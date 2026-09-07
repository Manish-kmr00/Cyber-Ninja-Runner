package com.yandex.mobile.ads.impl;

import android.os.Handler;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class ft0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f8924a;

    public ft0(Handler mainThreadHandler) {
        Intrinsics.checkNotNullParameter(mainThreadHandler, "mainThreadHandler");
        this.f8924a = mainThreadHandler;
    }

    public final void a() {
        this.f8924a.removeCallbacksAndMessages(null);
    }

    private final class a implements Runnable {
        private final long b;
        private final xn c;
        final /* synthetic */ ft0 d;

        public a(ft0 ft0Var, long j, d31 periodicJob) {
            Intrinsics.checkNotNullParameter(periodicJob, "periodicJob");
            this.d = ft0Var;
            this.b = j;
            this.c = periodicJob;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.c.b()) {
                this.c.run();
                this.d.f8924a.postDelayed(this, this.b);
            }
        }
    }

    public final void a(long j, d31 periodicJob) {
        Intrinsics.checkNotNullParameter(periodicJob, "periodicJob");
        if (periodicJob.b()) {
            this.f8924a.postDelayed(new a(this, j, periodicJob), j);
        }
    }
}
