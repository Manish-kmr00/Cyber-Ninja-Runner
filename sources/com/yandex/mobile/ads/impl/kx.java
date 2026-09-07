package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class kx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final uw f9456a;
    private final vx b;
    private final List<mz0> c;
    private final xw d;
    private final ex e;
    private final lx f;

    public kx(uw appData, vx sdkData, ArrayList mediationNetworksData, xw consentsData, ex debugErrorIndicatorData, lx lxVar) {
        Intrinsics.checkNotNullParameter(appData, "appData");
        Intrinsics.checkNotNullParameter(sdkData, "sdkData");
        Intrinsics.checkNotNullParameter(mediationNetworksData, "mediationNetworksData");
        Intrinsics.checkNotNullParameter(consentsData, "consentsData");
        Intrinsics.checkNotNullParameter(debugErrorIndicatorData, "debugErrorIndicatorData");
        this.f9456a = appData;
        this.b = sdkData;
        this.c = mediationNetworksData;
        this.d = consentsData;
        this.e = debugErrorIndicatorData;
        this.f = lxVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof kx)) {
            return false;
        }
        kx kxVar = (kx) obj;
        return Intrinsics.areEqual(this.f9456a, kxVar.f9456a) && Intrinsics.areEqual(this.b, kxVar.b) && Intrinsics.areEqual(this.c, kxVar.c) && Intrinsics.areEqual(this.d, kxVar.d) && Intrinsics.areEqual(this.e, kxVar.e) && Intrinsics.areEqual(this.f, kxVar.f);
    }

    public final int hashCode() {
        int iHashCode = (this.e.hashCode() + ((this.d.hashCode() + aa.a(this.c, (this.b.hashCode() + (this.f9456a.hashCode() * 31)) * 31, 31)) * 31)) * 31;
        lx lxVar = this.f;
        return iHashCode + (lxVar == null ? 0 : lxVar.hashCode());
    }

    public final String toString() {
        return "DebugPanelLocalData(appData=" + this.f9456a + ", sdkData=" + this.b + ", mediationNetworksData=" + this.c + ", consentsData=" + this.d + ", debugErrorIndicatorData=" + this.e + ", logsData=" + this.f + ")";
    }

    public final uw a() {
        return this.f9456a;
    }

    public final vx f() {
        return this.b;
    }

    public final List<mz0> e() {
        return this.c;
    }

    public final xw b() {
        return this.d;
    }

    public final ex c() {
        return this.e;
    }

    public final lx d() {
        return this.f;
    }
}
