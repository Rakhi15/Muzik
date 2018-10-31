package com.audlabs.viperfx.screen;

import android.content.Intent;
import com.audlabs.viperfx.widget.h;
import java.math.BigDecimal;

class bn implements h {
    final /* synthetic */ VhsFragment a;

    bn(VhsFragment vhsFragment) {
        this.a = vhsFragment;
    }

    public void a(float f) {
        int intValue = new BigDecimal((double) (f / 45.0f)).setScale(0, 4).intValue();
        if (intValue - 2 != Integer.valueOf(this.a.a.getString("viper4android.headphonefx.vhs.qual", "0")).intValue()) {
            this.a.mTvVshVal.setText(this.a.vhsQual[intValue - 2]);
            this.a.b.setRotate((float) (intValue * 45), this.a.c, this.a.d);
            this.a.mIVKnobPoint.setImageMatrix(this.a.b);
            this.a.a.edit().putString("viper4android.headphonefx.vhs.qual", (intValue - 2) + "").apply();
            this.a.getActivity().sendBroadcast(new Intent("com.audlabs.viperfx.UPDATE"));
        }
    }
}
