package com.stericson.roottools;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.stericson.rootshell.b.e;
import com.stericson.rootshell.b.i;
import com.stericson.roottools.a.b;

class c extends Thread {
    final /* synthetic */ SanityCheckRootTools a;
    private Handler b;

    public c(SanityCheckRootTools sanityCheckRootTools, Context context, Handler handler) {
        this.a = sanityCheckRootTools;
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
            for (String str : a.c()) {
                a(3, str + " k\n\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        a(4, "Testing A ton of commands");
        a(3, "[ Ton of Commands ]\n");
        for (int i = 0; i < 100; i++) {
            a.b("/system/xbin/busybox");
        }
        a(4, "Testing Find Binary");
        boolean f = a.f();
        a(3, "[ Checking Root ]\n");
        a(3, f + " k\n\n");
        a(4, "Testing file exists");
        a(3, "[ Checking Exists() ]\n");
        a(3, a.b("/system/sbin/[") + " k\n\n");
        a(4, "Testing Is Access Given");
        f = a.d();
        a(3, "[ Checking for Access to Root ]\n");
        a(3, f + " k\n\n");
        a(4, "Testing Remount");
        f = a.b("/system", "rw");
        a(3, "[ Remounting System as RW ]\n");
        a(3, f + " k\n\n");
        a(4, "Testing CheckUtil");
        a(3, "[ Checking busybox is setup ]\n");
        a(3, a.a("busybox") + " k\n\n");
        a(4, "Testing getBusyBoxVersion");
        a(3, "[ Checking busybox version ]\n");
        a(3, a.c("/system/xbin/") + " k\n\n");
        try {
            a(4, "Testing fixUtils");
            a(3, "[ Checking Utils ]\n");
            a(3, a.a(new String[]{"ls", "rm", "ln", "dd", "chmod", "mount"}) + " k\n\n");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            a(4, "Testing getSymlink");
            a(3, "[ Checking [[ for symlink ]\n");
            a(3, a.h("/system/bin/[[") + " k\n\n");
        } catch (Exception e22) {
            e22.printStackTrace();
        }
        a(4, "Testing getInode");
        a(3, "[ Checking Inodes ]\n");
        a(3, a.f("/system/bin/busybox") + " k\n\n");
        a(4, "Testing GetBusyBoxapplets");
        try {
            a(3, "[ Getting all available Busybox applets ]\n");
            for (String str2 : a.d("/data/data/stericson.busybox/files/bb/busybox")) {
                a(3, str2 + " k\n\n");
            }
        } catch (Exception e222) {
            e222.printStackTrace();
        }
        a(4, "Testing GetBusyBox version in a special directory!");
        try {
            a(3, "[ Testing GetBusyBox version in a special directory! ]\n");
            a(3, a.c("/data/data/stericson.busybox/files/bb/") + " k\n\n");
        } catch (Exception e2222) {
            e2222.printStackTrace();
        }
        a(4, "Testing getFilePermissionsSymlinks");
        b e3 = a.e("/system/xbin/busybox");
        a(3, "[ Checking busybox permissions and symlink ]\n");
        if (e3 != null) {
            a(3, "Symlink: " + e3.a() + " k\n\n");
            a(3, "Group Permissions: " + e3.e() + " k\n\n");
            a(3, "Owner Permissions: " + e3.f() + " k\n\n");
            a(3, "Permissions: " + e3.c() + " k\n\n");
            a(3, "Type: " + e3.b() + " k\n\n");
            a(3, "User Permissions: " + e3.d() + " k\n\n");
        } else {
            a(3, "Permissions == null k\n\n");
        }
        a(4, "Testing output capture");
        a(3, "[ busybox ash --help ]\n");
        try {
            e a = a.a(true);
            a.a(new d(this, 0, "busybox ash --help"));
            a(4, "getevent - /dev/input/event0");
            a(3, "[ getevent - /dev/input/event0 ]\n");
            a.a(new e(this, 0, 0, "getevent /dev/input/event0"));
        } catch (Exception e22222) {
            e22222.printStackTrace();
        }
        a(4, "Switching RootContext - SYSTEM_APP");
        a(3, "[ Switching Root Context - SYSTEM_APP ]\n");
        try {
            a = a.a(true, i.SYSTEM_APP);
            a.a(new f(this, 0, "id"));
            a(4, "Testing PM");
            a(3, "[ Testing pm list packages -d ]\n");
            a.a(new g(this, 0, "sh /system/bin/pm list packages -d"));
        } catch (Exception e222222) {
            e222222.printStackTrace();
        }
        a(4, "Switching RootContext - UNTRUSTED");
        a(3, "[ Switching Root Context - UNTRUSTED ]\n");
        try {
            a.a(true, i.UNTRUSTED_APP).a(new h(this, 0, "id"));
        } catch (Exception e2222222) {
            e2222222.printStackTrace();
        }
        a(4, "Testing df");
        long g = a.g("/data");
        a(3, "[ Checking /data partition size]\n");
        a(3, g + "k\n\n");
        try {
            a.a(true).a(new i(this, 42, false, "echo done"));
        } catch (Exception e22222222) {
            e22222222.printStackTrace();
        }
    }
}
