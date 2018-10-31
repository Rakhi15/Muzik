package com.audlabs.viperfx.screen;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class aj implements OnClickListener {
    final /* synthetic */ FetCompressorFragment a;

    aj(FetCompressorFragment fetCompressorFragment) {
        this.a = fetCompressorFragment;
    }

    public void onClick(View view) {
        if (this.a.mFetCompressorAutokneeEnable.isChecked()) {
            this.a.mTrbFetCompressorKnee.setDisable(true);
            this.a.mPbvFetCompressorKnee.setColorId(this.a.getResources().getColor(2131492906));
            this.a.mTrbFetCompressorKneemulti.setDisable(false);
            this.a.mPbvFetCompressorKneemulti.setColorId(this.a.getResources().getColor(2131492877));
        } else {
            this.a.mTrbFetCompressorKnee.setDisable(false);
            this.a.mPbvFetCompressorKnee.setColorId(this.a.getResources().getColor(2131492877));
            this.a.mTrbFetCompressorKneemulti.setDisable(true);
            this.a.mPbvFetCompressorKneemulti.setColorId(this.a.getResources().getColor(2131492906));
        }
        if (this.a.c) {
            this.a.a.edit().putBoolean("viper4android.headphonefx.fetcompressor.autoknee", this.a.mFetCompressorAutokneeEnable.isChecked()).apply();
        } else {
            this.a.a.edit().putBoolean("viper4android.speakerfx.fetcompressor.autoknee", this.a.mFetCompressorAutokneeEnable.isChecked()).apply();
        }
        this.a.getActivity().sendBroadcast(new Intent("com.audlabs.viperfx.UPDATE"));
    }
}
