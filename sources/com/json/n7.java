package com.json;

import android.content.Context;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.json.environment.ContextProvider;
import com.json.environment.NetworkStateReceiver;
import com.json.environment.thread.IronSourceThreadManager;
import com.json.mediationsdk.IronSource;
import com.json.mediationsdk.IronSourceSegment;
import com.json.mediationsdk.LoadWhileShowSupportState;
import com.json.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.json.mediationsdk.adunit.adapter.internal.AdapterSettingsInterface;
import com.json.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.json.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener;
import com.json.mediationsdk.adunit.adapter.utility.AdData;
import com.json.mediationsdk.adunit.adapter.utility.AdInfo;
import com.json.mediationsdk.h;
import com.json.mediationsdk.i;
import com.json.mediationsdk.impressionData.ImpressionData;
import com.json.mediationsdk.impressionData.ImpressionDataListener;
import com.json.mediationsdk.logger.IronLog;
import com.json.mediationsdk.logger.IronSourceError;
import com.json.mediationsdk.logger.IronSourceLogger;
import com.json.mediationsdk.logger.IronSourceLoggerManager;
import com.json.mediationsdk.model.NetworkSettings;
import com.json.mediationsdk.model.Placement;
import com.json.mediationsdk.n;
import com.json.mediationsdk.utils.IronSourceConstants;
import com.json.mediationsdk.utils.IronSourceUtils;
import com.json.q7;
import com.safedk.android.internal.partials.IronSourceNetworkBridge;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public abstract class n7<Smash extends q7<?>, Listener extends AdapterAdListener> implements r2, s4, d2, fm, Cdo, p, bw, x7, tp {
    private AdInfo A;
    private qk B;
    final ai C;
    final ai.a D;
    protected final bg E;
    private final bg.a F;
    private boolean G;
    private eu H;
    private AtomicBoolean I;
    private yj J;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected aw<Smash> f4075a;
    protected ConcurrentHashMap<String, h.a> b;
    protected com.json.mediationsdk.e c;
    protected h d;
    protected int e;
    protected String f;
    protected JSONObject g;
    protected m5 h;
    protected Placement i;
    protected boolean j;
    private NetworkStateReceiver k;
    protected qs l;
    protected ib m;
    protected ib n;
    protected u0 o;
    protected f p;
    protected q2 q;
    protected nc r;
    protected e2 s;
    protected l2 t;
    protected s u;
    protected IronSourceSegment v;
    protected UUID w;
    protected final Object x;
    private long y;
    private Boolean z;

    class a extends hr {
        a() {
        }

        @Override // com.json.hr
        public void a() {
            n7.this.B();
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ NetworkSettings f4077a;

        b(NetworkSettings networkSettings) {
            this.f4077a = networkSettings;
        }

        @Override // java.lang.Runnable
        public void run() {
            n7.this.c(this.f4077a);
        }
    }

    class c extends TimerTask {
        c() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            n7.this.D();
        }
    }

    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            n7.this.g = IronSourceNetworkBridge.jsonObjectInit();
            n7.this.s.i.a();
            HashMap map = new HashMap();
            ArrayList arrayList = new ArrayList();
            StringBuilder sb = new StringBuilder();
            ArrayList arrayList2 = new ArrayList();
            n7.this.b(map, arrayList, sb, arrayList2);
            n7.this.a(map, arrayList, sb, arrayList2);
        }
    }

    class e implements z7.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Map f4080a;
        final /* synthetic */ StringBuilder b;
        final /* synthetic */ List c;

        e(Map map, StringBuilder sb, List list) {
            this.f4080a = map;
            this.b = sb;
            this.c = list;
        }

        @Override // com.ironsource.z7.b
        public void a(List<a8> list, long j, List<String> list2) {
            n7.this.s.h.a(j);
            for (a8 a8Var : list) {
                NetworkSettings networkSettingsA = n7.this.o.a(a8Var.c());
                Map<String, Object> mapB = n7.this.b(networkSettingsA, com.json.mediationsdk.c.b().b(networkSettingsA, n7.this.o.getAdUnit(), n7.this.k()));
                if (a8Var.a() != null) {
                    this.f4080a.put(a8Var.c(), a8Var.a());
                    this.b.append(a8Var.d()).append(a8Var.c()).append(StringUtils.COMMA);
                    n7.this.s.h.a(mapB, a8Var.e());
                } else {
                    n7.this.s.h.a(mapB, a8Var.e(), a8Var.b());
                }
            }
            Iterator<String> it = list2.iterator();
            while (it.hasNext()) {
                NetworkSettings networkSettingsA2 = n7.this.o.a(it.next());
                n7.this.s.h.b(n7.this.b(networkSettingsA2, com.json.mediationsdk.c.b().b(networkSettingsA2, n7.this.o.getAdUnit(), n7.this.k())), j);
            }
            n7.this.a((Map<String, Object>) this.f4080a, (List<String>) this.c, this.b.toString());
        }

        @Override // com.ironsource.z7.b
        public void onFailure(String str) {
            n7.this.s.h.a(str);
            n7.this.a((Map<String, Object>) this.f4080a, (List<String>) this.c, this.b.toString());
        }
    }

    protected enum f {
        NONE,
        READY_TO_LOAD,
        AUCTION,
        LOADING,
        READY_TO_SHOW,
        SHOWING
    }

    public n7(u0 u0Var, qk qkVar, IronSourceSegment ironSourceSegment) {
        this(mm.S(), mm.M(), u0Var, qkVar, ironSourceSegment);
    }

    n7(xf xfVar, wf wfVar, u0 u0Var, qk qkVar, IronSourceSegment ironSourceSegment) {
        this.f = "";
        this.j = false;
        this.x = new Object();
        this.y = 0L;
        this.I = new AtomicBoolean(false);
        this.w = UUID.randomUUID();
        this.C = xfVar.k();
        this.D = wfVar.e();
        this.E = xfVar.B();
        this.F = wfVar.m();
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("adUnit = " + u0Var.getAdUnit() + ", loading mode = " + u0Var.getLoadingData().a());
        IronSourceUtils.sendAutomationLog(u0Var.getAdUnit() + " initiated object per waterfall mode");
        ib ibVar = new ib();
        this.J = a(u0Var);
        this.v = ironSourceSegment;
        this.o = u0Var;
        this.s = new e2(u0Var.getAdUnit(), e2.b.MEDIATION, this);
        this.t = g();
        this.q = h();
        a(f.NONE);
        this.B = qkVar;
        this.f4075a = new aw<>(this.o.getAuctionSettings().f(), this.o.getAuctionSettings().i(), this);
        this.s.f.a(o(), this.o.getLoadingData().a().toString());
        this.b = new ConcurrentHashMap<>();
        this.i = null;
        G();
        this.g = IronSourceNetworkBridge.jsonObjectInit();
        if (this.o.q()) {
            this.c = new com.json.mediationsdk.e(new com.json.mediationsdk.f(this.o.getAuctionSettings(), IronSourceUtils.getSessionId()));
        }
        this.d = new h(this.o.j(), this.o.getAuctionSettings().c());
        s();
        r();
        this.m = new ib();
        a(f.READY_TO_LOAD);
        this.r = new nc(u0Var.getAdExpirationInMinutes(), this);
        this.u = new s();
        this.s.f.a(ib.a(ibVar));
        if (this.o.getLoadingData().e()) {
            ironLog.verbose("first automatic load");
            A();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        f fVar;
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(i());
        synchronized (this.x) {
            if (this.o.getLoadingData().e() && this.l.a()) {
                ironLog.verbose(b("all smashes are capped"));
                a(a2.a(this.o.getAdUnit()), "all smashes are capped", false);
                return;
            }
            if (!t() && this.p == f.SHOWING) {
                IronLog.API.error(b("load cannot be invoked while showing an ad"));
                a(new IronSourceError(a2.d(this.o.getAdUnit()), "load cannot be invoked while showing an ad"));
                return;
            }
            if (this.o.getLoadingData().a() != o2.a.AUTOMATIC_LOAD_WHILE_SHOW && this.o.getLoadingData().a() != o2.a.MANUAL_WITH_LOAD_ON_SHOW && (((fVar = this.p) != f.READY_TO_LOAD && fVar != f.READY_TO_SHOW) || n.a().b(this.o.getAdUnit()))) {
                IronLog.API.error(b("load is already in progress"));
                return;
            }
            this.g = IronSourceNetworkBridge.jsonObjectInit();
            F();
            if (v()) {
                this.s.g.a();
            } else {
                this.s.g.a(q());
            }
            this.n = new ib();
            if (this.o.q()) {
                if (!this.b.isEmpty()) {
                    this.d.a(this.b);
                    this.b.clear();
                }
                K();
            } else {
                a(f.LOADING);
            }
            if (this.o.q()) {
                return;
            }
            ironLog.verbose(b("auction disabled"));
            L();
            C();
        }
    }

    private void C() {
        gw<Smash> gwVarE = E();
        if (gwVarE.c()) {
            a(509, "Mediation No fill", false);
        }
        Iterator<Smash> it = gwVarE.a().iterator();
        while (it.hasNext()) {
            it.next().E();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        IronLog.INTERNAL.verbose(i());
        AsyncTask.execute(new d());
    }

    private gw<Smash> E() {
        IronLog.INTERNAL.verbose();
        return new fw(this.o).d(this.f4075a.b());
    }

    private void F() {
        this.u.a(this.o.getAdUnit(), false);
    }

    private void K() {
        IronLog.INTERNAL.verbose(i());
        synchronized (this.x) {
            f fVar = this.p;
            f fVar2 = f.AUCTION;
            if (fVar == fVar2) {
                return;
            }
            a(fVar2);
            this.I.set(false);
            long jK = this.o.getAuctionSettings().k() - ib.a(this.m);
            if (jK > 0) {
                new Timer().schedule(new c(), jK);
            } else {
                D();
            }
        }
    }

    private void L() {
        IronLog.INTERNAL.verbose(i());
        a(j(), m());
    }

    private Smash a(m5 m5Var, String str) {
        NetworkSettings networkSettingsA = this.o.a(m5Var.c());
        if (networkSettingsA != null) {
            com.json.mediationsdk.c.b().b(networkSettingsA, this.o.getAdUnit(), k());
            BaseAdAdapter<?, Listener> baseAdAdapterA = a(networkSettingsA, this.o.getAdUnit());
            if (baseAdAdapterA != null) {
                Smash smash = (Smash) a(networkSettingsA, baseAdAdapterA, this.C.a(this.o.getAdUnit()), str, m5Var);
                this.b.put(m5Var.c(), h.a.ISAuctionPerformanceDidntAttemptToLoad);
                return smash;
            }
            IronLog.INTERNAL.error(b("addSmashToWaterfall - could not load ad adapter for " + networkSettingsA.getProviderInstanceName()));
        } else {
            String str2 = "could not find matching provider settings for auction response item - item = " + m5Var.c() + " state = " + this.p;
            IronLog.INTERNAL.error(b(str2));
            this.s.k.h(str2);
        }
        return null;
    }

    private yj a(u0 u0Var) {
        if (u0Var.getSharedManagersThread()) {
            return IronSourceThreadManager.INSTANCE.getSharedManagersThread();
        }
        return null;
    }

    private String a(List<m5> list, String str) {
        IronLog.INTERNAL.verbose(b("waterfall.size() = " + list.size()));
        this.b.clear();
        StringBuilder sb = new StringBuilder();
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (int i = 0; i < list.size(); i++) {
            m5 m5Var = list.get(i);
            q7 q7VarA = a(m5Var, str);
            if (q7VarA != null) {
                copyOnWriteArrayList.add(q7VarA);
                sb.append(a(m5Var, q7VarA.l()));
            }
            if (i != list.size() - 1) {
                sb.append(StringUtils.COMMA);
            }
        }
        this.f4075a.a(this.o.getLoadingData().a(), (CopyOnWriteArrayList<Smash>) copyOnWriteArrayList, str);
        IronLog.INTERNAL.verbose(b("updateWaterfall() - next waterfall is " + ((Object) sb)));
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Map<String, Object> map, List<String> list, String str) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(b("auction waterfallString = " + str));
        boolean z = false;
        if (map.size() == 0 && list.size() == 0) {
            ironLog.verbose(b("auction failed - no candidates"));
            this.s.i.a(1005, "No candidates available for auctioning");
            a(a2.e(this.o.getAdUnit()), "no available ad to load", false);
            return;
        }
        this.s.i.b(str);
        if (this.c == null) {
            ironLog.error(b("mAuctionHandler is null"));
            return;
        }
        int iA = this.C.a(this.o.getAdUnit());
        i iVar = new i(this.o.getAdUnit());
        iVar.b(IronSourceUtils.isEncryptedResponse());
        iVar.a(map);
        iVar.a(list);
        iVar.a(this.d);
        iVar.a(iA);
        iVar.a(this.v);
        iVar.d(this.G);
        eu euVar = this.H;
        if (euVar != null && euVar.b()) {
            z = true;
        }
        iVar.e(z);
        a(ContextProvider.getInstance().getApplicationContext(), iVar, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Map<String, Object> map, List<String> list, StringBuilder sb, List<w7> list2) {
        if (list2.isEmpty()) {
            a(map, list, sb.toString());
            return;
        }
        z7 z7Var = new z7();
        e eVar = new e(map, sb, list);
        this.s.h.a();
        z7Var.a(list2, eVar, this.o.getCollectBiddingDataTimeout(), TimeUnit.MILLISECONDS);
    }

    private void a(JSONObject jSONObject) {
        this.u.a(this.o.getAdUnit(), jSONObject != null ? jSONObject.optBoolean(com.json.mediationsdk.d.f, false) : false);
        b(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Object> b(NetworkSettings networkSettings, AdapterBaseInterface adapterBaseInterface) {
        HashMap map = new HashMap();
        try {
            map.put(IronSourceConstants.EVENTS_PROVIDER, networkSettings.getProviderDefaultInstance());
            map.put(IronSourceConstants.EVENTS_PROVIDER_ADAPTER_VERSION, adapterBaseInterface.getAdapterVersion());
            map.put(IronSourceConstants.EVENTS_PROVIDER_SDK_VERSION, adapterBaseInterface.getNetworkSDKVersion());
            map.put("spId", networkSettings.getSubProviderId());
            map.put("instanceType", Integer.valueOf(networkSettings.getInstanceType(this.o.getAdUnit())));
            map.put(IronSourceConstants.EVENTS_PROGRAMMATIC, Integer.valueOf(p()));
        } catch (Exception e2) {
            o9.d().a(e2);
            IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.INTERNAL, "getProviderEventData " + networkSettings.getProviderDefaultInstance(), e2);
        }
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Map<String, Object> map, List<String> list, StringBuilder sb, List<w7> list2) {
        StringBuilder sbAppend;
        String providerName;
        for (NetworkSettings networkSettings : this.o.j()) {
            eu euVar = this.H;
            if (euVar == null || euVar.a(networkSettings, this.o.getAdUnit())) {
                if (!this.l.b(new ps(networkSettings.getProviderInstanceName(), networkSettings.getMaxAdsPerSession(this.o.getAdUnit()))) && d(networkSettings)) {
                    AdData adDataA = a(networkSettings, (String) null);
                    if (networkSettings.isBidder(this.o.getAdUnit())) {
                        AdapterBaseInterface adapterBaseInterfaceB = com.json.mediationsdk.c.b().b(networkSettings, this.o.getAdUnit(), k());
                        if (adapterBaseInterfaceB instanceof y7) {
                            list2.add(new w7(networkSettings.getInstanceType(this.o.getAdUnit()), networkSettings.getProviderInstanceName(), adDataA, (y7) adapterBaseInterfaceB, this, networkSettings));
                        } else {
                            if (adapterBaseInterfaceB == null) {
                                sbAppend = new StringBuilder("prepareAuctionCandidates - could not load network adapter ");
                                providerName = networkSettings.getProviderName();
                            } else {
                                sbAppend = new StringBuilder("network adapter ").append(networkSettings.getProviderName());
                                providerName = " does not implementing BiddingDataInterface";
                            }
                            this.s.k.g(sbAppend.append(providerName).toString());
                        }
                    } else {
                        list.add(networkSettings.getProviderInstanceName());
                        sb.append(networkSettings.getInstanceType(this.o.getAdUnit())).append(networkSettings.getProviderInstanceName()).append(StringUtils.COMMA);
                    }
                }
            }
        }
    }

    private void b(JSONObject jSONObject) {
        int i;
        try {
            if (jSONObject == null) {
                this.o.b(false);
                IronLog.INTERNAL.verbose(b("loading configuration from auction response is null, using the following: " + this.o.r()));
                return;
            }
            try {
                if (jSONObject.has(com.json.mediationsdk.d.x) && (i = jSONObject.getInt(com.json.mediationsdk.d.x)) > 0) {
                    this.o.a(i);
                }
                if (jSONObject.has(com.json.mediationsdk.d.y)) {
                    this.o.a(jSONObject.getBoolean(com.json.mediationsdk.d.y));
                }
                this.o.b(jSONObject.optBoolean(com.json.mediationsdk.d.z, false));
                IronLog.INTERNAL.verbose(b(this.o.r()));
            } catch (JSONException e2) {
                o9.d().a(e2);
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.error("failed to update loading configuration for" + this.o.getAdUnit() + " Error: " + e2.getMessage());
                ironLog.verbose(b(this.o.r()));
            }
        } catch (Throwable th) {
            IronLog.INTERNAL.verbose(b(this.o.r()));
            throw th;
        }
    }

    private boolean b(b2 b2Var) {
        return !new ArrayList(Arrays.asList(b2.INIT_STARTED, b2.LOAD_AD, b2.AUCTION_REQUEST, b2.AUCTION_REQUEST_WATERFALL, b2.AUCTION_FAILED_NO_CANDIDATES, b2.COLLECT_TOKEN, b2.COLLECT_TOKENS_COMPLETED, b2.COLLECT_TOKENS_FAILED, b2.INSTANCE_COLLECT_TOKEN, b2.INSTANCE_COLLECT_TOKEN_SUCCESS, b2.INSTANCE_COLLECT_TOKEN_FAILED, b2.INSTANCE_COLLECT_TOKEN_TIMED_OUT)).contains(b2Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(NetworkSettings networkSettings) {
        IronLog.INTERNAL.verbose(b(String.format("Start initializing provider %s on thread %s", networkSettings.getProviderInstanceName(), Thread.currentThread().getName())));
        AdData adDataA = a(networkSettings, this.o.getUserId());
        AdapterBaseInterface adapterBaseInterfaceB = com.json.mediationsdk.c.b().b(networkSettings, this.o.getAdUnit(), k());
        if (adapterBaseInterfaceB != null) {
            try {
                adapterBaseInterfaceB.init(adDataA, ContextProvider.getInstance().getApplicationContext(), null);
            } catch (Exception e2) {
                o9.d().a(e2);
                this.s.k.g("initProvider - exception while calling networkAdapter.init with " + networkSettings.getProviderName() + " - " + e2);
            }
        }
        IronLog.INTERNAL.verbose(b(String.format("Done initializing provider %s on thread %s", networkSettings.getProviderInstanceName(), Thread.currentThread().getName())));
    }

    private boolean c(b2 b2Var) {
        return new ArrayList(Arrays.asList(b2.LOAD_AD_SUCCESS, b2.LOAD_AD_FAILED, b2.LOAD_AD_FAILED_WITH_REASON, b2.AUCTION_SUCCESS, b2.AUCTION_FAILED, b2.AUCTION_FAILED_NO_CANDIDATES, b2.AD_FORMAT_CAPPED, b2.AD_OPENED, b2.SHOW_AD, b2.SHOW_AD_FAILED, b2.AD_CLICKED, b2.RELOAD_AD_FAILED_WITH_REASON, b2.RELOAD_AD_SUCCESS, b2.AD_LEFT_APPLICATION)).contains(b2Var);
    }

    private boolean c(NetworkSettings networkSettings, AdapterBaseInterface adapterBaseInterface) {
        if (this.f4075a.a(adapterBaseInterface, this.o.getAdUnit(), networkSettings.getProviderInstanceName())) {
            return false;
        }
        return networkSettings.shouldEarlyInit() || networkSettings.isIronSource() || networkSettings.isBidder(this.o.getAdUnit());
    }

    private boolean c(boolean z) {
        Boolean bool = this.z;
        if (bool == null) {
            return false;
        }
        return (z && !bool.booleanValue() && u()) || (!z && this.z.booleanValue());
    }

    private boolean d(NetworkSettings networkSettings) {
        AdapterBaseInterface adapterBaseInterfaceB = com.json.mediationsdk.c.b().b(networkSettings, this.o.getAdUnit(), k());
        if (adapterBaseInterfaceB instanceof AdapterSettingsInterface) {
            return this.f4075a.a(this.o.getLoadingData().a(), networkSettings.getProviderInstanceName(), networkSettings.getProviderTypeForReflection(), a(networkSettings, adapterBaseInterfaceB), adapterBaseInterfaceB, this.o.getAdUnit());
        }
        return false;
    }

    private List<m5> j() {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (NetworkSettings networkSettings : this.o.j()) {
            if (!networkSettings.isBidder(this.o.getAdUnit()) && d(networkSettings)) {
                ps psVar = new ps(networkSettings.getProviderInstanceName(), networkSettings.getMaxAdsPerSession(this.o.getAdUnit()));
                if (!this.l.b(psVar)) {
                    copyOnWriteArrayList.add(new m5(psVar.c()));
                }
            }
        }
        return copyOnWriteArrayList;
    }

    private int p() {
        return 1;
    }

    private void r() {
        IronLog.INTERNAL.verbose(i());
        ArrayList arrayList = new ArrayList();
        for (NetworkSettings networkSettings : this.o.j()) {
            if (c(networkSettings, com.json.mediationsdk.c.b().b(networkSettings, this.o.getAdUnit(), k()))) {
                arrayList.add(new b(networkSettings));
            }
        }
        IronSourceThreadManager.INSTANCE.executeTasks(this.o.getProvidersParallelInit(), this.o.getWaitUntilAllProvidersFinishInit(), arrayList);
    }

    private void s() {
        ArrayList arrayList = new ArrayList();
        for (NetworkSettings networkSettings : this.o.j()) {
            arrayList.add(new ps(networkSettings.getProviderInstanceName(), networkSettings.getMaxAdsPerSession(this.o.getAdUnit())));
        }
        qs qsVar = new qs();
        this.l = qsVar;
        qsVar.a(arrayList);
    }

    public void A() {
        if (c()) {
            a(new a());
        } else {
            B();
        }
    }

    protected void G() {
        n.a().a(this.o.getAdUnit(), this.o.getDelayLoadFailure());
    }

    protected boolean H() {
        return true;
    }

    protected boolean I() {
        return true;
    }

    public void J() {
        Iterator<NetworkSettings> it = this.o.j().iterator();
        while (it.hasNext()) {
            com.json.mediationsdk.c.b().b(it.next(), this.o.getAdUnit(), k());
        }
    }

    protected LoadWhileShowSupportState a(NetworkSettings networkSettings, AdapterBaseInterface adapterBaseInterface) {
        return LoadWhileShowSupportState.NONE;
    }

    protected BaseAdAdapter<?, Listener> a(NetworkSettings networkSettings, IronSource.AD_UNIT ad_unit) {
        BaseAdAdapter<?, Listener> baseAdAdapter = (BaseAdAdapter<?, Listener>) com.json.mediationsdk.c.b().a(networkSettings, ad_unit, k());
        if (baseAdAdapter != null) {
            return baseAdAdapter;
        }
        return null;
    }

    protected AdData a(NetworkSettings networkSettings, String str) {
        return AdData.createAdDataForNetworkAdapter(b(networkSettings), this.o.getAdUnit(), str);
    }

    protected abstract Smash a(NetworkSettings networkSettings, BaseAdAdapter<?, Listener> baseAdAdapter, int i, String str, m5 m5Var);

    protected String a(m5 m5Var, int i) {
        return String.format("%s%s", Integer.valueOf(i), m5Var.c());
    }

    public Map<String, Object> a(b2 b2Var) {
        HashMap map = new HashMap();
        map.put(IronSourceConstants.EVENTS_PROVIDER, "Mediation");
        map.put(IronSourceConstants.EVENTS_PROGRAMMATIC, 1);
        JSONObject jSONObject = this.g;
        if (jSONObject != null && jSONObject.length() > 0) {
            map.put("genericParams", this.g);
        }
        map.put("sessionDepth", Integer.valueOf(this.C.a(this.o.getAdUnit())));
        if (c(b2Var)) {
            map.put(IronSourceConstants.AUCTION_TRIALS, Integer.valueOf(this.e));
            if (!TextUtils.isEmpty(this.f)) {
                map.put(IronSourceConstants.AUCTION_FALLBACK, this.f);
            }
        }
        if (b(b2Var) && !TextUtils.isEmpty(this.f4075a.c())) {
            map.put("auctionId", this.f4075a.c());
        }
        return map;
    }

    @Override // com.json.p
    public void a() {
        if (this.o.getLoadingData().e()) {
            a(f.READY_TO_LOAD);
            b(true);
            A();
        }
    }

    @Override // com.json.bw
    public void a(int i) {
        this.s.k.u("waterfalls hold too many with size = " + i);
    }

    @Override // com.json.s4
    public void a(int i, String str, int i2, String str2, long j) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(i());
        if (!y()) {
            String str3 = "unexpected auction fail - error = " + i + ", " + str + " state = " + this.p;
            ironLog.error(b(str3));
            this.s.k.i(str3);
            return;
        }
        String str4 = "Auction failed | moving to fallback waterfall (error " + i + " - " + str + ")";
        ironLog.verbose(b(str4));
        IronSourceUtils.sendAutomationLog(l() + ": " + str4);
        this.e = i2;
        this.f = str2;
        this.g = IronSourceNetworkBridge.jsonObjectInit();
        L();
        this.s.i.a(j, i, str);
        a(f.LOADING);
        C();
    }

    protected void a(int i, String str, boolean z) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose();
        a(f.READY_TO_LOAD);
        ironLog.verbose(b("errorCode = " + i + ", errorReason = " + str));
        if (this.o.getLoadingData().f()) {
            if (!z) {
                this.s.g.a(ib.a(this.n), i, str, q());
            }
            a(new IronSourceError(i, str));
        } else {
            if (!z) {
                this.s.k.b(i, str);
            }
            b(false);
        }
        this.q.e();
    }

    protected void a(Context context, i iVar, s4 s4Var) {
        com.json.mediationsdk.e eVar = this.c;
        if (eVar != null) {
            eVar.a(context, iVar, s4Var);
        } else {
            IronLog.INTERNAL.error(b("mAuctionHandler is null"));
        }
    }

    public void a(Context context, boolean z) {
        IronLog.INTERNAL.verbose(b("track = " + z));
        try {
            this.j = z;
            if (z) {
                if (this.k == null) {
                    this.k = new NetworkStateReceiver(context, this);
                }
                context.getApplicationContext().registerReceiver(this.k, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            } else if (this.k != null) {
                context.getApplicationContext().unregisterReceiver(this.k);
            }
        } catch (Exception e2) {
            o9.d().a(e2);
            IronLog.INTERNAL.error("Got an error from receiver with message: " + e2.getMessage());
        }
    }

    public void a(eu euVar) {
        this.H = euVar;
        this.G = euVar != null;
        this.z = null;
    }

    protected void a(l2 l2Var) {
        this.t = l2Var;
    }

    public void a(IronSourceSegment ironSourceSegment) {
        this.v = ironSourceSegment;
    }

    protected void a(IronSourceError ironSourceError) {
        n.a().b(this.o.getAdUnit(), ironSourceError);
    }

    @Override // com.json.r2
    public void a(IronSourceError ironSourceError, q7<?> q7Var) {
        gw<Smash> gwVarE;
        q7<?> q7VarC;
        synchronized (this.x) {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.verbose(b(q7Var.k() + " - error = " + ironSourceError));
            if (q7Var.h().equals(this.f4075a.c()) && this.p != f.AUCTION) {
                this.b.put(q7Var.c(), h.a.ISAuctionPerformanceFailedToLoad);
                if (z() || x()) {
                    gwVarE = E();
                    if (gwVarE.c()) {
                        a(509, "Mediation No fill", false);
                        return;
                    }
                } else {
                    gwVarE = null;
                }
                if (gwVarE == null) {
                    return;
                }
                if (this.o.getCom.ironsource.mediationsdk.d.z java.lang.String()) {
                    synchronized (this.x) {
                        if (gwVarE.b() && w() && (q7VarC = new fw(this.o).c(this.f4075a.b())) != null) {
                            i(q7VarC);
                        }
                    }
                }
                Iterator<Smash> it = gwVarE.a().iterator();
                while (it.hasNext()) {
                    it.next().E();
                }
                return;
            }
            ironLog.error(b("onAdLoadFailed was invoked from " + q7Var.c() + " with state =" + this.p + " auctionId: " + q7Var.h() + " and the current id is " + this.f4075a.c()));
            this.s.k.n("onAdLoadFailed was invoked with state =" + this.p);
        }
    }

    @Override // com.json.x7
    public void a(NetworkSettings networkSettings) {
        AdapterBaseInterface adapterBaseInterfaceB = com.json.mediationsdk.c.b().b(networkSettings, this.o.getAdUnit(), k());
        if (adapterBaseInterfaceB != null) {
            this.s.h.a(b(networkSettings, adapterBaseInterfaceB));
        }
    }

    protected void a(f fVar) {
        synchronized (this.x) {
            IronLog.INTERNAL.verbose("set current state to = " + fVar);
            this.p = fVar;
        }
    }

    protected void a(q7<?> q7Var, AdInfo adInfo) {
        this.t.c(adInfo);
    }

    @Override // com.json.tp
    public void a(Runnable runnable) {
        yj yjVar = this.J;
        if (yjVar != null) {
            yjVar.a(runnable);
        }
    }

    @Override // com.json.x7
    public void a(String str) {
        this.s.k.g(str);
    }

    @Override // com.json.s4
    public void a(List<m5> list, String str, m5 m5Var, JSONObject jSONObject, JSONObject jSONObject2, int i, long j, int i2, String str2) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(i());
        if (!y()) {
            ironLog.error(b("unexpected auction success for auctionId - " + str + " state = " + this.p));
            this.s.k.j("unexpected auction success, state = " + this.p);
            return;
        }
        this.f = "";
        this.e = i;
        this.h = m5Var;
        this.g = jSONObject;
        if (!TextUtils.isEmpty(str2)) {
            this.s.k.a(i2, str2);
        }
        a(jSONObject2);
        if (this.u.a(this.o.getAdUnit())) {
            this.s.i.a(str);
            a(IronSourceError.ERROR_AD_FORMAT_CAPPED, "Ad unit is capped", true);
            return;
        }
        String strA = a(list, str);
        this.s.i.a(j, this.o.r());
        this.s.i.c(strA);
        a(f.LOADING);
        C();
    }

    @Override // com.json.Cdo
    public void a(boolean z) {
        if (!this.j || this.o.getLoadingData().f()) {
            return;
        }
        IronLog.INTERNAL.verbose("network availability changed to - " + z);
        if (c(z)) {
            a(z, false, (q7<?>) null);
        }
    }

    protected void a(boolean z, boolean z2, q7<?> q7Var) {
        synchronized (this.x) {
            Boolean bool = this.z;
            if (bool == null || bool.booleanValue() != z) {
                this.z = Boolean.valueOf(z);
                long time = 0;
                if (this.y != 0) {
                    time = new Date().getTime() - this.y;
                }
                this.y = new Date().getTime();
                this.s.g.a(z, time, z2);
                AdInfo adInfoF = q7Var != null ? q7Var.f() : this.A;
                this.A = adInfoF;
                l2 l2Var = this.t;
                if (!z) {
                    adInfoF = null;
                }
                l2Var.a(z, adInfoF);
            }
        }
    }

    protected boolean a(f fVar, f fVar2) {
        boolean z;
        synchronized (this.x) {
            if (this.p == fVar) {
                IronLog.INTERNAL.verbose("expected state = " + fVar + ", state to set = " + fVar2);
                this.p = fVar2;
                z = true;
            } else {
                IronLog.INTERNAL.verbose("wrong state, current state = " + this.p + ", expected state = " + fVar);
                z = false;
            }
        }
        return z;
    }

    protected String b(String str) {
        String str2 = this.o.getAdUnit().name() + " state:" + this.p;
        return TextUtils.isEmpty(str) ? str2 : str2 + " - " + str;
    }

    protected abstract JSONObject b(NetworkSettings networkSettings);

    public void b() {
        IronLog.INTERNAL.verbose(i());
        A();
    }

    protected void b(m5 m5Var, String str) {
        if (m5Var == null) {
            IronLog.INTERNAL.error(b("reportImpressionDataToPublisher - no auctionResponseItem or listener"));
            e2 e2Var = this.s;
            if (e2Var != null) {
                e2Var.k.g("reportImpressionDataToPublisher - no auctionResponseItem or listener");
                return;
            }
            return;
        }
        ImpressionData impressionDataA = m5Var.a(str);
        if (impressionDataA != null) {
            for (ImpressionDataListener impressionDataListener : new HashSet(this.B.a())) {
                IronLog.CALLBACK.info(b("onImpressionSuccess " + impressionDataListener.getClass().getSimpleName() + ": " + impressionDataA));
                impressionDataListener.onImpressionSuccess(impressionDataA);
            }
        }
    }

    @Override // com.json.r2
    public void b(q7<?> q7Var) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(b(q7Var.k()));
        this.s.j.g(n());
        this.f4075a.a(q7Var);
        this.f4075a.b(q7Var);
        this.l.a(q7Var);
        if (this.l.b(q7Var)) {
            ironLog.verbose(b(q7Var.c() + " was session capped"));
            q7Var.N();
            IronSourceUtils.sendAutomationLog(q7Var.c() + " was session capped");
        }
        this.F.a(ContextProvider.getInstance().getApplicationContext(), n(), this.o.getAdUnit());
        if (this.E.b(ContextProvider.getInstance().getApplicationContext(), this.i, this.o.getAdUnit())) {
            ironLog.verbose(b("placement " + n() + " is capped"));
            this.s.j.b(n(), null);
        }
        this.D.b(this.o.getAdUnit());
        if (this.o.q()) {
            m5 m5VarI = q7Var.i();
            this.c.a(m5VarI, q7Var.l(), this.h, n());
            this.b.put(q7Var.c(), h.a.ISAuctionPerformanceShowedSuccessfully);
            if (H()) {
                b(m5VarI, n());
            }
        }
        g(q7Var);
        if (this.o.getLoadingData().e()) {
            b(false);
        }
        this.q.h();
    }

    protected void b(boolean z) {
        a(false, z, (q7<?>) null);
    }

    @Override // com.json.tp
    public boolean c() {
        yj yjVar = this.J;
        if (yjVar == null || yjVar == Thread.currentThread()) {
            return false;
        }
        return this.o.getSharedManagersThread();
    }

    @Override // com.json.r2
    public void e(q7<?> q7Var) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(b(q7Var.k()));
        if (!q7Var.h().equals(this.f4075a.c())) {
            ironLog.error(b("invoked from " + q7Var.c() + " with state = " + this.p + " auctionId: " + q7Var.h() + " and the current id is " + this.f4075a.c()));
            this.s.k.o("onAdLoadSuccess invoked with state = " + this.p);
            return;
        }
        if (this.o.getCom.ironsource.mediationsdk.d.z java.lang.String()) {
            List<Smash> listB = this.f4075a.b();
            fw fwVar = new fw(this.o);
            boolean zA = fwVar.a(q7Var, listB);
            synchronized (this.x) {
                if (zA) {
                    if (w()) {
                        i(q7Var);
                    }
                }
                if (fwVar.a(listB)) {
                    i(fwVar.c(listB));
                }
            }
        }
        this.b.put(q7Var.c(), h.a.ISAuctionPerformanceLoadedSuccessfully);
        if (a(f.LOADING, f.READY_TO_SHOW)) {
            long jA = ib.a(this.n);
            if (v()) {
                this.s.g.a(jA);
            } else {
                this.s.g.a(jA, q());
            }
            if (this.o.getLoadingData().e()) {
                this.r.a(0L);
            }
            if (!this.o.getCom.ironsource.mediationsdk.d.z java.lang.String()) {
                i(q7Var);
            }
            h(q7Var);
        }
    }

    @Override // com.json.r2
    public void f(q7<?> q7Var) {
        IronLog.INTERNAL.verbose(b(q7Var.k()));
        this.s.j.a(n());
        this.t.a(this.i, q7Var.f());
    }

    protected abstract l2 g();

    protected void g(q7<?> q7Var) {
        this.t.d(q7Var.f());
    }

    protected q2 h() {
        return new q2(this.o.getLoadingData(), this);
    }

    protected void h(q7<?> q7Var) {
        if (this.o.getLoadingData().f()) {
            a(q7Var, q7Var.f());
        } else {
            a(true, false, q7Var);
        }
    }

    protected String i() {
        return b((String) null);
    }

    protected void i(q7<?> q7Var) {
        if (this.o.q() && this.I.compareAndSet(false, true)) {
            m5 m5VarI = q7Var.i();
            this.c.a(m5VarI, q7Var.l(), this.h);
            ArrayList<String> arrayList = new ArrayList<>();
            ConcurrentHashMap<String, m5> concurrentHashMap = new ConcurrentHashMap<>();
            for (Smash smash : this.f4075a.b()) {
                arrayList.add(smash.c());
                concurrentHashMap.put(smash.c(), smash.i());
            }
            this.c.a(arrayList, concurrentHashMap, q7Var.l(), this.h, m5VarI);
        }
    }

    public UUID k() {
        return this.w;
    }

    protected abstract String l();

    protected String m() {
        return "fallback_" + System.currentTimeMillis();
    }

    protected String n() {
        Placement placement = this.i;
        return placement == null ? "" : placement.getPlacementName();
    }

    abstract String o();

    protected boolean q() {
        return false;
    }

    protected boolean t() {
        return false;
    }

    protected boolean u() {
        return false;
    }

    protected abstract boolean v();

    protected boolean w() {
        boolean z;
        synchronized (this.x) {
            f fVar = this.p;
            z = fVar == f.LOADING || fVar == f.READY_TO_SHOW;
        }
        return z;
    }

    protected boolean x() {
        boolean z;
        synchronized (this.x) {
            z = this.p == f.READY_TO_SHOW;
        }
        return z;
    }

    protected boolean y() {
        boolean z;
        synchronized (this.x) {
            z = this.p == f.AUCTION;
        }
        return z;
    }

    protected boolean z() {
        boolean z;
        synchronized (this.x) {
            z = this.p == f.LOADING;
        }
        return z;
    }
}
