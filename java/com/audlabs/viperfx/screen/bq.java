package com.audlabs.viperfx.screen;

import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.a.a;
import com.audlabs.viperfx.widget.ProgressBarView;
import com.audlabs.viperfx.widget.TouchRotateButton;

public class bq implements Unbinder {
    protected VseFragment b;

    public bq(VseFragment vseFragment, a aVar, Object obj) {
        this.b = vseFragment;
        vseFragment.mTvVseVal = (TextView) aVar.a(obj, 2131558706, "field 'mTvVseVal'", TextView.class);
        vseFragment.mTrbVse = (TouchRotateButton) aVar.a(obj, 2131558707, "field 'mTrbVse'", TouchRotateButton.class);
        vseFragment.mPbvVse = (ProgressBarView) aVar.a(obj, 2131558708, "field 'mPbvVse'", ProgressBarView.class);
    }
}
