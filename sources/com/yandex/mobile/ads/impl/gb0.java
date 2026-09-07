package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class gb0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g5 f8983a;
    private final va1 b;
    private final pb1 c;
    private final Object d;

    public /* synthetic */ gb0(Context context, g5 g5Var) {
        this(context, g5Var, new va1(context), new pb1());
    }

    public gb0(Context context, g5 adLoadingPhasesManager, va1 nativeVideoCacheManager, pb1 nativeVideoUrlsProvider) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adLoadingPhasesManager, "adLoadingPhasesManager");
        Intrinsics.checkNotNullParameter(nativeVideoCacheManager, "nativeVideoCacheManager");
        Intrinsics.checkNotNullParameter(nativeVideoUrlsProvider, "nativeVideoUrlsProvider");
        this.f8983a = adLoadingPhasesManager;
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
            List<Pair<String, String>> listA = this.c.a(nativeAdBlock.c());
            if (listA.isEmpty()) {
                videoLoadListener.a();
            } else {
                a aVar = new a(this.f8983a, videoLoadListener, this.b, CollectionsKt.drop(listA, 1).iterator(), debugEventsReporter);
                g5 g5Var = this.f8983a;
                f5 adLoadingPhaseType = f5.r;
                g5Var.getClass();
                Intrinsics.checkNotNullParameter(adLoadingPhaseType, "adLoadingPhaseType");
                g5Var.a(adLoadingPhaseType, null);
                Pair pair = (Pair) CollectionsKt.first((List) listA);
                this.b.a((String) pair.component1(), aVar, (String) pair.component2());
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private static final class a implements wd2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final g5 f8984a;
        private final oe2 b;
        private final b c;

        public a(g5 adLoadingPhasesManager, bb1 videoLoadListener, va1 nativeVideoCacheManager, Iterator urlToRequests, aw debugEventsReporter) {
            Intrinsics.checkNotNullParameter(adLoadingPhasesManager, "adLoadingPhasesManager");
            Intrinsics.checkNotNullParameter(videoLoadListener, "videoLoadListener");
            Intrinsics.checkNotNullParameter(nativeVideoCacheManager, "nativeVideoCacheManager");
            Intrinsics.checkNotNullParameter(urlToRequests, "urlToRequests");
            Intrinsics.checkNotNullParameter(debugEventsReporter, "debugEventsReporter");
            this.f8984a = adLoadingPhasesManager;
            this.b = videoLoadListener;
            this.c = new b(adLoadingPhasesManager, videoLoadListener, nativeVideoCacheManager, urlToRequests, debugEventsReporter);
        }

        @Override // com.yandex.mobile.ads.impl.wd2
        public final void c() {
        }

        @Override // com.yandex.mobile.ads.impl.wd2
        public final void a() {
            this.f8984a.a(f5.r);
            this.b.a();
            this.c.a();
        }

        @Override // com.yandex.mobile.ads.impl.wd2
        public final void b() {
            this.f8984a.a(f5.r);
            this.b.a();
            this.c.b();
        }
    }

    private static final class b implements wd2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final g5 f8985a;
        private final oe2 b;
        private final va1 c;
        private final Iterator<Pair<String, String>> d;
        private final aw e;

        public b(g5 adLoadingPhasesManager, oe2 videoLoadListener, va1 nativeVideoCacheManager, Iterator<Pair<String, String>> urlToRequests, aw debugEventsReporter) {
            Intrinsics.checkNotNullParameter(adLoadingPhasesManager, "adLoadingPhasesManager");
            Intrinsics.checkNotNullParameter(videoLoadListener, "videoLoadListener");
            Intrinsics.checkNotNullParameter(nativeVideoCacheManager, "nativeVideoCacheManager");
            Intrinsics.checkNotNullParameter(urlToRequests, "urlToRequests");
            Intrinsics.checkNotNullParameter(debugEventsReporter, "debugEventsReporter");
            this.f8985a = adLoadingPhasesManager;
            this.b = videoLoadListener;
            this.c = nativeVideoCacheManager;
            this.d = urlToRequests;
            this.e = debugEventsReporter;
        }

        @Override // com.yandex.mobile.ads.impl.wd2
        public final void a() {
            if (this.d.hasNext()) {
                Pair<String, String> next = this.d.next();
                String strComponent1 = next.component1();
                String strComponent2 = next.component2();
                this.c.a(strComponent1, new b(this.f8985a, this.b, this.c, this.d, this.e), strComponent2);
            }
        }

        @Override // com.yandex.mobile.ads.impl.wd2
        public final void b() {
            this.e.a(zv.f);
        }

        @Override // com.yandex.mobile.ads.impl.wd2
        public final void c() {
            a();
        }
    }

    public final void a(String requestId) {
        Intrinsics.checkNotNullParameter(requestId, "requestId");
        synchronized (this.d) {
            this.b.a(requestId);
            Unit unit = Unit.INSTANCE;
        }
    }
}
