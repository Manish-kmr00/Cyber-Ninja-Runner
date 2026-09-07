package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class gw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9038a;
    private final String b;
    private final String c;

    public gw(String name, String format, String adUnitId) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(format, "format");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        this.f9038a = name;
        this.b = format;
        this.c = adUnitId;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof gw)) {
            return false;
        }
        gw gwVar = (gw) obj;
        return Intrinsics.areEqual(this.f9038a, gwVar.f9038a) && Intrinsics.areEqual(this.b, gwVar.b) && Intrinsics.areEqual(this.c, gwVar.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + v3.a(this.b, this.f9038a.hashCode() * 31, 31);
    }

    public final String toString() {
        return "DebugPanelAdUnitData(name=" + this.f9038a + ", format=" + this.b + ", adUnitId=" + this.c + ")";
    }

    public final String c() {
        return this.f9038a;
    }

    public final String b() {
        return this.b;
    }

    public final String a() {
        return this.c;
    }
}
