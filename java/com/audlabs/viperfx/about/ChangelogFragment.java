package com.audlabs.viperfx.about;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ChangelogFragment extends Fragment {
    private Handler a = new b(this);
    @BindView
    TextView mTvChangelogtxt;

    private void a() {
        new Thread(new c(this)).start();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(2130968621, viewGroup, false);
        ButterKnife.a(this, inflate);
        a();
        return inflate;
    }
}
