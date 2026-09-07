package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class p02 implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9884a;
    private final List<s02> b;

    public p02(String actionType, ArrayList items) {
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        Intrinsics.checkNotNullParameter(items, "items");
        this.f9884a = actionType;
        this.b = items;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p02)) {
            return false;
        }
        p02 p02Var = (p02) obj;
        return Intrinsics.areEqual(this.f9884a, p02Var.f9884a) && Intrinsics.areEqual(this.b, p02Var.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.f9884a.hashCode() * 31);
    }

    public final String toString() {
        return "SocialAction(actionType=" + this.f9884a + ", items=" + this.b + ")";
    }

    @Override // com.yandex.mobile.ads.impl.x
    public final String a() {
        return this.f9884a;
    }

    public final List<s02> c() {
        return this.b;
    }
}
