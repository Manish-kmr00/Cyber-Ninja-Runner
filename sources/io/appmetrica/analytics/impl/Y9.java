package io.appmetrica.analytics.impl;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class Y9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11433a;
    public final int b;
    public final boolean c;

    public Y9(JSONObject jSONObject) {
        this.f11433a = jSONObject.getString("name");
        this.c = jSONObject.getBoolean("required");
        this.b = jSONObject.optInt("version", -1);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Y9.class != obj.getClass()) {
            return false;
        }
        Y9 y9 = (Y9) obj;
        if (this.b != y9.b || this.c != y9.c) {
            return false;
        }
        String str = this.f11433a;
        String str2 = y9.f11433a;
        if (str != null) {
            return str.equals(str2);
        }
        return str2 == null;
    }

    public final int hashCode() {
        String str = this.f11433a;
        return ((((str != null ? str.hashCode() : 0) * 31) + this.b) * 31) + (this.c ? 1 : 0);
    }

    public Y9(String str, int i, boolean z) {
        this.f11433a = str;
        this.b = i;
        this.c = z;
    }
}
