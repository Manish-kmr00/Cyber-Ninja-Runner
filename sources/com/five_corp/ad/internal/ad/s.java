package com.five_corp.ad.internal.ad;

import java.util.Objects;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes6.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1310a;
    public final String b;
    public final boolean c;
    public final int d;
    public final int e;

    public s(String str, String str2, int i, int i2) {
        this.f1310a = str;
        this.b = str2;
        this.c = str2 != null;
        this.d = i;
        this.e = i2;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return this.f1310a.equals(sVar.f1310a) && Objects.equals(this.b, sVar.b) && this.c == sVar.c && this.d == sVar.d && this.e == sVar.e;
    }

    public final int hashCode() {
        int iHashCode = (this.f1310a.hashCode() + 31) * 31;
        String str = this.b;
        return ((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + (this.c ? 1 : 0)) * 31) + this.d) * 31) + this.e;
    }

    public final String toString() {
        return "Resource{, url='" + this.f1310a + "', isPermanent=" + this.c + ", width=" + this.d + ", height=" + this.e + AbstractJsonLexerKt.END_OBJ;
    }
}
