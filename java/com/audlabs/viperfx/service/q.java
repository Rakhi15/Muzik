package com.audlabs.viperfx.service;

import android.content.SharedPreferences;
import android.media.audiofx.AudioEffect;
import android.media.audiofx.AudioEffect.OnEnableStatusChangeListener;
import android.util.Log;
import android.widget.Toast;

class q implements OnEnableStatusChangeListener {
    final /* synthetic */ ViPER4AndroidService a;
    final /* synthetic */ o b;

    q(o oVar, ViPER4AndroidService viPER4AndroidService) {
        this.b = oVar;
        this.a = viPER4AndroidService;
    }

    public void onEnableStatusChange(AudioEffect audioEffect, boolean z) {
        String a = ViPER4AndroidService.a(this.b.b.getSharedPreferences("com.audlabs.viperfx.settings", 0));
        SharedPreferences sharedPreferences = this.b.b.getSharedPreferences("com.audlabs.viperfx." + a, 0);
        String str = "viper4android.headphonefx.enable";
        if (a.equalsIgnoreCase("speaker")) {
            str = "viper4android.speakerfx.enable";
        }
        boolean z2 = sharedPreferences.getBoolean(str, false);
        if (z2 != z) {
            Log.i("ViPER4Android", "Engine status is " + z + ", but we expected " + z2);
            Log.i("ViPER4Android", "Im sure you are experiencing no effect,because the effect is controlled by the system now");
            Log.i("ViPER4Android", "I really have no idea how to solve this problem.Fucking android. I'm sorry, bro");
            Toast.makeText(this.b.b, this.b.b.getString(this.b.b.getResources().getIdentifier("text_token_lost", "string", this.b.b.getApplicationInfo().packageName)), 1).show();
            return;
        }
        Log.i("ViPER4Android", "Everything is under control for now");
    }
}
