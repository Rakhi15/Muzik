package com.audlabs.viperfx.service;

import android.os.Environment;
import android.util.Log;
import java.util.TimerTask;

class a extends TimerTask {
    final /* synthetic */ ViPER4AndroidService a;

    a(ViPER4AndroidService viPER4AndroidService) {
        this.a = viPER4AndroidService;
    }

    public void run() {
        if (!Environment.getExternalStorageState().equals("mounted")) {
            this.a.r = false;
        } else if (!this.a.r) {
            Log.i("ViPER4Android", "Media mounted, now updating parameters");
            this.a.r = true;
            this.a.a(false);
        }
    }
}
