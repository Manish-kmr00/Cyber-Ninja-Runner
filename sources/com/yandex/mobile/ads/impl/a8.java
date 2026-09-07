package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final p2 f8377a;

    public a8(p2 adBreak) {
        Intrinsics.checkNotNullParameter(adBreak, "adBreak");
        this.f8377a = adBreak;
    }

    public final t9 a() {
        return this.f8377a.b().a();
    }

    public final String c() {
        return this.f8377a.b().b();
    }

    public final String d() {
        r2 r2VarE = this.f8377a.e();
        if (r2VarE != null) {
            return r2VarE.d();
        }
        return null;
    }

    public final String b() {
        r2 r2VarE = this.f8377a.e();
        if (r2VarE != null) {
            return r2VarE.c();
        }
        return null;
    }

    public final String e() {
        r2 r2VarE = this.f8377a.e();
        if (r2VarE != null) {
            return r2VarE.e();
        }
        return null;
    }
}
