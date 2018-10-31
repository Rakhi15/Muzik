package com.audlabs.viperfx.main;

import android.app.DialogFragment;
import android.os.Handler;
import android.os.Message;
import android.view.View;

class h extends Handler {
    final /* synthetic */ MainActivity a;

    h(MainActivity mainActivity) {
        this.a = mainActivity;
    }

    public void handleMessage(Message message) {
        if (message.what == 1) {
            View view = (View) message.obj;
            if (view != null) {
                DialogFragment iVar = new i(this, view);
                iVar.setStyle(1, 0);
                iVar.show(this.a.getFragmentManager(), "v4astatus");
            }
        }
        super.handleMessage(message);
    }
}
