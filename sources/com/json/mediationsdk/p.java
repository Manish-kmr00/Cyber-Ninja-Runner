package com.json.mediationsdk;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.json.ak;
import com.json.an;
import com.json.ar;
import com.json.as;
import com.json.au;
import com.json.bf;
import com.json.bg;
import com.json.cn;
import com.json.cv;
import com.json.d8;
import com.json.de;
import com.json.dg;
import com.json.dq;
import com.json.dv;
import com.json.environment.ContextProvider;
import com.json.eo;
import com.json.eu;
import com.json.fg;
import com.json.fk;
import com.json.g6;
import com.json.h4;
import com.json.h7;
import com.json.hj;
import com.json.i1;
import com.json.ip;
import com.json.j;
import com.json.jp;
import com.json.k1;
import com.json.k4;
import com.json.ke;
import com.json.lb;
import com.json.ls;
import com.json.mb;
import com.json.mediationsdk.adquality.AdQualityBridge;
import com.json.mediationsdk.adunit.adapter.utility.AdInfo;
import com.json.mediationsdk.config.ConfigFile;
import com.json.mediationsdk.demandOnly.ISDemandOnlyBannerLayout;
import com.json.mediationsdk.demandOnly.ISDemandOnlyInterstitialListener;
import com.json.mediationsdk.demandOnly.ISDemandOnlyRewardedVideoListener;
import com.json.mediationsdk.demandOnly.f;
import com.json.mediationsdk.demandOnly.h;
import com.json.mediationsdk.demandOnly.k;
import com.json.mediationsdk.events.ISErrorListener;
import com.json.mediationsdk.impressionData.ImpressionDataListener;
import com.json.mediationsdk.logger.IronLog;
import com.json.mediationsdk.logger.IronSourceError;
import com.json.mediationsdk.logger.IronSourceLogger;
import com.json.mediationsdk.logger.IronSourceLoggerManager;
import com.json.mediationsdk.logger.LogListener;
import com.json.mediationsdk.metadata.MetaData;
import com.json.mediationsdk.metadata.MetaDataUtils;
import com.json.mediationsdk.model.InterstitialPlacement;
import com.json.mediationsdk.model.NetworkSettings;
import com.json.mediationsdk.model.Placement;
import com.json.mediationsdk.sdk.InitializationListener;
import com.json.mediationsdk.sdk.LevelPlayInterstitialListener;
import com.json.mediationsdk.sdk.LevelPlayRewardedVideoBaseListener;
import com.json.mediationsdk.sdk.LevelPlayRewardedVideoListener;
import com.json.mediationsdk.sdk.LevelPlayRewardedVideoManualListener;
import com.json.mediationsdk.sdk.SegmentListener;
import com.json.mediationsdk.server.HttpFunctions;
import com.json.mediationsdk.server.ServerURL;
import com.json.mediationsdk.utils.ErrorBuilder;
import com.json.mediationsdk.utils.IronSourceAES;
import com.json.mediationsdk.utils.IronSourceConstants;
import com.json.mediationsdk.utils.IronSourceUtils;
import com.json.mg;
import com.json.mj;
import com.json.mm;
import com.json.mo;
import com.json.nf;
import com.json.nm;
import com.json.o9;
import com.json.oc;
import com.json.oj;
import com.json.op;
import com.json.qa;
import com.json.qi;
import com.json.qk;
import com.json.r8;
import com.json.ra;
import com.json.rm;
import com.json.s8;
import com.json.sdk.controller.FeaturesManager;
import com.json.sg;
import com.json.si;
import com.json.st;
import com.json.u6;
import com.json.vq;
import com.json.xa;
import com.json.xh;
import com.json.yl;
import com.json.yq;
import com.json.z8;
import com.json.zb;
import com.json.zj;
import com.json.zr;
import com.json.zt;
import com.safedk.android.internal.partials.IronSourceNetworkBridge;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public class p implements zj, mo, qa, qa.b, qa.c, qa.a {
    private static boolean t0;
    private Set<IronSource.AD_UNIT> A;
    private boolean B;
    private IronSourceSegment C;
    private final String D;
    private int E;
    private boolean F;
    private boolean G;
    private boolean H;
    private boolean I;
    private boolean J;
    private boolean K;
    private boolean L;
    private Boolean M;
    private IronSourceBannerLayout N;
    private String O;
    private Boolean P;
    private dg Q;
    private w R;
    private hj S;
    private vq T;
    private g6 U;
    private InitializationListener V;
    private eo W;
    private AtomicBoolean X;
    private boolean Y;
    private boolean Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f3998a;
    private boolean a0;
    private final String b;
    private boolean b0;
    private final nf c;
    private boolean c0;
    private final nf.a d;
    private int d0;
    private final bg e;
    private final ConcurrentHashMap<String, h.d> e0;
    private final bf f;
    private final ConcurrentHashMap<String, h.b> f0;
    private final xh.a g;
    private final ConcurrentHashMap<String, h.d> g0;
    private IronSourceLoggerManager h;
    private f h0;
    private yl i;
    private k i0;
    private com.json.mediationsdk.logger.b j;
    private com.json.mediationsdk.demandOnly.c j0;
    private AtomicBoolean k;
    private oc k0;
    private final Object l;
    private ak l0;
    private ls m;
    private ke m0;
    private String n;
    private boolean n0;
    private String o;
    private AdQualityBridge o0;
    private String p;
    private final AtomicBoolean p0;
    private String q;
    ISErrorListener q0;
    private Map<String, String> r;
    mg<ISDemandOnlyInterstitialListener> r0;
    private String s;
    mg<ISDemandOnlyRewardedVideoListener> s0;
    private AtomicBoolean t;
    private boolean u;
    private List<IronSource.AD_UNIT> v;
    private String w;
    private Context x;
    private Boolean y;
    private Set<IronSource.AD_UNIT> z;

    class a implements ISErrorListener {
        a() {
        }

        @Override // com.json.mediationsdk.events.ISErrorListener
        public void onError(Throwable th) {
            IronLog.INTERNAL.error(th.getMessage());
        }
    }

    static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4000a;
        static final /* synthetic */ int[] b;
        static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[op.b.values().length];
            c = iArr;
            try {
                iArr[op.b.CAPPED_PER_DELIVERY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                c[op.b.CAPPED_PER_COUNT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                c[op.b.CAPPED_PER_PACE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                c[op.b.NOT_CAPPED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[s.d.values().length];
            b = iArr2;
            try {
                iArr2[s.d.INIT_FAILED.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[s.d.INIT_IN_PROGRESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr3 = new int[IronSource.AD_UNIT.values().length];
            f4000a = iArr3;
            try {
                iArr3[IronSource.AD_UNIT.REWARDED_VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f4000a[IronSource.AD_UNIT.INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f4000a[IronSource.AD_UNIT.BANNER.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f4000a[IronSource.AD_UNIT.NATIVE_AD.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public interface c {
        void a(String str);
    }

    private static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static volatile p f4001a = new p(null);

        private d() {
        }
    }

    private p() {
        this(mm.S().f(), mm.M().b(), mm.S().B(), mm.S().v(), mm.M().q());
    }

    /* synthetic */ p(a aVar) {
        this();
    }

    p(nf nfVar, nf.a aVar, bg bgVar, bf bfVar, xh.a aVar2) {
        this.f3998a = getClass().getName();
        this.b = "!SDK-VERSION-STRING!:com.ironsource:mediationsdk:\u200b8.7.0";
        this.l = new Object();
        this.m = null;
        this.n = null;
        this.o = "";
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.u = false;
        this.y = null;
        this.B = true;
        this.D = "sessionDepth";
        this.P = null;
        this.n0 = false;
        this.c = nfVar;
        this.d = aVar;
        this.e = bgVar;
        this.f = bfVar;
        this.g = aVar2;
        w();
        this.k = new AtomicBoolean();
        this.z = new HashSet();
        this.A = new HashSet();
        this.G = false;
        this.F = false;
        this.H = false;
        this.t = new AtomicBoolean(true);
        this.X = new AtomicBoolean(false);
        this.p0 = new AtomicBoolean(false);
        this.E = 0;
        this.I = false;
        this.J = false;
        this.K = false;
        this.L = false;
        this.w = IronSourceUtils.getSessionId();
        this.M = Boolean.FALSE;
        this.b0 = false;
        this.O = null;
        this.Q = null;
        this.V = null;
        this.W = null;
        this.R = null;
        this.Y = false;
        this.e0 = new ConcurrentHashMap<>();
        this.g0 = new ConcurrentHashMap<>();
        this.f0 = new ConcurrentHashMap<>();
        this.h0 = null;
        this.i0 = null;
        this.j0 = null;
        this.d0 = 1;
        this.k0 = new oc();
        ak akVar = new ak();
        this.l0 = akVar;
        this.m0 = new ke(akVar);
        this.q0 = new a();
        this.o0 = null;
        this.r0 = new mg.a();
        this.s0 = new mg.b();
    }

    private boolean A() {
        ls lsVar = this.m;
        return (lsVar == null || lsVar.j() == null || this.m.j().a() == null || this.m.j().a().size() <= 0) ? false : true;
    }

    private synchronized boolean C() {
        return this.u;
    }

    private boolean D() {
        ls lsVar = this.m;
        return (lsVar == null || lsVar.c() == null || this.m.c().getInterstitialConfigurations() == null) ? false : true;
    }

    private boolean E() {
        return D() && G();
    }

    private boolean G() {
        ls lsVar = this.m;
        return (lsVar == null || lsVar.j() == null || this.m.j().b() == null || this.m.j().b().size() <= 0) ? false : true;
    }

    private boolean H() {
        ls lsVar = this.m;
        return (lsVar == null || lsVar.c() == null || this.m.c().getNativeAdConfigurations() == null) ? false : true;
    }

    private boolean I() {
        return H() && J();
    }

    private boolean J() {
        ls lsVar = this.m;
        return (lsVar == null || lsVar.j() == null || this.m.j().c() == null || this.m.j().c().isEmpty()) ? false : true;
    }

    private boolean L() {
        ls lsVar = this.m;
        return (lsVar == null || lsVar.c() == null || this.m.c().getRewardedVideoConfigurations() == null) ? false : true;
    }

    private boolean M() {
        return L() && N();
    }

    private boolean N() {
        ls lsVar = this.m;
        return (lsVar == null || lsVar.j() == null || this.m.j().d() == null || this.m.j().d().size() <= 0) ? false : true;
    }

    private void T() {
        if (this.V == null || !this.X.compareAndSet(false, true)) {
            return;
        }
        IronLog.CALLBACK.verbose("onInitializationCompleted()");
        ar.i().a(new zb(IronSourceConstants.TROUBLESHOOTING_INIT_COMPLETED, IronSourceUtils.getMediationAdditionalData(false)));
        this.V.onInitializationComplete();
    }

    private void V() {
        ConcurrentHashMap<String, List<String>> concurrentHashMapC = qk.b().c();
        if (concurrentHashMapC.containsKey(com.json.mediationsdk.metadata.a.c)) {
            String str = concurrentHashMapC.get(com.json.mediationsdk.metadata.a.c).get(0);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            xa.f4585a.b(!MetaDataUtils.getMetaDataBooleanValue(str));
        }
    }

    private boolean W() {
        return this.o0 == null && this.p0.get() && this.m.c().getAdQualityConfigurations().a() && AdQualityBridge.adQualityAvailable();
    }

    private void X() {
        if (this.H) {
            Z();
            return;
        }
        boolean zH = this.m.c().getBannerConfigurations().d().h();
        this.c0 = zH;
        if (zH) {
            Y();
        } else {
            f0();
        }
    }

    private void Y() {
        IronLog.INTERNAL.verbose();
        List<NetworkSettings> listA = a(this.m.j().a());
        if (listA.size() > 0) {
            this.U = new g6(listA, this.m.c().getBannerConfigurations(), IronSourceUtils.getUserIdForNetworks(), qk.b(), this.C);
            v();
        } else {
            JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false, true, 1);
            a(mediationAdditionalData, new Object[][]{new Object[]{"errorCode", 1010}});
            a(IronSourceConstants.TROUBLESHOOTING_BN_INIT_FAILED, mediationAdditionalData);
            a(IronSource.AD_UNIT.BANNER, false);
        }
    }

    private void Z() {
        this.h.log(IronSourceLogger.IronSourceTag.INTERNAL, "Banner started in demand only mode", 0);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.m.j().a().size(); i++) {
            String str = this.m.j().a().get(i);
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(this.m.k().b(str));
            }
        }
        if (arrayList.isEmpty()) {
            JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false, false, 1);
            a(mediationAdditionalData, new Object[][]{new Object[]{"errorCode", 1010}});
            a(IronSourceConstants.TROUBLESHOOTING_BN_INIT_FAILED, mediationAdditionalData);
            a(IronSource.AD_UNIT.BANNER, false);
            return;
        }
        synchronized (this.f0) {
            u6 u6VarC = this.m.c().getBannerConfigurations();
            ra.a aVar = new ra.a("Mediation");
            if (u6VarC.k()) {
                aVar.a("isOneFlow", 1);
            }
            this.j0 = new com.json.mediationsdk.demandOnly.c(arrayList, u6VarC, n(), o(), new ra.b(oj.i(), aVar));
        }
        for (h.b bVar : this.f0.values()) {
            this.j0.a(bVar.getBanner(), bVar.getInstanceId());
        }
        this.f0.clear();
    }

    private int a(yq yqVar) {
        return (this.a0 || this.Y || !yqVar.k().e()) ? 1 : 2;
    }

    private ls a(Context context, String str, c cVar) {
        ls lsVar = null;
        if (!IronSourceUtils.isNetworkConnected(context)) {
            return null;
        }
        try {
            String strB = b(context);
            if (TextUtils.isEmpty(strB)) {
                strB = this.c.M(context);
                IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "using custom identifier", 1);
            }
            String str2 = strB;
            IronSourceSegment ironSourceSegment = this.C;
            String strSendPostRequest = HttpFunctions.sendPostRequest(ServerURL.buildInitURL(context, n(), str, str2, q(), this.Y, ironSourceSegment != null ? ironSourceSegment.getSegmentData() : null, B()), qi.a().toString(), cVar);
            if (strSendPostRequest == null) {
                IronLog.INTERNAL.warning("serverResponseString is null");
                return null;
            }
            if (IronSourceUtils.isEncryptedResponse()) {
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.verbose("encrypt");
                JSONObject jSONObjectJsonObjectInit = IronSourceNetworkBridge.jsonObjectInit(strSendPostRequest);
                String strOptString = jSONObjectJsonObjectInit.optString("response", null);
                if (TextUtils.isEmpty(strOptString)) {
                    ironLog.warning("encryptedResponse is empty - return null");
                    return null;
                }
                strSendPostRequest = a(strOptString, Boolean.valueOf(jSONObjectJsonObjectInit.optBoolean("compression", false)));
                if (TextUtils.isEmpty(strSendPostRequest)) {
                    ironLog.warning("encoded response invalid - return null");
                    U();
                    return null;
                }
            }
            ls lsVar2 = new ls(context, n(), str, strSendPostRequest);
            try {
                lsVar2.a(ls.a.SERVER);
                if (lsVar2.p()) {
                    return lsVar2;
                }
                IronLog.INTERNAL.warning("response invalid - return null");
                return null;
            } catch (Exception e) {
                e = e;
                lsVar = lsVar2;
                o9.d().a(e);
                IronLog.INTERNAL.warning("exception = " + e);
                return lsVar;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    private f a(List<NetworkSettings> list) {
        mj mjVarD = this.m.c().getInterstitialConfigurations();
        ra.a aVar = new ra.a("Mediation");
        if (mjVarD.j()) {
            aVar.a("isOneFlow", 1);
        }
        return new f(list, mjVarD, com.json.mediationsdk.c.b(), this.r0, n(), o(), new ra.b(oj.i(), aVar));
    }

    private IronSourceError a(s.d dVar) {
        if (!this.K) {
            return new IronSourceError(510, "ironSource SDK was not initialized");
        }
        if (!this.H) {
            return new IronSourceError(510, "ironSource SDK was not initialized using Demand Only mode");
        }
        if (dVar == s.d.INIT_FAILED) {
            return new IronSourceError(510, "ironSource initialization failed");
        }
        if (dVar == s.d.INIT_IN_PROGRESS && s.c().d()) {
            return new IronSourceError(510, "ironSource initialization in progress");
        }
        return null;
    }

    private String a(String str, Boolean bool) {
        return bool.booleanValue() ? IronSourceAES.decryptAndDecompress(mb.b().c(), str) : IronSourceAES.decode(mb.b().c(), str);
    }

    private List<NetworkSettings> a(ArrayList<String> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            String str = arrayList.get(i);
            if (!TextUtils.isEmpty(str)) {
                arrayList2.add(this.m.k().b(str));
            }
        }
        return arrayList2;
    }

    private void a(int i, JSONObject jSONObject) {
        oj.i().a(new zb(i, jSONObject));
    }

    private synchronized void a(eo eoVar) {
        this.W = eoVar;
    }

    private void a(h4 h4Var, Context context, ls lsVar) {
        oj.i().a(h4Var.c(), context);
        oj.i().b(h4Var.d(), context);
        oj.i().b(h4Var.f());
        oj.i().a(h4Var.e());
        oj.i().c(h4Var.a());
        oj.i().c(h4Var.i(), context);
        oj.i().a(h4Var.h(), context);
        oj.i().b(h4Var.j(), context);
        oj.i().d(h4Var.g(), context);
        oj.i().a(lsVar.c().getApplicationConfigurations().i());
        oj.i().a(h4Var.k());
        oj.i().d(h4Var.b());
    }

    private void a(k4 k4Var) {
        xa xaVar = xa.f4585a;
        xaVar.c(k4Var.getShouldUseAppSet());
        xaVar.a(k4Var.getShouldReuseAdvId());
        xaVar.a(k4Var.getUserAgentExpirationThresholdInHours());
        this.f.a(k4Var);
    }

    private void a(ls lsVar) {
        this.j.setDebugLevel(lsVar.c().getApplicationConfigurations().g().b());
        this.h.setLoggerDebugLevel("console", lsVar.c().getApplicationConfigurations().g().a());
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:34:? A[RETURN, SYNTHETIC] */
    private void a(ls lsVar, Context context) {
        h4 h4VarG;
        ip ipVar;
        boolean zL = L() ? lsVar.c().getRewardedVideoConfigurations().m().l() : false;
        boolean zL2 = D() ? lsVar.c().getInterstitialConfigurations().i().l() : false;
        boolean zL3 = y() ? lsVar.c().getBannerConfigurations().g().l() : false;
        boolean zL4 = H() ? lsVar.c().getNativeAdConfigurations().getEventsConfigurations().l() : false;
        jp jpVarH = lsVar.c().getApplicationConfigurations().h();
        boolean zI = jpVarH.i();
        if (zL) {
            b(lsVar.c().getRewardedVideoConfigurations().m(), context, lsVar);
        } else {
            ar.i().b(false);
        }
        if (zL2) {
            h4VarG = lsVar.c().getInterstitialConfigurations().i();
        } else {
            if (!zL3) {
                if (zL4) {
                    h4VarG = lsVar.c().getNativeAdConfigurations().getEventsConfigurations();
                } else {
                    oj.i().b(false);
                }
                ipVar = ip.P;
                ipVar.b(zI);
                if (zI) {
                    ipVar.b(jpVarH.j(), context);
                    ipVar.c(jpVarH.l(), context);
                    ipVar.a(jpVarH.k(), context);
                    ipVar.a(jpVarH.g());
                    ipVar.d(jpVarH.h());
                }
            }
            h4VarG = lsVar.c().getBannerConfigurations().g();
        }
        a(h4VarG, context, lsVar);
        ipVar = ip.P;
        ipVar.b(zI);
        if (zI) {
            ipVar.b(jpVarH.j(), context);
            ipVar.c(jpVarH.l(), context);
            ipVar.a(jpVarH.k(), context);
            ipVar.a(jpVarH.g());
            ipVar.d(jpVarH.h());
        }
    }

    private void a(IronSource.AD_UNIT ad_unit) {
        String str = ad_unit + " ad unit has already been initialized";
        this.h.log(IronSourceLogger.IronSourceTag.API, str, 3);
        IronSourceUtils.sendAutomationLog(str);
    }

    private void a(IronSource.AD_UNIT ad_unit, boolean z) {
        ConcurrentHashMap concurrentHashMap;
        int i = b.f4000a[ad_unit.ordinal()];
        if (i == 1) {
            if (!this.F) {
                if (this.Y) {
                    if (this.Z) {
                        this.Z = false;
                        n.a().b(IronSource.AD_UNIT.REWARDED_VIDEO, ErrorBuilder.buildInitFailedError("init() had failed", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
                        return;
                    }
                    return;
                }
                if (z || L() || this.A.contains(ad_unit)) {
                    dq.a().a(false, (AdInfo) null);
                    return;
                }
                return;
            }
            Iterator<h.d> it = this.g0.values().iterator();
            while (it.hasNext()) {
                String strC = it.next().getInstanceId();
                this.s0.a(strC).onRewardedVideoAdLoadFailed(strC, ErrorBuilder.buildInitFailedError("initISDemandOnly() had failed", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            }
            concurrentHashMap = this.g0;
        } else if (i != 2) {
            if (i != 3) {
                return;
            }
            if (!this.H) {
                if (this.M.booleanValue()) {
                    this.M = Boolean.FALSE;
                    n.a().b(IronSource.AD_UNIT.BANNER, new IronSourceError(602, "init() had failed"));
                    this.N = null;
                    this.O = null;
                    return;
                }
                return;
            }
            for (h.b bVar : this.f0.values()) {
                ISDemandOnlyBannerLayout iSDemandOnlyBannerLayoutG = bVar.getBanner();
                if (iSDemandOnlyBannerLayoutG != null) {
                    iSDemandOnlyBannerLayoutG.getListener().a(bVar.getInstanceId(), ErrorBuilder.buildInitFailedError("initISDemandOnly() had failed", "Banner"));
                }
            }
            concurrentHashMap = this.f0;
        } else {
            if (!this.G) {
                if (this.b0) {
                    this.b0 = false;
                    n.a().b(IronSource.AD_UNIT.INTERSTITIAL, ErrorBuilder.buildInitFailedError("init() had failed", "Interstitial"));
                    return;
                }
                return;
            }
            Iterator<h.d> it2 = this.e0.values().iterator();
            while (it2.hasNext()) {
                String strC2 = it2.next().getInstanceId();
                this.r0.a(strC2).onInterstitialAdLoadFailed(strC2, ErrorBuilder.buildInitFailedError("initISDemandOnly() had failed", "Interstitial"));
            }
            concurrentHashMap = this.e0;
        }
        concurrentHashMap.clear();
    }

    private synchronized void a(h.d dVar, ISDemandOnlyInterstitialListener iSDemandOnlyInterstitialListener) {
        String strC = dVar.getInstanceId();
        IronLog ironLog = IronLog.API;
        ironLog.info("instanceId=" + strC);
        try {
            if (!this.J) {
                ironLog.error("initISDemandOnly() must be called before loadISDemandOnlyInterstitial()");
                iSDemandOnlyInterstitialListener.onInterstitialAdLoadFailed(strC, new IronSourceError(510, "initISDemandOnly() must be called before loadISDemandOnlyInterstitial()"));
                return;
            }
            if (!this.G) {
                ironLog.error("Interstitial was initialized in mediation mode. Use loadInterstitial instead");
                iSDemandOnlyInterstitialListener.onInterstitialAdLoadFailed(strC, new IronSourceError(510, "Interstitial was initialized in mediation mode. Use loadInterstitial instead"));
                return;
            }
            s.d dVarA = s.c().a();
            if (dVarA == s.d.INIT_FAILED) {
                ironLog.error("init() had failed");
                iSDemandOnlyInterstitialListener.onInterstitialAdLoadFailed(strC, ErrorBuilder.buildInitFailedError("init() had failed", "Interstitial"));
                return;
            }
            IronSourceError ironSourceErrorA = dVar.a();
            if (ironSourceErrorA != null) {
                if (ironSourceErrorA.getErrorCode() == 1060) {
                    b(IronSourceConstants.TROUBLESHOOTING_DO_CALLED_IS_LOAD_WITH_NO_ACTIVITY, IronSourceUtils.getMediationAdditionalData(true, !TextUtils.isEmpty(dVar.getAdMarkup()), 1));
                }
                ironLog.error(ironSourceErrorA.toString());
                iSDemandOnlyInterstitialListener.onInterstitialAdLoadFailed(strC, ironSourceErrorA);
                return;
            }
            e(dVar.getActivity());
            if (dVarA == s.d.INIT_IN_PROGRESS) {
                if (s.c().d()) {
                    ironLog.error("init() had failed");
                    iSDemandOnlyInterstitialListener.onInterstitialAdLoadFailed(strC, ErrorBuilder.buildInitFailedError("init() had failed", "Interstitial"));
                } else {
                    synchronized (this.e0) {
                        this.e0.put(dVar.getInstanceId(), dVar);
                    }
                    if (!TextUtils.isEmpty(dVar.getInstanceId())) {
                        a(83003, IronSourceUtils.getMediationAdditionalData(true, !TextUtils.isEmpty(dVar.getAdMarkup()), 1));
                    }
                }
                return;
            }
            if (!E()) {
                ironLog.error("No interstitial configurations found");
                iSDemandOnlyInterstitialListener.onInterstitialAdLoadFailed(strC, ErrorBuilder.buildInitFailedError("the server response does not contain interstitial data", "Interstitial"));
                return;
            }
            synchronized (this.e0) {
                f fVar = this.h0;
                if (fVar == null) {
                    this.e0.put(dVar.getInstanceId(), dVar);
                    if (!TextUtils.isEmpty(dVar.getAdMarkup())) {
                        a(83003, IronSourceUtils.getMediationAdditionalData(true, !TextUtils.isEmpty(dVar.getAdMarkup()), 1));
                    }
                    return;
                }
                fVar.a(dVar);
            }
            throw th;
        } catch (Throwable th) {
            o9.d().a(th);
            IronLog.API.error(th.getMessage());
            iSDemandOnlyInterstitialListener.onInterstitialAdLoadFailed(strC, new IronSourceError(510, th.getMessage()));
        }
    }

    private void a(String str, r8 r8Var) {
        if (a(str, 1, 128)) {
            return;
        }
        r8Var.a(ErrorBuilder.buildInvalidKeyValueError(IronSourceConstants.EVENTS_DYNAMIC_USER_ID, "dynamicUserId is invalid, should be between 1-128 chars in length."));
    }

    private void a(JSONObject jSONObject, Object[][] objArr) {
        if (objArr != null) {
            try {
                for (Object[] objArr2 : objArr) {
                    jSONObject.put(objArr2[0].toString(), objArr2[1]);
                }
            } catch (Exception e) {
                o9.d().a(e);
                IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "IronSourceObject addToDictionary: " + Log.getStackTraceString(e), 3);
            }
        }
    }

    private void a(boolean z, String str) {
        if (z) {
            JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(this.F, true, this.d0);
            if (str != null) {
                a(mediationAdditionalData, new Object[][]{new Object[]{"placement", str}});
            }
            b(IronSourceConstants.RV_API_IS_CAPPED_TRUE, mediationAdditionalData);
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0057 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:15:0x0059  */
    /* JADX WARN: Code duplicated, block: B:16:0x005c  */
    private void a(boolean z, boolean z2, int i, JSONObject jSONObject, boolean z3) {
        String str;
        String str2;
        try {
            StringBuilder sb = new StringBuilder();
            if (!z2) {
                if (z) {
                    sb.append(String.format(",cachedUserAgent=%s", Boolean.valueOf(this.c.r())));
                    jSONObject.put(IronSourceConstants.EVENTS_EXT1, sb.toString());
                    jSONObject.put("sessionDepth", i);
                    if (z3) {
                        if (z2) {
                            str2 = "isMultipleAdObjects";
                        } else {
                            str2 = "isMultipleAdUnits";
                        }
                        jSONObject.put(str2, 1);
                    }
                } else {
                    sb.append(StringUtils.COMMA);
                    str = IronSourceConstants.EVENTS_INIT_CONTEXT_FLOW;
                }
                ar.i().a(new zb(14, jSONObject));
            }
            str = String.format(",Activity=%s", Boolean.valueOf(ContextProvider.getInstance().getCurrentActiveActivity() != null));
            sb.append(str);
            sb.append(String.format(",cachedUserAgent=%s", Boolean.valueOf(this.c.r())));
            jSONObject.put(IronSourceConstants.EVENTS_EXT1, sb.toString());
            jSONObject.put("sessionDepth", i);
            if (z3) {
                if (z2) {
                    str2 = "isMultipleAdObjects";
                } else {
                    str2 = "isMultipleAdUnits";
                }
                jSONObject.put(str2, 1);
            }
        } catch (Exception e) {
            o9.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
        ar.i().a(new zb(14, jSONObject));
    }

    private synchronized void a(boolean z, boolean z2, boolean z3, IronSource.AD_UNIT... ad_unitArr) {
        JSONObject mediationAdditionalData;
        int i = 0;
        for (IronSource.AD_UNIT ad_unit : ad_unitArr) {
            if (ad_unit.equals(IronSource.AD_UNIT.INTERSTITIAL)) {
                this.J = true;
            } else if (ad_unit.equals(IronSource.AD_UNIT.BANNER)) {
                this.K = true;
            } else if (ad_unit.equals(IronSource.AD_UNIT.REWARDED_VIDEO)) {
                this.I = true;
            } else if (ad_unit.equals(IronSource.AD_UNIT.NATIVE_AD)) {
                this.L = true;
            }
        }
        if (s.c().a() == s.d.INIT_FAILED) {
            try {
                if (this.i != null) {
                    int length = ad_unitArr.length;
                    while (i < length) {
                        IronSource.AD_UNIT ad_unit2 = ad_unitArr[i];
                        if (!this.z.contains(ad_unit2)) {
                            a(ad_unit2, true);
                        }
                        i++;
                    }
                }
            } catch (Exception e) {
                o9.d().a(e);
                IronLog.INTERNAL.error(e.toString());
            }
        }
        if (!C()) {
            mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(z2);
            int length2 = ad_unitArr.length;
            while (i < length2) {
                IronSource.AD_UNIT ad_unit3 = ad_unitArr[i];
                if (this.z.contains(ad_unit3)) {
                    this.h.log(IronSourceLogger.IronSourceTag.API, ad_unit3 + " ad unit has started initializing.", 3);
                } else {
                    this.z.add(ad_unit3);
                    this.A.add(ad_unit3);
                    try {
                        mediationAdditionalData.put(ad_unit3.toString(), true);
                    } catch (Exception e2) {
                        o9.d().a(e2);
                        IronLog.INTERNAL.error(e2.toString());
                    }
                }
                i++;
            }
            JSONObject jSONObject = mediationAdditionalData;
            int i2 = 1 + this.E;
            this.E = i2;
            a(z, z2, i2, jSONObject, z3);
        } else {
            if (this.v == null) {
                return;
            }
            try {
                new nm().a(this.m.c().getApplicationConfigurations().d().b(), B());
            } catch (Exception e3) {
                o9.d().a(e3);
                IronLog.INTERNAL.error(e3.toString());
            }
            mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(z2);
            for (IronSource.AD_UNIT ad_unit4 : ad_unitArr) {
                if (this.z.contains(ad_unit4)) {
                    a(ad_unit4);
                } else {
                    this.z.add(ad_unit4);
                    this.A.add(ad_unit4);
                    try {
                        mediationAdditionalData.put(ad_unit4.toString(), true);
                    } catch (Exception e4) {
                        o9.d().a(e4);
                        IronLog.INTERNAL.error(e4.toString());
                    }
                    List<IronSource.AD_UNIT> list = this.v;
                    if (list == null || !list.contains(ad_unit4)) {
                        a(ad_unit4, false);
                    } else {
                        b(ad_unit4);
                    }
                }
            }
            JSONObject jSONObject2 = mediationAdditionalData;
            int i3 = 1 + this.E;
            this.E = i3;
            a(z, z2, i3, jSONObject2, z3);
        }
    }

    private boolean a(h.b bVar) {
        if (s.c().a() != s.d.INIT_IN_PROGRESS) {
            return false;
        }
        synchronized (this.f0) {
            this.f0.put(bVar.getInstanceId(), bVar);
        }
        return true;
    }

    private boolean a(String str, int i, int i2) {
        return str != null && str.length() >= i && str.length() <= i2;
    }

    private void a0() {
        this.h.log(IronSourceLogger.IronSourceTag.INTERNAL, "Interstitial started in demand only mode", 0);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.m.j().b().size(); i++) {
            String str = this.m.j().b().get(i);
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(this.m.k().b(str));
            }
        }
        if (arrayList.isEmpty()) {
            JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false, false, 1);
            a(mediationAdditionalData, new Object[][]{new Object[]{"errorCode", 1010}});
            a(IronSourceConstants.TROUBLESHOOTING_IS_INIT_FAILED, mediationAdditionalData);
            a(IronSource.AD_UNIT.INTERSTITIAL, false);
            return;
        }
        synchronized (this.e0) {
            this.h0 = a((List<NetworkSettings>) arrayList);
        }
        Iterator<h.d> it = this.e0.values().iterator();
        while (it.hasNext()) {
            this.h0.a(it.next());
        }
        this.e0.clear();
    }

    private k b(List<NetworkSettings> list) {
        yq yqVarF = this.m.c().getRewardedVideoConfigurations();
        ra.a aVar = new ra.a("Mediation");
        if (yqVarF.d()) {
            aVar.a("isOneFlow", 1);
        }
        return new k(list, yqVarF, com.json.mediationsdk.c.b(), this.s0, n(), o(), new ra.b(ar.i(), aVar));
    }

    private void b(int i, JSONObject jSONObject) {
        ar.i().a(new zb(i, jSONObject));
    }

    private void b(h4 h4Var, Context context, ls lsVar) {
        ar.i().a(h4Var.c(), context);
        ar.i().b(h4Var.d(), context);
        ar.i().b(h4Var.f());
        ar.i().a(h4Var.e());
        ar.i().c(h4Var.a());
        ar.i().c(h4Var.i(), context);
        ar.i().a(h4Var.h(), context);
        ar.i().b(h4Var.j(), context);
        ar.i().d(h4Var.g(), context);
        ar.i().a(lsVar.c().getApplicationConfigurations().i());
        ar.i().a(h4Var.k());
        ar.i().d(h4Var.b());
    }

    private void b(IronSource.AD_UNIT ad_unit) {
        int i = b.f4000a[ad_unit.ordinal()];
        if (i == 1) {
            g0();
        } else if (i == 2) {
            c0();
        } else {
            if (i != 3) {
                return;
            }
            X();
        }
    }

    private boolean b(ls lsVar) {
        return lsVar != null && lsVar.o();
    }

    private boolean b(h.b bVar) {
        synchronized (this.f0) {
            if (this.j0 != null) {
                return false;
            }
            this.f0.put(bVar.getInstanceId(), bVar);
            return true;
        }
    }

    private boolean b(List<IronSource.AD_UNIT> list, boolean z, s8 s8Var) {
        IronLog.INTERNAL.verbose();
        try {
            this.j.a(s8Var.getApplicationConfigurations().g().d());
            this.v = list;
            c(true);
            this.h.log(IronSourceLogger.IronSourceTag.API, "onInitSuccess()", 1);
            IronSourceUtils.sendAutomationLog("init success");
            if (z) {
                JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false);
                try {
                    mediationAdditionalData.put("revived", true);
                } catch (JSONException e) {
                    o9.d().a(e);
                    IronLog.INTERNAL.error(e.toString());
                }
                ar.i().a(new zb(114, mediationAdditionalData));
            }
            int cmpId = s8Var.getApplicationConfigurations().e().getCmpId();
            if (cmpId >= 0) {
                z8 z8Var = new z8();
                z8Var.a(cmpId);
                z8Var.a(cmpId, this.m.k().d());
            }
            oj.i().h();
            ar.i().h();
            com.json.mediationsdk.c.b().b(n(), o());
            for (IronSource.AD_UNIT ad_unit : IronSource.AD_UNIT.values()) {
                if (this.z.contains(ad_unit)) {
                    if (list.contains(ad_unit)) {
                        b(ad_unit);
                    } else {
                        a(ad_unit, false);
                    }
                }
            }
            if (x() && W()) {
                AdQualityBridge adQualityBridge = new AdQualityBridge(ContextProvider.getInstance().getApplicationContext(), n(), o(), new i1(), this.m.c().getApplicationConfigurations().g().a());
                this.o0 = adQualityBridge;
                IronSourceSegment ironSourceSegment = this.C;
                if (ironSourceSegment != null) {
                    adQualityBridge.setSegment(ironSourceSegment);
                }
            }
            T();
            eo eoVarR = r();
            if (eoVarR != null) {
                eoVarR.a(this.m);
            }
            return true;
        } catch (Exception e2) {
            o9.d().a(e2);
            IronLog.INTERNAL.error(e2.toString());
            eo eoVarR2 = r();
            if (eoVarR2 != null) {
                eoVarR2.onInitFailed(new IronSourceError(IronSourceError.ERROR_LEGACY_INIT_POST_FAILED, "onInitSuccess() had failed"));
            }
            return false;
        }
    }

    private void b0() {
        this.h.log(IronSourceLogger.IronSourceTag.INTERNAL, "Rewarded Video started in demand only mode", 0);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.m.j().d().size(); i++) {
            String str = this.m.j().d().get(i);
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(this.m.k().b(str));
            }
        }
        if (arrayList.isEmpty()) {
            a(IronSource.AD_UNIT.REWARDED_VIDEO, false);
            return;
        }
        synchronized (this.g0) {
            this.i0 = b(arrayList);
        }
        if (ContextProvider.getInstance().getCurrentActiveActivity() == null) {
            a(IronSource.AD_UNIT.REWARDED_VIDEO, false);
            return;
        }
        Iterator<h.d> it = this.g0.values().iterator();
        while (it.hasNext()) {
            this.i0.a(it.next());
        }
        this.g0.clear();
    }

    private synchronized void c(boolean z) {
        this.u = z;
    }

    private void c0() {
        if (this.G) {
            a0();
        } else {
            d0();
        }
    }

    private void d(Activity activity, String str) {
        try {
            InterstitialPlacement interstitialPlacementM = m(str);
            if (interstitialPlacementM == null) {
                interstitialPlacementM = i();
            }
            if (interstitialPlacementM == null) {
                this.h.log(IronSourceLogger.IronSourceTag.INTERNAL, "showProgrammaticInterstitial error: empty default placement in response", 3);
                sg.a().a(new IronSourceError(1020, "showProgrammaticInterstitial error: empty default placement in response"), (AdInfo) null);
                return;
            }
            if (activity != null) {
                e(activity);
            } else if (ContextProvider.getInstance().getCurrentActiveActivity() == null) {
                this.h.log(IronSourceLogger.IronSourceTag.API, "Activity must be provided in showInterstitial when initializing SDK with context", 3);
                sg.a().a(new IronSourceError(510, "Activity must be provided in showInterstitial when initializing SDK with context"), (AdInfo) null);
                return;
            }
            this.S.a(activity, new Placement(interstitialPlacementM));
        } catch (Exception e) {
            o9.d().a(e);
            this.h.logException(IronSourceLogger.IronSourceTag.API, "showProgrammaticInterstitial()", e);
        }
    }

    private void d(Context context) {
        AtomicBoolean atomicBoolean = this.k;
        if (atomicBoolean == null || !atomicBoolean.compareAndSet(false, true)) {
            return;
        }
        st.a().a(new de(context));
        oj.i().a(context, this.C);
        ar.i().a(context, this.C);
        ip.P.a(context, this.C);
    }

    private void d0() {
        IronLog.INTERNAL.verbose();
        List<NetworkSettings> listA = a(this.m.j().b());
        if (listA.size() <= 0) {
            JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false, true, 1);
            a(mediationAdditionalData, new Object[][]{new Object[]{"errorCode", 1010}});
            a(IronSourceConstants.TROUBLESHOOTING_IS_INIT_FAILED, mediationAdditionalData);
            a(IronSource.AD_UNIT.INTERSTITIAL, false);
            return;
        }
        hj hjVar = new hj(listA, this.m.c().getInterstitialConfigurations(), IronSourceUtils.getUserIdForNetworks(), qk.b(), this.C);
        this.S = hjVar;
        Boolean bool = this.y;
        if (bool != null) {
            hjVar.a(this.x, bool.booleanValue());
        }
        if (this.b0) {
            this.b0 = false;
            this.S.A();
        }
    }

    private void e(Activity activity) {
        ContextProvider.getInstance().updateActivity(activity);
        IronLog.INTERNAL.verbose("activity is updated to: " + activity.hashCode());
    }

    private void e(Activity activity, String str) {
        Placement placementP;
        try {
            placementP = p(str);
            if (placementP == null) {
                try {
                    placementP = j();
                } catch (Exception e) {
                    e = e;
                    o9.d().a(e);
                    this.h.logException(IronSourceLogger.IronSourceTag.API, "showProgrammaticRewardedVideo()", e);
                }
            }
            if (placementP == null) {
                this.h.log(IronSourceLogger.IronSourceTag.INTERNAL, "showProgrammaticRewardedVideo error: empty default placement in response", 3);
                dq.a().a(new IronSourceError(1021, "showProgrammaticRewardedVideo error: empty default placement in response"), (AdInfo) null);
                return;
            }
        } catch (Exception e2) {
            e = e2;
            placementP = null;
        }
        if (activity != null) {
            e(activity);
        } else if (ContextProvider.getInstance().getCurrentActiveActivity() == null) {
            this.h.log(IronSourceLogger.IronSourceTag.API, "Activity must be provided in showRewardedVideo when initializing SDK with context", 3);
            dq.a().a(ErrorBuilder.buildInitFailedError("Activity must be provided in showRewardedVideo when initializing SDK with context", IronSourceConstants.REWARDED_VIDEO_AD_UNIT), (AdInfo) null);
            return;
        }
        vq vqVar = this.T;
        if (vqVar != null && (this.Y || this.a0)) {
            vqVar.a(activity, placementP);
            return;
        }
        dg dgVar = this.Q;
        if (dgVar != null) {
            dgVar.a(activity, placementP);
            return;
        }
        this.h.log(IronSourceLogger.IronSourceTag.API, "showProgrammaticRewardedVideo - show called before init completed, managers not initiated yet", 3);
        dq.a().a(new IronSourceError(1023, "showProgrammaticRewardedVideo - show called before init completed, managers not initiated yet"), (AdInfo) null);
    }

    private void e0() {
        this.h.log(IronSourceLogger.IronSourceTag.INTERNAL, "Rewarded Video started in programmatic mode", 0);
        List<NetworkSettings> listA = a(this.m.j().d());
        if (listA.size() <= 0) {
            JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false, true, this.d0);
            a(mediationAdditionalData, new Object[][]{new Object[]{"errorCode", 1010}});
            b(IronSourceConstants.TROUBLESHOOTING_RV_INIT_FAILED, mediationAdditionalData);
            a(IronSource.AD_UNIT.REWARDED_VIDEO, false);
            return;
        }
        q qVar = new q(listA, this.m.c().getRewardedVideoConfigurations(), n(), IronSourceUtils.getUserIdForNetworks(), qk.b().a(), this.C);
        this.Q = qVar;
        Boolean bool = this.y;
        if (bool != null) {
            qVar.a(this.x, bool.booleanValue());
        }
    }

    private void f0() {
        IronLog.INTERNAL.verbose();
        List<NetworkSettings> listA = a(this.m.j().a());
        if (listA.size() > 0) {
            this.h.log(IronSourceLogger.IronSourceTag.INTERNAL, "Banner started in programmatic mode", 0);
            this.R = new w(listA, new k(n(), IronSourceUtils.getUserIdForNetworks(), this.m.c().getBannerConfigurations()), qk.b().a(), this.C);
            v();
        } else {
            JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false, true, 1);
            a(mediationAdditionalData, new Object[][]{new Object[]{"errorCode", 1010}});
            a(IronSourceConstants.TROUBLESHOOTING_BN_INIT_FAILED, mediationAdditionalData);
            a(IronSource.AD_UNIT.BANNER, false);
        }
    }

    private void g0() {
        if (this.F) {
            b0();
            return;
        }
        yq yqVarF = this.m.c().getRewardedVideoConfigurations();
        this.a0 = yqVarF.k().h();
        this.d0 = a(yqVarF);
        if (this.Y || this.a0) {
            h0();
        } else {
            e0();
        }
    }

    private void h0() {
        IronLog.INTERNAL.verbose();
        List<NetworkSettings> listA = a(this.m.j().d());
        if (listA.size() <= 0) {
            JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false, true, this.d0);
            a(mediationAdditionalData, new Object[][]{new Object[]{"errorCode", 1010}});
            b(IronSourceConstants.TROUBLESHOOTING_RV_INIT_FAILED, mediationAdditionalData);
            a(IronSource.AD_UNIT.REWARDED_VIDEO, false);
            return;
        }
        vq vqVar = new vq(listA, this.m.c().getRewardedVideoConfigurations(), IronSourceUtils.getUserIdForNetworks(), this.Y, qk.b(), this.C);
        this.T = vqVar;
        Boolean bool = this.y;
        if (bool != null) {
            vqVar.a(this.x, bool.booleanValue());
        }
        if (this.Z && this.Y) {
            this.Z = false;
            this.T.A();
        }
    }

    private InterstitialPlacement i() {
        mj mjVarD = this.m.c().getInterstitialConfigurations();
        if (mjVarD != null) {
            return mjVarD.a();
        }
        return null;
    }

    private Placement j() {
        yq yqVarF = this.m.c().getRewardedVideoConfigurations();
        if (yqVarF != null) {
            return yqVarF.a();
        }
        return null;
    }

    private h7 k(String str) {
        h7 h7VarA;
        u6 u6VarC = this.m.c().getBannerConfigurations();
        if (u6VarC == null) {
            return new lb();
        }
        return (TextUtils.isEmpty(str) || (h7VarA = u6VarC.a(str)) == null) ? u6VarC.i() : h7VarA;
    }

    private ra k() {
        return new ra.b(ar.i(), new ra.a("IronSource"));
    }

    private op.b l(String str) {
        InterstitialPlacement interstitialPlacementM;
        ls lsVar = this.m;
        if (lsVar == null || lsVar.c() == null || this.m.c().getInterstitialConfigurations() == null) {
            return op.b.NOT_CAPPED;
        }
        try {
            interstitialPlacementM = m(str);
            if (interstitialPlacementM == null) {
                try {
                    interstitialPlacementM = i();
                    if (interstitialPlacementM == null) {
                        this.h.log(IronSourceLogger.IronSourceTag.API, "Default placement was not found", 3);
                    }
                } catch (Exception e) {
                    e = e;
                    o9.d().a(e);
                    IronLog.INTERNAL.error(e.toString());
                }
            }
        } catch (Exception e2) {
            e = e2;
            interstitialPlacementM = null;
        }
        return interstitialPlacementM == null ? op.b.NOT_CAPPED : a(interstitialPlacementM);
    }

    private InterstitialPlacement m(String str) {
        mj mjVarD = this.m.c().getInterstitialConfigurations();
        if (mjVarD != null) {
            return mjVarD.a(str);
        }
        return null;
    }

    public static p m() {
        return d.f4001a;
    }

    private op.b o(String str) {
        Placement placementP;
        ls lsVar = this.m;
        if (lsVar == null || lsVar.c() == null || this.m.c().getRewardedVideoConfigurations() == null) {
            return op.b.NOT_CAPPED;
        }
        try {
            placementP = p(str);
            if (placementP == null) {
                try {
                    placementP = j();
                    if (placementP == null) {
                        this.h.log(IronSourceLogger.IronSourceTag.API, "Default placement was not found", 3);
                    }
                } catch (Exception e) {
                    e = e;
                    o9.d().a(e);
                    IronLog.INTERNAL.error(e.toString());
                }
            }
        } catch (Exception e2) {
            e = e2;
            placementP = null;
        }
        return placementP == null ? op.b.NOT_CAPPED : a(placementP);
    }

    private Placement p(String str) {
        yq yqVarF = this.m.c().getRewardedVideoConfigurations();
        if (yqVarF != null) {
            return yqVarF.a(str);
        }
        return null;
    }

    private synchronized eo r() {
        return this.W;
    }

    private boolean u(String str) {
        if (str == null) {
            return false;
        }
        return str.matches("^[a-zA-Z0-9]*$");
    }

    private r8 v(String str) {
        IronSourceError ironSourceError;
        String str2;
        r8 r8Var = new r8();
        if (str != null) {
            if (a(str, 5, 10)) {
                str2 = u(str) ? "length should be between 5-10 characters" : "should contain only english characters and numbers";
                return r8Var;
            }
            ironSourceError = ErrorBuilder.buildInvalidCredentialsError("appKey", str, str2);
        } else {
            ironSourceError = new IronSourceError(506, "Init Fail - appKey is missing");
        }
        r8Var.a(ironSourceError);
        return r8Var;
    }

    private void v() {
        if (this.M.booleanValue()) {
            IronLog.INTERNAL.verbose("load banner after init");
            this.M = Boolean.FALSE;
            a(this.N, this.O);
            this.N = null;
            this.O = null;
        }
    }

    private void w() {
        this.h = IronSourceLoggerManager.getLogger(0);
        com.json.mediationsdk.logger.b bVar = new com.json.mediationsdk.logger.b(null, 1);
        this.j = bVar;
        this.h.addLogger(bVar);
        this.i = new yl();
    }

    private boolean x() {
        try {
            IronLog.INTERNAL.verbose("AdQuality SDK exist: " + Class.forName("com.ironsource.adqualitysdk.sdk.IronSourceAdQuality").getName());
            return true;
        } catch (Throwable th) {
            o9.d().a(th);
            IronLog.INTERNAL.verbose("No AdQuality SDK found");
            return false;
        }
    }

    private boolean y() {
        ls lsVar = this.m;
        return (lsVar == null || lsVar.c() == null || this.m.c().getBannerConfigurations() == null) ? false : true;
    }

    private boolean z() {
        return y() && A();
    }

    boolean B() {
        return this.F || this.G || this.H;
    }

    public boolean F() {
        boolean z;
        try {
            if (this.G) {
                this.h.log(IronSourceLogger.IronSourceTag.API, "Interstitial was initialized in demand only mode. Use isISDemandOnlyInterstitialReady instead", 3);
                return false;
            }
            hj hjVar = this.S;
            boolean z2 = hjVar != null && hjVar.u();
            try {
                oj.i().a(new zb(z2 ? 2101 : 2102, IronSourceUtils.getMediationAdditionalData(false, true, 1)));
                this.h.log(IronSourceLogger.IronSourceTag.API, "isInterstitialReady():" + z2, 1);
                return z2;
            } catch (Throwable th) {
                z = z2;
                th = th;
                o9.d().a(th);
                IronSourceLoggerManager ironSourceLoggerManager = this.h;
                IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
                ironSourceLoggerManager.log(ironSourceTag, "isInterstitialReady():" + z, 1);
                this.h.logException(ironSourceTag, "isInterstitialReady()", th);
                return false;
            }
        } catch (Throwable th2) {
            th = th2;
            z = false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0033  */
    public boolean K() {
        boolean z;
        boolean z2;
        try {
            if (this.F) {
                this.h.log(IronSourceLogger.IronSourceTag.API, "Rewarded Video was initialized in demand only mode. Use isISDemandOnlyRewardedVideoAvailable instead", 3);
                return false;
            }
            if (this.Y || this.a0) {
                vq vqVar = this.T;
                if (vqVar == null || !vqVar.u()) {
                    z2 = false;
                } else {
                    z2 = true;
                }
            } else {
                dg dgVar = this.Q;
                if (dgVar == null || !dgVar.d()) {
                    z2 = false;
                } else {
                    z2 = true;
                }
            }
            try {
                JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false);
                a(mediationAdditionalData, new Object[][]{new Object[]{IronSourceConstants.EVENTS_PROGRAMMATIC, Integer.valueOf(this.d0)}});
                ar.i().a(new zb(z2 ? 1101 : IronSourceConstants.RV_API_HAS_AVAILABILITY_FALSE, mediationAdditionalData));
                this.h.log(IronSourceLogger.IronSourceTag.API, "isRewardedVideoAvailable():" + z2, 1);
                return z2;
            } catch (Throwable th) {
                z = z2;
                th = th;
                o9.d().a(th);
                IronSourceLoggerManager ironSourceLoggerManager = this.h;
                IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
                ironSourceLoggerManager.log(ironSourceTag, "isRewardedVideoAvailable():" + z, 1);
                this.h.logException(ironSourceTag, "isRewardedVideoAvailable()", th);
                return false;
            }
        } catch (Throwable th2) {
            th = th2;
            z = false;
        }
    }

    public boolean O() {
        return C();
    }

    public void P() {
        IronSourceLoggerManager ironSourceLoggerManager = this.h;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
        ironSourceLoggerManager.log(ironSourceTag, "loadInterstitial()", 1);
        try {
            if (this.G) {
                this.h.log(ironSourceTag, "Interstitial was initialized in demand only mode. Use loadISDemandOnlyInterstitial instead", 3);
                n.a().b(IronSource.AD_UNIT.INTERSTITIAL, ErrorBuilder.buildInitFailedError("Interstitial was initialized in demand only mode. Use loadISDemandOnlyInterstitial instead", "Interstitial"));
                return;
            }
            if (!this.J) {
                this.h.log(ironSourceTag, "init() must be called before loadInterstitial()", 3);
                n.a().b(IronSource.AD_UNIT.INTERSTITIAL, ErrorBuilder.buildInitFailedError("init() must be called before loadInterstitial()", "Interstitial"));
                return;
            }
            s.d dVarA = s.c().a();
            if (dVarA == s.d.INIT_FAILED) {
                this.h.log(ironSourceTag, "init() had failed", 3);
                n.a().b(IronSource.AD_UNIT.INTERSTITIAL, ErrorBuilder.buildInitFailedError("init() had failed", "Interstitial"));
                return;
            }
            if (dVarA == s.d.INIT_IN_PROGRESS) {
                if (!s.c().d()) {
                    this.b0 = true;
                    return;
                } else {
                    this.h.log(ironSourceTag, "init() had failed", 3);
                    n.a().b(IronSource.AD_UNIT.INTERSTITIAL, ErrorBuilder.buildInitFailedError("init() had failed", "Interstitial"));
                    return;
                }
            }
            if (!E()) {
                this.h.log(ironSourceTag, "No interstitial configurations found", 3);
                n.a().b(IronSource.AD_UNIT.INTERSTITIAL, ErrorBuilder.buildInitFailedError("the server response does not contain interstitial data", "Interstitial"));
                return;
            }
            hj hjVar = this.S;
            if (hjVar == null) {
                this.b0 = true;
            } else {
                hjVar.A();
            }
        } catch (Throwable th) {
            o9.d().a(th);
            this.h.logException(IronSourceLogger.IronSourceTag.API, "loadInterstitial()", th);
            n.a().b(IronSource.AD_UNIT.INTERSTITIAL, new IronSourceError(510, th.getMessage()));
        }
    }

    public void Q() {
        IronSourceLoggerManager ironSourceLoggerManager = this.h;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
        ironSourceLoggerManager.log(ironSourceTag, "loadRewardedVideo()", 1);
        try {
            if (this.F) {
                this.h.log(ironSourceTag, "Rewarded Video was initialized in demand only mode. Use loadISDemandOnlyRewardedVideo instead", 3);
                n.a().b(IronSource.AD_UNIT.REWARDED_VIDEO, ErrorBuilder.buildInitFailedError("Rewarded Video was initialized in demand only mode. Use loadISDemandOnlyRewardedVideo instead", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
                return;
            }
            if (!this.Y && !this.n0) {
                this.h.log(ironSourceTag, "Rewarded Video is not initiated with manual load", 3);
                return;
            }
            if (!this.I) {
                this.h.log(ironSourceTag, "init() must be called before loadRewardedVideo()", 3);
                n.a().b(IronSource.AD_UNIT.REWARDED_VIDEO, ErrorBuilder.buildInitFailedError("init() must be called before loadRewardedVideo()", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
                return;
            }
            s.d dVarA = s.c().a();
            if (dVarA == s.d.INIT_FAILED) {
                this.h.log(ironSourceTag, "init() had failed", 3);
                n.a().b(IronSource.AD_UNIT.REWARDED_VIDEO, ErrorBuilder.buildInitFailedError("init() had failed", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
                return;
            }
            if (dVarA == s.d.INIT_IN_PROGRESS) {
                if (!s.c().d()) {
                    this.Z = true;
                    return;
                } else {
                    this.h.log(ironSourceTag, "init() had failed", 3);
                    n.a().b(IronSource.AD_UNIT.REWARDED_VIDEO, ErrorBuilder.buildInitFailedError("init() had failed", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
                    return;
                }
            }
            if (!M()) {
                this.h.log(ironSourceTag, "No rewarded video configurations found", 3);
                n.a().b(IronSource.AD_UNIT.REWARDED_VIDEO, ErrorBuilder.buildInitFailedError("the server response does not contain rewarded video data", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
                return;
            }
            vq vqVar = this.T;
            if (vqVar == null) {
                this.Z = true;
            } else {
                vqVar.A();
            }
        } catch (Throwable th) {
            o9.d().a(th);
            this.h.logException(IronSourceLogger.IronSourceTag.API, "loadRewardedVideo()", th);
            n.a().b(IronSource.AD_UNIT.REWARDED_VIDEO, new IronSourceError(510, th.getMessage()));
        }
    }

    public void R() {
        hj hjVar = this.S;
        if (hjVar != null) {
            hjVar.a((eu) null);
        }
        vq vqVar = this.T;
        if (vqVar != null) {
            vqVar.a((eu) null);
        }
        g6 g6Var = this.U;
        if (g6Var != null) {
            g6Var.a((eu) null);
        }
        this.n0 = false;
    }

    public void S() {
        IronLog.API.info("removing all impression data listeners");
        qk.b().d();
        dg dgVar = this.Q;
        if (dgVar != null) {
            dgVar.c();
        }
        w wVar = this.R;
        if (wVar != null) {
            wVar.c();
        }
    }

    public void U() {
        if (t0) {
            return;
        }
        t0 = true;
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false);
        try {
            mediationAdditionalData.put("status", "false");
            mediationAdditionalData.put("errorCode", 1);
        } catch (JSONException e) {
            o9.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
        ar.i().a(new zb(114, mediationAdditionalData));
    }

    public ls a(Context context, String str) {
        if (si.a(context)) {
            d8 d8VarC = si.c(context);
            String strD = d8VarC.d();
            String strF = d8VarC.f();
            String strE = d8VarC.e();
            if (strD.equals(str)) {
                ls lsVar = new ls(context, strD, strF, strE);
                lsVar.a(ls.a.CACHE);
                return lsVar;
            }
        }
        return null;
    }

    @Override // com.ironsource.qa.a
    public ISDemandOnlyBannerLayout a(Activity activity, ISBannerSize iSBannerSize) {
        IronSourceLoggerManager ironSourceLoggerManager = this.h;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
        ironSourceLoggerManager.log(ironSourceTag, "createBannerForDemandOnly()", 1);
        if (activity == null) {
            this.h.log(ironSourceTag, "createBannerForDemandOnly() : Activity cannot be null", 3);
            return null;
        }
        ContextProvider.getInstance().updateActivity(activity);
        return new ISDemandOnlyBannerLayout(activity, iSBannerSize);
    }

    public synchronized IronSourceError a(Context context, String str, boolean z, InitializationListener initializationListener, eo eoVar, IronSource.AD_UNIT... ad_unitArr) {
        IronLog.INTERNAL.verbose("GitHash: de66667");
        j.f3792a.a(context);
        if (!fk.a((Object) context, "Init Failed - provided context is null")) {
            d("Provided context is null");
            return new IronSourceError(2000, "Provided context is null");
        }
        this.g.a(context);
        boolean z2 = context instanceof Activity;
        if (z2) {
            e((Activity) context);
        }
        if (initializationListener != null) {
            this.V = initializationListener;
        }
        if (!z) {
            this.p0.set(true);
        }
        AtomicBoolean atomicBoolean = this.t;
        if (atomicBoolean == null || !atomicBoolean.compareAndSet(true, false)) {
            if (ad_unitArr != null) {
                a(z2, z, eoVar != null, ad_unitArr);
                if (C() && !z) {
                    T();
                }
            } else {
                this.h.log(IronSourceLogger.IronSourceTag.API, "Multiple calls to init without ad units are not allowed", 3);
            }
            zr zrVarB = as.f3534a.b();
            if (C()) {
                return new IronSourceError(IronSourceError.ERROR_INIT_ALREADY_FINISHED, "Already finished init");
            }
            if (zrVarB == zr.INIT_FAILED) {
                return new IronSourceError(IronSourceError.ERROR_LEGACY_INIT_FAILED, "Legacy init failed");
            }
            if (zrVarB == zr.NOT_INIT) {
                return new IronSourceError(2020, "Already called new init");
            }
            if (eoVar != null) {
                a(eoVar);
            }
            return new IronSourceError(IronSourceError.ERROR_OLD_API_INIT_IN_PROGRESS, "Old Api init in progress");
        }
        as.f3534a.a(eoVar == null);
        if ((ad_unitArr == null || ad_unitArr.length == 0) && eoVar == null) {
            for (IronSource.AD_UNIT ad_unit : IronSource.AD_UNIT.values()) {
                this.z.add(ad_unit);
            }
            this.I = true;
            this.J = true;
            this.K = true;
            this.L = true;
        } else {
            for (IronSource.AD_UNIT ad_unit2 : ad_unitArr) {
                this.z.add(ad_unit2);
                this.A.add(ad_unit2);
                if (ad_unit2.equals(IronSource.AD_UNIT.INTERSTITIAL)) {
                    this.J = true;
                }
                if (ad_unit2.equals(IronSource.AD_UNIT.BANNER)) {
                    this.K = true;
                }
                if (ad_unit2.equals(IronSource.AD_UNIT.NATIVE_AD)) {
                    this.L = true;
                }
                if (ad_unit2.equals(IronSource.AD_UNIT.REWARDED_VIDEO)) {
                    this.I = true;
                }
            }
        }
        IronLog.API.info("init(appKey:" + str + ")");
        r8 r8VarV = v(str);
        if (r8VarV.b()) {
            this.n = str;
        }
        ls lsVarA = a(context, this.n);
        if (lsVarA != null) {
            IronLog.INTERNAL.verbose("init cache exists");
            a(lsVarA.c().getApplicationConfigurations().e());
        } else {
            IronLog.INTERNAL.verbose("init cache does not exist");
        }
        ContextProvider.getInstance().updateAppContext(context.getApplicationContext());
        this.d.a(context.getApplicationContext(), TimeUnit.HOURS.toMillis(xa.f4585a.d()));
        this.l0.f(IronSourceUtils.getSDKVersion());
        this.l0.a(fg.a());
        this.l0.b(IronSourceUtils.isGooglePlayInstalled(context));
        this.l0.a(k1.a());
        V();
        d(context);
        if (this.n == null) {
            s.c().f();
            if (this.z.contains(IronSource.AD_UNIT.REWARDED_VIDEO)) {
                dq.a().a(false, (AdInfo) null);
            }
            IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, r8VarV.a().toString(), 1);
            return new IronSourceError(2010, "App key is null");
        }
        this.l0.a(context);
        this.l0.b(this.n);
        this.l0.h(this.w);
        this.l0.g(ConfigFile.getConfigFile().getPluginType());
        if (this.B) {
            JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(z);
            if (ad_unitArr != null) {
                for (IronSource.AD_UNIT ad_unit3 : ad_unitArr) {
                    try {
                        mediationAdditionalData.put(ad_unit3.toString(), true);
                    } catch (Exception e) {
                        o9.d().a(e);
                    }
                }
            }
            int i = this.E + 1;
            this.E = i;
            a(z2, z, i, mediationAdditionalData, eoVar != null);
            this.B = false;
        }
        return null;
    }

    op.b a(InterstitialPlacement interstitialPlacement) {
        return this.e.a(ContextProvider.getInstance().getApplicationContext(), interstitialPlacement, IronSource.AD_UNIT.INTERSTITIAL);
    }

    op.b a(Placement placement) {
        return this.e.a(ContextProvider.getInstance().getApplicationContext(), placement, IronSource.AD_UNIT.REWARDED_VIDEO);
    }

    @Override // com.json.qa
    public String a(Context context) {
        dv dvVarJ;
        ra raVarK = k();
        zr zrVarA = as.f3534a.a();
        raVarK.a(IronSourceConstants.TROUBLESHOOTING_DO_GET_BIDDING_DATA_CALLED_IN_INIT_STATUS, zrVarA);
        if (context == null) {
            IronLog.API.error("bidding data cannot be retrieved, context required");
            raVarK.a(IronSourceConstants.TROUBLESHOOTING_DO_GET_BIDDING_DATA_CALLED_WITHOUT_CONTEXT, (zr) null);
            return null;
        }
        if (zrVarA == zr.NOT_INIT) {
            IronLog.API.error("bidding data cannot be retrieved, SDK not initialized");
            return null;
        }
        s.c().g();
        ls lsVar = this.m;
        boolean zE = (lsVar == null || (dvVarJ = lsVar.c().getApplicationConfigurations().j()) == null) ? true : dvVarJ.e();
        this.l0.b(context);
        JSONObject jSONObjectA = new cv().a(context);
        com.json.mediationsdk.d.b().a(jSONObjectA, true);
        String string = jSONObjectA.toString();
        String strCompressAndEncrypt = zE ? IronSourceAES.compressAndEncrypt(string) : IronSourceAES.encrypt(string);
        if (strCompressAndEncrypt == null) {
            raVarK.a(IronSourceConstants.TROUBLESHOOTING_DO_GET_BIDDING_DATA_RETURNED_NULL, (zr) null);
        }
        return strCompressAndEncrypt;
    }

    String a(String str, op.b bVar) {
        if (bVar == null) {
            return null;
        }
        int i = b.c[bVar.ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            return "placement " + str + " is capped";
        }
        return null;
    }

    HashSet<String> a(String str, String str2) {
        ls lsVar = this.m;
        return lsVar == null ? new HashSet<>() : lsVar.k().a(str, str2);
    }

    public synchronized List<IronSource.AD_UNIT> a(Context context, String str, boolean z, IronSource.AD_UNIT... ad_unitArr) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        if ((ad_unitArr == null || ad_unitArr.length == 0) && z) {
            if (this.I) {
                a(IronSource.AD_UNIT.REWARDED_VIDEO);
            } else {
                this.F = true;
                arrayList.add(IronSource.AD_UNIT.REWARDED_VIDEO);
            }
            if (this.J) {
                a(IronSource.AD_UNIT.INTERSTITIAL);
            } else {
                this.G = true;
                arrayList.add(IronSource.AD_UNIT.INTERSTITIAL);
            }
            if (this.K) {
                a(IronSource.AD_UNIT.BANNER);
            } else {
                this.H = true;
                arrayList.add(IronSource.AD_UNIT.BANNER);
            }
        } else {
            for (IronSource.AD_UNIT ad_unit : ad_unitArr) {
                if (ad_unit.equals(IronSource.AD_UNIT.INTERSTITIAL)) {
                    if (this.J) {
                        a(ad_unit);
                    } else {
                        this.G = true;
                        if (!arrayList.contains(ad_unit)) {
                            arrayList.add(ad_unit);
                        }
                    }
                }
                if (ad_unit.equals(IronSource.AD_UNIT.REWARDED_VIDEO)) {
                    if (this.I) {
                        a(ad_unit);
                    } else {
                        this.F = true;
                        if (!arrayList.contains(ad_unit)) {
                            arrayList.add(ad_unit);
                        }
                    }
                }
                if (ad_unit.equals(IronSource.AD_UNIT.BANNER)) {
                    if (this.K) {
                        a(ad_unit);
                    } else {
                        this.H = true;
                        if (!arrayList.contains(ad_unit)) {
                            arrayList.add(ad_unit);
                        }
                    }
                }
            }
        }
        if (context != null) {
            if (context instanceof Activity) {
                e((Activity) context);
            }
            ContextProvider.getInstance().updateAppContext(context.getApplicationContext());
        }
        return arrayList;
    }

    @Override // com.json.mo
    public void a() {
        if (this.M.booleanValue()) {
            this.M = Boolean.FALSE;
            n.a().b(IronSource.AD_UNIT.BANNER, new IronSourceError(603, "init() had failed"));
            this.N = null;
            this.O = null;
        }
        if (this.b0) {
            this.b0 = false;
            n.a().b(IronSource.AD_UNIT.INTERSTITIAL, ErrorBuilder.buildInitFailedError("init() had failed", "Interstitial"));
        }
        if (this.Z) {
            this.Z = false;
            n.a().b(IronSource.AD_UNIT.REWARDED_VIDEO, ErrorBuilder.buildInitFailedError("init() had failed", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
        }
        synchronized (this.e0) {
            Iterator<h.d> it = this.e0.values().iterator();
            while (it.hasNext()) {
                String strC = it.next().getInstanceId();
                this.r0.a(strC).onInterstitialAdLoadFailed(strC, ErrorBuilder.buildInitFailedError("init() had failed", "Interstitial"));
            }
            this.e0.clear();
        }
        synchronized (this.g0) {
            Iterator<h.d> it2 = this.g0.values().iterator();
            while (it2.hasNext()) {
                String strC2 = it2.next().getInstanceId();
                this.s0.a(strC2).onRewardedVideoAdLoadFailed(strC2, ErrorBuilder.buildInitFailedError("init() had failed", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            }
            this.g0.clear();
        }
        synchronized (this.f0) {
            for (h.b bVar : this.f0.values()) {
                ISDemandOnlyBannerLayout iSDemandOnlyBannerLayoutG = bVar.getBanner();
                if (iSDemandOnlyBannerLayoutG != null) {
                    iSDemandOnlyBannerLayoutG.getListener().a(bVar.getInstanceId(), ErrorBuilder.buildInitFailedError("init() had failed", "Banner"));
                }
            }
            this.f0.clear();
        }
    }

    public void a(long j, ls.a aVar) {
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(B());
        try {
            mediationAdditionalData.put("duration", j);
            mediationAdditionalData.put("sessionDepth", this.E);
            mediationAdditionalData.put(IronSourceConstants.EVENTS_EXT1, aVar.a());
        } catch (Exception e) {
            o9.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
        ar.i().a(new zb(514, mediationAdditionalData));
    }

    public void a(Activity activity) {
        try {
            if (FeaturesManager.getInstance().getStopUseOnResumeAndPause()) {
                return;
            }
            this.h.log(IronSourceLogger.IronSourceTag.API, "onPause()", 1);
            ContextProvider.getInstance().onPause(activity);
        } catch (Throwable th) {
            o9.d().a(th);
            this.h.logException(IronSourceLogger.IronSourceTag.API, "onPause()", th);
        }
    }

    @Override // com.ironsource.qa.a
    public synchronized void a(Activity activity, ISDemandOnlyBannerLayout iSDemandOnlyBannerLayout, String str) {
        h.b bVarA = new h.c().b(str).a(activity).a(iSDemandOnlyBannerLayout).a(IronSource.AD_UNIT.BANNER).a();
        IronSourceError ironSourceErrorA = bVarA.a();
        if (ironSourceErrorA != null) {
            this.h.log(IronSourceLogger.IronSourceTag.API, ironSourceErrorA.getErrorMessage(), 3);
            if (iSDemandOnlyBannerLayout != null) {
                iSDemandOnlyBannerLayout.getListener().a(str, ironSourceErrorA);
            }
            return;
        }
        IronSourceError ironSourceErrorA2 = a(s.c().a());
        if (ironSourceErrorA2 != null) {
            this.h.log(IronSourceLogger.IronSourceTag.API, ironSourceErrorA2.getErrorMessage(), 3);
            iSDemandOnlyBannerLayout.getListener().a(str, ironSourceErrorA2);
            return;
        }
        ContextProvider.getInstance().updateActivity(activity);
        if (a(bVarA)) {
            return;
        }
        if (!z()) {
            this.h.log(IronSourceLogger.IronSourceTag.API, "No banner configurations found", 3);
            iSDemandOnlyBannerLayout.getListener().a(str, ErrorBuilder.buildInitFailedError("the server response does not contain banner data", "Banner"));
        } else {
            if (b(bVarA)) {
                return;
            }
            this.j0.a(iSDemandOnlyBannerLayout, str);
        }
    }

    @Override // com.ironsource.qa.a
    public synchronized void a(Activity activity, ISDemandOnlyBannerLayout iSDemandOnlyBannerLayout, String str, String str2) {
        h.b bVarA = new h.c().b(str).a(activity).a(true).a(str2).a(iSDemandOnlyBannerLayout).a(IronSource.AD_UNIT.BANNER).a();
        IronSourceError ironSourceErrorA = bVarA.a();
        if (ironSourceErrorA != null) {
            this.h.log(IronSourceLogger.IronSourceTag.API, ironSourceErrorA.getErrorMessage(), 3);
            if (iSDemandOnlyBannerLayout != null) {
                iSDemandOnlyBannerLayout.getListener().a(str, ironSourceErrorA);
            }
            return;
        }
        IronSourceError ironSourceErrorA2 = a(s.c().a());
        if (ironSourceErrorA2 != null) {
            this.h.log(IronSourceLogger.IronSourceTag.API, ironSourceErrorA2.getErrorMessage(), 3);
            iSDemandOnlyBannerLayout.getListener().a(str, ironSourceErrorA2);
            return;
        }
        ContextProvider.getInstance().updateActivity(activity);
        if (a(bVarA)) {
            return;
        }
        if (!z()) {
            this.h.log(IronSourceLogger.IronSourceTag.API, "No banner configurations found", 3);
            iSDemandOnlyBannerLayout.getListener().a(str, ErrorBuilder.buildInitFailedError("the server response does not contain banner data", "Banner"));
        } else {
            if (b(bVarA)) {
                return;
            }
            this.j0.a(iSDemandOnlyBannerLayout, str, str2);
        }
    }

    @Override // com.ironsource.qa.b
    public synchronized void a(Activity activity, String str) {
        a(new h.c().b(str).a(activity, ContextProvider.getInstance().getCurrentActiveActivity()).a(IronSource.AD_UNIT.INTERSTITIAL).b(), this.r0.a(str));
    }

    @Override // com.ironsource.qa.c
    public synchronized void a(Activity activity, String str, String str2) {
        a(new h.c().b(str).a(str2).a(activity, ContextProvider.getInstance().getCurrentActiveActivity()).a(true).a(IronSource.AD_UNIT.REWARDED_VIDEO).b(), this.s0.a(str));
    }

    public synchronized void a(Context context, String str, boolean z, InitializationListener initializationListener, IronSource.AD_UNIT... ad_unitArr) {
        if (a(context, str, z, initializationListener, null, ad_unitArr) == null) {
            s.c().a(this);
            s.c().a(this.k0);
            s.c().a(context, str, this.o, ad_unitArr);
        }
    }

    @Override // com.json.qa
    public synchronized void a(Context context, String str, IronSource.AD_UNIT... ad_unitArr) {
        List<IronSource.AD_UNIT> listA = a(context, str, true, ad_unitArr);
        if (!listA.isEmpty()) {
            a(context, str, true, (InitializationListener) null, (IronSource.AD_UNIT[]) listA.toArray(new IronSource.AD_UNIT[listA.size()]));
        }
    }

    @Override // com.json.zj
    public void a(Context context, boolean z) {
        this.x = context;
        this.y = Boolean.valueOf(z);
        hj hjVar = this.S;
        if (hjVar != null) {
            hjVar.a(context, z);
        }
        if (this.a0) {
            vq vqVar = this.T;
            if (vqVar != null) {
                vqVar.a(context, z);
                return;
            }
            return;
        }
        dg dgVar = this.Q;
        if (dgVar != null) {
            dgVar.a(context, z);
        }
    }

    public void a(IronSource.AD_UNIT ad_unit, eu euVar) {
        g6 g6Var;
        vq vqVar;
        hj hjVar;
        if (this.n0) {
            if (ad_unit == IronSource.AD_UNIT.INTERSTITIAL && (hjVar = this.S) != null) {
                hjVar.a(euVar);
            }
            if (ad_unit == IronSource.AD_UNIT.REWARDED_VIDEO && (vqVar = this.T) != null) {
                vqVar.a(euVar);
            }
            if (ad_unit != IronSource.AD_UNIT.BANNER || (g6Var = this.U) == null) {
                return;
            }
            g6Var.a(euVar);
        }
    }

    public void a(IronSource.AD_UNIT ad_unit, WaterfallConfiguration waterfallConfiguration) {
        if (ad_unit == null) {
            IronLog.API.error("AdUnit should not be null.");
            return;
        }
        IronLog.API.info(String.format("(%s, %s)", ad_unit.name(), waterfallConfiguration == null ? "NULL" : waterfallConfiguration.toString()));
        zb zbVar = new zb(53, IronSourceUtils.getMediationAdditionalData(false));
        zbVar.a(IronSourceConstants.EVENTS_EXT1, waterfallConfiguration == null ? "" : waterfallConfiguration.toJsonString());
        ar.i().a(zbVar, ad_unit);
        this.l0.a(ad_unit, waterfallConfiguration);
    }

    public void a(IronSourceBannerLayout ironSourceBannerLayout) {
        g6 g6Var;
        this.h.log(IronSourceLogger.IronSourceTag.API, "destroyBanner()", 1);
        try {
            if (!this.c0 || (g6Var = this.U) == null) {
                w wVar = this.R;
                if (wVar != null) {
                    wVar.a(ironSourceBannerLayout);
                }
            } else {
                g6Var.a(ironSourceBannerLayout);
            }
        } catch (Throwable th) {
            o9.d().a(th);
            this.h.logException(IronSourceLogger.IronSourceTag.API, "destroyBanner()", th);
        }
    }

    public void a(IronSourceBannerLayout ironSourceBannerLayout, String str) {
        IronLog.INTERNAL.verbose("placementName = " + str);
        if (this.H) {
            this.h.log(IronSourceLogger.IronSourceTag.API, "Banner was initialized in demand only mode. Use loadISDemandOnlyBanner instead", 3);
            n.a().b(IronSource.AD_UNIT.BANNER, ErrorBuilder.buildInitFailedError("Banner was initialized in demand only mode. Use loadISDemandOnlyBanner instead", "Banner"));
            return;
        }
        if (ironSourceBannerLayout == null || ironSourceBannerLayout.isDestroyed()) {
            String strConcat = "loadBanner can't be called - ".concat(ironSourceBannerLayout == null ? "banner layout is null " : "banner layout is destroyed");
            this.h.log(IronSourceLogger.IronSourceTag.API, strConcat, 3);
            n.a().b(IronSource.AD_UNIT.BANNER, ErrorBuilder.buildLoadFailedError(strConcat));
            return;
        }
        if (!this.K) {
            this.h.log(IronSourceLogger.IronSourceTag.API, "init() must be called before loadBanner()", 3);
            n.a().b(IronSource.AD_UNIT.BANNER, ErrorBuilder.buildLoadFailedError("init() must be called before loadBanner()"));
            return;
        }
        if (ironSourceBannerLayout.getSize().getDescription().equals("CUSTOM") && (ironSourceBannerLayout.getSize().getWidth() <= 0 || ironSourceBannerLayout.getSize().getHeight() <= 0)) {
            this.h.log(IronSourceLogger.IronSourceTag.API, "loadBanner: Unsupported banner size. Height and width must be bigger than 0", 3);
            n.a().b(IronSource.AD_UNIT.BANNER, ErrorBuilder.unsupportedBannerSize(""));
            return;
        }
        s.d dVarA = s.c().a();
        if (dVarA == s.d.INIT_FAILED) {
            this.h.log(IronSourceLogger.IronSourceTag.API, "init() had failed", 3);
            n.a().b(IronSource.AD_UNIT.BANNER, new IronSourceError(600, "Init() had failed"));
            return;
        }
        if (dVarA == s.d.INIT_IN_PROGRESS) {
            if (s.c().d()) {
                this.h.log(IronSourceLogger.IronSourceTag.API, "init() had failed", 3);
                n.a().b(IronSource.AD_UNIT.BANNER, new IronSourceError(601, "Init() had failed"));
                return;
            } else {
                this.N = ironSourceBannerLayout;
                this.M = Boolean.TRUE;
                this.O = str;
                return;
            }
        }
        if (!z()) {
            this.h.log(IronSourceLogger.IronSourceTag.API, "No banner configurations found", 3);
            n.a().b(IronSource.AD_UNIT.BANNER, new IronSourceError(615, "the server response does not contain banner data"));
            return;
        }
        w wVar = this.R;
        if (wVar == null && this.U == null) {
            this.N = ironSourceBannerLayout;
            this.M = Boolean.TRUE;
            this.O = str;
        } else if (this.c0) {
            this.U.a(ironSourceBannerLayout, new Placement(k(str)));
        } else {
            wVar.a(ironSourceBannerLayout, k(str));
        }
    }

    public void a(IronSourceSegment ironSourceSegment) {
        this.C = ironSourceSegment;
        vq vqVar = this.T;
        if (vqVar != null) {
            vqVar.a(ironSourceSegment);
        }
        dg dgVar = this.Q;
        if (dgVar != null) {
            dgVar.a(ironSourceSegment);
        }
        hj hjVar = this.S;
        if (hjVar != null) {
            hjVar.a(ironSourceSegment);
        }
        w wVar = this.R;
        if (wVar != null) {
            wVar.a(ironSourceSegment);
        }
        g6 g6Var = this.U;
        if (g6Var != null) {
            g6Var.a(ironSourceSegment);
        }
        AdQualityBridge adQualityBridge = this.o0;
        if (adQualityBridge != null) {
            adQualityBridge.setSegment(ironSourceSegment);
        }
        oj.i().a(this.C);
        ar.i().a(this.C);
        ip.P.a(this.C);
    }

    @Override // com.ironsource.qa.b
    public void a(ISDemandOnlyInterstitialListener iSDemandOnlyInterstitialListener) {
        this.r0.a(iSDemandOnlyInterstitialListener);
    }

    @Override // com.ironsource.qa.c
    public void a(ISDemandOnlyRewardedVideoListener iSDemandOnlyRewardedVideoListener) {
        this.s0.a(iSDemandOnlyRewardedVideoListener);
    }

    void a(h.d dVar, ISDemandOnlyRewardedVideoListener iSDemandOnlyRewardedVideoListener) {
        String strC = dVar.getInstanceId();
        IronLog ironLog = IronLog.API;
        ironLog.info("instanceId=" + strC);
        try {
            if (!this.I) {
                ironLog.error("initISDemandOnly() must be called before loadDemandOnlyRewardedVideo()");
                iSDemandOnlyRewardedVideoListener.onRewardedVideoAdLoadFailed(strC, new IronSourceError(510, "initISDemandOnly() must be called before loadDemandOnlyRewardedVideo()"));
                return;
            }
            if (!this.F) {
                ironLog.error("Rewarded video was initialized in mediation mode");
                iSDemandOnlyRewardedVideoListener.onRewardedVideoAdLoadFailed(strC, new IronSourceError(510, "Rewarded video was initialized in mediation mode"));
                return;
            }
            s.d dVarA = s.c().a();
            if (dVarA == s.d.INIT_FAILED) {
                ironLog.error("init() had failed");
                iSDemandOnlyRewardedVideoListener.onRewardedVideoAdLoadFailed(strC, ErrorBuilder.buildInitFailedError("init() had failed", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
                return;
            }
            IronSourceError ironSourceErrorA = dVar.a();
            if (ironSourceErrorA != null) {
                if (ironSourceErrorA.getErrorCode() == 1060) {
                    b(81321, IronSourceUtils.getMediationAdditionalData(true, !TextUtils.isEmpty(dVar.getAdMarkup()), 1));
                }
                ironLog.error(ironSourceErrorA.toString());
                iSDemandOnlyRewardedVideoListener.onRewardedVideoAdLoadFailed(strC, ironSourceErrorA);
                return;
            }
            e(dVar.getActivity());
            if (dVarA == s.d.INIT_IN_PROGRESS) {
                if (s.c().d()) {
                    ironLog.error("init() had failed");
                    iSDemandOnlyRewardedVideoListener.onRewardedVideoAdLoadFailed(strC, ErrorBuilder.buildInitFailedError("init() had failed", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
                    return;
                }
                synchronized (this.g0) {
                    this.g0.put(strC, dVar);
                }
                if (TextUtils.isEmpty(dVar.getAdMarkup())) {
                    return;
                }
                b(IronSourceConstants.TROUBLESHOOTING_DO_IAB_RV_LOAD_FAILED_INIT_IN_PROGRESS, IronSourceUtils.getMediationAdditionalData(true, !TextUtils.isEmpty(dVar.getAdMarkup()), 1));
                return;
            }
            if (!M()) {
                ironLog.error("No rewarded video configurations found");
                iSDemandOnlyRewardedVideoListener.onRewardedVideoAdLoadFailed(strC, ErrorBuilder.buildInitFailedError("the server response does not contain rewarded video data", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
                return;
            }
            synchronized (this.g0) {
                k kVar = this.i0;
                if (kVar != null) {
                    kVar.a(dVar);
                    return;
                }
                this.g0.put(strC, dVar);
                if (!TextUtils.isEmpty(dVar.getAdMarkup())) {
                    b(IronSourceConstants.TROUBLESHOOTING_DO_IAB_RV_LOAD_FAILED_INIT_IN_PROGRESS, IronSourceUtils.getMediationAdditionalData(true, !TextUtils.isEmpty(dVar.getAdMarkup()), 1));
                }
                return;
            }
            o9.d().a(th);
            IronLog.API.error(th.getMessage());
            iSDemandOnlyRewardedVideoListener.onRewardedVideoAdLoadFailed(strC, new IronSourceError(510, th.getMessage()));
        } catch (Throwable th) {
            o9.d().a(th);
            IronLog.API.error(th.getMessage());
            iSDemandOnlyRewardedVideoListener.onRewardedVideoAdLoadFailed(strC, new IronSourceError(510, th.getMessage()));
        }
    }

    @Override // com.json.ji
    public void a(ImpressionDataListener impressionDataListener) {
        if (fk.a((Object) impressionDataListener, "removeImpressionDataListener - listener is null")) {
            qk.b().b(impressionDataListener);
            dg dgVar = this.Q;
            if (dgVar != null) {
                dgVar.a(impressionDataListener);
            }
            w wVar = this.R;
            if (wVar != null) {
                wVar.a(impressionDataListener);
            }
            IronLog.API.info("remove impression data listener from " + impressionDataListener.getClass().getSimpleName());
        }
    }

    @Override // com.json.im
    public void a(LogListener logListener) {
        if (logListener == null) {
            this.h.log(IronSourceLogger.IronSourceTag.API, "setLogListener(LogListener:null)", 1);
        } else {
            this.j.a(logListener);
            this.h.log(IronSourceLogger.IronSourceTag.API, "setLogListener(LogListener:" + logListener.getClass().getSimpleName() + ")", 1);
        }
    }

    public void a(LevelPlayInterstitialListener levelPlayInterstitialListener) {
        IronLog.API.info();
        sg.a().a(levelPlayInterstitialListener);
    }

    public void a(LevelPlayRewardedVideoListener levelPlayRewardedVideoListener) {
        IronLog.API.info();
        dq.a().a(levelPlayRewardedVideoListener);
    }

    public synchronized void a(LevelPlayRewardedVideoManualListener levelPlayRewardedVideoManualListener) {
        String str;
        IronLog ironLog = IronLog.API;
        ironLog.info();
        if (!this.I) {
            if (levelPlayRewardedVideoManualListener == null) {
                this.Y = false;
                str = "Disabling rewarded video manual mode";
            } else {
                this.Y = true;
                str = "Enabling rewarded video manual mode";
            }
            ironLog.info(str);
        }
        dq.a().a(levelPlayRewardedVideoManualListener);
    }

    void a(SegmentListener segmentListener) {
        yl ylVar = this.i;
        if (ylVar != null) {
            ylVar.a(segmentListener);
            s.c().a(this.i);
        }
    }

    @Override // com.ironsource.qa.c
    public synchronized void a(String str) {
        IronLog ironLog = IronLog.API;
        ironLog.info("instanceId=" + str);
        ISDemandOnlyRewardedVideoListener iSDemandOnlyRewardedVideoListenerA = this.s0.a(str);
        try {
            if (!this.F) {
                ironLog.error("Rewarded video was initialized in mediation mode. Use showRewardedVideo instead");
                iSDemandOnlyRewardedVideoListenerA.onRewardedVideoAdShowFailed(str, new IronSourceError(508, "Rewarded video was initialized in mediation mode. Use showRewardedVideo instead"));
                return;
            }
            k kVar = this.i0;
            if (kVar != null) {
                kVar.b(str);
            } else {
                ironLog.error("Rewarded video was not initiated");
                iSDemandOnlyRewardedVideoListenerA.onRewardedVideoAdShowFailed(str, new IronSourceError(508, "Rewarded video was not initiated"));
            }
        } catch (Exception e) {
            o9.d().a(e);
            IronLog.API.error(e.getMessage());
            if (iSDemandOnlyRewardedVideoListenerA != null) {
                iSDemandOnlyRewardedVideoListenerA.onRewardedVideoAdShowFailed(str, new IronSourceError(510, e.getMessage()));
            }
        }
    }

    public void a(String str, List<String> list) {
        IronLog ironLog = IronLog.API;
        ironLog.verbose("key = " + str + ", values = " + list.toString());
        String strCheckMetaDataKeyValidity = MetaDataUtils.checkMetaDataKeyValidity(str);
        String strCheckMetaDataValueValidity = MetaDataUtils.checkMetaDataValueValidity(list);
        if (strCheckMetaDataKeyValidity.length() > 0) {
            ironLog.verbose(strCheckMetaDataKeyValidity);
            return;
        }
        if (strCheckMetaDataValueValidity.length() > 0) {
            ironLog.verbose(strCheckMetaDataValueValidity);
            return;
        }
        MetaData metaData = MetaDataUtils.formatMetaData(str, list);
        String metaDataKey = metaData.getMetaDataKey();
        List<String> metaDataValue = metaData.getMetaDataValue();
        if (!MetaDataUtils.isMediationOnlyKey(metaDataKey)) {
            com.json.mediationsdk.c.b().a(metaDataKey, metaDataValue);
        } else if (C() && MetaDataUtils.isMediationKeysBeforeInit(metaDataKey)) {
            ironLog.error("setMetaData with key = " + metaDataKey + " must to be called before init");
        } else {
            qk.b().a(metaDataKey, metaDataValue);
        }
        try {
            ConcurrentHashMap<String, List<String>> concurrentHashMapC = com.json.mediationsdk.c.b().c();
            concurrentHashMapC.putAll(qk.b().c());
            JSONObject jSONObjectJsonObjectInit = IronSourceNetworkBridge.jsonObjectInit();
            for (Map.Entry<String, List<String>> entry : concurrentHashMapC.entrySet()) {
                jSONObjectJsonObjectInit.put(entry.getKey(), entry.getValue());
            }
            this.m0.a(jSONObjectJsonObjectInit);
            this.l0.a(jSONObjectJsonObjectInit);
        } catch (JSONException e) {
            o9.d().a(e);
            IronLog.INTERNAL.error("got the following error " + e.getMessage());
        }
        ar.i().a(new zb(C() ? 51 : 50, IronSourceUtils.getJsonForMetaData(str, list, metaDataValue)));
    }

    public void a(String str, JSONObject jSONObject) {
        if (fk.a((Object) jSONObject, "setAdRevenueData - impressionData is null") && fk.a((Object) str, "setAdRevenueData - dataSource is null")) {
            this.k0.a(str, jSONObject);
        }
    }

    @Override // com.json.mo
    public void a(List<IronSource.AD_UNIT> list, boolean z, s8 s8Var) {
        b(list, z, s8Var);
    }

    @Override // com.json.zj
    public void a(Map<String, String> map) {
        if (map != null) {
            try {
                if (map.size() == 0) {
                    return;
                }
                this.h.log(IronSourceLogger.IronSourceTag.API, this.f3998a + ":setRewardedVideoServerParameters(params:" + map.toString() + ")", 1);
                this.r = new HashMap(map);
            } catch (Exception e) {
                o9.d().a(e);
                this.h.logException(IronSourceLogger.IronSourceTag.API, this.f3998a + ":setRewardedVideoServerParameters(params:" + map.toString() + ")", e);
            }
        }
    }

    @Override // com.json.zj
    public void a(boolean z) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, "setAdaptersDebug : " + z, 1);
        com.json.mediationsdk.c.b().a(z);
    }

    boolean a(h7 h7Var) {
        return this.e.b(ContextProvider.getInstance().getApplicationContext(), h7Var, IronSource.AD_UNIT.BANNER);
    }

    public boolean a(boolean z, ls lsVar) {
        if (C()) {
            return true;
        }
        synchronized (this.l) {
            this.m = lsVar;
        }
        return b(lsVar.g(), z, lsVar.c());
    }

    ls b(Context context, String str, c cVar) {
        synchronized (this.l) {
            ls lsVar = this.m;
            if (lsVar != null) {
                return new ls(lsVar);
            }
            ls lsVarA = a(context, str, cVar);
            if (lsVarA == null || !lsVarA.p()) {
                IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
                IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
                logger.log(ironSourceTag, "Null or invalid response. Trying to get cached response", 0);
                lsVarA = a(context, n());
                if (lsVarA != null) {
                    this.h.log(ironSourceTag, ErrorBuilder.buildUsingCachedConfigurationError(n(), str).toString() + ": " + lsVarA.toString(), 1);
                    ar.i().a(new zb(IronSourceConstants.USING_CACHE_FOR_INIT_EVENT, IronSourceUtils.getMediationAdditionalData(false)));
                }
            }
            if (lsVarA != null) {
                this.m = lsVarA;
                IronSourceUtils.saveLastResponse(context, lsVarA.toString());
                b(this.m, context);
                oj.i().c(true);
                ar.i().c(true);
                ip.P.c(true);
            }
            return lsVarA;
        }
    }

    public IronSourceBannerLayout b(Activity activity, ISBannerSize iSBannerSize) {
        IronSourceLoggerManager ironSourceLoggerManager = this.h;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
        ironSourceLoggerManager.log(ironSourceTag, "createBanner()", 1);
        if (activity == null) {
            this.h.log(ironSourceTag, "createBanner() : Activity cannot be null", 3);
            return null;
        }
        ContextProvider.getInstance().updateActivity(activity);
        return new IronSourceBannerLayout(activity, iSBannerSize);
    }

    @Override // com.json.zj
    public String b(Context context) {
        String strP = this.c.p(context);
        return !TextUtils.isEmpty(strP) ? strP : "";
    }

    @Override // com.json.zj
    public void b() {
        this.r = null;
    }

    public void b(Activity activity) {
        IronLog ironLog = IronLog.API;
        ironLog.info("onResume()");
        try {
            if (FeaturesManager.getInstance().getStopUseOnResumeAndPause()) {
                ironLog.info("onResume() is disabled");
            } else {
                ContextProvider.getInstance().onResume(activity);
            }
        } catch (Throwable th) {
            this.h.logException(IronSourceLogger.IronSourceTag.API, "onResume()", th);
            o9.d().a(th);
        }
    }

    @Override // com.ironsource.qa.c
    public synchronized void b(Activity activity, String str) {
        a(new h.c().b(str).a(activity, ContextProvider.getInstance().getCurrentActiveActivity()).a(IronSource.AD_UNIT.REWARDED_VIDEO).b(), this.s0.a(str));
    }

    @Override // com.ironsource.qa.b
    public synchronized void b(Activity activity, String str, String str2) {
        a(new h.c().b(str).a(activity, ContextProvider.getInstance().getCurrentActiveActivity()).a(IronSource.AD_UNIT.INTERSTITIAL).a(true).a(str2).b(), this.r0.a(str));
    }

    public void b(ls lsVar, Context context) {
        a(lsVar);
        a(lsVar, context);
    }

    public void b(IronSourceBannerLayout ironSourceBannerLayout) {
        a(ironSourceBannerLayout, "");
    }

    @Override // com.json.ji
    public void b(ImpressionDataListener impressionDataListener) {
        if (fk.a((Object) impressionDataListener, "addImpressionDataListener - listener is null")) {
            qk.b().a(impressionDataListener);
            dg dgVar = this.Q;
            if (dgVar != null) {
                dgVar.b(impressionDataListener);
            }
            w wVar = this.R;
            if (wVar != null) {
                wVar.b(impressionDataListener);
            }
            IronLog.API.info("add impression data listener to " + impressionDataListener.getClass().getSimpleName());
        }
    }

    @Override // com.ironsource.qa.b
    public void b(String str) {
        this.h.log(IronSourceLogger.IronSourceTag.API, "showDemandOnlyInterstitial() instanceId=" + str, 1);
        ISDemandOnlyInterstitialListener iSDemandOnlyInterstitialListenerA = this.r0.a(str);
        try {
            if (!this.G) {
                IronLog.API.error("Interstitial was initialized in mediation mode. Use showInterstitial instead");
                iSDemandOnlyInterstitialListenerA.onInterstitialAdShowFailed(str, new IronSourceError(508, "Interstitial was initialized in mediation mode. Use showInterstitial instead"));
                return;
            }
            f fVar = this.h0;
            if (fVar != null) {
                fVar.a(str);
            } else {
                IronLog.API.error("Interstitial was not initiated");
                iSDemandOnlyInterstitialListenerA.onInterstitialAdShowFailed(str, new IronSourceError(508, "Interstitial was not initiated"));
            }
        } catch (Exception e) {
            o9.d().a(e);
            IronLog.API.error(e.getMessage());
            if (iSDemandOnlyInterstitialListenerA != null) {
                iSDemandOnlyInterstitialListenerA.onInterstitialAdShowFailed(str, ErrorBuilder.buildInitFailedError("showISDemandOnlyInterstitial can't be called before the Interstitial ad unit initialization completed successfully", "Interstitial"));
            }
        }
    }

    public void b(String str, JSONObject jSONObject) {
        v vVar = new v(str, jSONObject);
        IronLog.API.verbose(vVar.toString());
        com.json.mediationsdk.c.b().a(vVar);
    }

    public void b(boolean z) {
        this.P = Boolean.valueOf(z);
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, "setConsent : " + z, 1);
        com.json.mediationsdk.c.b().b(z);
        this.l0.a(z);
        ar.i().a(new zb(z ? 40 : 41, IronSourceUtils.getMediationAdditionalData(false)));
    }

    @Override // com.json.zj
    public void c() {
        this.h.log(IronSourceLogger.IronSourceTag.API, "removeRewardedVideoListener()", 1);
        dq.a().a((LevelPlayRewardedVideoBaseListener) null);
    }

    public void c(Activity activity) {
        IronSourceLoggerManager ironSourceLoggerManager = this.h;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
        ironSourceLoggerManager.log(ironSourceTag, "showInterstitial()", 1);
        try {
            if (this.G) {
                this.h.log(ironSourceTag, "Interstitial was initialized in demand only mode. Use showISDemandOnlyInterstitial instead", 3);
                sg.a().a(new IronSourceError(510, "Interstitial was initialized in demand only mode. Use showISDemandOnlyInterstitial instead"), (AdInfo) null);
            } else {
                if (!D()) {
                    sg.a().a(ErrorBuilder.buildInitFailedError("showInterstitial can't be called before the Interstitial ad unit initialization completed successfully", "Interstitial"), (AdInfo) null);
                    return;
                }
                InterstitialPlacement interstitialPlacementI = i();
                if (interstitialPlacementI != null) {
                    c(activity, interstitialPlacementI.getPlacementName());
                } else {
                    sg.a().a(new IronSourceError(1020, "showInterstitial error: empty default placement in response"), (AdInfo) null);
                }
            }
        } catch (Exception e) {
            o9.d().a(e);
            this.h.logException(IronSourceLogger.IronSourceTag.API, "showInterstitial()", e);
            sg.a().a(new IronSourceError(510, e.getMessage()), (AdInfo) null);
        }
    }

    public void c(Activity activity, String str) {
        String str2 = "showInterstitial(" + str + ")";
        IronSourceLoggerManager ironSourceLoggerManager = this.h;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
        ironSourceLoggerManager.log(ironSourceTag, str2, 1);
        try {
            if (this.G) {
                this.h.log(ironSourceTag, "Interstitial was initialized in demand only mode. Use showISDemandOnlyInterstitial instead", 3);
                sg.a().a(new IronSourceError(510, "Interstitial was initialized in demand only mode. Use showISDemandOnlyInterstitial instead"), (AdInfo) null);
            } else if (D()) {
                d(activity, str);
            } else {
                sg.a().a(ErrorBuilder.buildInitFailedError("showInterstitial can't be called before the Interstitial ad unit initialization completed successfully", "Interstitial"), (AdInfo) null);
            }
        } catch (Exception e) {
            o9.d().a(e);
            this.h.logException(IronSourceLogger.IronSourceTag.API, str2, e);
            sg.a().a(new IronSourceError(510, e.getMessage()), (AdInfo) null);
        }
    }

    public void c(Context context) {
        zt ztVar = zt.f4665a;
        ztVar.b();
        if (!C()) {
            ztVar.a(IronSourceConstants.errorCode_TEST_SUITE_SDK_NOT_INITIALIZED);
            IronLog.API.error("TestSuite cannot be launched, SDK not initialized");
            return;
        }
        if (!b(this.m)) {
            ztVar.a(IronSourceConstants.errorCode_TEST_SUITE_DISABLED);
            IronLog.API.error("TestSuite cannot be launched, Please contact your account manager to enable it");
            return;
        }
        if (!IronSourceUtils.isNetworkConnected(context)) {
            ztVar.a(IronSourceConstants.errorCode_TEST_SUITE_NO_NETWORK_CONNECTIVITY);
            IronLog.API.error("TestSuite cannot be launched, No network connectivity");
            return;
        }
        hj hjVar = this.S;
        if (hjVar != null) {
            hjVar.J();
        }
        vq vqVar = this.T;
        if (vqVar != null) {
            vqVar.J();
        }
        g6 g6Var = this.U;
        if (g6Var != null) {
            g6Var.J();
            this.U.T();
        }
        new au().a(context, n(), this.m.i(), IronSourceUtils.getSDKVersion(), this.m.c().getTestSuiteSettings().b(), g(), this.Y);
        this.n0 = true;
        ztVar.c();
    }

    @Override // com.ironsource.qa.a
    public void c(String str) {
        this.h.log(IronSourceLogger.IronSourceTag.API, "destroyBanner()", 1);
        try {
            com.json.mediationsdk.demandOnly.c cVar = this.j0;
            if (cVar != null) {
                cVar.a(str);
            }
        } catch (Throwable th) {
            o9.d().a(th);
            this.h.logException(IronSourceLogger.IronSourceTag.API, "destroyISDemandOnlyBanner()", th);
        }
    }

    @Override // com.json.zj
    public void d() {
        this.h.log(IronSourceLogger.IronSourceTag.API, "removeInterstitialListener()", 1);
        sg.a().a((LevelPlayInterstitialListener) null);
    }

    public void d(Activity activity) {
        if (!L()) {
            dq.a().a(ErrorBuilder.buildInitFailedError("showRewardedVideo can't be called before the Rewarded Video ad unit initialization completed successfully", IronSourceConstants.REWARDED_VIDEO_AD_UNIT), (AdInfo) null);
            this.h.log(IronSourceLogger.IronSourceTag.INTERNAL, "showRewardedVideo can't be called before the Rewarded Video ad unit initialization completed successfully", 3);
            return;
        }
        Placement placementJ = j();
        if (placementJ != null) {
            f(activity, placementJ.getPlacementName());
            return;
        }
        this.h.log(IronSourceLogger.IronSourceTag.INTERNAL, "showRewardedVideo error: empty default placement in response", 3);
        dq.a().a(new IronSourceError(1021, "showRewardedVideo error: empty default placement in response"), (AdInfo) null);
    }

    @Override // com.json.mo
    public void d(String str) {
        try {
            this.h.log(IronSourceLogger.IronSourceTag.API, "onInitFailed(reason:" + str + ")", 1);
            IronSourceUtils.sendAutomationLog("Mediation init failed");
            if (this.i != null) {
                Iterator<IronSource.AD_UNIT> it = this.z.iterator();
                while (it.hasNext()) {
                    a(it.next(), true);
                }
            }
            eo eoVarR = r();
            if (eoVarR != null) {
                eoVarR.onInitFailed(new IronSourceError(IronSourceError.ERROR_LEGACY_INIT_FAILED, "Legacy init failed"));
            }
        } catch (Exception e) {
            o9.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x002a  */
    public String e() {
        String str;
        if (this.L) {
            s sVarC = s.c();
            int i = b.b[sVarC.a().ordinal()];
            if (i == 1) {
                str = "init() had failed";
            } else if (i != 2) {
                str = "";
            } else if (sVarC.d()) {
                str = "init() had failed";
            } else {
                str = "init() not finished yet";
            }
        } else {
            str = "init() must be called first";
        }
        return (I() || !str.isEmpty()) ? str : "No Native Ad configurations found";
    }

    @Override // com.json.zj
    public boolean e(String str) {
        try {
            String str2 = this.f3998a + ":setDynamicUserId(dynamicUserId:" + str + ")";
            IronSourceLoggerManager ironSourceLoggerManager = this.h;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
            ironSourceLoggerManager.log(ironSourceTag, str2, 1);
            r8 r8Var = new r8();
            a(str, r8Var);
            if (!r8Var.b()) {
                IronSourceLoggerManager.getLogger().log(ironSourceTag, r8Var.a().toString(), 2);
                return false;
            }
            this.q = str;
            ar.i().a(new zb(52, IronSourceUtils.getJsonForUserId(true)));
            return true;
        } catch (Exception e) {
            o9.d().a(e);
            this.h.logException(IronSourceLogger.IronSourceTag.API, this.f3998a + ":setDynamicUserId(dynamicUserId:" + str + ")", e);
            return false;
        }
    }

    public an f() {
        IronLog.INTERNAL.verbose();
        List<NetworkSettings> listA = a(this.m.j().c());
        if (listA.size() > 0) {
            return new an(listA, this.m.c().getNativeAdConfigurations(), IronSourceUtils.getUserIdForNetworks(), qk.b(), this.C);
        }
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false, true, 1);
        a(mediationAdditionalData, new Object[][]{new Object[]{"errorCode", 1010}});
        a(IronSourceConstants.TROUBLESHOOTING_NT_INIT_FAILED, mediationAdditionalData);
        return null;
    }

    public void f(Activity activity, String str) {
        String str2 = "showRewardedVideo(" + str + ")";
        IronSourceLoggerManager ironSourceLoggerManager = this.h;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
        ironSourceLoggerManager.log(ironSourceTag, str2, 1);
        try {
            if (this.F) {
                this.h.log(ironSourceTag, "Rewarded Video was initialized in demand only mode. Use showISDemandOnlyRewardedVideo instead", 3);
                dq.a().a(ErrorBuilder.buildInitFailedError("Rewarded Video was initialized in demand only mode. Use showISDemandOnlyRewardedVideo instead", IronSourceConstants.REWARDED_VIDEO_AD_UNIT), (AdInfo) null);
            } else if (L()) {
                e(activity, str);
            } else {
                dq.a().a(ErrorBuilder.buildInitFailedError("showRewardedVideo can't be called before the Rewarded Video ad unit initialization completed successfully", IronSourceConstants.REWARDED_VIDEO_AD_UNIT), (AdInfo) null);
            }
        } catch (Exception e) {
            o9.d().a(e);
            this.h.logException(IronSourceLogger.IronSourceTag.API, str2, e);
            dq.a().a(new IronSourceError(510, e.getMessage()), (AdInfo) null);
        }
    }

    @Override // com.ironsource.qa.b
    public synchronized boolean f(String str) {
        f fVar;
        fVar = this.h0;
        return fVar != null && fVar.b(str);
    }

    @Override // com.json.zj
    public InterstitialPlacement g(String str) {
        InterstitialPlacement interstitialPlacementM;
        try {
            interstitialPlacementM = m(str);
            if (interstitialPlacementM == null) {
                try {
                    this.h.log(IronSourceLogger.IronSourceTag.API, "Placement is not valid, please make sure you are using the right placements, using the default placement.", 2);
                    interstitialPlacementM = i();
                } catch (Exception e) {
                    e = e;
                    o9.d().a(e);
                }
            }
            this.h.log(IronSourceLogger.IronSourceTag.API, "getPlacementInfo(placement: " + str + "):" + interstitialPlacementM, 1);
        } catch (Exception e2) {
            e = e2;
            interstitialPlacementM = null;
        }
        return interstitialPlacementM;
    }

    Boolean g() {
        return this.P;
    }

    public ls h() {
        return this.m;
    }

    @Override // com.json.zj
    public void h(String str) {
        try {
            String str2 = this.f3998a + ":setMediationType(mediationType:" + str + ")";
            IronSourceLoggerManager ironSourceLoggerManager = this.h;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
            ironSourceLoggerManager.log(ironSourceTag, str2, 1);
            if (a(str, 1, 64) && u(str)) {
                this.s = str;
                this.l0.e(str);
            } else {
                this.h.log(ironSourceTag, " mediationType value is invalid - should be alphanumeric and 1-64 chars in length", 1);
            }
        } catch (Exception e) {
            o9.d().a(e);
            this.h.logException(IronSourceLogger.IronSourceTag.API, this.f3998a + ":setMediationType(mediationType:" + str + ")", e);
        }
    }

    @Override // com.json.zj
    public Placement i(String str) {
        Placement placementP;
        try {
            placementP = p(str);
            if (placementP == null) {
                try {
                    this.h.log(IronSourceLogger.IronSourceTag.API, "Placement is not valid, please make sure you are using the right placements, using the default placement.", 2);
                    placementP = j();
                } catch (Exception e) {
                    e = e;
                    o9.d().a(e);
                }
            }
            this.h.log(IronSourceLogger.IronSourceTag.API, "getPlacementInfo(placement: " + str + "):" + placementP, 1);
        } catch (Exception e2) {
            e = e2;
            placementP = null;
        }
        return placementP;
    }

    @Override // com.ironsource.qa.c
    public synchronized boolean j(String str) {
        k kVar;
        kVar = this.i0;
        return kVar != null && kVar.a(str);
    }

    public String l() {
        return this.q;
    }

    public cn n(String str) {
        cn cnVarA;
        rm rmVarE = this.m.c().getNativeAdConfigurations();
        if (rmVarE == null) {
            return null;
        }
        return (TextUtils.isEmpty(str) || (cnVarA = rmVarE.a(str)) == null) ? rmVarE.e() : cnVarA;
    }

    public String n() {
        return this.n;
    }

    public String o() {
        return this.o;
    }

    public List<IronSource.AD_UNIT> p() {
        ArrayList arrayList = new ArrayList();
        Set<IronSource.AD_UNIT> set = this.z;
        if (set != null) {
            arrayList.addAll(set);
        }
        return arrayList;
    }

    public String q() {
        return this.s;
    }

    boolean q(String str) {
        if (!y()) {
            return false;
        }
        h7 h7VarA = null;
        try {
            h7VarA = this.m.c().getBannerConfigurations().a(str);
            if (h7VarA == null && (h7VarA = this.m.c().getBannerConfigurations().i()) == null) {
                this.h.log(IronSourceLogger.IronSourceTag.API, "Banner default placement was not found", 3);
                return false;
            }
        } catch (Exception e) {
            o9.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
        if (h7VarA == null) {
            return false;
        }
        return a(h7VarA);
    }

    boolean r(String str) {
        if (this.G) {
            return false;
        }
        boolean z = l(str) != op.b.NOT_CAPPED;
        if (z) {
            JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(this.G, true, 1);
            try {
                mediationAdditionalData.put("placement", str);
                mediationAdditionalData.put(IronSourceConstants.EVENTS_PROGRAMMATIC, 1);
            } catch (Exception e) {
                o9.d().a(e);
            }
            oj.i().a(new zb(2103, mediationAdditionalData));
        }
        return z;
    }

    public Map<String, String> s() {
        return this.r;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0017  */
    boolean s(String str) {
        boolean z;
        op.b bVarO = o(str);
        if (bVarO != null) {
            int i = b.c[bVarO.ordinal()];
            z = true;
            if (i != 1 && i != 2 && i != 3) {
                z = false;
            }
        } else {
            z = false;
        }
        a(z, str);
        return z;
    }

    public IronSourceSegment t() {
        return this.C;
    }

    public void t(String str) {
        IronLog.API.verbose("userId = " + str);
        this.o = str;
        ar.i().a(new zb(52, IronSourceUtils.getJsonForUserId(false)));
        AdQualityBridge adQualityBridge = this.o0;
        if (adQualityBridge != null) {
            adQualityBridge.changeUserId(str);
        }
    }

    public String u() {
        return this.w;
    }
}
