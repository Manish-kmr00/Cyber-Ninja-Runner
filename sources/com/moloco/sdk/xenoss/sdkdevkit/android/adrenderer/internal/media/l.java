package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media;

/* JADX INFO: loaded from: classes10.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6604a;
    public final boolean b;
    public final double c;
    public final int d;

    public l(int i, boolean z, double d, int i2) {
        this.f6604a = i;
        this.b = z;
        this.c = d;
        this.d = i2;
    }

    public final int a() {
        return this.f6604a;
    }

    public final boolean b() {
        return this.b;
    }

    public final double c() {
        return this.c;
    }

    public final int d() {
        return this.d;
    }

    public final int e() {
        return this.f6604a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return this.f6604a == lVar.f6604a && this.b == lVar.b && Double.compare(this.c, lVar.c) == 0 && this.d == lVar.d;
    }

    public final int f() {
        return this.d;
    }

    public final double g() {
        return this.c;
    }

    public final boolean h() {
        return this.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public int hashCode() {
        int iHashCode = Integer.hashCode(this.f6604a) * 31;
        boolean z = this.b;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return ((((iHashCode + r1) * 31) + Double.hashCode(this.c)) * 31) + Integer.hashCode(this.d);
    }

    public String toString() {
        return "MediaConfig(chunkSize=" + this.f6604a + ", isStreamingEnabled=" + this.b + ", minStreamingPlayableDurationOnTimeoutSecs=" + this.c + ", mediaCacheDiskCleanUpLimit=" + this.d + ')';
    }

    public final l a(int i, boolean z, double d, int i2) {
        return new l(i, z, d, i2);
    }

    public static /* synthetic */ l a(l lVar, int i, boolean z, double d, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = lVar.f6604a;
        }
        if ((i3 & 2) != 0) {
            z = lVar.b;
        }
        boolean z2 = z;
        if ((i3 & 4) != 0) {
            d = lVar.c;
        }
        double d2 = d;
        if ((i3 & 8) != 0) {
            i2 = lVar.d;
        }
        return lVar.a(i, z2, d2, i2);
    }
}
