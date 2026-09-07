package com.ogury.ad.internal;

import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class g8 implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f7308a;
    public String b;

    public g8() {
        Intrinsics.checkNotNullParameter("", "name");
        Intrinsics.checkNotNullParameter("", "value");
        this.f7308a = "";
        this.b = "";
    }

    public final String a() {
        return this.f7308a;
    }

    public final String b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g8)) {
            return false;
        }
        g8 g8Var = (g8) obj;
        return Intrinsics.areEqual(this.f7308a, g8Var.f7308a) && Intrinsics.areEqual(this.b, g8Var.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.f7308a.hashCode() * 31);
    }

    public final String toString() {
        return "RewardItem(name=" + this.f7308a + ", value=" + this.b + ")";
    }
}
