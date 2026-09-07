package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.os.Looper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class pd1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ld1 f9917a;

    public final a31 a(Context context, o3 adConfiguration, qk0 impressionReporter, c62 trackingChecker, String viewControllerDescription, s9 adStructureType) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(impressionReporter, "impressionReporter");
        Intrinsics.checkNotNullParameter(trackingChecker, "trackingChecker");
        Intrinsics.checkNotNullParameter(viewControllerDescription, "viewControllerDescription");
        Intrinsics.checkNotNullParameter(adStructureType, "adStructureType");
        kd1 kd1VarA = this.f9917a.a(impressionReporter, adStructureType);
        Looper mainLooper = Looper.getMainLooper();
        Intrinsics.checkNotNullExpressionValue(mainLooper, "getMainLooper(...)");
        a31.a aVar = new a31.a(mainLooper, kd1VarA);
        v9 v9Var = new v9(context, adConfiguration);
        int i = iw1.l;
        return new a31(context, adConfiguration, kd1VarA, trackingChecker, viewControllerDescription, adStructureType, aVar, v9Var, iw1.a.a(), new k62());
    }

    public /* synthetic */ pd1() {
        this(new ld1());
    }

    public pd1(ld1 noticeReportControllerCreator) {
        Intrinsics.checkNotNullParameter(noticeReportControllerCreator, "noticeReportControllerCreator");
        this.f9917a = noticeReportControllerCreator;
    }
}
