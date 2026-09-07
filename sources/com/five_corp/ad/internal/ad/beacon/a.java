package com.five_corp.ad.internal.ad.beacon;

/* JADX INFO: loaded from: classes10.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1268a;
    public final int b;
    public final long c;
    public final j d;

    public a(int i, int i2, long j, j jVar) {
        this.f1268a = i;
        this.b = i2;
        this.c = j;
        this.d = jVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f1268a == aVar.f1268a && this.b == aVar.b && this.c == aVar.c && this.d.equals(aVar.d);
    }

    public final int hashCode() {
        return this.d.hashCode() + ((((h.a(this.b) + ((c.a(this.f1268a) + 2969) * 2969)) * 2969) + ((int) this.c)) * 2969);
    }
}
