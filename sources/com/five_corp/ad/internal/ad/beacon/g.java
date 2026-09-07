package com.five_corp.ad.internal.ad.beacon;

/* JADX INFO: loaded from: classes10.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1272a;
    public final String b;

    public g(String str, String str2) {
        this.f1272a = str;
        this.b = str2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.f1272a.equals(gVar.f1272a) && this.b.equals(gVar.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.f1272a.hashCode() * 31);
    }
}
