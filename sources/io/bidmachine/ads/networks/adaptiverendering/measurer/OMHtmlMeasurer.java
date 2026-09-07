package io.bidmachine.ads.networks.adaptiverendering.measurer;

import android.view.ViewGroup;
import android.webkit.WebView;
import com.iab.omid.library.appodeal.ScriptInjector;
import com.iab.omid.library.appodeal.adsession.AdEvents;
import com.iab.omid.library.appodeal.adsession.AdSessionConfiguration;
import com.iab.omid.library.appodeal.adsession.AdSessionContext;
import com.iab.omid.library.appodeal.adsession.CreativeType;
import com.iab.omid.library.appodeal.adsession.ImpressionType;
import com.iab.omid.library.appodeal.adsession.Owner;
import com.iab.omid.library.appodeal.adsession.Partner;
import io.bidmachine.core.Logger;
import io.bidmachine.core.Utils;
import io.bidmachine.measurer.OMSDKSettings;
import io.bidmachine.rendering.measurer.HtmlMeasurer;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes9.dex */
public class OMHtmlMeasurer extends OMMeasurer<WebView> implements HtmlMeasurer {
    private static final long DESTROY_DELAY = 1000;
    private final AtomicBoolean isCreativePrepared = new AtomicBoolean(false);

    @Override // io.bidmachine.ads.networks.adaptiverendering.measurer.OMMeasurer
    protected long getDestroyDelayMs() {
        return 1000L;
    }

    @Override // io.bidmachine.rendering.measurer.HtmlMeasurer
    public String prepareCreativeForMeasure(String str) {
        if (!this.isCreativePrepared.compareAndSet(false, true)) {
            return str;
        }
        try {
            return ScriptInjector.injectScriptContentIntoHtml(OMSDKSettings.OM_JS, str);
        } catch (Throwable th) {
            Logger.w(th);
            return str;
        }
    }

    @Override // io.bidmachine.ads.networks.adaptiverendering.measurer.OMMeasurer, io.bidmachine.rendering.measurer.Measurer
    public void onViewReady(WebView webView) {
        startAdSession(webView);
        trackLoaded();
    }

    @Override // io.bidmachine.ads.networks.adaptiverendering.measurer.OMMeasurer, io.bidmachine.rendering.measurer.Measurer
    public void onViewAddedToContainer(WebView webView, ViewGroup viewGroup) {
        registerView(viewGroup);
    }

    @Override // io.bidmachine.ads.networks.adaptiverendering.measurer.OMMeasurer
    protected void onAdLoaded(AdEvents adEvents) throws Throwable {
        adEvents.loaded();
    }

    protected void startAdSession(final WebView webView) {
        Utils.onUiThread(new Runnable() { // from class: io.bidmachine.ads.networks.adaptiverendering.measurer.OMHtmlMeasurer.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Partner partner = OMSDKSettings.getPartner();
                    if (partner != null && !OMHtmlMeasurer.this.isSessionPrepared()) {
                        OMHtmlMeasurer.this.prepareAdSession(AdSessionConfiguration.createAdSessionConfiguration(CreativeType.HTML_DISPLAY, ImpressionType.BEGIN_TO_RENDER, Owner.NATIVE, Owner.NATIVE, false), AdSessionContext.createHtmlAdSessionContext(partner, webView, "", ""));
                    }
                } catch (Throwable th) {
                    Logger.w(th);
                }
            }
        });
    }
}
