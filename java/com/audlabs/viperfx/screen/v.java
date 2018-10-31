package com.audlabs.viperfx.screen;

import android.support.v7.app.ad;
import android.view.View;
import android.view.View.OnClickListener;

class v implements OnClickListener {
    final /* synthetic */ DynamicsystemFragment a;

    v(DynamicsystemFragment dynamicsystemFragment) {
        this.a = dynamicsystemFragment;
    }

    public void onClick(View view) {
        ad adVar = new ad(this.a.getActivity());
        adVar.a(2131099704);
        adVar.a(this.a.outputsArray, new w(this));
        adVar.b(2131099775, new x(this));
        adVar.b().show();
    }
}
