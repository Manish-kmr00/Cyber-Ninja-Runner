package com.smaato.sdk.core.openmeasurement;

import android.util.Log;
import android.webkit.WebView;
import com.iab.omid.library.smaato.Omid;
import com.iab.omid.library.smaato.adsession.AdEvents;
import com.iab.omid.library.smaato.adsession.AdSession;
import com.iab.omid.library.smaato.adsession.AdSessionConfiguration;
import com.iab.omid.library.smaato.adsession.AdSessionContext;
import com.iab.omid.library.smaato.adsession.CreativeType;
import com.iab.omid.library.smaato.adsession.ImpressionType;
import com.iab.omid.library.smaato.adsession.Owner;
import com.smaato.sdk.core.AndroidsInjector;
import com.smaato.sdk.core.util.Threads;

/* JADX INFO: loaded from: classes11.dex */
public class OMWebViewViewabilityTracker extends BaseOMViewabilityTracker {
    public OMWebViewViewabilityTracker() {
        AndroidsInjector.inject(this);
    }

    public void registerAdView(final WebView webView) {
        Threads.runOnUi(new Runnable() { // from class: com.smaato.sdk.core.openmeasurement.OMWebViewViewabilityTracker$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                OMWebViewViewabilityTracker.lambda$registerAdView$0(webView);
            }
        });
        AdSession adSessionCreateAdSession = AdSession.createAdSession(AdSessionConfiguration.createAdSessionConfiguration(CreativeType.HTML_DISPLAY, ImpressionType.BEGIN_TO_RENDER, Owner.NATIVE, Owner.NONE, false), AdSessionContext.createHtmlAdSessionContext(this.partner, webView, "", ""));
        this.adSession = adSessionCreateAdSession;
        adSessionCreateAdSession.registerAdView(webView);
        this.adEvents = AdEvents.createAdEvents(this.adSession);
        Log.i("OMTracker", "OM Viewabiltiy registerAdView");
    }

    static /* synthetic */ void lambda$registerAdView$0(WebView webView) {
        if (Omid.isActive()) {
            return;
        }
        Omid.activate(webView.getContext());
    }

    public void updateAdView(WebView webView) {
        AdSession adSession = this.adSession;
        if (adSession != null) {
            adSession.registerAdView(webView);
        }
    }

    /* JADX INFO: renamed from: lambda$trackImpression$1$com-smaato-sdk-core-openmeasurement-OMWebViewViewabilityTracker, reason: not valid java name */
    /* synthetic */ void m5573x20a909c4() {
        super.trackImpression();
    }

    @Override // com.smaato.sdk.core.openmeasurement.BaseOMViewabilityTracker, com.smaato.sdk.core.openmeasurement.ViewabilityTracker
    public void trackImpression() {
        Threads.scheduleDelayed(500L, new Runnable() { // from class: com.smaato.sdk.core.openmeasurement.OMWebViewViewabilityTracker$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m5573x20a909c4();
            }
        });
    }
}
