package com.audlabs.viperfx.screen;

import android.content.Intent;
import com.audlabs.viperfx.widget.h;
import java.math.BigDecimal;

class ae implements h {
    final /* synthetic */ FetCompressorFragment a;

    ae(FetCompressorFragment fetCompressorFragment) {
        this.a = fetCompressorFragment;
    }

    public void a(float f) {
        int intValue = new BigDecimal((double) (f - 30.0f)).setScale(0, 4).intValue();
        this.a.mPbvFetCompressorMaxrelease.setProgressSync((float) intValue);
        this.a.mTvFetCompressorMaxreleaseVal.setText(this.a.i((float) (((double) intValue) / 300.0d)));
        if (this.a.c) {
            this.a.a.edit().putString("viper4android.headphonefx.fetcompressor.maxrelease", (intValue / 3) + "").apply();
        } else {
            this.a.a.edit().putString("viper4android.speakerfx.fetcompressor.maxrelease", (intValue / 3) + "").apply();
        }
        this.a.getActivity().sendBroadcast(new Intent("com.audlabs.viperfx.UPDATE"));
    }
}
