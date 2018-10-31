package com.audlabs.viperfx.screen;

import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.audlabs.viperfx.b.c;
import com.audlabs.viperfx.b.d;
import com.audlabs.viperfx.b.e;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

class h implements OnClickListener {
    final /* synthetic */ ConvolverFragment a;

    h(ConvolverFragment convolverFragment) {
        this.a = convolverFragment;
    }

    public void onClick(View view) {
        if (Environment.getExternalStorageState().equals("mounted")) {
            File file = new File(d.d());
            if (file.exists()) {
                c.a("Kernel directory exists");
            } else {
                c.a("Kernel directory does not exists");
                file.mkdirs();
                file.mkdir();
            }
            this.a.f = new ArrayList();
            e.a(file, ".irs", this.a.f);
            e.a(file, ".wav", this.a.f);
            if (this.a.f.isEmpty()) {
                Toast.makeText(this.a.getActivity(), String.format(this.a.getActivity().getResources().getString(2131099807), new Object[]{d.d()}), 0).show();
                return;
            }
            Collections.sort(this.a.f);
            this.a.mLayoutConvolverKnlMain.setVisibility(4);
            this.a.mLayoutConvolverKnlSearch.startAnimation(this.a.g);
            this.a.mLayoutConvolverKnlSearch.setVisibility(0);
            this.a.b = this.a.a.getString("viper4android.headphonefx.convolver.kernel", "");
            this.a.a("");
            return;
        }
        c.a("External storage not mounted");
        Toast.makeText(this.a.getActivity(), String.format(this.a.getActivity().getResources().getString(2131099807), new Object[]{d.d()}), 0).show();
    }
}
