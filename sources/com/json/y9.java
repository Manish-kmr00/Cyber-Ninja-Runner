package com.json;

import android.content.Context;
import android.text.TextUtils;
import com.json.sdk.utils.Logger;
import com.safedk.android.internal.partials.IronSourceNetworkBridge;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public class y9 {
    private static final String c = "y9";
    private static final String d = "setSharedSignal";
    private static final String e = "getSharedSignal";
    private static final String f = "functionName";
    private static final String g = "functionParams";
    private static final String h = "success";
    private static final String i = "fail";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f4613a;
    x9 b;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f4614a;
        JSONObject b;
        String c;
        String d;

        private a() {
        }

        public static a a(JSONObject jSONObject) {
            a aVar = new a();
            aVar.f4614a = jSONObject.optString("functionName");
            aVar.b = jSONObject.optJSONObject("functionParams");
            aVar.c = jSONObject.optString("success");
            aVar.d = jSONObject.optString("fail");
            return aVar;
        }
    }

    public y9(Context context, x9 x9Var) {
        this.f4613a = context;
        this.b = x9Var;
    }

    private a a(String str) throws JSONException {
        return a.a(IronSourceNetworkBridge.jsonObjectInit(str));
    }

    private void a(Context context, a aVar, rk rkVar) {
        fr frVar = new fr();
        JSONObject jSONObject = aVar.b;
        frVar.b("data", this.b.a(context, w9.a(jSONObject.optString("source")), jSONObject.optString("key")));
        rkVar.a(true, aVar.c, frVar);
    }

    private void a(a aVar, rk rkVar, Exception exc) {
        o9.d().a(exc);
        String message = exc.getMessage();
        Logger.i(c, aVar.f4614a + " exception " + message);
        fr frVar = new fr();
        if (TextUtils.isEmpty(message)) {
            message = "Unknown error";
        }
        frVar.b("error", message);
        rkVar.a(false, aVar.d, frVar);
    }

    private void b(Context context, a aVar, rk rkVar) {
        fr frVar = new fr();
        JSONObject jSONObject = aVar.b;
        this.b.a(context, w9.a(jSONObject.optString("source")), jSONObject.optString("key"), jSONObject.optString("data"));
        rkVar.a(true, aVar.c, frVar);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x002c  */
    public void a(String str, rk rkVar) throws Exception {
        byte b;
        a aVarA = a(str);
        try {
            String str2 = aVarA.f4614a;
            int iHashCode = str2.hashCode();
            if (iHashCode != 576059875) {
                if (iHashCode == 1486812399 && str2.equals(d)) {
                    b = 0;
                } else {
                    b = -1;
                }
            } else if (str2.equals(e)) {
                b = 1;
            } else {
                b = -1;
            }
            if (b == 0) {
                b(this.f4613a, aVarA, rkVar);
            } else {
                if (b != 1) {
                    throw new UnsupportedOperationException("unsupported API: " + str);
                }
                a(this.f4613a, aVarA, rkVar);
            }
        } catch (Exception e2) {
            a(aVarA, rkVar, e2);
        }
    }
}
