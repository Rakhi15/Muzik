package com.audlabs.viperfx.main;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v7.app.ad;
import com.audlabs.viperfx.b.e;

class l implements OnClickListener {
    final /* synthetic */ j a;

    l(j jVar) {
        this.a = jVar;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        e.b();
        ad adVar = new ad(this.a.a);
        adVar.a("ViPERFX");
        adVar.b(this.a.a.getResources().getString(2131099799));
        adVar.b(this.a.a.getResources().getString(2131099816), null);
        adVar.c();
    }
}
