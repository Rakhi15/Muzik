package com.audlabs.viperfx.screen;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.dh;
import android.support.v7.widget.eg;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.a.a;
import butterknife.a.e;
import com.audlabs.viperfx.base.b;
import com.audlabs.viperfx.widget.ProgressBarView;
import com.audlabs.viperfx.widget.TouchRotateButton;
import java.util.ArrayList;
import java.util.List;

public class ConvolverFragment extends b {
    private String b;
    private int c = -1;
    private VDdcAdapter d;
    private List e;
    private ArrayList f;
    private TranslateAnimation g;
    private TranslateAnimation h;
    private Handler i = new f(this);
    @BindView
    Button mBtnConvolverKnl;
    @BindView
    RecyclerView mConvolverKnlRecyclerview;
    @BindView
    AppCompatEditText mEtConvolverKnlSearch;
    @BindView
    ScrollView mLayoutConvolverKnlMain;
    @BindView
    LinearLayout mLayoutConvolverKnlSearch;
    @BindView
    ProgressBarView mPbvConvolverCrosschannel;
    @BindView
    TouchRotateButton mTrbConvolverCrosschannel;
    @BindView
    TextView mTvConvolverCrosschannelVal;

    public class VDdcAdapter extends dh {
        final /* synthetic */ ConvolverFragment a;

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
                return new m(vDdcViewHolder, aVar, obj);
            }
        }

        public VDdcAdapter(ConvolverFragment convolverFragment) {
            this.a = convolverFragment;
        }

        public int a() {
            return this.a.e.size();
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
            if (i == this.a.c) {
                vDdcViewHolder.ivSelect.setImageResource(2130903086);
            } else {
                vDdcViewHolder.ivSelect.setImageResource(2130903085);
            }
            vDdcViewHolder.tvName.setText((CharSequence) this.a.e.get(i));
            vDdcViewHolder.a.setOnClickListener(new k(this, i));
        }

        public /* synthetic */ eg b(ViewGroup viewGroup, int i) {
            return a(viewGroup, i);
        }
    }

    private void a() {
        this.mConvolverKnlRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.mConvolverKnlRecyclerview.setAdapter(this.d);
        this.mEtConvolverKnlSearch.addTextChangedListener(new g(this));
        this.mBtnConvolverKnl.setOnClickListener(new h(this));
        this.mTrbConvolverCrosschannel.setBgImageInt(2130903068);
        this.mTrbConvolverCrosschannel.setBgPressImageInt(2130903069);
        this.mPbvConvolverCrosschannel.setMax(300);
        this.mTrbConvolverCrosschannel.setOnChangeDegreeListening(new i(this));
    }

    private void a(String str) {
        new j(this, str).start();
    }

    private void b() {
        if (!this.a.getString("viper4android.headphonefx.convolver.kernel", "").equals("")) {
            this.mBtnConvolverKnl.setText(this.a.getString("viper4android.headphonefx.convolver.kernel", ""));
        }
        String string = this.a.getString("viper4android.headphonefx.convolver.crosschannel", "0");
        this.mTvConvolverCrosschannelVal.setText(string + "%");
        this.mPbvConvolverCrosschannel.setProgressSync((float) (Integer.valueOf(string).intValue() * 3));
        this.mTrbConvolverCrosschannel.setCurDegree((float) ((Integer.valueOf(string).intValue() * 3) + 30));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.e = new ArrayList();
        this.d = new VDdcAdapter(this);
        this.g = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        this.g.setDuration(500);
        this.h = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
        this.h.setDuration(500);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(2130968624, viewGroup, false);
        ButterKnife.a(this, inflate);
        a();
        b();
        return inflate;
    }
}
