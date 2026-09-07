package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class yy0 implements h62 {
    @Override // com.yandex.mobile.ads.impl.h62
    public final void a(c71 nativeAdViewAdapter) {
        Intrinsics.checkNotNullParameter(nativeAdViewAdapter, "nativeAdViewAdapter");
    }

    @Override // com.yandex.mobile.ads.impl.h62
    public final void a(rk0 impressionTrackingListener) {
        Intrinsics.checkNotNullParameter(impressionTrackingListener, "impressionTrackingListener");
    }

    @Override // com.yandex.mobile.ads.impl.h62
    public final void a(q91 reportParameterManager) {
        Intrinsics.checkNotNullParameter(reportParameterManager, "reportParameterManager");
    }

    @Override // com.yandex.mobile.ads.impl.h62
    public final void a(Context context, ch1.b phoneStateListener, c71 c71Var) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(phoneStateListener, "phoneStateListener");
    }

    @Override // com.yandex.mobile.ads.impl.h62
    public final void a(Context context, ch1.b phoneStateListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(phoneStateListener, "phoneStateListener");
    }

    @Override // com.yandex.mobile.ads.impl.h62
    public final void a(o8<?> adResponse, List<xx1> showNotices) {
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(showNotices, "showNotices");
    }
}
