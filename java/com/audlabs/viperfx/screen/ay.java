package com.audlabs.viperfx.screen;

import android.content.Intent;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

class ay implements OnSeekBarChangeListener {
    final /* synthetic */ PlaybackFragment a;

    ay(PlaybackFragment playbackFragment) {
        this.a = playbackFragment;
    }

    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        int i2 = -((i / 10) - 5);
        this.a.mTvPlaybackOutputVal.setText(this.a.mOutputs[i2]);
        this.a.a.edit().putString("viper4android.headphonefx.playbackgain.volume", this.a.mOutputVals[i2]).apply();
        this.a.getActivity().sendBroadcast(new Intent("com.audlabs.viperfx.UPDATE"));
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
    }
}
