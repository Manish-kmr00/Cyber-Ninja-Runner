package com.json;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import com.json.mediationsdk.logger.IronLog;
import com.safedk.android.internal.partials.IronSourceNetworkBridge;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class yg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private wg f4619a;
    private WebView c;
    private String d;
    private String e = "yg";
    private String[] f = {"handleGetViewVisibility"};
    private final String[] g = {ug.h, ug.i, ug.g, "handleGetViewVisibility", ug.j};
    private pv b = new pv();

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4620a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ JSONObject d;

        a(String str, String str2, String str3, JSONObject jSONObject) {
            this.f4620a = str;
            this.b = str2;
            this.c = str3;
            this.d = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (!yg.this.b(this.f4620a)) {
                    String str = "ISNAdViewLogic | handleMessageFromController | cannot handle command: " + this.f4620a;
                    Log.e(yg.this.e, str);
                    yg.this.a(this.b, str);
                } else if (this.f4620a.equalsIgnoreCase("handleGetViewVisibility")) {
                    yg.this.e(this.c);
                } else if (this.f4620a.equalsIgnoreCase(ug.j) || this.f4620a.equalsIgnoreCase(ug.i)) {
                    yg.this.a(this.d.getString("params"), this.c, this.b);
                }
            } catch (Exception e) {
                o9.d().a(e);
                IronLog.INTERNAL.error(e.toString());
                String str2 = "ISNAdViewLogic | handleMessageFromController | Error while trying handle message: " + this.f4620a;
                Log.e(yg.this.e, str2);
                yg.this.a(this.b, str2);
            }
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4621a;
        final /* synthetic */ String b;

        b(String str, String str2) {
            this.f4621a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                IronSourceNetworkBridge.webViewEvaluateJavaScript(yg.this.c, this.f4621a, null);
            } catch (Throwable th) {
                o9.d().a(th);
                Log.e(yg.this.e, "injectJavaScriptIntoWebView | Error while trying inject JS into external adUnit: " + this.b + "Android API level: " + Build.VERSION.SDK_INT);
            }
        }
    }

    private String a(String str) {
        return String.format(ug.u, str);
    }

    private JSONObject a(JSONObject jSONObject) {
        JSONObject jSONObjectJsonObjectInit = IronSourceNetworkBridge.jsonObjectInit();
        try {
            jSONObjectJsonObjectInit.put("id", jSONObject.getString("id"));
            jSONObjectJsonObjectInit.put("data", this.b.a());
        } catch (Exception e) {
            o9.d().a(e);
            Log.e(this.e, "Error while trying execute method buildVisibilityMessageForAdUnit | params: " + jSONObject);
            IronLog.INTERNAL.error(e.toString());
        }
        return jSONObjectJsonObjectInit;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str) {
        for (String str2 : this.g) {
            if (str2.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    private void d() {
        if (this.f4619a == null || this.b == null) {
            return;
        }
        a(ug.f4490a, a());
    }

    private void d(String str) {
        hg.f3748a.d(new b("javascript:try{" + str + "}catch(e){console.log(\"JS exception: \" + JSON.stringify(e));}", str));
    }

    private boolean h(String str) {
        for (String str2 : this.f) {
            if (str2.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    private boolean i(String str) {
        return str.equalsIgnoreCase(ug.k);
    }

    public JSONObject a() {
        JSONObject jSONObjectJsonObjectInit = IronSourceNetworkBridge.jsonObjectInit();
        try {
            JSONObject jSONObjectJsonObjectInit2 = IronSourceNetworkBridge.jsonObjectInit();
            jSONObjectJsonObjectInit2.put(ug.s, this.b.a());
            jSONObjectJsonObjectInit.put(ug.p, jSONObjectJsonObjectInit2);
            jSONObjectJsonObjectInit.put("adViewId", c());
            return jSONObjectJsonObjectInit;
        } catch (JSONException e) {
            o9.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return IronSourceNetworkBridge.jsonObjectInit();
        }
    }

    public void a(WebView webView) {
        this.c = webView;
    }

    public void a(wg wgVar) {
        this.f4619a = wgVar;
    }

    public void a(String str, int i, boolean z) {
        this.b.a(str, i, z);
        if (i(str)) {
            d();
        }
    }

    public void a(String str, String str2) {
        wg wgVar = this.f4619a;
        if (wgVar != null) {
            wgVar.a(str, str2, this.d);
        }
    }

    public void a(String str, String str2, String str3) throws JSONException {
        if (this.c == null) {
            String str4 = "No external adUnit attached to ISNAdView while trying to send message: " + str;
            Log.e(this.e, str4);
            this.f4619a.a(str3, str4, this.d);
            return;
        }
        try {
            IronSourceNetworkBridge.jsonObjectInit(str);
        } catch (JSONException e) {
            o9.d().a(e);
            str = "\"" + str + "\"";
        }
        d(a(str));
        JSONObject jSONObjectJsonObjectInit = IronSourceNetworkBridge.jsonObjectInit();
        jSONObjectJsonObjectInit.put("adViewId", this.d);
        a(str2, jSONObjectJsonObjectInit);
    }

    public void a(String str, JSONObject jSONObject) {
        wg wgVar = this.f4619a;
        if (wgVar != null) {
            wgVar.a(str, jSONObject);
        }
    }

    void a(String str, JSONObject jSONObject, String str2, String str3) {
        if (this.f4619a == null) {
            lh.a(er.t, new gh().a(cc.y, "mDelegate is null").a());
        } else {
            hg.f3748a.d(new a(str, str3, str2, jSONObject));
        }
    }

    public void a(JSONObject jSONObject, String str, String str2) throws JSONException {
        a(a(jSONObject).toString(), str, str2);
    }

    public void b() {
        this.f4619a = null;
        this.b = null;
    }

    public String c() {
        return this.d;
    }

    public void c(String str) {
        try {
            JSONObject jSONObjectJsonObjectInit = IronSourceNetworkBridge.jsonObjectInit(str);
            String strOptString = jSONObjectJsonObjectInit.optString("method");
            if (TextUtils.isEmpty(strOptString) || !h(strOptString)) {
                a(jSONObjectJsonObjectInit.optString(ug.v, ug.c), jSONObjectJsonObjectInit);
            } else if (strOptString.equalsIgnoreCase("handleGetViewVisibility")) {
                a(jSONObjectJsonObjectInit, (String) null, (String) null);
            }
        } catch (JSONException e) {
            o9.d().a(e);
            Log.e(this.e, "ISNAdViewLogic | receiveMessageFromExternal | Error while trying handle message: " + str);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    public void e() {
        if (this.f4619a == null || this.b == null) {
            return;
        }
        a(ug.b, a());
    }

    public void e(String str) throws JSONException {
        JSONObject jSONObjectA = this.b.a();
        jSONObjectA.put("adViewId", this.d);
        a(str, jSONObjectA);
    }

    public void f(String str) {
        try {
            JSONObject jSONObjectJsonObjectInit = IronSourceNetworkBridge.jsonObjectInit();
            jSONObjectJsonObjectInit.put("adViewId", this.d);
            a(str, jSONObjectJsonObjectInit);
        } catch (JSONException e) {
            o9.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    public void g(String str) {
        this.d = str;
    }
}
