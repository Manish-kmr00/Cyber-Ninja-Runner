package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class mx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9675a;
    private final String b;

    public mx(String name, String value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        this.f9675a = name;
        this.b = value;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof mx)) {
            return false;
        }
        mx mxVar = (mx) obj;
        return Intrinsics.areEqual(this.f9675a, mxVar.f9675a) && Intrinsics.areEqual(this.b, mxVar.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.f9675a.hashCode() * 31);
    }

    public final String toString() {
        return "DebugPanelMediationAdapterParameterData(name=" + this.f9675a + ", value=" + this.b + ")";
    }

    public final String a() {
        return this.f9675a;
    }

    public final String b() {
        return this.b;
    }
}
