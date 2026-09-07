package com.yandex.mobile.ads.impl;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class dy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final dy f8742a;
    private final cx b;
    private final boolean c;
    private final List<fy> d;

    /* JADX WARN: Multi-variable type inference failed */
    public dy(dy dyVar, cx destination, boolean z, List<? extends fy> uiData) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(uiData, "uiData");
        this.f8742a = dyVar;
        this.b = destination;
        this.c = z;
        this.d = uiData;
    }

    public static dy a(dy dyVar, dy dyVar2, cx destination, boolean z, List uiData, int i) {
        if ((i & 1) != 0) {
            dyVar2 = dyVar.f8742a;
        }
        if ((i & 2) != 0) {
            destination = dyVar.b;
        }
        if ((i & 4) != 0) {
            z = dyVar.c;
        }
        if ((i & 8) != 0) {
            uiData = dyVar.d;
        }
        dyVar.getClass();
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(uiData, "uiData");
        return new dy(dyVar2, destination, z, uiData);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dy)) {
            return false;
        }
        dy dyVar = (dy) obj;
        return Intrinsics.areEqual(this.f8742a, dyVar.f8742a) && Intrinsics.areEqual(this.b, dyVar.b) && this.c == dyVar.c && Intrinsics.areEqual(this.d, dyVar.d);
    }

    public final int hashCode() {
        dy dyVar = this.f8742a;
        return this.d.hashCode() + a7.a(this.c, (this.b.hashCode() + ((dyVar == null ? 0 : dyVar.hashCode()) * 31)) * 31, 31);
    }

    public final String toString() {
        return "DebugPanelUiState(prevState=" + this.f8742a + ", destination=" + this.b + ", isLoading=" + this.c + ", uiData=" + this.d + ")";
    }

    public final dy b() {
        return this.f8742a;
    }

    public final boolean d() {
        return this.c;
    }

    public final cx a() {
        return this.b;
    }

    public final List<fy> c() {
        return this.d;
    }
}
