package com.moloco.sdk.internal.services.bidtoken.providers;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f6333a;
    public final Integer b;
    public final Boolean c;

    public h() {
        this(null, null, null, 7, null);
    }

    public final Integer a() {
        return this.f6333a;
    }

    public final Integer b() {
        return this.b;
    }

    public final Boolean c() {
        return this.c;
    }

    public final Integer d() {
        return this.b;
    }

    public final Integer e() {
        return this.f6333a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return Intrinsics.areEqual(this.f6333a, hVar.f6333a) && Intrinsics.areEqual(this.b, hVar.b) && Intrinsics.areEqual(this.c, hVar.c);
    }

    public final Boolean f() {
        return this.c;
    }

    public int hashCode() {
        Integer num = this.f6333a;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.b;
        int iHashCode2 = (iHashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Boolean bool = this.c;
        return iHashCode2 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        return "BatteryInfoSignal(maxBatteryLevel=" + this.f6333a + ", batteryStatus=" + this.b + ", isPowerSaveMode=" + this.c + ')';
    }

    public h(Integer num, Integer num2, Boolean bool) {
        this.f6333a = num;
        this.b = num2;
        this.c = bool;
    }

    public final h a(Integer num, Integer num2, Boolean bool) {
        return new h(num, num2, bool);
    }

    public static /* synthetic */ h a(h hVar, Integer num, Integer num2, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            num = hVar.f6333a;
        }
        if ((i & 2) != 0) {
            num2 = hVar.b;
        }
        if ((i & 4) != 0) {
            bool = hVar.c;
        }
        return hVar.a(num, num2, bool);
    }

    public /* synthetic */ h(Integer num, Integer num2, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : bool);
    }
}
