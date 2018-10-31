package com.stericson.roottools.b;

import com.stericson.rootshell.b.a;

class h extends a {
    final /* synthetic */ c a;

    h(c cVar, int i, boolean z, String... strArr) {
        this.a = cVar;
        super(i, z, strArr);
    }

    public void a(int i, String str) {
        if (i == 6 && str.contains(a.e.trim())) {
            a.d = str.split(" ");
        }
        super.a(i, str);
    }
}
