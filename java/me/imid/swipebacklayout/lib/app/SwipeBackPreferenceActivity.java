package me.imid.swipebacklayout.lib.app;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.view.View;

public class SwipeBackPreferenceActivity extends PreferenceActivity {
    private a a;

    public View findViewById(int i) {
        View findViewById = super.findViewById(i);
        return (findViewById != null || this.a == null) ? findViewById : this.a.a(i);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = new a(this);
        this.a.a();
    }

    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        this.a.b();
    }
}
