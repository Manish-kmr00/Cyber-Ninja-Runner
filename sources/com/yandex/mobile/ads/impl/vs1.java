package com.yandex.mobile.ads.impl;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class vs1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final X509TrustManager f10504a;

    public vs1(mw1 trustManager) {
        Intrinsics.checkNotNullParameter(trustManager, "trustManager");
        this.f10504a = trustManager;
    }

    public final SSLContext a() {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new X509TrustManager[]{this.f10504a}, null);
            Intrinsics.checkNotNull(sSLContext);
            return sSLContext;
        } catch (KeyManagementException e) {
            throw new IllegalStateException("Failed to initialize SSLContext", e);
        } catch (NoSuchAlgorithmException e2) {
            throw new IllegalStateException("No system TLS", e2);
        }
    }
}
