package com.five_corp.ad.internal.movie.partialcache.mediacodec;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1484a;
    public final ByteBuffer b;

    public a(int i, ByteBuffer byteBuffer) {
        this.f1484a = i;
        this.b = byteBuffer;
    }

    public final boolean equals(Object obj) {
        return obj != null && (obj instanceof a) && this.f1484a == ((a) obj).f1484a;
    }

    public final int hashCode() {
        return this.f1484a;
    }
}
