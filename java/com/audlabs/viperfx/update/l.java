package com.audlabs.viperfx.update;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

class l implements ServiceConnection {
    final /* synthetic */ k a;

    l(k kVar) {
        this.a = kVar;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        ((c) iBinder).a();
    }

    public void onServiceDisconnected(ComponentName componentName) {
    }
}
