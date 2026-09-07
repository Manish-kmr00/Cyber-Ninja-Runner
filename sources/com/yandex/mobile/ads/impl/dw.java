package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class dw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f8738a;
    private final String b;
    private final String c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dw)) {
            return false;
        }
        dw dwVar = (dw) obj;
        return Intrinsics.areEqual(this.f8738a, dwVar.f8738a) && Intrinsics.areEqual(this.b, dwVar.b) && Intrinsics.areEqual(this.c, dwVar.c);
    }

    public final int hashCode() {
        String str = this.f8738a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.b;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.c;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        return "DebugPanelAdNetworkSettingsData(pageId=" + this.f8738a + ", appReviewStatus=" + this.b + ", appAdsTxt=" + this.c + ")";
    }

    public dw(String str, String str2, String str3) {
        this.f8738a = str;
        this.b = str2;
        this.c = str3;
    }

    public final String c() {
        return this.f8738a;
    }

    public final String b() {
        return this.b;
    }

    public final String a() {
        return this.c;
    }
}
