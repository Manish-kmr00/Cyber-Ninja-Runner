package com.yandex.mobile.ads.impl;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class fx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<sw> f8942a;
    private final uw b;
    private final wx c;
    private final dw d;
    private final qw e;
    private final xw f;
    private final ex g;

    public fx(List<sw> alertsData, uw appData, wx sdkIntegrationData, dw adNetworkSettingsData, qw adaptersData, xw consentsData, ex debugErrorIndicatorData) {
        Intrinsics.checkNotNullParameter(alertsData, "alertsData");
        Intrinsics.checkNotNullParameter(appData, "appData");
        Intrinsics.checkNotNullParameter(sdkIntegrationData, "sdkIntegrationData");
        Intrinsics.checkNotNullParameter(adNetworkSettingsData, "adNetworkSettingsData");
        Intrinsics.checkNotNullParameter(adaptersData, "adaptersData");
        Intrinsics.checkNotNullParameter(consentsData, "consentsData");
        Intrinsics.checkNotNullParameter(debugErrorIndicatorData, "debugErrorIndicatorData");
        this.f8942a = alertsData;
        this.b = appData;
        this.c = sdkIntegrationData;
        this.d = adNetworkSettingsData;
        this.e = adaptersData;
        this.f = consentsData;
        this.g = debugErrorIndicatorData;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof fx)) {
            return false;
        }
        fx fxVar = (fx) obj;
        return Intrinsics.areEqual(this.f8942a, fxVar.f8942a) && Intrinsics.areEqual(this.b, fxVar.b) && Intrinsics.areEqual(this.c, fxVar.c) && Intrinsics.areEqual(this.d, fxVar.d) && Intrinsics.areEqual(this.e, fxVar.e) && Intrinsics.areEqual(this.f, fxVar.f) && Intrinsics.areEqual(this.g, fxVar.g);
    }

    public final int hashCode() {
        return this.g.hashCode() + ((this.f.hashCode() + ((this.e.hashCode() + ((this.d.hashCode() + ((this.c.hashCode() + ((this.b.hashCode() + (this.f8942a.hashCode() * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "DebugPanelFeedData(alertsData=" + this.f8942a + ", appData=" + this.b + ", sdkIntegrationData=" + this.c + ", adNetworkSettingsData=" + this.d + ", adaptersData=" + this.e + ", consentsData=" + this.f + ", debugErrorIndicatorData=" + this.g + ")";
    }

    public final uw c() {
        return this.b;
    }

    public final wx f() {
        return this.c;
    }

    public final dw a() {
        return this.d;
    }

    public final qw b() {
        return this.e;
    }

    public final xw d() {
        return this.f;
    }

    public final ex e() {
        return this.g;
    }
}
