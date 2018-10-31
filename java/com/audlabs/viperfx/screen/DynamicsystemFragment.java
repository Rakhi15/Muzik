package com.audlabs.viperfx.screen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import butterknife.BindArray;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.audlabs.viperfx.base.b;
import com.audlabs.viperfx.widget.ProgressBarView;
import com.audlabs.viperfx.widget.TouchRotateButton;
import java.util.Arrays;

public class DynamicsystemFragment extends b {
    @BindView
    Button mBtnDynamicsystemOutput;
    @BindView
    ProgressBarView mPbvDynamicsystemBass;
    @BindView
    TouchRotateButton mTrbDynamicsystemBass;
    @BindView
    TextView mTvDynamicsystemBassVal;
    @BindArray
    String[] outputs;
    @BindArray
    String[] outputsArray;

    private void a() {
        this.mBtnDynamicsystemOutput.setOnClickListener(new v(this));
        this.mTrbDynamicsystemBass.setBgImageInt(2130903068);
        this.mTrbDynamicsystemBass.setBgPressImageInt(2130903069);
        this.mPbvDynamicsystemBass.setMax(100);
        this.mTrbDynamicsystemBass.setOnChangeDegreeListening(new y(this));
    }

    private void b() {
        this.mBtnDynamicsystemOutput.setText(this.outputsArray[Arrays.asList(this.outputs).indexOf(this.a.getString("viper4android.headphonefx.dynamicsystem.coeffs", "100;5600;40;80;50;50"))]);
        String string = this.a.getString("viper4android.headphonefx.dynamicsystem.bass", "0");
        this.mTvDynamicsystemBassVal.setText(string + "%");
        this.mPbvDynamicsystemBass.setProgressSync(Float.valueOf(string).floatValue());
        this.mTrbDynamicsystemBass.setCurDegree((Float.valueOf(string).floatValue() * 3.0f) + 30.0f);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(2130968627, viewGroup, false);
        ButterKnife.a(this, inflate);
        a();
        b();
        return inflate;
    }
}
