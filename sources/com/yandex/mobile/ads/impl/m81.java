package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class m81 implements vc0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ig1 f9608a;
    private final jz b;
    private k3 c;
    private ul1 d;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ m81(k3 k3Var, y42 y42Var, ul1 ul1Var) {
        this(k3Var, y42Var, ul1Var, ig1.a.a(false), y42Var.d());
        int i = ig1.f9217a;
    }

    public static final void b(m81 m81Var) {
        ul1 ul1Var = m81Var.d;
        if (ul1Var != null) {
            ul1Var.a();
        }
        k3 k3Var = m81Var.c;
        if (k3Var != null) {
            k3Var.b();
        }
    }

    public m81(k3 adCompleteListener, y42 timeProviderContainer, ul1 progressListener, ig1 pausableTimer, jz defaultContentDelayProvider) {
        Intrinsics.checkNotNullParameter(adCompleteListener, "adCompleteListener");
        Intrinsics.checkNotNullParameter(timeProviderContainer, "timeProviderContainer");
        Intrinsics.checkNotNullParameter(progressListener, "progressListener");
        Intrinsics.checkNotNullParameter(pausableTimer, "pausableTimer");
        Intrinsics.checkNotNullParameter(defaultContentDelayProvider, "defaultContentDelayProvider");
        this.f9608a = pausableTimer;
        this.b = defaultContentDelayProvider;
        this.c = adCompleteListener;
        this.d = progressListener;
    }

    @Override // com.yandex.mobile.ads.impl.vc0
    public final void start() {
        a aVar = new a();
        long jA = this.b.a();
        this.f9608a.a(new b(jA));
        this.f9608a.a(jA, aVar);
    }

    @Override // com.yandex.mobile.ads.impl.vc0
    public final void resume() {
        this.f9608a.resume();
    }

    @Override // com.yandex.mobile.ads.impl.vc0
    public final void pause() {
        this.f9608a.pause();
    }

    @Override // com.yandex.mobile.ads.impl.vc0
    public final void invalidate() {
        this.f9608a.invalidate();
        this.f9608a.a(null);
        this.c = null;
        this.d = null;
    }

    private final class a implements kg1 {
        public a() {
        }

        @Override // com.yandex.mobile.ads.impl.kg1
        public final void a() {
            m81.b(m81.this);
        }
    }

    private final class b implements f52 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f9610a;

        public b(long j) {
            this.f9610a = j;
        }

        @Override // com.yandex.mobile.ads.impl.f52
        public final void a(long j, long j2) {
            ul1 ul1Var = m81.this.d;
            if (ul1Var != null) {
                long j3 = this.f9610a;
                ul1Var.a(j3, j3 - j);
            }
        }
    }
}
