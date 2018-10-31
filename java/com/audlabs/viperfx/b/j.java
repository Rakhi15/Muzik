package com.audlabs.viperfx.b;

import android.media.audiofx.AudioEffect;
import android.media.audiofx.AudioEffect.Descriptor;
import android.util.Log;
import com.audlabs.viperfx.service.ViPER4AndroidService;

public class j {
    final /* synthetic */ e a;
    private Descriptor[] b;
    private boolean c;
    private final int[] d = new int[4];

    public j(e eVar) {
        this.a = eVar;
        try {
            this.b = AudioEffect.queryEffects();
            if (this.b == null) {
                this.c = false;
                this.d[0] = 0;
                this.d[1] = 0;
                this.d[2] = 0;
                this.d[3] = 0;
                Log.e("ViPER4Android", "Failed to query audio effects");
                return;
            }
            Descriptor descriptor = null;
            Log.i("ViPER4Android", "Found " + this.b.length + " effects");
            for (int i = 0; i < this.b.length; i++) {
                if (this.b[i] != null) {
                    try {
                        Descriptor descriptor2 = this.b[i];
                        Log.i("ViPER4Android", "[" + (i + 1) + "], " + descriptor2.name + ", " + descriptor2.implementor);
                        if (descriptor2.uuid.equals(ViPER4AndroidService.b)) {
                            Log.i("ViPER4Android", "Perfect, found ViPER4Android engine at " + (i + 1));
                        } else {
                            descriptor2 = descriptor;
                        }
                        descriptor = descriptor2;
                    } catch (Exception e) {
                        Log.e("ViPER4Android", "AudioEffect Descriptor error , msg = " + e.getMessage());
                    }
                }
            }
            if (descriptor == null) {
                Log.i("ViPER4Android", "ViPER4Android engine not found");
                this.c = false;
                this.d[0] = 0;
                this.d[1] = 0;
                this.d[2] = 0;
                this.d[3] = 0;
                return;
            }
            try {
                String str = descriptor.name;
                if (str.contains("[") && str.contains("]") && str.length() >= 23) {
                    str = str.substring(15);
                    while (str.endsWith("]")) {
                        str = str.substring(0, str.length() - 1);
                    }
                    String[] split = str.split("\\.");
                    if (split.length == 4) {
                        this.d[0] = Integer.parseInt(split[0]);
                        this.d[1] = Integer.parseInt(split[1]);
                        this.d[2] = Integer.parseInt(split[2]);
                        this.d[3] = Integer.parseInt(split[3]);
                    }
                    Log.i("ViPER4Android", "The version of ViPER4Android engine is " + this.d[0] + "." + this.d[1] + "." + this.d[2] + "." + this.d[3]);
                    this.c = true;
                    return;
                }
            } catch (Exception e2) {
                Log.e("ViPER4Android", "ViPER4Android engine version exception: " + e2.getMessage());
            }
            Log.e("ViPER4Android", "Cannot extract ViPER4Android engine version");
            this.c = false;
            this.d[0] = 0;
            this.d[1] = 0;
            this.d[2] = 0;
            this.d[3] = 0;
        } catch (Exception e3) {
            this.b = null;
            this.c = false;
            this.d[0] = 0;
            this.d[1] = 0;
            this.d[2] = 0;
            this.d[3] = 0;
            Log.e("ViPER4Android", "Failed to query audio effects");
        }
    }

    public boolean a() {
        return this.c;
    }

    public int[] b() {
        return this.d;
    }
}
