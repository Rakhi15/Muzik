package com.audlabs.viperfx.base;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.util.Log;

final class m implements OnClickListener {
    m() {
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        Log.i("ViPER4Android", "Load profile canceled");
    }
}
