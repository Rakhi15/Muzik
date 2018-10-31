package com.audlabs.viperfx.screen;

import android.content.res.Resources;
import android.widget.SeekBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.a.a;

public class ba implements Unbinder {
    protected ReverbFragment b;

    public ba(ReverbFragment reverbFragment, a aVar, Object obj, Resources resources) {
        this.b = reverbFragment;
        reverbFragment.mTvReverbRoomsizeVal = (TextView) aVar.a(obj, 2131558650, "field 'mTvReverbRoomsizeVal'", TextView.class);
        reverbFragment.mSbReverbRoomsize = (SeekBar) aVar.a(obj, 2131558651, "field 'mSbReverbRoomsize'", SeekBar.class);
        reverbFragment.mTvReverbWidthVal = (TextView) aVar.a(obj, 2131558653, "field 'mTvReverbWidthVal'", TextView.class);
        reverbFragment.mSbReverbWidth = (SeekBar) aVar.a(obj, 2131558654, "field 'mSbReverbWidth'", SeekBar.class);
        reverbFragment.mTvReverbDampVal = (TextView) aVar.a(obj, 2131558656, "field 'mTvReverbDampVal'", TextView.class);
        reverbFragment.mSbReverbDamp = (SeekBar) aVar.a(obj, 2131558657, "field 'mSbReverbDamp'", SeekBar.class);
        reverbFragment.mTvReverbWetVal = (TextView) aVar.a(obj, 2131558659, "field 'mTvReverbWetVal'", TextView.class);
        reverbFragment.mSbReverbWet = (SeekBar) aVar.a(obj, 2131558660, "field 'mSbReverbWet'", SeekBar.class);
        reverbFragment.mTvReverbDryVal = (TextView) aVar.a(obj, 2131558662, "field 'mTvReverbDryVal'", TextView.class);
        reverbFragment.mSbReverbDry = (SeekBar) aVar.a(obj, 2131558663, "field 'mSbReverbDry'", SeekBar.class);
        reverbFragment.mReverbRoomsizes = resources.getStringArray(2131427343);
        reverbFragment.mReverbRoomwidts = resources.getStringArray(2131427344);
    }
}
