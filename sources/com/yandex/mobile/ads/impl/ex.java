package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes3.dex */
public final class ex {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f8838a;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ex) && this.f8838a == ((ex) obj).f8838a;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f8838a);
    }

    public final String toString() {
        return "DebugPanelErrorIndicatorData(isEnabled=" + this.f8838a + ")";
    }

    public ex(boolean z) {
        this.f8838a = z;
    }

    public final boolean a() {
        return this.f8838a;
    }
}
