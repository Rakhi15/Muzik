package com.audlabs.viperfx.setting;

import android.os.Bundle;
import com.audlabs.viperfx.b.a;
import com.audlabs.viperfx.base.BaseActivity;

public class SettingActivity extends BaseActivity {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2130968603);
        a(getResources().getString(2131099823));
        if (((SettingFragment) getFragmentManager().findFragmentById(2131558510)) == null) {
            a.a(getFragmentManager(), new SettingFragment(), 2131558510);
        }
    }
}
