package com.inmobi.media;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.browser.trusted.sharing.ShareTarget;
import com.google.android.gms.appset.AppSetIdInfo;
import com.inmobi.commons.core.configs.AdConfig;
import com.inmobi.commons.core.configs.Config;
import com.inmobi.commons.core.configs.SignalsConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class D extends S8 {
    public String A;
    public String B;
    public String C;
    public Map D;
    public final J y;
    public final Y8 z;

    public static JSONObject a(String adType) throws JSONException {
        Intrinsics.checkNotNullParameter(adType, "adType");
        if (Intrinsics.areEqual(adType, "banner")) {
            return H4.c.a();
        }
        if (!Intrinsics.areEqual("audio", adType)) {
            return new JSONObject();
        }
        D4 d4 = D4.c;
        JSONObject jSONObject = new JSONObject();
        long j = d4.f3037a / 1000;
        if (j != 0) {
            jSONObject.put("a-lastAudioPlayedTs", String.valueOf(j));
        }
        int i = d4.b;
        if (i > 0) {
            jSONObject.put("a-audioFreq", String.valueOf(i));
        }
        Context contextD = C3517pb.d();
        if (contextD != null) {
            ConcurrentHashMap concurrentHashMap = K5.b;
            K5 k5A = J5.a(contextD, "audio_pref_file");
            Intrinsics.checkNotNullParameter("user_mute_count", "key");
            int i2 = k5A.f3112a.getInt("user_mute_count", -1);
            if (i2 > 0) {
                jSONObject.put("a-umc", String.valueOf(i2));
            }
        }
        return jSONObject;
    }

    /* JADX WARN: Code duplicated, block: B:103:0x022d  */
    /* JADX WARN: Code duplicated, block: B:125:0x02c1  */
    /* JADX WARN: Code duplicated, block: B:20:0x0086  */
    @Override // com.inmobi.media.S8
    public final void f() {
        ArrayList arrayList;
        boolean z;
        String strValueOf;
        AppSetIdInfo appSetIdInfo;
        String strE;
        SignalsConfig.PublisherConfig publisher;
        Map map;
        super.f();
        HashMap mutableMap = this.k;
        if (mutableMap != null) {
            C3630xc c3630xcA = AbstractC3616wc.a();
            String str = c3630xcA.f3479a;
            if (str != null) {
            }
            mutableMap.put("is-unifid-service-used", String.valueOf(c3630xcA.b));
            mutableMap.put("format", this.A);
            String str2 = this.B;
            if (str2 != null) {
            }
            mutableMap.putAll(C3354e6.f3300a.b());
            HashMap map2 = new HashMap();
            String str3 = "DENIED";
            if (C3354e6.c() && C3354e6.e()) {
                str3 = "AUTHORISED";
            }
            Locale ENGLISH = Locale.ENGLISH;
            Intrinsics.checkNotNullExpressionValue(ENGLISH, "ENGLISH");
            String lowerCase = str3.toLowerCase(ENGLISH);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            map2.put("loc-consent-status", lowerCase);
            mutableMap.putAll(map2);
            mutableMap.putAll(sd.a());
            String strH = C3517pb.f3400a.h();
            if (strH == null || C3601vb.a(strH).isVisibleWifiEnabled()) {
                arrayList = ud.f;
                if (!(arrayList instanceof ArrayList)) {
                    arrayList = null;
                }
            } else {
                arrayList = null;
            }
            HashMap map3 = new HashMap();
            int i = 1;
            if (arrayList != null && arrayList.size() > 0) {
                rd rdVar = (rd) arrayList.get(arrayList.size() - 1);
                map3.put("v-ap-bssid", String.valueOf(rdVar != null ? Long.valueOf(rdVar.f3420a) : null));
            }
            mutableMap.putAll(map3);
            mutableMap.putAll(R1.a());
            mutableMap.putAll(R1.b());
            mutableMap.putAll(R1.c());
            Y8 y8 = this.z;
            if (y8 != null && (map = y8.f3245a) != null) {
                mutableMap.putAll(map);
            }
            LinkedHashMap linkedHashMap = C3578u2.f3440a;
            Config configA = C3549s2.a("signals", this.m, null);
            SignalsConfig signalsConfig = configA instanceof SignalsConfig ? (SignalsConfig) configA : null;
            if (signalsConfig != null && (publisher = signalsConfig.getPublisher()) != null && publisher.getEnableMCO()) {
                G9 g9 = G9.f3081a;
                g9.getClass();
                JSONObject jSONObject = (JSONObject) G9.d.getValue(g9, G9.b[0]);
                if (jSONObject.length() > 0) {
                    String string = jSONObject.toString();
                    Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                    mutableMap.put(com.ironsource.b9.h.l0, string);
                }
            }
            HashMap map4 = new HashMap();
            map4.putAll(AbstractC3450l2.f3364a);
            mutableMap.putAll(map4);
            String str4 = this.C;
            if (str4 != null) {
            }
            mutableMap.put("m10n_context", Intrinsics.areEqual("others", this.y.j()) ? "M10N_CONTEXT_OTHER" : "M10N_CONTEXT_ACTIVITY");
            Map<String, String> mapF = this.y.f();
            if (mapF != null) {
                for (Map.Entry<String, String> entry : mapF.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (!mutableMap.containsKey(key)) {
                        mutableMap.put(key, value);
                    }
                }
            }
            Map map5 = this.D;
            if (map5 != null) {
                mutableMap.putAll(map5);
            }
            if (this.y.g() != Long.MIN_VALUE) {
                mutableMap.put("im-plid", String.valueOf(this.y.g()));
            }
            mutableMap.put("int-origin", this.y.h());
            LinkedHashMap linkedHashMap2 = C3578u2.f3440a;
            Config configA2 = C3549s2.a("signals", this.m, null);
            SignalsConfig signalsConfig2 = configA2 instanceof SignalsConfig ? (SignalsConfig) configA2 : null;
            JSONObject ext = signalsConfig2 != null ? signalsConfig2.getExt() : null;
            if (ext != null && ext.length() > 0) {
                String string2 = ext.toString();
                Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
                mutableMap.put("im-ext", string2);
            }
            String str5 = L9.f3126a;
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            String str6 = L9.f3126a;
            if (str6 != null) {
                linkedHashMap3.put("u-nip", str6);
            } else {
                linkedHashMap3 = null;
            }
            if (linkedHashMap3 != null) {
                mutableMap.putAll(linkedHashMap3);
            }
            C3435k3 c3435k3 = C3435k3.f3355a;
            if (c3435k3.y() && (strE = AbstractC3565t3.e()) != null) {
                mutableMap.put("d-device-gesture-margins", strE);
            }
            if (Y2.a(C3517pb.d()) != null) {
                Config configA3 = C3549s2.a("ads", this.m, null);
                AdConfig adConfig = configA3 instanceof AdConfig ? (AdConfig) configA3 : null;
                if (adConfig == null || !adConfig.getCctEnabled()) {
                    z = false;
                } else {
                    z = true;
                }
            } else {
                z = false;
            }
            mutableMap.put("cct-enabled", String.valueOf(z));
            Lazy lazy = P.c;
            if (!((CopyOnWriteArrayList) lazy.getValue()).isEmpty()) {
                String string3 = new JSONArray((Collection) lazy.getValue()).toString();
                Intrinsics.checkNotNullExpressionValue(string3, "toString(...)");
                mutableMap.put("u-r-crid", string3);
            }
            String str7 = this.B;
            if (str7 != null && a(str7).length() > 0) {
                String string4 = a(str7).toString();
                Intrinsics.checkNotNullExpressionValue(string4, "toString(...)");
                mutableMap.put("audioObject", string4);
            }
            mutableMap.putAll(I9.a());
            if (C3517pb.d() != null) {
                Context contextD = C3517pb.d();
                SharedPreferences sharedPreferences = contextD != null ? contextD.getSharedPreferences((contextD != null ? contextD.getPackageName() : null) + "_preferences", 0) : null;
                if (sharedPreferences == null || !sharedPreferences.contains("IABGPP_HDR_GppString")) {
                    strValueOf = "";
                } else {
                    strValueOf = String.valueOf(sharedPreferences.getString("IABGPP_HDR_GppString", ""));
                }
            } else {
                strValueOf = "";
            }
            if (AbstractC3420j2.a(strValueOf)) {
                mutableMap.put("gpp", strValueOf);
            }
            Pair<String, String> pairI = c3435k3.i();
            Intrinsics.checkNotNullParameter(mutableMap, "<this>");
            if (pairI != null) {
                mutableMap.put(pairI.getFirst(), pairI.getSecond());
            }
            Pair<String, String> pairK = c3435k3.k();
            Intrinsics.checkNotNullParameter(mutableMap, "<this>");
            if (pairK != null) {
                mutableMap.put(pairK.getFirst(), pairK.getSecond());
            }
            Pair<String, String> pairC = c3435k3.c();
            Intrinsics.checkNotNullParameter(mutableMap, "<this>");
            if (pairC != null) {
                mutableMap.put(pairC.getFirst(), pairC.getSecond());
            }
            Pair<String, String> pairF = c3435k3.f();
            Intrinsics.checkNotNullParameter(mutableMap, "<this>");
            if (pairF != null) {
                mutableMap.put(pairF.getFirst(), pairF.getSecond());
            }
            Pair<String, String> pairT = c3435k3.t();
            Intrinsics.checkNotNullParameter(mutableMap, "<this>");
            if (pairT != null) {
                mutableMap.put(pairT.getFirst(), pairT.getSecond());
            }
            Pair<String, String> pairD = c3435k3.d();
            Intrinsics.checkNotNullParameter(mutableMap, "<this>");
            if (pairD != null) {
                mutableMap.put(pairD.getFirst(), pairD.getSecond());
            }
            Pair<String, String> pairU = c3435k3.u();
            Intrinsics.checkNotNullParameter(mutableMap, "<this>");
            if (pairU != null) {
                mutableMap.put(pairU.getFirst(), pairU.getSecond());
            }
            Pair<String, String> pairG = c3435k3.g();
            Intrinsics.checkNotNullParameter(mutableMap, "<this>");
            if (pairG != null) {
                mutableMap.put(pairG.getFirst(), pairG.getSecond());
            }
            Pair<String, String> pairH = c3435k3.h();
            Intrinsics.checkNotNullParameter(mutableMap, "<this>");
            if (pairH != null) {
                mutableMap.put(pairH.getFirst(), pairH.getSecond());
            }
            Pair<String, String> pairB = c3435k3.b();
            Intrinsics.checkNotNullParameter(mutableMap, "<this>");
            if (pairB != null) {
                mutableMap.put(pairB.getFirst(), pairB.getSecond());
            }
            Pair<String, String> pairJ = c3435k3.j();
            Intrinsics.checkNotNullParameter(mutableMap, "<this>");
            if (pairJ != null) {
                mutableMap.put(pairJ.getFirst(), pairJ.getSecond());
            }
            AppSetIdInfo appSetIdInfo2 = Q0.f3171a;
            Intrinsics.checkNotNullParameter(mutableMap, "mutableMap");
            if (Q0.a() && (appSetIdInfo = Q0.f3171a) != null) {
                String id = appSetIdInfo.getId();
                Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
                mutableMap.put("d-app-set-id", id);
            }
            M2 m2 = M2.f3131a;
            if (M2.c()) {
                mutableMap.put("ik", M2.g);
                mutableMap.put("c_data", M2.b());
                StringBuilder sb = new StringBuilder("");
                Context contextD2 = C3517pb.d();
                if (contextD2 != null) {
                    ConcurrentHashMap concurrentHashMap = K5.b;
                    K5 k5A = J5.a(contextD2, "c_data_store");
                    Intrinsics.checkNotNullParameter("akv", "key");
                    i = k5A.f3112a.getInt("akv", 1);
                }
                mutableMap.put("aKV", sb.append(i).toString());
            }
            JSONObject jSONObjectB = C3587ub.f3446a.b();
            if (jSONObjectB.length() > 0) {
                String string5 = jSONObjectB.toString();
                Intrinsics.checkNotNullExpressionValue(string5, "toString(...)");
                mutableMap.put("sData", string5);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public D(String str, C3545rc c3545rc, String str2, J adPlacement, Y8 y8, L4 l4, boolean z) {
        super("POST", str, c3545rc, false, l4, ShareTarget.ENCODING_TYPE_URL_ENCODED, z);
        Intrinsics.checkNotNullParameter(adPlacement, "adPlacement");
        this.y = adPlacement;
        this.z = y8;
        this.A = "json";
        this.m = C3517pb.b();
        HashMap map = this.k;
        if (map != null) {
            map.putAll(AbstractC3565t3.c());
            String str3 = O0.b;
            if (str3 != null) {
            }
            map.put("client-request-id", adPlacement.d());
            if (str2 != null) {
                map.put("u-appcache", str2);
            }
            map.put("sdk-flavor", "row");
        }
    }
}
