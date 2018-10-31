package com.audlabs.viperfx.update;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

class i implements ServiceConnection {
    final /* synthetic */ h a;

    i(h hVar) {
        this.a = hVar;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        ((c) iBinder).a();
    }

    public void onServiceDisconnected(ComponentName componentName) {
    }
}
