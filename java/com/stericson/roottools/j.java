package com.stericson.roottools;

import android.os.Handler;
import android.os.Message;
import me.imid.swipebacklayout.lib.f;

class j extends Handler {
    final /* synthetic */ SanityCheckRootTools a;

    private j(SanityCheckRootTools sanityCheckRootTools) {
        this.a = sanityCheckRootTools;
    }

    public void handleMessage(Message message) {
        int i = message.getData().getInt("action");
        CharSequence string = message.getData().getString("text");
        switch (i) {
            case f.View_android_focusable /*1*/:
                this.a.c.show();
                this.a.c.setMessage("Running Root Library Tests...");
                return;
            case f.View_paddingStart /*2*/:
                if (string != null) {
                    this.a.a(string);
                }
                this.a.c.hide();
                return;
            case f.View_paddingEnd /*3*/:
                this.a.a(string);
                return;
            case f.View_theme /*4*/:
                this.a.c.setMessage(string);
                return;
            default:
                return;
        }
    }
}
