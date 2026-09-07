package com.json;

import android.content.Context;
import android.text.TextUtils;
import com.json.environment.StringUtils;
import com.json.mediationsdk.IronSource;
import com.json.mediationsdk.logger.IronLog;
import com.json.mediationsdk.model.InterstitialPlacement;
import com.json.mediationsdk.model.NetworkSettings;
import com.json.mediationsdk.model.Placement;
import com.json.mediationsdk.utils.IronSourceConstants;
import com.json.mediationsdk.utils.IronSourceUtils;
import com.safedk.android.internal.partials.IronSourceNetworkBridge;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class ls {
    protected static final boolean A = false;
    protected static final String A0 = "sharedManagersThread";
    protected static final String A1 = "spId";
    protected static final int B = 60;
    protected static final String B0 = "parallelLoad";
    protected static final String B1 = "mpis";
    protected static final int C = 10000;
    protected static final String C0 = "bidderExclusive";
    protected static final String C1 = "auction";
    protected static final int D = 10000;
    protected static final String D0 = "adapterTimeOutInSeconds";
    protected static final String D1 = "auctionData";
    protected static final int E = -1;
    protected static final String E0 = "atim";
    protected static final String E1 = "auctioneerURL";
    protected static final int F = 5000;
    protected static final String F0 = "bannerInterval";
    protected static final String F1 = "extAuctioneerURL";
    protected static final int G = 3;
    protected static final String G0 = "isOneFlow";
    protected static final String G1 = "objectPerWaterfall";
    protected static final int H = 3;
    protected static final String H0 = "expiredDurationInMinutes";
    protected static final String H1 = "minTimeBeforeFirstAuction";
    protected static final int I = 3;
    protected static final String I0 = "server";
    protected static final String I1 = "timeToWaitBeforeAuction";
    protected static final int J = 0;
    protected static final String J0 = "publisher";
    protected static final String J1 = "timeToWaitBeforeLoad";
    protected static final int K = 2;
    protected static final String K0 = "console";
    protected static final String K1 = "auctionRetryInterval";
    protected static final int L = 15;
    protected static final String L0 = "sendUltraEvents";
    protected static final String L1 = "isLoadWhileShow";
    protected static final long M = 10000;
    protected static final String M0 = "sendEventsToggle";
    protected static final String M1 = "auctionTrials";
    protected static final long N = 3000;
    protected static final String N0 = "eventsCompression";
    protected static final String N1 = "auctionTimeout";
    protected static final boolean O = false;
    protected static final String O0 = "eventsCompressionLevel";
    protected static final String O1 = "auctionSavedHistory";
    protected static final boolean P = false;
    protected static final String P0 = "serverEventsURL";
    protected static final String P1 = "disableLoadWhileShowSupportFor";
    protected static final int Q = 30000;
    protected static final String Q0 = "serverEventsType";
    protected static final String Q1 = "tokenPerAdapter";
    protected static final int R = -1;
    protected static final String R0 = "backupThreshold";
    protected static final String R1 = "timeToDeleteOldWaterfallAfterAuction";
    protected static final int S = 5000;
    protected static final String S0 = "maxNumberOfEvents";
    protected static final String S1 = "compressAuctionRequest";
    protected static final int T = 1;
    protected static final String T0 = "maxEventsPerBatch";
    protected static final String T1 = "compressAuctionResponse";
    protected static final boolean U = false;
    protected static final String U0 = "optOut";
    protected static final String U1 = "encryptionVersion";
    protected static final int V = 15000;
    protected static final String V0 = "optIn";
    protected static final String V1 = "shouldSendBannerBURLFromImpression";
    protected static final int W = 15000;
    protected static final String W0 = "triggerEvents";
    protected static final String W1 = "impressionTimeout";
    protected static final String X = "providerOrder";
    protected static final String X0 = "nonConnectivityEvents";
    protected static final String X1 = "optInKeys";
    protected static final String Y = "providerSettings";
    protected static final String Y0 = "shouldSendPublisherLogsOnUIThread";
    protected static final String Y1 = "tokenGenericParams";
    protected static final String Z = "configurations";
    protected static final String Z0 = "pixel";
    protected static final String Z1 = "compressToken";
    protected static final String a0 = "genericParams";
    protected static final String a1 = "pixelEventsUrl";
    protected static final String a2 = "compressExternalToken";
    protected static final String b0 = "adUnits";
    protected static final String b1 = "pixelEventsEnabled";
    protected static final String b2 = "instanceType";
    protected static final String c0 = "providerLoadName";
    protected static final String c1 = "placements";
    protected static final String c2 = "maxAdsPerSession";
    protected static final String d0 = "application";
    protected static final String d1 = "placementId";
    protected static final String d2 = "reward";
    protected static final String e0 = "rewardedVideo";
    protected static final String e1 = "placementName";
    protected static final String e2 = "name";
    protected static final String f0 = "interstitial";
    protected static final String f1 = "delivery";
    protected static final String f2 = "amount";
    protected static final String g0 = "banner";
    protected static final String g1 = "isDefault";
    protected static final String g2 = "bannerRefreshRate";
    protected static final String h0 = "nativeAd";
    protected static final String h1 = "capping";
    protected static final String h2 = "protocolVersion";
    protected static final String i0 = "integration";
    protected static final String i1 = "pacing";
    protected static final String i2 = "adFormats";
    protected static final String j0 = "loggers";
    protected static final String j1 = "enabled";
    protected static final String j2 = "adUnits";
    protected static final String k0 = "segment";
    protected static final String k1 = "maxImpressions";
    protected static final String k2 = "rewarded";
    public static final String l = "appKey";
    protected static final String l0 = "events";
    protected static final String l1 = "numOfSeconds";
    public static final String m = "userId";
    protected static final String m0 = "crashReporter";
    protected static final String m1 = "unit";
    public static final String n = "response";
    protected static final String n0 = "token";
    protected static final String n1 = "virtualItemName";
    protected static final String o = "error";
    protected static final String o0 = "external";
    protected static final String o1 = "virtualItemCount";
    protected static final int p = 3;
    protected static final String p0 = "mediationTypes";
    protected static final String p1 = "uuidEnabled";
    protected static final boolean q = false;
    protected static final String q0 = "providerDefaultInstance";
    protected static final String q1 = "abt";
    protected static final boolean r = true;
    protected static final String r0 = "testSuite";
    protected static final String r1 = "delayLoadFailure";
    protected static final boolean s = true;
    protected static final String s0 = "controllerUrl";
    protected static final String s1 = "keysToInclude";
    protected static final int t = 2;
    protected static final String t0 = "AdQuality";
    protected static final String t1 = "reporterURL";
    protected static final int u = 2;
    protected static final String u0 = "initSDK";
    protected static final String u1 = "reporterKeyword";
    protected static final int v = 1;
    protected static final String v0 = "settings";
    protected static final String v1 = "includeANR";
    protected static final int w = 1;
    protected static final String w0 = "collectBiddingDataTimeout";
    protected static final String w1 = "timeout";
    protected static final boolean x = true;
    protected static final String x0 = "providers";
    protected static final String x1 = "setIgnoreDebugger";
    protected static final boolean y = false;
    protected static final String y0 = "parallelInit";
    protected static final String y1 = "adSourceName";
    protected static final boolean z = false;
    protected static final String z0 = "waitUntilAllProvidersFinishInit";
    protected static final String z1 = "providerNetworkKey";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private aq f3876a;
    private cq b;
    private s8 c;
    private String d;
    private String e;
    private JSONObject f;
    private Context g;
    private a h;
    private bg.a i;
    private boolean j;
    private mc k;

    public enum a {
        NOT_SET("0"),
        CACHE("1"),
        SERVER("2");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f3877a;

        a(String str) {
            this.f3877a = str;
        }

        public String a() {
            return this.f3877a;
        }
    }

    public ls(Context context, String str, String str2, String str3) {
        this.h = a.NOT_SET;
        this.j = false;
        this.g = context;
        this.i = mm.M().m();
        try {
            this.f = TextUtils.isEmpty(str3) ? IronSourceNetworkBridge.jsonObjectInit() : IronSourceNetworkBridge.jsonObjectInit(str3);
            this.j = n();
            s();
            q();
            r();
            this.d = TextUtils.isEmpty(str) ? "" : str;
            this.e = TextUtils.isEmpty(str2) ? "" : str2;
            b(this.f);
        } catch (JSONException e) {
            o9.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            a();
        }
    }

    public ls(ls lsVar) {
        this.h = a.NOT_SET;
        this.j = false;
        try {
            this.g = lsVar.d();
            this.f = IronSourceNetworkBridge.jsonObjectInit(lsVar.f.toString());
            this.d = lsVar.d;
            this.e = lsVar.e;
            this.j = lsVar.j;
            this.f3876a = lsVar.j();
            this.b = lsVar.k();
            this.c = lsVar.c();
            this.h = lsVar.h();
            this.i = mm.M().m();
            b(this.f);
        } catch (Exception e) {
            o9.d().a(e);
            a();
        }
    }

    private int a(JSONObject jSONObject, JSONObject jSONObject2, String str, int i) {
        int iOptInt = 0;
        if (jSONObject.has(str)) {
            iOptInt = jSONObject.optInt(str, 0);
        } else if (jSONObject2.has(str)) {
            iOptInt = jSONObject2.optInt(str, 0);
        }
        return iOptInt == 0 ? i : iOptInt;
    }

    private long a(JSONObject jSONObject, JSONObject jSONObject2, String str, long j) {
        long jOptLong;
        if (jSONObject.has(str)) {
            jOptLong = jSONObject.optLong(str, 0L);
        } else {
            jOptLong = jSONObject2.has(str) ? jSONObject2.optLong(str, 0L) : 0L;
        }
        return jOptLong == 0 ? j : jOptLong;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0036 A[PHI: r7
  0x0036: PHI (r7v3 com.ironsource.pp) = (r7v1 com.ironsource.pp), (r7v2 com.ironsource.pp) binds: [B:10:0x0034, B:13:0x0042] A[DONT_GENERATE, DONT_INLINE]] */
    private lp a(JSONObject jSONObject) {
        pp ppVar = null;
        if (jSONObject == null) {
            return null;
        }
        lp.b bVar = new lp.b();
        bVar.a(jSONObject.optBoolean("delivery", true));
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("capping");
        if (jSONObjectOptJSONObject != null) {
            String strOptString = jSONObjectOptJSONObject.optString(m1);
            if (!TextUtils.isEmpty(strOptString)) {
                pp ppVar2 = pp.PER_DAY;
                if (ppVar2.toString().equals(strOptString)) {
                    ppVar = ppVar2;
                } else {
                    ppVar2 = pp.PER_HOUR;
                    if (ppVar2.toString().equals(strOptString)) {
                        ppVar = ppVar2;
                    }
                }
            }
            int iOptInt = jSONObjectOptJSONObject.optInt(k1, 0);
            bVar.a(jSONObjectOptJSONObject.optBoolean("enabled", false) && iOptInt > 0, ppVar, iOptInt);
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("pacing");
        if (jSONObjectOptJSONObject2 != null) {
            int iOptInt2 = jSONObjectOptJSONObject2.optInt(l1, 0);
            bVar.a(jSONObjectOptJSONObject2.optBoolean("enabled", false) && iOptInt2 > 0, iOptInt2);
        }
        return bVar.a();
    }

    public static a a(ls lsVar) {
        return lsVar != null ? lsVar.h() : a.NOT_SET;
    }

    private String a(String str) {
        try {
            JSONObject jSONObjectC = c(c(c(c(this.f, "configurations"), "adFormats"), str), y2.c);
            if (jSONObjectC == null) {
                return null;
            }
            Iterator<String> itKeys = jSONObjectC.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                JSONObject jSONObjectC2 = c(jSONObjectC, next);
                if (jSONObjectC2 != null && jSONObjectC2.optBoolean(g1)) {
                    return next;
                }
            }
            return null;
        } catch (Exception e) {
            o9.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return null;
        }
    }

    private void a() {
        this.f = IronSourceNetworkBridge.jsonObjectInit();
        this.d = "";
        this.e = "";
        this.f3876a = new aq();
        this.b = cq.c();
        this.c = new s8.a().a();
        this.i = mm.M().m();
        b(this.f);
    }

    private boolean a(JSONObject jSONObject, JSONObject jSONObject2, String str, boolean z2) {
        if (jSONObject.has(str)) {
            return jSONObject.optBoolean(str, z2);
        }
        return jSONObject2.has(str) ? jSONObject2.optBoolean(str, z2) : z2;
    }

    private int[] a(JSONObject jSONObject, String str) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(str);
        if (jSONArrayOptJSONArray == null) {
            return null;
        }
        int[] iArr = new int[jSONArrayOptJSONArray.length()];
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            iArr[i] = jSONArrayOptJSONArray.optInt(i);
        }
        return iArr;
    }

    public static dv b(ls lsVar) {
        return (lsVar == null || !lsVar.p()) ? dv.a() : lsVar.c().getApplicationConfigurations().j();
    }

    private String b() {
        return this.j ? "adFormats" : y2.c;
    }

    private JSONArray b(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return null;
        }
        if (!this.j) {
            return jSONObject.optJSONArray(str);
        }
        JSONObject jSONObjectC = c(jSONObject, str);
        String strA = a(str);
        if (jSONObjectC == null || strA == null) {
            return null;
        }
        return jSONObjectC.optJSONArray(strA);
    }

    private void b(JSONObject jSONObject) {
        this.k = new mc(jSONObject.optJSONObject(tr.d));
    }

    private boolean b(String str) {
        return this.b.a("Mediation") && StringUtils.toLowerCase("IronSource").equals(StringUtils.toLowerCase(str));
    }

    private g1 c(JSONObject jSONObject) {
        g1 g1Var = new g1();
        JSONObject jSONObjectC = c(jSONObject, "AdQuality");
        if (jSONObjectC != null) {
            g1Var.a(jSONObjectC.optBoolean(u0));
        }
        return g1Var;
    }

    private JSONObject c(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(str);
        }
        return null;
    }

    private Context d() {
        return this.g;
    }

    private h7 d(JSONObject jSONObject) {
        if (jSONObject != null) {
            int iOptInt = jSONObject.optInt("placementId", -1);
            String strOptString = jSONObject.optString("placementName", "");
            boolean zOptBoolean = jSONObject.optBoolean(g1, false);
            lp lpVarA = a(jSONObject);
            if (iOptInt >= 0 && !TextUtils.isEmpty(strOptString)) {
                h7 h7Var = new h7(iOptInt, strOptString, zOptBoolean, lpVarA);
                if (lpVarA == null) {
                    return h7Var;
                }
                this.i.c(this.g, h7Var, IronSource.AD_UNIT.BANNER);
                return h7Var;
            }
        }
        return null;
    }

    private JSONObject d(JSONObject jSONObject, String str) {
        JSONObject jSONObjectC = c(jSONObject, str);
        return jSONObjectC != null ? jSONObjectC : IronSourceNetworkBridge.jsonObjectInit();
    }

    private InterstitialPlacement e(JSONObject jSONObject) {
        if (jSONObject != null) {
            int iOptInt = jSONObject.optInt("placementId", -1);
            String strOptString = jSONObject.optString("placementName", "");
            boolean zOptBoolean = jSONObject.optBoolean(g1, false);
            lp lpVarA = a(jSONObject);
            if (iOptInt >= 0 && !TextUtils.isEmpty(strOptString)) {
                InterstitialPlacement interstitialPlacement = new InterstitialPlacement(iOptInt, strOptString, zOptBoolean, lpVarA);
                if (lpVarA == null) {
                    return interstitialPlacement;
                }
                this.i.c(this.g, interstitialPlacement, IronSource.AD_UNIT.INTERSTITIAL);
                return interstitialPlacement;
            }
        }
        return null;
    }

    private cn f(JSONObject jSONObject) {
        if (jSONObject != null) {
            int iOptInt = jSONObject.optInt("placementId", -1);
            String strOptString = jSONObject.optString("placementName", "");
            boolean zOptBoolean = jSONObject.optBoolean(g1, false);
            lp lpVarA = a(jSONObject);
            if (iOptInt >= 0 && !TextUtils.isEmpty(strOptString)) {
                cn cnVar = new cn(iOptInt, strOptString, zOptBoolean, lpVarA);
                if (lpVarA == null) {
                    return cnVar;
                }
                this.i.c(this.g, cnVar, IronSource.AD_UNIT.NATIVE_AD);
                return cnVar;
            }
        }
        return null;
    }

    private Placement g(JSONObject jSONObject) {
        if (jSONObject != null) {
            int iOptInt = jSONObject.optInt("placementId", -1);
            String strOptString = jSONObject.optString("placementName", "");
            boolean zOptBoolean = jSONObject.optBoolean(g1, false);
            String strOptString2 = jSONObject.optString("virtualItemName", "");
            int iOptInt2 = jSONObject.optInt("virtualItemCount", -1);
            lp lpVarA = a(jSONObject);
            if (iOptInt >= 0 && !TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(strOptString2) && iOptInt2 > 0) {
                Placement placement = new Placement(iOptInt, strOptString, zOptBoolean, strOptString2, iOptInt2, lpVarA);
                if (lpVarA == null) {
                    return placement;
                }
                this.i.c(this.g, placement, IronSource.AD_UNIT.REWARDED_VIDEO);
                return placement;
            }
        }
        return null;
    }

    private pu h(JSONObject jSONObject) {
        pu puVar = new pu();
        JSONObject jSONObjectC = c(jSONObject, "testSuite");
        if (jSONObjectC != null) {
            puVar.b(jSONObjectC.optString("controllerUrl"));
        }
        return puVar;
    }

    private String l() {
        return this.j ? "rewarded" : "rewardedVideo";
    }

    private boolean m() {
        JSONObject jSONObjectC;
        JSONArray jSONArrayOptJSONArray;
        JSONObject jSONObjectC2 = c(this.f, "providerOrder");
        JSONArray jSONArrayNames = jSONObjectC2.names();
        if (jSONArrayNames == null) {
            return true;
        }
        JSONObject jSONObjectC3 = c(c(this.f, "configurations"), b());
        for (int i = 0; i < jSONArrayNames.length(); i++) {
            String strOptString = jSONArrayNames.optString(i);
            JSONArray jSONArrayOptJSONArray2 = jSONObjectC2.optJSONArray(strOptString);
            if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() != 0 && (jSONObjectC = c(jSONObjectC3, strOptString)) != null && ((jSONArrayOptJSONArray = jSONObjectC.optJSONArray("placements")) == null || jSONArrayOptJSONArray.length() == 0)) {
                return false;
            }
        }
        return true;
    }

    private boolean n() {
        int iOptInt;
        try {
            iOptInt = this.f.optInt(h2, 0);
        } catch (Exception e) {
            o9.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            iOptInt = 0;
        }
        return iOptInt == 1;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:159:0x072a  */
    /* JADX WARN: Code duplicated, block: B:162:0x0731 A[Catch: Exception -> 0x0b3f, TryCatch #0 {Exception -> 0x0b3f, blocks: (B:3:0x0004, B:5:0x006f, B:9:0x008b, B:11:0x0097, B:16:0x00dd, B:18:0x0177, B:19:0x0184, B:21:0x018a, B:24:0x019e, B:26:0x01a6, B:27:0x01af, B:29:0x01b5, B:32:0x01c5, B:34:0x01cd, B:35:0x01d4, B:37:0x01da, B:40:0x01e8, B:42:0x01f0, B:43:0x01f7, B:45:0x01fd, B:48:0x020b, B:50:0x0214, B:53:0x02c5, B:55:0x02cb, B:57:0x02e4, B:60:0x02f0, B:62:0x02f6, B:64:0x0300, B:65:0x0303, B:69:0x0320, B:71:0x03bc, B:72:0x03c9, B:74:0x03cf, B:77:0x03e3, B:79:0x03eb, B:80:0x03f4, B:82:0x03fa, B:85:0x040a, B:87:0x0412, B:88:0x0419, B:90:0x041f, B:93:0x042d, B:95:0x0435, B:96:0x043c, B:98:0x0442, B:101:0x0450, B:103:0x045b, B:105:0x04d8, B:108:0x04e2, B:110:0x04e8, B:112:0x04f2, B:113:0x04f5, B:117:0x050a, B:119:0x05ce, B:120:0x05d9, B:122:0x05df, B:125:0x05f1, B:127:0x05f9, B:128:0x0602, B:130:0x0608, B:133:0x0618, B:135:0x0620, B:136:0x0627, B:138:0x062d, B:141:0x063b, B:143:0x0643, B:144:0x064a, B:146:0x0650, B:149:0x065e, B:151:0x0669, B:153:0x0673, B:157:0x071d, B:160:0x072b, B:162:0x0731, B:164:0x073d, B:165:0x0740, B:169:0x076d, B:171:0x0805, B:172:0x080c, B:174:0x0812, B:177:0x0820, B:179:0x0828, B:180:0x082f, B:182:0x0835, B:185:0x0843, B:187:0x084b, B:188:0x0852, B:190:0x0858, B:193:0x0866, B:195:0x086e, B:196:0x0875, B:198:0x087b, B:201:0x0889, B:203:0x0896, B:205:0x08a0, B:209:0x0913, B:212:0x0923, B:214:0x0929, B:216:0x0933, B:217:0x0936, B:219:0x094f, B:221:0x0956, B:224:0x0963, B:226:0x0969, B:227:0x0973, B:229:0x097b, B:230:0x097e, B:232:0x098b, B:234:0x0994, B:236:0x09ad, B:238:0x09b2, B:239:0x09d0, B:241:0x09f8, B:244:0x0a3e, B:246:0x0a44, B:249:0x0a52, B:251:0x0a70, B:255:0x0a7c, B:257:0x0a88, B:259:0x0a95, B:260:0x0a99, B:261:0x0a9e, B:263:0x0aa7, B:264:0x0ab0, B:266:0x0b0d, B:268:0x0b15, B:270:0x0b2c, B:254:0x0a77, B:206:0x0904, B:207:0x090a, B:154:0x0702, B:155:0x0710, B:104:0x04cd, B:56:0x02d5), top: B:275:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:164:0x073d A[Catch: Exception -> 0x0b3f, TryCatch #0 {Exception -> 0x0b3f, blocks: (B:3:0x0004, B:5:0x006f, B:9:0x008b, B:11:0x0097, B:16:0x00dd, B:18:0x0177, B:19:0x0184, B:21:0x018a, B:24:0x019e, B:26:0x01a6, B:27:0x01af, B:29:0x01b5, B:32:0x01c5, B:34:0x01cd, B:35:0x01d4, B:37:0x01da, B:40:0x01e8, B:42:0x01f0, B:43:0x01f7, B:45:0x01fd, B:48:0x020b, B:50:0x0214, B:53:0x02c5, B:55:0x02cb, B:57:0x02e4, B:60:0x02f0, B:62:0x02f6, B:64:0x0300, B:65:0x0303, B:69:0x0320, B:71:0x03bc, B:72:0x03c9, B:74:0x03cf, B:77:0x03e3, B:79:0x03eb, B:80:0x03f4, B:82:0x03fa, B:85:0x040a, B:87:0x0412, B:88:0x0419, B:90:0x041f, B:93:0x042d, B:95:0x0435, B:96:0x043c, B:98:0x0442, B:101:0x0450, B:103:0x045b, B:105:0x04d8, B:108:0x04e2, B:110:0x04e8, B:112:0x04f2, B:113:0x04f5, B:117:0x050a, B:119:0x05ce, B:120:0x05d9, B:122:0x05df, B:125:0x05f1, B:127:0x05f9, B:128:0x0602, B:130:0x0608, B:133:0x0618, B:135:0x0620, B:136:0x0627, B:138:0x062d, B:141:0x063b, B:143:0x0643, B:144:0x064a, B:146:0x0650, B:149:0x065e, B:151:0x0669, B:153:0x0673, B:157:0x071d, B:160:0x072b, B:162:0x0731, B:164:0x073d, B:165:0x0740, B:169:0x076d, B:171:0x0805, B:172:0x080c, B:174:0x0812, B:177:0x0820, B:179:0x0828, B:180:0x082f, B:182:0x0835, B:185:0x0843, B:187:0x084b, B:188:0x0852, B:190:0x0858, B:193:0x0866, B:195:0x086e, B:196:0x0875, B:198:0x087b, B:201:0x0889, B:203:0x0896, B:205:0x08a0, B:209:0x0913, B:212:0x0923, B:214:0x0929, B:216:0x0933, B:217:0x0936, B:219:0x094f, B:221:0x0956, B:224:0x0963, B:226:0x0969, B:227:0x0973, B:229:0x097b, B:230:0x097e, B:232:0x098b, B:234:0x0994, B:236:0x09ad, B:238:0x09b2, B:239:0x09d0, B:241:0x09f8, B:244:0x0a3e, B:246:0x0a44, B:249:0x0a52, B:251:0x0a70, B:255:0x0a7c, B:257:0x0a88, B:259:0x0a95, B:260:0x0a99, B:261:0x0a9e, B:263:0x0aa7, B:264:0x0ab0, B:266:0x0b0d, B:268:0x0b15, B:270:0x0b2c, B:254:0x0a77, B:206:0x0904, B:207:0x090a, B:154:0x0702, B:155:0x0710, B:104:0x04cd, B:56:0x02d5), top: B:275:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:211:0x0922  */
    /* JADX WARN: Code duplicated, block: B:214:0x0929 A[Catch: Exception -> 0x0b3f, TryCatch #0 {Exception -> 0x0b3f, blocks: (B:3:0x0004, B:5:0x006f, B:9:0x008b, B:11:0x0097, B:16:0x00dd, B:18:0x0177, B:19:0x0184, B:21:0x018a, B:24:0x019e, B:26:0x01a6, B:27:0x01af, B:29:0x01b5, B:32:0x01c5, B:34:0x01cd, B:35:0x01d4, B:37:0x01da, B:40:0x01e8, B:42:0x01f0, B:43:0x01f7, B:45:0x01fd, B:48:0x020b, B:50:0x0214, B:53:0x02c5, B:55:0x02cb, B:57:0x02e4, B:60:0x02f0, B:62:0x02f6, B:64:0x0300, B:65:0x0303, B:69:0x0320, B:71:0x03bc, B:72:0x03c9, B:74:0x03cf, B:77:0x03e3, B:79:0x03eb, B:80:0x03f4, B:82:0x03fa, B:85:0x040a, B:87:0x0412, B:88:0x0419, B:90:0x041f, B:93:0x042d, B:95:0x0435, B:96:0x043c, B:98:0x0442, B:101:0x0450, B:103:0x045b, B:105:0x04d8, B:108:0x04e2, B:110:0x04e8, B:112:0x04f2, B:113:0x04f5, B:117:0x050a, B:119:0x05ce, B:120:0x05d9, B:122:0x05df, B:125:0x05f1, B:127:0x05f9, B:128:0x0602, B:130:0x0608, B:133:0x0618, B:135:0x0620, B:136:0x0627, B:138:0x062d, B:141:0x063b, B:143:0x0643, B:144:0x064a, B:146:0x0650, B:149:0x065e, B:151:0x0669, B:153:0x0673, B:157:0x071d, B:160:0x072b, B:162:0x0731, B:164:0x073d, B:165:0x0740, B:169:0x076d, B:171:0x0805, B:172:0x080c, B:174:0x0812, B:177:0x0820, B:179:0x0828, B:180:0x082f, B:182:0x0835, B:185:0x0843, B:187:0x084b, B:188:0x0852, B:190:0x0858, B:193:0x0866, B:195:0x086e, B:196:0x0875, B:198:0x087b, B:201:0x0889, B:203:0x0896, B:205:0x08a0, B:209:0x0913, B:212:0x0923, B:214:0x0929, B:216:0x0933, B:217:0x0936, B:219:0x094f, B:221:0x0956, B:224:0x0963, B:226:0x0969, B:227:0x0973, B:229:0x097b, B:230:0x097e, B:232:0x098b, B:234:0x0994, B:236:0x09ad, B:238:0x09b2, B:239:0x09d0, B:241:0x09f8, B:244:0x0a3e, B:246:0x0a44, B:249:0x0a52, B:251:0x0a70, B:255:0x0a7c, B:257:0x0a88, B:259:0x0a95, B:260:0x0a99, B:261:0x0a9e, B:263:0x0aa7, B:264:0x0ab0, B:266:0x0b0d, B:268:0x0b15, B:270:0x0b2c, B:254:0x0a77, B:206:0x0904, B:207:0x090a, B:154:0x0702, B:155:0x0710, B:104:0x04cd, B:56:0x02d5), top: B:275:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:216:0x0933 A[Catch: Exception -> 0x0b3f, TryCatch #0 {Exception -> 0x0b3f, blocks: (B:3:0x0004, B:5:0x006f, B:9:0x008b, B:11:0x0097, B:16:0x00dd, B:18:0x0177, B:19:0x0184, B:21:0x018a, B:24:0x019e, B:26:0x01a6, B:27:0x01af, B:29:0x01b5, B:32:0x01c5, B:34:0x01cd, B:35:0x01d4, B:37:0x01da, B:40:0x01e8, B:42:0x01f0, B:43:0x01f7, B:45:0x01fd, B:48:0x020b, B:50:0x0214, B:53:0x02c5, B:55:0x02cb, B:57:0x02e4, B:60:0x02f0, B:62:0x02f6, B:64:0x0300, B:65:0x0303, B:69:0x0320, B:71:0x03bc, B:72:0x03c9, B:74:0x03cf, B:77:0x03e3, B:79:0x03eb, B:80:0x03f4, B:82:0x03fa, B:85:0x040a, B:87:0x0412, B:88:0x0419, B:90:0x041f, B:93:0x042d, B:95:0x0435, B:96:0x043c, B:98:0x0442, B:101:0x0450, B:103:0x045b, B:105:0x04d8, B:108:0x04e2, B:110:0x04e8, B:112:0x04f2, B:113:0x04f5, B:117:0x050a, B:119:0x05ce, B:120:0x05d9, B:122:0x05df, B:125:0x05f1, B:127:0x05f9, B:128:0x0602, B:130:0x0608, B:133:0x0618, B:135:0x0620, B:136:0x0627, B:138:0x062d, B:141:0x063b, B:143:0x0643, B:144:0x064a, B:146:0x0650, B:149:0x065e, B:151:0x0669, B:153:0x0673, B:157:0x071d, B:160:0x072b, B:162:0x0731, B:164:0x073d, B:165:0x0740, B:169:0x076d, B:171:0x0805, B:172:0x080c, B:174:0x0812, B:177:0x0820, B:179:0x0828, B:180:0x082f, B:182:0x0835, B:185:0x0843, B:187:0x084b, B:188:0x0852, B:190:0x0858, B:193:0x0866, B:195:0x086e, B:196:0x0875, B:198:0x087b, B:201:0x0889, B:203:0x0896, B:205:0x08a0, B:209:0x0913, B:212:0x0923, B:214:0x0929, B:216:0x0933, B:217:0x0936, B:219:0x094f, B:221:0x0956, B:224:0x0963, B:226:0x0969, B:227:0x0973, B:229:0x097b, B:230:0x097e, B:232:0x098b, B:234:0x0994, B:236:0x09ad, B:238:0x09b2, B:239:0x09d0, B:241:0x09f8, B:244:0x0a3e, B:246:0x0a44, B:249:0x0a52, B:251:0x0a70, B:255:0x0a7c, B:257:0x0a88, B:259:0x0a95, B:260:0x0a99, B:261:0x0a9e, B:263:0x0aa7, B:264:0x0ab0, B:266:0x0b0d, B:268:0x0b15, B:270:0x0b2c, B:254:0x0a77, B:206:0x0904, B:207:0x090a, B:154:0x0702, B:155:0x0710, B:104:0x04cd, B:56:0x02d5), top: B:275:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:298:0x0740 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:305:0x0936 A[SYNTHETIC] */
    private void q() {
        String str;
        String str2;
        String str3;
        String str4;
        JSONObject jSONObject;
        String str5;
        String str6;
        yq yqVar;
        String str7;
        String str8;
        String str9;
        JSONObject jSONObject2;
        String str10;
        mj mjVar;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        JSONObject jSONObject3;
        String str17;
        String str18;
        String str19;
        u6 u6Var;
        u6 u6Var2;
        String str20;
        String str21;
        String str22;
        JSONObject jSONObject4;
        String str23;
        String str24;
        JSONObject jSONObject5;
        String str25;
        String str26;
        rm rmVar;
        boolean zOptBoolean;
        String str27;
        JSONObject jSONObjectC;
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        o5 o5Var;
        o5 o5Var2;
        int i;
        cn cnVarF;
        int[] iArr5;
        int[] iArr6;
        int[] iArr7;
        int[] iArr8;
        o5 o5Var3;
        o5 o5Var4;
        u6 u6Var3;
        int i3;
        h7 h7VarD;
        int[] iArr9;
        int[] iArr10;
        int[] iArr11;
        int[] iArr12;
        o5 o5Var5;
        int[] iArr13;
        int[] iArr14;
        int[] iArr15;
        int[] iArr16;
        o5 o5Var6;
        try {
            JSONObject jSONObjectC2 = c(this.f, "configurations");
            JSONObject jSONObjectC3 = c(jSONObjectC2, b());
            JSONObject jSONObjectC4 = c(jSONObjectC2, "application");
            JSONObject jSONObjectC5 = c(jSONObjectC3, l());
            JSONObject jSONObjectC6 = c(jSONObjectC3, "interstitial");
            JSONObject jSONObjectC7 = c(jSONObjectC3, "banner");
            JSONObject jSONObjectC8 = c(jSONObjectC3, "nativeAd");
            JSONObject jSONObjectC9 = c(jSONObjectC4, "events");
            JSONObject jSONObjectC10 = c(jSONObjectC4, "loggers");
            JSONObject jSONObjectC11 = c(jSONObjectC4, "token");
            JSONObject jSONObjectC12 = c(jSONObjectC4, "segment");
            JSONObject jSONObjectC13 = c(jSONObjectC4, "auction");
            JSONObject jSONObjectC14 = c(jSONObjectC4, "crashReporter");
            JSONObject jSONObjectC15 = c(jSONObjectC4, "settings");
            JSONObject jSONObjectC16 = c(jSONObjectC4, "external");
            JSONObject jSONObjectC17 = c(jSONObjectC9, Z0);
            if (jSONObjectC4 != null) {
                IronSourceUtils.saveBooleanToSharedPrefs(this.g, "uuidEnabled", jSONObjectC4.optBoolean("uuidEnabled", true));
            }
            if (jSONObjectC9 != null) {
                String strOptString = jSONObjectC9.optString("abt");
                if (TextUtils.isEmpty(strOptString)) {
                    str = null;
                } else {
                    oj.i().a(strOptString);
                    ar.i().a(strOptString);
                    str = strOptString;
                }
            } else {
                str = null;
            }
            String str28 = D1;
            JSONObject jSONObject6 = jSONObjectC13;
            String str29 = "optIn";
            String str30 = "optOut";
            if (jSONObjectC5 != null) {
                JSONArray jSONArrayOptJSONArray = jSONObjectC5.optJSONArray("placements");
                JSONObject jSONObjectC18 = c(jSONObjectC5, "events");
                JSONObject jSONObjectD = d(jSONObjectC5, x0);
                long jOptLong = jSONObjectC5.optLong(w0, 3000L);
                boolean zOptBoolean2 = jSONObjectD.optBoolean(y0, false);
                boolean zOptBoolean3 = jSONObjectD.optBoolean(z0, false);
                boolean zOptBoolean4 = jSONObjectC5.optBoolean(A0, true);
                int iA = a(jSONObjectC5, jSONObjectC4, "parallelLoad", 2);
                boolean zA = a(jSONObjectC5, jSONObjectC4, "bidderExclusive", true);
                int iA2 = a(jSONObjectC5, jSONObjectC4, D0, 60);
                int iA3 = a(jSONObjectC5, jSONObjectC4, "expiredDurationInMinutes", -1);
                int iA4 = a(jSONObjectC5, jSONObjectC4, r1, 3);
                boolean zA2 = a(jSONObjectC5, jSONObjectC4, "isOneFlow", false);
                JSONObject jSONObjectMergeJsons = IronSourceUtils.mergeJsons(jSONObjectC18, jSONObjectC9);
                boolean zOptBoolean5 = jSONObjectMergeJsons.optBoolean("sendUltraEvents", false);
                boolean zOptBoolean6 = jSONObjectMergeJsons.optBoolean("sendEventsToggle", false);
                str5 = "eventsCompression";
                boolean zOptBoolean7 = jSONObjectMergeJsons.optBoolean(str5, false);
                int iOptInt = jSONObjectMergeJsons.optInt("eventsCompressionLevel", -1);
                String strOptString2 = jSONObjectMergeJsons.optString("serverEventsURL", "");
                String strOptString3 = jSONObjectMergeJsons.optString("serverEventsType", "");
                int iOptInt2 = jSONObjectMergeJsons.optInt("backupThreshold", -1);
                int iOptInt3 = jSONObjectMergeJsons.optInt("maxNumberOfEvents", -1);
                int iOptInt4 = jSONObjectMergeJsons.optInt("maxEventsPerBatch", 5000);
                str30 = str30;
                JSONArray jSONArrayOptJSONArray2 = jSONObjectMergeJsons.optJSONArray(str30);
                if (jSONArrayOptJSONArray2 != null) {
                    int[] iArr17 = new int[jSONArrayOptJSONArray2.length()];
                    for (int i4 = 0; i4 < jSONArrayOptJSONArray2.length(); i4++) {
                        iArr17[i4] = jSONArrayOptJSONArray2.optInt(i4);
                    }
                    iArr13 = iArr17;
                } else {
                    iArr13 = null;
                }
                str29 = str29;
                JSONArray jSONArrayOptJSONArray3 = jSONObjectMergeJsons.optJSONArray(str29);
                if (jSONArrayOptJSONArray3 != null) {
                    int[] iArr18 = new int[jSONArrayOptJSONArray3.length()];
                    for (int i5 = 0; i5 < jSONArrayOptJSONArray3.length(); i5++) {
                        iArr18[i5] = jSONArrayOptJSONArray3.optInt(i5);
                    }
                    iArr14 = iArr18;
                } else {
                    iArr14 = null;
                }
                JSONArray jSONArrayOptJSONArray4 = jSONObjectMergeJsons.optJSONArray("triggerEvents");
                if (jSONArrayOptJSONArray4 != null) {
                    int[] iArr19 = new int[jSONArrayOptJSONArray4.length()];
                    for (int i6 = 0; i6 < jSONArrayOptJSONArray4.length(); i6++) {
                        iArr19[i6] = jSONArrayOptJSONArray4.optInt(i6);
                    }
                    iArr15 = iArr19;
                } else {
                    iArr15 = null;
                }
                JSONArray jSONArrayOptJSONArray5 = jSONObjectMergeJsons.optJSONArray("nonConnectivityEvents");
                if (jSONArrayOptJSONArray5 != null) {
                    int[] iArr20 = new int[jSONArrayOptJSONArray5.length()];
                    for (int i7 = 0; i7 < jSONArrayOptJSONArray5.length(); i7++) {
                        iArr20[i7] = jSONArrayOptJSONArray5.optInt(i7);
                    }
                    iArr16 = iArr20;
                } else {
                    iArr16 = null;
                }
                h4 h4Var = new h4(zOptBoolean5, zOptBoolean6, zOptBoolean7, iOptInt, strOptString2, strOptString3, iOptInt2, iOptInt3, iOptInt4, iArr13, iArr14, iArr15, iArr16);
                if (jSONObject6 != null) {
                    JSONObject jSONObjectC19 = c(jSONObject6, l());
                    String strOptString4 = jSONObject6.optString(str28, "");
                    String strOptString5 = jSONObject6.optString(E1, "");
                    String strOptString6 = jSONObject6.optString(F1, "");
                    int iOptInt5 = jSONObject6.optInt("auctionTrials", 2);
                    long jOptLong2 = jSONObject6.optLong(N1, 10000L);
                    int iOptInt6 = jSONObject6.optInt(O1, 15);
                    boolean zOptBoolean8 = jSONObject6.optBoolean(S1, false);
                    boolean zOptBoolean9 = jSONObject6.optBoolean(T1, false);
                    int iOptInt7 = jSONObject6.optInt(U1, 1);
                    boolean zOptBoolean10 = jSONObject6.optBoolean(Q1, false);
                    int iOptInt8 = jSONObjectC19.optInt(H1, 2000);
                    int iOptInt9 = jSONObjectC19.optInt(K1, 30000);
                    int iOptInt10 = jSONObjectC19.optInt(I1, 5000);
                    str6 = "";
                    int iOptInt11 = jSONObjectC19.optInt(J1, 50);
                    str2 = r1;
                    boolean zOptBoolean11 = jSONObjectC19.optBoolean(G1, false);
                    boolean zOptBoolean12 = jSONObjectC19.optBoolean("isLoadWhileShow", true);
                    int iOptInt12 = jSONObjectC19.optInt(R1, 30000);
                    jSONObject = jSONObjectC4;
                    str3 = z0;
                    str4 = y0;
                    o5Var6 = new o5(strOptString4, strOptString5, strOptString6, iOptInt5, iOptInt6, jOptLong2, iOptInt8, iOptInt9, iOptInt10, iOptInt11, zOptBoolean12, iOptInt12, zOptBoolean8, zOptBoolean9, zOptBoolean11, iOptInt7, false, zOptBoolean10);
                    JSONArray jSONArrayOptJSONArray6 = jSONObjectC19.optJSONArray(P1);
                    if (jSONArrayOptJSONArray6 != null) {
                        str28 = str28;
                        jSONObject6 = jSONObject6;
                        for (int i8 = 0; i8 < jSONArrayOptJSONArray6.length(); i8++) {
                            o5Var6.a(jSONArrayOptJSONArray6.optString(i8));
                        }
                    }
                } else {
                    str2 = r1;
                    str3 = z0;
                    str4 = y0;
                    jSONObject = jSONObjectC4;
                    str6 = "";
                    o5Var6 = new o5();
                }
                str28 = str28;
                jSONObject6 = jSONObject6;
                yq yqVar2 = new yq(iA, zA, iA2, iA3, h4Var, o5Var6, iA4, zA2, jOptLong, zOptBoolean2, zOptBoolean3, zOptBoolean4);
                if (jSONArrayOptJSONArray != null) {
                    for (int i9 = 0; i9 < jSONArrayOptJSONArray.length(); i9++) {
                        Placement placementG = g(jSONArrayOptJSONArray.optJSONObject(i9));
                        if (placementG != null) {
                            yqVar2.a(placementG);
                        }
                    }
                }
                yqVar = yqVar2;
            } else {
                str2 = r1;
                str3 = z0;
                str4 = y0;
                jSONObject = jSONObjectC4;
                str5 = "eventsCompression";
                jSONObjectC9 = jSONObjectC9;
                str6 = "";
                yqVar = null;
            }
            if (jSONObjectC6 != null) {
                str8 = "placements";
                JSONArray jSONArrayOptJSONArray7 = jSONObjectC6.optJSONArray(str8);
                str9 = "events";
                JSONObject jSONObjectC20 = c(jSONObjectC6, str9);
                JSONObject jSONObjectD2 = d(jSONObjectC6, x0);
                long jOptLong3 = jSONObjectC6.optLong(w0, 3000L);
                str10 = str4;
                boolean zOptBoolean13 = jSONObjectD2.optBoolean(str10, false);
                str3 = str3;
                boolean zOptBoolean14 = jSONObjectD2.optBoolean(str3, false);
                boolean zOptBoolean15 = jSONObjectC6.optBoolean(A0, true);
                jSONObject2 = jSONObject;
                int iA5 = a(jSONObjectC6, jSONObject2, "parallelLoad", 2);
                boolean zA3 = a(jSONObjectC6, jSONObject2, "bidderExclusive", false);
                int iA6 = a(jSONObjectC6, jSONObject2, D0, 60);
                String str31 = str2;
                int iA7 = a(jSONObjectC6, jSONObject2, str31, 3);
                str2 = str31;
                boolean zA4 = a(jSONObjectC6, jSONObject2, "isOneFlow", false);
                JSONObject jSONObject7 = jSONObjectC9;
                JSONObject jSONObjectMergeJsons2 = IronSourceUtils.mergeJsons(jSONObjectC20, jSONObject7);
                boolean zOptBoolean16 = jSONObjectMergeJsons2.optBoolean("sendEventsToggle", false);
                String str32 = str5;
                boolean zOptBoolean17 = jSONObjectMergeJsons2.optBoolean(str32, false);
                str5 = str32;
                str11 = "eventsCompressionLevel";
                int iOptInt13 = jSONObjectMergeJsons2.optInt(str11, -1);
                str6 = str6;
                String strOptString7 = jSONObjectMergeJsons2.optString("serverEventsURL", str6);
                String strOptString8 = jSONObjectMergeJsons2.optString("serverEventsType", str6);
                jSONObjectC9 = jSONObject7;
                int iOptInt14 = jSONObjectMergeJsons2.optInt("backupThreshold", -1);
                int iOptInt15 = jSONObjectMergeJsons2.optInt("maxNumberOfEvents", -1);
                int iOptInt16 = jSONObjectMergeJsons2.optInt("maxEventsPerBatch", 5000);
                str30 = str30;
                JSONArray jSONArrayOptJSONArray8 = jSONObjectMergeJsons2.optJSONArray(str30);
                if (jSONArrayOptJSONArray8 != null) {
                    int[] iArr21 = new int[jSONArrayOptJSONArray8.length()];
                    for (int i10 = 0; i10 < jSONArrayOptJSONArray8.length(); i10++) {
                        iArr21[i10] = jSONArrayOptJSONArray8.optInt(i10);
                    }
                    iArr9 = iArr21;
                } else {
                    iArr9 = null;
                }
                str29 = str29;
                JSONArray jSONArrayOptJSONArray9 = jSONObjectMergeJsons2.optJSONArray(str29);
                if (jSONArrayOptJSONArray9 != null) {
                    int[] iArr22 = new int[jSONArrayOptJSONArray9.length()];
                    for (int i11 = 0; i11 < jSONArrayOptJSONArray9.length(); i11++) {
                        iArr22[i11] = jSONArrayOptJSONArray9.optInt(i11);
                    }
                    iArr10 = iArr22;
                } else {
                    iArr10 = null;
                }
                JSONArray jSONArrayOptJSONArray10 = jSONObjectMergeJsons2.optJSONArray("triggerEvents");
                if (jSONArrayOptJSONArray10 != null) {
                    int[] iArr23 = new int[jSONArrayOptJSONArray10.length()];
                    for (int i12 = 0; i12 < jSONArrayOptJSONArray10.length(); i12++) {
                        iArr23[i12] = jSONArrayOptJSONArray10.optInt(i12);
                    }
                    iArr11 = iArr23;
                } else {
                    iArr11 = null;
                }
                JSONArray jSONArrayOptJSONArray11 = jSONObjectMergeJsons2.optJSONArray("nonConnectivityEvents");
                if (jSONArrayOptJSONArray11 != null) {
                    int[] iArr24 = new int[jSONArrayOptJSONArray11.length()];
                    for (int i13 = 0; i13 < jSONArrayOptJSONArray11.length(); i13++) {
                        iArr24[i13] = jSONArrayOptJSONArray11.optInt(i13);
                    }
                    iArr12 = iArr24;
                } else {
                    iArr12 = null;
                }
                h4 h4Var2 = new h4(false, zOptBoolean16, zOptBoolean17, iOptInt13, strOptString7, strOptString8, iOptInt14, iOptInt15, iOptInt16, iArr9, iArr10, iArr11, iArr12);
                if (jSONObject6 != null) {
                    JSONObject jSONObject8 = jSONObject6;
                    str7 = str28;
                    jSONObject6 = jSONObject8;
                    o5Var5 = new o5(jSONObject8.optString(str7, str6), jSONObject8.optString(E1, str6), jSONObject8.optString(F1, str6), jSONObject8.optInt("auctionTrials", 2), jSONObject8.optInt(O1, 15), jSONObject8.optLong(N1, 10000L), c(jSONObject8, "interstitial").optInt(H1, 2000), 0L, 0L, 0L, true, 0, jSONObject8.optBoolean(S1, false), jSONObject8.optBoolean(T1, false), true, jSONObject8.optInt(U1, 1), false, jSONObject8.optBoolean(Q1, false));
                } else {
                    str7 = str28;
                    o5Var5 = new o5();
                }
                mj mjVar2 = new mj(iA5, zA3, iA6, h4Var2, o5Var5, iA7, zA4, jOptLong3, zOptBoolean13, zOptBoolean14, zOptBoolean15);
                if (jSONArrayOptJSONArray7 != null) {
                    for (int i14 = 0; i14 < jSONArrayOptJSONArray7.length(); i14++) {
                        InterstitialPlacement interstitialPlacementE = e(jSONArrayOptJSONArray7.optJSONObject(i14));
                        if (interstitialPlacementE != null) {
                            mjVar2.a(interstitialPlacementE);
                        }
                    }
                }
                mjVar = mjVar2;
            } else {
                str7 = str28;
                str8 = r12;
                str9 = r8;
                jSONObject2 = jSONObject;
                str10 = str4;
                mjVar = null;
            }
            if (jSONObjectC7 != null) {
                JSONArray jSONArrayOptJSONArray12 = jSONObjectC7.optJSONArray(str8);
                JSONObject jSONObjectC21 = c(jSONObjectC7, str9);
                JSONObject jSONObjectD3 = d(jSONObjectC7, x0);
                str19 = str3;
                str12 = str7;
                str13 = A0;
                JSONArray jSONArray = jSONArrayOptJSONArray12;
                jSONObject3 = jSONObjectC9;
                long jA = a(jSONObjectC7, jSONObject2, E0, 10000L);
                str18 = str2;
                int iA8 = a(jSONObjectC7, jSONObject2, str18, 3);
                int iOptInt17 = jSONObjectC7.optInt("bannerInterval", 60);
                long jOptLong4 = jSONObjectC7.optLong(W1, 15000L);
                boolean zA5 = a(jSONObjectC7, jSONObject2, "isOneFlow", false);
                long jOptLong5 = jSONObjectC7.optLong(w0, 3000L);
                boolean zOptBoolean18 = jSONObjectD3.optBoolean(str10, false);
                boolean zOptBoolean19 = jSONObjectD3.optBoolean(str19, false);
                boolean zOptBoolean20 = jSONObjectC7.optBoolean(str13, true);
                JSONObject jSONObjectMergeJsons3 = IronSourceUtils.mergeJsons(jSONObjectC21, jSONObject3);
                boolean zOptBoolean21 = jSONObjectMergeJsons3.optBoolean("sendEventsToggle", false);
                str16 = str5;
                boolean zOptBoolean22 = jSONObjectMergeJsons3.optBoolean(str16, false);
                str15 = str11;
                int iOptInt18 = jSONObjectMergeJsons3.optInt(str15, -1);
                str17 = str6;
                String strOptString9 = jSONObjectMergeJsons3.optString("serverEventsURL", str17);
                String strOptString10 = jSONObjectMergeJsons3.optString("serverEventsType", str17);
                int iOptInt19 = jSONObjectMergeJsons3.optInt("backupThreshold", -1);
                int iOptInt20 = jSONObjectMergeJsons3.optInt("maxNumberOfEvents", -1);
                int iOptInt21 = jSONObjectMergeJsons3.optInt("maxEventsPerBatch", 5000);
                str14 = str30;
                JSONArray jSONArrayOptJSONArray13 = jSONObjectMergeJsons3.optJSONArray(str14);
                if (jSONArrayOptJSONArray13 != null) {
                    int[] iArr25 = new int[jSONArrayOptJSONArray13.length()];
                    for (int i15 = 0; i15 < jSONArrayOptJSONArray13.length(); i15++) {
                        iArr25[i15] = jSONArrayOptJSONArray13.optInt(i15);
                    }
                    iArr5 = iArr25;
                } else {
                    iArr5 = null;
                }
                str29 = str29;
                JSONArray jSONArrayOptJSONArray14 = jSONObjectMergeJsons3.optJSONArray(str29);
                if (jSONArrayOptJSONArray14 != null) {
                    int[] iArr26 = new int[jSONArrayOptJSONArray14.length()];
                    for (int i16 = 0; i16 < jSONArrayOptJSONArray14.length(); i16++) {
                        iArr26[i16] = jSONArrayOptJSONArray14.optInt(i16);
                    }
                    iArr6 = iArr26;
                } else {
                    iArr6 = null;
                }
                JSONArray jSONArrayOptJSONArray15 = jSONObjectMergeJsons3.optJSONArray("triggerEvents");
                if (jSONArrayOptJSONArray15 != null) {
                    int[] iArr27 = new int[jSONArrayOptJSONArray15.length()];
                    for (int i17 = 0; i17 < jSONArrayOptJSONArray15.length(); i17++) {
                        iArr27[i17] = jSONArrayOptJSONArray15.optInt(i17);
                    }
                    iArr7 = iArr27;
                } else {
                    iArr7 = null;
                }
                JSONArray jSONArrayOptJSONArray16 = jSONObjectMergeJsons3.optJSONArray("nonConnectivityEvents");
                if (jSONArrayOptJSONArray16 != null) {
                    int[] iArr28 = new int[jSONArrayOptJSONArray16.length()];
                    for (int i18 = 0; i18 < jSONArrayOptJSONArray16.length(); i18++) {
                        iArr28[i18] = jSONArrayOptJSONArray16.optInt(i18);
                    }
                    iArr8 = iArr28;
                } else {
                    iArr8 = null;
                }
                h4 h4Var3 = new h4(false, zOptBoolean21, zOptBoolean22, iOptInt18, strOptString9, strOptString10, iOptInt19, iOptInt20, iOptInt21, iArr5, iArr6, iArr7, iArr8);
                if (jSONObject6 != null) {
                    JSONObject jSONObject9 = jSONObject6;
                    JSONObject jSONObjectC22 = c(jSONObject9, "banner");
                    if (jSONObjectC22 != null) {
                        str17 = str17;
                        jSONObject6 = jSONObject9;
                        str12 = str12;
                        str29 = str29;
                        jSONObject3 = jSONObject3;
                        o5Var4 = new o5(jSONObject9.optString(str12, str17), jSONObject9.optString(E1, str17), jSONObject9.optString(F1, str17), jSONObject9.optInt("auctionTrials", 2), jSONObject9.optInt(O1, 15), jSONObject9.optLong(N1, 10000L), jSONObjectC22.optInt(H1, 2000), jSONObjectC22.optInt(K1, 15000), jSONObjectC22.optInt(I1, 50), 0L, jSONObjectC22.optBoolean("isLoadWhileShow", false), 0, jSONObject9.optBoolean(S1, false), jSONObject9.optBoolean(T1, false), jSONObjectC22.optBoolean(G1, true), jSONObject9.optInt(U1, 1), jSONObjectC22.optBoolean(V1, true), jSONObject9.optBoolean(Q1, false));
                    } else {
                        jSONObject6 = jSONObject9;
                        o5Var3 = new o5();
                    }
                    u6Var3 = new u6(1, jA, false, h4Var3, iOptInt17, o5Var4, iA8, zA5, jOptLong5, zOptBoolean18, zOptBoolean19, zOptBoolean20, jOptLong4);
                    if (jSONArray != null) {
                        i3 = 0;
                        while (i3 < jSONArray.length()) {
                            JSONArray jSONArray2 = jSONArray;
                            h7VarD = d(jSONArray2.optJSONObject(i3));
                            if (h7VarD != null) {
                                u6Var3.a(h7VarD);
                            }
                            i3++;
                            jSONArray = jSONArray2;
                        }
                    }
                    u6Var = u6Var3;
                } else {
                    o5Var3 = new o5();
                }
                o5Var4 = o5Var3;
                u6Var3 = new u6(1, jA, false, h4Var3, iOptInt17, o5Var4, iA8, zA5, jOptLong5, zOptBoolean18, zOptBoolean19, zOptBoolean20, jOptLong4);
                if (jSONArray != null) {
                    i3 = 0;
                    while (i3 < jSONArray.length()) {
                        JSONArray jSONArray3 = jSONArray;
                        h7VarD = d(jSONArray3.optJSONObject(i3));
                        if (h7VarD != null) {
                            u6Var3.a(h7VarD);
                        }
                        i3++;
                        jSONArray = jSONArray3;
                    }
                }
                u6Var = u6Var3;
            } else {
                str12 = str7;
                str13 = r5;
                str14 = str30;
                str15 = str11;
                str16 = str5;
                jSONObject3 = jSONObjectC9;
                str17 = str6;
                str18 = str2;
                str19 = str3;
                u6Var = null;
            }
            if (jSONObjectC8 != null) {
                JSONArray jSONArrayOptJSONArray17 = jSONObjectC8.optJSONArray(str8);
                String str33 = str9;
                JSONObject jSONObjectC23 = c(jSONObjectC8, str33);
                JSONObject jSONObjectD4 = d(jSONObjectC8, x0);
                u6Var2 = u6Var;
                str24 = str33;
                String str34 = str12;
                JSONObject jSONObject10 = jSONObject6;
                long jA2 = a(jSONObjectC8, jSONObject2, E0, 10000L);
                int iA9 = a(jSONObjectC8, jSONObject2, str18, 0);
                long jOptLong6 = jSONObjectC8.optLong(w0, 3000L);
                boolean zOptBoolean23 = jSONObjectD4.optBoolean(str10, false);
                boolean zOptBoolean24 = jSONObjectD4.optBoolean(str19, false);
                boolean zOptBoolean25 = jSONObjectC8.optBoolean(str13, true);
                jSONObject5 = jSONObject3;
                JSONObject jSONObjectMergeJsons4 = IronSourceUtils.mergeJsons(jSONObjectC23, jSONObject5);
                boolean zOptBoolean26 = jSONObjectMergeJsons4.optBoolean("sendEventsToggle", false);
                str20 = str16;
                boolean zOptBoolean27 = jSONObjectMergeJsons4.optBoolean(str20, false);
                str25 = str15;
                int iOptInt22 = jSONObjectMergeJsons4.optInt(str25, -1);
                str26 = str17;
                String strOptString11 = jSONObjectMergeJsons4.optString("serverEventsURL", str26);
                String strOptString12 = jSONObjectMergeJsons4.optString("serverEventsType", str26);
                int iOptInt23 = jSONObjectMergeJsons4.optInt("backupThreshold", -1);
                int iOptInt24 = jSONObjectMergeJsons4.optInt("maxNumberOfEvents", -1);
                int iOptInt25 = jSONObjectMergeJsons4.optInt("maxEventsPerBatch", 5000);
                str21 = str14;
                JSONArray jSONArrayOptJSONArray18 = jSONObjectMergeJsons4.optJSONArray(str21);
                if (jSONArrayOptJSONArray18 != null) {
                    int[] iArr29 = new int[jSONArrayOptJSONArray18.length()];
                    for (int i19 = 0; i19 < jSONArrayOptJSONArray18.length(); i19++) {
                        iArr29[i19] = jSONArrayOptJSONArray18.optInt(i19);
                    }
                    iArr = iArr29;
                } else {
                    iArr = null;
                }
                str23 = str29;
                JSONArray jSONArrayOptJSONArray19 = jSONObjectMergeJsons4.optJSONArray(str23);
                if (jSONArrayOptJSONArray19 != null) {
                    int[] iArr30 = new int[jSONArrayOptJSONArray19.length()];
                    for (int i20 = 0; i20 < jSONArrayOptJSONArray19.length(); i20++) {
                        iArr30[i20] = jSONArrayOptJSONArray19.optInt(i20);
                    }
                    iArr2 = iArr30;
                } else {
                    iArr2 = null;
                }
                JSONArray jSONArrayOptJSONArray20 = jSONObjectMergeJsons4.optJSONArray("triggerEvents");
                if (jSONArrayOptJSONArray20 != null) {
                    int[] iArr31 = new int[jSONArrayOptJSONArray20.length()];
                    for (int i21 = 0; i21 < jSONArrayOptJSONArray20.length(); i21++) {
                        iArr31[i21] = jSONArrayOptJSONArray20.optInt(i21);
                    }
                    iArr3 = iArr31;
                } else {
                    iArr3 = null;
                }
                JSONArray jSONArrayOptJSONArray21 = jSONObjectMergeJsons4.optJSONArray("nonConnectivityEvents");
                if (jSONArrayOptJSONArray21 != null) {
                    int[] iArr32 = new int[jSONArrayOptJSONArray21.length()];
                    for (int i22 = 0; i22 < jSONArrayOptJSONArray21.length(); i22++) {
                        iArr32[i22] = jSONArrayOptJSONArray21.optInt(i22);
                    }
                    iArr4 = iArr32;
                } else {
                    iArr4 = null;
                }
                h4 h4Var4 = new h4(false, zOptBoolean26, zOptBoolean27, iOptInt22, strOptString11, strOptString12, iOptInt23, iOptInt24, iOptInt25, iArr, iArr2, iArr3, iArr4);
                jSONObject4 = jSONObject10;
                if (jSONObject4 != null) {
                    JSONObject jSONObjectC24 = c(jSONObject4, "nativeAd");
                    str22 = str34;
                    if (jSONObjectC24 != null) {
                        o5Var2 = new o5(jSONObject4.optString(str22, str26), jSONObject4.optString(E1, str26), jSONObject4.optString(F1, str26), jSONObject4.optInt("auctionTrials", 2), jSONObject4.optInt(O1, 15), jSONObject4.optLong(N1, 10000L), jSONObjectC24.optInt(H1, 2000), 0L, 0L, 0L, true, 0, jSONObject4.optBoolean(S1, false), jSONObject4.optBoolean(T1, false), true, jSONObject4.optInt(U1, 1), false, jSONObject4.optBoolean(Q1, false));
                    } else {
                        o5Var = new o5();
                    }
                    rmVar = new rm(1, jA2, false, h4Var4, o5Var2, iA9, jOptLong6, zOptBoolean23, zOptBoolean24, zOptBoolean25);
                    if (jSONArrayOptJSONArray17 != null) {
                        for (i = 0; i < jSONArrayOptJSONArray17.length(); i++) {
                            cnVarF = f(jSONArrayOptJSONArray17.optJSONObject(i));
                            if (cnVarF != null) {
                                rmVar.a(cnVarF);
                            }
                        }
                    }
                } else {
                    str22 = str34;
                    o5Var = new o5();
                }
                o5Var2 = o5Var;
                rmVar = new rm(1, jA2, false, h4Var4, o5Var2, iA9, jOptLong6, zOptBoolean23, zOptBoolean24, zOptBoolean25);
                if (jSONArrayOptJSONArray17 != null) {
                    while (i < jSONArrayOptJSONArray17.length()) {
                        cnVarF = f(jSONArrayOptJSONArray17.optJSONObject(i));
                        if (cnVarF != null) {
                            rmVar.a(cnVarF);
                        }
                    }
                }
            } else {
                u6Var2 = u6Var;
                str20 = str16;
                str21 = str14;
                str22 = str12;
                jSONObject4 = jSONObject6;
                str23 = str29;
                str24 = str9;
                jSONObject5 = jSONObject3;
                str25 = str15;
                str26 = str17;
                rmVar = null;
            }
            dv dvVar = new dv();
            if (jSONObjectC11 != null) {
                JSONArray jSONArrayOptJSONArray22 = jSONObjectC11.optJSONArray(X1);
                if (jSONArrayOptJSONArray22 != null) {
                    for (int i23 = 0; i23 < jSONArrayOptJSONArray22.length(); i23++) {
                        dvVar.a(jSONArrayOptJSONArray22.optString(i23));
                    }
                }
                JSONObject jSONObjectOptJSONObject = jSONObjectC11.optJSONObject(Y1);
                if (jSONObjectOptJSONObject != null) {
                    dvVar.a(jSONObjectOptJSONObject);
                }
                dvVar.a(jSONObjectC11.optBoolean(Z1, true));
            }
            jp jpVar = new jp();
            if (jSONObjectC17 != null) {
                String strOptString13 = jSONObjectC17.optString(a1, kp.f3842a);
                zOptBoolean = jSONObjectC17.optBoolean(b1, true);
                jpVar.a(strOptString13);
            } else {
                zOptBoolean = true;
            }
            jpVar.b(zOptBoolean);
            if (zOptBoolean) {
                jpVar.b(a(jSONObject5, str21));
                jpVar.a(a(jSONObject5, str23));
                jpVar.a(jSONObject5.optBoolean(str20, false));
                jpVar.a(jSONObject5.optInt(str25, -1));
            }
            o4 o4Var = new o4(jSONObjectC10.optInt("server", 3), jSONObjectC10.optInt("publisher", 3), jSONObjectC10.optInt("console", 3), jSONObjectC10.optBoolean("shouldSendPublisherLogsOnUIThread", false));
            e4 e4Var = new e4();
            if (jSONObjectC14 != 0) {
                e4Var.a(jSONObjectC14.optBoolean("enabled", false));
                e4Var.c(jSONObjectC14.optString("reporterURL", str26));
                e4Var.b(jSONObjectC14.optString("reporterKeyword", str26));
                e4Var.c(jSONObjectC14.optBoolean("includeANR", false));
                e4Var.a(jSONObjectC14.optInt("timeout", 5000));
                e4Var.b(jSONObjectC14.optBoolean("setIgnoreDebugger", false));
                JSONArray jSONArrayOptJSONArray23 = jSONObjectC14.optJSONArray("keysToInclude");
                if (jSONArrayOptJSONArray23 != null) {
                    for (int i24 = 0; i24 < jSONArrayOptJSONArray23.length(); i24++) {
                        e4Var.a(jSONArrayOptJSONArray23.optString(i24));
                    }
                }
            }
            ms msVar = jSONObjectC12 != null ? new ms(jSONObjectC12.optString("name", str26), jSONObjectC12.optString("id", "-1"), jSONObjectC12.optJSONObject("custom")) : null;
            if (jSONObjectC15 == null) {
                jSONObjectC15 = IronSourceNetworkBridge.jsonObjectInit();
            }
            k4 k4Var = new k4(jSONObjectC15);
            j4 j4Var = new j4();
            if (jSONObjectC16 != null) {
                JSONObject jSONObjectOptJSONObject2 = jSONObjectC16.optJSONObject(p0);
                Map map = new HashMap();
                if (jSONObjectOptJSONObject2 != null) {
                    map = IronSourceUtils.parseJsonToStringMap(jSONObjectOptJSONObject2);
                }
                j4Var = new j4(map);
            }
            j4 j4Var2 = j4Var;
            y3 y3Var = new y3();
            if (jSONObject4 != null) {
                y3Var = new y3(jSONObject4.optString(str22));
            }
            a4 a4Var = new a4(o4Var, msVar, dvVar, jSONObject2.optBoolean("integration", false), e4Var, k4Var, j4Var2, jpVar, y3Var, str);
            pu puVarH = h(jSONObjectC2);
            g1 g1VarC = c(jSONObjectC2);
            s8.a aVar = new s8.a();
            aVar.a(yqVar);
            aVar.a(mjVar);
            aVar.a(u6Var2);
            aVar.a(rmVar);
            aVar.a(a4Var);
            aVar.b(puVarH);
            aVar.a(g1VarC);
            s8 s8VarA = aVar.a();
            this.c = s8VarA;
            IronLog.INTERNAL.verbose(s8VarA.toString());
            JSONObject jSONObjectC25 = c(jSONObject5, "genericParams");
            if (jSONObjectC25 != null && (jSONObjectC = c(jSONObjectC25, (str27 = str24))) != null) {
                jSONObjectC25.remove(str27);
                Map<String, String> jsonToStringMap = IronSourceUtils.parseJsonToStringMap(jSONObjectC);
                ar.i().b(jsonToStringMap);
                oj.i().b(jsonToStringMap);
            }
            if (jSONObjectC25 != null) {
                Map<String, String> jsonToStringMap2 = IronSourceUtils.parseJsonToStringMap(jSONObjectC25);
                ar.i().a(jsonToStringMap2);
                oj.i().a(jsonToStringMap2);
            }
        } catch (Exception e) {
            o9.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    private void r() {
        try {
            JSONObject jSONObjectC = c(this.f, "providerOrder");
            JSONArray jSONArrayB = b(jSONObjectC, l());
            JSONArray jSONArrayB2 = b(jSONObjectC, "interstitial");
            JSONArray jSONArrayB3 = b(jSONObjectC, "banner");
            JSONArray jSONArrayB4 = b(jSONObjectC, "nativeAd");
            this.f3876a = new aq();
            if (jSONArrayB != null && c() != null && c().getRewardedVideoConfigurations() != null) {
                for (int i = 0; i < jSONArrayB.length(); i++) {
                    String strOptString = jSONArrayB.optString(i);
                    this.f3876a.d(strOptString);
                    NetworkSettings networkSettingsB = cq.c().b(strOptString);
                    if (networkSettingsB != null) {
                        networkSettingsB.setRewardedVideoPriority(i);
                    }
                }
            }
            if (jSONArrayB2 != null && c() != null && c().getInterstitialConfigurations() != null) {
                for (int i3 = 0; i3 < jSONArrayB2.length(); i3++) {
                    String strOptString2 = jSONArrayB2.optString(i3);
                    this.f3876a.b(strOptString2);
                    NetworkSettings networkSettingsB2 = cq.c().b(strOptString2);
                    if (networkSettingsB2 != null) {
                        networkSettingsB2.setInterstitialPriority(i3);
                    }
                }
            }
            if (jSONArrayB3 != null) {
                for (int i4 = 0; i4 < jSONArrayB3.length(); i4++) {
                    String strOptString3 = jSONArrayB3.optString(i4);
                    this.f3876a.a(strOptString3);
                    NetworkSettings networkSettingsB3 = cq.c().b(strOptString3);
                    if (networkSettingsB3 != null) {
                        networkSettingsB3.setBannerPriority(i4);
                    }
                }
            }
            if (jSONArrayB4 != null) {
                for (int i5 = 0; i5 < jSONArrayB4.length(); i5++) {
                    String strOptString4 = jSONArrayB4.optString(i5);
                    this.f3876a.c(strOptString4);
                    NetworkSettings networkSettingsB4 = cq.c().b(strOptString4);
                    if (networkSettingsB4 != null) {
                        networkSettingsB4.setNativeAdPriority(i5);
                    }
                }
            }
        } catch (Exception e) {
            o9.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    private void s() {
        ls lsVar;
        NetworkSettings networkSettings;
        ls lsVar2 = this;
        try {
            lsVar2.b = cq.c();
            JSONObject jSONObjectC = lsVar2.c(lsVar2.f, "providerSettings");
            Iterator<String> itKeys = jSONObjectC.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                JSONObject jSONObjectOptJSONObject = jSONObjectC.optJSONObject(next);
                if (jSONObjectOptJSONObject != null) {
                    boolean zOptBoolean = jSONObjectOptJSONObject.optBoolean("mpis", false);
                    String strOptString = jSONObjectOptJSONObject.optString("spId", "0");
                    String strOptString2 = jSONObjectOptJSONObject.optString("adSourceName", null);
                    String strOptString3 = jSONObjectOptJSONObject.optString("providerNetworkKey", null);
                    String strOptString4 = jSONObjectOptJSONObject.optString("providerLoadName", next);
                    String strOptString5 = jSONObjectOptJSONObject.optString("providerDefaultInstance", strOptString4);
                    JSONObject jSONObjectC2 = lsVar2.c(jSONObjectOptJSONObject, b());
                    JSONObject jSONObjectC3 = lsVar2.c(jSONObjectOptJSONObject, "application");
                    JSONObject jSONObjectC4 = lsVar2.c(jSONObjectC2, l());
                    JSONObject jSONObjectC5 = lsVar2.c(jSONObjectC2, "interstitial");
                    JSONObject jSONObjectC6 = lsVar2.c(jSONObjectC2, "banner");
                    JSONObject jSONObjectC7 = lsVar2.c(jSONObjectC2, "nativeAd");
                    JSONObject jSONObjectMergeJsons = IronSourceUtils.mergeJsons(jSONObjectC4, jSONObjectC3);
                    JSONObject jSONObjectMergeJsons2 = IronSourceUtils.mergeJsons(jSONObjectC5, jSONObjectC3);
                    JSONObject jSONObjectMergeJsons3 = IronSourceUtils.mergeJsons(jSONObjectC6, jSONObjectC3);
                    JSONObject jSONObjectMergeJsons4 = IronSourceUtils.mergeJsons(jSONObjectC7, jSONObjectC3);
                    if (lsVar2.b.a(next)) {
                        ar.i().a(new zb(IronSourceConstants.TROUBLESHOOTING_MERGE_LOCAL_SETTINGS, null));
                        NetworkSettings networkSettingsB = lsVar2.b.b(next);
                        JSONObject rewardedVideoSettings = networkSettingsB.getRewardedVideoSettings();
                        JSONObject interstitialSettings = networkSettingsB.getInterstitialSettings();
                        JSONObject bannerSettings = networkSettingsB.getBannerSettings();
                        JSONObject nativeAdSettings = networkSettingsB.getNativeAdSettings();
                        networkSettingsB.setRewardedVideoSettings(IronSourceUtils.mergeJsons(rewardedVideoSettings, jSONObjectMergeJsons));
                        networkSettingsB.setInterstitialSettings(IronSourceUtils.mergeJsons(interstitialSettings, jSONObjectMergeJsons2));
                        networkSettingsB.setBannerSettings(IronSourceUtils.mergeJsons(bannerSettings, jSONObjectMergeJsons3));
                        networkSettingsB.setNativeAdSettings(IronSourceUtils.mergeJsons(nativeAdSettings, jSONObjectMergeJsons4));
                        networkSettingsB.setIsMultipleInstances(zOptBoolean);
                        networkSettingsB.setSubProviderId(strOptString);
                        networkSettingsB.setAdSourceNameForEvents(strOptString2);
                        networkSettingsB.setProviderNetworkKey(strOptString3);
                    } else {
                        if (lsVar2.b(strOptString4)) {
                            NetworkSettings networkSettingsB2 = lsVar2.b.b("Mediation");
                            JSONObject rewardedVideoSettings2 = networkSettingsB2.getRewardedVideoSettings();
                            JSONObject interstitialSettings2 = networkSettingsB2.getInterstitialSettings();
                            JSONObject bannerSettings2 = networkSettingsB2.getBannerSettings();
                            JSONObject nativeAdSettings2 = networkSettingsB2.getNativeAdSettings();
                            JSONObject jSONObjectJsonObjectInit = IronSourceNetworkBridge.jsonObjectInit(rewardedVideoSettings2.toString());
                            JSONObject jSONObjectJsonObjectInit2 = IronSourceNetworkBridge.jsonObjectInit(interstitialSettings2.toString());
                            try {
                                networkSettings = new NetworkSettings(next, strOptString4, strOptString5, strOptString3, jSONObjectC3, IronSourceUtils.mergeJsons(jSONObjectJsonObjectInit, jSONObjectMergeJsons), IronSourceUtils.mergeJsons(jSONObjectJsonObjectInit2, jSONObjectMergeJsons2), IronSourceUtils.mergeJsons(IronSourceNetworkBridge.jsonObjectInit(bannerSettings2.toString()), jSONObjectMergeJsons3), IronSourceUtils.mergeJsons(IronSourceNetworkBridge.jsonObjectInit(nativeAdSettings2.toString()), jSONObjectMergeJsons4));
                                networkSettings.setIsMultipleInstances(zOptBoolean);
                                networkSettings.setSubProviderId(strOptString);
                                networkSettings.setAdSourceNameForEvents(strOptString2);
                                lsVar = this;
                            } catch (Exception e) {
                                e = e;
                                o9.d().a(e);
                                IronLog.INTERNAL.error(e.toString());
                                return;
                            }
                        } else {
                            lsVar = lsVar2;
                            networkSettings = new NetworkSettings(next, strOptString4, strOptString5, strOptString3, jSONObjectC3, jSONObjectMergeJsons, jSONObjectMergeJsons2, jSONObjectMergeJsons3, jSONObjectMergeJsons4);
                            networkSettings.setIsMultipleInstances(zOptBoolean);
                            networkSettings.setSubProviderId(strOptString);
                            networkSettings.setAdSourceNameForEvents(strOptString2);
                        }
                        try {
                            lsVar.b.a(networkSettings);
                            lsVar2 = lsVar;
                            jSONObjectC = jSONObjectC;
                            itKeys = itKeys;
                        } catch (Exception e3) {
                            e = e3;
                            o9.d().a(e);
                            IronLog.INTERNAL.error(e.toString());
                            return;
                        }
                    }
                }
            }
            lsVar2.b.b();
        } catch (Exception e4) {
            e = e4;
        }
    }

    public void a(a aVar) {
        this.h = aVar;
    }

    public s8 c() {
        return this.c;
    }

    public mc e() {
        return this.k;
    }

    public li f() {
        return new li(this.d, this.e);
    }

    public List<IronSource.AD_UNIT> g() {
        aq aqVar;
        aq aqVar2;
        aq aqVar3;
        aq aqVar4;
        if (this.f == null || this.c == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.c.getRewardedVideoConfigurations() != null && (aqVar4 = this.f3876a) != null && !aqVar4.d().isEmpty()) {
            arrayList.add(IronSource.AD_UNIT.REWARDED_VIDEO);
        }
        if (this.c.getInterstitialConfigurations() != null && (aqVar3 = this.f3876a) != null && !aqVar3.b().isEmpty()) {
            arrayList.add(IronSource.AD_UNIT.INTERSTITIAL);
        }
        if (this.c.getBannerConfigurations() != null && (aqVar2 = this.f3876a) != null && !aqVar2.a().isEmpty()) {
            arrayList.add(IronSource.AD_UNIT.BANNER);
        }
        if (this.c.getNativeAdConfigurations() != null && (aqVar = this.f3876a) != null && !aqVar.c().isEmpty()) {
            arrayList.add(IronSource.AD_UNIT.NATIVE_AD);
        }
        return arrayList;
    }

    public a h() {
        return this.h;
    }

    public JSONObject i() {
        return this.f;
    }

    public aq j() {
        return this.f3876a;
    }

    public cq k() {
        return this.b;
    }

    public boolean o() {
        return !TextUtils.isEmpty(c().getTestSuiteSettings().b());
    }

    public boolean p() {
        JSONObject jSONObject = this.f;
        return (jSONObject == null || jSONObject.has("error") || this.f3876a == null || this.b == null || this.c == null || !m()) ? false : true;
    }

    public String toString() {
        JSONObject jSONObjectJsonObjectInit = IronSourceNetworkBridge.jsonObjectInit();
        try {
            jSONObjectJsonObjectInit.put("appKey", this.d);
            jSONObjectJsonObjectInit.put("userId", this.e);
            jSONObjectJsonObjectInit.put("response", this.f);
        } catch (JSONException e) {
            o9.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
        return jSONObjectJsonObjectInit.toString();
    }
}
