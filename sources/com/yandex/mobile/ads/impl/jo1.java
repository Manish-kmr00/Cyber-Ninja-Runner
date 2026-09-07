package com.yandex.mobile.ads.impl;

import android.os.Handler;
import android.os.Looper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class jo1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final u7 f9340a;
    private final b b;
    private final Handler c;
    private boolean d;

    public interface b {
        void a();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public jo1(u7 adRenderValidator, b adRenderedListener) {
        this(adRenderValidator, adRenderedListener, new Handler(Looper.getMainLooper()));
        Intrinsics.checkNotNullParameter(adRenderValidator, "adRenderValidator");
        Intrinsics.checkNotNullParameter(adRenderedListener, "adRenderedListener");
    }

    public jo1(u7 adRenderValidator, b adRenderedListener, Handler handler) {
        Intrinsics.checkNotNullParameter(adRenderValidator, "adRenderValidator");
        Intrinsics.checkNotNullParameter(adRenderedListener, "adRenderedListener");
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.f9340a = adRenderValidator;
        this.b = adRenderedListener;
        this.c = handler;
    }

    public final void a() {
        this.c.post(new a(this, this.f9340a));
    }

    private final class a implements Runnable {
        private final u7 b;
        final /* synthetic */ jo1 c;

        public a(jo1 jo1Var, u7 adRenderingValidator) {
            Intrinsics.checkNotNullParameter(adRenderingValidator, "adRenderingValidator");
            this.c = jo1Var;
            this.b = adRenderingValidator;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.c.d) {
                return;
            }
            if (this.b.a()) {
                this.c.d = true;
                this.c.b.a();
            } else {
                this.c.c.postDelayed(new a(this.c, this.b), 300L);
            }
        }
    }

    public final void b() {
        this.c.removeCallbacksAndMessages(null);
    }
}
