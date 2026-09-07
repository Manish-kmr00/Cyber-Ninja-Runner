package com.json;

import android.text.TextUtils;
import com.json.environment.ContextProvider;
import com.json.mediationsdk.IronSource;
import com.json.mediationsdk.adunit.adapter.internal.AdapterAdFullScreenInterface;
import com.json.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.json.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.json.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener;
import com.json.mediationsdk.adunit.adapter.listener.NetworkInitializationListener;
import com.json.mediationsdk.adunit.adapter.utility.AdData;
import com.json.mediationsdk.adunit.adapter.utility.AdInfo;
import com.json.mediationsdk.adunit.adapter.utility.AdapterErrorType;
import com.json.mediationsdk.logger.IronLog;
import com.json.mediationsdk.logger.IronSourceError;
import com.json.mediationsdk.model.NetworkSettings;
import com.json.mediationsdk.model.Placement;
import com.json.mediationsdk.utils.ErrorBuilder;
import com.json.mediationsdk.utils.IronSourceConstants;
import com.json.r2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public abstract class q7<Listener extends r2> implements NetworkInitializationListener, qt.a, d2, AdapterAdListener, zh.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected m1 f4187a;
    protected Listener b;
    protected BaseAdAdapter<?, AdapterAdListener> c;
    protected e2 d;
    protected h e;
    protected Placement g;
    protected c3 h;
    protected JSONObject i;
    protected String j;
    protected AdData k;
    protected Long l;
    protected ib m;
    private final m5 o;
    private final tp p;
    private AtomicBoolean f = new AtomicBoolean(false);
    private qt n = new qt(TimeUnit.SECONDS.toMillis(s()));
    protected final Object q = new Object();

    class a extends hr {
        a() {
        }

        @Override // com.json.hr
        public void a() {
            q7.this.L();
        }
    }

    class b extends hr {
        b() {
        }

        @Override // com.json.hr
        public void a() {
            q7.this.K();
        }
    }

    class c extends hr {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f4190a;
        final /* synthetic */ String b;

        c(int i, String str) {
            this.f4190a = i;
            this.b = str;
        }

        @Override // com.json.hr
        public void a() {
            q7.this.a(this.f4190a, this.b);
        }
    }

    class d extends hr {
        d() {
        }

        @Override // com.json.hr
        public void a() {
            q7.this.I();
        }
    }

    class e extends hr {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdapterErrorType f4192a;
        final /* synthetic */ int b;
        final /* synthetic */ String c;

        e(AdapterErrorType adapterErrorType, int i, String str) {
            this.f4192a = adapterErrorType;
            this.b = i;
            this.c = str;
        }

        @Override // com.json.hr
        public void a() {
            q7.this.a(this.f4192a, this.b, this.c);
        }
    }

    class f extends hr {
        f() {
        }

        @Override // com.json.hr
        public void a() {
            q7.this.J();
        }
    }

    class g extends hr {
        g() {
        }

        @Override // com.json.hr
        public void a() {
            q7.this.H();
        }
    }

    protected enum h {
        NONE,
        INIT_IN_PROGRESS,
        READY_TO_LOAD,
        LOADING,
        LOADED,
        SHOWING,
        FAILED
    }

    /* JADX WARN: Multi-variable type inference failed */
    public q7(tp tpVar, m1 m1Var, BaseAdAdapter<?, ?> baseAdAdapter, c3 c3Var, m5 m5Var, Listener listener) {
        this.f4187a = m1Var;
        this.b = listener;
        this.d = new e2(m1Var.a(), e2.b.PROVIDER, this);
        this.h = c3Var;
        this.i = c3Var.c();
        this.c = baseAdAdapter;
        this.o = m5Var;
        this.p = tpVar;
        a(h.NONE);
    }

    private boolean D() {
        return this.e == h.INIT_IN_PROGRESS;
    }

    private void F() {
        IronLog.INTERNAL.verbose(d());
        a(h.LOADING);
        a(false);
        try {
            this.n.a((qt.a) this);
            G();
        } catch (Throwable th) {
            o9.d().a(th);
            String str = "unexpected error while calling adapter.loadAd() - " + th.getMessage() + " - state = " + this.e;
            IronLog.INTERNAL.error(a(str));
            e2 e2Var = this.d;
            if (e2Var != null) {
                e2Var.k.g(str);
            }
            onAdLoadFailed(AdapterErrorType.ADAPTER_ERROR_TYPE_INTERNAL, 510, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        IronLog.INTERNAL.verbose(d());
        e2 e2Var = this.d;
        if (e2Var != null) {
            e2Var.j.a(j());
        }
        this.b.f(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        boolean zO;
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(d());
        qt qtVar = this.n;
        if (qtVar != null) {
            qtVar.e();
        }
        synchronized (this.q) {
            h hVar = this.e;
            zO = false;
            if (hVar == h.LOADING) {
                long jA = ib.a(this.m);
                ironLog.verbose(a("Load duration = " + jA));
                if (this.d != null) {
                    if (v()) {
                        this.d.g.a(jA);
                    } else {
                        this.d.g.a(jA, false);
                    }
                }
                a(h.LOADED);
                zO = O();
            } else if (hVar != h.FAILED) {
                ironLog.error(a(String.format("unexpected load success for %s, state - %s", k(), this.e)));
                String str = String.format("unexpected load success, state - %s", this.e);
                if (this.d != null) {
                    if (v()) {
                        this.d.k.r(str);
                    } else {
                        this.d.k.o(str);
                    }
                }
            }
        }
        if (zO) {
            this.b.e(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        IronLog.INTERNAL.verbose(d());
        a(h.SHOWING);
        e2 e2Var = this.d;
        if (e2Var != null) {
            e2Var.j.g(j());
        }
        this.b.b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(d());
        if (D()) {
            qt qtVar = this.n;
            if (qtVar != null) {
                qtVar.e();
            }
            a(h.READY_TO_LOAD);
            F();
            return;
        }
        if (this.e == h.FAILED) {
            return;
        }
        ironLog.error(a(String.format("unexpected init success for %s, state - %s", k(), this.e)));
        if (this.d != null) {
            this.d.k.m(String.format("unexpected init success, state - %s", this.e));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        long jA = ib.a(this.m);
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(a("Load duration = " + jA + ", state = " + this.e + ", isBidder = " + w()));
        synchronized (this.q) {
            if (!z()) {
                ironLog.error(a(String.format("unexpected timeout for %s, state - %s, error - %s", k(), this.e, 1025)));
                if (this.d != null) {
                    this.d.k.t(String.format("unexpected timeout, state - %s, error - %s", this.e, 1025));
                }
                return;
            }
            a(h.FAILED);
            e2 e2Var = this.d;
            if (e2Var != null) {
                e2Var.g.a(jA, 1025, false);
                this.d.g.a(jA, 1025, "time out", false);
            }
            this.b.a(ErrorBuilder.buildLoadFailedError("time out"), this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(a("error = " + i + ", " + str));
        if (D()) {
            qt qtVar = this.n;
            if (qtVar != null) {
                qtVar.e();
            }
            a(h.FAILED);
            a(AdapterErrorType.ADAPTER_ERROR_TYPE_INTERNAL, i, str, ib.a(this.m));
            this.b.a(new IronSourceError(i, str), this);
            return;
        }
        if (this.e == h.FAILED) {
            return;
        }
        ironLog.error(a(String.format("unexpected init failed for %s, state - %s, error - %s, %s", k(), this.e, Integer.valueOf(i), str)));
        if (this.d != null) {
            this.d.k.l(String.format("unexpected init failed, state - %s, error - %s, %s", this.e, Integer.valueOf(i), str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdapterErrorType adapterErrorType, int i, String str) {
        long jA = ib.a(this.m);
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(a("Load duration = " + jA + ", error = " + i + ", " + str));
        qt qtVar = this.n;
        if (qtVar != null) {
            qtVar.e();
        }
        synchronized (this.q) {
            h hVar = this.e;
            if (hVar == h.LOADING) {
                a(adapterErrorType, i, str, jA);
                a(h.FAILED);
                this.b.a(new IronSourceError(i, str), this);
                return;
            }
            if (hVar == h.FAILED) {
                a(adapterErrorType, i, str, jA);
                return;
            }
            if (hVar == h.LOADED && adapterErrorType == AdapterErrorType.ADAPTER_ERROR_TYPE_AD_EXPIRED) {
                this.l = Long.valueOf(System.currentTimeMillis());
                ironLog.error(a(String.format("ad expired for %s, state = %s", this.h.f(), this.e)));
                e2 e2Var = this.d;
                if (e2Var != null) {
                    e2Var.k.a(String.format("ad expired, state = %s", this.e));
                }
                return;
            }
            ironLog.error(a(String.format("unexpected load failed for %s, state - %s, error - %s, %s", k(), this.e, Integer.valueOf(i), str)));
            String str2 = String.format("unexpected load failed, state - %s, error - %s, %s", this.e, Integer.valueOf(i), str);
            if (this.d != null) {
                if (v()) {
                    this.d.k.q(str2);
                } else if (this.f4187a.a() != IronSource.AD_UNIT.REWARDED_VIDEO || this.e != h.SHOWING) {
                    this.d.k.n(str2);
                }
            }
        }
    }

    private void a(AdapterErrorType adapterErrorType, int i, String str, long j) {
        if (this.d != null) {
            if (adapterErrorType == AdapterErrorType.ADAPTER_ERROR_TYPE_NO_FILL) {
                if (v()) {
                    this.d.g.b(j, i);
                    return;
                } else {
                    this.d.g.a(j, i);
                    return;
                }
            }
            if (TextUtils.isEmpty(str)) {
                this.d.g.a(j, i, false);
            } else if (v()) {
                this.d.g.a(j, i, str);
            } else {
                this.d.g.a(j, i, str, false);
            }
        }
    }

    private boolean b(b2 b2Var) {
        return new ArrayList(Arrays.asList(b2.LOAD_AD, b2.LOAD_AD_SUCCESS, b2.LOAD_AD_FAILED, b2.LOAD_AD_FAILED_WITH_REASON, b2.LOAD_AD_NO_FILL, b2.RELOAD_AD, b2.RELOAD_AD_SUCCESS, b2.RELOAD_AD_FAILED_WITH_REASON, b2.RELOAD_AD_NO_FILL, b2.DESTROY_AD, b2.AD_PRESENT_SCREEN, b2.AD_DISMISS_SCREEN, b2.AD_LEFT_APPLICATION, b2.AD_OPENED, b2.AD_CLOSED, b2.SHOW_AD, b2.SHOW_AD_FAILED, b2.AD_CLICKED, b2.AD_REWARDED)).contains(b2Var);
    }

    private int o() {
        return 1;
    }

    private int s() {
        m5 m5Var = this.o;
        if (m5Var == null) {
            return this.f4187a.f();
        }
        Integer numF = m5Var.f();
        int iF = (numF == null || numF.intValue() <= 0) ? this.f4187a.f() : numF.intValue();
        IronLog.INTERNAL.verbose(a("Load timeout for " + this.o.c() + " - " + iF + " seconds"));
        return iF;
    }

    public AtomicBoolean A() {
        return this.f;
    }

    public boolean B() {
        return y();
    }

    public boolean C() {
        return this.e == h.SHOWING;
    }

    public void E() {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(d());
        m5 m5VarI = i();
        String strK = m5VarI.k();
        Map<String, Object> mapA = mk.a(m5VarI.a());
        mapA.put("adUnit", this.f4187a.a());
        b(strK);
        try {
            boolean z = false;
            if (v()) {
                this.d.g.a();
            } else {
                this.d.g.a(false);
            }
            this.l = null;
            this.m = new ib();
            this.k = a(strK, mapA);
            synchronized (this.q) {
                if (this.e != h.NONE) {
                    z = true;
                } else {
                    a(h.INIT_IN_PROGRESS);
                }
            }
            if (z) {
                String str = "loadAd - incorrect state while loading, state = " + this.e;
                ironLog.error(a(str));
                this.d.k.g(str);
                onInitFailed(a2.c(this.f4187a.a()), str);
                return;
            }
            this.n.a((qt.a) this);
            AdapterBaseInterface networkAdapter = this.c.getNetworkAdapter();
            if (networkAdapter != null) {
                networkAdapter.init(this.k, ContextProvider.getInstance().getApplicationContext(), this);
                return;
            }
            String str2 = "loadAd - network adapter not available " + k();
            ironLog.error(a(str2));
            onInitFailed(a2.c(this.f4187a.a()), str2);
        } catch (Throwable th) {
            o9.d().a(th);
            String str3 = "loadAd - exception = " + th.getLocalizedMessage();
            IronLog.INTERNAL.error(a(str3));
            e2 e2Var = this.d;
            if (e2Var != null) {
                e2Var.k.g(str3);
            }
            onInitFailed(a2.c(this.f4187a.a()), str3);
        }
    }

    protected void G() {
        Object obj = this.c;
        if (obj instanceof AdapterAdFullScreenInterface) {
            ((AdapterAdFullScreenInterface) obj).loadAd(this.k, ContextProvider.getInstance().getCurrentActiveActivity(), this);
        } else {
            IronLog.INTERNAL.error(a("adapter not instance of AdapterAdFullScreenInterface"));
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0059 A[Catch: all -> 0x0069, TryCatch #1 {, blocks: (B:4:0x0003, B:7:0x0008, B:13:0x0055, B:15:0x0059, B:16:0x005e, B:18:0x0062, B:19:0x0067, B:10:0x000f, B:12:0x0050), top: B:26:0x0003, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:18:0x0062 A[Catch: all -> 0x0069, TryCatch #1 {, blocks: (B:4:0x0003, B:7:0x0008, B:13:0x0055, B:15:0x0059, B:16:0x005e, B:18:0x0062, B:19:0x0067, B:10:0x000f, B:12:0x0050), top: B:26:0x0003, inners: #0 }] */
    public void M() {
        e2 e2Var;
        qt qtVar;
        synchronized (this) {
            BaseAdAdapter<?, AdapterAdListener> baseAdAdapter = this.c;
            if (baseAdAdapter != null) {
                try {
                    baseAdAdapter.releaseMemory();
                    this.c = null;
                } catch (Exception e2) {
                    o9.d().a(e2);
                    String str = "Exception while calling adapter.releaseMemory() from " + this.h.f() + " - " + e2.getMessage() + " - state = " + this.e;
                    IronLog.INTERNAL.error(a(str));
                    e2 e2Var2 = this.d;
                    if (e2Var2 != null) {
                        e2Var2.k.g(str);
                    }
                }
                e2Var = this.d;
                if (e2Var != null) {
                    e2Var.f();
                    this.d = null;
                }
                qtVar = this.n;
                if (qtVar != null) {
                    qtVar.d();
                    this.n = null;
                }
            } else {
                e2Var = this.d;
                if (e2Var != null) {
                    e2Var.f();
                    this.d = null;
                }
                qtVar = this.n;
                if (qtVar != null) {
                    qtVar.d();
                    this.n = null;
                }
            }
            throw th;
        }
    }

    public void N() {
        IronLog.INTERNAL.verbose(d());
        e2 e2Var = this.d;
        if (e2Var != null) {
            e2Var.j.a();
        }
    }

    protected boolean O() {
        return true;
    }

    protected AdData a(String str, Map<String, Object> map) {
        return new AdData(str, q(), a(map));
    }

    protected String a(String str) {
        String str2 = this.f4187a.a().name() + " - " + k() + " - state = " + this.e;
        return TextUtils.isEmpty(str) ? str2 : str2 + " - " + str;
    }

    public Map<String, Object> a(b2 b2Var) {
        HashMap map = new HashMap();
        try {
            BaseAdAdapter<?, AdapterAdListener> baseAdAdapter = this.c;
            map.put(IronSourceConstants.EVENTS_PROVIDER_ADAPTER_VERSION, baseAdAdapter != null ? baseAdAdapter.getNetworkAdapter().getAdapterVersion() : "");
            BaseAdAdapter<?, AdapterAdListener> baseAdAdapter2 = this.c;
            map.put(IronSourceConstants.EVENTS_PROVIDER_SDK_VERSION, baseAdAdapter2 != null ? baseAdAdapter2.getNetworkAdapter().getNetworkSDKVersion() : "");
        } catch (Exception e2) {
            o9.d().a(e2);
            IronLog.INTERNAL.error(a("could not get adapter version for event data" + k()));
        }
        map.put("spId", this.h.i());
        map.put(IronSourceConstants.EVENTS_PROVIDER, this.h.a());
        map.put("instanceType", Integer.valueOf(l()));
        map.put(IronSourceConstants.EVENTS_PROGRAMMATIC, Integer.valueOf(o()));
        if (!TextUtils.isEmpty(this.j)) {
            map.put("dynamicDemandSource", this.j);
        }
        map.put("sessionDepth", r());
        if (this.f4187a.e() != null && this.f4187a.e().length() > 0) {
            map.put("genericParams", this.f4187a.e());
        }
        if (!TextUtils.isEmpty(this.f4187a.c())) {
            map.put("auctionId", this.f4187a.c());
        }
        if (b(b2Var)) {
            map.put(IronSourceConstants.AUCTION_TRIALS, Integer.valueOf(this.f4187a.d()));
            if (!TextUtils.isEmpty(this.f4187a.b())) {
                map.put(IronSourceConstants.AUCTION_FALLBACK, this.f4187a.b());
            }
        }
        if (!TextUtils.isEmpty(this.f4187a.g().getCustomNetwork())) {
            map.put(IronSourceConstants.EVENTS_CUSTOM_NETWORK_FIELD, this.f4187a.g().getCustomNetwork());
        }
        return map;
    }

    protected Map<String, Object> a(Map<String, Object> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        map.put("userId", this.f4187a.i());
        return map;
    }

    @Override // com.ironsource.qt.a
    public void a() {
        if (this.p.c()) {
            this.p.a(new a());
        } else {
            L();
        }
    }

    protected void a(h hVar) {
        IronLog.INTERNAL.verbose(d());
        this.e = hVar;
    }

    public void a(boolean z) {
        this.f.set(z);
    }

    @Override // com.ironsource.zh.b
    public int b() {
        return this.h.e();
    }

    public void b(String str) {
        this.j = com.json.mediationsdk.d.b().c(str);
    }

    @Override // com.ironsource.zh.b
    public String c() {
        return this.h.f();
    }

    protected String d() {
        return a((String) null);
    }

    public Long e() {
        return this.l;
    }

    public AdInfo f() {
        return new AdInfo(this.o.a(j()), this.o.d());
    }

    public IronSource.AD_UNIT g() {
        return this.f4187a.a();
    }

    public String h() {
        return this.f4187a.c();
    }

    public m5 i() {
        return this.o;
    }

    protected String j() {
        Placement placement = this.g;
        return placement == null ? "" : placement.getPlacementName();
    }

    public String k() {
        return String.format("%s %s", c(), Integer.valueOf(hashCode()));
    }

    public int l() {
        return this.h.d();
    }

    public String m() {
        return this.h.h().isMultipleInstances() ? this.h.h().getProviderTypeForReflection() : this.h.f();
    }

    public String n() {
        return this.h.g();
    }

    @Override // com.json.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener
    public void onAdClicked() {
        if (this.p.c()) {
            this.p.a(new g());
        } else {
            H();
        }
    }

    @Override // com.json.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener
    public void onAdLoadFailed(AdapterErrorType adapterErrorType, int i, String str) {
        if (this.p.c()) {
            this.p.a(new e(adapterErrorType, i, str));
        } else {
            a(adapterErrorType, i, str);
        }
    }

    @Override // com.json.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener
    public void onAdLoadSuccess() {
        if (this.p.c()) {
            this.p.a(new d());
        } else {
            I();
        }
    }

    public void onAdOpened() {
        if (this.p.c()) {
            this.p.a(new f());
        } else {
            J();
        }
    }

    @Override // com.json.mediationsdk.adunit.adapter.listener.NetworkInitializationListener
    public void onInitFailed(int i, String str) {
        if (this.p.c()) {
            this.p.a(new c(i, str));
        } else {
            a(i, str);
        }
    }

    @Override // com.json.mediationsdk.adunit.adapter.listener.NetworkInitializationListener
    public void onInitSuccess() {
        if (this.p.c()) {
            this.p.a(new b());
        } else {
            K();
        }
    }

    public NetworkSettings p() {
        return this.f4187a.g();
    }

    protected Map<String, Object> q() {
        HashMap map = new HashMap();
        map.putAll(mk.a(this.i));
        return map;
    }

    public Integer r() {
        m1 m1Var = this.f4187a;
        if (m1Var != null) {
            return Integer.valueOf(m1Var.h());
        }
        return null;
    }

    public h t() {
        return this.e;
    }

    protected tp u() {
        return this.p;
    }

    protected boolean v() {
        return false;
    }

    public boolean w() {
        return this.h.j();
    }

    public boolean x() {
        return this.e == h.FAILED;
    }

    public boolean y() {
        return this.e == h.LOADED;
    }

    public boolean z() {
        h hVar = this.e;
        return hVar == h.INIT_IN_PROGRESS || hVar == h.LOADING;
    }
}
