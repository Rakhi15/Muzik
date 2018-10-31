package com.audlabs.viperfx.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.util.Log;

class d extends BroadcastReceiver {
    final /* synthetic */ ViPER4AndroidService a;

    d(ViPER4AndroidService viPER4AndroidService) {
        this.a = viPER4AndroidService;
    }

    public void onReceive(Context context, Intent intent) {
        boolean z = false;
        Log.i("ViPER4Android", "mRoutingReceiver::onReceive()");
        String action = intent.getAction();
        boolean j = ViPER4AndroidService.d;
        boolean k = ViPER4AndroidService.e;
        boolean l = ViPER4AndroidService.f;
        if (action.equals("android.intent.action.HEADSET_PLUG")) {
            if (intent.getIntExtra("state", 0) == 1) {
                z = true;
            }
            ViPER4AndroidService.d = z;
        } else if (action.equals("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED")) {
            if (intent.getIntExtra("android.bluetooth.profile.extra.STATE", 0) == 2) {
                z = true;
            }
            ViPER4AndroidService.e = z;
        } else if (VERSION.SDK_INT >= 16 && action.equals("android.intent.action.ANALOG_AUDIO_DOCK_PLUG")) {
            if (intent.getIntExtra("state", 0) == 1) {
                z = true;
            }
            ViPER4AndroidService.f = z;
        }
        Log.i("ViPER4Android", "Headset=" + ViPER4AndroidService.d + ", Bluetooth=" + ViPER4AndroidService.e + ", USB=" + ViPER4AndroidService.f);
        if (j != ViPER4AndroidService.d || k != ViPER4AndroidService.e || l != ViPER4AndroidService.f) {
            this.a.a(true);
        }
    }
}
