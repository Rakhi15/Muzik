package com.audlabs.viperfx.base;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

public class BaseActivity extends SwipeBackActivity {
    @BindView
    Toolbar mToolbar;

    public void a(String str) {
        ActionBar f = f();
        if (f != null) {
            f.a(str);
        }
    }

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
    }

    public void setContentView(int i) {
        super.setContentView(i);
        ButterKnife.a(this);
        a(this.mToolbar);
        ActionBar f = f();
        if (f != null) {
            f.b(true);
            f.a(true);
        }
    }
}
