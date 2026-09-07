package com.ogury.ad.internal;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class x7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f7442a;
    public final String b;
    public final String c;

    public x7(JSONObject profigRequestBody, String str, String str2) {
        Intrinsics.checkNotNullParameter(profigRequestBody, "profigRequestBody");
        this.f7442a = profigRequestBody;
        this.b = str;
        this.c = str2;
    }

    public final JSONObject a() {
        return this.f7442a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x7)) {
            return false;
        }
        x7 x7Var = (x7) obj;
        return Intrinsics.areEqual(this.f7442a, x7Var.f7442a) && Intrinsics.areEqual(this.b, x7Var.b) && Intrinsics.areEqual(this.c, x7Var.c);
    }

    public final int hashCode() {
        int iHashCode = this.f7442a.hashCode() * 31;
        String str = this.b;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.c;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        return "ProfigRequest(profigRequestBody=" + this.f7442a + ", profigRequestBodyHash=" + this.b + ", privacyCompliancySectionHash=" + this.c + ")";
    }
}
