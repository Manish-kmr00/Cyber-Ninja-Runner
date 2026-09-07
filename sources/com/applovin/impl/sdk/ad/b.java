package com.applovin.impl.sdk.ad;

import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import androidx.arch.core.util.Function;
import androidx.core.app.NotificationCompat;
import androidx.core.util.Consumer;
import com.applovin.impl.a8;
import com.applovin.impl.adview.m;
import com.applovin.impl.c4;
import com.applovin.impl.f1;
import com.applovin.impl.f5;
import com.applovin.impl.k7;
import com.applovin.impl.k8;
import com.applovin.impl.l4;
import com.applovin.impl.n4;
import com.applovin.impl.o0;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.k;
import com.applovin.impl.sdk.o;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.v4;
import com.applovin.sdk.AppLovinSdkUtils;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.iab.omid.library.applovin.adsession.VerificationScriptResource;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public abstract class b extends AppLovinAdImpl implements n4 {
    private final List d;
    private final AtomicBoolean e;
    private final AtomicBoolean f;
    private final AtomicReference g;
    private final Bundle h;
    private String i;
    private long j;
    private int k;
    private String l;
    private d m;

    /* JADX INFO: renamed from: com.applovin.impl.sdk.ad.b$b, reason: collision with other inner class name */
    public enum EnumC0140b {
        UNSPECIFIED,
        DISMISS,
        DO_NOT_DISMISS
    }

    public enum c {
        DEFAULT,
        ACTIVITY_PORTRAIT,
        ACTIVITY_LANDSCAPE
    }

    public class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f638a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;

        private d() {
            this.f638a = AppLovinSdkUtils.dpToPx(k.o(), b.this.p());
            this.b = AppLovinSdkUtils.dpToPx(k.o(), b.this.r());
            this.c = AppLovinSdkUtils.dpToPx(k.o(), b.this.n());
            this.d = AppLovinSdkUtils.dpToPx(k.o(), ((Integer) ((AppLovinAdBase) b.this).sdk.a(v4.h1)).intValue());
            this.e = AppLovinSdkUtils.dpToPx(k.o(), ((Integer) ((AppLovinAdBase) b.this).sdk.a(v4.g1)).intValue());
        }
    }

    public enum e {
        RESIZE_ASPECT,
        TOP,
        BOTTOM,
        LEFT,
        RIGHT
    }

    public b(JSONObject jSONObject, JSONObject jSONObject2, k kVar) {
        super(jSONObject, jSONObject2, kVar);
        this.d = CollectionUtils.synchronizedList();
        this.e = new AtomicBoolean();
        this.f = new AtomicBoolean();
        this.g = new AtomicReference();
        this.h = new Bundle();
    }

    private List O() {
        return getIntegerListFromAdObject("multi_close_style", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List i(f5 f5Var) {
        return k7.a(f5Var.a("custom_tabs_tab_hidden_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Bundle k(f5 f5Var) {
        return JsonUtils.toBundle(f5Var.a(com.safedk.android.analytics.brandsafety.creatives.discoveries.c.f, (JSONObject) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Map m(f5 f5Var) {
        try {
            return JsonUtils.toStringMap(f5Var.a("http_headers_for_postbacks", new JSONObject()));
        } catch (JSONException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String o(f5 f5Var) {
        return JsonUtils.getString(f5Var.a("video_button_properties", (JSONObject) null), "video_button_html", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ a8 p(f5 f5Var) {
        return new a8(f5Var.a("video_button_properties", (JSONObject) null), this.sdk);
    }

    private String r0() {
        String stringFromAdObject = getStringFromAdObject("video_end_url", null);
        if (stringFromAdObject != null) {
            return stringFromAdObject.replace("{CLCODE}", getClCode());
        }
        return null;
    }

    public f1 A() {
        f5 f5Var = this.synchronizedAdObject;
        if (f5Var != null) {
            return (f1) f5Var.a(new Function() { // from class: com.applovin.impl.sdk.ad.b$$ExternalSyntheticLambda1
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return b.h((f5) obj);
                }
            });
        }
        JSONObject jsonObjectFromAdObject = getJsonObjectFromAdObject("custom_tabs_settings", null);
        if (jsonObjectFromAdObject != null) {
            return new f1(jsonObjectFromAdObject);
        }
        return null;
    }

    public void A0() {
        this.k++;
    }

    public List B() {
        List listA;
        f5 f5Var = this.synchronizedAdObject;
        if (f5Var != null) {
            return (List) f5Var.a(new Function() { // from class: com.applovin.impl.sdk.ad.b$$ExternalSyntheticLambda5
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return this.f$0.i((f5) obj);
                }
            });
        }
        synchronized (this.adObjectLock) {
            listA = k7.a(getJsonObjectFromAdObject("custom_tabs_tab_hidden_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
        }
        return listA;
    }

    public boolean B0() {
        return getBooleanFromAdObject("aocve", (Boolean) this.sdk.a(v4.i6));
    }

    public List C() {
        List listA;
        f5 f5Var = this.synchronizedAdObject;
        if (f5Var != null) {
            return (List) f5Var.a(new Function() { // from class: com.applovin.impl.sdk.ad.b$$ExternalSyntheticLambda0
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return this.f$0.j((f5) obj);
                }
            });
        }
        synchronized (this.adObjectLock) {
            listA = k7.a(getJsonObjectFromAdObject("custom_tabs_tab_shown_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
        }
        return listA;
    }

    public boolean C0() {
        return this.k > 0;
    }

    public List D() {
        return getStringListFromAdObject("custom_tabs_warmup_urls", Collections.emptyList());
    }

    public boolean D0() {
        return getBooleanFromAdObject("bvde", (Boolean) this.sdk.a(v4.V5));
    }

    public boolean E() {
        return getBooleanFromAdObject("dismiss_on_skip", Boolean.FALSE);
    }

    public boolean E0() {
        return getBooleanFromAdObject("lhs_close_button", (Boolean) this.sdk.a(v4.J1));
    }

    public String F() {
        return this.i;
    }

    public boolean F0() {
        return getBooleanFromAdObject("custom_tabs_client_warmup_enabled", Boolean.FALSE);
    }

    public int G() {
        return getIntFromAdObject("poststitial_dismiss_forward_delay_millis", -1);
    }

    public boolean G0() {
        return getBooleanFromAdObject("custom_tabs_enabled", Boolean.FALSE);
    }

    public int H() {
        return getIntFromAdObject("poststitial_shown_forward_delay_millis", -1);
    }

    public boolean H0() {
        return getBooleanFromAdObject("forward_lifecycle_events_to_webview", Boolean.FALSE);
    }

    public int I() {
        return k7.a(getIntFromAdObject("graphic_completion_percent", -1), 90);
    }

    public boolean I0() {
        return getBooleanFromAdObject("gase", Boolean.FALSE);
    }

    public long J() {
        return this.j;
    }

    public boolean J0() {
        return getBooleanFromAdObject("lock_current_orientation", Boolean.FALSE);
    }

    public List K() {
        List listA;
        f5 f5Var = this.synchronizedAdObject;
        if (f5Var != null) {
            return (List) f5Var.a(new Function() { // from class: com.applovin.impl.sdk.ad.b$$ExternalSyntheticLambda10
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return this.f$0.l((f5) obj);
                }
            });
        }
        synchronized (this.adObjectLock) {
            listA = k7.a(getJsonObjectFromAdObject("imp_urls", new JSONObject()), getClCode(), null, null, T(), a1(), this.sdk);
        }
        return listA;
    }

    public abstract boolean K0();

    public int L() {
        return getIntFromAdObject("mdafra", ((Integer) this.sdk.a(v4.S0)).intValue());
    }

    public AtomicBoolean L0() {
        return this.e;
    }

    public boolean M() {
        return getBooleanFromAdObject("playback_requires_user_action", Boolean.TRUE);
    }

    public boolean M0() {
        return getBooleanFromAdObject("lhs_skip_button", (Boolean) this.sdk.a(v4.W1));
    }

    public List N() {
        List listO = O();
        if (listO == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(listO.size());
        Iterator it = listO.iterator();
        while (it.hasNext()) {
            arrayList.add(a(((Integer) it.next()).intValue()));
        }
        return arrayList;
    }

    public boolean N0() {
        return getBooleanFromAdObject("video_clickable", Boolean.FALSE);
    }

    public abstract boolean O0();

    public List P() {
        return getIntegerListFromAdObject("multi_close_delay_graphic", null);
    }

    public boolean P0() {
        return getBooleanFromAdObject("web_contents_debugging_enabled", Boolean.valueOf(k7.j(k.o()) || k7.h(k.o()) || ((Boolean) this.sdk.a(v4.n6)).booleanValue()));
    }

    public Uri Q() {
        String stringFromAdObject = getStringFromAdObject("mute_image", "https://assets.applovin.com/sound_off.png");
        if (StringUtils.isValidString(stringFromAdObject)) {
            return Uri.parse(stringFromAdObject);
        }
        return null;
    }

    public abstract void Q0();

    public List R() {
        String stringFromAdObject = getStringFromAdObject("optional_html_resources", null);
        return stringFromAdObject != null ? CollectionUtils.explode(stringFromAdObject) : Collections.emptyList();
    }

    public boolean R0() {
        return getBooleanFromAdObject("aarwdc", (Boolean) this.sdk.a(v4.u2));
    }

    public abstract String S();

    public boolean S0() {
        return getBooleanFromAdObject("always_reward_user", (Boolean) this.sdk.a(v4.f1));
    }

    public Map T() {
        HashMap map = new HashMap();
        try {
            f5 f5Var = this.synchronizedAdObject;
            map.putAll(f5Var != null ? (Map) f5Var.a(new Function() { // from class: com.applovin.impl.sdk.ad.b$$ExternalSyntheticLambda13
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return b.m((f5) obj);
                }
            }) : JsonUtils.toStringMap(getJsonObjectFromAdObject("http_headers_for_postbacks", new JSONObject())));
        } catch (JSONException e2) {
            this.sdk.O();
            if (o.a()) {
                this.sdk.O().a("DirectAd", "Failed to retrieve http headers for postbacks", e2);
            }
        }
        if (getBooleanFromAdObject("use_webview_ua_for_postbacks", Boolean.FALSE)) {
            map.put("User-Agent", k8.a());
        }
        return map;
    }

    public boolean T0() {
        return getBooleanFromAdObject("should_apply_mute_setting_to_poststitial", Boolean.FALSE);
    }

    public EnumC0140b U() {
        String stringFromAdObject = getStringFromAdObject("poststitial_dismiss_type", null);
        if (StringUtils.isValidString(stringFromAdObject)) {
            if ("dismiss".equalsIgnoreCase(stringFromAdObject)) {
                return EnumC0140b.DISMISS;
            }
            if ("no_dismiss".equalsIgnoreCase(stringFromAdObject)) {
                return EnumC0140b.DO_NOT_DISMISS;
            }
        }
        return EnumC0140b.UNSPECIFIED;
    }

    public boolean U0() {
        return getBooleanFromAdObject("should_apply_web_view_settings_to_web_view_button", (Boolean) this.sdk.a(v4.r6));
    }

    public int V() {
        return getColorFromAdObject("postitial_progress_bar_color", -922746881);
    }

    public boolean V0() {
        f5 f5Var = this.synchronizedAdObject;
        return f5Var != null ? ((Boolean) f5Var.a(new Function() { // from class: com.applovin.impl.sdk.ad.b$$ExternalSyntheticLambda2
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return b.s((f5) obj);
            }
        })).booleanValue() : JsonUtils.getBoolean(getJsonObjectFromAdObject("video_button_properties", null), "should_cache_video_button_html_assets", Boolean.FALSE).booleanValue();
    }

    public long W() {
        return getLongFromAdObject("postitial_progress_bar_total_ms", -1L);
    }

    public boolean W0() {
        return this.f.get();
    }

    public List X() {
        return getStringListFromAdObject("pbpn", this.sdk.c(v4.C6));
    }

    public boolean X0() {
        return h1() || f1() || g1();
    }

    public long Y() {
        long longFromAdObject = getLongFromAdObject("report_reward_duration", -1L);
        if (longFromAdObject >= 0) {
            return TimeUnit.SECONDS.toMillis(longFromAdObject);
        }
        return -1L;
    }

    public boolean Y0() {
        return getBooleanFromAdObject("custom_tabs_should_track_events", Boolean.FALSE);
    }

    public int Z() {
        return getIntFromAdObject("report_reward_percent", -1);
    }

    public boolean Z0() {
        return getBooleanFromAdObject("serfaad", (Boolean) this.sdk.a(v4.R0));
    }

    public List a0() {
        String stringFromAdObject = getStringFromAdObject("required_html_resources", null);
        return stringFromAdObject != null ? CollectionUtils.explode(stringFromAdObject) : Collections.emptyList();
    }

    public boolean a1() {
        return getBooleanFromAdObject("fire_postbacks_from_webview", Boolean.FALSE);
    }

    public int b0() {
        return this.k;
    }

    public boolean b1() {
        return getBooleanFromAdObject("should_forward_close_button_tapped_to_poststitial", Boolean.FALSE);
    }

    public void c(final String str) {
        f5 f5Var = this.synchronizedAdObject;
        if (f5Var != null) {
            f5Var.a(new Consumer() { // from class: com.applovin.impl.sdk.ad.b$$ExternalSyntheticLambda15
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    b.a(str, (f5) obj);
                }
            });
            return;
        }
        synchronized (this.adObjectLock) {
            JsonUtils.putString(getJsonObjectFromAdObject("video_button_properties", null), "video_button_html", str);
        }
    }

    public List c0() {
        String stringFromAdObject = getStringFromAdObject("resource_cache_prefix", null);
        ArrayList arrayList = stringFromAdObject != null ? new ArrayList(CollectionUtils.explode(stringFromAdObject)) : new ArrayList(this.sdk.c(v4.F0));
        if (k7.j(k.o())) {
            arrayList.add("https://p.applov.in/");
        }
        return arrayList;
    }

    public boolean c1() {
        return getBooleanFromAdObject("fmsstwvoar", Boolean.FALSE);
    }

    public List d(MotionEvent motionEvent, boolean z, boolean z2) {
        List<String> stringListFromAdObject = getStringListFromAdObject("privacy_sandbox_click_attribution_urls", Collections.emptyList());
        if (stringListFromAdObject.isEmpty()) {
            return stringListFromAdObject;
        }
        Map mapA = a(motionEvent, z, z2);
        ArrayList arrayList = new ArrayList(stringListFromAdObject.size());
        Iterator<String> it = stringListFromAdObject.iterator();
        while (it.hasNext()) {
            arrayList.add(StringUtils.replace(it.next(), mapA));
        }
        return arrayList;
    }

    public List d0() {
        return getStringListFromAdObject("rea", a0());
    }

    public boolean d1() {
        return getBooleanFromAdObject("sftbpn", Boolean.FALSE);
    }

    public List e() {
        List listA;
        f5 f5Var = this.synchronizedAdObject;
        if (f5Var != null) {
            return (List) f5Var.a(new Function() { // from class: com.applovin.impl.sdk.ad.b$$ExternalSyntheticLambda3
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return this.f$0.a((f5) obj);
                }
            });
        }
        synchronized (this.adObjectLock) {
            listA = k7.a(getJsonObjectFromAdObject("ad_closed_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
        }
        return listA;
    }

    public com.applovin.impl.adview.e.a e0() {
        int intFromAdObject = getIntFromAdObject("skip_style", -1);
        return intFromAdObject == -1 ? q() : a(intFromAdObject);
    }

    public boolean e1() {
        return getBooleanFromAdObject("fvcetwv", Boolean.FALSE);
    }

    public long f() {
        return getLongFromAdObject("ad_dismiss_delay_on_app_launch_ms", TimeUnit.SECONDS.toMillis(3L));
    }

    public List f0() {
        return getStringListFromAdObject("substrings_for_disabled_click_logic", Collections.emptyList());
    }

    public boolean f1() {
        return getStringListFromAdObject("system_bars_hide_list", this.sdk.c(v4.t2)).contains(NotificationCompat.CATEGORY_NAVIGATION);
    }

    public long g() {
        return getLongFromAdObject("ad_reshow_delay_on_app_launch_ms", -1L);
    }

    public c g0() {
        c cVar = c.DEFAULT;
        String upperCase = getStringFromAdObject("ad_target", cVar.toString()).toUpperCase(Locale.ENGLISH);
        if ("ACTIVITY_PORTRAIT".equalsIgnoreCase(upperCase)) {
            return c.ACTIVITY_PORTRAIT;
        }
        return "ACTIVITY_LANDSCAPE".equalsIgnoreCase(upperCase) ? c.ACTIVITY_LANDSCAPE : cVar;
    }

    public boolean g1() {
        return getStringListFromAdObject("system_bars_hide_list", this.sdk.c(v4.t2)).contains("none");
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase, com.applovin.impl.b4
    public abstract c4 getAdEventTracker();

    public String getCachePrefix() {
        return getStringFromAdObject("cache_prefix", null);
    }

    @Override // com.applovin.impl.sdk.array.ArrayDirectDownloadAd
    public Bundle getDirectDownloadParameters() {
        f5 f5Var = this.synchronizedAdObject;
        return f5Var != null ? (Bundle) f5Var.a(new Function() { // from class: com.applovin.impl.sdk.ad.b$$ExternalSyntheticLambda17
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return b.k((f5) obj);
            }
        }) : JsonUtils.toBundle(getJsonObjectFromAdObject(com.safedk.android.analytics.brandsafety.creatives.discoveries.c.f, null));
    }

    @Override // com.applovin.impl.sdk.array.ArrayDirectDownloadAd
    public String getDirectDownloadToken() {
        return getStringFromAdObject("ah_dd_token", null);
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase, com.applovin.impl.b4
    public String getOpenMeasurementContentUrl() {
        return getStringFromAdObject("omid_content_url", null);
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase, com.applovin.impl.b4
    public String getOpenMeasurementCustomReferenceData() {
        return getStringFromAdObject("omid_custom_ref_data", "");
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase, com.applovin.impl.b4
    public List getOpenMeasurementVerificationScriptResources() {
        List list;
        final Function function = new Function() { // from class: com.applovin.impl.sdk.ad.b$$ExternalSyntheticLambda11
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return this.f$0.a((JSONArray) obj);
            }
        };
        f5 f5Var = this.synchronizedAdObject;
        if (f5Var != null) {
            return (List) f5Var.a(new Function() { // from class: com.applovin.impl.sdk.ad.b$$ExternalSyntheticLambda16
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return b.a(function, (f5) obj);
                }
            });
        }
        synchronized (this.adObjectLock) {
            list = (List) function.apply(getJsonArrayFromAdObject("omid_verification_script_resources", null));
        }
        return list;
    }

    public List getPrivacySandboxImpressionAttributionUrls() {
        List<String> stringListFromAdObject = getStringListFromAdObject("privacy_sandbox_impression_attribution_urls", Collections.emptyList());
        if (stringListFromAdObject.isEmpty()) {
            return stringListFromAdObject;
        }
        ArrayList arrayList = new ArrayList(stringListFromAdObject.size());
        String clCode = getClCode();
        Iterator<String> it = stringListFromAdObject.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().replace("{CLCODE}", clCode));
        }
        return arrayList;
    }

    public Bundle h() {
        return this.h;
    }

    public String h0() {
        return this.l;
    }

    public boolean h1() {
        return getStringListFromAdObject("system_bars_hide_list", this.sdk.c(v4.t2)).contains("status");
    }

    public Uri i0() {
        String stringFromAdObject = getStringFromAdObject("unmute_image", "https://assets.applovin.com/sound_on.png");
        if (StringUtils.isValidString(stringFromAdObject)) {
            return Uri.parse(stringFromAdObject);
        }
        return null;
    }

    public boolean i1() {
        return getBooleanFromAdObject("avoms", Boolean.FALSE);
    }

    @Override // com.applovin.impl.sdk.array.ArrayDirectDownloadAd
    public boolean isDirectDownloadEnabled() {
        return StringUtils.isValidString(getDirectDownloadToken());
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase, com.applovin.impl.b4
    public abstract boolean isOpenMeasurementEnabled();

    public List j() {
        List listA;
        f5 f5Var = this.synchronizedAdObject;
        if (f5Var != null) {
            return (List) f5Var.a(new Function() { // from class: com.applovin.impl.sdk.ad.b$$ExternalSyntheticLambda9
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return this.f$0.b((f5) obj);
                }
            });
        }
        synchronized (this.adObjectLock) {
            listA = k7.a(getJsonObjectFromAdObject("app_killed_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
        }
        return listA;
    }

    public String j0() {
        f5 f5Var = this.synchronizedAdObject;
        return f5Var != null ? (String) f5Var.a(new Function() { // from class: com.applovin.impl.sdk.ad.b$$ExternalSyntheticLambda18
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return b.n((f5) obj);
            }
        }) : JsonUtils.getString(getJsonObjectFromAdObject("video_button_properties", null), "video_button_base_url", RemoteSettings.FORWARD_SLASH_STRING);
    }

    public boolean j1() {
        return getBooleanFromAdObject("report_reward_percent_include_close_delay", Boolean.TRUE);
    }

    public String k0() {
        f5 f5Var = this.synchronizedAdObject;
        return f5Var != null ? (String) f5Var.a(new Function() { // from class: com.applovin.impl.sdk.ad.b$$ExternalSyntheticLambda21
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return b.o((f5) obj);
            }
        }) : JsonUtils.getString(getJsonObjectFromAdObject("video_button_properties", null), "video_button_html", "");
    }

    public boolean k1() {
        return getBooleanFromAdObject("require_interaction_for_click", Boolean.FALSE);
    }

    public List l() {
        return this.d;
    }

    public a8 l0() {
        f5 f5Var = this.synchronizedAdObject;
        return f5Var != null ? (a8) f5Var.a(new Function() { // from class: com.applovin.impl.sdk.ad.b$$ExternalSyntheticLambda14
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return this.f$0.p((f5) obj);
            }
        }) : new a8(getJsonObjectFromAdObject("video_button_properties", null), this.sdk);
    }

    public boolean l1() {
        return getBooleanFromAdObject("sruifwvc", Boolean.FALSE);
    }

    public abstract Uri m();

    public abstract Uri m0();

    public boolean m1() {
        return g() >= 0;
    }

    public int n() {
        return getIntFromAdObject("close_button_horizontal_margin", ((Integer) this.sdk.a(v4.K1)).intValue());
    }

    public long n0() {
        return getLongFromAdObject("close_delay", 0L);
    }

    public boolean n1() {
        return getBooleanFromAdObject("respect_adview_fully_watched", Boolean.FALSE);
    }

    public long o0() {
        return TimeUnit.SECONDS.toMillis(getLongFromAdObject("close_delay_max_buffering_time_seconds", 5L));
    }

    public boolean o1() {
        return getBooleanFromAdObject("sscomt", Boolean.FALSE);
    }

    public int p0() {
        return k7.c(getIntFromAdObject("video_completion_percent", -1));
    }

    public boolean p1() {
        return getBooleanFromAdObject("sudbia", (Boolean) this.sdk.a(v4.B6));
    }

    public com.applovin.impl.adview.e.a q() {
        List listO = O();
        int intFromAdObject = getIntFromAdObject("close_style", (listO == null || listO.size() <= 0) ? -1 : ((Integer) listO.get(0)).intValue());
        return intFromAdObject == -1 ? a(hasVideoUrl()) : a(intFromAdObject);
    }

    public List q0() {
        List listA;
        f5 f5Var = this.synchronizedAdObject;
        if (f5Var != null) {
            return (List) f5Var.a(new Function() { // from class: com.applovin.impl.sdk.ad.b$$ExternalSyntheticLambda20
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return this.f$0.q((f5) obj);
                }
            });
        }
        synchronized (this.adObjectLock) {
            listA = k7.a(getJsonObjectFromAdObject("video_end_urls", new JSONObject()), getClCode(), r0(), this.sdk);
        }
        return listA;
    }

    public boolean q1() {
        return getBooleanFromAdObject("upiosp", Boolean.FALSE);
    }

    public int r() {
        return getIntFromAdObject("close_button_top_margin", ((Integer) this.sdk.a(v4.M1)).intValue());
    }

    public long s() {
        List listP = P();
        long longFromAdObject = getLongFromAdObject("close_delay_graphic", (listP == null || listP.size() <= 0) ? 0L : ((Integer) listP.get(0)).intValue());
        if (longFromAdObject == -1 || longFromAdObject == -2) {
            return 0L;
        }
        return longFromAdObject;
    }

    public e s0() {
        String stringFromAdObject = getStringFromAdObject("video_gravity", null);
        if (ViewHierarchyConstants.DIMENSION_TOP_KEY.equals(stringFromAdObject)) {
            return e.TOP;
        }
        if ("bottom".equals(stringFromAdObject)) {
            return e.BOTTOM;
        }
        if ("left".equals(stringFromAdObject)) {
            return e.LEFT;
        }
        return "right".equals(stringFromAdObject) ? e.RIGHT : e.RESIZE_ASPECT;
    }

    public int t() {
        return getColorFromAdObject("countdown_color", -922746881);
    }

    public int t0() {
        return getColorFromAdObject("progress_bar_color", -922746881);
    }

    public int u() {
        return getIntFromAdObject("countdown_length", 0);
    }

    public boolean u0() {
        return getBooleanFromAdObject("progress_bar_enabled", Boolean.FALSE);
    }

    public Bundle v() {
        Map map;
        f5 f5Var = this.synchronizedAdObject;
        if (f5Var != null) {
            map = (Map) f5Var.a(new Function() { // from class: com.applovin.impl.sdk.ad.b$$ExternalSyntheticLambda23
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return this.f$0.c((f5) obj);
                }
            });
        } else {
            try {
                map = JsonUtils.toStringMap(getJsonObjectFromAdObject("custom_tabs_http_headers", new JSONObject()));
            } catch (JSONException e2) {
                this.sdk.O();
                if (o.a()) {
                    this.sdk.O().a("DirectAd", "Failed to retrieve http headers for Custom Tabs", e2);
                }
                map = new HashMap();
            }
        }
        Bundle bundle = new Bundle();
        for (Map.Entry entry : map.entrySet()) {
            bundle.putString((String) entry.getKey(), (String) entry.getValue());
        }
        if (getBooleanFromAdObject("custom_tabs_should_use_webview_ua", Boolean.FALSE)) {
            bundle.putString("User-Agent", k8.a());
        }
        return bundle;
    }

    public abstract Uri v0();

    public List w() {
        List listA;
        f5 f5Var = this.synchronizedAdObject;
        if (f5Var != null) {
            return (List) f5Var.a(new Function() { // from class: com.applovin.impl.sdk.ad.b$$ExternalSyntheticLambda7
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return this.f$0.d((f5) obj);
                }
            });
        }
        synchronized (this.adObjectLock) {
            listA = k7.a(getJsonObjectFromAdObject("custom_tabs_navigation_aborted_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
        }
        return listA;
    }

    public int w0() {
        int i;
        if (k7.a(getSize())) {
            i = 1;
        } else {
            i = ((Boolean) this.sdk.a(v4.O5)).booleanValue() ? 0 : -1;
        }
        return getIntFromAdObject("whalt", i);
    }

    public List x() {
        List listA;
        f5 f5Var = this.synchronizedAdObject;
        if (f5Var != null) {
            return (List) f5Var.a(new Function() { // from class: com.applovin.impl.sdk.ad.b$$ExternalSyntheticLambda6
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return this.f$0.e((f5) obj);
                }
            });
        }
        synchronized (this.adObjectLock) {
            listA = k7.a(getJsonObjectFromAdObject("custom_tabs_navigation_failed_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
        }
        return listA;
    }

    public m x0() {
        f5 f5Var = this.synchronizedAdObject;
        if (f5Var != null) {
            return (m) f5Var.a(new Function() { // from class: com.applovin.impl.sdk.ad.b$$ExternalSyntheticLambda4
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return b.r((f5) obj);
                }
            });
        }
        JSONObject jsonObjectFromAdObject = getJsonObjectFromAdObject("web_view_settings", null);
        if (jsonObjectFromAdObject != null) {
            return new m(jsonObjectFromAdObject);
        }
        return null;
    }

    public List y() {
        List listA;
        f5 f5Var = this.synchronizedAdObject;
        if (f5Var != null) {
            return (List) f5Var.a(new Function() { // from class: com.applovin.impl.sdk.ad.b$$ExternalSyntheticLambda8
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return this.f$0.f((f5) obj);
                }
            });
        }
        synchronized (this.adObjectLock) {
            listA = k7.a(getJsonObjectFromAdObject("custom_tabs_navigation_finished_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
        }
        return listA;
    }

    public List y0() {
        return CollectionUtils.explode(getStringFromAdObject("wlh", null));
    }

    public List z() {
        List listA;
        f5 f5Var = this.synchronizedAdObject;
        if (f5Var != null) {
            return (List) f5Var.a(new Function() { // from class: com.applovin.impl.sdk.ad.b$$ExternalSyntheticLambda22
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return this.f$0.g((f5) obj);
                }
            });
        }
        synchronized (this.adObjectLock) {
            listA = k7.a(getJsonObjectFromAdObject("custom_tabs_navigation_started_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
        }
        return listA;
    }

    public List z0() {
        return CollectionUtils.explode(getStringFromAdObject("wls", ""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List f(f5 f5Var) {
        return k7.a(f5Var.a("custom_tabs_navigation_finished_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List g(f5 f5Var) {
        return k7.a(f5Var.a("custom_tabs_navigation_started_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ f1 h(f5 f5Var) {
        JSONObject jSONObjectA = f5Var.a("custom_tabs_settings", (JSONObject) null);
        if (jSONObjectA != null) {
            return new f1(jSONObjectA);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List l(f5 f5Var) {
        return k7.a(f5Var.a("imp_urls", new JSONObject()), getClCode(), null, null, T(), a1(), this.sdk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String n(f5 f5Var) {
        return JsonUtils.getString(f5Var.a("video_button_properties", (JSONObject) null), "video_button_base_url", RemoteSettings.FORWARD_SLASH_STRING);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ m r(f5 f5Var) {
        JSONObject jSONObjectA = f5Var.a("web_view_settings", (JSONObject) null);
        if (jSONObjectA != null) {
            return new m(jSONObjectA);
        }
        return null;
    }

    public void a(String str) {
        this.i = str;
    }

    public void b(String str) {
        this.l = str;
    }

    public void a(long j) {
        this.j = j;
    }

    public void b(boolean z) {
        f5 f5Var = this.synchronizedAdObject;
        if (f5Var != null) {
            f5Var.a("html_resources_cached", z);
            return;
        }
        synchronized (this.adObjectLock) {
            JsonUtils.putBoolean(this.adObject, "html_resources_cached", z);
        }
    }

    public l4 i() {
        return (l4) this.g.getAndSet(null);
    }

    public String k() {
        String stringFromAdObject = getStringFromAdObject("base_url", RemoteSettings.FORWARD_SLASH_STRING);
        if ("null".equalsIgnoreCase(stringFromAdObject)) {
            return null;
        }
        return stringFromAdObject;
    }

    public d o() {
        if (this.m == null) {
            this.m = new d();
        }
        return this.m;
    }

    public int p() {
        return getIntFromAdObject("close_button_size", ((Integer) this.sdk.a(v4.L1)).intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = JsonUtils.getJSONObject(jSONArray, i, (JSONObject) null);
            try {
                URL url = new URL(JsonUtils.getString(jSONObject, "url", null));
                String string = JsonUtils.getString(jSONObject, "vendor_key", null);
                String string2 = JsonUtils.getString(jSONObject, "parameters", null);
                if (StringUtils.isValidString(string) && StringUtils.isValidString(string2)) {
                    arrayList.add(VerificationScriptResource.createVerificationScriptResourceWithParameters(string, url, string2));
                } else {
                    arrayList.add(VerificationScriptResource.createVerificationScriptResourceWithoutParameters(url));
                }
            } catch (Throwable th) {
                this.sdk.O();
                if (o.a()) {
                    this.sdk.O().a("DirectAd", "Failed to parse OMID verification script resource", th);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean s(f5 f5Var) {
        return JsonUtils.getBoolean(f5Var.a("video_button_properties", (JSONObject) null), "should_cache_video_button_html_assets", Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List q(f5 f5Var) {
        return k7.a(f5Var.a("video_end_urls", new JSONObject()), getClCode(), r0(), this.sdk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List d(f5 f5Var) {
        return k7.a(f5Var.a("custom_tabs_navigation_aborted_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
    }

    public void d() {
        this.f.set(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List b(f5 f5Var) {
        return k7.a(f5Var.a("app_killed_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List e(f5 f5Var) {
        return k7.a(f5Var.a("custom_tabs_navigation_failed_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List j(f5 f5Var) {
        return k7.a(f5Var.a("custom_tabs_tab_shown_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
    }

    private List b(final MotionEvent motionEvent, final boolean z, final boolean z2) {
        List listA;
        f5 f5Var = this.synchronizedAdObject;
        if (f5Var != null) {
            return (List) f5Var.a(new Function() { // from class: com.applovin.impl.sdk.ad.b$$ExternalSyntheticLambda12
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return this.f$0.a(motionEvent, z, z2, (f5) obj);
                }
            });
        }
        synchronized (this.adObjectLock) {
            listA = k7.a(getJsonObjectFromAdObject("click_tracking_urls", new JSONObject()), a(motionEvent, z, z2), c(motionEvent, z, z2), T(), a1(), this.sdk);
        }
        return listA;
    }

    public long c() {
        return getLongFromAdObject("batfort", TimeUnit.SECONDS.toMillis(1L));
    }

    private String c(MotionEvent motionEvent, boolean z, boolean z2) {
        String stringFromAdObject = getStringFromAdObject("click_tracking_url", null);
        Map mapA = a(motionEvent, z, z2);
        if (stringFromAdObject != null) {
            return StringUtils.replace(stringFromAdObject, mapA);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Map c(f5 f5Var) {
        try {
            return JsonUtils.toStringMap(f5Var.a("custom_tabs_http_headers", new JSONObject()));
        } catch (JSONException e2) {
            this.sdk.O();
            if (o.a()) {
                this.sdk.O().a("DirectAd", "Failed to retrieve http headers for Custom Tabs", e2);
            }
            return new HashMap();
        }
    }

    public void c(Uri uri) {
        f5 f5Var = this.synchronizedAdObject;
        if (f5Var != null) {
            f5Var.b("unmute_image", uri.toString());
            return;
        }
        synchronized (this.adObjectLock) {
            JsonUtils.putString(this.adObject, "unmute_image", uri.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List a(Function function, f5 f5Var) {
        return (List) function.apply(f5Var.a("omid_verification_script_resources", (JSONArray) null));
    }

    public void a(Uri uri) {
        this.d.add(uri);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(String str, f5 f5Var) {
        JsonUtils.putString(f5Var.a("video_button_properties", (JSONObject) null), "video_button_html", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List a(f5 f5Var) {
        return k7.a(f5Var.a("ad_closed_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
    }

    public List a(MotionEvent motionEvent, boolean z) {
        return b(motionEvent, false, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List a(MotionEvent motionEvent, boolean z, boolean z2, f5 f5Var) {
        return k7.a(f5Var.a("click_tracking_urls", new JSONObject()), a(motionEvent, z, z2), c(motionEvent, z, z2), T(), a1(), this.sdk);
    }

    public List b(final MotionEvent motionEvent, final boolean z) {
        List listA;
        List list;
        f5 f5Var = this.synchronizedAdObject;
        if (f5Var != null) {
            list = (List) f5Var.a(new Function() { // from class: com.applovin.impl.sdk.ad.b$$ExternalSyntheticLambda19
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return this.f$0.a(motionEvent, z, (f5) obj);
                }
            });
        } else {
            synchronized (this.adObjectLock) {
                listA = k7.a(getJsonObjectFromAdObject("video_click_tracking_urls", new JSONObject()), a(motionEvent, true, z), null, T(), a1(), this.sdk);
            }
            list = listA;
        }
        return list.isEmpty() ? b(motionEvent, true, z) : list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List a(MotionEvent motionEvent, boolean z, f5 f5Var) {
        return k7.a(f5Var.a("video_click_tracking_urls", new JSONObject()), a(motionEvent, true, z), null, T(), a1(), this.sdk);
    }

    private Map a(MotionEvent motionEvent, boolean z, boolean z2) {
        Point pointB = o0.b(k.o());
        HashMap map = new HashMap(7);
        map.put("{CLCODE}", getClCode());
        map.put("{CLICK_X}", String.valueOf(motionEvent != null ? motionEvent.getRawX() : -1.0f));
        map.put("{CLICK_Y}", String.valueOf(motionEvent != null ? motionEvent.getRawY() : -1.0f));
        map.put("{SCREEN_WIDTH}", String.valueOf(pointB.x));
        map.put("{SCREEN_HEIGHT}", String.valueOf(pointB.y));
        map.put("{IS_VIDEO_CLICK}", String.valueOf(z));
        map.put("{IS_INSTALL}", String.valueOf(z2));
        return map;
    }

    public void a(l4 l4Var) {
        this.g.set(l4Var);
    }

    private com.applovin.impl.adview.e.a a(boolean z) {
        return z ? com.applovin.impl.adview.e.a.WHITE_ON_TRANSPARENT : com.applovin.impl.adview.e.a.WHITE_ON_BLACK;
    }

    protected com.applovin.impl.adview.e.a a(int i) {
        if (i == 1) {
            return com.applovin.impl.adview.e.a.WHITE_ON_TRANSPARENT;
        }
        if (i == 2) {
            return com.applovin.impl.adview.e.a.INVISIBLE;
        }
        if (i == 3) {
            return com.applovin.impl.adview.e.a.TRANSPARENT_SKIP;
        }
        return com.applovin.impl.adview.e.a.WHITE_ON_BLACK;
    }

    public void b(Uri uri) {
        f5 f5Var = this.synchronizedAdObject;
        if (f5Var != null) {
            f5Var.b("mute_image", uri.toString());
            return;
        }
        synchronized (this.adObjectLock) {
            JsonUtils.putString(this.adObject, "mute_image", uri.toString());
        }
    }
}
