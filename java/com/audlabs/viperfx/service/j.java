package com.audlabs.viperfx.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

class j extends BroadcastReceiver {
    final /* synthetic */ ViPER4AndroidService a;

    j(ViPER4AndroidService viPER4AndroidService) {
        this.a = viPER4AndroidService;
    }

    public void onReceive(Context context, Intent intent) {
        Log.i("ViPER4Android", "m3rdAPI_SET_EQUALIZER_Receiver::onReceive()");
        if (!this.a.q) {
            return;
        }
        if (intent.hasExtra("token")) {
            int intExtra = intent.getIntExtra("token", 0);
            if (intExtra == 0) {
                Log.i("ViPER4Android", "m3rdAPI_SET_EQUALIZER_Receiver, invalid token found");
                return;
            }
            Log.i("ViPER4Android", "m3rdAPI_SET_EQUALIZER_Receiver, token = " + intExtra);
            if (intent.hasExtra("enabled")) {
                this.a.o = intent.getBooleanExtra("enabled", this.a.o);
                Log.i("ViPER4Android", "m3rdAPI_SET_EQUALIZER_Receiver, enable equalizer = " + this.a.o);
            }
            if (intent.hasExtra("bandcount") && intent.hasExtra("bandvalues")) {
                intExtra = intent.getIntExtra("bandcount", 0);
                Object floatArrayExtra = intent.getFloatArrayExtra("bandvalues");
                if (intExtra != 10 || floatArrayExtra == null) {
                    Log.i("ViPER4Android", "m3rdAPI_SET_EQUALIZER_Receiver,invalid band parameters");
                    return;
                }
                Log.i("ViPER4Android", "m3rdAPI_SET_EQUALIZER_Receiver, got new eq band values");
                if (this.a.p == null) {
                    this.a.p = new float[10];
                }
                System.arraycopy(floatArrayExtra, 0, this.a.p, 0, intExtra);
            }
            this.a.a(false);
            return;
        }
        Log.i("ViPER4Android", "m3rdAPI_SET_EQUALIZER_Receiver, no token found");
    }
}
