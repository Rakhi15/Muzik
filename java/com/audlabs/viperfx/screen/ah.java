package com.audlabs.viperfx.screen;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class ah implements OnClickListener {
    final /* synthetic */ FetCompressorFragment a;

    ah(FetCompressorFragment fetCompressorFragment) {
        this.a = fetCompressorFragment;
    }

    public void onClick(View view) {
        if (this.a.c) {
            this.a.a.edit().putBoolean("viper4android.headphonefx.fetcompressor.noclipenable", this.a.mFetCompressorNoclipenableEnable.isChecked()).apply();
        } else {
            this.a.a.edit().putBoolean("viper4android.speakerfx.fetcompressor.noclipenable", this.a.mFetCompressorNoclipenableEnable.isChecked()).apply();
        }
        this.a.getActivity().sendBroadcast(new Intent("com.audlabs.viperfx.UPDATE"));
    }
}
