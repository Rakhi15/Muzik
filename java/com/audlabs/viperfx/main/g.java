package com.audlabs.viperfx.main;

import android.app.Activity;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.c;
import android.support.v7.widget.Toolbar;
import android.view.View;

class g extends c {
    final /* synthetic */ MainActivity a;
    private boolean b = true;

    g(MainActivity mainActivity, Activity activity, DrawerLayout drawerLayout, Toolbar toolbar, int i, int i2) {
        this.a = mainActivity;
        super(activity, drawerLayout, toolbar, i, i2);
    }

    public void a(View view, float f) {
        super.a(view, f);
        if (this.b) {
            this.a.a(this.a.mNavigationView.getMenu());
            this.b = false;
        }
    }

    public void b(View view) {
        super.b(view);
        this.b = true;
    }
}
