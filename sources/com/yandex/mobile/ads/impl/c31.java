package com.yandex.mobile.ads.impl;

import android.os.Handler;
import android.os.Looper;
import androidx.viewpager2.widget.ViewPager2;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes6.dex */
public final class c31 {
    static final /* synthetic */ KProperty<Object>[] g = {ta.a(c31.class, "viewPager", "getViewPager()Landroidx/viewpager2/widget/ViewPager2;", 0)};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final n31 f8565a;
    private final g31 b;
    private final gt0 c;
    private final zn1 d;
    private ft0 e;
    private boolean f;

    public c31(ViewPager2 viewPager, n31 multiBannerSwiper, g31 multiBannerEventTracker, gt0 jobSchedulerFactory) {
        Intrinsics.checkNotNullParameter(viewPager, "viewPager");
        Intrinsics.checkNotNullParameter(multiBannerSwiper, "multiBannerSwiper");
        Intrinsics.checkNotNullParameter(multiBannerEventTracker, "multiBannerEventTracker");
        Intrinsics.checkNotNullParameter(jobSchedulerFactory, "jobSchedulerFactory");
        this.f8565a = multiBannerSwiper;
        this.b = multiBannerEventTracker;
        this.c = jobSchedulerFactory;
        this.d = ao1.a(viewPager);
        this.f = true;
    }

    public final void b() {
        ft0 ft0Var = this.e;
        if (ft0Var != null) {
            ft0Var.a();
        }
        this.e = null;
    }

    public final void a() {
        b();
        this.f = false;
    }

    public final void a(long j) {
        Unit unit;
        if (j <= 0 || !this.f) {
            return;
        }
        b();
        ViewPager2 viewPager2 = (ViewPager2) this.d.getValue(this, g[0]);
        if (viewPager2 != null) {
            d31 d31Var = new d31(viewPager2, this.f8565a, this.b);
            this.c.getClass();
            ft0 ft0Var = new ft0(new Handler(Looper.getMainLooper()));
            this.e = ft0Var;
            ft0Var.a(j, d31Var);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            b();
            this.f = false;
        }
    }
}
