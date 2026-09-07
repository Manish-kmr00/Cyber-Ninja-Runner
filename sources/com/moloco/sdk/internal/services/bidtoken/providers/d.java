package com.moloco.sdk.internal.services.bidtoken.providers;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Long f6331a;

    public d(Long l) {
        this.f6331a = l;
    }

    public final Long a() {
        return this.f6331a;
    }

    public final Long b() {
        return this.f6331a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof d) && Intrinsics.areEqual(this.f6331a, ((d) obj).f6331a);
    }

    public int hashCode() {
        Long l = this.f6331a;
        if (l == null) {
            return 0;
        }
        return l.hashCode();
    }

    public String toString() {
        return "AppDirInfo(appDirSize=" + this.f6331a + ')';
    }

    public final d a(Long l) {
        return new d(l);
    }

    public static /* synthetic */ d a(d dVar, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            l = dVar.f6331a;
        }
        return dVar.a(l);
    }
}
