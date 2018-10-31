package com.audlabs.viperfx.main;

import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.dh;
import android.support.v7.widget.eg;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.a.a;
import butterknife.a.e;
import com.audlabs.viperfx.b.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainFragment extends PreferenceFragment {
    private SharedPreferences a;
    private String b;
    private MianAdapter c;
    private List d;
    private r e;
    private RecyclerView f;

    public class MianAdapter extends dh {
        final /* synthetic */ MainFragment a;

        class MainViewHolder extends eg {
            @BindView
            CheckBox cbEnable;
            @BindView
            ImageView ivIcon;
            final /* synthetic */ MianAdapter l;
            @BindView
            TextView tvTilte;

            public MainViewHolder(MianAdapter mianAdapter, View view) {
                this.l = mianAdapter;
                super(view);
                ButterKnife.a(this, view);
            }
        }

        public final class MainViewHolder_ViewBinder implements e {
            public Unbinder a(a aVar, MainViewHolder mainViewHolder, Object obj) {
                return new q(mainViewHolder, aVar, obj);
            }
        }

        public MianAdapter(MainFragment mainFragment) {
            this.a = mainFragment;
        }

        public int a() {
            return this.a.d.size();
        }

        public MainViewHolder a(ViewGroup viewGroup, int i) {
            return new MainViewHolder(this, LayoutInflater.from(this.a.getActivity()).inflate(2130968638, viewGroup, false));
        }

        public void a(MainViewHolder mainViewHolder, int i) {
            if (i % 2 == 0) {
                mainViewHolder.a.setBackgroundResource(2130837593);
            } else {
                mainViewHolder.a.setBackgroundResource(2130837592);
            }
            HashMap hashMap = (HashMap) this.a.d.get(i);
            mainViewHolder.ivIcon.setImageResource(Integer.valueOf((String) hashMap.get("ICON")).intValue());
            mainViewHolder.tvTilte.setText((CharSequence) hashMap.get("TITLE"));
            if (hashMap.get("KEY") != null) {
                mainViewHolder.cbEnable.setVisibility(0);
                mainViewHolder.cbEnable.setChecked(this.a.a.getBoolean((String) hashMap.get("KEY"), false));
            } else {
                mainViewHolder.cbEnable.setVisibility(4);
            }
            mainViewHolder.cbEnable.setOnClickListener(new o(this, hashMap, mainViewHolder));
            mainViewHolder.a.setOnClickListener(new p(this, hashMap, mainViewHolder));
        }

        public /* synthetic */ eg b(ViewGroup viewGroup, int i) {
            return a(viewGroup, i);
        }
    }

    public static MainFragment a(String str) {
        MainFragment mainFragment = new MainFragment();
        Bundle bundle = new Bundle();
        bundle.putString("config", str);
        mainFragment.setArguments(bundle);
        return mainFragment;
    }

    public List a() {
        List arrayList = new ArrayList();
        HashMap hashMap;
        if ("speaker".equals(this.b)) {
            hashMap = new HashMap();
            hashMap.put("ICON", String.valueOf(2130903098));
            hashMap.put("TITLE", getActivity().getString(2131099737));
            hashMap.put("KEY", "viper4android.speakerfx.enable");
            arrayList.add(hashMap);
            hashMap = new HashMap();
            hashMap.put("ICON", String.valueOf(2130903100));
            hashMap.put("TITLE", getActivity().getString(2131099727));
            hashMap.put("KEY", "viper4android.speakerfx.fetcompressor.enable");
            hashMap.put("FLAG", "compressor");
            arrayList.add(hashMap);
            hashMap = new HashMap();
            hashMap.put("ICON", String.valueOf(2130903054));
            hashMap.put("TITLE", getActivity().getString(2131099710));
            hashMap.put("KEY", "viper4android.headphonefx.fireq.enable");
            hashMap.put("FLAG", "fireq");
            arrayList.add(hashMap);
            hashMap = new HashMap();
            hashMap.put("ICON", String.valueOf(2130903070));
            hashMap.put("TITLE", getActivity().getString(2131099700));
            hashMap.put("KEY", "viper4android.headphonefx.convolver.enable");
            hashMap.put("FLAG", "convolver");
            arrayList.add(hashMap);
            hashMap = new HashMap();
            hashMap.put("ICON", String.valueOf(2130903090));
            hashMap.put("TITLE", getActivity().getString(2131099746));
            hashMap.put("KEY", "viper4android.headphonefx.reverb.enable");
            hashMap.put("FLAG", "reverb");
            arrayList.add(hashMap);
            hashMap = new HashMap();
            hashMap.put("ICON", String.valueOf(2130903099));
            hashMap.put("TITLE", getActivity().getString(2131099754));
            hashMap.put("KEY", "viper4android.speakerfx.spkopt.enable");
            arrayList.add(hashMap);
            hashMap = new HashMap();
            hashMap.put("ICON", String.valueOf(2130903053));
            hashMap.put("TITLE", getActivity().getString(2131099770));
            hashMap.put("KEY", "viper4android.headphonefx.playbackgain.enable");
            hashMap.put("FLAG", "playbackgain");
            arrayList.add(hashMap);
            hashMap = new HashMap();
            hashMap.put("ICON", String.valueOf(2130903102));
            hashMap.put("TITLE", getActivity().getString(2131099756));
            hashMap.put("FLAG", "limiter");
            arrayList.add(hashMap);
        } else {
            hashMap = new HashMap();
            hashMap.put("ICON", String.valueOf(2130903098));
            hashMap.put("TITLE", getActivity().getString(2131099737));
            hashMap.put("KEY", "viper4android.headphonefx.enable");
            arrayList.add(hashMap);
            hashMap = new HashMap();
            hashMap.put("ICON", String.valueOf(2130903055));
            hashMap.put("TITLE", getActivity().getString(2131099742));
            hashMap.put("KEY", "viper4android.headphonefx.playbackgain.enable");
            hashMap.put("FLAG", "playbackgain");
            arrayList.add(hashMap);
            hashMap = new HashMap();
            hashMap.put("ICON", String.valueOf(2130903100));
            hashMap.put("TITLE", getActivity().getString(2131099727));
            hashMap.put("KEY", "viper4android.headphonefx.fetcompressor.enable");
            hashMap.put("FLAG", "compressor");
            arrayList.add(hashMap);
            hashMap = new HashMap();
            hashMap.put("ICON", String.valueOf(2130903097));
            hashMap.put("TITLE", getActivity().getString(2131099763));
            hashMap.put("KEY", "viper4android.headphonefx.viperddc.enable");
            hashMap.put("FLAG", "viperddc");
            arrayList.add(hashMap);
            hashMap = new HashMap();
            hashMap.put("ICON", String.valueOf(2130903082));
            hashMap.put("TITLE", getActivity().getString(2131099766));
            hashMap.put("KEY", "viper4android.headphonefx.vse.enable");
            hashMap.put("FLAG", "vse");
            arrayList.add(hashMap);
            hashMap = new HashMap();
            hashMap.put("ICON", String.valueOf(2130903054));
            hashMap.put("TITLE", getActivity().getString(2131099710));
            hashMap.put("KEY", "viper4android.headphonefx.fireq.enable");
            hashMap.put("FLAG", "fireq");
            arrayList.add(hashMap);
            hashMap = new HashMap();
            hashMap.put("ICON", String.valueOf(2130903070));
            hashMap.put("TITLE", getActivity().getString(2131099700));
            hashMap.put("KEY", "viper4android.headphonefx.convolver.enable");
            hashMap.put("FLAG", "convolver");
            arrayList.add(hashMap);
            hashMap = new HashMap();
            hashMap.put("ICON", String.valueOf(2130903048));
            hashMap.put("TITLE", getActivity().getString(2131099696));
            hashMap.put("KEY", "viper4android.headphonefx.colorfulmusic.enable");
            hashMap.put("FLAG", "colorfulmusic");
            arrayList.add(hashMap);
            hashMap = new HashMap();
            hashMap.put("ICON", String.valueOf(2130903047));
            hashMap.put("TITLE", getActivity().getString(2131099702));
            hashMap.put("KEY", "viper4android.headphonefx.diffsurr.enable");
            hashMap.put("FLAG", "diffsurr");
            arrayList.add(hashMap);
            hashMap = new HashMap();
            hashMap.put("ICON", String.valueOf(2130903052));
            hashMap.put("TITLE", getActivity().getString(2131099758));
            hashMap.put("KEY", "viper4android.headphonefx.vhs.enable");
            hashMap.put("FLAG", "vhs");
            arrayList.add(hashMap);
            hashMap = new HashMap();
            hashMap.put("ICON", String.valueOf(2130903090));
            hashMap.put("TITLE", getActivity().getString(2131099746));
            hashMap.put("KEY", "viper4android.headphonefx.reverb.enable");
            hashMap.put("FLAG", "reverb");
            arrayList.add(hashMap);
            hashMap = new HashMap();
            hashMap.put("ICON", String.valueOf(2130903051));
            hashMap.put("TITLE", getActivity().getString(2131099706));
            hashMap.put("KEY", "viper4android.headphonefx.dynamicsystem.enable");
            hashMap.put("FLAG", "dynamicsystem");
            arrayList.add(hashMap);
            hashMap = new HashMap();
            hashMap.put("ICON", String.valueOf(2130903049));
            hashMap.put("TITLE", getActivity().getString(2131099707));
            hashMap.put("KEY", "viper4android.headphonefx.tube.enable");
            arrayList.add(hashMap);
            hashMap = new HashMap();
            hashMap.put("ICON", String.valueOf(2130903050));
            hashMap.put("TITLE", getActivity().getString(2131099731));
            hashMap.put("KEY", "viper4android.headphonefx.fidelity.bass.enable");
            hashMap.put("FLAG", "bass");
            arrayList.add(hashMap);
            hashMap = new HashMap();
            hashMap.put("ICON", String.valueOf(2130903083));
            hashMap.put("TITLE", getActivity().getString(2131099734));
            hashMap.put("KEY", "viper4android.headphonefx.fidelity.clarity.enable");
            hashMap.put("FLAG", "clarity");
            arrayList.add(hashMap);
            hashMap = new HashMap();
            hashMap.put("ICON", String.valueOf(2130903094));
            hashMap.put("TITLE", getActivity().getString(2131099701));
            hashMap.put("KEY", "viper4android.headphonefx.cure.enable");
            hashMap.put("FLAG", "cure");
            arrayList.add(hashMap);
            hashMap = new HashMap();
            hashMap.put("ICON", String.valueOf(2130903042));
            hashMap.put("TITLE", getActivity().getString(2131099695));
            hashMap.put("KEY", "viper4android.headphonefx.analogx.enable");
            hashMap.put("FLAG", "analogx");
            arrayList.add(hashMap);
            hashMap = new HashMap();
            hashMap.put("ICON", String.valueOf(2130903102));
            hashMap.put("TITLE", getActivity().getString(2131099736));
            hashMap.put("FLAG", "limiter");
            arrayList.add(hashMap);
        }
        return arrayList;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        c.b("onCreate");
        this.b = getArguments().getString("config");
        PreferenceManager preferenceManager = getPreferenceManager();
        preferenceManager.setSharedPreferencesName("com.audlabs.viperfx." + this.b);
        preferenceManager.setSharedPreferencesMode(4);
        this.a = preferenceManager.getSharedPreferences();
        if (this.d == null) {
            this.d = a();
        }
        this.c = new MianAdapter(this);
        this.e = new r(this);
        getActivity().registerReceiver(this.e, new IntentFilter("com.audlabs.viperfx.updatemainui"));
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.f == null) {
            this.f = new RecyclerView(getActivity());
            this.f.setLayoutManager(new LinearLayoutManager(getActivity()));
            this.f.setAdapter(this.c);
        }
        return this.f;
    }

    public void onDestroy() {
        super.onDestroy();
        getActivity().unregisterReceiver(this.e);
    }

    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
    }
}
