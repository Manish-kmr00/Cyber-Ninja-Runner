package sg.bigo.ads.controller.e;

import android.content.ContentValues;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
import sg.bigo.ads.api.Ad;
import sg.bigo.ads.api.AdConfig;
import sg.bigo.ads.api.a.l;
import sg.bigo.ads.api.core.q;
import sg.bigo.ads.common.utils.k;
import sg.bigo.ads.common.utils.t;
import sg.bigo.ads.controller.g.i;
import sg.bigo.ads.controller.g.j;

/* JADX INFO: loaded from: classes8.dex */
public final class a implements sg.bigo.ads.controller.e<sg.bigo.ads.api.b, sg.bigo.ads.api.core.c, l>, sg.bigo.ads.controller.f.a.InterfaceC0885a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f13437a;
    final sg.bigo.ads.controller.b.d b;
    final sg.bigo.ads.controller.b.h c;
    final sg.bigo.ads.controller.a.b d;
    public final d e;
    final e f;
    public f g;
    final LinkedList<C0884a<? extends sg.bigo.ads.api.b>> h;
    final SparseArray<C0884a<i>> i;
    public long j;
    final b l;
    private Context n;
    private final sg.bigo.ads.controller.b o;
    private final AtomicBoolean m = new AtomicBoolean(false);
    boolean k = true;

    /* JADX INFO: renamed from: sg.bigo.ads.controller.e.a$a, reason: collision with other inner class name */
    public static class C0884a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T f13450a;
        final sg.bigo.ads.controller.c b;
        public boolean c;
        public boolean d;
        public int e;
        public int f;
        public q g;

        private C0884a(T t, sg.bigo.ads.controller.c cVar) {
            this.e = 1;
            this.f = 0;
            this.f13450a = t;
            this.b = cVar;
        }

        public /* synthetic */ C0884a(Object obj, sg.bigo.ads.controller.c cVar, byte b) {
            this(obj, cVar);
        }
    }

    public class b implements Runnable {
        private volatile int b = 0;
        private boolean c = true;

        public b() {
        }

        static /* synthetic */ void a(b bVar) {
            if (bVar.b == 2) {
                sg.bigo.ads.common.t.a.a(0, 3, "PrefetchConfigTask", "Task resumed.");
                bVar.a();
            }
        }

        final void a() {
            if (this.b == 0 || this.b == 2) {
                sg.bigo.ads.common.t.a.a(0, 3, "PrefetchConfigTask", "Task set.");
                sg.bigo.ads.common.n.d.a(3, this, 5000L);
                this.b = 1;
            }
        }

        final void b() {
            if (this.b == 1 || this.b == 2) {
                if (this.b == 1) {
                    sg.bigo.ads.common.n.d.a(this);
                }
                sg.bigo.ads.common.t.a.a(0, 3, "PrefetchConfigTask", "Task canceled.");
                this.b = 3;
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (!sg.bigo.ads.common.f.b.e()) {
                b();
                return;
            }
            if (!this.c || a.this.k) {
                sg.bigo.ads.common.t.a.a(0, 3, "PrefetchConfigTask", "Start to execute task.");
                this.b = 4;
                a.this.f.a(new e.a() { // from class: sg.bigo.ads.controller.e.a.b.1
                    @Override // sg.bigo.ads.controller.e.e.a
                    public final void a(int i) {
                        a.a(a.this, 1, (Map) null);
                    }

                    @Override // sg.bigo.ads.controller.e.e.a
                    public final void a(int i, int i2, String str) {
                    }
                }, 0);
            } else {
                this.c = false;
                sg.bigo.ads.common.t.a.b("PrefetchConfigTask", "The network is unavailable now. Task paused.");
                this.b = 2;
            }
        }
    }

    public a(Context context, AdConfig adConfig) {
        sg.bigo.ads.controller.b bVar = new sg.bigo.ads.controller.b() { // from class: sg.bigo.ads.controller.e.a.1
            @Override // sg.bigo.ads.controller.e
            public final void a(int i, int i2, int i3, String str, Object obj) {
                sg.bigo.ads.common.t.a.a(0, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.g.f6934a, "sdk config fetch error, seq=" + i + ", code=" + i2 + ", subCode=" + i3 + ", message=" + str);
            }

            @Override // sg.bigo.ads.controller.b
            public final void a(int i, String str) {
                sg.bigo.ads.common.t.a.a(0, 3, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.g.f6934a, "sdk config fetch success, seqId=" + i + ", data=" + str);
            }
        };
        this.o = bVar;
        this.f13437a = context;
        sg.bigo.ads.controller.b.d dVar = new sg.bigo.ads.controller.b.d(context);
        this.b = dVar;
        sg.bigo.ads.api.a.i.f13093a = dVar;
        sg.bigo.ads.controller.b.h hVar = new sg.bigo.ads.controller.b.h(context);
        this.c = hVar;
        d dVar2 = new d(context, adConfig, dVar);
        this.e = dVar2;
        sg.bigo.ads.controller.a.b bVar2 = new sg.bigo.ads.controller.a.b(context, dVar2, dVar);
        this.d = bVar2;
        bVar2.g = bVar;
        sg.bigo.ads.common.u.a.e.a(bVar2.f13381a.m);
        sg.bigo.ads.common.u.g.f13279a = new sg.bigo.ads.common.u.a.a(dVar2);
        this.f = new e(context, dVar, hVar, dVar2, bVar2);
        if (sg.bigo.ads.api.a.i.f13093a != null) {
            sg.bigo.ads.api.a.b bVarQ = sg.bigo.ads.api.a.i.f13093a.q();
            if (bVarQ instanceof sg.bigo.ads.controller.b.b) {
                ((sg.bigo.ads.controller.b.b) bVarQ).f13400a = hVar;
            }
        }
        this.h = new LinkedList<>();
        this.i = new SparseArray<>();
        this.l = new b();
    }

    static /* synthetic */ void a(a aVar, int i, Map map) {
        if (sg.bigo.ads.common.utils.q.a((CharSequence) aVar.e.c.z()) || aVar.m.getAndSet(true)) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jI = sg.bigo.ads.common.x.a.i();
        long jElapsedRealtime = aVar.j == 0 ? -1L : SystemClock.elapsedRealtime() - aVar.j;
        if (jCurrentTimeMillis - jI >= 300000) {
            sg.bigo.ads.core.d.b.a(jElapsedRealtime, i, sg.bigo.ads.common.x.a.q(), sg.bigo.ads.common.m.b.e(), (Map<String, String>) map);
            sg.bigo.ads.common.x.a.c(jCurrentTimeMillis);
            sg.bigo.ads.core.d.b.a();
        }
    }

    static /* synthetic */ void a(a aVar, final C0884a c0884a) {
        if (aVar.b.B()) {
            sg.bigo.ads.common.n.d.a(3, new Runnable() { // from class: sg.bigo.ads.controller.e.a.10
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public final void run() {
                    Ad adA;
                    sg.bigo.ads.api.b bVar = (sg.bigo.ads.api.b) c0884a.f13450a;
                    l lVarA = a.this.c.a(bVar);
                    if ((lVarA != null ? lVarA.w() : false) || bVar.g()) {
                        a.this.h.addFirst(c0884a);
                    } else {
                        if (lVarA != null && (adA = sg.bigo.ads.ad.b.a.f12488a.a(lVarA)) != null && (c0884a.b instanceof sg.bigo.ads.controller.a) && (((sg.bigo.ads.controller.a) c0884a.b).f13365a instanceof sg.bigo.ads.controller.d)) {
                            sg.bigo.ads.controller.a aVar2 = (sg.bigo.ads.controller.a) c0884a.b;
                            if (aVar2.f13365a instanceof sg.bigo.ads.controller.d) {
                                ((sg.bigo.ads.controller.d) aVar2.f13365a).a(lVarA, adA);
                            }
                        }
                        a.this.h.offer(c0884a);
                    }
                    a.this.a();
                }
            });
        } else {
            aVar.a(c0884a, 1005, 10004, "The country where the ad request comes from is not supported, please change your country to RU or US and have a try. Besides, check your COPPA setup on bigo's console. The app will fail to send an ad request if it's targeted children under 13.");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    final void a() {
        C0884a<? extends sg.bigo.ads.api.b> c0884aPoll;
        int i;
        String str;
        int i2;
        i cVar;
        boolean z;
        sg.bigo.ads.api.core.c cVarA;
        int i3;
        while (this.i.size() < this.b.x() && (c0884aPoll = this.h.poll()) != null) {
            l lVarA = this.c.a((sg.bigo.ads.api.b) c0884aPoll.f13450a);
            String str2 = ((sg.bigo.ads.api.b) c0884aPoll.f13450a).b;
            byte b2 = 0;
            if (lVarA == null) {
                sg.bigo.ads.common.t.a.a(0, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.g.f6934a, "scheduleRequest error, slot is empty, slot id=" + ((sg.bigo.ads.api.b) c0884aPoll.f13450a).f13094a);
                i = 10006;
                str = "The slot id is inactive or invalid, please make sure the id is aligned with app id. If ids are correct, please wait for at least 30 minutes then try again";
                i2 = 1014;
            } else if (!lVarA.m()) {
                sg.bigo.ads.common.t.a.a(0, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.g.f6934a, "schedule next request, slot is disable, slot id=" + ((sg.bigo.ads.api.b) c0884aPoll.f13450a).f13094a);
                i = 10005;
                str = "The switch of the slot is turned off. Please check slot setup.";
                i2 = 1015;
            } else if (((sg.bigo.ads.api.b) c0884aPoll.f13450a).a(lVarA.b())) {
                sg.bigo.ads.common.t.a.a(0, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.g.f6934a, "schedule next request, this slot id is ad type " + lVarA.b() + ", request as type " + ((sg.bigo.ads.api.b) c0884aPoll.f13450a).c());
                i = 10007;
                str = "The ad type of this slot isn't consistent with the method to querying an ad.";
                i2 = 1016;
            } else {
                boolean zW = lVarA.w();
                if (!zW && !TextUtils.isEmpty(str2)) {
                    sg.bigo.ads.common.t.a.a(0, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.g.f6934a, "requsting an ordinary ad with server bidding payload.");
                }
                if (c0884aPoll.c && sg.bigo.ads.api.a.i.f13093a != null && sg.bigo.ads.api.a.i.f13093a.q().f(lVarA.l()) > 1) {
                    sg.bigo.ads.common.t.a.a(0, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.g.f6934a, "schedule next request, slot is timeout, slot id=" + ((sg.bigo.ads.api.b) c0884aPoll.f13450a).f13094a);
                    i3 = 10207;
                } else {
                    if (!c0884aPoll.d || sg.bigo.ads.api.a.i.f13093a == null || sg.bigo.ads.api.a.i.f13093a.q().g(lVarA.l()) <= 1) {
                        if (sg.bigo.ads.api.core.b.d(lVarA.b())) {
                            sg.bigo.ads.common.x.a.j(lVarA.l());
                            int iA = lVarA.q().a("splash_impression_limit");
                            if (iA <= 0) {
                                z = true;
                            } else {
                                z = sg.bigo.ads.common.x.a.i(lVarA.l()) < iA;
                                if (!z) {
                                    sg.bigo.ads.common.t.a.b(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.g.f6934a, "The maximum number of ad impressions for the day (" + iA + ") has been reached.");
                                }
                            }
                            if (!z) {
                                i = 10008;
                                str = "The impressions of the ad has reached the limit. You can change this setup on bigo's console";
                                i2 = 1017;
                            } else if (!zW && (cVarA = sg.bigo.ads.controller.c.a.a(lVarA, ((sg.bigo.ads.api.b) c0884aPoll.f13450a).g)) != null) {
                                if (cVarA.J()) {
                                    sg.bigo.ads.controller.c.a.a(lVarA.l());
                                } else {
                                    sg.bigo.ads.common.t.a.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.g.f6934a, "Succeed to load splash ads from local db.");
                                    sg.bigo.ads.api.core.g.a aVar = new sg.bigo.ads.api.core.g.a(cVarA, lVarA, (sg.bigo.ads.api.b) c0884aPoll.f13450a, this.f13437a, b());
                                    aVar.f13107a = this.e;
                                    c0884aPoll.b.a(-1, c0884aPoll.f13450a, aVar.a());
                                }
                            }
                        }
                        sg.bigo.ads.api.a.h hVar = sg.bigo.ads.api.a.i.f13093a;
                        if (hVar != null && hVar.t() && !this.k) {
                            a(c0884aPoll, 1003, AuthApiStatusCodes.AUTH_APP_CERT_ERROR, "no network connection");
                            return;
                        }
                        sg.bigo.ads.controller.b.d dVar = this.b;
                        d dVar2 = this.e;
                        sg.bigo.ads.controller.a.b bVar = this.d;
                        sg.bigo.ads.api.b bVar2 = (sg.bigo.ads.api.b) c0884aPoll.f13450a;
                        if (bVar2.e()) {
                            cVar = new j(dVar, dVar2, bVar, bVar2, lVarA, this);
                        } else {
                            cVar = lVarA.w() ? new sg.bigo.ads.controller.g.c(dVar, dVar2, bVar2, lVarA, this) : new sg.bigo.ads.controller.g.b(dVar, dVar2, bVar, bVar2, lVarA, this);
                        }
                        this.i.put(cVar.a(), new C0884a<>(cVar, c0884aPoll.b, b2));
                        sg.bigo.ads.api.b.a aVar2 = ((sg.bigo.ads.api.b) c0884aPoll.f13450a).g;
                        if (aVar2.k == 0) {
                            aVar2.k = System.currentTimeMillis();
                        }
                        c0884aPoll.e = 2;
                        if (cVar instanceof sg.bigo.ads.controller.g.b) {
                            c0884aPoll.g = ((sg.bigo.ads.controller.g.b) cVar).h;
                        }
                        cVar.b();
                        Map<String, Object> mapA = sg.bigo.ads.core.b.a.a("load", lVarA, (sg.bigo.ads.api.b) c0884aPoll.f13450a, null, Integer.valueOf(lVarA.v()));
                        mapA.put("is_server_request", 1);
                        sg.bigo.ads.core.b.b.a().a("load", mapA);
                        return;
                    }
                    sg.bigo.ads.common.t.a.a(0, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.g.f6934a, "schedule next request, slot is loaded with cache, slot id=" + ((sg.bigo.ads.api.b) c0884aPoll.f13450a).f13094a);
                    i3 = 10208;
                }
                a(c0884aPoll, 1011, i3, "no fill");
            }
            a(c0884aPoll, i2, i, str);
        }
    }

    @Override // sg.bigo.ads.controller.e
    public final /* synthetic */ void a(final int i, final int i2, final int i3, final String str, l lVar) {
        final l lVar2 = lVar;
        sg.bigo.ads.common.n.d.a(3, new Runnable() { // from class: sg.bigo.ads.controller.e.a.3
            @Override // java.lang.Runnable
            public final void run() {
                C0884a<i> c0884a = a.this.i.get(i);
                if (c0884a != null) {
                    sg.bigo.ads.api.b bVarK = c0884a.f13450a.k();
                    a.this.i.remove(i);
                    int i4 = i2;
                    String str2 = str;
                    if (i4 == 1005) {
                        if (i3 == -6) {
                            i4 = 1004;
                            str2 = "The sdk integration and ad request are successful, but no ad wins at this time.";
                        } else {
                            str2 = "Error from server: " + str;
                        }
                    }
                    c0884a.b.a(i, i4, i3, str2, Pair.create(bVarK, lVar2));
                }
                a.this.a();
            }
        });
    }

    @Override // sg.bigo.ads.controller.e
    public final /* synthetic */ void a(final int i, sg.bigo.ads.api.b bVar, sg.bigo.ads.api.core.c[] cVarArr) {
        final sg.bigo.ads.api.b bVar2 = bVar;
        final sg.bigo.ads.api.core.c[] cVarArr2 = cVarArr;
        sg.bigo.ads.common.n.d.a(3, new Runnable() { // from class: sg.bigo.ads.controller.e.a.2
            @Override // java.lang.Runnable
            public final void run() {
                C0884a<i> c0884a = a.this.i.get(i);
                if (c0884a != null) {
                    a.this.i.remove(i);
                    if (!k.a(cVarArr2)) {
                        sg.bigo.ads.api.core.g[] gVarArr = new sg.bigo.ads.api.core.g[cVarArr2.length];
                        int i2 = 0;
                        while (true) {
                            sg.bigo.ads.api.core.c[] cVarArr3 = cVarArr2;
                            if (i2 >= cVarArr3.length) {
                                break;
                            }
                            sg.bigo.ads.api.core.c cVar = cVarArr3[i2];
                            sg.bigo.ads.api.core.g.a aVar = new sg.bigo.ads.api.core.g.a(cVar, c0884a.f13450a.l(), bVar2, a.this.f13437a, a.this.b());
                            aVar.f13107a = a.this.e;
                            gVarArr[i2] = aVar.a();
                            if (sg.bigo.ads.api.core.b.d(cVar.x())) {
                                t.a();
                                ContentValues contentValues = new ContentValues();
                                contentValues.put("slot", cVar.b());
                                contentValues.put("log_id", Long.valueOf(cVar.Z()));
                                long jCurrentTimeMillis = System.currentTimeMillis();
                                contentValues.put("start_time", Long.valueOf(jCurrentTimeMillis));
                                contentValues.put(SDKConstants.PARAM_TOURNAMENTS_END_TIME, Long.valueOf((cVar.L() * 1000) + jCurrentTimeMillis));
                                JSONObject jSONObjectAf = cVar.af();
                                contentValues.put("ad_data", jSONObjectAf == null ? "" : jSONObjectAf.toString());
                                contentValues.put("mtime", Long.valueOf(jCurrentTimeMillis));
                                sg.bigo.ads.common.g.a.a.b("tb_addata", contentValues);
                            }
                            i2++;
                        }
                        c0884a.b.a(i, bVar2, gVarArr);
                    }
                }
                a.this.a();
            }
        });
    }

    public final void a(String str, String str2) {
        this.d.a(str, str2);
    }

    final void a(final C0884a<? extends sg.bigo.ads.api.b> c0884a, final int i, final int i2, final String str) {
        sg.bigo.ads.common.n.d.a(2, new Runnable() { // from class: sg.bigo.ads.controller.e.a.11
            @Override // java.lang.Runnable
            public final void run() {
                c0884a.b.a(0, i, i2, str, new Pair(c0884a.f13450a, null));
            }
        });
    }

    @Override // sg.bigo.ads.controller.f.a.InterfaceC0885a
    public final void a(boolean z) {
        this.k = z;
        if (z) {
            sg.bigo.ads.common.aa.b.a();
            b.a(this.l);
        }
    }

    final Context b() {
        try {
            if (Build.VERSION.SDK_INT < 30) {
                return this.f13437a;
            }
            Context context = this.n;
            if (context != null) {
                return context;
            }
            Context contextCreateWindowContext = this.f13437a.createDisplayContext(((DisplayManager) this.f13437a.getSystemService(DisplayManager.class)).getDisplay(0)).createWindowContext(1001, null);
            this.n = contextCreateWindowContext;
            return contextCreateWindowContext;
        } catch (Throwable unused) {
            return this.f13437a;
        }
    }
}
