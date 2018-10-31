package com.audlabs.viperfx.service;

import android.media.audiofx.AudioEffect;
import android.media.audiofx.AudioEffect.Descriptor;
import android.util.Log;
import com.audlabs.viperfx.b.b;
import com.audlabs.viperfx.b.d;
import com.audlabs.viperfx.base.V4AJniInterface;
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Random;
import java.util.UUID;

class o {
    public AudioEffect a;
    final /* synthetic */ ViPER4AndroidService b;
    private final UUID c = UUID.fromString("ec7178ec-e5e1-4432-a3f4-4657e6795210");

    public o(ViPER4AndroidService viPER4AndroidService, int i) {
        this.b = viPER4AndroidService;
        try {
            Log.i("ViPER4Android", "Creating viper4android module, " + ViPER4AndroidService.b);
            this.a = (AudioEffect) AudioEffect.class.getConstructor(new Class[]{UUID.class, UUID.class, Integer.TYPE, Integer.TYPE}).newInstance(new Object[]{this.c, ViPER4AndroidService.b, Integer.valueOf(0), Integer.valueOf(i)});
        } catch (Exception e) {
            Log.e("ViPER4Android", "Can not create audio effect instance,V4A driver not installed or not supported by this rom");
            this.a = null;
        }
        if (this.a != null) {
            Descriptor descriptor = this.a.getDescriptor();
            Log.i("ViPER4Android", "Effect name : " + descriptor.name);
            Log.i("ViPER4Android", "Type id : " + descriptor.type);
            Log.i("ViPER4Android", "Unique id : " + descriptor.uuid);
            Log.i("ViPER4Android", "Implementor : " + descriptor.implementor);
            Log.i("ViPER4Android", "Connect mode : " + descriptor.connectMode);
            this.a.setControlStatusListener(new p(this, viPER4AndroidService));
            this.a.setEnableStatusListener(new q(this, viPER4AndroidService));
        }
    }

    private int a(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.order(ByteOrder.nativeOrder());
        return wrap.getInt(0);
    }

    private void a(b bVar, String str) {
        int i = 0;
        int nextInt = new Random().nextInt();
        a(65591, nextInt, bVar.c(), 0);
        byte[] b = bVar.b();
        if (b == null || b.length <= 0) {
            a(65591, 0, 0, 1);
            return;
        }
        int a = (int) b.a(b, b.length);
        Log.i("ViPER4Android", "[Kernel] Channels = " + bVar.c() + ", Frames = " + bVar.d() + ", Bytes = " + b.length + ", Hash = " + a);
        int length = b.length;
        int i2 = 0;
        while (length > 0) {
            int min = Math.min(8176, length);
            byte[] bArr = new byte[min];
            System.arraycopy(b, i2, bArr, 0, min);
            i2 += min;
            length -= min;
            a(65592, nextInt, min / 4, bArr);
        }
        byte[] bytes = str.getBytes();
        if (bytes != null) {
            i = (int) b.a(bytes, bytes.length);
        }
        a(65593, nextInt, a, i);
    }

    private void a(String str, int i, int i2) {
        int i3 = 0;
        int nextInt = new Random().nextInt();
        a(65591, nextInt, i, 0);
        byte[] b = V4AJniInterface.b(str);
        if (b == null || b.length <= 0) {
            a(65591, 0, 0, 1);
            return;
        }
        int[] a = V4AJniInterface.a(b);
        if (a == null || a.length != 2 || a[0] == 0) {
            a(65591, 0, 0, 1);
            return;
        }
        int i4 = a[1];
        Log.i("ViPER4Android", "[Kernel] Channels = " + i + ", Frames = " + i2 + ", Bytes = " + b.length + ", Hash = " + i4);
        int length = b.length;
        int i5 = 0;
        while (length > 0) {
            int min = Math.min(8176, length);
            byte[] bArr = new byte[min];
            System.arraycopy(b, i5, bArr, 0, min);
            i5 += min;
            length -= min;
            a(65592, nextInt, min / 4, bArr);
        }
        byte[] bytes = str.getBytes();
        if (bytes != null) {
            i3 = (int) b.a(bytes, bytes.length);
        }
        a(65593, nextInt, i4, i3);
    }

    private byte[] a(byte[]... bArr) {
        int i = 0;
        for (byte[] length : bArr) {
            i += length.length;
        }
        Object obj = new byte[i];
        i = 0;
        for (Object obj2 : bArr) {
            System.arraycopy(obj2, 0, obj, i, obj2.length);
            i += obj2.length;
        }
        return obj;
    }

    private void b(b bVar, String str) {
        int i = 0;
        int nextInt = new Random().nextInt();
        a(65540, nextInt, bVar.c(), 0);
        byte[] b = bVar.b();
        if (b == null || b.length <= 0) {
            a(65540, 0, 0, 1);
            return;
        }
        int a = (int) b.a(b, b.length);
        Log.i("ViPER4Android", "[Kernel] Channels = " + bVar.c() + ", Frames = " + bVar.d() + ", Bytes = " + b.length + ", Hash = " + a);
        int i2 = 0;
        int length = b.length;
        int i3 = 0;
        while (length > 0) {
            int min = Math.min(8176, length);
            byte[] bArr = new byte[min];
            System.arraycopy(b, i2, bArr, 0, min);
            i2 += min;
            length -= min;
            Log.i("ViPER4Android", "Setting kernel buffer, index = " + i3 + "," + "length = " + min);
            i3++;
            a(65541, nextInt, min / 4, bArr);
        }
        byte[] bytes = str.getBytes();
        if (bytes != null) {
            i = (int) b.a(bytes, bytes.length);
        }
        a(65542, nextInt, a, i);
    }

    private void b(String str, int i, int i2) {
        int nextInt = new Random().nextInt();
        a(65540, nextInt, i, 0);
        byte[] b = V4AJniInterface.b(str);
        if (b == null || b.length <= 0) {
            a(65540, 0, 0, 1);
            return;
        }
        int[] a = V4AJniInterface.a(b);
        if (a == null || a.length != 2 || a[0] == 0) {
            a(65540, 0, 0, 1);
            return;
        }
        int i3 = a[1];
        Log.i("ViPER4Android", "[Kernel] Channels = " + i + ", Frames = " + i2 + ", Bytes = " + b.length + ", Hash = " + i3);
        int length = b.length;
        int i4 = 0;
        int i5 = 0;
        while (length > 0) {
            int min = Math.min(8176, length);
            byte[] bArr = new byte[min];
            System.arraycopy(b, i4, bArr, 0, min);
            i4 += min;
            length -= min;
            Log.i("ViPER4Android", "Setting kernel buffer, index = " + i5 + ", length = " + min);
            i5++;
            a(65541, nextInt, min / 4, bArr);
        }
        byte[] bytes = str.getBytes();
        i5 = 0;
        if (bytes != null) {
            i5 = (int) b.a(bytes, bytes.length);
        }
        a(65542, nextInt, i3, i5);
    }

    private byte[] b(int i) {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(ByteOrder.nativeOrder());
        allocate.putInt(i);
        return allocate.array();
    }

    public int a(int i) {
        try {
            byte[] bArr = new byte[4];
            b(b(i), bArr);
            return a(bArr);
        } catch (Exception e) {
            Log.i("ViPER4Android", "getParameter_px4_vx4x1: " + e.getMessage());
            return -1;
        }
    }

    public void a() {
        Log.i("ViPER4Android", "Free viper4android module.");
        if (this.a != null) {
            try {
                this.a.release();
            } catch (Exception e) {
                Log.i("ViPER4Android", "release: " + e.getMessage());
            }
        }
        this.a = null;
    }

    public void a(int i, int i2) {
        try {
            a(b(i), b(i2));
        } catch (Exception e) {
            Log.i("ViPER4Android", "setParameter_px4_vx4x1: " + e.getMessage());
        }
    }

    public void a(int i, int i2, int i3) {
        try {
            byte[] b = b(i);
            byte[] b2 = b(i2);
            byte[] b3 = b(i3);
            a(b, a(b2, b3));
        } catch (Exception e) {
            Log.i("ViPER4Android", "setParameter_px4_vx4x2: " + e.getMessage());
        }
    }

    public void a(int i, int i2, int i3, int i4) {
        try {
            byte[] b = b(i);
            byte[] b2 = b(i2);
            byte[] b3 = b(i3);
            byte[] b4 = b(i4);
            a(b, a(b2, b3, b4));
        } catch (Exception e) {
            Log.i("ViPER4Android", "setParameter_px4_vx4x3: " + e.getMessage());
        }
    }

    public void a(int i, int i2, int i3, byte[] bArr) {
        try {
            byte[] b = b(i);
            byte[] b2 = b(i2);
            byte[] b3 = b(i3);
            b2 = a(b2, b3, bArr);
            if (b2.length < 8192) {
                b3 = new byte[(8192 - b2.length)];
                b2 = a(b2, b3);
            }
            a(b, b2);
        } catch (Exception e) {
            Log.i("ViPER4Android", "setParameter_px4_vx2x8192: " + e.getMessage());
        }
    }

    public void a(int i, float[] fArr) {
        try {
            byte[] bArr;
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(fArr.length * 4)]);
            wrap.order(ByteOrder.nativeOrder());
            for (float putFloat : fArr) {
                wrap.putFloat(putFloat);
            }
            byte[] b = b(i);
            byte[] a = a(b(fArr.length / 2), bArr);
            if (a.length < 1024) {
                bArr = new byte[(1024 - a.length)];
                a = a(a, bArr);
            }
            a(b, a);
        } catch (Exception e) {
            Log.i("ViPER4Android", "setParameter_px4_vx1x1024: " + e.getMessage());
        }
    }

    public void a(String str, boolean z) {
        int i = 65591;
        if (!str.contains("Kernel")) {
            str = d.d() + str;
        }
        if (new File(str).exists()) {
            Log.i("ViPER4Android", "Convolver kernel exists");
            if (str == null) {
                Log.i("ViPER4Android", "Clear convolver kernel");
                if (z) {
                    a(65591, 0, 0, 1);
                    return;
                } else {
                    a(65540, 0, 0, 1);
                    return;
                }
            }
            Log.i("ViPER4Android", "Convolver kernel = " + str);
            if (str.equals("")) {
                Log.i("ViPER4Android", "Clear convolver kernel");
                if (z) {
                    a(65591, 0, 0, 1);
                    return;
                } else {
                    a(65540, 0, 0, 1);
                    return;
                }
            }
            int a;
            b bVar;
            int[] a2;
            byte[] bytes = str.getBytes();
            if (bytes != null) {
                a = (int) b.a(bytes, bytes.length);
                int a3 = a(32778);
                Log.i("ViPER4Android", "Kernel ID = [driver: " + a3 + ", client: " + a + "]");
                if (a == a3) {
                    a = 0;
                    if (a != 0) {
                        Log.i("ViPER4Android", "Driver is holding the same irs now");
                        return;
                    }
                    if (!z) {
                        i = 65540;
                    }
                    Log.i("ViPER4Android", "We are going to load irs through internal method");
                    bVar = new b();
                    if (bVar.a(str)) {
                        if (z) {
                            b(bVar, str);
                        } else {
                            a(bVar, str);
                        }
                        bVar.a();
                        return;
                    } else if (V4AJniInterface.b()) {
                        Log.i("ViPER4Android", "Failed to load " + str);
                        return;
                    } else {
                        Log.i("ViPER4Android", "We are going to load irs through jni");
                        a2 = V4AJniInterface.a(str);
                        if (a2 == null) {
                            a(i, 0, 0, 1);
                            return;
                        } else if (a2.length != 4) {
                            a(i, 0, 0, 1);
                            return;
                        } else if (a2[0] == 0) {
                            a(i, 0, 0, 1);
                            return;
                        } else if (z) {
                            b(str, a2[1], a2[2]);
                            return;
                        } else {
                            a(str, a2[1], a2[2]);
                            return;
                        }
                    }
                }
            }
            a = 1;
            if (a != 0) {
                if (z) {
                    i = 65540;
                }
                Log.i("ViPER4Android", "We are going to load irs through internal method");
                bVar = new b();
                if (bVar.a(str)) {
                    if (z) {
                        b(bVar, str);
                    } else {
                        a(bVar, str);
                    }
                    bVar.a();
                    return;
                } else if (V4AJniInterface.b()) {
                    Log.i("ViPER4Android", "Failed to load " + str);
                    return;
                } else {
                    Log.i("ViPER4Android", "We are going to load irs through jni");
                    a2 = V4AJniInterface.a(str);
                    if (a2 == null) {
                        a(i, 0, 0, 1);
                        return;
                    } else if (a2.length != 4) {
                        a(i, 0, 0, 1);
                        return;
                    } else if (a2[0] == 0) {
                        a(i, 0, 0, 1);
                        return;
                    } else if (z) {
                        b(str, a2[1], a2[2]);
                        return;
                    } else {
                        a(str, a2[1], a2[2]);
                        return;
                    }
                }
            }
            Log.i("ViPER4Android", "Driver is holding the same irs now");
            return;
        }
        Log.i("ViPER4Android", "Convolver kernel does not exist");
        if (z) {
            a(65591, 0, 0, 1);
        } else {
            a(65540, 0, 0, 1);
        }
    }

    public void a(byte[] bArr, byte[] bArr2) {
        if (this.a != null) {
            try {
                AudioEffect.class.getMethod("setParameter", new Class[]{byte[].class, byte[].class}).invoke(this.a, new Object[]{bArr, bArr2});
            } catch (Exception e) {
                Log.i("ViPER4Android", "setParameter_Native: " + e.getMessage());
            }
        }
    }

    public void b(byte[] bArr, byte[] bArr2) {
        if (this.a != null) {
            try {
                AudioEffect.class.getMethod("getParameter", new Class[]{byte[].class, byte[].class}).invoke(this.a, new Object[]{bArr, bArr2});
            } catch (Exception e) {
                Log.i("ViPER4Android", "getParameter_Native: " + e.getMessage());
            }
        }
    }
}
