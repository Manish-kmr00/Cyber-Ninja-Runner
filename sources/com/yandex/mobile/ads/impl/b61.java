package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class b61 {
    public static l61 a(Context context, o3 adConfiguration, g5 adLoadingPhasesManager, f61 nativeAdLoadingFinishedListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(adLoadingPhasesManager, "adLoadingPhasesManager");
        Intrinsics.checkNotNullParameter(nativeAdLoadingFinishedListener, "nativeAdLoadingFinishedListener");
        return new l61(context, adConfiguration, adLoadingPhasesManager, nativeAdLoadingFinishedListener);
    }
}
