package com.audlabs.viperfx.base;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.audlabs.viperfx.b.d;
import com.audlabs.viperfx.b.e;
import com.audlabs.viperfx.main.MainActivity;
import me.imid.swipebacklayout.lib.f;

final class n implements OnClickListener {
    final /* synthetic */ String a;
    final /* synthetic */ Context b;

    n(String str, Context context) {
        this.a = str;
        this.b = context;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        String str = "";
        switch (i) {
            case f.View_android_theme /*0*/:
                str = "com.audlabs.viperfx.headset";
                break;
            case f.View_android_focusable /*1*/:
                str = "com.audlabs.viperfx.speaker";
                break;
            case f.View_paddingStart /*2*/:
                str = "com.audlabs.viperfx.bluetooth";
                break;
            case f.View_paddingEnd /*3*/:
                str = "com.audlabs.viperfx.usb";
                break;
        }
        if (!str.isEmpty()) {
            e.a(this.a, d.f(), str, this.b);
            this.b.startActivity(new Intent(this.b, MainActivity.class));
            ((Activity) this.b).finish();
        }
    }
}
