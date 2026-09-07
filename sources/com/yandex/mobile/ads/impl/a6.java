package com.yandex.mobile.ads.impl;

import androidx.media3.common.util.Assertions;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final y5 f8372a;
    private final q9 b;
    private final z4 c;
    private final qi1 d;
    private final ei1 e;
    private final x5 f;
    private final xn0 g;

    public a6(o9 adStateDataController, oi1 playerStateController, y5 adPlayerEventsController, q9 adStateHolder, z4 adInfoStorage, qi1 playerStateHolder, ei1 playerAdPlaybackController, x5 adPlayerDiscardController, xn0 instreamSettings) {
        Intrinsics.checkNotNullParameter(adStateDataController, "adStateDataController");
        Intrinsics.checkNotNullParameter(playerStateController, "playerStateController");
        Intrinsics.checkNotNullParameter(adPlayerEventsController, "adPlayerEventsController");
        Intrinsics.checkNotNullParameter(adStateHolder, "adStateHolder");
        Intrinsics.checkNotNullParameter(adInfoStorage, "adInfoStorage");
        Intrinsics.checkNotNullParameter(playerStateHolder, "playerStateHolder");
        Intrinsics.checkNotNullParameter(playerAdPlaybackController, "playerAdPlaybackController");
        Intrinsics.checkNotNullParameter(adPlayerDiscardController, "adPlayerDiscardController");
        Intrinsics.checkNotNullParameter(instreamSettings, "instreamSettings");
        this.f8372a = adPlayerEventsController;
        this.b = adStateHolder;
        this.c = adInfoStorage;
        this.d = playerStateHolder;
        this.e = playerAdPlaybackController;
        this.f = adPlayerDiscardController;
        this.g = instreamSettings;
    }

    public final void a(do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        if (sm0.d == this.b.a(videoAd)) {
            this.b.a(videoAd, sm0.e);
            xi1 xi1VarC = this.b.c();
            Assertions.checkState(Intrinsics.areEqual(videoAd, xi1VarC != null ? xi1VarC.d() : null));
            this.d.a(false);
            this.e.a();
            this.f8372a.c(videoAd);
        }
    }

    public final void b(do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        sm0 sm0VarA = this.b.a(videoAd);
        if (sm0.b == sm0VarA || sm0.c == sm0VarA) {
            this.b.a(videoAd, sm0.d);
            Object objCheckNotNull = Assertions.checkNotNull(this.c.a(videoAd));
            Intrinsics.checkNotNullExpressionValue(objCheckNotNull, "checkNotNull(...)");
            this.b.a(new xi1((u4) objCheckNotNull, videoAd));
            this.f8372a.d(videoAd);
            return;
        }
        if (sm0.e == sm0VarA) {
            xi1 xi1VarC = this.b.c();
            Assertions.checkState(Intrinsics.areEqual(videoAd, xi1VarC != null ? xi1VarC.d() : null));
            this.b.a(videoAd, sm0.d);
            this.f8372a.e(videoAd);
        }
    }

    public final void c(do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        if (sm0.e == this.b.a(videoAd)) {
            this.b.a(videoAd, sm0.d);
            xi1 xi1VarC = this.b.c();
            Assertions.checkState(Intrinsics.areEqual(videoAd, xi1VarC != null ? xi1VarC.d() : null));
            this.d.a(true);
            this.e.b();
            this.f8372a.e(videoAd);
        }
    }

    public final void d(final do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        x5.b bVar = this.g.f() ? x5.b.c : x5.b.b;
        x5.a aVar = new x5.a() { // from class: com.yandex.mobile.ads.impl.a6$$ExternalSyntheticLambda0
            @Override // com.yandex.mobile.ads.impl.x5.a
            public final void a() {
                a6.a(this.f$0, videoAd);
            }
        };
        sm0 sm0VarA = this.b.a(videoAd);
        sm0 sm0Var = sm0.b;
        if (sm0Var == sm0VarA) {
            u4 u4VarA = this.c.a(videoAd);
            if (u4VarA != null) {
                this.f.a(u4VarA, bVar, aVar);
                return;
            }
            return;
        }
        this.b.a(videoAd, sm0Var);
        xi1 xi1VarC = this.b.c();
        if (xi1VarC != null) {
            this.f.a(xi1VarC.c(), bVar, aVar);
        } else {
            op0.b(new Object[0]);
        }
    }

    public final void e(final do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        x5.b bVar = x5.b.b;
        x5.a aVar = new x5.a() { // from class: com.yandex.mobile.ads.impl.a6$$ExternalSyntheticLambda1
            @Override // com.yandex.mobile.ads.impl.x5.a
            public final void a() {
                a6.b(this.f$0, videoAd);
            }
        };
        sm0 sm0VarA = this.b.a(videoAd);
        sm0 sm0Var = sm0.b;
        if (sm0Var == sm0VarA) {
            u4 u4VarA = this.c.a(videoAd);
            if (u4VarA != null) {
                this.f.a(u4VarA, bVar, aVar);
                return;
            }
            return;
        }
        this.b.a(videoAd, sm0Var);
        xi1 xi1VarC = this.b.c();
        if (xi1VarC == null) {
            op0.b(new Object[0]);
        } else {
            this.f.a(xi1VarC.c(), bVar, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(a6 this$0, do0 videoAd) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(videoAd, "$videoAd");
        this$0.f8372a.f(videoAd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(a6 this$0, do0 videoAd) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(videoAd, "$videoAd");
        this$0.f8372a.a(videoAd);
    }
}
