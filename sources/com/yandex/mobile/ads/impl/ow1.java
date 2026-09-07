package com.yandex.mobile.ads.impl;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class ow1 implements mw1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final nw1 f9870a;

    public ow1(bu1 customCertificatesProvider) {
        Intrinsics.checkNotNullParameter(customCertificatesProvider, "customCertificatesProvider");
        this.f9870a = new nw1(customCertificatesProvider);
    }

    @Override // javax.net.ssl.X509TrustManager
    public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        this.f9870a.a(x509CertificateArr, str);
    }

    @Override // javax.net.ssl.X509TrustManager
    public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        this.f9870a.b(x509CertificateArr, str);
    }

    @Override // javax.net.ssl.X509TrustManager
    public final X509Certificate[] getAcceptedIssuers() {
        return this.f9870a.c();
    }
}
