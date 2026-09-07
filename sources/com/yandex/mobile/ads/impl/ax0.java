package com.yandex.mobile.ads.impl;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class ax0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final su0 f8451a;
    private final db2 b;
    private final List<uj0> c;

    public static ax0 a(ax0 ax0Var, db2 db2Var) {
        su0 su0Var = ax0Var.f8451a;
        List<uj0> list = ax0Var.c;
        ax0Var.getClass();
        return new ax0(su0Var, db2Var, list);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ax0)) {
            return false;
        }
        ax0 ax0Var = (ax0) obj;
        return Intrinsics.areEqual(this.f8451a, ax0Var.f8451a) && Intrinsics.areEqual(this.b, ax0Var.b) && Intrinsics.areEqual(this.c, ax0Var.c);
    }

    public final int hashCode() {
        su0 su0Var = this.f8451a;
        int iHashCode = (su0Var == null ? 0 : su0Var.hashCode()) * 31;
        db2 db2Var = this.b;
        int iHashCode2 = (iHashCode + (db2Var == null ? 0 : db2Var.hashCode())) * 31;
        List<uj0> list = this.c;
        return iHashCode2 + (list != null ? list.hashCode() : 0);
    }

    public final String toString() {
        return "MediaValue(media=" + this.f8451a + ", video=" + this.b + ", imageValues=" + this.c + ")";
    }

    public ax0(su0 su0Var, db2 db2Var, List<uj0> list) {
        this.f8451a = su0Var;
        this.b = db2Var;
        this.c = list;
    }

    public final su0 b() {
        return this.f8451a;
    }

    public final db2 c() {
        return this.b;
    }

    public final List<uj0> a() {
        return this.c;
    }
}
