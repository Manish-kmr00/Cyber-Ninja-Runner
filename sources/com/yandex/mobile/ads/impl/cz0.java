package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class cz0 implements ij {
    @Override // com.yandex.mobile.ads.impl.ij
    public final int a(Context context, int i, gf1 orientation) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        return (i <= 632 || 90.0f > ((float) oh2.a(context, orientation)) * 0.15f) ? 50 : 90;
    }
}
