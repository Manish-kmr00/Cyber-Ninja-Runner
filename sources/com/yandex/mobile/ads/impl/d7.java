package com.yandex.mobile.ads.impl;

import com.monetization.ads.quality.base.model.configuration.AdQualityVerifiableNetwork;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f8667a;
    private final boolean b;
    private final boolean c;
    private final Map<AdQualityVerifiableNetwork, m7> d;
    private final Set<String> e;

    public d7(int i, boolean z, boolean z2, LinkedHashMap adNetworksCustomParameters, Set enabledAdUnits) {
        Intrinsics.checkNotNullParameter(adNetworksCustomParameters, "adNetworksCustomParameters");
        Intrinsics.checkNotNullParameter(enabledAdUnits, "enabledAdUnits");
        this.f8667a = i;
        this.b = z;
        this.c = z2;
        this.d = adNetworksCustomParameters;
        this.e = enabledAdUnits;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d7)) {
            return false;
        }
        d7 d7Var = (d7) obj;
        return this.f8667a == d7Var.f8667a && this.b == d7Var.b && this.c == d7Var.c && Intrinsics.areEqual(this.d, d7Var.d) && Intrinsics.areEqual(this.e, d7Var.e);
    }

    public final int hashCode() {
        return this.e.hashCode() + ((this.d.hashCode() + a7.a(this.c, a7.a(this.b, Integer.hashCode(this.f8667a) * 31, 31), 31)) * 31);
    }

    public final String toString() {
        return "AdQualityVerificationPolicy(usagePercent=" + this.f8667a + ", enabled=" + this.b + ", blockAdOnInternalError=" + this.c + ", adNetworksCustomParameters=" + this.d + ", enabledAdUnits=" + this.e + ")";
    }

    public final int e() {
        return this.f8667a;
    }

    public final boolean c() {
        return this.b;
    }

    public final boolean b() {
        return this.c;
    }

    public final Map<AdQualityVerifiableNetwork, m7> a() {
        return this.d;
    }

    public final Set<String> d() {
        return this.e;
    }
}
