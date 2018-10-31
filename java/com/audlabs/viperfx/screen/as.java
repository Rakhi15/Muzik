package com.audlabs.viperfx.screen;

import com.audlabs.viperfx.widget.g;

class as implements g {
    final /* synthetic */ FireqFragment a;

    as(FireqFragment fireqFragment) {
        this.a = fireqFragment;
    }

    public void a(int i) {
        this.a.b = i;
        this.a.a(this.a.b);
        if (this.a.b >= this.a.mEQPresetNames.length - 1) {
            this.a.a.edit().putString("viper4android.headphonefx.fireq", "custom").apply();
        } else {
            this.a.a.edit().putString("viper4android.headphonefx.fireq", (String) this.a.c.get(this.a.b)).apply();
            this.a.a.edit().putString("viper4android.headphonefx.fireq.custom", (String) this.a.c.get(this.a.b)).apply();
        }
        if (this.a.d != null) {
            this.a.d.a(null);
        }
    }
}
