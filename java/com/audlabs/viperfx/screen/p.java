package com.audlabs.viperfx.screen;

import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.a.a;
import com.audlabs.viperfx.widget.TouchRotateButton;

public class p implements Unbinder {
    protected CuresystemFragment b;

    public p(CuresystemFragment curesystemFragment, a aVar, Object obj, Resources resources) {
        this.b = curesystemFragment;
        curesystemFragment.mTrbCureCrossfeed = (TouchRotateButton) aVar.a(obj, 2131558610, "field 'mTrbCureCrossfeed'", TouchRotateButton.class);
        curesystemFragment.mIVKnobPoint = (ImageView) aVar.a(obj, 2131558531, "field 'mIVKnobPoint'", ImageView.class);
        curesystemFragment.mTvModeSlight = (TextView) aVar.a(obj, 2131558612, "field 'mTvModeSlight'", TextView.class);
        curesystemFragment.mTvModeModerate = (TextView) aVar.a(obj, 2131558611, "field 'mTvModeModerate'", TextView.class);
        curesystemFragment.mTvModeExtreme = (TextView) aVar.a(obj, 2131558613, "field 'mTvModeExtreme'", TextView.class);
        curesystemFragment.cureCrossfeed = resources.getStringArray(2131427334);
    }
}
