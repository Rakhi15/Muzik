package com.audlabs.viperfx.base;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.EditText;

class h implements OnClickListener {
    final /* synthetic */ EditText a;
    final /* synthetic */ g b;

    h(g gVar, EditText editText) {
        this.b = gVar;
        this.a = editText;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        e.c(this.b.a, this.a.getText().toString());
    }
}
