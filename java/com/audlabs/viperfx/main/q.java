package com.audlabs.viperfx.main;

import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.a.a;

public class q implements Unbinder {
    protected MainViewHolder b;

    public q(MainViewHolder mainViewHolder, a aVar, Object obj) {
        this.b = mainViewHolder;
        mainViewHolder.ivIcon = (ImageView) aVar.a(obj, 2131558709, "field 'ivIcon'", ImageView.class);
        mainViewHolder.tvTilte = (TextView) aVar.a(obj, 2131558711, "field 'tvTilte'", TextView.class);
        mainViewHolder.cbEnable = (CheckBox) aVar.a(obj, 2131558710, "field 'cbEnable'", CheckBox.class);
    }
}
