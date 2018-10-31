package com.stericson.rootshell.b;

import com.stericson.rootshell.a;

class f implements Runnable {
    final /* synthetic */ e a;

    f(e eVar) {
        this.a = eVar;
    }

    public void run() {
        while (true) {
            try {
                synchronized (this.a.q) {
                    while (!this.a.r && this.a.v >= this.a.q.size()) {
                        this.a.b = false;
                        this.a.q.wait();
                    }
                }
                if (this.a.v >= this.a.t) {
                    while (this.a.u != this.a.v) {
                        a.c("Waiting for read and write to catch up before cleanup.");
                    }
                    this.a.i();
                }
                if (this.a.v < this.a.q.size()) {
                    this.a.b = true;
                    a aVar = (a) this.a.q.get(this.a.v);
                    aVar.g();
                    a.c("Executing: " + aVar.c() + " with context: " + this.a.k);
                    this.a.p.write(aVar.c());
                    this.a.p.write("\necho F*D^W@#FGF " + this.a.w + " $?\n");
                    this.a.p.flush();
                    this.a.v = this.a.v + 1;
                    this.a.w = this.a.w + 1;
                } else if (this.a.r) {
                    this.a.b = false;
                    this.a.p.write("\nexit 0\n");
                    this.a.p.flush();
                    a.c("Closing shell");
                    this.a.v = 0;
                    this.a.a(this.a.p);
                    return;
                }
            } catch (Exception e) {
                try {
                    a.a(e.getMessage(), com.stericson.rootshell.f.ERROR, e);
                    return;
                } finally {
                    this.a.v = 0;
                    this.a.a(this.a.p);
                }
            } catch (Exception e2) {
                a.a(e2.getMessage(), com.stericson.rootshell.f.ERROR, e2);
                this.a.v = 0;
                this.a.a(this.a.p);
                return;
            }
        }
    }
}
