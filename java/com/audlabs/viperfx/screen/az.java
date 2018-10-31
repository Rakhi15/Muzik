package com.audlabs.viperfx.screen;

import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.a.a;
import com.audlabs.viperfx.widget.TouchRotateButton;

public class az implements Unbinder {
    protected PlaybackFragment b;

    public az(PlaybackFragment playbackFragment, a aVar, Object obj, Resources resources) {
        this.b = playbackFragment;
        playbackFragment.mTrbPlaybackEffect = (TouchRotateButton) aVar.a(obj, 2131558639, "field 'mTrbPlaybackEffect'", TouchRotateButton.class);
        playbackFragment.mIVKnobPoint = (ImageView) aVar.a(obj, 2131558531, "field 'mIVKnobPoint'", ImageView.class);
        playbackFragment.mTvModeSlight = (TextView) aVar.a(obj, 2131558641, "field 'mTvModeSlight'", TextView.class);
        playbackFragment.mTvModeModerate = (TextView) aVar.a(obj, 2131558640, "field 'mTvModeModerate'", TextView.class);
        playbackFragment.mTvModeExtreme = (TextView) aVar.a(obj, 2131558642, "field 'mTvModeExtreme'", TextView.class);
        playbackFragment.mTvPlaybackMaxgainVal = (TextView) aVar.a(obj, 2131558644, "field 'mTvPlaybackMaxgainVal'", TextView.class);
        playbackFragment.mSbPlaybackMaxgain = (SeekBar) aVar.a(obj, 2131558645, "field 'mSbPlaybackMaxgain'", SeekBar.class);
        playbackFragment.mTvPlaybackOutputVal = (TextView) aVar.a(obj, 2131558647, "field 'mTvPlaybackOutputVal'", TextView.class);
        playbackFragment.mSbPlaybackOutput = (SeekBar) aVar.a(obj, 2131558648, "field 'mSbPlaybackOutput'", SeekBar.class);
        playbackFragment.mRatioVals = resources.getStringArray(2131427371);
        playbackFragment.mRatios = resources.getStringArray(2131427341);
        playbackFragment.mOutputs = resources.getStringArray(2131427339);
        playbackFragment.mOutputVals = resources.getStringArray(2131427369);
        playbackFragment.mMultiFactors = resources.getStringArray(2131427338);
        playbackFragment.mMultiFactorVals = resources.getStringArray(2131427368);
    }
}
