package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class hw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9141a;
    private final String b;
    private final String c;
    private final kw d;

    public hw(String name, String format, String adUnitId, kw mediation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(format, "format");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(mediation, "mediation");
        this.f9141a = name;
        this.b = format;
        this.c = adUnitId;
        this.d = mediation;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof hw)) {
            return false;
        }
        hw hwVar = (hw) obj;
        return Intrinsics.areEqual(this.f9141a, hwVar.f9141a) && Intrinsics.areEqual(this.b, hwVar.b) && Intrinsics.areEqual(this.c, hwVar.c) && Intrinsics.areEqual(this.d, hwVar.d);
    }

    public final int hashCode() {
        return this.d.hashCode() + v3.a(this.c, v3.a(this.b, this.f9141a.hashCode() * 31, 31), 31);
    }

    public final String toString() {
        return "DebugPanelAdUnitFullData(name=" + this.f9141a + ", format=" + this.b + ", adUnitId=" + this.c + ", mediation=" + this.d + ")";
    }

    public final String d() {
        return this.f9141a;
    }

    public final String b() {
        return this.b;
    }

    public final String a() {
        return this.c;
    }

    public final kw c() {
        return this.d;
    }
}
