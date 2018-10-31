package com.audlabs.viperfx.screen;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.audlabs.viperfx.service.m;

class ar implements ServiceConnection {
    final /* synthetic */ FireqFragment a;

    ar(FireqFragment fireqFragment) {
        this.a = fireqFragment;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.a.d = ((m) iBinder).a();
    }

    public void onServiceDisconnected(ComponentName componentName) {
        this.a.d = null;
    }
}
