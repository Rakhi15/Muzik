package com.audlabs.viperfx.main;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class StartActivity extends Activity {
    @BindView
    ImageView mIVEntry;

    private void a() {
        Animator ofFloat = ObjectAnimator.ofFloat(this.mIVEntry, "scaleX", new float[]{1.0f, 1.15f});
        Animator ofFloat2 = ObjectAnimator.ofFloat(this.mIVEntry, "scaleY", new float[]{1.0f, 1.15f});
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(2000).play(ofFloat).with(ofFloat2);
        animatorSet.start();
        animatorSet.addListener(new s(this));
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2130968604);
        ButterKnife.a(this);
        a();
    }
}
