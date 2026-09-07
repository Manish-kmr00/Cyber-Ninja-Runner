package com.yandex.mobile.ads.impl;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class fh2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final eh2 f8895a;
    private final jr0 b;
    private final pu0 c;
    private final Map<String, String> d;

    public fh2(eh2 view, jr0 layoutParams, pu0 measured, Map<String, String> additionalInfo) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(layoutParams, "layoutParams");
        Intrinsics.checkNotNullParameter(measured, "measured");
        Intrinsics.checkNotNullParameter(additionalInfo, "additionalInfo");
        this.f8895a = view;
        this.b = layoutParams;
        this.c = measured;
        this.d = additionalInfo;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof fh2)) {
            return false;
        }
        fh2 fh2Var = (fh2) obj;
        return Intrinsics.areEqual(this.f8895a, fh2Var.f8895a) && Intrinsics.areEqual(this.b, fh2Var.b) && Intrinsics.areEqual(this.c, fh2Var.c) && Intrinsics.areEqual(this.d, fh2Var.d);
    }

    public final int hashCode() {
        return this.d.hashCode() + ((this.c.hashCode() + ((this.b.hashCode() + (this.f8895a.hashCode() * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "ViewSizeInfo(view=" + this.f8895a + ", layoutParams=" + this.b + ", measured=" + this.c + ", additionalInfo=" + this.d + ")";
    }

    public final eh2 d() {
        return this.f8895a;
    }

    public final jr0 b() {
        return this.b;
    }

    public final pu0 c() {
        return this.c;
    }

    public final Map<String, String> a() {
        return this.d;
    }
}
