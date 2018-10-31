package com.audlabs.viperfx.screen;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import butterknife.BindArray;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.audlabs.viperfx.base.b;

public class ReverbFragment extends b implements OnSeekBarChangeListener {
    @BindArray
    String[] mReverbRoomsizes;
    @BindArray
    String[] mReverbRoomwidts;
    @BindView
    SeekBar mSbReverbDamp;
    @BindView
    SeekBar mSbReverbDry;
    @BindView
    SeekBar mSbReverbRoomsize;
    @BindView
    SeekBar mSbReverbWet;
    @BindView
    SeekBar mSbReverbWidth;
    @BindView
    TextView mTvReverbDampVal;
    @BindView
    TextView mTvReverbDryVal;
    @BindView
    TextView mTvReverbRoomsizeVal;
    @BindView
    TextView mTvReverbWetVal;
    @BindView
    TextView mTvReverbWidthVal;

    private void a() {
        this.mSbReverbRoomsize.setOnSeekBarChangeListener(this);
        this.mSbReverbWidth.setOnSeekBarChangeListener(this);
        this.mSbReverbDamp.setOnSeekBarChangeListener(this);
        this.mSbReverbWet.setOnSeekBarChangeListener(this);
        this.mSbReverbDry.setOnSeekBarChangeListener(this);
    }

    private void b() {
        int intValue = Integer.valueOf(this.a.getString("viper4android.headphonefx.reverb.roomsize", "0")).intValue();
        this.mSbReverbRoomsize.setProgress(intValue);
        this.mTvReverbRoomsizeVal.setText(this.mReverbRoomsizes[intValue / 10]);
        intValue = Integer.valueOf(this.a.getString("viper4android.headphonefx.reverb.roomwidth", "0")).intValue();
        this.mSbReverbWidth.setProgress(intValue);
        this.mTvReverbWidthVal.setText(this.mReverbRoomwidts[intValue / 10]);
        intValue = Integer.valueOf(this.a.getString("viper4android.headphonefx.reverb.damp", "0")).intValue();
        this.mSbReverbDamp.setProgress(intValue);
        this.mTvReverbDampVal.setText(intValue + "%");
        intValue = Integer.valueOf(this.a.getString("viper4android.headphonefx.reverb.wet", "0")).intValue();
        this.mSbReverbWet.setProgress(intValue);
        this.mTvReverbWetVal.setText(intValue + "%");
        intValue = Integer.valueOf(this.a.getString("viper4android.headphonefx.reverb.dry", "50")).intValue();
        this.mSbReverbDry.setProgress(intValue);
        this.mTvReverbDryVal.setText(intValue + "%");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(2130968631, viewGroup, false);
        ButterKnife.a(this, inflate);
        a();
        b();
        return inflate;
    }

    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        switch (seekBar.getId()) {
            case 2131558651:
                this.mTvReverbRoomsizeVal.setText(this.mReverbRoomsizes[i / 10]);
                this.a.edit().putString("viper4android.headphonefx.reverb.roomsize", i + "").apply();
                break;
            case 2131558654:
                this.mTvReverbWidthVal.setText(this.mReverbRoomwidts[i / 10]);
                this.a.edit().putString("viper4android.headphonefx.reverb.roomwidth", i + "").apply();
                break;
            case 2131558657:
                this.mTvReverbDampVal.setText(i + "%");
                this.a.edit().putString("viper4android.headphonefx.reverb.damp", i + "").apply();
                break;
            case 2131558660:
                this.mTvReverbWetVal.setText(i + "%");
                this.a.edit().putString("viper4android.headphonefx.reverb.wet", i + "").apply();
                break;
            case 2131558663:
                this.mTvReverbDryVal.setText(i + "%");
                this.a.edit().putString("viper4android.headphonefx.reverb.dry", i + "").apply();
                break;
        }
        getActivity().sendBroadcast(new Intent("com.audlabs.viperfx.UPDATE"));
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
    }
}
