package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class je {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9308a;
    private final String b;

    public je(ke appAdAnalyticsReportType, JSONObject payloadJson) {
        Intrinsics.checkNotNullParameter(appAdAnalyticsReportType, "appAdAnalyticsReportType");
        Intrinsics.checkNotNullParameter(payloadJson, "payloadJson");
        this.f9308a = appAdAnalyticsReportType.a();
        String string = payloadJson.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        this.b = string;
    }

    public final String a() {
        return this.f9308a;
    }

    public final String b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof je)) {
            return false;
        }
        je jeVar = (je) obj;
        return Intrinsics.areEqual(jeVar.f9308a, this.f9308a) && Intrinsics.areEqual(jeVar.b, this.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.f9308a.hashCode() * 31);
    }
}
