package com.inmobi.media;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class K4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EnumC3396h6 f3111a;
    public final double b;

    public K4(EnumC3396h6 logLevel, double d) {
        Intrinsics.checkNotNullParameter(logLevel, "logLevel");
        this.f3111a = logLevel;
        this.b = d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof K4)) {
            return false;
        }
        K4 k4 = (K4) obj;
        return this.f3111a == k4.f3111a && Double.compare(this.b, k4.b) == 0;
    }

    public final int hashCode() {
        return Double.hashCode(this.b) + (this.f3111a.hashCode() * 31);
    }

    public final String toString() {
        return "LoggerConfiguration(logLevel=" + this.f3111a + ", samplingFactor=" + this.b + ')';
    }
}
