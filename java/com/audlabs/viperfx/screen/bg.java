package com.audlabs.viperfx.screen;

import android.content.Intent;
import com.audlabs.viperfx.widget.h;
import java.math.BigDecimal;

class bg implements h {
    final /* synthetic */ VClarityFragment a;

    bg(VClarityFragment vClarityFragment) {
        this.a = vClarityFragment;
    }

    public void a(float f) {
        int intValue = new BigDecimal((double) ((f - 45.0f) / 30.0f)).setScale(0, 4).intValue();
        if (!this.a.vclartyBoostVals[intValue].equals(this.a.a.getString("viper4android.headphonefx.fidelity.clarity.gain", "50"))) {
            this.a.mTvClartyVal.setText(this.a.vclartyBoosts[intValue]);
            this.a.c.setRotate((float) ((intValue * 30) + 45), this.a.d, this.a.e);
            this.a.mIVKnobPoint.setImageMatrix(this.a.c);
            this.a.a.edit().putString("viper4android.headphonefx.fidelity.clarity.gain", this.a.vclartyBoostVals[intValue]).apply();
            this.a.getActivity().sendBroadcast(new Intent("com.audlabs.viperfx.UPDATE"));
        }
    }
}
