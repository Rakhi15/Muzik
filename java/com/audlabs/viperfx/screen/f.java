package com.audlabs.viperfx.screen;

import android.os.Handler;
import android.os.Message;

class f extends Handler {
    final /* synthetic */ ConvolverFragment a;

    f(ConvolverFragment convolverFragment) {
        this.a = convolverFragment;
    }

    public void handleMessage(Message message) {
        if (message.what == 0) {
            this.a.d.e();
            this.a.mConvolverKnlRecyclerview.a(this.a.c);
        }
        super.handleMessage(message);
    }
}
