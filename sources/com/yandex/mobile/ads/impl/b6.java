package com.yandex.mobile.ads.impl;

import com.google.android.exoplayer2.util.Assertions;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final z5 f8477a;
    private final r9 b;
    private final a5 c;
    private final ri1 d;
    private final fi1 e;
    private final w5 f;
    private final xn0 g;

    public b6(p9 adStateDataController, pi1 playerStateController, z5 adPlayerEventsController, r9 adStateHolder, a5 adInfoStorage, ri1 playerStateHolder, fi1 playerAdPlaybackController, w5 adPlayerDiscardController, xn0 instreamSettings) {
        Intrinsics.checkNotNullParameter(adStateDataController, "adStateDataController");
        Intrinsics.checkNotNullParameter(playerStateController, "playerStateController");
        Intrinsics.checkNotNullParameter(adPlayerEventsController, "adPlayerEventsController");
        Intrinsics.checkNotNullParameter(adStateHolder, "adStateHolder");
        Intrinsics.checkNotNullParameter(adInfoStorage, "adInfoStorage");
        Intrinsics.checkNotNullParameter(playerStateHolder, "playerStateHolder");
        Intrinsics.checkNotNullParameter(playerAdPlaybackController, "playerAdPlaybackController");
        Intrinsics.checkNotNullParameter(adPlayerDiscardController, "adPlayerDiscardController");
        Intrinsics.checkNotNullParameter(instreamSettings, "instreamSettings");
        this.f8477a = adPlayerEventsController;
        this.b = adStateHolder;
        this.c = adInfoStorage;
        this.d = playerStateHolder;
        this.e = playerAdPlaybackController;
        this.f = adPlayerDiscardController;
        this.g = instreamSettings;
    }

    public final void a(do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        if (tm0.d == this.b.a(videoAd)) {
            this.b.a(videoAd, tm0.e);
            yi1 yi1VarC = this.b.c();
            Assertions.checkState(Intrinsics.areEqual(videoAd, yi1VarC != null ? yi1VarC.d() : null));
            this.d.a(false);
            this.e.a();
            this.f8477a.c(videoAd);
        }
    }

    public final void b(do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        tm0 tm0VarA = this.b.a(videoAd);
        if (tm0.b == tm0VarA || tm0.c == tm0VarA) {
            this.b.a(videoAd, tm0.d);
            Object objCheckNotNull = Assertions.checkNotNull(this.c.a(videoAd));
            Intrinsics.checkNotNullExpressionValue(objCheckNotNull, "checkNotNull(...)");
            this.b.a(new yi1((v4) objCheckNotNull, videoAd));
            this.f8477a.d(videoAd);
            return;
        }
        if (tm0.e == tm0VarA) {
            yi1 yi1VarC = this.b.c();
            Assertions.checkState(Intrinsics.areEqual(videoAd, yi1VarC != null ? yi1VarC.d() : null));
            this.b.a(videoAd, tm0.d);
            this.f8477a.e(videoAd);
        }
    }

    public final void c(do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        if (tm0.e == this.b.a(videoAd)) {
            this.b.a(videoAd, tm0.d);
            yi1 yi1VarC = this.b.c();
            Assertions.checkState(Intrinsics.areEqual(videoAd, yi1VarC != null ? yi1VarC.d() : null));
            this.d.a(true);
            this.e.b();
            this.f8477a.e(videoAd);
        }
    }

    public final void d(final do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        w5.b bVar = this.g.f() ? w5.b.c : w5.b.b;
        w5.a aVar = new w5.a() { // from class: com.yandex.mobile.ads.impl.b6$$ExternalSyntheticLambda1
            @Override // com.yandex.mobile.ads.impl.w5.a
            public final void a() {
                b6.a(this.f$0, videoAd);
            }
        };
        tm0 tm0VarA = this.b.a(videoAd);
        tm0 tm0Var = tm0.b;
        if (tm0Var == tm0VarA) {
            v4 v4VarA = this.c.a(videoAd);
            if (v4VarA != null) {
                this.f.a(v4VarA, bVar, aVar);
                return;
            }
            return;
        }
        this.b.a(videoAd, tm0Var);
        yi1 yi1VarC = this.b.c();
        if (yi1VarC != null) {
            this.f.a(yi1VarC.c(), bVar, aVar);
        } else {
            op0.b(new Object[0]);
        }
    }

    public final void e(final do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        w5.b bVar = w5.b.b;
        w5.a aVar = new w5.a() { // from class: com.yandex.mobile.ads.impl.b6$$ExternalSyntheticLambda0
            @Override // com.yandex.mobile.ads.impl.w5.a
            public final void a() {
                b6.b(this.f$0, videoAd);
            }
        };
        tm0 tm0VarA = this.b.a(videoAd);
        tm0 tm0Var = tm0.b;
        if (tm0Var == tm0VarA) {
            v4 v4VarA = this.c.a(videoAd);
            if (v4VarA != null) {
                this.f.a(v4VarA, bVar, aVar);
                return;
            }
            return;
        }
        this.b.a(videoAd, tm0Var);
        yi1 yi1VarC = this.b.c();
        if (yi1VarC == null) {
            op0.b(new Object[0]);
        } else {
            this.f.a(yi1VarC.c(), bVar, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(b6 this$0, do0 videoAd) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(videoAd, "$videoAd");
        this$0.f8477a.f(videoAd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(b6 this$0, do0 videoAd) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(videoAd, "$videoAd");
        this$0.f8477a.a(videoAd);
    }
}
