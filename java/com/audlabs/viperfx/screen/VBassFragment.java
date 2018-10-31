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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import butterknife.BindArray;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.audlabs.viperfx.base.b;
import com.audlabs.viperfx.widget.ProgressBarView;
import com.audlabs.viperfx.widget.TouchRotateButton;
import java.util.Arrays;

public class VBassFragment extends b {
    private Matrix b;
    private float c;
    private float d;
    @BindView
    ImageView mIVKnobPoint;
    @BindView
    ProgressBarView mPbvBassFreq;
    @BindView
    RadioButton mRbModeNaturalbass;
    @BindView
    RadioButton mRbModePurebass;
    @BindView
    RadioButton mRbModeSubwoofer;
    @BindView
    RadioGroup mRgBassMode;
    @BindView
    TouchRotateButton mTrbBassFreq;
    @BindView
    TouchRotateButton mTrbBassGain;
    @BindView
    TextView mTvBassFreqVal;
    @BindView
    TextView mTvBassGainVal;
    @BindArray
    String[] vbassBoostVals;
    @BindArray
    String[] vbassBoosts;
    @BindArray
    String[] vbassFreq;
    @BindArray
    String[] vbassMode;

    private void a() {
        this.mRbModeNaturalbass.setText(this.vbassMode[0]);
        this.mRbModePurebass.setText(this.vbassMode[1]);
        this.mRbModeSubwoofer.setText(this.vbassMode[2]);
        this.mRgBassMode.setOnCheckedChangeListener(new bb(this));
        this.mTrbBassFreq.setBgImageInt(2130903068);
        this.mTrbBassFreq.setBgPressImageInt(2130903069);
        this.mPbvBassFreq.setMax(300);
        this.mTrbBassFreq.setOnChangeDegreeListening(new bc(this));
        this.b = new Matrix();
        Bitmap bitmap = ((BitmapDrawable) a.a(getActivity(), 2130903066)).getBitmap();
        this.c = (float) (bitmap.getWidth() / 2);
        this.d = (float) (bitmap.getHeight() / 2);
        this.mTrbBassGain.setBgImageInt(2130903065);
        this.mTrbBassGain.setBgPressImageInt(2130903067);
        this.mTrbBassGain.setMIN_DEGREE(56.25f);
        this.mTrbBassGain.setMAX_DEGREE(303.75f);
        this.mTrbBassGain.setOnChangeDegreeListening(new bd(this));
    }

    private void b() {
        String string = this.a.getString("viper4android.headphonefx.fidelity.bass.mode", "0");
        if ("0".equals(string)) {
            this.mRbModeNaturalbass.setChecked(true);
        } else if ("1".equals(string)) {
            this.mRbModePurebass.setChecked(true);
        } else if ("2".equals(string)) {
            this.mRbModeSubwoofer.setChecked(true);
        }
        string = this.a.getString("viper4android.headphonefx.fidelity.bass.freq", "40");
        this.mTvBassFreqVal.setText(string + " HZ");
        this.mPbvBassFreq.setProgressSync((float) (Integer.valueOf(string).intValue() * 3));
        this.mTrbBassFreq.setCurDegree((float) ((Integer.valueOf(string).intValue() * 3) + 30));
        int indexOf = Arrays.asList(this.vbassBoostVals).indexOf(this.a.getString("viper4android.headphonefx.fidelity.bass.gain", "50"));
        if (indexOf < 0 || indexOf >= this.vbassBoosts.length) {
            indexOf = 0;
        }
        this.mTvBassGainVal.setText(this.vbassBoosts[indexOf]);
        this.b.setRotate((float) ((((double) indexOf) * 22.5d) + 56.25d), this.c, this.d);
        this.mIVKnobPoint.setImageMatrix(this.b);
        this.mTrbBassGain.setCurDegree((float) ((((double) indexOf) * 22.5d) + 56.25d));
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(2130968633, viewGroup, false);
        ButterKnife.a(this, inflate);
        a();
        b();
        return inflate;
    }
}
