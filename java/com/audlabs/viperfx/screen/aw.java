package com.audlabs.viperfx.screen;

import android.content.Intent;
import com.audlabs.viperfx.widget.h;
import java.math.BigDecimal;

class aw implements h {
    final /* synthetic */ PlaybackFragment a;

    aw(PlaybackFragment playbackFragment) {
        this.a = playbackFragment;
    }

    public void a(float f) {
        int intValue = new BigDecimal((double) (f / 45.0f)).setScale(0, 4).intValue();
        if (!this.a.mRatioVals[intValue - 3].equals(this.a.a.getString("viper4android.headphonefx.playbackgain.ratio", "50"))) {
            this.a.b.setRotate((float) (intValue * 45), this.a.c, this.a.d);
            this.a.mIVKnobPoint.setImageMatrix(this.a.b);
            this.a.a.edit().putString("viper4android.headphonefx.playbackgain.ratio", this.a.mRatioVals[intValue - 3]).apply();
            this.a.getActivity().sendBroadcast(new Intent("com.audlabs.viperfx.UPDATE"));
        }
    }
}
