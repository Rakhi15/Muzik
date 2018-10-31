package com.stericson.roottools;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy.Builder;
import android.os.StrictMode.VmPolicy;
import android.widget.ScrollView;
import android.widget.TextView;
import com.stericson.rootshell.a.a;
import com.stericson.rootshell.b.e;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class SanityCheckRootTools extends Activity {
    private ScrollView a;
    private TextView b;
    private ProgressDialog c;

    protected void a(CharSequence charSequence) {
        this.b.append(charSequence);
        this.a.post(new b(this));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        StrictMode.setThreadPolicy(new Builder().detectDiskReads().detectDiskWrites().detectNetwork().penaltyLog().build());
        StrictMode.setVmPolicy(new VmPolicy.Builder().detectLeakedSqlLiteObjects().detectLeakedClosableObjects().penaltyLog().penaltyDeath().build());
        a.a = true;
        this.b = new TextView(this);
        this.b.setText("");
        this.a = new ScrollView(this);
        this.a.addView(this.b);
        setContentView(this.a);
        a((CharSequence) "SanityCheckRootTools \n\n");
        if (a.f()) {
            a((CharSequence) "Root found.\n");
        } else {
            a((CharSequence) "Root not found");
        }
        try {
            e.h();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e2) {
            a((CharSequence) "[ TIMEOUT EXCEPTION! ]\n");
            e2.printStackTrace();
        } catch (a e3) {
            a((CharSequence) "[ ROOT DENIED EXCEPTION! ]\n");
            e3.printStackTrace();
        }
        try {
            if (a.d()) {
                this.c = new ProgressDialog(this);
                this.c.setCancelable(false);
                this.c.setProgressStyle(0);
                new c(this, this, new j()).start();
                return;
            }
            a((CharSequence) "ERROR: No root access to this device.\n");
        } catch (Exception e4) {
            a((CharSequence) "ERROR: could not determine root access to this device.\n");
        }
    }
}
