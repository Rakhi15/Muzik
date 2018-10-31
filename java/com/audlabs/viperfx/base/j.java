package com.audlabs.viperfx.base;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class j implements OnClickListener {
    final /* synthetic */ String a;
    final /* synthetic */ g b;

    j(g gVar, String str) {
        this.b = gVar;
        this.a = str;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        e.c(this.b.a, this.a);
    }
}
