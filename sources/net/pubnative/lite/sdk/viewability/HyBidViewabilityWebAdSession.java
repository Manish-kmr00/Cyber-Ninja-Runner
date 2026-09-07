package net.pubnative.lite.sdk.viewability;

import android.webkit.WebView;
import com.iab.omid.library.pubnativenet.adsession.AdSession;
import com.iab.omid.library.pubnativenet.adsession.AdSessionConfiguration;
import com.iab.omid.library.pubnativenet.adsession.AdSessionContext;
import com.iab.omid.library.pubnativenet.adsession.CreativeType;
import com.iab.omid.library.pubnativenet.adsession.ImpressionType;
import com.iab.omid.library.pubnativenet.adsession.Owner;
import net.pubnative.lite.sdk.utils.Logger;

/* JADX INFO: loaded from: classes12.dex */
public class HyBidViewabilityWebAdSession extends HyBidViewabilityAdSession {
    private static final String TAG = "HyBidViewabilityWebAdSession";

    public HyBidViewabilityWebAdSession(ViewabilityManager viewabilityManager) {
        super(viewabilityManager);
    }

    public void initAdSession(WebView webView, boolean z) {
        if (this.viewabilityManager.isViewabilityMeasurementEnabled()) {
            try {
                AdSessionContext adSessionContextCreateHtmlAdSessionContext = AdSessionContext.createHtmlAdSessionContext(this.viewabilityManager.getPartner(), webView, "", "");
                Owner owner = z ? Owner.JAVASCRIPT : Owner.NATIVE;
                this.mAdSession = AdSession.createAdSession(AdSessionConfiguration.createAdSessionConfiguration(z ? CreativeType.DEFINED_BY_JAVASCRIPT : CreativeType.HTML_DISPLAY, z ? ImpressionType.DEFINED_BY_JAVASCRIPT : ImpressionType.BEGIN_TO_RENDER, owner, z ? owner : Owner.NONE, false), adSessionContextCreateHtmlAdSessionContext);
                this.mAdSession.registerAdView(webView);
                createAdEvents();
                this.mAdSession.start();
            } catch (IllegalArgumentException e) {
                Logger.e("", e.getMessage());
            } catch (NullPointerException e2) {
                Logger.e(TAG, "OM SDK Ad Session - Exception", e2);
            }
        }
    }
}
