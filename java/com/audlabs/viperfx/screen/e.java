package com.audlabs.viperfx.screen;

import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.a.a;
import com.audlabs.viperfx.widget.TouchRotateButton;

public class e implements Unbinder {
    protected ColorfulmusicFragment b;

    public e(ColorfulmusicFragment colorfulmusicFragment, a aVar, Object obj, Resources resources) {
        this.b = colorfulmusicFragment;
        colorfulmusicFragment.mTvColorfulmusicVal = (TextView) aVar.a(obj, 2131558538, "field 'mTvColorfulmusicVal'", TextView.class);
        colorfulmusicFragment.mTrbColorfulmusic = (TouchRotateButton) aVar.a(obj, 2131558540, "field 'mTrbColorfulmusic'", TouchRotateButton.class);
        colorfulmusicFragment.mIVKnobPoint = (ImageView) aVar.a(obj, 2131558539, "field 'mIVKnobPoint'", ImageView.class);
        colorfulmusicFragment.mTvColorfulmusicMiVal = (TextView) aVar.a(obj, 2131558542, "field 'mTvColorfulmusicMiVal'", TextView.class);
        colorfulmusicFragment.mTrbColorfulmusicMi = (TouchRotateButton) aVar.a(obj, 2131558544, "field 'mTrbColorfulmusicMi'", TouchRotateButton.class);
        colorfulmusicFragment.mIVKnobPointMi = (ImageView) aVar.a(obj, 2131558543, "field 'mIVKnobPointMi'", ImageView.class);
        colorfulmusicFragment.mCoeffArrs = resources.getStringArray(2131427330);
        colorfulmusicFragment.mMidimageArrs = resources.getStringArray(2131427331);
    }
}
