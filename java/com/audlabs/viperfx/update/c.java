package com.audlabs.viperfx.update;

import android.os.Binder;

public class c extends Binder {
    final /* synthetic */ DownloadService a;

    public c(DownloadService downloadService) {
        this.a = downloadService;
    }

    public void a() {
        if (this.a.j == null || !this.a.j.isAlive()) {
            this.a.a = 0;
            this.a.b();
            new d(this).start();
        }
    }
}
