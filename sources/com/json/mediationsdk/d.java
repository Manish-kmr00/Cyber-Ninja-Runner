package com.json.mediationsdk;

import android.os.Build;
import android.security.NetworkSecurityPolicy;
import android.text.TextUtils;
import com.json.ak;
import com.json.ar;
import com.json.b5;
import com.json.environment.ContextProvider;
import com.json.environment.thread.IronSourceThreadManager;
import com.json.f5;
import com.json.fe;
import com.json.m5;
import com.json.mediationsdk.demandOnly.p;
import com.json.mediationsdk.logger.IronLog;
import com.json.mediationsdk.utils.IronSourceConstants;
import com.json.mediationsdk.utils.IronSourceUtils;
import com.json.mk;
import com.json.mm;
import com.json.nf;
import com.json.o9;
import com.json.v4;
import com.json.x2;
import com.json.zb;
import com.safedk.android.internal.partials.IronSourceNetworkBridge;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class d {
    public static final boolean A = false;
    private static d B = new d();
    public static final String c = "auctionId";
    public static final String d = "armData";
    public static final String e = "larmData";
    public static final String f = "isAdUnitCapped";
    public static final String g = "settings";
    public static final String h = "waterfall";
    public static final String i = "genericParams";
    public static final String j = "configurations";
    public static final String k = "instances";
    public static final String l = "${AUCTION_LOSS}";
    public static final String m = "${AUCTION_MBR}";
    public static final String n = "${AUCTION_PRICE}";
    public static final String o = "${DYNAMIC_DEMAND_SOURCE}";
    public static final String p = "${INSTANCE}";
    public static final String q = "${INSTANCE_TYPE}";
    public static final String r = "${PLACEMENT_NAME}";
    private static final String s = "adMarkup";
    private static final String t = "dynamicDemandSource";
    private static final String u = "params";
    public static final String v = "dlpl";
    public static final String w = "adUnit";
    public static final String x = "parallelLoad";
    public static final String y = "bidderExclusive";
    public static final String z = "showPriorityEnabled";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f3940a = new AtomicBoolean(false);
    private final nf b = mm.S().f();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f3941a;
        private List<m5> b;
        private m5 c;
        private JSONObject d;
        private JSONObject e;
        private int f;
        private String g;
        private v4 h;

        public a(String str) {
            this.f3941a = str;
        }

        public p a(String str) {
            v4 v4Var = this.h;
            return v4Var != null ? v4Var.a(str) : new p.b();
        }

        public String a() {
            return this.f3941a;
        }

        public JSONObject b() {
            return this.e;
        }

        public int c() {
            return this.f;
        }

        public String d() {
            return this.g;
        }

        public m5 e() {
            return this.c;
        }

        public JSONObject f() {
            return this.d;
        }

        public v4 g() {
            return this.h;
        }

        public List<m5> h() {
            return this.b;
        }
    }

    static class b implements Runnable {
        private static final int d = 15000;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f3942a;
        private String b;
        private String c;

        public b(String str, String str2, String str3) {
            this.f3942a = str;
            this.b = str2;
            this.c = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = this.f3942a + ";" + this.b + ";" + this.c;
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.c).openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setReadTimeout(15000);
                httpURLConnection.setConnectTimeout(15000);
                httpURLConnection.connect();
                int iHttpUrlConnectionGetResponseCode = IronSourceNetworkBridge.httpUrlConnectionGetResponseCode(httpURLConnection);
                String responseMessage = httpURLConnection.getResponseMessage();
                IronSourceNetworkBridge.httpUrlConnectionDisconnect(httpURLConnection);
                if (iHttpUrlConnectionGetResponseCode != 200 && iHttpUrlConnectionGetResponseCode != 204) {
                    JSONObject jSONObjectJsonObjectInit = IronSourceNetworkBridge.jsonObjectInit();
                    jSONObjectJsonObjectInit.put(IronSourceConstants.EVENTS_PROVIDER, "Mediation");
                    jSONObjectJsonObjectInit.put(IronSourceConstants.EVENTS_PROGRAMMATIC, 1);
                    jSONObjectJsonObjectInit.put(IronSourceConstants.EVENTS_EXT1, str);
                    jSONObjectJsonObjectInit.put("errorCode", iHttpUrlConnectionGetResponseCode);
                    jSONObjectJsonObjectInit.put("reason", responseMessage);
                    ar.i().a(new zb(IronSourceConstants.TROUBLESHOOTING_FAILED_TO_SEND_AUCTION_URL, jSONObjectJsonObjectInit));
                }
            } catch (Exception e) {
                o9.d().a(e);
                IronLog.INTERNAL.error("Send auction url failed with params - " + str + ";" + e.getMessage());
            }
        }
    }

    private enum c {
        NOT_SECURE,
        SECURE
    }

    private c a() {
        c cVar = c.SECURE;
        if (Build.VERSION.SDK_INT >= 28) {
            if (!NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted()) {
                return cVar;
            }
        } else if ((ContextProvider.getInstance().getApplicationContext().getApplicationInfo().flags & 134217728) == 0) {
            return cVar;
        }
        return c.NOT_SECURE;
    }

    private String a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        double d2 = Double.parseDouble(str);
        double d3 = Double.parseDouble(str2);
        return d3 == 0.0d ? "" : String.valueOf(Math.round((d2 / d3) * 1000.0d) / 1000.0d);
    }

    public static d b() {
        return B;
    }

    public a a(JSONObject jSONObject) throws JSONException {
        String strOptString = jSONObject.optString("auctionId");
        if (TextUtils.isEmpty(strOptString)) {
            throw new JSONException("Invalid auction response - auction id is missing");
        }
        a aVar = new a(strOptString);
        JSONObject jSONObjectOptJSONObject = null;
        if (jSONObject.has("settings")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("settings");
            aVar.c = new m5(jSONObject2);
            jSONObjectOptJSONObject = jSONObject2.has(d) ? jSONObject2.optJSONObject(d) : null;
            if (jSONObject2.has("genericParams")) {
                aVar.d = jSONObject2.optJSONObject("genericParams");
            }
            if (jSONObject2.has("configurations")) {
                aVar.e = jSONObject2.optJSONObject("configurations");
            }
            if (jSONObject2.has(k)) {
                aVar.h = new v4.a(jSONObject2.optJSONObject(k));
            }
        }
        aVar.b = new ArrayList();
        if (jSONObject.has(h)) {
            JSONArray jSONArray = jSONObject.getJSONArray(h);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                m5 m5Var = new m5(jSONArray.getJSONObject(i2), i2, jSONObjectOptJSONObject);
                if (!m5Var.m()) {
                    aVar.f = 1002;
                    aVar.g = "waterfall " + i2;
                    IronLog.INTERNAL.verbose("AuctionResponseItem " + i2 + " not valid - parsing error");
                    throw new JSONException("invalid response");
                }
                aVar.b.add(m5Var);
            }
        }
        return aVar;
    }

    public String a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            JSONObject jSONObjectJsonObjectInit = IronSourceNetworkBridge.jsonObjectInit(str);
            return jSONObjectJsonObjectInit.has("adMarkup") ? jSONObjectJsonObjectInit.getString("adMarkup") : str;
        } catch (JSONException e2) {
            o9.d().a(e2);
            IronLog.INTERNAL.error("exception " + e2.getMessage());
            return str;
        }
    }

    public String a(String str, int i2, m5 m5Var, String str2, String str3, String str4) {
        String strI = m5Var.i();
        return a(str, m5Var.c(), i2, b().c(m5Var.k()), strI, b().a(strI, str2), str3, str4);
    }

    public String a(String str, String str2, int i2, String str3, String str4, String str5, String str6, String str7) {
        return str.replace("${AUCTION_PRICE}", str4).replace("${AUCTION_LOSS}", str6).replace("${AUCTION_MBR}", str5).replace(p, str2).replace(q, Integer.toString(i2)).replace(o, str3).replace(r, str7);
    }

    JSONObject a(i iVar) throws JSONException {
        boolean z2;
        boolean z3;
        ISBannerSize iSBannerSize;
        IronSource.AD_UNIT ad_unitC = iVar.c();
        boolean isEncryptedResponse = iVar.getIsEncryptedResponse();
        Map<String, Object> mapG = iVar.g();
        List<String> listK = iVar.k();
        h auctionHistory = iVar.getAuctionHistory();
        int sessionDepth = iVar.getSessionDepth();
        ISBannerSize iSBannerSize2 = iVar.getCom.ironsource.k6.u java.lang.String();
        IronSourceSegment segment = iVar.getSegment();
        boolean testSuiteLaunched = iVar.getTestSuiteLaunched();
        boolean useTestAds = iVar.getUseTestAds();
        ArrayList<f5> arrayListJ = iVar.j();
        JSONObject jSONObjectJsonObjectInit = IronSourceNetworkBridge.jsonObjectInit();
        JSONObject jSONObjectJsonObjectInit2 = IronSourceNetworkBridge.jsonObjectInit();
        Iterator<String> it = mapG.keySet().iterator();
        while (true) {
            z2 = testSuiteLaunched;
            z3 = isEncryptedResponse;
            String strA = "";
            iSBannerSize = iSBannerSize2;
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            Iterator<String> it2 = it;
            JSONObject jSONObjectJsonObjectInit3 = IronSourceNetworkBridge.jsonObjectInit();
            IronSourceSegment ironSourceSegment = segment;
            jSONObjectJsonObjectInit3.put(fe.t0, 2);
            jSONObjectJsonObjectInit3.put(fe.k0, new JSONObject((Map) mapG.get(next)));
            if (auctionHistory != null) {
                strA = auctionHistory.a(next);
            }
            jSONObjectJsonObjectInit3.put(fe.w0, strA);
            jSONObjectJsonObjectInit3.put("ts", useTestAds ? 1 : 0);
            jSONObjectJsonObjectInit2.put(next, jSONObjectJsonObjectInit3);
            testSuiteLaunched = z2;
            isEncryptedResponse = z3 ? 1 : 0;
            iSBannerSize2 = iSBannerSize;
            it = it2;
            segment = ironSourceSegment;
        }
        IronSourceSegment ironSourceSegment2 = segment;
        int i2 = 2;
        for (String str : listK) {
            JSONObject jSONObjectJsonObjectInit4 = IronSourceNetworkBridge.jsonObjectInit();
            jSONObjectJsonObjectInit4.put(fe.t0, 1);
            jSONObjectJsonObjectInit4.put(fe.w0, auctionHistory != null ? auctionHistory.a(str) : "");
            jSONObjectJsonObjectInit2.put(str, jSONObjectJsonObjectInit4);
        }
        for (f5 f5Var : arrayListJ) {
            JSONObject jSONObjectJsonObjectInit5 = IronSourceNetworkBridge.jsonObjectInit();
            jSONObjectJsonObjectInit5.put(fe.t0, f5Var.e() ? i2 : 1);
            Map<String, Object> mapF = f5Var.f();
            if (!mapF.isEmpty()) {
                jSONObjectJsonObjectInit5.put(fe.k0, new JSONObject(mapF));
            }
            jSONObjectJsonObjectInit5.put(fe.w0, auctionHistory != null ? auctionHistory.a(f5Var.g()) : "");
            jSONObjectJsonObjectInit5.put("ts", useTestAds ? 1 : 0);
            if (!f5Var.getPlumbus().isEmpty()) {
                jSONObjectJsonObjectInit5.put(v, f5Var.getPlumbus());
            }
            jSONObjectJsonObjectInit2.put(f5Var.g(), jSONObjectJsonObjectInit5);
            i2 = 2;
        }
        jSONObjectJsonObjectInit.put(fe.s0, jSONObjectJsonObjectInit2);
        if (iVar.getIsOneFlow()) {
            jSONObjectJsonObjectInit.put(fe.s1, 1);
        }
        if (iVar.getCom.ironsource.mediationsdk.utils.IronSourceConstants.EVENTS_DEMAND_ONLY java.lang.String()) {
            jSONObjectJsonObjectInit.put("do", 1);
        }
        new ak().b(ContextProvider.getInstance().getApplicationContext());
        JSONObject jSONObjectA = new b5(x2.a(ad_unitC)).a();
        a(jSONObjectA, false);
        jSONObjectA.put(fe.u0, sessionDepth);
        jSONObjectA.put(fe.v0, a().ordinal());
        if (ironSourceSegment2 != null) {
            jSONObjectA.put(fe.e1, ironSourceSegment2.toJson());
        }
        jSONObjectJsonObjectInit.put(fe.p0, jSONObjectA);
        if (iSBannerSize != null) {
            JSONObject jSONObjectJsonObjectInit6 = IronSourceNetworkBridge.jsonObjectInit();
            jSONObjectJsonObjectInit6.put(fe.m0, iSBannerSize.getDescription());
            jSONObjectJsonObjectInit6.put(fe.o0, iSBannerSize.getWidth());
            jSONObjectJsonObjectInit6.put(fe.n0, iSBannerSize.getHeight());
            jSONObjectJsonObjectInit.put(fe.l0, jSONObjectJsonObjectInit6);
        }
        jSONObjectJsonObjectInit.put(fe.g0, ad_unitC.toString());
        if (iVar.getAdFormat() != null) {
            jSONObjectJsonObjectInit.put("adf", iVar.getAdFormat());
        }
        if (iVar.getAdUnitId() != null) {
            jSONObjectJsonObjectInit.put("mediationAdUnitId", iVar.getAdUnitId());
        }
        if (iVar.getCom.ironsource.fe.j0 java.lang.String() != null) {
            jSONObjectJsonObjectInit.put(fe.j0, iVar.getCom.ironsource.fe.j0 java.lang.String());
        }
        jSONObjectJsonObjectInit.put(fe.q0, !z3 ? 1 : 0);
        Object objRemove = jSONObjectA.remove(fe.o1);
        if (objRemove != null) {
            jSONObjectJsonObjectInit.put(fe.o1, objRemove);
        }
        if (z2) {
            jSONObjectJsonObjectInit.put(fe.m1, 1);
        }
        return jSONObjectJsonObjectInit;
    }

    public void a(String str, String str2, String str3) {
        IronSourceThreadManager.INSTANCE.postMediationBackgroundTask(new b(str, str2, str3));
    }

    public void a(JSONObject jSONObject, boolean z2) {
        if (jSONObject == null || jSONObject.length() <= 0 || TextUtils.isEmpty(jSONObject.optString(fe.g1)) || !this.f3940a.compareAndSet(false, true)) {
            return;
        }
        ar.i().a(new zb(IronSourceConstants.TROUBLESHOOTING_MEDIATION_TCS_CALCULATED, IronSourceUtils.getMediationAdditionalData(z2, true, -1)));
    }

    public Map<String, String> b(String str) {
        HashMap map = new HashMap();
        try {
            JSONObject jSONObjectJsonObjectInit = IronSourceNetworkBridge.jsonObjectInit(str);
            if (jSONObjectJsonObjectInit.has("params")) {
                JSONObject jSONObject = jSONObjectJsonObjectInit.getJSONObject("params");
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    Object obj = jSONObject.get(next);
                    if (obj instanceof String) {
                        map.put(next, (String) obj);
                    }
                }
            }
        } catch (JSONException e2) {
            o9.d().a(e2);
            IronLog.INTERNAL.error("exception " + e2.getMessage());
        }
        return map;
    }

    public String c(String str) {
        String string = "";
        try {
            if (TextUtils.isEmpty(str) || !mk.a(str)) {
                return "";
            }
            JSONObject jSONObjectJsonObjectInit = IronSourceNetworkBridge.jsonObjectInit(str);
            if (!jSONObjectJsonObjectInit.has("params")) {
                return "";
            }
            JSONObject jSONObject = jSONObjectJsonObjectInit.getJSONObject("params");
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.verbose("parameters = " + jSONObject);
            if (!jSONObject.has("dynamicDemandSource")) {
                return "";
            }
            string = jSONObject.getString("dynamicDemandSource");
            ironLog.verbose("demand source = " + string);
            return string;
        } catch (JSONException e2) {
            o9.d().a(e2);
            IronLog.INTERNAL.error("exception " + e2.getMessage());
            return string;
        }
    }
}
