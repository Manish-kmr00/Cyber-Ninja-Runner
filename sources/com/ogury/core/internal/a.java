package com.ogury.core.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AdInfo.kt */
/* JADX INFO: loaded from: classes12.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7486a;
    public final boolean b;

    public a(String id, boolean z) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.f7486a = id;
        this.b = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.areEqual(this.f7486a, aVar.f7486a) && this.b == aVar.b;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.b) + (this.f7486a.hashCode() * 31);
    }

    public final String toString() {
        return "AdInfo(id=" + this.f7486a + ", isLimitAdTrackingEnabled=" + this.b + ")";
    }
}
