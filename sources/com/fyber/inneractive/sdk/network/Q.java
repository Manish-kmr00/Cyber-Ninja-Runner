package com.fyber.inneractive.sdk.network;

import android.os.Build;
import android.text.TextUtils;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.config.AbstractC3081k;
import com.fyber.inneractive.sdk.config.AbstractC3090u;
import com.fyber.inneractive.sdk.config.C3077g;
import com.fyber.inneractive.sdk.config.C3091v;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.fyber.inneractive.sdk.external.InneractiveUserConfig;
import com.fyber.inneractive.sdk.util.AbstractC3247k;
import com.fyber.inneractive.sdk.util.AbstractC3251o;
import com.fyber.inneractive.sdk.util.AbstractC3255t;
import com.fyber.inneractive.sdk.util.AbstractC3256u;
import com.fyber.inneractive.sdk.util.IAlog;
import com.json.tr;
import com.pubmatic.sdk.common.POBCommonConstants;
import com.pubmatic.sdk.openwrap.core.POBConstants;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public final class Q extends U implements InterfaceC3139o {
    public final InneractiveAdRequest p;
    public HashMap q;
    public StringBuffer r;
    public final com.fyber.inneractive.sdk.serverapi.d s;
    public com.fyber.inneractive.sdk.dv.j t;
    public boolean u;
    public final com.fyber.inneractive.sdk.network.timeouts.request.a v;

    public Q(C3141q c3141q, InneractiveAdRequest inneractiveAdRequest, com.fyber.inneractive.sdk.config.global.r rVar) {
        com.fyber.inneractive.sdk.serverapi.c cVar = new com.fyber.inneractive.sdk.serverapi.c(rVar);
        super(c3141q, G.c.a(), rVar);
        this.t = null;
        this.u = false;
        this.o = true;
        this.p = inneractiveAdRequest;
        this.s = cVar;
        if (inneractiveAdRequest != null) {
            String strA = com.fyber.inneractive.sdk.util.o0.a(inneractiveAdRequest.getSpotId());
            String mediationName = inneractiveAdRequest.getMediationName();
            com.fyber.inneractive.sdk.config.global.features.k kVar = (com.fyber.inneractive.sdk.config.global.features.k) rVar.a(com.fyber.inneractive.sdk.config.global.features.k.class);
            this.v = TextUtils.isEmpty(mediationName) ? new com.fyber.inneractive.sdk.network.timeouts.request.b(kVar, strA) : new com.fyber.inneractive.sdk.network.timeouts.request.d(strA, kVar, mediationName);
        }
    }

    @Override // com.fyber.inneractive.sdk.network.InterfaceC3139o
    public final StringBuffer a() {
        return this.r;
    }

    @Override // com.fyber.inneractive.sdk.network.InterfaceC3139o
    public final Map b() {
        return this.q;
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public final void c() {
        super.c();
        IAlog.a("%s : NetworkRequestAd cancel by timeout - resolve request with no fill", IAlog.a(this));
        this.f1914a = true;
        a((Object) null, (Exception) new k0("no fill", 204), false);
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public final byte[] d() {
        JSONArray jSONArrayA;
        byte[] bytes = new byte[0];
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            com.fyber.inneractive.sdk.config.global.r rVar = ((com.fyber.inneractive.sdk.serverapi.c) this.s).f2325a;
            if (rVar != null) {
                jSONArrayA = com.fyber.inneractive.sdk.config.global.g.a(rVar.b, true);
                IAlog.a("%s: active experiments json set = %s", "SupportedFeaturesProvider", jSONArrayA);
            } else {
                jSONArrayA = null;
            }
            if (jSONArrayA != null && jSONArrayA.length() > 0) {
                jSONObject2.put(tr.d, jSONArrayA);
                jSONObject.put("sdk_experiments", jSONObject2);
            }
            UnitDisplayType unitDisplayTypeA = com.fyber.inneractive.sdk.serverapi.b.a(this.p.getSpotId());
            IAConfigManager iAConfigManager = IAConfigManager.O;
            JSONArray jSONArrayA2 = iAConfigManager.x.a(unitDisplayTypeA);
            if (jSONArrayA2 != null && jSONArrayA2.length() > 0) {
                jSONObject.put("user_sessions", jSONArrayA2);
            }
            int iA = iAConfigManager.u.b.a("dv_enabled_v2", 0, 0);
            if (unitDisplayTypeA != null && iA == 1) {
                com.fyber.inneractive.sdk.dv.j jVarA = iAConfigManager.G.a(unitDisplayTypeA);
                this.t = jVarA;
                if (jVarA != null) {
                    jSONObject.put("gdem_signal", jVarA.f1743a.getQuery());
                }
            }
            com.fyber.inneractive.sdk.topics.b bVar = iAConfigManager.F;
            if (bVar != null && IAConfigManager.f()) {
                Object objB = bVar.b();
                if (objB != null) {
                    jSONObject.put("topics", objB);
                }
                Object objA = bVar.a();
                if (objA != null) {
                    jSONObject.put("encrypted_topics", objA);
                }
            }
            bytes = jSONObject.toString().getBytes(StandardCharsets.UTF_8);
            IAlog.a("request json body - %s", jSONObject.toString());
            return bytes;
        } catch (Exception unused) {
            IAlog.a("Failed building body for ad request!", new Object[0]);
            return bytes;
        }
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public final int e() {
        return 0;
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public final int h() {
        return o();
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public final Map j() {
        int i = AbstractC3081k.f1710a;
        String property = System.getProperty("ia.testEnvironmentConfiguration.response");
        if (TextUtils.isEmpty(property)) {
            return null;
        }
        HashMap map = new HashMap();
        map.put("mockadnetworkresponseid", property);
        IAlog.a("NetworkRequestAd: Adding mock response header - %s", property);
        return map;
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public final M k() {
        return M.POST;
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public final g0 m() {
        return g0.HIGH;
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public final l0 n() {
        com.fyber.inneractive.sdk.network.timeouts.request.a aVar = this.v;
        return new l0(aVar.i, aVar.h);
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public final String p() {
        String str;
        String str2;
        int i = AbstractC3081k.f1710a;
        String property = System.getProperty("ia.testEnvironmentConfiguration.name");
        String str3 = TextUtils.isEmpty(property) ? "https://" + IAConfigManager.O.i.e : Pattern.compile("^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$").matcher(property).matches() ? "https://" + property + "/simpleM2M/clientRequestEnhancedXmlAd" : "https://" + property + ".inner-active.mobi/simpleM2M/clientRequestEnhancedXmlAd";
        InneractiveAdRequest inneractiveAdRequest = this.p;
        com.fyber.inneractive.sdk.serverapi.d dVar = this.s;
        S s = new S(inneractiveAdRequest, dVar);
        s.f1912a = new HashMap();
        s.a("fromSDK", Boolean.toString(true));
        s.a("po", System.getProperty("ia.testEnvironmentConfiguration.number"));
        s.a(POBConstants.KEY_SECURE, !AbstractC3255t.a() || IAConfigManager.O.q ? "1" : "0");
        s.a("spotid", inneractiveAdRequest.getSpotId());
        String property2 = System.getProperty("ia.testEnvironmentConfiguration.chosenUnitId");
        if (property2 == null) {
            property2 = inneractiveAdRequest.getSelectedUnitConfig() == null ? null : ((com.fyber.inneractive.sdk.config.T) inneractiveAdRequest.getSelectedUnitConfig()).f1681a;
        }
        s.a("uid", property2);
        IAConfigManager iAConfigManager = IAConfigManager.O;
        if (TextUtils.isEmpty(iAConfigManager.n)) {
            s.a(com.safedk.android.analytics.brandsafety.l.Z, iAConfigManager.l);
        } else {
            s.a(com.safedk.android.analytics.brandsafety.l.Z, iAConfigManager.l + "_" + iAConfigManager.n);
        }
        dVar.getClass();
        s.a(InneractiveMediationDefs.GENDER_FEMALE, Integer.toString(372));
        com.fyber.inneractive.sdk.serverapi.c cVar = (com.fyber.inneractive.sdk.serverapi.c) dVar;
        List list = com.fyber.inneractive.sdk.serverapi.c.d;
        if (!list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(String.valueOf((Integer) it.next()));
            }
            s.a(POBConstants.KEY_VIDEO_PROTOCOLS, AbstractC3251o.a(arrayList));
        }
        List list2 = com.fyber.inneractive.sdk.serverapi.c.c;
        if (!list2.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            Iterator it2 = list2.iterator();
            while (it2.hasNext()) {
                arrayList2.add(String.valueOf((Integer) it2.next()));
            }
            s.a("api", AbstractC3251o.a(arrayList2));
        }
        if (!InneractiveAdManager.isCurrentUserAChild()) {
            s.a(POBCommonConstants.ZIP_PARAM, iAConfigManager.j.getZipCode());
        }
        s.a("a", Integer.toString(iAConfigManager.j.getAge()));
        InneractiveUserConfig.Gender gender = iAConfigManager.j.getGender();
        if (InneractiveUserConfig.Gender.MALE.equals(gender)) {
            s.a("g", "m");
        } else if (InneractiveUserConfig.Gender.FEMALE.equals(gender)) {
            s.a("g", InneractiveMediationDefs.GENDER_FEMALE);
        }
        s.a(ApsMetricsDataMap.APSMETRICS_FIELD_TIMESTAMP, Long.toString(System.currentTimeMillis()));
        StringBuilder sb = new StringBuilder("2.2.0-Android-8.3.6");
        if (!TextUtils.isEmpty(InneractiveAdManager.getDevPlatform())) {
            sb.append('-').append(InneractiveAdManager.getDevPlatform());
        }
        s.a("v", sb.toString());
        Boolean boolD = iAConfigManager.D.d();
        if (boolD != null) {
            s.a("gdpr_privacy_consent", boolD.booleanValue() ? "1" : "0");
        }
        C3077g c3077g = iAConfigManager.D;
        if (c3077g != null) {
            Boolean bool = AbstractC3251o.f2370a == null ? null : c3077g.i;
            if (bool != null) {
                s.a("lgpd_consent", bool.booleanValue() ? "1" : "0");
            }
            Boolean bool2 = iAConfigManager.D.j;
            if (bool2 != null && bool2.booleanValue()) {
                s.a("coppaApplies", "1");
            }
        }
        if (!InneractiveAdManager.isCurrentUserAChild()) {
            String property3 = System.getProperty("ia.testEnvironmentConfiguration.device");
            C3091v c3091v = AbstractC3090u.f1727a.b;
            String str4 = c3091v != null ? c3091v.c : false ? "amazonId" : "aaid";
            if (TextUtils.isEmpty(property3)) {
                C3091v c3091v2 = AbstractC3090u.f1727a.b;
                property3 = c3091v2 != null ? c3091v2.f1728a : null;
            }
            s.a(str4, property3);
        }
        if (!InneractiveAdManager.isCurrentUserAChild()) {
            C3091v c3091v3 = AbstractC3090u.f1727a.b;
            s.a("dnt", Boolean.toString(c3091v3 != null ? c3091v3.b : false));
        }
        s.a("dml", AbstractC3247k.k());
        int iB = AbstractC3251o.b(AbstractC3251o.f());
        int iB2 = AbstractC3251o.b(AbstractC3251o.e());
        if (iB > 0 && iB2 > 0) {
            s.a("w", Integer.toString(iB));
            s.a("h", Integer.toString(iB2));
        }
        int iD = AbstractC3251o.d();
        s.a("o", iD == 1 ? "p" : iD == 2 ? "l" : ApsMetricsDataMap.APSMETRICS_FIELD_URL);
        if (!InneractiveAdManager.isCurrentUserAChild()) {
            s.a("ciso", AbstractC3247k.j());
            String str5 = cVar.b;
            s.a("mcc", str5 == null ? "" : str5.substring(0, Math.min(3, str5.length())));
            String str6 = cVar.b;
            s.a("mnc", str6 == null ? "" : str6.substring(Math.min(3, str6.length())));
            com.fyber.inneractive.sdk.util.a0 a0VarA = com.fyber.inneractive.sdk.util.a0.a();
            IAlog.a("ExchangeRequestParamsProvider: getNetwork : type: %s value: %s", a0VarA, a0VarA.b());
            s.a("nt", a0VarA.b());
            s.a("crn", cVar.a());
            s.a(CommonUrlParts.APP_SET_ID, iAConfigManager.r);
        }
        s.a("os", "Android");
        s.a("lng", iAConfigManager.o);
        ArrayList arrayList3 = iAConfigManager.p;
        if (arrayList3 != null && !arrayList3.isEmpty()) {
            s.a("in_lng", AbstractC3251o.a(arrayList3));
        }
        s.a("bid", AbstractC3251o.f2370a.getPackageName());
        s.a("appv", AbstractC3247k.m());
        C3077g c3077g2 = iAConfigManager.D;
        if (c3077g2.d == null) {
            c3077g2.e = c3077g2.h();
        }
        if (AbstractC3251o.f2370a == null) {
            str = null;
        } else {
            str = c3077g2.d;
            if (str == null) {
                str = c3077g2.e;
            }
        }
        s.a("gdpr_consent_data", str);
        C3077g c3077g3 = iAConfigManager.D;
        if (AbstractC3251o.f2370a == null) {
            c3077g3.getClass();
            str2 = null;
        } else {
            str2 = c3077g3.h;
        }
        s.a("us_privacy", str2);
        s.a("mute_video", Boolean.toString(iAConfigManager.k));
        s.a("osv", Build.VERSION.RELEASE);
        com.fyber.inneractive.sdk.ignite.l lVar = iAConfigManager.E.p;
        s.a("ignitep", lVar != null ? lVar.f1221a.d() : null);
        com.fyber.inneractive.sdk.ignite.l lVar2 = iAConfigManager.E.p;
        s.a("ignitev", lVar2 != null ? lVar2.f1221a.i() : null);
        HashMap map = new HashMap();
        cVar.a(inneractiveAdRequest.getSpotId(), map);
        for (Map.Entry entry : map.entrySet()) {
            s.a((String) entry.getKey(), (String) entry.getValue());
        }
        if (InneractiveAdManager.isCurrentUserAChild()) {
            s.a("childMode", "1");
        }
        com.fyber.inneractive.sdk.ignite.l lVar3 = IAConfigManager.O.E.p;
        s.a("odt", lVar3 != null ? lVar3.getOdt() : "");
        String strA = com.fyber.inneractive.sdk.util.g0.a(str3, s.f1912a);
        if (!this.u) {
            IAlog.d("%s %s", "AD_REQUEST", strA);
            this.u = true;
        }
        return strA;
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public final int q() {
        return this.v.f;
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public final boolean s() {
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0098  */
    @Override // com.fyber.inneractive.sdk.network.U
    public final O a(C3136l c3136l, Map map, int i) throws N {
        StringBuffer stringBufferA;
        String str;
        List list;
        if (map != null) {
            HashMap map2 = new HashMap();
            for (String str2 : map.keySet()) {
                if (str2 != null && (list = (List) map.get(str2)) != null && list.size() > 0) {
                    map2.put(str2.toLowerCase(Locale.US), (String) list.get(0));
                }
            }
            this.q = map2;
        }
        InputStream inputStream = c3136l == null ? null : c3136l.c;
        super.d(System.currentTimeMillis());
        IAlog.a("%s : NetworkRequestAd : set start read timestamp", IAlog.a(this));
        if (inputStream != null) {
            try {
                stringBufferA = AbstractC3256u.a(inputStream);
            } catch (Exception e) {
                IAlog.a("failed create response builder in network request ad", e, new Object[0]);
                stringBufferA = null;
            }
            this.r = stringBufferA;
        }
        b(System.currentTimeMillis());
        O o = new O();
        try {
            HashMap map3 = this.q;
            if (map3 != null) {
                str = (String) map3.get(EnumC3138n.RETURNED_AD_TYPE.key.toLowerCase(Locale.US));
                if (TextUtils.isEmpty(str) || !TextUtils.isDigitsOnly(str)) {
                    str = null;
                }
            } else {
                str = null;
            }
            o.f1911a = a(str != null ? Integer.parseInt(str) : 6, this, null, this.t);
            return o;
        } catch (Exception e2) {
            b(System.currentTimeMillis());
            IAlog.a("failed parse ad network request", e2, new Object[0]);
            throw new N(e2);
        }
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public final void b(long j) {
        super.b(j);
        IAlog.a("%s : NetworkRequestAd : set end read timestamp, total execution time: %d", IAlog.a(this), Integer.valueOf(o()));
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public final void c(long j) {
        super.c(j);
        IAlog.a("%s : NetworkRequestAd : set start connection timestamp", IAlog.a(this));
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public final C3136l a(String str) {
        IAlog.a("%s: NetworkRequestAd Ad request execution started, timeouts(connection: %d read: %d)", IAlog.a(this), Integer.valueOf(n().f1925a), Integer.valueOf(n().b));
        return super.a(str);
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public final void a(long j) {
        super.a(j);
        IAlog.a("%s : NetworkRequestAd : set end connection timestamp, total execution time: %d", IAlog.a(this), Integer.valueOf(o()));
    }
}
