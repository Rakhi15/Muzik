package com.audlabs.viperfx.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

class b extends BroadcastReceiver {
    final /* synthetic */ ViPER4AndroidService a;

    b(ViPER4AndroidService viPER4AndroidService) {
        this.a = viPER4AndroidService;
    }

    public void onReceive(Context context, Intent intent) {
        Log.i("ViPER4Android", "mShowNotifyReceiver::onReceive()");
        String a = ViPER4AndroidService.a(this.a.getSharedPreferences("com.audlabs.viperfx.settings", 0));
        if (a.equalsIgnoreCase("headset")) {
            this.a.a(this.a.getString(this.a.getResources().getIdentifier("text_headset", "string", this.a.getApplicationInfo().packageName)));
        } else if (a.equalsIgnoreCase("bluetooth")) {
            this.a.a(this.a.getString(this.a.getResources().getIdentifier("text_bluetooth", "string", this.a.getApplicationInfo().packageName)));
        } else if (a.equalsIgnoreCase("usb")) {
            this.a.a(this.a.getString(this.a.getResources().getIdentifier("text_usb", "string", this.a.getApplicationInfo().packageName)));
        } else {
            this.a.a(this.a.getString(this.a.getResources().getIdentifier("text_speaker", "string", this.a.getApplicationInfo().packageName)));
        }
    }
}
