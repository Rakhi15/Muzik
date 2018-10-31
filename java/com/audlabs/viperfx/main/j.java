package com.audlabs.viperfx.main;

import android.content.Intent;
import android.os.Message;
import android.support.design.widget.Snackbar;
import android.support.design.widget.aw;
import android.support.v7.app.ad;
import android.view.MenuItem;
import com.audlabs.viperfx.base.e;
import com.audlabs.viperfx.setting.SettingActivity;

class j implements aw {
    final /* synthetic */ MainActivity a;

    j(MainActivity mainActivity) {
        this.a = mainActivity;
    }

    public boolean a(MenuItem menuItem) {
        if (menuItem != null) {
            this.a.mDrawerLayout.f(8388611);
            this.a.getSharedPreferences("com.audlabs.viperfx.settings", 0);
            switch (menuItem.getItemId()) {
                case 2131558729:
                    e.h(this.a);
                    break;
                case 2131558730:
                    e.g(this.a);
                    break;
                case 2131558731:
                    String charSequence = menuItem.getTitle().toString();
                    if (!this.a.getResources().getString(2131099828).equals(charSequence)) {
                        if (!this.a.getResources().getString(2131099806).equals(charSequence)) {
                            Snackbar.a(this.a.mCoordinatorLayout, this.a.getResources().getString(2131099822), 0).a();
                            break;
                        }
                        Message message = new Message();
                        message.what = 40970;
                        message.obj = this.a;
                        MainActivity.s.sendMessage(message);
                        break;
                    }
                    ad adVar = new ad(this.a);
                    adVar.a("ViPERFX");
                    adVar.b(this.a.getResources().getString(2131099798));
                    adVar.a(this.a.getResources().getString(2131099839), new l(this));
                    adVar.b(this.a.getResources().getString(2131099813), null);
                    adVar.c();
                    break;
                case 2131558732:
                    new Thread(new k(this)).start();
                    break;
                case 2131558733:
                    this.a.startActivity(new Intent(this.a, SettingActivity.class));
                    this.a.overridePendingTransition(2131034128, 0);
                    break;
                default:
                    break;
            }
        }
        return true;
    }
}
