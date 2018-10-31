package com.audlabs.viperfx.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences.Editor;
import me.imid.swipebacklayout.lib.f;

class b implements OnClickListener {
    final /* synthetic */ SettingFragment a;

    b(SettingFragment settingFragment) {
        this.a = settingFragment;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        Editor edit = this.a.a.edit();
        switch (i) {
            case f.View_android_theme /*0*/:
                edit.putString("viper4android.settings.compatiblemode", "global");
                break;
            case f.View_android_focusable /*1*/:
                edit.putString("viper4android.settings.compatiblemode", "local");
                break;
        }
        edit.apply();
        this.a.mCompatibleState.setText(this.a.mCompatibleModes[i]);
        dialogInterface.dismiss();
    }
}
