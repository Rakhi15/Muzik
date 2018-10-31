package com.audlabs.viperfx.main;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class r extends BroadcastReceiver {
    final /* synthetic */ MainFragment a;

    r(MainFragment mainFragment) {
        this.a = mainFragment;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null && "com.audlabs.viperfx.updatemainui".equals(intent.getAction())) {
            this.a.c.e();
        }
    }
}
