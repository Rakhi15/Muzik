package com.stericson.rootshell;

import android.util.Log;
import com.stericson.rootshell.b.e;
import com.stericson.rootshell.b.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import me.imid.swipebacklayout.lib.f;

public class a {
    public static boolean a = false;
    public static boolean b = true;
    public static int c = 20000;

    public static e a(boolean z) {
        return a(z, 0);
    }

    public static e a(boolean z, int i) {
        return a(z, i, e.a, 3);
    }

    public static e a(boolean z, int i, i iVar, int i2) {
        return z ? e.a(i, iVar, i2) : e.a(i);
    }

    public static e a(boolean z, i iVar) {
        return a(z, 0, iVar, 3);
    }

    public static List a(String str, List list) {
        String str2;
        Object obj;
        List arrayList = new ArrayList();
        if (list == null) {
            list = b();
        }
        c("Checking for " + str);
        try {
            for (String str22 : r13) {
                com.stericson.rootshell.b.a cVar = new c(0, false, new String[]{"stat " + (!str22.endsWith("/") ? str22 + "/" : str22) + str}, str, arrayList, !str22.endsWith("/") ? str22 + "/" : str22);
                a(false).a(cVar);
                a(a(false), cVar);
            }
            if (arrayList.isEmpty()) {
                obj = null;
            } else {
                int i = 1;
            }
        } catch (Exception e) {
            c(str + " was not found, more information MAY be available with Debugging on.");
            obj = null;
        }
        if (obj == null) {
            c("Trying second method");
            for (String str222 : r13) {
                if (!str222.endsWith("/")) {
                    str222 = str222 + "/";
                }
                if (a(str222 + str)) {
                    c(str + " was found here: " + str222);
                    arrayList.add(str222);
                } else {
                    c(str + " was NOT found here: " + str222);
                }
            }
        }
        Collections.reverse(arrayList);
        return arrayList;
    }

    public static void a() {
        e.e();
    }

    private static void a(e eVar, com.stericson.rootshell.b.a aVar) {
        while (!aVar.e()) {
            a("RootShell v1.3", eVar.c(aVar));
            a("RootShell v1.3", "Processed " + aVar.g + " of " + aVar.f + " output from command.");
            synchronized (aVar) {
                try {
                    if (!aVar.e()) {
                        aVar.wait(2000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (!(aVar.d() || aVar.e())) {
                Exception exception;
                if (!eVar.b && !eVar.c) {
                    a("RootShell v1.3", "Waiting for a command to be executed in a shell that is not executing and not reading! \n\n Command: " + aVar.c());
                    exception = new Exception();
                    exception.setStackTrace(Thread.currentThread().getStackTrace());
                    exception.printStackTrace();
                } else if (!eVar.b || eVar.c) {
                    a("RootShell v1.3", "Waiting for a command to be executed in a shell that is not reading! \n\n Command: " + aVar.c());
                    exception = new Exception();
                    exception.setStackTrace(Thread.currentThread().getStackTrace());
                    exception.printStackTrace();
                } else {
                    a("RootShell v1.3", "Waiting for a command to be executed in a shell that is executing but not reading! \n\n Command: " + aVar.c());
                    exception = new Exception();
                    exception.setStackTrace(Thread.currentThread().getStackTrace());
                    exception.printStackTrace();
                }
            }
        }
    }

    public static void a(String str, f fVar, Exception exception) {
        a(null, str, fVar, exception);
    }

    public static void a(String str, String str2) {
        a(str, str2, f.DEBUG, null);
    }

    public static void a(String str, String str2, f fVar, Exception exception) {
        if (str2 != null && !str2.equals("") && a) {
            if (str == null) {
                str = "RootShell v1.3";
            }
            switch (e.a[fVar.ordinal()]) {
                case f.View_android_focusable /*1*/:
                    Log.v(str, str2);
                    return;
                case f.View_paddingStart /*2*/:
                    Log.e(str, str2, exception);
                    return;
                case f.View_paddingEnd /*3*/:
                    Log.d(str, str2);
                    return;
                case f.View_theme /*4*/:
                    Log.w(str, str2);
                    return;
                default:
                    return;
            }
        }
    }

    public static boolean a(String str) {
        return a(str, false);
    }

    public static boolean a(String str, boolean z) {
        Collection<String> arrayList = new ArrayList();
        String str2 = "ls " + (z ? "-d " : " ");
        com.stericson.rootshell.b.a bVar = new b(0, false, new String[]{str2 + str}, arrayList);
        try {
            a(false).a(bVar);
            a(a(false), bVar);
            for (String str22 : arrayList) {
                if (str22.trim().equals(str)) {
                    return true;
                }
            }
            arrayList.clear();
            try {
                a(true).a(bVar);
                a(a(true), bVar);
                List<String> arrayList2 = new ArrayList();
                arrayList2.addAll(arrayList);
                for (String str222 : arrayList2) {
                    if (str222.trim().equals(str)) {
                        return true;
                    }
                }
                return false;
            } catch (Exception e) {
                return false;
            }
        } catch (Exception e2) {
            return false;
        }
    }

    public static List b() {
        return Arrays.asList(System.getenv("PATH").split(":"));
    }

    public static List b(String str) {
        return a(str, null);
    }

    public static void c(String str) {
        a(null, str, f.DEBUG, null);
    }

    public static boolean c() {
        Set<String> hashSet = new HashSet();
        try {
            c("Checking for Root access");
            com.stericson.rootshell.b.a dVar = new d(158, false, new String[]{"id"}, hashSet);
            e.h().a(dVar);
            a(e.h(), dVar);
            for (String str : hashSet) {
                c(str);
                if (str.toLowerCase().contains("uid=0")) {
                    c("Access Given");
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean d() {
        return b("busybox").size() > 0;
    }

    public static boolean e() {
        return b("su").size() > 0;
    }
}
