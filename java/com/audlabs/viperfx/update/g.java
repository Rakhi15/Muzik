package com.audlabs.viperfx.update;

import android.os.Handler;
import android.os.Message;
import org.json.JSONException;
import org.json.JSONObject;

class g extends Thread {
    final /* synthetic */ Handler a;
    final /* synthetic */ e b;

    g(e eVar, Handler handler) {
        this.b = eVar;
        this.a = handler;
    }

    public void run() {
        if (this.b.a(this.b.b)) {
            String a = this.b.b("http://api.audlabs.com/viperfx/update.php");
            if (a == null) {
                this.a.sendEmptyMessage(2);
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(a);
                Message obtainMessage = this.a.obtainMessage();
                obtainMessage.what = 1;
                obtainMessage.obj = jSONObject;
                this.a.sendMessage(obtainMessage);
                return;
            } catch (JSONException e) {
                this.a.sendEmptyMessage(2);
                e.printStackTrace();
                return;
            }
        }
        this.a.sendEmptyMessage(2);
    }
}
