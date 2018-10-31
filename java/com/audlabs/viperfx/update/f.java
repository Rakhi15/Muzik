package com.audlabs.viperfx.update;

import android.os.Handler;
import android.os.Message;
import java.util.Locale;
import org.json.JSONObject;

class f extends Handler {
    final /* synthetic */ e a;

    f(e eVar) {
        this.a = eVar;
    }

    public void handleMessage(Message message) {
        if (message.what == 1) {
            JSONObject jSONObject = (JSONObject) message.obj;
            try {
                if (jSONObject.getInt("versionCode") > this.a.b.getPackageManager().getPackageInfo(this.a.b.getPackageName(), 0).versionCode) {
                    String str = Locale.getDefault().getLanguage() + "_" + Locale.getDefault().getCountry();
                    str = str.equalsIgnoreCase("zh_CN") ? jSONObject.getString("updateMessage_zh_CN") : str.equalsIgnoreCase("zh_TW") ? jSONObject.getString("updateMessage_zh_TW") : jSONObject.getString("updateMessage");
                    this.a.a(jSONObject.getString("url"), str);
                } else if (this.a.c) {
                    this.a.d();
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (this.a.c) {
                    this.a.e();
                }
            }
        } else if (this.a.c) {
            this.a.e();
        }
        if (this.a.c) {
            this.a.c();
        }
    }
}
