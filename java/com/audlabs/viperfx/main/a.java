package com.audlabs.viperfx.main;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.audlabs.viperfx.service.ViPER4AndroidService;
import com.audlabs.viperfx.service.m;

class a implements ServiceConnection {
    final /* synthetic */ MainActivity a;

    a(MainActivity mainActivity) {
        this.a = mainActivity;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        int i = 0;
        Log.i("ViPER4Android", "ViPER4Android service connected");
        this.a.q = ((m) iBinder).a();
        String a = ViPER4AndroidService.a(this.a.getSharedPreferences("com.audlabs.viperfx.settings", 0));
        if (this.a.mViewPager != null) {
            String[] a2 = this.a.n();
            while (i < a2.length) {
                if (a.equals(a2[i])) {
                    this.a.mViewPager.setCurrentItem(i);
                    break;
                }
                i++;
            }
        }
        Log.i("ViPER4Android", "Unbinding service ...");
        this.a.unbindService(this);
    }

    public void onServiceDisconnected(ComponentName componentName) {
        Log.e("ViPER4Android", "ViPER4Android service disconnected");
    }
}
