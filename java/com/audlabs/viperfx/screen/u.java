package com.audlabs.viperfx.screen;

import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.a.a;
import com.audlabs.viperfx.widget.TouchRotateButton;

public class u implements Unbinder {
    protected DiffsurrFragment b;

    public u(DiffsurrFragment diffsurrFragment, a aVar, Object obj, Resources resources) {
        this.b = diffsurrFragment;
        diffsurrFragment.mTvDiffsurrVal = (TextView) aVar.a(obj, 2131558615, "field 'mTvDiffsurrVal'", TextView.class);
        diffsurrFragment.mTrbDiffsurr = (TouchRotateButton) aVar.a(obj, 2131558616, "field 'mTrbDiffsurr'", TouchRotateButton.class);
        diffsurrFragment.mIVKnobPoint = (ImageView) aVar.a(obj, 2131558531, "field 'mIVKnobPoint'", ImageView.class);
        diffsurrFragment.diffsurroundDelays = resources.getStringArray(2131427361);
        diffsurrFragment.diffsurroundDelayVals = resources.getStringArray(2131427362);
    }
}
