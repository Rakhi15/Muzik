package com.audlabs.viperfx.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

class k extends BroadcastReceiver {
    final /* synthetic */ ViPER4AndroidService a;

    k(ViPER4AndroidService viPER4AndroidService) {
        this.a = viPER4AndroidService;
    }

    public void onReceive(Context context, Intent intent) {
        Log.i("ViPER4Android", "mAudioSessionReceiver::onReceive()");
        if (this.a.getSharedPreferences("com.audlabs.viperfx.settings", 0).getString("viper4android.settings.compatiblemode", "global").equals("global")) {
            boolean z = false;
        } else {
            int i = 1;
        }
        String action = intent.getAction();
        int intExtra = intent.getIntExtra("android.media.extra.AUDIO_SESSION", 0);
        if (intExtra == 0) {
            Log.i("ViPER4Android", "Global output mixer session control received! ");
            return;
        }
        o oVar;
        if (action.equals("android.media.action.OPEN_AUDIO_EFFECT_CONTROL_SESSION")) {
            Log.i("ViPER4Android", String.format("New audio session: %d", new Object[]{Integer.valueOf(intExtra)}));
            if (i == 0) {
                Log.i("ViPER4Android", "Only global effect allowed.");
                return;
            } else if (!this.a.l.a()) {
                Log.i("ViPER4Android", "Semaphore acquire failed.");
            } else if (this.a.k.indexOfKey(intExtra) < 0) {
                Log.i("ViPER4Android", "Creating local V4ADSPModule ...");
                oVar = new o(this.a, intExtra);
                if (oVar.a == null) {
                    Log.e("ViPER4Android", "Failed to load v4a driver.");
                    oVar.a();
                } else {
                    this.a.k.put(intExtra, oVar);
                }
                this.a.l.b();
            } else {
                Log.i("ViPER4Android", "Effect module already exist [session = " + intExtra + "]");
                this.a.l.b();
                return;
            }
        }
        if (action.equals("android.media.action.CLOSE_AUDIO_EFFECT_CONTROL_SESSION")) {
            Log.i("ViPER4Android", String.format("Audio session removed: %d", new Object[]{Integer.valueOf(intExtra)}));
            if (this.a.l.a()) {
                if (this.a.k.indexOfKey(intExtra) >= 0) {
                    oVar = (o) this.a.k.get(intExtra);
                    this.a.k.remove(intExtra);
                    if (oVar != null) {
                        oVar.a();
                    }
                }
                this.a.l.b();
            } else {
                Log.i("ViPER4Android", "Semaphore accquire failed.");
            }
        }
        this.a.a(false);
    }
}
