package com.audlabs.viperfx.screen;

import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.a.a;

public class bm implements Unbinder {
    protected VDdcFragment b;

    public bm(VDdcFragment vDdcFragment, a aVar, Object obj) {
        this.b = vDdcFragment;
        vDdcFragment.etSearch = (AppCompatEditText) aVar.a(obj, 2131558703, "field 'etSearch'", AppCompatEditText.class);
        vDdcFragment.mRecyclerView = (RecyclerView) aVar.a(obj, 2131558704, "field 'mRecyclerView'", RecyclerView.class);
    }
}
