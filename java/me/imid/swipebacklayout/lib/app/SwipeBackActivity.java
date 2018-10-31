package me.imid.swipebacklayout.lib.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class SwipeBackActivity extends AppCompatActivity {
    private a l;

    public View findViewById(int i) {
        View findViewById = super.findViewById(i);
        return (findViewById != null || this.l == null) ? findViewById : this.l.a(i);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.l = new a(this);
        this.l.a();
    }

    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        this.l.b();
    }
}
