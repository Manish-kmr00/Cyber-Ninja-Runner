package com.ogury.ad.internal;

import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class n2 implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f7362a;
    public final o2 b;

    public n2() {
        this(0);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n2)) {
            return false;
        }
        n2 n2Var = (n2) obj;
        return this.f7362a == n2Var.f7362a && this.b == n2Var.b;
    }

    public final int hashCode() {
        return this.b.hashCode() + (Boolean.hashCode(this.f7362a) * 31);
    }

    public final String toString() {
        return "ImpressionSettings(isPaidImpression=" + this.f7362a + ", impressionSource=" + this.b + ")";
    }

    public n2(boolean z, o2 impressionSource) {
        Intrinsics.checkNotNullParameter(impressionSource, "impressionSource");
        this.f7362a = z;
        this.b = impressionSource;
    }

    public /* synthetic */ n2(int i) {
        this(false, o2.IMPRESSION_SOURCE_FORMAT);
    }
}
