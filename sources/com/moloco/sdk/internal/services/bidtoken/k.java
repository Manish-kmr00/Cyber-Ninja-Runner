package com.moloco.sdk.internal.services.bidtoken;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6322a;
    public final String b;
    public final f c;

    public k(String bidToken, String publicKey, f bidTokenConfig) {
        Intrinsics.checkNotNullParameter(bidToken, "bidToken");
        Intrinsics.checkNotNullParameter(publicKey, "publicKey");
        Intrinsics.checkNotNullParameter(bidTokenConfig, "bidTokenConfig");
        this.f6322a = bidToken;
        this.b = publicKey;
        this.c = bidTokenConfig;
    }

    public final String a() {
        return this.f6322a;
    }

    public final String b() {
        return this.b;
    }

    public final f c() {
        return this.c;
    }

    public final String d() {
        return this.f6322a;
    }

    public final f e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return Intrinsics.areEqual(this.f6322a, kVar.f6322a) && Intrinsics.areEqual(this.b, kVar.b) && Intrinsics.areEqual(this.c, kVar.c);
    }

    public final String f() {
        return this.b;
    }

    public int hashCode() {
        return (((this.f6322a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "BidTokenResponseComponents(bidToken=" + this.f6322a + ", publicKey=" + this.b + ", bidTokenConfig=" + this.c + ')';
    }

    public final k a(String bidToken, String publicKey, f bidTokenConfig) {
        Intrinsics.checkNotNullParameter(bidToken, "bidToken");
        Intrinsics.checkNotNullParameter(publicKey, "publicKey");
        Intrinsics.checkNotNullParameter(bidTokenConfig, "bidTokenConfig");
        return new k(bidToken, publicKey, bidTokenConfig);
    }

    public static /* synthetic */ k a(k kVar, String str, String str2, f fVar, int i, Object obj) {
        if ((i & 1) != 0) {
            str = kVar.f6322a;
        }
        if ((i & 2) != 0) {
            str2 = kVar.b;
        }
        if ((i & 4) != 0) {
            fVar = kVar.c;
        }
        return kVar.a(str, str2, fVar);
    }
}
