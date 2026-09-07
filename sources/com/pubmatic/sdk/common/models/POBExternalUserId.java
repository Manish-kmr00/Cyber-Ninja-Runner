package com.pubmatic.sdk.common.models;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class POBExternalUserId {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f7582a;
    private final String b;
    private int c = 0;
    private JSONObject d;

    public POBExternalUserId(String str, String str2) {
        this.f7582a = str;
        this.b = str2;
    }

    public int getAtype() {
        return this.c;
    }

    public JSONObject getExtension() {
        return this.d;
    }

    public String getId() {
        return this.b;
    }

    public String getSource() {
        return this.f7582a;
    }

    public void setAtype(int i) {
        this.c = i;
    }

    public void setExtension(JSONObject jSONObject) {
        this.d = jSONObject;
    }
}
