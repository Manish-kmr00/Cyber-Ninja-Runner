package com.yandex.mobile.ads.impl;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class n21 implements ah0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final i21 f9692a;
    private final ah0 b;

    public n21(i21 mraidController, ah0 htmlWebViewListener) {
        Intrinsics.checkNotNullParameter(mraidController, "mraidController");
        Intrinsics.checkNotNullParameter(htmlWebViewListener, "htmlWebViewListener");
        this.f9692a = mraidController;
        this.b = htmlWebViewListener;
    }

    @Override // com.yandex.mobile.ads.impl.ah0
    public final void a(w3 adFetchRequestError) {
        Intrinsics.checkNotNullParameter(adFetchRequestError, "adFetchRequestError");
        this.b.a(adFetchRequestError);
    }

    @Override // com.yandex.mobile.ads.impl.ah0
    public final void a(uf1 webView, Map trackingParameters) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(trackingParameters, "trackingParameters");
        this.f9692a.a(webView, trackingParameters);
    }

    @Override // com.yandex.mobile.ads.impl.ah0
    public final void a(String url) throws g21 {
        Intrinsics.checkNotNullParameter(url, "url");
        this.f9692a.b(url);
    }

    @Override // com.yandex.mobile.ads.impl.ah0
    public final void a(boolean z) {
        this.f9692a.a(z);
    }
}
