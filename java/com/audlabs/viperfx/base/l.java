package com.audlabs.viperfx.base;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class l implements OnClickListener {
    final /* synthetic */ Context a;
    final /* synthetic */ String[] b;

    l(Context context, String[] strArr) {
        this.a = context;
        this.b = strArr;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        e.d(this.a, this.b[i]);
    }
}
