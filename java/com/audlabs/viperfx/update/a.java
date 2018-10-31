package com.audlabs.viperfx.update;

import android.os.Handler;
import android.os.Message;
import me.imid.swipebacklayout.lib.f;

class a extends Handler {
    final /* synthetic */ DownloadService a;

    a(DownloadService downloadService) {
        this.a = downloadService;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case f.View_android_theme /*0*/:
                this.a.b.cancel(1);
                this.a.d();
                return;
            case f.View_android_focusable /*1*/:
                int i = message.arg1;
                if (i < 100) {
                    this.a.l.a(100, i, false);
                    this.a.k = this.a.l.a();
                } else {
                    this.a.l.a(0, 0, false);
                    this.a.k = this.a.l.a();
                    this.a.k.flags = 16;
                    this.a.h = true;
                    this.a.stopSelf();
                }
                this.a.b.notify(1, this.a.k);
                return;
            case f.View_paddingStart /*2*/:
                this.a.b.cancel(1);
                return;
            default:
                return;
        }
    }
}
