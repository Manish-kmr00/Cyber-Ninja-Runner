package io.bidmachine.measurer;

import android.os.Handler;
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
import io.bidmachine.iab.measurer.MraidAdMeasurer;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes13.dex */
public class MraidOMSDKAdMeasurer extends OMSDKAdMeasurer<WebView> implements MraidAdMeasurer {
    private static final long DESTROY_DELAY = 1000;
    private final AtomicBoolean isCreativePrepared;

    public MraidOMSDKAdMeasurer() {
        this(false);
    }

    public MraidOMSDKAdMeasurer(boolean z) {
        super(z);
        this.isCreativePrepared = new AtomicBoolean(false);
    }

    @Override // io.bidmachine.iab.measurer.MraidAdMeasurer
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

    @Override // io.bidmachine.measurer.OMSDKAdMeasurer, io.bidmachine.iab.measurer.AdMeasurer
    public void onAdViewReady(WebView webView) {
        startAdSession(webView);
    }

    protected void startAdSession(final WebView webView) {
        Utils.onUiThread(new Runnable() { // from class: io.bidmachine.measurer.MraidOMSDKAdMeasurer.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Partner partner = OMSDKSettings.getPartner();
                    if (partner != null && !MraidOMSDKAdMeasurer.this.isSessionPrepared()) {
                        MraidOMSDKAdMeasurer.this.prepareAdSession(AdSessionConfiguration.createAdSessionConfiguration(CreativeType.HTML_DISPLAY, ImpressionType.BEGIN_TO_RENDER, Owner.NATIVE, Owner.NATIVE, false), AdSessionContext.createHtmlAdSessionContext(partner, webView, "", ""));
                    }
                } catch (Throwable th) {
                    Logger.w(th);
                }
            }
        });
    }

    @Override // io.bidmachine.measurer.OMSDKAdMeasurer
    protected void onAdLoaded(AdEvents adEvents) throws Throwable {
        adEvents.loaded();
        log("onAdLoaded");
    }

    public void destroy(final Runnable runnable) {
        final Handler handlerCreateHandlerWithMyOrMainLooper = Utils.createHandlerWithMyOrMainLooper();
        Utils.onUiThread(new Runnable() { // from class: io.bidmachine.measurer.MraidOMSDKAdMeasurer.2
            @Override // java.lang.Runnable
            public void run() {
                MraidOMSDKAdMeasurer.this.destroy();
                Runnable runnable2 = runnable;
                if (runnable2 != null) {
                    handlerCreateHandlerWithMyOrMainLooper.postDelayed(runnable2, 1000L);
                }
            }
        });
    }
}
