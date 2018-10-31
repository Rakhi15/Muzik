package com.audlabs.viperfx.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import me.imid.swipebacklayout.lib.f;

class a implements OnClickListener {
    final /* synthetic */ SettingFragment a;

    a(SettingFragment settingFragment) {
        this.a = settingFragment;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        Editor edit = this.a.a.edit();
        switch (i) {
            case f.View_android_theme /*0*/:
                edit.putString("viper4android.settings.lock_effect", "none");
                break;
            case f.View_android_focusable /*1*/:
                edit.putString("viper4android.settings.lock_effect", "headset");
                break;
            case f.View_paddingStart /*2*/:
                edit.putString("viper4android.settings.lock_effect", "speaker");
                break;
            case f.View_paddingEnd /*3*/:
                edit.putString("viper4android.settings.lock_effect", "bluetooth");
                break;
            case f.View_theme /*4*/:
                edit.putString("viper4android.settings.lock_effect", "usb");
                break;
        }
        edit.apply();
        this.a.getActivity().sendBroadcast(new Intent("com.audlabs.viperfx.UPDATE"));
        dialogInterface.dismiss();
        if (this.a.a.getBoolean("viper4android.settings.show_notify_icon", false)) {
            this.a.getActivity().sendBroadcast(new Intent("com.audlabs.viperfx.SHOWNOTIFY"));
        }
        this.a.mLockeffectState.setText(this.a.b[i]);
    }
}
