package com.yandex.mobile.ads.impl;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class nj2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final uf1 f9734a;
    private final wy1 b;

    public nj2(uf1 parentHtmlWebView) {
        Intrinsics.checkNotNullParameter(parentHtmlWebView, "parentHtmlWebView");
        this.f9734a = parentHtmlWebView;
        this.b = new wy1();
    }

    public final void a(final Map<String, String> trackingParameters) {
        Intrinsics.checkNotNullParameter(trackingParameters, "trackingParameters");
        this.b.a(new Runnable() { // from class: com.yandex.mobile.ads.impl.nj2$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                nj2.a(this.f$0, trackingParameters);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(nj2 this$0, Map trackingParameters) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(trackingParameters, "$trackingParameters");
        this$0.f9734a.setVisibility(0);
        op0.d(new Object[0]);
        ah0 ah0VarJ = this$0.f9734a.j();
        if (ah0VarJ != null) {
            ah0VarJ.a(this$0.f9734a, trackingParameters);
        }
    }
}
