package me.imid.swipebacklayout.lib.app;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.d;

public class a {
    private Activity a;
    private SwipeBackLayout b;

    public a(Activity activity) {
        this.a = activity;
    }

    public View a(int i) {
        return this.b != null ? this.b.findViewById(i) : null;
    }

    public void a() {
        this.a.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.a.getWindow().getDecorView().setBackgroundDrawable(null);
        this.b = (SwipeBackLayout) LayoutInflater.from(this.a).inflate(d.swipeback_layout, null);
        this.b.a(new b(this));
    }

    public void b() {
        this.b.a(this.a);
    }
}
