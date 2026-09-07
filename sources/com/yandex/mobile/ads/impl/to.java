package com.yandex.mobile.ads.impl;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class to {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ng f10321a;

    public final void a(View view, String assetName) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(assetName, "assetName");
        ng ngVar = this.f10321a;
        if (ngVar != null) {
            ngVar.a(view, assetName);
        }
    }

    public final void a(ng listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.f10321a = listener;
    }
}
