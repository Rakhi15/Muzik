package com.audlabs.viperfx.screen;

import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.a.a;
import com.audlabs.viperfx.widget.TouchRotateButton;

public class bo implements Unbinder {
    protected VhsFragment b;

    public bo(VhsFragment vhsFragment, a aVar, Object obj, Resources resources) {
        this.b = vhsFragment;
        vhsFragment.mTvVshVal = (TextView) aVar.a(obj, 2131558701, "field 'mTvVshVal'", TextView.class);
        vhsFragment.mTrbVhs = (TouchRotateButton) aVar.a(obj, 2131558702, "field 'mTrbVhs'", TouchRotateButton.class);
        vhsFragment.mIVKnobPoint = (ImageView) aVar.a(obj, 2131558531, "field 'mIVKnobPoint'", ImageView.class);
        vhsFragment.vhsQual = resources.getStringArray(2131427351);
    }
}
