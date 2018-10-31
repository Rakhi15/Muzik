package com.audlabs.viperfx.widget;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;

class f implements OnItemSelectedListener {
    final /* synthetic */ Gallery a;

    f(Gallery gallery) {
        this.a = gallery;
    }

    public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
        TextView textView = (TextView) view;
        if (textView != null) {
            textView.setTextColor(this.a.a ? this.a.b : this.a.d);
        }
        if (!(this.a.e == null || this.a.e == textView)) {
            this.a.e.setTextColor(this.a.a ? this.a.c : this.a.d);
        }
        this.a.e = textView;
        if (this.a.a && this.a.f != null) {
            this.a.f.a(i);
        }
    }

    public void onNothingSelected(AdapterView adapterView) {
    }
}
