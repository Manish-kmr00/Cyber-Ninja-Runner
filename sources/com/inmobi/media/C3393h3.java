package com.inmobi.media;

/* JADX INFO: renamed from: com.inmobi.media.h3, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C3393h3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f3330a;
    public final long b;
    public final long c;

    public C3393h3(long j, long j2, long j3) {
        this.f3330a = j;
        this.b = j2;
        this.c = j3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3393h3)) {
            return false;
        }
        C3393h3 c3393h3 = (C3393h3) obj;
        return this.f3330a == c3393h3.f3330a && this.b == c3393h3.b && this.c == c3393h3.c;
    }

    public final int hashCode() {
        return Long.hashCode(this.c) + ((Long.hashCode(this.b) + (Long.hashCode(this.f3330a) * 31)) * 31);
    }

    public final String toString() {
        return "DeviceMemoryInfo(maxHeapSize=" + this.f3330a + ", freeHeapSize=" + this.b + ", currentHeapSize=" + this.c + ')';
    }
}
