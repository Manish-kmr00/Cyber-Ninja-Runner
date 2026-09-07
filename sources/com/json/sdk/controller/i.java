package com.json.sdk.controller;

import android.content.Context;
import com.json.b9;
import com.json.fr;
import com.json.mm;
import com.json.nf;
import com.json.rk;
import com.json.sdk.utils.Logger;
import com.json.sdk.utils.SDKUtils;
import com.safedk.android.internal.partials.IronSourceNetworkBridge;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class i {
    private static final String c = "i";
    private static final String d = "getDeviceData";
    private static final String e = "deviceDataFunction";
    private static final String f = "deviceDataParams";
    private static final String g = "success";
    private static final String h = "fail";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f4321a;
    private final nf b = mm.S().f();

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f4322a;
        JSONObject b;
        String c;
        String d;

        private b() {
        }
    }

    public i(Context context) {
        this.f4321a = context;
    }

    private fr a() {
        fr frVar = new fr();
        frVar.b(SDKUtils.encodeString(b9.i.i0), SDKUtils.encodeString(String.valueOf(this.b.c())));
        frVar.b(SDKUtils.encodeString(b9.i.j0), SDKUtils.encodeString(String.valueOf(this.b.h(this.f4321a))));
        frVar.b(SDKUtils.encodeString(b9.i.k0), SDKUtils.encodeString(String.valueOf(this.b.J(this.f4321a))));
        frVar.b(SDKUtils.encodeString(b9.i.l0), SDKUtils.encodeString(String.valueOf(this.b.l(this.f4321a))));
        frVar.b(SDKUtils.encodeString(b9.i.m0), SDKUtils.encodeString(String.valueOf(this.b.c(this.f4321a))));
        frVar.b(SDKUtils.encodeString(b9.i.n0), SDKUtils.encodeString(String.valueOf(this.b.d(this.f4321a))));
        return frVar;
    }

    private b a(String str) throws JSONException {
        JSONObject jSONObjectJsonObjectInit = IronSourceNetworkBridge.jsonObjectInit(str);
        b bVar = new b();
        bVar.f4322a = jSONObjectJsonObjectInit.optString(e);
        bVar.b = jSONObjectJsonObjectInit.optJSONObject(f);
        bVar.c = jSONObjectJsonObjectInit.optString("success");
        bVar.d = jSONObjectJsonObjectInit.optString("fail");
        return bVar;
    }

    void a(String str, rk rkVar) throws Exception {
        b bVarA = a(str);
        if (d.equals(bVarA.f4322a)) {
            rkVar.a(true, bVarA.c, a());
        } else {
            Logger.i(c, "unhandled API request " + str);
        }
    }
}
