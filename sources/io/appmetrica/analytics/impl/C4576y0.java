package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ndkcrashesapi.internal.NativeCrashSource;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.y0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4576y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NativeCrashSource f11849a;
    public final String b;
    public final String c;
    public final String d;
    public final long e;
    public final C4601z0 f;

    public C4576y0(NativeCrashSource nativeCrashSource, String str, String str2, String str3, long j, C4601z0 c4601z0) {
        this.f11849a = nativeCrashSource;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = j;
        this.f = c4601z0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C4576y0)) {
            return false;
        }
        C4576y0 c4576y0 = (C4576y0) obj;
        return this.f11849a == c4576y0.f11849a && Intrinsics.areEqual(this.b, c4576y0.b) && Intrinsics.areEqual(this.c, c4576y0.c) && Intrinsics.areEqual(this.d, c4576y0.d) && this.e == c4576y0.e && Intrinsics.areEqual(this.f, c4576y0.f);
    }

    public final int hashCode() {
        return this.f.hashCode() + ((Long.hashCode(this.e) + ((this.d.hashCode() + ((this.c.hashCode() + ((this.b.hashCode() + (this.f11849a.hashCode() * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "AppMetricaNativeCrash(source=" + this.f11849a + ", handlerVersion=" + this.b + ", uuid=" + this.c + ", dumpFile=" + this.d + ", creationTime=" + this.e + ", metadata=" + this.f + ')';
    }
}
