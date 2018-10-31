package com.audlabs.viperfx.about;

import android.app.Fragment;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class AboutFragment extends Fragment {
    @BindView
    TextView mTvVersion;

    private void a() {
        String str;
        try {
            str = getActivity().getPackageManager().getPackageInfo(getActivity().getPackageName(), 0).versionName;
        } catch (NameNotFoundException e) {
            str = "N/A";
        }
        String string = getResources().getString(2131099671);
        this.mTvVersion.setText(String.format(string, new Object[]{str}) + "\n");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(2130968619, viewGroup, false);
        ButterKnife.a(this, inflate);
        a();
        return inflate;
    }
}
