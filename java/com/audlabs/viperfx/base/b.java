package com.audlabs.viperfx.base;

import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.audlabs.viperfx.b.c;

public class b extends Fragment {
    protected SharedPreferences a;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getActivity().getIntent().getStringExtra("CONFIG");
        c.b("config:" + stringExtra + ":" + this);
        this.a = getActivity().getSharedPreferences("com.audlabs.viperfx." + stringExtra, 0);
    }
}
