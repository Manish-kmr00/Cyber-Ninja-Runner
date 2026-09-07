package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public class kk implements ug0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final uf1 f9425a;

    public kk(uf1 parentHtmlWebView) {
        Intrinsics.checkNotNullParameter(parentHtmlWebView, "parentHtmlWebView");
        this.f9425a = parentHtmlWebView;
        parentHtmlWebView.setId(2);
    }

    @Override // com.yandex.mobile.ads.impl.ug0
    public void a(String htmlResponse) {
        Intrinsics.checkNotNullParameter(htmlResponse, "htmlResponse");
        this.f9425a.b(htmlResponse);
    }

    public void a(ah0 htmlWebViewListener) {
        Intrinsics.checkNotNullParameter(htmlWebViewListener, "htmlWebViewListener");
        this.f9425a.setHtmlWebViewListener(htmlWebViewListener);
    }

    @Override // com.yandex.mobile.ads.impl.ug0
    public void invalidate() {
        this.f9425a.d();
    }
}
