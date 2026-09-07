package com.moloco.sdk.internal.services.bidtoken.providers;

import com.moloco.sdk.internal.services.a0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f6339a;
    public final Integer b;
    public final Boolean c;
    public final a0 d;

    public r() {
        this(null, null, null, null, 15, null);
    }

    public final Integer a() {
        return this.f6339a;
    }

    public final Integer b() {
        return this.b;
    }

    public final Boolean c() {
        return this.c;
    }

    public final a0 d() {
        return this.d;
    }

    public final Integer e() {
        return this.f6339a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return Intrinsics.areEqual(this.f6339a, rVar.f6339a) && Intrinsics.areEqual(this.b, rVar.b) && Intrinsics.areEqual(this.c, rVar.c) && Intrinsics.areEqual(this.d, rVar.d);
    }

    public final Integer f() {
        return this.b;
    }

    public final Boolean g() {
        return this.c;
    }

    public final a0 h() {
        return this.d;
    }

    public int hashCode() {
        Integer num = this.f6339a;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.b;
        int iHashCode2 = (iHashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Boolean bool = this.c;
        int iHashCode3 = (iHashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        a0 a0Var = this.d;
        return iHashCode3 + (a0Var != null ? a0Var.hashCode() : 0);
    }

    public String toString() {
        return "NetworkInfoSignal(mobileCountryCode=" + this.f6339a + ", mobileNetworkCode=" + this.b + ", networkRestricted=" + this.c + ", networkType=" + this.d + ')';
    }

    public r(Integer num, Integer num2, Boolean bool, a0 a0Var) {
        this.f6339a = num;
        this.b = num2;
        this.c = bool;
        this.d = a0Var;
    }

    public final r a(Integer num, Integer num2, Boolean bool, a0 a0Var) {
        return new r(num, num2, bool, a0Var);
    }

    public static /* synthetic */ r a(r rVar, Integer num, Integer num2, Boolean bool, a0 a0Var, int i, Object obj) {
        if ((i & 1) != 0) {
            num = rVar.f6339a;
        }
        if ((i & 2) != 0) {
            num2 = rVar.b;
        }
        if ((i & 4) != 0) {
            bool = rVar.c;
        }
        if ((i & 8) != 0) {
            a0Var = rVar.d;
        }
        return rVar.a(num, num2, bool, a0Var);
    }

    public /* synthetic */ r(Integer num, Integer num2, Boolean bool, a0 a0Var, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : bool, (i & 8) != 0 ? null : a0Var);
    }
}
