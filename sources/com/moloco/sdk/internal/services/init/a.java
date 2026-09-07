package com.moloco.sdk.internal.services.init;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class a {
    public static final int c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6392a;
    public final String b;

    public a(String appKey, String mediation) {
        Intrinsics.checkNotNullParameter(appKey, "appKey");
        Intrinsics.checkNotNullParameter(mediation, "mediation");
        this.f6392a = appKey;
        this.b = mediation;
    }

    public final String a() {
        return this.f6392a;
    }

    public final String b() {
        return this.b;
    }

    public final String c() {
        return this.f6392a;
    }

    public final String d() {
        return this.b;
    }

    public final String e() {
        return this.f6392a + "___" + this.b + "___v0";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.areEqual(this.f6392a, aVar.f6392a) && Intrinsics.areEqual(this.b, aVar.b);
    }

    public final List<String> f() {
        return CollectionsKt.emptyList();
    }

    public int hashCode() {
        return (this.f6392a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "CacheKey(appKey=" + this.f6392a + ", mediation=" + this.b + ')';
    }

    public final a a(String appKey, String mediation) {
        Intrinsics.checkNotNullParameter(appKey, "appKey");
        Intrinsics.checkNotNullParameter(mediation, "mediation");
        return new a(appKey, mediation);
    }

    public static /* synthetic */ a a(a aVar, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = aVar.f6392a;
        }
        if ((i & 2) != 0) {
            str2 = aVar.b;
        }
        return aVar.a(str, str2);
    }
}
