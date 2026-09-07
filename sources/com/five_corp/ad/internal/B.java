package com.five_corp.ad.internal;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes11.dex */
public final class B implements com.five_corp.ad.internal.hub.c, com.five_corp.ad.internal.hub.b {
    public static final /* synthetic */ int g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z f1262a;
    public final com.five_corp.ad.internal.http.d b;
    public final com.five_corp.ad.internal.bgtask.b c;
    public final com.five_corp.ad.internal.bgtask.b d;
    public final com.five_corp.ad.internal.hub.a e;
    public Set f = Collections.emptySet();

    static {
        B.class.toString();
    }

    public B(z zVar, com.five_corp.ad.internal.http.d dVar, com.five_corp.ad.internal.bgtask.b bVar, com.five_corp.ad.internal.bgtask.b bVar2, com.five_corp.ad.internal.hub.a aVar) {
        this.f1262a = zVar;
        this.b = dVar;
        this.c = bVar;
        this.d = bVar2;
        this.e = aVar;
    }

    @Override // com.five_corp.ad.internal.hub.c
    public final void a(com.five_corp.ad.internal.cache.x xVar) {
        if (xVar.b != null) {
            HashSet hashSet = new HashSet();
            this.f = hashSet;
            hashSet.addAll(xVar.b.h);
        }
    }

    public final void a(com.five_corp.ad.internal.beacon.a aVar) {
        this.c.a(new com.five_corp.ad.internal.bgtask.i(aVar, this.f1262a, this.b));
    }
}
