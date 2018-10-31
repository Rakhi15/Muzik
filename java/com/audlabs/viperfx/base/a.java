package com.audlabs.viperfx.base;

import android.support.v7.widget.Toolbar;
import butterknife.Unbinder;

public class a implements Unbinder {
    protected BaseActivity b;

    public a(BaseActivity baseActivity, butterknife.a.a aVar, Object obj) {
        this.b = baseActivity;
        baseActivity.mToolbar = (Toolbar) aVar.a(obj, 2131558508, "field 'mToolbar'", Toolbar.class);
    }
}
