package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class no1 {
    public static mo1 a(Context context, o8 adResponse, o3 adConfiguration, s4 adIdStorageManager, va adVisibilityValidator, vo1 renderingImpressionTrackingListener) {
        s9 adStructureType = s9.b;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(adIdStorageManager, "adIdStorageManager");
        Intrinsics.checkNotNullParameter(adVisibilityValidator, "adVisibilityValidator");
        Intrinsics.checkNotNullParameter(renderingImpressionTrackingListener, "renderingImpressionTrackingListener");
        Intrinsics.checkNotNullParameter(adStructureType, "adStructureType");
        return new mo1(context, new u7(adVisibilityValidator, new og0()), adResponse, adConfiguration, adStructureType, adIdStorageManager, renderingImpressionTrackingListener, (po1) null, adResponse.j());
    }
}
