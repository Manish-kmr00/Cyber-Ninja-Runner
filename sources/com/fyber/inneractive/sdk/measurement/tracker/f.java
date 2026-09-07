package com.fyber.inneractive.sdk.measurement.tracker;

import android.webkit.WebView;
import com.fyber.inneractive.sdk.flow.x;
import com.fyber.inneractive.sdk.network.AbstractC3149z;
import com.fyber.inneractive.sdk.util.r;
import com.fyber.inneractive.sdk.web.C3274m;
import com.iab.omid.library.fyber.adsession.AdEvents;
import com.iab.omid.library.fyber.adsession.AdSession;
import com.iab.omid.library.fyber.adsession.AdSessionConfiguration;
import com.iab.omid.library.fyber.adsession.AdSessionContext;
import com.iab.omid.library.fyber.adsession.Partner;
import com.iab.omid.library.fyber.publisher.AdSessionStatePublisher;

/* JADX INFO: loaded from: classes12.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AdSession f1866a;
    public AdEvents b;
    public final x c;
    public final Partner e;
    public WebView f;
    public boolean d = false;
    public final c g = new c(this);

    public f(Partner partner, C3274m c3274m, x xVar) {
        this.e = partner;
        this.f = c3274m;
        this.c = xVar;
    }

    public abstract void a();

    public final void a(Throwable th) {
        String str = "OpenMeasurementTracker - " + th.getMessage();
        String simpleName = th.getClass().getSimpleName();
        x xVar = this.c;
        AbstractC3149z.a(simpleName, str, xVar != null ? xVar.f1840a : null, xVar != null ? xVar.c() : null);
    }

    public abstract AdSessionConfiguration b();

    public abstract void c();

    public final void a(boolean z) {
        AdSession adSession = this.f1866a;
        if (adSession != null) {
            try {
                adSession.finish();
            } catch (Throwable th) {
                a(th);
            }
            r.b.postDelayed(new d(this), z ? 0 : 1000);
            this.f1866a = null;
            this.b = null;
        }
    }

    public void a(C3274m c3274m) {
        AdSessionContext adSessionContextCreateHtmlAdSessionContext;
        WebView webView;
        try {
            AdSessionConfiguration adSessionConfigurationB = b();
            try {
                adSessionContextCreateHtmlAdSessionContext = AdSessionContext.createHtmlAdSessionContext(this.e, c3274m, "", "");
            } catch (Throwable th) {
                a(th);
                adSessionContextCreateHtmlAdSessionContext = null;
            }
            AdSession adSessionCreateAdSession = AdSession.createAdSession(adSessionConfigurationB, adSessionContextCreateHtmlAdSessionContext);
            this.f1866a = adSessionCreateAdSession;
            AdSessionStatePublisher adSessionStatePublisher = adSessionCreateAdSession.getAdSessionStatePublisher();
            if (adSessionStatePublisher != null && (webView = adSessionStatePublisher.getWebView()) != null && webView != c3274m) {
                webView.setWebViewClient(this.g);
            }
            this.f1866a.registerAdView(c3274m);
            this.f1866a.start();
        } catch (Throwable th2) {
            a(th2);
        }
    }
}
