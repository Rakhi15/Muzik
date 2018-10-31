package com.audlabs.viperfx.b;

import android.util.Log;

public class c {
    public static boolean a = true;

    public static void a(String str) {
        if (a) {
            Log.i("ViPER4Android", str);
        }
    }

    public static void b(String str) {
        if (a) {
            Log.d("ViPER4Android", str);
        }
    }
}
