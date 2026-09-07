package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes6.dex */
public final class av0 implements z00 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f8441a;
    private final uu0 b;

    public av0(ot nativeAdAssets, int i, uu0 mediaAspectRatioProvider) {
        Intrinsics.checkNotNullParameter(nativeAdAssets, "nativeAdAssets");
        Intrinsics.checkNotNullParameter(mediaAspectRatioProvider, "mediaAspectRatioProvider");
        this.f8441a = i;
        this.b = mediaAspectRatioProvider;
    }

    @Override // com.yandex.mobile.ads.impl.z00
    public final boolean a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        int i = oh2.b;
        int i2 = bb0.a(context, "context").heightPixels;
        int i3 = bb0.a(context, "context").widthPixels;
        Float fA = this.b.a();
        return i3 - (fA != null ? MathKt.roundToInt(fA.floatValue() * ((float) i2)) : 0) >= this.f8441a;
    }
}
