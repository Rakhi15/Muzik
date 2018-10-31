package com.audlabs.viperfx.service;

import android.media.audiofx.AudioEffect;
import android.media.audiofx.AudioEffect.OnControlStatusChangeListener;
import android.util.Log;
import android.widget.Toast;

class p implements OnControlStatusChangeListener {
    final /* synthetic */ ViPER4AndroidService a;
    final /* synthetic */ o b;

    p(o oVar, ViPER4AndroidService viPER4AndroidService) {
        this.b = oVar;
        this.a = viPER4AndroidService;
    }

    public void onControlStatusChange(AudioEffect audioEffect, boolean z) {
        if (z) {
            Log.i("ViPER4Android", "We got effect control token");
            this.b.b.a(true);
            return;
        }
        Log.i("ViPER4Android", "We lost effect control token");
        Toast.makeText(this.b.b, this.b.b.getString(this.b.b.getResources().getIdentifier("text_token_lost", "string", this.b.b.getApplicationInfo().packageName)), 1).show();
    }
}
