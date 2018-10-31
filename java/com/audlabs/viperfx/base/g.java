package com.audlabs.viperfx.base;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v7.app.ad;
import android.view.View;
import android.widget.EditText;

final class g implements OnClickListener {
    final /* synthetic */ Context a;
    final /* synthetic */ String[] b;

    g(Context context, String[] strArr) {
        this.a = context;
        this.b = strArr;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == 0) {
            ad adVar = new ad(this.a);
            adVar.a(2131099812);
            View editText = new EditText(this.a);
            adVar.b(editText);
            adVar.a(this.a.getResources().getString(2131099816), new h(this, editText));
            adVar.b(this.a.getResources().getString(2131099775), new i(this));
            adVar.c();
            return;
        }
        String str = this.b[i];
        ad adVar2 = new ad(this.a);
        adVar2.a("ViPERFX");
        adVar2.b(this.a.getResources().getString(2131099819));
        adVar2.a(this.a.getResources().getString(2131099816), new j(this, str)).b(this.a.getResources().getString(2131099775), null);
        adVar2.c();
    }
}
