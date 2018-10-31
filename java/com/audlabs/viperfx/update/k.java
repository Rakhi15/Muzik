package com.audlabs.viperfx.update;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.ServiceConnection;

class k implements OnClickListener {
    final /* synthetic */ String a;
    final /* synthetic */ e b;

    k(e eVar, String str) {
        this.b = eVar;
        this.a = str;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        ServiceConnection lVar = new l(this);
        Intent intent = new Intent(this.b.b, DownloadService.class);
        intent.putExtra("download_url", this.a);
        intent.putExtra("title", "ViPER4Android");
        this.b.b.startService(intent);
        this.b.b.bindService(intent, lVar, 1);
    }
}
