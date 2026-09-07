package io.bidmachine.measurer;

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
import io.bidmachine.iab.IabError;
import io.bidmachine.iab.measurer.AdMeasurer;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes9.dex */
public abstract class OMSDKAdMeasurer<AdView extends View> implements AdMeasurer<AdView> {
    private static final String TAG = "AdMeasurer";
    private AdEvents adEvents;
    private AdSession adSession;
    private WeakReference<View> adViewWeak;
    private final AtomicBoolean isShownTracked;
    private final boolean isTrackShownOutside;
    private MediaEvents mediaEvents;

    protected abstract void onAdLoaded(AdEvents adEvents) throws Throwable;

    @Override // io.bidmachine.iab.measurer.AdMeasurer
    public void onAdViewReady(AdView adview) {
    }

    @Override // io.bidmachine.iab.measurer.AdMeasurer
    public void registerAdView(AdView adview) {
    }

    public OMSDKAdMeasurer() {
        this(false);
    }

    public OMSDKAdMeasurer(boolean z) {
        this.isTrackShownOutside = z;
        this.isShownTracked = new AtomicBoolean(false);
    }

    @Override // io.bidmachine.iab.measurer.AdMeasurer
    public void registerAdContainer(final ViewGroup viewGroup) {
        Utils.onUiThread(new Runnable() { // from class: io.bidmachine.measurer.OMSDKAdMeasurer.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (OMSDKAdMeasurer.this.adSession != null) {
                        OMSDKAdMeasurer oMSDKAdMeasurer = OMSDKAdMeasurer.this;
                        oMSDKAdMeasurer.registerAdView(oMSDKAdMeasurer.adSession, viewGroup);
                    } else {
                        OMSDKAdMeasurer.this.adViewWeak = new WeakReference(viewGroup);
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

    protected void prepareAdSession(AdSessionConfiguration adSessionConfiguration, AdSessionContext adSessionContext) {
        try {
            AdSession adSessionCreateAdSession = AdSession.createAdSession(adSessionConfiguration, adSessionContext);
            this.adSession = adSessionCreateAdSession;
            this.adEvents = AdEvents.createAdEvents(adSessionCreateAdSession);
            if (adSessionConfiguration.isNativeMediaEventsOwner()) {
                this.mediaEvents = MediaEvents.createMediaEvents(this.adSession);
            }
            registerViews(this.adSession);
            this.adSession.start();
            onAdLoaded(this.adEvents);
            log("prepareAdSession");
        } catch (Throwable th) {
            Logger.w(th);
        }
    }

    private void registerViews(AdSession adSession) throws Throwable {
        WeakReference<View> weakReference = this.adViewWeak;
        View view = weakReference != null ? weakReference.get() : null;
        if (view != null) {
            registerAdView(adSession, view);
        }
        this.adViewWeak = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerAdView(AdSession adSession, View view) throws Throwable {
        adSession.registerAdView(view);
        log("registerAdView");
    }

    @Override // io.bidmachine.iab.measurer.AdMeasurer
    public void onAdShown() {
        if (this.isTrackShownOutside) {
            return;
        }
        trackShown();
    }

    public void trackShown() {
        if (this.isShownTracked.compareAndSet(false, true)) {
            Utils.onUiThread(new Runnable() { // from class: io.bidmachine.measurer.OMSDKAdMeasurer.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (OMSDKAdMeasurer.this.adEvents != null) {
                            OMSDKAdMeasurer.this.adEvents.impressionOccurred();
                            OMSDKAdMeasurer.this.log("onAdShown");
                        }
                    } catch (Throwable th) {
                        Logger.w(th);
                    }
                }
            });
        }
    }

    @Override // io.bidmachine.iab.measurer.AdMeasurer
    public void onAdClicked() {
        Utils.onUiThread(new Runnable() { // from class: io.bidmachine.measurer.OMSDKAdMeasurer.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (OMSDKAdMeasurer.this.mediaEvents != null) {
                        OMSDKAdMeasurer.this.mediaEvents.adUserInteraction(InteractionType.CLICK);
                        OMSDKAdMeasurer.this.log(nu.f);
                    }
                } catch (Throwable th) {
                    Logger.w(th);
                }
            }
        });
    }

    @Override // io.bidmachine.iab.measurer.AdMeasurer
    public void onError(IabError iabError) {
        error(iabError.getMessage());
    }

    public void onMediaStarted(final float f, final float f2) {
        Utils.onUiThread(new Runnable() { // from class: io.bidmachine.measurer.OMSDKAdMeasurer.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (OMSDKAdMeasurer.this.mediaEvents != null) {
                        OMSDKAdMeasurer.this.mediaEvents.start(f / 1000.0f, f2);
                        OMSDKAdMeasurer.this.log("onMediaStarted");
                    }
                } catch (Throwable th) {
                    Logger.w(th);
                }
            }
        });
    }

    public void onMediaFirstQuartile() {
        Utils.onUiThread(new Runnable() { // from class: io.bidmachine.measurer.OMSDKAdMeasurer.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (OMSDKAdMeasurer.this.mediaEvents != null) {
                        OMSDKAdMeasurer.this.mediaEvents.firstQuartile();
                        OMSDKAdMeasurer.this.log("onMediaFirstQuartile");
                    }
                } catch (Throwable th) {
                    Logger.w(th);
                }
            }
        });
    }

    public void onMediaMidpoint() {
        Utils.onUiThread(new Runnable() { // from class: io.bidmachine.measurer.OMSDKAdMeasurer.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (OMSDKAdMeasurer.this.mediaEvents != null) {
                        OMSDKAdMeasurer.this.mediaEvents.midpoint();
                        OMSDKAdMeasurer.this.log("onMediaMidpoint");
                    }
                } catch (Throwable th) {
                    Logger.w(th);
                }
            }
        });
    }

    public void onMediaThirdQuartile() {
        Utils.onUiThread(new Runnable() { // from class: io.bidmachine.measurer.OMSDKAdMeasurer.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (OMSDKAdMeasurer.this.mediaEvents != null) {
                        OMSDKAdMeasurer.this.mediaEvents.thirdQuartile();
                        OMSDKAdMeasurer.this.log("onMediaThirdQuartile");
                    }
                } catch (Throwable th) {
                    Logger.w(th);
                }
            }
        });
    }

    public void onMediaCompleted() {
        Utils.onUiThread(new Runnable() { // from class: io.bidmachine.measurer.OMSDKAdMeasurer.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (OMSDKAdMeasurer.this.mediaEvents != null) {
                        OMSDKAdMeasurer.this.mediaEvents.complete();
                        OMSDKAdMeasurer.this.log("onMediaCompleted");
                    }
                } catch (Throwable th) {
                    Logger.w(th);
                }
            }
        });
    }

    public void onMediaPaused() {
        Utils.onUiThread(new Runnable() { // from class: io.bidmachine.measurer.OMSDKAdMeasurer.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (OMSDKAdMeasurer.this.mediaEvents != null) {
                        OMSDKAdMeasurer.this.mediaEvents.pause();
                        OMSDKAdMeasurer.this.log("onMediaPaused");
                    }
                } catch (Throwable th) {
                    Logger.w(th);
                }
            }
        });
    }

    public void onMediaResumed() {
        Utils.onUiThread(new Runnable() { // from class: io.bidmachine.measurer.OMSDKAdMeasurer.10
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (OMSDKAdMeasurer.this.mediaEvents != null) {
                        OMSDKAdMeasurer.this.mediaEvents.resume();
                        OMSDKAdMeasurer.this.log("onMediaResumed");
                    }
                } catch (Throwable th) {
                    Logger.w(th);
                }
            }
        });
    }

    public void onMediaVolumeChanged(final float f) {
        Utils.onUiThread(new Runnable() { // from class: io.bidmachine.measurer.OMSDKAdMeasurer.11
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (OMSDKAdMeasurer.this.mediaEvents != null) {
                        OMSDKAdMeasurer.this.mediaEvents.volumeChange(f);
                        OMSDKAdMeasurer.this.log("onMediaVolumeChanged");
                    }
                } catch (Throwable th) {
                    Logger.w(th);
                }
            }
        });
    }

    public void onMediaSkipped() {
        Utils.onUiThread(new Runnable() { // from class: io.bidmachine.measurer.OMSDKAdMeasurer.12
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (OMSDKAdMeasurer.this.mediaEvents != null) {
                        OMSDKAdMeasurer.this.mediaEvents.skipped();
                        OMSDKAdMeasurer.this.log("onMediaSkipped");
                    }
                } catch (Throwable th) {
                    Logger.w(th);
                }
            }
        });
    }

    public void destroy() {
        Utils.onUiThread(new Runnable() { // from class: io.bidmachine.measurer.OMSDKAdMeasurer.13
            @Override // java.lang.Runnable
            public void run() {
                try {
                    OMSDKAdMeasurer.this.mediaEvents = null;
                    OMSDKAdMeasurer.this.adEvents = null;
                    if (OMSDKAdMeasurer.this.adSession != null) {
                        OMSDKAdMeasurer.this.adSession.finish();
                    }
                    OMSDKAdMeasurer.this.log("destroy");
                } catch (Throwable th) {
                    Logger.w(th);
                }
            }
        });
    }

    public void error(String str) {
        error(ErrorType.GENERIC, str);
    }

    public void videoError(String str) {
        error(ErrorType.VIDEO, str);
    }

    private void error(final ErrorType errorType, final String str) {
        Utils.onUiThread(new Runnable() { // from class: io.bidmachine.measurer.OMSDKAdMeasurer.14
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (OMSDKAdMeasurer.this.adSession != null) {
                        OMSDKAdMeasurer.this.adSession.error(errorType, str);
                        OMSDKAdMeasurer.this.log("error");
                    }
                } catch (Throwable th) {
                    Logger.w(th);
                }
            }
        });
    }

    protected void log(String str) {
        Logger.d(TAG, str);
    }
}
