package com.audlabs.viperfx.screen;

import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import butterknife.BindArray;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.audlabs.viperfx.base.b;
import com.audlabs.viperfx.service.ViPER4AndroidService;
import com.audlabs.viperfx.widget.EqualizerViewBar;
import com.audlabs.viperfx.widget.Gallery;
import java.util.Arrays;
import java.util.List;

public class FireqFragment extends b {
    private int b;
    private List c;
    private ViPER4AndroidService d;
    private final ServiceConnection e = new ar(this);
    @BindArray
    String[] mEQPresetNames;
    @BindView
    Gallery mEqGallery;
    @BindView
    EqualizerViewBar mEqualizerView;

    private void a() {
        this.c = Arrays.asList(getResources().getStringArray(2131427367));
        this.b = this.c.indexOf(this.a.getString("viper4android.headphonefx.fireq", "0.0;0.0;0.0;0.0;0.0;0.0;0.0;0.0;0.0;0.0;"));
        this.mEqGallery.setAdapter(new ArrayAdapter(getActivity(), 2130968618, this.mEQPresetNames));
        this.mEqGallery.setEnabled(true);
        this.mEqGallery.setSelection(this.b);
        this.mEqGallery.setOnItemSelectedListener(new as(this));
        getActivity().bindService(new Intent(getActivity(), ViPER4AndroidService.class), this.e, 0);
        this.mEqualizerView.setBandUpdatedListener(new at(this));
    }

    private void a(int i) {
        String[] split = "custom".equals((String) this.c.get(i)) ? this.a.getString("viper4android.headphonefx.fireq.custom", "0.0;0.0;0.0;0.0;0.0;0.0;0.0;0.0;0.0;0.0;").split(";") : ((String) this.c.get(i)).split(";");
        float[] fArr = new float[10];
        for (int i2 = 0; i2 < fArr.length; i2 = (short) (i2 + 1)) {
            fArr[i2] = Float.parseFloat(split[i2]);
        }
        this.mEqualizerView.setBands(fArr);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(2130968628, viewGroup, false);
        ButterKnife.a(this, inflate);
        a();
        return inflate;
    }

    public void onDestroy() {
        getActivity().unbindService(this.e);
        super.onDestroy();
    }
}
