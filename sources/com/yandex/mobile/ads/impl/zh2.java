package com.yandex.mobile.ads.impl;

import android.graphics.Rect;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class zh2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final of1 f10819a;
    private final ai2 b;

    public zh2(of1 overlappingAreaProvider, ai2 visibleRectProvider) {
        Intrinsics.checkNotNullParameter(overlappingAreaProvider, "overlappingAreaProvider");
        Intrinsics.checkNotNullParameter(visibleRectProvider, "visibleRectProvider");
        this.f10819a = overlappingAreaProvider;
        this.b = visibleRectProvider;
    }

    public final int a(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        boolean zD = oh2.d(view);
        Rect rectA = this.b.a(view);
        if (zD || rectA == null) {
            return 0;
        }
        return (rectA.width() * rectA.height()) - this.f10819a.a(view, rectA);
    }
}
