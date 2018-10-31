package com.audlabs.viperfx.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class d implements OnClickListener {
    final /* synthetic */ SettingFragment a;

    d(SettingFragment settingFragment) {
        this.a = settingFragment;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.a.a.edit().putBoolean("viper4android.settings.developer", true).apply();
        this.a.b();
    }
}
