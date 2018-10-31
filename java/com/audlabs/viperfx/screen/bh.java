package com.audlabs.viperfx.screen;

import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.a.a;
import com.audlabs.viperfx.widget.TouchRotateButton;

public class bh implements Unbinder {
    protected VClarityFragment b;

    public bh(VClarityFragment vClarityFragment, a aVar, Object obj, Resources resources) {
        this.b = vClarityFragment;
        vClarityFragment.mRgVclartyMode = (RadioGroup) aVar.a(obj, 2131558693, "field 'mRgVclartyMode'", RadioGroup.class);
        vClarityFragment.mRbModeNatural = (RadioButton) aVar.a(obj, 2131558694, "field 'mRbModeNatural'", RadioButton.class);
        vClarityFragment.mRbModeOzone = (RadioButton) aVar.a(obj, 2131558695, "field 'mRbModeOzone'", RadioButton.class);
        vClarityFragment.mRbModeXhifi = (RadioButton) aVar.a(obj, 2131558696, "field 'mRbModeXhifi'", RadioButton.class);
        vClarityFragment.mTvClartyVal = (TextView) aVar.a(obj, 2131558698, "field 'mTvClartyVal'", TextView.class);
        vClarityFragment.mTrbClarty = (TouchRotateButton) aVar.a(obj, 2131558699, "field 'mTrbClarty'", TouchRotateButton.class);
        vClarityFragment.mIVKnobPoint = (ImageView) aVar.a(obj, 2131558531, "field 'mIVKnobPoint'", ImageView.class);
        vClarityFragment.vclartyMode = resources.getStringArray(2131427350);
        vClarityFragment.vclartyBoosts = resources.getStringArray(2131427349);
        vClarityFragment.vclartyBoostVals = resources.getStringArray(2131427383);
    }
}
