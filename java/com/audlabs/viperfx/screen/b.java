package com.audlabs.viperfx.screen;

import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.a.a;
import com.audlabs.viperfx.widget.TouchRotateButton;

public class b implements Unbinder {
    protected AnalogxFragment b;

    public b(AnalogxFragment analogxFragment, a aVar, Object obj, Resources resources) {
        this.b = analogxFragment;
        analogxFragment.mTrbAnalogx = (TouchRotateButton) aVar.a(obj, 2131558532, "field 'mTrbAnalogx'", TouchRotateButton.class);
        analogxFragment.mIVKnobPoint = (ImageView) aVar.a(obj, 2131558531, "field 'mIVKnobPoint'", ImageView.class);
        analogxFragment.mTvModeSlight = (TextView) aVar.a(obj, 2131558534, "field 'mTvModeSlight'", TextView.class);
        analogxFragment.mTvModeModerate = (TextView) aVar.a(obj, 2131558533, "field 'mTvModeModerate'", TextView.class);
        analogxFragment.mTvModeExtreme = (TextView) aVar.a(obj, 2131558535, "field 'mTvModeExtreme'", TextView.class);
        analogxFragment.analogxMode = resources.getStringArray(2131427329);
    }
}
