package com.applovin.impl.mediation.ads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.amazon.aps.shared.util.APSSharedUtil;
import com.applovin.impl.b6;
import com.applovin.impl.b8;
import com.applovin.impl.c2;
import com.applovin.impl.c8;
import com.applovin.impl.d8;
import com.applovin.impl.g5;
import com.applovin.impl.i;
import com.applovin.impl.j;
import com.applovin.impl.k7;
import com.applovin.impl.mediation.MaxErrorImpl;
import com.applovin.impl.o0;
import com.applovin.impl.o3;
import com.applovin.impl.p6;
import com.applovin.impl.q2;
import com.applovin.impl.s;
import com.applovin.impl.sdk.f;
import com.applovin.impl.sdk.o;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.v2;
import com.applovin.impl.y2;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxAdViewConfiguration;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.ads.MaxAdView;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes7.dex */
public class MaxAdViewImpl extends com.applovin.impl.mediation.ads.a implements f.a, d8.a, j.b {
    private boolean A;
    private boolean B;
    private boolean C;
    private boolean D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f524a;
    private final MaxAdView b;
    private final String c;
    private final View d;
    private long e;
    private y2 f;
    private String g;
    private String h;
    private final MaxAdViewConfiguration i;
    private final b j;
    private final d k;
    private final f l;
    private final c8 m;
    private final d8 n;
    private final Object o;
    private final Object p;
    private y2 q;
    private MaxAd r;
    private boolean s;
    private boolean t;
    private boolean u;
    private final AtomicBoolean v;
    private boolean w;
    private boolean x;
    private boolean y;
    private boolean z;

    private class b extends c {
        private b() {
            super();
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoadFailed(String str, MaxError maxError) {
            o oVar = MaxAdViewImpl.this.logger;
            if (o.a()) {
                MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
                maxAdViewImpl.logger.a(maxAdViewImpl.tag, "MaxAdListener.onAdLoadFailed(adUnitId=" + str + ", error=" + maxError + "), listener=" + MaxAdViewImpl.this.adListener);
            }
            q2.a(MaxAdViewImpl.this.adListener, str, maxError, true);
            MaxAdViewImpl.this.a(maxError);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoaded(MaxAd maxAd) {
            if (MaxAdViewImpl.this.a()) {
                o oVar = MaxAdViewImpl.this.logger;
                if (o.a()) {
                    MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
                    maxAdViewImpl.logger.a(maxAdViewImpl.tag, "Precache ad with ad unit ID '" + MaxAdViewImpl.this.adUnitId + "' loaded after MaxAdView was destroyed. Destroying the ad.");
                }
                MaxAdViewImpl.this.sdk.X().destroyAd(maxAd);
                return;
            }
            y2 y2Var = (y2) maxAd;
            y2Var.g(MaxAdViewImpl.this.g);
            y2Var.f(MaxAdViewImpl.this.h);
            if (y2Var.y() == null) {
                MaxAdViewImpl.this.sdk.X().destroyAd(y2Var);
                onAdLoadFailed(y2Var.getAdUnitId(), new MaxErrorImpl(-5001, "Ad view not fully loaded"));
                return;
            }
            if (y2Var.q0()) {
                long jL0 = y2Var.l0();
                MaxAdViewImpl.this.sdk.O();
                if (o.a()) {
                    MaxAdViewImpl.this.sdk.O().a(MaxAdViewImpl.this.tag, "Scheduling banner ad refresh " + jL0 + " milliseconds from now for '" + MaxAdViewImpl.this.adUnitId + "'...");
                }
                MaxAdViewImpl.this.l.a(jL0);
                if (MaxAdViewImpl.this.l.g() || MaxAdViewImpl.this.u) {
                    o oVar2 = MaxAdViewImpl.this.logger;
                    if (o.a()) {
                        MaxAdViewImpl maxAdViewImpl2 = MaxAdViewImpl.this;
                        maxAdViewImpl2.logger.a(maxAdViewImpl2.tag, "Pausing ad refresh for publisher");
                    }
                    MaxAdViewImpl.this.l.j();
                }
            }
            o oVar3 = MaxAdViewImpl.this.logger;
            if (o.a()) {
                MaxAdViewImpl maxAdViewImpl3 = MaxAdViewImpl.this;
                maxAdViewImpl3.logger.a(maxAdViewImpl3.tag, "MaxAdListener.onAdLoaded(ad=" + maxAd + "), listener=" + MaxAdViewImpl.this.adListener);
            }
            q2.f(MaxAdViewImpl.this.adListener, maxAd, true);
            MaxAdViewImpl.this.d(y2Var);
        }
    }

    private abstract class c implements MaxAdListener, MaxAdViewAdListener, MaxAdRevenueListener, com.applovin.impl.mediation.ads.a.InterfaceC0135a {
        private c() {
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdClicked(MaxAd maxAd) {
            if (maxAd.equals(MaxAdViewImpl.this.q)) {
                o oVar = MaxAdViewImpl.this.logger;
                if (o.a()) {
                    MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
                    maxAdViewImpl.logger.a(maxAdViewImpl.tag, "MaxAdListener.onAdClicked(ad=" + maxAd + "), listener=" + MaxAdViewImpl.this.adListener);
                }
                q2.a(MaxAdViewImpl.this.adListener, maxAd, true);
            }
        }

        @Override // com.applovin.mediation.MaxAdViewAdListener
        public void onAdCollapsed(MaxAd maxAd) {
            if (maxAd.equals(MaxAdViewImpl.this.r)) {
                MaxAdViewImpl.this.r = null;
                if ((MaxAdViewImpl.this.q.r0() || MaxAdViewImpl.this.B) && MaxAdViewImpl.this.s) {
                    MaxAdViewImpl.this.s = false;
                    MaxAdViewImpl.this.startAutoRefresh();
                }
                o oVar = MaxAdViewImpl.this.logger;
                if (o.a()) {
                    MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
                    maxAdViewImpl.logger.a(maxAdViewImpl.tag, "MaxAdViewAdListener.onAdCollapsed(ad=" + maxAd + "), listener=" + MaxAdViewImpl.this.adListener);
                }
                q2.b(MaxAdViewImpl.this.adListener, maxAd, true);
            }
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
            if (maxAd.equals(MaxAdViewImpl.this.q)) {
                o oVar = MaxAdViewImpl.this.logger;
                if (o.a()) {
                    MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
                    maxAdViewImpl.logger.a(maxAdViewImpl.tag, "MaxAdListener.onAdDisplayFailed(ad=" + maxAd + ", error=" + maxError + "), listener=" + MaxAdViewImpl.this.adListener);
                }
                q2.a(MaxAdViewImpl.this.adListener, maxAd, maxError, true);
            }
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdDisplayed(MaxAd maxAd) {
            if (maxAd.equals(MaxAdViewImpl.this.q)) {
                o oVar = MaxAdViewImpl.this.logger;
                if (o.a()) {
                    MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
                    maxAdViewImpl.logger.a(maxAdViewImpl.tag, "MaxAdListener.onAdDisplayed(ad=" + maxAd + "), listener=" + MaxAdViewImpl.this.adListener);
                }
                q2.c(MaxAdViewImpl.this.adListener, maxAd, true);
            }
        }

        @Override // com.applovin.mediation.MaxAdViewAdListener
        public void onAdExpanded(MaxAd maxAd) {
            if (maxAd.equals(MaxAdViewImpl.this.q)) {
                MaxAdViewImpl.this.r = maxAd;
                if ((MaxAdViewImpl.this.q.r0() || MaxAdViewImpl.this.B) && !MaxAdViewImpl.this.l.g()) {
                    MaxAdViewImpl.this.s = true;
                    MaxAdViewImpl.this.stopAutoRefresh();
                }
                o oVar = MaxAdViewImpl.this.logger;
                if (o.a()) {
                    MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
                    maxAdViewImpl.logger.a(maxAdViewImpl.tag, "MaxAdViewAdListener.onAdExpanded(ad=" + maxAd + "), listener=" + MaxAdViewImpl.this.adListener);
                }
                q2.d(MaxAdViewImpl.this.adListener, maxAd, true);
            }
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdHidden(MaxAd maxAd) {
            if (maxAd.equals(MaxAdViewImpl.this.q)) {
                o oVar = MaxAdViewImpl.this.logger;
                if (o.a()) {
                    MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
                    maxAdViewImpl.logger.a(maxAdViewImpl.tag, "MaxAdListener.onAdHidden(ad=" + maxAd + "), listener=" + MaxAdViewImpl.this.adListener);
                }
                q2.e(MaxAdViewImpl.this.adListener, maxAd, true);
            }
        }

        @Override // com.applovin.mediation.MaxAdRequestListener
        public void onAdRequestStarted(String str) {
            o oVar = MaxAdViewImpl.this.logger;
            if (o.a()) {
                MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
                maxAdViewImpl.logger.a(maxAdViewImpl.tag, "MaxAdRequestListener.onAdRequestStarted(adUnitId=" + str + "), listener=" + MaxAdViewImpl.this.requestListener);
            }
            q2.a(MaxAdViewImpl.this.requestListener, str, true);
        }

        @Override // com.applovin.mediation.MaxAdRevenueListener
        public void onAdRevenuePaid(MaxAd maxAd) {
            o oVar = MaxAdViewImpl.this.logger;
            if (o.a()) {
                MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
                maxAdViewImpl.logger.a(maxAdViewImpl.tag, "MaxAdRevenueListener.onAdRevenuePaid(ad=" + maxAd + "), listener=" + MaxAdViewImpl.this.revenueListener);
            }
            q2.a(MaxAdViewImpl.this.revenueListener, maxAd, true);
        }
    }

    private class d extends c {
        private d() {
            super();
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoadFailed(String str, MaxError maxError) {
            o oVar = MaxAdViewImpl.this.logger;
            if (o.a()) {
                MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
                maxAdViewImpl.logger.a(maxAdViewImpl.tag, "Failed to precache ad for refresh with error code: " + maxError.getCode());
            }
            MaxAdViewImpl.this.a(maxError);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoaded(MaxAd maxAd) {
            if (MaxAdViewImpl.this.x) {
                o oVar = MaxAdViewImpl.this.logger;
                if (o.a()) {
                    MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
                    maxAdViewImpl.logger.a(maxAdViewImpl.tag, "Ad with ad unit ID '" + MaxAdViewImpl.this.adUnitId + "' loaded after MaxAdView was destroyed. Destroying the ad.");
                }
                MaxAdViewImpl.this.sdk.X().destroyAd(maxAd);
                return;
            }
            o oVar2 = MaxAdViewImpl.this.logger;
            if (o.a()) {
                MaxAdViewImpl maxAdViewImpl2 = MaxAdViewImpl.this;
                maxAdViewImpl2.logger.a(maxAdViewImpl2.tag, "Successfully precached ad for refresh");
            }
            if (((Boolean) MaxAdViewImpl.this.sdk.a(o3.y7)).booleanValue()) {
                MaxAdViewImpl.this.b(maxAd);
            } else {
                MaxAdViewImpl.this.a(maxAd);
            }
        }
    }

    public MaxAdViewImpl(String str, MaxAdFormat maxAdFormat, MaxAdViewConfiguration maxAdViewConfiguration, MaxAdView maxAdView, View view, Context context) {
        super(str, maxAdFormat, "MaxAdView", AppLovinSdk.getInstance(context).a());
        this.c = UUID.randomUUID().toString().toLowerCase(Locale.US);
        this.e = Long.MAX_VALUE;
        this.o = new Object();
        this.p = new Object();
        this.q = null;
        this.r = null;
        this.v = new AtomicBoolean();
        this.x = false;
        this.f524a = context.getApplicationContext();
        this.b = maxAdView;
        this.d = view;
        this.j = new b();
        this.k = new d();
        this.l = new f(this.sdk, this);
        this.m = new c8(maxAdView, this.sdk);
        this.n = new d8(maxAdView, this.sdk, this);
        this.i = maxAdViewConfiguration;
        this.sdk.j().a(this);
        if (maxAdViewConfiguration != null && maxAdViewConfiguration.getAdaptiveType() != MaxAdViewConfiguration.AdaptiveType.NONE) {
            setExtraParameter("adaptive_banner", Boolean.toString(true));
            setLocalExtraParameter("adaptive_banner_type", maxAdViewConfiguration.getAdaptiveType().toString());
            int adaptiveWidth = maxAdViewConfiguration.getAdaptiveWidth();
            if (adaptiveWidth > 0) {
                setLocalExtraParameter("adaptive_banner_width", Integer.valueOf(adaptiveWidth));
            }
            int inlineMaximumHeight = maxAdViewConfiguration.getInlineMaximumHeight();
            if (inlineMaximumHeight > 0) {
                setLocalExtraParameter("inline_adaptive_banner_max_height", Integer.valueOf(inlineMaximumHeight));
            }
        }
        if (o.a()) {
            this.logger.a(this.tag, "Created new MaxAdView (" + this + ")");
        }
    }

    @Override // com.applovin.impl.mediation.ads.a
    public void destroy() {
        if (((Boolean) this.sdk.a(o3.z7)).booleanValue()) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.mediation.ads.MaxAdViewImpl$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.g();
                }
            });
        } else {
            g();
        }
    }

    public MaxAdFormat getAdFormat() {
        return this.adFormat;
    }

    public String getPlacement() {
        return this.g;
    }

    public void loadAd() {
        loadAd(i.PUBLISHER_INITIATED);
    }

    @Override // com.applovin.impl.sdk.f.a
    public void onAdRefresh() {
        if (((Boolean) this.sdk.a(o3.y7)).booleanValue()) {
            f();
        } else {
            e();
        }
    }

    @Override // com.applovin.impl.j.b
    public void onCreativeIdGenerated(String str, String str2) {
        y2 y2Var = this.q;
        if (y2Var != null && y2Var.P().equalsIgnoreCase(str)) {
            this.q.h(str2);
            q2.b(this.adReviewListener, str2, this.q);
            return;
        }
        y2 y2Var2 = this.f;
        if (y2Var2 == null || !y2Var2.P().equalsIgnoreCase(str)) {
            return;
        }
        this.f.h(str2);
    }

    @Override // com.applovin.impl.d8.a
    public void onLogVisibilityImpression() {
        a(this.q, this.m.a(this.q));
    }

    public void onWindowVisibilityChanged(int i) {
        if (((Boolean) this.sdk.a(o3.v7)).booleanValue() && this.l.h()) {
            if (b8.b(i)) {
                if (o.a()) {
                    this.logger.a(this.tag, "Ad view visible");
                }
                this.l.d();
            } else {
                if (o.a()) {
                    this.logger.a(this.tag, "Ad view hidden");
                }
                this.l.c();
            }
        }
    }

    public void setCustomData(String str) {
        if (this.q != null && o.a()) {
            this.logger.k(this.tag, "Setting custom data (" + str + ") for Ad Unit ID (" + this.adUnitId + ") after an ad has been loaded already.");
        }
        k7.b(str, this.tag);
        this.h = str;
    }

    @Override // com.applovin.impl.mediation.ads.a
    public void setExtraParameter(String str, String str2) {
        super.setExtraParameter(str, str2);
        a(str, str2);
    }

    public void setPlacement(String str) {
        if (this.q != null && o.a()) {
            this.logger.k(this.tag, "Setting placement (" + str + ") for Ad Unit ID (" + this.adUnitId + ") after an ad has been loaded already.");
        }
        this.g = str;
    }

    public void setPublisherBackgroundColor(int i) {
        this.e = i;
    }

    public void startAutoRefresh() {
        this.u = false;
        if (!this.l.g()) {
            if (o.a()) {
                this.logger.a(this.tag, "Ignoring call to startAutoRefresh() - ad refresh is not paused");
            }
        } else {
            this.l.m();
            if (o.a()) {
                this.logger.a(this.tag, "Resumed auto-refresh with remaining time: " + this.l.b() + "ms");
            }
        }
    }

    public void stopAutoRefresh() {
        if (this.q != null) {
            if (o.a()) {
                this.logger.a(this.tag, "Pausing auto-refresh with remaining time: " + this.l.b() + "ms");
            }
            this.l.j();
        } else if (this.y || ((Boolean) this.sdk.a(o3.x7)).booleanValue()) {
            this.u = true;
        } else {
            o.j(this.tag, "Stopping auto-refresh has no effect until after the first ad has been loaded.");
        }
    }

    public String toString() {
        StringBuilder sbAppend = new StringBuilder("MaxAdView{adUnitId='").append(this.adUnitId).append("', adListener=");
        Object obj = this.adListener;
        if (obj == this.b) {
            obj = "this";
        }
        return sbAppend.append(obj).append(", isDestroyed=").append(a()).append(AbstractJsonLexerKt.END_OBJ).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final y2 y2Var) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.mediation.ads.MaxAdViewImpl$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b(y2Var);
            }
        });
    }

    private void e() {
        this.v.set(false);
        if (this.f != null) {
            i();
            return;
        }
        if (!b()) {
            if (o.a()) {
                this.logger.a(this.tag, "Refreshing ad from network...");
            }
            loadAd(i.REFRESH);
        } else if (this.t) {
            if (o.a()) {
                this.logger.a(this.tag, "Refreshing ad from network due to viewability requirements not met for refresh request...");
            }
            loadAd(i.REFRESH);
        } else {
            if (o.a()) {
                this.logger.b(this.tag, "Ignoring attempt to refresh ad - either still waiting for precache or did not attempt request due to visibility requirement not met");
            }
            this.v.set(true);
        }
    }

    private void f() {
        boolean z;
        boolean z2;
        synchronized (this.p) {
            z = false;
            this.v.set(false);
            z2 = this.f != null;
            if (!z2) {
                if (b()) {
                    if (!this.t) {
                        if (o.a()) {
                            this.logger.b(this.tag, "Ignoring attempt to refresh ad - either still waiting for precache or did not attempt request due to visibility requirement not met");
                        }
                        this.v.set(true);
                    } else if (o.a()) {
                        this.logger.a(this.tag, "Refreshing ad from network due to viewability requirements not met for refresh request...");
                    }
                } else if (o.a()) {
                    this.logger.a(this.tag, "Refreshing ad from network...");
                }
                z = true;
            }
        }
        if (z2) {
            i();
        } else if (z) {
            loadAd(i.REFRESH);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        h();
        if (this.f != null) {
            this.sdk.X().destroyAd(this.f);
        }
        synchronized (this.o) {
            this.x = true;
        }
        this.l.a();
        this.sdk.j().b(this);
        if (this.sdk.R() != null) {
            this.sdk.R().c(this.adUnitId, this.c);
        } else {
            this.sdk.Q().c(this.adUnitId, this.c);
        }
        super.destroy();
    }

    private void h() {
        y2 y2Var;
        MaxAdView maxAdView = this.b;
        if (maxAdView != null) {
            s.a(maxAdView, this.d);
        }
        this.n.b();
        synchronized (this.o) {
            y2Var = this.q;
        }
        MaxAd maxAd = this.r;
        if (maxAd != null && maxAd.equals(y2Var)) {
            if (o.a()) {
                this.logger.a(this.tag, "Collapsing ad manually for removed ad.");
            }
            q2.b(this.j, maxAd);
        }
        if (y2Var != null) {
            this.sdk.X().destroyAd(y2Var);
        }
    }

    private void i() {
        if (o.a()) {
            this.logger.a(this.tag, "Rendering for cached ad: " + this.f + APSSharedUtil.TRUNCATE_SEPARATOR);
        }
        this.j.onAdLoaded(this.f);
        this.f = null;
    }

    public void loadAd(i iVar) {
        if (o.a()) {
            this.logger.a(this.tag, "" + this + " Loading ad for " + this.adUnitId + APSSharedUtil.TRUNCATE_SEPARATOR);
        }
        boolean z = this.y || ((Boolean) this.sdk.a(o3.x7)).booleanValue();
        if (z && !this.l.g() && this.l.h()) {
            o.h(this.tag, "Unable to load a new ad. An ad refresh has already been scheduled in " + TimeUnit.MILLISECONDS.toSeconds(this.l.b()) + " seconds.");
            return;
        }
        if (!z) {
            if (o.a()) {
                this.logger.a(this.tag, "Loading ad...");
            }
            a(iVar, this.j);
        } else if (this.f != null) {
            if (o.a()) {
                this.logger.a(this.tag, "Rendering cached ad");
            }
            i();
        } else if (this.w) {
            if (o.a()) {
                this.logger.a(this.tag, "Waiting for precache ad to load to render");
            }
            this.v.set(true);
        } else {
            if (o.a()) {
                this.logger.a(this.tag, "Loading ad...");
            }
            a(iVar, this.j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(final y2 y2Var) {
        View viewY = y2Var.y();
        String str = viewY == null ? "MaxAdView does not have a loaded ad view" : null;
        MaxAdView maxAdView = this.b;
        if (maxAdView == null) {
            str = "MaxAdView does not have a parent view";
        }
        if (str != null) {
            if (o.a()) {
                this.logger.b(this.tag, str);
            }
            MaxErrorImpl maxErrorImpl = new MaxErrorImpl(-1, str);
            if (o.a()) {
                this.logger.a(this.tag, "MaxAdListener.onAdDisplayFailed(ad=" + y2Var + ", error=" + maxErrorImpl + "), listener=" + this.adListener);
            }
            q2.a(this.adListener, (MaxAd) y2Var, (MaxError) maxErrorImpl, true);
            this.sdk.X().processAdDisplayErrorPostbackForUserError(maxErrorImpl, y2Var);
            return;
        }
        h();
        a((v2) y2Var);
        if (y2Var.k0()) {
            this.n.a(y2Var);
        }
        maxAdView.setDescendantFocusability(393216);
        if (y2Var.m0() != Long.MAX_VALUE) {
            this.d.setBackgroundColor((int) y2Var.m0());
        } else {
            long j = this.e;
            if (j != Long.MAX_VALUE) {
                this.d.setBackgroundColor((int) j);
            } else {
                this.d.setBackgroundColor(0);
            }
        }
        maxAdView.addView(viewY);
        a(viewY, y2Var);
        this.sdk.z().d(y2Var);
        c(y2Var);
        synchronized (this.o) {
            this.q = y2Var;
        }
        if (o.a()) {
            this.logger.a(this.tag, "Scheduling impression for ad manually...");
        }
        this.sdk.X().processRawAdImpression(y2Var, this.j);
        if (StringUtils.isValidString(this.q.getAdReviewCreativeId())) {
            q2.a(this.adReviewListener, this.q.getAdReviewCreativeId(), (MaxAd) this.q, true);
        }
        AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.mediation.ads.MaxAdViewImpl$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(y2Var);
            }
        }, y2Var.o0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c() {
        if (o.a()) {
            this.logger.a(this.tag, "Loading ad for precache request...");
        }
        a(i.SEQUENTIAL_OR_PRECACHE, this.k);
    }

    private void d() {
        if (b()) {
            if (o.a()) {
                this.logger.a(this.tag, "Scheduling refresh precache request now");
            }
            this.w = true;
            this.sdk.r0().a((g5) new p6(this.sdk, "loadMaxAdForPrecacheRequest", new Runnable() { // from class: com.applovin.impl.mediation.ads.MaxAdViewImpl$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.c();
                }
            }), b6.b.MEDIATION);
        }
    }

    private void c(y2 y2Var) {
        int height = this.b.getHeight();
        int width = this.b.getWidth();
        if (height > 0 || width > 0) {
            int iPxToDp = AppLovinSdkUtils.pxToDp(this.f524a, height);
            int iPxToDp2 = AppLovinSdkUtils.pxToDp(this.f524a, width);
            MaxAdFormat format = y2Var.getFormat();
            int height2 = (this.D ? format.getAdaptiveSize(iPxToDp2, this.b.getContext()) : format.getSize()).getHeight();
            int iMin = Math.min(format.getSize().getWidth(), o0.b(this.f524a).x);
            if (iPxToDp < height2 || iPxToDp2 < iMin) {
                String str = "\n**************************************************\n`MaxAdView` size " + iPxToDp2 + VastAttributes.HORIZONTAL_POSITION + iPxToDp + " dp smaller than required " + (this.D ? "adaptive " : "") + "size: " + iMin + VastAttributes.HORIZONTAL_POSITION + height2 + " dp\nSome mediated networks (e.g. Google Ad Manager) may not render correctly\n**************************************************\n";
                if (o.a()) {
                    this.logger.b("AppLovinSdk", str);
                }
            }
        }
    }

    private void a(final i iVar, final com.applovin.impl.mediation.ads.a.InterfaceC0135a interfaceC0135a) {
        if (a()) {
            boolean zC = k7.c(this.sdk);
            this.sdk.E().a(c2.E0, "attemptingToLoadDestroyedAdView", CollectionUtils.hashMap("details", "debug=" + zC));
            if (!zC) {
                o.h(this.tag, "Failed to load new ad - this instance is already destroyed");
                return;
            }
            throw new IllegalStateException("Failed to load new ad - this instance is already destroyed for ad unit ID: " + this.adUnitId);
        }
        AppLovinSdkUtils.runOnUiThread(true, new Runnable() { // from class: com.applovin.impl.mediation.ads.MaxAdViewImpl$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(interfaceC0135a, iVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(com.applovin.impl.mediation.ads.a.InterfaceC0135a interfaceC0135a, i iVar) {
        int adaptiveWidth;
        y2 y2Var = this.q;
        if (y2Var != null) {
            long jA = this.m.a(y2Var);
            this.extraParameters.put("visible_ad_ad_unit_id", this.q.getAdUnitId());
            this.extraParameters.put("viewability_flags", Long.valueOf(jA));
        } else {
            this.extraParameters.remove("visible_ad_ad_unit_id");
            this.extraParameters.remove("viewability_flags");
        }
        int iPxToDp = AppLovinSdkUtils.pxToDp(this.b.getContext(), this.b.getWidth());
        int iPxToDp2 = AppLovinSdkUtils.pxToDp(this.b.getContext(), this.b.getHeight());
        this.extraParameters.put("viewport_width", Integer.valueOf(iPxToDp));
        this.extraParameters.put("viewport_height", Integer.valueOf(iPxToDp2));
        this.extraParameters.put("auto_refresh_stopped", Boolean.valueOf(this.l.g() || this.u));
        this.extraParameters.put("auto_retries_disabled", Boolean.valueOf(this.z));
        MaxAdViewConfiguration maxAdViewConfiguration = this.i;
        if (maxAdViewConfiguration != null && (adaptiveWidth = maxAdViewConfiguration.getAdaptiveWidth()) > 0 && iPxToDp != adaptiveWidth) {
            o.j(this.tag, "The requested adaptive ad view width (" + adaptiveWidth + " dp) is different from the MaxAdView width (" + iPxToDp + " dp).");
        }
        if (o.a()) {
            this.logger.a(this.tag, "Loading " + this.adFormat.getLabel().toLowerCase(Locale.ENGLISH) + " ad for '" + this.adUnitId + "' and notifying " + interfaceC0135a + APSSharedUtil.TRUNCATE_SEPARATOR);
        }
        this.sdk.X().loadAd(this.adUnitId, this.c, this.adFormat, iVar, this.localExtraParameters, this.extraParameters, this.f524a, interfaceC0135a);
    }

    private void a(String str, String str2) {
        if ("allow_pause_auto_refresh_immediately".equalsIgnoreCase(str)) {
            if (o.a()) {
                this.logger.a(this.tag, "Updated allow immediate auto-refresh pause and ad load to: " + str2);
            }
            this.y = Boolean.parseBoolean(str2);
            return;
        }
        if ("disable_auto_retries".equalsIgnoreCase(str)) {
            if (o.a()) {
                this.logger.a(this.tag, "Updated disable auto-retries to: " + str2);
            }
            this.z = Boolean.parseBoolean(str2);
            return;
        }
        if ("disable_precache".equalsIgnoreCase(str)) {
            if (o.a()) {
                this.logger.a(this.tag, "Updated precached disabled to: " + str2);
            }
            this.A = Boolean.parseBoolean(str2);
            return;
        }
        if ("should_stop_auto_refresh_on_ad_expand".equals(str)) {
            if (o.a()) {
                this.logger.a(this.tag, "Updated should stop auto-refresh on ad expand to: " + str2);
            }
            this.B = Boolean.parseBoolean(str2);
        } else if ("force_precache".equals(str)) {
            if (o.a()) {
                this.logger.a(this.tag, "Updated force precache to: " + str2);
            }
            this.C = Boolean.parseBoolean(str2);
        } else if ("adaptive_banner".equalsIgnoreCase(str)) {
            if (o.a()) {
                this.logger.a(this.tag, "Updated is adaptive banner to: " + str2);
            }
            if (this.i == null) {
                o.h(this.tag, "You configured adaptive banners incorrectly by setting extra parameters to the MaxAdView! Please configure adaptive banners via MaxAdViewConfiguration instead. Learn more: https://developers.applovin.com/en/max/android/ad-formats/banner-and-mrec-ads#adaptive-banners");
            }
            this.D = Boolean.parseBoolean(str2);
            setLocalExtraParameter(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(MaxAd maxAd) {
        boolean zCompareAndSet;
        this.w = false;
        synchronized (this.p) {
            zCompareAndSet = this.v.compareAndSet(true, false);
            if (!zCompareAndSet) {
                if (o.a()) {
                    this.logger.a(this.tag, "Saving precache ad...");
                }
                y2 y2Var = (y2) maxAd;
                this.f = y2Var;
                y2Var.g(this.g);
                this.f.f(this.h);
            }
        }
        if (zCompareAndSet) {
            if (o.a()) {
                this.logger.a(this.tag, "Rendering precache request ad: " + maxAd.getAdUnitId() + APSSharedUtil.TRUNCATE_SEPARATOR);
            }
            this.j.onAdLoaded(maxAd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(y2 y2Var) {
        long jA = this.m.a(y2Var);
        if (!y2Var.k0()) {
            a(y2Var, jA);
        }
        a(jA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MaxError maxError) {
        if (a()) {
            if (o.a()) {
                this.logger.a(this.tag, "Ad load failure with ad unit ID '" + this.adUnitId + "' occured after MaxAdView was destroyed.");
                return;
            }
            return;
        }
        if (this.sdk.c(o3.r7).contains(String.valueOf(maxError.getCode()))) {
            this.sdk.O();
            if (o.a()) {
                this.sdk.O().a(this.tag, "Ignoring banner ad refresh for error code " + maxError.getCode());
                return;
            }
            return;
        }
        if (!this.u && !this.l.g()) {
            this.t = true;
            this.w = false;
            long jLongValue = ((Long) this.sdk.a(o3.q7)).longValue();
            if (jLongValue >= 0) {
                this.sdk.O();
                if (o.a()) {
                    this.sdk.O().a(this.tag, "Scheduling failed banner ad refresh " + jLongValue + " milliseconds from now for '" + this.adUnitId + "'...");
                }
                this.l.a(jLongValue);
                return;
            }
            return;
        }
        if (this.w) {
            if (o.a()) {
                this.logger.a(this.tag, "Refresh precache failed when auto-refresh is stopped");
            }
            this.w = false;
        }
        if (this.v.get()) {
            if (o.a()) {
                this.logger.a(this.tag, "Refresh precache failed - MaxAdListener.onAdLoadFailed(adUnitId=" + this.adUnitId + ", error=" + maxError + "), listener=" + this.adListener);
            }
            q2.a(this.adListener, this.adUnitId, maxError, true);
        }
    }

    private boolean b() {
        if (this.A) {
            return false;
        }
        return ((Boolean) this.sdk.a(o3.E7)).booleanValue();
    }

    private void a(View view, y2 y2Var) {
        int iP0 = y2Var.p0();
        int iN0 = y2Var.n0();
        int iDpToPx = iP0 == -1 ? -1 : AppLovinSdkUtils.dpToPx(view.getContext(), iP0);
        int iDpToPx2 = iN0 != -1 ? AppLovinSdkUtils.dpToPx(view.getContext(), iN0) : -1;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(iDpToPx, iDpToPx2);
        } else {
            layoutParams.width = iDpToPx;
            layoutParams.height = iDpToPx2;
        }
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            if (o.a()) {
                this.logger.a(this.tag, "Pinning ad view to MAX ad view with width: " + iDpToPx + " and height: " + iDpToPx2 + ".");
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            for (int i : b8.a(this.b.getGravity(), 10, 14)) {
                layoutParams2.addRule(i);
            }
        }
        view.setLayoutParams(layoutParams);
    }

    private void a(y2 y2Var, long j) {
        if (o.a()) {
            this.logger.a(this.tag, "Scheduling viewability impression for ad...");
        }
        this.sdk.X().processViewabilityAdImpressionPostback(y2Var, j, this.j);
    }

    private void a(long j) {
        if (k7.a(j, ((Long) this.sdk.a(o3.D7)).longValue()) && !this.C) {
            if (o.a()) {
                this.logger.a(this.tag, "Undesired flags matched - current: " + Long.toBinaryString(j) + ", undesired: " + Long.toBinaryString(j));
            }
            if (o.a()) {
                this.logger.a(this.tag, "Waiting for refresh timer to manually fire request");
            }
            this.t = true;
            return;
        }
        if (o.a()) {
            this.logger.a(this.tag, "No undesired viewability flags matched or forcing precache - scheduling viewability");
        }
        this.t = false;
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MaxAd maxAd) {
        this.w = false;
        if (this.v.compareAndSet(true, false)) {
            if (o.a()) {
                this.logger.a(this.tag, "Rendering precache request ad: " + maxAd.getAdUnitId() + APSSharedUtil.TRUNCATE_SEPARATOR);
            }
            this.j.onAdLoaded(maxAd);
        } else {
            if (o.a()) {
                this.logger.a(this.tag, "Saving precache ad...");
            }
            y2 y2Var = (y2) maxAd;
            this.f = y2Var;
            y2Var.g(this.g);
            this.f.f(this.h);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a() {
        boolean z;
        synchronized (this.o) {
            z = this.x;
        }
        return z;
    }
}
