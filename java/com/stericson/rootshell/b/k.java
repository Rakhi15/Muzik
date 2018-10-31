package com.stericson.rootshell.b;

import java.io.EOFException;
import java.io.IOException;
import java.lang.reflect.Field;

public class k extends Thread {
    public int a;
    public e b;

    private k(e eVar) {
        this.a = -911;
        this.b = eVar;
    }

    private void a() {
        try {
            Field declaredField;
            try {
                declaredField = this.b.m.getClass().getDeclaredField("pid");
            } catch (NoSuchFieldException e) {
                declaredField = r0.getDeclaredField("id");
            }
            declaredField.setAccessible(true);
            this.b.p.write("(echo -17 > /proc/" + ((Integer) declaredField.get(this.b.m)).intValue() + "/oom_adj) &> /dev/null\n");
            this.b.p.write("(echo -17 > /proc/$$/oom_adj) &> /dev/null\n");
            this.b.p.flush();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void run() {
        try {
            this.b.p.write("echo Started\n");
            this.b.p.flush();
            while (true) {
                String readLine = this.b.n.readLine();
                if (readLine == null) {
                    throw new EOFException();
                } else if (!"".equals(readLine)) {
                    if ("Started".equals(readLine)) {
                        this.a = 1;
                        a();
                        return;
                    }
                    this.b.l = "unknown error occurred.";
                }
            }
        } catch (IOException e) {
            this.a = -42;
            if (e.getMessage() != null) {
                this.b.l = e.getMessage();
            } else {
                this.b.l = "RootAccess denied?.";
            }
        }
    }
}
