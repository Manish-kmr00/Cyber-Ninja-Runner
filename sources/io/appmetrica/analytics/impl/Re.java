package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class Re {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11330a;
    public final JSONObject b;
    public final X7 c;

    public Re(String str, JSONObject jSONObject, X7 x7) {
        this.f11330a = str;
        this.b = jSONObject;
        this.c = x7;
    }

    public final String toString() {
        return "Candidate{trackingId='" + this.f11330a + "', additionalParams=" + this.b + ", source=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }
}
