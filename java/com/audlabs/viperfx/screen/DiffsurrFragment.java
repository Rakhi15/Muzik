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

public class DiffsurrFragment extends b {
    private Matrix b;
    private float c;
    private float d;
    @BindArray
    String[] diffsurroundDelayVals;
    @BindArray
    String[] diffsurroundDelays;
    @BindView
    ImageView mIVKnobPoint;
    @BindView
    TouchRotateButton mTrbDiffsurr;
    @BindView
    TextView mTvDiffsurrVal;

    private void a() {
        this.mTrbDiffsurr.setBgImageInt(2130903065);
        this.mTrbDiffsurr.setBgPressImageInt(2130903067);
        this.mTrbDiffsurr.setMIN_DEGREE(60.0f);
        this.mTrbDiffsurr.setMAX_DEGREE(300.0f);
        this.b = new Matrix();
        Bitmap bitmap = ((BitmapDrawable) a.a(getActivity(), 2130903066)).getBitmap();
        this.c = (float) (bitmap.getWidth() / 2);
        this.d = (float) (bitmap.getHeight() / 2);
        this.mTrbDiffsurr.setOnChangeDegreeListening(new t(this));
    }

    private void b() {
        int indexOf = Arrays.asList(this.diffsurroundDelayVals).indexOf(this.a.getString("viper4android.headphonefx.diffsurr.delay", "500")) + 2;
        this.mTvDiffsurrVal.setText(this.diffsurroundDelays[indexOf - 2]);
        this.b.setRotate((float) (indexOf * 30), this.c, this.d);
        this.mIVKnobPoint.setImageMatrix(this.b);
        this.mTrbDiffsurr.setCurDegree((float) (indexOf * 30));
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(2130968626, viewGroup, false);
        ButterKnife.a(this, inflate);
        a();
        b();
        return inflate;
    }
}
