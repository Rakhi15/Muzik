package com.audlabs.viperfx.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class ProgressBarView extends View {
    private int a;
    private int b;
    private int c;
    private float d;
    private float e;
    private boolean f = false;
    private RectF g;
    private Paint h;
    private Paint i;
    private int j;
    private int k;
    private int l;
    private int m;

    public ProgressBarView(Context context) {
        super(context);
        a();
    }

    public ProgressBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public ProgressBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private float a(float f) {
        return f < 0.0f ? 0.0f : f > this.d ? this.d : f;
    }

    private void a() {
        this.h = new Paint();
        this.h.setAntiAlias(true);
        this.i = new Paint();
        this.i.setAntiAlias(true);
        this.m = getResources().getColor(2131492877);
    }

    protected void onDraw(Canvas canvas) {
        float f = 300.0f * (this.e / this.d);
        float f2 = 300.0f - f;
        if (f <= 0.0f) {
            f = 1.0f;
            this.h.setColor(getResources().getColor(2131492874));
        } else {
            this.h.setColor(this.m);
        }
        this.h.setStrokeWidth(0.0f);
        this.h.setStyle(Style.FILL);
        canvas.drawCircle(((float) this.k) - (((float) this.j) * ((float) Math.sin((double) 1057360530))), ((float) this.l) + (((float) this.j) * ((float) Math.cos((double) 1057360530))), (float) (this.a / 2), this.h);
        this.h.setStrokeWidth((float) this.a);
        this.h.setStyle(Style.STROKE);
        canvas.drawArc(this.g, 120.0f, f, false, this.h);
        this.h.setColor(getResources().getColor(2131492874));
        canvas.drawArc(this.g, 120.0f + f, f2, false, this.h);
        if (f2 > 0.0f) {
            this.h.setColor(getResources().getColor(2131492874));
        } else {
            this.h.setColor(this.m);
        }
        this.h.setStrokeWidth(0.0f);
        this.h.setStyle(Style.FILL);
        canvas.drawCircle(((float) this.k) + (((float) this.j) * ((float) Math.sin((double) 1057360530))), ((float) this.l) + (((float) this.j) * ((float) Math.cos((double) 1057360530))), (float) (this.a / 2), this.h);
        float f3 = (float) (((double) ((30.0f + f) / 180.0f)) * 3.141592653589793d);
        float sin = ((float) this.k) - (((float) this.j) * ((float) Math.sin((double) f3)));
        f3 = (((float) Math.cos((double) f3)) * ((float) this.j)) + ((float) this.l);
        if (f <= 0.0f) {
            this.i.setColor(getResources().getColor(2131492874));
        } else {
            this.i.setColor(this.m);
        }
        canvas.drawCircle(sin, f3, (float) (this.a / 2), this.i);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.b == 0 || this.c == 0) {
            this.b = getWidth();
            this.c = getHeight();
            this.j = Math.min(this.b, this.c) / 2;
            this.a = this.j / 12;
            this.j -= this.a;
            this.k = this.b / 2;
            this.l = this.c / 2;
            this.g = new RectF();
            this.g.left = (float) (this.k - this.j);
            this.g.top = (float) (this.l - this.j);
            this.g.right = (float) (this.k + this.j);
            this.g.bottom = (float) (this.l + this.j);
        }
    }

    public void setColorId(int i) {
        this.m = i;
        invalidate();
    }

    public void setMax(int i) {
        this.d = (float) i;
        invalidate();
    }

    public void setProgressSync(float f) {
        this.e = a(f);
        invalidate();
    }
}
