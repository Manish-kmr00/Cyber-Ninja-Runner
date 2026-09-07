package com.yandex.mobile.ads.impl;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class yw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final uw f10774a;
    private final vx b;
    private final dw c;
    private final qw d;
    private final xw e;
    private final ex f;
    private final List<ew> g;
    private final List<sw> h;

    public yw(uw appData, vx sdkData, dw networkSettingsData, qw adaptersData, xw consentsData, ex debugErrorIndicatorData, List<ew> adUnits, List<sw> alerts) {
        Intrinsics.checkNotNullParameter(appData, "appData");
        Intrinsics.checkNotNullParameter(sdkData, "sdkData");
        Intrinsics.checkNotNullParameter(networkSettingsData, "networkSettingsData");
        Intrinsics.checkNotNullParameter(adaptersData, "adaptersData");
        Intrinsics.checkNotNullParameter(consentsData, "consentsData");
        Intrinsics.checkNotNullParameter(debugErrorIndicatorData, "debugErrorIndicatorData");
        Intrinsics.checkNotNullParameter(adUnits, "adUnits");
        Intrinsics.checkNotNullParameter(alerts, "alerts");
        this.f10774a = appData;
        this.b = sdkData;
        this.c = networkSettingsData;
        this.d = adaptersData;
        this.e = consentsData;
        this.f = debugErrorIndicatorData;
        this.g = adUnits;
        this.h = alerts;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof yw)) {
            return false;
        }
        yw ywVar = (yw) obj;
        return Intrinsics.areEqual(this.f10774a, ywVar.f10774a) && Intrinsics.areEqual(this.b, ywVar.b) && Intrinsics.areEqual(this.c, ywVar.c) && Intrinsics.areEqual(this.d, ywVar.d) && Intrinsics.areEqual(this.e, ywVar.e) && Intrinsics.areEqual(this.f, ywVar.f) && Intrinsics.areEqual(this.g, ywVar.g) && Intrinsics.areEqual(this.h, ywVar.h);
    }

    public final int hashCode() {
        return this.h.hashCode() + aa.a(this.g, (this.f.hashCode() + ((this.e.hashCode() + ((this.d.hashCode() + ((this.c.hashCode() + ((this.b.hashCode() + (this.f10774a.hashCode() * 31)) * 31)) * 31)) * 31)) * 31)) * 31, 31);
    }

    public final String toString() {
        return "DebugPanelData(appData=" + this.f10774a + ", sdkData=" + this.b + ", networkSettingsData=" + this.c + ", adaptersData=" + this.d + ", consentsData=" + this.e + ", debugErrorIndicatorData=" + this.f + ", adUnits=" + this.g + ", alerts=" + this.h + ")";
    }

    public final uw d() {
        return this.f10774a;
    }

    public final vx h() {
        return this.b;
    }

    public final dw g() {
        return this.c;
    }

    public final qw b() {
        return this.d;
    }

    public final xw e() {
        return this.e;
    }

    public final ex f() {
        return this.f;
    }

    public final List<ew> a() {
        return this.g;
    }

    public final List<sw> c() {
        return this.h;
    }
}
