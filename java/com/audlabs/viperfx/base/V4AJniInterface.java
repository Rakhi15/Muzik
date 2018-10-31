package com.audlabs.viperfx.base;

import android.util.Log;
import java.nio.charset.Charset;

public class V4AJniInterface {
    private static boolean a;

    static {
        try {
            System.loadLibrary("V4AJniUtils");
            a = true;
            Log.i("ViPER4Android_Utils", "libV4AJniUtils.so loaded");
        } catch (UnsatisfiedLinkError e) {
            a = false;
            Log.e("ViPER4Android_Utils", "[Fatal] Can't load libV4AJniUtils.so");
        }
    }

    private static native int CheckCPUHasNEON();

    private static native int CheckCPUHasVFP();

    private static native int CheckLibraryUsable();

    private static native int[] GetImpulseResponseInfo(byte[] bArr);

    private static native int[] HashImpulseResponse(byte[] bArr, int i);

    private static native byte[] ReadImpulseResponse(byte[] bArr);

    public static boolean a() {
        boolean z = true;
        if (!a) {
            return false;
        }
        if (CheckLibraryUsable() != 1) {
            z = false;
        }
        return z;
    }

    public static int[] a(String str) {
        if (!a) {
            return null;
        }
        byte[] bytes = str.getBytes(Charset.forName("US-ASCII"));
        return bytes != null ? GetImpulseResponseInfo(bytes) : null;
    }

    public static int[] a(byte[] bArr) {
        return (a && bArr != null) ? HashImpulseResponse(bArr, bArr.length) : null;
    }

    public static boolean b() {
        return a;
    }

    public static byte[] b(String str) {
        if (!a) {
            return null;
        }
        byte[] bytes = str.getBytes(Charset.forName("US-ASCII"));
        return bytes != null ? ReadImpulseResponse(bytes) : null;
    }

    public static boolean c() {
        if (!a) {
            return false;
        }
        int CheckCPUHasNEON = CheckCPUHasNEON();
        Log.i("ViPER4Android_Utils", "CpuInfo[jni] = NEON:" + CheckCPUHasNEON);
        return CheckCPUHasNEON != 0;
    }

    public static boolean d() {
        if (!a) {
            return false;
        }
        int CheckCPUHasVFP = CheckCPUHasVFP();
        Log.i("ViPER4Android_Utils", "CpuInfo[jni] = VFP:" + CheckCPUHasVFP);
        return CheckCPUHasVFP != 0;
    }
}
