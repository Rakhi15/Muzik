package com.stericson.rootshell.b;

import android.os.Handler;
import android.os.Message;
import me.imid.swipebacklayout.lib.f;

class c extends Handler {
    final /* synthetic */ a a;

    private c(a aVar) {
        this.a = aVar;
    }

    public final void handleMessage(Message message) {
        int i = message.getData().getInt("action");
        String string = message.getData().getString("text");
        switch (i) {
            case f.View_android_focusable /*1*/:
                this.a.a(this.a.p, string);
                return;
            case f.View_paddingStart /*2*/:
                this.a.a(this.a.p, this.a.o);
                return;
            case f.View_paddingEnd /*3*/:
                this.a.b(this.a.p, string);
                return;
            default:
                return;
        }
    }
}
