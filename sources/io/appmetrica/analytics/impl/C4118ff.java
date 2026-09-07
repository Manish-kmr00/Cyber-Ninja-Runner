package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.parsing.JsonUtils;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.ff, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C4118ff implements Y7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11551a;
    public final JSONObject b;
    public final boolean c;
    public final boolean d;
    public final X7 e;

    public C4118ff(String str, JSONObject jSONObject, boolean z, boolean z2, X7 x7) {
        this.f11551a = str;
        this.b = jSONObject;
        this.c = z;
        this.d = z2;
        this.e = x7;
    }

    @Override // io.appmetrica.analytics.impl.Y7
    public final X7 a() {
        return this.e;
    }

    public final JSONObject b() {
        if (!this.c) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("trackingId", this.f11551a);
            if (this.b.length() <= 0) {
                return jSONObject;
            }
            jSONObject.put("additionalParams", this.b);
            return jSONObject;
        } catch (Throwable unused) {
            return jSONObject;
        }
    }

    public final JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("trackingId", this.f11551a);
            jSONObject.put("additionalParams", this.b);
            jSONObject.put("wasSet", this.c);
            jSONObject.put("autoTracking", this.d);
            jSONObject.put("source", this.e.f11414a);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public final String toString() {
        return "PreloadInfoState{trackingId='" + this.f11551a + "', additionalParameters=" + this.b + ", wasSet=" + this.c + ", autoTrackingEnabled=" + this.d + ", source=" + this.e + AbstractJsonLexerKt.END_OBJ;
    }

    public static C4118ff a(JSONObject jSONObject) {
        X7 x7;
        String strOptStringOrNull = JsonUtils.optStringOrNull(jSONObject, "trackingId");
        JSONObject jSONObjectOptJsonObjectOrDefault = JsonUtils.optJsonObjectOrDefault(jSONObject, "additionalParams", new JSONObject());
        int i = 0;
        boolean zOptBooleanOrDefault = JsonUtils.optBooleanOrDefault(jSONObject, "wasSet", false);
        boolean zOptBooleanOrDefault2 = JsonUtils.optBooleanOrDefault(jSONObject, "autoTracking", false);
        String strOptStringOrNull2 = JsonUtils.optStringOrNull(jSONObject, "source");
        X7[] x7ArrValues = X7.values();
        int length = x7ArrValues.length;
        while (true) {
            if (i >= length) {
                x7 = null;
                break;
            }
            x7 = x7ArrValues[i];
            if (Intrinsics.areEqual(x7.f11414a, strOptStringOrNull2)) {
                break;
            }
            i++;
        }
        return new C4118ff(strOptStringOrNull, jSONObjectOptJsonObjectOrDefault, zOptBooleanOrDefault, zOptBooleanOrDefault2, x7 == null ? X7.b : x7);
    }
}
