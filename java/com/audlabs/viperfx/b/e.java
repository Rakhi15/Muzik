package com.audlabs.viperfx.b;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import android.util.Log;
import com.audlabs.viperfx.base.c;
import com.stericson.rootshell.a;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import me.imid.swipebacklayout.lib.f;

public class e {
    public static int a(Context context, String str) {
        int b = b(context, str);
        switch (b) {
            case f.View_android_theme /*0*/:
            case f.View_android_focusable /*1*/:
            case f.View_paddingStart /*2*/:
            case f.View_paddingEnd /*3*/:
            case f.View_theme /*4*/:
                return b;
            case f.Toolbar_contentInsetStart /*5*/:
            case f.Toolbar_contentInsetEnd /*6*/:
                return 6;
            default:
                return 6;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int a(java.lang.String r13, java.lang.String r14) {
        /*
        r1 = 1;
        r3 = 0;
        r0 = "ViPER4Android";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r4 = "Editing audio configuration, input = ";
        r2 = r2.append(r4);
        r2 = r2.append(r13);
        r4 = ", output = ";
        r2 = r2.append(r4);
        r2 = r2.append(r14);
        r2 = r2.toString();
        android.util.Log.i(r0, r2);
        r4 = b(r13);	 Catch:{ Exception -> 0x00d4 }
        r6 = 32;
        r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r0 >= 0) goto L_0x0030;
    L_0x002e:
        r0 = 5;
    L_0x002f:
        return r0;
    L_0x0030:
        r0 = new java.io.File;	 Catch:{ Exception -> 0x00d4 }
        r0.<init>(r14);	 Catch:{ Exception -> 0x00d4 }
        r0.delete();	 Catch:{ Exception -> 0x00d4 }
        r6 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x00d4 }
        r6.<init>(r13);	 Catch:{ Exception -> 0x00d4 }
        r7 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x00d4 }
        r7.<init>(r14);	 Catch:{ Exception -> 0x00d4 }
        r8 = new java.io.InputStreamReader;	 Catch:{ Exception -> 0x00d4 }
        r0 = "ASCII";
        r8.<init>(r6, r0);	 Catch:{ Exception -> 0x00d4 }
        r9 = new java.io.OutputStreamWriter;	 Catch:{ Exception -> 0x00d4 }
        r0 = "ASCII";
        r9.<init>(r7, r0);	 Catch:{ Exception -> 0x00d4 }
        r10 = new java.io.BufferedReader;	 Catch:{ Exception -> 0x00d4 }
        r10.<init>(r8);	 Catch:{ Exception -> 0x00d4 }
        r11 = new java.io.BufferedWriter;	 Catch:{ Exception -> 0x00d4 }
        r11.<init>(r9);	 Catch:{ Exception -> 0x00d4 }
        r0 = (int) r4;	 Catch:{ Exception -> 0x00d4 }
        r0 = r0 + 1;
        r10.mark(r0);	 Catch:{ Exception -> 0x00d4 }
    L_0x0060:
        r0 = r10.readLine();	 Catch:{ Exception -> 0x00d4 }
        if (r0 != 0) goto L_0x0089;
    L_0x0066:
        r0 = r3;
    L_0x0067:
        if (r0 == 0) goto L_0x00f4;
    L_0x0069:
        r10.reset();	 Catch:{ Exception -> 0x00d4 }
    L_0x006c:
        r0 = r10.readLine();	 Catch:{ Exception -> 0x00d4 }
        if (r0 != 0) goto L_0x00bd;
    L_0x0072:
        r11.flush();	 Catch:{ Exception -> 0x00d4 }
        r10.close();	 Catch:{ Exception -> 0x00d4 }
        r8.close();	 Catch:{ Exception -> 0x00d4 }
        r6.close();	 Catch:{ Exception -> 0x00d4 }
        r11.close();	 Catch:{ Exception -> 0x00d4 }
        r9.close();	 Catch:{ Exception -> 0x00d4 }
        r7.close();	 Catch:{ Exception -> 0x00d4 }
        r0 = r3;
        goto L_0x002f;
    L_0x0089:
        r2 = r0.trim();	 Catch:{ Exception -> 0x00d4 }
        r4 = "#";
        r2 = r2.startsWith(r4);	 Catch:{ Exception -> 0x00d4 }
        if (r2 != 0) goto L_0x0060;
    L_0x0095:
        r2 = java.util.Locale.US;	 Catch:{ Exception -> 0x00d4 }
        r2 = r0.toLowerCase(r2);	 Catch:{ Exception -> 0x00d4 }
        r4 = "41d3c987-e6cf-11e3-a88a-11aba5d5c51b";
        r2 = r2.contains(r4);	 Catch:{ Exception -> 0x00d4 }
        if (r2 == 0) goto L_0x0060;
    L_0x00a3:
        r2 = "ViPER4Android";
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00d4 }
        r4.<init>();	 Catch:{ Exception -> 0x00d4 }
        r5 = "Source file has been modified, line = ";
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x00d4 }
        r0 = r4.append(r0);	 Catch:{ Exception -> 0x00d4 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x00d4 }
        android.util.Log.i(r2, r0);	 Catch:{ Exception -> 0x00d4 }
        r0 = r1;
        goto L_0x0067;
    L_0x00bd:
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00d4 }
        r1.<init>();	 Catch:{ Exception -> 0x00d4 }
        r0 = r1.append(r0);	 Catch:{ Exception -> 0x00d4 }
        r1 = "\n";
        r0 = r0.append(r1);	 Catch:{ Exception -> 0x00d4 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x00d4 }
        r11.write(r0);	 Catch:{ Exception -> 0x00d4 }
        goto L_0x006c;
    L_0x00d4:
        r0 = move-exception;
        r1 = "ViPER4Android";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "Error: ";
        r2 = r2.append(r3);
        r0 = r0.getMessage();
        r0 = r2.append(r0);
        r0 = r0.toString();
        android.util.Log.i(r1, r0);
        r0 = 3;
        goto L_0x002f;
    L_0x00f4:
        r10.reset();	 Catch:{ Exception -> 0x00d4 }
        r0 = r3;
        r2 = r3;
    L_0x00f9:
        r4 = r10.readLine();	 Catch:{ Exception -> 0x00d4 }
        if (r4 != 0) goto L_0x011b;
    L_0x00ff:
        r11.flush();	 Catch:{ Exception -> 0x00d4 }
        r10.close();	 Catch:{ Exception -> 0x00d4 }
        r8.close();	 Catch:{ Exception -> 0x00d4 }
        r6.close();	 Catch:{ Exception -> 0x00d4 }
        r11.close();	 Catch:{ Exception -> 0x00d4 }
        r9.close();	 Catch:{ Exception -> 0x00d4 }
        r7.close();	 Catch:{ Exception -> 0x00d4 }
        if (r2 == 0) goto L_0x01c6;
    L_0x0116:
        if (r0 == 0) goto L_0x01c6;
    L_0x0118:
        r0 = r3;
        goto L_0x002f;
    L_0x011b:
        r5 = r4.trim();	 Catch:{ Exception -> 0x00d4 }
        r12 = "#";
        r5 = r5.startsWith(r12);	 Catch:{ Exception -> 0x00d4 }
        if (r5 == 0) goto L_0x013e;
    L_0x0127:
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00d4 }
        r5.<init>();	 Catch:{ Exception -> 0x00d4 }
        r4 = r5.append(r4);	 Catch:{ Exception -> 0x00d4 }
        r5 = "\n";
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x00d4 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x00d4 }
        r11.write(r4);	 Catch:{ Exception -> 0x00d4 }
        goto L_0x00f9;
    L_0x013e:
        r5 = r4.trim();	 Catch:{ Exception -> 0x00d4 }
        r12 = "libraries {";
        r5 = r5.equalsIgnoreCase(r12);	 Catch:{ Exception -> 0x00d4 }
        if (r5 == 0) goto L_0x0173;
    L_0x014a:
        if (r2 != 0) goto L_0x0173;
    L_0x014c:
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00d4 }
        r2.<init>();	 Catch:{ Exception -> 0x00d4 }
        r2 = r2.append(r4);	 Catch:{ Exception -> 0x00d4 }
        r4 = "\n";
        r2 = r2.append(r4);	 Catch:{ Exception -> 0x00d4 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x00d4 }
        r11.write(r2);	 Catch:{ Exception -> 0x00d4 }
        r2 = "  v4a_fx {\n";
        r11.write(r2);	 Catch:{ Exception -> 0x00d4 }
        r2 = "    path /system/lib/soundfx/libv4a_fx_ics.so\n";
        r11.write(r2);	 Catch:{ Exception -> 0x00d4 }
        r2 = "  }\n";
        r11.write(r2);	 Catch:{ Exception -> 0x00d4 }
        r2 = r1;
        goto L_0x00f9;
    L_0x0173:
        r5 = r4.trim();	 Catch:{ Exception -> 0x00d4 }
        r12 = "effects {";
        r5 = r5.equalsIgnoreCase(r12);	 Catch:{ Exception -> 0x00d4 }
        if (r5 == 0) goto L_0x01ae;
    L_0x017f:
        if (r0 != 0) goto L_0x01ae;
    L_0x0181:
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00d4 }
        r0.<init>();	 Catch:{ Exception -> 0x00d4 }
        r0 = r0.append(r4);	 Catch:{ Exception -> 0x00d4 }
        r4 = "\n";
        r0 = r0.append(r4);	 Catch:{ Exception -> 0x00d4 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x00d4 }
        r11.write(r0);	 Catch:{ Exception -> 0x00d4 }
        r0 = "  v4a_standard_fx {\n";
        r11.write(r0);	 Catch:{ Exception -> 0x00d4 }
        r0 = "    library v4a_fx\n";
        r11.write(r0);	 Catch:{ Exception -> 0x00d4 }
        r0 = "    uuid 41d3c987-e6cf-11e3-a88a-11aba5d5c51b\n";
        r11.write(r0);	 Catch:{ Exception -> 0x00d4 }
        r0 = "  }\n";
        r11.write(r0);	 Catch:{ Exception -> 0x00d4 }
        r0 = r1;
        goto L_0x00f9;
    L_0x01ae:
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00d4 }
        r5.<init>();	 Catch:{ Exception -> 0x00d4 }
        r4 = r5.append(r4);	 Catch:{ Exception -> 0x00d4 }
        r5 = "\n";
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x00d4 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x00d4 }
        r11.write(r4);	 Catch:{ Exception -> 0x00d4 }
        goto L_0x00f9;
    L_0x01c6:
        r0 = 4;
        goto L_0x002f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.audlabs.viperfx.b.e.a(java.lang.String, java.lang.String):int");
    }

    public static ArrayList a(String str) {
        try {
            File file = new File(str);
            ArrayList arrayList = new ArrayList();
            a(file, ".prf", arrayList);
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(c(str + ((String) it.next())).trim());
            }
            return arrayList2;
        } catch (Exception e) {
            return new ArrayList();
        }
    }

    public static void a(File file, String str, ArrayList arrayList) {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File a : listFiles) {
                    a(a, str, arrayList);
                }
                return;
            }
            return;
        }
        String absolutePath = file.getAbsolutePath();
        absolutePath = absolutePath.substring(absolutePath.lastIndexOf("/") + 1);
        if (absolutePath.toLowerCase(Locale.US).endsWith(str)) {
            arrayList.add(absolutePath);
        }
    }

    public static boolean a() {
        return a.b("toybox").size() > 0;
    }

    public static boolean a(Context context) {
        boolean e = com.stericson.roottools.a.e();
        if (!(e || a())) {
            Builder builder = new Builder(context);
            builder.setTitle("ViPERFX");
            builder.setMessage(context.getResources().getString(2131099814));
            builder.setPositiveButton(context.getResources().getString(2131099816), new f(context));
            builder.setNegativeButton(context.getResources().getString(2131099775), new g());
            builder.show();
        }
        return e;
    }

    public static boolean a(Context context, String str, String str2) {
        String c = c(context);
        if (c.equals("")) {
            return false;
        }
        c = c + "/" + str2;
        try {
            File file = new File(c);
            if (file.exists()) {
                file.delete();
            }
            OutputStream fileOutputStream = new FileOutputStream(c);
            InputStream open = context.getAssets().open(str);
            byte[] bArr = new byte[4096];
            while (true) {
                int read = open.read(bArr);
                if (read > 0) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.flush();
                    open.close();
                    fileOutputStream.close();
                    return true;
                }
            }
        } catch (Exception e) {
            Log.i("ViPER4Android", "CopyAssetsToLocal() failed, msg = " + e.getMessage());
            return false;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(java.lang.String r8, java.lang.String r9, java.lang.String r10) {
        /*
        r1 = 0;
        r0 = r9.trim();
        r2 = new java.io.FileInputStream;	 Catch:{ FileNotFoundException -> 0x003f, UnsupportedEncodingException -> 0x0042, IOException -> 0x0045 }
        r2.<init>(r8);	 Catch:{ FileNotFoundException -> 0x003f, UnsupportedEncodingException -> 0x0042, IOException -> 0x0045 }
        r3 = new java.io.InputStreamReader;	 Catch:{ FileNotFoundException -> 0x003f, UnsupportedEncodingException -> 0x0042, IOException -> 0x0045 }
        r3.<init>(r2, r10);	 Catch:{ FileNotFoundException -> 0x003f, UnsupportedEncodingException -> 0x0042, IOException -> 0x0045 }
        r4 = new java.io.BufferedReader;	 Catch:{ FileNotFoundException -> 0x003f, UnsupportedEncodingException -> 0x0042, IOException -> 0x0045 }
        r4.<init>(r3);	 Catch:{ FileNotFoundException -> 0x003f, UnsupportedEncodingException -> 0x0042, IOException -> 0x0045 }
    L_0x0014:
        r5 = r4.readLine();	 Catch:{ FileNotFoundException -> 0x003f, UnsupportedEncodingException -> 0x0042, IOException -> 0x0045 }
        if (r5 != 0) goto L_0x0025;
    L_0x001a:
        r0 = r1;
    L_0x001b:
        r4.close();	 Catch:{ FileNotFoundException -> 0x003f, UnsupportedEncodingException -> 0x0042, IOException -> 0x0045 }
        r3.close();	 Catch:{ FileNotFoundException -> 0x003f, UnsupportedEncodingException -> 0x0042, IOException -> 0x0045 }
        r2.close();	 Catch:{ FileNotFoundException -> 0x003f, UnsupportedEncodingException -> 0x0042, IOException -> 0x0045 }
    L_0x0024:
        return r0;
    L_0x0025:
        r6 = r5.trim();	 Catch:{ FileNotFoundException -> 0x003f, UnsupportedEncodingException -> 0x0042, IOException -> 0x0045 }
        r7 = "#";
        r6 = r6.startsWith(r7);	 Catch:{ FileNotFoundException -> 0x003f, UnsupportedEncodingException -> 0x0042, IOException -> 0x0045 }
        if (r6 != 0) goto L_0x0014;
    L_0x0031:
        r6 = java.util.Locale.US;	 Catch:{ FileNotFoundException -> 0x003f, UnsupportedEncodingException -> 0x0042, IOException -> 0x0045 }
        r5 = r5.toLowerCase(r6);	 Catch:{ FileNotFoundException -> 0x003f, UnsupportedEncodingException -> 0x0042, IOException -> 0x0045 }
        r5 = r5.contains(r0);	 Catch:{ FileNotFoundException -> 0x003f, UnsupportedEncodingException -> 0x0042, IOException -> 0x0045 }
        if (r5 == 0) goto L_0x0014;
    L_0x003d:
        r0 = 1;
        goto L_0x001b;
    L_0x003f:
        r0 = move-exception;
        r0 = r1;
        goto L_0x0024;
    L_0x0042:
        r0 = move-exception;
        r0 = r1;
        goto L_0x0024;
    L_0x0045:
        r0 = move-exception;
        r0 = r1;
        goto L_0x0024;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.audlabs.viperfx.b.e.a(java.lang.String, java.lang.String, java.lang.String):boolean");
    }

    public static boolean a(String str, String str2, String str3, Context context) {
        try {
            String str4;
            File file = new File(str2);
            ArrayList arrayList = new ArrayList();
            a(file, ".prf", arrayList);
            String str5 = "";
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                str4 = str2 + ((String) it.next());
                if (str.trim().equalsIgnoreCase(c(str4).trim())) {
                    break;
                }
            }
            str4 = str5;
            if (str4.equals("")) {
                return false;
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences(str3, 0);
            if (sharedPreferences == null) {
                return false;
            }
            InputStream fileInputStream = new FileInputStream(str4);
            Reader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            Editor edit = sharedPreferences.edit();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    edit.apply();
                    bufferedReader.close();
                    inputStreamReader.close();
                    fileInputStream.close();
                    return true;
                } else if (!readLine.startsWith("#")) {
                    String[] split = readLine.split("=");
                    if (split.length != 3) {
                        continue;
                    } else if (split[1].trim().equalsIgnoreCase("boolean")) {
                        edit.putBoolean(split[0], Boolean.valueOf(split[2]).booleanValue());
                    } else if (split[1].trim().equalsIgnoreCase("string")) {
                        edit.putString(split[0], split[2]);
                    }
                }
            }
        } catch (Exception e) {
            Log.i("ViPER4Android", "loadProfile Error: " + e.getMessage());
            return false;
        }
    }

    private static int b(Context context, String str) {
        if (!Environment.getExternalStorageState().equals("mounted")) {
            return 2;
        }
        if (!a(context, str, "libv4a_fx_ics.so")) {
            return 3;
        }
        if (d()) {
            a(context, "91-v4a.sh", "91-v4a.sh");
            int i = 1;
        } else {
            boolean z = false;
        }
        if (!com.stericson.roottools.a.d()) {
            return 1;
        }
        String str2;
        String str3;
        String str4;
        boolean b;
        if (com.stericson.roottools.a.a("chmod")) {
            str2 = "chmod";
        } else if (com.stericson.roottools.a.a("toybox") && com.stericson.roottools.a.a("chmod", "toybox")) {
            str2 = "toybox chmod";
        } else if (com.stericson.roottools.a.a("busybox") && com.stericson.roottools.a.a("chmod", "busybox")) {
            str2 = "busybox chmod";
        } else if (!com.stericson.roottools.a.a("toolbox") || !com.stericson.roottools.a.a("chmod", "toolbox")) {
            return 5;
        } else {
            str2 = "toolbox chmod";
        }
        String str5 = d.b() + "v4a_audio_system.conf";
        String str6 = d.b() + "v4a_audio_vendor.conf";
        int a = 1 & a("/system/etc/audio_effects.conf", "41d3c987-e6cf-11e3-a88a-11aba5d5c51b", "ASCII");
        boolean b2 = com.stericson.roottools.a.b("/system/vendor/etc/audio_effects.conf");
        int a2 = b2 ? a & a("/system/vendor/etc/audio_effects.conf", "41d3c987-e6cf-11e3-a88a-11aba5d5c51b", "ASCII") : a;
        if (a2 == 0) {
            if (b2) {
                com.stericson.roottools.a.a("/system/etc/audio_effects.conf", str5, false, false);
                com.stericson.roottools.a.a("/system/vendor/etc/audio_effects.conf", str6, false, false);
            } else {
                com.stericson.roottools.a.a("/system/etc/audio_effects.conf", str5, false, false);
            }
            a = a(str5, str5 + ".out");
            int a3 = b2 ? a(str6, str6 + ".out") : 0;
            if (!(a == 0 && a3 == 0)) {
                if (b2) {
                    try {
                        if (!com.stericson.roottools.a.a(str5, false)) {
                            new File(str5).delete();
                        }
                        if (!com.stericson.roottools.a.a(str6, false)) {
                            new File(str6).delete();
                        }
                        if (!com.stericson.roottools.a.a(str5 + ".out", false)) {
                            new File(str5 + ".out").delete();
                        }
                        if (!com.stericson.roottools.a.a(str6 + ".out", false)) {
                            new File(str6 + ".out").delete();
                        }
                    } catch (Exception e) {
                        return a != 0 ? a : a3;
                    }
                } else {
                    if (!com.stericson.roottools.a.a(str5, false)) {
                        new File(str5).delete();
                    }
                    if (!com.stericson.roottools.a.a(str5 + ".out", false)) {
                        new File(str5 + ".out").delete();
                    }
                }
                com.stericson.roottools.a.a();
                return a != 0 ? a : a3;
            }
        }
        String c = c(context);
        if (c.endsWith("/")) {
            str3 = c + "libv4a_fx_ics.so";
            if (i != 0) {
                str4 = str3;
                str3 = c + "91-v4a.sh";
            }
            str4 = str3;
            str3 = c;
        } else {
            str3 = c + "/libv4a_fx_ics.so";
            if (i != 0) {
                str4 = str3;
                str3 = c + "/91-v4a.sh";
            }
            str4 = str3;
            str3 = c;
        }
        if (b2) {
            try {
                b = com.stericson.roottools.a.b("/system", "RW");
                if (b) {
                    b = com.stericson.roottools.a.a(str4, "/system/lib/soundfx/libv4a_fx_ics.so", false, false);
                }
                if (a2 == 0) {
                    if (b) {
                        b = com.stericson.roottools.a.a(str5 + ".out", "/system/etc/audio_effects.conf", false, false);
                    }
                    if (b) {
                        b = com.stericson.roottools.a.a(str6 + ".out", "/system/vendor/etc/audio_effects.conf", false, false);
                    }
                }
                if (b && i != 0) {
                    b = com.stericson.roottools.a.a(str3, "/system/addon.d/91-v4a.sh", false, false);
                }
                if (a2 == 0) {
                    com.stericson.roottools.a.a(true).a(new com.stericson.rootshell.b.a(0, str2 + " 644 /system/etc/audio_effects.conf", str2 + " 644 /system/vendor/etc/audio_effects.conf", str2 + " 644 /system/lib/soundfx/libv4a_fx_ics.so"));
                } else {
                    com.stericson.roottools.a.a(true).a(new com.stericson.rootshell.b.a(0, str2 + " 644 /system/lib/soundfx/libv4a_fx_ics.so"));
                }
                if (i != 0) {
                    com.stericson.roottools.a.a(true).a(new com.stericson.rootshell.b.a(0, str2 + " 644 /system/addon.d/91-v4a.sh"));
                }
                com.stericson.roottools.a.b("/system", "RO");
                z = b;
            } catch (Exception e2) {
                Log.i("ViPER4Android", "Failed to copy back to /system, msg = " + e2.getMessage());
                b = false;
            }
        } else {
            b = com.stericson.roottools.a.b("/system", "RW");
            if (b) {
                b = com.stericson.roottools.a.a(str4, "/system/lib/soundfx/libv4a_fx_ics.so", false, false);
            }
            if (a2 == 0 && r1) {
                b = com.stericson.roottools.a.a(str5 + ".out", "/system/etc/audio_effects.conf", false, false);
            }
            if (b && i != 0) {
                b = com.stericson.roottools.a.a(str3, "/system/addon.d/91-v4a.sh", false, false);
            }
            if (a2 == 0) {
                com.stericson.roottools.a.a(true).a(new com.stericson.rootshell.b.a(0, str2 + " 644 /system/etc/audio_effects.conf", str2 + " 644 /system/lib/soundfx/libv4a_fx_ics.so"));
            } else {
                com.stericson.roottools.a.a(true).a(new com.stericson.rootshell.b.a(0, str2 + " 644 /system/lib/soundfx/libv4a_fx_ics.so"));
            }
            if (i != 0) {
                com.stericson.roottools.a.a(true).a(new com.stericson.rootshell.b.a(0, str2 + " 644 /system/addon.d/91-v4a.sh"));
            }
            com.stericson.roottools.a.b("/system", "RO");
            z = b;
        }
        b = z;
        if (a2 == 0) {
            if (b2) {
                try {
                    if (!com.stericson.roottools.a.a(str5, false)) {
                        new File(str5).delete();
                    }
                    if (!com.stericson.roottools.a.a(str6, false)) {
                        new File(str6).delete();
                    }
                    if (!com.stericson.roottools.a.a(str5 + ".out", false)) {
                        new File(str5 + ".out").delete();
                    }
                    if (!com.stericson.roottools.a.a(str6 + ".out", false)) {
                        new File(str6 + ".out").delete();
                    }
                } catch (Exception e22) {
                    Log.i("ViPER4Android", "Copy back to /system cleanup failed, msg = " + e22.getMessage());
                    return !b ? 6 : 0;
                }
            } else {
                if (!com.stericson.roottools.a.a(str5, false)) {
                    new File(str5).delete();
                }
                if (!com.stericson.roottools.a.a(str5 + ".out", false)) {
                    new File(str5 + ".out").delete();
                }
            }
        }
        com.stericson.roottools.a.a();
        return 0;
    }

    private static long b(String str) {
        return !new File(str).isFile() ? 0 : new File(str).length();
    }

    public static void b() {
        if (com.stericson.roottools.a.d()) {
            String str = "/system/lib/soundfx/libv4a_fx_ics.so";
            try {
                if (com.stericson.roottools.a.b(str)) {
                    com.stericson.roottools.a.a(str, true);
                    if (com.stericson.roottools.a.b("/system/addon.d/91-v4a.sh")) {
                        com.stericson.roottools.a.a("/system/addon.d/91-v4a.sh", true);
                    }
                }
                com.stericson.roottools.a.a();
            } catch (IOException e) {
                Log.i("ViPER4Android", "Driver uninstall failed, msg = " + e.getMessage());
            }
        }
    }

    public static void b(Context context) {
        String str = "lpa.decode";
        str = "lpa.use.stagefright";
        str = "tunnel.decode";
        ArrayList arrayList = new ArrayList();
        c cVar = new c();
        cVar.a();
        if (cVar.a("lpa.decode")) {
            if (cVar.b("lpa.decode").equalsIgnoreCase("true")) {
                Log.i("ViPER4Android", "[LPA] lpa.decode = true");
                arrayList.add("lpa.decode");
            } else {
                Log.i("ViPER4Android", "[LPA] lpa.decode = false");
            }
        }
        if (cVar.a("lpa.use.stagefright")) {
            if (cVar.b("lpa.use.stagefright").equalsIgnoreCase("true")) {
                Log.i("ViPER4Android", "[LPA] lpa.use.stagefright = true");
                arrayList.add("lpa.use.stagefright");
            } else {
                Log.i("ViPER4Android", "[LPA] lpa.use.stagefright = false");
            }
        }
        if (cVar.a("tunnel.decode")) {
            if (cVar.b("tunnel.decode").equalsIgnoreCase("true")) {
                Log.i("ViPER4Android", "[LPA] tunnel.decode = true");
                arrayList.add("tunnel.decode");
            } else {
                Log.i("ViPER4Android", "[LPA] tunnel.decode = false");
            }
        }
        if (arrayList.isEmpty()) {
            Log.i("ViPER4Android", "LPA feature not enabled");
            return;
        }
        Builder builder = new Builder(context);
        builder.setTitle("ViPERFX");
        builder.setMessage(context.getResources().getString(2131099810));
        builder.setPositiveButton(context.getResources().getString(2131099816), new h(arrayList, cVar));
        builder.setNegativeButton(context.getResources().getString(2131099775), new i());
        builder.show();
    }

    public static String c(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext != null ? applicationContext.getFilesDir().exists() ? applicationContext.getFilesDir().getAbsolutePath() : !applicationContext.getFilesDir().mkdirs() ? "" : "" : "";
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String c(java.lang.String r7) {
        /*
        r1 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x0048 }
        r1.<init>(r7);	 Catch:{ Exception -> 0x0048 }
        r2 = new java.io.InputStreamReader;	 Catch:{ Exception -> 0x0048 }
        r0 = "UTF-8";
        r2.<init>(r1, r0);	 Catch:{ Exception -> 0x0048 }
        r3 = new java.io.BufferedReader;	 Catch:{ Exception -> 0x0048 }
        r3.<init>(r2);	 Catch:{ Exception -> 0x0048 }
        r0 = "";
    L_0x0013:
        r4 = r3.readLine();	 Catch:{ Exception -> 0x0048 }
        if (r4 != 0) goto L_0x0023;
    L_0x0019:
        r3.close();	 Catch:{ Exception -> 0x0048 }
        r2.close();	 Catch:{ Exception -> 0x0048 }
        r1.close();	 Catch:{ Exception -> 0x0048 }
    L_0x0022:
        return r0;
    L_0x0023:
        r5 = "#";
        r5 = r4.startsWith(r5);	 Catch:{ Exception -> 0x0048 }
        if (r5 != 0) goto L_0x0013;
    L_0x002b:
        r5 = "=";
        r4 = r4.split(r5);	 Catch:{ Exception -> 0x0048 }
        r5 = r4.length;	 Catch:{ Exception -> 0x0048 }
        r6 = 2;
        if (r5 != r6) goto L_0x0013;
    L_0x0035:
        r5 = 0;
        r5 = r4[r5];	 Catch:{ Exception -> 0x0048 }
        r5 = r5.trim();	 Catch:{ Exception -> 0x0048 }
        r6 = "profile_name";
        r5 = r5.equalsIgnoreCase(r6);	 Catch:{ Exception -> 0x0048 }
        if (r5 == 0) goto L_0x0013;
    L_0x0044:
        r0 = 1;
        r0 = r4[r0];	 Catch:{ Exception -> 0x0048 }
        goto L_0x0019;
    L_0x0048:
        r0 = move-exception;
        r0 = "";
        goto L_0x0022;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.audlabs.viperfx.b.e.c(java.lang.String):java.lang.String");
    }

    public static void c() {
        try {
            com.stericson.roottools.a.a(true).a(new com.stericson.rootshell.b.a(0, "setenforce 0"));
            com.stericson.roottools.a.a();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean d() {
        File file = new File("/system/addon.d/");
        return file.exists() && file.isDirectory();
    }
}
