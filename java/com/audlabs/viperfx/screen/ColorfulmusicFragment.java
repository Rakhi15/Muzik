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
import android.widget.TextView;
import butterknife.BindArray;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.audlabs.viperfx.base.b;
import com.audlabs.viperfx.widget.TouchRotateButton;
import java.util.Arrays;
import java.util.List;

public class ColorfulmusicFragment extends b {
    private List b;
    private List c;
    private Matrix d;
    private float e;
    private float f;
    @BindArray
    String[] mCoeffArrs;
    @BindView
    ImageView mIVKnobPoint;
    @BindView
    ImageView mIVKnobPointMi;
    @BindArray
    String[] mMidimageArrs;
    @BindView
    TouchRotateButton mTrbColorfulmusic;
    @BindView
    TouchRotateButton mTrbColorfulmusicMi;
    @BindView
    TextView mTvColorfulmusicMiVal;
    @BindView
    TextView mTvColorfulmusicVal;

    private void a() {
        this.b = Arrays.asList(getResources().getStringArray(2131427356));
        this.c = Arrays.asList(getResources().getStringArray(2131427357));
        this.mTrbColorfulmusic.setBgImageInt(2130903065);
        this.mTrbColorfulmusic.setBgPressImageInt(2130903067);
        this.mTrbColorfulmusic.setMIN_DEGREE(60.0f);
        this.mTrbColorfulmusic.setMAX_DEGREE(300.0f);
        this.mTrbColorfulmusicMi.setBgImageInt(2130903065);
        this.mTrbColorfulmusicMi.setBgPressImageInt(2130903067);
        this.mTrbColorfulmusicMi.setMIN_DEGREE(67.5f);
        this.mTrbColorfulmusicMi.setMAX_DEGREE(292.5f);
        this.d = new Matrix();
        Bitmap bitmap = ((BitmapDrawable) a.a(getActivity(), 2130903066)).getBitmap();
        this.e = (float) (bitmap.getWidth() / 2);
        this.f = (float) (bitmap.getHeight() / 2);
        this.mTrbColorfulmusic.setOnChangeDegreeListening(new c(this));
        this.mTrbColorfulmusicMi.setOnChangeDegreeListening(new d(this));
    }

    private void b() {
        int indexOf = this.b.indexOf(this.a.getString("viper4android.headphonefx.colorfulmusic.coeffs", "120;200")) + 2;
        this.mTvColorfulmusicVal.setText(this.mCoeffArrs[indexOf - 2]);
        this.d.setRotate((float) (indexOf * 30), this.e, this.f);
        this.mIVKnobPoint.setImageMatrix(this.d);
        this.mTrbColorfulmusic.setCurDegree((float) (indexOf * 30));
        indexOf = this.c.indexOf(this.a.getString("viper4android.headphonefx.colorfulmusic.midimage", "150")) + 3;
        this.mTvColorfulmusicMiVal.setText(this.mMidimageArrs[indexOf - 3]);
        this.d.setRotate((float) (((double) indexOf) * 22.5d), this.e, this.f);
        this.mIVKnobPointMi.setImageMatrix(this.d);
        this.mTrbColorfulmusicMi.setCurDegree((float) (((double) indexOf) * 22.5d));
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(2130968622, viewGroup, false);
        ButterKnife.a(this, inflate);
        a();
        b();
        return inflate;
    }
}
