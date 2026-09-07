package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigMetaInfo;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.zg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C4617zg implements RemoteConfigMetaInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f11878a;
    public final long b;

    public C4617zg(long j, long j2) {
        this.f11878a = j;
        this.b = j2;
    }

    public final C4617zg a(long j, long j2) {
        return new C4617zg(j, j2);
    }

    public final long b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C4617zg)) {
            return false;
        }
        C4617zg c4617zg = (C4617zg) obj;
        return this.f11878a == c4617zg.f11878a && this.b == c4617zg.b;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigMetaInfo
    public final long getFirstSendTime() {
        return this.f11878a;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigMetaInfo
    public final long getLastUpdateTime() {
        return this.b;
    }

    public final int hashCode() {
        return Long.hashCode(this.b) + (Long.hashCode(this.f11878a) * 31);
    }

    public final String toString() {
        return "RemoteConfigMetaInfoModel(firstSendTime=" + this.f11878a + ", lastUpdateTime=" + this.b + ')';
    }

    public final long a() {
        return this.f11878a;
    }

    public static C4617zg a(C4617zg c4617zg, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = c4617zg.f11878a;
        }
        if ((i & 2) != 0) {
            j2 = c4617zg.b;
        }
        c4617zg.getClass();
        return new C4617zg(j, j2);
    }
}
