package com.stericson.roottools;

import com.stericson.rootshell.b.a;

class h extends a {
    final /* synthetic */ c a;

    h(c cVar, int i, String... strArr) {
        this.a = cVar;
        super(i, strArr);
    }

    public void a(int i, String str) {
        this.a.a(3, str + "\n");
        super.a(i, str);
    }
}
