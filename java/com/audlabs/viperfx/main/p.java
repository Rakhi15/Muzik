package com.audlabs.viperfx.main;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.audlabs.viperfx.main.MainFragment.MianAdapter;
import com.audlabs.viperfx.screen.DSPScreenActivity;
import java.util.HashMap;

class p implements OnClickListener {
    final /* synthetic */ HashMap a;
    final /* synthetic */ MainViewHolder b;
    final /* synthetic */ MianAdapter c;

    p(MianAdapter mianAdapter, HashMap hashMap, MainViewHolder mainViewHolder) {
        this.c = mianAdapter;
        this.a = hashMap;
        this.b = mainViewHolder;
    }

    public void onClick(View view) {
        if (this.a.get("FLAG") == null) {
            this.b.cbEnable.setChecked(!this.c.a.a.getBoolean((String) this.a.get("KEY"), false));
            this.c.a.a.edit().putBoolean((String) this.a.get("KEY"), this.b.cbEnable.isChecked()).apply();
            this.c.a.getActivity().sendBroadcast(new Intent("com.audlabs.viperfx.UPDATE"));
            return;
        }
        Intent intent = new Intent(this.c.a.getActivity(), DSPScreenActivity.class);
        intent.putExtra("TITLE", (String) this.a.get("TITLE"));
        intent.putExtra("KEY", (String) this.a.get("KEY"));
        intent.putExtra("FLAG", (String) this.a.get("FLAG"));
        intent.putExtra("CONFIG", this.c.a.b);
        this.c.a.getActivity().startActivity(intent);
        this.c.a.getActivity().overridePendingTransition(2131034128, 0);
    }
}
