package com.audlabs.viperfx.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

class h extends BroadcastReceiver {
    final /* synthetic */ ViPER4AndroidService a;

    h(ViPER4AndroidService viPER4AndroidService) {
        this.a = viPER4AndroidService;
    }

    public void onReceive(Context context, Intent intent) {
        Log.i("ViPER4Android", "m3rdAPI_RELEASE_EFFECT_Receiver::onReceive()");
        this.a.q = false;
        if (intent.hasExtra("token")) {
            Log.i("ViPER4Android", "m3rdAPI_RELEASE_EFFECT_Receiver, token = " + intent.getIntExtra("token", 0));
            this.a.a(false);
            return;
        }
        this.a.a(false);
    }
}
