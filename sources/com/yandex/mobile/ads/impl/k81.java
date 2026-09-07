package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class k81 implements vc0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final xp f9391a;
    private final yp b;
    private final long c;
    private final ig1 d;
    private final a e;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ k81(o8 o8Var, xp xpVar, y42 y42Var) {
        yp ypVarC = y42Var.c();
        long jA = l81.a(o8Var);
        int i = ig1.f9217a;
        this(o8Var, xpVar, y42Var, ypVarC, jA, ig1.a.a(false));
    }

    public static final void a(k81 k81Var) {
        k81Var.f9391a.a();
    }

    public k81(o8<?> adResponse, xp closeShowListener, y42 timeProviderContainer, yp closeTimerProgressIncrementer, long j, ig1 pausableTimer) {
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(closeShowListener, "closeShowListener");
        Intrinsics.checkNotNullParameter(timeProviderContainer, "timeProviderContainer");
        Intrinsics.checkNotNullParameter(closeTimerProgressIncrementer, "closeTimerProgressIncrementer");
        Intrinsics.checkNotNullParameter(pausableTimer, "pausableTimer");
        this.f9391a = closeShowListener;
        this.b = closeTimerProgressIncrementer;
        this.c = j;
        this.d = pausableTimer;
        this.e = new a();
    }

    @Override // com.yandex.mobile.ads.impl.vc0
    public final void start() {
        long jMax = Math.max(0L, this.c - this.b.a());
        this.d.a(this.b);
        this.d.a(jMax, this.e);
    }

    @Override // com.yandex.mobile.ads.impl.vc0
    public final void resume() {
        this.d.resume();
    }

    @Override // com.yandex.mobile.ads.impl.vc0
    public final void pause() {
        this.d.pause();
    }

    @Override // com.yandex.mobile.ads.impl.vc0
    public final void invalidate() {
        this.d.invalidate();
    }

    private final class a implements kg1 {
        public a() {
        }

        @Override // com.yandex.mobile.ads.impl.kg1
        public final void a() {
            k81.a(k81.this);
        }
    }
}
