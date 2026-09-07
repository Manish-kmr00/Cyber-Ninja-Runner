package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.net.http.SslCertificate;
import android.net.http.SslError;
import android.os.Build;
import com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes.dex */
public final class qj2 implements pj2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lazy f10025a = LazyKt.lazy(a.b);

    static final class a extends Lambda implements Function0<CertificateFactory> {
        public static final a b = new a();

        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final CertificateFactory invoke() {
            return CertificateFactory.getInstance(AndroidStaticDeviceInfoDataSource.CERTIFICATE_TYPE_X509);
        }
    }

    @Override // com.yandex.mobile.ads.impl.pj2
    public final boolean a(Context context, SslError sslError) {
        X509Certificate x509CertificateA;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sslError, "sslError");
        int i = iw1.l;
        cu1 cu1VarA = iw1.a.a().a(context);
        if (cu1VarA == null || !cu1VarA.k0()) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            x509CertificateA = sslError.getCertificate().getX509Certificate();
        } else {
            SslCertificate certificate = sslError.getCertificate();
            Intrinsics.checkNotNullExpressionValue(certificate, "getCertificate(...)");
            Object value = this.f10025a.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            x509CertificateA = us1.a(certificate, (CertificateFactory) value);
        }
        if (x509CertificateA == null) {
            return false;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            lr0.a(new bu1(context)).checkServerTrusted(new X509Certificate[]{x509CertificateA}, "RSA");
            return true;
        } catch (Exception unused) {
            Object[] args = new Object[0];
            int i2 = op0.b;
            Intrinsics.checkNotNullParameter(args, "args");
            return false;
        }
    }
}
