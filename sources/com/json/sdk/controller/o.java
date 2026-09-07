package com.json.sdk.controller;

import android.content.Context;
import android.text.TextUtils;
import com.json.fr;
import com.json.ho;
import com.json.o9;
import com.json.rk;
import com.json.sdk.utils.Logger;
import com.safedk.android.internal.partials.IronSourceNetworkBridge;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public class o {
    private static final String c = "o";
    private static final String d = "activate";
    private static final String e = "startSession";
    private static final String f = "finishSession";
    private static final String g = "impressionOccurred";
    private static final String h = "getOmidData";
    private static final String i = "omidFunction";
    private static final String j = "omidParams";
    private static final String k = "success";
    private static final String l = "fail";
    private static final String m = "%s | unsupported OMID API";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f4338a;
    private final ho b = new ho();

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f4339a;
        JSONObject b;
        String c;
        String d;

        private b() {
        }
    }

    public o(Context context) {
        this.f4338a = context;
    }

    private b a(String str) throws JSONException {
        JSONObject jSONObjectJsonObjectInit = IronSourceNetworkBridge.jsonObjectInit(str);
        b bVar = new b();
        bVar.f4339a = jSONObjectJsonObjectInit.optString(i);
        bVar.b = jSONObjectJsonObjectInit.optJSONObject(j);
        bVar.c = jSONObjectJsonObjectInit.optString("success");
        bVar.d = jSONObjectJsonObjectInit.optString("fail");
        return bVar;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x005f  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    void a(String str, rk rkVar) throws Exception {
        byte b2;
        b bVarA = a(str);
        fr frVar = new fr();
        JSONObject jSONObject = bVarA.b;
        if (jSONObject != null) {
            String strOptString = jSONObject.optString("adViewId", "");
            if (!TextUtils.isEmpty(strOptString)) {
                frVar.b("adViewId", strOptString);
            }
        }
        try {
            String str2 = bVarA.f4339a;
            switch (str2.hashCode()) {
                case -1655974669:
                    if (!str2.equals("activate")) {
                        b2 = -1;
                    } else {
                        b2 = 0;
                    }
                    break;
                case -984459207:
                    if (!str2.equals(h)) {
                        b2 = -1;
                    } else {
                        b2 = 4;
                    }
                    break;
                case 70701699:
                    if (!str2.equals(f)) {
                        b2 = -1;
                    } else {
                        b2 = 2;
                    }
                    break;
                case 1208109646:
                    if (!str2.equals(g)) {
                        b2 = -1;
                    } else {
                        b2 = 3;
                    }
                    break;
                case 1850541012:
                    if (!str2.equals(e)) {
                        b2 = -1;
                    } else {
                        b2 = 1;
                    }
                    break;
                default:
                    b2 = -1;
                    break;
            }
            if (b2 != 0) {
                if (b2 == 1) {
                    this.b.d(bVarA.b);
                } else if (b2 == 2) {
                    this.b.b(bVarA.b);
                } else if (b2 == 3) {
                    this.b.c(bVarA.b);
                } else if (b2 != 4) {
                    throw new IllegalArgumentException(String.format(m, bVarA.f4339a));
                }
                rkVar.a(true, bVarA.c, frVar);
            }
            this.b.a(this.f4338a);
            frVar = this.b.a();
            rkVar.a(true, bVarA.c, frVar);
        } catch (Exception e2) {
            o9.d().a(e2);
            frVar.b("errMsg", e2.getMessage());
            Logger.i(c, "OMIDJSAdapter " + bVarA.f4339a + " Exception: " + e2.getMessage());
            rkVar.a(false, bVarA.d, frVar);
        }
    }
}
