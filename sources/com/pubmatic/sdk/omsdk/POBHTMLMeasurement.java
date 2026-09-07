package com.pubmatic.sdk.omsdk;

import android.content.Context;
import android.webkit.WebView;
import com.iab.omid.library.pubmatic.Omid;
import com.iab.omid.library.pubmatic.adsession.AdEvents;
import com.iab.omid.library.pubmatic.adsession.AdSession;
import com.iab.omid.library.pubmatic.adsession.AdSessionConfiguration;
import com.iab.omid.library.pubmatic.adsession.AdSessionContext;
import com.iab.omid.library.pubmatic.adsession.CreativeType;
import com.iab.omid.library.pubmatic.adsession.ImpressionType;
import com.iab.omid.library.pubmatic.adsession.Owner;
import com.iab.omid.library.pubmatic.adsession.Partner;
import com.pubmatic.sdk.common.POBCommonConstants;
import com.pubmatic.sdk.common.log.POBLog;
import com.pubmatic.sdk.common.viewability.POBHTMLMeasurementProvider;

/* JADX INFO: loaded from: classes9.dex */
public class POBHTMLMeasurement extends POBMeasurement implements POBHTMLMeasurementProvider {

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f7708a;

        static {
            int[] iArr = new int[POBHTMLMeasurementProvider.POBHTMLAdEventType.values().length];
            f7708a = iArr;
            try {
                iArr[POBHTMLMeasurementProvider.POBHTMLAdEventType.LOADED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7708a[POBHTMLMeasurementProvider.POBHTMLAdEventType.IMPRESSION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // com.pubmatic.sdk.common.viewability.POBHTMLMeasurementProvider
    public void signalAdEvent(POBHTMLMeasurementProvider.POBHTMLAdEventType pOBHTMLAdEventType) {
        if (this.adEvents == null) {
            POBLog.error(POBOMSDKUtil.TAG, POBOMSDKLogConstants.MSG_OMSDK_UNABLE_SIGNALING_EVENT, pOBHTMLAdEventType.name());
            return;
        }
        try {
            POBLog.info(POBOMSDKUtil.TAG, POBOMSDKLogConstants.MSG_OMSDK_SIGNALING_EVENT, pOBHTMLAdEventType.name());
            int i = a.f7708a[pOBHTMLAdEventType.ordinal()];
            if (i == 1) {
                this.adEvents.loaded();
            } else if (i == 2) {
                this.adEvents.impressionOccurred();
            }
        } catch (Exception unused) {
            POBLog.error(POBOMSDKUtil.TAG, POBOMSDKLogConstants.MSG_OMSDK_UNABLE_SIGNALING_EVENT, pOBHTMLAdEventType.name());
        }
    }

    @Override // com.pubmatic.sdk.common.viewability.POBHTMLMeasurementProvider
    public void startAdSession(WebView webView) {
        try {
            Context applicationContext = webView.getContext().getApplicationContext();
            if (!Omid.isActive()) {
                Omid.activate(applicationContext);
            }
            AdSession adSessionCreateAdSession = AdSession.createAdSession(AdSessionConfiguration.createAdSessionConfiguration(CreativeType.HTML_DISPLAY, ImpressionType.BEGIN_TO_RENDER, Owner.NATIVE, Owner.NONE, false), AdSessionContext.createHtmlAdSessionContext(Partner.createPartner(POBCommonConstants.PARTNER_NAME, "4.5.1"), webView, null, ""));
            this.adSession = adSessionCreateAdSession;
            adSessionCreateAdSession.registerAdView(webView);
            this.adEvents = AdEvents.createAdEvents(this.adSession);
            this.adSession.start();
            POBLog.debug(POBOMSDKUtil.TAG, POBOMSDKLogConstants.MSG_OMSDK_START_SESSION, this.adSession.getAdSessionId());
        } catch (Exception e) {
            POBLog.error(POBOMSDKUtil.TAG, POBOMSDKLogConstants.MSG_OMSDK_UNABLE_START_SESSION, e.getMessage());
        }
    }
}
