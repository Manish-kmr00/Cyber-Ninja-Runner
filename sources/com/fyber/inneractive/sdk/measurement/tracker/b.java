package com.fyber.inneractive.sdk.measurement.tracker;

import android.webkit.WebView;
import com.fyber.inneractive.sdk.flow.x;
import com.fyber.inneractive.sdk.util.Q;
import com.fyber.inneractive.sdk.web.C3274m;
import com.iab.omid.library.fyber.adsession.AdSessionConfiguration;
import com.iab.omid.library.fyber.adsession.CreativeType;
import com.iab.omid.library.fyber.adsession.ImpressionType;
import com.iab.omid.library.fyber.adsession.Owner;
import com.iab.omid.library.fyber.adsession.Partner;
import com.safedk.android.internal.partials.DTExchangeNetworkBridge;

/* JADX INFO: loaded from: classes12.dex */
public final class b extends f {
    public b(Partner partner, C3274m c3274m, x xVar) {
        super(partner, c3274m, xVar);
    }

    @Override // com.fyber.inneractive.sdk.measurement.tracker.f
    public final void a(C3274m c3274m) {
        super.a(c3274m);
        StringBuilder sb = new StringBuilder("javascript:FyberMraidVideoTracker.initOmid(\"");
        sb.append(this.e.getName()).append("\",\"").append(this.e.getVersion());
        sb.append("\");");
        DTExchangeNetworkBridge.webviewLoadUrl(c3274m, sb.toString());
    }

    @Override // com.fyber.inneractive.sdk.measurement.tracker.f
    public final AdSessionConfiguration b() {
        try {
            CreativeType creativeType = CreativeType.DEFINED_BY_JAVASCRIPT;
            ImpressionType impressionType = ImpressionType.DEFINED_BY_JAVASCRIPT;
            Owner owner = Owner.JAVASCRIPT;
            return AdSessionConfiguration.createAdSessionConfiguration(creativeType, impressionType, owner, owner, false);
        } catch (Throwable th) {
            a(th);
            return null;
        }
    }

    @Override // com.fyber.inneractive.sdk.measurement.tracker.f
    public final void c() {
        WebView webView;
        if (this.d || this.f1866a == null || (webView = this.f) == null) {
            return;
        }
        this.d = true;
        Q.a(webView, "FyberMraidVideoTracker.impression();");
    }

    @Override // com.fyber.inneractive.sdk.measurement.tracker.f
    public final void a() {
        WebView webView = this.f;
        if (webView != null) {
            Q.a(webView, "FyberMraidVideoTracker.adUserInteraction();");
        }
    }
}
