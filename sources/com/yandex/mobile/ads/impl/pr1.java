package com.yandex.mobile.ads.impl;

import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class pr1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final rj f9946a;

    public final nr1 a(pq1 networkResponse) {
        Integer numValueOf;
        String strA;
        Intrinsics.checkNotNullParameter(networkResponse, "networkResponse");
        Map<String, String> responseHeaders = networkResponse.b();
        sh0 httpHeader = sh0.C;
        int i = kf0.b;
        Intrinsics.checkNotNullParameter(responseHeaders, "responseHeaders");
        Intrinsics.checkNotNullParameter(httpHeader, "httpHeader");
        String strA2 = kf0.a(responseHeaders, httpHeader);
        int i2 = oa.b;
        kx1 kx1Var = null;
        if (strA2 != null) {
            try {
                numValueOf = Integer.valueOf(strA2);
            } catch (NumberFormatException unused) {
                numValueOf = null;
            }
        } else {
            numValueOf = null;
        }
        String strA3 = kf0.a(responseHeaders, sh0.E);
        if (strA3 != null) {
            this.f9946a.getClass();
            strA = rj.a(strA3);
        } else {
            strA = null;
        }
        fp fpVar = (numValueOf == null || strA == null || strA.length() <= 0) ? null : new fp(numValueOf.intValue(), strA);
        sh0 header = sh0.F;
        Intrinsics.checkNotNullParameter(responseHeaders, "responseHeaders");
        Intrinsics.checkNotNullParameter(header, "header");
        String str = (String) CollectionsKt.firstOrNull((List) kf0.c(responseHeaders, header));
        if (str != null && str.length() > 0) {
            kx1Var = new kx1(str);
        }
        sh0 httpHeader2 = sh0.K;
        Intrinsics.checkNotNullParameter(responseHeaders, "responseHeaders");
        Intrinsics.checkNotNullParameter(httpHeader2, "httpHeader");
        String strA4 = kf0.a(responseHeaders, httpHeader2);
        return new nr1.a().a(fpVar).a(kx1Var).a(strA4 == null ? false : Boolean.parseBoolean(strA4)).a();
    }

    public /* synthetic */ pr1() {
        this(new rj());
    }

    public pr1(rj base64Decoder) {
        Intrinsics.checkNotNullParameter(base64Decoder, "base64Decoder");
        this.f9946a = base64Decoder;
    }
}
