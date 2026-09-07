package com.ogury.ad.internal;

import android.widget.FrameLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class z1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f7458a;
    public final FrameLayout b;
    public final h c;
    public final j4 d;

    public z1(o adType, FrameLayout parent, h adLayout, j4 adController) {
        Intrinsics.checkNotNullParameter(adType, "adType");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(adLayout, "adLayout");
        Intrinsics.checkNotNullParameter(adController, "adController");
        this.f7458a = adType;
        this.b = parent;
        this.c = adLayout;
        this.d = adController;
    }
}
