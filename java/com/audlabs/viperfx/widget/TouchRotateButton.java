package com.audlabs.viperfx.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import me.imid.swipebacklayout.lib.f;

public class TouchRotateButton extends ImageView {
    private boolean a = false;
    private h b;
    private i c;
    private float d = 30.0f;
    private float e = 330.0f;
    private Matrix f;
    private float g;
    private float h;
    private float i;
    private float j;
    private float k;
    private float l;
    private float m;
    private float n;
    private int o;
    private int p;

    public TouchRotateButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setScaleType(ScaleType.MATRIX);
        this.f = new Matrix();
    }

    private double a(float f, float f2, float f3, float f4, float f5, float f6) {
        double sqrt = Math.sqrt((double) (((f3 - f5) * (f3 - f5)) + ((f4 - f6) * (f4 - f6))));
        double sqrt2 = Math.sqrt((double) (((f - f5) * (f - f5)) + ((f2 - f6) * (f2 - f6))));
        double sqrt3 = Math.sqrt((double) (((f3 - f) * (f3 - f)) + ((f4 - f2) * (f4 - f2))));
        sqrt = (Math.acos((((sqrt2 * sqrt2) + (sqrt3 * sqrt3)) - (sqrt * sqrt)) / ((sqrt2 * 2.0d) * sqrt3)) * 180.0d) / 3.141592653589793d;
        if (f4 < f2 && f6 < f2) {
            if (f3 < f && f5 > f) {
                return sqrt;
            }
            if (f3 >= f && f5 <= f) {
                return -sqrt;
            }
        }
        if (f4 > f2 && f6 > f2) {
            if (f3 < f && f5 > f) {
                return -sqrt;
            }
            if (f3 > f && f5 < f) {
                return sqrt;
            }
        }
        if (f3 < f && f5 < f) {
            if (f4 < f2 && f6 > f2) {
                return -sqrt;
            }
            if (f4 > f2 && f6 < f2) {
                return sqrt;
            }
        }
        if (f3 > f && f5 > f) {
            if (f4 > f2 && f6 < f2) {
                return -sqrt;
            }
            if (f4 < f2 && f6 > f2) {
                return sqrt;
            }
        }
        float f7 = (f4 - f2) / (f3 - f);
        float f8 = (f6 - f2) / (f5 - f);
        return ((f3 <= f || f4 <= f2 || f5 <= f || f6 <= f2 || f7 <= f8) && ((f3 <= f || f4 >= f2 || f5 <= f || f6 >= f2 || f7 <= f8) && ((f3 >= f || f4 >= f2 || f5 >= f || f6 >= f2 || f7 <= f8) && (f3 >= f || f4 <= f2 || f5 >= f || f6 <= f2 || f7 <= f8)))) ? sqrt : -sqrt;
    }

    private void a() {
        this.n = (float) a(this.k, this.l, this.g, this.h, this.i, this.j);
        float f = this.m + this.n;
        if (f >= this.d && f <= this.e) {
            a(f);
            this.f.setRotate(this.m, this.k, this.l);
            setImageMatrix(this.f);
        }
        b();
        if (this.b != null) {
            this.b.a(this.m);
        }
    }

    private void a(float f) {
        if (f > this.e - 1.0f) {
            this.m = this.e;
        } else if (f < this.d + 1.0f) {
            this.m = this.d;
        } else {
            this.m = f;
        }
    }

    private void a(MotionEvent motionEvent) {
        this.i = motionEvent.getX();
        this.j = motionEvent.getY();
        switch (motionEvent.getAction()) {
            case f.View_android_theme /*0*/:
                setImageResource(this.p);
                b();
                if (this.c != null) {
                    this.c.a();
                    return;
                }
                return;
            case f.View_android_focusable /*1*/:
                setImageResource(this.o);
                if (this.c != null) {
                    this.c.b();
                    return;
                }
                return;
            case f.View_paddingStart /*2*/:
                a();
                return;
            default:
                return;
        }
    }

    private void b() {
        this.g = this.i;
        this.h = this.j;
    }

    public float getCurDegree() {
        return this.m;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        if (this.a) {
            return false;
        }
        a(motionEvent);
        return true;
    }

    public void setBgImageInt(int i) {
        this.o = i;
        Bitmap bitmap = ((BitmapDrawable) getContext().getResources().getDrawable(i)).getBitmap();
        this.k = (float) (bitmap.getWidth() / 2);
        this.l = (float) (bitmap.getHeight() / 2);
        setImageBitmap(bitmap);
    }

    public void setBgPressImageInt(int i) {
        this.p = i;
    }

    public void setCurDegree(float f) {
        if (f >= this.d && f <= this.e) {
            this.m = f;
            this.f.setRotate(f, this.k, this.l);
            setImageMatrix(this.f);
        }
    }

    public void setDisable(boolean z) {
        this.a = z;
    }

    public void setMAX_DEGREE(float f) {
        this.e = f;
    }

    public void setMIN_DEGREE(float f) {
        this.d = f;
    }

    public void setOnChangeDegreeListening(h hVar) {
        this.b = hVar;
    }

    public void setOnDownUpListening(i iVar) {
        this.c = iVar;
    }
}
