package com.audlabs.viperfx.screen;

import android.os.Bundle;
import android.support.v7.app.ad;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.audlabs.viperfx.base.b;
import com.audlabs.viperfx.widget.ProgressBarView;
import com.audlabs.viperfx.widget.TouchRotateButton;

public class VseFragment extends b {
    @BindView
    ProgressBarView mPbvVse;
    @BindView
    TouchRotateButton mTrbVse;
    @BindView
    TextView mTvVseVal;

    private void a() {
        this.mTrbVse.setBgImageInt(2130903068);
        this.mTrbVse.setBgPressImageInt(2130903069);
        this.mPbvVse.setMax(100);
        this.mTrbVse.setOnChangeDegreeListening(new bp(this));
    }

    private void b() {
        String string = this.a.getString("viper4android.headphonefx.vse.value", "0.1");
        this.mTvVseVal.setText(string);
        this.mPbvVse.setProgressSync(Float.valueOf(string).floatValue() * 100.0f);
        this.mTrbVse.setCurDegree((Float.valueOf(string).floatValue() * 300.0f) + 30.0f);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!this.a.getBoolean("viper4android.settings.vse.notice", false)) {
            this.a.edit().putBoolean("viper4android.settings.vse.notice", true).apply();
            ad adVar = new ad(getActivity());
            adVar.a("ViPERFX");
            adVar.b(getActivity().getResources().getString(2131099765));
            adVar.b(getActivity().getResources().getString(2131099816), null);
            adVar.c();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(2130968637, viewGroup, false);
        ButterKnife.a(this, inflate);
        a();
        b();
        return inflate;
    }
}
