package me.imid.swipebacklayout.lib;

import android.content.Context;
import android.support.v4.view.ba;
import android.support.v4.view.ca;
import android.support.v4.widget.bn;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import java.util.Arrays;

public class k {
    private static final Interpolator v = new l();
    private int a;
    private int b;
    private int c = -1;
    private float[] d;
    private float[] e;
    private float[] f;
    private float[] g;
    private int[] h;
    private int[] i;
    private int[] j;
    private int k;
    private VelocityTracker l;
    private float m;
    private float n;
    private int o;
    private int p;
    private bn q;
    private final n r;
    private View s;
    private boolean t;
    private final ViewGroup u;
    private final Runnable w = new m(this);

    private k(Context context, ViewGroup viewGroup, n nVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (nVar == null) {
            throw new IllegalArgumentException("Callback may not be null");
        } else {
            this.u = viewGroup;
            this.r = nVar;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.b = viewConfiguration.getScaledTouchSlop();
            this.m = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.n = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.q = bn.a(context, v);
        }
    }

    private float a(float f, float f2, float f3) {
        float abs = Math.abs(f);
        return abs < f2 ? 0.0f : abs > f3 ? f <= 0.0f ? -f3 : f3 : f;
    }

    private int a(int i, int i2, int i3) {
        if (i == 0) {
            return 0;
        }
        int width = this.u.getWidth();
        int i4 = width / 2;
        float c = (c(Math.min(1.0f, ((float) Math.abs(i)) / ((float) width))) * ((float) i4)) + ((float) i4);
        i4 = Math.abs(i2);
        return Math.min(i4 > 0 ? Math.round(Math.abs(c / ((float) i4)) * 1000.0f) * 4 : (int) (((((float) Math.abs(i)) / ((float) i3)) + 1.0f) * 256.0f), 600);
    }

    private int a(View view, int i, int i2, int i3, int i4) {
        int b = b(i3, (int) this.n, (int) this.m);
        int b2 = b(i4, (int) this.n, (int) this.m);
        int abs = Math.abs(i);
        int abs2 = Math.abs(i2);
        int abs3 = Math.abs(b);
        int abs4 = Math.abs(b2);
        int i5 = abs3 + abs4;
        int i6 = abs + abs2;
        return (int) (((b2 != 0 ? ((float) abs4) / ((float) i5) : ((float) abs2) / ((float) i6)) * ((float) a(i2, b2, this.r.b(view)))) + ((b != 0 ? ((float) abs3) / ((float) i5) : ((float) abs) / ((float) i6)) * ((float) a(i, b, this.r.a(view)))));
    }

    public static k a(ViewGroup viewGroup, n nVar) {
        return new k(viewGroup.getContext(), viewGroup, nVar);
    }

    private void a(float f, float f2) {
        this.t = true;
        this.r.a(this.s, f, f2);
        this.t = false;
        if (this.a == 1) {
            d(0);
        }
    }

    private void a(float f, float f2, int i) {
        f(i);
        float[] fArr = this.d;
        this.f[i] = f;
        fArr[i] = f;
        fArr = this.e;
        this.g[i] = f2;
        fArr[i] = f2;
        this.h[i] = f((int) f, (int) f2);
        this.k |= 1 << i;
    }

    private boolean a(float f, float f2, int i, int i2) {
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        if ((this.h[i] & i2) != i2 || (this.p & i2) == 0 || (this.j[i] & i2) == i2 || (this.i[i] & i2) == i2) {
            return false;
        }
        if (abs <= ((float) this.b) && abs2 <= ((float) this.b)) {
            return false;
        }
        if (abs >= abs2 * 0.5f || !this.r.b(i2)) {
            return (this.i[i] & i2) == 0 && abs > ((float) this.b);
        } else {
            int[] iArr = this.j;
            iArr[i] = iArr[i] | i2;
            return false;
        }
    }

    private boolean a(int i, int i2, int i3, int i4) {
        int left = this.s.getLeft();
        int top = this.s.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.q.h();
            d(0);
            return false;
        }
        this.q.a(left, top, i5, i6, a(this.s, i5, i6, i3, i4));
        d(2);
        return true;
    }

    private boolean a(View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        boolean z = this.r.a(view) > 0;
        boolean z2 = this.r.b(view) > 0;
        return (z && z2) ? (f * f) + (f2 * f2) > ((float) (this.b * this.b)) : z ? Math.abs(f) > ((float) this.b) : z2 ? Math.abs(f2) > ((float) this.b) : false;
    }

    private int b(int i, int i2, int i3) {
        int abs = Math.abs(i);
        return abs < i2 ? 0 : abs > i3 ? i <= 0 ? -i3 : i3 : i;
    }

    private void b(float f, float f2, int i) {
        int i2 = 1;
        if (!a(f, f2, i, 1)) {
            i2 = 0;
        }
        if (a(f2, f, i, 4)) {
            i2 |= 4;
        }
        if (a(f, f2, i, 2)) {
            i2 |= 2;
        }
        if (a(f2, f, i, 8)) {
            i2 |= 8;
        }
        if (i2 != 0) {
            int[] iArr = this.i;
            iArr[i] = iArr[i] | i2;
            this.r.b(i2, i);
        }
    }

    private void b(int i, int i2, int i3, int i4) {
        int a;
        int b;
        int left = this.s.getLeft();
        int top = this.s.getTop();
        if (i3 != 0) {
            a = this.r.a(this.s, i, i3);
            this.s.offsetLeftAndRight(a - left);
        } else {
            a = i;
        }
        if (i4 != 0) {
            b = this.r.b(this.s, i2, i4);
            this.s.offsetTopAndBottom(b - top);
        } else {
            b = i2;
        }
        if (i3 != 0 || i4 != 0) {
            this.r.a(this.s, a, b, a - left, b - top);
        }
    }

    private float c(float f) {
        return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
    }

    private void c() {
        if (this.d != null) {
            Arrays.fill(this.d, 0.0f);
            Arrays.fill(this.e, 0.0f);
            Arrays.fill(this.f, 0.0f);
            Arrays.fill(this.g, 0.0f);
            Arrays.fill(this.h, 0);
            Arrays.fill(this.i, 0);
            Arrays.fill(this.j, 0);
            this.k = 0;
        }
    }

    private void c(MotionEvent motionEvent) {
        int c = ba.c(motionEvent);
        for (int i = 0; i < c; i++) {
            int b = ba.b(motionEvent, i);
            float c2 = ba.c(motionEvent, i);
            float d = ba.d(motionEvent, i);
            this.f[b] = c2;
            this.g[b] = d;
        }
    }

    private void d() {
        this.l.computeCurrentVelocity(1000, this.m);
        a(a(ca.a(this.l, this.c), this.n, this.m), a(ca.b(this.l, this.c), this.n, this.m));
    }

    private void e(int i) {
        if (this.d != null) {
            this.d[i] = 0.0f;
            this.e[i] = 0.0f;
            this.f[i] = 0.0f;
            this.g[i] = 0.0f;
            this.h[i] = 0;
            this.i[i] = 0;
            this.j[i] = 0;
            this.k &= (1 << i) ^ -1;
        }
    }

    private int f(int i, int i2) {
        int i3 = 0;
        if (i < this.u.getLeft() + this.o) {
            i3 = 1;
        }
        if (i2 < this.u.getTop() + this.o) {
            i3 = 4;
        }
        if (i > this.u.getRight() - this.o) {
            i3 = 2;
        }
        return i2 > this.u.getBottom() - this.o ? 8 : i3;
    }

    private void f(int i) {
        if (this.d == null || this.d.length <= i) {
            Object obj = new float[(i + 1)];
            Object obj2 = new float[(i + 1)];
            Object obj3 = new float[(i + 1)];
            Object obj4 = new float[(i + 1)];
            Object obj5 = new int[(i + 1)];
            Object obj6 = new int[(i + 1)];
            Object obj7 = new int[(i + 1)];
            if (this.d != null) {
                System.arraycopy(this.d, 0, obj, 0, this.d.length);
                System.arraycopy(this.e, 0, obj2, 0, this.e.length);
                System.arraycopy(this.f, 0, obj3, 0, this.f.length);
                System.arraycopy(this.g, 0, obj4, 0, this.g.length);
                System.arraycopy(this.h, 0, obj5, 0, this.h.length);
                System.arraycopy(this.i, 0, obj6, 0, this.i.length);
                System.arraycopy(this.j, 0, obj7, 0, this.j.length);
            }
            this.d = obj;
            this.e = obj2;
            this.f = obj3;
            this.g = obj4;
            this.h = obj5;
            this.i = obj6;
            this.j = obj7;
        }
    }

    public int a() {
        return this.a;
    }

    public void a(float f) {
        this.n = f;
    }

    public void a(int i) {
        this.p = i;
    }

    public void a(View view, int i) {
        if (view.getParent() != this.u) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.u + ")");
        }
        this.s = view;
        this.c = i;
        this.r.b(view, i);
        d(1);
    }

    public boolean a(int i, int i2) {
        if (this.t) {
            return a(i, i2, (int) ca.a(this.l, this.c), (int) ca.b(this.l, this.c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    public boolean a(MotionEvent motionEvent) {
        int a = ba.a(motionEvent);
        int b = ba.b(motionEvent);
        if (a == 0) {
            b();
        }
        if (this.l == null) {
            this.l = VelocityTracker.obtain();
        }
        this.l.addMovement(motionEvent);
        float y;
        int b2;
        switch (a) {
            case f.View_android_theme /*0*/:
                float x = motionEvent.getX();
                y = motionEvent.getY();
                b2 = ba.b(motionEvent, 0);
                a(x, y, b2);
                View e = e((int) x, (int) y);
                if (e == this.s && this.a == 2) {
                    b(e, b2);
                }
                a = this.h[b2];
                if ((this.p & a) != 0) {
                    this.r.a(a & this.p, b2);
                    break;
                }
                break;
            case f.View_android_focusable /*1*/:
            case f.View_paddingEnd /*3*/:
                b();
                break;
            case f.View_paddingStart /*2*/:
                b = ba.c(motionEvent);
                a = 0;
                while (a < b) {
                    b2 = ba.b(motionEvent, a);
                    float c = ba.c(motionEvent, a);
                    float d = ba.d(motionEvent, a);
                    float f = c - this.d[b2];
                    float f2 = d - this.e[b2];
                    b(f, f2, b2);
                    if (this.a != 1) {
                        View e2 = e((int) c, (int) d);
                        if (e2 == null || !a(e2, f, f2) || !b(e2, b2)) {
                            a++;
                        }
                    }
                    c(motionEvent);
                    break;
                }
                c(motionEvent);
                break;
            case f.Toolbar_contentInsetStart /*5*/:
                a = ba.b(motionEvent, b);
                float c2 = ba.c(motionEvent, b);
                y = ba.d(motionEvent, b);
                a(c2, y, a);
                if (this.a != 0) {
                    if (this.a == 2) {
                        View e3 = e((int) c2, (int) y);
                        if (e3 == this.s) {
                            b(e3, a);
                            break;
                        }
                    }
                }
                b = this.h[a];
                if ((this.p & b) != 0) {
                    this.r.a(b & this.p, a);
                    break;
                }
                break;
            case f.Toolbar_contentInsetEnd /*6*/:
                e(ba.b(motionEvent, b));
                break;
        }
        return this.a == 1;
    }

    public boolean a(View view, int i, int i2) {
        return view != null && i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom();
    }

    public boolean a(boolean z) {
        if (this.a == 2) {
            boolean a;
            boolean g = this.q.g();
            int b = this.q.b();
            int c = this.q.c();
            int left = b - this.s.getLeft();
            int top = c - this.s.getTop();
            if (left != 0) {
                this.s.offsetLeftAndRight(left);
            }
            if (top != 0) {
                this.s.offsetTopAndBottom(top);
            }
            if (!(left == 0 && top == 0)) {
                this.r.a(this.s, b, c, left, top);
            }
            if (g && b == this.q.d() && c == this.q.e()) {
                this.q.h();
                a = this.q.a();
            } else {
                a = g;
            }
            if (!a) {
                if (z) {
                    this.u.post(this.w);
                } else {
                    d(0);
                }
            }
        }
        return this.a == 2;
    }

    public void b() {
        this.c = -1;
        c();
        if (this.l != null) {
            this.l.recycle();
            this.l = null;
        }
    }

    public void b(float f) {
        this.m = f;
    }

    public void b(int i) {
        this.o = i;
    }

    public void b(MotionEvent motionEvent) {
        int i = 0;
        int a = ba.a(motionEvent);
        int b = ba.b(motionEvent);
        if (a == 0) {
            b();
        }
        if (this.l == null) {
            this.l = VelocityTracker.obtain();
        }
        this.l.addMovement(motionEvent);
        float x;
        float y;
        View e;
        int i2;
        switch (a) {
            case f.View_android_theme /*0*/:
                x = motionEvent.getX();
                y = motionEvent.getY();
                i = ba.b(motionEvent, 0);
                e = e((int) x, (int) y);
                a(x, y, i);
                b(e, i);
                i2 = this.h[i];
                if ((this.p & i2) != 0) {
                    this.r.a(i2 & this.p, i);
                    return;
                }
                return;
            case f.View_android_focusable /*1*/:
                if (this.a == 1) {
                    d();
                }
                b();
                return;
            case f.View_paddingStart /*2*/:
                if (this.a == 1) {
                    i = ba.a(motionEvent, this.c);
                    x = ba.c(motionEvent, i);
                    i2 = (int) (x - this.f[this.c]);
                    i = (int) (ba.d(motionEvent, i) - this.g[this.c]);
                    b(this.s.getLeft() + i2, this.s.getTop() + i, i2, i);
                    c(motionEvent);
                    return;
                }
                i2 = ba.c(motionEvent);
                while (i < i2) {
                    a = ba.b(motionEvent, i);
                    float c = ba.c(motionEvent, i);
                    float d = ba.d(motionEvent, i);
                    float f = c - this.d[a];
                    float f2 = d - this.e[a];
                    b(f, f2, a);
                    if (this.a != 1) {
                        e = e((int) c, (int) d);
                        if (!a(e, f, f2) || !b(e, a)) {
                            i++;
                        }
                    }
                    c(motionEvent);
                    return;
                }
                c(motionEvent);
                return;
            case f.View_paddingEnd /*3*/:
                if (this.a == 1) {
                    a(0.0f, 0.0f);
                }
                b();
                return;
            case f.Toolbar_contentInsetStart /*5*/:
                i = ba.b(motionEvent, b);
                x = ba.c(motionEvent, b);
                y = ba.d(motionEvent, b);
                a(x, y, i);
                if (this.a == 0) {
                    b(e((int) x, (int) y), i);
                    i2 = this.h[i];
                    if ((this.p & i2) != 0) {
                        this.r.a(i2 & this.p, i);
                        return;
                    }
                    return;
                } else if (d((int) x, (int) y)) {
                    b(this.s, i);
                    return;
                } else {
                    return;
                }
            case f.Toolbar_contentInsetEnd /*6*/:
                a = ba.b(motionEvent, b);
                if (this.a == 1 && a == this.c) {
                    b = ba.c(motionEvent);
                    while (i < b) {
                        int b2 = ba.b(motionEvent, i);
                        if (b2 != this.c) {
                            if (e((int) ba.c(motionEvent, i), (int) ba.d(motionEvent, i)) == this.s && b(this.s, b2)) {
                                i = this.c;
                                if (i == -1) {
                                    d();
                                }
                            }
                        }
                        i++;
                    }
                    i = -1;
                    if (i == -1) {
                        d();
                    }
                }
                e(a);
                return;
            default:
                return;
        }
    }

    public boolean b(int i, int i2) {
        if (!c(i2)) {
            return false;
        }
        boolean z = (i & 1) == 1;
        boolean z2 = (i & 2) == 2;
        float f = this.f[i2] - this.d[i2];
        float f2 = this.g[i2] - this.e[i2];
        return (z && z2) ? (f * f) + (f2 * f2) > ((float) (this.b * this.b)) : z ? Math.abs(f) > ((float) this.b) : z2 ? Math.abs(f2) > ((float) this.b) : false;
    }

    boolean b(View view, int i) {
        if (view == this.s && this.c == i) {
            return true;
        }
        if (view == null || !this.r.a(view, i)) {
            return false;
        }
        this.c = i;
        a(view, i);
        return true;
    }

    public boolean c(int i) {
        return (this.k & (1 << i)) != 0;
    }

    public boolean c(int i, int i2) {
        return c(i2) && (this.h[i2] & i) != 0;
    }

    void d(int i) {
        if (this.a != i) {
            this.a = i;
            this.r.a(i);
            if (i == 0) {
                this.s = null;
            }
        }
    }

    public boolean d(int i, int i2) {
        return a(this.s, i, i2);
    }

    public View e(int i, int i2) {
        for (int childCount = this.u.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.u.getChildAt(this.r.c(childCount));
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }
}
