package com.audlabs.viperfx.screen;

import android.content.Intent;
import com.audlabs.viperfx.widget.h;
import java.math.BigDecimal;

class a implements h {
    final /* synthetic */ AnalogxFragment a;

    a(AnalogxFragment analogxFragment) {
        this.a = analogxFragment;
    }

    public void a(float f) {
        int intValue = new BigDecimal((double) (f / 45.0f)).setScale(0, 4).intValue();
        if (intValue - 3 != Integer.valueOf(this.a.a.getString("viper4android.headphonefx.analogx.mode", "0")).intValue()) {
            this.a.b.setRotate((float) (intValue * 45), this.a.c, this.a.d);
            this.a.mIVKnobPoint.setImageMatrix(this.a.b);
            this.a.a.edit().putString("viper4android.headphonefx.analogx.mode", (intValue - 3) + "").apply();
            this.a.getActivity().sendBroadcast(new Intent("com.audlabs.viperfx.UPDATE"));
        }
    }
}
