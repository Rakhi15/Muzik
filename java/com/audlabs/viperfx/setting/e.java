package com.audlabs.viperfx.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.audlabs.viperfx.main.MainActivity;

class e implements OnClickListener {
    final /* synthetic */ SettingFragment a;

    e(SettingFragment settingFragment) {
        this.a = settingFragment;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        com.audlabs.viperfx.b.e.c();
        this.a.getActivity().startActivity(new Intent(this.a.getActivity(), MainActivity.class));
        this.a.getActivity().finish();
        MainActivity.l.finish();
    }
}
