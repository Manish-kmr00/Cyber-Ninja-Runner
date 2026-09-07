package com.yandex.mobile.ads.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class zc1<T> implements xc1<T> {
    private static final long k = TimeUnit.SECONDS.toMillis(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o3 f10806a;
    private final uq1<T> b;
    private final p80 c;
    private final ez0 d;
    private final pr1 e;
    private final gs f;
    private final lg0 g;
    private final qs0 h;
    private final md i;
    private final p8 j;

    public zc1(o3 adConfiguration, uq1<T> responseBodyParser, p80 falseClickParser, ez0 mediationDataParser, pr1 rewardDataParser, gs contentTypeHeaderParser, lg0 htmlAdImpressionDataParser, qs0 localeParser, md analyticsParametersParser, p8 adResponseAbExperimentDataParser) {
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(responseBodyParser, "responseBodyParser");
        Intrinsics.checkNotNullParameter(falseClickParser, "falseClickParser");
        Intrinsics.checkNotNullParameter(mediationDataParser, "mediationDataParser");
        Intrinsics.checkNotNullParameter(rewardDataParser, "rewardDataParser");
        Intrinsics.checkNotNullParameter(contentTypeHeaderParser, "contentTypeHeaderParser");
        Intrinsics.checkNotNullParameter(htmlAdImpressionDataParser, "htmlAdImpressionDataParser");
        Intrinsics.checkNotNullParameter(localeParser, "localeParser");
        Intrinsics.checkNotNullParameter(analyticsParametersParser, "analyticsParametersParser");
        Intrinsics.checkNotNullParameter(adResponseAbExperimentDataParser, "adResponseAbExperimentDataParser");
        this.f10806a = adConfiguration;
        this.b = responseBodyParser;
        this.c = falseClickParser;
        this.d = mediationDataParser;
        this.e = rewardDataParser;
        this.f = contentTypeHeaderParser;
        this.g = htmlAdImpressionDataParser;
        this.h = localeParser;
        this.i = analyticsParametersParser;
        this.j = adResponseAbExperimentDataParser;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer b(String value) {
        int i;
        Intrinsics.checkNotNullParameter(value, "value");
        int i2 = oa.b;
        if (value != null) {
            try {
                i = Integer.parseInt(value);
            } catch (NumberFormatException unused) {
                i = 0;
            }
        } else {
            i = 0;
        }
        return Integer.valueOf(Math.min(i, 100));
    }

    @Override // com.yandex.mobile.ads.impl.xc1
    public final o8<T> a(pq1 networkResponse, Map<String, String> responseHeaders, qs responseAdType) {
        Integer numValueOf;
        Integer numValueOf2;
        Locale locale;
        Long lValueOf;
        Intrinsics.checkNotNullParameter(networkResponse, "networkResponse");
        Intrinsics.checkNotNullParameter(responseHeaders, "headers");
        Intrinsics.checkNotNullParameter(responseAdType, "responseAdType");
        o8.a aVar = new o8.a();
        aVar.f(this.f10806a.c());
        aVar.a(responseAdType);
        int iB = kf0.b(responseHeaders, sh0.d);
        int iB2 = kf0.b(responseHeaders, sh0.e);
        aVar.e(iB);
        aVar.b(iB2);
        String strA = kf0.a(responseHeaders, sh0.R);
        String strA2 = kf0.a(responseHeaders, sh0.S);
        aVar.e(strA);
        aVar.k(strA2);
        aVar.b(kf0.a(responseHeaders, sh0.h));
        String analyticsParametersValue = kf0.a(responseHeaders, sh0.W);
        if (analyticsParametersValue != null) {
            this.i.getClass();
            Intrinsics.checkNotNullParameter(analyticsParametersValue, "analyticsParametersValue");
            HashMap map = new HashMap();
            try {
                JSONObject jSONObject = new JSONObject(analyticsParametersValue);
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    Object obj = jSONObject.get(next);
                    Intrinsics.checkNotNull(next);
                    Intrinsics.checkNotNull(obj);
                    map.put(next, obj);
                }
            } catch (Throwable unused) {
            }
            aVar.a(map);
        }
        zy1 zy1VarR = this.f10806a.r();
        aVar.a(zy1VarR != null ? zy1VarR.a() : null);
        aVar.c(kf0.c(responseHeaders, sh0.i));
        aVar.f(kf0.c(responseHeaders, sh0.r));
        this.j.getClass();
        aVar.a(p8.a(responseHeaders));
        aVar.a(kf0.a(responseHeaders, sh0.u, new kf0.a() { // from class: com.yandex.mobile.ads.impl.zc1$$ExternalSyntheticLambda0
            @Override // com.yandex.mobile.ads.impl.kf0.a
            public final Object a(String str) {
                return zc1.a(str);
            }
        }));
        aVar.d(kf0.a(responseHeaders, sh0.P, new kf0.a() { // from class: com.yandex.mobile.ads.impl.zc1$$ExternalSyntheticLambda1
            @Override // com.yandex.mobile.ads.impl.kf0.a
            public final Object a(String str) {
                return zc1.b(str);
            }
        }));
        aVar.e(kf0.c(responseHeaders, sh0.j));
        sh0 httpHeader = sh0.k;
        Intrinsics.checkNotNullParameter(responseHeaders, "responseHeaders");
        Intrinsics.checkNotNullParameter(httpHeader, "httpHeader");
        String strA3 = kf0.a(responseHeaders, httpHeader);
        int i = oa.b;
        if (strA3 != null) {
            try {
                numValueOf = Integer.valueOf(strA3);
            } catch (NumberFormatException unused2) {
                numValueOf = null;
            }
        } else {
            numValueOf = null;
        }
        aVar.a(numValueOf != null ? Long.valueOf(((long) numValueOf.intValue()) * k) : null);
        sh0 httpHeader2 = sh0.D;
        int i2 = kf0.b;
        Intrinsics.checkNotNullParameter(responseHeaders, "responseHeaders");
        Intrinsics.checkNotNullParameter(httpHeader2, "httpHeader");
        String strA4 = kf0.a(responseHeaders, httpHeader2);
        int i3 = oa.b;
        if (strA4 != null) {
            try {
                numValueOf2 = Integer.valueOf(strA4);
            } catch (NumberFormatException unused3) {
                numValueOf2 = null;
            }
        } else {
            numValueOf2 = null;
        }
        aVar.b(numValueOf2 != null ? Long.valueOf(((long) numValueOf2.intValue()) * k) : null);
        aVar.g(kf0.a(responseHeaders, sh0.p));
        this.h.getClass();
        Intrinsics.checkNotNullParameter(responseHeaders, "headers");
        String strA5 = kf0.a(responseHeaders, sh0.q);
        Locale[] availableLocales = Locale.getAvailableLocales();
        Intrinsics.checkNotNull(availableLocales);
        int length = availableLocales.length;
        int i4 = 0;
        while (true) {
            if (i4 >= length) {
                locale = null;
                break;
            }
            if (Intrinsics.areEqual(availableLocales[i4].getLanguage(), strA5)) {
                locale = new Locale(strA5);
                break;
            }
            i4++;
        }
        aVar.a(locale);
        aVar.b(kf0.c(responseHeaders, sh0.o));
        aVar.f(kf0.b(responseHeaders, sh0.z));
        aVar.c(kf0.b(responseHeaders, sh0.A));
        aVar.d(kf0.b(responseHeaders, sh0.B));
        aVar.a(kf0.b(responseHeaders, sh0.G));
        aVar.l(kf0.a(responseHeaders, sh0.y));
        sh0 httpHeader3 = sh0.m;
        Intrinsics.checkNotNullParameter(responseHeaders, "responseHeaders");
        Intrinsics.checkNotNullParameter(httpHeader3, "httpHeader");
        String strA6 = kf0.a(responseHeaders, httpHeader3);
        aVar.i(strA6 == null ? false : Boolean.parseBoolean(strA6));
        aVar.h(kf0.a(responseHeaders, sh0.Z));
        aVar.j(kf0.a(responseHeaders, sh0.a0));
        aVar.i(kf0.a(responseHeaders, sh0.b0));
        aVar.c(kf0.a(responseHeaders, sh0.H));
        this.f.getClass();
        aVar.a(gs.a(responseHeaders));
        aVar.a(this.e.a(networkResponse));
        this.c.getClass();
        Intrinsics.checkNotNullParameter(networkResponse, "networkResponse");
        Map<String, String> responseHeaders2 = networkResponse.b();
        sh0 header = sh0.w;
        Intrinsics.checkNotNullParameter(responseHeaders2, "responseHeaders");
        Intrinsics.checkNotNullParameter(header, "header");
        String str = (String) CollectionsKt.firstOrNull((List) kf0.c(responseHeaders2, header));
        sh0 httpHeader4 = sh0.x;
        Intrinsics.checkNotNullParameter(responseHeaders2, "responseHeaders");
        Intrinsics.checkNotNullParameter(httpHeader4, "httpHeader");
        String strA7 = kf0.a(responseHeaders2, httpHeader4);
        if (strA7 != null) {
            try {
                lValueOf = Long.valueOf(strA7);
            } catch (NumberFormatException unused4) {
                lValueOf = null;
            }
        } else {
            lValueOf = null;
        }
        aVar.a((str == null || lValueOf == null) ? null : new j80(str, lValueOf.longValue()));
        this.g.getClass();
        Intrinsics.checkNotNullParameter(responseHeaders, "headers");
        String strA8 = kf0.a(responseHeaders, sh0.l);
        aVar.a((strA8 == null || strA8.length() <= 0) ? null : new t4(strA8));
        sh0 httpHeader5 = sh0.I;
        Intrinsics.checkNotNullParameter(responseHeaders, "responseHeaders");
        Intrinsics.checkNotNullParameter(httpHeader5, "httpHeader");
        String strA9 = kf0.a(responseHeaders, httpHeader5);
        aVar.j(strA9 == null ? false : Boolean.parseBoolean(strA9));
        sh0 httpHeader6 = sh0.Q;
        Intrinsics.checkNotNullParameter(responseHeaders, "responseHeaders");
        Intrinsics.checkNotNullParameter(httpHeader6, "httpHeader");
        String strA10 = kf0.a(responseHeaders, httpHeader6);
        aVar.f(strA10 == null ? false : Boolean.parseBoolean(strA10));
        sh0 httpHeader7 = sh0.t;
        Intrinsics.checkNotNullParameter(responseHeaders, "responseHeaders");
        Intrinsics.checkNotNullParameter(httpHeader7, "httpHeader");
        String strA11 = kf0.a(responseHeaders, httpHeader7);
        boolean z = strA11 == null ? false : Boolean.parseBoolean(strA11);
        aVar.e(z);
        if (z) {
            aVar.a(this.d.a(networkResponse));
        } else {
            aVar.a(this.b.a(networkResponse));
        }
        aVar.d(kf0.a(responseHeaders, sh0.T));
        aVar.a(kf0.a(responseHeaders, sh0.g));
        sh0 httpHeader8 = sh0.X;
        Intrinsics.checkNotNullParameter(responseHeaders, "responseHeaders");
        Intrinsics.checkNotNullParameter(httpHeader8, "httpHeader");
        String strA12 = kf0.a(responseHeaders, httpHeader8);
        aVar.c(strA12 == null ? false : Boolean.parseBoolean(strA12));
        String strA13 = kf0.a(responseHeaders, sh0.M);
        aVar.a(strA13 != null ? new ha0(strA13) : null);
        sh0 httpHeader9 = sh0.n;
        Intrinsics.checkNotNullParameter(responseHeaders, "responseHeaders");
        Intrinsics.checkNotNullParameter(httpHeader9, "httpHeader");
        String strA14 = kf0.a(responseHeaders, httpHeader9);
        aVar.h(strA14 == null ? true : Boolean.parseBoolean(strA14));
        sh0 httpHeader10 = sh0.d0;
        Intrinsics.checkNotNullParameter(responseHeaders, "responseHeaders");
        Intrinsics.checkNotNullParameter(httpHeader10, "httpHeader");
        String strA15 = kf0.a(responseHeaders, httpHeader10);
        aVar.g(strA15 != null ? Boolean.parseBoolean(strA15) : false);
        sh0 httpHeader11 = sh0.e0;
        Intrinsics.checkNotNullParameter(responseHeaders, "responseHeaders");
        Intrinsics.checkNotNullParameter(httpHeader11, "httpHeader");
        String strA16 = kf0.a(responseHeaders, httpHeader11);
        aVar.a(strA16 == null ? true : Boolean.parseBoolean(strA16));
        sh0 httpHeader12 = sh0.f0;
        Intrinsics.checkNotNullParameter(responseHeaders, "responseHeaders");
        Intrinsics.checkNotNullParameter(httpHeader12, "httpHeader");
        String strA17 = kf0.a(responseHeaders, httpHeader12);
        aVar.d(strA17 == null ? true : Boolean.parseBoolean(strA17));
        sh0 httpHeader13 = sh0.g0;
        Intrinsics.checkNotNullParameter(responseHeaders, "responseHeaders");
        Intrinsics.checkNotNullParameter(httpHeader13, "httpHeader");
        String strA18 = kf0.a(responseHeaders, httpHeader13);
        aVar.b(strA18 != null ? Boolean.parseBoolean(strA18) : true);
        return aVar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Long a(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        long j = 0L;
        int i = oa.b;
        if (value == null) {
            return j;
        }
        try {
            return Long.valueOf(value);
        } catch (NumberFormatException unused) {
            return j;
        }
    }
}
