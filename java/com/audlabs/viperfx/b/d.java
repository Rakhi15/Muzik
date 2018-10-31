package com.audlabs.viperfx.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class d {
    private static boolean a;
    private static String b = "";
    private static String c = "";
    private static String d = "";
    private static String e = "";
    private static String f = "";

    public static List a(Context context) {
        List arrayList = new ArrayList();
        StorageManager storageManager = (StorageManager) context.getSystemService("storage");
        try {
            Method method = StorageManager.class.getMethod("getVolumePaths", new Class[0]);
            method.setAccessible(true);
            for (String str : (String[]) method.invoke(storageManager, new Object[0])) {
                String str2;
                if (!str2.endsWith("/")) {
                    str2 = str2 + "/";
                }
                String str3 = str2 + "v4a_test_file";
                Log.i("ViPER4Android", "Now checking for external storage writable, file = " + str3);
                if (a(str3)) {
                    arrayList.add(str2);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public static boolean a() {
        return a;
    }

    private static boolean a(String str) {
        boolean z = false;
        try {
            byte[] bArr = new byte[16];
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            fileOutputStream.write(bArr);
            fileOutputStream.flush();
            fileOutputStream.close();
            z = new File(str).delete();
        } catch (FileNotFoundException e) {
            Log.i("ViPER4Android", "FileNotFoundException, msg = " + e.getMessage());
        } catch (IOException e2) {
            Log.i("ViPER4Android", "IOException, msg = " + e2.getMessage());
        }
        return z;
    }

    public static String b() {
        return b;
    }

    public static void b(Context context) {
        try {
            c(context);
        } catch (Exception e) {
            String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
            if (VERSION.SDK_INT >= 18 && (absolutePath.endsWith("/emulated/0") || absolutePath.endsWith("/emulated/0/"))) {
                absolutePath = absolutePath.replace("/emulated/0", "/emulated/legacy");
            }
            if (!absolutePath.endsWith("/")) {
                absolutePath = absolutePath + "/";
            }
            b = absolutePath;
            c = b + "ViPER4Android/";
            d = c + "Kernel/";
            e = c + "DDC/";
            f = c + "Profile/";
        }
        a = true;
    }

    public static String c() {
        return c;
    }

    private static void c(Context context) {
        String str;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.audlabs.viperfx.settings", 0);
        if (!"".equals(sharedPreferences.getString("viper4android.settings.default_storage", ""))) {
            b = sharedPreferences.getString("viper4android.settings.default_storage", "");
            c = b + "ViPER4Android/";
            d = c + "Kernel/";
            e = c + "DDC/";
            f = c + "Profile/";
            str = b + "v4a_test_file";
            Log.i("ViPER4Android", "Now checking for external storage writable, file = " + str);
            if (a(str)) {
                return;
            }
        }
        str = Environment.getExternalStorageDirectory().getAbsolutePath();
        if (Environment.getExternalStorageState().equals("mounted")) {
            String str2 = (str.endsWith("/") ? str : str + "/") + "v4a_test_file";
            Log.i("ViPER4Android", "Now checking for external storage writable, file = " + str2);
            if ((a(str2) ? 1 : 0) != 0) {
                if (!str.endsWith("/")) {
                    str = str + "/";
                }
                b = str;
                c = b + "ViPER4Android/";
                d = c + "Kernel/";
                e = c + "DDC/";
                f = c + "Profile/";
                Log.i("ViPER4Android", "External storage path = " + b);
                Log.i("ViPER4Android", "ViPER4Android root path = " + c);
                Log.i("ViPER4Android", "ViPER4Android kernel path = " + d);
                Log.i("ViPER4Android", "ViPER4Android custom DDC path = " + e);
                Log.i("ViPER4Android", "ViPER4Android profile path = " + f);
                return;
            }
            Log.i("ViPER4Android", "Really terrible thing, external storage detection failed. V4A may malfunction");
            if (!str.endsWith("/")) {
                str = str + "/";
            }
            b = str;
            c = b + "ViPER4Android/";
            d = c + "Kernel/";
            e = c + "DDC/";
            f = c + "Profile/";
            return;
        }
        if (VERSION.SDK_INT >= 18 && (str.endsWith("/emulated/0") || str.endsWith("/emulated/0/"))) {
            str = str.replace("/emulated/0", "/emulated/legacy");
        }
        if (!str.endsWith("/")) {
            str = str + "/";
        }
        b = str;
        c = b + "ViPER4Android/";
        d = c + "Kernel/";
        e = c + "DDC/";
        f = c + "Profile/";
    }

    public static String d() {
        return d;
    }

    public static String e() {
        return e;
    }

    public static String f() {
        return f;
    }
}
