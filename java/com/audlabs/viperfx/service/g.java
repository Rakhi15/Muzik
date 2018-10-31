package com.audlabs.viperfx.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

class g extends BroadcastReceiver {
    final /* synthetic */ ViPER4AndroidService a;

    g(ViPER4AndroidService viPER4AndroidService) {
        this.a = viPER4AndroidService;
    }

    public void onReceive(Context context, Intent intent) {
        Log.i("ViPER4Android", "m3rdAPI_TAKEOVER_EFFECT_Receiver::onReceive()");
        Intent intent2 = new Intent("com.audlabs.viperfx.viper4android_v2.TAKEOVER_EFFECT_RESULT");
        if (intent.hasExtra("token")) {
            int intExtra = intent.getIntExtra("token", 0);
            if (intExtra == 0) {
                Log.i("ViPER4Android", "m3rdAPI_TAKEOVER_EFFECT_Receiver, invalid token found");
                intent2.putExtra("granted", false);
                this.a.sendBroadcast(intent2);
                return;
            }
            this.a.q = true;
            Log.i("ViPER4Android", "m3rdAPI_TAKEOVER_EFFECT_Receiver, token = " + intExtra);
            intent2.putExtra("granted", true);
            this.a.sendBroadcast(intent2);
            return;
        }
        Log.i("ViPER4Android", "m3rdAPI_TAKEOVER_EFFECT_Receiver, no token found");
        intent2.putExtra("granted", false);
        this.a.sendBroadcast(intent2);
    }
}
