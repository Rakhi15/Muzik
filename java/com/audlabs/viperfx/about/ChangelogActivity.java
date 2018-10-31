package com.audlabs.viperfx.about;

import android.os.Bundle;
import com.audlabs.viperfx.b.a;
import com.audlabs.viperfx.base.BaseActivity;

public class ChangelogActivity extends BaseActivity {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2130968603);
        a(getResources().getString(2131099776));
        if (((ChangelogFragment) getFragmentManager().findFragmentById(2131558510)) == null) {
            a.a(getFragmentManager(), new ChangelogFragment(), 2131558510);
        }
    }
}
