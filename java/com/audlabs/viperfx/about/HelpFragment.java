package com.audlabs.viperfx.about;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class HelpFragment extends Fragment {
    @BindView
    TextView mTvChangelogtxt;

    private void a() {
        this.mTvChangelogtxt.setText(getActivity().getResources().getString(2131099804));
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(2130968621, viewGroup, false);
        ButterKnife.a(this, inflate);
        a();
        return inflate;
    }
}
