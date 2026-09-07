package com.moloco.sdk.acm;

import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6002a;
    public String b;
    public long c;
    public final Map<String, String> d;

    public a(String appId, String postAnalyticsUrl, long j, Map<String, String> clientOptions) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(postAnalyticsUrl, "postAnalyticsUrl");
        Intrinsics.checkNotNullParameter(clientOptions, "clientOptions");
        this.f6002a = appId;
        this.b = postAnalyticsUrl;
        this.c = j;
        this.d = clientOptions;
    }

    public final String a() {
        return this.f6002a;
    }

    public final String b() {
        return this.b;
    }

    public final long c() {
        return this.c;
    }

    public final Map<String, String> d() {
        return this.d;
    }

    public final String e() {
        return this.f6002a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.areEqual(this.f6002a, aVar.f6002a) && Intrinsics.areEqual(this.b, aVar.b) && this.c == aVar.c && Intrinsics.areEqual(this.d, aVar.d);
    }

    public final Map<String, String> f() {
        return this.d;
    }

    public final String g() {
        return this.b;
    }

    public final long h() {
        return this.c;
    }

    public int hashCode() {
        return (((((this.f6002a.hashCode() * 31) + this.b.hashCode()) * 31) + Long.hashCode(this.c)) * 31) + this.d.hashCode();
    }

    public String toString() {
        return "ACMConfig(appId=" + this.f6002a + ", postAnalyticsUrl=" + this.b + ", requestPeriodSeconds=" + this.c + ", clientOptions=" + this.d + ')';
    }

    public final a a(String appId, String postAnalyticsUrl, long j, Map<String, String> clientOptions) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(postAnalyticsUrl, "postAnalyticsUrl");
        Intrinsics.checkNotNullParameter(clientOptions, "clientOptions");
        return new a(appId, postAnalyticsUrl, j, clientOptions);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ a a(a aVar, String str, String str2, long j, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = aVar.f6002a;
        }
        if ((i & 2) != 0) {
            str2 = aVar.b;
        }
        String str3 = str2;
        if ((i & 4) != 0) {
            j = aVar.c;
        }
        long j2 = j;
        if ((i & 8) != 0) {
            map = aVar.d;
        }
        return aVar.a(str, str3, j2, map);
    }

    public final void a(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.b = str;
    }

    public final void a(long j) {
        this.c = j;
    }

    public /* synthetic */ a(String str, String str2, long j, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? 600L : j, map);
    }
}
