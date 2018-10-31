package com.audlabs.viperfx.widget;

import android.view.View;
import android.view.View.OnClickListener;

class c implements OnClickListener {
    final /* synthetic */ short a;
    final /* synthetic */ VerticalSeekBar b;
    final /* synthetic */ EqualizerViewBar c;

    c(EqualizerViewBar equalizerViewBar, short s, VerticalSeekBar verticalSeekBar) {
        this.c = equalizerViewBar;
        this.a = s;
        this.b = verticalSeekBar;
    }

    public void onClick(View view) {
        if (this.c.d[this.a] > this.c.a) {
            this.b.setProgress((int) ((((float) (((double) this.c.d[this.a]) - 0.1d)) * 10.0f) + 120.0f));
            if (this.c.g != null) {
                this.c.g.a();
            }
        }
    }
}
