package com.audlabs.viperfx.screen;

import android.content.Intent;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

class bf implements OnCheckedChangeListener {
    final /* synthetic */ VClarityFragment a;

    bf(VClarityFragment vClarityFragment) {
        this.a = vClarityFragment;
    }

    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (i == this.a.mRbModeNatural.getId()) {
            this.a.a.edit().putString("viper4android.headphonefx.fidelity.clarity.mode", "0").apply();
        } else if (i == this.a.mRbModeOzone.getId()) {
            this.a.a.edit().putString("viper4android.headphonefx.fidelity.clarity.mode", "1").apply();
        } else if (i == this.a.mRbModeXhifi.getId()) {
            this.a.a.edit().putString("viper4android.headphonefx.fidelity.clarity.mode", "2").apply();
        }
        this.a.getActivity().sendBroadcast(new Intent("com.audlabs.viperfx.UPDATE"));
    }
}
