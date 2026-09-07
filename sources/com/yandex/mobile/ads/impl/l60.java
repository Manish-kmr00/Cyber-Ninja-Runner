package com.yandex.mobile.ads.impl;

import android.os.Handler;
import android.os.SystemClock;
import androidx.media3.common.AdPlaybackState;
import androidx.media3.common.Player;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class l60 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ol f9482a;
    private final y5 b;
    private final x60 c;
    private final lp1 d;
    private final q9 e;
    private final z4 f;
    private final o5 g;
    private final db h;
    private final Handler i;

    public l60(ol bindingControllerHolder, o9 adStateDataController, y5 adPlayerEventsController, x60 playerProvider, lp1 reporter, q9 adStateHolder, z4 adInfoStorage, o5 adPlaybackStateController, db adsLoaderPlaybackErrorConverter, Handler prepareCompleteHandler) {
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
        this.f9482a = bindingControllerHolder;
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
        if (!this.c.b() || !this.f9482a.b()) {
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
        do0 do0VarA = this.f.a(new u4(i, i2));
        if (do0VarA != null) {
            this.e.a(do0VarA, sm0.g);
            this.h.getClass();
            this.b.a(do0VarA, db.c(iOException));
            return;
        }
        op0.b(new Object[0]);
    }

    public final void a(int i, int i2) {
        a(i, i2, SystemClock.elapsedRealtime());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(l60 this$0, int i, int i2, long j) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.a(i, i2, j);
    }

    private final void a(final int i, final int i2, final long j) {
        if (SystemClock.elapsedRealtime() - j < 200) {
            Player playerA = this.c.a();
            if (playerA != null && playerA.getDuration() != -9223372036854775807L) {
                do0 do0VarA = this.f.a(new u4(i, i2));
                if (do0VarA != null) {
                    this.e.a(do0VarA, sm0.c);
                    this.b.b(do0VarA);
                    return;
                } else {
                    op0.b(new Object[0]);
                    return;
                }
            }
            this.i.postDelayed(new Runnable() { // from class: com.yandex.mobile.ads.impl.l60$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    l60.a(this.f$0, i, i2, j);
                }
            }, 20L);
            return;
        }
        do0 do0VarA2 = this.f.a(new u4(i, i2));
        if (do0VarA2 != null) {
            this.e.a(do0VarA2, sm0.c);
            this.b.b(do0VarA2);
        } else {
            op0.b(new Object[0]);
        }
    }
}
