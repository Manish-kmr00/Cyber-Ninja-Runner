package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class bj implements j9 {
    @Override // com.yandex.mobile.ads.impl.j9
    public final boolean a(Context context, zy1 sizeInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sizeInfo, "sizeInfo");
        return sizeInfo.c(context) >= 0 && sizeInfo.a(context) >= 0;
    }
}
