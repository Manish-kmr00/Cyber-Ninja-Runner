package com.yandex.mobile.ads.impl;

import com.monetization.ads.core.utils.CallbackStackTraceMarker;
import com.yandex.mobile.ads.video.playback.VideoAdPlaybackListener;
import com.yandex.mobile.ads.video.playback.model.VideoAd;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes7.dex */
public final class in2 implements io0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final VideoAdPlaybackListener f9249a;
    private final dm2 b;

    static final class a extends Lambda implements Function0<Unit> {
        final /* synthetic */ VideoAd c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(VideoAd videoAd) {
            super(0);
            this.c = videoAd;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            in2.this.f9249a.onAdClicked(this.c);
            return Unit.INSTANCE;
        }
    }

    static final class b extends Lambda implements Function0<Unit> {
        final /* synthetic */ VideoAd c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(VideoAd videoAd) {
            super(0);
            this.c = videoAd;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            in2.this.f9249a.onAdCompleted(this.c);
            return Unit.INSTANCE;
        }
    }

    static final class c extends Lambda implements Function0<Unit> {
        final /* synthetic */ VideoAd c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(VideoAd videoAd) {
            super(0);
            this.c = videoAd;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            in2.this.f9249a.onAdError(this.c);
            return Unit.INSTANCE;
        }
    }

    static final class d extends Lambda implements Function0<Unit> {
        final /* synthetic */ VideoAd c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(VideoAd videoAd) {
            super(0);
            this.c = videoAd;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            in2.this.f9249a.onAdPaused(this.c);
            return Unit.INSTANCE;
        }
    }

    static final class e extends Lambda implements Function0<Unit> {
        final /* synthetic */ VideoAd c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(VideoAd videoAd) {
            super(0);
            this.c = videoAd;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            in2.this.f9249a.onAdPrepared(this.c);
            return Unit.INSTANCE;
        }
    }

    static final class f extends Lambda implements Function0<Unit> {
        final /* synthetic */ VideoAd c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(VideoAd videoAd) {
            super(0);
            this.c = videoAd;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            in2.this.f9249a.onAdResumed(this.c);
            return Unit.INSTANCE;
        }
    }

    static final class g extends Lambda implements Function0<Unit> {
        final /* synthetic */ VideoAd c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(VideoAd videoAd) {
            super(0);
            this.c = videoAd;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            in2.this.f9249a.onAdSkipped(this.c);
            return Unit.INSTANCE;
        }
    }

    static final class h extends Lambda implements Function0<Unit> {
        final /* synthetic */ VideoAd c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(VideoAd videoAd) {
            super(0);
            this.c = videoAd;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            in2.this.f9249a.onAdStarted(this.c);
            return Unit.INSTANCE;
        }
    }

    static final class i extends Lambda implements Function0<Unit> {
        final /* synthetic */ VideoAd c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(VideoAd videoAd) {
            super(0);
            this.c = videoAd;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            in2.this.f9249a.onAdStopped(this.c);
            return Unit.INSTANCE;
        }
    }

    static final class j extends Lambda implements Function0<Unit> {
        final /* synthetic */ VideoAd c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(VideoAd videoAd) {
            super(0);
            this.c = videoAd;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            in2.this.f9249a.onImpression(this.c);
            return Unit.INSTANCE;
        }
    }

    static final class k extends Lambda implements Function0<Unit> {
        final /* synthetic */ VideoAd c;
        final /* synthetic */ float d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(VideoAd videoAd, float f) {
            super(0);
            this.c = videoAd;
            this.d = f;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            in2.this.f9249a.onVolumeChanged(this.c, this.d);
            return Unit.INSTANCE;
        }
    }

    public in2(VideoAdPlaybackListener videoAdPlaybackListener, dm2 videoAdAdapterCache) {
        Intrinsics.checkNotNullParameter(videoAdPlaybackListener, "videoAdPlaybackListener");
        Intrinsics.checkNotNullParameter(videoAdAdapterCache, "videoAdAdapterCache");
        this.f9249a = videoAdPlaybackListener;
        this.b = videoAdAdapterCache;
    }

    @Override // com.yandex.mobile.ads.impl.io0
    public final void b(do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        new CallbackStackTraceMarker(new e(this.b.a(videoAd)));
    }

    @Override // com.yandex.mobile.ads.impl.io0
    public final void c(do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        new CallbackStackTraceMarker(new d(this.b.a(videoAd)));
    }

    @Override // com.yandex.mobile.ads.impl.io0
    public final void d(do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        new CallbackStackTraceMarker(new h(this.b.a(videoAd)));
    }

    @Override // com.yandex.mobile.ads.impl.io0
    public final void e(do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        new CallbackStackTraceMarker(new f(this.b.a(videoAd)));
    }

    @Override // com.yandex.mobile.ads.impl.io0
    public final void f(do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        new CallbackStackTraceMarker(new i(this.b.a(videoAd)));
    }

    @Override // com.yandex.mobile.ads.impl.io0
    public final void g(do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        new CallbackStackTraceMarker(new b(this.b.a(videoAd)));
    }

    @Override // com.yandex.mobile.ads.impl.io0
    public final void h(do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        new CallbackStackTraceMarker(new c(this.b.a(videoAd)));
    }

    @Override // com.yandex.mobile.ads.impl.io0
    public final void i(do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        new CallbackStackTraceMarker(new a(this.b.a(videoAd)));
    }

    @Override // com.yandex.mobile.ads.impl.io0
    public final void j(do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        new CallbackStackTraceMarker(new j(this.b.a(videoAd)));
    }

    @Override // com.yandex.mobile.ads.impl.io0
    public final void a(do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        new CallbackStackTraceMarker(new g(this.b.a(videoAd)));
    }

    @Override // com.yandex.mobile.ads.impl.io0
    public final void a(do0 videoAd, float f2) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        new CallbackStackTraceMarker(new k(this.b.a(videoAd), f2));
    }
}
