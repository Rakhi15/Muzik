package com.audlabs.viperfx.screen;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class ap implements OnClickListener {
    final /* synthetic */ FetCompressorFragment a;

    ap(FetCompressorFragment fetCompressorFragment) {
        this.a = fetCompressorFragment;
    }

    public void onClick(View view) {
        if (this.a.mFetCompressorAutoreleaseEnable.isChecked()) {
            this.a.mTrbFetCompressorRelease.setDisable(true);
            this.a.mPbvFetCompressorRelease.setColorId(this.a.getResources().getColor(2131492906));
            this.a.mTrbFetCompressorMaxrelease.setDisable(false);
            this.a.mPbvFetCompressorMaxrelease.setColorId(this.a.getResources().getColor(2131492877));
        } else {
            this.a.mTrbFetCompressorRelease.setDisable(false);
            this.a.mPbvFetCompressorRelease.setColorId(this.a.getResources().getColor(2131492877));
            this.a.mTrbFetCompressorMaxrelease.setDisable(true);
            this.a.mPbvFetCompressorMaxrelease.setColorId(this.a.getResources().getColor(2131492906));
        }
        if (this.a.c) {
            this.a.a.edit().putBoolean("viper4android.headphonefx.fetcompressor.autorelease", this.a.mFetCompressorAutoreleaseEnable.isChecked()).apply();
        } else {
            this.a.a.edit().putBoolean("viper4android.speakerfx.fetcompressor.autorelease", this.a.mFetCompressorAutoreleaseEnable.isChecked()).apply();
        }
        this.a.getActivity().sendBroadcast(new Intent("com.audlabs.viperfx.UPDATE"));
    }
}
