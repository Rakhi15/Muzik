package com.audlabs.viperfx.main;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.audlabs.viperfx.main.MainFragment.MianAdapter;
import java.util.HashMap;

class o implements OnClickListener {
    final /* synthetic */ HashMap a;
    final /* synthetic */ MainViewHolder b;
    final /* synthetic */ MianAdapter c;

    o(MianAdapter mianAdapter, HashMap hashMap, MainViewHolder mainViewHolder) {
        this.c = mianAdapter;
        this.a = hashMap;
        this.b = mainViewHolder;
    }

    public void onClick(View view) {
        this.c.a.a.edit().putBoolean((String) this.a.get("KEY"), this.b.cbEnable.isChecked()).apply();
        this.c.a.getActivity().sendBroadcast(new Intent("com.audlabs.viperfx.UPDATE"));
    }
}
