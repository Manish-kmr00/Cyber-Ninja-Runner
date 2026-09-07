package io.appmetrica.analytics.impl;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class Vn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Yn f11397a;
    public final Yn b;
    public final Wn c;
    public JSONObject d;

    public Vn(Yn yn, Yn yn2, Wn wn) {
        this.f11397a = yn;
        this.b = yn2;
        this.c = wn;
    }

    public final synchronized JSONObject a() {
        JSONObject jSONObject;
        if (this.d == null) {
            JSONObject jSONObjectA = this.c.a(a(this.f11397a), a(this.b));
            this.d = jSONObjectA;
            a(jSONObjectA);
        }
        jSONObject = this.d;
        if (jSONObject == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fileContents");
            jSONObject = null;
        }
        return jSONObject;
    }

    public static JSONObject a(Yn yn) {
        try {
            String strA = yn.a();
            return strA != null ? new JSONObject(strA) : new JSONObject();
        } catch (Throwable unused) {
            return new JSONObject();
        }
    }

    public final synchronized void a(JSONObject jSONObject) {
        String string = jSONObject.toString();
        try {
            this.f11397a.a(string);
        } catch (Throwable unused) {
        }
        try {
            this.b.a(string);
        } catch (Throwable unused2) {
        }
    }
}
