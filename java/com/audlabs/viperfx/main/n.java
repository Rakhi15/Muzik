package com.audlabs.viperfx.main;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import butterknife.Unbinder;
import butterknife.a.a;

public class n implements Unbinder {
    protected MainActivity b;

    public n(MainActivity mainActivity, a aVar, Object obj) {
        this.b = mainActivity;
        mainActivity.mCoordinatorLayout = (CoordinatorLayout) aVar.a(obj, 2131558512, "field 'mCoordinatorLayout'", CoordinatorLayout.class);
        mainActivity.mToolbar = (Toolbar) aVar.a(obj, 2131558508, "field 'mToolbar'", Toolbar.class);
        mainActivity.mDrawerLayout = (DrawerLayout) aVar.a(obj, 2131558511, "field 'mDrawerLayout'", DrawerLayout.class);
        mainActivity.mNavigationView = (NavigationView) aVar.a(obj, 2131558515, "field 'mNavigationView'", NavigationView.class);
        mainActivity.mTabLayout = (TabLayout) aVar.a(obj, 2131558513, "field 'mTabLayout'", TabLayout.class);
        mainActivity.mViewPager = (ViewPager) aVar.a(obj, 2131558514, "field 'mViewPager'", ViewPager.class);
    }
}
