package com.inmobi.media;

import com.inmobi.commons.core.configs.SignalsConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.b9, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C3315b9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3276a;
    public final String b;
    public final SignalsConfig.NovatiqConfig c;

    public C3315b9(String hyperId, String spHost, SignalsConfig.NovatiqConfig novatiqConfig) {
        Intrinsics.checkNotNullParameter(hyperId, "hyperId");
        Intrinsics.checkNotNullParameter("i6i", "sspId");
        Intrinsics.checkNotNullParameter(spHost, "spHost");
        Intrinsics.checkNotNullParameter("inmobi", "pubId");
        Intrinsics.checkNotNullParameter(novatiqConfig, "novatiqConfig");
        this.f3276a = hyperId;
        this.b = spHost;
        this.c = novatiqConfig;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3315b9)) {
            return false;
        }
        C3315b9 c3315b9 = (C3315b9) obj;
        return Intrinsics.areEqual(this.f3276a, c3315b9.f3276a) && Intrinsics.areEqual("i6i", "i6i") && Intrinsics.areEqual(this.b, c3315b9.b) && Intrinsics.areEqual("inmobi", "inmobi") && Intrinsics.areEqual(this.c, c3315b9.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + ((((this.b.hashCode() + (((this.f3276a.hashCode() * 31) + 102684) * 31)) * 31) - 1183962098) * 31);
    }

    public final String toString() {
        return "NovatiqData(hyperId=" + this.f3276a + ", sspId=i6i, spHost=" + this.b + ", pubId=inmobi, novatiqConfig=" + this.c + ')';
    }
}
