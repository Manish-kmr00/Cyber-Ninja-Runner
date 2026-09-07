package com.ogury.ad.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class j1 implements b5 {
    public static final j1 b = new j1(new b5[0]);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b5[] f7326a;

    public j1(b5[] mraidUrlHandlers) {
        Intrinsics.checkNotNullParameter(mraidUrlHandlers, "mraidUrlHandlers");
        this.f7326a = mraidUrlHandlers;
    }

    @Override // com.ogury.ad.internal.b5
    public final boolean a(String url, d5 webView, c ad) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(ad, "ad");
        for (b5 b5Var : this.f7326a) {
            if (b5Var.a(url, webView, ad)) {
                return true;
            }
        }
        return false;
    }
}
