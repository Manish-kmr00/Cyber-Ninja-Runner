package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class ct implements a82 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final gt f8637a;
    private final ju b;
    private final wn0 c;
    private final rl0 d;
    private final fb2 e;
    private final xl0 f;
    private final im0 g;
    private final mo0 h;
    private final qo0 i;

    public final void a(q70 instreamAdView, List<pb2> friendlyOverlays) {
        Intrinsics.checkNotNullParameter(instreamAdView, "instreamAdView");
        Intrinsics.checkNotNullParameter(friendlyOverlays, "friendlyOverlays");
        ct ctVarA = this.d.a(instreamAdView);
        if (!Intrinsics.areEqual(this, ctVarA)) {
            if (ctVarA != null && ctVarA.d.a(ctVarA)) {
                ctVarA.i.d();
            }
            if (this.d.a(this)) {
                this.i.d();
            }
            this.d.a(instreamAdView, this);
        }
        this.g.a(this.f8637a);
        this.h.a(this.b);
        this.i.a(instreamAdView, friendlyOverlays);
    }

    public /* synthetic */ ct(Context context, uu1 uu1Var, bt btVar, gt gtVar, ju juVar) {
        km0 km0Var = new km0();
        no0 no0Var = new no0();
        wn0 wn0Var = new wn0();
        int i = rl0.d;
        this(context, uu1Var, btVar, gtVar, juVar, km0Var, no0Var, wn0Var, rl0.a.a(), new fb2(), new xl0());
    }

    public final void c() {
        this.f.b();
    }

    public final void d() {
        this.f.c();
    }

    public final void e() {
        if (this.d.a(this)) {
            this.i.d();
        }
    }

    public ct(Context context, uu1 sdkEnvironmentModule, bt instreamAd, gt instreamAdPlayer, ju videoPlayer, km0 instreamAdPlayerReuseControllerFactory, no0 instreamVideoPlayerReuseControllerFactory, wn0 playbackEventListener, rl0 bindingManager, fb2 playbackProxyListener, xl0 customUiElementsHolder) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(instreamAd, "instreamAd");
        Intrinsics.checkNotNullParameter(instreamAdPlayer, "instreamAdPlayer");
        Intrinsics.checkNotNullParameter(videoPlayer, "videoPlayer");
        Intrinsics.checkNotNullParameter(instreamAdPlayerReuseControllerFactory, "instreamAdPlayerReuseControllerFactory");
        Intrinsics.checkNotNullParameter(instreamVideoPlayerReuseControllerFactory, "instreamVideoPlayerReuseControllerFactory");
        Intrinsics.checkNotNullParameter(playbackEventListener, "playbackEventListener");
        Intrinsics.checkNotNullParameter(bindingManager, "bindingManager");
        Intrinsics.checkNotNullParameter(playbackProxyListener, "playbackProxyListener");
        Intrinsics.checkNotNullParameter(customUiElementsHolder, "customUiElementsHolder");
        this.f8637a = instreamAdPlayer;
        this.b = videoPlayer;
        this.c = playbackEventListener;
        this.d = bindingManager;
        this.e = playbackProxyListener;
        this.f = customUiElementsHolder;
        instreamAdPlayerReuseControllerFactory.getClass();
        this.g = km0.a(this);
        instreamVideoPlayerReuseControllerFactory.getClass();
        this.h = no0.a(this);
        qo0 qo0Var = new qo0(context, sdkEnvironmentModule, instreamAd, new gm0(instreamAdPlayer), new ye2(videoPlayer), customUiElementsHolder);
        this.i = qo0Var;
        qo0Var.a(playbackEventListener);
        qo0Var.a(playbackProxyListener);
    }

    @Override // com.yandex.mobile.ads.impl.a82
    public final void invalidateAdPlayer() {
        this.g.b(this.f8637a);
        this.i.a();
    }

    public final void a() {
        this.h.b(this.b);
        this.i.b();
    }

    public final void b() {
        this.i.c();
    }

    public final void a(io0 io0Var) {
        this.e.a(io0Var);
    }

    public final void a(xl2 xl2Var) {
        this.c.a(xl2Var);
    }
}
