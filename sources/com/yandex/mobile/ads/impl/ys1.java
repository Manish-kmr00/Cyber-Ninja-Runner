package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class ys1 implements xs1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final iw1 f10767a;

    public ys1(iw1 sdkSettings) {
        Intrinsics.checkNotNullParameter(sdkSettings, "sdkSettings");
        this.f10767a = sdkSettings;
    }

    @Override // com.yandex.mobile.ads.impl.xs1
    public final SSLSocketFactory a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        cu1 cu1VarA = this.f10767a.a(context);
        Intrinsics.checkNotNullParameter(context, "context");
        bu1 customCertificatesProvider = new bu1(context);
        if (cu1VarA != null && cu1VarA.k0()) {
            Intrinsics.checkNotNullParameter(customCertificatesProvider, "customCertificatesProvider");
            mw1 trustManager = lr0.a(customCertificatesProvider);
            Intrinsics.checkNotNullParameter(trustManager, "trustManager");
            SSLSocketFactory socketFactory = new vs1(trustManager).a().getSocketFactory();
            Intrinsics.checkNotNullExpressionValue(socketFactory, "getSocketFactory(...)");
            return socketFactory;
        }
        if (pa.a(21)) {
            int i = uj1.b;
            try {
                SSLContext sSLContext = SSLContext.getInstance("TLSv1.2");
                try {
                    sSLContext.init(null, null, null);
                } catch (KeyManagementException e) {
                    op0.b(e.getMessage());
                }
                SSLSocketFactory socketFactory2 = sSLContext.getSocketFactory();
                Intrinsics.checkNotNullExpressionValue(socketFactory2, "getSocketFactory(...)");
                return new uj1(socketFactory2);
            } catch (NoSuchAlgorithmException e2) {
                op0.b("TLSv1.2", e2.getMessage());
            }
        }
        return null;
    }
}
