package com.audlabs.viperfx.screen;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.content.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import butterknife.BindArray;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.audlabs.viperfx.base.b;
import com.audlabs.viperfx.widget.TouchRotateButton;
import java.util.Arrays;

public class VClarityFragment extends b {
    private View b;
    private Matrix c;
    private float d;
    private float e;
    @BindView
    ImageView mIVKnobPoint;
    @BindView
    RadioButton mRbModeNatural;
    @BindView
    RadioButton mRbModeOzone;
    @BindView
    RadioButton mRbModeXhifi;
    @BindView
    RadioGroup mRgVclartyMode;
    @BindView
    TouchRotateButton mTrbClarty;
    @BindView
    TextView mTvClartyVal;
    @BindArray
    String[] vclartyBoostVals;
    @BindArray
    String[] vclartyBoosts;
    @BindArray
    String[] vclartyMode;

    private void a() {
        this.mRbModeNatural.setText(this.vclartyMode[0]);
        this.mRbModeOzone.setText(this.vclartyMode[1]);
        this.mRbModeXhifi.setText(this.vclartyMode[2]);
        this.mRgVclartyMode.setOnCheckedChangeListener(new bf(this));
        this.c = new Matrix();
        Bitmap bitmap = ((BitmapDrawable) a.a(getActivity(), 2130903066)).getBitmap();
        this.d = (float) (bitmap.getWidth() / 2);
        this.e = (float) (bitmap.getHeight() / 2);
        this.mTrbClarty.setBgImageInt(2130903065);
        this.mTrbClarty.setBgPressImageInt(2130903067);
        this.mTrbClarty.setMIN_DEGREE(45.0f);
        this.mTrbClarty.setMAX_DEGREE(315.0f);
        this.mTrbClarty.setOnChangeDegreeListening(new bg(this));
    }

    private void b() {
        String string = this.a.getString("viper4android.headphonefx.fidelity.clarity.mode", "0");
        if ("0".equals(string)) {
            this.mRbModeNatural.setChecked(true);
        } else if ("1".equals(string)) {
            this.mRbModeOzone.setChecked(true);
        } else if ("2".equals(string)) {
            this.mRbModeXhifi.setChecked(true);
        }
        int indexOf = Arrays.asList(this.vclartyBoostVals).indexOf(this.a.getString("viper4android.headphonefx.fidelity.clarity.gain", "50"));
        this.mTvClartyVal.setText(this.vclartyBoosts[indexOf]);
        this.mTrbClarty.setCurDegree((float) ((indexOf * 30) + 45));
        this.c.setRotate((float) ((indexOf * 30) + 45), this.d, this.e);
        this.mIVKnobPoint.setImageMatrix(this.c);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.b == null) {
            this.b = layoutInflater.inflate(2130968634, viewGroup, false);
            ButterKnife.a(this, this.b);
        }
        a();
        b();
        return this.b;
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onDestroyView() {
        super.onDestroyView();
        ((ViewGroup) this.b.getParent()).removeView(this.b);
    }
}
