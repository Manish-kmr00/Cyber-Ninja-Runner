package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.wj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4545wj implements Xa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AdRevenue f11832a;
    public final /* synthetic */ boolean b;

    public C4545wj(AdRevenue adRevenue, boolean z) {
        this.f11832a = adRevenue;
        this.b = z;
    }

    @Override // io.appmetrica.analytics.impl.Xa
    public final void a(Ya ya) {
        ya.reportAdRevenue(this.f11832a, this.b);
    }
}
