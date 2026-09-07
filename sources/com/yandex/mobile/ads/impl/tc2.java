package com.yandex.mobile.ads.impl;

import android.os.Handler;
import android.os.Looper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class tc2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final id2 f10287a;
    private final a b;
    private final Handler c;
    private boolean d;
    private boolean e;

    public interface a {
        void b();
    }

    public tc2(id2 statusController, a preparedListener) {
        Intrinsics.checkNotNullParameter(statusController, "statusController");
        Intrinsics.checkNotNullParameter(preparedListener, "preparedListener");
        this.f10287a = statusController;
        this.b = preparedListener;
        this.c = new Handler(Looper.getMainLooper());
    }

    public final void a() {
        if (this.e || this.d) {
            return;
        }
        this.e = true;
        this.c.post(new b());
    }

    private final class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (tc2.this.d || !tc2.this.f10287a.a(hd2.d)) {
                tc2.this.c.postDelayed(this, 200L);
                return;
            }
            tc2.this.b.b();
            tc2.this.d = true;
            tc2.this.b();
        }
    }

    public final void b() {
        this.c.removeCallbacksAndMessages(null);
        this.e = false;
    }
}
