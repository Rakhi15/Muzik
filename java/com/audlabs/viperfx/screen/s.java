package com.audlabs.viperfx.screen;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import me.imid.swipebacklayout.lib.f;

public class s extends Fragment {
    public static Fragment a(String str) {
        Object obj = -1;
        switch (str.hashCode()) {
            case -1527618773:
                if (str.equals("colorfulmusic")) {
                    obj = 5;
                    break;
                }
                break;
            case -934352430:
                if (str.equals("reverb")) {
                    obj = 8;
                    break;
                }
                break;
            case -864340600:
                if (str.equals("analogx")) {
                    obj = 13;
                    break;
                }
                break;
            case -369448763:
                if (str.equals("compressor")) {
                    obj = 14;
                    break;
                }
                break;
            case -340672014:
                if (str.equals("convolver")) {
                    obj = 4;
                    break;
                }
                break;
            case -96105049:
                if (str.equals("diffsurr")) {
                    obj = 6;
                    break;
                }
                break;
            case 116737:
                if (str.equals("vhs")) {
                    obj = 7;
                    break;
                }
                break;
            case 117064:
                if (str.equals("vse")) {
                    obj = 2;
                    break;
                }
                break;
            case 3016415:
                if (str.equals("bass")) {
                    obj = 10;
                    break;
                }
                break;
            case 3065381:
                if (str.equals("cure")) {
                    obj = 12;
                    break;
                }
                break;
            case 97439995:
                if (str.equals("fireq")) {
                    obj = 3;
                    break;
                }
                break;
            case 176117160:
                if (str.equals("limiter")) {
                    obj = 15;
                    break;
                }
                break;
            case 853581844:
                if (str.equals("clarity")) {
                    obj = 11;
                    break;
                }
                break;
            case 1356045338:
                if (str.equals("playbackgain")) {
                    obj = null;
                    break;
                }
                break;
            case 1424123694:
                if (str.equals("dynamicsystem")) {
                    obj = 9;
                    break;
                }
                break;
            case 1495031321:
                if (str.equals("viperddc")) {
                    obj = 1;
                    break;
                }
                break;
        }
        switch (obj) {
            case f.View_android_theme /*0*/:
                return new PlaybackFragment();
            case f.View_android_focusable /*1*/:
                return new VDdcFragment();
            case f.View_paddingStart /*2*/:
                return new VseFragment();
            case f.View_paddingEnd /*3*/:
                return new FireqFragment();
            case f.View_theme /*4*/:
                return new ConvolverFragment();
            case f.Toolbar_contentInsetStart /*5*/:
                return new ColorfulmusicFragment();
            case f.Toolbar_contentInsetEnd /*6*/:
                return new DiffsurrFragment();
            case f.Toolbar_contentInsetLeft /*7*/:
                return new VhsFragment();
            case f.Toolbar_contentInsetRight /*8*/:
                return new ReverbFragment();
            case f.Toolbar_popupTheme /*9*/:
                return new DynamicsystemFragment();
            case f.Toolbar_titleTextAppearance /*10*/:
                return new VBassFragment();
            case f.Toolbar_subtitleTextAppearance /*11*/:
                return new VClarityFragment();
            case f.Toolbar_titleMargins /*12*/:
                return new CuresystemFragment();
            case f.Toolbar_titleMarginStart /*13*/:
                return new AnalogxFragment();
            case f.Toolbar_titleMarginEnd /*14*/:
                return new FetCompressorFragment();
            case f.Toolbar_titleMarginTop /*15*/:
                return new FxLimiterFragment();
            default:
                return new s();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View textView = new TextView(getActivity());
        textView.setText(2131099672);
        return textView;
    }
}
