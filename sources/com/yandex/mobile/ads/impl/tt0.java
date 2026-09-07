package com.yandex.mobile.ads.impl;

import android.os.Handler;
import android.os.Looper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class tt0 implements kt0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f10330a;
    private kt0 b;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(tt0 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        kt0 kt0Var = this$0.b;
        if (kt0Var != null) {
            kt0Var.onInstreamAdBreakCompleted();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(tt0 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        kt0 kt0Var = this$0.b;
        if (kt0Var != null) {
            kt0Var.onInstreamAdBreakPrepared();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(tt0 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        kt0 kt0Var = this$0.b;
        if (kt0Var != null) {
            kt0Var.onInstreamAdBreakStarted();
        }
    }

    @Override // com.yandex.mobile.ads.impl.kt0
    public final void onInstreamAdBreakError(final String reason) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        this.f10330a.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.tt0$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                tt0.a(this.f$0, reason);
            }
        });
    }

    public /* synthetic */ tt0() {
        this(new Handler(Looper.getMainLooper()));
    }

    public tt0(Handler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.f10330a = handler;
    }

    @Override // com.yandex.mobile.ads.impl.kt0
    public final void onInstreamAdBreakPrepared() {
        this.f10330a.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.tt0$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                tt0.b(this.f$0);
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.kt0
    public final void onInstreamAdBreakStarted() {
        this.f10330a.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.tt0$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                tt0.c(this.f$0);
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.kt0
    public final void onInstreamAdBreakCompleted() {
        this.f10330a.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.tt0$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                tt0.a(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(tt0 this$0, String reason) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(reason, "$reason");
        kt0 kt0Var = this$0.b;
        if (kt0Var != null) {
            kt0Var.onInstreamAdBreakError(reason);
        }
    }

    public final void a(ul2 ul2Var) {
        this.b = ul2Var;
    }
}
