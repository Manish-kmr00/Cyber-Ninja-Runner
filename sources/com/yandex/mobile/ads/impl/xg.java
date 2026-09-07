package com.yandex.mobile.ads.impl;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class xg implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final bf1 f10651a;
    private final String b;
    private final String c;
    private final eg2 d;

    public xg(bf1 adClickHandler, String url, String assetName, eg2 videoTracker) {
        Intrinsics.checkNotNullParameter(adClickHandler, "adClickHandler");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(assetName, "assetName");
        Intrinsics.checkNotNullParameter(videoTracker, "videoTracker");
        this.f10651a = adClickHandler;
        this.b = url;
        this.c = assetName;
        this.d = videoTracker;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        this.d.a(this.c);
        this.f10651a.a(this.b);
    }
}
