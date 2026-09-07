package com.json;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.json.environment.ContextProvider;
import com.json.mediationsdk.IronSource;
import com.json.mediationsdk.IronSourceBannerLayout;
import com.json.mediationsdk.adunit.adapter.internal.AdapterBannerInterface;
import com.json.mediationsdk.adunit.adapter.internal.AdapterBindAdViewInterface;
import com.json.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.json.mediationsdk.adunit.adapter.internal.listener.AdapterAdViewListener;
import com.json.mediationsdk.adunit.adapter.listener.BannerAdListener;
import com.json.mediationsdk.adunit.adapter.utility.AdData;
import com.json.mediationsdk.l;
import com.json.mediationsdk.logger.IronLog;
import com.json.mediationsdk.model.Placement;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class k6 extends q7<s1> implements BannerAdListener, d2 {
    public static final String t = "bannerLayout";
    public static final String u = "bannerSize";
    private final IronSourceBannerLayout r;
    private final boolean s;

    class a extends hr {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f3829a;
        final /* synthetic */ FrameLayout.LayoutParams b;

        a(View view, FrameLayout.LayoutParams layoutParams) {
            this.f3829a = view;
            this.b = layoutParams;
        }

        @Override // com.json.hr
        public void a() {
            k6.this.a(this.f3829a, this.b);
        }
    }

    class b extends hr {
        b() {
        }

        @Override // com.json.hr
        public void a() {
            k6.this.J();
        }
    }

    public k6(tp tpVar, m1 m1Var, BaseAdAdapter<?, AdapterAdViewListener> baseAdAdapter, IronSourceBannerLayout ironSourceBannerLayout, Placement placement, boolean z, m5 m5Var, s1 s1Var) {
        super(tpVar, m1Var, baseAdAdapter, new c3(m1Var.g(), m1Var.g().getBannerSettings(), IronSource.AD_UNIT.BANNER), m5Var, s1Var);
        this.r = ironSourceBannerLayout;
        this.g = placement;
        this.s = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(d());
        if (y()) {
            super.onAdOpened();
            return;
        }
        if (this.e == q7.h.FAILED) {
            return;
        }
        ironLog.error(String.format("unexpected onAdOpened for %s, state - %s", k(), this.e));
        if (this.d != null) {
            this.d.k.p(String.format("unexpected onAdOpened, state - %s", this.e));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, FrameLayout.LayoutParams layoutParams) {
        Listener listener;
        super.onAdLoadSuccess();
        if (!y() || (listener = this.b) == 0) {
            return;
        }
        ((s1) listener).a(this, view, layoutParams);
    }

    @Override // com.json.q7
    protected void G() {
        Object obj = this.c;
        if (obj instanceof AdapterBannerInterface) {
            ((AdapterBannerInterface) obj).loadAd(this.k, ContextProvider.getInstance().getCurrentActiveActivity(), this.r.getSize(), this);
        } else {
            IronLog.INTERNAL.error(a("adapter not instance of AdapterBannerInterface"));
        }
    }

    @Override // com.json.q7
    protected boolean O() {
        return false;
    }

    public void P() {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(k());
        a(q7.h.NONE);
        Object obj = this.c;
        if (obj == null) {
            ironLog.warning("mAdapter == null");
            return;
        }
        try {
            if (obj instanceof AdapterBannerInterface) {
                ((AdapterBannerInterface) obj).destroyAd(this.k);
            } else {
                ironLog.error(a("adapter not instance of AdapterBannerInterface"));
            }
        } catch (Throwable th) {
            o9.d().a(th);
            String str = "destroyBanner - exception = " + th.getLocalizedMessage() + " state = " + this.e;
            IronLog.INTERNAL.error(a(str));
            e2 e2Var = this.d;
            if (e2Var != null) {
                e2Var.k.g(str);
            }
        }
        e2 e2Var2 = this.d;
        if (e2Var2 != null) {
            e2Var2.g.a(r().intValue());
        }
    }

    public void Q() {
        Object obj = this.c;
        if (obj instanceof AdapterBindAdViewInterface) {
            ((AdapterBindAdViewInterface) obj).onAdViewBound(this.k);
        }
    }

    public void R() {
        Object obj = this.c;
        if (obj instanceof AdapterBindAdViewInterface) {
            ((AdapterBindAdViewInterface) obj).onAdViewWillBind(this.k);
        }
    }

    @Override // com.json.q7
    protected AdData a(String str, Map<String, Object> map) {
        return new AdData(str, q(), a(map));
    }

    @Override // com.json.q7, com.json.d2
    public Map<String, Object> a(b2 b2Var) {
        Map<String, Object> mapA = super.a(b2Var);
        IronSourceBannerLayout ironSourceBannerLayout = this.r;
        if (ironSourceBannerLayout != null && !ironSourceBannerLayout.isDestroyed()) {
            l.a(mapA, this.r.getSize());
        }
        if (this.g != null) {
            mapA.put("placement", j());
        }
        return mapA;
    }

    @Override // com.json.q7
    protected Map<String, Object> a(Map<String, Object> map) {
        Map<String, Object> mapA = super.a(map);
        m1 m1Var = this.f4187a;
        if (m1Var != null && this.r != null && TextUtils.isEmpty(m1Var.g().getCustomNetwork())) {
            mapA.put("bannerLayout", this.r);
        }
        return mapA;
    }

    @Override // com.json.mediationsdk.adunit.adapter.internal.listener.AdapterAdViewListener
    public void onAdLeftApplication() {
        e2 e2Var;
        Placement placement = this.g;
        if (placement != null && (e2Var = this.d) != null) {
            e2Var.j.f(placement.getPlacementName());
        }
        Listener listener = this.b;
        if (listener != 0) {
            ((s1) listener).d(this);
        }
    }

    @Override // com.json.mediationsdk.adunit.adapter.listener.BannerAdListener, com.json.mediationsdk.adunit.adapter.internal.listener.AdapterAdViewListener
    public void onAdLoadSuccess(View view, FrameLayout.LayoutParams layoutParams) {
        if (u().c()) {
            u().a(new a(view, layoutParams));
        } else {
            a(view, layoutParams);
        }
    }

    @Override // com.json.q7, com.json.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener
    public void onAdOpened() {
        if (u().c()) {
            u().a(new b());
        } else {
            J();
        }
    }

    @Override // com.json.mediationsdk.adunit.adapter.internal.listener.AdapterAdViewListener
    public void onAdScreenDismissed() {
        e2 e2Var;
        Placement placement = this.g;
        if (placement != null && (e2Var = this.d) != null) {
            e2Var.j.c(placement.getPlacementName());
        }
        Listener listener = this.b;
        if (listener != 0) {
            ((s1) listener).c(this);
        }
    }

    @Override // com.json.mediationsdk.adunit.adapter.internal.listener.AdapterAdViewListener
    public void onAdScreenPresented() {
        e2 e2Var;
        Placement placement = this.g;
        if (placement != null && (e2Var = this.d) != null) {
            e2Var.j.h(placement.getPlacementName());
        }
        Listener listener = this.b;
        if (listener != 0) {
            ((s1) listener).a(this);
        }
    }

    @Override // com.json.q7
    protected boolean v() {
        return this.s;
    }
}
