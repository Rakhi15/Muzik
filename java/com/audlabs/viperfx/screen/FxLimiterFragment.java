package com.audlabs.viperfx.screen;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import butterknife.BindArray;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.audlabs.viperfx.base.b;
import java.util.Arrays;

public class FxLimiterFragment extends b implements OnClickListener, OnSeekBarChangeListener {
    @BindView
    CheckBox mLimiterEnable;
    @BindView
    CheckBox mOutputGainEnable;
    @BindView
    CheckBox mOutputPanEnable;
    @BindArray
    String[] mOutputVals;
    @BindArray
    String[] mOutputVolVals;
    @BindArray
    String[] mOutputVols;
    @BindArray
    String[] mOutputs;
    @BindView
    SeekBar mSbLimiter;
    @BindView
    SeekBar mSbOutputGain;
    @BindView
    SeekBar mSbOutputPan;
    @BindView
    TextView mTvLimiterVal;
    @BindView
    TextView mTvOutputGainVal;
    @BindView
    TextView mTvOutputPanVal;

    private void a() {
        this.mOutputPanEnable.setOnClickListener(this);
        this.mOutputGainEnable.setOnClickListener(this);
        this.mLimiterEnable.setOnClickListener(this);
        this.mSbOutputPan.setOnSeekBarChangeListener(this);
        this.mSbOutputGain.setOnSeekBarChangeListener(this);
        this.mSbLimiter.setOnSeekBarChangeListener(this);
    }

    private void b() {
        this.mSbOutputPan.setProgress(Integer.valueOf(this.a.getString("viper4android.headphonefx.channelpan", "0")).intValue() + 100);
        this.mTvOutputPanVal.setText(this.a.getString("viper4android.headphonefx.channelpan", "0"));
        int indexOf = Arrays.asList(this.mOutputVolVals).indexOf(this.a.getString("viper4android.headphonefx.outvol", "100"));
        this.mSbOutputGain.setProgress(((-indexOf) + 21) * 10);
        this.mTvOutputGainVal.setText(this.mOutputVols[indexOf]);
        indexOf = Arrays.asList(this.mOutputVals).indexOf(this.a.getString("viper4android.headphonefx.limiter", "100"));
        this.mSbLimiter.setProgress(((-indexOf) + 5) * 10);
        this.mTvLimiterVal.setText(this.mOutputs[indexOf]);
    }

    public void onClick(View view) {
        if (view.getId() == this.mOutputPanEnable.getId()) {
            this.mOutputPanEnable.setChecked(true);
        } else if (view.getId() == this.mOutputGainEnable.getId()) {
            this.mOutputGainEnable.setChecked(true);
        } else if (view.getId() == this.mLimiterEnable.getId()) {
            this.mLimiterEnable.setChecked(true);
        }
        getActivity().sendBroadcast(new Intent("com.audlabs.viperfx.UPDATE"));
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(2130968629, viewGroup, false);
        ButterKnife.a(this, inflate);
        a();
        b();
        return inflate;
    }

    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        if (seekBar.getId() == this.mSbOutputPan.getId()) {
            this.mTvOutputPanVal.setText((i - 100) + "");
            this.a.edit().putString("viper4android.headphonefx.channelpan", (i - 100) + "").apply();
        } else if (seekBar.getId() == this.mSbOutputGain.getId()) {
            r0 = -((i / 10) - 21);
            this.mTvOutputGainVal.setText(this.mOutputVols[r0]);
            this.a.edit().putString("viper4android.headphonefx.outvol", this.mOutputVolVals[r0]).apply();
        } else if (seekBar.getId() == this.mSbLimiter.getId()) {
            r0 = -((i / 10) - 5);
            this.mTvLimiterVal.setText(this.mOutputs[r0]);
            this.a.edit().putString("viper4android.headphonefx.limiter", this.mOutputVals[r0]).apply();
        }
        getActivity().sendBroadcast(new Intent("com.audlabs.viperfx.UPDATE"));
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
    }
}
