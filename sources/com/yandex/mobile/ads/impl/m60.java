package com.yandex.mobile.ads.impl;

import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.source.ads.AdPlaybackState;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class m60 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final pl f9600a;
    private final z5 b;
    private final y60 c;
    private final lp1 d;
    private final r9 e;
    private final a5 f;
    private final p5 g;
    private final eb h;
    private final Handler i;

    public m60(pl bindingControllerHolder, p9 adStateDataController, z5 adPlayerEventsController, y60 playerProvider, lp1 reporter, r9 adStateHolder, a5 adInfoStorage, p5 adPlaybackStateController, eb adsLoaderPlaybackErrorConverter, Handler prepareCompleteHandler) {
        Intrinsics.checkNotNullParameter(bindingControllerHolder, "bindingControllerHolder");
        Intrinsics.checkNotNullParameter(adStateDataController, "adStateDataController");
        Intrinsics.checkNotNullParameter(adPlayerEventsController, "adPlayerEventsController");
        Intrinsics.checkNotNullParameter(playerProvider, "playerProvider");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(adStateHolder, "adStateHolder");
        Intrinsics.checkNotNullParameter(adInfoStorage, "adInfoStorage");
        Intrinsics.checkNotNullParameter(adPlaybackStateController, "adPlaybackStateController");
        Intrinsics.checkNotNullParameter(adsLoaderPlaybackErrorConverter, "adsLoaderPlaybackErrorConverter");
        Intrinsics.checkNotNullParameter(prepareCompleteHandler, "prepareCompleteHandler");
        this.f9600a = bindingControllerHolder;
        this.b = adPlayerEventsController;
        this.c = playerProvider;
        this.d = reporter;
        this.e = adStateHolder;
        this.f = adInfoStorage;
        this.g = adPlaybackStateController;
        this.h = adsLoaderPlaybackErrorConverter;
        this.i = prepareCompleteHandler;
    }

    public final void b(int i, int i2, IOException exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        if (!this.c.b() || !this.f9600a.b()) {
            op0.f(new Object[0]);
            return;
        }
        try {
            a(i, i2, exception);
        } catch (RuntimeException e) {
            op0.b(e);
            this.d.reportError("Unexpected exception while handling prepare error", e);
        }
    }

    private final void a(int i, int i2, IOException iOException) {
        AdPlaybackState adPlaybackStateWithAdLoadError = this.g.a().withAdLoadError(i, i2);
        Intrinsics.checkNotNullExpressionValue(adPlaybackStateWithAdLoadError, "withAdLoadError(...)");
        this.g.a(adPlaybackStateWithAdLoadError);
        do0 do0VarA = this.f.a(new v4(i, i2));
        if (do0VarA != null) {
            this.e.a(do0VarA, tm0.g);
            this.h.getClass();
            this.b.a(do0VarA, eb.c(iOException));
            return;
        }
        op0.b(new Object[0]);
    }

    public final void a(int i, int i2) {
        a(i, i2, SystemClock.elapsedRealtime());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(m60 this$0, int i, int i2, long j) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.a(i, i2, j);
    }

    private final void a(final int i, final int i2, final long j) {
        if (SystemClock.elapsedRealtime() - j < 200) {
            Player playerA = this.c.a();
            if (playerA != null && playerA.getDuration() != -9223372036854775807L) {
                do0 do0VarA = this.f.a(new v4(i, i2));
                if (do0VarA != null) {
                    this.e.a(do0VarA, tm0.c);
                    this.b.b(do0VarA);
                    return;
                } else {
                    op0.b(new Object[0]);
                    return;
                }
            }
            this.i.postDelayed(new Runnable() { // from class: com.yandex.mobile.ads.impl.m60$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    m60.a(this.f$0, i, i2, j);
                }
            }, 20L);
            return;
        }
        do0 do0VarA2 = this.f.a(new v4(i, i2));
        if (do0VarA2 != null) {
            this.e.a(do0VarA2, tm0.c);
            this.b.b(do0VarA2);
        } else {
            op0.b(new Object[0]);
        }
    }
}
