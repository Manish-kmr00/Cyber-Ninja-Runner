package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class yg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f10733a;
    private final uu1 b;
    private final rb2<do0> c;
    private final dt d;
    private final eg2 e;
    private final io0 f;
    private final pj0 g;
    private final en0 h;

    public yg(Context context, uu1 sdkEnvironmentModule, rb2 videoAdInfo, dt adBreak, eg2 videoTracker, fb2 playbackListener, uk1 imageProvider, en0 assetsWrapper) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        Intrinsics.checkNotNullParameter(adBreak, "adBreak");
        Intrinsics.checkNotNullParameter(videoTracker, "videoTracker");
        Intrinsics.checkNotNullParameter(playbackListener, "playbackListener");
        Intrinsics.checkNotNullParameter(imageProvider, "imageProvider");
        Intrinsics.checkNotNullParameter(assetsWrapper, "assetsWrapper");
        this.f10733a = context;
        this.b = sdkEnvironmentModule;
        this.c = videoAdInfo;
        this.d = adBreak;
        this.e = videoTracker;
        this.f = playbackListener;
        this.g = imageProvider;
        this.h = assetsWrapper;
    }

    public final List<cn0> a() {
        Context context = this.f10733a;
        uu1 sdkEnvironmentModule = this.b;
        rb2<do0> videoAdInfo = this.c;
        dt adBreak = this.d;
        eg2 videoTracker = this.e;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        Intrinsics.checkNotNullParameter(adBreak, "adBreak");
        Intrinsics.checkNotNullParameter(videoTracker, "videoTracker");
        mg mgVar = new mg(videoAdInfo, new vn0(context, sdkEnvironmentModule, adBreak, videoAdInfo).a(), videoTracker);
        ig<?> igVarA = this.h.a("call_to_action");
        rb2<do0> videoAdInfo2 = this.c;
        Context context2 = this.f10733a;
        uu1 sdkEnvironmentModule2 = this.b;
        dt adBreak2 = this.d;
        eg2 videoTracker2 = this.e;
        io0 playbackListener = this.f;
        Intrinsics.checkNotNullParameter(videoAdInfo2, "videoAdInfo");
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule2, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(adBreak2, "adBreak");
        Intrinsics.checkNotNullParameter(videoTracker2, "videoTracker");
        Intrinsics.checkNotNullParameter(playbackListener, "playbackListener");
        zd2 zd2VarA = new ko0(new su()).a(videoAdInfo2.b(), igVarA != null ? igVarA.b() : null);
        sn snVar = new sn(igVarA, new vo(context2, sdkEnvironmentModule2, adBreak2, videoAdInfo2, videoTracker2, playbackListener, zd2VarA, new wm0(context2, sdkEnvironmentModule2, adBreak2, videoAdInfo2, videoTracker2, playbackListener, zd2VarA), new i10()));
        tn tnVar = new tn();
        rb2<do0> rb2Var = this.c;
        gc gcVarA = new hc(rb2Var, new ic(rb2Var.g())).a();
        ig<?> igVarA2 = this.h.a("favicon");
        gj0 gj0Var = new gj0(this.f10733a, new pn0(), this.g);
        s80 s80Var = new s80(gj0Var, igVarA2, mgVar);
        r30 r30Var = new r30(this.h.a("domain"), mgVar);
        t12 t12Var = new t12(this.h.a("sponsored"), this.c.a(), mgVar, new u12());
        p6 p6Var = new p6(this.c.d().b().a(), this.c.d().b().b());
        v62 v62Var = new v62(gj0Var, this.h.a("trademark"), mgVar);
        yl0 yl0Var = new yl0();
        bf1 bf1VarA = new vn0(this.f10733a, this.b, this.d, this.c).a();
        ig<?> igVarA3 = this.h.a("feedback");
        yb ybVar = new yb(yl0Var, bf1VarA, new k0());
        j10 j10Var = new j10();
        l20 l20Var = new l20(j10Var);
        return CollectionsKt.listOf((Object[]) new cn0[]{snVar, gcVarA, s80Var, r30Var, t12Var, p6Var, v62Var, tnVar, new ra0(igVarA3, mgVar, this.e, ybVar, new o20(j10Var, l20Var, new n20(l20Var, new k30()))), new cj2(this.h.a("warning"), mgVar)});
    }
}
