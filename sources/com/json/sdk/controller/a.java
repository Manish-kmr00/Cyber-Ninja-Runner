package com.json.sdk.controller;

import android.content.Context;
import android.text.TextUtils;
import com.json.bh;
import com.json.fr;
import com.json.jw;
import com.json.o9;
import com.json.rk;
import com.json.uv;
import com.json.wg;
import com.safedk.android.internal.partials.IronSourceNetworkBridge;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class a implements wg {
    private static final String d = "loadWithUrl";
    private static final String e = "sendMessage";
    public static final String f = "removeAdView";
    public static final String g = "webviewAction";
    public static final String h = "handleGetViewVisibility";
    private static final String i = "functionName";
    private static final String j = "functionParams";
    private static final String k = "success";
    private static final String l = "fail";
    public static final String m = "errMsg";
    private static final String n = "%s | unsupported AdViews API";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private jw f4286a;
    private bh b = bh.a();
    private Context c;

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f4287a;
        JSONObject b;
        String c;
        String d;

        private b() {
        }
    }

    public a(Context context) {
        this.c = context;
    }

    private b a(String str) throws JSONException {
        JSONObject jSONObjectJsonObjectInit = IronSourceNetworkBridge.jsonObjectInit(str);
        b bVar = new b();
        bVar.f4287a = jSONObjectJsonObjectInit.optString("functionName");
        bVar.b = jSONObjectJsonObjectInit.optJSONObject("functionParams");
        bVar.c = jSONObjectJsonObjectInit.optString("success");
        bVar.d = jSONObjectJsonObjectInit.optString("fail");
        return bVar;
    }

    public void a(jw jwVar) {
        this.f4286a = jwVar;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x004b  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    void a(String str, rk rkVar) throws Exception {
        byte b2;
        b bVarA = a(str);
        fr frVar = new fr();
        try {
            String str2 = bVarA.f4287a;
            switch (str2.hashCode()) {
                case -1384357108:
                    if (!str2.equals(f)) {
                        b2 = -1;
                    } else {
                        b2 = 2;
                    }
                    break;
                case 691453791:
                    if (!str2.equals("sendMessage")) {
                        b2 = -1;
                    } else {
                        b2 = 1;
                    }
                    break;
                case 842351363:
                    if (!str2.equals("loadWithUrl")) {
                        b2 = -1;
                    } else {
                        b2 = 0;
                    }
                    break;
                case 1182065477:
                    if (!str2.equals("handleGetViewVisibility")) {
                        b2 = -1;
                    } else {
                        b2 = 3;
                    }
                    break;
                case 1491535759:
                    if (!str2.equals(g)) {
                        b2 = -1;
                    } else {
                        b2 = 4;
                    }
                    break;
                default:
                    b2 = -1;
                    break;
            }
            if (b2 == 0) {
                this.b.a(this, bVarA.b, this.c, bVarA.c, bVarA.d);
                return;
            }
            if (b2 == 1) {
                this.b.d(bVarA.b, bVarA.c, bVarA.d);
                return;
            }
            if (b2 == 2) {
                this.b.c(bVarA.b, bVarA.c, bVarA.d);
            } else if (b2 == 3) {
                this.b.a(bVarA.b, bVarA.c, bVarA.d);
            } else {
                if (b2 != 4) {
                    throw new IllegalArgumentException(String.format(n, bVarA.f4287a));
                }
                this.b.b(bVarA.b, bVarA.c, bVarA.d);
            }
        } catch (Exception e2) {
            o9.d().a(e2);
            frVar.b("errMsg", e2.getMessage());
            String strC = this.b.c(bVarA.b);
            if (!TextUtils.isEmpty(strC)) {
                frVar.b("adViewId", strC);
            }
            rkVar.a(false, bVarA.d, frVar);
        }
    }

    @Override // com.json.wg
    public void a(String str, String str2, String str3) {
        a(str, uv.a(str2, str3));
    }

    @Override // com.json.wg
    public void a(String str, JSONObject jSONObject) {
        if (this.f4286a == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f4286a.a(str, jSONObject);
    }
}
