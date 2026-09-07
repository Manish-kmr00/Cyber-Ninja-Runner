package com.five_corp.ad.internal.ad.beacon;

/* JADX INFO: loaded from: classes10.dex */
public final class j {
    public static final j d = new j(1, 0.5d);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1273a;
    public final double b;
    public final int c;

    public j(int i, double d2) {
        this.f1273a = i;
        this.b = d2;
        this.c = (int) (d2 * 1000000.0d);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return this.f1273a == jVar.f1273a && this.c == jVar.c;
    }

    public final int hashCode() {
        return ((i.a(this.f1273a) + 2969) * 2969) + this.c;
    }
}
