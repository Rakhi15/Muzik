package com.audlabs.viperfx.screen;

import android.content.Intent;
import com.audlabs.viperfx.widget.h;
import java.math.BigDecimal;

class bc implements h {
    final /* synthetic */ VBassFragment a;

    bc(VBassFragment vBassFragment) {
        this.a = vBassFragment;
    }

    public void a(float f) {
        int intValue = new BigDecimal((double) (f - 30.0f)).setScale(0, 4).intValue();
        this.a.mPbvBassFreq.setProgressSync((float) intValue);
        this.a.mTvBassFreqVal.setText((intValue / 3) + "HZ");
        this.a.a.edit().putString("viper4android.headphonefx.fidelity.bass.freq", (intValue / 3) + "").apply();
        this.a.getActivity().sendBroadcast(new Intent("com.audlabs.viperfx.UPDATE"));
    }
}
