package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class fn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final op1 f8911a;
    private final oq1 b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final op1 f8912a;

        public a(long j, op1 request) {
            Intrinsics.checkNotNullParameter(request, "request");
            this.f8912a = request;
        }

        public final fn a() {
            fn fnVar = new fn(this.f8912a, null);
            return (fnVar.b() == null || !this.f8912a.b().a()) ? fnVar : new fn(null, null);
        }
    }

    public fn(op1 op1Var, oq1 oq1Var) {
        this.f8911a = op1Var;
        this.b = oq1Var;
    }

    public final op1 b() {
        return this.f8911a;
    }

    public final oq1 a() {
        return this.b;
    }
}
