package com.audlabs.viperfx.widget;

import android.content.Context;
import android.support.v4.content.a;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class EqualizerViewBar extends HorizontalScrollView {
    private float a;
    private float b;
    private int c;
    private float[] d;
    private float[] e;
    private List f;
    private e g;

    public EqualizerViewBar(Context context) {
        super(context);
        this.a = -12.0f;
        this.b = 12.0f;
        this.c = 10;
        this.d = new float[this.c];
        this.e = new float[this.c];
        this.f = new ArrayList();
        a();
    }

    public EqualizerViewBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = -12.0f;
        this.b = 12.0f;
        this.c = 10;
        this.d = new float[this.c];
        this.e = new float[this.c];
        this.f = new ArrayList();
        a();
    }

    public EqualizerViewBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = -12.0f;
        this.b = 12.0f;
        this.c = 10;
        this.d = new float[this.c];
        this.e = new float[this.c];
        this.f = new ArrayList();
        a();
    }

    private int a(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    private void a() {
        this.e = new float[this.c];
        for (int i = 0; i < this.d.length; i++) {
            this.e[i] = (float) (15.625d * Math.pow(2.0d, (double) (i + 1)));
        }
        View linearLayout = new LinearLayout(getContext());
        linearLayout.setLayoutParams(new LayoutParams(-2, -1));
        linearLayout.setOrientation(0);
        linearLayout.setPadding(a(getContext(), 15.0f), 0, a(getContext(), 15.0f), a(getContext(), 15.0f));
        for (short s = (short) 0; s < this.c; s = (short) (s + 1)) {
            View linearLayout2 = new LinearLayout(getContext());
            linearLayout2.setLayoutParams(new LayoutParams(a(getContext(), 55.0f), -1, 1.0f));
            linearLayout2.setOrientation(1);
            linearLayout2.setGravity(17);
            View verticalSeekBarWrapper = new VerticalSeekBarWrapper(getContext());
            verticalSeekBarWrapper.setLayoutParams(new LayoutParams(-2, -1, 1.0f));
            View verticalSeekBar = new VerticalSeekBar(getContext());
            verticalSeekBar.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
            verticalSeekBar.setMax((int) ((this.b - this.a) * 10.0f));
            verticalSeekBar.setProgress((int) ((((double) this.d[s]) * 10.0d) + 120.0d));
            verticalSeekBar.setProgressDrawable(a.a(getContext(), 2130837586));
            verticalSeekBar.setThumb(a.a(getContext(), 2130837587));
            verticalSeekBar.setBackgroundColor(getResources().getColor(17170445));
            View textView = new TextView(getContext());
            textView.setLayoutParams(new LayoutParams(-2, -2));
            textView.setText(String.format(((double) this.d[s]) == 0.0d ? "%.0fdb" : "%+.1fdb", new Object[]{Float.valueOf(this.d[s])}));
            View textView2 = new TextView(getContext());
            textView2.setLayoutParams(new LayoutParams(-2, -2));
            float f = this.e[s];
            String str = f < 1000.0f ? "%.0f" : "%.0fk";
            Object[] objArr = new Object[1];
            if (f >= 1000.0f) {
                f /= 1000.0f;
            }
            objArr[0] = Float.valueOf(f);
            textView2.setText(String.format(str, objArr));
            verticalSeekBar.setOnSeekBarChangeListener(new a(this, textView, s));
            View button = new Button(getContext());
            button.setLayoutParams(new LayoutParams(a(getContext(), 28.0f), a(getContext(), 28.0f)));
            button.setBackgroundResource(2130837583);
            button.setOnClickListener(new b(this, s, verticalSeekBar));
            View button2 = new Button(getContext());
            button2.setLayoutParams(new LayoutParams(a(getContext(), 28.0f), a(getContext(), 28.0f)));
            button2.setBackgroundResource(2130837584);
            button2.setOnClickListener(new c(this, s, verticalSeekBar));
            this.f.add(verticalSeekBar);
            verticalSeekBarWrapper.addView(verticalSeekBar);
            linearLayout2.addView(button);
            linearLayout2.addView(textView);
            linearLayout2.addView(verticalSeekBarWrapper);
            linearLayout2.addView(textView2);
            linearLayout2.addView(button2);
            linearLayout.addView(linearLayout2);
        }
        addView(linearLayout);
    }

    public void setBandUpdatedListener(e eVar) {
        this.g = eVar;
    }

    public void setBands(float[] fArr) {
        this.d = fArr;
        new Thread(new d(this)).start();
    }
}
