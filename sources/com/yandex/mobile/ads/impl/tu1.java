package com.yandex.mobile.ads.impl;

import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class tu1 extends vz {
    private final SSLSocketFactory s;

    @Override // com.yandex.mobile.ads.impl.vz
    public final HttpURLConnection a(URL url) {
        Intrinsics.checkNotNullParameter(url, "url");
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        SSLSocketFactory sSLSocketFactory = this.s;
        if (sSLSocketFactory != null && (httpURLConnection instanceof HttpsURLConnection)) {
            ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(sSLSocketFactory);
        }
        Intrinsics.checkNotNull(httpURLConnection);
        return httpURLConnection;
    }

    public tu1(String str, rh0 rh0Var, SSLSocketFactory sSLSocketFactory) {
        super(str, 8000, 8000, rh0Var);
        this.s = sSLSocketFactory;
    }
}
