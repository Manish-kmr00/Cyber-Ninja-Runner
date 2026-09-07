package com.moloco.sdk.internal.services.init;

import com.moloco.sdk.Init;
import com.moloco.sdk.internal.v;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v<Init.SDKInitResponse, j> f6394a;
    public final String b;

    public c(v<Init.SDKInitResponse, j> sdkInitResult, String fetchType) {
        Intrinsics.checkNotNullParameter(sdkInitResult, "sdkInitResult");
        Intrinsics.checkNotNullParameter(fetchType, "fetchType");
        this.f6394a = sdkInitResult;
        this.b = fetchType;
    }

    public final v<Init.SDKInitResponse, j> a() {
        return this.f6394a;
    }

    public final String b() {
        return this.b;
    }

    public final String c() {
        return this.b;
    }

    public final v<Init.SDKInitResponse, j> d() {
        return this.f6394a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return Intrinsics.areEqual(this.f6394a, cVar.f6394a) && Intrinsics.areEqual(this.b, cVar.b);
    }

    public int hashCode() {
        return (this.f6394a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "FetchState(sdkInitResult=" + this.f6394a + ", fetchType=" + this.b + ')';
    }

    public final c a(v<Init.SDKInitResponse, j> sdkInitResult, String fetchType) {
        Intrinsics.checkNotNullParameter(sdkInitResult, "sdkInitResult");
        Intrinsics.checkNotNullParameter(fetchType, "fetchType");
        return new c(sdkInitResult, fetchType);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ c a(c cVar, v vVar, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            vVar = cVar.f6394a;
        }
        if ((i & 2) != 0) {
            str = cVar.b;
        }
        return cVar.a(vVar, str);
    }
}
