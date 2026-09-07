package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import javax.net.ssl.SSLSocketFactory;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class z01 extends mk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f10781a;
    private final mn1 b;
    private final ee c;
    private final uc1 d;
    private final mk e;

    public z01(Context context, SSLSocketFactory sSLSocketFactory, c aabHurlStack, mn1 readyHttpResponseCreator, ee antiAdBlockerStateValidator, uc1 networkResponseCreator, hi0 hurlStackFactory) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(aabHurlStack, "aabHurlStack");
        Intrinsics.checkNotNullParameter(readyHttpResponseCreator, "readyHttpResponseCreator");
        Intrinsics.checkNotNullParameter(antiAdBlockerStateValidator, "antiAdBlockerStateValidator");
        Intrinsics.checkNotNullParameter(networkResponseCreator, "networkResponseCreator");
        Intrinsics.checkNotNullParameter(hurlStackFactory, "hurlStackFactory");
        this.f10781a = aabHurlStack;
        this.b = readyHttpResponseCreator;
        this.c = antiAdBlockerStateValidator;
        this.d = networkResponseCreator;
        hurlStackFactory.getClass();
        this.e = hi0.a(context, null, sSLSocketFactory);
    }

    @Override // com.yandex.mobile.ads.impl.mk
    public final zh0 a(np1<?> request, Map<String, String> additionalHeaders) throws zh, IOException {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(additionalHeaders, "additionalHeaders");
        long jCurrentTimeMillis = System.currentTimeMillis();
        tc1 networkResponse = this.d.a(request);
        if (h11.f9051a.a()) {
            yp1.a(jCurrentTimeMillis, request, networkResponse);
        }
        if (networkResponse == null) {
            if (this.c.a()) {
                return this.f10781a.a(request, additionalHeaders);
            }
            zh0 zh0VarA = this.e.a(request, additionalHeaders);
            Intrinsics.checkNotNull(zh0VarA);
            return zh0VarA;
        }
        this.b.getClass();
        Intrinsics.checkNotNullParameter(networkResponse, "networkResponse");
        ArrayList arrayList = new ArrayList();
        Map<String, String> map = networkResponse.c;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                arrayList.add(new hf0(entry.getKey(), entry.getValue()));
            }
        }
        return new zh0(networkResponse.f10286a, arrayList, networkResponse.b);
    }
}
