package com.inmobi.media;

import com.inmobi.commons.core.configs.Config;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.y2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3634y2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Config f3483a;
    public final InterfaceC3564t2 b;

    public C3634y2(Config config, InterfaceC3564t2 interfaceC3564t2) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.f3483a = config;
        this.b = interfaceC3564t2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3634y2)) {
            return false;
        }
        C3634y2 c3634y2 = (C3634y2) obj;
        return Intrinsics.areEqual(this.f3483a, c3634y2.f3483a) && Intrinsics.areEqual(this.b, c3634y2.b);
    }

    public final int hashCode() {
        int iHashCode = this.f3483a.hashCode() * 31;
        InterfaceC3564t2 interfaceC3564t2 = this.b;
        return iHashCode + (interfaceC3564t2 == null ? 0 : interfaceC3564t2.hashCode());
    }

    public final String toString() {
        return "ConfigFetchInputs(config=" + this.f3483a + ", listener=" + this.b + ')';
    }
}
