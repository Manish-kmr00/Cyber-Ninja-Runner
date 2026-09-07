package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class c4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f8567a;
    private final dt b;
    private final gm0 c;
    private final pj0 d;
    private final zm0 e;
    private final hc2<do0> f;

    public c4(Context context, dt adBreak, gm0 adPlayerController, uk1 imageProvider, zm0 adViewsHolderManager, i4 playbackEventsListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adBreak, "adBreak");
        Intrinsics.checkNotNullParameter(adPlayerController, "adPlayerController");
        Intrinsics.checkNotNullParameter(imageProvider, "imageProvider");
        Intrinsics.checkNotNullParameter(adViewsHolderManager, "adViewsHolderManager");
        Intrinsics.checkNotNullParameter(playbackEventsListener, "playbackEventsListener");
        this.f8567a = context;
        this.b = adBreak;
        this.c = adPlayerController;
        this.d = imageProvider;
        this.e = adViewsHolderManager;
        this.f = playbackEventsListener;
    }

    public final b4 a() {
        return new b4(new m4(this.f8567a, this.b, this.c, this.d, this.e, this.f).a(this.b.f()));
    }
}
