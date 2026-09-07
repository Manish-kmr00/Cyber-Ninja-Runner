package com.ogury.ad.internal;

import com.ogury.ad.common.OguryMediation;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class b4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f7268a;
    public final String b;
    public final String c;
    public final String d;
    public final JSONObject e;
    public final y1 f;
    public final String g;
    public final x1 h;
    public p1 i;
    public final OguryMediation j;

    public /* synthetic */ b4(long j, String str, String str2, String str3, JSONObject jSONObject, y1 y1Var, String str4, x1 x1Var, OguryMediation oguryMediation, int i) {
        this(j, str, str2, str3, jSONObject, (i & 32) != 0 ? null : y1Var, str4, (i & 128) != 0 ? null : x1Var, p1.IMMEDIATE_DISPATCH, oguryMediation);
    }

    public final x1 a() {
        return this.h;
    }

    public final JSONObject b() {
        return this.e;
    }

    public final y1 c() {
        return this.f;
    }

    public final String d() {
        return this.c;
    }

    public final String e() {
        return this.d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b4)) {
            return false;
        }
        b4 b4Var = (b4) obj;
        return this.f7268a == b4Var.f7268a && Intrinsics.areEqual(this.b, b4Var.b) && Intrinsics.areEqual(this.c, b4Var.c) && Intrinsics.areEqual(this.d, b4Var.d) && Intrinsics.areEqual(this.e, b4Var.e) && Intrinsics.areEqual(this.f, b4Var.f) && Intrinsics.areEqual(this.g, b4Var.g) && Intrinsics.areEqual(this.h, b4Var.h) && this.i == b4Var.i && Intrinsics.areEqual(this.j, b4Var.j);
    }

    public final OguryMediation f() {
        return this.j;
    }

    public final String g() {
        return this.b;
    }

    public final int hashCode() {
        int iHashCode = (this.d.hashCode() + ((this.c.hashCode() + ((this.b.hashCode() + (Long.hashCode(this.f7268a) * 31)) * 31)) * 31)) * 31;
        JSONObject jSONObject = this.e;
        int iHashCode2 = (iHashCode + (jSONObject == null ? 0 : jSONObject.hashCode())) * 31;
        y1 y1Var = this.f;
        int iHashCode3 = (this.g.hashCode() + ((iHashCode2 + (y1Var == null ? 0 : y1Var.hashCode())) * 31)) * 31;
        x1 x1Var = this.h;
        int iHashCode4 = (this.i.hashCode() + ((iHashCode3 + (x1Var == null ? 0 : x1Var.hashCode())) * 31)) * 31;
        OguryMediation oguryMediation = this.j;
        return iHashCode4 + (oguryMediation != null ? oguryMediation.hashCode() : 0);
    }

    public final String toString() {
        return "MonitoringEvent(at=" + this.f7268a + ", sessionId=" + this.b + ", id=" + this.c + ", name=" + this.d + ", details=" + this.e + ", error=" + this.f + ", adUnitId=" + this.g + ", ad=" + this.h + ", dispatchType=" + this.i + ", oguryMediation=" + this.j + ")";
    }

    public b4(long j, String sessionId, String id, String name, JSONObject jSONObject, y1 y1Var, String adUnitId, x1 x1Var, p1 dispatchType, OguryMediation oguryMediation) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(dispatchType, "dispatchType");
        this.f7268a = j;
        this.b = sessionId;
        this.c = id;
        this.d = name;
        this.e = jSONObject;
        this.f = y1Var;
        this.g = adUnitId;
        this.h = x1Var;
        this.i = dispatchType;
        this.j = oguryMediation;
    }
}
