package com.audlabs.viperfx.main;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v7.app.ad;
import com.audlabs.viperfx.base.e;
import me.imid.swipebacklayout.lib.f;

class c implements OnClickListener {
    final /* synthetic */ Context a;
    final /* synthetic */ b b;

    c(b bVar, Context context) {
        this.b = bVar;
        this.a = context;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        String b = e.b("");
        if (com.audlabs.viperfx.b.e.a(this.a) || com.audlabs.viperfx.b.e.a()) {
            int a = com.audlabs.viperfx.b.e.a(this.a, b);
            if (a == 0) {
                com.audlabs.viperfx.b.e.b(this.a);
                ad adVar = new ad(this.a);
                adVar.a("ViPERFX");
                adVar.b(this.a.getResources().getString(2131099796));
                adVar.b(this.a.getResources().getString(2131099816), null);
                adVar.c();
                return;
            }
            ad adVar2 = new ad(this.a);
            adVar2.a("ViPERFX");
            switch (a) {
                case f.View_android_focusable /*1*/:
                    adVar2.b(this.a.getResources().getString(2131099791));
                    break;
                case f.View_paddingStart /*2*/:
                    adVar2.b(this.a.getResources().getString(2131099797));
                    break;
                case f.View_paddingEnd /*3*/:
                    adVar2.b(this.a.getResources().getString(2131099794));
                    break;
                case f.View_theme /*4*/:
                    adVar2.b(this.a.getResources().getString(2131099793));
                    break;
                default:
                    adVar2.b(this.a.getResources().getString(2131099795));
                    break;
            }
            adVar2.b(this.a.getResources().getString(2131099816), null);
            adVar2.c();
            return;
        }
        adVar = new ad(this.a);
        adVar.a("ViPERFX");
        adVar.b(this.a.getResources().getString(2131099792));
        adVar.b(this.a.getResources().getString(2131099816), null);
        adVar.c();
    }
}
