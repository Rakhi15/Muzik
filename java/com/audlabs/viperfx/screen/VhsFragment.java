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

public class VhsFragment extends b {
    private Matrix b;
    private float c;
    private float d;
    @BindView
    ImageView mIVKnobPoint;
    @BindView
    TouchRotateButton mTrbVhs;
    @BindView
    TextView mTvVshVal;
    @BindArray
    String[] vhsQual;

    private void a() {
        this.mTrbVhs.setBgImageInt(2130903065);
        this.mTrbVhs.setBgPressImageInt(2130903067);
        this.mTrbVhs.setMIN_DEGREE(90.0f);
        this.mTrbVhs.setMAX_DEGREE(270.0f);
        this.b = new Matrix();
        Bitmap bitmap = ((BitmapDrawable) a.a(getActivity(), 2130903066)).getBitmap();
        this.c = (float) (bitmap.getWidth() / 2);
        this.d = (float) (bitmap.getHeight() / 2);
        this.mTrbVhs.setOnChangeDegreeListening(new bn(this));
    }

    private void b() {
        int intValue = Integer.valueOf(this.a.getString("viper4android.headphonefx.vhs.qual", "0")).intValue() + 2;
        this.mTvVshVal.setText(this.vhsQual[intValue - 2]);
        this.b.setRotate((float) (intValue * 45), this.c, this.d);
        this.mIVKnobPoint.setImageMatrix(this.b);
        this.mTrbVhs.setCurDegree((float) (intValue * 45));
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(2130968635, viewGroup, false);
        ButterKnife.a(this, inflate);
        a();
        b();
        return inflate;
    }
}
