package com.audlabs.viperfx.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

class i extends BroadcastReceiver {
    final /* synthetic */ ViPER4AndroidService a;

    i(ViPER4AndroidService viPER4AndroidService) {
        this.a = viPER4AndroidService;
    }

    public void onReceive(Context context, Intent intent) {
        Log.i("ViPER4Android", "m3rdAPI_SET_ENABLED_Receiver::onReceive()");
        if (!this.a.q) {
            return;
        }
        if (intent.hasExtra("token")) {
            int intExtra = intent.getIntExtra("token", 0);
            if (intExtra == 0) {
                Log.i("ViPER4Android", "m3rdAPI_SET_ENABLED_Receiver, invalid token found");
                return;
            } else if (intent.hasExtra("enabled")) {
                this.a.n = intent.getBooleanExtra("enabled", false);
                Log.i("ViPER4Android", "m3rdAPI_SET_ENABLED_Receiver, token = " + intExtra + ", enabled = " + this.a.n);
                this.a.a(false);
                return;
            } else {
                return;
            }
        }
        Log.i("ViPER4Android", "m3rdAPI_SET_ENABLED_Receiver, no token found");
    }
}
