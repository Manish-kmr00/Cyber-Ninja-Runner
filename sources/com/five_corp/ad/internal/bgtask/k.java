package com.five_corp.ad.internal.bgtask;

/* JADX INFO: loaded from: classes12.dex */
public final class k extends m {
    public final String c;
    public final com.five_corp.ad.internal.http.d d;

    public k(String str, com.five_corp.ad.internal.http.d dVar) {
        super(2);
        this.c = str;
        this.d = dVar;
    }

    @Override // com.five_corp.ad.internal.bgtask.m
    public final boolean b() {
        com.five_corp.ad.internal.util.f fVarA = this.d.a(this.c, "GET", null, null);
        return fVarA.f1560a && ((com.five_corp.ad.internal.http.c) fVarA.c).f1392a == 200;
    }
}
