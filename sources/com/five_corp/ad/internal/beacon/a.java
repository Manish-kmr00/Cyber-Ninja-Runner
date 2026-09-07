package com.five_corp.ad.internal.beacon;

import com.five_corp.ad.internal.context.l;
import com.five_corp.ad.internal.context.t;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.five_corp.ad.internal.context.i f1319a;
    public final com.five_corp.ad.internal.context.h b;
    public final com.five_corp.ad.internal.ad.a c;
    public final com.five_corp.ad.internal.tracking_data.a d;
    public final int e;
    public final com.five_corp.ad.internal.soundstate.a f;
    public final e g;
    public final long h;
    public final long i;
    public final double j;
    public com.five_corp.ad.internal.ad.beacon.a k;
    public Map l;
    public boolean m;

    public a(l lVar, int i, com.five_corp.ad.internal.soundstate.a aVar, long j, double d) {
        long j2;
        com.five_corp.ad.internal.ad.a aVar2 = lVar.b;
        t tVar = lVar.d;
        com.five_corp.ad.internal.tracking_data.a aVar3 = tVar.d;
        com.five_corp.ad.internal.context.i iVar = tVar.f1370a;
        com.five_corp.ad.internal.context.h hVar = lVar.f;
        e eVar = lVar.i;
        synchronized (lVar) {
            j2 = lVar.k;
        }
        this.d = aVar3;
        this.f1319a = iVar;
        this.b = hVar;
        this.c = aVar2;
        this.e = i;
        this.f = aVar;
        this.g = eVar;
        this.h = j;
        this.i = j2;
        this.j = d;
    }
}
