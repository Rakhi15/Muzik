package com.audlabs.viperfx.setting;

import android.content.res.Resources;
import android.support.v7.widget.AppCompatTextView;
import android.widget.RelativeLayout;
import butterknife.Unbinder;
import butterknife.a.a;

public class f implements Unbinder {
    protected SettingFragment b;

    public f(SettingFragment settingFragment, a aVar, Object obj, Resources resources) {
        this.b = settingFragment;
        settingFragment.mLockeffect = (RelativeLayout) aVar.a(obj, 2131558666, "field 'mLockeffect'", RelativeLayout.class);
        settingFragment.mLockeffectState = (AppCompatTextView) aVar.a(obj, 2131558667, "field 'mLockeffectState'", AppCompatTextView.class);
        settingFragment.mNotify = (RelativeLayout) aVar.a(obj, 2131558664, "field 'mNotify'", RelativeLayout.class);
        settingFragment.mTvNotifyState = (AppCompatTextView) aVar.a(obj, 2131558665, "field 'mTvNotifyState'", AppCompatTextView.class);
        settingFragment.mCompatible = (RelativeLayout) aVar.a(obj, 2131558668, "field 'mCompatible'", RelativeLayout.class);
        settingFragment.mCompatibleState = (AppCompatTextView) aVar.a(obj, 2131558669, "field 'mCompatibleState'", AppCompatTextView.class);
        settingFragment.mDefaultStorage = (RelativeLayout) aVar.a(obj, 2131558670, "field 'mDefaultStorage'", RelativeLayout.class);
        settingFragment.mTvDefaultStorageState = (AppCompatTextView) aVar.a(obj, 2131558671, "field 'mTvDefaultStorageState'", AppCompatTextView.class);
        settingFragment.mTvDeveloper = (AppCompatTextView) aVar.a(obj, 2131558672, "field 'mTvDeveloper'", AppCompatTextView.class);
        settingFragment.mCloseSelinuxView = aVar.a(obj, 2131558673, "field 'mCloseSelinuxView'");
        settingFragment.mTvCloseSelinux = (AppCompatTextView) aVar.a(obj, 2131558674, "field 'mTvCloseSelinux'", AppCompatTextView.class);
        settingFragment.mTvv4aRated = (AppCompatTextView) aVar.a(obj, 2131558676, "field 'mTvv4aRated'", AppCompatTextView.class);
        settingFragment.mTvHelp = (AppCompatTextView) aVar.a(obj, 2131558675, "field 'mTvHelp'", AppCompatTextView.class);
        settingFragment.mTvChangelog = (AppCompatTextView) aVar.a(obj, 2131558677, "field 'mTvChangelog'", AppCompatTextView.class);
        settingFragment.mTvCheckupdate = (AppCompatTextView) aVar.a(obj, 2131558678, "field 'mTvCheckupdate'", AppCompatTextView.class);
        settingFragment.mTvAbout = (AppCompatTextView) aVar.a(obj, 2131558679, "field 'mTvAbout'", AppCompatTextView.class);
        settingFragment.mCompatibleModes = resources.getStringArray(2131427332);
    }
}
