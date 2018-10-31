package com.audlabs.viperfx.screen;

import android.support.v7.widget.Toolbar;
import android.widget.CheckBox;
import butterknife.Unbinder;
import butterknife.a.a;

public class r implements Unbinder {
    protected DSPScreenActivity b;

    public r(DSPScreenActivity dSPScreenActivity, a aVar, Object obj) {
        this.b = dSPScreenActivity;
        dSPScreenActivity.mToolbar = (Toolbar) aVar.a(obj, 2131558508, "field 'mToolbar'", Toolbar.class);
        dSPScreenActivity.mEnable = (CheckBox) aVar.a(obj, 2131558509, "field 'mEnable'", CheckBox.class);
    }
}
