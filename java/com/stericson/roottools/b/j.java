package com.stericson.roottools.b;

import com.stericson.rootshell.b.a;

class j extends a {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ c c;

    j(c cVar, int i, boolean z, String[] strArr, String str, String str2) {
        this.c = cVar;
        this.a = str;
        this.b = str2;
        super(i, z, strArr);
    }

    public void a(int i, String str) {
        if (this.a.endsWith("toybox")) {
            if (!str.contains("no such tool")) {
                a.b = true;
            }
        } else if (this.a.endsWith("toolbox")) {
            if (!str.contains("no such tool")) {
                a.b = true;
            }
        } else if (this.a.endsWith("busybox") && str.contains(this.b)) {
            com.stericson.roottools.a.i("Found util!");
            a.b = true;
        }
        super.a(i, str);
    }
}
