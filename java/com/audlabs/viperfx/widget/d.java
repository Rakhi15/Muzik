package com.audlabs.viperfx.widget;

class d implements Runnable {
    final /* synthetic */ EqualizerViewBar a;

    d(EqualizerViewBar equalizerViewBar) {
        this.a = equalizerViewBar;
    }

    public void run() {
        for (int i = 0; i < this.a.c; short s = (short) (i + 1)) {
            ((VerticalSeekBar) this.a.f.get(i)).setProgress((int) ((((double) this.a.d[i]) * 10.0d) + 120.0d));
        }
    }
}
