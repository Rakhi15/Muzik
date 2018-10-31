package com.audlabs.viperfx.screen;

import android.content.Intent;
import com.audlabs.viperfx.widget.h;
import java.math.BigDecimal;

class t implements h {
    final /* synthetic */ DiffsurrFragment a;

    t(DiffsurrFragment diffsurrFragment) {
        this.a = diffsurrFragment;
    }

    public void a(float f) {
        int intValue = new BigDecimal((double) (f / 30.0f)).setScale(0, 4).intValue();
        if (!this.a.diffsurroundDelayVals[intValue - 2].equals(this.a.a.getString("viper4android.headphonefx.diffsurr.delay", "500"))) {
            this.a.mTvDiffsurrVal.setText(this.a.diffsurroundDelays[intValue - 2]);
            this.a.b.setRotate((float) (intValue * 30), this.a.c, this.a.d);
            this.a.mIVKnobPoint.setImageMatrix(this.a.b);
            this.a.a.edit().putString("viper4android.headphonefx.diffsurr.delay", this.a.diffsurroundDelayVals[intValue - 2] + "").apply();
            this.a.getActivity().sendBroadcast(new Intent("com.audlabs.viperfx.UPDATE"));
        }
    }
}
