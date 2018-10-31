package com.audlabs.viperfx.main;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ad;

final class b extends Handler {
    b() {
    }

    public void handleMessage(Message message) {
        try {
            if (message.what == 40970) {
                if (message.obj == null) {
                    super.handleMessage(message);
                    return;
                }
                Context context = (Context) message.obj;
                ad adVar = new ad(context);
                adVar.a("ViPERFX");
                adVar.b(context.getResources().getString(2131099800));
                adVar.a(context.getResources().getString(2131099839), new c(this, context));
                adVar.b(context.getResources().getString(2131099813), new d(this));
                adVar.c();
            }
            super.handleMessage(message);
        } catch (Exception e) {
            super.handleMessage(message);
        }
    }
}
