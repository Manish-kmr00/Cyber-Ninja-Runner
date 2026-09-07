package com.moloco.sdk.internal.services.bidtoken;

/* JADX INFO: loaded from: classes12.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f6317a;

    public f(boolean z) {
        this.f6317a = z;
    }

    public final boolean a() {
        return this.f6317a;
    }

    public final boolean b() {
        return this.f6317a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof f) && this.f6317a == ((f) obj).f6317a;
    }

    public int hashCode() {
        boolean z = this.f6317a;
        if (z) {
            return 1;
        }
        return z ? 1 : 0;
    }

    public String toString() {
        return "BidTokenConfig(dbtEnabled=" + this.f6317a + ')';
    }

    public final f a(boolean z) {
        return new f(z);
    }

    public static /* synthetic */ f a(f fVar, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = fVar.f6317a;
        }
        return fVar.a(z);
    }
}
