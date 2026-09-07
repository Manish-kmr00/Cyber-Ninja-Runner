package com.yandex.mobile.ads.impl;

import android.os.Handler;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class jf2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ye2 f9315a;
    private final Handler b;
    private vl1 c;
    private boolean d;

    public jf2(ye2 videoPlayerController, Handler handler) {
        Intrinsics.checkNotNullParameter(videoPlayerController, "videoPlayerController");
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.f9315a = videoPlayerController;
        this.b = handler;
    }

    public final void a(vl1 vl1Var) {
        this.c = vl1Var;
    }

    private final class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            long jC = jf2.this.f9315a.c();
            vl1 vl1Var = jf2.this.c;
            if (vl1Var != null) {
                vl1Var.a(jC);
            }
            if (jf2.this.d) {
                jf2.this.b.postDelayed(this, 200L);
            }
        }
    }

    public final void b() {
        if (this.d) {
            this.b.removeCallbacksAndMessages(null);
            this.d = false;
        }
    }

    public final void a() {
        if (this.d) {
            return;
        }
        this.d = true;
        this.b.post(new a());
    }
}
