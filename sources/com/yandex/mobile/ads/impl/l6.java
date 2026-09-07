package com.yandex.mobile.ads.impl;

import android.net.Uri;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class l6 implements i20 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final dz1 f9481a;

    public l6(dz1 skipAdController) {
        Intrinsics.checkNotNullParameter(skipAdController, "skipAdController");
        this.f9481a = skipAdController;
    }

    @Override // com.yandex.mobile.ads.impl.i20
    public final boolean a(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        if (!Intrinsics.areEqual(uri.getHost(), "showNextAd")) {
            return false;
        }
        this.f9481a.a();
        return true;
    }
}
