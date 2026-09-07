package com.ogury.ad.internal;

import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class l4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<u5> f7343a;
    public final d5 b;
    public final c c;
    public final long d;

    public l4() {
        throw null;
    }

    public l4(WeakReference oguryAdGatewayRef, d5 webView, c ad) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        Intrinsics.checkNotNullParameter(oguryAdGatewayRef, "oguryAdGatewayRef");
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(ad, "ad");
        this.f7343a = oguryAdGatewayRef;
        this.b = webView;
        this.c = ad;
        this.d = jCurrentTimeMillis;
    }

    public final c a() {
        return this.c;
    }

    public final long b() {
        return this.d;
    }
}
