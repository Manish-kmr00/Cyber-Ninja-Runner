package com.yandex.mobile.ads.impl;

import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f8854a;
    private final Set<Long> b;

    public f() {
        this(0);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return Intrinsics.areEqual(this.f8854a, fVar.f8854a) && Intrinsics.areEqual(this.b, fVar.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.f8854a.hashCode() * 31);
    }

    public final String toString() {
        return "AbExperimentData(experiments=" + this.f8854a + ", triggeredTestIds=" + this.b + ")";
    }

    public /* synthetic */ f(int i) {
        this("", SetsKt.emptySet());
    }

    public final String a() {
        return this.f8854a;
    }

    public f(String experiments, Set<Long> triggeredTestIds) {
        Intrinsics.checkNotNullParameter(experiments, "experiments");
        Intrinsics.checkNotNullParameter(triggeredTestIds, "triggeredTestIds");
        this.f8854a = experiments;
        this.b = triggeredTestIds;
    }

    public final Set<Long> b() {
        return this.b;
    }
}
