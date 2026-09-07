package com.fyber.inneractive.sdk.flow;

import android.app.Activity;
import android.os.SystemClock;
import android.view.View;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.network.C3146w;
import com.fyber.inneractive.sdk.network.EnumC3144u;
import com.fyber.inneractive.sdk.util.C3237a;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.v0;
import com.fyber.inneractive.sdk.util.x0;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public abstract class N extends A implements com.fyber.inneractive.sdk.interfaces.f {
    public com.fyber.inneractive.sdk.interfaces.e k;
    public Runnable l;
    public x0 m;
    public Runnable n;
    public x0 o;
    public long r;
    public K v;
    public boolean p = false;
    public boolean q = false;
    public boolean s = false;
    public boolean t = false;
    public final C3237a u = new C3237a();

    public abstract boolean G();

    public final void H() {
        if (this.l == null) {
            long jK = K();
            this.r = jK;
            this.l = new J(this, jK);
            IAlog.a("%senabling close with delay %d", IAlog.a(this), Long.valueOf(this.r));
            x xVar = this.b;
            boolean zB = xVar != null ? b(xVar) : false;
            if (zB && !G()) {
                if (zB) {
                    com.fyber.inneractive.sdk.interfaces.e eVar = this.k;
                    if (eVar != null) {
                        eVar.showCloseCountdown();
                    }
                    K k = new K(this, this.r + 100);
                    this.v = k;
                    k.start();
                    return;
                }
                return;
            }
            if (this.q) {
                return;
            }
            this.q = true;
            x0 x0Var = new x0(TimeUnit.MILLISECONDS, this.r);
            this.m = x0Var;
            x0Var.e = new L(this);
            v0 v0Var = new v0(x0Var);
            x0Var.c = v0Var;
            x0Var.d = false;
            v0Var.sendEmptyMessage(1932593528);
        }
    }

    public abstract int I();

    public abstract int J();

    public abstract long K();

    public abstract boolean L();

    public abstract long a(long j);

    public void a(com.fyber.inneractive.sdk.interfaces.e eVar, Activity activity) throws InneractiveUnitController.AdDisplayError {
        if (this.f1772a == null) {
            IAlog.f("%sYou must set the spot to render before calling renderAd", IAlog.a(this));
            throw new InneractiveUnitController.AdDisplayError("No spot ad to render");
        }
        if (eVar != null) {
            this.k = eVar;
        } else {
            IAlog.f("%srenderAd called with a null activity!", IAlog.a(this));
            throw new InneractiveUnitController.AdDisplayError("Activity is null");
        }
    }

    @Override // com.fyber.inneractive.sdk.interfaces.f
    public void b(boolean z) {
    }

    public abstract boolean b(x xVar);

    public final void c(boolean z) {
        C3146w c3146w;
        if (this.b == null) {
            EnumC3144u enumC3144u = EnumC3144u.MRAID_CUSTOM_CLOSE_DETECTED;
            c3146w = new C3146w((com.fyber.inneractive.sdk.response.e) null);
            c3146w.c = enumC3144u;
            c3146w.f1934a = null;
            c3146w.d = null;
        } else {
            EnumC3144u enumC3144u2 = EnumC3144u.MRAID_CUSTOM_CLOSE_DETECTED;
            x xVar = this.b;
            InneractiveAdRequest inneractiveAdRequest = xVar.f1840a;
            com.fyber.inneractive.sdk.response.e eVarC = xVar.c();
            JSONArray jSONArrayB = this.b.c.b();
            c3146w = new C3146w(eVarC);
            c3146w.c = enumC3144u2;
            c3146w.f1934a = inneractiveAdRequest;
            c3146w.d = jSONArrayB;
        }
        JSONObject jSONObject = new JSONObject();
        Boolean boolValueOf = Boolean.valueOf(z);
        try {
            jSONObject.put("fyber_close_enabled", boolValueOf);
        } catch (Exception unused) {
            IAlog.f("Got exception adding param to json object: %s, %s", "fyber_close_enabled", boolValueOf);
        }
        c3146w.f.put(jSONObject);
        c3146w.a((String) null);
    }

    public final void d(boolean z) {
        C3146w c3146w;
        this.p = true;
        if (z) {
            if (this.b == null) {
                EnumC3144u enumC3144u = EnumC3144u.FAIL_SAFE_ACTIVATED;
                c3146w = new C3146w((com.fyber.inneractive.sdk.response.e) null);
                c3146w.c = enumC3144u;
                c3146w.f1934a = null;
                c3146w.d = null;
            } else {
                EnumC3144u enumC3144u2 = EnumC3144u.FAIL_SAFE_ACTIVATED;
                x xVar = this.b;
                InneractiveAdRequest inneractiveAdRequest = xVar.f1840a;
                com.fyber.inneractive.sdk.response.e eVarC = xVar.c();
                JSONArray jSONArrayB = this.b.c.b();
                c3146w = new C3146w(eVarC);
                c3146w.c = enumC3144u2;
                c3146w.f1934a = inneractiveAdRequest;
                c3146w.d = jSONArrayB;
            }
            JSONObject jSONObject = new JSONObject();
            Boolean boolValueOf = Boolean.valueOf(L());
            try {
                jSONObject.put("is_endcard", boolValueOf);
            } catch (Exception unused) {
                IAlog.f("Got exception adding param to json object: %s, %s", "is_endcard", boolValueOf);
            }
            c3146w.f.put(jSONObject);
            c3146w.a((String) null);
        }
        com.fyber.inneractive.sdk.interfaces.e eVar = this.k;
        if (eVar != null) {
            eVar.showCloseButton(z, J(), I());
            if (z) {
                return;
            }
            C3237a c3237a = this.u;
            c3237a.d = 0L;
            c3237a.e = 0L;
            c3237a.f = 0L;
            c3237a.b = false;
            c3237a.a(false);
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.A, com.fyber.inneractive.sdk.external.InneractiveAdRenderer
    public void destroy() {
        Runnable runnable = this.l;
        if (runnable != null) {
            com.fyber.inneractive.sdk.util.r.b.removeCallbacks(runnable);
            this.l = null;
        }
        Runnable runnable2 = this.n;
        if (runnable2 != null) {
            com.fyber.inneractive.sdk.util.r.b.removeCallbacks(runnable2);
            this.n = null;
        }
        com.fyber.inneractive.sdk.interfaces.e eVar = this.k;
        if (eVar != null) {
            eVar.destroy();
        }
        this.k = null;
        K k = this.v;
        if (k != null) {
            k.cancel();
            this.v = null;
        }
        x0 x0Var = this.o;
        if (x0Var != null) {
            x0Var.e = null;
            this.o = null;
        }
        x0 x0Var2 = this.m;
        if (x0Var2 != null) {
            x0Var2.e = null;
            this.m = null;
        }
        super.destroy();
    }

    @Override // com.fyber.inneractive.sdk.flow.A, com.fyber.inneractive.sdk.external.InneractiveAdRenderer
    public final void initialize(InneractiveAdSpot inneractiveAdSpot) {
        super.initialize(inneractiveAdSpot);
        this.u.f2356a = inneractiveAdSpot;
    }

    @Override // com.fyber.inneractive.sdk.interfaces.f
    public void m() {
        x0 x0Var = this.m;
        if (x0Var != null) {
            x0Var.d = false;
            x0Var.a(SystemClock.uptimeMillis());
        }
        x0 x0Var2 = this.o;
        if (x0Var2 != null) {
            x0Var2.d = false;
            x0Var2.a(SystemClock.uptimeMillis());
        }
    }

    @Override // com.fyber.inneractive.sdk.interfaces.f
    public void r() {
        x0 x0Var = this.m;
        if (x0Var != null) {
            x0Var.d = true;
            v0 v0Var = x0Var.c;
            if (v0Var != null) {
                v0Var.removeMessages(1932593528);
            }
        }
        x0 x0Var2 = this.o;
        if (x0Var2 != null) {
            x0Var2.d = true;
            v0 v0Var2 = x0Var2.c;
            if (v0Var2 != null) {
                v0Var2.removeMessages(1932593528);
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.A
    public final View x() {
        com.fyber.inneractive.sdk.interfaces.e eVar = this.k;
        if (eVar != null) {
            return eVar.getLayout();
        }
        return null;
    }

    @Override // com.fyber.inneractive.sdk.flow.A
    public final int y() {
        com.fyber.inneractive.sdk.interfaces.e eVar = this.k;
        if (eVar == null || eVar.getLayout() == null) {
            return 1;
        }
        return this.k.getLayout().getHeight();
    }

    @Override // com.fyber.inneractive.sdk.flow.A
    public final int z() {
        com.fyber.inneractive.sdk.interfaces.e eVar = this.k;
        if (eVar == null || eVar.getLayout() == null) {
            return 1;
        }
        return this.k.getLayout().getWidth();
    }

    @Override // com.fyber.inneractive.sdk.interfaces.f
    public boolean b(com.fyber.inneractive.sdk.flow.storepromo.observer.a aVar) {
        IAlog.f("InneractiveFullscreenAdRendererImpl : registerObserver: %s doesnt support Store Promo", getClass().getName());
        return false;
    }

    @Override // com.fyber.inneractive.sdk.interfaces.f
    public void a(com.fyber.inneractive.sdk.flow.storepromo.observer.a aVar) {
        IAlog.f("InneractiveFullscreenAdRendererImpl : unregisterObserver: %s doesnt support Store Promo", getClass().getName());
    }
}
