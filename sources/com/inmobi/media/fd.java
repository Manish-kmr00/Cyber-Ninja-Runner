package com.inmobi.media;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import io.bidmachine.iab.utils.VisibilityTracker;
import java.util.ArrayList;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public abstract class fd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakHashMap f3319a;
    public final Zc b;
    public final Handler c;
    public final byte d;
    public final L4 e;
    public final int f;
    public final ArrayList g;
    public long h;
    public final AtomicBoolean i;
    public bd j;
    public final Lazy k;
    public final Lazy l;
    public boolean m;

    public fd(Zc visibilityChecker, byte b, L4 l4) {
        Intrinsics.checkNotNullParameter(visibilityChecker, "visibilityChecker");
        WeakHashMap weakHashMap = new WeakHashMap(10);
        Handler handler = new Handler(Looper.getMainLooper());
        this.f3319a = weakHashMap;
        this.b = visibilityChecker;
        this.c = handler;
        this.d = b;
        this.e = l4;
        this.f = 50;
        this.g = new ArrayList(50);
        this.i = new AtomicBoolean(true);
        this.k = LazyKt.lazy(new dd(this));
        this.l = LazyKt.lazy(new ed(this));
    }

    public final void a(View view, Object obj, int i) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(view, "rootView");
        Intrinsics.checkNotNullParameter(view, "view");
        L4 l4 = this.e;
        if (l4 != null) {
            ((M4) l4).c(VisibilityTracker.TAG, "add view to tracker - minPercent - " + i + "  " + this);
        }
        cd cdVar = (cd) this.f3319a.get(view);
        if (cdVar == null) {
            cdVar = new cd();
            this.f3319a.put(view, cdVar);
            this.h++;
        }
        cdVar.f3287a = i;
        long j = this.h;
        cdVar.b = j;
        cdVar.c = view;
        cdVar.d = obj;
        long j2 = this.f;
        if (j % j2 == 0) {
            long j3 = j - j2;
            for (Map.Entry entry : this.f3319a.entrySet()) {
                View view2 = (View) entry.getKey();
                if (((cd) entry.getValue()).b < j3) {
                    this.g.add(view2);
                }
            }
            for (View view3 : this.g) {
                Intrinsics.checkNotNull(view3);
                a(view3);
            }
            this.g.clear();
        }
        if (this.f3319a.size() == 1) {
            f();
        }
    }

    public void b() {
        L4 l4 = this.e;
        if (l4 != null) {
            ((M4) l4).c(VisibilityTracker.TAG, "destroy " + this);
        }
        a();
        this.j = null;
        this.i.set(true);
    }

    public abstract int c();

    public abstract void d();

    public void e() {
        L4 l4 = this.e;
        if (l4 != null) {
            ((M4) l4).c(VisibilityTracker.TAG, "pause " + this);
        }
        ((RunnableC3304ad) this.k.getValue()).run();
        this.c.removeCallbacksAndMessages(null);
        this.m = false;
        this.i.set(true);
    }

    public void f() {
        L4 l4 = this.e;
        if (l4 != null) {
            ((M4) l4).c(VisibilityTracker.TAG, "resume " + this);
        }
        this.i.set(false);
        g();
    }

    public final void g() {
        toString();
        if (this.m || this.i.get()) {
            return;
        }
        this.m = true;
        ((ScheduledThreadPoolExecutor) S3.c.getValue()).schedule((Runnable) this.l.getValue(), c(), TimeUnit.MILLISECONDS);
    }

    public final void a(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        L4 l4 = this.e;
        if (l4 != null) {
            ((M4) l4).c(VisibilityTracker.TAG, "removed view from tracker " + this);
        }
        if (((cd) this.f3319a.remove(view)) != null) {
            this.h--;
            if (this.f3319a.isEmpty()) {
                e();
            }
        }
    }

    public final void a() {
        L4 l4 = this.e;
        if (l4 != null) {
            ((M4) l4).c(VisibilityTracker.TAG, "clear " + this);
        }
        this.f3319a.clear();
        this.c.removeMessages(0);
        this.m = false;
    }
}
