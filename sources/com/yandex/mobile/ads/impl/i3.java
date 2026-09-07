package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class i3 implements j3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final uu1 f9169a;
    private final o8<?> b;
    private final o3 c;
    private final l51 d;
    private final z32 e;
    private final v9 f;
    private final u41 g;
    private final r62 h;
    private final c5 i;
    private t71 j;

    @Override // com.yandex.mobile.ads.impl.j3
    public final df0 a(View view, ig<?> asset, rr0 link, c71 nativeAdViewAdapter) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(asset, "asset");
        Intrinsics.checkNotNullParameter(link, "link");
        Intrinsics.checkNotNullParameter(nativeAdViewAdapter, "nativeAdViewAdapter");
        this.d.a(link);
        Context context = view.getContext();
        t8 t8VarA = this.i.a();
        cp cpVarA = this.g.a(asset.b(), "url");
        z32 z32Var = this.e;
        Intrinsics.checkNotNull(context);
        o91 o91Var = new o91(this.f, z32Var.a(context, this.f9169a, this.c, this.b, t8VarA));
        n91 n91VarA = o91Var.a(cpVarA);
        o3 o3Var = this.c;
        o8<?> o8Var = this.b;
        l51 l51Var = this.d;
        df0 df0VarA = new f0(o3Var, o8Var, cpVarA, o91Var, nativeAdViewAdapter, l51Var, new a0(o3Var, o8Var, cpVarA, o91Var, nativeAdViewAdapter, l51Var, this.j)).a(view, link.a());
        this.h.a(link.d());
        String strE = link.e();
        if (strE != null && strE.length() > 0) {
            n91VarA.a(strE);
        }
        return df0VarA;
    }

    public /* synthetic */ i3(Context context, uu1 uu1Var, o8 o8Var, o3 o3Var, l51 l51Var, z32 z32Var) {
        v9 v9Var = new v9(context, o3Var);
        this(context, uu1Var, o8Var, o3Var, l51Var, z32Var, v9Var, new u41(context, o3Var, o8Var), new r62(v9Var), new c5(l51Var));
    }

    public i3(Context context, uu1 sdkEnvironmentModule, o8<?> adResponse, o3 adConfiguration, l51 nativeAdEventController, z32 targetUrlHandlerProvider, v9 adTracker, u41 clickReporterCreator, r62 trackingUrlHandler, c5 adLinksHandlerReceiver) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(nativeAdEventController, "nativeAdEventController");
        Intrinsics.checkNotNullParameter(targetUrlHandlerProvider, "targetUrlHandlerProvider");
        Intrinsics.checkNotNullParameter(adTracker, "adTracker");
        Intrinsics.checkNotNullParameter(clickReporterCreator, "clickReporterCreator");
        Intrinsics.checkNotNullParameter(trackingUrlHandler, "trackingUrlHandler");
        Intrinsics.checkNotNullParameter(adLinksHandlerReceiver, "adLinksHandlerReceiver");
        this.f9169a = sdkEnvironmentModule;
        this.b = adResponse;
        this.c = adConfiguration;
        this.d = nativeAdEventController;
        this.e = targetUrlHandlerProvider;
        this.f = adTracker;
        this.g = clickReporterCreator;
        this.h = trackingUrlHandler;
        this.i = adLinksHandlerReceiver;
    }

    public final void a(t71 t71Var) {
        this.j = t71Var;
        this.g.a(t71Var);
    }
}
