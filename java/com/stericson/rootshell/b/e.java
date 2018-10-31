package com.stericson.rootshell.b;

import android.os.Build.VERSION;
import com.stericson.rootshell.a;
import com.stericson.rootshell.f;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

public class e {
    public static i a = i.NORMAL;
    private static e e = null;
    private static e f = null;
    private static e g = null;
    private static String[] h = new String[]{null, null};
    private Runnable A = new h(this);
    public boolean b = false;
    public boolean c = false;
    public boolean d = false;
    private int i = 25000;
    private j j = null;
    private i k = i.NORMAL;
    private String l = "";
    private final Process m;
    private final BufferedReader n;
    private final BufferedReader o;
    private final OutputStreamWriter p;
    private final List q = new ArrayList();
    private boolean r = false;
    private Boolean s = null;
    private int t = 5000;
    private int u = 0;
    private int v = 0;
    private int w = 0;
    private int x = 0;
    private boolean y = false;
    private Runnable z = new f(this);

    private e(String str, j jVar, i iVar, int i) {
        a.c("Starting shell: " + str);
        a.c("Context: " + iVar.a());
        a.c("Timeout: " + i);
        this.j = jVar;
        if (i <= 0) {
            i = this.i;
        }
        this.i = i;
        this.k = iVar;
        if (this.k == i.NORMAL) {
            this.m = Runtime.getRuntime().exec(str);
        } else {
            String a = a(false);
            String a2 = a(true);
            if (!f() || a == null || a2 == null || !a.endsWith("SUPERSU") || Integer.valueOf(a2).intValue() < 190) {
                a.c("Su binary --context switch not supported!");
                a.c("Su binary display version: " + a);
                a.c("Su binary internal version: " + a2);
                a.c("SELinuxEnforcing: " + f());
            } else {
                str = str + " --context " + this.k.a();
            }
            this.m = Runtime.getRuntime().exec(str);
        }
        this.n = new BufferedReader(new InputStreamReader(this.m.getInputStream(), "UTF-8"));
        this.o = new BufferedReader(new InputStreamReader(this.m.getErrorStream(), "UTF-8"));
        this.p = new OutputStreamWriter(this.m.getOutputStream(), "UTF-8");
        k kVar = new k();
        kVar.start();
        try {
            kVar.join((long) this.i);
            if (kVar.a == -911) {
                try {
                    this.m.destroy();
                } catch (Exception e) {
                }
                a(this.n);
                a(this.o);
                a(this.p);
                throw new TimeoutException(this.l);
            } else if (kVar.a == -42) {
                try {
                    this.m.destroy();
                } catch (Exception e2) {
                }
                a(this.n);
                a(this.o);
                a(this.p);
                throw new com.stericson.rootshell.a.a("Root Access Denied");
            } else {
                Thread thread = new Thread(this.z, "Shell Input");
                thread.setPriority(5);
                thread.start();
                thread = new Thread(this.A, "Shell Output");
                thread.setPriority(5);
                thread.start();
            }
        } catch (InterruptedException e3) {
            kVar.interrupt();
            Thread.currentThread().interrupt();
            throw new TimeoutException();
        }
    }

    public static e a(int i) {
        try {
            if (f == null) {
                a.c("Starting Shell!");
                f = new e("/system/bin/sh", j.NORMAL, i.NORMAL, i);
            } else {
                a.c("Using Existing Shell!");
            }
            return f;
        } catch (com.stericson.rootshell.a.a e) {
            throw new IOException();
        }
    }

    public static e a(int i, int i2) {
        return a(i, a, i2);
    }

    public static e a(int i, i iVar, int i2) {
        int i3;
        int i4 = 0;
        if (e == null) {
            a.c("Starting Root Shell!");
            String str = "su";
            while (e == null) {
                try {
                    a.c("Trying to open Root Shell, attempt #" + i4);
                    e = new e(str, j.ROOT, iVar, i);
                } catch (IOException e) {
                    IOException iOException = e;
                    i3 = i4 + 1;
                    if (i4 >= i2) {
                        a.c("IOException, could not start shell");
                        throw iOException;
                    }
                    i4 = i3;
                } catch (com.stericson.rootshell.a.a e2) {
                    com.stericson.rootshell.a.a aVar = e2;
                    i3 = i4 + 1;
                    if (i4 >= i2) {
                        a.c("RootDeniedException, could not start shell");
                        throw aVar;
                    }
                    i4 = i3;
                } catch (TimeoutException e3) {
                    TimeoutException timeoutException = e3;
                    i3 = i4 + 1;
                    if (i4 >= i2) {
                        a.c("TimeoutException, could not start shell");
                        throw timeoutException;
                    }
                    i4 = i3;
                }
            }
        } else if (e.k != iVar) {
            try {
                a.c("Context is different than open shell, switching context... " + e.k + " VS " + iVar);
                e.a(iVar);
            } catch (IOException e4) {
                if (0 >= i2) {
                    a.c("IOException, could not switch context!");
                    throw e4;
                }
            } catch (com.stericson.rootshell.a.a e22) {
                if (0 >= i2) {
                    a.c("RootDeniedException, could not switch context!");
                    throw e22;
                }
            } catch (TimeoutException e32) {
                if (0 >= i2) {
                    a.c("TimeoutException, could not switch context!");
                    throw e32;
                }
            }
        } else {
            a.c("Using Existing Root Shell!");
        }
        return e;
    }

    private synchronized String a(boolean z) {
        String str;
        int i = z ? 0 : 1;
        if (h[i] == null) {
            try {
                Process exec = Runtime.getRuntime().exec(z ? "su -V" : "su -v", null);
                exec.waitFor();
                List<String> arrayList = new ArrayList();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            arrayList.add(readLine);
                        }
                    } catch (IOException e) {
                    }
                    try {
                        break;
                    } catch (IOException e2) {
                    }
                }
                bufferedReader.close();
                exec.destroy();
                if (arrayList != null) {
                    for (String str2 : arrayList) {
                        if (z) {
                            try {
                                if (Integer.parseInt(str2) > 0) {
                                    break;
                                }
                            } catch (NumberFormatException e3) {
                            }
                        } else if (str2.contains(".")) {
                            break;
                        }
                    }
                }
                str2 = null;
                h[i] = str2;
            } catch (IOException e4) {
                e4.printStackTrace();
                str2 = null;
            } catch (InterruptedException e5) {
                e5.printStackTrace();
                str2 = null;
            }
        }
        str2 = h[i];
        return str2;
    }

    private void a(Reader reader) {
        if (reader != null) {
            try {
                reader.close();
            } catch (Exception e) {
            }
        }
    }

    private void a(Writer writer) {
        if (writer != null) {
            try {
                writer.close();
            } catch (Exception e) {
            }
        }
    }

    public static void b() {
        a.c("Request to close custom shell!");
        if (g != null) {
            g.a();
        }
    }

    public static void c() {
        a.c("Request to close root shell!");
        if (e != null) {
            e.a();
        }
    }

    public static void d() {
        a.c("Request to close normal shell!");
        if (f != null) {
            f.a();
        }
    }

    public static void e() {
        a.c("Request to close all shells!");
        d();
        c();
        b();
    }

    public static e h() {
        return a(0, 3);
    }

    private void i() {
        this.y = true;
        int abs = Math.abs(this.t - (this.t / 4));
        a.c("Cleaning up: " + abs);
        for (int i = 0; i < abs; i++) {
            this.q.remove(0);
        }
        this.u = this.q.size() - 1;
        this.v = this.q.size() - 1;
        this.y = false;
    }

    public a a(a aVar) {
        if (this.r) {
            throw new IllegalStateException("Unable to add commands to a closed shell");
        }
        do {
        } while (this.y);
        aVar.h();
        this.q.add(aVar);
        g();
        return aVar;
    }

    public e a(i iVar) {
        if (this.j == j.ROOT) {
            try {
                c();
            } catch (Exception e) {
                a.c("Problem closing shell while trying to switch context...");
            }
            return a(this.i, iVar, 3);
        }
        a.c("Can only switch context on a root shell!");
        return this;
    }

    public void a() {
        a.c("Request to close shell!");
        int i = 0;
        while (this.b) {
            a.c("Waiting on shell to finish executing before closing...");
            i++;
            if (i > 10000) {
                break;
            }
        }
        synchronized (this.q) {
            this.r = true;
            g();
        }
        a.c("Shell Closed!");
        if (this == e) {
            e = null;
        } else if (this == f) {
            f = null;
        } else if (this == g) {
            g = null;
        }
    }

    public int b(a aVar) {
        return this.q.indexOf(aVar);
    }

    public String c(a aVar) {
        return "Command is in position " + b(aVar) + " currently executing command at position " + this.v + " and the number of commands is " + this.q.size();
    }

    public void d(a aVar) {
        while (this.o.ready() && aVar != null) {
            try {
                String readLine = this.o.readLine();
                if (readLine != null) {
                    aVar.c(aVar.p, readLine);
                } else {
                    return;
                }
            } catch (Exception e) {
                a.a(e.getMessage(), f.ERROR, e);
                return;
            }
        }
    }

    public synchronized boolean f() {
        if (this.s == null) {
            Boolean valueOf;
            if (VERSION.SDK_INT >= 17) {
                if (new File("/sys/fs/selinux/enforce").exists()) {
                    InputStream fileInputStream;
                    try {
                        fileInputStream = new FileInputStream("/sys/fs/selinux/enforce");
                        valueOf = Boolean.valueOf(fileInputStream.read() == 49);
                        try {
                            fileInputStream.close();
                        } catch (Exception e) {
                        }
                    } catch (Exception e2) {
                        valueOf = null;
                    } catch (Throwable th) {
                        fileInputStream.close();
                    }
                } else {
                    valueOf = null;
                }
                if (valueOf == null) {
                    valueOf = Boolean.valueOf(VERSION.SDK_INT >= 19);
                }
            } else {
                valueOf = null;
            }
            if (valueOf == null) {
                valueOf = Boolean.valueOf(false);
            }
            this.s = valueOf;
        }
        return this.s.booleanValue();
    }

    protected void g() {
        new g(this).start();
    }
}
