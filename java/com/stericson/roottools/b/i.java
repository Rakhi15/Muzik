package com.stericson.roottools.b;

import com.stericson.rootshell.b.a;
import java.util.List;

class i extends a {
    final /* synthetic */ List a;
    final /* synthetic */ c b;

    i(c cVar, int i, boolean z, String[] strArr, List list) {
        this.b = cVar;
        this.a = list;
        super(i, z, strArr);
    }

    public void a(int i, String str) {
        if (i == 7 && !str.trim().equals("")) {
            this.a.add(str);
        }
        super.a(i, str);
    }
}
