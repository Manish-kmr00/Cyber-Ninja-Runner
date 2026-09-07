package com.safedk.android.analytics.events;

import android.os.Bundle;
import android.text.TextUtils;
import com.safedk.android.analytics.StatsCollector;
import com.safedk.android.analytics.brandsafety.p;
import com.safedk.android.analytics.events.base.StatsEvent;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.SdksMapping;
import com.safedk.android.utils.n;
import com.unity3d.services.UnityAdsConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class RedirectEvent extends StatsEvent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f8124a = 120000;
    public static final String b = "redirect";
    public static final String c = "redirect_url";
    public static final String d = "redirect_type";
    public static final String e = "foreground_activity";
    public static final String f = "max_events";
    public static final String g = "touch_ts";
    public static final String h = "external";
    public static final String i = "internal";
    public static final String j = "customtab";
    public static final String k = "suspected_store_kit";
    private static final String l = "RedirectEvent";
    private static final long serialVersionUID = 0;
    private String m;
    private String n;
    private String o;
    private String p;
    private MaxEvents q;
    private long r;

    public RedirectEvent() {
        this.q = null;
    }

    public RedirectEvent(String sdk, String redirectUrl, String redirectType, String foregroundActivity, long timestamp, long touchTs) {
        super(sdk, StatsCollector.EventType.redirect);
        this.q = null;
        Logger.d(l, "RedirectEvent ctor started, sdk=" + sdk + ", redirectUrl=" + redirectUrl + ", redirectType=" + redirectType + ", foregroundActivity=" + foregroundActivity + " ,timestamp=" + timestamp + ", touchTs=" + touchTs);
        Logger.d(l, "RedirectEvent ctor SdksMapping.getSdkNameByPackage()=" + SdksMapping.getSdkNameByPackage(sdk));
        Logger.d(l, "RedirectEvent ctor SdksMapping.getSdkPackageByClass()=" + SdksMapping.getSdkPackageByClass(sdk));
        String sdkUUIDByPackage = SdksMapping.getSdkUUIDByPackage(sdk);
        if (sdkUUIDByPackage != null && SdksMapping.getAllSdkVersionsMap() != null && SdksMapping.getAllSdkVersionsMap().get(sdkUUIDByPackage) != null) {
            this.m = SdksMapping.getAllSdkVersionsMap().get(sdkUUIDByPackage);
            Logger.d(l, "RedirectEvent ctor sdkVersion=" + this.m);
        } else {
            Logger.d(l, "RedirectEvent ctor cannot find version for sdk " + sdk + " , SdkVersionsMap=" + SdksMapping.getAllSdkVersionsMap());
        }
        this.n = redirectUrl;
        this.o = redirectType;
        this.p = foregroundActivity;
        this.r = n.b(touchTs);
        this.I = false;
    }

    public void a(MaxEvents maxEvents) {
        synchronized (p.a()) {
            this.q = (MaxEvents) maxEvents.clone();
            Logger.d(l, "setMaxEvents , added " + this.q.size() + " items. content : " + this.q);
        }
    }

    @Override // com.safedk.android.analytics.events.base.StatsEvent
    public StatsCollector.EventType a() {
        return StatsCollector.EventType.redirect;
    }

    @Override // com.safedk.android.analytics.events.base.StatsEvent
    public String b() {
        StringBuilder sb = new StringBuilder();
        sb.append(StatsCollector.EventType.redirect + "_");
        sb.append(this.n == null ? "_" : this.n + "_");
        sb.append(this.G);
        Logger.d(l, "Getting key from object : " + sb.toString());
        return sb.toString();
    }

    public static String b(Bundle bundle) {
        StringBuilder sb = new StringBuilder();
        sb.append(StatsCollector.EventType.redirect + "_");
        if (bundle.getString("redirect_url") == null) {
            sb.append("_");
        } else {
            sb.append(bundle.getString("redirect_url") + "_");
        }
        sb.append(bundle.getLong("timestamp"));
        Logger.d(l, "Getting key from bundle : " + sb.toString());
        return sb.toString();
    }

    @Override // com.safedk.android.analytics.events.base.StatsEvent
    public void a(StatsEvent statsEvent) {
        if (((RedirectEvent) statsEvent).I) {
            this.I = true;
        }
        if (((RedirectEvent) statsEvent).f() != null && f() == null) {
            a(((RedirectEvent) statsEvent).f());
        }
    }

    @Override // com.safedk.android.analytics.events.base.StatsEvent
    public Bundle d() {
        Bundle bundleD = super.d();
        bundleD.putString("sdk_version", this.m);
        bundleD.putString("redirect_url", this.n);
        bundleD.putString("redirect_type", this.o);
        bundleD.putString("foreground_activity", this.p);
        bundleD.putLong(g, this.r);
        if (this.q != null && this.q.size() > 0) {
            synchronized (p.a()) {
                bundleD.putParcelableArrayList(f, this.q.a());
            }
        }
        Logger.d(l, "Redirect Event toBundle : " + bundleD.toString());
        return bundleD;
    }

    @Override // com.safedk.android.analytics.events.base.StatsEvent
    public boolean a_() {
        return System.currentTimeMillis() - this.G > UnityAdsConstants.Timeout.INIT_TIMEOUT_MS || this.n != null || this.I;
    }

    public String f() {
        return this.n;
    }

    public void a(String str) {
        this.n = str;
    }

    @Override // com.safedk.android.analytics.events.base.StatsEvent, com.safedk.android.utils.f
    public JSONObject i() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("touchTs", this.r);
        if (!TextUtils.isEmpty(this.m)) {
            jSONObject.put("sdkVersion", this.m);
        }
        if (!TextUtils.isEmpty(this.n)) {
            jSONObject.put("redirectUrl", this.n);
        }
        if (!TextUtils.isEmpty(this.o)) {
            jSONObject.put("redirectType", this.o);
        }
        if (!TextUtils.isEmpty(this.p)) {
            jSONObject.put("foregroundActivity", this.p);
        }
        if (this.q != null) {
            jSONObject.put("maxEvents", this.q.i());
        }
        return jSONObject;
    }

    @Override // com.safedk.android.analytics.events.base.StatsEvent, com.safedk.android.utils.f
    public void a(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.r = jSONObject.optLong("touchTs", 0L);
            this.m = jSONObject.optString("sdkVersion", "");
            this.n = jSONObject.optString("redirectUrl", "");
            this.o = jSONObject.optString("redirectType", "");
            this.p = jSONObject.optString("foregroundActivity", "");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("maxEvents");
            if (jSONObjectOptJSONObject != null) {
                this.q = new MaxEvents();
                this.q.a(jSONObjectOptJSONObject);
            }
        }
    }
}
