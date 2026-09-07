package io.bidmachine.ads.networks.adaptiverendering.measurer;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import com.iab.omid.library.appodeal.adsession.AdEvents;
import com.iab.omid.library.appodeal.adsession.AdSession;
import com.iab.omid.library.appodeal.adsession.AdSessionConfiguration;
import com.iab.omid.library.appodeal.adsession.AdSessionContext;
import com.iab.omid.library.appodeal.adsession.ErrorType;
import com.iab.omid.library.appodeal.adsession.media.InteractionType;
import com.iab.omid.library.appodeal.adsession.media.MediaEvents;
import com.json.nu;
import io.bidmachine.core.Logger;
import io.bidmachine.core.Utils;
import io.bidmachine.rendering.measurer.Measurer;
import io.bidmachine.rendering.model.Error;
import io.bidmachine.utils.Tag;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes12.dex */
public abstract class OMMeasurer<AdView extends View> implements Measurer<AdView> {
    private AdEvents adEvents;
    private AdSession adSession;
    protected MediaEvents mediaEvents;
    private final Tag tag = new Tag("OMMeasurer");
    private final AtomicBoolean isLoadedTracked = new AtomicBoolean(false);
    private final AtomicBoolean isShownTracked = new AtomicBoolean(false);

    protected long getDestroyDelayMs() {
        return 0L;
    }

    protected abstract void onAdLoaded(AdEvents adEvents) throws Throwable;

    @Override // io.bidmachine.rendering.measurer.Measurer
    public void onViewAddedToContainer(AdView adview, ViewGroup viewGroup) {
    }

    @Override // io.bidmachine.rendering.measurer.Measurer
    public void onViewCreated(AdView adview) {
    }

    @Override // io.bidmachine.rendering.measurer.Measurer
    public void onViewReady(AdView adview) {
    }

    @Override // io.bidmachine.rendering.measurer.Measurer
    public void onShown() {
        if (this.isShownTracked.compareAndSet(false, true)) {
            Utils.onUiThread(new Runnable() { // from class: io.bidmachine.ads.networks.adaptiverendering.measurer.OMMeasurer.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (!OMMeasurer.this.isSessionPrepared() || OMMeasurer.this.adEvents == null) {
                            return;
                        }
                        OMMeasurer.this.adEvents.impressionOccurred();
                        OMMeasurer.this.log("onAdShown");
                    } catch (Throwable th) {
                        Logger.w(th);
                    }
                }
            });
        }
    }

    @Override // io.bidmachine.rendering.measurer.Measurer
    public void onClicked() {
        Utils.onUiThread(new Runnable() { // from class: io.bidmachine.ads.networks.adaptiverendering.measurer.OMMeasurer.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (OMMeasurer.this.mediaEvents != null) {
                        OMMeasurer.this.mediaEvents.adUserInteraction(InteractionType.CLICK);
                        OMMeasurer.this.log(nu.f);
                    }
                } catch (Throwable th) {
                    Logger.w(th);
                }
            }
        });
    }

    @Override // io.bidmachine.rendering.measurer.Measurer
    public void onError(Error error) {
        trackError(error.getMessage());
    }

    @Override // io.bidmachine.rendering.measurer.Measurer
    public void destroy(final Runnable runnable) {
        final Handler handlerCreateHandlerWithMyOrMainLooper = Utils.createHandlerWithMyOrMainLooper();
        Utils.onUiThread(new Runnable() { // from class: io.bidmachine.ads.networks.adaptiverendering.measurer.OMMeasurer.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    OMMeasurer.this.mediaEvents = null;
                    OMMeasurer.this.adEvents = null;
                    if (OMMeasurer.this.adSession != null) {
                        OMMeasurer.this.adSession.finish();
                    }
                    OMMeasurer.this.log("destroy");
                    Runnable runnable2 = runnable;
                    if (runnable2 != null) {
                        handlerCreateHandlerWithMyOrMainLooper.postDelayed(runnable2, OMMeasurer.this.getDestroyDelayMs());
                    }
                } catch (Throwable th) {
                    Logger.w(th);
                }
            }
        });
    }

    protected void trackLoaded() {
        if (this.isLoadedTracked.compareAndSet(false, true)) {
            Utils.onUiThread(new Runnable() { // from class: io.bidmachine.ads.networks.adaptiverendering.measurer.OMMeasurer.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (!OMMeasurer.this.isSessionPrepared() || OMMeasurer.this.adEvents == null) {
                            return;
                        }
                        OMMeasurer oMMeasurer = OMMeasurer.this;
                        oMMeasurer.onAdLoaded(oMMeasurer.adEvents);
                        OMMeasurer.this.log("onAdLoaded");
                    } catch (Throwable th) {
                        Logger.w(th);
                    }
                }
            });
        }
    }

    public void trackError(String str) {
        trackError(ErrorType.GENERIC, str);
    }

    public void trackVideoError(String str) {
        trackError(ErrorType.VIDEO, str);
    }

    private void trackError(final ErrorType errorType, final String str) {
        Utils.onUiThread(new Runnable() { // from class: io.bidmachine.ads.networks.adaptiverendering.measurer.OMMeasurer.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (OMMeasurer.this.adSession != null) {
                        OMMeasurer.this.adSession.error(errorType, str);
                        OMMeasurer.this.log("error");
                    }
                } catch (Throwable th) {
                    Logger.w(th);
                }
            }
        });
    }

    protected boolean isSessionPrepared() {
        return this.adSession != null;
    }

    protected void log(String str) {
        Logger.d(this.tag, str);
    }

    protected void prepareAdSession(AdSessionConfiguration adSessionConfiguration, AdSessionContext adSessionContext) {
        try {
            AdSession adSessionCreateAdSession = AdSession.createAdSession(adSessionConfiguration, adSessionContext);
            this.adSession = adSessionCreateAdSession;
            this.adEvents = AdEvents.createAdEvents(adSessionCreateAdSession);
            if (adSessionConfiguration.isNativeMediaEventsOwner()) {
                this.mediaEvents = MediaEvents.createMediaEvents(this.adSession);
            }
            this.adSession.start();
            log("prepareAdSession");
        } catch (Throwable th) {
            Logger.w(th);
        }
    }

    protected void registerView(final View view) {
        Utils.onUiThread(new Runnable() { // from class: io.bidmachine.ads.networks.adaptiverendering.measurer.OMMeasurer.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (OMMeasurer.this.adSession != null) {
                        OMMeasurer.this.adSession.registerAdView(view);
                        OMMeasurer.this.log("registerView");
                    }
                } catch (Throwable th) {
                    Logger.w(th);
                }
            }
        });
    }
}
