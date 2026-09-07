package com.json.mediationsdk;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import com.json.Cdo;
import com.json.a8;
import com.json.al;
import com.json.ar;
import com.json.bg;
import com.json.cr;
import com.json.dg;
import com.json.dq;
import com.json.dr;
import com.json.environment.ContextProvider;
import com.json.environment.NetworkStateReceiver;
import com.json.environment.thread.IronSourceThreadManager;
import com.json.m5;
import com.json.mediationsdk.impressionData.ImpressionDataListener;
import com.json.mediationsdk.logger.IronLog;
import com.json.mediationsdk.logger.IronSourceError;
import com.json.mediationsdk.logger.IronSourceLogger;
import com.json.mediationsdk.logger.IronSourceLoggerManager;
import com.json.mediationsdk.model.NetworkSettings;
import com.json.mediationsdk.model.Placement;
import com.json.mediationsdk.utils.ErrorBuilder;
import com.json.mediationsdk.utils.IronSourceConstants;
import com.json.mediationsdk.utils.IronSourceUtils;
import com.json.mm;
import com.json.nc;
import com.json.o5;
import com.json.o9;
import com.json.p;
import com.json.pk;
import com.json.qs;
import com.json.s4;
import com.json.w7;
import com.json.yq;
import com.json.z7;
import com.json.zb;
import com.json.zk;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
class q extends m implements zk, dr, s4, dg, Cdo, p {
    private long A;
    private Boolean B;
    private final Object C;
    private nc D;
    private final long E;
    private final bg.a F;
    private final bg G;
    private al e;
    private ConcurrentHashMap<String, m5> f;
    private ConcurrentHashMap<String, h.a> g;
    private m5 h;
    private h i;
    private com.json.mediationsdk.e j;
    private JSONObject k;
    private cr l;
    private boolean m;
    private long n;
    private String o;
    private int p;
    private NetworkStateReceiver q;
    private boolean r;
    private final ConcurrentHashMap<String, r> s;
    private qs t;
    private int u;
    private String v;
    private int w;
    private boolean x;
    private boolean y;
    private e z;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ NetworkSettings f4002a;
        final /* synthetic */ yq b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;

        a(NetworkSettings networkSettings, yq yqVar, String str, String str2) {
            this.f4002a = networkSettings;
            this.b = yqVar;
            this.c = str;
            this.d = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            q.this.a(this.f4002a, this.b, this.c, this.d);
        }
    }

    class b extends TimerTask {
        b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            q.this.j();
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            q.this.d("makeAuction()");
            q.this.n = new Date().getTime();
            HashMap map = new HashMap();
            ArrayList arrayList = new ArrayList();
            StringBuilder sb = new StringBuilder();
            ArrayList arrayList2 = new ArrayList();
            q.this.b(map, arrayList, sb, arrayList2);
            q.this.a(map, arrayList, sb, arrayList2);
        }
    }

    class d implements z7.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Map f4005a;
        final /* synthetic */ StringBuilder b;
        final /* synthetic */ List c;

        d(Map map, StringBuilder sb, List list) {
            this.f4005a = map;
            this.b = sb;
            this.c = list;
        }

        @Override // com.ironsource.z7.b
        public void a(List<a8> list, long j, List<String> list2) {
            q.this.c(IronSourceConstants.RV_COLLECT_TOKENS_COMPLETED, pk.a(new Object[][]{new Object[]{"duration", Long.valueOf(j)}}));
            for (a8 a8Var : list) {
                r rVar = (r) q.this.s.get(a8Var.c());
                if (a8Var.a() != null) {
                    this.f4005a.put(a8Var.c(), a8Var.a());
                    this.b.append(a8Var.d()).append(a8Var.c()).append(StringUtils.COMMA);
                    if (rVar != null) {
                        rVar.a(1021, new Object[][]{new Object[]{"duration", Long.valueOf(a8Var.e())}});
                    }
                } else if (rVar != null) {
                    rVar.a(1022, new Object[][]{new Object[]{"duration", Long.valueOf(a8Var.e())}, new Object[]{"reason", a8Var.b()}});
                }
            }
            Iterator<String> it = list2.iterator();
            while (it.hasNext()) {
                r rVar2 = (r) q.this.s.get(it.next());
                if (rVar2 != null) {
                    rVar2.a(1023, new Object[][]{new Object[]{"duration", Long.valueOf(j)}});
                }
            }
            q.this.a((Map<String, Object>) this.f4005a, (List<String>) this.c, this.b.toString());
        }

        @Override // com.ironsource.z7.b
        public void onFailure(String str) {
            q.this.c(IronSourceConstants.RV_COLLECT_TOKENS_FAILED, pk.a(new Object[][]{new Object[]{"reason", str}}));
            q.this.a((Map<String, Object>) this.f4005a, (List<String>) this.c, this.b.toString());
        }
    }

    private enum e {
        RV_STATE_INITIATING,
        RV_STATE_AUCTION_IN_PROGRESS,
        RV_STATE_NOT_LOADED,
        RV_STATE_LOADING_SMASHES,
        RV_STATE_READY_TO_SHOW
    }

    public q(List<NetworkSettings> list, yq yqVar, String str, String str2, HashSet<ImpressionDataListener> hashSet, IronSourceSegment ironSourceSegment) {
        super(hashSet, ironSourceSegment);
        this.o = "";
        this.r = false;
        this.u = 1;
        this.C = new Object();
        this.F = mm.M().m();
        this.G = mm.S().B();
        long time = new Date().getTime();
        c(IronSourceConstants.RV_MANAGER_INIT_STARTED, pk.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, IronSourceConstants.LWS_RV_MANAGER_NAME}}));
        a(e.RV_STATE_INITIATING);
        this.B = null;
        this.w = yqVar.g();
        this.x = yqVar.j();
        this.v = "";
        this.k = null;
        o5 o5VarK = yqVar.k();
        this.y = false;
        this.e = new al(yqVar.k().f(), yqVar.k().i());
        this.f = new ConcurrentHashMap<>();
        this.g = new ConcurrentHashMap<>();
        this.A = new Date().getTime();
        boolean z = o5VarK.g() > 0;
        this.m = z;
        if (z) {
            this.j = new com.json.mediationsdk.e(IronSource.AD_UNIT.REWARDED_VIDEO, o5VarK, this);
        }
        this.l = new cr(o5VarK, this);
        ConcurrentHashMap<String, r> concurrentHashMap = new ConcurrentHashMap<>();
        this.s = concurrentHashMap;
        a(list, yqVar, str, str2);
        this.i = new h(list, o5VarK.c());
        qs qsVar = new qs();
        this.t = qsVar;
        qsVar.a(new ArrayList(concurrentHashMap.values()));
        this.D = new nc(yqVar.c(), this);
        this.E = yqVar.l();
        c(IronSourceConstants.RV_MANAGER_INIT_ENDED, pk.a(new Object[][]{new Object[]{"duration", Long.valueOf(new Date().getTime() - time)}}));
        a(o5VarK.k());
    }

    private String a(m5 m5Var) {
        String string;
        r rVar = this.s.get(m5Var.c());
        if (rVar != null) {
            string = Integer.toString(rVar.g());
        } else {
            string = TextUtils.isEmpty(m5Var.k()) ? "1" : "2";
        }
        return string + m5Var.c();
    }

    private void a(int i) {
        a(i, (Map<String, Object>) null, true, true);
    }

    private void a(int i, Map<String, Object> map) {
        a(i, map, false, true);
    }

    private void a(int i, Map<String, Object> map, boolean z, boolean z2) {
        HashMap map2 = new HashMap();
        map2.put(IronSourceConstants.EVENTS_PROVIDER, "Mediation");
        map2.put(IronSourceConstants.EVENTS_PROGRAMMATIC, 2);
        if (z2 && !TextUtils.isEmpty(this.e.d())) {
            map2.put("auctionId", this.e.d());
        }
        JSONObject jSONObject = this.k;
        if (jSONObject != null && jSONObject.length() > 0) {
            map2.put("genericParams", this.k);
        }
        if (z && !TextUtils.isEmpty(this.v)) {
            map2.put("placement", this.v);
        }
        if (c(i)) {
            ar.i().a(map2, this.p, this.o);
        }
        map2.put("sessionDepth", Integer.valueOf(this.u));
        if (map != null) {
            try {
                if (!map.isEmpty()) {
                    map2.putAll(map);
                }
            } catch (Exception e2) {
                o9.d().a(e2);
                IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "LWSProgRvManager: RV sendMediationEvent " + Log.getStackTraceString(e2), 3);
            }
        }
        ar.i().a(new zb(i, new JSONObject(map2)));
    }

    private void a(long j) {
        Map<String, Object> mapA;
        if (this.t.a()) {
            d("all smashes are capped");
            mapA = pk.a(new Object[][]{new Object[]{"errorCode", Integer.valueOf(IronSourceConstants.TROUBLESHOOTING_MEDIATION_TCS_CALCULATED)}, new Object[]{"reason", "all smashes are capped"}});
        } else {
            a(IronSource.AD_UNIT.REWARDED_VIDEO);
            if (this.m) {
                if (!this.g.isEmpty()) {
                    this.i.a(this.g);
                    this.g.clear();
                }
                new Timer().schedule(new b(), j);
                return;
            }
            d("auction fallback flow starting");
            k();
            if (!this.e.c().isEmpty()) {
                b(1000);
                i();
                return;
            } else {
                d("loadSmashes -  waterfall is empty");
                mapA = pk.a(new Object[][]{new Object[]{"errorCode", 80004}, new Object[]{"reason", "waterfall is empty"}});
            }
        }
        a(IronSourceConstants.TROUBLESHOOTING_RV_LOAD_FAILED, mapA);
        h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(NetworkSettings networkSettings, yq yqVar, String str, String str2) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(String.format("Start initializing provider %s on thread %s", networkSettings.getProviderInstanceName(), Thread.currentThread().getName()));
        AbstractAdapter abstractAdapterA = com.json.mediationsdk.c.b().a(networkSettings, networkSettings.getRewardedVideoSettings(), false);
        if (abstractAdapterA != null) {
            r rVar = new r(str, str2, networkSettings, this, yqVar.h(), abstractAdapterA, this.u);
            this.s.put(rVar.c(), rVar);
        }
        ironLog.verbose(String.format("Done initializing provider %s on thread %s", networkSettings.getProviderInstanceName(), Thread.currentThread().getName()));
    }

    private void a(e eVar) {
        d("current state=" + this.z + ", new state=" + eVar);
        this.z = eVar;
    }

    private void a(r rVar, String str) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK, "LWSProgRvManager: " + (rVar.c() + " : " + str), 0);
    }

    private void a(String str) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, str, 3);
    }

    private void a(List<NetworkSettings> list, yq yqVar, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        Iterator<NetworkSettings> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new a(it.next(), yqVar, str, str2));
        }
        IronSourceThreadManager.INSTANCE.executeTasks(yqVar.f(), yqVar.o(), arrayList);
    }

    private void a(List<m5> list, String str, JSONObject jSONObject) {
        this.f.clear();
        this.g.clear();
        CopyOnWriteArrayList<r> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (m5 m5Var : list) {
            sb.append(a(m5Var) + StringUtils.COMMA);
            r rVar = this.s.get(m5Var.c());
            if (rVar != null) {
                AbstractAdapter abstractAdapterA = com.json.mediationsdk.c.b().a(rVar.b.h());
                if (abstractAdapterA != null) {
                    r rVar2 = new r(rVar, this, abstractAdapterA, this.u, str, jSONObject, this.p, this.o);
                    rVar2.a(true);
                    copyOnWriteArrayList.add(rVar2);
                    this.f.put(rVar2.c(), m5Var);
                    this.g.put(m5Var.c(), h.a.ISAuctionPerformanceDidntAttemptToLoad);
                }
            } else {
                d("updateWaterfall() - could not find matching smash for auction response item " + m5Var.c());
            }
        }
        this.e.a(copyOnWriteArrayList, str);
        if (this.e.a()) {
            a(IronSourceConstants.TROUBLESHOOTING_RV_WATERFALL_OVERHEAD, pk.a(new Object[][]{new Object[]{"reason", "waterfalls hold too many with size=" + this.e.e()}}));
        }
        d("updateWaterfall() - next waterfall is " + sb.toString());
        if (sb.length() == 0) {
            d("Updated waterfall is empty");
        }
        a(IronSourceConstants.RV_AUCTION_RESPONSE_WATERFALL, pk.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, sb.toString()}}));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Map<String, Object> map, List<String> list, String str) {
        if (map.keySet().size() == 0 && list.size() == 0) {
            c(1301, pk.a(new Object[][]{new Object[]{"errorCode", 1005}, new Object[]{"duration", 0}}));
            d("makeAuction() failed - No candidates available for auctioning");
            h();
        } else {
            d("makeAuction() - request waterfall is: " + str);
            b(1000);
            b(IronSourceConstants.RV_AUCTION_REQUEST);
            c(IronSourceConstants.RV_AUCTION_REQUEST_WATERFALL, pk.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, str.toString()}}));
            this.j.a(ContextProvider.getInstance().getApplicationContext(), map, list, this.i, this.u, this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Map<String, Object> map, List<String> list, StringBuilder sb, List<w7> list2) {
        if (list2.isEmpty()) {
            a(map, list, sb.toString());
            return;
        }
        z7 z7Var = new z7();
        d dVar = new d(map, sb, list);
        b(IronSourceConstants.RV_COLLECT_TOKENS);
        z7Var.a(list2, dVar, this.E, TimeUnit.MILLISECONDS);
    }

    private void a(boolean z, Map<String, Object> map) {
        synchronized (this.C) {
            Boolean bool = this.B;
            if (bool == null || bool.booleanValue() != z) {
                this.B = Boolean.valueOf(z);
                long time = new Date().getTime() - this.A;
                this.A = new Date().getTime();
                if (map == null) {
                    map = new HashMap<>();
                }
                map.put("duration", Long.valueOf(time));
                a(z ? IronSourceConstants.RV_CALLBACK_AVAILABILITY_TRUE : IronSourceConstants.RV_CALLBACK_AVAILABILITY_FALSE, map);
                dq dqVarA = dq.a();
                al alVar = this.e;
                dqVarA.a(z, alVar.a(alVar.d()));
            }
        }
    }

    private void b(int i) {
        a(i, (Map<String, Object>) null, false, false);
    }

    private void b(int i, Map<String, Object> map) {
        a(i, map, true, true);
    }

    private void b(String str) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, str, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Map<String, Object> map, List<String> list, StringBuilder sb, List<w7> list2) {
        for (r rVar : this.s.values()) {
            if (!this.t.b(rVar) && this.e.b(rVar)) {
                if (rVar.p()) {
                    list2.add(new w7(rVar.g(), rVar.c(), null, rVar, null, null));
                } else {
                    list.add(rVar.c());
                    sb.append(rVar.g() + rVar.c() + StringUtils.COMMA);
                }
            }
        }
    }

    private void b(boolean z) {
        a(z, (Map<String, Object>) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i, Map<String, Object> map) {
        a(i, map, false, false);
    }

    private void c(r rVar, Placement placement) {
        d("showVideo()");
        this.t.a(rVar);
        if (this.t.b(rVar)) {
            rVar.B();
            IronSourceUtils.sendAutomationLog(rVar.c() + " rewarded video is now session capped");
        }
        bg.a aVar = this.F;
        Context applicationContext = ContextProvider.getInstance().getApplicationContext();
        String placementName = placement.getPlacementName();
        IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.REWARDED_VIDEO;
        aVar.a(applicationContext, placementName, ad_unit);
        if (this.G.b(ContextProvider.getInstance().getApplicationContext(), placement, ad_unit)) {
            a(IronSourceConstants.RV_CAP_PLACEMENT);
        }
        this.D.a();
        rVar.a(placement);
    }

    private void c(String str) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "LWSProgRvManager: " + str, 3);
    }

    private boolean c(int i) {
        return i == 1003 || i == 1302 || i == 1301 || i == 1303;
    }

    private boolean c(boolean z) {
        Boolean bool = this.B;
        if (bool == null) {
            return false;
        }
        return (z && !bool.booleanValue() && d()) || (!z && this.B.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "LWSProgRvManager: " + str, 0);
    }

    private List<m5> g() {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (r rVar : this.s.values()) {
            if (!rVar.p() && !this.t.b(rVar) && this.e.b(rVar)) {
                copyOnWriteArrayList.add(new m5(rVar.c()));
            }
        }
        return copyOnWriteArrayList;
    }

    private void g(r rVar) {
        String strK = this.f.get(rVar.c()).k();
        JSONObject jSONObjectA = this.f.get(rVar.c()).a();
        rVar.c(strK);
        rVar.a(strK, jSONObjectA);
    }

    private void h() {
        a(e.RV_STATE_NOT_LOADED);
        if (!this.y) {
            b(false);
        }
        this.l.a();
    }

    private void i() {
        if (this.e.c().isEmpty()) {
            d("loadSmashes -  waterfall is empty");
            a(IronSourceConstants.TROUBLESHOOTING_RV_LOAD_FAILED, pk.a(new Object[][]{new Object[]{"errorCode", 80004}, new Object[]{"reason", "waterfall is empty"}}));
            h();
            return;
        }
        a(e.RV_STATE_LOADING_SMASHES);
        int i = 0;
        for (int i2 = 0; i2 < this.e.c().size() && i < this.w; i2++) {
            r rVar = this.e.c().get(i2);
            if (rVar.h()) {
                if (this.x && rVar.p()) {
                    if (i != 0) {
                        String str = "Advanced Loading: Won't start loading bidder " + rVar.c() + " as a non bidder is being loaded";
                        d(str);
                        IronSourceUtils.sendAutomationLog(str);
                        return;
                    } else {
                        String str2 = "Advanced Loading: Starting to load bidder " + rVar.c() + ". No other instances will be loaded at the same time.";
                        d(str2);
                        IronSourceUtils.sendAutomationLog(str2);
                        g(rVar);
                        return;
                    }
                }
                g(rVar);
                i++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        synchronized (this.C) {
            e eVar = this.z;
            e eVar2 = e.RV_STATE_AUCTION_IN_PROGRESS;
            if (eVar != eVar2) {
                a(eVar2);
                AsyncTask.execute(new c());
            }
        }
    }

    private void k() {
        a(g(), "fallback_" + System.currentTimeMillis(), this.k);
    }

    @Override // com.json.p
    public void a() {
        a(e.RV_STATE_NOT_LOADED);
        a(false, pk.a(new Object[][]{new Object[]{"errorCode", Integer.valueOf(IronSourceError.ERROR_RV_EXPIRED_ADS)}, new Object[]{"reason", "loaded ads are expired"}}));
        a(0L);
    }

    @Override // com.json.s4
    public void a(int i, String str, int i2, String str2, long j) {
        String str3 = "Auction failed | moving to fallback waterfall (error " + i + " - " + str + ")";
        d(str3);
        IronSourceUtils.sendAutomationLog("RV: " + str3);
        this.p = i2;
        this.o = str2;
        this.k = null;
        k();
        a(1301, TextUtils.isEmpty(str) ? pk.a(new Object[][]{new Object[]{"errorCode", Integer.valueOf(i)}, new Object[]{"duration", Long.valueOf(j)}}) : pk.a(new Object[][]{new Object[]{"errorCode", Integer.valueOf(i)}, new Object[]{"reason", str}, new Object[]{"duration", Long.valueOf(j)}}));
        i();
    }

    @Override // com.json.dg
    public void a(Activity activity, Placement placement) {
        synchronized (this.C) {
            try {
                if (placement == null) {
                    a("showRewardedVideo error: empty default placement");
                    IronSourceError ironSourceError = new IronSourceError(1021, "showRewardedVideo error: empty default placement");
                    dq dqVarA = dq.a();
                    al alVar = this.e;
                    dqVarA.a(ironSourceError, alVar.a(alVar.d()));
                    a(IronSourceConstants.RV_CALLBACK_SHOW_FAILED, pk.a(new Object[][]{new Object[]{"errorCode", 1021}, new Object[]{"reason", "showRewardedVideo error: empty default placement"}}), false, true);
                    return;
                }
                this.v = placement.getPlacementName();
                b("showRewardedVideo(" + placement + ")");
                r rVar = null;
                b(1100, activity != null ? pk.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, IronSourceConstants.EVENTS_INIT_CONTEXT_FLOW}}) : null);
                if (this.y) {
                    a("showRewardedVideo error: can't show ad while an ad is already showing");
                    IronSourceError ironSourceError2 = new IronSourceError(1022, "showRewardedVideo error: can't show ad while an ad is already showing");
                    dq dqVarA2 = dq.a();
                    al alVar2 = this.e;
                    dqVarA2.a(ironSourceError2, alVar2.a(alVar2.d()));
                    b(IronSourceConstants.RV_CALLBACK_SHOW_FAILED, pk.a(new Object[][]{new Object[]{"errorCode", 1022}, new Object[]{"reason", "showRewardedVideo error: can't show ad while an ad is already showing"}}));
                    return;
                }
                if (this.z != e.RV_STATE_READY_TO_SHOW) {
                    a("showRewardedVideo error: show called while no ads are available");
                    IronSourceError ironSourceError3 = new IronSourceError(1023, "showRewardedVideo error: show called while no ads are available");
                    dq dqVarA3 = dq.a();
                    al alVar3 = this.e;
                    dqVarA3.a(ironSourceError3, alVar3.a(alVar3.d()));
                    b(IronSourceConstants.RV_CALLBACK_SHOW_FAILED, pk.a(new Object[][]{new Object[]{"errorCode", 1023}, new Object[]{"reason", "showRewardedVideo error: show called while no ads are available"}}));
                    return;
                }
                if (this.G.b(ContextProvider.getInstance().getApplicationContext(), placement, IronSource.AD_UNIT.REWARDED_VIDEO)) {
                    String str = "showRewardedVideo error: placement " + this.v + " is capped";
                    a(str);
                    IronSourceError ironSourceError4 = new IronSourceError(IronSourceError.ERROR_PLACEMENT_CAPPED, str);
                    dq dqVarA4 = dq.a();
                    al alVar4 = this.e;
                    dqVarA4.a(ironSourceError4, alVar4.a(alVar4.d()));
                    b(IronSourceConstants.RV_CALLBACK_SHOW_FAILED, pk.a(new Object[][]{new Object[]{"errorCode", Integer.valueOf(IronSourceError.ERROR_PLACEMENT_CAPPED)}, new Object[]{"reason", str}}));
                    return;
                }
                StringBuffer stringBuffer = new StringBuffer();
                for (r rVar2 : this.e.c()) {
                    if (rVar2.A()) {
                        this.y = true;
                        rVar2.b(true);
                        a(e.RV_STATE_NOT_LOADED);
                        rVar = rVar2;
                        break;
                    }
                    if (rVar2.e() != null) {
                        stringBuffer.append(rVar2.c() + ":" + rVar2.e() + StringUtils.COMMA);
                    }
                    rVar2.b(false);
                }
                if (rVar != null) {
                    c(rVar, placement);
                    return;
                }
                d("showRewardedVideo(): No ads to show");
                dq dqVarA5 = dq.a();
                IronSourceError ironSourceErrorBuildNoAdsToShowError = ErrorBuilder.buildNoAdsToShowError(IronSourceConstants.REWARDED_VIDEO_AD_UNIT);
                al alVar5 = this.e;
                dqVarA5.a(ironSourceErrorBuildNoAdsToShowError, alVar5.a(alVar5.d()));
                HashMap map = new HashMap();
                map.put("errorCode", 509);
                map.put("reason", "showRewardedVideo(): No ads to show");
                if (stringBuffer.length() != 0) {
                    map.put(IronSourceConstants.EVENTS_EXT1, stringBuffer.toString());
                }
                b(IronSourceConstants.RV_CALLBACK_SHOW_FAILED, map);
                this.l.b();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.json.dg
    public void a(Context context, boolean z) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "LWSProgRvManager Should Track Network State: " + z, 0);
        try {
            this.r = z;
            if (z) {
                if (this.q == null) {
                    this.q = new NetworkStateReceiver(context, this);
                }
                context.getApplicationContext().registerReceiver(this.q, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            } else if (this.q != null) {
                context.getApplicationContext().unregisterReceiver(this.q);
            }
        } catch (Exception e2) {
            o9.d().a(e2);
            IronLog.INTERNAL.error("Got an error from receiver with message: " + e2.getMessage());
        }
    }

    @Override // com.json.zk
    public void a(IronSourceError ironSourceError, r rVar) {
        m5 m5Var;
        if (this.m && (m5Var = this.f.get(rVar.c())) != null) {
            al alVar = this.e;
            alVar.a(alVar.d(), m5Var.a(this.v), m5Var.d());
        }
        a(rVar, "onRewardedVideoAdShowFailed error=" + ironSourceError.getErrorMessage());
        this.y = false;
        b(IronSourceConstants.RV_CALLBACK_SHOW_FAILED, pk.a(new Object[][]{new Object[]{"errorCode", Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{"reason", ironSourceError.getErrorMessage()}}));
        dq.a().a(ironSourceError, this.e.a(rVar.u()));
        this.g.put(rVar.c(), h.a.ISAuctionPerformanceFailedToShow);
        if (this.z != e.RV_STATE_READY_TO_SHOW) {
            b(false);
        }
        this.l.b();
    }

    @Override // com.json.zk
    public void a(r rVar) {
        a(rVar, "onRewardedVideoAdStarted");
        dq.a().c();
    }

    @Override // com.json.zk
    public void a(r rVar, Placement placement) {
        a(rVar, "onRewardedVideoAdRewarded");
        dq.a().b(placement, this.e.a(rVar.u()));
    }

    @Override // com.json.s4
    public void a(List<m5> list, String str, m5 m5Var, JSONObject jSONObject, JSONObject jSONObject2, int i, long j, int i2, String str2) {
        d("makeAuction(): success");
        this.h = m5Var;
        this.p = i;
        this.k = jSONObject;
        this.o = "";
        if (!TextUtils.isEmpty(str2)) {
            a(88002, pk.a(new Object[][]{new Object[]{"errorCode", Integer.valueOf(i2)}, new Object[]{"reason", str2}}));
        }
        IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.REWARDED_VIDEO;
        a(jSONObject2, ad_unit);
        if (this.b.a(ad_unit)) {
            a(IronSourceConstants.RV_AD_UNIT_CAPPED, pk.a(new Object[][]{new Object[]{"auctionId", str}}));
            h();
        } else {
            a(list, str, this.k);
            a(IronSourceConstants.RV_AUCTION_SUCCESS, pk.a(new Object[][]{new Object[]{"duration", Long.valueOf(j)}}));
            i();
        }
    }

    @Override // com.json.Cdo
    public void a(boolean z) {
        if (this.r) {
            IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "Network Availability Changed To: " + z, 0);
            if (c(z)) {
                b(z);
            }
        }
    }

    @Override // com.json.dr
    public void b() {
        d("onLoadTriggered: RV load was triggered in " + this.z + " state");
        a(0L);
    }

    @Override // com.json.zk
    public void b(r rVar) {
        a(rVar, "onRewardedVideoAdClosed, mediation state: " + this.z.name());
        dq.a().b(this.e.a(rVar.u()));
        this.y = false;
        boolean z = this.z == e.RV_STATE_READY_TO_SHOW;
        StringBuilder sb = new StringBuilder();
        if (z) {
            for (r rVar2 : this.e.c()) {
                if (rVar2.y()) {
                    sb.append(rVar2.c() + ";");
                }
            }
        }
        Object[][] objArr = new Object[1][];
        objArr[0] = new Object[]{IronSourceConstants.EVENTS_EXT1, "otherRVAvailable = " + (sb.length() > 0 ? "true|" + ((Object) sb) : "false")};
        rVar.b(1203, objArr);
        if (rVar.equals(this.e.f())) {
            this.e.a((r) null);
            if (this.z != e.RV_STATE_READY_TO_SHOW) {
                b(false);
            }
        }
    }

    @Override // com.json.zk
    public void b(r rVar, Placement placement) {
        a(rVar, "onRewardedVideoAdClicked");
        dq.a().a(placement, this.e.a(rVar.u()));
    }

    /* JADX WARN: Code duplicated, block: B:70:0x00da A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:87:0x005a A[SYNTHETIC] */
    @Override // com.json.zk
    public void c(r rVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        synchronized (this.C) {
            a(rVar, "onLoadError mState=" + this.z);
            if (rVar.u() == this.e.d() && this.z != e.RV_STATE_AUCTION_IN_PROGRESS) {
                this.g.put(rVar.c(), h.a.ISAuctionPerformanceFailedToLoad);
                e eVar = this.z;
                if (eVar == e.RV_STATE_LOADING_SMASHES || eVar == e.RV_STATE_READY_TO_SHOW) {
                    boolean z = false;
                    boolean z2 = false;
                    for (r rVar2 : this.e.c()) {
                        if (rVar2.h()) {
                            if (this.x && rVar2.p()) {
                                if (z || z2) {
                                    String str = "Advanced Loading: Won't start loading bidder " + rVar2.c() + " as " + (z ? "a non bidder is being loaded" : "a non bidder was already loaded successfully");
                                    d(str);
                                    IronSourceUtils.sendAutomationLog(str);
                                    break;
                                }
                                String str2 = "Advanced Loading: Starting to load bidder " + rVar2.c() + ". No other instances will be loaded at the same time.";
                                d(str2);
                                IronSourceUtils.sendAutomationLog(str2);
                                if (this.f.get(rVar2.c()) != null) {
                                    copyOnWriteArrayList.add(rVar2);
                                    if (this.x) {
                                        break;
                                    } else {
                                        break;
                                    }
                                }
                                continue;
                            } else if (this.f.get(rVar2.c()) != null) {
                                copyOnWriteArrayList.add(rVar2);
                                if (this.x || !rVar.p() || rVar2.p() || copyOnWriteArrayList.size() >= this.w) {
                                    break;
                                } else {
                                    z = true;
                                }
                            } else {
                                continue;
                            }
                        } else if (rVar2.z()) {
                            z = true;
                        } else if (rVar2.A()) {
                            z2 = true;
                        }
                    }
                    if (copyOnWriteArrayList.size() == 0 && !z2 && !z) {
                        d("onLoadError(): No other available smashes");
                        if (!this.y) {
                            b(false);
                        }
                        a(IronSourceConstants.TROUBLESHOOTING_RV_LOAD_FAILED, pk.a(new Object[][]{new Object[]{"errorCode", 509}, new Object[]{"reason", "Mediation No fill"}}));
                        a(e.RV_STATE_NOT_LOADED);
                        this.l.a();
                    }
                    Iterator it = copyOnWriteArrayList.iterator();
                    while (it.hasNext()) {
                        g((r) it.next());
                    }
                    return;
                }
                return;
            }
            d("onLoadError was invoked with auctionId:" + rVar.u() + " and the current id is " + this.e.d());
            rVar.a(IronSourceConstants.RV_MANAGER_UNEXPECTED_STATE, new Object[][]{new Object[]{"errorCode", 4}, new Object[]{"reason", "loadError wrong auction ID " + this.z}});
        }
    }

    @Override // com.json.zk
    public void d(r rVar) {
        this.e.a(rVar);
        this.u++;
        a(rVar, "onRewardedVideoAdOpened");
        if (this.m) {
            m5 m5Var = this.f.get(rVar.c());
            if (m5Var != null) {
                al alVar = this.e;
                alVar.a(alVar.d(), m5Var.a(this.v), m5Var.d());
                this.j.a(m5Var, rVar.g(), this.h, this.v);
                this.g.put(rVar.c(), h.a.ISAuctionPerformanceShowedSuccessfully);
                a(m5Var, this.v);
            } else {
                String strC = rVar.c();
                c("onRewardedVideoAdOpened showing instance " + strC + " missing from waterfall");
                a(IronSourceConstants.TROUBLESHOOTING_RV_NOTIFICATIONS_ERROR, pk.a(new Object[][]{new Object[]{"errorCode", 1011}, new Object[]{"reason", "Showing missing " + this.z}, new Object[]{IronSourceConstants.EVENTS_EXT1, strC}}));
            }
        }
        dq.a().c(this.e.a(rVar.u()));
        b(false);
        this.l.c();
    }

    @Override // com.json.dg
    public boolean d() {
        if ((!this.r || IronSourceUtils.isNetworkConnected(ContextProvider.getInstance().getApplicationContext())) && this.z == e.RV_STATE_READY_TO_SHOW && !this.y) {
            Iterator<r> it = this.e.c().iterator();
            while (it.hasNext()) {
                if (it.next().A()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.json.zk
    public void e(r rVar) {
        synchronized (this.C) {
            a(rVar, "onLoadSuccess mState=" + this.z);
            if (rVar.u() == this.e.d() && this.z != e.RV_STATE_AUCTION_IN_PROGRESS) {
                this.g.put(rVar.c(), h.a.ISAuctionPerformanceLoadedSuccessfully);
                e eVar = this.z;
                e eVar2 = e.RV_STATE_LOADING_SMASHES;
                if (eVar == eVar2) {
                    a(e.RV_STATE_READY_TO_SHOW);
                    a(1003, pk.a(new Object[][]{new Object[]{"duration", Long.valueOf(new Date().getTime() - this.n)}}));
                    this.D.a(0L);
                    if (this.m) {
                        m5 m5Var = this.f.get(rVar.c());
                        if (m5Var != null) {
                            al alVar = this.e;
                            alVar.a(alVar.d(), m5Var.a(""), m5Var.d());
                            this.j.a(m5Var, rVar.g(), this.h);
                            this.j.a(this.e.c(), this.f, rVar.g(), this.h, m5Var);
                        } else {
                            String strC = rVar.c();
                            c("onLoadSuccess winner instance " + strC + " missing from waterfall. auctionId: " + rVar.u() + " and the current id is " + this.e.d());
                            a(IronSourceConstants.TROUBLESHOOTING_RV_NOTIFICATIONS_ERROR, pk.a(new Object[][]{new Object[]{"errorCode", 1010}, new Object[]{"reason", "Loaded missing " + eVar2}, new Object[]{IronSourceConstants.EVENTS_EXT1, strC}}));
                        }
                    }
                    b(true);
                }
                return;
            }
            d("onLoadSuccess was invoked with auctionId: " + rVar.u() + " and the current id is " + this.e.d());
            rVar.a(IronSourceConstants.RV_MANAGER_UNEXPECTED_STATE, new Object[][]{new Object[]{"errorCode", 2}, new Object[]{"reason", "onLoadSuccess wrong auction ID " + this.z}});
        }
    }

    @Override // com.json.zk
    public void f(r rVar) {
        a(rVar, "onRewardedVideoAdEnded");
        dq.a().b();
    }
}
