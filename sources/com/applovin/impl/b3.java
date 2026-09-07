package com.applovin.impl;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.core.internal.view.SupportMenu;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.adapter.MaxAdViewAdapter;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapter.MaxAppOpenAdapter;
import com.applovin.mediation.adapter.MaxInterstitialAdapter;
import com.applovin.mediation.adapter.MaxNativeAdAdapter;
import com.applovin.mediation.adapter.MaxRewardedAdapter;
import com.applovin.mediation.adapter.listeners.MaxNativeAdAdapterListener;
import com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters;
import com.safedk.android.analytics.events.BrandSafetyEvent;
import com.smaato.sdk.core.dns.DnsName;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class b3 implements Comparable, AppLovinCommunicatorSubscriber {
    private final List A;
    private final List B;
    private final List C;
    private final List D;
    private final Map E;
    private final boolean F;
    private final boolean G;
    private final x6 H;
    private final boolean I;
    private final String J;
    private final Map K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.k f358a;
    private final a b;
    private int c;
    private final boolean d;
    private final boolean e;
    private final boolean f;
    private final boolean g;
    private boolean h;
    private final boolean i;
    private final boolean j;
    private final boolean k;
    private final boolean l;
    private final boolean m;
    private final boolean n;
    private final boolean o;
    private final String p;
    private final String q;
    private String r;
    private String s;
    private final String t;
    private final String u;
    private final String v;
    private final String w;
    private final int x;
    private final List y;
    private final List z;

    public enum a {
        MISSING("MISSING"),
        INCOMPLETE_INTEGRATION("INCOMPLETE INTEGRATION"),
        INVALID_INTEGRATION("INVALID INTEGRATION"),
        COMPLETE("COMPLETE");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f359a;

        a(String str) {
            this.f359a = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String b() {
            return this.f359a;
        }
    }

    public enum b {
        NOT_SUPPORTED("Not Supported", SupportMenu.CATEGORY_MASK, "This network does not support test mode."),
        INVALID_INTEGRATION("Invalid Integration", SupportMenu.CATEGORY_MASK, "Please address all the integration issue(s) marked in red above."),
        NOT_INITIALIZED("Not Initialized", SupportMenu.CATEGORY_MASK, "Please configure this network in your MAX dashboard."),
        DISABLED("Enable", -16776961, "Please re-launch the app to enable test ads."),
        READY("", -16776961, "");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f360a;
        private final int b;
        private final String c;

        b(String str, int i2, String str2) {
            this.f360a = str;
            this.b = i2;
            this.c = str2;
        }

        public String b() {
            return this.c;
        }

        public String c() {
            return this.f360a;
        }

        public int d() {
            return this.b;
        }
    }

    /* JADX WARN: Code duplicated, block: B:66:0x0263 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:68:0x0267  */
    /* JADX WARN: Code duplicated, block: B:71:0x0279  */
    /* JADX WARN: Code duplicated, block: B:72:0x0285  */
    /* JADX WARN: Code duplicated, block: B:75:0x02c7  */
    /* JADX WARN: Code duplicated, block: B:78:0x02d6  */
    public b3(JSONObject jSONObject, com.applovin.impl.sdk.k kVar) {
        String adapterVersion;
        String strA;
        boolean zEquals;
        String string;
        boolean zIsBeta;
        boolean z;
        boolean z2;
        int iLastIndexOf;
        String lowerCase;
        Integer numA;
        JSONObject jSONObject2;
        String string2;
        boolean z3;
        this.f358a = kVar;
        String string3 = JsonUtils.getString(jSONObject, "name", "");
        this.p = string3;
        this.q = JsonUtils.getString(jSONObject, "display_name", "");
        this.r = JsonUtils.getString(jSONObject, "adapter_class", "");
        this.u = JsonUtils.getString(jSONObject, "latest_adapter_version", "");
        this.B = a(jSONObject);
        Boolean bool = Boolean.FALSE;
        this.k = JsonUtils.getBoolean(jSONObject, "hide_if_missing", bool).booleanValue();
        JSONObject jSONObject3 = JsonUtils.getJSONObject(jSONObject, com.safedk.android.utils.j.c, new JSONObject());
        this.z = a(jSONObject3, kVar);
        this.o = JsonUtils.getBoolean(jSONObject3, "java_8_required", bool).booleanValue();
        this.F = JsonUtils.getBoolean(jSONObject3, "has_micro_sdk", bool).booleanValue();
        this.G = JsonUtils.getBoolean(jSONObject3, "hide_initialization_status", bool).booleanValue();
        this.n = JsonUtils.getBoolean(jSONObject3, "check_sdk_adapter_version_mismatch", Boolean.TRUE).booleanValue();
        this.C = JsonUtils.getList(jSONObject3, "live_network_filtering_names", null);
        JSONObject jSONObject4 = JsonUtils.getJSONObject(jSONObject3, "test_mode", new JSONObject());
        JSONObject jSONObject5 = JsonUtils.getJSONObject(jSONObject4, "network_names", (JSONObject) null);
        if (jSONObject5 == null || jSONObject5.length() <= 0) {
            this.D = Arrays.asList(string3);
            this.E = null;
        } else {
            ArrayList arrayList = new ArrayList(Arrays.asList(string3));
            HashMap map = new HashMap(jSONObject5.length());
            Iterator<String> itKeys = jSONObject5.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                MaxAdFormat fromString = MaxAdFormat.formatFromString(next);
                String string4 = JsonUtils.getString(jSONObject5, next, null);
                if (fromString != null && !TextUtils.isEmpty(string4)) {
                    arrayList.add(string4);
                    map.put(fromString, string4);
                }
            }
            this.D = arrayList;
            this.E = map;
        }
        JSONObject jSONObject6 = JsonUtils.getJSONObject(jSONObject, "test_mode", new JSONObject());
        Boolean bool2 = Boolean.TRUE;
        this.i = JsonUtils.getBoolean(jSONObject6, "supported", bool2).booleanValue();
        this.j = JsonUtils.getBoolean(jSONObject, "test_mode_requires_init", Boolean.FALSE).booleanValue();
        this.v = JsonUtils.getString(jSONObject6, "message", null);
        this.H = new x6(JsonUtils.getJSONObject(jSONObject3, "tcf_config"), this.q);
        List list = JsonUtils.getList(jSONObject, "existence_classes", null);
        if (list != null) {
            this.d = k7.a(list);
        } else {
            this.d = k7.a(JsonUtils.getString(jSONObject, "existence_class", ""));
        }
        List listEmptyList = Collections.emptyList();
        String str = this.r;
        String string5 = JsonUtils.getString(jSONObject3, "init_adapter_class", null);
        if (string5 != null) {
            this.r = string5;
        }
        MaxAdapter maxAdapterA = t3.a(str, kVar);
        if (maxAdapterA != null) {
            this.e = true;
            try {
                adapterVersion = maxAdapterA.getAdapterVersion();
                try {
                    try {
                        strA = t3.a(maxAdapterA);
                        try {
                            this.h = t3.a(maxAdapterA, this.r);
                            listEmptyList = a(maxAdapterA, JsonUtils.getBoolean(jSONObject4, "is_mrec_supported", bool2).booleanValue());
                            JSONObject jSONObject7 = JsonUtils.getJSONObject(jSONObject3, "native_ad_view_config", (JSONObject) null);
                            if (jSONObject7 != null) {
                                String string6 = JsonUtils.getString(jSONObject7, "min_adapter_version", null);
                                z3 = string6 == null || k7.a(adapterVersion, string6) >= 0;
                                try {
                                    string = JsonUtils.getString(jSONObject7, BrandSafetyEvent.ad, null);
                                } catch (Throwable th) {
                                    th = th;
                                    string = null;
                                    com.applovin.impl.sdk.o.h("MediatedNetwork", "Failed to load adapter for network " + this.p + ". Please check that you have a compatible network SDK integrated. Error: " + th);
                                    z = z3;
                                    zIsBeta = false;
                                    Class<?> cls = Class.forName(this.r);
                                    zEquals = cls.getMethod("loadNativeAd", MaxAdapterResponseParameters.class, Activity.class, MaxNativeAdAdapterListener.class).getDeclaringClass().equals(cls);
                                    this.t = adapterVersion;
                                    this.s = strA;
                                    this.y = listEmptyList;
                                    this.l = zEquals;
                                    this.m = z;
                                    this.w = string;
                                    this.A = a(jSONObject3, adapterVersion, kVar);
                                    this.g = k7.a(JsonUtils.getString(JsonUtils.getJSONObject(jSONObject, "alternative_network", (JSONObject) null), "adapter_class", ""));
                                    this.b = a();
                                    if (adapterVersion.equals(this.u)) {
                                        z2 = false;
                                    } else {
                                        z2 = false;
                                    }
                                    this.f = z2;
                                    Context contextO = com.applovin.impl.sdk.k.o();
                                    iLastIndexOf = this.p.lastIndexOf("_");
                                    if (iLastIndexOf != -1) {
                                        lowerCase = this.p.toLowerCase().substring(0, iLastIndexOf);
                                    } else {
                                        lowerCase = this.p.toLowerCase();
                                    }
                                    this.x = contextO.getResources().getIdentifier("applovin_ic_mediation_" + lowerCase, "drawable", contextO.getPackageName());
                                    this.c = MaxAdapter.InitializationStatus.NOT_INITIALIZED.getCode();
                                    AppLovinCommunicator.getInstance(contextO).subscribe(this, "adapter_initialization_status");
                                    numA = kVar.S().a(this.r);
                                    if (numA != null) {
                                        this.c = numA.intValue();
                                    }
                                    jSONObject2 = JsonUtils.getJSONObject(jSONObject3, "amazon_marketplace", (JSONObject) null);
                                    if (jSONObject2 != null) {
                                    }
                                    this.I = false;
                                    this.J = null;
                                    this.K = null;
                                    return;
                                }
                            } else {
                                string = null;
                                z3 = false;
                            }
                            try {
                                z = z3;
                                zIsBeta = maxAdapterA.isBeta();
                            } catch (Throwable th2) {
                                th = th2;
                                com.applovin.impl.sdk.o.h("MediatedNetwork", "Failed to load adapter for network " + this.p + ". Please check that you have a compatible network SDK integrated. Error: " + th);
                                z = z3;
                                zIsBeta = false;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            string = null;
                            z3 = false;
                            com.applovin.impl.sdk.o.h("MediatedNetwork", "Failed to load adapter for network " + this.p + ". Please check that you have a compatible network SDK integrated. Error: " + th);
                            z = z3;
                            zIsBeta = false;
                            Class<?> cls2 = Class.forName(this.r);
                            zEquals = cls2.getMethod("loadNativeAd", MaxAdapterResponseParameters.class, Activity.class, MaxNativeAdAdapterListener.class).getDeclaringClass().equals(cls2);
                            this.t = adapterVersion;
                            this.s = strA;
                            this.y = listEmptyList;
                            this.l = zEquals;
                            this.m = z;
                            this.w = string;
                            this.A = a(jSONObject3, adapterVersion, kVar);
                            this.g = k7.a(JsonUtils.getString(JsonUtils.getJSONObject(jSONObject, "alternative_network", (JSONObject) null), "adapter_class", ""));
                            this.b = a();
                            if (adapterVersion.equals(this.u)) {
                                z2 = false;
                            } else {
                                z2 = false;
                            }
                            this.f = z2;
                            Context contextO2 = com.applovin.impl.sdk.k.o();
                            iLastIndexOf = this.p.lastIndexOf("_");
                            if (iLastIndexOf != -1) {
                                lowerCase = this.p.toLowerCase().substring(0, iLastIndexOf);
                            } else {
                                lowerCase = this.p.toLowerCase();
                            }
                            this.x = contextO2.getResources().getIdentifier("applovin_ic_mediation_" + lowerCase, "drawable", contextO2.getPackageName());
                            this.c = MaxAdapter.InitializationStatus.NOT_INITIALIZED.getCode();
                            AppLovinCommunicator.getInstance(contextO2).subscribe(this, "adapter_initialization_status");
                            numA = kVar.S().a(this.r);
                            if (numA != null) {
                                this.c = numA.intValue();
                            }
                            jSONObject2 = JsonUtils.getJSONObject(jSONObject3, "amazon_marketplace", (JSONObject) null);
                            if (jSONObject2 != null) {
                            }
                            this.I = false;
                            this.J = null;
                            this.K = null;
                            return;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        strA = "";
                    }
                    Class<?> cls3 = Class.forName(this.r);
                    zEquals = cls3.getMethod("loadNativeAd", MaxAdapterResponseParameters.class, Activity.class, MaxNativeAdAdapterListener.class).getDeclaringClass().equals(cls3);
                } catch (Throwable th5) {
                    kVar.O();
                    if (com.applovin.impl.sdk.o.a()) {
                        kVar.O().a("MediatedNetwork", "Failed to check if adapter overrides MaxNativeAdAdapter", th5);
                    }
                    zEquals = false;
                }
            } catch (Throwable th6) {
                th = th6;
                adapterVersion = "";
                strA = adapterVersion;
            }
        } else {
            this.e = false;
            adapterVersion = "";
            strA = adapterVersion;
            zEquals = false;
            string = null;
            zIsBeta = false;
            z = false;
        }
        this.t = adapterVersion;
        this.s = strA;
        this.y = listEmptyList;
        this.l = zEquals;
        this.m = z;
        this.w = string;
        this.A = a(jSONObject3, adapterVersion, kVar);
        this.g = k7.a(JsonUtils.getString(JsonUtils.getJSONObject(jSONObject, "alternative_network", (JSONObject) null), "adapter_class", ""));
        this.b = a();
        if (adapterVersion.equals(this.u) || zIsBeta) {
            z2 = false;
        } else {
            z2 = true;
        }
        this.f = z2;
        Context contextO3 = com.applovin.impl.sdk.k.o();
        iLastIndexOf = this.p.lastIndexOf("_");
        if (iLastIndexOf != -1) {
            lowerCase = this.p.toLowerCase().substring(0, iLastIndexOf);
        } else {
            lowerCase = this.p.toLowerCase();
        }
        this.x = contextO3.getResources().getIdentifier("applovin_ic_mediation_" + lowerCase, "drawable", contextO3.getPackageName());
        this.c = MaxAdapter.InitializationStatus.NOT_INITIALIZED.getCode();
        AppLovinCommunicator.getInstance(contextO3).subscribe(this, "adapter_initialization_status");
        numA = kVar.S().a(this.r);
        if (numA != null) {
            this.c = numA.intValue();
        }
        jSONObject2 = JsonUtils.getJSONObject(jSONObject3, "amazon_marketplace", (JSONObject) null);
        if (jSONObject2 != null || !this.d) {
            this.I = false;
            this.J = null;
            this.K = null;
            return;
        }
        this.I = true;
        this.J = JsonUtils.getString(jSONObject2, "test_mode_app_id", null);
        JSONObject jSONObject8 = JsonUtils.getJSONObject(jSONObject2, "test_mode_slot_ids", new JSONObject());
        HashMap map2 = new HashMap(jSONObject8.length());
        Iterator<String> itKeys2 = jSONObject8.keys();
        while (itKeys2.hasNext()) {
            String next2 = itKeys2.next();
            MaxAdFormat fromString2 = MaxAdFormat.formatFromString(next2);
            JSONObject jSONObject9 = JsonUtils.getJSONObject(jSONObject8, next2, (JSONObject) null);
            if (fromString2 != null && jSONObject9 != null && (string2 = JsonUtils.getString(jSONObject9, CommonUrlParts.UUID, null)) != null) {
                map2.put(fromString2, new x(string2, jSONObject9, fromString2));
            }
        }
        this.K = map2;
    }

    private a a() {
        a aVar;
        if (!this.d) {
            aVar = this.e ? a.INCOMPLETE_INTEGRATION : a.MISSING;
        } else if (this.e) {
            aVar = a.COMPLETE;
        } else {
            aVar = this.g ? a.MISSING : a.INCOMPLETE_INTEGRATION;
        }
        if (aVar == a.MISSING) {
            return aVar;
        }
        Iterator it = this.z.iterator();
        while (it.hasNext()) {
            if (!((m4) it.next()).c()) {
                return a.INVALID_INTEGRATION;
            }
        }
        Iterator it2 = this.A.iterator();
        while (it2.hasNext()) {
            if (!((j1) it2.next()).c()) {
                return a.INVALID_INTEGRATION;
            }
        }
        if (!this.o || com.applovin.impl.sdk.k.G0()) {
            return F() ? a.INCOMPLETE_INTEGRATION : aVar;
        }
        return a.INVALID_INTEGRATION;
    }

    public boolean A() {
        return this.e;
    }

    public boolean B() {
        return this.f;
    }

    public boolean C() {
        return this.h;
    }

    public boolean D() {
        return this.I;
    }

    public boolean E() {
        return this.o;
    }

    public boolean F() {
        if (!this.n || !StringUtils.isValidString(this.s)) {
            return false;
        }
        return !k7.d(this.s).equals(k7.a(this.t, this.s.split(DnsName.ESCAPED_DOT).length));
    }

    public boolean G() {
        return this.d;
    }

    public boolean H() {
        return this.b == a.MISSING && this.k;
    }

    public boolean I() {
        return this.G;
    }

    public boolean J() {
        return this.l;
    }

    public boolean K() {
        return this.m;
    }

    public String b() {
        return this.r;
    }

    public String c() {
        return this.t;
    }

    public Map d() {
        return this.K;
    }

    public String e() {
        return this.J;
    }

    public List f() {
        return this.A;
    }

    public String g() {
        return this.q;
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorEntity
    public String getCommunicatorId() {
        return "MediatedNetwork";
    }

    public int h() {
        return this.x;
    }

    public int i() {
        return this.c;
    }

    public final String j() {
        StringBuilder sb = new StringBuilder("\n---------- ");
        String str = "UNAVAILABLE";
        StringBuilder sbAppend = sb.append(this.p).append(" ----------\nStatus  - ").append(this.b.b()).append("\nSDK     - ").append((!this.d || TextUtils.isEmpty(this.s)) ? "UNAVAILABLE" : this.s).append("\nAdapter - ");
        if (this.e && !TextUtils.isEmpty(this.t)) {
            str = this.t;
        }
        sbAppend.append(str);
        for (m4 m4Var : n()) {
            if (!m4Var.c()) {
                sb.append("\n* MISSING ").append(m4Var.b()).append(": ").append(m4Var.a());
            }
        }
        for (j1 j1Var : f()) {
            if (!j1Var.c()) {
                sb.append("\n* MISSING ").append(j1Var.b()).append(": ").append(j1Var.a());
            }
        }
        return sb.toString();
    }

    public String k() {
        return this.u;
    }

    public List l() {
        return this.C;
    }

    public String m() {
        return this.p;
    }

    public List n() {
        return this.z;
    }

    public final com.applovin.impl.sdk.k o() {
        return this.f358a;
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorSubscriber
    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        String string = appLovinCommunicatorMessage.getMessageData().getString("adapter_class", "");
        if (this.r.equals(string)) {
            this.c = appLovinCommunicatorMessage.getMessageData().getInt("init_status", 0);
            MaxAdapter maxAdapterA = t3.a(string, this.f358a);
            if (maxAdapterA != null) {
                String strA = t3.a(maxAdapterA);
                if (this.s.equals(strA)) {
                    return;
                }
                this.s = strA;
                this.f358a.u().a(this.s, string);
            }
        }
    }

    public String p() {
        return this.s;
    }

    public a q() {
        return this.b;
    }

    public List r() {
        return this.y;
    }

    public List s() {
        return this.B;
    }

    public x6 t() {
        return this.H;
    }

    public String toString() {
        return "MediatedNetwork{name=" + this.p + ", displayName=" + this.q + ", sdkAvailable=" + this.d + ", sdkVersion=" + this.s + ", adapterAvailable=" + this.e + ", adapterVersion=" + this.t + "}";
    }

    public List u() {
        return this.D;
    }

    public String v() {
        return this.v;
    }

    public String w() {
        return this.w;
    }

    public Map x() {
        return this.E;
    }

    public b y() {
        if (!this.i) {
            return b.NOT_SUPPORTED;
        }
        a aVar = this.b;
        if (aVar != a.COMPLETE && (aVar != a.INCOMPLETE_INTEGRATION || !G() || !A())) {
            return b.INVALID_INTEGRATION;
        }
        if (this.f358a.t0().c()) {
            return (this.j && (this.c == MaxAdapter.InitializationStatus.INITIALIZED_FAILURE.getCode() || this.c == MaxAdapter.InitializationStatus.INITIALIZING.getCode())) ? b.NOT_INITIALIZED : b.READY;
        }
        return b.DISABLED;
    }

    public boolean z() {
        return this.F;
    }

    private List a(MaxAdapter maxAdapter, boolean z) {
        ArrayList arrayList = new ArrayList(5);
        if (maxAdapter instanceof MaxInterstitialAdapter) {
            arrayList.add(MaxAdFormat.INTERSTITIAL);
        }
        if (maxAdapter instanceof MaxAppOpenAdapter) {
            arrayList.add(MaxAdFormat.APP_OPEN);
        }
        if (maxAdapter instanceof MaxRewardedAdapter) {
            arrayList.add(MaxAdFormat.REWARDED);
        }
        if (maxAdapter instanceof MaxAdViewAdapter) {
            arrayList.add(MaxAdFormat.BANNER);
            arrayList.add(MaxAdFormat.LEADER);
            if (z) {
                arrayList.add(MaxAdFormat.MREC);
            }
        }
        if (maxAdapter instanceof MaxNativeAdAdapter) {
            arrayList.add(MaxAdFormat.NATIVE);
        }
        return arrayList;
    }

    private List a(JSONObject jSONObject, com.applovin.impl.sdk.k kVar) {
        ArrayList arrayList = new ArrayList();
        if (this.r.equals("com.applovin.mediation.adapters.AppLovinMediationAdapter")) {
            m4 m4Var = new m4("com.google.android.gms.permission.AD_ID", "Please add\n<uses-permission android:name=\"com.google.android.gms.permission.AD_ID\" />\nto your AndroidManifest.xml", com.applovin.impl.sdk.k.o());
            if (m4Var.c()) {
                arrayList.add(m4Var);
            }
        }
        JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "permissions", new JSONObject());
        Iterator<String> itKeys = jSONObject2.keys();
        while (itKeys.hasNext()) {
            try {
                String next = itKeys.next();
                arrayList.add(new m4(next, jSONObject2.getString(next), com.applovin.impl.sdk.k.o()));
            } catch (JSONException unused) {
            }
        }
        return arrayList;
    }

    private List a(JSONObject jSONObject) {
        return JsonUtils.optList(JsonUtils.getJSONArray(jSONObject, "supported_regions", null), null);
    }

    private List a(JSONObject jSONObject, String str, com.applovin.impl.sdk.k kVar) {
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "dependencies", new JSONArray());
        JSONArray jSONArray2 = JsonUtils.getJSONArray(jSONObject, "dependencies_v2", new JSONArray());
        ArrayList arrayList = new ArrayList(jSONArray.length() + jSONArray2.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONArray, i, (JSONObject) null);
            if (jSONObject2 != null) {
                arrayList.add(new j1(jSONObject2, kVar));
            }
        }
        for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
            JSONObject jSONObject3 = JsonUtils.getJSONObject(jSONArray2, i2, (JSONObject) null);
            if (jSONObject3 != null && j1.a(str, JsonUtils.getString(jSONObject3, "min_adapter_version", null), JsonUtils.getString(jSONObject3, "max_adapter_version", null))) {
                arrayList.add(new j1(jSONObject3, kVar));
            }
        }
        return arrayList;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(b3 b3Var) {
        return this.q.compareToIgnoreCase(b3Var.q);
    }
}
