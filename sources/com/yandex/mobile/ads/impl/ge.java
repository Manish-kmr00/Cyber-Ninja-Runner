package com.yandex.mobile.ads.impl;

import java.net.Socket;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.X509ExtendedTrustManager;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ge {
    public static final void a(X509TrustManager trustManager, X509Certificate[] x509CertificateArr, String str, Socket socket) throws CertificateException {
        Intrinsics.checkNotNullParameter(trustManager, "trustManager");
        if (trustManager instanceof X509ExtendedTrustManager) {
            ((X509ExtendedTrustManager) trustManager).checkClientTrusted(x509CertificateArr, str, socket);
        } else {
            trustManager.checkClientTrusted(x509CertificateArr, str);
        }
    }

    public static final void b(X509TrustManager trustManager, X509Certificate[] x509CertificateArr, String str, Socket socket) throws CertificateException {
        Intrinsics.checkNotNullParameter(trustManager, "trustManager");
        if (trustManager instanceof X509ExtendedTrustManager) {
            ((X509ExtendedTrustManager) trustManager).checkServerTrusted(x509CertificateArr, str, socket);
        } else {
            trustManager.checkServerTrusted(x509CertificateArr, str);
        }
    }

    public static final void a(X509TrustManager trustManager, X509Certificate[] x509CertificateArr, String str, SSLEngine sSLEngine) throws CertificateException {
        Intrinsics.checkNotNullParameter(trustManager, "trustManager");
        if (trustManager instanceof X509ExtendedTrustManager) {
            ((X509ExtendedTrustManager) trustManager).checkClientTrusted(x509CertificateArr, str, sSLEngine);
        } else {
            trustManager.checkClientTrusted(x509CertificateArr, str);
        }
    }

    public static final void b(X509TrustManager trustManager, X509Certificate[] x509CertificateArr, String str, SSLEngine sSLEngine) throws CertificateException {
        Intrinsics.checkNotNullParameter(trustManager, "trustManager");
        if (trustManager instanceof X509ExtendedTrustManager) {
            ((X509ExtendedTrustManager) trustManager).checkServerTrusted(x509CertificateArr, str, sSLEngine);
        } else {
            trustManager.checkServerTrusted(x509CertificateArr, str);
        }
    }

    public static final mw1 a(jv customCertificatesProvider) throws CertificateException {
        Intrinsics.checkNotNullParameter(customCertificatesProvider, "customCertificatesProvider");
        return new xu1(customCertificatesProvider);
    }
}
