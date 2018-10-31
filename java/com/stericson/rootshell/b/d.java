package com.stericson.rootshell.b;

import com.stericson.rootshell.a;

class d extends Thread {
    final /* synthetic */ a a;

    private d(a aVar) {
        this.a = aVar;
    }

    public void run() {
        if (this.a.q > 0) {
            while (!this.a.l) {
                synchronized (this.a) {
                    try {
                        this.a.wait((long) this.a.q);
                    } catch (InterruptedException e) {
                    }
                }
                if (!this.a.l) {
                    a.c("Timeout Exception has occurred.");
                    this.a.a("Timeout Exception");
                }
            }
        }
    }
}
