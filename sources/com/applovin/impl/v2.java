package com.applovin.impl;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.arch.core.util.Function;
import com.applovin.impl.sdk.utils.BundleUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdWaterfallInfo;
import com.applovin.mediation.nativeAds.MaxNativeAd;
import com.applovin.sdk.AppLovinSdkUtils;
import com.safedk.android.analytics.events.BrandSafetyEvent;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import net.pubnative.lite.sdk.analytics.Reporting;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public abstract class v2 extends h3 implements MaxAd {
    private final AtomicBoolean k;
    private final AtomicBoolean l;
    private final x2 m;
    protected com.applovin.impl.mediation.h n;
    private final String o;
    private MaxAdWaterfallInfo p;
    private long q;
    private String r;
    private String s;
    private Bundle t;

    protected v2(x2 x2Var, JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.mediation.h hVar, com.applovin.impl.sdk.k kVar) {
        super(x2Var.e(), jSONObject, jSONObject2, kVar);
        this.k = new AtomicBoolean();
        this.l = new AtomicBoolean();
        this.m = x2Var;
        this.n = hVar;
        this.o = hVar != null ? hVar.b() : null;
    }

    private long I() {
        return a("load_started_time_ms", 0L);
    }

    public static v2 a(x2 x2Var, JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.sdk.k kVar) {
        String string = JsonUtils.getString(jSONObject2, "ad_format", null);
        MaxAdFormat fromString = MaxAdFormat.formatFromString(string);
        Objects.requireNonNull(fromString, "Invalid ad format for string: " + string);
        if (fromString.isAdViewAd()) {
            return new y2(x2Var, jSONObject, jSONObject2, kVar);
        }
        if (fromString == MaxAdFormat.NATIVE) {
            return new a3(x2Var, jSONObject, jSONObject2, kVar);
        }
        if (fromString.isFullscreenAd()) {
            return new z2(x2Var, jSONObject, jSONObject2, kVar);
        }
        throw new IllegalArgumentException("Unsupported ad format: " + string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ JSONObject b(f5 f5Var) {
        return JsonUtils.deepCopy(f5Var.a("ad_values", new JSONObject()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Bundle c(f5 f5Var) {
        JSONObject jSONObjectA;
        if (f5Var.a("credentials")) {
            jSONObjectA = f5Var.a("credentials", new JSONObject());
        } else {
            jSONObjectA = f5Var.a("server_parameters", new JSONObject());
            JsonUtils.putString(jSONObjectA, Reporting.Key.PLACEMENT_ID, Q());
        }
        return JsonUtils.toBundle(jSONObjectA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ JSONObject d(f5 f5Var) {
        return JsonUtils.deepCopy(f5Var.a("publisher_extra_info", new JSONObject()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double e(f5 f5Var) {
        return Double.valueOf(JsonUtils.getDouble(f5Var.a("revenue_parameters", (JSONObject) null), "revenue", -1.0d));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ JSONObject f(f5 f5Var) {
        return JsonUtils.deepCopy(f5Var.a("revenue_parameters", new JSONObject()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String g(f5 f5Var) {
        return JsonUtils.getString(f5Var.a("revenue_parameters", (JSONObject) null), "precision", "");
    }

    public com.applovin.impl.mediation.h A() {
        return this.n;
    }

    public Bundle B() {
        return this.t;
    }

    public String C() {
        return a("bcode", "");
    }

    public long D() {
        return a("bid_expiration_ms", BundleUtils.getLong("bid_expiration_ms", -1L, l()));
    }

    public String E() {
        return a("bid_response", (String) null);
    }

    public Bundle F() {
        JSONObject jSONObjectA;
        f5 f5Var = this.h;
        if (f5Var != null) {
            return (Bundle) f5Var.a(new Function() { // from class: com.applovin.impl.v2$$ExternalSyntheticLambda3
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return this.f$0.c((f5) obj);
                }
            });
        }
        if (c("credentials")) {
            jSONObjectA = a("credentials", new JSONObject());
        } else {
            jSONObjectA = a("server_parameters", new JSONObject());
            JsonUtils.putString(jSONObjectA, Reporting.Key.PLACEMENT_ID, Q());
        }
        return JsonUtils.toBundle(jSONObjectA);
    }

    public long G() {
        if (I() > 0) {
            return H() - I();
        }
        return -1L;
    }

    public long H() {
        return a("load_completed_time_ms", 0L);
    }

    public String J() {
        return this.r;
    }

    public int K() {
        return a("mspc", ((Integer) this.f436a.a(o3.W7)).intValue());
    }

    public JSONObject L() {
        f5 f5Var = this.h;
        return f5Var != null ? (JSONObject) f5Var.a(new Function() { // from class: com.applovin.impl.v2$$ExternalSyntheticLambda5
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return v2.d((f5) obj);
            }
        }) : a("publisher_extra_info", new JSONObject());
    }

    public x2 M() {
        return this.m;
    }

    public String N() {
        return JsonUtils.getString(O(), "revenue_event", "");
    }

    public JSONObject O() {
        f5 f5Var = this.h;
        return f5Var != null ? (JSONObject) f5Var.a(new Function() { // from class: com.applovin.impl.v2$$ExternalSyntheticLambda0
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return v2.f((f5) obj);
            }
        }) : a("revenue_parameters", new JSONObject());
    }

    public String P() {
        return b("event_id", "");
    }

    public String Q() {
        return a(BrandSafetyEvent.k, (String) null);
    }

    public List R() {
        return b("mwf_info_urls");
    }

    public String S() {
        return b("waterfall_name", "");
    }

    public String T() {
        return b("waterfall_test_name", "");
    }

    public boolean U() {
        return StringUtils.isValidString(E());
    }

    public boolean V() {
        com.applovin.impl.mediation.h hVar = this.n;
        return hVar != null && hVar.k() && this.n.j();
    }

    public boolean W() {
        return a("only_load_when_initialized", Boolean.FALSE).booleanValue();
    }

    public boolean X() {
        return a("prefer_load_when_initialized", Boolean.TRUE).booleanValue();
    }

    public void Y() {
        c("load_completed_time_ms", SystemClock.elapsedRealtime());
    }

    public void Z() {
        c("load_started_time_ms", SystemClock.elapsedRealtime());
    }

    public abstract v2 a(com.applovin.impl.mediation.h hVar);

    public Boolean a0() {
        return a("destroy_on_ui_thread", (Boolean) null);
    }

    public Boolean b0() {
        return a("load_on_ui_thread", (Boolean) null);
    }

    public Boolean c0() {
        return a("show_on_ui_thread", (Boolean) null);
    }

    @Override // com.applovin.mediation.MaxAd
    public String getAdReviewCreativeId() {
        return this.s;
    }

    @Override // com.applovin.mediation.MaxAd
    public String getAdValue(String str) {
        return getAdValue(str, null);
    }

    @Override // com.applovin.mediation.MaxAd
    public String getCreativeId() {
        return a("creative_id", (String) null);
    }

    @Override // com.applovin.mediation.MaxAd
    public String getDspId() {
        return a("dsp_id", (String) null);
    }

    @Override // com.applovin.mediation.MaxAd
    public String getDspName() {
        return a("dsp_name", (String) null);
    }

    @Override // com.applovin.mediation.MaxAd
    public MaxAdFormat getFormat() {
        return MaxAdFormat.formatFromString(a("ad_format", b("ad_format", (String) null)));
    }

    @Override // com.applovin.mediation.MaxAd
    public MaxNativeAd getNativeAd() {
        com.applovin.impl.mediation.h hVar = this.n;
        if (hVar != null) {
            return hVar.e();
        }
        return null;
    }

    @Override // com.applovin.mediation.MaxAd
    public String getNetworkName() {
        return a(BrandSafetyEvent.ad, "");
    }

    @Override // com.applovin.mediation.MaxAd
    public String getNetworkPlacement() {
        return StringUtils.emptyIfNull(Q());
    }

    @Override // com.applovin.mediation.MaxAd
    public long getRequestLatencyMillis() {
        return this.q;
    }

    @Override // com.applovin.mediation.MaxAd
    public double getRevenue() {
        if (!((Boolean) this.f436a.a(o3.b8)).booleanValue() || !getFormat().isFullscreenAd() || u().get()) {
            f5 f5Var = this.h;
            return f5Var != null ? ((Double) f5Var.a(new Function() { // from class: com.applovin.impl.v2$$ExternalSyntheticLambda1
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return v2.e((f5) obj);
                }
            })).doubleValue() : JsonUtils.getDouble(a("revenue_parameters", (JSONObject) null), "revenue", -1.0d);
        }
        this.f436a.O();
        if (!com.applovin.impl.sdk.o.a()) {
            return 0.0d;
        }
        this.f436a.O().b("MediatedAd", "Attempting to retrieve revenue when not available yet");
        return 0.0d;
    }

    @Override // com.applovin.mediation.MaxAd
    public String getRevenuePrecision() {
        f5 f5Var = this.h;
        return f5Var != null ? (String) f5Var.a(new Function() { // from class: com.applovin.impl.v2$$ExternalSyntheticLambda4
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return v2.g((f5) obj);
            }
        }) : JsonUtils.getString(a("revenue_parameters", (JSONObject) null), "precision", "");
    }

    @Override // com.applovin.mediation.MaxAd
    public AppLovinSdkUtils.Size getSize() {
        int iA = a("ad_width", -3);
        int iA2 = a("ad_height", -3);
        return (iA == -3 || iA2 == -3) ? getFormat().getSize() : new AppLovinSdkUtils.Size(iA, iA2);
    }

    @Override // com.applovin.mediation.MaxAd
    public MaxAdWaterfallInfo getWaterfall() {
        return this.p;
    }

    public void h(String str) {
        this.s = str;
    }

    public void i(String str) {
        this.r = str;
    }

    public void t() {
        this.n = null;
        this.p = null;
    }

    @Override // com.applovin.impl.h3
    public String toString() {
        return "MediatedAd{thirdPartyAdPlacementId=" + Q() + ", adUnitId=" + getAdUnitId() + ", format=" + getFormat().getLabel() + ", networkName='" + getNetworkName() + "'}";
    }

    public AtomicBoolean u() {
        return this.k;
    }

    public String v() {
        return a("adomain", (String) null);
    }

    public AtomicBoolean w() {
        return this.l;
    }

    public JSONObject x() {
        f5 f5Var = this.h;
        return f5Var != null ? (JSONObject) f5Var.a(new Function() { // from class: com.applovin.impl.v2$$ExternalSyntheticLambda2
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return v2.b((f5) obj);
            }
        }) : a("ad_values", new JSONObject());
    }

    public View y() {
        com.applovin.impl.mediation.h hVar;
        if (!V() || (hVar = this.n) == null) {
            return null;
        }
        return hVar.d();
    }

    public String z() {
        return this.o;
    }

    @Override // com.applovin.mediation.MaxAd
    public String getAdValue(String str, String str2) {
        JSONObject jSONObjectX = x();
        if (jSONObjectX.has(str)) {
            return JsonUtils.getString(jSONObjectX, str, str2);
        }
        Bundle bundleL = l();
        if (bundleL.containsKey(str)) {
            return bundleL.getString(str);
        }
        JSONObject jSONObjectL = L();
        return jSONObjectL.has(str) ? JsonUtils.getString(jSONObjectL, str, str2) : a(str, str2);
    }

    public void a(MaxAdWaterfallInfo maxAdWaterfallInfo) {
        this.p = maxAdWaterfallInfo;
    }

    public void a(long j) {
        this.q = j;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        JSONObject jSONObjectL = L();
        JsonUtils.putAll(jSONObjectL, jSONObject);
        a("publisher_extra_info", (Object) jSONObjectL);
    }

    public void a(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        if (bundle.containsKey("creative_id") && !c("creative_id")) {
            c("creative_id", BundleUtils.getString("creative_id", bundle));
        }
        if (bundle.containsKey("ad_width") && !c("ad_width") && bundle.containsKey("ad_height") && !c("ad_height")) {
            int i = BundleUtils.getInt("ad_width", bundle);
            int i2 = BundleUtils.getInt("ad_height", bundle);
            c("ad_width", i);
            c("ad_height", i2);
        }
        if (bundle.containsKey("publisher_extra_info")) {
            a(BundleUtils.toJSONObject(bundle.getBundle("publisher_extra_info")));
        }
        if (bundle.containsKey("array_parameters")) {
            this.t = bundle.getBundle("array_parameters");
        }
    }
}
