package com.audlabs.viperfx.screen;

import android.os.Handler;
import android.os.Message;

class bi extends Handler {
    final /* synthetic */ VDdcFragment a;

    bi(VDdcFragment vDdcFragment) {
        this.a = vDdcFragment;
    }

    public void handleMessage(Message message) {
        if (message.what == 0) {
            this.a.b.e();
            this.a.mRecyclerView.a(this.a.g);
        }
        super.handleMessage(message);
    }
}
