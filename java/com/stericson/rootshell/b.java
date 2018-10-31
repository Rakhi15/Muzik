package com.stericson.rootshell;

import com.stericson.rootshell.b.a;
import java.util.List;

final class b extends a {
    final /* synthetic */ List a;

    b(int i, boolean z, String[] strArr, List list) {
        this.a = list;
        super(i, z, strArr);
    }

    public void a(int i, String str) {
        a.c(str);
        this.a.add(str);
        super.a(i, str);
    }
}
