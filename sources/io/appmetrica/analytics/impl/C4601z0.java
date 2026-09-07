package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.z0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C4601z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11867a;
    public final String b;
    public final CounterConfigurationReporterType c;
    public final int d;
    public final String e;
    public final String f;

    public C4601z0(String str, String str2, CounterConfigurationReporterType counterConfigurationReporterType, int i, String str3, String str4) {
        this.f11867a = str;
        this.b = str2;
        this.c = counterConfigurationReporterType;
        this.d = i;
        this.e = str3;
        this.f = str4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C4601z0)) {
            return false;
        }
        C4601z0 c4601z0 = (C4601z0) obj;
        return Intrinsics.areEqual(this.f11867a, c4601z0.f11867a) && Intrinsics.areEqual(this.b, c4601z0.b) && this.c == c4601z0.c && this.d == c4601z0.d && Intrinsics.areEqual(this.e, c4601z0.e) && Intrinsics.areEqual(this.f, c4601z0.f);
    }

    public final int hashCode() {
        int iHashCode = (this.e.hashCode() + ((Integer.hashCode(this.d) + ((this.c.hashCode() + ((this.b.hashCode() + (this.f11867a.hashCode() * 31)) * 31)) * 31)) * 31)) * 31;
        String str = this.f;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        return "AppMetricaNativeCrashMetadata(apiKey=" + this.f11867a + ", packageName=" + this.b + ", reporterType=" + this.c + ", processID=" + this.d + ", processSessionID=" + this.e + ", errorEnvironment=" + this.f + ')';
    }
}
