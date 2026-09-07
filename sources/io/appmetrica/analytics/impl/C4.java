package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes13.dex */
public final class C4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f11083a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final Boolean f;

    public C4(A4 a4) {
        this.f11083a = a4.f11052a;
        this.b = a4.b;
        this.c = a4.c;
        this.d = a4.d;
        this.e = a4.e;
        this.f = a4.f;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C4.class != obj.getClass()) {
            return false;
        }
        C4 c4 = (C4) obj;
        if (this.f11083a != c4.f11083a || this.b != c4.b || this.c != c4.c || this.d != c4.d || this.e != c4.e) {
            return false;
        }
        Boolean bool = this.f;
        Boolean bool2 = c4.f;
        if (bool != null) {
            return bool.equals(bool2);
        }
        return bool2 == null;
    }

    public final int hashCode() {
        int i = (((((((((this.f11083a ? 1 : 0) * 31) + (this.b ? 1 : 0)) * 31) + (this.c ? 1 : 0)) * 31) + (this.d ? 1 : 0)) * 31) + (this.e ? 1 : 0)) * 31;
        Boolean bool = this.f;
        return i + (bool != null ? bool.hashCode() : 0);
    }

    public final String toString() {
        return "CollectingFlags{permissionsCollectingEnabled=" + this.f11083a + ", featuresCollectingEnabled=" + this.b + ", googleAid=" + this.c + ", simInfo=" + this.d + ", huaweiOaid=" + this.e + ", sslPinning=" + this.f + AbstractJsonLexerKt.END_OBJ;
    }
}
