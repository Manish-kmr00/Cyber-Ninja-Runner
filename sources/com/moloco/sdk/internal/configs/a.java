package com.moloco.sdk.internal.configs;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class a {
    public static final int c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6078a;
    public final int b;

    public a(String reportingUrl, int i) {
        Intrinsics.checkNotNullParameter(reportingUrl, "reportingUrl");
        this.f6078a = reportingUrl;
        this.b = i;
    }

    public final String a() {
        return this.f6078a;
    }

    public final int b() {
        return this.b;
    }

    public final int c() {
        return this.b;
    }

    public final String d() {
        return this.f6078a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.areEqual(this.f6078a, aVar.f6078a) && this.b == aVar.b;
    }

    public int hashCode() {
        return (this.f6078a.hashCode() * 31) + Integer.hashCode(this.b);
    }

    public String toString() {
        return "OperationalMetricsConfig(reportingUrl=" + this.f6078a + ", pollingIntervalSeconds=" + this.b + ')';
    }

    public final a a(String reportingUrl, int i) {
        Intrinsics.checkNotNullParameter(reportingUrl, "reportingUrl");
        return new a(reportingUrl, i);
    }

    public static /* synthetic */ a a(a aVar, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = aVar.f6078a;
        }
        if ((i2 & 2) != 0) {
            i = aVar.b;
        }
        return aVar.a(str, i);
    }
}
