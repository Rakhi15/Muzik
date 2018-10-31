package com.stericson.rootshell.b;

class g extends Thread {
    final /* synthetic */ e a;

    g(e eVar) {
        this.a = eVar;
    }

    public void run() {
        synchronized (this.a.q) {
            this.a.q.notifyAll();
        }
    }
}
