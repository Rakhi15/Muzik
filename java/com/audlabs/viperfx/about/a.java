package com.audlabs.viperfx.about;

import android.widget.TextView;
import butterknife.Unbinder;

public class a implements Unbinder {
    protected AboutFragment b;

    public a(AboutFragment aboutFragment, butterknife.a.a aVar, Object obj) {
        this.b = aboutFragment;
        aboutFragment.mTvVersion = (TextView) aVar.a(obj, 2131558528, "field 'mTvVersion'", TextView.class);
    }
}
