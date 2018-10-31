package com.audlabs.viperfx.screen;

import android.content.Intent;
import com.audlabs.viperfx.widget.h;
import java.math.BigDecimal;

class c implements h {
    final /* synthetic */ ColorfulmusicFragment a;

    c(ColorfulmusicFragment colorfulmusicFragment) {
        this.a = colorfulmusicFragment;
    }

    public void a(float f) {
        int intValue = new BigDecimal((double) (f / 30.0f)).setScale(0, 4).intValue();
        if (!((String) this.a.b.get(intValue - 2)).equals(this.a.a.getString("viper4android.headphonefx.colorfulmusic.coeffs", "120;200"))) {
            this.a.mTvColorfulmusicVal.setText(this.a.mCoeffArrs[intValue - 2]);
            this.a.d.setRotate((float) (intValue * 30), this.a.e, this.a.f);
            this.a.mIVKnobPoint.setImageMatrix(this.a.d);
            this.a.a.edit().putString("viper4android.headphonefx.colorfulmusic.coeffs", (String) this.a.b.get(intValue - 2)).apply();
            this.a.getActivity().sendBroadcast(new Intent("com.audlabs.viperfx.UPDATE"));
        }
    }
}
