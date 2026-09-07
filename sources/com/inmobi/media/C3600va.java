package com.inmobi.media;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.va, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes11.dex */
public final class C3600va implements O1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ba f3459a;

    public C3600va(Ba ba) {
        this.f3459a = ba;
    }

    @Override // com.inmobi.media.O1
    public final void a(String url, String api, Z5 z5) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(api, "api");
        this.f3459a.getLandingPageHandler().b(url, api, z5);
    }

    @Override // com.inmobi.media.O1
    public final void b() {
        L4 l4 = this.f3459a.i;
        if (l4 != null) {
            String str = Ba.O0;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
            ((M4) l4).a(str, "onCCTScreenDisplayed");
        }
        this.f3459a.getListener().e(this.f3459a);
        Ba.a(this.f3459a, null, null, null);
    }

    @Override // com.inmobi.media.O1
    public final void c() {
        L4 l4 = this.f3459a.i;
        if (l4 != null) {
            String str = Ba.O0;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
            ((M4) l4).a(str, "onCCTPageLoadedSuccessfully");
        }
        this.f3459a.m();
    }

    @Override // com.inmobi.media.O1
    public final void a(N5 funnelState, Z5 z5, Integer num) {
        Intrinsics.checkNotNullParameter(funnelState, "landingPageFunnelState");
        U5 landingPageHandler = this.f3459a.getLandingPageHandler();
        landingPageHandler.getClass();
        Intrinsics.checkNotNullParameter(funnelState, "funnelState");
        R5.a(funnelState, z5, num, new T5(landingPageHandler));
    }

    @Override // com.inmobi.media.O1
    public final void a() {
        L4 l4 = this.f3459a.i;
        if (l4 != null) {
            String str = Ba.O0;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
            ((M4) l4).a(str, "onCCTScreenDismissed");
        }
        this.f3459a.v();
    }
}
