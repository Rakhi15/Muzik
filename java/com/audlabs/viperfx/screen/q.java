package com.audlabs.viperfx.screen;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.view.View.OnClickListener;

class q implements OnClickListener {
    final /* synthetic */ SharedPreferences a;
    final /* synthetic */ String b;
    final /* synthetic */ DSPScreenActivity c;

    q(DSPScreenActivity dSPScreenActivity, SharedPreferences sharedPreferences, String str) {
        this.c = dSPScreenActivity;
        this.a = sharedPreferences;
        this.b = str;
    }

    public void onClick(View view) {
        this.a.edit().putBoolean(this.b, this.c.mEnable.isChecked()).apply();
        this.c.sendBroadcast(new Intent("com.audlabs.viperfx.updatemainui"));
        this.c.sendBroadcast(new Intent("com.audlabs.viperfx.UPDATE"));
    }
}
