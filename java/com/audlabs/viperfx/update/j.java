package com.audlabs.viperfx.update;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class j implements OnClickListener {
    final /* synthetic */ e a;

    j(e eVar) {
        this.a = eVar;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.a.d.edit().putBoolean("viper4android.settings.is_check_update", false).apply();
    }
}
