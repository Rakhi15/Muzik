package com.audlabs.viperfx.screen;

import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.a.a;

public class bl implements Unbinder {
    protected VDdcViewHolder b;

    public bl(VDdcViewHolder vDdcViewHolder, a aVar, Object obj) {
        this.b = vDdcViewHolder;
        vDdcViewHolder.ivSelect = (ImageView) aVar.a(obj, 2131558712, "field 'ivSelect'", ImageView.class);
        vDdcViewHolder.tvName = (TextView) aVar.a(obj, 2131558713, "field 'tvName'", TextView.class);
    }
}
