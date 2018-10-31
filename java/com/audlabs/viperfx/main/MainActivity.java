package com.audlabs.viperfx.main;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.internal.NavigationMenuView;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.design.widget.aw;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.c;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.audlabs.viperfx.a.a;
import com.audlabs.viperfx.b.d;
import com.audlabs.viperfx.base.V4AJniInterface;
import com.audlabs.viperfx.service.ViPER4AndroidService;
import com.audlabs.viperfx.update.e;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static MainActivity l;
    private static final Handler s = new b();
    private c m;
    @BindView
    CoordinatorLayout mCoordinatorLayout;
    @BindView
    DrawerLayout mDrawerLayout;
    @BindView
    NavigationView mNavigationView;
    @BindView
    TabLayout mTabLayout;
    @BindView
    Toolbar mToolbar;
    @BindView
    ViewPager mViewPager;
    private m n;
    private List o;
    private String[] p;
    private ViPER4AndroidService q;
    private ServiceConnection r = new a(this);
    private final int t = 291;
    private Handler u = new h(this);
    private aw v = new j(this);

    private void a(Menu menu) {
        if (getSharedPreferences("com.audlabs.viperfx.settings", 0).getString("viper4android.settings.compatiblemode", "global").equalsIgnoreCase("global")) {
            menu.findItem(2131558732).setEnabled(true);
        } else {
            menu.findItem(2131558732).setEnabled(false);
        }
        MenuItem findItem;
        if (this.q == null) {
            findItem = menu.findItem(2131558731);
            findItem.setTitle(getResources().getString(2131099806));
            if (d.a()) {
                findItem.setEnabled(true);
            } else {
                findItem.setEnabled(false);
            }
        } else if (this.q.a()) {
            findItem = menu.findItem(2131558731);
            findItem.setTitle(getResources().getString(2131099828));
            if (d.a()) {
                findItem.setEnabled(true);
            } else {
                findItem.setEnabled(false);
            }
        } else {
            findItem = menu.findItem(2131558731);
            findItem.setTitle(getResources().getString(2131099806));
            if (d.a()) {
                findItem.setEnabled(true);
            } else {
                findItem.setEnabled(false);
            }
        }
    }

    private void k() {
        if (VERSION.SDK_INT >= 23 && checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 291);
        }
    }

    private void l() {
        this.o = m();
        this.p = n();
        a(this.mToolbar);
        if (this.mNavigationView != null) {
            NavigationMenuView navigationMenuView = (NavigationMenuView) this.mNavigationView.getChildAt(0);
            if (navigationMenuView != null) {
                navigationMenuView.setVerticalScrollBarEnabled(false);
            }
        }
        this.m = new g(this, this, this.mDrawerLayout, this.mToolbar, 2131099693, 2131099692);
        this.m.a();
        this.mDrawerLayout.a(this.m);
        this.mNavigationView.setNavigationItemSelectedListener(this.v);
        this.n = new m(this, getFragmentManager());
        this.mViewPager.setAdapter(this.n);
        this.mTabLayout.setupWithViewPager(this.mViewPager);
    }

    private List m() {
        List arrayList = new ArrayList();
        arrayList.add(getResources().getString(2131099691));
        arrayList.add(getResources().getString(2131099771));
        arrayList.add(getResources().getString(2131099673));
        arrayList.add(getResources().getString(2131099840));
        return arrayList;
    }

    private String[] n() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("headset");
        arrayList.add("speaker");
        arrayList.add("bluetooth");
        arrayList.add("usb");
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public void onBackPressed() {
        if (this.mDrawerLayout.g(8388611)) {
            this.mDrawerLayout.f(8388611);
        } else {
            super.onBackPressed();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2130968602);
        ButterKnife.a(this);
        l = this;
        k();
        new e(this).a();
        Log.i("ViPER4Android", "Jni library status = " + V4AJniInterface.a());
        if (com.audlabs.viperfx.base.e.a((Context) this)) {
        }
        if (com.audlabs.viperfx.base.e.b((Context) this) && a.a((Context) this)) {
            com.audlabs.viperfx.base.e.c(this);
        }
        Log.i("ViPER4Android", "Starting service, reason = ViPER4Android::onCreate");
        startService(new Intent(this, ViPER4AndroidService.class));
        new Thread(new e(this)).start();
        new Thread(new f(this)).start();
        if (com.audlabs.viperfx.base.e.a((Context) this)) {
            com.audlabs.viperfx.base.e.d(this);
        }
        l();
        Log.i("ViPER4Android", "onResume(), Binding service ...");
        bindService(new Intent(this, ViPER4AndroidService.class), this.r, 64);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(2131623937, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem == null) {
            return true;
        }
        if (menuItem.getItemId() == 2131558734) {
            try {
                unbindService(this.r);
            } catch (Exception e) {
                e.printStackTrace();
            }
            stopService(new Intent(this, ViPER4AndroidService.class));
            ViPER4AndroidService.a = false;
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void onResume() {
        Log.i("ViPER4Android", "Main activity onResume()");
        super.onResume();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }
}
