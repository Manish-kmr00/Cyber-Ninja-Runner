package com.yandex.mobile.ads.impl;

import android.util.Log;
import java.io.IOException;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.X509TrustManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes6.dex */
public final class nw1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final jv f9760a;
    private final Lazy b;
    private KeyStore c;
    private X509TrustManager d;
    private final Object e;

    static final class a extends Lambda implements Function0<X509TrustManager> {
        public static final a b = new a();

        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final X509TrustManager invoke() {
            X509TrustManager x509TrustManagerA = e72.a((KeyStore) null);
            if (x509TrustManagerA != null) {
                return x509TrustManagerA;
            }
            throw new IllegalArgumentException("Failed to create default TrustManager");
        }
    }

    public nw1(jv customCertificatesProvider) {
        Intrinsics.checkNotNullParameter(customCertificatesProvider, "customCertificatesProvider");
        this.f9760a = customCertificatesProvider;
        this.b = LazyKt.lazy(a.b);
        this.e = new Object();
    }

    public final void a(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        ((X509TrustManager) this.b.getValue()).checkClientTrusted(x509CertificateArr, str);
    }

    public final void b(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        Unit unit;
        try {
            ((X509TrustManager) this.b.getValue()).checkServerTrusted(x509CertificateArr, str);
        } catch (CertificateException e) {
            synchronized (this.e) {
                a();
                b();
                X509TrustManager x509TrustManager = this.d;
                if (x509TrustManager != null) {
                    x509TrustManager.checkServerTrusted(x509CertificateArr, str);
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit != null) {
                    Unit unit2 = Unit.INSTANCE;
                } else {
                    Log.w("SdkTrustManager", "Custom TrustManager is null");
                    throw e;
                }
            }
        }
    }

    public final X509Certificate[] c() {
        X509Certificate[] acceptedIssuers = ((X509TrustManager) this.b.getValue()).getAcceptedIssuers();
        Intrinsics.checkNotNullExpressionValue(acceptedIssuers, "getAcceptedIssuers(...)");
        return acceptedIssuers;
    }

    private final void a() {
        KeyStore keyStore;
        b();
        b();
        if (this.c == null) {
            int i = e72.b;
            KeyStore keyStore2 = null;
            try {
                keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
                try {
                    keyStore.load(null);
                } catch (IOException unused) {
                }
            } catch (GeneralSecurityException unused2) {
                keyStore = null;
            }
            if (keyStore == null) {
                Log.w("SdkTrustManager", "Custom KeyStore is null, failed to add certs");
            } else {
                byte[][] bArrA = this.f9760a.a();
                ArrayList arrayList = new ArrayList();
                for (byte[] bArr : bArrA) {
                    X509Certificate x509CertificateA = e72.a(bArr);
                    if (x509CertificateA != null) {
                        arrayList.add(x509CertificateA);
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    a(keyStore, (X509Certificate) it.next());
                }
                keyStore2 = keyStore;
            }
            this.c = keyStore2;
        }
        b();
        if (this.d == null) {
            b();
            if (this.c != null) {
                b();
                this.d = e72.a(this.c);
            }
        }
    }

    public final void b(X509Certificate[] x509CertificateArr, String str, Socket socket) throws CertificateException {
        Unit unit;
        try {
            X509TrustManager x509TrustManager = (X509TrustManager) this.b.getValue();
            if (e72.a()) {
                ge.b(x509TrustManager, x509CertificateArr, str, socket);
            } else {
                x509TrustManager.checkServerTrusted(x509CertificateArr, str);
            }
        } catch (CertificateException e) {
            synchronized (this.e) {
                a();
                b();
                X509TrustManager x509TrustManager2 = this.d;
                if (x509TrustManager2 != null) {
                    if (e72.a()) {
                        ge.b(x509TrustManager2, x509CertificateArr, str, socket);
                    } else {
                        x509TrustManager2.checkServerTrusted(x509CertificateArr, str);
                    }
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit != null) {
                    Unit unit2 = Unit.INSTANCE;
                } else {
                    Log.w("SdkTrustManager", "Custom TrustManager is null");
                    throw e;
                }
            }
        }
    }

    private static void a(KeyStore keyStore, X509Certificate x509Certificate) {
        try {
            keyStore.setCertificateEntry("custom_cert_" + keyStore.size(), x509Certificate);
        } catch (KeyStoreException e) {
            Log.w("SdkTrustManager", "Failed to store certificate", e);
        }
    }

    public final void a(X509Certificate[] x509CertificateArr, String str, Socket socket) throws CertificateException {
        if (e72.a()) {
            ge.a((X509TrustManager) this.b.getValue(), x509CertificateArr, str, socket);
        } else {
            ((X509TrustManager) this.b.getValue()).checkClientTrusted(x509CertificateArr, str);
        }
    }

    public final void a(X509Certificate[] x509CertificateArr, String str, SSLEngine sSLEngine) throws CertificateException {
        if (e72.a()) {
            ge.a((X509TrustManager) this.b.getValue(), x509CertificateArr, str, sSLEngine);
        } else {
            ((X509TrustManager) this.b.getValue()).checkClientTrusted(x509CertificateArr, str);
        }
    }

    public final void b(X509Certificate[] x509CertificateArr, String str, SSLEngine sSLEngine) throws CertificateException {
        Unit unit;
        try {
            X509TrustManager x509TrustManager = (X509TrustManager) this.b.getValue();
            if (e72.a()) {
                ge.b(x509TrustManager, x509CertificateArr, str, sSLEngine);
            } else {
                x509TrustManager.checkServerTrusted(x509CertificateArr, str);
            }
        } catch (CertificateException e) {
            synchronized (this.e) {
                a();
                b();
                X509TrustManager x509TrustManager2 = this.d;
                if (x509TrustManager2 != null) {
                    if (e72.a()) {
                        ge.b(x509TrustManager2, x509CertificateArr, str, sSLEngine);
                    } else {
                        x509TrustManager2.checkServerTrusted(x509CertificateArr, str);
                    }
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit != null) {
                    Unit unit2 = Unit.INSTANCE;
                } else {
                    Log.w("SdkTrustManager", "Custom TrustManager is null");
                    throw e;
                }
            }
        }
    }

    private final void b() {
        if (!Thread.holdsLock(this.e)) {
            throw new IllegalStateException("Operation should be performed under lock");
        }
    }
}
