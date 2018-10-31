package com.audlabs.viperfx.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.util.Log;

final class i implements OnClickListener {
    i() {
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        Log.i("ViPER4Android", "[LPA] User canceled");
        dialogInterface.dismiss();
    }
}
