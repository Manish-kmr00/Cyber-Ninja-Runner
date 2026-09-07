package com.yandex.mobile.ads.impl;

import android.os.Handler;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class cg1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final bh0 f8602a;
    private final Handler b;
    private final wy1 c;
    private final r7 d;
    private boolean e;

    public cg1(bh0 htmlWebViewRenderer, Handler handler, wy1 singleTimeRunner, r7 adRenderWaitBreaker) {
        Intrinsics.checkNotNullParameter(htmlWebViewRenderer, "htmlWebViewRenderer");
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(singleTimeRunner, "singleTimeRunner");
        Intrinsics.checkNotNullParameter(adRenderWaitBreaker, "adRenderWaitBreaker");
        this.f8602a = htmlWebViewRenderer;
        this.b = handler;
        this.c = singleTimeRunner;
        this.d = adRenderWaitBreaker;
    }

    public final void b() {
        if (this.e) {
            return;
        }
        this.c.a(new Runnable() { // from class: com.yandex.mobile.ads.impl.cg1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                cg1.a(this.f$0);
            }
        });
    }

    public final void a() {
        this.b.removeCallbacksAndMessages(null);
        this.d.a(null);
    }

    public final void a(int i, String str) {
        this.e = true;
        this.b.removeCallbacks(this.d);
        this.b.post(new oj2(i, str, this.f8602a));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(cg1 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        op0.d(new Object[0]);
        this$0.b.postDelayed(this$0.d, 10000L);
    }

    public final void a(ah0 ah0Var) {
        this.d.a(ah0Var);
    }
}
