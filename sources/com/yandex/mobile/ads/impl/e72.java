package com.yandex.mobile.ads.impl;

import com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource;
import java.io.ByteArrayInputStream;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes9.dex */
public final class e72 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Lazy f8771a = LazyKt.lazy(a.b);
    public static final /* synthetic */ int b = 0;

    static final class a extends Lambda implements Function0<CertificateFactory> {
        public static final a b = new a();

        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final CertificateFactory invoke() {
            try {
                return CertificateFactory.getInstance(AndroidStaticDeviceInfoDataSource.CERTIFICATE_TYPE_X509);
            } catch (CertificateException unused) {
                return null;
            }
        }
    }

    public static final X509Certificate a(byte[] certBytes) {
        Intrinsics.checkNotNullParameter(certBytes, "certBytes");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(certBytes);
        try {
            CertificateFactory certificateFactory = (CertificateFactory) f8771a.getValue();
            return (X509Certificate) (certificateFactory != null ? certificateFactory.generateCertificate(byteArrayInputStream) : null);
        } catch (CertificateException unused) {
            return null;
        }
    }

    public static final boolean a() {
        return true;
    }

    public static final X509TrustManager a(KeyStore keyStore) {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(keyStore);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            Intrinsics.checkNotNull(trustManagers);
            ArrayList arrayList = new ArrayList();
            for (TrustManager trustManager : trustManagers) {
                if (trustManager instanceof X509TrustManager) {
                    arrayList.add(trustManager);
                }
            }
            return (X509TrustManager) CollectionsKt.firstOrNull((List) arrayList);
        } catch (GeneralSecurityException unused) {
            return null;
        }
    }
}
