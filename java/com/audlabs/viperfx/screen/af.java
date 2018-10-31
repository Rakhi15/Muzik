package com.audlabs.viperfx.screen;

import android.content.Intent;
import com.audlabs.viperfx.widget.h;
import java.math.BigDecimal;

class af implements h {
    final /* synthetic */ FetCompressorFragment a;

    af(FetCompressorFragment fetCompressorFragment) {
        this.a = fetCompressorFragment;
    }

    public void a(float f) {
        int intValue = new BigDecimal((double) (f - 30.0f)).setScale(0, 4).intValue();
        this.a.mPbvFetCompressorCrest.setProgressSync((float) intValue);
        this.a.mTvFetCompressorCrestVal.setText(this.a.j((float) (((double) intValue) / 300.0d)));
        if (this.a.c) {
            this.a.a.edit().putString("viper4android.headphonefx.fetcompressor.crest", (intValue / 3) + "").apply();
        } else {
            this.a.a.edit().putString("viper4android.speakerfx.fetcompressor.crest", (intValue / 3) + "").apply();
        }
        this.a.getActivity().sendBroadcast(new Intent("com.audlabs.viperfx.UPDATE"));
    }
}
