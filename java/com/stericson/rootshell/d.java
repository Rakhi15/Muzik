package com.stericson.rootshell;

import com.stericson.rootshell.b.a;
import java.util.Arrays;
import java.util.Set;

final class d extends a {
    final /* synthetic */ Set a;

    d(int i, boolean z, String[] strArr, Set set) {
        this.a = set;
        super(i, z, strArr);
    }

    public void a(int i, String str) {
        if (i == 158) {
            this.a.addAll(Arrays.asList(str.split(" ")));
        }
        super.a(i, str);
    }
}
