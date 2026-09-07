package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.ApiKeyUtils;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.f5, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public class C4108f5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11544a;
    public final String b;

    public C4108f5(String str, String str2) {
        this.f11544a = str;
        this.b = str2;
    }

    public final String a() {
        return ApiKeyUtils.createPartialApiKey(this.b);
    }

    public final String b() {
        return this.b;
    }

    public final String c() {
        return this.f11544a;
    }

    public boolean d() {
        return false;
    }

    public String e() {
        return this.f11544a + "_" + ApiKeyUtils.createPartialApiKey(this.b);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C4108f5 c4108f5 = (C4108f5) obj;
        String str = this.f11544a;
        if (str == null ? c4108f5.f11544a != null : !str.equals(c4108f5.f11544a)) {
            return false;
        }
        String str2 = this.b;
        String str3 = c4108f5.b;
        if (str2 != null) {
            return str2.equals(str3);
        }
        return str3 == null;
    }

    public final int hashCode() {
        String str = this.f11544a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return this.f11544a + "_" + this.b;
    }
}
