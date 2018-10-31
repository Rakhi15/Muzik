package com.audlabs.viperfx.screen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.audlabs.viperfx.base.b;
import com.audlabs.viperfx.widget.ProgressBarView;
import com.audlabs.viperfx.widget.TouchRotateButton;
import java.text.DecimalFormat;

public class FetCompressorFragment extends b {
    private DecimalFormat b = new DecimalFormat("#0.00");
    private boolean c = true;
    @BindView
    CheckBox mFetCompressorAutoattackEnable;
    @BindView
    CheckBox mFetCompressorAutogainEnable;
    @BindView
    CheckBox mFetCompressorAutokneeEnable;
    @BindView
    CheckBox mFetCompressorAutoreleaseEnable;
    @BindView
    CheckBox mFetCompressorNoclipenableEnable;
    @BindView
    ProgressBarView mPbvFetCompressorAdapt;
    @BindView
    ProgressBarView mPbvFetCompressorAttack;
    @BindView
    ProgressBarView mPbvFetCompressorCrest;
    @BindView
    ProgressBarView mPbvFetCompressorGain;
    @BindView
    ProgressBarView mPbvFetCompressorKnee;
    @BindView
    ProgressBarView mPbvFetCompressorKneemulti;
    @BindView
    ProgressBarView mPbvFetCompressorMaxattack;
    @BindView
    ProgressBarView mPbvFetCompressorMaxrelease;
    @BindView
    ProgressBarView mPbvFetCompressorRatio;
    @BindView
    ProgressBarView mPbvFetCompressorRelease;
    @BindView
    ProgressBarView mPbvFetCompressorThreshold;
    @BindView
    TouchRotateButton mTrbFetCompressorAdapt;
    @BindView
    TouchRotateButton mTrbFetCompressorAttack;
    @BindView
    TouchRotateButton mTrbFetCompressorCrest;
    @BindView
    TouchRotateButton mTrbFetCompressorGain;
    @BindView
    TouchRotateButton mTrbFetCompressorKnee;
    @BindView
    TouchRotateButton mTrbFetCompressorKneemulti;
    @BindView
    TouchRotateButton mTrbFetCompressorMaxattack;
    @BindView
    TouchRotateButton mTrbFetCompressorMaxrelease;
    @BindView
    TouchRotateButton mTrbFetCompressorRatio;
    @BindView
    TouchRotateButton mTrbFetCompressorRelease;
    @BindView
    TouchRotateButton mTrbFetCompressorThreshold;
    @BindView
    TextView mTvFetCompressorAdaptVal;
    @BindView
    TextView mTvFetCompressorAttackVal;
    @BindView
    TextView mTvFetCompressorCrestVal;
    @BindView
    TextView mTvFetCompressorGainVal;
    @BindView
    TextView mTvFetCompressorKneeVal;
    @BindView
    TextView mTvFetCompressorKneemultiVal;
    @BindView
    TextView mTvFetCompressorMaxattackVal;
    @BindView
    TextView mTvFetCompressorMaxreleaseVal;
    @BindView
    TextView mTvFetCompressorRatioVal;
    @BindView
    TextView mTvFetCompressorReleaseVal;
    @BindView
    TextView mTvFetCompressorThresholdVal;

    private float a(float f, float f2, float f3) {
        return (float) Math.exp(Math.log((double) f2) + (((double) f) * (Math.log((double) f3) - Math.log((double) f2))));
    }

    private String a(float f) {
        return this.b.format(Math.log10(Math.pow(10.0d, ((double) (-60.0f * f)) / 20.0d)) * 20.0d) + getString(2131099783);
    }

    private void a() {
        this.mTrbFetCompressorThreshold.setBgImageInt(2130903068);
        this.mTrbFetCompressorThreshold.setBgPressImageInt(2130903069);
        this.mPbvFetCompressorThreshold.setMax(300);
        this.mTrbFetCompressorThreshold.setOnChangeDegreeListening(new aa(this));
        this.mTrbFetCompressorRatio.setBgImageInt(2130903068);
        this.mTrbFetCompressorRatio.setBgPressImageInt(2130903069);
        this.mPbvFetCompressorRatio.setMax(300);
        this.mTrbFetCompressorRatio.setOnChangeDegreeListening(new ai(this));
        this.mFetCompressorAutokneeEnable.setOnClickListener(new aj(this));
        this.mTrbFetCompressorKnee.setBgImageInt(2130903068);
        this.mTrbFetCompressorKnee.setBgPressImageInt(2130903069);
        this.mPbvFetCompressorKnee.setMax(300);
        this.mTrbFetCompressorKnee.setOnChangeDegreeListening(new ak(this));
        this.mFetCompressorAutogainEnable.setOnClickListener(new al(this));
        this.mTrbFetCompressorGain.setBgImageInt(2130903068);
        this.mTrbFetCompressorGain.setBgPressImageInt(2130903069);
        this.mPbvFetCompressorGain.setMax(300);
        this.mTrbFetCompressorGain.setOnChangeDegreeListening(new am(this));
        this.mFetCompressorAutoattackEnable.setOnClickListener(new an(this));
        this.mTrbFetCompressorAttack.setBgImageInt(2130903068);
        this.mTrbFetCompressorAttack.setBgPressImageInt(2130903069);
        this.mPbvFetCompressorAttack.setMax(300);
        this.mTrbFetCompressorAttack.setOnChangeDegreeListening(new ao(this));
        this.mFetCompressorAutoreleaseEnable.setOnClickListener(new ap(this));
        this.mTrbFetCompressorRelease.setBgImageInt(2130903068);
        this.mTrbFetCompressorRelease.setBgPressImageInt(2130903069);
        this.mPbvFetCompressorRelease.setMax(300);
        this.mTrbFetCompressorRelease.setOnChangeDegreeListening(new ab(this));
        this.mTrbFetCompressorKneemulti.setBgImageInt(2130903068);
        this.mTrbFetCompressorKneemulti.setBgPressImageInt(2130903069);
        this.mPbvFetCompressorKneemulti.setMax(300);
        this.mTrbFetCompressorKneemulti.setOnChangeDegreeListening(new ac(this));
        this.mTrbFetCompressorMaxattack.setBgImageInt(2130903068);
        this.mTrbFetCompressorMaxattack.setBgPressImageInt(2130903069);
        this.mPbvFetCompressorMaxattack.setMax(300);
        this.mTrbFetCompressorMaxattack.setOnChangeDegreeListening(new ad(this));
        this.mTrbFetCompressorMaxrelease.setBgImageInt(2130903068);
        this.mTrbFetCompressorMaxrelease.setBgPressImageInt(2130903069);
        this.mPbvFetCompressorMaxrelease.setMax(300);
        this.mTrbFetCompressorMaxrelease.setOnChangeDegreeListening(new ae(this));
        this.mTrbFetCompressorCrest.setBgImageInt(2130903068);
        this.mTrbFetCompressorCrest.setBgPressImageInt(2130903069);
        this.mPbvFetCompressorCrest.setMax(300);
        this.mTrbFetCompressorCrest.setOnChangeDegreeListening(new af(this));
        this.mTrbFetCompressorAdapt.setBgImageInt(2130903068);
        this.mTrbFetCompressorAdapt.setBgPressImageInt(2130903069);
        this.mPbvFetCompressorAdapt.setMax(300);
        this.mTrbFetCompressorAdapt.setOnChangeDegreeListening(new ag(this));
        this.mFetCompressorNoclipenableEnable.setOnClickListener(new ah(this));
    }

    private float b(float f, float f2, float f3) {
        return ((f3 - f2) * f) + f2;
    }

    private String b(float f) {
        return ((double) f) > 0.99d ? "\u221e:1" : this.b.format(1.0d / (1.0d - ((double) f))) + ":1";
    }

    private void b() {
        int intValue = Integer.valueOf(this.a.getString(this.c ? "viper4android.headphonefx.fetcompressor.threshold" : "viper4android.speakerfx.fetcompressor.threshold", "100")).intValue();
        this.mTvFetCompressorThresholdVal.setText(a((float) (((double) intValue) / 100.0d)));
        this.mPbvFetCompressorThreshold.setProgressSync((float) (intValue * 3));
        this.mTrbFetCompressorThreshold.setCurDegree((float) ((intValue * 3) + 30));
        intValue = Integer.valueOf(this.a.getString(this.c ? "viper4android.headphonefx.fetcompressor.ratio" : "viper4android.speakerfx.fetcompressor.ratio", "100")).intValue();
        this.mTvFetCompressorRatioVal.setText(b((float) (((double) intValue) / 100.0d)));
        this.mPbvFetCompressorRatio.setProgressSync((float) (intValue * 3));
        this.mTrbFetCompressorRatio.setCurDegree((float) ((intValue * 3) + 30));
        intValue = Integer.valueOf(this.a.getString(this.c ? "viper4android.headphonefx.fetcompressor.knee" : "viper4android.speakerfx.fetcompressor.knee", "0")).intValue();
        this.mTvFetCompressorKneeVal.setText(c((float) (((double) intValue) / 100.0d)));
        this.mPbvFetCompressorKnee.setProgressSync((float) (intValue * 3));
        this.mTrbFetCompressorKnee.setCurDegree((float) ((intValue * 3) + 30));
        intValue = Integer.valueOf(this.a.getString(this.c ? "viper4android.headphonefx.fetcompressor.gain" : "viper4android.speakerfx.fetcompressor.gain", "0")).intValue();
        this.mTvFetCompressorGainVal.setText(d((float) (((double) intValue) / 100.0d)));
        this.mPbvFetCompressorGain.setProgressSync((float) (intValue * 3));
        this.mTrbFetCompressorGain.setCurDegree((float) ((intValue * 3) + 30));
        intValue = Integer.valueOf(this.a.getString(this.c ? "viper4android.headphonefx.fetcompressor.attack" : "viper4android.speakerfx.fetcompressor.attack", "20")).intValue();
        this.mTvFetCompressorAttackVal.setText(e((float) (((double) intValue) / 100.0d)));
        this.mPbvFetCompressorAttack.setProgressSync((float) (intValue * 3));
        this.mTrbFetCompressorAttack.setCurDegree((float) ((intValue * 3) + 30));
        intValue = Integer.valueOf(this.a.getString(this.c ? "viper4android.headphonefx.fetcompressor.release" : "viper4android.speakerfx.fetcompressor.release", "50")).intValue();
        this.mTvFetCompressorReleaseVal.setText(f((float) (((double) intValue) / 100.0d)));
        this.mPbvFetCompressorRelease.setProgressSync((float) (intValue * 3));
        this.mTrbFetCompressorRelease.setCurDegree((float) ((intValue * 3) + 30));
        intValue = Integer.valueOf(this.a.getString(this.c ? "viper4android.headphonefx.fetcompressor.kneemulti" : "viper4android.speakerfx.fetcompressor.kneemulti", "0")).intValue();
        this.mTvFetCompressorKneemultiVal.setText(g((float) (((double) intValue) / 100.0d)));
        this.mPbvFetCompressorKneemulti.setProgressSync((float) (intValue * 3));
        this.mTrbFetCompressorKneemulti.setCurDegree((float) ((intValue * 3) + 30));
        intValue = Integer.valueOf(this.a.getString(this.c ? "viper4android.headphonefx.fetcompressor.maxattack" : "viper4android.speakerfx.fetcompressor.maxattack", "80")).intValue();
        this.mTvFetCompressorMaxattackVal.setText(h((float) (((double) intValue) / 100.0d)));
        this.mPbvFetCompressorMaxattack.setProgressSync((float) (intValue * 3));
        this.mTrbFetCompressorMaxattack.setCurDegree((float) ((intValue * 3) + 30));
        intValue = Integer.valueOf(this.a.getString(this.c ? "viper4android.headphonefx.fetcompressor.maxrelease" : "viper4android.speakerfx.fetcompressor.maxrelease", "100")).intValue();
        this.mTvFetCompressorMaxreleaseVal.setText(i((float) (((double) intValue) / 100.0d)));
        this.mPbvFetCompressorMaxrelease.setProgressSync((float) (intValue * 3));
        this.mTrbFetCompressorMaxrelease.setCurDegree((float) ((intValue * 3) + 30));
        intValue = Integer.valueOf(this.a.getString(this.c ? "viper4android.headphonefx.fetcompressor.crest" : "viper4android.speakerfx.fetcompressor.crest", "20")).intValue();
        this.mTvFetCompressorCrestVal.setText(j((float) (((double) intValue) / 100.0d)));
        this.mPbvFetCompressorCrest.setProgressSync((float) (intValue * 3));
        this.mTrbFetCompressorCrest.setCurDegree((float) ((intValue * 3) + 30));
        intValue = Integer.valueOf(this.a.getString(this.c ? "viper4android.headphonefx.fetcompressor.adapt" : "viper4android.speakerfx.fetcompressor.adapt", "50")).intValue();
        this.mTvFetCompressorAdaptVal.setText(k((float) (((double) intValue) / 100.0d)));
        this.mPbvFetCompressorAdapt.setProgressSync((float) (intValue * 3));
        this.mTrbFetCompressorAdapt.setCurDegree((float) ((intValue * 3) + 30));
        boolean z = this.a.getBoolean(this.c ? "viper4android.headphonefx.fetcompressor.autoknee" : "viper4android.speakerfx.fetcompressor.autoknee", true);
        this.mFetCompressorAutokneeEnable.setChecked(z);
        if (z) {
            this.mTrbFetCompressorKnee.setDisable(true);
            this.mPbvFetCompressorKnee.setColorId(getResources().getColor(2131492906));
            this.mTrbFetCompressorKneemulti.setDisable(false);
            this.mPbvFetCompressorKneemulti.setColorId(getResources().getColor(2131492877));
        } else {
            this.mTrbFetCompressorKnee.setDisable(false);
            this.mPbvFetCompressorKnee.setColorId(getResources().getColor(2131492877));
            this.mTrbFetCompressorKneemulti.setDisable(true);
            this.mPbvFetCompressorKneemulti.setColorId(getResources().getColor(2131492906));
        }
        z = this.a.getBoolean(this.c ? "viper4android.headphonefx.fetcompressor.autogain" : "viper4android.speakerfx.fetcompressor.autogain", true);
        this.mFetCompressorAutogainEnable.setChecked(z);
        if (z) {
            this.mTrbFetCompressorGain.setDisable(true);
            this.mPbvFetCompressorGain.setColorId(getResources().getColor(2131492906));
        } else {
            this.mTrbFetCompressorGain.setDisable(false);
            this.mPbvFetCompressorGain.setColorId(getResources().getColor(2131492877));
        }
        z = this.a.getBoolean(this.c ? "viper4android.headphonefx.fetcompressor.autoattack" : "viper4android.speakerfx.fetcompressor.autoattack", true);
        this.mFetCompressorAutoattackEnable.setChecked(z);
        if (z) {
            this.mTrbFetCompressorAttack.setDisable(true);
            this.mPbvFetCompressorAttack.setColorId(getResources().getColor(2131492906));
            this.mTrbFetCompressorMaxattack.setDisable(false);
            this.mPbvFetCompressorMaxattack.setColorId(getResources().getColor(2131492877));
        } else {
            this.mTrbFetCompressorAttack.setDisable(false);
            this.mPbvFetCompressorAttack.setColorId(getResources().getColor(2131492877));
            this.mTrbFetCompressorMaxattack.setDisable(true);
            this.mPbvFetCompressorMaxattack.setColorId(getResources().getColor(2131492906));
        }
        z = this.a.getBoolean(this.c ? "viper4android.headphonefx.fetcompressor.autorelease" : "viper4android.speakerfx.fetcompressor.autorelease", true);
        this.mFetCompressorAutoreleaseEnable.setChecked(z);
        if (z) {
            this.mTrbFetCompressorRelease.setDisable(true);
            this.mPbvFetCompressorRelease.setColorId(getResources().getColor(2131492906));
            this.mTrbFetCompressorMaxrelease.setDisable(false);
            this.mPbvFetCompressorMaxrelease.setColorId(getResources().getColor(2131492877));
        } else {
            this.mTrbFetCompressorRelease.setDisable(false);
            this.mPbvFetCompressorRelease.setColorId(getResources().getColor(2131492877));
            this.mTrbFetCompressorMaxrelease.setDisable(true);
            this.mPbvFetCompressorMaxrelease.setColorId(getResources().getColor(2131492906));
        }
        this.mFetCompressorNoclipenableEnable.setChecked(this.a.getBoolean(this.c ? "viper4android.headphonefx.fetcompressor.noclipenable" : "viper4android.speakerfx.fetcompressor.noclipenable", true));
    }

    private String c(float f) {
        return this.b.format(Math.log10(Math.pow(10.0d, ((double) (60.0f * f)) / 20.0d)) * 20.0d) + getString(2131099783);
    }

    private String d(float f) {
        return this.b.format(Math.log10(Math.pow(10.0d, ((double) (60.0f * f)) / 20.0d)) * 20.0d) + getString(2131099783);
    }

    private String e(float f) {
        return this.b.format(((double) a(f, 1.0E-4f, 0.2f)) * 1000.0d) + getString(2131099811);
    }

    private String f(float f) {
        return this.b.format(((double) a(f, 0.005f, 2.0f)) * 1000.0d) + getString(2131099811);
    }

    private String g(float f) {
        return this.b.format((double) b(f, 0.0f, 4.0f)) + "x";
    }

    private String h(float f) {
        return this.b.format(((double) a(f, 1.0E-4f, 0.2f)) * 1000.0d) + getString(2131099811);
    }

    private String i(float f) {
        return this.b.format(((double) a(f, 0.005f, 2.0f)) * 1000.0d) + getString(2131099811);
    }

    private String j(float f) {
        return this.b.format(Math.log10(Math.pow(10.0d, ((double) (60.0f * f)) / 20.0d)) * 20.0d) + getString(2131099783);
    }

    private String k(float f) {
        return this.b.format(((double) a(f, 1.0f, 4.0f)) * 1000.0d) + getString(2131099811);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.c = getActivity().getIntent().getStringExtra("KEY").contains("headphonefx");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(2130968623, viewGroup, false);
        ButterKnife.a(this, inflate);
        a();
        b();
        return inflate;
    }
}
