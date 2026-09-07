package com.ogury.ad.internal;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes13.dex */
public final class x1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7438a;
    public final String b;
    public final JSONArray c;

    public x1(String str, String str2, JSONArray jSONArray) {
        this.f7438a = str;
        this.b = str2;
        this.c = jSONArray;
    }

    public final String a() {
        return this.f7438a;
    }

    public final String b() {
        return this.b;
    }

    public final JSONArray c() {
        return this.c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x1)) {
            return false;
        }
        x1 x1Var = (x1) obj;
        return Intrinsics.areEqual(this.f7438a, x1Var.f7438a) && Intrinsics.areEqual(this.b, x1Var.b) && Intrinsics.areEqual(this.c, x1Var.c);
    }

    public final int hashCode() {
        String str = this.f7438a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.b;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        JSONArray jSONArray = this.c;
        return iHashCode2 + (jSONArray != null ? jSONArray.hashCode() : 0);
    }

    public final String toString() {
        return "EventAd(campaignId=" + this.f7438a + ", creativeId=" + this.b + ", extras=" + this.c + ")";
    }
}
