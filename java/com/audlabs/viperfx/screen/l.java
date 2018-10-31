package com.audlabs.viperfx.screen;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class l implements AnimationListener {
    final /* synthetic */ k a;

    l(k kVar) {
        this.a = kVar;
    }

    public void onAnimationEnd(Animation animation) {
        this.a.b.a.mLayoutConvolverKnlMain.setVisibility(0);
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
