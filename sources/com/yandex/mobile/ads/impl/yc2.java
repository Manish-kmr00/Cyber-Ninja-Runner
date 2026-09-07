package com.yandex.mobile.ads.impl;

import android.os.Handler;
import android.os.Looper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class yc2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final oc2<?> f10725a;
    private final vc2 b;
    private final Handler c;
    private boolean d;

    public /* synthetic */ yc2(oc2 oc2Var, vc2 vc2Var) {
        this(oc2Var, vc2Var, new Handler(Looper.getMainLooper()));
    }

    public yc2(oc2<?> videoAdPlayer, vc2 videoAdProgressEventsObservable, Handler handler) {
        Intrinsics.checkNotNullParameter(videoAdPlayer, "videoAdPlayer");
        Intrinsics.checkNotNullParameter(videoAdProgressEventsObservable, "videoAdProgressEventsObservable");
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.f10725a = videoAdPlayer;
        this.b = videoAdProgressEventsObservable;
        this.c = handler;
    }

    public final void a() {
        if (this.d) {
            return;
        }
        this.d = true;
        this.b.a();
        this.c.post(new a());
    }

    private final class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            long adPosition = yc2.this.f10725a.getAdPosition();
            yc2.this.b.a(yc2.this.f10725a.b(), adPosition);
            if (yc2.this.d) {
                yc2.this.c.postDelayed(this, 200L);
            }
        }
    }

    public final void b() {
        if (this.d) {
            this.b.b();
            this.c.removeCallbacksAndMessages(null);
            this.d = false;
        }
    }
}
