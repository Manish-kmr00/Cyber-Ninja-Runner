package com.json;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class g9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f3716a;
    private JSONObject b;
    private String c;
    private String d;

    public g9(String str) {
        this.f3716a = str;
    }

    public g9(String str, String str2, String str3) {
        this.f3716a = str;
        this.c = str2;
        this.d = str3;
    }

    public g9(String str, JSONObject jSONObject) {
        this.f3716a = str;
        this.b = jSONObject;
    }

    public g9(String str, JSONObject jSONObject, String str2, String str3) {
        this.f3716a = str;
        this.b = jSONObject;
        this.c = str2;
        this.d = str3;
    }

    public String a() {
        return this.d;
    }

    public String b() {
        return this.f3716a;
    }

    public JSONObject c() {
        return this.b;
    }

    public String d() {
        return this.c;
    }
}
