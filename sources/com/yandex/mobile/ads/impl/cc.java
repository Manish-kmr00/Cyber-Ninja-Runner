package com.yandex.mobile.ads.impl;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class cc implements zg0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ub f8587a;
    private final List<zb> b;
    private ec c;
    private String d;

    public cc(ub optOutRenderer) {
        Intrinsics.checkNotNullParameter(optOutRenderer, "optOutRenderer");
        this.f8587a = optOutRenderer;
        this.b = a();
    }

    public static final void a(cc ccVar) {
        ec ecVar = ccVar.c;
        if (ecVar != null) {
            ecVar.b();
        }
    }

    public final void a(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        try {
            URI uri = new URI(url);
            String scheme = uri.getScheme();
            String host = uri.getHost();
            for (zb zbVar : this.b) {
                if (zbVar.a(scheme, host)) {
                    zbVar.a();
                    return;
                }
            }
            ec ecVar = this.c;
            if (ecVar != null) {
                ecVar.a(url);
            }
        } catch (URISyntaxException unused) {
            String str = "Invalid URL: " + url;
            op0.f(new Object[0]);
            ec ecVar2 = this.c;
            if (ecVar2 != null) {
                ecVar2.b();
            }
        }
    }

    public final void a(ec adtuneWebViewListener) {
        Intrinsics.checkNotNullParameter(adtuneWebViewListener, "adtuneWebViewListener");
        this.c = adtuneWebViewListener;
    }

    public final void b(String str) {
        this.d = str;
    }

    private final class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ec ecVar = cc.this.c;
            if (ecVar != null) {
                ecVar.a();
            }
        }
    }

    @Override // com.yandex.mobile.ads.impl.zg0
    public final void a(int i) {
        ec ecVar;
        if (!new dc().a(i) || (ecVar = this.c) == null) {
            return;
        }
        ecVar.b();
    }

    private final class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            cc.a(cc.this);
        }
    }

    private final List<zb> a() {
        return CollectionsKt.listOf((Object[]) new fc[]{new fc("adtuneRendered", new c()), new fc("adtuneClosed", new a()), new fc("openOptOut", new b())});
    }

    private final class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            cc.this.f8587a.a(cc.this.d);
        }
    }
}
