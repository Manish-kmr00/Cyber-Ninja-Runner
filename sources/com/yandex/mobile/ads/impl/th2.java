package com.yandex.mobile.ads.impl;

import android.os.SystemClock;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class th2<T> implements uc2, wc2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final rb2<T> f10303a;
    private final id2 b;
    private final eg2 c;
    private final hc2<T> d;
    private final ld2 e;
    private Long f;
    private boolean g;

    public /* synthetic */ th2(rb2 rb2Var, kg2 kg2Var, id2 id2Var, fg2 fg2Var, hc2 hc2Var) {
        this(rb2Var, kg2Var, id2Var, fg2Var, hc2Var, new mg2(kg2Var));
    }

    public th2(rb2 videoAdInfo, kg2 videoViewProvider, id2 videoAdStatusController, fg2 videoTracker, hc2 videoAdPlaybackEventsListener, ld2 videoAdVisibilityValidator) {
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        Intrinsics.checkNotNullParameter(videoViewProvider, "videoViewProvider");
        Intrinsics.checkNotNullParameter(videoAdStatusController, "videoAdStatusController");
        Intrinsics.checkNotNullParameter(videoTracker, "videoTracker");
        Intrinsics.checkNotNullParameter(videoAdPlaybackEventsListener, "videoAdPlaybackEventsListener");
        Intrinsics.checkNotNullParameter(videoAdVisibilityValidator, "videoAdVisibilityValidator");
        this.f10303a = videoAdInfo;
        this.b = videoAdStatusController;
        this.c = videoTracker;
        this.d = videoAdPlaybackEventsListener;
        this.e = videoAdVisibilityValidator;
    }

    @Override // com.yandex.mobile.ads.impl.uc2
    public final void a(long j, long j2) {
        if (this.g) {
            return;
        }
        Unit unit = null;
        if (this.e.a() && this.b.a() == hd2.e) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            Long l = this.f;
            if (l != null) {
                if (jElapsedRealtime - l.longValue() >= 2000) {
                    this.g = true;
                    this.d.k(this.f10303a);
                    this.c.n();
                }
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                this.f = Long.valueOf(jElapsedRealtime);
                this.d.l(this.f10303a);
                return;
            }
            return;
        }
        this.f = null;
    }

    @Override // com.yandex.mobile.ads.impl.wc2
    public final void b() {
        this.f = null;
    }

    @Override // com.yandex.mobile.ads.impl.wc2
    public final void a() {
        this.f = null;
    }
}
