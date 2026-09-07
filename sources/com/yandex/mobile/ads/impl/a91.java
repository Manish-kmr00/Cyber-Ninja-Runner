package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a91 implements vc0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ul1 f8381a;
    private final ig1 b;
    private final tl1 c;
    private final z1 d;
    private final jz e;

    public a91(ul1 progressListener, y42 timeProviderContainer, ig1 pausableTimer, tl1 progressIncrementer, z1 adBlockDurationProvider, jz defaultContentDelayProvider) {
        Intrinsics.checkNotNullParameter(progressListener, "progressListener");
        Intrinsics.checkNotNullParameter(timeProviderContainer, "timeProviderContainer");
        Intrinsics.checkNotNullParameter(pausableTimer, "pausableTimer");
        Intrinsics.checkNotNullParameter(progressIncrementer, "progressIncrementer");
        Intrinsics.checkNotNullParameter(adBlockDurationProvider, "adBlockDurationProvider");
        Intrinsics.checkNotNullParameter(defaultContentDelayProvider, "defaultContentDelayProvider");
        this.f8381a = progressListener;
        this.b = pausableTimer;
        this.c = progressIncrementer;
        this.d = adBlockDurationProvider;
        this.e = defaultContentDelayProvider;
    }

    @Override // com.yandex.mobile.ads.impl.vc0
    public final void start() {
        a aVar = new a();
        this.b.a(this.e.a(), aVar);
        this.b.a(aVar);
    }

    @Override // com.yandex.mobile.ads.impl.vc0
    public final void resume() {
        this.b.resume();
    }

    @Override // com.yandex.mobile.ads.impl.vc0
    public final void pause() {
        this.b.pause();
    }

    @Override // com.yandex.mobile.ads.impl.vc0
    public final void invalidate() {
        this.b.invalidate();
    }

    private final class a implements kg1, f52 {
        public a() {
        }

        @Override // com.yandex.mobile.ads.impl.kg1
        public final void a() {
            a91.this.f8381a.a();
        }

        @Override // com.yandex.mobile.ads.impl.f52
        public final void a(long j, long j2) {
            long jA = a91.this.c.a() + (a91.this.e.a() - j);
            a91.this.f8381a.a(a91.this.d.a(), jA);
        }
    }
}
