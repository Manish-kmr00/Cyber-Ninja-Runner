package com.yandex.mobile.ads.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class oa2 implements bg2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9799a;
    private final kq0 b;
    private final String c;
    private final Map<String, List<String>> d;

    public oa2(String vendor, kq0 kq0Var, String str, HashMap events) {
        Intrinsics.checkNotNullParameter(vendor, "vendor");
        Intrinsics.checkNotNullParameter(events, "events");
        this.f9799a = vendor;
        this.b = kq0Var;
        this.c = str;
        this.d = events;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof oa2)) {
            return false;
        }
        oa2 oa2Var = (oa2) obj;
        return Intrinsics.areEqual(this.f9799a, oa2Var.f9799a) && Intrinsics.areEqual(this.b, oa2Var.b) && Intrinsics.areEqual(this.c, oa2Var.c) && Intrinsics.areEqual(this.d, oa2Var.d);
    }

    public final int hashCode() {
        int iHashCode = this.f9799a.hashCode() * 31;
        kq0 kq0Var = this.b;
        int iHashCode2 = (iHashCode + (kq0Var == null ? 0 : kq0Var.hashCode())) * 31;
        String str = this.c;
        return this.d.hashCode() + ((iHashCode2 + (str != null ? str.hashCode() : 0)) * 31);
    }

    public final String toString() {
        return "Verification(vendor=" + this.f9799a + ", javaScriptResource=" + this.b + ", parameters=" + this.c + ", events=" + this.d + ")";
    }

    public final String d() {
        return this.f9799a;
    }

    public final kq0 b() {
        return this.b;
    }

    public final String c() {
        return this.c;
    }

    @Override // com.yandex.mobile.ads.impl.bg2
    public final Map<String, List<String>> a() {
        Map<String, List<String>> mapUnmodifiableMap = Collections.unmodifiableMap(this.d);
        Intrinsics.checkNotNullExpressionValue(mapUnmodifiableMap, "unmodifiableMap(...)");
        return mapUnmodifiableMap;
    }
}
