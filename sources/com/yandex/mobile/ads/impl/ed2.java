package com.yandex.mobile.ads.impl;

import android.os.Handler;
import android.os.Looper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class ed2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final mf2 f8789a;
    private final a b;
    private final Handler c;
    private boolean d;
    private boolean e;

    public interface a {
        void a();
    }

    public ed2(mf2 renderValidator, a renderingStartListener) {
        Intrinsics.checkNotNullParameter(renderValidator, "renderValidator");
        Intrinsics.checkNotNullParameter(renderingStartListener, "renderingStartListener");
        this.f8789a = renderValidator;
        this.b = renderingStartListener;
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
            if (ed2.this.d || !ed2.this.f8789a.a()) {
                ed2.this.c.postDelayed(this, 200L);
                return;
            }
            ed2.this.b.a();
            ed2.this.d = true;
            ed2.this.b();
        }
    }

    public final void b() {
        this.c.removeCallbacksAndMessages(null);
        this.e = false;
    }
}
