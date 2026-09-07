package com.json.mediationsdk;

import android.content.Context;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.json.a8;
import com.json.ai;
import com.json.b8;
import com.json.bg;
import com.json.environment.ContextProvider;
import com.json.environment.thread.IronSourceThreadManager;
import com.json.h7;
import com.json.ib;
import com.json.m5;
import com.json.mediationsdk.adunit.adapter.utility.AdData;
import com.json.mediationsdk.impressionData.ImpressionDataListener;
import com.json.mediationsdk.logger.IronLog;
import com.json.mediationsdk.logger.IronSourceError;
import com.json.mediationsdk.model.NetworkSettings;
import com.json.mediationsdk.utils.IronSourceConstants;
import com.json.mediationsdk.utils.IronSourceUtils;
import com.json.mm;
import com.json.o9;
import com.json.oj;
import com.json.s4;
import com.json.t5;
import com.json.vp;
import com.json.w7;
import com.json.wf;
import com.json.wl;
import com.json.xf;
import com.json.yu;
import com.json.z7;
import com.json.zb;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.bidmachine.iab.vast.tags.VastAttributes;
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

/* JADX INFO: loaded from: classes3.dex */
public class w extends m implements vp, s4 {
    private ConcurrentHashMap<String, com.ironsource.mediationsdk.h.a> A;
    private long B;
    private final Object C;
    private ib D;
    private boolean E;
    private final long F;
    private final Runnable G;
    private final ai e;
    private final ai.a f;
    private final bg g;
    private final bg.a h;
    private k i;
    private i j;
    private wl k;
    private IronSourceBannerLayout l;
    private h7 m;
    private int n;
    private x o;
    private int p;
    private final ConcurrentHashMap<String, x> q;
    private CopyOnWriteArrayList<x> r;
    private String s;
    private JSONObject t;
    private String u;
    private int v;
    private com.json.mediationsdk.e w;
    private m5 x;
    private com.json.mediationsdk.h y;
    private ConcurrentHashMap<String, m5> z;

    class a implements l.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ h7 f4023a;
        final /* synthetic */ IronSourceBannerLayout b;

        a(h7 h7Var, IronSourceBannerLayout ironSourceBannerLayout) {
            this.f4023a = h7Var;
            this.b = ironSourceBannerLayout;
        }

        @Override // com.ironsource.mediationsdk.l.b
        public void a() {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.verbose("placement = " + this.f4023a.getPlacementName());
            l.b(this.b);
            w.this.l = this.b;
            w.this.m = this.f4023a;
            bg bgVar = w.this.g;
            Context applicationContext = ContextProvider.getInstance().getApplicationContext();
            h7 h7Var = this.f4023a;
            IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.BANNER;
            if (!bgVar.b(applicationContext, h7Var, ad_unit)) {
                w.this.b(false);
                return;
            }
            ironLog.verbose("placement is capped");
            n.a().b(ad_unit, new IronSourceError(604, "placement " + this.f4023a.getPlacementName() + " is capped"));
            w.this.a(IronSourceConstants.BN_CALLBACK_LOAD_ERROR, new Object[][]{new Object[]{"errorCode", 604}});
            w.this.a(i.READY_TO_LOAD);
        }

        @Override // com.ironsource.mediationsdk.l.b
        public void a(String str) {
            IronLog.API.error("can't load banner - errorMessage = " + str);
        }
    }

    class b implements l.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ IronSourceBannerLayout f4024a;

        b(IronSourceBannerLayout ironSourceBannerLayout) {
            this.f4024a = ironSourceBannerLayout;
        }

        @Override // com.ironsource.mediationsdk.l.b
        public void a() {
            IronLog.INTERNAL.verbose("destroying banner");
            w.this.k.b();
            w.this.a(3100, (Object[][]) null, w.this.o != null ? w.this.o.n() : w.this.p);
            w.this.h();
            this.f4024a.a();
            w.this.l = null;
            w.this.m = null;
            w.this.a(i.READY_TO_LOAD);
        }

        @Override // com.ironsource.mediationsdk.l.b
        public void a(String str) {
            IronLog.API.error("destroy banner failed - errorMessage = " + str);
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (w.this.l == null) {
                    IronLog.INTERNAL.verbose("mIronSourceBanner is null");
                    w.this.a(3200, new Object[][]{new Object[]{"errorCode", Integer.valueOf(IronSourceError.ERROR_BN_RELOAD_SKIP_BANNER_LAYOUT_IS_NULL)}});
                } else {
                    if (w.this.o()) {
                        w.this.v();
                        return;
                    }
                    IronLog.INTERNAL.verbose("banner is not visible, reload skipped");
                    w.this.a(3200, new Object[][]{new Object[]{"errorCode", 613}});
                    w.this.k.a(TimeUnit.SECONDS.toMillis(w.this.i.f()));
                }
            } catch (Throwable th) {
                o9.d().a(th);
                w.this.a(IronSourceConstants.TROUBLESHOOTING_BN_RELOAD_EXCEPTION, new Object[][]{new Object[]{"reason", th.getMessage()}});
            }
        }
    }

    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            w.this.w();
            if (w.this.y()) {
                return;
            }
            w.this.a(IronSourceConstants.BN_AUCTION_REQUEST);
            HashMap map = new HashMap();
            ArrayList arrayList = new ArrayList();
            StringBuilder sb = new StringBuilder();
            ArrayList arrayList2 = new ArrayList();
            w.this.b(map, arrayList, sb, arrayList2);
            w.this.a(map, arrayList, sb, arrayList2);
        }
    }

    class e implements z7.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Map f4027a;
        final /* synthetic */ StringBuilder b;
        final /* synthetic */ List c;

        e(Map map, StringBuilder sb, List list) {
            this.f4027a = map;
            this.b = sb;
            this.c = list;
        }

        @Override // com.ironsource.z7.b
        public void a(List<a8> list, long j, List<String> list2) {
            w.this.a(IronSourceConstants.BN_COLLECT_TOKENS_COMPLETED, new Object[][]{new Object[]{"duration", Long.valueOf(j)}});
            for (a8 a8Var : list) {
                if (a8Var.a() != null) {
                    this.f4027a.put(a8Var.c(), a8Var.a());
                    this.b.append(a8Var.d()).append(a8Var.c()).append(StringUtils.COMMA);
                    ((x) w.this.q.get(a8Var.c())).a(IronSourceConstants.BN_INSTANCE_COLLECT_TOKEN_SUCCESS, new Object[][]{new Object[]{"duration", Long.valueOf(a8Var.e())}});
                } else {
                    ((x) w.this.q.get(a8Var.c())).a(IronSourceConstants.BN_INSTANCE_COLLECT_TOKEN_FAILED, new Object[][]{new Object[]{"duration", Long.valueOf(a8Var.e())}, new Object[]{"reason", a8Var.b()}});
                }
            }
            Iterator<String> it = list2.iterator();
            while (it.hasNext()) {
                ((x) w.this.q.get(it.next())).a(IronSourceConstants.BN_INSTANCE_COLLECT_TOKEN_TIMED_OUT, new Object[][]{new Object[]{"duration", Long.valueOf(j)}});
            }
            w.this.a((Map<String, Object>) this.f4027a, (List<String>) this.c, this.b);
        }

        @Override // com.ironsource.z7.b
        public void onFailure(String str) {
            w.this.a(IronSourceConstants.BN_COLLECT_TOKENS_FAILED, new Object[][]{new Object[]{"duration", str}});
            w.this.a((Map<String, Object>) this.f4027a, (List<String>) this.c, this.b);
        }
    }

    class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ NetworkSettings f4028a;

        f(NetworkSettings networkSettings) {
            this.f4028a = networkSettings;
        }

        @Override // java.lang.Runnable
        public void run() {
            w.this.a(this.f4028a);
        }
    }

    class g implements b8 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ x f4029a;

        g(x xVar) {
            this.f4029a = xVar;
        }

        @Override // com.json.b8
        public void a() {
            this.f4029a.D();
        }
    }

    class h extends TimerTask {
        h() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            w.this.u();
        }
    }

    enum i {
        NONE,
        READY_TO_LOAD,
        STARTED_LOADING,
        FIRST_AUCTION,
        AUCTION,
        LOADING,
        RELOADING,
        LOADED
    }

    w(xf xfVar, wf wfVar, List<NetworkSettings> list, k kVar, HashSet<ImpressionDataListener> hashSet, IronSourceSegment ironSourceSegment) {
        super(hashSet, ironSourceSegment);
        this.j = i.NONE;
        this.u = "";
        this.C = new Object();
        this.E = false;
        c cVar = new c();
        this.G = cVar;
        ai aiVarK = xfVar.k();
        this.e = aiVarK;
        this.f = wfVar.e();
        this.g = xfVar.B();
        this.h = wfVar.m();
        long time = new Date().getTime();
        a(IronSourceConstants.BN_MANAGER_INIT_STARTED, new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, IronSourceConstants.PROG_BN_MANAGER_NAME}});
        IronLog.INTERNAL.verbose("isAuctionEnabled = " + kVar.j());
        this.i = kVar;
        this.q = new ConcurrentHashMap<>();
        this.r = new CopyOnWriteArrayList<>();
        this.z = new ConcurrentHashMap<>();
        this.A = new ConcurrentHashMap<>();
        IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.BANNER;
        this.p = aiVarK.a(ad_unit);
        n.a().a(ad_unit, this.i.d());
        if (this.i.j()) {
            this.w = new com.json.mediationsdk.e(ad_unit, this.i.b(), this);
        }
        this.y = new com.json.mediationsdk.h(list, this.i.b().c());
        a(list, kVar);
        this.B = new Date().getTime();
        a(i.READY_TO_LOAD);
        this.F = kVar.g();
        this.k = new wl(cVar, com.json.lifecycle.b.d(), new yu());
        a(IronSourceConstants.BN_MANAGER_INIT_ENDED, new Object[][]{new Object[]{"duration", Long.valueOf(new Date().getTime() - time)}});
    }

    public w(List<NetworkSettings> list, k kVar, HashSet<ImpressionDataListener> hashSet, IronSourceSegment ironSourceSegment) {
        this(mm.S(), mm.M(), list, kVar, hashSet, ironSourceSegment);
    }

    private String a(List<m5> list) {
        IronLog.INTERNAL.verbose("waterfall.size() = " + list.size());
        this.r.clear();
        this.z.clear();
        this.A.clear();
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < list.size(); i2++) {
            m5 m5Var = list.get(i2);
            a(m5Var);
            sb.append(b(m5Var));
            if (i2 != list.size() - 1) {
                sb.append(StringUtils.COMMA);
            }
        }
        IronLog.INTERNAL.verbose("updateWaterfall() - next waterfall is " + sb.toString());
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        a(i2, (Object[][]) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, Object[][] objArr) {
        a(i2, objArr, this.p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, Object[][] objArr, int i3) {
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false, true, 1);
        try {
            ISBannerSize iSBannerSizeK = k();
            if (iSBannerSizeK != null) {
                a(mediationAdditionalData, iSBannerSizeK);
            }
            if (this.m != null) {
                mediationAdditionalData.put("placement", l());
            }
            mediationAdditionalData.put("sessionDepth", i3);
            if (!TextUtils.isEmpty(this.s)) {
                mediationAdditionalData.put("auctionId", this.s);
            }
            JSONObject jSONObject = this.t;
            if (jSONObject != null && jSONObject.length() > 0) {
                mediationAdditionalData.put("genericParams", this.t);
            }
            if (b(i2)) {
                mediationAdditionalData.put(IronSourceConstants.AUCTION_TRIALS, this.v);
                if (!TextUtils.isEmpty(this.u)) {
                    mediationAdditionalData.put(IronSourceConstants.AUCTION_FALLBACK, this.u);
                }
            }
            if (objArr != null) {
                for (Object[] objArr2 : objArr) {
                    mediationAdditionalData.put(objArr2[0].toString(), objArr2[1]);
                }
            }
        } catch (Exception e2) {
            o9.d().a(e2);
            IronLog.INTERNAL.error(Log.getStackTraceString(e2));
        }
        oj.i().a(new zb(i2, mediationAdditionalData));
    }

    private void a(m5 m5Var) {
        x xVar = this.q.get(m5Var.c());
        if (xVar == null) {
            IronLog.INTERNAL.error("could not find matching smash for auction response item - item = " + m5Var.c());
            return;
        }
        AbstractAdapter abstractAdapterA = com.json.mediationsdk.c.b().a(xVar.b.h());
        if (abstractAdapterA != null) {
            x xVar2 = new x(this.i, this, xVar.b.h(), abstractAdapterA, this.p, this.s, this.t, this.v, this.u, p());
            xVar2.a(true);
            this.r.add(xVar2);
            this.z.put(xVar2.c(), m5Var);
            this.A.put(m5Var.c(), com.ironsource.mediationsdk.h.a.ISAuctionPerformanceDidntAttemptToLoad);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(NetworkSettings networkSettings) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(String.format("Start initializing provider %s on thread %s", networkSettings.getProviderInstanceName(), Thread.currentThread().getName()));
        AbstractAdapter abstractAdapterA = com.json.mediationsdk.c.b().a(networkSettings, networkSettings.getBannerSettings(), false);
        if (abstractAdapterA != null) {
            x xVar = new x(this.i, this, networkSettings, abstractAdapterA, this.p, p());
            this.q.put(xVar.c(), xVar);
        } else {
            ironLog.verbose(networkSettings.getProviderInstanceName() + " can't load adapter");
        }
        ironLog.verbose(String.format("Done initializing provider %s on thread %s", networkSettings.getProviderInstanceName(), Thread.currentThread().getName()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(i iVar) {
        IronLog.INTERNAL.verbose("from '" + this.j + "' to '" + iVar + "'");
        synchronized (this.C) {
            this.j = iVar;
        }
    }

    private void a(x xVar, m5 m5Var) {
        this.w.a(m5Var, xVar.g(), this.x, l());
        a(this.z.get(xVar.c()), l());
    }

    private void a(List<NetworkSettings> list, k kVar) {
        ArrayList arrayList = new ArrayList();
        Iterator<NetworkSettings> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new f(it.next()));
        }
        IronSourceThreadManager.INSTANCE.executeTasks(kVar.c().l(), kVar.c().n(), arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Map<String, Object> map, List<String> list, StringBuilder sb) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("auction waterfallString = " + ((Object) sb));
        if (map.size() != 0 || list.size() != 0) {
            a(IronSourceConstants.BN_AUCTION_REQUEST_WATERFALL, new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, sb.toString()}});
            com.json.mediationsdk.e eVar = this.w;
            if (eVar != null) {
                eVar.a(ContextProvider.getInstance().getApplicationContext(), map, list, this.y, this.p, this.c, j());
                return;
            } else {
                ironLog.error("mAuctionHandler is null");
                return;
            }
        }
        a(IronSourceConstants.BN_AUCTION_FAILED, new Object[][]{new Object[]{"errorCode", 1005}, new Object[]{"duration", 0}});
        if (a(i.AUCTION, i.LOADED)) {
            this.k.a(TimeUnit.SECONDS.toMillis(this.i.f()));
            return;
        }
        n.a().b(IronSource.AD_UNIT.BANNER, new IronSourceError(1005, "No candidates available for auctioning"));
        a(IronSourceConstants.BN_CALLBACK_LOAD_ERROR, new Object[][]{new Object[]{"errorCode", 1005}});
        a(i.READY_TO_LOAD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Map<String, Object> map, List<String> list, StringBuilder sb, List<w7> list2) {
        if (list2.isEmpty()) {
            a(map, list, sb);
            return;
        }
        z7 z7Var = new z7();
        e eVar = new e(map, sb, list);
        a(IronSourceConstants.BN_COLLECT_TOKENS);
        z7Var.a(list2, eVar, this.F, TimeUnit.MILLISECONDS);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0046  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static void a(JSONObject jSONObject, ISBannerSize iSBannerSize) {
        byte b2;
        try {
            String description = iSBannerSize.getDescription();
            switch (description.hashCode()) {
                case -387072689:
                    if (!description.equals(l.c)) {
                        b2 = -1;
                    } else {
                        b2 = 2;
                    }
                    break;
                case 72205083:
                    if (!description.equals(l.b)) {
                        b2 = -1;
                    } else {
                        b2 = 1;
                    }
                    break;
                case 79011241:
                    if (!description.equals(l.e)) {
                        b2 = -1;
                    } else {
                        b2 = 3;
                    }
                    break;
                case 1951953708:
                    if (!description.equals("BANNER")) {
                        b2 = -1;
                    } else {
                        b2 = 0;
                    }
                    break;
                case 1999208305:
                    if (!description.equals("CUSTOM")) {
                        b2 = -1;
                    } else {
                        b2 = 4;
                    }
                    break;
                default:
                    b2 = -1;
                    break;
            }
            if (b2 == 0) {
                jSONObject.put(l.h, 1);
            } else if (b2 == 1) {
                jSONObject.put(l.h, 2);
            } else if (b2 == 2) {
                jSONObject.put(l.h, 3);
            } else if (b2 == 3) {
                jSONObject.put(l.h, 5);
            } else if (b2 == 4) {
                jSONObject.put(l.h, 6);
                jSONObject.put("custom_banner_size", iSBannerSize.getWidth() + VastAttributes.HORIZONTAL_POSITION + iSBannerSize.getHeight());
            }
            if (iSBannerSize.isAdaptive()) {
                String str = l.q;
                if (jSONObject.has(IronSourceConstants.EVENTS_EXT1)) {
                    str = jSONObject.optString(IronSourceConstants.EVENTS_EXT1) + " , Adaptive=true";
                }
                jSONObject.put(IronSourceConstants.EVENTS_EXT1, str);
            }
        } catch (Exception e2) {
            o9.d().a(e2);
            IronLog.INTERNAL.error(Log.getStackTraceString(e2));
        }
    }

    private boolean a(i iVar, i iVar2) {
        boolean z;
        synchronized (this.C) {
            if (this.j == iVar) {
                IronLog.INTERNAL.verbose("set state from '" + this.j + "' to '" + iVar2 + "'");
                this.j = iVar2;
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    private String b(m5 m5Var) {
        x xVar = this.q.get(m5Var.c());
        return ((xVar == null ? !TextUtils.isEmpty(m5Var.k()) : xVar.p()) ? "2" : "1") + m5Var.c();
    }

    private void b(x xVar, View view, FrameLayout.LayoutParams layoutParams) {
        if (this.l != null) {
            xVar.E();
            l.a(this.l, view, layoutParams, new g(xVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Map<String, Object> map, List<String> list, StringBuilder sb, List<w7> list2) {
        if (this.g.b(ContextProvider.getInstance().getApplicationContext(), this.m, IronSource.AD_UNIT.BANNER)) {
            return;
        }
        for (x xVar : this.q.values()) {
            AdData adDataCreateAdDataForNetworkAdapter = AdData.createAdDataForNetworkAdapter(xVar.d, IronSource.AD_UNIT.BANNER, null, this.l);
            if (xVar.p()) {
                list2.add(new w7(xVar.g(), xVar.c(), adDataCreateAdDataForNetworkAdapter, xVar, null, null));
            } else if (!xVar.p()) {
                list.add(xVar.c());
                sb.append(xVar.g() + xVar.c() + StringUtils.COMMA);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        i iVar;
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("current state = " + this.j);
        if (this.i.j()) {
            iVar = z ? i.AUCTION : i.FIRST_AUCTION;
        } else {
            iVar = z ? i.RELOADING : i.LOADING;
        }
        if (!a(i.STARTED_LOADING, iVar)) {
            ironLog.error("wrong state - " + this.j);
            return;
        }
        this.D = new ib();
        this.s = "";
        this.t = null;
        this.n = 0;
        this.p = this.e.a(IronSource.AD_UNIT.BANNER);
        a(z ? IronSourceConstants.BN_RELOAD : 3001);
        if (this.i.j()) {
            u();
        } else {
            x();
            t();
        }
    }

    private boolean b(int i2) {
        return i2 == 3201 || i2 == 3110 || i2 == 3111 || i2 == 3116 || i2 == 3119 || i2 == 3112 || i2 == 3115 || i2 == 3501 || i2 == 3502 || i2 == 3506;
    }

    private void f(x xVar) {
        String strK;
        IronSourceBannerLayout ironSourceBannerLayout = this.l;
        if (ironSourceBannerLayout == null || ironSourceBannerLayout.isDestroyed()) {
            return;
        }
        IronSourceBannerLayout ironSourceBannerLayoutB = null;
        if (xVar.p()) {
            strK = this.z.get(xVar.c()).k();
            xVar.c(strK);
        } else {
            strK = null;
        }
        JSONObject jSONObjectA = this.z.get(xVar.c()).a();
        try {
            ironSourceBannerLayoutB = this.l.b();
        } catch (Exception e2) {
            o9.d().a(e2);
            IronLog.INTERNAL.verbose("Failed to make copy of banner layout: " + e2.getMessage());
        }
        xVar.a(ironSourceBannerLayoutB, this.m, strK, jSONObjectA);
    }

    private boolean g() {
        IronSourceBannerLayout ironSourceBannerLayout = this.l;
        return (ironSourceBannerLayout == null || ironSourceBannerLayout.isDestroyed()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.o != null) {
            IronLog.INTERNAL.verbose("mActiveSmash = " + this.o.f());
            this.o.t();
            this.o = null;
        }
    }

    private List<m5> i() {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (x xVar : this.q.values()) {
            if (!xVar.p() && !this.g.b(ContextProvider.getInstance().getApplicationContext(), this.m, IronSource.AD_UNIT.BANNER)) {
                copyOnWriteArrayList.add(new m5(xVar.c()));
            }
        }
        return copyOnWriteArrayList;
    }

    private ISBannerSize j() {
        IronSourceBannerLayout ironSourceBannerLayout = this.l;
        if (ironSourceBannerLayout == null || ironSourceBannerLayout.getSize() == null) {
            return null;
        }
        if (this.l.getSize().isSmart()) {
            return AdapterUtils.isLargeScreen(ContextProvider.getInstance().getApplicationContext()) ? ISBannerSize.e : ISBannerSize.BANNER;
        }
        return this.l.getSize();
    }

    private ISBannerSize k() {
        IronSourceBannerLayout ironSourceBannerLayout = this.l;
        if (ironSourceBannerLayout != null) {
            return ironSourceBannerLayout.getSize();
        }
        return null;
    }

    private String l() {
        h7 h7Var = this.m;
        return h7Var != null ? h7Var.getPlacementName() : "";
    }

    private void m() {
        String str = this.r.isEmpty() ? "Empty waterfall" : "Mediation No fill";
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("errorReason = ".concat(str));
        g((x) null);
        i iVar = i.LOADING;
        i iVar2 = i.READY_TO_LOAD;
        if (a(iVar, iVar2)) {
            a(IronSourceConstants.BN_CALLBACK_LOAD_ERROR, new Object[][]{new Object[]{"errorCode", 606}, new Object[]{"reason", str}, new Object[]{"duration", Long.valueOf(ib.a(this.D))}});
            n.a().b(IronSource.AD_UNIT.BANNER, new IronSourceError(606, str));
        } else if (!a(i.RELOADING, i.LOADED)) {
            a(iVar2);
            ironLog.error("wrong state = " + this.j);
        } else {
            a(3201, new Object[][]{new Object[]{"duration", Long.valueOf(ib.a(this.D))}});
            n.a().b(IronSource.AD_UNIT.BANNER, new IronSourceError(606, str));
            this.k.a(TimeUnit.SECONDS.toMillis(this.i.f()));
        }
    }

    private void n() {
        String strL = l();
        bg.a aVar = this.h;
        Context applicationContext = ContextProvider.getInstance().getApplicationContext();
        IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.BANNER;
        aVar.a(applicationContext, strL, ad_unit);
        if (this.g.b(ContextProvider.getInstance().getApplicationContext(), this.m, ad_unit)) {
            a(IronSourceConstants.BN_PLACEMENT_CAPPED);
        }
    }

    private boolean p() {
        i iVar = this.j;
        return iVar == i.RELOADING || iVar == i.AUCTION;
    }

    private boolean q() {
        boolean z;
        synchronized (this.C) {
            z = this.j == i.LOADED;
        }
        return z;
    }

    private boolean r() {
        boolean z;
        synchronized (this.C) {
            i iVar = this.j;
            z = iVar == i.FIRST_AUCTION || iVar == i.AUCTION;
        }
        return z;
    }

    private boolean s() {
        boolean z;
        synchronized (this.C) {
            i iVar = this.j;
            z = iVar == i.LOADING || iVar == i.RELOADING;
        }
        return z;
    }

    private void t() {
        try {
            for (int i2 = this.n; i2 < this.r.size(); i2++) {
                x xVar = this.r.get(i2);
                if (xVar.h()) {
                    IronLog.INTERNAL.verbose("loading smash - " + xVar.f());
                    this.n = i2 + 1;
                    f(xVar);
                    return;
                }
            }
            m();
        } catch (Exception e2) {
            o9.d().a(e2);
            a(IronSourceConstants.TROUBLESHOOTING_BN_INTERNAL_ERROR, new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, "loadNextSmash"}, new Object[]{"reason", Log.getStackTraceString(e2)}});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        IronLog.INTERNAL.verbose();
        AsyncTask.execute(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("");
        if (a(i.LOADED, i.STARTED_LOADING)) {
            b(true);
        } else {
            ironLog.error("wrong state = " + this.j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        if (this.A.isEmpty()) {
            return;
        }
        this.y.a(this.A);
        this.A.clear();
    }

    private void x() {
        List<m5> listI = i();
        this.s = e();
        a(listI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean y() {
        long jA = l.a(this.B, this.i.h());
        if (jA <= 0) {
            return false;
        }
        IronLog.INTERNAL.verbose("waiting before auction - timeToWaitBeforeAuction = " + jA);
        new Timer().schedule(new h(), jA);
        return true;
    }

    @Override // com.json.s4
    public void a(int i2, String str, int i3, String str2, long j) {
        String str3 = "Auction failed | moving to fallback waterfall (error " + i2 + " - " + str + ")";
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(str3);
        IronSourceUtils.sendAutomationLog("BN: " + str3);
        if (!r()) {
            ironLog.warning("wrong state - mCurrentState = " + this.j);
            return;
        }
        this.u = str2;
        this.v = i3;
        this.t = null;
        x();
        a(IronSourceConstants.BN_AUCTION_FAILED, new Object[][]{new Object[]{"duration", Long.valueOf(j)}, new Object[]{"errorCode", Integer.valueOf(i2)}, new Object[]{"reason", str}});
        a(this.j == i.FIRST_AUCTION ? i.LOADING : i.RELOADING);
        t();
    }

    public void a(IronSourceBannerLayout ironSourceBannerLayout) {
        IronLog.INTERNAL.verbose();
        l.a(ironSourceBannerLayout, new b(ironSourceBannerLayout));
    }

    public void a(IronSourceBannerLayout ironSourceBannerLayout, h7 h7Var) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose();
        IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.BANNER;
        a(ad_unit);
        f();
        if (!a(i.READY_TO_LOAD, i.STARTED_LOADING)) {
            IronLog.API.error("can't load banner - loadBanner already called and still in progress");
        } else if (n.a().b(ad_unit)) {
            ironLog.verbose("can't load banner - already has pending invocation");
        } else {
            l.a(ironSourceBannerLayout, h7Var, new a(h7Var, ironSourceBannerLayout));
        }
    }

    @Override // com.json.vp
    public void a(IronSourceError ironSourceError, x xVar, boolean z) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("error = " + ironSourceError);
        if (xVar.x() != this.s) {
            ironLog.error("invoked with auctionId: " + xVar.x() + " and the current id is " + this.s);
            xVar.a(IronSourceConstants.TROUBLESHOOTING_BN_MANAGER_UNEXPECTED_STATE, new Object[][]{new Object[]{"errorCode", 3}, new Object[]{"reason", "Wrong auction " + xVar.x() + " State - " + this.j}, new Object[]{IronSourceConstants.EVENTS_EXT1, xVar.c()}});
        } else if (!s()) {
            ironLog.warning("wrong state - mCurrentState = " + this.j);
        } else {
            this.A.put(xVar.c(), com.ironsource.mediationsdk.h.a.ISAuctionPerformanceFailedToLoad);
            t();
        }
    }

    @Override // com.json.vp
    public void a(x xVar) {
        m5 m5Var;
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(xVar.f());
        if (!q()) {
            ironLog.warning("wrong state - mCurrentState = " + this.j);
            a(IronSourceConstants.TROUBLESHOOTING_BN_MANAGER_UNEXPECTED_STATE, new Object[][]{new Object[]{"errorCode", 1}, new Object[]{"reason", "Wrong State - " + this.j}, new Object[]{IronSourceConstants.EVENTS_EXT1, xVar.c()}});
            return;
        }
        if (this.i.j() && this.i.b().q() && (m5Var = this.z.get(xVar.c())) != null) {
            a(xVar, m5Var);
        }
        a(IronSourceConstants.BN_CALLBACK_SHOW);
    }

    @Override // com.json.vp
    public void a(x xVar, View view, FrameLayout.LayoutParams layoutParams) {
        Object[][] objArr;
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("smash = " + xVar.f());
        if (xVar.x() != this.s) {
            ironLog.error("invoked with auctionId: " + xVar.x() + " and the current id is " + this.s);
            xVar.a(IronSourceConstants.TROUBLESHOOTING_BN_MANAGER_UNEXPECTED_STATE, new Object[][]{new Object[]{"errorCode", 2}, new Object[]{"reason", "Wrong auction id " + xVar.x() + " State - " + this.j}, new Object[]{IronSourceConstants.EVENTS_EXT1, xVar.c()}});
            return;
        }
        if (!s()) {
            ironLog.warning("wrong state - mCurrentState = " + this.j);
            return;
        }
        x xVar2 = this.o;
        if (xVar2 != null) {
            xVar2.q();
        }
        g(xVar);
        this.o = xVar;
        b(xVar, view, layoutParams);
        this.A.put(xVar.c(), com.ironsource.mediationsdk.h.a.ISAuctionPerformanceShowedSuccessfully);
        if (this.i.j()) {
            m5 m5Var = this.z.get(xVar.c());
            if (m5Var != null) {
                a(m5Var.a(l()), m5Var.d());
                this.w.a(m5Var, xVar.g(), this.x);
                this.w.a(this.r, this.z, xVar.g(), this.x, m5Var);
                if (!this.i.b().q()) {
                    a(xVar, m5Var);
                }
            } else {
                String strC = xVar.c();
                ironLog.error("onLoadSuccess winner instance " + strC + " missing from waterfall. auctionId = " + this.s);
                a(IronSourceConstants.TROUBLESHOOTING_BN_NOTIFICATIONS_ERROR, new Object[][]{new Object[]{"errorCode", 1010}, new Object[]{"reason", "Loaded missing"}, new Object[]{IronSourceConstants.EVENTS_EXT1, strC}});
            }
        }
        if (this.j == i.LOADING) {
            if (g()) {
                t5.a().d(this.d);
                objArr = new Object[][]{new Object[]{"duration", Long.valueOf(ib.a(this.D))}};
            } else {
                objArr = new Object[][]{new Object[]{"reason", "banner is destroyed"}, new Object[]{"duration", Long.valueOf(ib.a(this.D))}};
            }
            a(IronSourceConstants.BN_CALLBACK_LOAD_SUCCESS, objArr);
        } else {
            if (g()) {
                t5.a().d(this.d);
            }
            IronSourceUtils.sendAutomationLog("bannerReloadSucceeded");
            a(IronSourceConstants.BN_CALLBACK_RELOAD_SUCCESS, new Object[][]{new Object[]{"duration", Long.valueOf(ib.a(this.D))}});
        }
        n();
        this.f.b(IronSource.AD_UNIT.BANNER);
        a(i.LOADED);
        this.k.a(TimeUnit.SECONDS.toMillis(this.i.f()));
    }

    @Override // com.json.s4
    public void a(List<m5> list, String str, m5 m5Var, JSONObject jSONObject, JSONObject jSONObject2, int i2, long j, int i3, String str2) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("auctionId = " + str);
        if (!r()) {
            ironLog.warning("wrong state - mCurrentState = " + this.j);
            return;
        }
        this.u = "";
        this.s = str;
        this.v = i2;
        this.x = m5Var;
        this.t = jSONObject;
        if (!TextUtils.isEmpty(str2)) {
            a(88002, new Object[][]{new Object[]{"errorCode", Integer.valueOf(i3)}, new Object[]{"reason", str2}});
        }
        IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.BANNER;
        a(jSONObject2, ad_unit);
        if (!this.b.a(ad_unit)) {
            a(IronSourceConstants.BN_AUCTION_SUCCESS, new Object[][]{new Object[]{"duration", Long.valueOf(j)}});
            a(this.j == i.FIRST_AUCTION ? i.LOADING : i.RELOADING);
            a(IronSourceConstants.BN_AUCTION_RESPONSE_WATERFALL, new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, a(list)}});
            t();
            return;
        }
        a(IronSourceConstants.BN_AD_UNIT_CAPPED, new Object[][]{new Object[]{"auctionId", str}});
        i iVar = this.j;
        a(i.READY_TO_LOAD);
        if (iVar == i.FIRST_AUCTION) {
            n.a().b(ad_unit, new IronSourceError(IronSourceError.ERROR_AD_FORMAT_CAPPED, "Ad unit is capped"));
        }
    }

    @Override // com.json.vp
    public void b(x xVar) {
        Object[][] objArr;
        IronLog.INTERNAL.verbose(xVar.f());
        if (g()) {
            t5.a().b(this.d);
            objArr = null;
        } else {
            objArr = new Object[][]{new Object[]{"reason", "banner is destroyed"}};
        }
        a(IronSourceConstants.BN_CALLBACK_CLICK, objArr, xVar.n());
    }

    @Override // com.json.vp
    public void c(x xVar) {
        Object[][] objArr;
        IronLog.INTERNAL.verbose(xVar.f());
        if (g()) {
            t5.a().c(this.d);
            objArr = null;
        } else {
            objArr = new Object[][]{new Object[]{"reason", "banner is destroyed"}};
        }
        a(IronSourceConstants.BN_CALLBACK_LEAVE_APP, objArr, xVar.n());
    }

    @Override // com.json.vp
    public void d(x xVar) {
        Object[][] objArr;
        IronLog.INTERNAL.verbose(xVar.f());
        if (g()) {
            t5.a().f(this.d);
            objArr = null;
        } else {
            objArr = new Object[][]{new Object[]{"reason", "banner is destroyed"}};
        }
        a(IronSourceConstants.BN_CALLBACK_PRESENT_SCREEN, objArr, xVar.n());
    }

    @Override // com.json.vp
    public void e(x xVar) {
        Object[][] objArr;
        IronLog.INTERNAL.verbose(xVar.f());
        if (g()) {
            t5.a().e(this.d);
            objArr = null;
        } else {
            objArr = new Object[][]{new Object[]{"reason", "banner is destroyed"}};
        }
        a(IronSourceConstants.BN_CALLBACK_DISMISS_SCREEN, objArr, xVar.n());
    }

    public void g(x xVar) {
        for (x xVar2 : this.r) {
            if (!xVar2.equals(xVar)) {
                xVar2.q();
            }
        }
    }

    public boolean o() {
        IronLog ironLog;
        String str;
        if (!this.l.isShown()) {
            ironLog = IronLog.INTERNAL;
            str = "banner or one of its parents are INVISIBLE or GONE";
        } else {
            if (this.l.hasWindowFocus()) {
                boolean globalVisibleRect = this.l.getGlobalVisibleRect(new Rect());
                IronLog.INTERNAL.verbose("visible = " + globalVisibleRect);
                return globalVisibleRect;
            }
            ironLog = IronLog.INTERNAL;
            str = "banner has no window focus";
        }
        ironLog.verbose(str);
        return false;
    }
}
