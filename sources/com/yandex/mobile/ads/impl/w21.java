package com.yandex.mobile.ads.impl;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class w21 implements ah0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final s21 f10528a;
    private final j21 b;
    private final ie2 c;
    private final nj2 d;
    private final h21 e;
    private final wg0 f;
    private xo g;

    @Override // com.yandex.mobile.ads.impl.ah0
    public final void a(w3 adFetchRequestError) {
        Intrinsics.checkNotNullParameter(adFetchRequestError, "adFetchRequestError");
    }

    @Override // com.yandex.mobile.ads.impl.ah0
    public final void a(boolean z) {
    }

    public final void b(String htmlResponse) {
        Intrinsics.checkNotNullParameter(htmlResponse, "htmlResponse");
        this.e.getClass();
        boolean zA = h21.a(htmlResponse);
        this.f.getClass();
        vg0 m21Var = zA ? new m21() : new lk();
        s21 s21Var = this.f10528a;
        ie2 ie2Var = this.c;
        j21 j21Var = this.b;
        m21Var.a(s21Var, this, ie2Var, j21Var, j21Var, j21Var).a(htmlResponse);
    }

    public /* synthetic */ w21(s21 s21Var, j21 j21Var) {
        this(s21Var, j21Var, new ie2(), new nj2(s21Var), new h21(), new wg0());
    }

    @Override // com.yandex.mobile.ads.impl.ah0
    public final void a(uf1 webView, Map trackingParameters) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(trackingParameters, "trackingParameters");
    }

    public w21(s21 mraidWebView, j21 mraidEventsObservable, ie2 videoEventController, nj2 webViewLoadingNotifier, h21 mraidCompatibilityDetector, wg0 htmlWebViewAdapterFactoryProvider) {
        Intrinsics.checkNotNullParameter(mraidWebView, "mraidWebView");
        Intrinsics.checkNotNullParameter(mraidEventsObservable, "mraidEventsObservable");
        Intrinsics.checkNotNullParameter(videoEventController, "videoEventController");
        Intrinsics.checkNotNullParameter(webViewLoadingNotifier, "webViewLoadingNotifier");
        Intrinsics.checkNotNullParameter(mraidCompatibilityDetector, "mraidCompatibilityDetector");
        Intrinsics.checkNotNullParameter(htmlWebViewAdapterFactoryProvider, "htmlWebViewAdapterFactoryProvider");
        this.f10528a = mraidWebView;
        this.b = mraidEventsObservable;
        this.c = videoEventController;
        this.d = webViewLoadingNotifier;
        this.e = mraidCompatibilityDetector;
        this.f = htmlWebViewAdapterFactoryProvider;
    }

    public final void a() {
        this.d.a(MapsKt.emptyMap());
    }

    @Override // com.yandex.mobile.ads.impl.ah0
    public final void a(String customUrl) {
        Intrinsics.checkNotNullParameter(customUrl, "customUrl");
        xo xoVar = this.g;
        if (xoVar != null) {
            xoVar.a(this.f10528a, customUrl);
        }
    }

    public final void a(xo xoVar) {
        this.g = xoVar;
    }
}
