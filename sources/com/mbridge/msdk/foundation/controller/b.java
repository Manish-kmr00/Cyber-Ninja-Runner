package com.mbridge.msdk.foundation.controller;

import android.util.Log;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: CandidateController.java */
/* JADX INFO: loaded from: classes6.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashMap<String, com.mbridge.msdk.foundation.cache.d> f4901a;

    /* JADX INFO: renamed from: com.mbridge.msdk.foundation.controller.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CandidateController.java */
    static class C0431b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static b f4902a = new b();
    }

    public static b a() {
        return C0431b.f4902a;
    }

    public com.mbridge.msdk.foundation.cache.d b(String str, JSONArray jSONArray) {
        JSONArray jSONArray2;
        Exception e;
        if (this.f4901a == null) {
            this.f4901a = new HashMap<>();
        }
        if (this.f4901a.containsKey(str)) {
            return this.f4901a.get(str);
        }
        if (jSONArray == null) {
            try {
                jSONArray2 = new JSONArray();
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("c_cb", 0);
                    jSONObject.put("t_disc", 0.95d);
                    jSONObject.put("u_disc", 0.95d);
                    jSONObject.put("max_ecppv_diff", 0);
                    jSONObject.put("max_cache_num", 20);
                    jSONObject.put("max_usage_limit", 10);
                    jSONObject.put(SDKConstants.PARAM_A2U_TIME_INTERVAL, 7200);
                    jSONArray2.put(jSONObject);
                } catch (Exception e2) {
                    e = e2;
                    Log.e("CandidateController", e.getMessage());
                }
            } catch (Exception e3) {
                jSONArray2 = jSONArray;
                e = e3;
            }
            jSONArray = jSONArray2;
        }
        return a(str, jSONArray);
    }

    private b() {
        this.f4901a = new HashMap<>();
    }

    public com.mbridge.msdk.foundation.cache.d a(String str, JSONArray jSONArray) {
        if (this.f4901a == null) {
            this.f4901a = new HashMap<>();
        }
        if (this.f4901a.containsKey(str)) {
            return this.f4901a.get(str);
        }
        com.mbridge.msdk.foundation.cache.d dVar = new com.mbridge.msdk.foundation.cache.d(str, jSONArray);
        this.f4901a.put(str, dVar);
        return dVar;
    }
}
