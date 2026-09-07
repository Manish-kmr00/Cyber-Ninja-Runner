package com.json;

import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class ck {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static String f3580a = "ManRewInst_";

    public static String a() {
        return String.valueOf(System.currentTimeMillis());
    }

    public static String a(rj rjVar) {
        eh.e eVar;
        if (rjVar.i()) {
            eVar = eh.e.Banner;
        } else {
            eVar = rjVar.n() ? eh.e.RewardedVideo : eh.e.Interstitial;
        }
        return eVar.toString();
    }

    public static String a(JSONObject jSONObject) {
        return jSONObject.optBoolean("rewarded") ? f3580a + jSONObject.optString("name") : jSONObject.optString("name");
    }

    public static String b() {
        return UUID.randomUUID().toString();
    }
}
