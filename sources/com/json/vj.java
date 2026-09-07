package com.json;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.json.mediationsdk.logger.IronLog;
import com.json.sdk.controller.FeaturesManager;
import com.json.sdk.utils.IronSourceStorageUtils;
import com.json.sdk.utils.Logger;
import com.json.sdk.utils.SDKUtils;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public final class vj implements gr, v9, u9, s9, t9, bk, oo {
    private static final String m = "IronSourceAdsPublisherAgent";
    private static vj n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.json.sdk.controller.e f4527a;
    private String b;
    private String c;
    private wa d;
    private pn e;
    private e9 g;
    private boolean f = false;
    private FeaturesManager h = FeaturesManager.getInstance();
    private bi.a i = mm.M().g();
    private p0.a j = mm.M().E();
    private p0 k = mm.S().F();
    private ch l = mm.S().z();

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4528a;
        final /* synthetic */ String b;
        final /* synthetic */ va c;

        a(String str, String str2, va vaVar) {
            this.f4528a = str;
            this.b = str2;
            this.c = vaVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            vj.this.f4527a.a(this.f4528a, this.b, this.c, (v9) vj.this);
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ JSONObject f4529a;

        b(JSONObject jSONObject) {
            this.f4529a = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            vj.this.f4527a.a(this.f4529a, (v9) vj.this);
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4530a;
        final /* synthetic */ String b;
        final /* synthetic */ va c;

        c(String str, String str2, va vaVar) {
            this.f4530a = str;
            this.b = str2;
            this.c = vaVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            vj.this.f4527a.a(this.f4530a, this.b, this.c, (u9) vj.this);
        }
    }

    class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4531a;

        d(String str) {
            this.f4531a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            vj.this.f4527a.a(this.f4531a, vj.this);
        }
    }

    class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ JSONObject f4532a;

        e(JSONObject jSONObject) {
            this.f4532a = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            vj.this.f4527a.a(this.f4532a, (u9) vj.this);
        }
    }

    class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ rj f4533a;
        final /* synthetic */ Map b;

        f(rj rjVar, Map map) {
            this.f4533a = rjVar;
            this.b = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            eh.e eVar = this.f4533a.i() ? eh.e.Banner : eh.e.Interstitial;
            va vaVarA = vj.this.d.a(eVar, this.f4533a);
            gh ghVar = new gh();
            ghVar.a(cc.x, Boolean.valueOf(this.f4533a.j())).a(cc.G, Boolean.valueOf(this.f4533a.m())).a(cc.v, this.f4533a.g()).a("producttype", ck.a(this.f4533a)).a(cc.I, Long.valueOf(m0.f3880a.b(this.f4533a.e())));
            lh.a(er.h, ghVar.a());
            if (eVar == eh.e.Banner) {
                vj.this.f4527a.a(vj.this.b, vj.this.c, vaVarA, (t9) vj.this);
                vj.this.f4527a.a(vaVarA, this.b, (t9) vj.this);
            } else {
                vj.this.f4527a.a(vj.this.b, vj.this.c, vaVarA, (u9) vj.this);
                vj.this.f4527a.b(vaVarA, this.b, vj.this);
            }
        }
    }

    class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ va f4534a;
        final /* synthetic */ Map b;

        g(va vaVar, Map map) {
            this.f4534a = vaVar;
            this.b = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            vj.this.f4527a.a(this.f4534a, this.b, (u9) vj.this);
        }
    }

    class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ rj f4535a;

        h(rj rjVar) {
            this.f4535a = rjVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            eh.e eVar = this.f4535a.i() ? eh.e.Banner : eh.e.Interstitial;
            va vaVarA = vj.this.d.a(eVar, this.f4535a);
            gh ghVar = new gh();
            ghVar.a(cc.x, Boolean.valueOf(this.f4535a.j())).a(cc.v, this.f4535a.g()).a("producttype", ck.a(this.f4535a)).a("isMultipleAdObjects", Boolean.valueOf(this.f4535a.l()));
            lh.a(er.m, ghVar.a());
            if (eVar == eh.e.Banner) {
                vj.this.f4527a.a(vaVarA);
            } else {
                vaVarA.a(false);
                vj.this.f4527a.b(vaVarA);
            }
        }
    }

    private vj(Context context, int i) {
        c(context);
    }

    vj(String str, String str2, Context context) {
        this.b = str;
        this.c = str2;
        c(context);
    }

    public static bk a(Context context, String str, String str2) {
        return a(str, str2, context);
    }

    public static synchronized bk a(String str, String str2, Context context) {
        if (n == null) {
            lh.a(er.f3672a);
            n = new vj(str, str2, context);
        }
        return n;
    }

    private jo a(va vaVar) {
        if (vaVar == null) {
            return null;
        }
        return (jo) vaVar.i();
    }

    public static synchronized vj a(Context context, int i) throws Exception {
        Logger.i(m, "getInstance()");
        if (n == null) {
            n = new vj(context, i);
        }
        return n;
    }

    private Map<String, String> a(Map<String, String> map) {
        map.put("adm", SDKUtils.decodeString(map.get("adm")));
        return map;
    }

    private lo b(va vaVar) {
        if (vaVar == null) {
            return null;
        }
        return (lo) vaVar.i();
    }

    public static synchronized vj b(Context context) throws Exception {
        return a(context, 0);
    }

    private void b(rj rjVar, Map<String, String> map) {
        Logger.d(m, "loadOnNewInstance " + rjVar.e());
        this.f4527a.a(new f(rjVar, map));
    }

    private qo c(va vaVar) {
        if (vaVar == null) {
            return null;
        }
        return (qo) vaVar.i();
    }

    private void c(Context context) {
        try {
            SDKUtils.getNetworkConfiguration();
            ik.a(context);
            IronSourceStorageUtils.initializeCacheDirectory(context, new rt(SDKUtils.getNetworkConfiguration().optJSONObject(b9.a.k)));
            ik.e().d(SDKUtils.getSDKVersion());
            this.d = new wa();
            e9 e9Var = new e9();
            this.g = e9Var;
            if (context instanceof Activity) {
                e9Var.a((Activity) context);
            }
            int debugMode = this.h.getDebugMode();
            this.e = new pn();
            this.f4527a = new com.json.sdk.controller.e(context, this.g, this.d, hg.f3748a, debugMode, this.h.getDataManagerConfig(), this.b, this.c, this.e);
            Logger.enableLogging(debugMode);
            Logger.i(m, "C'tor");
            a(context);
            this.e.d();
            this.e.e();
            this.e.a(context);
            this.e.b();
            this.e.a();
            this.e.b(context);
            this.e.c();
        } catch (Exception e2) {
            o9.d().a(e2);
            IronLog.INTERNAL.error(e2.toString());
        }
    }

    private void c(rj rjVar, Map<String, String> map) {
        try {
            map = a(map);
        } catch (Exception e2) {
            o9.d().a(e2);
            gh ghVarA = new gh().a(cc.A, e2.getMessage()).a(cc.x, Boolean.valueOf(rjVar.j())).a(cc.G, Boolean.valueOf(rjVar.m())).a(cc.v, rjVar.g()).a("producttype", ck.a(rjVar)).a(cc.I, Long.valueOf(m0.f3880a.b(rjVar.e())));
            m0.f3880a.a(rjVar.e());
            lh.a(er.k, ghVarA.a());
            IronLog.INTERNAL.error(e2.toString());
            Logger.d(m, "loadInAppBiddingAd failed decoding  ADM " + e2.getMessage());
        }
        b(rjVar, map);
    }

    private va d(eh.e eVar, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.d.a(eVar, str);
    }

    @Override // com.json.bk
    public com.json.sdk.controller.e a() {
        return this.f4527a;
    }

    @Override // com.json.gr, com.json.bk
    public void a(Activity activity) {
        try {
            Logger.i(m, "release()");
            za.g();
            this.g.b();
            this.f4527a.a((Context) activity);
            this.f4527a.destroy();
            this.f4527a = null;
        } catch (Exception e2) {
            o9.d().a(e2);
        }
        n = null;
    }

    @Override // com.json.dk
    public void a(Activity activity, rj rjVar, Map<String, String> map) {
        this.g.a(activity);
        Logger.i(m, "showAd " + rjVar.e());
        va vaVarA = this.d.a(eh.e.Interstitial, rjVar.e());
        if (vaVarA == null) {
            return;
        }
        this.f4527a.a(new g(vaVarA, map));
    }

    public void a(Context context) {
        this.f = false;
        Boolean boolC = this.l.c(b9.a.g);
        if (boolC == null) {
            boolC = Boolean.FALSE;
        }
        boolean zBooleanValue = boolC.booleanValue();
        this.f = zBooleanValue;
        if (zBooleanValue) {
            try {
                ((Application) context).registerActivityLifecycleCallbacks(new i(this));
            } catch (Throwable th) {
                o9.d().a(th);
                gh ghVar = new gh();
                ghVar.a(cc.y, th.getMessage());
                lh.a(er.u, ghVar.a());
            }
        }
    }

    @Override // com.json.s9
    public void a(eh.e eVar, String str) {
        lo loVarB;
        va vaVarD = d(eVar, str);
        if (vaVarD != null) {
            if (eVar == eh.e.RewardedVideo) {
                qo qoVarC = c(vaVarD);
                if (qoVarC != null) {
                    qoVarC.c();
                    return;
                }
                return;
            }
            if (eVar != eh.e.Interstitial || (loVarB = b(vaVarD)) == null) {
                return;
            }
            loVarB.onInterstitialClose();
        }
    }

    @Override // com.json.s9
    public void a(eh.e eVar, String str, z2 z2Var) {
        jo joVarA;
        va vaVarD = d(eVar, str);
        if (vaVarD != null) {
            vaVarD.b(2);
            if (eVar == eh.e.RewardedVideo) {
                qo qoVarC = c(vaVarD);
                if (qoVarC != null) {
                    qoVarC.a(z2Var);
                    return;
                }
                return;
            }
            if (eVar == eh.e.Interstitial) {
                lo loVarB = b(vaVarD);
                if (loVarB != null) {
                    loVarB.onInterstitialInitSuccess();
                    return;
                }
                return;
            }
            if (eVar != eh.e.Banner || (joVarA = a(vaVarD)) == null) {
                return;
            }
            joVarA.onBannerInitSuccess();
        }
    }

    @Override // com.json.s9
    public void a(eh.e eVar, String str, String str2) {
        jo joVarA;
        va vaVarD = d(eVar, str);
        gh ghVarA = new gh().a(cc.v, str).a("producttype", eVar).a(cc.A, str2);
        if (vaVarD != null) {
            m0 m0Var = m0.f3880a;
            ghVarA.a(cc.I, Long.valueOf(m0Var.b(vaVarD.h())));
            ghVarA.a(cc.x, Boolean.valueOf(mh.a(vaVarD)));
            m0Var.a(vaVarD.h());
            vaVarD.b(3);
            if (eVar == eh.e.RewardedVideo) {
                qo qoVarC = c(vaVarD);
                if (qoVarC != null) {
                    qoVarC.b(str2);
                }
            } else if (eVar == eh.e.Interstitial) {
                lo loVarB = b(vaVarD);
                if (loVarB != null) {
                    loVarB.onInterstitialInitFailed(str2);
                }
            } else if (eVar == eh.e.Banner && (joVarA = a(vaVarD)) != null) {
                joVarA.onBannerLoadFail(str2);
            }
        }
        lh.a(er.i, ghVarA.a());
    }

    @Override // com.json.s9
    public void a(eh.e eVar, String str, String str2, JSONObject jSONObject) {
        jo joVarA;
        va vaVarD = d(eVar, str);
        if (vaVarD == null || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            Logger.i(m, "Received Event Notification: " + str2 + " for demand source: " + vaVarD.f());
            if (eVar == eh.e.Interstitial) {
                lo loVarB = b(vaVarD);
                if (loVarB != null) {
                    jSONObject.put("demandSourceName", str);
                    loVarB.onInterstitialEventNotificationReceived(str2, jSONObject);
                }
            } else if (eVar == eh.e.RewardedVideo) {
                qo qoVarC = c(vaVarD);
                if (qoVarC != null) {
                    jSONObject.put("demandSourceName", str);
                    qoVarC.a(str2, jSONObject);
                }
            } else if (eVar == eh.e.Banner && (joVarA = a(vaVarD)) != null) {
                jSONObject.put("demandSourceName", str);
                if (str2.equalsIgnoreCase("impressions")) {
                    joVarA.onBannerShowSuccess();
                }
            }
        } catch (JSONException e2) {
            o9.d().a(e2);
            IronLog.INTERNAL.error(e2.toString());
        }
    }

    @Override // com.json.dk
    public void a(rj rjVar, Map<String, String> map) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        map.put(b9.h.y0, String.valueOf(jCurrentTimeMillis));
        m0.f3880a.a(rjVar.e(), jCurrentTimeMillis);
        gh ghVar = new gh();
        ghVar.a(cc.x, Boolean.valueOf(rjVar.j())).a(cc.G, Boolean.valueOf(rjVar.m())).a(cc.v, rjVar.g()).a("producttype", ck.a(rjVar)).a(cc.I, Long.valueOf(jCurrentTimeMillis));
        lh.a(er.f, ghVar.a());
        Logger.d(m, "loadAd " + rjVar.e());
        o0 o0Var = new o0(rjVar);
        this.j.a(o0Var);
        this.j.a(new JSONObject(map), n1.LOAD_REQUEST, o0Var.c());
        if (c(rjVar)) {
            this.i.a(new xs(o0Var));
        }
        if (rjVar.k()) {
            c(rjVar, map);
        } else {
            b(rjVar, map);
        }
    }

    @Override // com.json.v9
    public void a(String str, int i) {
        qo qoVarC;
        va vaVarD = d(eh.e.RewardedVideo, str);
        if (vaVarD == null || (qoVarC = c(vaVarD)) == null) {
            return;
        }
        qoVarC.a(i);
    }

    @Override // com.json.t9
    public void a(String str, vg vgVar) {
        jo joVarA;
        va vaVarD = d(eh.e.Banner, str);
        if (vaVarD == null || (joVarA = a(vaVarD)) == null) {
            return;
        }
        joVarA.onBannerLoadSuccess(vaVarD.c(), vgVar);
    }

    @Override // com.json.t9
    public void a(String str, String str2) {
        jo joVarA;
        va vaVarD = d(eh.e.Banner, str);
        if (vaVarD == null || (joVarA = a(vaVarD)) == null) {
            return;
        }
        joVarA.onBannerLoadFail(str2);
    }

    @Override // com.json.gr
    public void a(String str, String str2, int i) {
        eh.e productType;
        va vaVarA;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (productType = SDKUtils.getProductType(str)) == null || (vaVarA = this.d.a(productType, str2)) == null) {
            return;
        }
        vaVarA.c(i);
    }

    @Override // com.json.gr
    public void a(String str, String str2, String str3, Map<String, String> map, lo loVar) {
        this.b = str;
        this.c = str2;
        this.f4527a.a(new c(str, str2, this.d.a(eh.e.Interstitial, str3, map, loVar)));
    }

    @Override // com.json.gr
    public void a(String str, String str2, String str3, Map<String, String> map, qo qoVar) {
        this.b = str;
        this.c = str2;
        this.f4527a.a(new a(str, str2, this.d.a(eh.e.RewardedVideo, str3, map, qoVar)));
    }

    @Override // com.json.u9
    public void a(String str, JSONObject jSONObject) {
        eh.e eVar = eh.e.Interstitial;
        va vaVarD = d(eVar, str);
        gh ghVarA = new gh().a(cc.v, str);
        if (vaVarD != null) {
            rj rjVarC = vaVarD.c();
            this.j.a(jSONObject, n1.LOAD_SUCCESS, rjVarC.e());
            if (c(rjVarC)) {
                this.i.a(new ys(this.k.a(rjVarC.e())));
            }
            gh ghVarA2 = ghVarA.a("producttype", mh.a(vaVarD, eVar)).a(cc.x, Boolean.valueOf(mh.a(vaVarD)));
            m0 m0Var = m0.f3880a;
            ghVarA2.a(cc.I, Long.valueOf(m0Var.b(vaVarD.h())));
            m0Var.a(vaVarD.h());
            lo loVarB = b(vaVarD);
            if (loVarB != null) {
                loVarB.onInterstitialLoadSuccess(vaVarD.c());
            }
        }
        lh.a(er.l, ghVarA.a());
    }

    @Override // com.json.gr
    public void a(JSONObject jSONObject) {
        this.f4527a.a(new b(jSONObject));
    }

    @Override // com.json.dk
    public boolean a(rj rjVar) {
        Logger.d(m, "isAdAvailable " + rjVar.e());
        va vaVarA = this.d.a(eh.e.Interstitial, rjVar.e());
        if (vaVarA == null) {
            return false;
        }
        return vaVarA.d();
    }

    @Override // com.json.gr
    public boolean a(String str) {
        return this.f4527a.a(str);
    }

    @Override // com.json.oo
    public void b(Activity activity) {
        try {
            this.f4527a.d();
            this.f4527a.a((Context) activity);
        } catch (Exception e2) {
            o9.d().a(e2);
            IronLog.INTERNAL.error(e2.toString());
        }
    }

    @Override // com.json.dk
    public void b(Activity activity, rj rjVar, Map<String, String> map) {
        this.g.a(activity);
        a(rjVar, map);
    }

    @Override // com.json.s9
    public void b(eh.e eVar, String str) {
        qo qoVarC;
        va vaVarD = d(eVar, str);
        if (vaVarD != null) {
            if (eVar == eh.e.Interstitial) {
                lo loVarB = b(vaVarD);
                if (loVarB != null) {
                    loVarB.onInterstitialOpen();
                    return;
                }
                return;
            }
            if (eVar != eh.e.RewardedVideo || (qoVarC = c(vaVarD)) == null) {
                return;
            }
            qoVarC.a();
        }
    }

    @Override // com.json.dk
    public void b(rj rjVar) {
        Logger.d(m, "destroyInstance " + rjVar.e());
        if (c(rjVar)) {
            this.j.a(n1.DESTROYED, rjVar.e());
            this.i.a(new ws(this.k.a(rjVar.e())));
        }
        this.f4527a.a(new h(rjVar));
    }

    @Override // com.json.u9
    public void b(String str) {
        va vaVarD = d(eh.e.Interstitial, str);
        if (vaVarD != null) {
            rj rjVarC = vaVarD.c();
            this.j.a(n1.SHOW_SUCCESS, rjVarC.e());
            if (c(rjVarC)) {
                this.i.a(new at(this.k.a(rjVarC.e())));
            }
            lo loVarB = b(vaVarD);
            if (loVarB != null) {
                loVarB.onInterstitialShowSuccess();
            }
        }
    }

    @Override // com.json.u9
    public void b(String str, String str2) {
        va vaVarD = d(eh.e.Interstitial, str);
        if (vaVarD != null) {
            rj rjVarC = vaVarD.c();
            this.j.a(n1.SHOW_FAIL, rjVarC.e());
            if (c(rjVarC)) {
                this.i.a(new zs(this.k.a(rjVarC.e())));
            }
            lo loVarB = b(vaVarD);
            if (loVarB != null) {
                loVarB.onInterstitialShowFailed(str2);
            }
        }
    }

    @Override // com.json.gr
    public void b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String strOptString = jSONObject.optString("demandSourceName");
        if (TextUtils.isEmpty(strOptString)) {
            return;
        }
        this.f4527a.a(new d(strOptString));
    }

    @Override // com.json.oo
    public void c(Activity activity) {
        this.g.a(activity);
        this.f4527a.f();
        this.f4527a.b(activity);
    }

    @Override // com.json.s9
    public void c(eh.e eVar, String str) {
        jo joVarA;
        va vaVarD = d(eVar, str);
        if (vaVarD != null) {
            if (eVar == eh.e.RewardedVideo) {
                qo qoVarC = c(vaVarD);
                if (qoVarC != null) {
                    qoVarC.d();
                    return;
                }
                return;
            }
            if (eVar == eh.e.Interstitial) {
                lo loVarB = b(vaVarD);
                if (loVarB != null) {
                    loVarB.onInterstitialClick();
                    return;
                }
                return;
            }
            if (eVar != eh.e.Banner || (joVarA = a(vaVarD)) == null) {
                return;
            }
            joVarA.onBannerClick();
        }
    }

    @Override // com.json.v9
    public void c(String str) {
        qo qoVarC;
        va vaVarD = d(eh.e.RewardedVideo, str);
        if (vaVarD == null || (qoVarC = c(vaVarD)) == null) {
            return;
        }
        qoVarC.b();
    }

    @Override // com.json.u9
    public void c(String str, String str2) {
        eh.e eVar = eh.e.Interstitial;
        va vaVarD = d(eVar, str);
        gh ghVar = new gh();
        ghVar.a(cc.A, str2).a(cc.v, str);
        if (vaVarD != null) {
            gh ghVarA = ghVar.a("producttype", mh.a(vaVarD, eVar)).a(cc.y, vaVarD.e() == 2 ? cc.E : cc.F).a(cc.x, Boolean.valueOf(mh.a(vaVarD)));
            m0 m0Var = m0.f3880a;
            ghVarA.a(cc.I, Long.valueOf(m0Var.b(vaVarD.h())));
            m0Var.a(vaVarD.h());
            lo loVarB = b(vaVarD);
            if (loVarB != null) {
                loVarB.onInterstitialLoadFailed(str2);
            }
        }
        lh.a(er.g, ghVar.a());
    }

    @Override // com.json.gr
    public void c(JSONObject jSONObject) {
        this.f4527a.a(new e(jSONObject));
    }

    public boolean c(rj rjVar) {
        return rjVar.l() && !rjVar.i() && a(rjVar);
    }

    @Override // com.json.v9
    public void d(String str, String str2) {
        qo qoVarC;
        va vaVarD = d(eh.e.RewardedVideo, str);
        if (vaVarD == null || (qoVarC = c(vaVarD)) == null) {
            return;
        }
        qoVarC.a(str2);
    }

    @Override // com.json.u9
    public void onInterstitialAdRewarded(String str, int i) {
        va vaVarD = d(eh.e.Interstitial, str);
        lo loVarB = b(vaVarD);
        if (vaVarD == null || loVarB == null) {
            return;
        }
        loVarB.onInterstitialAdRewarded(str, i);
    }

    @Override // com.json.gr, com.json.bk
    public void onPause(Activity activity) {
        if (this.f) {
            return;
        }
        b(activity);
    }

    @Override // com.json.gr, com.json.bk
    public void onResume(Activity activity) {
        if (this.f) {
            return;
        }
        c(activity);
    }
}
