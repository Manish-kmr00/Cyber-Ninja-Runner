package com.json;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.json.environment.ContextProvider;
import com.json.mediationsdk.AdapterUtils;
import com.json.mediationsdk.ISBannerSize;
import com.json.mediationsdk.IronSource;
import com.json.mediationsdk.IronSourceBannerLayout;
import com.json.mediationsdk.IronSourceSegment;
import com.json.mediationsdk.LoadWhileShowSupportState;
import com.json.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.json.mediationsdk.adunit.adapter.internal.AdapterSettingsInterface;
import com.json.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.json.mediationsdk.adunit.adapter.internal.listener.AdapterAdViewListener;
import com.json.mediationsdk.adunit.adapter.utility.AdData;
import com.json.mediationsdk.i;
import com.json.mediationsdk.l;
import com.json.mediationsdk.logger.IronLog;
import com.json.mediationsdk.logger.IronSourceError;
import com.json.mediationsdk.model.NetworkSettings;
import com.json.mediationsdk.model.Placement;
import com.json.mediationsdk.n;
import com.json.mediationsdk.utils.IronSourceConstants;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class g6 extends n7<k6, AdapterAdViewListener> implements s1, f6 {
    private a7 K;
    private boolean L;
    private IronSourceBannerLayout M;
    private View N;
    private q7<?> O;
    private FrameLayout.LayoutParams P;
    private final AtomicBoolean Q;
    private final AtomicBoolean R;

    class a implements b8 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ q7 f3713a;

        a(q7 q7Var) {
            this.f3713a = q7Var;
        }

        @Override // com.json.b8
        public void a() {
            ((k6) this.f3713a).Q();
        }
    }

    class b implements b8 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ q7 f3714a;

        b(q7 q7Var) {
            this.f3714a = q7Var;
        }

        @Override // com.json.b8
        public void a() {
            ((k6) this.f3714a).Q();
            g6 g6Var = g6.this;
            g6Var.s.j.j(g6Var.n());
            g6.this.Q.set(false);
            g6.this.W();
            IronLog.INTERNAL.verbose("start binding timer after impression, expected interval = " + g6.this.o.getLoadingData().b() + ", current timestamp = " + System.currentTimeMillis());
            g6.this.O().h();
        }
    }

    static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3715a;

        static {
            int[] iArr = new int[o2.a.values().length];
            f3715a = iArr;
            try {
                iArr[o2.a.MANUAL_WITH_AUTOMATIC_RELOAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3715a[o2.a.MANUAL_WITH_LOAD_ON_SHOW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public g6(List<NetworkSettings> list, u6 u6Var, String str, qk qkVar, IronSourceSegment ironSourceSegment) {
        super(new h6(str, list, u6Var), qkVar, ironSourceSegment);
        this.L = false;
        this.Q = new AtomicBoolean(true);
        this.R = new AtomicBoolean(false);
        this.K = N();
    }

    private void M() {
        int i = c.f3715a[this.q.b().a().ordinal()];
        if (i == 1) {
            P().a();
        } else {
            if (i != 2) {
                return;
            }
            P().l();
            P().m();
            O().a();
            O().b();
        }
    }

    private a7 N() {
        return new a7(this.o.getLoadingData(), this.o.getInteractionData(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a7 O() {
        return this.K;
    }

    private g7 P() {
        return (g7) this.q;
    }

    private ISBannerSize Q() {
        IronSourceBannerLayout ironSourceBannerLayout = this.M;
        if (ironSourceBannerLayout == null || ironSourceBannerLayout.getSize() == null) {
            return null;
        }
        if (this.M.getSize().isSmart()) {
            return AdapterUtils.isLargeScreen(ContextProvider.getInstance().getApplicationContext()) ? l.a() : ISBannerSize.BANNER;
        }
        return this.M.getSize();
    }

    private boolean S() {
        IronLog.INTERNAL.verbose(b(this.N + ", " + this.P + ", " + this.O));
        return (this.N == null || this.P == null || this.O == null) ? false : true;
    }

    private void U() {
        int i = c.f3715a[this.q.b().a().ordinal()];
        if (i == 1) {
            P().k();
        } else {
            if (i != 2) {
                return;
            }
            P().r();
        }
    }

    private void V() {
        int i = c.f3715a[this.q.b().a().ordinal()];
        if (i == 1) {
            P().k();
        } else {
            if (i != 2) {
                return;
            }
            P().q();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W() {
        this.O = null;
        this.N = null;
        this.P = null;
    }

    private void b(q7<?> q7Var, View view, FrameLayout.LayoutParams layoutParams) {
        ((k6) q7Var).R();
        l.a(this.M, view, layoutParams, new a(q7Var));
    }

    private void c(q7<?> q7Var, View view, FrameLayout.LayoutParams layoutParams) {
        if (!a(n7.f.READY_TO_SHOW, n7.f.SHOWING)) {
            IronLog.INTERNAL.verbose("wrong state = " + this.p);
            return;
        }
        this.R.set(false);
        O().e();
        ((k6) q7Var).R();
        l.a(this.M, view, layoutParams, new b(q7Var));
    }

    boolean R() {
        IronLog ironLog;
        String str;
        if (!this.M.isShown()) {
            ironLog = IronLog.INTERNAL;
            str = "banner or one of its parents are INVISIBLE or GONE";
        } else {
            if (this.M.hasWindowFocus()) {
                boolean globalVisibleRect = this.M.getGlobalVisibleRect(new Rect());
                IronLog.INTERNAL.verbose("visible = " + globalVisibleRect);
                return globalVisibleRect;
            }
            ironLog = IronLog.INTERNAL;
            str = "banner has no window focus";
        }
        ironLog.verbose(str);
        return false;
    }

    public void T() {
        IronSourceBannerLayout ironSourceBannerLayout = this.M;
        if (ironSourceBannerLayout != null) {
            a(ironSourceBannerLayout);
        }
    }

    @Override // com.json.n7
    protected LoadWhileShowSupportState a(NetworkSettings networkSettings, AdapterBaseInterface adapterBaseInterface) {
        return ((AdapterSettingsInterface) adapterBaseInterface).getBannerLoadWhileShowSupportedState(networkSettings);
    }

    @Override // com.json.n7
    protected AdData a(NetworkSettings networkSettings, String str) {
        return AdData.createAdDataForNetworkAdapter(b(networkSettings), this.o.getAdUnit(), str, this.M);
    }

    @Override // com.json.n7
    protected /* bridge */ /* synthetic */ q7 a(NetworkSettings networkSettings, BaseAdAdapter baseAdAdapter, int i, String str, m5 m5Var) {
        return b(networkSettings, (BaseAdAdapter<?, AdapterAdViewListener>) baseAdAdapter, i, str, m5Var);
    }

    @Override // com.json.n7, com.json.d2
    public Map<String, Object> a(b2 b2Var) {
        Map<String, Object> mapA = super.a(b2Var);
        if (b(this.M)) {
            l.a(mapA, this.M.getSize());
        }
        if (this.i != null) {
            mapA.put("placement", n());
        }
        return mapA;
    }

    @Override // com.json.n7
    protected void a(int i, String str, boolean z) {
        if (!v()) {
            super.a(i, str, z);
            return;
        }
        if (!z) {
            this.s.g.a(ib.a(this.n), i, str);
            n.a().b(this.o.getAdUnit(), new IronSourceError(i, str));
        }
        if (v()) {
            a(n7.f.SHOWING);
            V();
        }
    }

    @Override // com.json.n7
    protected void a(Context context, i iVar, s4 s4Var) {
        if (this.c == null) {
            IronLog.INTERNAL.error(b("mAuctionHandler is null"));
        } else {
            iVar.a(Q());
            this.c.a(context, iVar, s4Var);
        }
    }

    public void a(IronSourceBannerLayout ironSourceBannerLayout) {
        try {
            if (!b(ironSourceBannerLayout)) {
                IronLog.API.error("destroy banner failed - errorMessage = " + String.format("can't destroy banner - %s", ironSourceBannerLayout == null ? "banner is null" : "banner is destroyed"));
                return;
            }
            IronLog.INTERNAL.verbose("destroying banner");
            M();
            k6 k6Var = (k6) this.f4075a.d();
            if (k6Var != null) {
                this.s.g.a(k6Var.r() != null ? k6Var.r().intValue() : this.C.a(this.o.getAdUnit()));
                k6Var.P();
                this.f4075a.a(null);
                this.f4075a.b(null);
            }
            l.a(ironSourceBannerLayout);
            this.M = null;
            this.i = null;
            this.L = false;
            if (P().o()) {
                this.Q.set(true);
                this.R.set(false);
                W();
            }
            a(n7.f.READY_TO_LOAD);
        } catch (Throwable th) {
            o9.d().a(th);
            String str = "destroyBanner - exception = " + th.getLocalizedMessage() + " state = " + this.p;
            IronLog.INTERNAL.error(b(str));
            e2 e2Var = this.s;
            if (e2Var != null) {
                e2Var.k.g(str);
            }
        }
    }

    public void a(IronSourceBannerLayout ironSourceBannerLayout, Placement placement) {
        String str;
        IronLog.INTERNAL.verbose("placement = " + placement);
        int iB = 510;
        if (!b(ironSourceBannerLayout)) {
            str = String.format("can't load banner - %s", ironSourceBannerLayout == null ? "banner is null" : "banner is destroyed");
        } else if (placement == null || TextUtils.isEmpty(placement.getPlacementName())) {
            str = String.format("can't load banner - %s", placement == null ? "placement is null" : "placement name is empty");
            iB = a2.b(this.o.getAdUnit());
        } else if (this.E.b(ContextProvider.getInstance().getApplicationContext(), placement, this.o.getAdUnit())) {
            str = String.format("placement %s is capped", placement.getPlacementName());
            iB = a2.f(this.o.getAdUnit());
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            IronLog.API.error(b(str));
            a(iB, str, false);
        } else {
            l.b(ironSourceBannerLayout);
            this.M = ironSourceBannerLayout;
            this.i = placement;
            A();
        }
    }

    @Override // com.json.u2
    public void a(q7<?> q7Var) {
        IronLog.INTERNAL.verbose(b(q7Var.k()));
        this.t.f(q7Var.f());
    }

    @Override // com.json.s1
    public void a(q7<?> q7Var, View view, FrameLayout.LayoutParams layoutParams) {
        IronLog.INTERNAL.verbose("mState = " + this.p);
        super.e(q7Var);
        if (this.o.getLoadingData().a() == o2.a.MANUAL_WITH_AUTOMATIC_RELOAD) {
            if (!a(n7.f.READY_TO_SHOW, n7.f.SHOWING)) {
                return;
            }
            this.f4075a.a(q7Var);
            this.f4075a.b(q7Var);
            b(q7Var, view, layoutParams);
            P().k();
        } else {
            if (!P().o()) {
                return;
            }
            this.f4075a.b(q7Var);
            if (this.Q.get()) {
                c(q7Var, view, layoutParams);
            } else {
                this.O = q7Var;
                this.N = view;
                this.P = layoutParams;
            }
        }
        this.t.c(q7Var.f());
    }

    protected k6 b(NetworkSettings networkSettings, BaseAdAdapter<?, AdapterAdViewListener> baseAdAdapter, int i, String str, m5 m5Var) {
        return new k6(this, new m1(IronSource.AD_UNIT.BANNER, this.o.getUserId(), i, this.g, str, this.e, this.f, networkSettings, this.o.getSmashLoadTimeout()), baseAdAdapter, this.M, this.i, v(), m5Var, this);
    }

    @Override // com.json.n7
    protected JSONObject b(NetworkSettings networkSettings) {
        return networkSettings.getBannerSettings();
    }

    @Override // com.json.n7, com.json.fm
    public void b() {
        boolean z;
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(i());
        try {
            if (this.M == null) {
                ironLog.error("mIronSourceBanner is null");
                this.s.g.b(IronSourceError.ERROR_BN_RELOAD_SKIP_BANNER_LAYOUT_IS_NULL);
                return;
            }
            if (!R()) {
                if (this.o.getLoadingData().a() == o2.a.MANUAL_WITH_AUTOMATIC_RELOAD) {
                    ironLog.verbose("banner is not visible, reload skipped");
                    this.s.g.b(613);
                }
                U();
                return;
            }
            synchronized (this.x) {
                if (a(n7.f.SHOWING, n7.f.READY_TO_LOAD)) {
                    ironLog.verbose("start reload");
                    z = true;
                    this.L = true;
                } else {
                    ironLog.error("wrong state = " + this.p);
                    z = false;
                }
            }
            if (z) {
                a(this.M, this.i);
            }
        } catch (Throwable th) {
            o9.d().a(th);
            this.s.k.c(th.getMessage());
        }
    }

    @Override // com.json.n7, com.json.r2
    public void b(q7<?> q7Var) {
        super.b(q7Var);
        if (P().o()) {
            if (!this.R.compareAndSet(false, true)) {
                IronLog.INTERNAL.verbose("Impression already recorded as receive, it can occur from network onAdOpened or from impression timeout timer - loading next ad already in progress");
            } else {
                O().b();
                U();
            }
        }
    }

    boolean b(IronSourceBannerLayout ironSourceBannerLayout) {
        return (ironSourceBannerLayout == null || ironSourceBannerLayout.isDestroyed()) ? false : true;
    }

    @Override // com.json.u2
    public void c(q7<?> q7Var) {
        IronLog.INTERNAL.verbose(b(q7Var.k()));
        this.t.e(q7Var.f());
    }

    @Override // com.json.u2
    public void d(q7<?> q7Var) {
        IronLog.INTERNAL.verbose(b(q7Var.k()));
        this.t.b(q7Var.f());
    }

    @Override // com.json.f6
    public void e() {
        if (!R()) {
            IronLog.INTERNAL.verbose("banner is not visible, binding skipped");
            O().h();
            this.s.g.b(IronSourceError.ERROR_BN_BINDING_SKIP_INVISIBLE);
        } else if (S()) {
            IronLog.INTERNAL.verbose("done binding timer, binding view now, current timestamp = " + System.currentTimeMillis());
            c(this.O, this.N, this.P);
        } else {
            IronLog.INTERNAL.verbose("Cannot bind banner view after interval, the next ad is not ready yet");
            this.Q.set(true);
        }
    }

    @Override // com.json.f6
    public void f() {
        if (!R()) {
            IronLog.INTERNAL.verbose("banner is not visible, starting the impression timeout timer again");
            O().e();
        } else if (this.R.compareAndSet(false, true)) {
            IronLog.INTERNAL.verbose("banner impression timeout reached, reloading banner manually");
            U();
            this.s.k.b("banner impression timeout reached, reloading banner manually");
        }
    }

    @Override // com.json.n7
    protected l2 g() {
        return new b7();
    }

    @Override // com.json.n7
    protected void g(q7<?> q7Var) {
    }

    @Override // com.json.n7
    protected q2 h() {
        return new g7(this.o.getLoadingData(), this);
    }

    @Override // com.json.n7
    protected void h(q7<?> q7Var) {
    }

    @Override // com.json.n7
    protected String l() {
        return "BN";
    }

    @Override // com.json.n7
    protected String o() {
        return IronSourceConstants.OPW_BN_MANAGER_NAME;
    }

    @Override // com.json.n7
    protected boolean v() {
        return this.L;
    }
}
