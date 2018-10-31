package com.audlabs.viperfx.screen;

import android.content.res.Resources;
import butterknife.Unbinder;
import butterknife.a.a;
import com.audlabs.viperfx.widget.EqualizerViewBar;
import com.audlabs.viperfx.widget.Gallery;

public class au implements Unbinder {
    protected FireqFragment b;

    public au(FireqFragment fireqFragment, a aVar, Object obj, Resources resources) {
        this.b = fireqFragment;
        fireqFragment.mEqualizerView = (EqualizerViewBar) aVar.a(obj, 2131558623, "field 'mEqualizerView'", EqualizerViewBar.class);
        fireqFragment.mEqGallery = (Gallery) aVar.a(obj, 2131558625, "field 'mEqGallery'", Gallery.class);
        fireqFragment.mEQPresetNames = resources.getStringArray(2131427366);
    }
}
