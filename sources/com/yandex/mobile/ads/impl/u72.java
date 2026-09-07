package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class u72 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final uu1 f10362a;
    private final xl0 b;
    private final xn0 c;

    public final t72 a(Context context, dt coreInstreamAdBreak, rb2 videoAdInfo, zn0 instreamVastAdPlayer, eg2 videoTracker, uk1 imageProvider, fb2 playbackListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(coreInstreamAdBreak, "coreInstreamAdBreak");
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        Intrinsics.checkNotNullParameter(instreamVastAdPlayer, "instreamVastAdPlayer");
        Intrinsics.checkNotNullParameter(videoTracker, "videoTracker");
        Intrinsics.checkNotNullParameter(imageProvider, "imageProvider");
        Intrinsics.checkNotNullParameter(playbackListener, "playbackListener");
        if (!this.c.e()) {
            uu1 uu1Var = this.f10362a;
            su suVar = new su();
            ko0 ko0Var = new ko0(suVar);
            zd2 zd2VarA = ko0Var.a(videoAdInfo.b(), null);
            return new ro(context, uu1Var, coreInstreamAdBreak, instreamVastAdPlayer, videoAdInfo, videoTracker, playbackListener, suVar, ko0Var, zd2VarA, new wm0(context, uu1Var, coreInstreamAdBreak, videoAdInfo, videoTracker, playbackListener, zd2VarA), new f6(instreamVastAdPlayer));
        }
        uu1 uu1Var2 = this.f10362a;
        xl0 xl0Var = this.b;
        ks ksVar = new ks(context, instreamVastAdPlayer, coreInstreamAdBreak, videoAdInfo, videoTracker, playbackListener);
        fn0 fn0Var = new fn0();
        en0 en0VarA = fn0.a(context, videoAdInfo);
        yg ygVar = new yg(context, uu1Var2, videoAdInfo, coreInstreamAdBreak, videoTracker, playbackListener, imageProvider, en0VarA);
        List<cn0> listA = ygVar.a();
        fh fhVar = new fh(listA);
        xm0 xm0Var = new xm0();
        nn0 nn0Var = new nn0();
        int i = iw1.l;
        mn0 mn0VarA = nn0.a(iw1.a.a().a(context));
        return new js(context, uu1Var2, xl0Var, instreamVastAdPlayer, coreInstreamAdBreak, videoAdInfo, videoTracker, imageProvider, playbackListener, ksVar, fn0Var, en0VarA, ygVar, listA, fhVar, xm0Var, nn0Var, mn0VarA, new um0(xl0Var, mn0VarA));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ u72(uu1 uu1Var, xl0 xl0Var) {
        this(uu1Var, xl0Var, xn0.a.a());
        int i = xn0.g;
    }

    public u72(uu1 sdkEnvironmentModule, xl0 customUiElementsHolder, xn0 instreamSettings) {
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(customUiElementsHolder, "customUiElementsHolder");
        Intrinsics.checkNotNullParameter(instreamSettings, "instreamSettings");
        this.f10362a = sdkEnvironmentModule;
        this.b = customUiElementsHolder;
        this.c = instreamSettings;
    }
}
