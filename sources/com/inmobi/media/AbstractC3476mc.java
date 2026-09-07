package com.inmobi.media;

import android.util.Base64;
import com.inmobi.commons.core.configs.AdConfig;
import com.inmobi.commons.core.configs.RootConfig;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: renamed from: com.inmobi.media.mc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractC3476mc {
    public static String a(Map map, String str) {
        HashMap map2;
        EnumC3396h6 enumC3396h6 = C3442ka.f3360a;
        M4 m4A = C3442ka.a("getToken", "AB", false);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (map != null) {
            C3531qb.a((String) map.get("tp"));
            C3531qb.b((String) map.get("tp-v"));
        }
        a();
        if (!C3517pb.q()) {
            if (m4A != null) {
                Intrinsics.checkNotNullExpressionValue("com.inmobi.media.mc", "LOG_TAG");
                m4A.b("com.inmobi.media.mc", "InMobi SDK is not initialised. Cannot fetch a token.");
            }
            a(90, jCurrentTimeMillis, m4A);
            return null;
        }
        LinkedHashMap linkedHashMap = C3578u2.f3440a;
        RootConfig rootConfig = (RootConfig) B4.a("root", "null cannot be cast to non-null type com.inmobi.commons.core.configs.RootConfig", null);
        if (rootConfig.getMonetizationDisabled()) {
            a(2012, jCurrentTimeMillis, m4A);
            if (m4A != null) {
                Intrinsics.checkNotNullExpressionValue("com.inmobi.media.mc", "LOG_TAG");
                m4A.b("com.inmobi.media.mc", "Monetization disabled. cannot provide token");
            }
            return null;
        }
        AdConfig adConfig = (AdConfig) B4.a("ads", "null cannot be cast to non-null type com.inmobi.commons.core.configs.AdConfig", null);
        C3490nc c3490nc = new C3490nc(new C3545rc(adConfig.getIncludeIds()), m4A, rootConfig, adConfig);
        c3490nc.C = map;
        c3490nc.B = str;
        HashMap mapHashMapOf = MapsKt.hashMapOf(TuplesKt.to("h-user-agent", C3517pb.k()));
        if (mapHashMapOf != null && (map2 = c3490nc.k) != null) {
            map2.putAll(mapHashMapOf);
        }
        c3490nc.f();
        if (!c3490nc.d) {
            if (m4A != null) {
                Intrinsics.checkNotNullExpressionValue("com.inmobi.media.mc", "LOG_TAG");
                m4A.b("com.inmobi.media.mc", "get Signals failed - GDPR Compliance");
            }
            a(2141, jCurrentTimeMillis, m4A);
            return null;
        }
        a(jCurrentTimeMillis, m4A);
        if (m4A != null) {
            Intrinsics.checkNotNullExpressionValue("com.inmobi.media.mc", "LOG_TAG");
            m4A.a("com.inmobi.media.mc", "get signals success");
        }
        String strC = c3490nc.c();
        Charset charset = Charsets.UTF_8;
        byte[] bytes = strC.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        byte[] bArrEncode = Base64.encode(bytes, 8);
        Intrinsics.checkNotNullExpressionValue(bArrEncode, "encode(...)");
        return new String(bArrEncode, charset);
    }

    public static final void b() {
        HashMap mapHashMapOf = MapsKt.hashMapOf(TuplesKt.to("networkType", C3435k3.q()), TuplesKt.to("plType", "AB"));
        Ob ob = Ob.f3160a;
        Ob.b("AdGetSignalsCalled", mapHashMapOf, Sb.SDK);
    }

    public static void a(final int i, final long j, M4 m4) {
        if (m4 != null) {
            Intrinsics.checkNotNullExpressionValue("com.inmobi.media.mc", "LOG_TAG");
            m4.c("com.inmobi.media.mc", "submitAdGetSignalsFailed - errorCode - " + i + ", startTime - " + j);
        }
        C3517pb.a(new Runnable() { // from class: com.inmobi.media.mc$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                AbstractC3476mc.a(j, i);
            }
        });
        if (m4 != null) {
            m4.a();
        }
    }

    public static final void a(long j, int i) {
        HashMap mapHashMapOf = MapsKt.hashMapOf(TuplesKt.to("latency", Long.valueOf(System.currentTimeMillis() - j)), TuplesKt.to("networkType", C3435k3.q()), TuplesKt.to("errorCode", Integer.valueOf(i)), TuplesKt.to("plType", "AB"));
        Ob ob = Ob.f3160a;
        Ob.b("AdGetSignalsFailed", mapHashMapOf, Sb.SDK);
    }

    public static void a(final long j, M4 m4) {
        if (m4 != null) {
            Intrinsics.checkNotNullExpressionValue("com.inmobi.media.mc", "LOG_TAG");
            m4.c("com.inmobi.media.mc", "submitAdGetSignalsSucceeded - startTime - " + j);
        }
        C3517pb.a(new Runnable() { // from class: com.inmobi.media.mc$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                AbstractC3476mc.a(j);
            }
        });
        if (m4 != null) {
            m4.a();
        }
    }

    public static final void a(long j) {
        HashMap mapHashMapOf = MapsKt.hashMapOf(TuplesKt.to("latency", Long.valueOf(System.currentTimeMillis() - j)), TuplesKt.to("networkType", C3435k3.q()), TuplesKt.to("plType", "AB"));
        Ob ob = Ob.f3160a;
        Ob.b("AdGetSignalsSucceeded", mapHashMapOf, Sb.SDK);
    }

    public static void a() {
        C3517pb.a(new Runnable() { // from class: com.inmobi.media.mc$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AbstractC3476mc.b();
            }
        });
    }
}
