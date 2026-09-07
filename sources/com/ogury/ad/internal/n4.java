package com.ogury.ad.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class n4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d5 f7364a;

    public n4(d5 webView) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        this.f7364a = webView;
    }

    public final void a(e adExposure) {
        Intrinsics.checkNotNullParameter(adExposure, "adExposure");
        h5.a(this.f7364a, o4.a(adExposure));
        if (adExposure.c < 50.0f) {
            h5.a(this.f7364a, o4.a(false));
            return;
        }
        d5 d5Var = this.f7364a;
        if (d5Var.l) {
            return;
        }
        h5.a(d5Var, o4.a(true));
    }
}
