package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.cg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes7.dex */
public final class C4044cg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11496a;
    public final long b;
    public final long c;
    public final EnumC4019bg d;

    public C4044cg(byte[] bArr) throws InvalidProtocolBufferNanoException {
        C4069dg c4069dgA = C4069dg.a(bArr);
        this.f11496a = c4069dgA.f11515a;
        this.b = c4069dgA.c;
        this.c = c4069dgA.b;
        this.d = a(c4069dgA.d);
    }

    public final byte[] a() {
        C4069dg c4069dg = new C4069dg();
        c4069dg.f11515a = this.f11496a;
        c4069dg.c = this.b;
        c4069dg.b = this.c;
        int iOrdinal = this.d.ordinal();
        int i = 1;
        if (iOrdinal != 1) {
            i = 2;
            if (iOrdinal != 2) {
                i = 0;
            }
        }
        c4069dg.d = i;
        return MessageNano.toByteArray(c4069dg);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C4044cg.class != obj.getClass()) {
            return false;
        }
        C4044cg c4044cg = (C4044cg) obj;
        return this.b == c4044cg.b && this.c == c4044cg.c && this.f11496a.equals(c4044cg.f11496a) && this.d == c4044cg.d;
    }

    public final int hashCode() {
        int iHashCode = this.f11496a.hashCode() * 31;
        long j = this.b;
        int i = (iHashCode + ((int) (j ^ (j >>> 32)))) * 31;
        long j2 = this.c;
        return this.d.hashCode() + ((i + ((int) (j2 ^ (j2 >>> 32)))) * 31);
    }

    public final String toString() {
        return "ReferrerInfo{installReferrer='" + this.f11496a + "', referrerClickTimestampSeconds=" + this.b + ", installBeginTimestampSeconds=" + this.c + ", source=" + this.d + AbstractJsonLexerKt.END_OBJ;
    }

    public C4044cg(String str, long j, long j2, EnumC4019bg enumC4019bg) {
        this.f11496a = str;
        this.b = j;
        this.c = j2;
        this.d = enumC4019bg;
    }

    public static EnumC4019bg a(int i) {
        if (i == 1) {
            return EnumC4019bg.c;
        }
        if (i != 2) {
            return EnumC4019bg.b;
        }
        return EnumC4019bg.d;
    }
}
