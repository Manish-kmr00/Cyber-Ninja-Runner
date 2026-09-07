package com.yandex.mobile.ads.impl;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class g4 {
    private static final long d = TimeUnit.SECONDS.toMillis(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b4 f8963a;
    private final xn0 b;
    private final Handler c;

    public g4(b4 adGroupController) {
        Intrinsics.checkNotNullParameter(adGroupController, "adGroupController");
        this.f8963a = adGroupController;
        int i = xn0.g;
        this.b = xn0.a.a();
        this.c = new Handler(Looper.getMainLooper());
    }

    public final void b() {
        final k4 k4VarE;
        if (!this.b.d() || (k4VarE = this.f8963a.e()) == null) {
            return;
        }
        this.c.postDelayed(new Runnable() { // from class: com.yandex.mobile.ads.impl.g4$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                g4.a(this.f$0, k4VarE);
            }
        }, d);
    }

    public final void c() {
        k4 k4VarE = this.f8963a.e();
        if (k4VarE != null) {
            id2 id2VarB = k4VarE.b();
            ao0 ao0VarA = k4VarE.a();
            int iOrdinal = id2VarB.a().ordinal();
            if (iOrdinal == 1 || iOrdinal == 2 || iOrdinal == 3 || iOrdinal == 6 || iOrdinal == 7) {
                ao0VarA.g();
            }
        }
        this.c.removeCallbacksAndMessages(null);
    }

    public final void a() {
        ao0 ao0VarA;
        k4 k4VarE = this.f8963a.e();
        if (k4VarE != null && (ao0VarA = k4VarE.a()) != null) {
            ao0VarA.a();
        }
        this.c.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(g4 this$0, k4 nextAd) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(nextAd, "$nextAd");
        if (Intrinsics.areEqual(this$0.f8963a.e(), nextAd)) {
            id2 id2VarB = nextAd.b();
            ao0 ao0VarA = nextAd.a();
            if (id2VarB.a().ordinal() != 0) {
                return;
            }
            ao0VarA.d();
        }
    }
}
