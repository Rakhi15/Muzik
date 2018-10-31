package com.audlabs.viperfx.screen;

import android.content.Intent;
import com.audlabs.viperfx.widget.h;
import java.math.BigDecimal;

class d implements h {
    final /* synthetic */ ColorfulmusicFragment a;

    d(ColorfulmusicFragment colorfulmusicFragment) {
        this.a = colorfulmusicFragment;
    }

    public void a(float f) {
        int intValue = new BigDecimal(((double) f) / 22.5d).setScale(0, 4).intValue();
        if (!((String) this.a.c.get(intValue - 3)).equals(this.a.a.getString("viper4android.headphonefx.colorfulmusic.midimage", "150"))) {
            this.a.mTvColorfulmusicMiVal.setText(this.a.mMidimageArrs[intValue - 3]);
            this.a.d.setRotate((float) (((double) intValue) * 22.5d), this.a.e, this.a.f);
            this.a.mIVKnobPointMi.setImageMatrix(this.a.d);
            this.a.a.edit().putString("viper4android.headphonefx.colorfulmusic.midimage", (String) this.a.c.get(intValue - 3)).apply();
            this.a.getActivity().sendBroadcast(new Intent("com.audlabs.viperfx.UPDATE"));
        }
    }
}
