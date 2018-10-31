package com.audlabs.viperfx.screen;

import android.content.Intent;
import com.audlabs.viperfx.widget.h;
import java.math.BigDecimal;

class i implements h {
    final /* synthetic */ ConvolverFragment a;

    i(ConvolverFragment convolverFragment) {
        this.a = convolverFragment;
    }

    public void a(float f) {
        int intValue = new BigDecimal((double) (f - 30.0f)).setScale(0, 4).intValue();
        this.a.mPbvConvolverCrosschannel.setProgressSync((float) intValue);
        this.a.mTvConvolverCrosschannelVal.setText((intValue / 3) + "%");
        this.a.a.edit().putString("viper4android.headphonefx.convolver.crosschannel", (intValue / 3) + "").apply();
        this.a.getActivity().sendBroadcast(new Intent("com.audlabs.viperfx.UPDATE"));
    }
}
