package com.stericson.rootshell.b;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.IOException;

public class a {
    protected boolean d;
    protected Context e;
    public int f;
    public int g;
    d h;
    Handler i;
    boolean j;
    String[] k;
    boolean l;
    boolean m;
    boolean n;
    int o;
    int p;
    int q;

    public a(int i, int i2, String... strArr) {
        this.d = false;
        this.e = null;
        this.f = 0;
        this.g = 0;
        this.h = null;
        this.i = null;
        this.j = false;
        this.k = new String[0];
        this.l = false;
        this.m = false;
        this.n = true;
        this.o = -1;
        this.p = 0;
        this.q = com.stericson.rootshell.a.c;
        this.k = strArr;
        this.p = i;
        this.q = i2;
        a(com.stericson.rootshell.a.b);
    }

    public a(int i, boolean z, String... strArr) {
        this.d = false;
        this.e = null;
        this.f = 0;
        this.g = 0;
        this.h = null;
        this.i = null;
        this.j = false;
        this.k = new String[0];
        this.l = false;
        this.m = false;
        this.n = true;
        this.o = -1;
        this.p = 0;
        this.q = com.stericson.rootshell.a.c;
        this.k = strArr;
        this.p = i;
        a(z);
    }

    public a(int i, String... strArr) {
        this.d = false;
        this.e = null;
        this.f = 0;
        this.g = 0;
        this.h = null;
        this.i = null;
        this.j = false;
        this.k = new String[0];
        this.l = false;
        this.m = false;
        this.n = true;
        this.o = -1;
        this.p = 0;
        this.q = com.stericson.rootshell.a.c;
        this.k = strArr;
        this.p = i;
        a(com.stericson.rootshell.a.b);
    }

    private void a(boolean z) {
        this.n = z;
        if (Looper.myLooper() == null || !z) {
            com.stericson.rootshell.a.c("CommandHandler not created");
            return;
        }
        com.stericson.rootshell.a.c("CommandHandler created");
        this.i = new c();
    }

    protected final void a() {
        if (!this.m) {
            synchronized (this) {
                if (this.i == null || !this.n) {
                    a(this.p, this.o);
                } else {
                    Message obtainMessage = this.i.obtainMessage();
                    Bundle bundle = new Bundle();
                    bundle.putInt("action", 2);
                    obtainMessage.setData(bundle);
                    this.i.sendMessage(obtainMessage);
                }
                com.stericson.rootshell.a.c("Command " + this.p + " finished.");
                b();
            }
        }
    }

    protected final void a(int i) {
        synchronized (this) {
            this.o = i;
        }
    }

    public void a(int i, int i2) {
    }

    public void a(int i, String str) {
        com.stericson.rootshell.a.a("Command", "ID: " + i + ", " + str);
        this.g++;
    }

    protected final void a(String str) {
        try {
            e.e();
            com.stericson.rootshell.a.c("Terminating all shells.");
            b(str);
        } catch (IOException e) {
        }
    }

    protected final void b() {
        this.j = false;
        this.l = true;
        notifyAll();
    }

    public void b(int i, String str) {
    }

    protected final void b(String str) {
        synchronized (this) {
            if (this.i == null || !this.n) {
                b(this.p, str);
            } else {
                Message obtainMessage = this.i.obtainMessage();
                Bundle bundle = new Bundle();
                bundle.putInt("action", 3);
                bundle.putString("text", str);
                obtainMessage.setData(bundle);
                this.i.sendMessage(obtainMessage);
            }
            com.stericson.rootshell.a.c("Command " + this.p + " did not finish because it was terminated. Termination reason: " + str);
            a(-1);
            this.m = true;
            b();
        }
    }

    public final String c() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < this.k.length; i++) {
            if (i > 0) {
                stringBuilder.append('\n');
            }
            stringBuilder.append(this.k[i]);
        }
        return stringBuilder.toString();
    }

    protected final void c(int i, String str) {
        this.f++;
        if (this.i == null || !this.n) {
            a(i, str);
            return;
        }
        Message obtainMessage = this.i.obtainMessage();
        Bundle bundle = new Bundle();
        bundle.putInt("action", 1);
        bundle.putString("text", str);
        obtainMessage.setData(bundle);
        this.i.sendMessage(obtainMessage);
    }

    public final boolean d() {
        return this.j;
    }

    public final boolean e() {
        return this.l;
    }

    public final int f() {
        return this.o;
    }

    protected final void g() {
        this.h = new d();
        this.h.setPriority(1);
        this.h.start();
        this.j = true;
    }

    public final void h() {
        this.l = false;
        this.f = 0;
        this.g = 0;
        this.j = false;
        this.m = false;
        this.o = -1;
    }
}
