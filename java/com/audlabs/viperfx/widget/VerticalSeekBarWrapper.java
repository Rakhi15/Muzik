package com.audlabs.viperfx.widget;

import android.content.Context;
import android.support.v4.view.cf;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;

public class VerticalSeekBarWrapper extends FrameLayout {
    public VerticalSeekBarWrapper(Context context) {
        this(context, null, 0);
    }

    public VerticalSeekBarWrapper(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VerticalSeekBarWrapper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private void a(int i, int i2) {
        View childSeekBar = getChildSeekBar();
        if (childSeekBar != null) {
            int rotationAngle = childSeekBar.getRotationAngle();
            LayoutParams layoutParams = childSeekBar.getLayoutParams();
            layoutParams.width = i2;
            layoutParams.height = -2;
            childSeekBar.setLayoutParams(layoutParams);
            if (rotationAngle == 90) {
                rotationAngle = cf.n(childSeekBar);
                cf.d(childSeekBar, 90.0f);
                cf.a(childSeekBar, (float) ((-(i2 - i)) / 2));
                cf.b(childSeekBar, (float) ((i2 / 2) - rotationAngle));
            } else if (rotationAngle == 270) {
                rotationAngle = cf.m(childSeekBar);
                cf.d(childSeekBar, -90.0f);
                cf.a(childSeekBar, (float) ((-(i2 - i)) / 2));
                cf.b(childSeekBar, (float) ((i2 / 2) - rotationAngle));
            }
        }
    }

    private void a(int i, int i2, int i3, int i4) {
        VerticalSeekBar childSeekBar = getChildSeekBar();
        if (childSeekBar != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childSeekBar.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.height = i2;
            childSeekBar.setLayoutParams(layoutParams);
            childSeekBar.measure(0, 0);
            int measuredWidth = childSeekBar.getMeasuredWidth();
            childSeekBar.measure(MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), MeasureSpec.makeMeasureSpec(i2, 1073741824));
            layoutParams.gravity = 51;
            layoutParams.leftMargin = (i - measuredWidth) / 2;
            childSeekBar.setLayoutParams(layoutParams);
        }
        super.onSizeChanged(i, i2, i3, i4);
    }

    private void b(int i, int i2, int i3, int i4) {
        VerticalSeekBar childSeekBar = getChildSeekBar();
        if (childSeekBar != null) {
            childSeekBar.measure(MeasureSpec.makeMeasureSpec(i2, 1073741824), MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE));
        }
        a(i, i2);
        super.onSizeChanged(i, i2, i3, i4);
    }

    private boolean b() {
        VerticalSeekBar childSeekBar = getChildSeekBar();
        return childSeekBar != null ? childSeekBar.a() : false;
    }

    private VerticalSeekBar getChildSeekBar() {
        View childAt = getChildCount() > 0 ? getChildAt(0) : null;
        return childAt instanceof VerticalSeekBar ? (VerticalSeekBar) childAt : null;
    }

    void a() {
        a(getWidth(), getHeight());
    }

    protected void onMeasure(int i, int i2) {
        VerticalSeekBar childSeekBar = getChildSeekBar();
        int mode = MeasureSpec.getMode(i);
        if (childSeekBar == null || mode == 1073741824) {
            super.onMeasure(i, i2);
            return;
        }
        int measuredWidth;
        if (b()) {
            childSeekBar.measure(i2, i);
            mode = childSeekBar.getMeasuredHeight();
            measuredWidth = childSeekBar.getMeasuredWidth();
        } else {
            childSeekBar.measure(i, i2);
            mode = childSeekBar.getMeasuredWidth();
            measuredWidth = childSeekBar.getMeasuredHeight();
        }
        setMeasuredDimension(cf.a(mode, i, 0), cf.a(measuredWidth, i2, 0));
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if (b()) {
            b(i, i2, i3, i4);
        } else {
            a(i, i2, i3, i4);
        }
    }
}
