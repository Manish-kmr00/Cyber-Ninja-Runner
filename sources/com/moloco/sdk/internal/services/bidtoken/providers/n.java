package com.moloco.sdk.internal.services.bidtoken.providers;

import com.moloco.sdk.internal.services.h0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h0 f6337a;
    public final String b;
    public final String c;

    public n() {
        this(null, null, null, 7, null);
    }

    public final h0 a() {
        return this.f6337a;
    }

    public final String b() {
        return this.b;
    }

    public final String c() {
        return this.c;
    }

    public final String d() {
        return this.c;
    }

    public final String e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return this.f6337a == nVar.f6337a && Intrinsics.areEqual(this.b, nVar.b) && Intrinsics.areEqual(this.c, nVar.c);
    }

    public final h0 f() {
        return this.f6337a;
    }

    public int hashCode() {
        h0 h0Var = this.f6337a;
        int iHashCode = (h0Var == null ? 0 : h0Var.hashCode()) * 31;
        String str = this.b;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.c;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "DeviceSignalInfo(orientation=" + this.f6337a + ", locale=" + this.b + ", keyboardLocale=" + this.c + ')';
    }

    public n(h0 h0Var, String str, String str2) {
        this.f6337a = h0Var;
        this.b = str;
        this.c = str2;
    }

    public final n a(h0 h0Var, String str, String str2) {
        return new n(h0Var, str, str2);
    }

    public static /* synthetic */ n a(n nVar, h0 h0Var, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            h0Var = nVar.f6337a;
        }
        if ((i & 2) != 0) {
            str = nVar.b;
        }
        if ((i & 4) != 0) {
            str2 = nVar.c;
        }
        return nVar.a(h0Var, str, str2);
    }

    public /* synthetic */ n(h0 h0Var, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : h0Var, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2);
    }
}
