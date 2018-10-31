package me.imid.swipebacklayout.lib;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.cf;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.List;

public class SwipeBackLayout extends FrameLayout {
    private static final int[] a = new int[]{1, 2, 8, 11};
    private int b;
    private float c;
    private Activity d;
    private boolean e;
    private View f;
    private k g;
    private float h;
    private int i;
    private int j;
    private List k;
    private Drawable l;
    private Drawable m;
    private Drawable n;
    private float o;
    private int p;
    private boolean q;
    private Rect r;
    private int s;

    public SwipeBackLayout(Context context) {
        this(context, null);
    }

    public SwipeBackLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.SwipeBackLayoutStyle);
    }

    public SwipeBackLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.c = 0.3f;
        this.e = true;
        this.p = -1728053248;
        this.r = new Rect();
        this.g = k.a((ViewGroup) this, new i());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f.SwipeBackLayout, i, e.SwipeBackLayout);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(f.SwipeBackLayout_edge_size, -1);
        if (dimensionPixelSize > 0) {
            setEdgeSize(dimensionPixelSize);
        }
        setEdgeTrackingEnabled(a[obtainStyledAttributes.getInt(f.SwipeBackLayout_edge_flag, 0)]);
        dimensionPixelSize = obtainStyledAttributes.getResourceId(f.SwipeBackLayout_shadow_left, c.shadow_left);
        int resourceId = obtainStyledAttributes.getResourceId(f.SwipeBackLayout_shadow_right, c.shadow_right);
        int resourceId2 = obtainStyledAttributes.getResourceId(f.SwipeBackLayout_shadow_bottom, c.shadow_bottom);
        a(dimensionPixelSize, 1);
        a(resourceId, 2);
        a(resourceId2, 8);
        obtainStyledAttributes.recycle();
        float f = getResources().getDisplayMetrics().density * 400.0f;
        this.g.a(f);
        this.g.b(f * 2.0f);
    }

    private void a(Canvas canvas, View view) {
        int i = (((int) (((float) ((this.p & -16777216) >>> 24)) * this.o)) << 24) | (this.p & 16777215);
        if ((this.s & 1) != 0) {
            canvas.clipRect(0, 0, view.getLeft(), getHeight());
        } else if ((this.s & 2) != 0) {
            canvas.clipRect(view.getRight(), 0, getRight(), getHeight());
        } else if ((this.s & 8) != 0) {
            canvas.clipRect(view.getLeft(), view.getBottom(), getRight(), getHeight());
        }
        canvas.drawColor(i);
    }

    private void b(Canvas canvas, View view) {
        Rect rect = this.r;
        view.getHitRect(rect);
        if ((this.b & 1) != 0) {
            this.l.setBounds(rect.left - this.l.getIntrinsicWidth(), rect.top, rect.left, rect.bottom);
            this.l.setAlpha((int) (this.o * 255.0f));
            this.l.draw(canvas);
        }
        if ((this.b & 2) != 0) {
            this.m.setBounds(rect.right, rect.top, rect.right + this.m.getIntrinsicWidth(), rect.bottom);
            this.m.setAlpha((int) (this.o * 255.0f));
            this.m.draw(canvas);
        }
        if ((this.b & 8) != 0) {
            this.n.setBounds(rect.left, rect.bottom, rect.right, rect.bottom + this.n.getIntrinsicHeight());
            this.n.setAlpha((int) (this.o * 255.0f));
            this.n.draw(canvas);
        }
    }

    private void setContentView(View view) {
        this.f = view;
    }

    public void a(int i, int i2) {
        a(getResources().getDrawable(i), i2);
    }

    public void a(Activity activity) {
        this.d = activity;
        TypedArray obtainStyledAttributes = activity.getTheme().obtainStyledAttributes(new int[]{16842836});
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        ViewGroup viewGroup2 = (ViewGroup) viewGroup.getChildAt(0);
        viewGroup2.setBackgroundResource(resourceId);
        viewGroup.removeView(viewGroup2);
        addView(viewGroup2);
        setContentView(viewGroup2);
        viewGroup.addView(this);
    }

    public void a(Drawable drawable, int i) {
        if ((i & 1) != 0) {
            this.l = drawable;
        } else if ((i & 2) != 0) {
            this.m = drawable;
        } else if ((i & 8) != 0) {
            this.n = drawable;
        }
        invalidate();
    }

    public void a(h hVar) {
        if (this.k == null) {
            this.k = new ArrayList();
        }
        this.k.add(hVar);
    }

    public void computeScroll() {
        this.o = 1.0f - this.h;
        if (this.g.a(true)) {
            cf.d(this);
        }
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        Object obj = view == this.f ? 1 : null;
        boolean drawChild = super.drawChild(canvas, view, j);
        if (!(this.o <= 0.0f || obj == null || this.g.a() == 0)) {
            b(canvas, view);
            a(canvas, view);
        }
        return drawChild;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.e) {
            try {
                z = this.g.a(motionEvent);
            } catch (ArrayIndexOutOfBoundsException e) {
            }
        }
        return z;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.q = true;
        if (this.f != null) {
            this.f.layout(this.i, this.j, this.i + this.f.getMeasuredWidth(), this.j + this.f.getMeasuredHeight());
        }
        this.q = false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.e) {
            return false;
        }
        this.g.b(motionEvent);
        return true;
    }

    public void requestLayout() {
        if (!this.q) {
            super.requestLayout();
        }
    }

    public void setEdgeSize(int i) {
        this.g.b(i);
    }

    public void setEdgeTrackingEnabled(int i) {
        this.b = i;
        this.g.a(this.b);
    }

    public void setEnableGesture(boolean z) {
        this.e = z;
    }

    public void setScrimColor(int i) {
        this.p = i;
        invalidate();
    }

    public void setScrollThresHold(float f) {
        if (f >= 1.0f || f <= 0.0f) {
            throw new IllegalArgumentException("Threshold value should be between 0 and 1.0");
        }
        this.c = f;
    }

    @Deprecated
    public void setSwipeListener(h hVar) {
        a(hVar);
    }
}
