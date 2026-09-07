package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class y42 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final tl1 f10697a;
    private final z1 b;
    private final jz c;
    private final ip d;
    private final yp e;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y42)) {
            return false;
        }
        y42 y42Var = (y42) obj;
        return Intrinsics.areEqual(this.f10697a, y42Var.f10697a) && Intrinsics.areEqual(this.b, y42Var.b) && Intrinsics.areEqual(this.c, y42Var.c) && Intrinsics.areEqual(this.d, y42Var.d) && Intrinsics.areEqual(this.e, y42Var.e);
    }

    public final int hashCode() {
        return this.e.hashCode() + ((this.d.hashCode() + ((this.c.hashCode() + ((this.b.hashCode() + (this.f10697a.hashCode() * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "TimeProviderContainer(progressIncrementer=" + this.f10697a + ", adBlockDurationProvider=" + this.b + ", defaultContentDelayProvider=" + this.c + ", closableAdChecker=" + this.d + ", closeTimerProgressIncrementer=" + this.e + ")";
    }

    public /* synthetic */ y42(tl1 tl1Var, z1 z1Var, jz jzVar, ip ipVar) {
        this(tl1Var, z1Var, jzVar, ipVar, new yp());
    }

    public y42(tl1 progressIncrementer, z1 adBlockDurationProvider, jz defaultContentDelayProvider, ip closableAdChecker, yp closeTimerProgressIncrementer) {
        Intrinsics.checkNotNullParameter(progressIncrementer, "progressIncrementer");
        Intrinsics.checkNotNullParameter(adBlockDurationProvider, "adBlockDurationProvider");
        Intrinsics.checkNotNullParameter(defaultContentDelayProvider, "defaultContentDelayProvider");
        Intrinsics.checkNotNullParameter(closableAdChecker, "closableAdChecker");
        Intrinsics.checkNotNullParameter(closeTimerProgressIncrementer, "closeTimerProgressIncrementer");
        this.f10697a = progressIncrementer;
        this.b = adBlockDurationProvider;
        this.c = defaultContentDelayProvider;
        this.d = closableAdChecker;
        this.e = closeTimerProgressIncrementer;
    }

    public final tl1 e() {
        return this.f10697a;
    }

    public final z1 a() {
        return this.b;
    }

    public final jz d() {
        return this.c;
    }

    public final ip b() {
        return this.d;
    }

    public final yp c() {
        return this.e;
    }
}
