package com.applovin.impl;

import android.app.ActivityManager;
import android.net.Uri;
import android.os.SystemClock;
import com.applovin.impl.sdk.array.ArrayService;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinSdk;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.google.android.gms.security.ProviderInstaller;
import com.safedk.android.utils.SdksMapping;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import net.pubnative.lite.sdk.models.AdExperience;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class r5 extends g5 {
    private static final AtomicBoolean j = new AtomicBoolean();
    private final int g;
    private final Object h;
    private b i;

    public interface b {
        void a(JSONObject jSONObject);
    }

    private class c extends g5 {
        public c(com.applovin.impl.sdk.k kVar) {
            super("TaskTimeoutFetchBasicSettings", kVar, true);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (r5.this.i != null) {
                if (com.applovin.impl.sdk.o.a()) {
                    this.c.b(this.b, "Timing out fetch basic settings...");
                }
                r5.this.a(new JSONObject());
            }
        }
    }

    public r5(int i, com.applovin.impl.sdk.k kVar, b bVar) {
        super("TaskFetchBasicSettings", kVar, true);
        this.h = new Object();
        this.g = i;
        this.i = bVar;
    }

    private HashMap b(String str) {
        return a(str, 0L, 0, null, null);
    }

    private String f() {
        return r0.a((String) this.f424a.a(v4.n0), "5.0/i", b());
    }

    private String g() {
        return r0.a((String) this.f424a.a(v4.m0), "5.0/i", b());
    }

    protected JSONObject e() {
        JSONObject jSONObject = new JSONObject();
        try {
            com.applovin.impl.sdk.k kVar = this.f424a;
            v4 v4Var = v4.o5;
            if (((Boolean) kVar.a(v4Var)).booleanValue() || ((Boolean) this.f424a.a(v4Var)).booleanValue()) {
                jSONObject.put(com.safedk.android.analytics.brandsafety.l.x, UUID.randomUUID().toString());
            }
            jSONObject.put("sdk_version", AppLovinSdk.VERSION);
            JsonUtils.putStringIfValid(jSONObject, "ad_review_sdk_version", j.b());
            jSONObject.put("init_count", this.g);
            jSONObject.put("server_installed_at", this.f424a.a(v4.o));
            if (this.f424a.D0()) {
                jSONObject.put("first_install", true);
            }
            if (!this.f424a.A0()) {
                jSONObject.put("first_install_v2", true);
            }
            JsonUtils.putStringIfValid(jSONObject, "process_name", k7.c(a()));
            JsonUtils.putBooleanIfValid(jSONObject, "is_main_process", k7.i(a()));
            JsonUtils.putStringIfValid(jSONObject, "plugin_version", (String) this.f424a.a(v4.I3));
            JsonUtils.putStringIfValid(jSONObject, "mediation_provider", this.f424a.V());
            JsonUtils.putStringIfValid(jSONObject, "mediation_provider_v2", this.f424a.D());
            jSONObject.put(SdksMapping.KEY_INSTALLED_MEDIATION_ADAPTERS, t3.b(this.f424a));
            Map mapE = this.f424a.B().E();
            jSONObject.put("package_name", mapE.get("package_name"));
            jSONObject.put("app_version", mapE.get("app_version"));
            jSONObject.put("debug", mapE.get("debug"));
            jSONObject.put("tg", mapE.get("tg"));
            jSONObject.put("target_sdk", mapE.get("target_sdk"));
            jSONObject.put(SDKAnalyticsEvents.PARAMETER_SESSION_ID, mapE.get(SDKAnalyticsEvents.PARAMETER_SESSION_ID));
            List list = (List) mapE.get("application_start_info");
            if (!CollectionUtils.isEmpty(list)) {
                JsonUtils.putJsonArray(jSONObject, "application_start_info", new JSONArray((Collection) list));
            }
            List list2 = (List) mapE.get("application_exit_info");
            if (!CollectionUtils.isEmpty(list2)) {
                JsonUtils.putJsonArray(jSONObject, "application_exit_info", new JSONArray((Collection) list2));
            }
            List<String> adUnitIds = this.f424a.K() != null ? this.f424a.K().getAdUnitIds() : null;
            if (adUnitIds != null && adUnitIds.size() > 0) {
                List<String> listRemoveTrimmedEmptyStrings = CollectionUtils.removeTrimmedEmptyStrings(adUnitIds);
                jSONObject.put("ad_unit_ids", CollectionUtils.implode(listRemoveTrimmedEmptyStrings, listRemoveTrimmedEmptyStrings.size()));
            }
            jSONObject.put("IABTCF_TCString", mapE.get("IABTCF_TCString"));
            jSONObject.put("IABTCF_gdprApplies", mapE.get("IABTCF_gdprApplies"));
            Object obj = mapE.get("IABTCF_AddtlConsent");
            if (obj instanceof String) {
                JsonUtils.putStringIfValid(jSONObject, "IABTCF_AddtlConsent", (String) obj);
            }
            jSONObject.put("consent_flow_info", this.f424a.y().b());
            Map mapL = this.f424a.B().L();
            jSONObject.put("platform", mapL.get("platform"));
            jSONObject.put("os", mapL.get("os"));
            jSONObject.put(CommonUrlParts.LOCALE, mapL.get(CommonUrlParts.LOCALE));
            jSONObject.put(AdExperience.BRAND, mapL.get(AdExperience.BRAND));
            jSONObject.put("brand_name", mapL.get("brand_name"));
            jSONObject.put("hardware", mapL.get("hardware"));
            jSONObject.put("model", mapL.get("model"));
            jSONObject.put("revision", mapL.get("revision"));
            jSONObject.put("is_tablet", mapL.get("is_tablet"));
            jSONObject.put("screen_size_in", mapL.get("screen_size_in"));
            jSONObject.put("supported_abis", mapL.get("supported_abis"));
            Object obj2 = mapL.get("video_decoders");
            if (obj2 != null) {
                jSONObject.put("video_decoders", obj2);
            }
            if (((Boolean) this.f424a.a(v4.T3)).booleanValue()) {
                jSONObject.put("mtl", this.f424a.n0().getLastTrimMemoryLevel());
            }
            try {
                ActivityManager activityManager = (ActivityManager) com.applovin.impl.sdk.k.o().getSystemService("activity");
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                if (activityManager != null) {
                    activityManager.getMemoryInfo(memoryInfo);
                    jSONObject.put("fm", memoryInfo.availMem);
                    jSONObject.put("tm", memoryInfo.totalMem);
                    jSONObject.put("lmt", memoryInfo.threshold);
                    jSONObject.put("lm", memoryInfo.lowMemory);
                }
            } catch (Throwable unused) {
            }
            v.a aVarF = this.f424a.B().f();
            jSONObject.put("dnt", aVarF.c());
            jSONObject.put("dnt_code", aVarF.b().b());
            Boolean boolB = p0.c().b(a());
            if (((Boolean) this.f424a.a(v4.D3)).booleanValue() && StringUtils.isValidString(aVarF.a()) && !Boolean.TRUE.equals(boolB)) {
                jSONObject.put("idfa", aVarF.a());
            }
            com.applovin.impl.sdk.l.b bVarF = this.f424a.B().F();
            if (((Boolean) this.f424a.a(v4.w3)).booleanValue() && bVarF != null && !Boolean.TRUE.equals(boolB)) {
                jSONObject.put("idfv", bVarF.f662a);
                jSONObject.put("idfv_scope", bVarF.b);
            }
            if (((Boolean) this.f424a.a(v4.z3)).booleanValue()) {
                jSONObject.put("compass_random_token", this.f424a.v());
            }
            if (((Boolean) this.f424a.a(v4.B3)).booleanValue()) {
                jSONObject.put("applovin_random_token", this.f424a.i0());
            }
            if (((Boolean) this.f424a.a(v4.F3)).booleanValue()) {
                JsonUtils.putStringIfValid(jSONObject, "art", this.f424a.s());
            }
            JsonUtils.putStringIfValid(jSONObject, "eventid", this.f424a.F());
            if (this.f424a.t0().c()) {
                jSONObject.put("test_mode", true);
            }
            List listB = this.f424a.t0().b();
            if (listB != null && !listB.isEmpty()) {
                jSONObject.put("test_mode_networks", listB);
            }
            jSONObject.put("sdk_extra_parameters", new JSONObject(this.f424a.o0().getExtraParameters()));
            Map mapL0 = this.f424a.l0();
            if (!CollectionUtils.isEmpty(mapL0)) {
                jSONObject.put("segments", new JSONObject(mapL0));
            }
            if (this.g > 1) {
                ArrayService arrayServiceP = this.f424a.p();
                if (arrayServiceP.getIsDirectDownloadEnabled() != null) {
                    jSONObject.put("ah_dd_enabled", arrayServiceP.getIsDirectDownloadEnabled());
                }
                jSONObject.put("ah_sdk_version_code", arrayServiceP.getAppHubVersionCode());
                jSONObject.put("ah_random_user_token", StringUtils.emptyIfNull(arrayServiceP.getRandomUserToken()));
                jSONObject.put("ah_sdk_package_name", StringUtils.emptyIfNull(arrayServiceP.getAppHubPackageName()));
            }
        } catch (JSONException e) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Failed to create JSON body", e);
            }
            this.f424a.E().a(this.b, "createJSONBody", e);
        }
        return jSONObject;
    }

    protected Map h() {
        HashMap map = new HashMap();
        if (!((Boolean) this.f424a.a(v4.p5)).booleanValue() && !((Boolean) this.f424a.a(v4.o5)).booleanValue()) {
            map.put(com.safedk.android.analytics.brandsafety.l.x, UUID.randomUUID().toString());
        }
        if (!((Boolean) this.f424a.a(v4.a5)).booleanValue()) {
            map.put("sdk_key", this.f424a.j0());
        }
        CollectionUtils.putStringIfValid("connectEventKey", this.f424a.r(), map);
        Boolean boolB = p0.b().b(a());
        if (boolB != null) {
            map.put("huc", boolB.toString());
        }
        Boolean boolB2 = p0.c().b(a());
        if (boolB2 != null) {
            map.put("aru", boolB2.toString());
        }
        Boolean boolB3 = p0.a().b(a());
        if (boolB3 != null) {
            map.put("dns", boolB3.toString());
        }
        return map;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!o0.j() && j.compareAndSet(false, true)) {
            try {
                ProviderInstaller.installIfNeeded(com.applovin.impl.sdk.k.o());
            } catch (Throwable th) {
                if (com.applovin.impl.sdk.o.a()) {
                    this.c.a(this.b, "Cannot update security provider", th);
                }
            }
        }
        this.f424a.w0().d(c2.f, b(g()));
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Map mapH = h();
        com.applovin.impl.sdk.network.a.C0143a c0143aB = com.applovin.impl.sdk.network.a.a(this.f424a).b(g()).a(f()).b(mapH).a(e()).b(((Boolean) this.f424a.a(v4.A5)).booleanValue()).c("POST").a((Object) new JSONObject()).a(((Integer) this.f424a.a(v4.a3)).intValue()).b(((Integer) this.f424a.a(v4.d3)).intValue());
        com.applovin.impl.sdk.k kVar = this.f424a;
        v4 v4Var = v4.Z2;
        com.applovin.impl.sdk.network.a aVarA = c0143aB.c(((Integer) kVar.a(v4Var)).intValue()).e(((Boolean) this.f424a.a(v4.m3)).booleanValue()).a(s4.a.a(((Integer) this.f424a.a(v4.f5)).intValue())).f(true).a();
        this.f424a.r0().a(new c(this.f424a), b6.b.TIMEOUT, ((long) ((Integer) this.f424a.a(v4Var)).intValue()) + 250);
        a aVar = new a(aVarA, this.f424a, d(), jElapsedRealtime);
        aVar.c(v4.m0);
        aVar.b(v4.n0);
        this.f424a.r0().a(aVar);
    }

    class a extends j6 {
        final /* synthetic */ long m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(com.applovin.impl.sdk.network.a aVar, com.applovin.impl.sdk.k kVar, boolean z, long j) {
            super(aVar, kVar, z);
            this.m = j;
        }

        @Override // com.applovin.impl.j6, com.applovin.impl.q0.e
        public void a(String str, JSONObject jSONObject, int i) {
            long jElapsedRealtime = SystemClock.elapsedRealtime() - this.m;
            r5.this.a(jSONObject);
            this.f424a.w0().d(c2.g, r5.this.a(str, jElapsedRealtime, i, jSONObject, null));
        }

        @Override // com.applovin.impl.j6, com.applovin.impl.q0.e
        public void a(String str, int i, String str2, JSONObject jSONObject) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.b(this.b, "Unable to fetch basic SDK settings: server returned " + i);
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime() - this.m;
            r5.this.a(jSONObject != null ? jSONObject : new JSONObject());
            this.f424a.w0().d(c2.h, r5.this.a(str, jElapsedRealtime, i, jSONObject, str2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap a(String str, long j2, int i, JSONObject jSONObject, String str2) {
        Uri uriBuild = Uri.parse(str).buildUpon().clearQuery().build();
        JSONObject jSONObject2 = new JSONObject();
        JsonUtils.putString(jSONObject2, "domain", uriBuild.getHost());
        if (jSONObject != null) {
            JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "signal_providers", null);
            JSONArray jSONArray2 = JsonUtils.getJSONArray(jSONObject, "auto_init_adapters", null);
            if (jSONArray != null) {
                JsonUtils.putInt(jSONObject2, "signal_provider_count", jSONArray.length());
            }
            if (jSONArray2 != null) {
                JsonUtils.putInt(jSONObject2, "auto_init_adapter_count", jSONArray2.length());
            }
        }
        HashMap map = new HashMap();
        map.put("attempt_number", Integer.toString(this.g));
        map.put("error_message", str2);
        map.put("url", uriBuild.toString());
        map.put("details", jSONObject2.toString());
        map.put("duration_ms", Long.toString(j2));
        map.put("code", Integer.toString(i));
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject) {
        b bVar;
        synchronized (this.h) {
            bVar = this.i;
            this.i = null;
        }
        if (bVar != null) {
            bVar.a(jSONObject);
        }
    }
}
