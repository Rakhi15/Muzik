package com.audlabs.viperfx.screen;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.content.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import butterknife.BindArray;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.audlabs.viperfx.base.b;
import com.audlabs.viperfx.widget.TouchRotateButton;
import java.util.Arrays;

public class PlaybackFragment extends b {
    private Matrix b;
    private float c;
    private float d;
    @BindView
    ImageView mIVKnobPoint;
    @BindArray
    String[] mMultiFactorVals;
    @BindArray
    String[] mMultiFactors;
    @BindArray
    String[] mOutputVals;
    @BindArray
    String[] mOutputs;
    @BindArray
    String[] mRatioVals;
    @BindArray
    String[] mRatios;
    @BindView
    SeekBar mSbPlaybackMaxgain;
    @BindView
    SeekBar mSbPlaybackOutput;
    @BindView
    TouchRotateButton mTrbPlaybackEffect;
    @BindView
    TextView mTvModeExtreme;
    @BindView
    TextView mTvModeModerate;
    @BindView
    TextView mTvModeSlight;
    @BindView
    TextView mTvPlaybackMaxgainVal;
    @BindView
    TextView mTvPlaybackOutputVal;

    private void a() {
        this.mTvModeSlight.setText(this.mRatios[0]);
        this.mTvModeModerate.setText(this.mRatios[1]);
        this.mTvModeExtreme.setText(this.mRatios[2]);
        this.mTrbPlaybackEffect.setBgImageInt(2130903065);
        this.mTrbPlaybackEffect.setBgPressImageInt(2130903067);
        this.mTrbPlaybackEffect.setMIN_DEGREE(135.0f);
        this.mTrbPlaybackEffect.setMAX_DEGREE(225.0f);
        this.b = new Matrix();
        Bitmap bitmap = ((BitmapDrawable) a.a(getActivity(), 2130903066)).getBitmap();
        this.c = (float) (bitmap.getWidth() / 2);
        this.d = (float) (bitmap.getHeight() / 2);
        this.mTrbPlaybackEffect.setOnChangeDegreeListening(new aw(this));
        this.mSbPlaybackMaxgain.setOnSeekBarChangeListener(new ax(this));
        this.mSbPlaybackOutput.setOnSeekBarChangeListener(new ay(this));
    }

    private void b() {
        String string = this.a.getString("viper4android.headphonefx.playbackgain.ratio", "50");
        if (this.mRatioVals[0].equals(string)) {
            this.b.setRotate(135.0f, this.c, this.d);
            this.mIVKnobPoint.setImageMatrix(this.b);
            this.mTrbPlaybackEffect.setCurDegree(135.0f);
        } else if (this.mRatioVals[1].equals(string)) {
            this.b.setRotate(180.0f, this.c, this.d);
            this.mIVKnobPoint.setImageMatrix(this.b);
            this.mTrbPlaybackEffect.setCurDegree(180.0f);
        } else if (this.mRatioVals[2].equals(string)) {
            this.b.setRotate(225.0f, this.c, this.d);
            this.mIVKnobPoint.setImageMatrix(this.b);
            this.mTrbPlaybackEffect.setCurDegree(225.0f);
        }
        int indexOf = Arrays.asList(this.mMultiFactorVals).indexOf(this.a.getString("viper4android.headphonefx.playbackgain.maxscaler", "400"));
        this.mSbPlaybackMaxgain.setProgress(indexOf * 10);
        this.mTvPlaybackMaxgainVal.setText(this.mMultiFactors[indexOf]);
        indexOf = Arrays.asList(this.mOutputVals).indexOf(this.a.getString("viper4android.headphonefx.playbackgain.volume", "80"));
        this.mSbPlaybackOutput.setProgress(((-indexOf) + 5) * 10);
        this.mTvPlaybackOutputVal.setText(this.mOutputs[indexOf]);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(2130968630, viewGroup, false);
        ButterKnife.a(this, inflate);
        a();
        b();
        return inflate;
    }
}
