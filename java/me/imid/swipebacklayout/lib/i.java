package me.imid.swipebacklayout.lib;

import android.view.View;

class i extends n {
    final /* synthetic */ SwipeBackLayout a;
    private boolean b;

    private i(SwipeBackLayout swipeBackLayout) {
        this.a = swipeBackLayout;
    }

    public int a(View view) {
        return this.a.b & 3;
    }

    public int a(View view, int i, int i2) {
        return (this.a.s & 1) != 0 ? Math.min(view.getWidth(), Math.max(i, 0)) : (this.a.s & 2) != 0 ? Math.min(0, Math.max(i, -view.getWidth())) : 0;
    }

    public void a(int i) {
        super.a(i);
        if (this.a.k != null && !this.a.k.isEmpty()) {
            for (h a : this.a.k) {
                a.a(i, this.a.h);
            }
        }
    }

    public void a(View view, float f, float f2) {
        int i = 0;
        int width = view.getWidth();
        int height = view.getHeight();
        if ((this.a.s & 1) != 0) {
            width = (f > 0.0f || (f == 0.0f && this.a.h > this.a.c)) ? (width + this.a.l.getIntrinsicWidth()) + 10 : 0;
        } else if ((this.a.s & 2) != 0) {
            width = (f < 0.0f || (f == 0.0f && this.a.h > this.a.c)) ? -((width + this.a.l.getIntrinsicWidth()) + 10) : 0;
        } else if ((this.a.s & 8) != 0) {
            width = (f2 < 0.0f || (f2 == 0.0f && this.a.h > this.a.c)) ? -((this.a.n.getIntrinsicHeight() + height) + 10) : 0;
            int i2 = width;
            width = 0;
            i = i2;
        } else {
            width = 0;
        }
        this.a.g.a(width, i);
        this.a.invalidate();
    }

    public void a(View view, int i, int i2, int i3, int i4) {
        super.a(view, i, i2, i3, i4);
        if ((this.a.s & 1) != 0) {
            this.a.h = Math.abs(((float) i) / ((float) (this.a.f.getWidth() + this.a.l.getIntrinsicWidth())));
        } else if ((this.a.s & 2) != 0) {
            this.a.h = Math.abs(((float) i) / ((float) (this.a.f.getWidth() + this.a.m.getIntrinsicWidth())));
        } else if ((this.a.s & 8) != 0) {
            this.a.h = Math.abs(((float) i2) / ((float) (this.a.f.getHeight() + this.a.n.getIntrinsicHeight())));
        }
        this.a.i = i;
        this.a.j = i2;
        this.a.invalidate();
        if (this.a.h < this.a.c && !this.b) {
            this.b = true;
        }
        if (this.a.k != null && !this.a.k.isEmpty() && this.a.g.a() == 1 && this.a.h >= this.a.c && this.b) {
            this.b = false;
            for (h a : this.a.k) {
                a.a();
            }
        }
        if (this.a.h >= 1.0f && !this.a.d.isFinishing()) {
            this.a.d.finish();
            this.a.d.overridePendingTransition(0, 0);
        }
    }

    public boolean a(View view, int i) {
        int i2 = 1;
        boolean c = this.a.g.c(this.a.b, i);
        if (c) {
            if (this.a.g.c(1, i)) {
                this.a.s = 1;
            } else if (this.a.g.c(2, i)) {
                this.a.s = 2;
            } else if (this.a.g.c(8, i)) {
                this.a.s = 8;
            }
            if (!(this.a.k == null || this.a.k.isEmpty())) {
                for (h a : this.a.k) {
                    a.a(this.a.s);
                }
            }
            this.b = true;
        }
        if (this.a.b == 1 || this.a.b == 2) {
            i2 = !this.a.g.b(2, i) ? 1 : 0;
        } else if (this.a.b == 8) {
            if (this.a.g.b(1, i)) {
                i2 = 0;
            }
        } else if (this.a.b != 11) {
            i2 = 0;
        }
        return c & i2;
    }

    public int b(View view) {
        return this.a.b & 8;
    }

    public int b(View view, int i, int i2) {
        return (this.a.s & 8) != 0 ? Math.min(0, Math.max(i, -view.getHeight())) : 0;
    }
}
