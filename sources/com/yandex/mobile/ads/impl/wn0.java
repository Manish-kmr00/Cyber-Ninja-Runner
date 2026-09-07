package com.yandex.mobile.ads.impl;

import android.os.Handler;
import android.os.Looper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class wn0 implements po0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f10578a;
    private pl0 b;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(wn0 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        pl0 pl0Var = this$0.b;
        if (pl0Var != null) {
            pl0Var.onInstreamAdPrepared();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(wn0 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        pl0 pl0Var = this$0.b;
        if (pl0Var != null) {
            pl0Var.onInstreamAdCompleted();
        }
    }

    public /* synthetic */ wn0() {
        this(new Handler(Looper.getMainLooper()));
    }

    public wn0(Handler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.f10578a = handler;
    }

    @Override // com.yandex.mobile.ads.impl.po0
    public final void onInstreamAdPrepared() {
        this.f10578a.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.wn0$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                wn0.a(this.f$0);
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.po0
    public final void b() {
        final String str = "Video player returned error";
        Intrinsics.checkNotNullParameter("Video player returned error", "reason");
        this.f10578a.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.wn0$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                wn0.a(this.f$0, str);
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.po0
    public final void a() {
        this.f10578a.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.wn0$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                wn0.b(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(wn0 this$0, String reason) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(reason, "$reason");
        pl0 pl0Var = this$0.b;
        if (pl0Var != null) {
            pl0Var.onError(reason);
        }
    }

    public final void a(xl2 xl2Var) {
        this.b = xl2Var;
    }
}
