package com.audlabs.viperfx.update;

import com.audlabs.viperfx.b.d;
import java.io.File;

class b implements Runnable {
    final /* synthetic */ DownloadService a;

    b(DownloadService downloadService) {
        this.a = downloadService;
    }

    public void run() {
        File file = new File(d.c() + "/download");
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            this.a.a(this.a.d, new File(this.a.f));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
