package com.audlabs.viperfx.screen;

import android.content.Intent;
import com.audlabs.viperfx.widget.h;
import java.math.BigDecimal;

class aa implements h {
    final /* synthetic */ FetCompressorFragment a;

    aa(FetCompressorFragment fetCompressorFragment) {
        this.a = fetCompressorFragment;
    }

    public void a(float f) {
        int intValue = new BigDecimal((double) (f - 30.0f)).setScale(0, 4).intValue();
        this.a.mPbvFetCompressorThreshold.setProgressSync((float) intValue);
        this.a.mTvFetCompressorThresholdVal.setText(this.a.a((float) (((double) intValue) / 300.0d)));
        if (this.a.c) {
            this.a.a.edit().putString("viper4android.headphonefx.fetcompressor.threshold", (intValue / 3) + "").apply();
        } else {
            this.a.a.edit().putString("viper4android.speakerfx.fetcompressor.threshold", (intValue / 3) + "").apply();
        }
        this.a.getActivity().sendBroadcast(new Intent("com.audlabs.viperfx.UPDATE"));
    }
}
