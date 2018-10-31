package com.audlabs.viperfx.b;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import com.audlabs.viperfx.base.d;

public class a {
    public static void a(FragmentManager fragmentManager, Fragment fragment, int i) {
        d.a(fragmentManager);
        d.a(fragment);
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.add(i, fragment);
        beginTransaction.commit();
    }
}
