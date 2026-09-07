package com.json.sdk.controller;

import android.content.Context;
import com.json.c4;
import com.json.fr;
import com.json.mediationsdk.logger.IronLog;
import com.json.o9;
import com.json.rk;
import com.json.sdk.utils.Logger;
import com.safedk.android.internal.partials.IronSourceNetworkBridge;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class q {
    private static final String b = "q";
    private static final String c = "getPermissions";
    private static final String d = "isPermissionGranted";
    private static final String e = "permissions";
    private static final String f = "permission";
    private static final String g = "status";
    private static final String h = "functionName";
    private static final String i = "functionParams";
    private static final String j = "success";
    private static final String k = "fail";
    private static final String l = "unhandledPermission";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f4347a;

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f4348a;
        JSONObject b;
        String c;
        String d;

        private b() {
        }
    }

    public q(Context context) {
        this.f4347a = context;
    }

    private b a(String str) throws JSONException {
        JSONObject jSONObjectJsonObjectInit = IronSourceNetworkBridge.jsonObjectInit(str);
        b bVar = new b();
        bVar.f4348a = jSONObjectJsonObjectInit.optString("functionName");
        bVar.b = jSONObjectJsonObjectInit.optJSONObject("functionParams");
        bVar.c = jSONObjectJsonObjectInit.optString("success");
        bVar.d = jSONObjectJsonObjectInit.optString("fail");
        return bVar;
    }

    void a(String str, rk rkVar) throws Exception {
        b bVarA = a(str);
        if (c.equals(bVarA.f4348a)) {
            a(bVarA.b, bVarA, rkVar);
        } else if (d.equals(bVarA.f4348a)) {
            b(bVarA.b, bVarA, rkVar);
        } else {
            Logger.i(b, "PermissionsJSAdapter unhandled API request " + str);
        }
    }

    public void a(JSONObject jSONObject, b bVar, rk rkVar) {
        fr frVar = new fr();
        try {
            frVar.a("permissions", c4.a(this.f4347a, jSONObject.getJSONArray("permissions")));
            rkVar.a(true, bVar.c, frVar);
        } catch (Exception e2) {
            o9.d().a(e2);
            IronLog.INTERNAL.error(e2.toString());
            Logger.i(b, "PermissionsJSAdapter getPermissions JSON Exception when getting permissions parameter " + e2.getMessage());
            frVar.b("errMsg", e2.getMessage());
            rkVar.a(false, bVar.d, frVar);
        }
    }

    public void b(JSONObject jSONObject, b bVar, rk rkVar) {
        String str;
        boolean z;
        fr frVar = new fr();
        try {
            String string = jSONObject.getString(f);
            frVar.b(f, string);
            if (c4.d(this.f4347a, string)) {
                frVar.b("status", String.valueOf(c4.c(this.f4347a, string)));
                str = bVar.c;
                z = true;
            } else {
                frVar.b("status", l);
                str = bVar.d;
                z = false;
            }
            rkVar.a(z, str, frVar);
        } catch (Exception e2) {
            o9.d().a(e2);
            IronLog.INTERNAL.error(e2.toString());
            frVar.b("errMsg", e2.getMessage());
            rkVar.a(false, bVar.d, frVar);
        }
    }
}
