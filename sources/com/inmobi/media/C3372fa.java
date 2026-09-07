package com.inmobi.media;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.fa, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C3372fa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte f3316a;
    public final String b;

    public C3372fa(byte b, String assetUrl) {
        Intrinsics.checkNotNullParameter(assetUrl, "assetUrl");
        this.f3316a = b;
        this.b = assetUrl;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3372fa)) {
            return false;
        }
        C3372fa c3372fa = (C3372fa) obj;
        return this.f3316a == c3372fa.f3316a && Intrinsics.areEqual(this.b, c3372fa.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (Byte.hashCode(this.f3316a) * 31);
    }

    public final String toString() {
        return "RawAsset(mRawAssetType=" + ((int) this.f3316a) + ", assetUrl=" + this.b + ')';
    }
}
