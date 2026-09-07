package com.json.sdk.controller;

import android.content.Context;
import com.json.cv;
import com.json.environment.StringUtils;
import com.json.fr;
import com.json.mediationsdk.logger.IronLog;
import com.json.o9;
import com.json.pn;
import com.json.rk;
import com.json.sdk.utils.Logger;
import com.safedk.android.internal.partials.IronSourceNetworkBridge;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class u {
    private static final String d = "u";
    private static final String e = "updateToken";
    private static final String f = "getToken";
    private static final String g = "functionName";
    private static final String h = "functionParams";
    private static final String i = "success";
    private static final String j = "fail";
    private Context b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private pn f4353a = new pn();
    private cv c = new cv();

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f4354a;
        JSONObject b;
        String c;
        String d;

        private b() {
        }
    }

    public u(Context context) {
        this.b = context;
    }

    private b a(String str) throws JSONException {
        JSONObject jSONObjectJsonObjectInit = IronSourceNetworkBridge.jsonObjectInit(str);
        b bVar = new b();
        bVar.f4354a = jSONObjectJsonObjectInit.optString("functionName");
        bVar.b = jSONObjectJsonObjectInit.optJSONObject("functionParams");
        bVar.c = jSONObjectJsonObjectInit.optString("success");
        bVar.d = jSONObjectJsonObjectInit.optString("fail");
        return bVar;
    }

    private void a(b bVar, rk rkVar) {
        try {
            JSONObject jSONObjectA = this.c.a();
            Iterator<String> itKeys = jSONObjectA.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Object obj = jSONObjectA.get(next);
                if (obj instanceof String) {
                    jSONObjectA.put(next, StringUtils.encodeURI((String) obj));
                }
            }
            rkVar.a(true, bVar.c, jSONObjectA);
        } catch (Exception e2) {
            o9.d().a(e2);
            rkVar.a(false, bVar.d, e2.getMessage());
        }
    }

    void a(String str, rk rkVar) throws Exception {
        b bVarA = a(str);
        if (e.equals(bVarA.f4354a)) {
            a(bVarA.b, bVarA, rkVar);
        } else if (f.equals(bVarA.f4354a)) {
            a(bVarA, rkVar);
        } else {
            Logger.i(d, "unhandled API request " + str);
        }
    }

    public void a(JSONObject jSONObject, b bVar, rk rkVar) {
        fr frVar = new fr();
        try {
            this.f4353a.a(jSONObject);
            rkVar.a(true, bVar.c, frVar);
        } catch (Exception e2) {
            o9.d().a(e2);
            IronLog.INTERNAL.error(e2.toString());
            Logger.i(d, "updateToken exception " + e2.getMessage());
            rkVar.a(false, bVar.d, frVar);
        }
    }
}
