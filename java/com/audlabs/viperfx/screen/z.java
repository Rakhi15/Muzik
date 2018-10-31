package com.audlabs.viperfx.screen;

import android.content.res.Resources;
import android.widget.Button;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.a.a;
import com.audlabs.viperfx.widget.ProgressBarView;
import com.audlabs.viperfx.widget.TouchRotateButton;

public class z implements Unbinder {
    protected DynamicsystemFragment b;

    public z(DynamicsystemFragment dynamicsystemFragment, a aVar, Object obj, Resources resources) {
        this.b = dynamicsystemFragment;
        dynamicsystemFragment.mBtnDynamicsystemOutput = (Button) aVar.a(obj, 2131558618, "field 'mBtnDynamicsystemOutput'", Button.class);
        dynamicsystemFragment.mTvDynamicsystemBassVal = (TextView) aVar.a(obj, 2131558620, "field 'mTvDynamicsystemBassVal'", TextView.class);
        dynamicsystemFragment.mTrbDynamicsystemBass = (TouchRotateButton) aVar.a(obj, 2131558621, "field 'mTrbDynamicsystemBass'", TouchRotateButton.class);
        dynamicsystemFragment.mPbvDynamicsystemBass = (ProgressBarView) aVar.a(obj, 2131558622, "field 'mPbvDynamicsystemBass'", ProgressBarView.class);
        dynamicsystemFragment.outputsArray = resources.getStringArray(2131427337);
        dynamicsystemFragment.outputs = resources.getStringArray(2131427365);
    }
}
