package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class bz1 {
    @JvmStatic
    public static final boolean a(Context context, o8<?> adResponse, zy1 responseSizeInfo, j9 adSizeValidator, zy1 containerSizeInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(responseSizeInfo, "responseSizeInfo");
        Intrinsics.checkNotNullParameter(adSizeValidator, "adSizeValidator");
        Intrinsics.checkNotNullParameter(containerSizeInfo, "containerSizeInfo");
        boolean zA = adSizeValidator.a(context, responseSizeInfo);
        boolean zN = adResponse.N();
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        return zN || (zA && qa.a(applicationContext, responseSizeInfo, containerSizeInfo));
    }
}
