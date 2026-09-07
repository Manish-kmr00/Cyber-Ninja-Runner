package com.yandex.mobile.ads.impl;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class mg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final rb2<do0> f9636a;
    private final bf1 b;
    private final eg2 c;
    private final ko0 d;

    public mg(rb2<do0> videoAdInfo, bf1 adClickHandler, eg2 videoTracker) {
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        Intrinsics.checkNotNullParameter(adClickHandler, "adClickHandler");
        Intrinsics.checkNotNullParameter(videoTracker, "videoTracker");
        this.f9636a = videoAdInfo;
        this.b = adClickHandler;
        this.c = videoTracker;
        this.d = new ko0(new su());
    }

    public final void a(View view, ig<?> igVar) {
        String strA;
        Intrinsics.checkNotNullParameter(view, "view");
        if (igVar == null || !igVar.e() || (strA = this.d.a(this.f9636a.b(), igVar.b()).a()) == null) {
            return;
        }
        view.setOnClickListener(new xg(this.b, strA, igVar.b(), this.c));
    }
}
