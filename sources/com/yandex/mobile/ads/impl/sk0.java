package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class sk0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final hp1.b f10214a;
    private final hp1.b b;
    private final hp1.b c;
    private final hp1.b d;

    public sk0(hp1.b impressionTrackingSuccessReportType, hp1.b impressionTrackingStartReportType, hp1.b impressionTrackingFailureReportType, hp1.b forcedImpressionTrackingFailureReportType) {
        Intrinsics.checkNotNullParameter(impressionTrackingSuccessReportType, "impressionTrackingSuccessReportType");
        Intrinsics.checkNotNullParameter(impressionTrackingStartReportType, "impressionTrackingStartReportType");
        Intrinsics.checkNotNullParameter(impressionTrackingFailureReportType, "impressionTrackingFailureReportType");
        Intrinsics.checkNotNullParameter(forcedImpressionTrackingFailureReportType, "forcedImpressionTrackingFailureReportType");
        this.f10214a = impressionTrackingSuccessReportType;
        this.b = impressionTrackingStartReportType;
        this.c = impressionTrackingFailureReportType;
        this.d = forcedImpressionTrackingFailureReportType;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof sk0)) {
            return false;
        }
        sk0 sk0Var = (sk0) obj;
        return this.f10214a == sk0Var.f10214a && this.b == sk0Var.b && this.c == sk0Var.c && this.d == sk0Var.d;
    }

    public final int hashCode() {
        return this.d.hashCode() + ((this.c.hashCode() + ((this.b.hashCode() + (this.f10214a.hashCode() * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "ImpressionTrackingReportTypes(impressionTrackingSuccessReportType=" + this.f10214a + ", impressionTrackingStartReportType=" + this.b + ", impressionTrackingFailureReportType=" + this.c + ", forcedImpressionTrackingFailureReportType=" + this.d + ")";
    }

    public final hp1.b d() {
        return this.f10214a;
    }

    public final hp1.b c() {
        return this.b;
    }

    public final hp1.b b() {
        return this.c;
    }

    public final hp1.b a() {
        return this.d;
    }
}
