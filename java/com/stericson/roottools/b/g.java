package com.stericson.roottools.b;

import com.stericson.rootshell.b.a;

class g extends a {
    final /* synthetic */ c a;

    g(c cVar, int i, boolean z, String... strArr) {
        this.a = cVar;
        super(i, z, strArr);
    }

    public void a(int i, String str) {
        if (i == 1) {
            String str2 = "";
            if (str.split(" ")[0].length() != 10) {
                super.a(i, str);
                return;
            }
            com.stericson.roottools.a.i("Line " + str);
            try {
                String[] split = str.split(" ");
                if (split[split.length - 2].equals("->")) {
                    com.stericson.roottools.a.i("Symlink found.");
                    str2 = split[split.length - 1];
                }
            } catch (Exception e) {
            }
            try {
                a.j = this.a.a(str);
                if (a.j != null) {
                    a.j.a(str2);
                }
            } catch (Exception e2) {
                com.stericson.roottools.a.i(e2.getMessage());
            }
        }
        super.a(i, str);
    }
}
