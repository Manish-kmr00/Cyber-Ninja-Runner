package com.five_corp.ad.internal.ad;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes6.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1274a;
    public final int b;
    public final int c;

    public c(int i, int i2, int i3) {
        this.f1274a = i;
        this.b = i2;
        this.c = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        return this.f1274a == cVar.f1274a && this.b == cVar.b && this.c == cVar.c;
    }

    public final int hashCode() {
        return (((this.f1274a * 31) + this.b) * 31) + this.c;
    }

    public final String toString() {
        return "CcId{campaignId=" + this.f1274a + ", campaignVersion=" + this.b + ", creativeId=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }
}
