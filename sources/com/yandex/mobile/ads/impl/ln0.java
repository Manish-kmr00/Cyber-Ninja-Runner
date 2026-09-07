package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class ln0 implements bf1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f9545a;
    private final sn0 b;
    private final q82 c;

    public ln0(Context context, sn0 instreamInteractionTracker, q82 urlViewerLauncher) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(instreamInteractionTracker, "instreamInteractionTracker");
        Intrinsics.checkNotNullParameter(urlViewerLauncher, "urlViewerLauncher");
        this.f9545a = context;
        this.b = instreamInteractionTracker;
        this.c = urlViewerLauncher;
    }

    @Override // com.yandex.mobile.ads.impl.bf1
    public final void a(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (this.c.a(this.f9545a, url)) {
            this.b.a();
        }
    }
}
