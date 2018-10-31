package com.audlabs.viperfx.screen;

import android.content.Intent;
import com.audlabs.viperfx.widget.h;
import java.math.BigDecimal;

class bd implements h {
    final /* synthetic */ VBassFragment a;

    bd(VBassFragment vBassFragment) {
        this.a = vBassFragment;
    }

    public void a(float f) {
        int intValue = new BigDecimal((((double) f) - 56.25d) / 22.5d).setScale(0, 4).intValue();
        if (!this.a.vbassBoostVals[intValue].equals(this.a.a.getString("viper4android.headphonefx.fidelity.bass.gain", "50"))) {
            this.a.mTvBassGainVal.setText(this.a.vbassBoosts[intValue]);
            this.a.b.setRotate((float) ((((double) intValue) * 22.5d) + 56.25d), this.a.c, this.a.d);
            this.a.mIVKnobPoint.setImageMatrix(this.a.b);
            this.a.a.edit().putString("viper4android.headphonefx.fidelity.bass.gain", this.a.vbassBoostVals[intValue]).apply();
            this.a.getActivity().sendBroadcast(new Intent("com.audlabs.viperfx.UPDATE"));
        }
    }
}
