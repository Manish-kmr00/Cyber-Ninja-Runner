package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class vo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final rb2<do0> f10499a;
    private final View.OnClickListener b;
    private final i10 c;

    public vo(Context context, uu1 sdkEnvironmentModule, dt coreInstreamAdBreak, rb2<do0> videoAdInfo, eg2 videoTracker, io0 playbackListener, zd2 videoClicks, View.OnClickListener clickListener, i10 deviceTypeProvider) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(coreInstreamAdBreak, "coreInstreamAdBreak");
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        Intrinsics.checkNotNullParameter(videoTracker, "videoTracker");
        Intrinsics.checkNotNullParameter(playbackListener, "playbackListener");
        Intrinsics.checkNotNullParameter(videoClicks, "videoClicks");
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        Intrinsics.checkNotNullParameter(deviceTypeProvider, "deviceTypeProvider");
        this.f10499a = videoAdInfo;
        this.b = clickListener;
        this.c = deviceTypeProvider;
    }

    public final void a(View clickControl) {
        Intrinsics.checkNotNullParameter(clickControl, "clickControl");
        i10 i10Var = this.c;
        Context context = clickControl.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        h10 h10VarA = i10Var.a(context);
        String strB = this.f10499a.b().b();
        if ((strB == null || strB.length() == 0) || h10VarA == h10.d) {
            clickControl.setVisibility(8);
        } else {
            clickControl.setOnClickListener(this.b);
        }
    }
}
