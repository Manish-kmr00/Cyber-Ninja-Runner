package com.json.sdk.controller;

import android.app.Activity;
import android.content.Context;
import android.os.CountDownTimer;
import android.util.Log;
import com.json.b9;
import com.json.cc;
import com.json.e9;
import com.json.eh;
import com.json.er;
import com.json.fh;
import com.json.gb;
import com.json.gh;
import com.json.hg;
import com.json.iw;
import com.json.lh;
import com.json.m0;
import com.json.mh;
import com.json.mm;
import com.json.o9;
import com.json.om;
import com.json.pm;
import com.json.pn;
import com.json.q8;
import com.json.qe;
import com.json.s3;
import com.json.sdk.IronSourceNetwork;
import com.json.sdk.utils.IronSourceStorageUtils;
import com.json.sdk.utils.Logger;
import com.json.se;
import com.json.t9;
import com.json.u9;
import com.json.v9;
import com.json.va;
import com.json.vc;
import com.json.wa;
import com.json.wc;
import com.json.x9;
import com.json.y9;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class e implements com.json.sdk.controller.c, com.json.sdk.controller.l {
    private com.json.sdk.controller.l b;
    private CountDownTimer d;
    private final hg g;
    private final iw h;
    private final pn k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f4294a = "e";
    private eh.b c = eh.b.None;
    private final q8 e = new q8("NativeCommandExecutor");
    private final q8 f = new q8("ControllerCommandsExecutor");
    private final Map<String, com.ironsource.sdk.controller.l.a> i = new HashMap();
    private final Map<String, com.ironsource.sdk.controller.l.b> j = new HashMap();

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ JSONObject f4295a;
        final /* synthetic */ u9 b;

        a(JSONObject jSONObject, u9 u9Var) {
            this.f4295a = jSONObject;
            this.b = u9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.b != null) {
                e.this.b.a(this.f4295a, this.b);
            }
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ va f4296a;
        final /* synthetic */ Map b;
        final /* synthetic */ u9 c;

        b(va vaVar, Map map, u9 u9Var) {
            this.f4296a = vaVar;
            this.b = map;
            this.c = u9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.b != null) {
                e.this.b.a(this.f4296a, this.b, this.c);
            }
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4297a;
        final /* synthetic */ String b;
        final /* synthetic */ va c;
        final /* synthetic */ t9 d;

        c(String str, String str2, va vaVar, t9 t9Var) {
            this.f4297a = str;
            this.b = str2;
            this.c = vaVar;
            this.d = t9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.b != null) {
                e.this.b.a(this.f4297a, this.b, this.c, this.d);
            }
        }
    }

    class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ JSONObject f4298a;
        final /* synthetic */ t9 b;

        d(JSONObject jSONObject, t9 t9Var) {
            this.f4298a = jSONObject;
            this.b = t9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.b != null) {
                e.this.b.a(this.f4298a, this.b);
            }
        }
    }

    /* JADX INFO: renamed from: com.ironsource.sdk.controller.e$e, reason: collision with other inner class name */
    class RunnableC0404e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ va f4299a;

        RunnableC0404e(va vaVar) {
            this.f4299a = vaVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.b != null) {
                e.this.b.a(this.f4299a);
            }
        }
    }

    class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ va f4300a;

        f(va vaVar) {
            this.f4300a = vaVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.b != null) {
                e.this.b.b(this.f4300a);
            }
        }
    }

    class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ va f4301a;
        final /* synthetic */ Map b;
        final /* synthetic */ t9 c;

        g(va vaVar, Map map, t9 t9Var) {
            this.f4301a = vaVar;
            this.b = map;
            this.c = t9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.b != null) {
                e.this.b.a(this.f4301a, this.b, this.c);
            }
        }
    }

    class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.ironsource.sdk.controller.l.a f4302a;
        final /* synthetic */ com.ironsource.sdk.controller.f.c b;

        h(com.ironsource.sdk.controller.l.a aVar, com.ironsource.sdk.controller.f.c cVar) {
            this.f4302a = aVar;
            this.b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.b != null) {
                if (this.f4302a != null) {
                    e.this.i.put(this.b.getCom.ironsource.sdk.controller.f.b.b java.lang.String(), this.f4302a);
                }
                e.this.b.a(this.b, this.f4302a);
            }
        }
    }

    class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ JSONObject f4303a;

        i(JSONObject jSONObject) {
            this.f4303a = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.b != null) {
                e.this.b.b(this.f4303a);
            }
        }
    }

    class j implements Runnable {
        j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.b != null) {
                e.this.b.destroy();
                e.this.b = null;
            }
        }
    }

    class k extends CountDownTimer {
        k(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Logger.i(e.this.f4294a, "Global Controller Timer Finish");
            e.this.d(b9.c.k);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            Logger.i(e.this.f4294a, "Global Controller Timer Tick " + j);
        }
    }

    class l implements Runnable {
        l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.c();
        }
    }

    class m implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4307a;
        final /* synthetic */ String b;

        m(String str, String str2) {
            this.f4307a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                e eVar = e.this;
                eVar.b = eVar.b(eVar.h.b(), e.this.h.d(), e.this.h.f(), e.this.h.e(), e.this.h.g(), e.this.h.c(), this.f4307a, this.b);
                e.this.b.a();
            } catch (Throwable th) {
                o9.d().a(th);
                e.this.d(Log.getStackTraceString(th));
            }
        }
    }

    class n extends CountDownTimer {
        n(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Logger.i(e.this.f4294a, "Recovered Controller | Global Controller Timer Finish");
            e.this.d(b9.c.k);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            Logger.i(e.this.f4294a, "Recovered Controller | Global Controller Timer Tick " + j);
        }
    }

    class o implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4309a;
        final /* synthetic */ String b;
        final /* synthetic */ va c;
        final /* synthetic */ v9 d;

        o(String str, String str2, va vaVar, v9 v9Var) {
            this.f4309a = str;
            this.b = str2;
            this.c = vaVar;
            this.d = v9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.b != null) {
                e.this.b.a(this.f4309a, this.b, this.c, this.d);
            }
        }
    }

    class p implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ JSONObject f4310a;
        final /* synthetic */ v9 b;

        p(JSONObject jSONObject, v9 v9Var) {
            this.f4310a = jSONObject;
            this.b = v9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.b != null) {
                e.this.b.a(this.f4310a, this.b);
            }
        }
    }

    class q implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4311a;
        final /* synthetic */ String b;
        final /* synthetic */ va c;
        final /* synthetic */ u9 d;

        q(String str, String str2, va vaVar, u9 u9Var) {
            this.f4311a = str;
            this.b = str2;
            this.c = vaVar;
            this.d = u9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.b != null) {
                e.this.b.a(this.f4311a, this.b, this.c, this.d);
            }
        }
    }

    class r implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4312a;
        final /* synthetic */ u9 b;

        r(String str, u9 u9Var) {
            this.f4312a = str;
            this.b = u9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.b != null) {
                e.this.b.a(this.f4312a, this.b);
            }
        }
    }

    class s implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ va f4313a;
        final /* synthetic */ Map b;
        final /* synthetic */ u9 c;

        s(va vaVar, Map map, u9 u9Var) {
            this.f4313a = vaVar;
            this.b = map;
            this.c = u9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            lh.a(er.j, new gh().a(cc.v, this.f4313a.f()).a("producttype", mh.a(this.f4313a, eh.e.Interstitial)).a(cc.x, Boolean.valueOf(mh.a(this.f4313a))).a(cc.I, Long.valueOf(m0.f3880a.b(this.f4313a.h()))).a());
            if (e.this.b != null) {
                e.this.b.b(this.f4313a, this.b, this.c);
            }
        }
    }

    public e(Context context, e9 e9Var, wa waVar, hg hgVar, int i2, JSONObject jSONObject, String str, String str2, pn pnVar) {
        this.k = pnVar;
        this.g = hgVar;
        String networkStorageDir = IronSourceStorageUtils.getNetworkStorageDir(context);
        gb gbVarA = gb.a(networkStorageDir, hgVar, jSONObject);
        this.h = new iw(context, e9Var, waVar, i2, gbVarA, networkStorageDir);
        a(context, e9Var, waVar, i2, gbVarA, networkStorageDir, str, str2);
    }

    private void a(final Context context, final e9 e9Var, final wa waVar, final int i2, final gb gbVar, final String str, final String str2, final String str3) {
        int iC = mm.S().d().c();
        if (iC > 0) {
            lh.a(er.B, new gh().a(cc.y, String.valueOf(iC)).a());
        }
        a(new Runnable() { // from class: com.ironsource.sdk.controller.e$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.c(context, e9Var, waVar, i2, gbVar, str, str2, str3);
            }
        }, iC);
        this.d = new k(200000L, 1000L).start();
    }

    private void a(eh.e eVar, va vaVar, String str, String str2) {
        Logger.i(this.f4294a, "recoverWebController for product: " + eVar.toString());
        gh ghVar = new gh();
        ghVar.a("producttype", eVar.toString());
        ghVar.a(cc.v, vaVar.f());
        lh.a(er.b, ghVar.a());
        this.h.n();
        destroy();
        b(new m(str, str2));
        this.d = new n(200000L, 1000L).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(om omVar) {
        com.ironsource.sdk.controller.l.b bVar = this.j.get(omVar.d());
        if (bVar != null) {
            bVar.a(omVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(com.ironsource.sdk.controller.f.a aVar) {
        com.ironsource.sdk.controller.l.a aVarRemove = this.i.remove(aVar.c());
        if (aVarRemove != null) {
            aVarRemove.a(aVar);
        }
    }

    private void a(Runnable runnable, long j2) {
        hg hgVar = this.g;
        if (hgVar != null) {
            hgVar.d(runnable, j2);
        } else {
            Logger.e(this.f4294a, "mThreadManager = null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public v b(Context context, e9 e9Var, wa waVar, int i2, gb gbVar, String str, String str2, String str3) throws Throwable {
        lh.a(er.c);
        v vVar = new v(context, waVar, e9Var, this, this.g, i2, gbVar, str, h(), i(), str2, str3);
        wc wcVar = new wc(context, gbVar, new vc(this.g.a()), new pm(gbVar.a()));
        vVar.a(new u(context));
        vVar.a(new com.json.sdk.controller.o(context));
        vVar.a(new com.json.sdk.controller.q(context));
        vVar.a(new com.json.sdk.controller.i(context));
        vVar.a(new com.json.sdk.controller.a(context));
        vVar.a(new com.json.sdk.controller.j(gbVar.a(), wcVar));
        vVar.a(new s3());
        vVar.a(new y9(context, new x9()));
        return vVar;
    }

    private void b(Runnable runnable) {
        a(runnable, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(Context context, e9 e9Var, wa waVar, int i2, gb gbVar, String str, String str2, String str3) {
        try {
            v vVarB = b(context, e9Var, waVar, i2, gbVar, str, str2, str3);
            this.b = vVarB;
            vVarB.a();
        } catch (Throwable th) {
            o9.d().a(th);
            d(Log.getStackTraceString(th));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        lh.a(er.d, new gh().a(cc.A, str).a());
        this.c = eh.b.Loading;
        this.b = new com.json.sdk.controller.n(str, this.g);
        this.e.c();
        this.e.a();
        hg hgVar = this.g;
        if (hgVar != null) {
            hgVar.c(new l());
        }
    }

    private void e(String str) {
        IronSourceNetwork.updateInitFailed(new fh(1001, str));
    }

    private com.ironsource.sdk.controller.l.a h() {
        return new com.ironsource.sdk.controller.l.a() { // from class: com.ironsource.sdk.controller.e$$ExternalSyntheticLambda2
            @Override // com.ironsource.sdk.controller.l.a
            public final void a(f.a aVar) {
                this.f$0.a(aVar);
            }
        };
    }

    private com.ironsource.sdk.controller.l.b i() {
        return new com.ironsource.sdk.controller.l.b() { // from class: com.ironsource.sdk.controller.e$$ExternalSyntheticLambda1
            @Override // com.ironsource.sdk.controller.l.b
            public final void a(om omVar) {
                this.f$0.a(omVar);
            }
        };
    }

    private void k() {
        Logger.i(this.f4294a, "handleReadyState");
        this.c = eh.b.Ready;
        CountDownTimer countDownTimer = this.d;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        m();
        this.f.c();
        this.f.a();
        com.json.sdk.controller.l lVar = this.b;
        if (lVar != null) {
            lVar.e();
        }
    }

    private boolean l() {
        return eh.b.Ready.equals(this.c);
    }

    private void m() {
        this.h.a(true);
        com.json.sdk.controller.l lVar = this.b;
        if (lVar != null) {
            lVar.a(this.h.i());
        }
    }

    @Override // com.json.sdk.controller.l
    public void a() {
    }

    @Override // com.json.sdk.controller.l
    public void a(Activity activity) {
        this.b.a(activity);
    }

    @Override // com.json.sdk.controller.l
    public void a(Context context) {
        com.json.sdk.controller.l lVar;
        if (!l() || (lVar = this.b) == null) {
            return;
        }
        lVar.a(context);
    }

    @Override // com.json.ue
    public void a(qe qeVar) {
        er.a aVar;
        gh ghVar;
        StringBuilder sb;
        se strategy = qeVar.getStrategy();
        if (strategy == se.SendEvent) {
            aVar = er.A;
            ghVar = new gh();
            sb = new StringBuilder();
        } else {
            if (strategy != se.NativeController) {
                return;
            }
            com.json.sdk.controller.n nVar = new com.json.sdk.controller.n(qeVar.a(), this.g);
            this.b = nVar;
            this.k.a(nVar.g());
            lh.a(er.d, new gh().a(cc.A, qeVar.a() + " : strategy: " + strategy).a());
            aVar = er.A;
            ghVar = new gh();
            sb = new StringBuilder();
        }
        lh.a(aVar, ghVar.a(cc.y, sb.append(qeVar.a()).append(" : strategy: ").append(strategy).toString()).a());
    }

    @Override // com.json.sdk.controller.l
    public void a(com.ironsource.sdk.controller.f.c cVar, com.ironsource.sdk.controller.l.a aVar) {
        this.f.a(new h(aVar, cVar));
    }

    @Override // com.json.sdk.controller.l
    public void a(va vaVar) {
        this.f.a(new RunnableC0404e(vaVar));
    }

    @Override // com.json.sdk.controller.l
    public void a(va vaVar, Map<String, String> map, t9 t9Var) {
        this.f.a(new g(vaVar, map, t9Var));
    }

    @Override // com.json.sdk.controller.l
    public void a(va vaVar, Map<String, String> map, u9 u9Var) {
        this.f.a(new b(vaVar, map, u9Var));
    }

    public void a(Runnable runnable) {
        this.e.a(runnable);
    }

    public void a(String str, com.ironsource.sdk.controller.l.b bVar) {
        this.j.put(str, bVar);
    }

    @Override // com.json.sdk.controller.l
    public void a(String str, u9 u9Var) {
        Logger.i(this.f4294a, "load interstitial");
        this.f.a(new r(str, u9Var));
    }

    @Override // com.json.sdk.controller.l
    public void a(String str, String str2, va vaVar, t9 t9Var) {
        if (this.h.a(g(), this.c)) {
            a(eh.e.Banner, vaVar, str, str2);
        }
        this.f.a(new c(str, str2, vaVar, t9Var));
    }

    @Override // com.json.sdk.controller.l
    public void a(String str, String str2, va vaVar, u9 u9Var) {
        if (this.h.a(g(), this.c)) {
            a(eh.e.Interstitial, vaVar, str, str2);
        }
        this.f.a(new q(str, str2, vaVar, u9Var));
    }

    @Override // com.json.sdk.controller.l
    public void a(String str, String str2, va vaVar, v9 v9Var) {
        if (this.h.a(g(), this.c)) {
            a(eh.e.RewardedVideo, vaVar, str, str2);
        }
        this.f.a(new o(str, str2, vaVar, v9Var));
    }

    @Override // com.json.sdk.controller.l
    public void a(JSONObject jSONObject) {
    }

    @Override // com.json.sdk.controller.l
    public void a(JSONObject jSONObject, t9 t9Var) {
        this.f.a(new d(jSONObject, t9Var));
    }

    @Override // com.json.sdk.controller.l
    public void a(JSONObject jSONObject, u9 u9Var) {
        this.f.a(new a(jSONObject, u9Var));
    }

    @Override // com.json.sdk.controller.l
    public void a(JSONObject jSONObject, v9 v9Var) {
        this.f.a(new p(jSONObject, v9Var));
    }

    @Override // com.json.sdk.controller.l
    public boolean a(String str) {
        if (this.b == null || !l()) {
            return false;
        }
        return this.b.a(str);
    }

    @Override // com.json.sdk.controller.c
    public void b() {
        Logger.i(this.f4294a, "handleControllerLoaded");
        this.c = eh.b.Loaded;
        this.e.c();
        this.e.a();
    }

    @Override // com.json.sdk.controller.l
    public void b(Context context) {
        com.json.sdk.controller.l lVar;
        if (!l() || (lVar = this.b) == null) {
            return;
        }
        lVar.b(context);
    }

    @Override // com.json.sdk.controller.l
    public void b(va vaVar) {
        this.f.a(new f(vaVar));
    }

    @Override // com.json.sdk.controller.l
    public void b(va vaVar, Map<String, String> map, u9 u9Var) {
        this.f.a(new s(vaVar, map, u9Var));
    }

    @Override // com.json.sdk.controller.c
    public void b(String str) {
        Logger.i(this.f4294a, "handleControllerFailed ");
        gh ghVar = new gh();
        ghVar.a(cc.A, str);
        ghVar.a(cc.y, String.valueOf(this.h.l()));
        lh.a(er.o, ghVar.a());
        this.h.a(false);
        e(str);
        if (this.d != null) {
            Logger.i(this.f4294a, "cancel timer mControllerReadyTimer");
            this.d.cancel();
        }
        d(str);
    }

    @Override // com.json.sdk.controller.l
    public void b(JSONObject jSONObject) {
        this.f.a(new i(jSONObject));
    }

    @Override // com.json.sdk.controller.c
    public void c() {
        Logger.i(this.f4294a, "handleControllerReady ");
        this.k.a(g());
        if (eh.c.Web.equals(g())) {
            lh.a(er.e, new gh().a(cc.y, String.valueOf(this.h.l())).a());
            IronSourceNetwork.updateInitSucceeded();
        }
        k();
    }

    @Override // com.json.sdk.controller.c
    public void c(String str) {
        lh.a(er.y, new gh().a(cc.y, str).a());
        CountDownTimer countDownTimer = this.d;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        d(str);
    }

    @Override // com.json.sdk.controller.l
    public void d() {
        com.json.sdk.controller.l lVar;
        if (!l() || (lVar = this.b) == null) {
            return;
        }
        lVar.d();
    }

    @Override // com.json.sdk.controller.l
    public void destroy() {
        Logger.i(this.f4294a, "destroy controller");
        CountDownTimer countDownTimer = this.d;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        q8 q8Var = this.f;
        if (q8Var != null) {
            q8Var.b();
        }
        this.d = null;
        b(new j());
    }

    @Override // com.json.sdk.controller.l
    @Deprecated
    public void e() {
    }

    @Override // com.json.sdk.controller.l
    public void f() {
        com.json.sdk.controller.l lVar;
        if (!l() || (lVar = this.b) == null) {
            return;
        }
        lVar.f();
    }

    @Override // com.json.sdk.controller.l
    public eh.c g() {
        com.json.sdk.controller.l lVar = this.b;
        return lVar != null ? lVar.g() : eh.c.None;
    }

    public com.json.sdk.controller.l j() {
        return this.b;
    }
}
