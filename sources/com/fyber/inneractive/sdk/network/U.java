package com.fyber.inneractive.sdk.network;

import android.util.Log;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.util.AbstractC3251o;
import com.fyber.inneractive.sdk.util.AbstractC3256u;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes6.dex */
public abstract class U {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f1914a;
    public final E b;
    public final InterfaceC3132h c;
    public P d;
    public C3136l e;
    public volatile i0 f;
    public final String g;
    public final com.fyber.inneractive.sdk.config.global.r h;
    public long i;
    public long j;
    public int k;
    public boolean l;
    public boolean m;
    public final Object n;
    public boolean o;

    public U(E e, InterfaceC3132h interfaceC3132h, com.fyber.inneractive.sdk.config.global.r rVar) {
        this.f1914a = false;
        this.f = i0.INITIAL;
        this.i = 0L;
        this.j = 0L;
        this.k = 0;
        this.l = false;
        this.m = false;
        this.n = new Object();
        this.o = false;
        this.b = e;
        this.c = interfaceC3132h;
        this.g = UUID.randomUUID().toString();
        this.h = rVar;
    }

    public abstract O a(C3136l c3136l, Map map, int i);

    public void a(O o, String str, String str2) {
    }

    public void b(long j) {
        synchronized (this.n) {
            if (this.m) {
                this.k = (int) ((j - this.i) + ((long) this.k));
                this.m = false;
            }
        }
    }

    public void c() {
        boolean z;
        synchronized (this.n) {
            z = this.l;
        }
        if (z) {
            a(System.currentTimeMillis());
        } else if (r()) {
            b(System.currentTimeMillis());
        }
    }

    public byte[] d() {
        return null;
    }

    public abstract int e();

    public String f() {
        return null;
    }

    public C3125a g() {
        return null;
    }

    public int h() {
        return this.k;
    }

    public com.fyber.inneractive.sdk.config.global.r i() {
        return this.h;
    }

    public Map j() {
        return null;
    }

    public abstract M k();

    public String l() {
        return "application/json; charset=utf-8";
    }

    public abstract g0 m();

    public l0 n() {
        IAConfigManager iAConfigManager = IAConfigManager.O;
        return new l0(iAConfigManager.u.b.a("connect_timeout", 5000, 1), iAConfigManager.u.b.a("read_timeout", 5000, 1));
    }

    public int o() {
        int i;
        synchronized (this.n) {
            i = this.k;
        }
        return i;
    }

    public abstract String p();

    public int q() {
        Integer numA;
        com.fyber.inneractive.sdk.config.global.r rVar = this.h;
        if (rVar == null || (numA = ((com.fyber.inneractive.sdk.config.global.features.l) rVar.a(com.fyber.inneractive.sdk.config.global.features.l.class)).a("watchdog_buffer_time_ms")) == null) {
            return 500;
        }
        return numA.intValue();
    }

    public final boolean r() {
        boolean z;
        synchronized (this.n) {
            z = this.m;
        }
        return z;
    }

    public abstract boolean s();

    /* JADX WARN: Code duplicated, block: B:17:0x0035  */
    public final boolean t() {
        boolean z;
        if (!this.o) {
            return false;
        }
        com.fyber.inneractive.sdk.config.global.features.l lVar = (com.fyber.inneractive.sdk.config.global.features.l) IAConfigManager.O.M.a(com.fyber.inneractive.sdk.config.global.features.l.class);
        Boolean boolC = lVar.c("should_add_request_watchdog");
        if (boolC != null ? boolC.booleanValue() : false) {
            z = true;
        } else {
            Boolean boolC2 = lVar.c("should_report_request_watchdog");
            if (boolC2 != null ? boolC2.booleanValue() : false) {
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public C3136l a(String str) throws Exception {
        try {
            P p = this.d;
            if (p != null) {
                p.a("sdkInitNetworkRequest");
            }
            this.e = this.c.a(this, AbstractC3251o.i(), str);
            P p2 = this.d;
            if (p2 != null) {
                p2.a("sdkGotServerResponse");
            }
            return this.e;
        } catch (C3126b e) {
            IAlog.a("failed start network request", e, new Object[0]);
            throw e;
        } catch (q0 e2) {
            IAlog.a("failed read network response", e2, new Object[0]);
            throw e2;
        } catch (Exception e3) {
            IAlog.a("failed start network request", e3, new Object[0]);
            throw e3;
        }
    }

    public void d(long j) {
        synchronized (this.n) {
            if (!this.m) {
                this.m = true;
                this.i = j;
            }
        }
    }

    public void c(long j) {
        synchronized (this.n) {
            if (!this.l) {
                this.l = true;
                this.j = j;
            }
        }
    }

    public final void a(Object obj, Exception exc, boolean z) {
        P p;
        if (!z) {
            i0 i0Var = i0.RESOLVED;
            this.f = i0Var;
            if (i0Var == i0.QUEUED_FOR_RETRY && (p = this.d) != null) {
                p.a("sdkRequestEndedButWillBeRetried");
            }
        }
        com.fyber.inneractive.sdk.util.r.b.post(new T(this, obj, exc, z));
    }

    public final com.fyber.inneractive.sdk.response.e a(int i, InterfaceC3139o interfaceC3139o, com.fyber.inneractive.sdk.response.j jVar, com.fyber.inneractive.sdk.dv.j jVar2) throws N {
        try {
            com.fyber.inneractive.sdk.response.a aVarA = com.fyber.inneractive.sdk.response.a.a(i);
            if (aVarA == null) {
                aVarA = com.fyber.inneractive.sdk.response.a.RETURNED_ADTYPE_MRAID;
            }
            com.fyber.inneractive.sdk.factories.f fVar = com.fyber.inneractive.sdk.factories.d.f1768a;
            com.fyber.inneractive.sdk.factories.e eVar = (com.fyber.inneractive.sdk.factories.e) fVar.f1769a.get(aVarA);
            com.fyber.inneractive.sdk.response.b bVarB = eVar != null ? eVar.b() : null;
            if (bVarB == null) {
                IAlog.f("Received ad type %s does not have an appropriate parser!", Integer.valueOf(i));
                if (fVar.f1769a.size() == 0) {
                    Log.e("Inneractive_error", "Critical error raised while fetching an ad - please make sure you have added all the required fyber libraries (ia-mraid-kit, ia-video-kit) to your project");
                }
                throw new N("Could not find parser for ad type " + i);
            }
            IAlog.a("Received ad type %s - Got parser! %s", Integer.valueOf(i), bVarB);
            if (jVar != null) {
                bVarB.c = jVar;
            }
            bVarB.f2320a = bVarB.a();
            if (interfaceC3139o != null) {
                bVarB.c = new com.fyber.inneractive.sdk.response.k(interfaceC3139o);
            }
            com.fyber.inneractive.sdk.response.e eVarA = bVarB.a(null);
            eVarA.K = h();
            if (jVar2 != null) {
                eVarA.u = jVar2;
            }
            P p = this.d;
            if (p != null) {
                p.a("sdkParsedResponse");
            }
            return eVarA;
        } catch (Exception e) {
            IAlog.a("failed parse ad network request", e, new Object[0]);
            throw new N(e);
        }
    }

    public U(U u) {
        this.f1914a = false;
        this.f = i0.INITIAL;
        this.i = 0L;
        this.j = 0L;
        this.k = 0;
        this.l = false;
        this.m = false;
        this.n = new Object();
        this.o = false;
        this.b = u.b;
        this.c = u.c;
        this.g = UUID.randomUUID().toString();
        this.h = u.h;
        this.k = u.k;
        this.i = u.i;
        this.j = u.j;
    }

    public static int a(Map map) {
        List list = map != null ? (List) map.get("Content-Length") : null;
        if (list != null) {
            return AbstractC3256u.a((String) list.get(0), -1);
        }
        return -1;
    }

    public void a(long j) {
        synchronized (this.n) {
            if (this.l) {
                this.k = (int) ((j - this.j) + ((long) this.k));
                this.l = false;
            }
        }
    }
}
