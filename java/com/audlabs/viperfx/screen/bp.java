package com.audlabs.viperfx.screen;

import android.content.Intent;
import com.audlabs.viperfx.widget.h;
import java.math.BigDecimal;

class bp implements h {
    final /* synthetic */ VseFragment a;

    bp(VseFragment vseFragment) {
        this.a = vseFragment;
    }

    public void a(float f) {
        int intValue = new BigDecimal((double) (f - 30.0f)).setScale(0, 4).intValue() / 3;
        this.a.mPbvVse.setProgressSync((float) intValue);
        this.a.mTvVseVal.setText((((double) intValue) / 100.0d) + "");
        this.a.a.edit().putString("viper4android.headphonefx.vse.value", (((double) intValue) / 100.0d) + "").apply();
        this.a.getActivity().sendBroadcast(new Intent("com.audlabs.viperfx.UPDATE"));
    }
}
