package com.yandex.mobile.ads.impl;

import android.os.Handler;
import android.view.View;
import android.widget.FrameLayout;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class f21 implements pp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f8862a;
    private final r82 b;
    private final Handler c;
    private boolean d;

    public f21(FrameLayout closeButton, r82 useCustomCloseHandler, Handler handler) {
        Intrinsics.checkNotNullParameter(closeButton, "closeButton");
        Intrinsics.checkNotNullParameter(useCustomCloseHandler, "useCustomCloseHandler");
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.f8862a = closeButton;
        this.b = useCustomCloseHandler;
        this.c = handler;
        d().setVisibility(8);
    }

    @Override // com.yandex.mobile.ads.impl.pp
    public final void a() {
    }

    @Override // com.yandex.mobile.ads.impl.pp
    public final void b() {
    }

    @Override // com.yandex.mobile.ads.impl.pp
    public final void invalidate() {
    }

    @Override // com.yandex.mobile.ads.impl.pp
    public final View d() {
        return this.f8862a;
    }

    @Override // com.yandex.mobile.ads.impl.pp
    public final void c() {
        if (this.d) {
            return;
        }
        this.c.postDelayed(new a(this.f8862a), 200L);
    }

    @Override // com.yandex.mobile.ads.impl.pp
    public final void a(boolean z) {
        this.d = true;
        this.c.removeCallbacksAndMessages(null);
        r82 r82Var = this.b;
        View closeButton = this.f8862a;
        r82Var.getClass();
        Intrinsics.checkNotNullParameter(closeButton, "closeButton");
        closeButton.setVisibility(z ? 8 : 0);
    }

    private static final class a implements Runnable {
        private final WeakReference<View> b;

        public a(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.b = new WeakReference<>(view);
        }

        @Override // java.lang.Runnable
        public final void run() {
            View view = this.b.get();
            if (view != null) {
                view.setVisibility(0);
            }
        }
    }
}
