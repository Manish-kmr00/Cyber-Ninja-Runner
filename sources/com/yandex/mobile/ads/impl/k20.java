package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class k20 implements fk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9373a;
    private final y20 b;
    private final List<String> c;

    public k20(String actionType, y20 design, ArrayList trackingUrls) {
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        Intrinsics.checkNotNullParameter(design, "design");
        Intrinsics.checkNotNullParameter(trackingUrls, "trackingUrls");
        this.f9373a = actionType;
        this.b = design;
        this.c = trackingUrls;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k20)) {
            return false;
        }
        k20 k20Var = (k20) obj;
        return Intrinsics.areEqual(this.f9373a, k20Var.f9373a) && Intrinsics.areEqual(this.b, k20Var.b) && Intrinsics.areEqual(this.c, k20Var.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + ((this.b.hashCode() + (this.f9373a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "DivKitAdtuneAction(actionType=" + this.f9373a + ", design=" + this.b + ", trackingUrls=" + this.c + ")";
    }

    @Override // com.yandex.mobile.ads.impl.x
    public final String a() {
        return this.f9373a;
    }

    public final y20 c() {
        return this.b;
    }

    @Override // com.yandex.mobile.ads.impl.fk
    public final List<String> b() {
        return this.c;
    }
}
