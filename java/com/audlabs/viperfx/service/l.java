package com.audlabs.viperfx.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

class l extends BroadcastReceiver {
    final /* synthetic */ ViPER4AndroidService a;

    l(ViPER4AndroidService viPER4AndroidService) {
        this.a = viPER4AndroidService;
    }

    public void onReceive(Context context, Intent intent) {
        Log.i("ViPER4Android", "mPreferenceUpdateReceiver::onReceive()");
        this.a.a(false);
    }
}
