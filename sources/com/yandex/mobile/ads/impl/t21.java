package com.yandex.mobile.ads.impl;

import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public class t21 extends kk {
    private final i21 b;

    public static final class a implements q21 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WeakReference<ah0> f10261a;

        @Override // com.yandex.mobile.ads.impl.q21
        public final void a(uf1 webView, Map trackingParameters) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            Intrinsics.checkNotNullParameter(trackingParameters, "trackingParameters");
            ah0 ah0Var = this.f10261a.get();
            if (ah0Var != null) {
                ah0Var.a(webView, trackingParameters);
            }
        }

        public /* synthetic */ a(ah0 ah0Var) {
            this(ah0Var, new WeakReference(ah0Var));
        }

        public a(ah0 htmlWebViewListener, WeakReference<ah0> htmlWebViewListenerRef) {
            Intrinsics.checkNotNullParameter(htmlWebViewListener, "htmlWebViewListener");
            Intrinsics.checkNotNullParameter(htmlWebViewListenerRef, "htmlWebViewListenerRef");
            this.f10261a = htmlWebViewListenerRef;
        }

        @Override // com.yandex.mobile.ads.impl.q21
        public final void a(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            ah0 ah0Var = this.f10261a.get();
            if (ah0Var != null) {
                ah0Var.a(url);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t21(uf1 parentHtmlWebView, ah0 htmlWebViewListener, a htmlWebViewMraidListener, i21 mraidController) {
        super(parentHtmlWebView);
        Intrinsics.checkNotNullParameter(parentHtmlWebView, "parentHtmlWebView");
        Intrinsics.checkNotNullParameter(htmlWebViewListener, "htmlWebViewListener");
        Intrinsics.checkNotNullParameter(htmlWebViewMraidListener, "htmlWebViewMraidListener");
        Intrinsics.checkNotNullParameter(mraidController, "mraidController");
        this.b = mraidController;
        mraidController.a(htmlWebViewMraidListener);
    }

    @Override // com.yandex.mobile.ads.impl.kk, com.yandex.mobile.ads.impl.ug0
    public final void a(String htmlResponse) {
        Intrinsics.checkNotNullParameter(htmlResponse, "htmlResponse");
        this.b.a(htmlResponse);
    }

    public final i21 b() {
        return this.b;
    }

    @Override // com.yandex.mobile.ads.impl.kk
    public final void a(ah0 htmlWebViewListener) {
        Intrinsics.checkNotNullParameter(htmlWebViewListener, "htmlWebViewListener");
        super.a(new n21(this.b, htmlWebViewListener));
    }

    @Override // com.yandex.mobile.ads.impl.kk, com.yandex.mobile.ads.impl.ug0
    public final void invalidate() {
        super.invalidate();
        this.b.a();
    }
}
