package com.stericson.roottools;

import android.util.Log;
import com.stericson.rootshell.b.e;
import com.stericson.rootshell.b.i;
import com.stericson.roottools.b.b;
import com.stericson.roottools.b.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import me.imid.swipebacklayout.lib.f;

public final class a {
    public static boolean a = true;
    public static String b;
    public static boolean c = true;
    public static int d = 20000;
    private static c e = null;

    public static e a(boolean z) {
        return a(z, 0);
    }

    public static e a(boolean z, int i) {
        return a(z, i, e.a, 3);
    }

    public static e a(boolean z, int i, i iVar, int i2) {
        return com.stericson.rootshell.a.a(z, i, iVar, i2);
    }

    public static e a(boolean z, i iVar) {
        return a(z, 0, iVar, 3);
    }

    public static void a() {
        com.stericson.rootshell.a.a();
    }

    public static void a(c cVar) {
        e = cVar;
    }

    public static void a(String str, String str2, int i, Exception exception) {
        if (str2 != null && !str2.equals("") && a) {
            if (str == null) {
                str = "RootTools v4.2";
            }
            switch (i) {
                case f.View_android_focusable /*1*/:
                    Log.v(str, str2);
                    return;
                case f.View_paddingStart /*2*/:
                    Log.e(str, str2, exception);
                    return;
                case f.View_paddingEnd /*3*/:
                    Log.d(str, str2);
                    return;
                default:
                    return;
            }
        }
    }

    public static boolean a(String str) {
        return g().d(str);
    }

    public static boolean a(String str, String str2) {
        return g().b(str, str2);
    }

    public static boolean a(String str, String str2, boolean z, boolean z2) {
        return g().a(str, str2, z, z2);
    }

    public static boolean a(String str, boolean z) {
        return g().a(str, z);
    }

    public static boolean a(String[] strArr) {
        return g().a(strArr);
    }

    public static ArrayList b() {
        return g().b();
    }

    public static boolean b(String str) {
        return b(str, false);
    }

    public static boolean b(String str, String str2) {
        return new b().a(str, str2);
    }

    public static boolean b(String str, boolean z) {
        return com.stericson.rootshell.a.a(str, z);
    }

    public static String c(String str) {
        return g().f(str);
    }

    public static List c() {
        return Arrays.asList(System.getenv("PATH").split(":"));
    }

    public static void c(String str, String str2) {
        a(str, str2, 3, null);
    }

    public static List d(String str) {
        return g().e(str);
    }

    public static boolean d() {
        return com.stericson.rootshell.a.c();
    }

    public static com.stericson.roottools.a.b e(String str) {
        return g().i(str);
    }

    public static boolean e() {
        return com.stericson.rootshell.a.d();
    }

    public static String f(String str) {
        return g().h(str);
    }

    public static boolean f() {
        return com.stericson.rootshell.a.e();
    }

    public static long g(String str) {
        return g().j(str);
    }

    private static final c g() {
        if (e != null) {
            return e;
        }
        c.a();
        return e;
    }

    public static String h(String str) {
        return g().k(str);
    }

    public static void i(String str) {
        a(null, str, 3, null);
    }
}
