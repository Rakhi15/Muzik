package com.audlabs.viperfx.screen;

import android.content.res.Resources;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.a.a;

public class av implements Unbinder {
    protected FxLimiterFragment b;

    public av(FxLimiterFragment fxLimiterFragment, a aVar, Object obj, Resources resources) {
        this.b = fxLimiterFragment;
        fxLimiterFragment.mOutputPanEnable = (CheckBox) aVar.a(obj, 2131558627, "field 'mOutputPanEnable'", CheckBox.class);
        fxLimiterFragment.mTvOutputPanVal = (TextView) aVar.a(obj, 2131558628, "field 'mTvOutputPanVal'", TextView.class);
        fxLimiterFragment.mSbOutputPan = (SeekBar) aVar.a(obj, 2131558629, "field 'mSbOutputPan'", SeekBar.class);
        fxLimiterFragment.mOutputGainEnable = (CheckBox) aVar.a(obj, 2131558631, "field 'mOutputGainEnable'", CheckBox.class);
        fxLimiterFragment.mTvOutputGainVal = (TextView) aVar.a(obj, 2131558632, "field 'mTvOutputGainVal'", TextView.class);
        fxLimiterFragment.mSbOutputGain = (SeekBar) aVar.a(obj, 2131558633, "field 'mSbOutputGain'", SeekBar.class);
        fxLimiterFragment.mLimiterEnable = (CheckBox) aVar.a(obj, 2131558635, "field 'mLimiterEnable'", CheckBox.class);
        fxLimiterFragment.mTvLimiterVal = (TextView) aVar.a(obj, 2131558636, "field 'mTvLimiterVal'", TextView.class);
        fxLimiterFragment.mSbLimiter = (SeekBar) aVar.a(obj, 2131558637, "field 'mSbLimiter'", SeekBar.class);
        fxLimiterFragment.mOutputs = resources.getStringArray(2131427339);
        fxLimiterFragment.mOutputVals = resources.getStringArray(2131427369);
        fxLimiterFragment.mOutputVols = resources.getStringArray(2131427340);
        fxLimiterFragment.mOutputVolVals = resources.getStringArray(2131427370);
    }
}
