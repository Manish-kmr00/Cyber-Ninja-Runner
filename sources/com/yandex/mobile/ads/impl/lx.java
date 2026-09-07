package com.yandex.mobile.ads.impl;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class lx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<q11> f9573a;
    private final List<i11> b;

    public lx(List<q11> sdkLogs, List<i11> networkLogs) {
        Intrinsics.checkNotNullParameter(sdkLogs, "sdkLogs");
        Intrinsics.checkNotNullParameter(networkLogs, "networkLogs");
        this.f9573a = sdkLogs;
        this.b = networkLogs;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof lx)) {
            return false;
        }
        lx lxVar = (lx) obj;
        return Intrinsics.areEqual(this.f9573a, lxVar.f9573a) && Intrinsics.areEqual(this.b, lxVar.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.f9573a.hashCode() * 31);
    }

    public final String toString() {
        return "DebugPanelLogsData(sdkLogs=" + this.f9573a + ", networkLogs=" + this.b + ")";
    }

    public final List<q11> b() {
        return this.f9573a;
    }

    public final List<i11> a() {
        return this.b;
    }
}
