package com.inmobi.media;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.p2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C3508p2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3396a;
    public final String b;

    public C3508p2(String url, String accountId) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(accountId, "accountId");
        this.f3396a = url;
        this.b = accountId;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3508p2)) {
            return false;
        }
        C3508p2 c3508p2 = (C3508p2) obj;
        return Intrinsics.areEqual(this.f3396a, c3508p2.f3396a) && Intrinsics.areEqual(this.b, c3508p2.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.f3396a.hashCode() * 31);
    }

    public final String toString() {
        return "ConfigIdentifier(url=" + this.f3396a + ", accountId=" + this.b + ')';
    }
}
