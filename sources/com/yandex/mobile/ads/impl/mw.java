package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class mw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<gw> f9673a;

    public mw(ArrayList adUnits) {
        Intrinsics.checkNotNullParameter(adUnits, "adUnits");
        this.f9673a = adUnits;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof mw) && Intrinsics.areEqual(this.f9673a, ((mw) obj).f9673a);
    }

    public final int hashCode() {
        return this.f9673a.hashCode();
    }

    public final String toString() {
        return "DebugPanelAdUnitsData(adUnits=" + this.f9673a + ")";
    }

    public final List<gw> a() {
        return this.f9673a;
    }
}
