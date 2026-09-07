package com.ogury.ad.internal;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class y1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7446a;
    public final JSONObject b;

    public y1(String type, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.f7446a = type;
        this.b = jSONObject;
    }

    public final JSONObject a() {
        return this.b;
    }

    public final String b() {
        return this.f7446a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y1)) {
            return false;
        }
        y1 y1Var = (y1) obj;
        return Intrinsics.areEqual(this.f7446a, y1Var.f7446a) && Intrinsics.areEqual(this.b, y1Var.b);
    }

    public final int hashCode() {
        int iHashCode = this.f7446a.hashCode() * 31;
        JSONObject jSONObject = this.b;
        return iHashCode + (jSONObject == null ? 0 : jSONObject.hashCode());
    }

    public final String toString() {
        return "EventError(type=" + this.f7446a + ", content=" + this.b + ")";
    }
}
