package com.audlabs.viperfx.screen;

import android.content.Intent;
import com.audlabs.viperfx.widget.h;
import java.math.BigDecimal;

class y implements h {
    final /* synthetic */ DynamicsystemFragment a;

    y(DynamicsystemFragment dynamicsystemFragment) {
        this.a = dynamicsystemFragment;
    }

    public void a(float f) {
        int intValue = new BigDecimal((double) (f - 30.0f)).setScale(0, 4).intValue() / 3;
        this.a.mPbvDynamicsystemBass.setProgressSync((float) intValue);
        this.a.mTvDynamicsystemBassVal.setText(intValue + "%");
        this.a.a.edit().putString("viper4android.headphonefx.dynamicsystem.bass", intValue + "").apply();
        this.a.getActivity().sendBroadcast(new Intent("com.audlabs.viperfx.UPDATE"));
    }
}
