package com.audlabs.viperfx.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.cf;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.SeekBar;
import com.audlabs.viperfx.b;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import me.imid.swipebacklayout.lib.f;

public class VerticalSeekBar extends SeekBar {
    private boolean a;
    private Drawable b;
    private Method c;
    private int d = 270;

    public VerticalSeekBar(Context context) {
        super(context);
        a(context, null, 0, 0);
    }

    public VerticalSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet, 0, 0);
    }

    public VerticalSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet, i, 0);
    }

    private synchronized void a(int i, boolean z) {
        if (this.c == null) {
            try {
                Method method = getClass().getMethod("setProgress", new Class[]{Integer.TYPE, Boolean.TYPE});
                method.setAccessible(true);
                this.c = method;
            } catch (NoSuchMethodException e) {
            }
        }
        if (this.c != null) {
            try {
                this.c.invoke(this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)});
            } catch (IllegalArgumentException e2) {
            } catch (IllegalAccessException e3) {
            } catch (InvocationTargetException e4) {
            }
        } else {
            super.setProgress(i);
        }
        d();
    }

    private void a(Context context, AttributeSet attributeSet, int i, int i2) {
        cf.d(this, 0);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.VerticalSeekBar, i, i2);
            int integer = obtainStyledAttributes.getInteger(0, 0);
            if (a(integer)) {
                this.d = integer;
            }
            obtainStyledAttributes.recycle();
        }
    }

    private void a(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    private static boolean a(int i) {
        return i == 90 || i == 270;
    }

    private boolean a(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        Drawable thumbCompat = getThumbCompat();
        switch (motionEvent.getAction()) {
            case f.View_android_theme /*0*/:
                setPressed(true);
                if (thumbCompat != null) {
                    invalidate(thumbCompat.getBounds());
                }
                b();
                c(motionEvent);
                a(true);
                break;
            case f.View_android_focusable /*1*/:
                if (this.a) {
                    c(motionEvent);
                    c();
                    setPressed(false);
                } else {
                    b();
                    c(motionEvent);
                    c();
                    a(false);
                }
                invalidate();
                break;
            case f.View_paddingStart /*2*/:
                if (this.a) {
                    c(motionEvent);
                    break;
                }
                break;
            case f.View_paddingEnd /*3*/:
                if (this.a) {
                    c();
                    setPressed(false);
                }
                invalidate();
                break;
        }
        return true;
    }

    private void b() {
        this.a = true;
    }

    private boolean b(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case f.View_android_theme /*0*/:
                a(true);
                break;
            case f.View_android_focusable /*1*/:
                a(false);
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void c() {
        this.a = false;
    }

    private void c(MotionEvent motionEvent) {
        float f;
        float f2 = 0.0f;
        int paddingTop = super.getPaddingTop();
        int paddingBottom = super.getPaddingBottom();
        int height = getHeight();
        paddingBottom = (height - paddingTop) - paddingBottom;
        int y = (int) motionEvent.getY();
        switch (this.d) {
            case f.AppCompatTheme_controlBackground /*90*/:
                f = (float) (y - paddingTop);
                break;
            case 270:
                f = (float) ((height - paddingTop) - y);
                break;
            default:
                f = 0.0f;
                break;
        }
        if (f >= 0.0f && paddingBottom != 0) {
            f2 = f > ((float) paddingBottom) ? 1.0f : f / ((float) paddingBottom);
        }
        a((int) (f2 * ((float) getMax())), true);
    }

    private void d() {
        onSizeChanged(super.getWidth(), super.getHeight(), 0, 0);
    }

    private Drawable getThumbCompat() {
        return this.b;
    }

    private VerticalSeekBarWrapper getWrapper() {
        ViewParent parent = getParent();
        return parent instanceof VerticalSeekBarWrapper ? (VerticalSeekBarWrapper) parent : null;
    }

    boolean a() {
        return (VERSION.SDK_INT >= 11) && !isInEditMode();
    }

    public int getRotationAngle() {
        return this.d;
    }

    protected synchronized void onDraw(Canvas canvas) {
        if (!a()) {
            switch (this.d) {
                case f.AppCompatTheme_controlBackground /*90*/:
                    canvas.rotate(90.0f);
                    canvas.translate(0.0f, (float) (-super.getWidth()));
                    break;
                case 270:
                    canvas.rotate(-90.0f);
                    canvas.translate((float) (-super.getHeight()), 0.0f);
                    break;
            }
        }
        super.onDraw(canvas);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean z = false;
        int i2 = -1;
        if (isEnabled()) {
            switch (i) {
                case f.Toolbar_collapseContentDescription /*19*/:
                    if (this.d == 270) {
                        i2 = 1;
                    }
                    z = true;
                    break;
                case f.Toolbar_navigationIcon /*20*/:
                    if (this.d == 90) {
                        i2 = 1;
                    }
                    z = true;
                    break;
                case f.Toolbar_navigationContentDescription /*21*/:
                case f.Toolbar_logoDescription /*22*/:
                    i2 = 0;
                    z = true;
                    break;
                default:
                    i2 = 0;
                    break;
            }
            if (z) {
                int keyProgressIncrement = getKeyProgressIncrement();
                i2 = (i2 * keyProgressIncrement) + getProgress();
                if (i2 < 0 || i2 > getMax()) {
                    return true;
                }
                a(i2 - keyProgressIncrement, true);
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    protected synchronized void onMeasure(int i, int i2) {
        if (a()) {
            super.onMeasure(i, i2);
        } else {
            super.onMeasure(i2, i);
            LayoutParams layoutParams = getLayoutParams();
            if (!isInEditMode() || layoutParams == null || layoutParams.height < 0) {
                setMeasuredDimension(super.getMeasuredHeight(), super.getMeasuredWidth());
            } else {
                setMeasuredDimension(super.getMeasuredHeight(), getLayoutParams().height);
            }
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if (a()) {
            super.onSizeChanged(i, i2, i3, i4);
        } else {
            super.onSizeChanged(i2, i, i4, i3);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return a() ? b(motionEvent) : a(motionEvent);
    }

    public synchronized void setProgress(int i) {
        super.setProgress(i);
        if (!a()) {
            d();
        }
    }

    public void setRotationAngle(int i) {
        if (!a(i)) {
            throw new IllegalArgumentException("Invalid angle specified :" + i);
        } else if (this.d != i) {
            this.d = i;
            if (a()) {
                VerticalSeekBarWrapper wrapper = getWrapper();
                if (wrapper != null) {
                    wrapper.a();
                    return;
                }
                return;
            }
            requestLayout();
        }
    }

    public void setThumb(Drawable drawable) {
        this.b = drawable;
        super.setThumb(drawable);
    }
}
