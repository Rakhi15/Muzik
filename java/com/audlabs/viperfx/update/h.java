package com.audlabs.viperfx.update;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.ServiceConnection;

class h implements OnClickListener {
    final /* synthetic */ String a;
    final /* synthetic */ e b;

    h(e eVar, String str) {
        this.b = eVar;
        this.a = str;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.b.d.edit().putBoolean("viper4android.settings.is_check_update", true).apply();
        if (this.b.b(this.b.b)) {
            ServiceConnection iVar = new i(this);
            Intent intent = new Intent(this.b.b, DownloadService.class);
            intent.putExtra("download_url", this.a);
            intent.putExtra("title", "ViPER4Android");
            this.b.b.startService(intent);
            this.b.b.bindService(intent, iVar, 1);
            return;
        }
        this.b.a(this.a);
    }
}
