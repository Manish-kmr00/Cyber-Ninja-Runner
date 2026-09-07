package com.json;

import android.app.Activity;
import com.json.environment.ContextProvider;
import com.json.m7;
import com.json.mediationsdk.IronSourceSegment;
import com.json.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener;
import com.json.mediationsdk.h;
import com.json.mediationsdk.logger.IronLog;
import com.json.mediationsdk.logger.IronSourceError;
import com.json.mediationsdk.model.Placement;
import com.json.mediationsdk.utils.ErrorBuilder;
import com.json.mediationsdk.utils.IronSourceUtils;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public abstract class l7<Smash extends m7<?>, Listener extends AdapterAdInteractionListener> extends n7<Smash, Listener> implements j2 {

    class a extends hr {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f3850a;
        final /* synthetic */ Placement b;

        a(Activity activity, Placement placement) {
            this.f3850a = activity;
            this.b = placement;
        }

        @Override // com.json.hr
        public void a() {
            l7.this.b(this.f3850a, this.b);
        }
    }

    protected l7(u0 u0Var, qk qkVar, IronSourceSegment ironSourceSegment) {
        super(u0Var, qkVar, ironSourceSegment);
    }

    l7(xf xfVar, wf wfVar, u0 u0Var, qk qkVar, IronSourceSegment ironSourceSegment) {
        super(xfVar, wfVar, u0Var, qkVar, ironSourceSegment);
    }

    private String a(List<Smash> list) {
        StringBuilder sb = new StringBuilder();
        for (Smash smash : list) {
            if (smash.e() != null) {
                sb.append(smash.c()).append(":").append(smash.e()).append(StringUtils.COMMA);
            }
        }
        return sb.toString();
    }

    private void a(Activity activity, m7<?> m7Var, Placement placement) {
        if (this.o.getLoadingData().e()) {
            this.r.a();
        }
        m7Var.a(activity, placement);
    }

    private void a(Smash smash, List<Smash> list) {
        for (Smash smash2 : list) {
            if (smash != null && smash2 == smash) {
                smash.b(true);
                return;
            } else {
                smash2.b(false);
                IronLog.INTERNAL.verbose(b(smash2.k() + " - not ready to show"));
            }
        }
    }

    private void a(IronSourceError ironSourceError, m7<?> m7Var, String str) {
        this.s.j.a(n(), ironSourceError.getErrorCode(), ironSourceError.getErrorMessage(), str);
        this.q.g();
        this.t.a(ironSourceError, m7Var != null ? m7Var.f() : null);
        if (this.o.getLoadingData().e()) {
            b(false);
        }
    }

    private void a(IronSourceError ironSourceError, String str) {
        a(ironSourceError, (m7<?>) null, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(Activity activity, Placement placement) {
        m7 m7Var;
        IronSourceError ironSourceError;
        String strA;
        IronLog.INTERNAL.verbose(b("state = " + this.p));
        synchronized (this.x) {
            this.i = placement;
            this.s.j.a(activity, n());
            n7.f fVar = this.p;
            n7.f fVar2 = n7.f.SHOWING;
            m7Var = null;
            if (fVar == fVar2) {
                ironSourceError = new IronSourceError(a2.g(this.o.getAdUnit()), "can't show ad while an ad is already showing");
            } else if (fVar != n7.f.READY_TO_SHOW) {
                ironSourceError = new IronSourceError(509, "show called while no ads are available");
            } else if (placement == null) {
                ironSourceError = new IronSourceError(a2.b(this.o.getAdUnit()), "empty default placement");
            } else if (this.E.b(ContextProvider.getInstance().getApplicationContext(), placement, this.o.getAdUnit())) {
                ironSourceError = new IronSourceError(a2.f(this.o.getAdUnit()), "placement " + placement.getPlacementName() + " is capped");
            } else {
                ironSourceError = null;
            }
            if (ironSourceError != null) {
                IronLog.API.error(b(ironSourceError.getErrorMessage()));
                strA = "";
            } else {
                List listB = this.f4075a.b();
                fw fwVar = new fw(this.o);
                m7Var = (m7) fwVar.c(listB);
                a(m7Var, (List<m7>) fwVar.b(listB));
                if (m7Var != null) {
                    a(fVar2);
                    i(m7Var);
                } else {
                    ironSourceError = ErrorBuilder.buildNoAdsToShowError(this.o.getAdUnit().toString());
                    strA = a(listB);
                }
            }
            a(ironSourceError, strA);
        }
        if (m7Var != null) {
            a(activity, (m7<?>) m7Var, this.i);
        }
    }

    public void a(Activity activity, Placement placement) {
        if (c()) {
            a(new a(activity, placement));
        } else {
            b(activity, placement);
        }
    }

    @Override // com.json.j2
    public void a(m7<?> m7Var) {
        IronLog.INTERNAL.verbose(b(m7Var.k()));
        if (this.p == n7.f.SHOWING) {
            a(n7.f.READY_TO_LOAD);
        }
        this.q.f();
        this.t.a(m7Var.f());
    }

    @Override // com.json.j2
    public void a(IronSourceError ironSourceError, m7<?> m7Var) {
        IronLog.INTERNAL.verbose(b(m7Var.k() + " - error = " + ironSourceError));
        this.b.put(m7Var.c(), h.a.ISAuctionPerformanceFailedToShow);
        a(n7.f.READY_TO_LOAD);
        a(ironSourceError, m7Var, "");
    }

    @Override // com.json.j2
    public void b(m7<?> m7Var) {
        IronLog.INTERNAL.verbose(b(m7Var.k()));
        this.t.g(m7Var.f());
    }

    @Override // com.json.j2
    public void c(m7<?> m7Var) {
        IronLog.INTERNAL.verbose(b(m7Var.k()));
        this.t.a();
    }

    @Override // com.json.j2
    public String d() {
        StringBuilder sb = new StringBuilder();
        if (this.p == n7.f.READY_TO_SHOW) {
            for (m7 m7Var : this.f4075a.b()) {
                if (m7Var.y()) {
                    sb.append(m7Var.c()).append(";");
                }
            }
        }
        return sb.toString();
    }

    @Override // com.json.j2
    public void d(m7<?> m7Var) {
        IronLog.INTERNAL.verbose(b(m7Var.k()));
        this.t.b();
    }

    @Override // com.json.n7
    public boolean u() {
        if (!x()) {
            return false;
        }
        if (this.j && !IronSourceUtils.isNetworkConnected(ContextProvider.getInstance().getApplicationContext())) {
            return false;
        }
        Iterator it = this.f4075a.b().iterator();
        while (it.hasNext()) {
            if (((m7) it.next()).B()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.json.n7
    protected boolean v() {
        return false;
    }
}
