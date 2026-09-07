package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class w9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f10544a;
    private final String b;
    private final String c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w9)) {
            return false;
        }
        w9 w9Var = (w9) obj;
        return this.f10544a == w9Var.f10544a && Intrinsics.areEqual(this.b, w9Var.b) && Intrinsics.areEqual(this.c, w9Var.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + v3.a(this.b, Boolean.hashCode(this.f10544a) * 31, 31);
    }

    public final String toString() {
        return "AdTuneInfo(shouldShow=" + this.f10544a + ", token=" + this.b + ", advertiserInfo=" + this.c + ")";
    }

    public w9(String token, String advertiserInfo, boolean z) {
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(advertiserInfo, "advertiserInfo");
        this.f10544a = z;
        this.b = token;
        this.c = advertiserInfo;
    }

    public final boolean b() {
        return this.f10544a;
    }

    public final String c() {
        return this.b;
    }

    public final String a() {
        return this.c;
    }
}
