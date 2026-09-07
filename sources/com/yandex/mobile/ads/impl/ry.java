package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ry implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10152a;
    private final String b;
    private final List<vj1> c;

    public ry(String actionType, String fallbackUrl, ArrayList preferredPackages) {
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        Intrinsics.checkNotNullParameter(fallbackUrl, "fallbackUrl");
        Intrinsics.checkNotNullParameter(preferredPackages, "preferredPackages");
        this.f10152a = actionType;
        this.b = fallbackUrl;
        this.c = preferredPackages;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ry)) {
            return false;
        }
        ry ryVar = (ry) obj;
        return Intrinsics.areEqual(this.f10152a, ryVar.f10152a) && Intrinsics.areEqual(this.b, ryVar.b) && Intrinsics.areEqual(this.c, ryVar.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + v3.a(this.b, this.f10152a.hashCode() * 31, 31);
    }

    public final String toString() {
        return "DeeplinkAction(actionType=" + this.f10152a + ", fallbackUrl=" + this.b + ", preferredPackages=" + this.c + ")";
    }

    @Override // com.yandex.mobile.ads.impl.x
    public final String a() {
        return this.f10152a;
    }

    public final String c() {
        return this.b;
    }

    public final List<vj1> d() {
        return this.c;
    }
}
