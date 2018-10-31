package com.audlabs.viperfx.widget;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

class a implements OnSeekBarChangeListener {
    final /* synthetic */ TextView a;
    final /* synthetic */ short b;
    final /* synthetic */ EqualizerViewBar c;

    a(EqualizerViewBar equalizerViewBar, TextView textView, short s) {
        this.c = equalizerViewBar;
        this.a = textView;
        this.b = s;
    }

    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        float f = (float) (((double) (i - 120)) / 10.0d);
        this.a.setText(String.format(((double) f) == 0.0d ? "%.0fdb" : "%+.1fdb", new Object[]{Float.valueOf(f)}));
        ((VerticalSeekBar) this.c.f.get(this.b)).setProgress((int) ((10.0f * f) + 120.0f));
        this.c.d[this.b] = f;
        if (this.c.g != null) {
            this.c.g.a(this.c.d);
        }
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
        if (this.c.g != null) {
            this.c.g.a();
        }
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
    }
}
