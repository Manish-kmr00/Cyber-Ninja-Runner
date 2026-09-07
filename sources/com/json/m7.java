package com.json;

import android.app.Activity;
import com.json.j2;
import com.json.mediationsdk.IronSource;
import com.json.mediationsdk.adunit.adapter.internal.AdapterAdFullScreenInterface;
import com.json.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.json.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener;
import com.json.mediationsdk.logger.IronLog;
import com.json.mediationsdk.logger.IronSourceError;
import com.json.mediationsdk.model.Placement;
import java.util.Locale;

/* JADX INFO: loaded from: classes9.dex */
public abstract class m7<Listener extends j2> extends q7<Listener> implements AdapterAdInteractionListener {

    class a extends hr {
        a() {
        }

        @Override // com.json.hr
        public void a() {
            m7.this.P();
        }
    }

    class b extends hr {
        b() {
        }

        @Override // com.json.hr
        public void a() {
            m7.this.S();
        }
    }

    class c extends hr {
        c() {
        }

        @Override // com.json.hr
        public void a() {
            m7.this.Q();
        }
    }

    class d extends hr {
        d() {
        }

        @Override // com.json.hr
        public void a() {
            m7.this.T();
        }
    }

    class e extends hr {
        e() {
        }

        @Override // com.json.hr
        public void a() {
            m7.this.R();
        }
    }

    class f extends hr {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f3915a;
        final /* synthetic */ String b;

        f(int i, String str) {
            this.f3915a = i;
            this.b = str;
        }

        @Override // com.json.hr
        public void a() {
            m7.this.b(this.f3915a, this.b);
        }
    }

    public m7(tp tpVar, m1 m1Var, BaseAdAdapter<?, ?> baseAdAdapter, c3 c3Var, m5 m5Var, Listener listener) {
        super(tpVar, m1Var, baseAdAdapter, c3Var, m5Var, listener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(d());
        synchronized (this.q) {
            if (this.e != q7.h.SHOWING) {
                ironLog.error("unexpected ad closed for " + k() + " - state = " + this.e);
                e2 e2Var = this.d;
                if (e2Var != null) {
                    e2Var.k.k("unexpected ad closed - state = " + this.e);
                }
                return;
            }
            a(q7.h.NONE);
            if (this.d != null) {
                String str = "";
                if (this.f4187a.a() == IronSource.AD_UNIT.REWARDED_VIDEO) {
                    String strD = ((j2) this.b).d();
                    str = "otherInstanceAvailable = " + (strD.length() > 0 ? "true|" + strD : "false");
                }
                this.d.j.a(j(), str);
            }
            ((j2) this.b).a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        IronLog.INTERNAL.verbose(d());
        e2 e2Var = this.d;
        if (e2Var != null) {
            e2Var.j.d(j());
        }
        ((j2) this.b).c(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        IronLog.INTERNAL.verbose(d());
        e2 e2Var = this.d;
        if (e2Var != null) {
            e2Var.j.l(j());
        }
        ((j2) this.b).b((m7<?>) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        IronLog.INTERNAL.verbose(d());
        e2 e2Var = this.d;
        if (e2Var != null) {
            e2Var.j.i(j());
        }
        ((j2) this.b).d(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        IronLog.INTERNAL.verbose(d());
        e2 e2Var = this.d;
        if (e2Var != null) {
            e2Var.j.k(j());
        }
    }

    static String a(q7.h hVar, int i, String str) {
        return String.format(Locale.ENGLISH, "unexpected show failed, state - %s, error - %d %s", hVar, Integer.valueOf(i), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, String str) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(a("error = " + i + ", " + str));
        q7.h hVar = this.e;
        if (hVar == q7.h.SHOWING) {
            a(q7.h.FAILED);
            e2 e2Var = this.d;
            if (e2Var != null) {
                e2Var.j.a(j(), i, str, "");
            }
            ((j2) this.b).a(new IronSourceError(i, str), (m7<?>) this);
            return;
        }
        String strA = a(hVar, i, str);
        ironLog.error(a(strA));
        e2 e2Var2 = this.d;
        if (e2Var2 != null) {
            e2Var2.k.s(strA);
        }
    }

    @Override // com.json.q7
    public boolean B() {
        if (this.k == null || !y()) {
            return false;
        }
        try {
            Object obj = this.c;
            if (obj instanceof AdapterAdFullScreenInterface) {
                return ((AdapterAdFullScreenInterface) obj).isAdAvailable(this.k);
            }
            IronLog.INTERNAL.error(a("isReadyToShow - adapter not instance of AdapterAdFullScreenInterface"));
            e2 e2Var = this.d;
            if (e2Var != null) {
                e2Var.k.g("isReadyToShow - adapter not instance of AdapterAdFullScreenInterface");
            }
            return false;
        } catch (Throwable th) {
            o9.d().a(th);
            String str = "isReadyToShow - exception = " + th.getMessage() + " - state = " + this.e;
            IronLog.INTERNAL.error(a(str));
            e2 e2Var2 = this.d;
            if (e2Var2 != null) {
                e2Var2.k.g(str);
            }
        }
    }

    public void a(Activity activity, Placement placement) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(a("placementName = " + placement.getPlacementName()));
        try {
            this.g = placement;
            a(q7.h.SHOWING);
            this.d.j.a(activity, j());
            Object obj = this.c;
            if (obj instanceof AdapterAdFullScreenInterface) {
                ((AdapterAdFullScreenInterface) obj).showAd(this.k, this);
            } else {
                ironLog.error(a("showAd - adapter not instance of AdapterAdFullScreenInterface"));
                e2 e2Var = this.d;
                if (e2Var != null) {
                    e2Var.k.g("showAd - adapter not instance of AdapterAdFullScreenInterface");
                }
            }
        } catch (Throwable th) {
            o9.d().a(th);
            a(q7.h.FAILED);
            String str = "showAd - exception = " + th.getMessage() + " - state = " + this.e;
            IronLog.INTERNAL.error(a(str));
            e2 e2Var2 = this.d;
            if (e2Var2 != null) {
                e2Var2.k.g(str);
            }
            onAdShowFailed(a2.h(this.f4187a.a()), str);
        }
    }

    public void b(boolean z) {
        e2 e2Var = this.d;
        if (e2Var != null) {
            e2Var.j.a(z);
        }
    }

    @Override // com.json.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener
    public void onAdClosed() {
        if (u().c()) {
            u().a(new a());
        } else {
            P();
        }
    }

    @Override // com.json.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener
    public void onAdEnded() {
        if (u().c()) {
            u().a(new c());
        } else {
            Q();
        }
    }

    @Override // com.json.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener
    public void onAdShowFailed(int i, String str) {
        if (u().c()) {
            u().a(new f(i, str));
        } else {
            b(i, str);
        }
    }

    @Override // com.json.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener
    public void onAdShowSuccess() {
        if (u().c()) {
            u().a(new e());
        } else {
            R();
        }
    }

    @Override // com.json.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener
    public void onAdStarted() {
        if (u().c()) {
            u().a(new b());
        } else {
            S();
        }
    }

    @Override // com.json.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener
    public void onAdVisible() {
        if (u().c()) {
            u().a(new d());
        } else {
            T();
        }
    }
}
