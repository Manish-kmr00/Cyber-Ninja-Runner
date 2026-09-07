package sg.bigo.ads.controller.a;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import sg.bigo.ads.common.utils.l;
import sg.bigo.ads.common.utils.q;

/* JADX INFO: loaded from: classes10.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final sg.bigo.ads.controller.a.a f13381a;
    final sg.bigo.ads.common.g b;
    public sg.bigo.ads.controller.b g;
    private final sg.bigo.ads.api.a.h h;
    private final Context i;
    final AtomicBoolean c = new AtomicBoolean(false);
    final AtomicBoolean d = new AtomicBoolean(false);
    final AtomicBoolean e = new AtomicBoolean(false);
    final AtomicBoolean f = new AtomicBoolean(false);
    private final g k = new g() { // from class: sg.bigo.ads.controller.a.b.1
        @Override // sg.bigo.ads.controller.a.g
        public final void a(String str) {
            b.this.f13381a.a(0L);
            sg.bigo.ads.common.t.a.a(0, 3, "AntiBan", "[saveAsync], reSave config, fromUrlPath=".concat(String.valueOf(str)));
        }

        @Override // sg.bigo.ads.controller.a.g
        public final void a(String str, boolean z) {
            sg.bigo.ads.common.t.a.a(0, 3, "AntiBan", "fetchConfig, country=" + str + ", fromSDKConfigUrl=" + z);
            if (!z) {
                b.a(b.this, (sg.bigo.ads.controller.g.k.a) null);
            }
            b.a(b.this, str, true);
        }
    };
    private final Runnable l = new Runnable() { // from class: sg.bigo.ads.controller.a.b.2
        @Override // java.lang.Runnable
        public final void run() {
            if (b.a(b.this, new sg.bigo.ads.controller.g.k.a() { // from class: sg.bigo.ads.controller.a.b.2.1
                @Override // sg.bigo.ads.controller.g.k.a
                public final void a(String str, int i, int i2, int i3, String str2, Map<String, Object> map) {
                    b.a(b.this, b.this.b.v(), false);
                }

                @Override // sg.bigo.ads.controller.g.k.a
                public final void a(String str, int i, String str2, Map<String, Object> map) {
                }
            })) {
                return;
            }
            b bVar = b.this;
            b.a(bVar, bVar.b.v(), false);
        }
    };
    private final Map<String, String> j = new ConcurrentHashMap();

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final k f13391a;
        public final String b;
        public final long c;

        private a(k kVar, String str, long j) {
            this.f13391a = kVar;
            this.b = str;
            this.c = j;
        }

        /* synthetic */ a(k kVar, String str, long j, byte b) {
            this(kVar, str, j);
        }
    }

    public b(Context context, sg.bigo.ads.common.g gVar, sg.bigo.ads.api.a.h hVar) {
        this.i = context;
        this.f13381a = new sg.bigo.ads.controller.a.a(context, hVar);
        this.b = gVar;
        this.h = hVar;
    }

    static /* synthetic */ boolean a(b bVar, final String str, boolean z) {
        bVar.e.compareAndSet(false, z);
        if (!bVar.d.compareAndSet(false, true)) {
            sg.bigo.ads.common.t.a.a(0, 3, "AntiBan", "[net disk] fetch pay svr config return because is fetching, fetch free svr config after fail -> ".concat(String.valueOf(z)));
            return false;
        }
        sg.bigo.ads.controller.a.a.f fVar = bVar.f13381a.j;
        sg.bigo.ads.common.t.a.a(0, 3, "AntiBan", "[net disk] fetch pay svr config, canFetch=" + fVar.a() + ", fetch free svr config after fail -> " + z);
        final ValueCallback<a> valueCallback = new ValueCallback<a>() { // from class: sg.bigo.ads.controller.a.b.4
            @Override // android.webkit.ValueCallback
            public final /* synthetic */ void onReceiveValue(a aVar) {
                a aVar2 = aVar;
                b.this.d.set(false);
                b.this.e.set(false);
                b.this.f.set(false);
                if (aVar2 == null || aVar2.f13391a == null) {
                    return;
                }
                b.this.a(aVar2.b, aVar2.f13391a.f13398a, aVar2.c, true);
            }
        };
        final ValueCallback<String> valueCallback2 = new ValueCallback<String>() { // from class: sg.bigo.ads.controller.a.b.5
            @Override // android.webkit.ValueCallback
            public final /* synthetic */ void onReceiveValue(String str2) {
                sg.bigo.ads.common.t.a.a(0, 3, "AntiBan", "[net disk] all svr urls are fail");
                b.this.e.set(false);
                b.this.f.set(false);
            }
        };
        if (fVar.a()) {
            fVar.b();
            bVar.a(str, fVar, valueCallback, new ValueCallback<String>() { // from class: sg.bigo.ads.controller.a.b.6
                @Override // android.webkit.ValueCallback
                public final /* synthetic */ void onReceiveValue(String str2) {
                    b.this.d.set(false);
                    if (b.this.e.compareAndSet(true, false) && b.this.f.compareAndSet(false, true)) {
                        b.this.a(str, valueCallback, valueCallback2);
                    } else {
                        sg.bigo.ads.common.t.a.a(0, 3, "AntiBan", "[net disk] all pay svr urls are fail");
                    }
                }
            });
            return true;
        }
        if (bVar.e.compareAndSet(true, false) && bVar.f.compareAndSet(false, true)) {
            bVar.a(str, valueCallback, valueCallback2);
        }
        bVar.d.set(false);
        return false;
    }

    static /* synthetic */ boolean a(b bVar, final sg.bigo.ads.controller.g.k.a aVar) {
        final sg.bigo.ads.controller.a.a.c cVar = bVar.f13381a.g;
        sg.bigo.ads.common.t.a.a(0, 3, "AntiBan", "[sdk config] fetch sdk config, canFetch=" + cVar.a() + ", ignoreFetchInterval=false");
        if (!bVar.c.compareAndSet(false, true)) {
            sg.bigo.ads.common.t.a.a(0, 3, "AntiBan", "[sdk config] fetch sdk config return because it is fetching.");
            return false;
        }
        if (!cVar.a()) {
            bVar.c.set(false);
            return false;
        }
        cVar.g = System.currentTimeMillis();
        bVar.f13381a.a(0L);
        sg.bigo.ads.common.t.a.a(0, 3, "AntiBan", "[saveAsync], fetch sdk config");
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        new sg.bigo.ads.controller.g.k(bVar.b, bVar, new sg.bigo.ads.controller.g.k.a() { // from class: sg.bigo.ads.controller.a.b.3
            @Override // sg.bigo.ads.controller.g.k.a
            public final void a(String str, int i, int i2, int i3, String str2, Map<String, Object> map) {
                b.this.c.set(false);
                if (TextUtils.isEmpty(l.a(map, "host_cfg"))) {
                    sg.bigo.ads.core.d.b.a(jElapsedRealtime > 0 ? SystemClock.elapsedRealtime() - jElapsedRealtime : 0L, false, str, 4001, "code=" + i2 + ",subCode=" + i3 + ",message=" + str2);
                }
                sg.bigo.ads.controller.g.k.a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.a(str, i, i2, i3, str2, map);
                }
                if (b.this.g != null) {
                    b.this.g.a(i, i2, i3, str2, map);
                }
            }

            @Override // sg.bigo.ads.controller.g.k.a
            public final void a(String str, int i, String str2, Map<String, Object> map) {
                b.this.c.set(false);
                cVar.h = System.currentTimeMillis();
                b.this.f13381a.a(0L);
                sg.bigo.ads.common.t.a.a(0, 3, "AntiBan", "[saveAsync], fetch sdk config, on sdk config fetch success");
                if (TextUtils.isEmpty(l.a(map, "host_cfg"))) {
                    sg.bigo.ads.core.d.b.a(jElapsedRealtime > 0 ? SystemClock.elapsedRealtime() - jElapsedRealtime : 0L, false, str, 4002, "host_cfg is empty.");
                }
                sg.bigo.ads.controller.g.k.a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.a(str, i, str2, map);
                }
                if (b.this.g != null) {
                    b.this.g.a(i, str2);
                }
            }
        }).b();
        return true;
    }

    public final f a(String str) {
        f.a aVar = new f.a(this.f13381a, this.b, this.h, str);
        aVar.a(this.k);
        return aVar;
    }

    public final h a(String str, String str2, long j, boolean z) {
        h hVarA = this.f13381a.a(str, str2, this.j, this.b.v(), this.h.s());
        long jElapsedRealtime = j <= 0 ? 0L : SystemClock.elapsedRealtime() - j;
        if (hVarA.b) {
            this.f13381a.a(0L);
            sg.bigo.ads.common.t.a.a(0, 3, "AntiBan", "[saveAsync], update host config, configSource=" + str2 + ", result=" + hVarA);
            if (z) {
                sg.bigo.ads.core.d.b.a(jElapsedRealtime, hVarA.c, str2, true);
            }
        } else if (hVarA.d == 0) {
            if (z) {
                sg.bigo.ads.core.d.b.a(jElapsedRealtime, hVarA.c, str2, false);
            }
        } else if (z) {
            sg.bigo.ads.core.d.b.a(jElapsedRealtime, hVarA.c, str2, hVarA.d, hVarA.e);
        }
        sg.bigo.ads.common.t.a.a(0, 3, "AntiBan", "updateHostConfig, configSource=" + str2 + ", update result=" + hVarA);
        return hVarA;
    }

    public final void a(long j, String str) {
        sg.bigo.ads.common.t.a.a(0, 3, "AntiBan", "fetchAntiBanConfig, delayMillis=" + j + ", from=" + str);
        sg.bigo.ads.common.n.d.a(this.l);
        sg.bigo.ads.common.n.d.a(1, this.l, Math.max(j, 0L));
    }

    public final void a(String str, String str2) {
        sg.bigo.ads.common.t.a.a(0, 3, "AntiBan", "addExtraHost, country=" + str + ", host=" + str2);
        if (d.a(str2)) {
            if (q.a((CharSequence) str)) {
                str = "all";
            }
            this.j.put(str, str2);
            if (this.f13381a.a(str, str2)) {
                this.f13381a.a(10L);
                sg.bigo.ads.common.t.a.a(0, 3, "AntiBan", "saveAsync, addExtraHost, delayMillis=10");
            }
        }
    }

    final void a(final String str, final sg.bigo.ads.controller.a.a.g gVar, final ValueCallback<a> valueCallback, final ValueCallback<String> valueCallback2) {
        final k kVarA = gVar.a(str);
        sg.bigo.ads.common.t.a.a(0, 3, "AntiBan", "[net disk] [saveAsync] fetch svr config, country=" + str + ", url=" + kVarA);
        this.f13381a.a(0L);
        if (kVarA == null) {
            if (valueCallback2 != null) {
                valueCallback2.onReceiveValue("not available url.");
            }
        } else {
            sg.bigo.ads.common.u.b.a aVar = new sg.bigo.ads.common.u.b.a(new sg.bigo.ads.common.u.b.d(kVarA.f13398a), this.i);
            aVar.k = sg.bigo.ads.common.u.a.e.b();
            final long jElapsedRealtime = SystemClock.elapsedRealtime();
            sg.bigo.ads.common.u.g.a(aVar, new sg.bigo.ads.common.u.b<sg.bigo.ads.common.u.b.a, sg.bigo.ads.common.u.c.d>() { // from class: sg.bigo.ads.controller.a.b.8
                @Override // sg.bigo.ads.common.u.b
                public final /* synthetic */ sg.bigo.ads.common.u.c.c a(sg.bigo.ads.common.u.c.a aVar2) {
                    return new sg.bigo.ads.common.u.c.d(aVar2);
                }

                @Override // sg.bigo.ads.common.u.b
                public final /* synthetic */ void a(sg.bigo.ads.common.u.b.c cVar, sg.bigo.ads.common.u.c.c cVar2) {
                    sg.bigo.ads.common.t.a.a(0, 3, "AntiBan", "[net disk] succeed to fetch net disk url: " + kVarA.f13398a);
                    String strA = ((sg.bigo.ads.common.u.c.d) cVar2).a();
                    if (valueCallback != null) {
                        valueCallback.onReceiveValue(new a(kVarA, strA, jElapsedRealtime, (byte) 0));
                    }
                }

                @Override // sg.bigo.ads.common.u.b
                public final /* synthetic */ void a(sg.bigo.ads.common.u.b.c cVar, sg.bigo.ads.common.u.h hVar) {
                    sg.bigo.ads.common.t.a.a(0, 3, "AntiBan", "[net disk] try another net disk url due to failed to fetch net disk url: " + kVarA.f13398a);
                    sg.bigo.ads.core.d.b.a(jElapsedRealtime > 0 ? SystemClock.elapsedRealtime() - jElapsedRealtime : 0L, false, kVarA.f13398a, 4000, "NetError:" + hVar.f13280a + ", " + hVar.getMessage());
                    b.this.a(str, gVar, valueCallback, valueCallback2);
                }
            });
        }
    }

    final boolean a(String str, final ValueCallback<a> valueCallback, ValueCallback<String> valueCallback2) {
        final sg.bigo.ads.controller.a.a.e eVar = this.f13381a.k;
        sg.bigo.ads.common.t.a.a(0, 3, "AntiBan", "[net disk] fetch free svr config, canFetch=" + eVar.a());
        if (!eVar.a()) {
            this.f.set(false);
            return false;
        }
        eVar.b();
        a(str, eVar, new ValueCallback<a>() { // from class: sg.bigo.ads.controller.a.b.7
            @Override // android.webkit.ValueCallback
            public final /* synthetic */ void onReceiveValue(a aVar) {
                eVar.a(true);
                b.this.f13381a.a(0L);
                sg.bigo.ads.common.t.a.a(0, 3, "AntiBan", "[net disk] [saveAsync], fetch third free svr config, onSuccess");
                valueCallback.onReceiveValue(aVar);
            }
        }, valueCallback2);
        return true;
    }
}
