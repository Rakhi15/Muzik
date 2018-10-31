package com.audlabs.viperfx.screen;

import com.audlabs.viperfx.widget.e;

class at implements e {
    final /* synthetic */ FireqFragment a;

    at(FireqFragment fireqFragment) {
        this.a = fireqFragment;
    }

    public void a() {
        this.a.b = this.a.mEQPresetNames.length - 1;
        this.a.mEqGallery.setSelection(this.a.b);
    }

    public void a(float[] fArr) {
        if (this.a.b >= this.a.mEQPresetNames.length - 1) {
            StringBuilder stringBuilder = new StringBuilder();
            for (float append : fArr) {
                stringBuilder.append(append).append(";");
            }
            this.a.a.edit().putString("viper4android.headphonefx.fireq.custom", stringBuilder.toString()).apply();
        }
        if (this.a.d != null) {
            this.a.d.a(fArr);
        }
    }
}
