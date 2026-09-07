package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class kw1 implements h62 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final od1 f9455a;
    private final mo1 b;
    private final yk0 c;
    private final ch1 d;

    public kw1(a31 noticeTrackingManager, mo1 renderTrackingManager, yk0 indicatorManager, ch1 phoneStateTracker) {
        Intrinsics.checkNotNullParameter(noticeTrackingManager, "noticeTrackingManager");
        Intrinsics.checkNotNullParameter(renderTrackingManager, "renderTrackingManager");
        Intrinsics.checkNotNullParameter(indicatorManager, "indicatorManager");
        Intrinsics.checkNotNullParameter(phoneStateTracker, "phoneStateTracker");
        this.f9455a = noticeTrackingManager;
        this.b = renderTrackingManager;
        this.c = indicatorManager;
        this.d = phoneStateTracker;
    }

    @Override // com.yandex.mobile.ads.impl.h62
    public final void a(c71 nativeAdViewAdapter) {
        Intrinsics.checkNotNullParameter(nativeAdViewAdapter, "nativeAdViewAdapter");
        this.c.a(nativeAdViewAdapter);
    }

    @Override // com.yandex.mobile.ads.impl.h62
    public final void a(rk0 impressionTrackingListener) {
        Intrinsics.checkNotNullParameter(impressionTrackingListener, "impressionTrackingListener");
        this.f9455a.a(impressionTrackingListener);
    }

    @Override // com.yandex.mobile.ads.impl.h62
    public final void a(q91 reportParameterManager) {
        Intrinsics.checkNotNullParameter(reportParameterManager, "reportParameterManager");
        this.b.a(reportParameterManager);
    }

    @Override // com.yandex.mobile.ads.impl.h62
    public final void a(Context context, ch1.b phoneStateListener, c71 c71Var) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(phoneStateListener, "phoneStateListener");
        this.b.b();
        this.f9455a.b();
        this.d.a(phoneStateListener);
        if (c71Var != null) {
            this.c.a(context, c71Var);
        }
    }

    @Override // com.yandex.mobile.ads.impl.h62
    public final void a(Context context, ch1.b phoneStateListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(phoneStateListener, "phoneStateListener");
        this.b.c();
        this.f9455a.a();
        this.d.b(phoneStateListener);
        this.c.a();
    }

    @Override // com.yandex.mobile.ads.impl.h62
    public final void a(o8<?> adResponse, List<xx1> showNotices) {
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(showNotices, "showNotices");
        this.f9455a.a(adResponse, showNotices);
    }
}
