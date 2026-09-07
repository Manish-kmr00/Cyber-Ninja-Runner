package com.applovin.impl;

import android.content.Context;
import com.applovin.impl.mediation.MaxErrorImpl;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.adapter.MaxAdapterError;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.UUID;
import kotlin.UByte$$ExternalSyntheticBackport0;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class t5 extends g5 {
    private final x2 g;
    private final JSONArray h;
    private final Context i;
    private final com.applovin.impl.mediation.ads.a.InterfaceC0135a j;

    public t5(x2 x2Var, JSONArray jSONArray, Context context, com.applovin.impl.sdk.k kVar, com.applovin.impl.mediation.ads.a.InterfaceC0135a interfaceC0135a) {
        super("TaskFetchMediatedAd", kVar, x2Var.b());
        this.g = x2Var;
        this.h = jSONArray;
        this.i = context;
        this.j = interfaceC0135a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(JSONObject jSONObject) {
        try {
            r0.c(jSONObject, this.f424a);
            r0.b(jSONObject, this.f424a);
            r0.a(jSONObject, this.f424a);
            i3.f(jSONObject, this.f424a);
            i3.d(jSONObject, this.f424a);
            i3.e(jSONObject, this.f424a);
            i3.g(jSONObject, this.f424a);
            this.f424a.m().a();
            MaxAdFormat maxAdFormatA = this.g.a();
            MaxAdFormat fromString = MaxAdFormat.formatFromString(JsonUtils.getString(jSONObject, "ad_format", null));
            if (maxAdFormatA == fromString) {
                a(jSONObject);
                return;
            }
            String strB = this.g.b();
            if (fromString == null) {
                if (com.applovin.impl.sdk.o.a()) {
                    this.c.b(this.b, "Mediated ad response is missing the ad format field for ad unit " + strB);
                }
                if (jSONObject.has("ads")) {
                    HashMap map = new HashMap(3);
                    CollectionUtils.putStringIfValid("details", "Missing ad format field", map);
                    CollectionUtils.putStringIfValid("ad_unit_id", strB, map);
                    CollectionUtils.putStringIfValid("mcode", JsonUtils.getString(jSONObject, "mcode", ""), map);
                    this.f424a.E().a(c2.M0, this.b, map);
                }
                this.j.onAdLoadFailed(strB, MaxAdapterError.NO_FILL);
                return;
            }
            String label = fromString.getLabel();
            String label2 = maxAdFormatA.getLabel();
            String str = "Incorrect format (" + label + ") loaded for (" + label2 + ") ad. Please verify if the ad unit ID (" + strB + ") is assigned to the correct ad format.";
            if (k7.a(maxAdFormatA, fromString)) {
                com.applovin.impl.sdk.o.j(this.b, str);
                a(jSONObject);
                return;
            }
            k1.a(str, new Object[0]);
            com.applovin.impl.sdk.o.h(this.b, str);
            this.j.onAdLoadFailed(strB, new MaxAdapterError(MaxAdapterError.INVALID_CONFIGURATION, 0, str));
            HashMap<String, String> mapHashMap = CollectionUtils.hashMap("ad_unit_id", strB);
            CollectionUtils.putStringIfValid("name", label2, mapHashMap);
            CollectionUtils.putStringIfValid("details", label, mapHashMap);
            this.f424a.E().a(c2.E0, "incompatible_ad_format", mapHashMap);
        } catch (Throwable th) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Unable to process mediated ad response for ad unit " + this.g.b(), th);
            }
            throw new RuntimeException("Unable to process ad: " + th);
        }
    }

    private void c(JSONObject jSONObject) {
        JSONObject andResetCustomPostBodyData = this.f424a.X().getAndResetCustomPostBodyData();
        if (andResetCustomPostBodyData == null || !k7.h(com.applovin.impl.sdk.k.o())) {
            return;
        }
        JsonUtils.putAll(jSONObject, andResetCustomPostBodyData);
    }

    private void d(JSONObject jSONObject) {
        if (((Boolean) this.f424a.a(v4.C4)).booleanValue()) {
            r3 r3VarY = this.f424a.Y();
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            p3 p3Var = p3.f;
            JsonUtils.putAll(jSONObject3, (Map<String, ?>) r3VarY.a(p3Var, q3.a.AD_UNIT_ID));
            JsonUtils.putJSONObject(jSONObject2, "arpau", jSONObject3);
            JSONObject jSONObject4 = new JSONObject();
            JsonUtils.putAll(jSONObject4, (Map<String, ?>) r3VarY.a(p3Var, q3.a.AD_FORMAT));
            JsonUtils.putJSONObject(jSONObject2, "arpaf", jSONObject4);
            JSONObject jSONObject5 = new JSONObject();
            JsonUtils.putAll(jSONObject5, (Map<String, ?>) r3VarY.a(p3.g, q3.a.AD));
            JsonUtils.putJSONObject(jSONObject2, "ttdasipa_ms", jSONObject5);
            JsonUtils.putJSONObject(jSONObject, "mediation_stats", jSONObject2);
        }
    }

    private String e() {
        return i3.a(this.f424a);
    }

    private String f() {
        return i3.b(this.f424a);
    }

    private JSONObject g() throws JSONException {
        Map mapA = this.f424a.B().a((Map) null, false, true);
        mapA.putAll(this.g.c());
        JSONObject jSONObject = new JSONObject(mapA);
        e(jSONObject);
        h(jSONObject);
        f(jSONObject);
        c(jSONObject);
        g(jSONObject);
        d(jSONObject);
        return jSONObject;
    }

    private Map h() {
        HashMap map = new HashMap(4);
        map.put("AppLovin-Ad-Unit-Id", this.g.b());
        map.put("AppLovin-Ad-Format", this.g.a().getLabel());
        Map mapD = this.g.d();
        CollectionUtils.putObjectToStringIfValid("AppLovin-Retry-Attempt", mapD.get("retry_attempt"), map);
        CollectionUtils.putObjectToStringIfValid("AppLovin-Retry-Delay-Sec", mapD.get("retry_delay_sec"), map);
        return map;
    }

    @Override // java.lang.Runnable
    public void run() {
        MaxAdFormat maxAdFormatA = this.g.a();
        String strB = this.g.b();
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Fetching next ad for " + maxAdFormatA.getLabel() + " ad unit " + strB);
        }
        j2.a();
        if (((Boolean) this.f424a.a(v4.Q3)).booleanValue() && k7.j() && com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "User is connected to a VPN");
        }
        this.f424a.P().a(c2.T, maxAdFormatA, strB, (MaxError) null);
        if (((Boolean) this.f424a.a(v4.C4)).booleanValue()) {
            r3 r3VarY = this.f424a.Y();
            p3 p3Var = p3.f;
            r3VarY.a(p3Var, q3.a(strB));
            r3VarY.a(p3Var, q3.a(maxAdFormatA));
        }
        k7.a(this.f424a, this.b);
        try {
            JSONObject jSONObjectG = g();
            HashMap map = new HashMap();
            if (!((Boolean) this.f424a.a(v4.q5)).booleanValue() && !((Boolean) this.f424a.a(v4.o5)).booleanValue()) {
                map.put(com.safedk.android.analytics.brandsafety.l.x, UUID.randomUUID().toString());
            }
            if (!((Boolean) this.f424a.a(v4.a5)).booleanValue()) {
                map.put("sdk_key", this.f424a.j0());
            }
            if (this.f424a.t0().c()) {
                map.put("test_mode", "1");
            }
            List listB = this.f424a.t0().b();
            String str = this.f424a.o0().getExtraParameters().get("fan");
            if (listB != null && !listB.isEmpty()) {
                String strM = UByte$$ExternalSyntheticBackport0.m(StringUtils.COMMA, listB);
                map.put("filter_ad_network", strM);
                if (!this.f424a.t0().c()) {
                    map.put("fhkZsVqYC7", "1");
                }
                if (this.f424a.t0().d()) {
                    map.put("force_ad_network", strM);
                }
            } else if (com.applovin.impl.sdk.utils.StringUtils.isValidString(str)) {
                map.put("filter_ad_network", str);
            }
            a aVar = new a(com.applovin.impl.sdk.network.a.a(this.f424a).c("POST").a(h()).b(f()).a(e()).b(map).a(jSONObjectG).b(((Boolean) this.f424a.a(o3.o8)).booleanValue()).a((Object) new JSONObject()).c(((Long) this.f424a.a(o3.j7)).intValue()).a(((Integer) this.f424a.a(v4.U2)).intValue()).b(((Long) this.f424a.a(o3.i7)).intValue()).a(s4.a.a(((Integer) this.f424a.a(v4.g5)).intValue())).f(true).a(), this.f424a, strB, maxAdFormatA);
            aVar.c(o3.g7);
            aVar.b(o3.h7);
            this.f424a.r0().a(aVar);
        } catch (Throwable th) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Unable to fetch ad for Ad Unit ID: " + strB, th);
            }
            a("", 0, th.getMessage());
        }
    }

    class a extends j6 {
        final /* synthetic */ String m;
        final /* synthetic */ MaxAdFormat n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(com.applovin.impl.sdk.network.a aVar, com.applovin.impl.sdk.k kVar, String str, MaxAdFormat maxAdFormat) {
            super(aVar, kVar);
            this.m = str;
            this.n = maxAdFormat;
        }

        @Override // com.applovin.impl.j6, com.applovin.impl.q0.e
        public void a(String str, JSONObject jSONObject, int i) {
            if (i != 200) {
                t5.this.a(str, i, null);
                return;
            }
            JsonUtils.putLong(jSONObject, "ad_fetch_latency_millis", this.l.a());
            JsonUtils.putLong(jSONObject, "ad_fetch_response_size", this.l.b());
            HashMap map = new HashMap(6);
            CollectionUtils.putStringIfValid("url", com.applovin.impl.sdk.utils.StringUtils.getHost(str), map);
            CollectionUtils.putStringIfValid("code", String.valueOf(i), map);
            CollectionUtils.putStringIfValid("ad_unit_id", this.m, map);
            CollectionUtils.putStringIfValid("ad_format", this.n.getLabel(), map);
            CollectionUtils.putStringIfValid("latency_ms", String.valueOf(this.l.a()), map);
            CollectionUtils.putStringIfValid("response_size", String.valueOf(this.l.b()), map);
            this.f424a.P().d(c2.U, map);
            t5.this.b(jSONObject);
        }

        @Override // com.applovin.impl.j6, com.applovin.impl.q0.e
        public void a(String str, int i, String str2, JSONObject jSONObject) {
            t5.this.a(str, i, str2);
            this.f424a.E().a("fetchMediatedAd", str, i, str2);
        }
    }

    private void e(JSONObject jSONObject) throws JSONException {
        String strB = this.g.b();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("ad_unit_id", strB);
        jSONObject2.put("ad_format", this.g.a().getLabel());
        Map map = CollectionUtils.map(this.g.d());
        com.applovin.impl.sdk.p pVarA0 = this.f424a.a0();
        CollectionUtils.putStringIfValid("previous_request_id", pVarA0.b(strB), map);
        CollectionUtils.putStringIfValid("previous_loaded_request_id", pVarA0.a(strB), map);
        com.applovin.impl.sdk.p.a aVarC = pVarA0.c(strB);
        if (aVarC != null) {
            if (Boolean.parseBoolean(this.f424a.o0().getExtraParameters().get("esc"))) {
                map.put("previous_winning_network", "APPLOVIN_NETWORK");
                map.put("previous_winning_network_name", "AppLovin");
            } else {
                map.put("previous_winning_network", aVarC.a());
                map.put("previous_winning_network_name", aVarC.c());
            }
            if (this.f424a.R() != null) {
                Queue<v2> queueC = this.f424a.R().c(strB);
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (v2 v2Var : queueC) {
                    arrayList.add(v2Var.c());
                    arrayList2.add(v2Var.getNetworkName());
                }
                CollectionUtils.putStringIfValid("queued_ad_networks", UByte$$ExternalSyntheticBackport0.m(StringUtils.COMMA, arrayList), map);
                CollectionUtils.putStringIfValid("queued_ad_network_names", UByte$$ExternalSyntheticBackport0.m(StringUtils.COMMA, arrayList2), map);
            }
        }
        jSONObject2.put("extra_parameters", CollectionUtils.toJson(map));
        jSONObject.put("ad_info", jSONObject2);
    }

    private void f(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("disabled", new JSONArray(this.f424a.T().a()));
            jSONObject2.put("installed", t3.b(this.f424a));
            jSONObject2.put("initialized", this.f424a.S().b());
            jSONObject2.put("initialized_classnames", new JSONArray((Collection) this.f424a.S().a()));
            jSONObject2.put("loaded_classnames", new JSONArray(this.f424a.T().c()));
            jSONObject2.put("failed_classnames", new JSONArray(this.f424a.T().b()));
            jSONObject.put("adapters_info", jSONObject2);
        } catch (Exception e) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Failed to populate adapter classNames", e);
            }
            throw new RuntimeException("Failed to populate classNames: " + e);
        }
    }

    private void a(JSONObject jSONObject) {
        d6 d6Var = new d6(this.g, jSONObject, this.i, this.f424a, this.j);
        long j = JsonUtils.getLong(jSONObject, "process_waterfall_delay_ms", -1L);
        if (j > 0) {
            this.f424a.r0().a(d6Var, b6.b.MEDIATION, j, true);
        } else {
            this.f424a.r0().a(d6Var);
        }
    }

    private void h(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray = this.h;
        if (jSONArray != null) {
            jSONObject.put("signal_data", jSONArray);
        }
    }

    private void g(JSONObject jSONObject) {
        JsonUtils.putObject(jSONObject, "sdk_extra_parameters", new JSONObject(this.f424a.o0().getExtraParameters()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, String str2) {
        MaxErrorImpl maxErrorImpl;
        String strB = this.g.b();
        if (com.applovin.impl.sdk.o.a()) {
            this.c.b(this.b, "Unable to fetch ad for ad unit " + strB + ": server returned " + i);
        }
        if (i == -1009) {
            maxErrorImpl = new MaxErrorImpl(-1009, str2);
        } else if (i == -1001) {
            maxErrorImpl = new MaxErrorImpl(-1001, str2);
        } else if (com.applovin.impl.sdk.utils.StringUtils.isValidString(str2)) {
            maxErrorImpl = new MaxErrorImpl(-1000, str2);
        } else {
            maxErrorImpl = new MaxErrorImpl(-1);
        }
        HashMap map = new HashMap(5);
        CollectionUtils.putStringIfValid("url", com.applovin.impl.sdk.utils.StringUtils.getHost(str), map);
        CollectionUtils.putStringIfValid("code", String.valueOf(i), map);
        CollectionUtils.putStringIfValid("error_message", str2, map);
        CollectionUtils.putStringIfValid("ad_unit_id", strB, map);
        CollectionUtils.putStringIfValid("ad_format", this.g.a().getLabel(), map);
        this.f424a.P().d(c2.V, map);
        q2.a(this.j, strB, maxErrorImpl);
    }
}
