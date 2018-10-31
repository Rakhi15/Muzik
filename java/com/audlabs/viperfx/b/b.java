package com.audlabs.viperfx.b;

import android.util.Log;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import me.imid.swipebacklayout.lib.f;

public class b {
    private FileInputStream a = null;
    private BufferedInputStream b = null;
    private long c;
    private long d;
    private int e;
    private int f;
    private int g;

    private int a(BufferedInputStream bufferedInputStream) {
        byte[] bArr = new byte[4];
        try {
            return bufferedInputStream.read(bArr) == -1 ? -1 : ((((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16)) | ((bArr[2] & 255) << 8)) | (bArr[3] & 255);
        } catch (IOException e) {
            return 0;
        }
    }

    public static long a(byte[] bArr, int i) {
        if (bArr == null || bArr.length < i || i <= 0) {
            return 0;
        }
        long[] jArr = new long[256];
        for (int i2 = 0; i2 < 256; i2++) {
            long j = (long) i2;
            for (int i3 = 8; i3 > 0; i3--) {
                j = (1 & j) != 0 ? (j >> 1) ^ 3988292384L : j >> 1;
            }
            jArr[i2] = j;
        }
        long j2 = -1;
        for (int i4 = 0; i4 < i; i4++) {
            j2 = ((j2 >> 8) & 16777215) ^ jArr[((int) (((long) (bArr[i4] & 255)) ^ j2)) & 255];
        }
        return -1 ^ j2;
    }

    private short a(byte b, byte b2) {
        return (short) ((b & 255) | ((b2 & 255) << 8));
    }

    private byte[] a(byte[] bArr) {
        int length = bArr.length / 2;
        byte[] bArr2 = new byte[(length * 4)];
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        ByteBuffer wrap2 = ByteBuffer.wrap(bArr2);
        wrap.order(ByteOrder.nativeOrder());
        wrap2.order(ByteOrder.nativeOrder());
        for (int i = 0; i < length; i++) {
            wrap2.putFloat((float) (((double) wrap.getShort()) * 3.0517578125E-5d));
        }
        return bArr2;
    }

    private int b(BufferedInputStream bufferedInputStream) {
        byte[] bArr = new byte[4];
        try {
            return bufferedInputStream.read(bArr) == -1 ? -1 : (((bArr[0] & 255) | ((bArr[1] & 255) << 8)) | ((bArr[2] & 255) << 16)) | ((bArr[3] & 255) << 24);
        } catch (IOException e) {
            return 0;
        }
    }

    private byte[] b(byte[] bArr) {
        int length = bArr.length / 3;
        byte[] bArr2 = new byte[(length * 4)];
        ByteBuffer wrap = ByteBuffer.wrap(bArr2);
        wrap.order(ByteOrder.nativeOrder());
        int i = 0;
        int i2 = 0;
        while (i2 < length) {
            int i3 = ((bArr[i] & 255) | ((bArr[i + 1] & 255) << 8)) | ((bArr[i + 2] & 255) << 16);
            if (i3 > 8388607) {
                i3 = -(8388607 - (i3 & 8388607));
            }
            wrap.putFloat((float) (((double) i3) * 1.1920928955078125E-7d));
            i2++;
            i += 3;
        }
        return bArr2;
    }

    private short c(BufferedInputStream bufferedInputStream) {
        byte[] bArr = new byte[2];
        try {
            return bufferedInputStream.read(bArr, 0, 2) == -1 ? (short) -1 : a(bArr[0], bArr[1]);
        } catch (IOException e) {
            return (short) 0;
        }
    }

    private byte[] c(byte[] bArr) {
        int length = bArr.length / 4;
        byte[] bArr2 = new byte[(length * 4)];
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        ByteBuffer wrap2 = ByteBuffer.wrap(bArr2);
        wrap.order(ByteOrder.nativeOrder());
        wrap2.order(ByteOrder.nativeOrder());
        for (int i = 0; i < length; i++) {
            wrap2.putFloat((float) (((double) wrap.getInt()) * 4.6566128730773926E-10d));
        }
        return bArr2;
    }

    public void a() {
        if (this.b != null) {
            try {
                this.b.close();
            } catch (IOException e) {
                Log.i("ViPER4Android", "Release, msg = " + e.getMessage());
            }
            this.b = null;
        }
        if (this.a != null) {
            try {
                this.a.close();
            } catch (IOException e2) {
                Log.i("ViPER4Android", "Release, msg = " + e2.getMessage());
            }
            this.a = null;
        }
    }

    public boolean a(String str) {
        if (str == null || str.equals("") || !new File(str).exists()) {
            return false;
        }
        a();
        try {
            this.a = new FileInputStream(str);
            if (new File(str).length() <= 16) {
                a();
                return false;
            }
            this.b = new BufferedInputStream(this.a, 4096);
            if (a(this.b) != 1380533830) {
                a();
                return false;
            } else if (((long) b(this.b)) <= 16) {
                a();
                return false;
            } else if (a(this.b) != 1463899717) {
                a();
                return false;
            } else if (a(this.b) != 1718449184) {
                a();
                return false;
            } else if (b(this.b) < 16) {
                a();
                return false;
            } else {
                short c = c(this.b);
                if (c == (short) 1 || c == (short) 3) {
                    this.e = c(this.b);
                    if (this.e == 1 || this.e == 2 || this.e == 4) {
                        int b = b(this.b);
                        if (b < 8000 || b > 192000) {
                            a();
                            return false;
                        }
                        Log.i("ViPER4Android", "IRS byterate = " + b(this.b));
                        Log.i("ViPER4Android", "IRS blockalign = " + c(this.b));
                        this.g = c(this.b);
                        this.f = 0;
                        if (c == (short) 1) {
                            if (this.g == 16) {
                                this.f = 1;
                            } else if (this.g == 24) {
                                this.f = 2;
                            } else if (this.g == 32) {
                                this.f = 3;
                            } else {
                                a();
                                return false;
                            }
                        } else if (this.g == 32) {
                            this.f = 4;
                        } else {
                            a();
                            return false;
                        }
                        if (a(this.b) != 1684108385) {
                            a();
                            return false;
                        }
                        int b2 = b(this.b);
                        if (b2 <= 0 || b2 > 4194304) {
                            a();
                            return false;
                        }
                        this.d = (long) b2;
                        this.c = (this.d / ((long) this.e)) / ((long) (this.g / 8));
                        if (this.c < 16) {
                            a();
                            return false;
                        } else if (this.d % ((long) ((this.e * this.g) / 8)) != 0) {
                            a();
                            return false;
                        } else {
                            Log.i("ViPER4Android", "IRS [" + str + "] opened");
                            Log.i("ViPER4Android", "IRS attr = [" + this.f + "," + this.e + "," + this.c + "]");
                            return true;
                        }
                    }
                    a();
                    return false;
                }
                a();
                return false;
            }
        } catch (FileNotFoundException e) {
            this.a = null;
            this.b = null;
            Log.i("ViPER4Android", "LoadIrs, FileNotFoundException, msg = " + e.getMessage() + "mIrsPathName = " + str);
            return false;
        }
    }

    public byte[] b() {
        IOException iOException;
        if (this.b == null || this.a == null) {
            return null;
        }
        if (this.f < 1 || this.f > 4) {
            return null;
        }
        Object obj = new byte[4096];
        int i = 0;
        while (true) {
            try {
                int read = this.b.read(obj, i, 4096);
                if (read < 0) {
                    break;
                }
                read += i;
                try {
                    Object obj2 = new byte[(read + 4096)];
                    System.arraycopy(obj, 0, obj2, 0, read);
                    obj = obj2;
                    i = read;
                } catch (IOException e) {
                    IOException iOException2 = e;
                    i = read;
                    iOException = iOException2;
                }
            } catch (IOException e2) {
                iOException = e2;
            }
        }
        Object obj3 = new byte[i];
        System.arraycopy(obj, 0, obj3, 0, i);
        if (this.d <= ((long) obj3.length)) {
            this.d = (long) obj3.length;
            this.c = (this.d / ((long) this.e)) / ((long) (this.g / 8));
            if (this.d % ((long) ((this.e * this.g) / 8)) != 0) {
                a();
                return null;
            }
            obj2 = obj3;
        } else {
            if (this.d < ((long) obj3.length)) {
                Log.i("ViPER4Android", "IRSUtils: We got some garbage data, header = " + this.d + ", read = " + obj3.length);
                Log.i("ViPER4Android", "IRSUtils: So lets discard some data, length = " + (((long) obj3.length) - this.d));
                byte[] bArr = new byte[((int) this.d)];
                System.arraycopy(obj3, 0, bArr, 0, (int) this.d);
            }
            obj2 = obj3;
        }
        switch (this.f) {
            case f.View_android_focusable /*1*/:
                return a(bArr);
            case f.View_paddingStart /*2*/:
                return b(bArr);
            case f.View_paddingEnd /*3*/:
                return c(bArr);
            default:
                return bArr;
        }
        Log.i("ViPER4Android", "readEntireData, msg = " + iOException.getMessage());
        Object obj32 = new byte[i];
        System.arraycopy(obj, 0, obj32, 0, i);
        if (this.d <= ((long) obj32.length)) {
            if (this.d < ((long) obj32.length)) {
                Log.i("ViPER4Android", "IRSUtils: We got some garbage data, header = " + this.d + ", read = " + obj32.length);
                Log.i("ViPER4Android", "IRSUtils: So lets discard some data, length = " + (((long) obj32.length) - this.d));
                byte[] bArr2 = new byte[((int) this.d)];
                System.arraycopy(obj32, 0, bArr2, 0, (int) this.d);
            }
            obj2 = obj32;
        } else {
            this.d = (long) obj32.length;
            this.c = (this.d / ((long) this.e)) / ((long) (this.g / 8));
            if (this.d % ((long) ((this.e * this.g) / 8)) != 0) {
                a();
                return null;
            }
            obj2 = obj32;
        }
        switch (this.f) {
            case f.View_android_focusable /*1*/:
                return a(bArr2);
            case f.View_paddingStart /*2*/:
                return b(bArr2);
            case f.View_paddingEnd /*3*/:
                return c(bArr2);
            default:
                return bArr2;
        }
    }

    public int c() {
        return this.e;
    }

    public int d() {
        return (int) this.c;
    }

    protected void finalize() {
        try {
            a();
        } finally {
            super.finalize();
        }
    }
}
