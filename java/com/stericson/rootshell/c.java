package com.stericson.rootshell;

import com.stericson.rootshell.b.a;
import java.util.List;

final class c extends a {
    final /* synthetic */ String a;
    final /* synthetic */ List b;
    final /* synthetic */ String c;

    c(int i, boolean z, String[] strArr, String str, List list, String str2) {
        this.a = str;
        this.b = list;
        this.c = str2;
        super(i, z, strArr);
    }

    public void a(int i, String str) {
        if (str.contains("File: ") && str.contains(this.a)) {
            this.b.add(this.c);
            a.c(this.a + " was found here: " + this.c);
        }
        a.c(str);
        super.a(i, str);
    }
}
