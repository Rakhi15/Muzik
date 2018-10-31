package com.audlabs.viperfx.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class Gallery extends android.widget.Gallery {
    private boolean a;
    private int b;
    private int c;
    private int d;
    private TextView e;
    private g f;

    public Gallery(Context context) {
        this(context, null);
    }

    public Gallery(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public Gallery(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = false;
        this.e = null;
        this.f = null;
        Resources resources = getResources();
        this.b = resources.getColor(17170443);
        this.c = resources.getColor(2131492906);
        this.d = resources.getColor(2131492903);
        setOnItemSelectedListener(new f(this));
    }

    public boolean onDown(MotionEvent motionEvent) {
        return this.a ? super.onDown(motionEvent) : false;
    }

    public void setEnabled(boolean z) {
        this.a = z;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof TextView) {
                ((TextView) childAt).setTextColor(z ? this.c : this.d);
            }
        }
        if (z) {
            TextView textView = (TextView) getSelectedView();
            if (textView != null) {
                textView.setTextColor(this.b);
            }
        }
    }

    public void setOnItemSelectedListener(g gVar) {
        this.f = gVar;
    }
}
