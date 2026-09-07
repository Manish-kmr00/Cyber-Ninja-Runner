package com.yandex.mobile.ads.impl;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class wb implements zg0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final cf1 f10550a;
    private final List<zb> b;
    private xb c;

    public wb(cf1 optOutRepository) {
        Intrinsics.checkNotNullParameter(optOutRepository, "optOutRepository");
        this.f10550a = optOutRepository;
        this.b = a();
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
        } catch (URISyntaxException unused) {
            String str = "Invalid URL: " + url;
            op0.f(new Object[0]);
        }
    }

    public final void a(xb adtuneOptOutWebViewListener) {
        Intrinsics.checkNotNullParameter(adtuneOptOutWebViewListener, "adtuneOptOutWebViewListener");
        this.c = adtuneOptOutWebViewListener;
    }

    private final class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            wb.this.f10550a.b();
        }
    }

    private final List<zb> a() {
        return CollectionsKt.listOf(new fc("noInterestAd", new a()));
    }

    @Override // com.yandex.mobile.ads.impl.zg0
    public final void a(int i) {
        xb xbVar;
        if (!new dc().a(i) || (xbVar = this.c) == null) {
            return;
        }
        xbVar.a();
    }
}
