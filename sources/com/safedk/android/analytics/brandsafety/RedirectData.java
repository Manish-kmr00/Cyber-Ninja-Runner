package com.safedk.android.analytics.brandsafety;

import android.os.Bundle;
import android.text.TextUtils;
import com.safedk.android.analytics.events.BrandSafetyEvent;
import com.safedk.android.utils.PersistableBase;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public class RedirectData extends PersistableBase {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f8023a = "is_redirect";
    public static final String b = "is_expand";
    public static final String c = "is_auto_expand";
    public static final String d = "redirect_url";
    public static final String e = "redirect_request_url";
    public static final String f = "redirect_type";
    public static final String g = "is_website_opened";
    public static final String h = "is_auto_website_opened";
    private static final long serialVersionUID = 1;
    public boolean i = false;
    public boolean j = false;
    public boolean k = false;
    public boolean l = false;
    public String m = null;
    public String n = null;
    public String o = null;
    public String p = null;
    public String q = null;
    public String r;
    public long s;
    public BrandSafetyEvent.AdFormatType t;

    public RedirectData() {
    }

    public RedirectData(String sdkPackageName, BrandSafetyEvent.AdFormatType adFormatType) {
        this.r = sdkPackageName;
        this.t = adFormatType;
    }

    public void a(String str, String str2, String str3) {
        this.i = true;
        this.m = str2;
        this.n = str;
        this.o = str3;
        this.s = System.currentTimeMillis();
    }

    public void b(String str, String str2, String str3) {
        this.j = true;
        this.n = str;
        if (str2 == null) {
            str2 = str;
        }
        this.m = str2;
        this.p = str3;
        this.s = System.currentTimeMillis();
    }

    public void a(String str, String str2) {
        this.k = true;
        this.n = str;
        if (str2 == null) {
            str2 = str;
        }
        this.m = str2;
        this.s = System.currentTimeMillis();
    }

    public synchronized void a(String str) {
        if (str != null) {
            if (this.q == null) {
                this.q = str;
            } else if (!this.q.contains(str)) {
                this.q += l.ac + str;
            }
        }
    }

    public synchronized Bundle a() {
        Bundle bundle;
        bundle = new Bundle();
        if (this.i && this.l) {
            bundle.putBoolean("is_redirect", true);
        }
        if (this.j) {
            bundle.putBoolean(this.l ? c : b, true);
        }
        if (this.k) {
            bundle.putBoolean(this.l ? h : g, true);
        }
        if (!TextUtils.isEmpty(this.m)) {
            bundle.putString("redirect_url", this.m);
        }
        if (!TextUtils.isEmpty(this.n)) {
            bundle.putString(e, this.n);
        }
        if (!TextUtils.isEmpty(this.o)) {
            bundle.putString("redirect_type", this.o);
        }
        return bundle;
    }

    @Override // com.safedk.android.utils.f
    public JSONObject i() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("isRedirect", this.i);
        jSONObject.put("isExpand", this.j);
        jSONObject.put("isWebsiteOpened", this.k);
        jSONObject.put("isAuto", this.l);
        jSONObject.put("redirectUrl", this.m);
        jSONObject.put("redirectRequestUrl", this.n);
        jSONObject.put("redirectType", this.o);
        jSONObject.put("expandedWebviewAddress", this.p);
        jSONObject.put("debugInfo", this.q);
        jSONObject.put("sdkPackageName", this.r);
        jSONObject.put("redirectTimestamp", this.s);
        if (this.t != null) {
            jSONObject.put("adFormatType", this.t.name());
        }
        return jSONObject;
    }

    @Override // com.safedk.android.utils.f
    public void a(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.i = jSONObject.optBoolean("isRedirect", false);
            this.j = jSONObject.optBoolean("isExpand", false);
            this.k = jSONObject.optBoolean("isWebsiteOpened", false);
            this.l = jSONObject.optBoolean("isAuto", false);
            this.m = jSONObject.optString("redirectUrl", "");
            this.n = jSONObject.optString("redirectRequestUrl", "");
            this.o = jSONObject.optString("redirectType", "");
            this.p = jSONObject.optString("expandedWebviewAddress", "");
            this.q = jSONObject.optString("debugInfo", "");
            this.r = jSONObject.optString("sdkPackageName", "");
            this.s = jSONObject.optLong("redirectTimestamp", 0L);
            String strOptString = jSONObject.optString("adFormatType", "");
            this.t = strOptString.isEmpty() ? null : BrandSafetyEvent.AdFormatType.valueOf(strOptString);
        }
    }
}
