package com.yandex.mobile.ads.impl;

import android.net.http.SslCertificate;
import android.os.Bundle;
import com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource;
import java.io.ByteArrayInputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class us1 {
    public static final X509Certificate a(SslCertificate sslCertificate, CertificateFactory x509CertificateFactory) {
        byte[] byteArray;
        Intrinsics.checkNotNullParameter(sslCertificate, "<this>");
        Intrinsics.checkNotNullParameter(x509CertificateFactory, "x509CertificateFactory");
        if (!Intrinsics.areEqual(x509CertificateFactory.getType(), AndroidStaticDeviceInfoDataSource.CERTIFICATE_TYPE_X509)) {
            String str = "Wrong certificateFactory.\nExpected type: X.509\nActual type: " + x509CertificateFactory.getType();
            op0.b(new Object[0]);
            return null;
        }
        Bundle bundleSaveState = SslCertificate.saveState(sslCertificate);
        if (bundleSaveState == null || (byteArray = bundleSaveState.getByteArray("x509-certificate")) == null) {
            return null;
        }
        try {
            Certificate certificateGenerateCertificate = x509CertificateFactory.generateCertificate(new ByteArrayInputStream(byteArray));
            if (certificateGenerateCertificate instanceof X509Certificate) {
                return (X509Certificate) certificateGenerateCertificate;
            }
            return null;
        } catch (CertificateException unused) {
            op0.c(new Object[0]);
            return null;
        }
    }
}
