package com.moloco.sdk.internal.services.events;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f6383a;
    public final boolean b;
    public final String c;
    public final String d;

    public e(boolean z, boolean z2, String appForegroundUrl, String appBackgroundUrl) {
        Intrinsics.checkNotNullParameter(appForegroundUrl, "appForegroundUrl");
        Intrinsics.checkNotNullParameter(appBackgroundUrl, "appBackgroundUrl");
        this.f6383a = z;
        this.b = z2;
        this.c = appForegroundUrl;
        this.d = appBackgroundUrl;
    }

    public final boolean a() {
        return this.f6383a;
    }

    public final boolean b() {
        return this.b;
    }

    public final String c() {
        return this.c;
    }

    public final String d() {
        return this.d;
    }

    public final String e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.f6383a == eVar.f6383a && this.b == eVar.b && Intrinsics.areEqual(this.c, eVar.c) && Intrinsics.areEqual(this.d, eVar.d);
    }

    public final String f() {
        return this.c;
    }

    public final boolean g() {
        return this.f6383a;
    }

    public final boolean h() {
        return this.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        boolean z = this.f6383a;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z2 = this.b;
        return ((((i + (z2 ? 1 : z2)) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public String toString() {
        return "UserEventConfig(eventReportingEnabled=" + this.f6383a + ", userTrackingEnabled=" + this.b + ", appForegroundUrl=" + this.c + ", appBackgroundUrl=" + this.d + ')';
    }

    public final e a(boolean z, boolean z2, String appForegroundUrl, String appBackgroundUrl) {
        Intrinsics.checkNotNullParameter(appForegroundUrl, "appForegroundUrl");
        Intrinsics.checkNotNullParameter(appBackgroundUrl, "appBackgroundUrl");
        return new e(z, z2, appForegroundUrl, appBackgroundUrl);
    }

    public static /* synthetic */ e a(e eVar, boolean z, boolean z2, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = eVar.f6383a;
        }
        if ((i & 2) != 0) {
            z2 = eVar.b;
        }
        if ((i & 4) != 0) {
            str = eVar.c;
        }
        if ((i & 8) != 0) {
            str2 = eVar.d;
        }
        return eVar.a(z, z2, str, str2);
    }
}
