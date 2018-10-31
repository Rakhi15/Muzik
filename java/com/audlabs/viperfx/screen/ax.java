package com.audlabs.viperfx.screen;

import android.content.Intent;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

class ax implements OnSeekBarChangeListener {
    final /* synthetic */ PlaybackFragment a;

    ax(PlaybackFragment playbackFragment) {
        this.a = playbackFragment;
    }

    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        this.a.mTvPlaybackMaxgainVal.setText(this.a.mMultiFactors[i / 10]);
        this.a.a.edit().putString("viper4android.headphonefx.playbackgain.maxscaler", this.a.mMultiFactorVals[i / 10]).apply();
        this.a.getActivity().sendBroadcast(new Intent("com.audlabs.viperfx.UPDATE"));
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
    }
}
