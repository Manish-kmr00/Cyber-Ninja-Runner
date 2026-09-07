package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.SortedSet;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class f00 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g5 f8856a;
    private final va1 b;
    private final pb1 c;
    private final Object d;

    public /* synthetic */ f00(Context context, g5 g5Var) {
        this(context, g5Var, new va1(context), new pb1());
    }

    public f00(Context context, g5 adLoadingPhasesManager, va1 nativeVideoCacheManager, pb1 nativeVideoUrlsProvider) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adLoadingPhasesManager, "adLoadingPhasesManager");
        Intrinsics.checkNotNullParameter(nativeVideoCacheManager, "nativeVideoCacheManager");
        Intrinsics.checkNotNullParameter(nativeVideoUrlsProvider, "nativeVideoUrlsProvider");
        this.f8856a = adLoadingPhasesManager;
        this.b = nativeVideoCacheManager;
        this.c = nativeVideoUrlsProvider;
        this.d = new Object();
    }

    public final void a() {
        synchronized (this.d) {
            this.b.a();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void a(o41 nativeAdBlock, bb1 videoLoadListener, aw debugEventsReporter) {
        Intrinsics.checkNotNullParameter(nativeAdBlock, "nativeAdBlock");
        Intrinsics.checkNotNullParameter(videoLoadListener, "videoLoadListener");
        Intrinsics.checkNotNullParameter(debugEventsReporter, "debugEventsReporter");
        synchronized (this.d) {
            SortedSet<String> sortedSetB = this.c.b(nativeAdBlock.c());
            if (sortedSetB.isEmpty()) {
                videoLoadListener.a();
            } else {
                a videoCacheListener = new a(this.f8856a, sortedSetB.size(), videoLoadListener, debugEventsReporter);
                g5 g5Var = this.f8856a;
                f5 adLoadingPhaseType = f5.r;
                g5Var.getClass();
                Intrinsics.checkNotNullParameter(adLoadingPhaseType, "adLoadingPhaseType");
                g5Var.a(adLoadingPhaseType, null);
                for (String url : sortedSetB) {
                    va1 va1Var = this.b;
                    va1Var.getClass();
                    Intrinsics.checkNotNullParameter(url, "url");
                    Intrinsics.checkNotNullParameter(videoCacheListener, "videoCacheListener");
                    va1Var.a(url, videoCacheListener, String.valueOf(ti0.a()));
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private static final class a implements wd2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final g5 f8857a;
        private final oe2 b;
        private final aw c;
        private final AtomicInteger d;

        public a(g5 adLoadingPhasesManager, int i, bb1 videoLoadListener, aw debugEventsReporter) {
            Intrinsics.checkNotNullParameter(adLoadingPhasesManager, "adLoadingPhasesManager");
            Intrinsics.checkNotNullParameter(videoLoadListener, "videoLoadListener");
            Intrinsics.checkNotNullParameter(debugEventsReporter, "debugEventsReporter");
            this.f8857a = adLoadingPhasesManager;
            this.b = videoLoadListener;
            this.c = debugEventsReporter;
            this.d = new AtomicInteger(i);
        }

        @Override // com.yandex.mobile.ads.impl.wd2
        public final void c() {
        }

        @Override // com.yandex.mobile.ads.impl.wd2
        public final void a() {
            if (this.d.decrementAndGet() == 0) {
                this.f8857a.a(f5.r);
                this.b.a();
            }
        }

        @Override // com.yandex.mobile.ads.impl.wd2
        public final void b() {
            if (this.d.getAndSet(0) > 0) {
                this.f8857a.a(f5.r);
                this.c.a(zv.f);
                this.b.a();
            }
        }
    }
}
