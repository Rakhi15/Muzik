package com.audlabs.viperfx.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ad;
import android.util.Log;
import com.audlabs.viperfx.b.d;
import com.audlabs.viperfx.b.j;
import com.audlabs.viperfx.b.k;
import com.audlabs.viperfx.main.MainActivity;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class e {
    public static String a(InputStream inputStream) {
        try {
            Reader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder stringBuilder = new StringBuilder("");
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        stringBuilder.append(readLine);
                        stringBuilder.append("\n");
                    } else {
                        bufferedReader.close();
                        inputStreamReader.close();
                        return stringBuilder.toString();
                    }
                } catch (IOException e) {
                    return "";
                }
            }
        } catch (UnsupportedEncodingException e2) {
            return "";
        }
    }

    public static void a(Context context, Handler handler) {
        int i = 0;
        com.audlabs.viperfx.b.e eVar = new com.audlabs.viperfx.b.e();
        eVar.getClass();
        j jVar = new j(eVar);
        if (jVar.a()) {
            int[] b = jVar.b();
            i = a(b[0] + "." + b[1] + "." + b[2] + "." + b[3]);
        }
        if (i == 0) {
            Log.i("ViPER4Android", "Android audio effect engine reports the v4a driver is not usable");
            Message message = new Message();
            message.what = 40970;
            message.obj = context;
            handler.sendMessage(message);
        }
    }

    private static void a(File file, File file2) {
        InputStream fileInputStream = new FileInputStream(file);
        OutputStream fileOutputStream = new FileOutputStream(file2);
        Log.i("ViPER4Android", "Copying " + file.getAbsolutePath() + " to " + file2.getAbsolutePath());
        byte[] bArr = new byte[1024];
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read > 0) {
                fileOutputStream.write(bArr, 0, read);
            } else {
                fileInputStream.close();
                fileOutputStream.close();
                return;
            }
        }
    }

    public static boolean a() {
        int i;
        Random random = new Random();
        String str = "";
        for (i = 0; i < 8; i++) {
            String toHexString = Integer.toHexString(random.nextInt(256));
            if (toHexString.length() < 2) {
                toHexString = "0" + toHexString;
            }
            str = str + toHexString;
        }
        str = str + "-";
        for (i = 0; i < 4; i++) {
            toHexString = Integer.toHexString(random.nextInt(256));
            if (toHexString.length() < 2) {
                toHexString = "0" + toHexString;
            }
            str = str + toHexString;
        }
        try {
            return ((HttpURLConnection) new URL(new StringBuilder().append("http://vipersaudio.com/stat/v4a_stat.php?code=").append(new StringBuilder().append(str).append("-").append(VERSION.SDK_INT).toString()).append("&ver=viper4android-fx").toString()).openConnection()).getResponseCode() == 200;
        } catch (Exception e) {
            Log.i("ViPER4Android", "Submit failed, error = " + e.getMessage());
            return false;
        }
    }

    public static boolean a(Context context) {
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            String string = context.getSharedPreferences("com.audlabs.viperfx.settings", 0).getString("viper4android.settings.lastversion", "");
            return string == null || string.equals("") || !string.equalsIgnoreCase(str);
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    public static boolean a(String str) {
        List arrayList = new ArrayList();
        if (arrayList.contains(str)) {
            arrayList.clear();
            return true;
        }
        arrayList.clear();
        return str.equals("2.5.0.4");
    }

    public static String b(String str) {
        String str2 = "libv4a_fx_";
        str2 = VERSION.SDK_INT >= 18 ? str2 + "jb_" : str2 + "ics_";
        if (Build.CPU_ABI.contains("x86") || Build.CPU_ABI.contains("X86")) {
            str2 = str2 + "X86.so";
            Log.i("ViPER4Android", "Driver selection = " + str2);
            return str2;
        } else if (new k().a()) {
            str2 = str == null ? str2 + "NEON" : str.equals("") ? str2 + "NEON" : str.equalsIgnoreCase("sq") ? str2 + "NEON_SQ" : str.equalsIgnoreCase("hq") ? str2 + "NEON_HQ" : str2 + "NEON";
            str2 = str2 + ".so";
            Log.i("ViPER4Android", "Driver selection = " + str2);
            return str2;
        } else {
            Log.i("ViPER4Android", "CPU arch not supported");
            return "";
        }
    }

    public static boolean b(Context context) {
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            String string = context.getSharedPreferences("com.audlabs.viperfx.settings", 0).getString("viper4android.settings.ddc_db_compatible", "");
            return string == null || string.equals("") || !string.equalsIgnoreCase(str);
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    public static void c(Context context) {
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            Editor edit = context.getSharedPreferences("com.audlabs.viperfx.settings", 0).edit();
            if (edit != null) {
                edit.putString("viper4android.settings.ddc_db_compatible", str);
                edit.apply();
            }
        } catch (NameNotFoundException e) {
        }
    }

    private static void c(Context context, String str) {
        String str2 = context.getApplicationInfo().dataDir + "/shared_prefs/";
        File file = new File(d.f() + "/" + str);
        file.mkdirs();
        Log.i("ViPER4Android", "Saving profile to " + file.getAbsolutePath());
        String str3 = "com.audlabs.viperfx.";
        str3 = "com.vipercn.viper4android_v2.";
        try {
            a(new File(str2 + "com.audlabs.viperfx." + "bluetooth.xml"), new File(file, "com.vipercn.viper4android_v2.bluetooth.xml"));
        } catch (IOException e) {
            Log.e("ViPER4Android", "Cannot save preset");
        }
        try {
            a(new File(str2 + "com.audlabs.viperfx." + "headset.xml"), new File(file, "com.vipercn.viper4android_v2.headset.xml"));
        } catch (IOException e2) {
            Log.e("ViPER4Android", "Cannot save preset");
        }
        try {
            a(new File(str2 + "com.audlabs.viperfx." + "speaker.xml"), new File(file, "com.vipercn.viper4android_v2.speaker.xml"));
        } catch (IOException e3) {
            Log.e("ViPER4Android", "Cannot save preset");
        }
        try {
            a(new File(str2 + "com.audlabs.viperfx." + "usb.xml"), new File(file, "com.vipercn.viper4android_v2.usb.xml"));
        } catch (IOException e4) {
            Log.e("ViPER4Android", "Cannot save preset");
        }
    }

    public static void d(Context context) {
        String str = Locale.getDefault().getLanguage() + "_" + Locale.getDefault().getCountry();
        String str2 = "Changelog_";
        str = str.equalsIgnoreCase("zh_CN") ? str2 + "zh_CN" : str.equalsIgnoreCase("zh_TW") ? str2 + "zh_TW" : str2 + "en_US";
        str2 = str + ".txt";
        CharSequence charSequence = "";
        try {
            InputStream open = context.getAssets().open(str2);
            charSequence = a(open);
            open.close();
        } catch (IOException e) {
            Log.i("ViPER4Android", "Can not read changelog");
        }
        i(context);
        if (charSequence.equalsIgnoreCase("")) {
            Log.i("ViPER4Android", "Changelog is empty");
            return;
        }
        ad adVar = new ad(context);
        adVar.a(2131099776);
        adVar.b(charSequence);
        adVar.b(context.getResources().getString(2131099816), null);
        adVar.c();
    }

    private static void d(Context context, String str) {
        File file = new File(d.f() + "/" + str);
        if (file.exists()) {
            String str2 = "com.audlabs.viperfx.";
            str2 = "com.vipercn.viper4android_v2.";
            str2 = context.getApplicationInfo().dataDir + "/shared_prefs/";
            try {
                if (new File(file, "com.audlabs.viperfx.bluetooth.xml").exists()) {
                    a(new File(file, "com.audlabs.viperfx.bluetooth.xml"), new File(str2 + "com.audlabs.viperfx." + "bluetooth.xml"));
                } else {
                    a(new File(file, "com.vipercn.viper4android_v2.bluetooth.xml"), new File(str2 + "com.audlabs.viperfx." + "bluetooth.xml"));
                }
            } catch (IOException e) {
                Log.e("ViPER4Android", "Cannot load preset");
            }
            try {
                if (new File(file, "com.audlabs.viperfx.headset.xml").exists()) {
                    a(new File(file, "com.audlabs.viperfx.headset.xml"), new File(str2 + "com.audlabs.viperfx." + "headset.xml"));
                } else {
                    a(new File(file, "com.vipercn.viper4android_v2.headset.xml"), new File(str2 + "com.audlabs.viperfx." + "headset.xml"));
                }
            } catch (IOException e2) {
                Log.e("ViPER4Android", "Cannot load preset");
            }
            try {
                if (new File(file, "com.audlabs.viperfx.speaker.xml").exists()) {
                    a(new File(file, "com.audlabs.viperfx.speaker.xml"), new File(str2 + "com.audlabs.viperfx." + "speaker.xml"));
                } else {
                    a(new File(file, "com.vipercn.viper4android_v2.speaker.xml"), new File(str2 + "com.audlabs.viperfx." + "speaker.xml"));
                }
            } catch (IOException e3) {
                Log.e("ViPER4Android", "Cannot load preset");
            }
            try {
                if (new File(file, "com.audlabs.viperfx.usb.xml").exists()) {
                    a(new File(file, "com.audlabs.viperfx.usb.xml"), new File(str2 + "com.audlabs.viperfx." + "usb.xml"));
                } else {
                    a(new File(file, "com.vipercn.viper4android_v2.usb.xml"), new File(str2 + "com.audlabs.viperfx." + "usb.xml"));
                }
            } catch (IOException e4) {
                Log.e("ViPER4Android", "Cannot load preset");
            }
            context.sendBroadcast(new Intent("com.audlabs.viperfx.UPDATE"));
            context.startActivity(new Intent(context, MainActivity.class));
            ((Activity) context).finish();
            return;
        }
        CharSequence[] charSequenceArr = new String[]{context.getResources().getString(2131099803), context.getResources().getString(2131099825), context.getResources().getString(2131099774), context.getResources().getString(2131099838)};
        ad adVar = new ad(context);
        adVar.a(2131099818).a(charSequenceArr, new n(str, context)).b(context.getResources().getString(2131099775), new m());
        adVar.b().show();
    }

    public static boolean e(Context context) {
        return !context.getSharedPreferences("com.audlabs.viperfx.settings", 0).getBoolean("viper4android.settings.onlineactive", false);
    }

    public static void f(Context context) {
        Editor edit = context.getSharedPreferences("com.audlabs.viperfx.settings", 0).edit();
        if (edit != null) {
            edit.putBoolean("viper4android.settings.onlineactive", true);
            edit.apply();
        }
    }

    public static void g(Context context) {
        File file = new File(d.f());
        file.mkdirs();
        Log.i("ViPER4Android", "Saving preset to " + file.getAbsolutePath());
        File[] listFiles = file.listFiles(new f());
        CharSequence[] charSequenceArr = new String[(listFiles != null ? listFiles.length + 1 : 1)];
        charSequenceArr[0] = context.getString(2131099812);
        if (listFiles != null) {
            for (int i = 0; i < listFiles.length; i++) {
                charSequenceArr[i + 1] = listFiles[i].getName();
            }
        }
        ad adVar = new ad(context);
        adVar.a(2131099821).a(charSequenceArr, new g(context, charSequenceArr));
        adVar.b().show();
    }

    public static void h(Context context) {
        int i = 0;
        File file = new File(d.f());
        file.mkdirs();
        ArrayList a = com.audlabs.viperfx.b.e.a(d.f());
        File[] listFiles = file.listFiles(new k());
        if (listFiles != null) {
            for (File name : listFiles) {
                a.add(name.getName());
            }
        }
        CharSequence[] charSequenceArr = new String[a.size()];
        while (i < a.size()) {
            charSequenceArr[i] = (String) a.get(i);
            i++;
        }
        ad adVar = new ad(context);
        adVar.a(2131099808).a(charSequenceArr, new l(context, charSequenceArr));
        adVar.b().show();
    }

    private static void i(Context context) {
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            Editor edit = context.getSharedPreferences("com.audlabs.viperfx.settings", 0).edit();
            if (edit != null) {
                edit.putString("viper4android.settings.lastversion", str);
                edit.apply();
            }
        } catch (NameNotFoundException e) {
        }
    }
}
