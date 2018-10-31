package com.audlabs.viperfx.screen;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.widget.CheckBox;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.audlabs.viperfx.b.a;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

public class DSPScreenActivity extends SwipeBackActivity {
    @BindView
    CheckBox mEnable;
    @BindView
    Toolbar mToolbar;

    public boolean g() {
        onBackPressed();
        return true;
    }

    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0, 2131034129);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2130968601);
        ButterKnife.a(this);
        String stringExtra = getIntent().getStringExtra("KEY");
        String stringExtra2 = getIntent().getStringExtra("FLAG");
        SharedPreferences sharedPreferences = getSharedPreferences("com.audlabs.viperfx." + getIntent().getStringExtra("CONFIG"), 0);
        this.mToolbar.setTitle(getIntent().getStringExtra("TITLE"));
        if ("limiter".equals(stringExtra2)) {
            this.mEnable.setVisibility(4);
        } else {
            this.mEnable.setVisibility(0);
            this.mEnable.setChecked(sharedPreferences.getBoolean(stringExtra, false));
            this.mEnable.setOnClickListener(new q(this, sharedPreferences, stringExtra));
        }
        a(this.mToolbar);
        ActionBar f = f();
        if (f != null) {
            f.b(true);
            f.a(true);
        }
        a.a(getFragmentManager(), s.a(stringExtra2), 2131558510);
    }
}
