package com.audlabs.viperfx.screen;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class an implements OnClickListener {
    final /* synthetic */ FetCompressorFragment a;

    an(FetCompressorFragment fetCompressorFragment) {
        this.a = fetCompressorFragment;
    }

    public void onClick(View view) {
        if (this.a.mFetCompressorAutoattackEnable.isChecked()) {
            this.a.mTrbFetCompressorAttack.setDisable(true);
            this.a.mPbvFetCompressorAttack.setColorId(this.a.getResources().getColor(2131492906));
            this.a.mTrbFetCompressorMaxattack.setDisable(false);
            this.a.mPbvFetCompressorMaxattack.setColorId(this.a.getResources().getColor(2131492877));
        } else {
            this.a.mTrbFetCompressorAttack.setDisable(false);
            this.a.mPbvFetCompressorAttack.setColorId(this.a.getResources().getColor(2131492877));
            this.a.mTrbFetCompressorMaxattack.setDisable(true);
            this.a.mPbvFetCompressorMaxattack.setColorId(this.a.getResources().getColor(2131492906));
        }
        if (this.a.c) {
            this.a.a.edit().putBoolean("viper4android.headphonefx.fetcompressor.autoattack", this.a.mFetCompressorAutoattackEnable.isChecked()).apply();
        } else {
            this.a.a.edit().putBoolean("viper4android.speakerfx.fetcompressor.autoattack", this.a.mFetCompressorAutoattackEnable.isChecked()).apply();
        }
        this.a.getActivity().sendBroadcast(new Intent("com.audlabs.viperfx.UPDATE"));
    }
}
