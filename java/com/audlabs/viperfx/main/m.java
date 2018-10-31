package com.audlabs.viperfx.main;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.i;

public class m extends i {
    final /* synthetic */ MainActivity a;

    public m(MainActivity mainActivity, FragmentManager fragmentManager) {
        this.a = mainActivity;
        super(fragmentManager);
    }

    public Fragment a(int i) {
        return MainFragment.a(this.a.p[i]);
    }

    public int b() {
        return this.a.o.size();
    }

    public CharSequence c(int i) {
        return (CharSequence) this.a.o.get(i);
    }
}
