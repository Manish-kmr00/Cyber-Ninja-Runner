package com.ogury.ad.internal;

import com.ogury.ad.OguryAdError;
import com.ogury.ad.internal.t5;
import com.ogury.ad.internal.v5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class z5<T extends t5, L extends v5<T>> implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f7462a;
    public final L b;

    public z5(T ad, L l) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        this.f7462a = ad;
        this.b = l;
    }

    @Override // com.ogury.ad.internal.s
    public final void a() {
        L l = this.b;
        if (l != null) {
            l.onAdLoaded(this.f7462a);
        }
    }

    @Override // com.ogury.ad.internal.s
    public final void b() {
    }

    @Override // com.ogury.ad.internal.s
    public final void c() {
        L l = this.b;
        if (l != null) {
            l.onAdClosed(this.f7462a);
        }
    }

    @Override // com.ogury.ad.internal.s
    public final void d() {
        L l = this.b;
        if (l != null) {
            l.onAdClicked(this.f7462a);
        }
    }

    @Override // com.ogury.ad.internal.s
    public final void e() {
        L l = this.b;
        if (l != null) {
            l.onAdError(this.f7462a, new OguryAdError(OguryAdError.Type.LOAD_ERROR, 3201, "No ad has been loaded."));
        }
    }

    @Override // com.ogury.ad.internal.s
    public final void f() {
        L l = this.b;
        if (l != null) {
            l.onAdImpression(this.f7462a);
        }
    }

    @Override // com.ogury.ad.internal.s
    public final void g() {
        L l = this.b;
        if (l != null) {
            l.onAdError(this.f7462a, new OguryAdError(OguryAdError.Type.LOAD_ERROR, 2201, "No ad is currently available for this placement (no fill)."));
        }
    }

    @Override // com.ogury.ad.internal.s
    public final void a(OguryAdError oguryAdError) {
        Intrinsics.checkNotNullParameter(oguryAdError, "oguryAdError");
        L l = this.b;
        if (l != null) {
            l.onAdError(this.f7462a, oguryAdError);
        }
    }
}
