package com.stericson.roottools.b;

import com.stericson.rootshell.b.e;
import com.stericson.roottools.a.a;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class b {
    private a a(String str) {
        try {
            ArrayList b = com.stericson.roottools.a.b();
            File file = new File(str);
            while (file != null) {
                Iterator it = b.iterator();
                while (it.hasNext()) {
                    a aVar = (a) it.next();
                    if (aVar.b().equals(file)) {
                        return aVar;
                    }
                }
            }
            return null;
        } catch (IOException e) {
            if (com.stericson.roottools.a.a) {
                e.printStackTrace();
            }
            return null;
        } catch (Exception e2) {
            if (com.stericson.roottools.a.a) {
                e2.printStackTrace();
            }
            return null;
        }
    }

    private void a(com.stericson.rootshell.b.a aVar) {
        synchronized (aVar) {
            try {
                if (!aVar.e()) {
                    aVar.wait(2000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean a(String str, String str2) {
        a aVar;
        if (str.endsWith("/") && !str.equals("/")) {
            str = str.substring(0, str.lastIndexOf("/"));
        }
        boolean z = false;
        while (!z) {
            try {
                boolean z2;
                Iterator it = com.stericson.roottools.a.b().iterator();
                while (it.hasNext()) {
                    aVar = (a) it.next();
                    com.stericson.roottools.a.i(aVar.b().toString());
                    if (str.equals(aVar.b().toString())) {
                        z2 = true;
                        break;
                    }
                }
                z2 = z;
                if (z2) {
                    z = z2;
                } else {
                    try {
                        str = new File(str).getParent();
                        z = z2;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return false;
                    }
                }
            } catch (Exception e2) {
                if (com.stericson.roottools.a.a) {
                    e2.printStackTrace();
                }
                return false;
            }
        }
        aVar = a(str);
        if (aVar != null) {
            com.stericson.roottools.a.c("RootTools v4.2", "Remounting " + aVar.b().getAbsolutePath() + " as " + str2.toLowerCase());
            if (!aVar.c().contains(str2.toLowerCase())) {
                try {
                    com.stericson.rootshell.b.a aVar2 = new com.stericson.rootshell.b.a(0, true, "toybox mount -o remount," + str2.toLowerCase() + " " + aVar.a().getAbsolutePath() + " " + aVar.b().getAbsolutePath(), "busybox mount -o remount," + str2.toLowerCase() + " " + aVar.a().getAbsolutePath() + " " + aVar.b().getAbsolutePath(), "toolbox mount -o remount," + str2.toLowerCase() + " " + aVar.a().getAbsolutePath() + " " + aVar.b().getAbsolutePath(), "mount -o remount," + str2.toLowerCase() + " " + aVar.a().getAbsolutePath() + " " + aVar.b().getAbsolutePath(), "/system/bin/toolbox mount -o remount," + str2.toLowerCase() + " " + aVar.a().getAbsolutePath() + " " + aVar.b().getAbsolutePath());
                    e.h().a(aVar2);
                    a(aVar2);
                } catch (Exception e22) {
                    e22.printStackTrace();
                }
                aVar = a(str);
            }
            if (aVar != null) {
                com.stericson.roottools.a.c("RootTools v4.2", aVar.c() + " AND " + str2.toLowerCase());
                if (aVar.c().contains(str2.toLowerCase())) {
                    com.stericson.roottools.a.i(aVar.c().toString());
                    return true;
                }
                com.stericson.roottools.a.i(aVar.c().toString());
                return false;
            }
            com.stericson.roottools.a.i("mount is null, file was: " + str + " mountType was: " + str2);
        } else {
            com.stericson.roottools.a.i("mount is null, file was: " + str + " mountType was: " + str2);
        }
        return false;
    }
}
