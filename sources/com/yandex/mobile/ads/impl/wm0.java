package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class wm0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final rb2<do0> f10575a;
    private final eg2 b;
    private final io0 c;
    private final zd2 d;
    private final l82 e;
    private final bf1 f;

    @Override // android.view.View.OnClickListener
    public final void onClick(View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        this.b.m();
        this.c.i(this.f10575a.d());
        String strA = this.d.a();
        if (strA == null || strA.length() == 0) {
            return;
        }
        this.f.a(this.e.a(strA));
    }

    public /* synthetic */ wm0(Context context, uu1 uu1Var, dt dtVar, rb2 rb2Var, eg2 eg2Var, io0 io0Var, zd2 zd2Var) {
        this(context, uu1Var, dtVar, rb2Var, eg2Var, io0Var, zd2Var, new vn0(context, uu1Var, dtVar, rb2Var), new l82(context));
    }

    public wm0(Context context, uu1 sdkEnvironmentModule, dt coreInstreamAdBreak, rb2<do0> videoAdInfo, eg2 videoTracker, io0 playbackListener, zd2 videoClicks, vn0 openUrlHandlerProvider, l82 urlModifier) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(coreInstreamAdBreak, "coreInstreamAdBreak");
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        Intrinsics.checkNotNullParameter(videoTracker, "videoTracker");
        Intrinsics.checkNotNullParameter(playbackListener, "playbackListener");
        Intrinsics.checkNotNullParameter(videoClicks, "videoClicks");
        Intrinsics.checkNotNullParameter(openUrlHandlerProvider, "openUrlHandlerProvider");
        Intrinsics.checkNotNullParameter(urlModifier, "urlModifier");
        this.f10575a = videoAdInfo;
        this.b = videoTracker;
        this.c = playbackListener;
        this.d = videoClicks;
        this.e = urlModifier;
        this.f = openUrlHandlerProvider.a();
    }
}
