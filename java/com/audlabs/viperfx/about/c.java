package com.audlabs.viperfx.about;

import android.os.Message;
import android.util.Log;
import com.audlabs.viperfx.base.e;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

class c implements Runnable {
    final /* synthetic */ ChangelogFragment a;

    c(ChangelogFragment changelogFragment) {
        this.a = changelogFragment;
    }

    public void run() {
        String str = Locale.getDefault().getLanguage() + "_" + Locale.getDefault().getCountry();
        String str2 = "Changelog_";
        str = str.equalsIgnoreCase("zh_CN") ? str2 + "zh_CN" : str.equalsIgnoreCase("zh_TW") ? str2 + "zh_TW" : str2 + "en_US";
        str2 = str + ".txt";
        str = "";
        try {
            InputStream open = this.a.getActivity().getAssets().open(str2);
            str = e.a(open);
            open.close();
        } catch (IOException e) {
            Log.i("ViPER4Android", "Can not read changelog");
        }
        if (!str.equalsIgnoreCase("")) {
            Message message = new Message();
            message.what = 1;
            message.obj = str;
            this.a.a.sendMessage(message);
        }
    }
}
