package com.smaato.sdk.core.mvvm.model.om;

import android.view.View;
import android.webkit.WebView;
import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.openmeasurement.OMImageViewabilityTracker;
import com.smaato.sdk.core.openmeasurement.OMVideoViewabilityTracker;
import com.smaato.sdk.core.openmeasurement.OMWebViewViewabilityTracker;
import com.smaato.sdk.core.openmeasurement.VideoProps;
import com.smaato.sdk.core.openmeasurement.ViewabilityTracker;
import com.smaato.sdk.core.ui.AdContentView;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.fi.Consumer;

/* JADX INFO: loaded from: classes10.dex */
public class OMTrackingRemoteSource {
    private final Logger logger;
    private OMImageViewabilityTracker testOmImageViewabilityTracker;
    private OMWebViewViewabilityTracker testOmWebViewViewabilityTracker;

    public OMTrackingRemoteSource(Logger logger) {
        this.logger = logger;
    }

    public ViewabilityTracker getImageViewabilityTracker(AdContentView adContentView) {
        if (adContentView == null) {
            throw new NullPointerException("'adContentView' specified as non-null is null");
        }
        if (adContentView.getViewabilityVerificationResourcesMap().isEmpty()) {
            return null;
        }
        OMImageViewabilityTracker oMImageViewabilityTracker = this.testOmImageViewabilityTracker;
        if (oMImageViewabilityTracker == null) {
            oMImageViewabilityTracker = new OMImageViewabilityTracker();
        }
        oMImageViewabilityTracker.registerAdView(adContentView.getViewForOmTracking(), adContentView.getViewabilityVerificationResourcesMap());
        oMImageViewabilityTracker.startTracking();
        return oMImageViewabilityTracker;
    }

    public ViewabilityTracker getWebViewViewabilityTracker(AdContentView adContentView) {
        if (adContentView.getViewForOmTracking() instanceof WebView) {
            OMWebViewViewabilityTracker oMWebViewViewabilityTracker = this.testOmWebViewViewabilityTracker;
            if (oMWebViewViewabilityTracker == null) {
                oMWebViewViewabilityTracker = new OMWebViewViewabilityTracker();
            }
            oMWebViewViewabilityTracker.registerAdView((WebView) adContentView.getViewForOmTracking());
            oMWebViewViewabilityTracker.startTracking();
            return oMWebViewViewabilityTracker;
        }
        this.logger.error(LogDomain.CORE, "RichMedia Ad: AdContentView's view for tracking not of type WebView: " + adContentView.getViewForOmTracking(), new Object[0]);
        return null;
    }

    public ViewabilityTracker getOMVideoViewabilityTracker(AdContentView adContentView) {
        OMVideoViewabilityTracker oMVideoViewabilityTracker = new OMVideoViewabilityTracker();
        oMVideoViewabilityTracker.registerAdView(adContentView.getViewForOmTracking(), adContentView.getViewabilityVerificationResourcesMap());
        oMVideoViewabilityTracker.startTracking();
        return oMVideoViewabilityTracker;
    }

    public void trackOMAdLoaded(ViewabilityTracker viewabilityTracker) {
        Objects.onNotNull(viewabilityTracker, new Consumer() { // from class: com.smaato.sdk.core.mvvm.model.om.OMTrackingRemoteSource$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((ViewabilityTracker) obj).trackLoaded();
            }
        });
    }

    public void trackOMImpression(ViewabilityTracker viewabilityTracker) {
        Objects.onNotNull(viewabilityTracker, new Consumer() { // from class: com.smaato.sdk.core.mvvm.model.om.OMTrackingRemoteSource$$ExternalSyntheticLambda2
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((ViewabilityTracker) obj).trackImpression();
            }
        });
    }

    public void trackOMUpdateView(ViewabilityTracker viewabilityTracker, WebView webView) {
        if (viewabilityTracker instanceof OMWebViewViewabilityTracker) {
            ((OMWebViewViewabilityTracker) viewabilityTracker).updateAdView(webView);
        }
    }

    public void stopOMTracking(ViewabilityTracker viewabilityTracker) {
        Objects.onNotNull(viewabilityTracker, new Consumer() { // from class: com.smaato.sdk.core.mvvm.model.om.OMTrackingRemoteSource$$ExternalSyntheticLambda4
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((ViewabilityTracker) obj).stopTracking();
            }
        });
    }

    public void registerFriendlyObstruction(ViewabilityTracker viewabilityTracker, final View view) {
        if (view == null) {
            throw new NullPointerException("'view' specified as non-null is null");
        }
        Objects.onNotNull(viewabilityTracker, new Consumer() { // from class: com.smaato.sdk.core.mvvm.model.om.OMTrackingRemoteSource$$ExternalSyntheticLambda3
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((ViewabilityTracker) obj).registerFriendlyObstruction(view);
            }
        });
    }

    public void removeFriendlyObstruction(ViewabilityTracker viewabilityTracker, final View view) {
        Objects.onNotNull(viewabilityTracker, new Consumer() { // from class: com.smaato.sdk.core.mvvm.model.om.OMTrackingRemoteSource$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((ViewabilityTracker) obj).removeFriendlyObstruction(view);
            }
        });
    }

    public void trackOMVideoPlayerStateChange(ViewabilityTracker viewabilityTracker) {
        if (viewabilityTracker instanceof OMVideoViewabilityTracker) {
            ((OMVideoViewabilityTracker) viewabilityTracker).trackPlayerStateChange();
        }
    }

    public void trackOMVideoPlayerLoaded(ViewabilityTracker viewabilityTracker, VideoProps videoProps) {
        if (viewabilityTracker instanceof OMVideoViewabilityTracker) {
            ((OMVideoViewabilityTracker) viewabilityTracker).trackLoaded(videoProps);
        }
    }

    public void trackVideoClicked(ViewabilityTracker viewabilityTracker) {
        if (viewabilityTracker instanceof OMVideoViewabilityTracker) {
            ((OMVideoViewabilityTracker) viewabilityTracker).trackVideoClicked();
        }
    }

    public void trackVideoStarted(ViewabilityTracker viewabilityTracker, float f, float f2) {
        if (viewabilityTracker instanceof OMVideoViewabilityTracker) {
            ((OMVideoViewabilityTracker) viewabilityTracker).trackStarted(f, f2);
        }
    }

    public void trackVideoFirstQuartileReached(ViewabilityTracker viewabilityTracker) {
        if (viewabilityTracker instanceof OMVideoViewabilityTracker) {
            ((OMVideoViewabilityTracker) viewabilityTracker).trackFirstQuartile();
        }
    }

    public void trackVideoMidpointReached(ViewabilityTracker viewabilityTracker) {
        if (viewabilityTracker instanceof OMVideoViewabilityTracker) {
            ((OMVideoViewabilityTracker) viewabilityTracker).trackMidPoint();
        }
    }

    public void trackVideoThirdQuartileReached(ViewabilityTracker viewabilityTracker) {
        if (viewabilityTracker instanceof OMVideoViewabilityTracker) {
            ((OMVideoViewabilityTracker) viewabilityTracker).trackThirdQuartile();
        }
    }

    public void trackVideoCompleted(ViewabilityTracker viewabilityTracker) {
        if (viewabilityTracker instanceof OMVideoViewabilityTracker) {
            ((OMVideoViewabilityTracker) viewabilityTracker).trackCompleted();
        }
    }

    public void trackVideoPaused(ViewabilityTracker viewabilityTracker) {
        if (viewabilityTracker instanceof OMVideoViewabilityTracker) {
            ((OMVideoViewabilityTracker) viewabilityTracker).trackPaused();
        }
    }

    public void trackVideoResumed(ViewabilityTracker viewabilityTracker) {
        if (viewabilityTracker instanceof OMVideoViewabilityTracker) {
            ((OMVideoViewabilityTracker) viewabilityTracker).trackResumed();
        }
    }

    public void trackMute(ViewabilityTracker viewabilityTracker) {
        if (viewabilityTracker instanceof OMVideoViewabilityTracker) {
            ((OMVideoViewabilityTracker) viewabilityTracker).trackPlayerVolumeChanged(0.0f);
        }
    }

    public void trackUnmute(ViewabilityTracker viewabilityTracker) {
        if (viewabilityTracker instanceof OMVideoViewabilityTracker) {
            ((OMVideoViewabilityTracker) viewabilityTracker).trackPlayerVolumeChanged(1.0f);
        }
    }

    public void trackVideoSkipped(ViewabilityTracker viewabilityTracker) {
        if (viewabilityTracker instanceof OMVideoViewabilityTracker) {
            ((OMVideoViewabilityTracker) viewabilityTracker).trackSkipped();
        }
    }

    public void replaceTrackers(OMImageViewabilityTracker oMImageViewabilityTracker, OMWebViewViewabilityTracker oMWebViewViewabilityTracker) {
        this.testOmImageViewabilityTracker = oMImageViewabilityTracker;
        this.testOmWebViewViewabilityTracker = oMWebViewViewabilityTracker;
    }
}
