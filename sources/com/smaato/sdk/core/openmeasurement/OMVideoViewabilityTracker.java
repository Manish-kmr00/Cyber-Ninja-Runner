package com.smaato.sdk.core.openmeasurement;

import android.util.Log;
import android.view.View;
import com.iab.omid.library.smaato.Omid;
import com.iab.omid.library.smaato.adsession.AdEvents;
import com.iab.omid.library.smaato.adsession.AdSession;
import com.iab.omid.library.smaato.adsession.AdSessionConfiguration;
import com.iab.omid.library.smaato.adsession.AdSessionContext;
import com.iab.omid.library.smaato.adsession.CreativeType;
import com.iab.omid.library.smaato.adsession.ImpressionType;
import com.iab.omid.library.smaato.adsession.Owner;
import com.iab.omid.library.smaato.adsession.Partner;
import com.iab.omid.library.smaato.adsession.media.InteractionType;
import com.iab.omid.library.smaato.adsession.media.MediaEvents;
import com.iab.omid.library.smaato.adsession.media.PlayerState;
import com.iab.omid.library.smaato.adsession.media.Position;
import com.iab.omid.library.smaato.adsession.media.VastProperties;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.smaato.sdk.core.AndroidsInjector;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.Threads;
import com.smaato.sdk.core.util.diinjection.Inject;
import com.smaato.sdk.core.util.fi.Consumer;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class OMVideoViewabilityTracker extends BaseOMViewabilityTracker {

    @Inject
    private OMVideoResourceMapper resourceMapper;
    private MediaEvents videoEvents;

    public OMVideoViewabilityTracker() {
        AndroidsInjector.inject(this);
    }

    public void registerAdView(final View view, Map<String, List<ViewabilityVerificationResource>> map) {
        Threads.runOnUi(new Runnable() { // from class: com.smaato.sdk.core.openmeasurement.OMVideoViewabilityTracker$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                OMVideoViewabilityTracker.lambda$registerAdView$0(view);
            }
        });
        Owner owner = Owner.NATIVE;
        AdSessionConfiguration adSessionConfigurationCreateAdSessionConfiguration = AdSessionConfiguration.createAdSessionConfiguration(CreativeType.VIDEO, ImpressionType.LOADED, owner, owner, false);
        List<ViewabilityVerificationResource> listEmptyList = map.get(CampaignEx.KEY_OMID);
        Partner partner = this.partner;
        String str = this.omidJsServiceContent;
        OMVideoResourceMapper oMVideoResourceMapper = this.resourceMapper;
        if (listEmptyList == null) {
            listEmptyList = Collections.emptyList();
        }
        AdSession adSessionCreateAdSession = AdSession.createAdSession(adSessionConfigurationCreateAdSessionConfiguration, AdSessionContext.createNativeAdSessionContext(partner, str, oMVideoResourceMapper.apply(listEmptyList), null, ""));
        this.adSession = adSessionCreateAdSession;
        adSessionCreateAdSession.registerAdView(view);
        this.adEvents = AdEvents.createAdEvents(this.adSession);
        this.videoEvents = MediaEvents.createMediaEvents(this.adSession);
    }

    static /* synthetic */ void lambda$registerAdView$0(View view) {
        if (Omid.isActive()) {
            return;
        }
        Omid.activate(view.getContext());
    }

    public void trackPlayerStateChange() {
        MediaEvents mediaEvents = this.videoEvents;
        if (mediaEvents != null) {
            mediaEvents.playerStateChange(PlayerState.FULLSCREEN);
        }
    }

    public void trackVideoClicked() {
        MediaEvents mediaEvents = this.videoEvents;
        if (mediaEvents != null) {
            try {
                mediaEvents.adUserInteraction(InteractionType.CLICK);
            } catch (Exception e) {
                Log.e("OMVideoViewabilityTracker", "Error tracking Ad click: " + e.getMessage());
            }
        }
    }

    public void trackLoaded(final VideoProps videoProps) {
        Objects.onNotNull(this.videoEvents, new Consumer() { // from class: com.smaato.sdk.core.openmeasurement.OMVideoViewabilityTracker$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5572x6b0a1ca2(videoProps, (MediaEvents) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$trackLoaded$1$com-smaato-sdk-core-openmeasurement-OMVideoViewabilityTracker, reason: not valid java name */
    /* synthetic */ void m5572x6b0a1ca2(VideoProps videoProps, MediaEvents mediaEvents) {
        VastProperties vastPropertiesCreateVastPropertiesForNonSkippableMedia;
        if (videoProps.isSkippable) {
            vastPropertiesCreateVastPropertiesForNonSkippableMedia = VastProperties.createVastPropertiesForSkippableMedia(videoProps.skipOffset, true, Position.STANDALONE);
        } else {
            vastPropertiesCreateVastPropertiesForNonSkippableMedia = VastProperties.createVastPropertiesForNonSkippableMedia(true, Position.STANDALONE);
        }
        AdEvents adEvents = this.adEvents;
        if (adEvents != null) {
            adEvents.loaded(vastPropertiesCreateVastPropertiesForNonSkippableMedia);
        }
    }

    public void trackStarted(float f, float f2) {
        try {
            MediaEvents mediaEvents = this.videoEvents;
            if (mediaEvents == null || f <= 0.0f || f2 < 0.0f) {
                return;
            }
            mediaEvents.start(f, f2);
        } catch (Exception unused) {
            Log.e("OMVideoViewabilityTracker", "Invalid values passed to start video events");
        }
    }

    public void trackFirstQuartile() {
        MediaEvents mediaEvents = this.videoEvents;
        if (mediaEvents != null) {
            try {
                mediaEvents.firstQuartile();
            } catch (Exception e) {
                Log.e("OMVideoViewabilityTracker", "Error tracking Ad first quartile: " + e.getMessage());
            }
        }
    }

    public void trackMidPoint() {
        MediaEvents mediaEvents = this.videoEvents;
        if (mediaEvents != null) {
            try {
                mediaEvents.midpoint();
            } catch (Exception e) {
                Log.e("OMVideoViewabilityTracker", "Error tracking Ad midpoint: " + e.getMessage());
            }
        }
    }

    public void trackThirdQuartile() {
        MediaEvents mediaEvents = this.videoEvents;
        if (mediaEvents != null) {
            try {
                mediaEvents.thirdQuartile();
            } catch (Exception e) {
                Log.e("OMVideoViewabilityTracker", "Error tracking Ad third quartile: " + e.getMessage());
            }
        }
    }

    public void trackCompleted() {
        MediaEvents mediaEvents = this.videoEvents;
        if (mediaEvents != null) {
            try {
                mediaEvents.complete();
            } catch (Exception e) {
                Log.e("OMVideoViewabilityTracker", "Error tracking Ad complete: " + e.getMessage());
            }
        }
    }

    public void trackPaused() {
        MediaEvents mediaEvents = this.videoEvents;
        if (mediaEvents != null) {
            try {
                mediaEvents.pause();
            } catch (Exception e) {
                Log.e("OMVideoViewabilityTracker", "Error tracking Ad pause: " + e.getMessage());
            }
        }
    }

    public void trackResumed() {
        MediaEvents mediaEvents = this.videoEvents;
        if (mediaEvents != null) {
            try {
                mediaEvents.resume();
            } catch (Exception e) {
                Log.e("OMVideoViewabilityTracker", "Error tracking Ad resume: " + e.getMessage());
            }
        }
    }

    public void trackBufferStart() {
        MediaEvents mediaEvents = this.videoEvents;
        if (mediaEvents != null) {
            mediaEvents.bufferStart();
        }
    }

    public void trackBufferFinish() {
        MediaEvents mediaEvents = this.videoEvents;
        if (mediaEvents != null) {
            mediaEvents.bufferFinish();
        }
    }

    public void trackPlayerVolumeChanged(float f) {
        MediaEvents mediaEvents = this.videoEvents;
        if (mediaEvents != null) {
            mediaEvents.volumeChange(f);
        }
    }

    public void trackSkipped() {
        MediaEvents mediaEvents = this.videoEvents;
        if (mediaEvents != null) {
            mediaEvents.skipped();
        }
    }
}
