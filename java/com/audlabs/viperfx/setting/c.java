package com.audlabs.viperfx.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.audlabs.viperfx.b.d;

class c implements OnClickListener {
    final /* synthetic */ String[] a;
    final /* synthetic */ SettingFragment b;

    c(SettingFragment settingFragment, String[] strArr) {
        this.b = settingFragment;
        this.a = strArr;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.b.a.edit().putString("viper4android.settings.default_storage", this.a[i]).apply();
        d.b(this.b.getActivity());
        this.b.mTvDefaultStorageState.setText(d.b());
    }
}
