package com.applovin.impl;

import android.net.Uri;
import android.text.TextUtils;
import androidx.arch.core.util.Function;
import com.applovin.impl.sdk.utils.JsonUtils;
import io.bidmachine.unified.UnifiedMediationParams;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class l7 extends com.applovin.impl.sdk.ad.b implements n4 {
    private final String n;
    private final String o;
    private final u7 p;
    private final long q;
    private final y7 r;
    private final o7 s;
    private final String t;
    private final n7 u;
    private final i4 v;
    private final Set w;
    private final Set x;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private JSONObject f497a;
        private JSONObject b;
        private com.applovin.impl.sdk.k c;
        private long d;
        private String e;
        private String f;
        private u7 g;
        private y7 h;
        private o7 i;
        private n7 j;
        private Set k;
        private Set l;

        public b b(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.b = jSONObject;
                return this;
            }
            throw new IllegalArgumentException("No full ad response specified.");
        }

        public b b(String str) {
            this.e = str;
            return this;
        }

        public b b(Set set) {
            this.k = set;
            return this;
        }

        public b a(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.f497a = jSONObject;
                return this;
            }
            throw new IllegalArgumentException("No ad object specified.");
        }

        public b a(com.applovin.impl.sdk.k kVar) {
            if (kVar != null) {
                this.c = kVar;
                return this;
            }
            throw new IllegalArgumentException("No sdk specified.");
        }

        public b a(String str) {
            this.f = str;
            return this;
        }

        public b a(u7 u7Var) {
            this.g = u7Var;
            return this;
        }

        public b a(y7 y7Var) {
            this.h = y7Var;
            return this;
        }

        public b a(o7 o7Var) {
            this.i = o7Var;
            return this;
        }

        public b a(n7 n7Var) {
            this.j = n7Var;
            return this;
        }

        public b a(Set set) {
            this.l = set;
            return this;
        }

        public b a(long j) {
            this.d = j;
            return this;
        }

        public l7 a() {
            return new l7(this);
        }
    }

    public enum c {
        COMPANION_AD,
        VIDEO
    }

    public enum d {
        IMPRESSION,
        VIDEO_CLICK,
        COMPANION_CLICK,
        VIDEO,
        COMPANION,
        INDUSTRY_ICON_IMPRESSION,
        INDUSTRY_ICON_CLICK,
        ERROR
    }

    private Set A1() {
        y7 y7Var = this.r;
        return y7Var != null ? y7Var.b() : Collections.emptySet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List t(f5 f5Var) {
        return k7.a(f5Var.a("vimp_urls", new JSONObject()), getClCode(), null, w1(), T(), a1(), this.sdk);
    }

    private Set t1() {
        o7 o7Var = this.s;
        return o7Var != null ? o7Var.b() : Collections.emptySet();
    }

    private String w1() {
        String stringFromAdObject = getStringFromAdObject("vimp_url", null);
        if (stringFromAdObject != null) {
            return stringFromAdObject.replace("{CLCODE}", getClCode());
        }
        return null;
    }

    public y7 B1() {
        return this.r;
    }

    public z7 C1() {
        Long lF = r0.f(this.sdk);
        return this.r.a(lF != null ? lF.longValue() : 0L);
    }

    public boolean D1() {
        return x1() != null;
    }

    public boolean E1() {
        return getBooleanFromAdObject("vast_immediate_ad_load", Boolean.TRUE);
    }

    public void F1() {
        f5 f5Var = this.synchronizedAdObject;
        if (f5Var != null) {
            f5Var.c("vast_is_streaming");
            return;
        }
        synchronized (this.adObjectLock) {
            this.adObject.remove("vast_is_streaming");
        }
    }

    public boolean G1() {
        return getBooleanFromAdObject("cache_companion_ad", Boolean.TRUE);
    }

    public boolean H1() {
        return getBooleanFromAdObject("cache_video", Boolean.TRUE);
    }

    public boolean I1() {
        return getBooleanFromAdObject("vast_fire_click_trackers_on_html_clicks", Boolean.FALSE);
    }

    public boolean J1() {
        return getBooleanFromAdObject("iopms", Boolean.FALSE);
    }

    @Override // com.applovin.impl.sdk.ad.b
    public List K() {
        List listA;
        f5 f5Var = this.synchronizedAdObject;
        if (f5Var != null) {
            return (List) f5Var.a(new Function() { // from class: com.applovin.impl.l7$$ExternalSyntheticLambda0
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return this.f$0.t((f5) obj);
                }
            });
        }
        synchronized (this.adObjectLock) {
            listA = k7.a(getJsonObjectFromAdObject("vimp_urls", new JSONObject()), getClCode(), null, w1(), T(), a1(), this.sdk);
        }
        return listA;
    }

    @Override // com.applovin.impl.sdk.ad.b
    public boolean K0() {
        return getBooleanFromFullResponse("is_persisted_ad", false);
    }

    public boolean K1() {
        return getBooleanFromAdObject("iopmsfsr", Boolean.TRUE);
    }

    @Override // com.applovin.impl.sdk.ad.b
    public boolean N0() {
        return getBooleanFromAdObject("video_clickable", Boolean.FALSE) && m() != null;
    }

    @Override // com.applovin.impl.sdk.ad.b
    public boolean O0() {
        return getBooleanFromAdObject("vast_is_streaming", Boolean.FALSE);
    }

    @Override // com.applovin.impl.sdk.ad.b
    public void Q0() {
    }

    @Override // com.applovin.impl.sdk.ad.b
    public String S() {
        return this.t;
    }

    public Set a(d dVar, String str) {
        return a(dVar, new String[]{str});
    }

    public void d(String str) {
        f5 f5Var = this.synchronizedAdObject;
        if (f5Var != null) {
            f5Var.b("html_template", str);
            return;
        }
        synchronized (this.adObjectLock) {
            JsonUtils.putString(this.adObject, "html_template", str);
        }
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l7) || !super.equals(obj)) {
            return false;
        }
        l7 l7Var = (l7) obj;
        String str = this.n;
        if (str == null ? l7Var.n != null : !str.equals(l7Var.n)) {
            return false;
        }
        String str2 = this.o;
        if (str2 == null ? l7Var.o != null : !str2.equals(l7Var.o)) {
            return false;
        }
        u7 u7Var = this.p;
        if (u7Var == null ? l7Var.p != null : !u7Var.equals(l7Var.p)) {
            return false;
        }
        y7 y7Var = this.r;
        if (y7Var == null ? l7Var.r != null : !y7Var.equals(l7Var.r)) {
            return false;
        }
        o7 o7Var = this.s;
        if (o7Var == null ? l7Var.s != null : !o7Var.equals(l7Var.s)) {
            return false;
        }
        n7 n7Var = this.u;
        if (n7Var == null ? l7Var.u != null : !n7Var.equals(l7Var.u)) {
            return false;
        }
        Set set = this.w;
        if (set == null ? l7Var.w != null : !set.equals(l7Var.w)) {
            return false;
        }
        Set set2 = this.x;
        Set set3 = l7Var.x;
        if (set2 != null) {
            return set2.equals(set3);
        }
        return set3 == null;
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase
    public long getCreatedAtMillis() {
        return this.q;
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl
    public JSONObject getOriginalFullResponse() {
        return this.fullResponse;
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl
    public boolean hasVideoUrl() {
        List listG;
        y7 y7Var = this.r;
        return (y7Var == null || (listG = y7Var.g()) == null || listG.size() <= 0) ? false : true;
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl
    public int hashCode() {
        int iHashCode = super.hashCode() * 31;
        String str = this.n;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.o;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        u7 u7Var = this.p;
        int iHashCode4 = (iHashCode3 + (u7Var != null ? u7Var.hashCode() : 0)) * 31;
        y7 y7Var = this.r;
        int iHashCode5 = (iHashCode4 + (y7Var != null ? y7Var.hashCode() : 0)) * 31;
        o7 o7Var = this.s;
        int iHashCode6 = (iHashCode5 + (o7Var != null ? o7Var.hashCode() : 0)) * 31;
        n7 n7Var = this.u;
        int iHashCode7 = (iHashCode6 + (n7Var != null ? n7Var.hashCode() : 0)) * 31;
        Set set = this.w;
        int iHashCode8 = (iHashCode7 + (set != null ? set.hashCode() : 0)) * 31;
        Set set2 = this.x;
        return iHashCode8 + (set2 != null ? set2.hashCode() : 0);
    }

    @Override // com.applovin.impl.sdk.ad.b, com.applovin.impl.sdk.AppLovinAdBase, com.applovin.impl.b4
    public boolean isOpenMeasurementEnabled() {
        return getBooleanFromAdObject(UnifiedMediationParams.KEY_OM_SDK_ENABLED, Boolean.TRUE) && this.u != null;
    }

    @Override // com.applovin.impl.sdk.ad.b
    public Uri m() {
        y7 y7Var = this.r;
        if (y7Var != null) {
            return y7Var.c();
        }
        return null;
    }

    @Override // com.applovin.impl.sdk.ad.b
    public Uri m0() {
        return m();
    }

    public n7 r1() {
        return this.u;
    }

    public o7 s1() {
        return this.s;
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl
    public String toString() {
        return "VastAd{title='" + this.n + "', adDescription='" + this.o + "', systemInfo=" + this.p + ", videoCreative=" + this.r + ", companionAd=" + this.s + ", adVerifications=" + this.u + ", impressionTrackers=" + this.w + ", errorTrackers=" + this.x + AbstractJsonLexerKt.END_OBJ;
    }

    public String u1() {
        return getStringFromAdObject("html_template", "");
    }

    @Override // com.applovin.impl.sdk.ad.b
    public Uri v0() {
        z7 z7VarC1 = C1();
        if (z7VarC1 != null) {
            return z7VarC1.e();
        }
        return null;
    }

    public c v1() {
        return "companion_ad".equalsIgnoreCase(getStringFromAdObject("vast_first_caching_operation", "companion_ad")) ? c.COMPANION_AD : c.VIDEO;
    }

    public r7 x1() {
        y7 y7Var = this.r;
        if (y7Var != null) {
            return y7Var.f();
        }
        return null;
    }

    public long y1() {
        return getLongFromAdObject("real_close_delay", 0L);
    }

    public u7 z1() {
        return this.p;
    }

    private l7(b bVar) {
        super(bVar.f497a, bVar.b, bVar.c);
        this.n = bVar.e;
        this.p = bVar.g;
        this.o = bVar.f;
        this.r = bVar.h;
        this.s = bVar.i;
        this.u = bVar.j;
        this.w = bVar.k;
        this.x = bVar.l;
        this.v = new i4(this);
        Uri uriV0 = v0();
        if (uriV0 != null) {
            this.t = uriV0.toString();
        } else {
            this.t = "";
        }
        this.q = bVar.d;
    }

    public Set a(d dVar, String[] strArr) {
        this.sdk.O();
        if (com.applovin.impl.sdk.o.a()) {
            this.sdk.O().a("VastAd", "Retrieving trackers of type '" + dVar + "' and events '" + Arrays.toString(strArr) + "'...");
        }
        if (dVar == d.IMPRESSION) {
            return this.w;
        }
        if (dVar == d.VIDEO_CLICK) {
            return A1();
        }
        if (dVar == d.COMPANION_CLICK) {
            return t1();
        }
        if (dVar == d.VIDEO) {
            return a(c.VIDEO, strArr);
        }
        if (dVar == d.COMPANION) {
            return a(c.COMPANION_AD, strArr);
        }
        if (dVar == d.INDUSTRY_ICON_CLICK) {
            return x1().b();
        }
        if (dVar == d.INDUSTRY_ICON_IMPRESSION) {
            return x1().f();
        }
        if (dVar == d.ERROR) {
            return this.x;
        }
        this.sdk.O();
        if (com.applovin.impl.sdk.o.a()) {
            this.sdk.O().b("VastAd", "Failed to retrieve trackers of invalid type '" + dVar + "' and events '" + Arrays.toString(strArr) + "'");
        }
        return Collections.emptySet();
    }

    @Override // com.applovin.impl.sdk.ad.b, com.applovin.impl.sdk.AppLovinAdBase, com.applovin.impl.b4
    public i4 getAdEventTracker() {
        return this.v;
    }

    private Set a(c cVar, String[] strArr) {
        Map mapD;
        o7 o7Var;
        y7 y7Var;
        if (strArr != null && strArr.length > 0) {
            if (cVar == c.VIDEO && (y7Var = this.r) != null) {
                mapD = y7Var.e();
            } else {
                mapD = (cVar != c.COMPANION_AD || (o7Var = this.s) == null) ? null : o7Var.d();
            }
            HashSet hashSet = new HashSet();
            if (mapD != null && !mapD.isEmpty()) {
                for (String str : strArr) {
                    if (mapD.containsKey(str)) {
                        hashSet.addAll((Collection) mapD.get(str));
                    }
                }
            }
            return Collections.unmodifiableSet(hashSet);
        }
        return Collections.emptySet();
    }

    public static l7 a(JSONObject jSONObject, com.applovin.impl.sdk.k kVar) {
        if (jSONObject == null) {
            return null;
        }
        b bVar = new b();
        JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "full_response", (JSONObject) null);
        if (jSONObject2 == null) {
            return null;
        }
        bVar.b = jSONObject2;
        JSONObject jSONObject3 = JsonUtils.getJSONObject(JsonUtils.getJSONArray(jSONObject2, "ads", new JSONArray()), 0, (JSONObject) null);
        if (jSONObject3 == null) {
            return null;
        }
        bVar.f497a = jSONObject3;
        bVar.c = kVar;
        bVar.d = JsonUtils.getLong(jSONObject, "created_at_millis", 0L);
        bVar.e = JsonUtils.getString(jSONObject, "title", "");
        bVar.f = JsonUtils.getString(jSONObject, "ad_description", "");
        bVar.g = u7.a(JsonUtils.getJSONObject(jSONObject, "system_info", (JSONObject) null), kVar);
        bVar.h = y7.a(JsonUtils.getJSONObject(jSONObject, "video_creative", (JSONObject) null), kVar);
        bVar.i = o7.a(JsonUtils.getJSONObject(jSONObject, "companion_ad", (JSONObject) null), kVar);
        bVar.j = n7.a(JsonUtils.getJSONObject(jSONObject, "ad_verifications", (JSONObject) null), kVar);
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "impression_trackers", new JSONArray());
        HashSet hashSet = new HashSet();
        for (int i = 0; i < jSONArray.length(); i++) {
            v7 v7VarA = v7.a(JsonUtils.getJSONObject(jSONArray, i, (JSONObject) null), kVar);
            if (v7VarA != null) {
                hashSet.add(v7VarA);
            }
        }
        bVar.k = hashSet;
        JSONArray jSONArray2 = JsonUtils.getJSONArray(jSONObject, "error_trackers", new JSONArray());
        HashSet hashSet2 = new HashSet();
        for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
            v7 v7VarA2 = v7.a(JsonUtils.getJSONObject(jSONArray2, i2, (JSONObject) null), kVar);
            if (v7VarA2 != null) {
                hashSet2.add(v7VarA2);
            }
        }
        bVar.l = hashSet2;
        l7 l7Var = new l7(bVar);
        JSONArray jSONArray3 = JsonUtils.getJSONArray(jSONObject, "cached_ad_html_resources_urls", new JSONArray());
        for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
            Object objectAtIndex = JsonUtils.getObjectAtIndex(jSONArray3, i3, null);
            if (objectAtIndex instanceof String) {
                String str = (String) objectAtIndex;
                if (!TextUtils.isEmpty(str)) {
                    l7Var.a(Uri.parse(str));
                }
            }
        }
        return l7Var;
    }

    @Override // com.applovin.impl.n4
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putLong(jSONObject, "created_at_millis", this.q);
        JsonUtils.putString(jSONObject, "title", this.n);
        JsonUtils.putString(jSONObject, "ad_description", this.o);
        u7 u7Var = this.p;
        if (u7Var != null) {
            JsonUtils.putJSONObject(jSONObject, "system_info", u7Var.a());
        }
        y7 y7Var = this.r;
        if (y7Var != null) {
            JsonUtils.putJSONObject(jSONObject, "video_creative", y7Var.a());
        }
        o7 o7Var = this.s;
        if (o7Var != null) {
            JsonUtils.putJSONObject(jSONObject, "companion_ad", o7Var.a());
        }
        n7 n7Var = this.u;
        if (n7Var != null) {
            JsonUtils.putJSONObject(jSONObject, "ad_verifications", n7Var.a());
        }
        if (this.w != null) {
            JSONArray jSONArray = new JSONArray();
            Iterator it = this.w.iterator();
            while (it.hasNext()) {
                jSONArray.put(((v7) it.next()).a());
            }
            JsonUtils.putJsonArray(jSONObject, "impression_trackers", jSONArray);
        }
        if (this.x != null) {
            JSONArray jSONArray2 = new JSONArray();
            Iterator it2 = this.x.iterator();
            while (it2.hasNext()) {
                jSONArray2.put(((v7) it2.next()).a());
            }
            JsonUtils.putJsonArray(jSONObject, "error_trackers", jSONArray2);
        }
        ArrayList arrayList = new ArrayList();
        Iterator it3 = l().iterator();
        while (it3.hasNext()) {
            arrayList.add(((Uri) it3.next()).toString());
        }
        JsonUtils.putJsonArray(jSONObject, "cached_ad_html_resources_urls", new JSONArray((Collection) arrayList));
        f5 f5Var = this.synchronizedFullResponse;
        if (f5Var != null) {
            JsonUtils.putJSONObject(jSONObject, "full_response", f5Var.a());
        } else {
            synchronized (this.fullResponseLock) {
                JsonUtils.putJSONObject(jSONObject, "full_response", this.fullResponse);
            }
        }
        return jSONObject;
    }
}
