package com.stericson.roottools.b;

import android.util.Log;
import com.stericson.rootshell.b.e;
import com.stericson.roottools.a;
import com.stericson.roottools.a.b;
import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class c {
    protected c() {
    }

    public static void a() {
        a.a(new c());
    }

    private void a(e eVar, com.stericson.rootshell.b.a aVar) {
        while (!aVar.e()) {
            a.c("RootTools v4.2", eVar.c(aVar));
            a.c("RootTools v4.2", "Processed " + aVar.g + " of " + aVar.f + " output from command.");
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
                    Log.e("RootTools v4.2", "Waiting for a command to be executed in a shell that is not executing and not reading! \n\n Command: " + aVar.c());
                    exception = new Exception();
                    exception.setStackTrace(Thread.currentThread().getStackTrace());
                    exception.printStackTrace();
                } else if (!eVar.b || eVar.c) {
                    Log.e("RootTools v4.2", "Waiting for a command to be executed in a shell that is not reading! \n\n Command: " + aVar.c());
                    exception = new Exception();
                    exception.setStackTrace(Thread.currentThread().getStackTrace());
                    exception.printStackTrace();
                } else {
                    Log.e("RootTools v4.2", "Waiting for a command to be executed in a shell that is executing but not reading! \n\n Command: " + aVar.c());
                    exception = new Exception();
                    exception.setStackTrace(Thread.currentThread().getStackTrace());
                    exception.printStackTrace();
                }
            }
        }
    }

    public b a(String str) {
        String str2 = str.split(" ")[0];
        if (str2.length() != 10 || ((str2.charAt(0) != '-' && str2.charAt(0) != 'd' && str2.charAt(0) != 'l') || ((str2.charAt(1) != '-' && str2.charAt(1) != 'r') || (str2.charAt(2) != '-' && str2.charAt(2) != 'w')))) {
            return null;
        }
        a.i(str2);
        b bVar = new b();
        bVar.b(str2.substring(0, 1));
        a.i(bVar.b());
        bVar.c(str2.substring(1, 4));
        a.i(bVar.d());
        bVar.d(str2.substring(4, 7));
        a.i(bVar.e());
        bVar.e(str2.substring(7, 10));
        a.i(bVar.f());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(c(str2));
        stringBuilder.append(b(bVar.d()));
        stringBuilder.append(b(bVar.e()));
        stringBuilder.append(b(bVar.f()));
        bVar.a(Integer.parseInt(stringBuilder.toString()));
        return bVar;
    }

    public void a(String str, String str2) {
        try {
            a.b("/system", "rw");
            List<String> b = com.stericson.rootshell.a.b(str);
            if (b.size() > 0) {
                for (String str3 : b) {
                    com.stericson.rootshell.b.a aVar = new com.stericson.rootshell.b.a(0, false, str2 + " rm " + str3 + "/" + str);
                    com.stericson.rootshell.a.a(true).a(aVar);
                    a(com.stericson.rootshell.a.a(true), aVar);
                }
                com.stericson.rootshell.b.a aVar2 = new com.stericson.rootshell.b.a(0, false, str2 + " ln -s " + str2 + " /system/bin/" + str, str2 + " chmod 0755 /system/bin/" + str);
                com.stericson.rootshell.a.a(true).a(aVar2);
                a(com.stericson.rootshell.a.a(true), aVar2);
            }
            a.b("/system", "ro");
        } catch (Exception e) {
        }
    }

    public boolean a(String str, String str2, boolean z, boolean z2) {
        com.stericson.rootshell.b.a aVar;
        boolean z3;
        Exception e;
        if (z) {
            a.b(str2, "RW");
        }
        if (d("cp")) {
            a.i("cp command is available!");
            if (z2) {
                aVar = new com.stericson.rootshell.b.a(0, false, "cp -fp " + str + " " + str2);
                try {
                    e.h().a(aVar);
                    a(e.h(), aVar);
                    z3 = aVar.f() == 0;
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    z3 = false;
                    return aVar == null ? z3 : aVar.f() == 0;
                }
            } else {
                aVar = new com.stericson.rootshell.b.a(0, false, "cp -f " + str + " " + str2);
                e.h().a(aVar);
                a(e.h(), aVar);
                z3 = aVar.f() == 0;
            }
        } else if (d("toybox") && b("cp", "toybox")) {
            a.i("toybox cp command is available!");
            if (z2) {
                aVar = new com.stericson.rootshell.b.a(0, false, "toybox cp -fp " + str + " " + str2);
                e.h().a(aVar);
                a(e.h(), aVar);
                z3 = true;
            } else {
                aVar = new com.stericson.rootshell.b.a(0, false, "toybox cp -f " + str + " " + str2);
                e.h().a(aVar);
                a(e.h(), aVar);
                z3 = true;
            }
        } else {
            try {
                if (d("busybox") && b("cp", "busybox")) {
                    a.i("busybox cp command is available!");
                    if (z2) {
                        aVar = new com.stericson.rootshell.b.a(0, false, "busybox cp -fp " + str + " " + str2);
                        e.h().a(aVar);
                        a(e.h(), aVar);
                        z3 = true;
                    } else {
                        aVar = new com.stericson.rootshell.b.a(0, false, "busybox cp -f " + str + " " + str2);
                        e.h().a(aVar);
                        a(e.h(), aVar);
                        z3 = true;
                    }
                } else if (d("cat")) {
                    com.stericson.rootshell.b.a aVar2;
                    a.i("cp is not available, use cat!");
                    int c = z2 ? i(str).c() : -1;
                    aVar = new com.stericson.rootshell.b.a(0, false, "cat " + str + " > " + str2);
                    e.h().a(aVar);
                    a(e.h(), aVar);
                    if (z2) {
                        aVar2 = new com.stericson.rootshell.b.a(0, false, "chmod " + c + " " + str2);
                        try {
                            e.h().a(aVar2);
                            a(e.h(), aVar2);
                        } catch (Exception e3) {
                            Exception exception = e3;
                            aVar = aVar2;
                            e = exception;
                            e.printStackTrace();
                            z3 = false;
                            if (aVar == null) {
                                if (aVar.f() == 0) {
                                }
                            }
                        }
                    }
                    aVar2 = aVar;
                    aVar = aVar2;
                    z3 = true;
                } else {
                    z3 = false;
                    aVar = null;
                }
            } catch (Exception e4) {
                e = e4;
                aVar = null;
                e.printStackTrace();
                z3 = false;
                if (aVar == null) {
                }
            }
        }
        if (z) {
            a.b(str2, "RO");
        }
        if (aVar == null) {
            if (aVar.f() == 0) {
            }
        }
    }

    public boolean a(String str, boolean z) {
        boolean z2 = true;
        if (z) {
            try {
                a.b(str, "RW");
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        com.stericson.rootshell.b.a aVar;
        if (d("toybox") && b("rm", "toybox")) {
            a.i("toybox rm command is available!");
            aVar = new com.stericson.rootshell.b.a(0, false, "toybox rm -rf " + str);
            e.h().a(aVar);
            a(e.h(), aVar);
            if (aVar.f() != 0) {
                a.i("target not exist or unable to delete file");
                z2 = false;
            }
        } else if (b("rm", "toolbox")) {
            a.i("rm command is available!");
            aVar = new com.stericson.rootshell.b.a(0, false, "rm -r " + str);
            e.h().a(aVar);
            a(e.h(), aVar);
            if (aVar.f() != 0) {
                a.i("target not exist or unable to delete file");
                z2 = false;
            }
        } else if (d("busybox") && b("rm", "busybox")) {
            a.i("busybox rm command is available!");
            aVar = new com.stericson.rootshell.b.a(0, false, "busybox rm -rf " + str);
            e.h().a(aVar);
            a(e.h(), aVar);
            if (aVar.f() != 0) {
                a.i("target not exist or unable to delete file");
                z2 = false;
            }
        }
        if (z) {
            a.b(str, "RO");
        }
        return z2;
    }

    public boolean a(String[] strArr) {
        for (String str : strArr) {
            if (!d(str)) {
                if (d("toybox")) {
                    if (b(str, "toybox")) {
                        a(str, a.b);
                    }
                } else if (d("busybox")) {
                    if (b(str, "busybox")) {
                        a(str, a.b);
                    }
                } else if (!d("toolbox")) {
                    return false;
                } else {
                    if (b(str, "toolbox")) {
                        a(str, a.b);
                    }
                }
            }
        }
        return true;
    }

    public int b(String str) {
        String toLowerCase = str.toLowerCase(Locale.US);
        int i = toLowerCase.charAt(0) == 'r' ? 4 : 0;
        a.i("permission " + i);
        a.i("character " + toLowerCase.charAt(0));
        i = toLowerCase.charAt(1) == 'w' ? i + 2 : i + 0;
        a.i("permission " + i);
        a.i("character " + toLowerCase.charAt(1));
        i = (toLowerCase.charAt(2) == 'x' || toLowerCase.charAt(2) == 's' || toLowerCase.charAt(2) == 't') ? i + 1 : i + 0;
        a.i("permission " + i);
        a.i("character " + toLowerCase.charAt(2));
        return i;
    }

    public ArrayList b() {
        Throwable th;
        LineNumberReader lineNumberReader = null;
        e a = a.a(true);
        com.stericson.rootshell.b.a aVar = new com.stericson.rootshell.b.a(0, false, "cat /proc/mounts > /data/local/RootToolsMounts", "chmod 0777 /data/local/RootToolsMounts");
        a.a(aVar);
        a(a, aVar);
        FileReader fileReader;
        try {
            fileReader = new FileReader("/data/local/RootToolsMounts");
            try {
                LineNumberReader lineNumberReader2 = new LineNumberReader(fileReader);
                try {
                    ArrayList arrayList = new ArrayList();
                    while (true) {
                        String readLine = lineNumberReader2.readLine();
                        if (readLine == null) {
                            break;
                        }
                        a.i(readLine);
                        String[] split = readLine.split(" ");
                        arrayList.add(new com.stericson.roottools.a.a(new File(split[0]), new File(split[1]), split[2], split[3]));
                    }
                    a.h = arrayList;
                    if (a.h != null) {
                        arrayList = a.h;
                        try {
                            fileReader.close();
                        } catch (Exception e) {
                        }
                        try {
                            lineNumberReader2.close();
                        } catch (Exception e2) {
                        }
                        return arrayList;
                    }
                    throw new Exception();
                } catch (Throwable th2) {
                    th = th2;
                    lineNumberReader = lineNumberReader2;
                    try {
                        fileReader.close();
                    } catch (Exception e3) {
                    }
                    try {
                        lineNumberReader.close();
                    } catch (Exception e4) {
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileReader.close();
                lineNumberReader.close();
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            fileReader = null;
            fileReader.close();
            lineNumberReader.close();
            throw th;
        }
    }

    public boolean b(String str, String str2) {
        a.b = false;
        if (!str2.endsWith("toolbox") && !str2.endsWith("busybox") && !str2.endsWith("toybox")) {
            return false;
        }
        try {
            String[] strArr = new String[1];
            strArr[0] = str2.endsWith("toolbox") ? str2 + " " + str : str2 + " --list";
            com.stericson.rootshell.b.a jVar = new j(this, 0, false, strArr, str2, str);
            a.a(true).a(jVar);
            a(a.a(true), jVar);
            if (a.b) {
                a.i("Box contains " + str + " util!");
                return true;
            }
            a.i("Box does not contain " + str + " util!");
            return false;
        } catch (Exception e) {
            a.i(e.getMessage());
            return false;
        }
    }

    public int c(String str) {
        int i = 0;
        if (str.charAt(2) == 's') {
            i = 4;
        }
        if (str.charAt(5) == 's') {
            i += 2;
        }
        if (str.charAt(8) == 't') {
            i++;
        }
        a.i("special permissions " + i);
        return i;
    }

    public boolean d(String str) {
        List<String> b = com.stericson.rootshell.a.b(str);
        if (b.size() > 0) {
            for (String str2 : b) {
                b e = a.e(str2 + "/" + str);
                if (e != null) {
                    String substring = Integer.toString(e.c()).length() > 3 ? Integer.toString(e.c()).substring(1) : Integer.toString(e.c());
                    if (substring.equals("755") || substring.equals("777") || substring.equals("775")) {
                        a.b = str2 + "/" + str;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public List e(String str) {
        if (str != null && !str.endsWith("/") && !str.equals("")) {
            str = str + "/";
        } else if (str == null) {
            throw new Exception("Path is null, please specifiy a path");
        }
        List arrayList = new ArrayList();
        com.stericson.rootshell.b.a dVar = new d(this, 3, false, new String[]{str + "busybox --list"}, arrayList);
        com.stericson.rootshell.a.a(false).a(dVar);
        a(com.stericson.rootshell.a.a(false), dVar);
        if (arrayList.size() <= 0) {
            com.stericson.rootshell.a.a(true).a(dVar);
            a(com.stericson.rootshell.a.a(true), dVar);
        }
        return arrayList;
    }

    public String f(String str) {
        if (!(str.equals("") || str.endsWith("/"))) {
            str = str + "/";
        }
        a.f = "";
        try {
            com.stericson.rootshell.b.a eVar = new e(this, 4, false, str + "busybox");
            a.i("Getting BusyBox Version without root");
            e a = a.a(false);
            a.a(eVar);
            a(a, eVar);
            if (a.f.length() <= 0) {
                a.i("Getting BusyBox Version with root");
                a = a.a(true);
                a.a(eVar);
                a(a, eVar);
            }
            return a.f;
        } catch (Exception e) {
            a.i("BusyBox was not found, more information MAY be available with Debugging on.");
            return "";
        }
    }

    public long g(String str) {
        double d = 1.0d;
        try {
            StringBuffer stringBuffer = new StringBuffer();
            int i = 0;
            while (i < str.length()) {
                char charAt = str.charAt(i);
                if (Character.isDigit(charAt) || charAt == '.') {
                    stringBuffer.append(str.charAt(i));
                    i++;
                } else if (charAt == 'm' || charAt == 'M') {
                    d = 1024.0d;
                    return (long) Math.ceil(d * Double.valueOf(stringBuffer.toString()).doubleValue());
                } else {
                    if (charAt == 'g' || charAt == 'G') {
                        d = 1048576.0d;
                    }
                    return (long) Math.ceil(d * Double.valueOf(stringBuffer.toString()).doubleValue());
                }
            }
            return (long) Math.ceil(d * Double.valueOf(stringBuffer.toString()).doubleValue());
        } catch (Exception e) {
            return -1;
        }
    }

    public String h(String str) {
        try {
            com.stericson.rootshell.b.a fVar = new f(this, 5, false, "/data/local/ls -i " + str);
            e.h().a(fVar);
            a(e.h(), fVar);
            return a.i;
        } catch (Exception e) {
            return "";
        }
    }

    public b i(String str) {
        b bVar = null;
        a.i("Checking permissions for " + str);
        if (!a.b(str)) {
            return bVar;
        }
        a.i(str + " was found.");
        try {
            com.stericson.rootshell.b.a gVar = new g(this, 1, false, "ls -l " + str, "busybox ls -l " + str, "/system/bin/failsafe/toolbox ls -l " + str, "toolbox ls -l " + str);
            com.stericson.rootshell.a.a(true).a(gVar);
            a(com.stericson.rootshell.a.a(true), gVar);
            return a.j;
        } catch (Exception e) {
            a.i(e.getMessage());
            return bVar;
        }
    }

    public long j(String str) {
        int i = 0;
        a.e = str;
        a.i("Looking for Space");
        try {
            com.stericson.rootshell.b.a hVar = new h(this, 6, false, "df " + str);
            e.h().a(hVar);
            a(e.h(), hVar);
        } catch (Exception e) {
        }
        if (a.d != null) {
            a.i("First Method");
            int i2 = 0;
            for (String str2 : a.d) {
                a.i(str2);
                if (i2 != 0) {
                    return g(str2);
                }
                if (str2.equals("used,")) {
                    i2 = 1;
                }
            }
            i2 = 3;
            a.i("Second Method");
            if (a.d[0].length() <= 5) {
                i2 = 2;
            }
            String[] strArr = a.d;
            int length = strArr.length;
            int i3 = 0;
            while (i < length) {
                String str3 = strArr[i];
                a.i(str3);
                if (str3.length() > 0) {
                    a.i(str3 + "Valid");
                    if (i3 == i2) {
                        return g(str3);
                    }
                    i3++;
                }
                i++;
            }
        }
        a.i("Returning -1, space could not be determined.");
        return -1;
    }

    public String k(String str) {
        a.i("Looking for Symlink for " + str);
        try {
            List arrayList = new ArrayList();
            com.stericson.rootshell.b.a iVar = new i(this, 7, false, new String[]{"ls -l " + str}, arrayList);
            e.h().a(iVar);
            a(e.h(), iVar);
            String[] split = ((String) arrayList.get(0)).split(" ");
            if (split.length > 2 && split[split.length - 2].equals("->")) {
                a.i("Symlink found.");
                if (split[split.length - 1].equals("") || split[split.length - 1].contains("/")) {
                    return split[split.length - 1];
                }
                List b = com.stericson.rootshell.a.b(split[split.length - 1]);
                return b.size() > 0 ? ((String) b.get(0)) + split[split.length - 1] : split[split.length - 1];
            }
        } catch (Exception e) {
            if (a.a) {
                e.printStackTrace();
            }
        }
        a.i("Symlink not found");
        return "";
    }
}
