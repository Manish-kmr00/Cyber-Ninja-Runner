package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.ViewGroup;
import com.monetization.ads.nativeads.ExtendedNativeAdView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class j6 implements vd0, dz1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ViewGroup f9288a;
    private final y1 b;
    private final wr c;
    private final g6 d;
    private final ExtendedNativeAdView e;
    private final x1 f;
    private final tl1 g;
    private final yp h;
    private final sr1 i;
    private final ArrayList j;
    private final List<m6> k;
    private final long l;
    private int m;

    public j6(Context context, m61 nativeAdPrivate, pt adEventListener, ds1 closeVerificationController, ArrayList arrayList, y20 y20Var, ViewGroup subAdsContainer, y1 adBlockCompleteListener, wr contentCloseListener, hr0 layoutDesignsControllerCreator, g6 adPod, ExtendedNativeAdView nativeAdView, x1 adBlockBinder, tl1 progressIncrementer, yp closeTimerProgressIncrementer, sr1 timerViewController) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(nativeAdPrivate, "nativeAdPrivate");
        Intrinsics.checkNotNullParameter(adEventListener, "adEventListener");
        Intrinsics.checkNotNullParameter(closeVerificationController, "closeVerificationController");
        Intrinsics.checkNotNullParameter(subAdsContainer, "subAdsContainer");
        Intrinsics.checkNotNullParameter(adBlockCompleteListener, "adBlockCompleteListener");
        Intrinsics.checkNotNullParameter(contentCloseListener, "contentCloseListener");
        Intrinsics.checkNotNullParameter(layoutDesignsControllerCreator, "layoutDesignsControllerCreator");
        Intrinsics.checkNotNullParameter(adPod, "adPod");
        Intrinsics.checkNotNullParameter(nativeAdView, "nativeAdView");
        Intrinsics.checkNotNullParameter(adBlockBinder, "adBlockBinder");
        Intrinsics.checkNotNullParameter(progressIncrementer, "progressIncrementer");
        Intrinsics.checkNotNullParameter(closeTimerProgressIncrementer, "closeTimerProgressIncrementer");
        Intrinsics.checkNotNullParameter(timerViewController, "timerViewController");
        this.f9288a = subAdsContainer;
        this.b = adBlockCompleteListener;
        this.c = contentCloseListener;
        this.d = adPod;
        this.e = nativeAdView;
        this.f = adBlockBinder;
        this.g = progressIncrementer;
        this.h = closeTimerProgressIncrementer;
        this.i = timerViewController;
        List<m6> listB = adPod.b();
        this.k = listB;
        Iterator<T> it = listB.iterator();
        long jA = 0;
        while (it.hasNext()) {
            jA += ((m6) it.next()).a();
        }
        this.l = jA;
        this.j = layoutDesignsControllerCreator.a(context, this.e, nativeAdPrivate, adEventListener, new a(), closeVerificationController, this.g, new l6(this), arrayList, y20Var, this.d, this.h);
    }

    @Override // com.yandex.mobile.ads.impl.vd0
    public final void c() {
        ViewGroup viewGroup = this.f9288a;
        ExtendedNativeAdView extendedNativeAdView = this.e;
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        viewGroup.removeAllViews();
        viewGroup.addView(extendedNativeAdView, layoutParams);
        if (this.f.a(this.e)) {
            this.m = 1;
            gr0 gr0Var = (gr0) CollectionsKt.firstOrNull((List) this.j);
            if (gr0Var != null && gr0Var.a()) {
                b();
                this.i.a(this.e, this.l, this.g.a());
            } else if (this.m >= this.j.size()) {
                this.c.f();
            } else {
                d();
            }
        }
    }

    @Override // com.yandex.mobile.ads.impl.vd0
    public final void invalidate() {
        Iterator it = this.j.iterator();
        while (it.hasNext()) {
            ((gr0) it.next()).b();
        }
        this.f.a();
    }

    public final void d() {
        m6 m6Var = (m6) CollectionsKt.getOrNull(this.k, this.m - 1);
        this.g.a(m6Var != null ? m6Var.a() : 0L);
        this.h.b();
        if (this.m < this.j.size()) {
            int i = this.m;
            this.m = i + 1;
            if (!((gr0) this.j.get(i)).a()) {
                e();
            } else {
                b();
                this.i.a(this.e, this.l, this.g.a());
            }
        }
    }

    @Override // com.yandex.mobile.ads.impl.dz1
    public final void a() {
        n6 n6VarB;
        int i = this.m - 1;
        if (i == this.d.c()) {
            this.b.b();
        }
        if (this.m < this.j.size()) {
            gr0 gr0Var = (gr0) CollectionsKt.getOrNull(this.j, i);
            if (gr0Var != null) {
                gr0Var.b();
            }
            m6 m6Var = (m6) CollectionsKt.getOrNull(this.k, i);
            if (((m6Var == null || (n6VarB = m6Var.b()) == null) ? null : n6VarB.b()) == nz1.c) {
                int size = this.j.size() - 1;
                this.m = size;
                Iterator<T> it = this.k.subList(i, size).iterator();
                long jA = 0;
                while (it.hasNext()) {
                    jA += ((m6) it.next()).a();
                }
                this.g.a(jA);
                this.h.b();
                int i2 = this.m;
                this.m = i2 + 1;
                if (!((gr0) this.j.get(i2)).a()) {
                    if (this.m >= this.j.size()) {
                        this.c.f();
                        return;
                    } else {
                        d();
                        return;
                    }
                }
                b();
                this.i.a(this.e, this.l, this.g.a());
                return;
            }
            d();
        }
    }

    private final void e() {
        if (this.m >= this.j.size()) {
            this.c.f();
        } else {
            d();
        }
    }

    private final class a implements k3 {
        public a() {
        }

        @Override // com.yandex.mobile.ads.impl.k3
        public final void b() {
            int i = j6.this.m - 1;
            if (i == j6.this.d.c()) {
                j6.this.b.b();
            }
            m6 m6Var = (m6) CollectionsKt.getOrNull(j6.this.k, i);
            if ((m6Var != null ? m6Var.c() : null) != o6.c || m6Var.b() == null) {
                j6.this.d();
            }
        }

        @Override // com.yandex.mobile.ads.impl.k3
        public final void a() {
            j6.this.d();
        }
    }

    private final void b() {
        this.f9288a.setContentDescription("pageIndex: " + this.m);
    }
}
