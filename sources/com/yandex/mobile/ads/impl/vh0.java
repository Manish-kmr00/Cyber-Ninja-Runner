package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes9.dex */
public final class vh0 implements zs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f10478a;
    private final xs1 b;

    public vh0(Context context, xs1 sslSocketFactoryCreator) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sslSocketFactoryCreator, "sslSocketFactoryCreator");
        this.f10478a = context;
        this.b = sslSocketFactoryCreator;
    }

    @Override // com.yandex.mobile.ads.impl.zs
    public final boolean a(String host) {
        HttpsURLConnection httpsURLConnectionB;
        Intrinsics.checkNotNullParameter(host, "host");
        boolean z = false;
        try {
            httpsURLConnectionB = b(host);
            try {
                int responseCode = httpsURLConnectionB.getResponseCode();
                if (200 <= responseCode && responseCode < 500) {
                    z = true;
                }
                httpsURLConnectionB.disconnect();
                return z;
            } catch (Throwable unused) {
                try {
                    op0.c(new Object[0]);
                    return false;
                } finally {
                    if (httpsURLConnectionB != null) {
                        httpsURLConnectionB.disconnect();
                    }
                }
            }
        } catch (Throwable unused2) {
            httpsURLConnectionB = null;
        }
    }

    private final HttpsURLConnection b(String str) throws IOException {
        StringBuilder sb = new StringBuilder(str.length() + 13);
        if (!StringsKt.startsWith$default(str, "https://", false, 2, (Object) null)) {
            sb.append("https://");
        }
        sb.append(str);
        if (!StringsKt.endsWith$default(str, "/ping", false, 2, (Object) null)) {
            sb.append("/ping");
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        URLConnection uRLConnectionOpenConnection = new URL(string).openConnection();
        Intrinsics.checkNotNull(uRLConnectionOpenConnection, "null cannot be cast to non-null type javax.net.ssl.HttpsURLConnection");
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) uRLConnectionOpenConnection;
        httpsURLConnection.setSSLSocketFactory(this.b.a(this.f10478a));
        httpsURLConnection.setRequestMethod("HEAD");
        httpsURLConnection.setConnectTimeout(2000);
        httpsURLConnection.setReadTimeout(2000);
        return httpsURLConnection;
    }
}
