package com.audlabs.viperfx.screen;

import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.a.a;
import com.audlabs.viperfx.widget.ProgressBarView;
import com.audlabs.viperfx.widget.TouchRotateButton;

public class n implements Unbinder {
    protected ConvolverFragment b;

    public n(ConvolverFragment convolverFragment, a aVar, Object obj) {
        this.b = convolverFragment;
        convolverFragment.mLayoutConvolverKnlMain = (ScrollView) aVar.a(obj, 2131558602, "field 'mLayoutConvolverKnlMain'", ScrollView.class);
        convolverFragment.mBtnConvolverKnl = (Button) aVar.a(obj, 2131558604, "field 'mBtnConvolverKnl'", Button.class);
        convolverFragment.mTvConvolverCrosschannelVal = (TextView) aVar.a(obj, 2131558606, "field 'mTvConvolverCrosschannelVal'", TextView.class);
        convolverFragment.mTrbConvolverCrosschannel = (TouchRotateButton) aVar.a(obj, 2131558607, "field 'mTrbConvolverCrosschannel'", TouchRotateButton.class);
        convolverFragment.mPbvConvolverCrosschannel = (ProgressBarView) aVar.a(obj, 2131558608, "field 'mPbvConvolverCrosschannel'", ProgressBarView.class);
        convolverFragment.mLayoutConvolverKnlSearch = (LinearLayout) aVar.a(obj, 2131558599, "field 'mLayoutConvolverKnlSearch'", LinearLayout.class);
        convolverFragment.mEtConvolverKnlSearch = (AppCompatEditText) aVar.a(obj, 2131558600, "field 'mEtConvolverKnlSearch'", AppCompatEditText.class);
        convolverFragment.mConvolverKnlRecyclerview = (RecyclerView) aVar.a(obj, 2131558601, "field 'mConvolverKnlRecyclerview'", RecyclerView.class);
    }
}
