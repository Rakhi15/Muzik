package com.audlabs.viperfx.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.audlabs.viperfx.base.V4AJniInterface;
import com.audlabs.viperfx.service.ViPER4AndroidService;

public class BootCompletedReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        Log.i("ViPER4Android", "System booted.");
        Log.i("ViPER4Android", "Jni library status = " + V4AJniInterface.a());
        if (context.getSharedPreferences("com.audlabs.viperfx.settings", 0).getBoolean("viper4android.settings.driverconfigured", false)) {
            Log.i("ViPER4Android", "Start viper4android audio service.");
            context.startService(new Intent(context, ViPER4AndroidService.class));
            return;
        }
        Log.i("ViPER4Android", "Driver not configured correctly.");
    }
}
