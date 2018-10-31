package com.audlabs.viperfx.service;

import java.util.concurrent.Semaphore;

class n {
    final /* synthetic */ ViPER4AndroidService a;
    private final Semaphore b;

    private n(ViPER4AndroidService viPER4AndroidService) {
        this.a = viPER4AndroidService;
        this.b = new Semaphore(1);
    }

    public boolean a() {
        try {
            this.b.acquire();
            return true;
        } catch (InterruptedException e) {
            return false;
        }
    }

    public void b() {
        this.b.release();
    }
}
