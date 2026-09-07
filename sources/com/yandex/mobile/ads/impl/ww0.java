package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class ww0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final vw0 f10598a;
    private final Context b;

    public ww0(Context context, vw0 mediaSourcePathProvider) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mediaSourcePathProvider, "mediaSourcePathProvider");
        this.f10598a = mediaSourcePathProvider;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this.b = applicationContext;
    }

    public final cm1 a(jc2 videoAdPlaybackInfo) {
        Intrinsics.checkNotNullParameter(videoAdPlaybackInfo, "videoAdPlaybackInfo");
        lz.a aVar = new lz.a(this.b, new vu1(ws1.a()).a(this.b));
        int i = a70.e;
        vm.a aVarA = new vm.a().a(a70.a.a().a(this.b)).a(aVar);
        Intrinsics.checkNotNullExpressionValue(aVarA, "setUpstreamDataSourceFactory(...)");
        cm1.a aVar2 = new cm1.a(aVarA, new uz());
        this.f10598a.getClass();
        Intrinsics.checkNotNullParameter(videoAdPlaybackInfo, "videoAdPlaybackInfo");
        cm1 cm1VarA = aVar2.a(fw0.a(videoAdPlaybackInfo.getUrl()));
        Intrinsics.checkNotNullExpressionValue(cm1VarA, "createMediaSource(...)");
        return cm1VarA;
    }
}
