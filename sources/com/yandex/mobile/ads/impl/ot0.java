package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class ot0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final gm0 f9856a;
    private final tt0 b;
    private final ut0 c;
    private final zm0 d;
    private final u2 e;

    public ot0(Context context, uu1 sdkEnvironmentModule, dt instreamAdBreak, gm0 instreamAdPlayerController, z2 adBreakStatusController, tt0 manualPlaybackEventListener, xl0 instreamAdCustomUiElementsHolder, ut0 manualPlaybackManager, zm0 instreamAdViewsHolderManager, u2 adBreakPlaybackController) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(instreamAdBreak, "instreamAdBreak");
        Intrinsics.checkNotNullParameter(instreamAdPlayerController, "instreamAdPlayerController");
        Intrinsics.checkNotNullParameter(adBreakStatusController, "adBreakStatusController");
        Intrinsics.checkNotNullParameter(manualPlaybackEventListener, "manualPlaybackEventListener");
        Intrinsics.checkNotNullParameter(instreamAdCustomUiElementsHolder, "instreamAdCustomUiElementsHolder");
        Intrinsics.checkNotNullParameter(manualPlaybackManager, "manualPlaybackManager");
        Intrinsics.checkNotNullParameter(instreamAdViewsHolderManager, "instreamAdViewsHolderManager");
        Intrinsics.checkNotNullParameter(adBreakPlaybackController, "adBreakPlaybackController");
        this.f9856a = instreamAdPlayerController;
        this.b = manualPlaybackEventListener;
        this.c = manualPlaybackManager;
        this.d = instreamAdViewsHolderManager;
        this.e = adBreakPlaybackController;
    }

    public final void b() {
        ym0 ym0VarA = this.d.a();
        if (ym0VarA == null || ym0VarA.b() == null) {
            return;
        }
        this.e.a();
    }

    public final void d() {
        ym0 ym0VarA = this.d.a();
        if (ym0VarA == null || ym0VarA.b() == null) {
            return;
        }
        this.e.f();
    }

    public final void c() {
        this.f9856a.a();
        this.e.a(new a());
        this.e.d();
    }

    public final void a() {
        this.e.b();
        this.f9856a.b();
        this.d.b();
    }

    public final void a(q70 instreamAdView) {
        Intrinsics.checkNotNullParameter(instreamAdView, "instreamAdView");
        ot0 ot0VarA = this.c.a(instreamAdView);
        if (!Intrinsics.areEqual(this, ot0VarA)) {
            if (ot0VarA != null) {
                ot0VarA.e.c();
                ot0VarA.d.b();
            }
            if (this.c.a(this)) {
                this.e.c();
                this.d.b();
            }
            this.c.a(instreamAdView, this);
        }
        this.d.a(instreamAdView, CollectionsKt.emptyList());
        this.f9856a.a();
        this.e.g();
    }

    private final class a implements v2 {
        @Override // com.yandex.mobile.ads.impl.v2
        public final void d() {
        }

        public a() {
        }

        @Override // com.yandex.mobile.ads.impl.v2
        public final void a() {
            ot0.this.b.onInstreamAdBreakPrepared();
        }

        @Override // com.yandex.mobile.ads.impl.v2
        public final void b() {
            ot0.this.b.onInstreamAdBreakStarted();
        }

        @Override // com.yandex.mobile.ads.impl.v2
        public final void e() {
            ot0.this.b.onInstreamAdBreakCompleted();
        }

        @Override // com.yandex.mobile.ads.impl.v2
        public final void g() {
            ot0.this.b.onInstreamAdBreakError("Ad player returned error");
        }
    }

    public final void a(fb2 fb2Var) {
        this.e.a(fb2Var);
    }
}
