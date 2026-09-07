package com.applovin.impl;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public abstract class j2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f450a;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(com.applovin.impl.sdk.k kVar) {
        if (f450a) {
            return;
        }
        kVar.E().a(c2.E0, "no_ads_loaded");
    }

    public static void b(final com.applovin.impl.sdk.k kVar) {
        Long l = (Long) kVar.a(o3.d8);
        if (l.longValue() <= 0) {
            return;
        }
        kVar.r0().a(new p6(kVar, true, "submitIntegrationErrorReport", new Runnable() { // from class: com.applovin.impl.j2$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                j2.a(kVar);
            }
        }), b6.b.OTHER, TimeUnit.SECONDS.toMillis(l.longValue()));
    }

    public static void a() {
        f450a = true;
    }
}
