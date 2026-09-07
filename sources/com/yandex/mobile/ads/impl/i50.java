package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class i50 {
    private static final i50 c = new i50(1, "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCznqFqHos01bT613or9cQ8OWXEB0nvx8UZ//V75T+fb1IDn1/lPBwGY/OK5RfQYuqeIKoKasqfwtRo3sr8dJ+SDm29Brh3lV9r+apohla+GIAyYd5wcJugMfVH5z9SBxh19ukg+GiIvvDpmgi0M8gNVo6Nk21tkEgFxc9FfdT/HwIDAQAB");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9176a;
    private final int b;

    public final String b() {
        return this.f9176a;
    }

    public final int c() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i50)) {
            return false;
        }
        i50 i50Var = (i50) obj;
        return Intrinsics.areEqual(this.f9176a, i50Var.f9176a) && this.b == i50Var.b;
    }

    public final int hashCode() {
        return Integer.hashCode(this.b) + (this.f9176a.hashCode() * 31);
    }

    public final String toString() {
        return "EncryptionParameters(publicKey=" + this.f9176a + ", version=" + this.b + ")";
    }

    public i50(int i, String publicKey) {
        Intrinsics.checkNotNullParameter(publicKey, "publicKey");
        this.f9176a = publicKey;
        this.b = i;
    }

    public final String d() {
        return this.f9176a;
    }

    public final int e() {
        return this.b;
    }
}
