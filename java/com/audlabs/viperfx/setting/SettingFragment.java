package com.audlabs.viperfx.setting;

import android.app.Fragment;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ad;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import butterknife.BindArray;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.audlabs.viperfx.about.AboutActivity;
import com.audlabs.viperfx.about.ChangelogActivity;
import com.audlabs.viperfx.about.HelpActivity;
import com.audlabs.viperfx.b.d;
import com.audlabs.viperfx.update.e;
import java.util.List;

public class SettingFragment extends Fragment implements OnClickListener {
    private SharedPreferences a;
    private String[] b;
    @BindView
    View mCloseSelinuxView;
    @BindView
    RelativeLayout mCompatible;
    @BindArray
    String[] mCompatibleModes;
    @BindView
    AppCompatTextView mCompatibleState;
    @BindView
    RelativeLayout mDefaultStorage;
    @BindView
    RelativeLayout mLockeffect;
    @BindView
    AppCompatTextView mLockeffectState;
    @BindView
    RelativeLayout mNotify;
    @BindView
    AppCompatTextView mTvAbout;
    @BindView
    AppCompatTextView mTvChangelog;
    @BindView
    AppCompatTextView mTvCheckupdate;
    @BindView
    AppCompatTextView mTvCloseSelinux;
    @BindView
    AppCompatTextView mTvDefaultStorageState;
    @BindView
    AppCompatTextView mTvDeveloper;
    @BindView
    AppCompatTextView mTvHelp;
    @BindView
    AppCompatTextView mTvNotifyState;
    @BindView
    AppCompatTextView mTvv4aRated;

    private void a() {
        this.mLockeffect.setOnClickListener(this);
        this.mNotify.setOnClickListener(this);
        this.mCompatible.setOnClickListener(this);
        this.mDefaultStorage.setOnClickListener(this);
        this.mTvDeveloper.setOnClickListener(this);
        this.mTvCloseSelinux.setOnClickListener(this);
        this.mTvv4aRated.setOnClickListener(this);
        this.mTvHelp.setOnClickListener(this);
        this.mTvChangelog.setOnClickListener(this);
        this.mTvCheckupdate.setOnClickListener(this);
        this.mTvAbout.setOnClickListener(this);
    }

    private void b() {
        int i = 1;
        String string = this.a.getString("viper4android.settings.lock_effect", "none");
        int i2 = string.equalsIgnoreCase("none") ? 0 : string.equalsIgnoreCase("headset") ? 1 : string.equalsIgnoreCase("speaker") ? 2 : string.equalsIgnoreCase("bluetooth") ? 3 : string.equalsIgnoreCase("usb") ? 4 : 5;
        this.mLockeffectState.setText(this.b[i2]);
        if (this.a.getBoolean("viper4android.settings.show_notify_icon", false)) {
            this.mTvNotifyState.setText(getActivity().getResources().getString(2131099817));
        } else {
            this.mTvNotifyState.setText(getActivity().getResources().getString(2131099778));
        }
        this.mTvDefaultStorageState.setText(d.b());
        if (this.a.getString("viper4android.settings.compatiblemode", "global").equals("global")) {
            i = 0;
        }
        this.mCompatibleState.setText(this.mCompatibleModes[i]);
        boolean z = this.a.getBoolean("viper4android.settings.developer", false);
        this.mTvDeveloper.setText(z ? 2131099779 : 2131099801);
        if (z) {
            this.mCloseSelinuxView.setVisibility(0);
            this.mTvCloseSelinux.setVisibility(0);
            return;
        }
        this.mCloseSelinuxView.setVisibility(8);
        this.mTvCloseSelinux.setVisibility(8);
    }

    public void onClick(View view) {
        boolean z = true;
        ad adVar;
        switch (view.getId()) {
            case 2131558664:
                if (this.a.getBoolean("viper4android.settings.show_notify_icon", false)) {
                    z = false;
                }
                if (z) {
                    this.mTvNotifyState.setText(getActivity().getResources().getString(2131099817));
                } else {
                    this.mTvNotifyState.setText(getActivity().getResources().getString(2131099778));
                }
                Editor edit = this.a.edit();
                edit.putBoolean("viper4android.settings.show_notify_icon", z);
                edit.apply();
                if (z) {
                    getActivity().sendBroadcast(new Intent("com.audlabs.viperfx.SHOWNOTIFY"));
                    return;
                } else {
                    getActivity().sendBroadcast(new Intent("com.audlabs.viperfx.CANCELNOTIFY"));
                    return;
                }
            case 2131558666:
                new ad(getActivity()).a(2131099809).a(this.b, new a(this)).a(true).b().show();
                return;
            case 2131558668:
                new ad(getActivity()).a(2131099782).c(2131427332, new b(this)).a(true).b().show();
                return;
            case 2131558670:
                adVar = new ad(getActivity());
                adVar.a(2131099784);
                List a = d.a(getActivity());
                CharSequence[] charSequenceArr = new String[a.size()];
                a.toArray(charSequenceArr);
                adVar.a(charSequenceArr, new c(this, charSequenceArr));
                adVar.b().show();
                return;
            case 2131558672:
                if (this.a.getBoolean("viper4android.settings.developer", false)) {
                    this.a.edit().putBoolean("viper4android.settings.developer", false).apply();
                    b();
                    return;
                }
                adVar = new ad(getActivity());
                adVar.a(2131099801);
                adVar.b(2131099802);
                adVar.a(2131099816, new d(this));
                adVar.b(2131099775, null);
                adVar.b().show();
                return;
            case 2131558674:
                adVar = new ad(getActivity());
                adVar.a(2131099780);
                adVar.b(2131099781);
                adVar.a(2131099816, new e(this));
                adVar.b(2131099775, null);
                adVar.b().show();
                return;
            case 2131558675:
                getActivity().startActivity(new Intent(getActivity(), HelpActivity.class));
                getActivity().overridePendingTransition(2131034128, 0);
                return;
            case 2131558676:
                try {
                    getActivity().startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + getActivity().getPackageName())));
                    return;
                } catch (ActivityNotFoundException e) {
                    getActivity().startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=" + getActivity().getPackageName())));
                    return;
                }
            case 2131558677:
                getActivity().startActivity(new Intent(getActivity(), ChangelogActivity.class));
                getActivity().overridePendingTransition(2131034128, 0);
                return;
            case 2131558678:
                new e(getActivity(), true).a();
                return;
            case 2131558679:
                getActivity().startActivity(new Intent(getActivity(), AboutActivity.class));
                getActivity().overridePendingTransition(2131034128, 0);
                return;
            default:
                return;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = getActivity().getSharedPreferences("com.audlabs.viperfx.settings", 0);
        this.b = new String[]{getResources().getString(2131099785), getResources().getString(2131099803), getResources().getString(2131099825), getResources().getString(2131099774), getResources().getString(2131099838)};
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(2130968632, viewGroup, false);
        ButterKnife.a(this, inflate);
        a();
        b();
        return inflate;
    }
}
