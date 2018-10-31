package com.audlabs.viperfx.b;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;

final class f implements OnClickListener {
    final /* synthetic */ Context a;

    f(Context context) {
        this.a = context;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            this.a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=stericson.busybox")));
        } catch (ActivityNotFoundException e) {
            this.a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=stericson.busybox")));
        }
    }
}
