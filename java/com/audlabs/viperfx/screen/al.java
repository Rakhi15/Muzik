package com.audlabs.viperfx.screen;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class al implements OnClickListener {
    final /* synthetic */ FetCompressorFragment a;

    al(FetCompressorFragment fetCompressorFragment) {
        this.a = fetCompressorFragment;
    }

    public void onClick(View view) {
        if (this.a.mFetCompressorAutogainEnable.isChecked()) {
            this.a.mTrbFetCompressorGain.setDisable(true);
            this.a.mPbvFetCompressorGain.setColorId(this.a.getResources().getColor(2131492906));
        } else {
            this.a.mTrbFetCompressorGain.setDisable(false);
            this.a.mPbvFetCompressorGain.setColorId(this.a.getResources().getColor(2131492877));
        }
        if (this.a.c) {
            this.a.a.edit().putBoolean("viper4android.headphonefx.fetcompressor.autogain", this.a.mFetCompressorAutogainEnable.isChecked()).apply();
        } else {
            this.a.a.edit().putBoolean("viper4android.speakerfx.fetcompressor.autogain", this.a.mFetCompressorAutogainEnable.isChecked()).apply();
        }
        this.a.getActivity().sendBroadcast(new Intent("com.audlabs.viperfx.UPDATE"));
    }
}
