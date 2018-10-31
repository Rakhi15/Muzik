package com.audlabs.viperfx.screen;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class w implements OnClickListener {
    final /* synthetic */ v a;

    w(v vVar) {
        this.a = vVar;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.a.a.mBtnDynamicsystemOutput.setText(this.a.a.outputsArray[i]);
        this.a.a.a.edit().putString("viper4android.headphonefx.dynamicsystem.coeffs", this.a.a.outputs[i]).apply();
        this.a.a.getActivity().sendBroadcast(new Intent("com.audlabs.viperfx.UPDATE"));
    }
}
