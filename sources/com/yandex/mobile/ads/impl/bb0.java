package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.util.DisplayMetrics;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final /* synthetic */ class bb0 {
    public static DisplayMetrics a(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, str);
        return context.getResources().getDisplayMetrics();
    }
}
