package com.stericson.roottools.b;

import com.stericson.rootshell.b.a;

class f extends a {
    final /* synthetic */ c a;

    f(c cVar, int i, boolean z, String... strArr) {
        this.a = cVar;
        super(i, z, strArr);
    }

    public void a(int i, String str) {
        if (i == 5 && !str.trim().equals("") && Character.isDigit(str.trim().substring(0, 1).toCharArray()[0])) {
            a.i = str.trim().split(" ")[0];
        }
        super.a(i, str);
    }
}
