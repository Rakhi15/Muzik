package com.audlabs.viperfx.screen;

import android.content.Intent;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

class bb implements OnCheckedChangeListener {
    final /* synthetic */ VBassFragment a;

    bb(VBassFragment vBassFragment) {
        this.a = vBassFragment;
    }

    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (i == this.a.mRbModeNaturalbass.getId()) {
            this.a.a.edit().putString("viper4android.headphonefx.fidelity.bass.mode", "0").apply();
        } else if (i == this.a.mRbModePurebass.getId()) {
            this.a.a.edit().putString("viper4android.headphonefx.fidelity.bass.mode", "1").apply();
        } else if (i == this.a.mRbModeSubwoofer.getId()) {
            this.a.a.edit().putString("viper4android.headphonefx.fidelity.bass.mode", "2").apply();
        }
        this.a.getActivity().sendBroadcast(new Intent("com.audlabs.viperfx.UPDATE"));
    }
}
