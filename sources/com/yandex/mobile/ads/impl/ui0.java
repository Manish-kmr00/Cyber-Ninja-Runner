package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class ui0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final df f10387a;
    private final String b;
    private final zi0 c;

    public ui0(df appMetricaIdentifiers, String mauid, zi0 identifiersType) {
        Intrinsics.checkNotNullParameter(appMetricaIdentifiers, "appMetricaIdentifiers");
        Intrinsics.checkNotNullParameter(mauid, "mauid");
        Intrinsics.checkNotNullParameter(identifiersType, "identifiersType");
        this.f10387a = appMetricaIdentifiers;
        this.b = mauid;
        this.c = identifiersType;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ui0)) {
            return false;
        }
        ui0 ui0Var = (ui0) obj;
        return Intrinsics.areEqual(this.f10387a, ui0Var.f10387a) && Intrinsics.areEqual(this.b, ui0Var.b) && this.c == ui0Var.c;
    }

    public final int hashCode() {
        return this.c.hashCode() + v3.a(this.b, this.f10387a.hashCode() * 31, 31);
    }

    public final String toString() {
        return "Identifiers(appMetricaIdentifiers=" + this.f10387a + ", mauid=" + this.b + ", identifiersType=" + this.c + ")";
    }

    public final df a() {
        return this.f10387a;
    }

    public final String c() {
        return this.b;
    }

    public final zi0 b() {
        return this.c;
    }
}
