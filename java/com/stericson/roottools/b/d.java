package com.stericson.roottools.b;

import com.stericson.rootshell.b.a;
import java.util.List;

class d extends a {
    final /* synthetic */ List a;
    final /* synthetic */ c b;

    d(c cVar, int i, boolean z, String[] strArr, List list) {
        this.b = cVar;
        this.a = list;
        super(i, z, strArr);
    }

    public void a(int i, String str) {
        if (!(i != 3 || str.trim().equals("") || str.trim().contains("not found") || str.trim().contains("file busy"))) {
            this.a.add(str);
        }
        super.a(i, str);
    }
}
