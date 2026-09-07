package com.fyber.inneractive.sdk.web;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.Rect;
import android.os.Handler;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.util.AbstractC3255t;
import com.fyber.inneractive.sdk.util.AbstractC3256u;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.RunnableC3240d;
import com.fyber.inneractive.sdk.util.RunnableC3241e;
import com.safedk.android.internal.partials.DTExchangeNetworkBridge;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.web.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes13.dex */
public abstract class AbstractC3270i implements InterfaceC3271j, com.fyber.inneractive.sdk.util.M, InterfaceC3273l, Y {
    public C3274m b;
    public J c;
    public K d;
    public InterfaceC3268g f;
    public k0 g;
    public boolean j;
    public final boolean k;
    public InterfaceC3267f l;
    public final RunnableC3265d m;
    public final RunnableC3264c n;
    public C3266e o;
    public String p;
    public String q;
    public InneractiveAdRequest r;
    public com.fyber.inneractive.sdk.flow.x s;
    public com.fyber.inneractive.sdk.response.e t;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f2412a = false;
    public float h = 0.0f;
    public final Rect i = new Rect();
    public final boolean e = false;

    public AbstractC3270i(boolean z, com.fyber.inneractive.sdk.config.global.r rVar) {
        this.k = z;
        this.b = a(rVar);
        j0 j0Var = (j0) this;
        this.n = new RunnableC3264c(j0Var);
        this.m = new RunnableC3265d(j0Var);
    }

    @Override // com.fyber.inneractive.sdk.web.InterfaceC3271j
    public void a(WebView webView) {
    }

    public abstract boolean a(String str, com.fyber.inneractive.sdk.util.h0 h0Var);

    public void b(boolean z) {
        IAlog.a("%s destroy is fatal: %b", IAlog.a(this), Boolean.valueOf(z));
        C3266e c3266e = this.o;
        if (c3266e != null && !c3266e.f2406a.isTerminated() && !c3266e.f2406a.isShutdown()) {
            C3266e c3266e2 = this.o;
            c3266e2.f = true;
            c3266e2.f2406a.shutdownNow();
            Handler handler = c3266e2.b;
            if (handler != null) {
                RunnableC3240d runnableC3240d = c3266e2.d;
                if (runnableC3240d != null) {
                    handler.removeCallbacks(runnableC3240d);
                }
                RunnableC3241e runnableC3241e = c3266e2.c;
                if (runnableC3241e != null) {
                    c3266e2.b.removeCallbacks(runnableC3241e);
                }
                c3266e2.b = null;
            }
            this.o = null;
        }
        C3274m c3274m = this.b;
        if (c3274m != null) {
            com.fyber.inneractive.sdk.util.L.f2347a.a(c3274m);
            AbstractC3256u.a(this.b);
            this.b.setWebChromeClient(null);
            if (f() == null) {
                this.b.destroy();
            } else {
                f().a(z);
            }
        }
        K k = this.d;
        if (k != null) {
            k.e = null;
        }
        RunnableC3264c runnableC3264c = this.n;
        if (runnableC3264c != null) {
            com.fyber.inneractive.sdk.util.r.b.removeCallbacks(runnableC3264c);
        }
        RunnableC3265d runnableC3265d = this.m;
        if (runnableC3265d != null) {
            com.fyber.inneractive.sdk.util.r.b.removeCallbacks(runnableC3265d);
        }
        this.g = null;
        if (!z) {
            this.f = null;
        }
        this.b = null;
        this.c = null;
        this.d = null;
        this.s = null;
        this.r = null;
    }

    @Override // com.fyber.inneractive.sdk.web.InterfaceC3271j
    public void d() {
    }

    public void e() {
        b(false);
    }

    public abstract com.fyber.inneractive.sdk.measurement.tracker.f f();

    public com.fyber.inneractive.sdk.util.h0 g() {
        C3274m c3274m = this.b;
        return c3274m != null ? c3274m.getLastClickedLocation() : new com.fyber.inneractive.sdk.util.h0();
    }

    public void h() {
        WebSettings settings = this.b.getSettings();
        boolean z = true;
        settings.setJavaScriptEnabled(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        if (!IAConfigManager.O.q && AbstractC3255t.a()) {
            settings.setMixedContentMode(2);
        }
        if (this.e) {
            settings.setMediaPlaybackRequiresUserGesture(false);
        }
        C3274m c3274m = this.b;
        c3274m.setHorizontalScrollBarEnabled(false);
        c3274m.setHorizontalScrollbarOverlay(false);
        c3274m.setVerticalScrollBarEnabled(false);
        c3274m.setVerticalScrollbarOverlay(false);
        c3274m.getSettings().setSupportZoom(false);
        this.b.getClass();
        this.b.setFocusable(true);
        this.b.setBackgroundColor(0);
        J j = new J();
        this.c = j;
        this.b.setWebChromeClient(j);
        try {
            Context context = this.b.getContext();
            ApplicationInfo applicationInfo = context != null ? context.getApplicationInfo() : null;
            if (applicationInfo == null || (applicationInfo.flags & 2) == 0) {
                z = false;
            }
            WebView.setWebContentsDebuggingEnabled(z);
        } catch (Exception unused) {
            IAlog.a("Could not set web contents debugging flag", new Object[0]);
        }
        this.b.setListener(this);
    }

    public final void i() {
        IAlog.a("IAWebViewController resetClick()", new Object[0]);
        RunnableC3264c runnableC3264c = this.n;
        if (runnableC3264c != null) {
            com.fyber.inneractive.sdk.util.r.b.removeCallbacks(runnableC3264c);
        }
        RunnableC3265d runnableC3265d = this.m;
        if (runnableC3265d != null) {
            com.fyber.inneractive.sdk.util.r.b.removeCallbacks(runnableC3265d);
        }
        this.j = false;
    }

    public void setAdContent(com.fyber.inneractive.sdk.flow.x xVar) {
        this.s = xVar;
    }

    public void setAdRequest(InneractiveAdRequest inneractiveAdRequest) {
        this.r = inneractiveAdRequest;
    }

    public void setAdResponse(com.fyber.inneractive.sdk.response.e eVar) {
        this.t = eVar;
    }

    public void setListener(k0 k0Var) {
        this.g = k0Var;
    }

    public final void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        C3274m c3274m = this.b;
        if (c3274m != null) {
            if (layoutParams != null) {
                viewGroup.addView(c3274m, layoutParams);
            } else {
                viewGroup.addView(c3274m);
            }
            com.fyber.inneractive.sdk.util.L.f2347a.a(viewGroup.getContext(), this.b, this);
            this.b.setTapListener(this);
        }
    }

    public final C3274m a(com.fyber.inneractive.sdk.config.global.r rVar) {
        boolean z;
        int i;
        int i2;
        int iMax;
        C3274m c3274m = new C3274m();
        if (rVar != null) {
            com.fyber.inneractive.sdk.config.global.features.f fVar = (com.fyber.inneractive.sdk.config.global.features.f) rVar.a(com.fyber.inneractive.sdk.config.global.features.f.class);
            Boolean boolC = fVar.c("agg_res");
            boolean zBooleanValue = boolC != null ? boolC.booleanValue() : false;
            Integer numA = fVar.a("agg_res_ct");
            int iMax2 = Math.max(numA != null ? numA.intValue() : 500, 50);
            Integer numA2 = fVar.a("agg_res_rt");
            int iMax3 = Math.max(numA2 != null ? numA2.intValue() : 500, 50);
            Integer numA3 = fVar.a("agg_res_retries");
            z = zBooleanValue;
            i2 = iMax3;
            iMax = Math.max(numA3 != null ? numA3.intValue() : 2, 1);
            i = iMax2;
        } else {
            z = false;
            i = 500;
            i2 = 500;
            iMax = 2;
        }
        K k = new K(this, z, i, i2, iMax);
        this.d = k;
        c3274m.setWebViewClient(k);
        return c3274m;
    }

    @Override // com.fyber.inneractive.sdk.util.M
    public final void a(float f, Rect rect) {
        if (f == this.h && rect.equals(this.i)) {
            return;
        }
        this.h = f;
        this.i.set(rect);
        C3274m c3274m = this.b;
        if (c3274m != null) {
            c3274m.a();
        }
    }

    @Override // com.fyber.inneractive.sdk.web.InterfaceC3271j
    public boolean a(WebView webView, String str) {
        IAlog.a("%shandleUrl called with: %s", IAlog.a(this), str);
        if (this.b == null) {
            IAlog.a("handleUrl: web view already destroyed. Cannot handle url", new Object[0]);
            return false;
        }
        if (com.fyber.inneractive.sdk.util.k0.a(str)) {
            DTExchangeNetworkBridge.webviewLoadUrl(this.b, "chrome://crash");
            return true;
        }
        if (str != null && str.startsWith("data:")) {
            return false;
        }
        com.fyber.inneractive.sdk.util.h0 h0VarG = g();
        if (a(str, h0VarG)) {
            return true;
        }
        a(new C3269h(this, str, h0VarG));
        return true;
    }

    public void a(boolean z) {
        IAlog.a("%sonWebViewVisibilityChanged called with: %s", IAlog.a(this), Boolean.valueOf(z));
        k0 k0Var = this.g;
        if (k0Var != null) {
            k0Var.a(z);
        }
    }

    @Override // com.fyber.inneractive.sdk.web.InterfaceC3271j
    public void a() {
        k0 k0Var = this.g;
        if (k0Var != null) {
            k0Var.a();
        }
        b(true);
    }

    public final void a(InterfaceC3267f interfaceC3267f) {
        IAlog.e("IAWebViewController Web view click detected", new Object[0]);
        if (this.j) {
            IAlog.e("IAWebViewController Native click detected before web view request. Processing click", new Object[0]);
            interfaceC3267f.d();
            i();
            return;
        }
        if (this.k) {
            IAlog.e("IAWebViewController Native click was not detected yet. Caching click request and waiting", new Object[0]);
            RunnableC3265d runnableC3265d = this.m;
            if (runnableC3265d != null) {
                com.fyber.inneractive.sdk.util.r.b.removeCallbacks(runnableC3265d);
            }
            this.l = interfaceC3267f;
            if (this.m != null) {
                com.fyber.inneractive.sdk.util.r.b.postDelayed(this.m, IAConfigManager.O.u.b.a("click_timeout", 1000, 1000));
                return;
            }
            return;
        }
        RunnableC3265d runnableC3265d2 = this.m;
        if (runnableC3265d2 != null) {
            com.fyber.inneractive.sdk.util.r.b.removeCallbacks(runnableC3265d2);
        }
        this.l = null;
        interfaceC3267f.d();
    }
}
