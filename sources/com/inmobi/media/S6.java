package com.inmobi.media;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class S6 implements O1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C3313b7 f3191a;

    public S6(C3313b7 c3313b7) {
        this.f3191a = c3313b7;
    }

    @Override // com.inmobi.media.O1
    public final void a(String url, String api, Z5 z5) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(api, "api");
    }

    @Override // com.inmobi.media.O1
    public final void b() {
        A0 a0 = this.f3191a.w;
        if (a0 != null) {
            a0.d();
        }
    }

    @Override // com.inmobi.media.O1
    public final void c() {
    }

    @Override // com.inmobi.media.O1
    public final void a(N5 landingPageFunnelState, Z5 z5, Integer num) {
        Intrinsics.checkNotNullParameter(landingPageFunnelState, "landingPageFunnelState");
        R5.a(landingPageFunnelState, z5, num, 8);
    }

    @Override // com.inmobi.media.O1
    public final void a() {
        A0 a0 = this.f3191a.w;
        if (a0 != null) {
            a0.b();
        }
        L4 l4 = this.f3191a.j;
        if (l4 != null) {
            ((M4) l4).a();
        }
    }
}
