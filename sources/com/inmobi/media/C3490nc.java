package com.inmobi.media;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import androidx.browser.trusted.sharing.ShareTarget;
import com.google.android.gms.appset.AppSetIdInfo;
import com.inmobi.commons.core.configs.AdConfig;
import com.inmobi.commons.core.configs.Config;
import com.inmobi.commons.core.configs.RootConfig;
import com.inmobi.commons.core.configs.SignalsConfig;
import com.mbridge.msdk.foundation.download.download.ResourceManager;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.inmobi.media.nc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C3490nc extends S8 {
    public final String A;
    public String B;
    public Map C;
    public final RootConfig y;
    public final AdConfig z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3490nc(C3545rc uidMap, M4 m4, RootConfig rootConfig, AdConfig adConfig) {
        super("POST", (String) null, uidMap, false, (L4) m4, ShareTarget.ENCODING_TYPE_URL_ENCODED, 64);
        Intrinsics.checkNotNullParameter(uidMap, "uidMap");
        Intrinsics.checkNotNullParameter(rootConfig, "rootConfig");
        Intrinsics.checkNotNullParameter(adConfig, "adConfig");
        this.y = rootConfig;
        this.z = adConfig;
        this.A = ResourceManager.KEY_MD5CHECK;
        this.m = C3517pb.b();
        this.t = true;
        this.u = true;
        this.o = C3517pb.o();
    }

    /* JADX WARN: Code duplicated, block: B:101:0x020c  */
    /* JADX WARN: Code duplicated, block: B:104:0x0211  */
    /* JADX WARN: Code duplicated, block: B:106:0x0228  */
    /* JADX WARN: Code duplicated, block: B:109:0x023a  */
    /* JADX WARN: Code duplicated, block: B:111:0x0245 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:112:0x0247  */
    /* JADX WARN: Code duplicated, block: B:114:0x025a  */
    /* JADX WARN: Code duplicated, block: B:116:0x0272  */
    /* JADX WARN: Code duplicated, block: B:119:0x0287  */
    /* JADX WARN: Code duplicated, block: B:122:0x02aa  */
    /* JADX WARN: Code duplicated, block: B:125:0x02c3  */
    /* JADX WARN: Code duplicated, block: B:128:0x02d7  */
    /* JADX WARN: Code duplicated, block: B:131:0x02eb  */
    /* JADX WARN: Code duplicated, block: B:134:0x02ff  */
    /* JADX WARN: Code duplicated, block: B:137:0x0313  */
    /* JADX WARN: Code duplicated, block: B:140:0x0327  */
    /* JADX WARN: Code duplicated, block: B:143:0x033b  */
    /* JADX WARN: Code duplicated, block: B:146:0x034f  */
    /* JADX WARN: Code duplicated, block: B:149:0x0363  */
    /* JADX WARN: Code duplicated, block: B:152:0x0377  */
    /* JADX WARN: Code duplicated, block: B:155:0x038b  */
    /* JADX WARN: Code duplicated, block: B:164:0x03d7  */
    /* JADX WARN: Code duplicated, block: B:166:0x03f2  */
    /* JADX WARN: Code duplicated, block: B:167:0x0406  */
    /* JADX WARN: Code duplicated, block: B:171:0x0420  */
    /* JADX WARN: Code duplicated, block: B:173:0x0423  */
    /* JADX WARN: Code duplicated, block: B:176:0x0106 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:178:0x00f0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:181:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:27:0x0080  */
    /* JADX WARN: Code duplicated, block: B:30:0x0090  */
    /* JADX WARN: Code duplicated, block: B:33:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:36:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:39:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:44:0x0120  */
    /* JADX WARN: Code duplicated, block: B:45:0x0123  */
    /* JADX WARN: Code duplicated, block: B:47:0x0126  */
    /* JADX WARN: Code duplicated, block: B:48:0x012b  */
    /* JADX WARN: Code duplicated, block: B:54:0x0137  */
    /* JADX WARN: Code duplicated, block: B:56:0x013a  */
    /* JADX WARN: Code duplicated, block: B:59:0x014e  */
    /* JADX WARN: Code duplicated, block: B:60:0x0154  */
    /* JADX WARN: Code duplicated, block: B:62:0x0157  */
    /* JADX WARN: Code duplicated, block: B:73:0x0182  */
    /* JADX WARN: Code duplicated, block: B:76:0x019b  */
    /* JADX WARN: Code duplicated, block: B:78:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:79:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:82:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:83:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:88:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:91:0x01dc  */
    /* JADX WARN: Code duplicated, block: B:94:0x01f9  */
    @Override // com.inmobi.media.S8
    public final void f() {
        boolean zBooleanValue;
        String str;
        String str2;
        String str3;
        Map map;
        Config configA;
        SignalsConfig signalsConfig;
        JSONObject ext;
        boolean z;
        LinkedHashMap linkedHashMap;
        String str4;
        boolean z2;
        String strValueOf;
        SignalsConfig signalsConfig2;
        boolean z3;
        Context contextD;
        Map mapEmptyMap;
        Lazy lazy;
        JSONObject jSONObjectA;
        Pair<String, String> pairI;
        Pair<String, String> pairK;
        Pair<String, String> pairC;
        Pair<String, String> pairF;
        Pair<String, String> pairT;
        Pair<String, String> pairD;
        Pair<String, String> pairU;
        Pair<String, String> pairG;
        Pair<String, String> pairH;
        Pair<String, String> pairB;
        Pair<String, String> pairJ;
        JSONObject jSONObjectB;
        Context contextD2;
        int i;
        AppSetIdInfo appSetIdInfo;
        C3300a9 c3300a9;
        L4 l4;
        Y8 y8;
        JSONObject jSONObject;
        SignalsConfig.PublisherConfig publisher;
        Context contextD3;
        String packageName;
        String string;
        SharedPreferences sharedPreferences;
        String strE;
        super.f();
        HashMap mutableMap = this.k;
        if (mutableMap != null) {
            Boolean bool = I9.b;
            if (bool != null) {
                zBooleanValue = bool.booleanValue();
            } else {
                Context contextD4 = C3517pb.d();
                if (contextD4 != null) {
                    ConcurrentHashMap concurrentHashMap = K5.b;
                    K5 k5A = J5.a(contextD4, "user_info_store");
                    Intrinsics.checkNotNullParameter("user_age_restricted", "key");
                    I9.b = Boolean.valueOf(k5A.f3112a.getBoolean("user_age_restricted", false));
                }
                Boolean bool2 = I9.b;
                zBooleanValue = bool2 != null ? bool2.booleanValue() : false;
            }
            if (!zBooleanValue) {
                if (CollectionsKt.contains(this.y.getIpAddrTPSupport(), C3531qb.d())) {
                    Intrinsics.checkNotNull(T4.c);
                    str = T4.b;
                    if (str == null || str.length() == 0) {
                        String TAG = this.A;
                        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                    }
                } else {
                    String TAG2 = this.A;
                    Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                    Objects.toString(this.y.getIpAddrTPSupport());
                    C3531qb.d();
                }
                if (str != null) {
                }
                C3630xc c3630xcA = AbstractC3616wc.a();
                str2 = c3630xcA.f3479a;
                if (str2 != null) {
                }
                mutableMap.put("is-unifid-service-used", String.valueOf(c3630xcA.b));
                mutableMap.putAll(C3354e6.f3300a.b());
                mutableMap.putAll(AbstractC3466m4.a());
                mutableMap.put("d-media-volume", String.valueOf(C3435k3.f3355a.a(C3517pb.d(), this.o)));
                a(mutableMap);
                str3 = this.B;
                if (str3 != null) {
                }
                HashMap map2 = new HashMap();
                map2.putAll(AbstractC3450l2.f3364a);
                mutableMap.putAll(map2);
                map = this.C;
                if (map != null) {
                    for (Map.Entry entry : map.entrySet()) {
                        if (!mutableMap.containsKey(entry.getKey())) {
                            mutableMap.put(entry.getKey(), entry.getValue());
                        }
                    }
                }
                LinkedHashMap linkedHashMap2 = C3578u2.f3440a;
                configA = C3549s2.a("signals", this.m, null);
                if (configA instanceof SignalsConfig) {
                    signalsConfig = (SignalsConfig) configA;
                } else {
                    signalsConfig = null;
                }
                if (signalsConfig != null) {
                    ext = signalsConfig.getExt();
                } else {
                    ext = null;
                }
                if (ext != null || ext.length() <= 0) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    mutableMap.put("im-ext", String.valueOf(ext));
                }
                String str5 = L9.f3126a;
                linkedHashMap = new LinkedHashMap();
                str4 = L9.f3126a;
                if (str4 != null) {
                    linkedHashMap.put("u-nip", str4);
                } else {
                    linkedHashMap = null;
                }
                if (linkedHashMap != null) {
                    mutableMap.putAll(linkedHashMap);
                }
                if (Build.VERSION.SDK_INT >= 29 && (strE = AbstractC3565t3.e()) != null) {
                }
                if (this.z.getCctEnabled() || Y2.a(C3517pb.d()) == null) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                mutableMap.put("cct-enabled", String.valueOf(z2));
                mutableMap.putAll(I9.a());
                if (C3517pb.d() != null) {
                    contextD3 = C3517pb.d();
                    StringBuilder sb = new StringBuilder();
                    if (contextD3 != null) {
                        packageName = contextD3.getPackageName();
                    } else {
                        packageName = null;
                    }
                    string = sb.append(packageName).append("_preferences").toString();
                    if (contextD3 != null) {
                        sharedPreferences = contextD3.getSharedPreferences(string, 0);
                    } else {
                        sharedPreferences = null;
                    }
                    if (sharedPreferences == null && sharedPreferences.contains("IABGPP_HDR_GppString")) {
                        strValueOf = String.valueOf(sharedPreferences.getString("IABGPP_HDR_GppString", ""));
                    } else {
                        strValueOf = "";
                    }
                } else {
                    strValueOf = "";
                }
                if (AbstractC3420j2.a(strValueOf)) {
                    mutableMap.put("gpp", strValueOf);
                }
                mutableMap.putAll(AbstractC3565t3.c());
                mutableMap.putAll(R1.a());
                Config configA2 = C3549s2.a("signals", this.m, null);
                signalsConfig2 = configA2 instanceof SignalsConfig ? (SignalsConfig) configA2 : null;
                if (signalsConfig2 == null && (publisher = signalsConfig2.getPublisher()) != null && publisher.getEnableAB()) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    G9 g9 = G9.f3081a;
                    g9.getClass();
                    jSONObject = (JSONObject) G9.d.getValue(g9, G9.b[0]);
                    if (jSONObject.length() > 0) {
                        String string2 = jSONObject.toString();
                        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
                        mutableMap.put(com.ironsource.b9.h.l0, string2);
                    }
                }
                contextD = C3517pb.d();
                if (contextD != null) {
                    l4 = this.e;
                    c3300a9 = new C3300a9(contextD, l4);
                    if (c3300a9.d) {
                        y8 = new Y8(MapsKt.hashMapOf(TuplesKt.to("n-h-id", c3300a9.c)));
                    } else {
                        if (l4 != null) {
                            ((M4) l4).a("NovatiqDataHandler", "Novatiq disabled. skip");
                        }
                        y8 = new Y8(MapsKt.emptyMap());
                    }
                    mapEmptyMap = y8.f3245a;
                } else {
                    mapEmptyMap = MapsKt.emptyMap();
                }
                mutableMap.putAll(mapEmptyMap);
                lazy = P.c;
                if (!((CopyOnWriteArrayList) lazy.getValue()).isEmpty()) {
                    String string3 = new JSONArray((Collection) lazy.getValue()).toString();
                    Intrinsics.checkNotNullExpressionValue(string3, "toString(...)");
                    mutableMap.put("u-r-crid", string3);
                }
                jSONObjectA = H4.c.a();
                if (jSONObjectA.length() > 0) {
                    String string4 = jSONObjectA.toString();
                    Intrinsics.checkNotNullExpressionValue(string4, "toString(...)");
                    mutableMap.put("audioObject", string4);
                }
                C3435k3 c3435k3 = C3435k3.f3355a;
                pairI = c3435k3.i();
                Intrinsics.checkNotNullParameter(mutableMap, "<this>");
                if (pairI != null) {
                    mutableMap.put(pairI.getFirst(), pairI.getSecond());
                }
                pairK = c3435k3.k();
                Intrinsics.checkNotNullParameter(mutableMap, "<this>");
                if (pairK != null) {
                    mutableMap.put(pairK.getFirst(), pairK.getSecond());
                }
                pairC = c3435k3.c();
                Intrinsics.checkNotNullParameter(mutableMap, "<this>");
                if (pairC != null) {
                    mutableMap.put(pairC.getFirst(), pairC.getSecond());
                }
                pairF = c3435k3.f();
                Intrinsics.checkNotNullParameter(mutableMap, "<this>");
                if (pairF != null) {
                    mutableMap.put(pairF.getFirst(), pairF.getSecond());
                }
                pairT = c3435k3.t();
                Intrinsics.checkNotNullParameter(mutableMap, "<this>");
                if (pairT != null) {
                    mutableMap.put(pairT.getFirst(), pairT.getSecond());
                }
                pairD = c3435k3.d();
                Intrinsics.checkNotNullParameter(mutableMap, "<this>");
                if (pairD != null) {
                    mutableMap.put(pairD.getFirst(), pairD.getSecond());
                }
                pairU = c3435k3.u();
                Intrinsics.checkNotNullParameter(mutableMap, "<this>");
                if (pairU != null) {
                    mutableMap.put(pairU.getFirst(), pairU.getSecond());
                }
                pairG = c3435k3.g();
                Intrinsics.checkNotNullParameter(mutableMap, "<this>");
                if (pairG != null) {
                    mutableMap.put(pairG.getFirst(), pairG.getSecond());
                }
                pairH = c3435k3.h();
                Intrinsics.checkNotNullParameter(mutableMap, "<this>");
                if (pairH != null) {
                    mutableMap.put(pairH.getFirst(), pairH.getSecond());
                }
                pairB = c3435k3.b();
                Intrinsics.checkNotNullParameter(mutableMap, "<this>");
                if (pairB != null) {
                    mutableMap.put(pairB.getFirst(), pairB.getSecond());
                }
                pairJ = c3435k3.j();
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
                    StringBuilder sb2 = new StringBuilder("");
                    contextD2 = C3517pb.d();
                    if (contextD2 != null) {
                        ConcurrentHashMap concurrentHashMap2 = K5.b;
                        K5 k5A2 = J5.a(contextD2, "c_data_store");
                        Intrinsics.checkNotNullParameter("akv", "key");
                        i = k5A2.f3112a.getInt("akv", 1);
                    } else {
                        i = 1;
                    }
                    mutableMap.put("aKV", sb2.append(i).toString());
                }
                jSONObjectB = C3587ub.f3446a.b();
                if (jSONObjectB.length() > 0) {
                    String string5 = jSONObjectB.toString();
                    Intrinsics.checkNotNullExpressionValue(string5, "toString(...)");
                    mutableMap.put("sData", string5);
                }
            }
            String TAG3 = this.A;
            Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
            str = null;
            if (str != null) {
            }
            C3630xc c3630xcA2 = AbstractC3616wc.a();
            str2 = c3630xcA2.f3479a;
            if (str2 != null) {
            }
            mutableMap.put("is-unifid-service-used", String.valueOf(c3630xcA2.b));
            mutableMap.putAll(C3354e6.f3300a.b());
            mutableMap.putAll(AbstractC3466m4.a());
            mutableMap.put("d-media-volume", String.valueOf(C3435k3.f3355a.a(C3517pb.d(), this.o)));
            a(mutableMap);
            str3 = this.B;
            if (str3 != null) {
            }
            HashMap map3 = new HashMap();
            map3.putAll(AbstractC3450l2.f3364a);
            mutableMap.putAll(map3);
            map = this.C;
            if (map != null) {
                while (r1.hasNext()) {
                    if (!mutableMap.containsKey(entry.getKey())) {
                        mutableMap.put(entry.getKey(), entry.getValue());
                    }
                }
            }
            LinkedHashMap linkedHashMap3 = C3578u2.f3440a;
            configA = C3549s2.a("signals", this.m, null);
            if (configA instanceof SignalsConfig) {
                signalsConfig = (SignalsConfig) configA;
            } else {
                signalsConfig = null;
            }
            if (signalsConfig != null) {
                ext = signalsConfig.getExt();
            } else {
                ext = null;
            }
            if (ext != null) {
                z = false;
            } else {
                z = false;
            }
            if (z) {
                mutableMap.put("im-ext", String.valueOf(ext));
            }
            String str6 = L9.f3126a;
            linkedHashMap = new LinkedHashMap();
            str4 = L9.f3126a;
            if (str4 != null) {
                linkedHashMap.put("u-nip", str4);
            } else {
                linkedHashMap = null;
            }
            if (linkedHashMap != null) {
                mutableMap.putAll(linkedHashMap);
            }
            if (Build.VERSION.SDK_INT >= 29) {
            }
            if (this.z.getCctEnabled()) {
                z2 = false;
            } else {
                z2 = false;
            }
            mutableMap.put("cct-enabled", String.valueOf(z2));
            mutableMap.putAll(I9.a());
            if (C3517pb.d() != null) {
                contextD3 = C3517pb.d();
                StringBuilder sb3 = new StringBuilder();
                if (contextD3 != null) {
                    packageName = contextD3.getPackageName();
                } else {
                    packageName = null;
                }
                string = sb3.append(packageName).append("_preferences").toString();
                if (contextD3 != null) {
                    sharedPreferences = contextD3.getSharedPreferences(string, 0);
                } else {
                    sharedPreferences = null;
                }
                if (sharedPreferences == null) {
                    strValueOf = "";
                } else {
                    strValueOf = "";
                }
            } else {
                strValueOf = "";
            }
            if (AbstractC3420j2.a(strValueOf)) {
                mutableMap.put("gpp", strValueOf);
            }
            mutableMap.putAll(AbstractC3565t3.c());
            mutableMap.putAll(R1.a());
            Config configA3 = C3549s2.a("signals", this.m, null);
            if (configA3 instanceof SignalsConfig) {
            }
            if (signalsConfig2 == null) {
                z3 = false;
            } else {
                z3 = false;
            }
            if (z3) {
                G9 g10 = G9.f3081a;
                g10.getClass();
                jSONObject = (JSONObject) G9.d.getValue(g10, G9.b[0]);
                if (jSONObject.length() > 0) {
                    String string6 = jSONObject.toString();
                    Intrinsics.checkNotNullExpressionValue(string6, "toString(...)");
                    mutableMap.put(com.ironsource.b9.h.l0, string6);
                }
            }
            contextD = C3517pb.d();
            if (contextD != null) {
                l4 = this.e;
                c3300a9 = new C3300a9(contextD, l4);
                if (c3300a9.d) {
                    if (l4 != null) {
                        ((M4) l4).a("NovatiqDataHandler", "Novatiq disabled. skip");
                    }
                    y8 = new Y8(MapsKt.emptyMap());
                } else {
                    y8 = new Y8(MapsKt.hashMapOf(TuplesKt.to("n-h-id", c3300a9.c)));
                }
                mapEmptyMap = y8.f3245a;
            } else {
                mapEmptyMap = MapsKt.emptyMap();
            }
            mutableMap.putAll(mapEmptyMap);
            lazy = P.c;
            if (!((CopyOnWriteArrayList) lazy.getValue()).isEmpty()) {
                String string7 = new JSONArray((Collection) lazy.getValue()).toString();
                Intrinsics.checkNotNullExpressionValue(string7, "toString(...)");
                mutableMap.put("u-r-crid", string7);
            }
            jSONObjectA = H4.c.a();
            if (jSONObjectA.length() > 0) {
                String string8 = jSONObjectA.toString();
                Intrinsics.checkNotNullExpressionValue(string8, "toString(...)");
                mutableMap.put("audioObject", string8);
            }
            C3435k3 c3435k4 = C3435k3.f3355a;
            pairI = c3435k4.i();
            Intrinsics.checkNotNullParameter(mutableMap, "<this>");
            if (pairI != null) {
                mutableMap.put(pairI.getFirst(), pairI.getSecond());
            }
            pairK = c3435k4.k();
            Intrinsics.checkNotNullParameter(mutableMap, "<this>");
            if (pairK != null) {
                mutableMap.put(pairK.getFirst(), pairK.getSecond());
            }
            pairC = c3435k4.c();
            Intrinsics.checkNotNullParameter(mutableMap, "<this>");
            if (pairC != null) {
                mutableMap.put(pairC.getFirst(), pairC.getSecond());
            }
            pairF = c3435k4.f();
            Intrinsics.checkNotNullParameter(mutableMap, "<this>");
            if (pairF != null) {
                mutableMap.put(pairF.getFirst(), pairF.getSecond());
            }
            pairT = c3435k4.t();
            Intrinsics.checkNotNullParameter(mutableMap, "<this>");
            if (pairT != null) {
                mutableMap.put(pairT.getFirst(), pairT.getSecond());
            }
            pairD = c3435k4.d();
            Intrinsics.checkNotNullParameter(mutableMap, "<this>");
            if (pairD != null) {
                mutableMap.put(pairD.getFirst(), pairD.getSecond());
            }
            pairU = c3435k4.u();
            Intrinsics.checkNotNullParameter(mutableMap, "<this>");
            if (pairU != null) {
                mutableMap.put(pairU.getFirst(), pairU.getSecond());
            }
            pairG = c3435k4.g();
            Intrinsics.checkNotNullParameter(mutableMap, "<this>");
            if (pairG != null) {
                mutableMap.put(pairG.getFirst(), pairG.getSecond());
            }
            pairH = c3435k4.h();
            Intrinsics.checkNotNullParameter(mutableMap, "<this>");
            if (pairH != null) {
                mutableMap.put(pairH.getFirst(), pairH.getSecond());
            }
            pairB = c3435k4.b();
            Intrinsics.checkNotNullParameter(mutableMap, "<this>");
            if (pairB != null) {
                mutableMap.put(pairB.getFirst(), pairB.getSecond());
            }
            pairJ = c3435k4.j();
            Intrinsics.checkNotNullParameter(mutableMap, "<this>");
            if (pairJ != null) {
                mutableMap.put(pairJ.getFirst(), pairJ.getSecond());
            }
            AppSetIdInfo appSetIdInfo3 = Q0.f3171a;
            Intrinsics.checkNotNullParameter(mutableMap, "mutableMap");
            if (Q0.a()) {
                String id2 = appSetIdInfo.getId();
                Intrinsics.checkNotNullExpressionValue(id2, "getId(...)");
                mutableMap.put("d-app-set-id", id2);
            }
            M2 m3 = M2.f3131a;
            if (M2.c()) {
                mutableMap.put("ik", M2.g);
                mutableMap.put("c_data", M2.b());
                StringBuilder sb4 = new StringBuilder("");
                contextD2 = C3517pb.d();
                if (contextD2 != null) {
                    ConcurrentHashMap concurrentHashMap3 = K5.b;
                    K5 k5A3 = J5.a(contextD2, "c_data_store");
                    Intrinsics.checkNotNullParameter("akv", "key");
                    i = k5A3.f3112a.getInt("akv", 1);
                } else {
                    i = 1;
                }
                mutableMap.put("aKV", sb4.append(i).toString());
            }
            jSONObjectB = C3587ub.f3446a.b();
            if (jSONObjectB.length() > 0) {
                String string9 = jSONObjectB.toString();
                Intrinsics.checkNotNullExpressionValue(string9, "toString(...)");
                mutableMap.put("sData", string9);
            }
        }
    }
}
