package com.stericson.rootshell;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.stericson.rootshell.b.i;

class h extends Thread {
    final /* synthetic */ SanityCheckRootShell a;
    private Handler b;

    public h(SanityCheckRootShell sanityCheckRootShell, Context context, Handler handler) {
        this.a = sanityCheckRootShell;
        this.b = handler;
    }

    private void a(int i, String str) {
        Message obtainMessage = this.b.obtainMessage();
        Bundle bundle = new Bundle();
        bundle.putInt("action", i);
        bundle.putString("text", str);
        obtainMessage.setData(bundle);
        this.b.sendMessage(obtainMessage);
    }

    public void run() {
        a(1, null);
        a(4, "Testing getPath");
        a(3, "[ getPath ]\n");
        try {
            for (String str : a.b()) {
                a(3, str + " k\n\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        a(4, "Testing A ton of commands");
        a(3, "[ Ton of Commands ]\n");
        for (int i = 0; i < 100; i++) {
            a.a("/system/xbin/busybox");
        }
        a(4, "Testing Find Binary");
        boolean e2 = a.e();
        a(3, "[ Checking Root ]\n");
        a(3, e2 + " k\n\n");
        e2 = a.d();
        a(3, "[ Checking Busybox ]\n");
        a(3, e2 + " k\n\n");
        a(4, "Testing file exists");
        a(3, "[ Checking Exists() ]\n");
        a(3, a.a("/system/sbin/[") + " k\n\n");
        a(4, "Testing Is Access Given");
        e2 = a.c();
        a(3, "[ Checking for Access to Root ]\n");
        a(3, e2 + " k\n\n");
        a(4, "Testing output capture");
        a(3, "[ busybox ash --help ]\n");
        try {
            a.a(true).a(new i(this, 0, "busybox ash --help"));
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        a(4, "Switching RootContext - SYSTEM_APP");
        a(3, "[ Switching Root Context - SYSTEM_APP ]\n");
        try {
            a.a(true, i.SYSTEM_APP).a(new j(this, 0, "id"));
        } catch (Exception e32) {
            e32.printStackTrace();
        }
        a(4, "Switching RootContext - UNTRUSTED");
        a(3, "[ Switching Root Context - UNTRUSTED ]\n");
        try {
            a.a(true, i.UNTRUSTED_APP).a(new k(this, 0, "id"));
        } catch (Exception e322) {
            e322.printStackTrace();
        }
        try {
            a.a(true).a(new l(this, 42, false, "echo done"));
        } catch (Exception e3222) {
            e3222.printStackTrace();
        }
    }
}
