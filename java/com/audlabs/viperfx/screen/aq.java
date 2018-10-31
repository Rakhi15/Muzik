package com.audlabs.viperfx.screen;

import android.widget.CheckBox;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.a.a;
import com.audlabs.viperfx.widget.ProgressBarView;
import com.audlabs.viperfx.widget.TouchRotateButton;

public class aq implements Unbinder {
    protected FetCompressorFragment b;

    public aq(FetCompressorFragment fetCompressorFragment, a aVar, Object obj) {
        this.b = fetCompressorFragment;
        fetCompressorFragment.mTvFetCompressorThresholdVal = (TextView) aVar.a(obj, 2131558546, "field 'mTvFetCompressorThresholdVal'", TextView.class);
        fetCompressorFragment.mTrbFetCompressorThreshold = (TouchRotateButton) aVar.a(obj, 2131558547, "field 'mTrbFetCompressorThreshold'", TouchRotateButton.class);
        fetCompressorFragment.mPbvFetCompressorThreshold = (ProgressBarView) aVar.a(obj, 2131558548, "field 'mPbvFetCompressorThreshold'", ProgressBarView.class);
        fetCompressorFragment.mTvFetCompressorRatioVal = (TextView) aVar.a(obj, 2131558550, "field 'mTvFetCompressorRatioVal'", TextView.class);
        fetCompressorFragment.mTrbFetCompressorRatio = (TouchRotateButton) aVar.a(obj, 2131558551, "field 'mTrbFetCompressorRatio'", TouchRotateButton.class);
        fetCompressorFragment.mPbvFetCompressorRatio = (ProgressBarView) aVar.a(obj, 2131558552, "field 'mPbvFetCompressorRatio'", ProgressBarView.class);
        fetCompressorFragment.mFetCompressorAutokneeEnable = (CheckBox) aVar.a(obj, 2131558554, "field 'mFetCompressorAutokneeEnable'", CheckBox.class);
        fetCompressorFragment.mTvFetCompressorKneeVal = (TextView) aVar.a(obj, 2131558556, "field 'mTvFetCompressorKneeVal'", TextView.class);
        fetCompressorFragment.mTrbFetCompressorKnee = (TouchRotateButton) aVar.a(obj, 2131558557, "field 'mTrbFetCompressorKnee'", TouchRotateButton.class);
        fetCompressorFragment.mPbvFetCompressorKnee = (ProgressBarView) aVar.a(obj, 2131558558, "field 'mPbvFetCompressorKnee'", ProgressBarView.class);
        fetCompressorFragment.mFetCompressorAutogainEnable = (CheckBox) aVar.a(obj, 2131558564, "field 'mFetCompressorAutogainEnable'", CheckBox.class);
        fetCompressorFragment.mTvFetCompressorGainVal = (TextView) aVar.a(obj, 2131558566, "field 'mTvFetCompressorGainVal'", TextView.class);
        fetCompressorFragment.mTrbFetCompressorGain = (TouchRotateButton) aVar.a(obj, 2131558567, "field 'mTrbFetCompressorGain'", TouchRotateButton.class);
        fetCompressorFragment.mPbvFetCompressorGain = (ProgressBarView) aVar.a(obj, 2131558568, "field 'mPbvFetCompressorGain'", ProgressBarView.class);
        fetCompressorFragment.mFetCompressorAutoattackEnable = (CheckBox) aVar.a(obj, 2131558570, "field 'mFetCompressorAutoattackEnable'", CheckBox.class);
        fetCompressorFragment.mTvFetCompressorAttackVal = (TextView) aVar.a(obj, 2131558572, "field 'mTvFetCompressorAttackVal'", TextView.class);
        fetCompressorFragment.mTrbFetCompressorAttack = (TouchRotateButton) aVar.a(obj, 2131558573, "field 'mTrbFetCompressorAttack'", TouchRotateButton.class);
        fetCompressorFragment.mPbvFetCompressorAttack = (ProgressBarView) aVar.a(obj, 2131558574, "field 'mPbvFetCompressorAttack'", ProgressBarView.class);
        fetCompressorFragment.mFetCompressorAutoreleaseEnable = (CheckBox) aVar.a(obj, 2131558580, "field 'mFetCompressorAutoreleaseEnable'", CheckBox.class);
        fetCompressorFragment.mTvFetCompressorReleaseVal = (TextView) aVar.a(obj, 2131558582, "field 'mTvFetCompressorReleaseVal'", TextView.class);
        fetCompressorFragment.mTrbFetCompressorRelease = (TouchRotateButton) aVar.a(obj, 2131558583, "field 'mTrbFetCompressorRelease'", TouchRotateButton.class);
        fetCompressorFragment.mPbvFetCompressorRelease = (ProgressBarView) aVar.a(obj, 2131558584, "field 'mPbvFetCompressorRelease'", ProgressBarView.class);
        fetCompressorFragment.mTvFetCompressorKneemultiVal = (TextView) aVar.a(obj, 2131558560, "field 'mTvFetCompressorKneemultiVal'", TextView.class);
        fetCompressorFragment.mTrbFetCompressorKneemulti = (TouchRotateButton) aVar.a(obj, 2131558561, "field 'mTrbFetCompressorKneemulti'", TouchRotateButton.class);
        fetCompressorFragment.mPbvFetCompressorKneemulti = (ProgressBarView) aVar.a(obj, 2131558562, "field 'mPbvFetCompressorKneemulti'", ProgressBarView.class);
        fetCompressorFragment.mTvFetCompressorMaxattackVal = (TextView) aVar.a(obj, 2131558576, "field 'mTvFetCompressorMaxattackVal'", TextView.class);
        fetCompressorFragment.mTrbFetCompressorMaxattack = (TouchRotateButton) aVar.a(obj, 2131558577, "field 'mTrbFetCompressorMaxattack'", TouchRotateButton.class);
        fetCompressorFragment.mPbvFetCompressorMaxattack = (ProgressBarView) aVar.a(obj, 2131558578, "field 'mPbvFetCompressorMaxattack'", ProgressBarView.class);
        fetCompressorFragment.mTvFetCompressorMaxreleaseVal = (TextView) aVar.a(obj, 2131558586, "field 'mTvFetCompressorMaxreleaseVal'", TextView.class);
        fetCompressorFragment.mTrbFetCompressorMaxrelease = (TouchRotateButton) aVar.a(obj, 2131558587, "field 'mTrbFetCompressorMaxrelease'", TouchRotateButton.class);
        fetCompressorFragment.mPbvFetCompressorMaxrelease = (ProgressBarView) aVar.a(obj, 2131558588, "field 'mPbvFetCompressorMaxrelease'", ProgressBarView.class);
        fetCompressorFragment.mTvFetCompressorCrestVal = (TextView) aVar.a(obj, 2131558590, "field 'mTvFetCompressorCrestVal'", TextView.class);
        fetCompressorFragment.mTrbFetCompressorCrest = (TouchRotateButton) aVar.a(obj, 2131558591, "field 'mTrbFetCompressorCrest'", TouchRotateButton.class);
        fetCompressorFragment.mPbvFetCompressorCrest = (ProgressBarView) aVar.a(obj, 2131558592, "field 'mPbvFetCompressorCrest'", ProgressBarView.class);
        fetCompressorFragment.mTvFetCompressorAdaptVal = (TextView) aVar.a(obj, 2131558594, "field 'mTvFetCompressorAdaptVal'", TextView.class);
        fetCompressorFragment.mTrbFetCompressorAdapt = (TouchRotateButton) aVar.a(obj, 2131558595, "field 'mTrbFetCompressorAdapt'", TouchRotateButton.class);
        fetCompressorFragment.mPbvFetCompressorAdapt = (ProgressBarView) aVar.a(obj, 2131558596, "field 'mPbvFetCompressorAdapt'", ProgressBarView.class);
        fetCompressorFragment.mFetCompressorNoclipenableEnable = (CheckBox) aVar.a(obj, 2131558598, "field 'mFetCompressorNoclipenableEnable'", CheckBox.class);
    }
}
