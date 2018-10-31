package com.audlabs.viperfx.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

class c extends BroadcastReceiver {
    final /* synthetic */ ViPER4AndroidService a;

    c(ViPER4AndroidService viPER4AndroidService) {
        this.a = viPER4AndroidService;
    }

    public void onReceive(Context context, Intent intent) {
        Log.i("ViPER4Android", "mCancelNotifyReceiver::onReceive()");
        this.a.m();
    }
}
