package com.audlabs.viperfx.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

class e extends BroadcastReceiver {
    final /* synthetic */ ViPER4AndroidService a;

    e(ViPER4AndroidService viPER4AndroidService) {
        this.a = viPER4AndroidService;
    }

    public void onReceive(Context context, Intent intent) {
        Log.i("ViPER4Android", "m3rdAPI_QUERY_DRIVERSTATUS_Receiver::onReceive()");
        Intent intent2 = new Intent("com.audlabs.viperfx.viper4android_v2.QUERY_DRIVERSTATUS_RESULT");
        intent2.putExtra("driver_ready", this.a.i);
        intent2.putExtra("enabled", this.a.e());
        this.a.sendBroadcast(intent2);
    }
}
