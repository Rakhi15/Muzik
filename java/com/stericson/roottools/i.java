package com.stericson.roottools;

import com.stericson.rootshell.b.a;
import java.io.IOException;

class i extends a {
    boolean a = false;
    final /* synthetic */ c b;

    i(c cVar, int i, boolean z, String... strArr) {
        this.b = cVar;
        super(i, z, strArr);
    }

    public void a(int i, int i2) {
        synchronized (this.b.a) {
            this.a = true;
            this.b.a(4, "All tests complete.");
            this.b.a(2, null);
            try {
                a.a();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void a(int i, String str) {
        if (this.a) {
            a.i("CAUGHT!!!");
        }
        super.a(i, str);
    }

    public void b(int i, String str) {
        synchronized (this.b.a) {
            this.a = true;
            this.b.a(4, "All tests complete.");
            this.b.a(2, null);
            try {
                a.a();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
