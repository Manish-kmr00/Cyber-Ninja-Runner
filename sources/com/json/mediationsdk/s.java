package com.json.mediationsdk;

import android.content.Context;
import android.content.IntentFilter;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.TextUtils;
import com.json.Cdo;
import com.json.a4;
import com.json.ak;
import com.json.ar;
import com.json.as;
import com.json.bf;
import com.json.ce;
import com.json.cq;
import com.json.e4;
import com.json.environment.ContextProvider;
import com.json.environment.NetworkStateReceiver;
import com.json.environment.thread.IronSourceThreadManager;
import com.json.eq;
import com.json.ip;
import com.json.k4;
import com.json.ls;
import com.json.mediationsdk.integration.IntegrationHelper;
import com.json.mediationsdk.logger.IronLog;
import com.json.mediationsdk.logger.IronSourceLogger;
import com.json.mediationsdk.logger.IronSourceLoggerManager;
import com.json.mediationsdk.sdk.SegmentListener;
import com.json.mediationsdk.utils.IronSourceConstants;
import com.json.mediationsdk.utils.IronSourceUtils;
import com.json.mm;
import com.json.mo;
import com.json.ms;
import com.json.nm;
import com.json.o9;
import com.json.os;
import com.json.xa;
import com.json.zb;
import com.json.zr;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes4.dex */
class s implements Cdo {
    private static s A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private os f4009a;
    private NetworkStateReceiver p;
    private CountDownTimer q;
    private String t;
    private ls u;
    private SegmentListener v;
    private long x;
    private int b = e.f;
    private bf c = mm.S().v();
    private final String d = "appKey";
    private final String e = getClass().getSimpleName();
    private boolean l = false;
    private boolean n = false;
    private List<mo> r = new ArrayList();
    private String s = "";
    private f z = new a();
    private Handler m = IronSourceThreadManager.INSTANCE.getInitHandler();
    private int f = 1;
    private int g = 0;
    private int h = 62;
    private int i = 12;
    private int j = 5;
    private AtomicBoolean o = new AtomicBoolean(true);
    private boolean k = false;
    private boolean w = false;
    private ak y = new ak();

    class a extends f {
        a() {
            super();
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            ms msVarI;
            try {
                p pVarM = p.m();
                if (!TextUtils.isEmpty(s.this.s)) {
                    ce.a().a("userId", s.this.s);
                }
                if (!TextUtils.isEmpty(s.this.t)) {
                    ce.a().a("appKey", s.this.t);
                }
                s.this.y.i(s.this.s);
                s.this.x = new Date().getTime();
                cq.c().a();
                s.this.u = pVarM.b(ContextProvider.getInstance().getApplicationContext(), s.this.s, this.c);
                if (s.this.u != null) {
                    s.this.m.removeCallbacks(this);
                    if (s.this.u.p()) {
                        s.this.b(d.INITIATED);
                        new nm().a(s.this.u.c().getApplicationConfigurations().d().b(), pVarM.B());
                        k4 k4VarE = s.this.u.c().getApplicationConfigurations().e();
                        if (k4VarE != null) {
                            xa xaVar = xa.f4585a;
                            xaVar.c(k4VarE.getShouldUseAppSet());
                            xaVar.a(k4VarE.getShouldReuseAdvId());
                            xaVar.a(k4VarE.getUserAgentExpirationThresholdInHours());
                            IronSourceThreadManager.INSTANCE.setUseSharedExecutorService(k4VarE.getShouldUseSharedThreadPool());
                            s.this.c.a(k4VarE);
                        }
                        s.this.a(ContextProvider.getInstance().getApplicationContext(), s.this.u);
                        pVarM.a(new Date().getTime() - s.this.x, s.this.u.h());
                        if (k4VarE != null && k4VarE.getShouldRegisterTrigger()) {
                            new eq(ar.i(), new Function0() { // from class: com.ironsource.mediationsdk.s$a$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Long.valueOf(System.currentTimeMillis());
                                }
                            }, mm.S(), IronSourceThreadManager.INSTANCE.getThreadPoolExecutor()).c(ContextProvider.getInstance().getApplicationContext());
                        }
                        s.this.f4009a = new os();
                        s.this.f4009a.a(s.this.c);
                        if (s.this.u.c().getApplicationConfigurations().f() && ContextProvider.getInstance().getApplicationContext() != null) {
                            IntegrationHelper.validateIntegration(ContextProvider.getInstance().getApplicationContext());
                        }
                        List<IronSource.AD_UNIT> listG = s.this.u.g();
                        Iterator it = s.this.r.iterator();
                        while (it.hasNext()) {
                            ((mo) it.next()).a(listG, s.this.h(), s.this.u.c());
                        }
                        new ip.a().a();
                        if (s.this.v != null && (msVarI = s.this.u.c().getApplicationConfigurations().i()) != null && !TextUtils.isEmpty(msVarI.c())) {
                            s.this.v.onSegmentReceived(msVarI.c());
                        }
                        e4 e4VarC = s.this.u.c().getApplicationConfigurations().c();
                        if (e4VarC.f()) {
                            o9.d().a(e4VarC.b(), e4VarC.d(), e4VarC.c(), e4VarC.e(), IronSourceUtils.getSessionId(), e4VarC.a(), e4VarC.g());
                        }
                    } else if (!s.this.l) {
                        s.this.b(d.INIT_FAILED);
                        s.this.l = true;
                        Iterator it2 = s.this.r.iterator();
                        while (it2.hasNext()) {
                            ((mo) it2.next()).d("serverResponseIsNotValid");
                        }
                    }
                } else {
                    if (s.this.g == 3) {
                        s.this.w = true;
                        Iterator it3 = s.this.r.iterator();
                        while (it3.hasNext()) {
                            ((mo) it3.next()).a();
                        }
                    }
                    if (this.f4015a && s.this.g < s.this.h) {
                        s.this.k = true;
                        s.this.m.postDelayed(this, s.this.f * 1000);
                        if (s.this.g < s.this.i) {
                            s.a(s.this, 2);
                        }
                    }
                    if ((!this.f4015a || s.this.g == s.this.j) && !s.this.l) {
                        s.this.l = true;
                        if (TextUtils.isEmpty(this.b)) {
                            this.b = "noServerResponse";
                        }
                        Iterator it4 = s.this.r.iterator();
                        while (it4.hasNext()) {
                            ((mo) it4.next()).d(this.b);
                        }
                        s.this.b(d.INIT_FAILED);
                        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, "Mediation availability false reason: No server response", 1);
                    }
                    s.f(s.this);
                }
                s.this.e();
            } catch (Exception e) {
                o9.d().a(e);
                IronLog.INTERNAL.error(e.toString());
            }
        }
    }

    class b implements Runnable {

        class a extends CountDownTimer {
            a(long j, long j2) {
                super(j, j2);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                if (s.this.l) {
                    return;
                }
                s.this.l = true;
                Iterator it = s.this.r.iterator();
                while (it.hasNext()) {
                    ((mo) it.next()).d("noInternetConnection");
                }
                IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, "Mediation availability false reason: No internet connection", 1);
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                if (j <= 45000) {
                    s.this.w = true;
                    Iterator it = s.this.r.iterator();
                    while (it.hasNext()) {
                        ((mo) it.next()).a();
                    }
                }
            }
        }

        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            s.this.q = new a(60000L, 15000L).start();
        }
    }

    static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4012a;

        static {
            int[] iArr = new int[d.values().length];
            f4012a = iArr;
            try {
                iArr[d.INIT_IN_PROGRESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4012a[d.INIT_FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4012a[d.INITIATED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    enum d {
        NOT_INIT,
        INIT_IN_PROGRESS,
        INIT_FAILED,
        INITIATED
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static int f4014a = 0;
        public static int b = 1;
        public static int c = 2;
        public static int d = 3;
        public static int e = 4;
        public static int f = 5;
    }

    abstract class f implements Runnable {
        String b;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f4015a = true;
        protected p.c c = new a();

        class a implements p.c {
            a() {
            }

            @Override // com.ironsource.mediationsdk.p.c
            public void a(String str) {
                f fVar = f.this;
                fVar.f4015a = false;
                fVar.b = str;
            }
        }

        f() {
        }
    }

    private s() {
    }

    private static int a(d dVar) {
        int i = c.f4012a[dVar.ordinal()];
        if (i == 1) {
            return e.d;
        }
        if (i != 2) {
            return i != 3 ? e.f4014a : e.b;
        }
        return e.e;
    }

    static /* synthetic */ int a(s sVar, int i) {
        int i2 = sVar.f * i;
        sVar.f = i2;
        return i2;
    }

    public static synchronized s c() {
        if (A == null) {
            A = new s();
        }
        return A;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (mm.S().d().f()) {
            ar.i().a(new zb(IronSourceConstants.EP_CONFIG_RECEIVED, null));
        }
    }

    static /* synthetic */ int f(s sVar) {
        int i = sVar.g;
        sVar.g = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h() {
        return this.k;
    }

    public synchronized d a() {
        return d.values()[as.f3534a.a().ordinal()];
    }

    public void a(Context context, ls lsVar) {
        this.y.i(lsVar.f().h());
        this.y.b(lsVar.f().d());
        a4 applicationConfigurations = lsVar.c().getApplicationConfigurations();
        this.y.a(applicationConfigurations.a());
        this.y.c(applicationConfigurations.b().b());
        this.y.b(applicationConfigurations.j().b());
        this.y.a(Boolean.valueOf(IronSourceUtils.getFirstSession(context)));
        k4 k4VarE = lsVar.c().getApplicationConfigurations().e();
        this.y.b(k4VarE.getCmpId());
        mm.M().x().a(k4VarE.getCom.ironsource.b9.a.c java.lang.String());
    }

    public synchronized void a(Context context, String str, String str2, IronSource.AD_UNIT... ad_unitArr) {
        try {
            AtomicBoolean atomicBoolean = this.o;
            if (atomicBoolean == null || !atomicBoolean.compareAndSet(true, false)) {
                IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, this.e + ": Multiple calls to init are not allowed", 2);
            } else {
                b(d.INIT_IN_PROGRESS);
                this.s = str2;
                this.t = str;
                if (IronSourceUtils.isNetworkConnected(context)) {
                    this.m.post(this.z);
                } else {
                    this.n = true;
                    if (this.p == null) {
                        this.p = new NetworkStateReceiver(context, this);
                    }
                    context.registerReceiver(this.p, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                    IronSourceThreadManager.INSTANCE.postMediationBackgroundTask(new b());
                }
            }
        } catch (Exception e2) {
            o9.d().a(e2);
            IronLog.INTERNAL.error(e2.toString());
        }
    }

    public void a(SegmentListener segmentListener) {
        this.v = segmentListener;
    }

    public void a(mo moVar) {
        if (moVar == null) {
            return;
        }
        this.r.add(moVar);
    }

    @Override // com.json.Cdo
    public void a(boolean z) {
        if (this.n && z) {
            CountDownTimer countDownTimer = this.q;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            this.n = false;
            this.k = true;
            ar.i().a(new zb(IronSourceConstants.INIT_AFTER_REACHABILITY_CHANGE, IronSourceUtils.getMediationAdditionalData(false)));
            this.m.post(this.z);
        }
    }

    public int b() {
        return this.b;
    }

    public synchronized void b(d dVar) {
        IronLog.INTERNAL.verbose("old status: " + a() + ", new status: " + dVar + ")");
        as.f3534a.a(zr.values()[dVar.ordinal()]);
    }

    public void b(mo moVar) {
        if (moVar == null || this.r.size() == 0) {
            return;
        }
        this.r.remove(moVar);
    }

    public synchronized boolean d() {
        return this.w;
    }

    void f() {
        b(d.INIT_FAILED);
    }

    public synchronized void g() {
        int iA = a(a());
        this.b = iA;
        this.y.c(iA);
    }
}
