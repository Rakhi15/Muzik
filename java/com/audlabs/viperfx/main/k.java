package com.audlabs.viperfx.main;

import android.os.Message;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.audlabs.viperfx.b.e;
import com.audlabs.viperfx.b.j;

class k implements Runnable {
    final /* synthetic */ j a;

    k(j jVar) {
        this.a = jVar;
    }

    public void run() {
        Object obj;
        LayoutInflater from = LayoutInflater.from(this.a.a);
        View inflate;
        if (this.a.a.q == null) {
            inflate = from.inflate(2130968617, null);
            ((TextView) inflate.findViewById(2131558526)).setText(2131099822);
            obj = inflate;
        } else {
            this.a.a.q.b();
            SystemClock.sleep(500);
            this.a.a.q.c();
            String string = this.a.a.getResources().getString(2131099839);
            if (!this.a.a.q.d()) {
                string = this.a.a.getResources().getString(2131099813);
            }
            String string2 = this.a.a.getResources().getString(2131099839);
            if (!this.a.a.q.e()) {
                string2 = this.a.a.getResources().getString(2131099813);
            }
            String string3 = this.a.a.getResources().getString(2131099815);
            if (!this.a.a.q.g()) {
                string3 = this.a.a.getResources().getString(2131099772);
            }
            String string4 = this.a.a.getResources().getString(2131099826);
            if (!this.a.a.q.f()) {
                string4 = this.a.a.getResources().getString(2131099829);
            }
            String string5 = this.a.a.getResources().getString(2131099839);
            if (!this.a.a.q.h()) {
                string5 = this.a.a.getResources().getString(2131099813);
            }
            e eVar = new e();
            eVar.getClass();
            int[] b = new j(eVar).b();
            String str = b[0] + "." + b[1] + "." + b[2] + "." + b[3];
            CharSequence format = String.format(this.a.a.getResources().getString(2131099790), new Object[]{str, string, string2, string3, string4, string5, Integer.valueOf(this.a.a.q.i())});
            inflate = from.inflate(2130968617, null);
            ((TextView) inflate.findViewById(2131558526)).setText(format);
            View view = inflate;
        }
        Message message = new Message();
        message.what = 1;
        message.obj = obj;
        this.a.a.u.sendMessage(message);
    }
}
