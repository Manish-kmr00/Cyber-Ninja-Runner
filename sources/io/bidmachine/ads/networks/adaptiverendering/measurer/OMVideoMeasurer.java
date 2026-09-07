package io.bidmachine.ads.networks.adaptiverendering.measurer;

import android.view.View;
import android.view.ViewGroup;
import com.iab.omid.library.appodeal.adsession.AdEvents;
import com.iab.omid.library.appodeal.adsession.AdSessionConfiguration;
import com.iab.omid.library.appodeal.adsession.AdSessionContext;
import com.iab.omid.library.appodeal.adsession.CreativeType;
import com.iab.omid.library.appodeal.adsession.ImpressionType;
import com.iab.omid.library.appodeal.adsession.Owner;
import com.iab.omid.library.appodeal.adsession.Partner;
import com.iab.omid.library.appodeal.adsession.VerificationScriptResource;
import com.iab.omid.library.appodeal.adsession.media.Position;
import com.iab.omid.library.appodeal.adsession.media.VastProperties;
import io.bidmachine.core.Logger;
import io.bidmachine.core.Utils;
import io.bidmachine.measurer.OMSDKSettings;
import io.bidmachine.rendering.measurer.VideoMeasurer;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class OMVideoMeasurer extends OMMeasurer<View> implements VideoMeasurer {
    private static final boolean IS_AUTO_PLAY = true;
    final VastProperties vastProperties;
    final List<VerificationScriptResource> verificationScriptResourceList;

    public OMVideoMeasurer(List<VerificationScriptResource> list, Float f) {
        VastProperties vastPropertiesCreateVastPropertiesForNonSkippableMedia;
        this.verificationScriptResourceList = list;
        if (f != null && f.floatValue() >= 0.0f) {
            vastPropertiesCreateVastPropertiesForNonSkippableMedia = VastProperties.createVastPropertiesForSkippableMedia(f.floatValue(), true, Position.STANDALONE);
        } else {
            vastPropertiesCreateVastPropertiesForNonSkippableMedia = VastProperties.createVastPropertiesForNonSkippableMedia(true, Position.STANDALONE);
        }
        this.vastProperties = vastPropertiesCreateVastPropertiesForNonSkippableMedia;
    }

    @Override // io.bidmachine.ads.networks.adaptiverendering.measurer.OMMeasurer, io.bidmachine.rendering.measurer.Measurer
    public void onViewCreated(View view) {
        startAdSession();
    }

    @Override // io.bidmachine.ads.networks.adaptiverendering.measurer.OMMeasurer, io.bidmachine.rendering.measurer.Measurer
    public void onViewReady(View view) {
        trackLoaded();
    }

    @Override // io.bidmachine.ads.networks.adaptiverendering.measurer.OMMeasurer, io.bidmachine.rendering.measurer.Measurer
    public void onViewAddedToContainer(View view, ViewGroup viewGroup) {
        registerView(viewGroup);
    }

    @Override // io.bidmachine.rendering.measurer.VideoMeasurer
    public void onMediaStarted(final float f, final float f2) {
        Utils.onUiThread(new Runnable() { // from class: io.bidmachine.ads.networks.adaptiverendering.measurer.OMVideoMeasurer.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (OMVideoMeasurer.this.mediaEvents != null) {
                        OMVideoMeasurer.this.mediaEvents.start(f / 1000.0f, f2);
                        OMVideoMeasurer.this.log("onMediaStarted");
                    }
                } catch (Throwable th) {
                    Logger.w(th);
                }
            }
        });
    }

    @Override // io.bidmachine.rendering.measurer.VideoMeasurer
    public void onMediaFirstQuartile() {
        Utils.onUiThread(new Runnable() { // from class: io.bidmachine.ads.networks.adaptiverendering.measurer.OMVideoMeasurer.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (OMVideoMeasurer.this.mediaEvents != null) {
                        OMVideoMeasurer.this.mediaEvents.firstQuartile();
                        OMVideoMeasurer.this.log("onMediaFirstQuartile");
                    }
                } catch (Throwable th) {
                    Logger.w(th);
                }
            }
        });
    }

    @Override // io.bidmachine.rendering.measurer.VideoMeasurer
    public void onMediaMidpoint() {
        Utils.onUiThread(new Runnable() { // from class: io.bidmachine.ads.networks.adaptiverendering.measurer.OMVideoMeasurer.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (OMVideoMeasurer.this.mediaEvents != null) {
                        OMVideoMeasurer.this.mediaEvents.midpoint();
                        OMVideoMeasurer.this.log("onMediaMidpoint");
                    }
                } catch (Throwable th) {
                    Logger.w(th);
                }
            }
        });
    }

    @Override // io.bidmachine.rendering.measurer.VideoMeasurer
    public void onMediaThirdQuartile() {
        Utils.onUiThread(new Runnable() { // from class: io.bidmachine.ads.networks.adaptiverendering.measurer.OMVideoMeasurer.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (OMVideoMeasurer.this.mediaEvents != null) {
                        OMVideoMeasurer.this.mediaEvents.thirdQuartile();
                        OMVideoMeasurer.this.log("onMediaThirdQuartile");
                    }
                } catch (Throwable th) {
                    Logger.w(th);
                }
            }
        });
    }

    @Override // io.bidmachine.rendering.measurer.VideoMeasurer
    public void onMediaCompleted() {
        Utils.onUiThread(new Runnable() { // from class: io.bidmachine.ads.networks.adaptiverendering.measurer.OMVideoMeasurer.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (OMVideoMeasurer.this.mediaEvents != null) {
                        OMVideoMeasurer.this.mediaEvents.complete();
                        OMVideoMeasurer.this.log("onMediaCompleted");
                    }
                } catch (Throwable th) {
                    Logger.w(th);
                }
            }
        });
    }

    @Override // io.bidmachine.rendering.measurer.VideoMeasurer
    public void onMediaPaused() {
        Utils.onUiThread(new Runnable() { // from class: io.bidmachine.ads.networks.adaptiverendering.measurer.OMVideoMeasurer.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (OMVideoMeasurer.this.mediaEvents != null) {
                        OMVideoMeasurer.this.mediaEvents.pause();
                        OMVideoMeasurer.this.log("onMediaPaused");
                    }
                } catch (Throwable th) {
                    Logger.w(th);
                }
            }
        });
    }

    @Override // io.bidmachine.rendering.measurer.VideoMeasurer
    public void onMediaResumed() {
        Utils.onUiThread(new Runnable() { // from class: io.bidmachine.ads.networks.adaptiverendering.measurer.OMVideoMeasurer.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (OMVideoMeasurer.this.mediaEvents != null) {
                        OMVideoMeasurer.this.mediaEvents.resume();
                        OMVideoMeasurer.this.log("onMediaResumed");
                    }
                } catch (Throwable th) {
                    Logger.w(th);
                }
            }
        });
    }

    @Override // io.bidmachine.rendering.measurer.VideoMeasurer
    public void onMediaVolumeChanged(final float f) {
        Utils.onUiThread(new Runnable() { // from class: io.bidmachine.ads.networks.adaptiverendering.measurer.OMVideoMeasurer.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (OMVideoMeasurer.this.mediaEvents != null) {
                        OMVideoMeasurer.this.mediaEvents.volumeChange(f);
                        OMVideoMeasurer.this.log("onMediaVolumeChanged");
                    }
                } catch (Throwable th) {
                    Logger.w(th);
                }
            }
        });
    }

    @Override // io.bidmachine.rendering.measurer.VideoMeasurer
    public void onMediaSkipped() {
        Utils.onUiThread(new Runnable() { // from class: io.bidmachine.ads.networks.adaptiverendering.measurer.OMVideoMeasurer.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (OMVideoMeasurer.this.mediaEvents != null) {
                        OMVideoMeasurer.this.mediaEvents.skipped();
                        OMVideoMeasurer.this.log("onMediaSkipped");
                    }
                } catch (Throwable th) {
                    Logger.w(th);
                }
            }
        });
    }

    @Override // io.bidmachine.ads.networks.adaptiverendering.measurer.OMMeasurer
    protected void onAdLoaded(AdEvents adEvents) throws Throwable {
        adEvents.loaded(this.vastProperties);
    }

    protected void startAdSession() {
        Utils.onUiThread(new Runnable() { // from class: io.bidmachine.ads.networks.adaptiverendering.measurer.OMVideoMeasurer.10
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Partner partner = OMSDKSettings.getPartner();
                    if (partner != null && !OMVideoMeasurer.this.isSessionPrepared()) {
                        OMVideoMeasurer.this.prepareAdSession(AdSessionConfiguration.createAdSessionConfiguration(CreativeType.VIDEO, ImpressionType.BEGIN_TO_RENDER, Owner.NATIVE, Owner.NATIVE, false), AdSessionContext.createNativeAdSessionContext(partner, OMSDKSettings.OM_JS, OMVideoMeasurer.this.verificationScriptResourceList, "", ""));
                    }
                } catch (Throwable th) {
                    Logger.w(th);
                }
            }
        });
    }
}
