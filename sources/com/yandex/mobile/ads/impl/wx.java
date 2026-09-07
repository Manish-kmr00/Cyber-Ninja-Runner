package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class wx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10600a;
    private final xx b;

    public wx(String sdkVersion, xx sdkIntegrationStatusData) {
        Intrinsics.checkNotNullParameter(sdkVersion, "sdkVersion");
        Intrinsics.checkNotNullParameter(sdkIntegrationStatusData, "sdkIntegrationStatusData");
        this.f10600a = sdkVersion;
        this.b = sdkIntegrationStatusData;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof wx)) {
            return false;
        }
        wx wxVar = (wx) obj;
        return Intrinsics.areEqual(this.f10600a, wxVar.f10600a) && Intrinsics.areEqual(this.b, wxVar.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.f10600a.hashCode() * 31);
    }

    public final String toString() {
        return "DebugPanelSdkIntegrationData(sdkVersion=" + this.f10600a + ", sdkIntegrationStatusData=" + this.b + ")";
    }

    public final String b() {
        return this.f10600a;
    }

    public final xx a() {
        return this.b;
    }
}
