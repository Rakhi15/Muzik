package com.audlabs.viperfx.screen;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.audlabs.viperfx.screen.VDdcFragment.VDdcAdapter;

class bk implements OnClickListener {
    final /* synthetic */ int a;
    final /* synthetic */ VDdcAdapter b;

    bk(VDdcAdapter vDdcAdapter, int i) {
        this.b = vDdcAdapter;
        this.a = i;
    }

    public void onClick(View view) {
        this.b.a.g = this.a;
        this.b.a.a.edit().putString("viper4android.headphonefx.viperddc.device", (String) this.b.a.e.get(this.a)).apply();
        this.b.e();
        this.b.a.getActivity().sendBroadcast(new Intent("com.audlabs.viperfx.UPDATE"));
    }
}
