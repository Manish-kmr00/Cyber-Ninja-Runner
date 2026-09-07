package com.yandex.mobile.ads.impl;

import java.util.List;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class l62 implements kd1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final qk0 f9484a;
    private final sk0 b;
    private boolean c;
    private int d;
    private boolean e;
    private boolean f;

    public l62(qk0 impressionReporter, sk0 impressionTrackingReportTypes) {
        Intrinsics.checkNotNullParameter(impressionReporter, "impressionReporter");
        Intrinsics.checkNotNullParameter(impressionTrackingReportTypes, "impressionTrackingReportTypes");
        this.f9484a = impressionReporter;
        this.b = impressionTrackingReportTypes;
    }

    @Override // com.yandex.mobile.ads.impl.kd1
    public final void a(yx1 showNoticeType, f92 validationResult) {
        Intrinsics.checkNotNullParameter(showNoticeType, "showNoticeType");
        Intrinsics.checkNotNullParameter(validationResult, "validationResult");
        int i = this.d + 1;
        this.d = i;
        if (i == 20) {
            this.e = true;
            this.f9484a.b(this.b.b(), validationResult);
        }
    }

    @Override // com.yandex.mobile.ads.impl.kd1
    public final void a(List<qd1> forcedFailures) {
        Intrinsics.checkNotNullParameter(forcedFailures, "forcedFailures");
        qd1 qd1Var = (qd1) CollectionsKt.firstOrNull((List) forcedFailures);
        if (qd1Var == null) {
            return;
        }
        this.f9484a.a(this.b.a(), qd1Var.b());
    }

    @Override // com.yandex.mobile.ads.impl.kd1
    public final void invalidate() {
        this.c = false;
        this.d = 0;
        this.e = false;
        this.f = false;
    }

    @Override // com.yandex.mobile.ads.impl.kd1
    public final void a(yx1 showNoticeType, List<? extends yx1> notTrackedShowNoticeTypes) {
        Intrinsics.checkNotNullParameter(showNoticeType, "showNoticeType");
        Intrinsics.checkNotNullParameter(notTrackedShowNoticeTypes, "notTrackedShowNoticeTypes");
        if (this.f) {
            return;
        }
        this.f = true;
        this.f9484a.a(this.b.d(), MapsKt.mapOf(TuplesKt.to("failure_tracked", Boolean.valueOf(this.e))));
    }

    @Override // com.yandex.mobile.ads.impl.kd1
    public final void a(yx1 showNoticeType) {
        Intrinsics.checkNotNullParameter(showNoticeType, "showNoticeType");
        if (this.c) {
            return;
        }
        this.c = true;
        this.f9484a.a(this.b.c());
    }

    @Override // com.yandex.mobile.ads.impl.kd1
    public final void a(o8<?> adResponse) {
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        this.f9484a.a(adResponse);
    }
}
