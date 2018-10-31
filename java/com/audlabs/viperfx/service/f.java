package com.audlabs.viperfx.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

class f extends BroadcastReceiver {
    final /* synthetic */ ViPER4AndroidService a;

    f(ViPER4AndroidService viPER4AndroidService) {
        this.a = viPER4AndroidService;
    }

    public void onReceive(Context context, Intent intent) {
        Log.i("ViPER4Android", "m3rdAPI_QUERY_EQUALIZER_Receiver::onReceive()");
        Intent intent2 = new Intent("com.audlabs.viperfx.viper4android_v2.QUERY_EQUALIZER_RESULT");
        intent2.putExtra("equalizer_enabled", this.a.getSharedPreferences("com.audlabs.viperfx." + ViPER4AndroidService.a(this.a.getSharedPreferences("com.audlabs.viperfx.settings", 0)), 0).getBoolean("viper4android.headphonefx.fireq.enable", false));
        intent2.putExtra("equalizer_bandcount", 10);
        intent2.putExtra("equalizer_bandfreq", new float[]{31.0f, 62.0f, 125.0f, 250.0f, 500.0f, 1000.0f, 2000.0f, 4000.0f, 8000.0f, 16000.0f});
        this.a.sendBroadcast(intent2);
    }
}
