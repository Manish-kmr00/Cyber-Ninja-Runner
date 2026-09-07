package com.inmobi.media;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public abstract class D6 {
    public static int a(String str, JSONObject jSONObject) {
        return (str == null || !jSONObject.has(str)) ? jSONObject.getInt("default") : jSONObject.getInt(str);
    }
}
