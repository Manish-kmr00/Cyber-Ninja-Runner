package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.jm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4224jm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f11623a;

    public C4224jm(long j) {
        this.f11623a = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && C4224jm.class == obj.getClass() && this.f11623a == ((C4224jm) obj).f11623a;
    }

    public final int hashCode() {
        long j = this.f11623a;
        return (int) (j ^ (j >>> 32));
    }

    public final String toString() {
        return "StatSending{disabledReportingInterval=" + this.f11623a + AbstractJsonLexerKt.END_OBJ;
    }
}
