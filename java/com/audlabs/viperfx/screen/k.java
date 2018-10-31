package com.audlabs.viperfx.screen;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.audlabs.viperfx.screen.ConvolverFragment.VDdcAdapter;

class k implements OnClickListener {
    final /* synthetic */ int a;
    final /* synthetic */ VDdcAdapter b;

    k(VDdcAdapter vDdcAdapter, int i) {
        this.b = vDdcAdapter;
        this.a = i;
    }

    public void onClick(View view) {
        this.b.a.c = this.a;
        this.b.a.mBtnConvolverKnl.setText((CharSequence) this.b.a.e.get(this.a));
        this.b.a.a.edit().putString("viper4android.headphonefx.convolver.kernel", (String) this.b.a.e.get(this.a)).apply();
        this.b.a.mLayoutConvolverKnlSearch.startAnimation(this.b.a.h);
        this.b.a.mLayoutConvolverKnlSearch.setVisibility(4);
        this.b.a.h.setAnimationListener(new l(this));
        this.b.a.getActivity().sendBroadcast(new Intent("com.audlabs.viperfx.UPDATE"));
    }
}
