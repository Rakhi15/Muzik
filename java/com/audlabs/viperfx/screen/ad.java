package com.audlabs.viperfx.screen;

import android.content.Intent;
import com.audlabs.viperfx.widget.h;
import java.math.BigDecimal;

class ad implements h {
    final /* synthetic */ FetCompressorFragment a;

    ad(FetCompressorFragment fetCompressorFragment) {
        this.a = fetCompressorFragment;
    }

    public void a(float f) {
        int intValue = new BigDecimal((double) (f - 30.0f)).setScale(0, 4).intValue();
        this.a.mPbvFetCompressorMaxattack.setProgressSync((float) intValue);
        this.a.mTvFetCompressorMaxattackVal.setText(this.a.h((float) (((double) intValue) / 300.0d)));
        if (this.a.c) {
            this.a.a.edit().putString("viper4android.headphonefx.fetcompressor.maxattack", (intValue / 3) + "").apply();
        } else {
            this.a.a.edit().putString("viper4android.speakerfx.fetcompressor.maxattack", (intValue / 3) + "").apply();
        }
        this.a.getActivity().sendBroadcast(new Intent("com.audlabs.viperfx.UPDATE"));
    }
}
