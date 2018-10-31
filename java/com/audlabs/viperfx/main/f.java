package com.audlabs.viperfx.main;

import android.util.Log;
import com.audlabs.viperfx.b.d;
import com.audlabs.viperfx.base.e;

class f implements Runnable {
    final /* synthetic */ MainActivity a;

    f(MainActivity mainActivity) {
        this.a = mainActivity;
    }

    public void run() {
        Log.i("ViPER4Android", "Init environment");
        d.b(this.a);
        Log.i("ViPER4Android", "Check driver");
        e.a(this.a, MainActivity.s);
    }
}
