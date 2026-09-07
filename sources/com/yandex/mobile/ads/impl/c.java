package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.io.IOException;
import java.util.Map;
import javax.net.ssl.SSLSocketFactory;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class c extends mk implements gi0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f8551a;
    private final mk b;

    @Override // com.yandex.mobile.ads.impl.mk
    public final zh0 a(np1<?> request, Map<String, String> additionalHeaders) throws zh, IOException {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(additionalHeaders, "additionalHeaders");
        String strL = request.l();
        boolean zA = this.f8551a.a(strL);
        if (strL != null && !zA) {
            String strA = sh0.c.a();
            String strL2 = request.l();
            Intrinsics.checkNotNull(strL2);
            additionalHeaders.put(strA, strL2);
        }
        zh0 zh0VarA = this.b.a(request, additionalHeaders);
        Intrinsics.checkNotNullExpressionValue(zh0VarA, "executeRequest(...)");
        return zh0VarA;
    }

    public /* synthetic */ c(Context context, SSLSocketFactory sSLSocketFactory) {
        this(context, sSLSocketFactory, new hi0(), d.a());
    }

    public c(Context context, SSLSocketFactory sSLSocketFactory, hi0 hurlStackFactory, a aabCryptedUrlValidator) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(hurlStackFactory, "hurlStackFactory");
        Intrinsics.checkNotNullParameter(aabCryptedUrlValidator, "aabCryptedUrlValidator");
        this.f8551a = aabCryptedUrlValidator;
        hurlStackFactory.getClass();
        this.b = hi0.a(context, this, sSLSocketFactory);
    }

    @Override // com.yandex.mobile.ads.impl.m82
    public final String a(String str) {
        return (str == null || this.f8551a.a(str)) ? str : "https://yandex.ru/appcry";
    }
}
