package com.audlabs.viperfx.base;

import android.util.Log;
import com.stericson.roottools.a;
import com.stericson.roottools.a.b;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.concurrent.TimeoutException;

public class c {
    private final boolean a = false;
    private ArrayList b = new ArrayList();

    public void a() {
        this.b.clear();
        try {
            InputStream fileInputStream = new FileInputStream("/system/build.prop");
            Reader inputStreamReader = new InputStreamReader(fileInputStream, "ASCII");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    bufferedReader.close();
                    inputStreamReader.close();
                    fileInputStream.close();
                    return;
                }
                this.b.add(readLine);
            }
        } catch (FileNotFoundException e) {
            Log.i("ViPER4Android", "/system/build.prop not found");
        } catch (UnsupportedEncodingException e2) {
        } catch (IOException e3) {
        }
    }

    public void a(String str, String str2) {
        int i = 0;
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            String trim = ((String) this.b.get(i2)).trim();
            if (!(trim == null || trim.equals("") || trim.startsWith("#"))) {
                String[] split = trim.split("=");
                if (split != null && split.length == 2 && split[0] != null && str.equalsIgnoreCase(split[0])) {
                    split[1] = str2;
                    this.b.set(i2, split[0] + "=" + split[1]);
                    i = 1;
                }
            }
        }
        if (i == 0) {
            this.b.add(str + "=" + str2);
        }
    }

    public boolean a(String str) {
        for (int i = 0; i < this.b.size(); i++) {
            String trim = ((String) this.b.get(i)).trim();
            if (!(trim == null || trim.equals("") || trim.startsWith("#"))) {
                String[] split = trim.split("=");
                if (split != null && split.length == 2 && split[0] != null && str.equalsIgnoreCase(split[0])) {
                    return true;
                }
            }
        }
        return false;
    }

    public String b(String str) {
        for (int i = 0; i < this.b.size(); i++) {
            String trim = ((String) this.b.get(i)).trim();
            if (!(trim == null || trim.equals("") || trim.startsWith("#"))) {
                String[] split = trim.split("=");
                if (split != null && split.length == 2 && split[0] != null && str.equalsIgnoreCase(split[0])) {
                    return split[1] == null ? "" : split[1];
                }
            }
        }
        return "";
    }

    public void c(String str) {
        if (this.b.size() < 28) {
            Log.i("ViPER4Android", "[Commit build.prop] mBuildPropContent.size() < 28");
            return;
        }
        String str2 = str + "tmp_buildprop";
        String str3 = "/system/build.prop";
        try {
            String str4;
            OutputStream fileOutputStream = new FileOutputStream(str2);
            Writer outputStreamWriter = new OutputStreamWriter(fileOutputStream, "ASCII");
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            for (int i = 0; i < this.b.size(); i++) {
                str4 = (String) this.b.get(i);
                if (str4 == null || str4.equals("")) {
                    bufferedWriter.write("\n");
                } else {
                    bufferedWriter.write(str4 + "\n");
                }
            }
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStreamWriter.close();
            fileOutputStream.close();
            if (a.d()) {
                if (a.a("chmod")) {
                    str4 = "chmod";
                } else if (a.a("busybox") && a.a("chmod", "busybox")) {
                    str4 = "busybox chmod";
                } else if (a.a("toolbox") && a.a("chmod", "toolbox")) {
                    str4 = "toolbox chmod";
                } else {
                    Log.i("ViPER4Android", "[Commit build.prop] chmod not found");
                    new File(str2).delete();
                    return;
                }
                if (!a.b("/system", "RW")) {
                    Log.i("ViPER4Android", "[Commit build.prop] remount /system failed");
                    new File(str2).delete();
                    return;
                } else if (!a.a(str3, false)) {
                    Log.i("ViPER4Android", "[Commit build.prop] can not delete old file");
                    new File(str2).delete();
                    return;
                } else if (a.a(str2, str3, false, false)) {
                    new File(str2).delete();
                    try {
                        a.a(true).a(new com.stericson.rootshell.b.a(0, str4 + " 644 " + str3));
                    } catch (IOException e) {
                    } catch (TimeoutException e2) {
                    } catch (com.stericson.rootshell.a.a e3) {
                    }
                    b e4 = a.e(str3);
                    if (e4.c() != 644) {
                        Log.e("ViPER4Android", "[Commit build.prop] chmod failed, permission of build.prop is " + e4.c());
                        return;
                    } else {
                        Log.i("ViPER4Android", "[Commit build.prop] build.prop updated");
                        return;
                    }
                } else {
                    Log.i("ViPER4Android", "[Commit build.prop] can not copy file");
                    new File(str2).delete();
                    return;
                }
            }
            Log.i("ViPER4Android", "[Commit build.prop] no root permission");
            new File(str2).delete();
        } catch (FileNotFoundException e5) {
            Log.i("ViPER4Android", str2 + " not found");
        } catch (UnsupportedEncodingException e6) {
            Log.i("ViPER4Android", "ASCII encoding unsupported");
            new File(str2).delete();
        } catch (IOException e7) {
            Log.i("ViPER4Android", "[Commit build.prop] I/O exception");
            new File(str2).delete();
        }
    }
}
