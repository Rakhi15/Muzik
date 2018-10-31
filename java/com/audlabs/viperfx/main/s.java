package com.audlabs.viperfx.main;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;

class s extends AnimatorListenerAdapter {
    final /* synthetic */ StartActivity a;

    s(StartActivity startActivity) {
        this.a = startActivity;
    }

    public void onAnimationEnd(Animator animator) {
        this.a.startActivity(new Intent(this.a, MainActivity.class));
        this.a.finish();
    }
}
