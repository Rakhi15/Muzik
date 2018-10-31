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

public class AnalogxFragment extends b {
    @BindArray
    String[] analogxMode;
    private Matrix b;
    private float c;
    private float d;
    @BindView
    ImageView mIVKnobPoint;
    @BindView
    TouchRotateButton mTrbAnalogx;
    @BindView
    TextView mTvModeExtreme;
    @BindView
    TextView mTvModeModerate;
    @BindView
    TextView mTvModeSlight;

    private void a() {
        this.mTvModeSlight.setText(this.analogxMode[0]);
        this.mTvModeModerate.setText(this.analogxMode[1]);
        this.mTvModeExtreme.setText(this.analogxMode[2]);
        this.mTrbAnalogx.setBgImageInt(2130903065);
        this.mTrbAnalogx.setBgPressImageInt(2130903067);
        this.mTrbAnalogx.setMIN_DEGREE(135.0f);
        this.mTrbAnalogx.setMAX_DEGREE(225.0f);
        this.b = new Matrix();
        Bitmap bitmap = ((BitmapDrawable) a.a(getActivity(), 2130903066)).getBitmap();
        this.c = (float) (bitmap.getWidth() / 2);
        this.d = (float) (bitmap.getHeight() / 2);
        this.mTrbAnalogx.setOnChangeDegreeListening(new a(this));
    }

    private void b() {
        int intValue = Integer.valueOf(this.a.getString("viper4android.headphonefx.analogx.mode", "0")).intValue() + 3;
        this.b.setRotate((float) (intValue * 45), this.c, this.d);
        this.mIVKnobPoint.setImageMatrix(this.b);
        this.mTrbAnalogx.setCurDegree((float) (intValue * 45));
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(2130968620, viewGroup, false);
        ButterKnife.a(this, inflate);
        a();
        b();
        return inflate;
    }
}
