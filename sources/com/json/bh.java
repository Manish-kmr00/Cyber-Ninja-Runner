package com.json;

import android.content.Context;
import com.json.mediationsdk.logger.IronLog;
import com.json.sdk.utils.IronSourceStorageUtils;
import com.json.sdk.utils.Logger;
import com.safedk.android.internal.partials.IronSourceNetworkBridge;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class bh implements b3 {
    private static final String b = "bh";
    private static bh c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, vh> f3558a = Collections.synchronizedMap(new HashMap());

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ah f3559a;
        final /* synthetic */ Context b;
        final /* synthetic */ String c;

        a(ah ahVar, Context context, String str) {
            this.f3559a = ahVar;
            this.b = context;
            this.c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            bh.this.f3558a.put(this.c, new vg(this.f3559a, this.b));
        }
    }

    public static synchronized bh a() {
        if (c == null) {
            c = new bh();
        }
        return c;
    }

    private tg a(JSONObject jSONObject) {
        try {
            JSONObject jSONObjectJsonObjectInit = IronSourceNetworkBridge.jsonObjectInit(jSONObject.getString("adSize"));
            String string = jSONObjectJsonObjectInit.get("height").toString();
            String string2 = jSONObjectJsonObjectInit.get("width").toString();
            return new tg(Integer.parseInt(string2), Integer.parseInt(string), jSONObjectJsonObjectInit.get("label").toString());
        } catch (Exception e) {
            o9.d().a(e);
            return new tg();
        }
    }

    private tg b(JSONObject jSONObject) {
        tg tgVar = new tg();
        try {
            return a(jSONObject);
        } catch (Exception e) {
            o9.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return tgVar;
        }
    }

    private boolean d(JSONObject jSONObject) {
        return jSONObject.optBoolean(b9.h.s0);
    }

    @Override // com.json.b3
    public vh a(String str) {
        if (str.isEmpty() || !this.f3558a.containsKey(str)) {
            return null;
        }
        return this.f3558a.get(str);
    }

    public void a(wg wgVar, JSONObject jSONObject, Context context, String str, String str2) throws Exception {
        String string = jSONObject.getString("adViewId");
        if (string.isEmpty()) {
            Logger.i(b, "loadWithUrl fail - adViewId is empty");
            throw new Exception("adViewId is empty");
        }
        tg tgVarB = b(jSONObject);
        if (this.f3558a.containsKey(string)) {
            Logger.i(b, "sendMessageToAd fail - collection already contain adViewId");
            throw new Exception("collection already contain adViewId");
        }
        ah ahVar = new ah(wgVar, context, string, tgVarB);
        ahVar.e(IronSourceStorageUtils.getNetworkStorageDir(context));
        ahVar.b(jSONObject, str, str2);
        if (d(jSONObject)) {
            hg.f3748a.d(new a(ahVar, context, string));
        } else {
            this.f3558a.put(string, ahVar);
        }
    }

    public void a(JSONObject jSONObject, String str, String str2) throws Exception {
        String string = jSONObject.getString("adViewId");
        if (string.isEmpty()) {
            Logger.i(b, "removeAdView fail - adViewId is empty");
            throw new Exception("adViewId is empty");
        }
        if (!this.f3558a.containsKey(string)) {
            Logger.i(b, "removeAdView fail - collection does not contain adViewId");
            throw new Exception("collection does not contain adViewId");
        }
        vh vhVar = this.f3558a.get(string);
        if (vhVar != null) {
            vhVar.a(jSONObject, str, str2);
        }
    }

    public void b(JSONObject jSONObject, String str, String str2) throws Exception {
        String string = jSONObject.getString("adViewId");
        if (string.isEmpty()) {
            Logger.i(b, "performWebViewAction fail - adViewId is empty");
            throw new Exception("adViewId is empty");
        }
        if (!this.f3558a.containsKey(string)) {
            Logger.i(b, "performWebViewAction fail - collection does not contain adViewId");
            throw new Exception("collection does not contain adViewId");
        }
        vh vhVar = this.f3558a.get(string);
        String string2 = jSONObject.getString(b9.h.v0);
        if (vhVar != null) {
            vhVar.a(string2, str, str2);
        }
    }

    public String c(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null || !jSONObject.has("adViewId")) {
            return (jSONObject == null || !jSONObject.has("params")) ? "" : IronSourceNetworkBridge.jsonObjectInit(jSONObject.getString("params")).getString("adViewId");
        }
        return jSONObject.getString("adViewId");
    }

    public void c(JSONObject jSONObject, String str, String str2) throws Exception {
        String string = jSONObject.getString("adViewId");
        if (string.isEmpty()) {
            Logger.i(b, "removeAdView fail - adViewId is empty");
            throw new Exception("adViewId is empty");
        }
        if (!this.f3558a.containsKey(string)) {
            Logger.i(b, "removeAdView fail - collection does not contain adViewId");
            throw new Exception("collection does not contain adViewId");
        }
        vh vhVar = this.f3558a.get(string);
        this.f3558a.remove(string);
        if (vhVar != null) {
            vhVar.a(str, str2);
        }
    }

    public void d(JSONObject jSONObject, String str, String str2) throws Exception {
        String string = IronSourceNetworkBridge.jsonObjectInit(jSONObject.getString("params")).getString("adViewId");
        if (string.isEmpty()) {
            Logger.i(b, "sendMessageToAd fail - adViewId is empty");
            throw new Exception("adViewId is empty");
        }
        if (!this.f3558a.containsKey(string)) {
            Logger.i(b, "sendMessageToAd fail - collection does not contain adViewId");
            throw new Exception("collection does not contain adViewId");
        }
        vh vhVar = this.f3558a.get(string);
        if (vhVar != null) {
            vhVar.c(jSONObject, str, str2);
        }
    }
}
