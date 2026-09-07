package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.x3, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4554x3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f11839a;

    public C4554x3(long j) {
        this.f11839a = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && C4554x3.class == obj.getClass() && this.f11839a == ((C4554x3) obj).f11839a;
    }

    public final int hashCode() {
        long j = this.f11839a;
        return (int) (j ^ (j >>> 32));
    }

    public final String toString() {
        return "CacheControl{lastKnownLocationTtl=" + this.f11839a + AbstractJsonLexerKt.END_OBJ;
    }
}
