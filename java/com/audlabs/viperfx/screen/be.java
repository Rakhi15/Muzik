package com.audlabs.viperfx.screen;

import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.a.a;
import com.audlabs.viperfx.widget.ProgressBarView;
import com.audlabs.viperfx.widget.TouchRotateButton;

public class be implements Unbinder {
    protected VBassFragment b;

    public be(VBassFragment vBassFragment, a aVar, Object obj, Resources resources) {
        this.b = vBassFragment;
        vBassFragment.mRgBassMode = (RadioGroup) aVar.a(obj, 2131558681, "field 'mRgBassMode'", RadioGroup.class);
        vBassFragment.mRbModeNaturalbass = (RadioButton) aVar.a(obj, 2131558682, "field 'mRbModeNaturalbass'", RadioButton.class);
        vBassFragment.mRbModePurebass = (RadioButton) aVar.a(obj, 2131558683, "field 'mRbModePurebass'", RadioButton.class);
        vBassFragment.mRbModeSubwoofer = (RadioButton) aVar.a(obj, 2131558684, "field 'mRbModeSubwoofer'", RadioButton.class);
        vBassFragment.mTvBassFreqVal = (TextView) aVar.a(obj, 2131558686, "field 'mTvBassFreqVal'", TextView.class);
        vBassFragment.mTrbBassFreq = (TouchRotateButton) aVar.a(obj, 2131558687, "field 'mTrbBassFreq'", TouchRotateButton.class);
        vBassFragment.mPbvBassFreq = (ProgressBarView) aVar.a(obj, 2131558688, "field 'mPbvBassFreq'", ProgressBarView.class);
        vBassFragment.mTvBassGainVal = (TextView) aVar.a(obj, 2131558690, "field 'mTvBassGainVal'", TextView.class);
        vBassFragment.mTrbBassGain = (TouchRotateButton) aVar.a(obj, 2131558691, "field 'mTrbBassGain'", TouchRotateButton.class);
        vBassFragment.mIVKnobPoint = (ImageView) aVar.a(obj, 2131558531, "field 'mIVKnobPoint'", ImageView.class);
        vBassFragment.vbassMode = resources.getStringArray(2131427348);
        vBassFragment.vbassFreq = resources.getStringArray(2131427347);
        vBassFragment.vbassBoosts = resources.getStringArray(2131427346);
        vBassFragment.vbassBoostVals = resources.getStringArray(2131427380);
    }
}
