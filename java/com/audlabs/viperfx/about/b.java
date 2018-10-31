package com.audlabs.viperfx.about;

import android.os.Handler;
import android.os.Message;

class b extends Handler {
    final /* synthetic */ ChangelogFragment a;

    b(ChangelogFragment changelogFragment) {
        this.a = changelogFragment;
    }

    public void handleMessage(Message message) {
        if (message.what == 1) {
            this.a.mTvChangelogtxt.setText((String) message.obj);
        }
        super.handleMessage(message);
    }
}
