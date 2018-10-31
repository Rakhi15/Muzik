package com.stericson.roottools.b;

import com.stericson.rootshell.b.a;

class e extends a {
    final /* synthetic */ c a;

    e(c cVar, int i, boolean z, String... strArr) {
        this.a = cVar;
        super(i, z, strArr);
    }

    public void a(int i, String str) {
        String trim = str.trim();
        if (i == 4) {
            com.stericson.roottools.a.i("Version Output: " + trim);
            String[] split = trim.split(" ");
            if (split.length > 1 && split[1].contains("v1.")) {
                a.f = split[1];
                com.stericson.roottools.a.i("Found Version: " + a.f);
            }
        }
        super.a(i, trim);
    }
}
