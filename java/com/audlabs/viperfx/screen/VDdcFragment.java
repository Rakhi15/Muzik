package com.audlabs.viperfx.screen;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ad;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.dh;
import android.support.v7.widget.eg;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.a.a;
import butterknife.a.e;
import com.audlabs.viperfx.base.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VDdcFragment extends b implements TextWatcher {
    private VDdcAdapter b;
    private Map c;
    private List d;
    private List e;
    @BindView
    AppCompatEditText etSearch;
    private String f;
    private int g = -1;
    private Handler h = new bi(this);
    @BindView
    RecyclerView mRecyclerView;

    public class VDdcAdapter extends dh {
        final /* synthetic */ VDdcFragment a;

        class VDdcViewHolder extends eg {
            @BindView
            ImageView ivSelect;
            final /* synthetic */ VDdcAdapter l;
            @BindView
            TextView tvName;

            public VDdcViewHolder(VDdcAdapter vDdcAdapter, View view) {
                this.l = vDdcAdapter;
                super(view);
                ButterKnife.a(this, view);
            }
        }

        public final class VDdcViewHolder_ViewBinder implements e {
            public Unbinder a(a aVar, VDdcViewHolder vDdcViewHolder, Object obj) {
                return new bl(vDdcViewHolder, aVar, obj);
            }
        }

        public VDdcAdapter(VDdcFragment vDdcFragment) {
            this.a = vDdcFragment;
        }

        public int a() {
            return this.a.d.size();
        }

        public VDdcViewHolder a(ViewGroup viewGroup, int i) {
            return new VDdcViewHolder(this, LayoutInflater.from(this.a.getActivity()).inflate(2130968639, viewGroup, false));
        }

        public void a(VDdcViewHolder vDdcViewHolder, int i) {
            if (i % 2 == 0) {
                vDdcViewHolder.a.setBackgroundResource(2130837593);
            } else {
                vDdcViewHolder.a.setBackgroundResource(2130837592);
            }
            if (i == this.a.g) {
                vDdcViewHolder.ivSelect.setImageResource(2130903086);
            } else {
                vDdcViewHolder.ivSelect.setImageResource(2130903085);
            }
            vDdcViewHolder.tvName.setText((CharSequence) this.a.d.get(i));
            vDdcViewHolder.a.setOnClickListener(new bk(this, i));
        }

        public /* synthetic */ eg b(ViewGroup viewGroup, int i) {
            return a(viewGroup, i);
        }
    }

    private void a() {
        this.etSearch.addTextChangedListener(this);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.mRecyclerView.setAdapter(this.b);
    }

    private void a(String str) {
        new bj(this, str).start();
    }

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.b = new VDdcAdapter(this);
        this.f = this.a.getString("viper4android.headphonefx.viperddc.device", "");
        a("");
        if (!this.a.getBoolean("viper4android.settings.viperddc.notice", false)) {
            this.a.edit().putBoolean("viper4android.settings.viperddc.notice", true).apply();
            ad adVar = new ad(getActivity());
            adVar.a("ViPERFX");
            adVar.b(getActivity().getResources().getString(2131099762));
            adVar.b(getActivity().getResources().getString(2131099816), null);
            adVar.c();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(2130968636, viewGroup, false);
        ButterKnife.a(this, inflate);
        a();
        return inflate;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        a(charSequence + "");
    }
}
