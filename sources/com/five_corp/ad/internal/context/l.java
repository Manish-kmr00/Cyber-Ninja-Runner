package com.five_corp.ad.internal.context;

import android.os.Looper;

/* JADX INFO: loaded from: classes11.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f1364a;
    public final com.five_corp.ad.internal.ad.a b;
    public final String c;
    public final t d;
    public final com.five_corp.ad.internal.ad.format_config.a e;
    public final h f;
    public final com.five_corp.ad.internal.cache.q g;
    public final com.five_corp.ad.internal.cache.f h;
    public final com.five_corp.ad.internal.beacon.e i;
    public final Looper j;
    public long k = 0;

    public l(j jVar, String str, t tVar, com.five_corp.ad.internal.ad.format_config.a aVar, h hVar, com.five_corp.ad.internal.cache.q qVar, com.five_corp.ad.internal.beacon.e eVar, Looper looper) {
        this.f1364a = jVar;
        this.b = jVar.f1362a;
        this.c = str;
        this.d = tVar;
        this.e = aVar;
        this.f = hVar;
        this.g = qVar;
        this.h = new com.five_corp.ad.internal.cache.f(qVar);
        this.i = eVar;
        this.j = looper;
    }
}
