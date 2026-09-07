package net.pubnative.lite.sdk.viewability;

import android.view.View;
import com.iab.omid.library.pubnativenet.adsession.AdSession;
import com.iab.omid.library.pubnativenet.adsession.AdSessionConfiguration;
import com.iab.omid.library.pubnativenet.adsession.AdSessionContext;
import com.iab.omid.library.pubnativenet.adsession.CreativeType;
import com.iab.omid.library.pubnativenet.adsession.ImpressionType;
import com.iab.omid.library.pubnativenet.adsession.Owner;
import com.iab.omid.library.pubnativenet.adsession.VerificationScriptResource;
import com.iab.omid.library.pubnativenet.adsession.media.InteractionType;
import com.iab.omid.library.pubnativenet.adsession.media.MediaEvents;
import com.iab.omid.library.pubnativenet.adsession.media.Position;
import com.iab.omid.library.pubnativenet.adsession.media.VastProperties;
import java.util.List;
import net.pubnative.lite.sdk.utils.Logger;

/* JADX INFO: loaded from: classes10.dex */
public class HyBidViewabilityNativeVideoAdSession extends HyBidViewabilityNativeAdSession {
    private static final String OM_EXCEPTION = "OM SDK Ad Session - Exception";
    private static final String TAG = "HyBidViewabilityNativeVideoAdSession";
    private boolean completeFired;
    private boolean firstQuartileFired;
    private MediaEvents mMediaEvents;
    private boolean midpointFired;
    private boolean muted;
    private boolean startFired;
    private boolean thirdQuartileFired;

    public HyBidViewabilityNativeVideoAdSession(ViewabilityManager viewabilityManager) {
        super(viewabilityManager);
        this.startFired = false;
        this.firstQuartileFired = false;
        this.midpointFired = false;
        this.thirdQuartileFired = false;
        this.completeFired = false;
        this.muted = true;
    }

    public void initAdSession(View view, List<VerificationScriptResource> list) {
        if (this.viewabilityManager.isViewabilityMeasurementEnabled()) {
            this.mVerificationScriptResources.addAll(list);
            try {
                this.mAdSession = AdSession.createAdSession(AdSessionConfiguration.createAdSessionConfiguration(CreativeType.VIDEO, ImpressionType.BEGIN_TO_RENDER, Owner.NATIVE, Owner.NATIVE, false), AdSessionContext.createNativeAdSessionContext(this.viewabilityManager.getPartner(), this.viewabilityManager.getServiceJs(), this.mVerificationScriptResources, "", ""));
                this.mAdSession.registerAdView(view);
                createAdEvents();
                createMediaEvents();
                this.mAdSession.start();
            } catch (Exception e) {
                Logger.e(TAG, OM_EXCEPTION, e);
            }
        }
    }

    protected void createMediaEvents() {
        try {
            if (this.mAdSession != null) {
                this.mMediaEvents = MediaEvents.createMediaEvents(this.mAdSession);
            }
        } catch (Exception e) {
            Logger.e(TAG, OM_EXCEPTION, e);
        }
    }

    @Override // net.pubnative.lite.sdk.viewability.HyBidViewabilityAdSession
    public void fireLoaded() {
        try {
            if (this.viewabilityManager.isViewabilityMeasurementEnabled()) {
                VastProperties vastPropertiesCreateVastPropertiesForNonSkippableMedia = VastProperties.createVastPropertiesForNonSkippableMedia(false, Position.STANDALONE);
                if (this.mAdEvents != null) {
                    this.mAdEvents.loaded(vastPropertiesCreateVastPropertiesForNonSkippableMedia);
                }
            }
        } catch (Exception e) {
            Logger.e(TAG, OM_EXCEPTION, e);
        }
    }

    public void fireStart(float f, boolean z) {
        MediaEvents mediaEvents;
        try {
            if (!this.viewabilityManager.isViewabilityMeasurementEnabled() || (mediaEvents = this.mMediaEvents) == null || this.startFired) {
                return;
            }
            mediaEvents.start(f, z ? 0.0f : 1.0f);
            this.startFired = true;
        } catch (Exception e) {
            Logger.e(TAG, OM_EXCEPTION, e);
        }
    }

    public void fireFirstQuartile() {
        MediaEvents mediaEvents;
        try {
            if (!this.viewabilityManager.isViewabilityMeasurementEnabled() || (mediaEvents = this.mMediaEvents) == null || this.firstQuartileFired) {
                return;
            }
            mediaEvents.firstQuartile();
            this.firstQuartileFired = true;
        } catch (Exception e) {
            Logger.e(TAG, OM_EXCEPTION, e);
        }
    }

    public void fireMidpoint() {
        MediaEvents mediaEvents;
        try {
            if (!this.viewabilityManager.isViewabilityMeasurementEnabled() || (mediaEvents = this.mMediaEvents) == null || this.midpointFired) {
                return;
            }
            mediaEvents.midpoint();
            this.midpointFired = true;
        } catch (Exception e) {
            Logger.e(TAG, OM_EXCEPTION, e);
        }
    }

    public void fireThirdQuartile() {
        MediaEvents mediaEvents;
        try {
            if (!this.viewabilityManager.isViewabilityMeasurementEnabled() || (mediaEvents = this.mMediaEvents) == null || this.thirdQuartileFired) {
                return;
            }
            mediaEvents.thirdQuartile();
            this.thirdQuartileFired = true;
        } catch (Exception e) {
            Logger.e(TAG, OM_EXCEPTION, e);
        }
    }

    public void fireComplete() {
        MediaEvents mediaEvents;
        try {
            if (!this.viewabilityManager.isViewabilityMeasurementEnabled() || (mediaEvents = this.mMediaEvents) == null || this.completeFired) {
                return;
            }
            mediaEvents.complete();
            this.completeFired = true;
        } catch (Exception e) {
            Logger.e(TAG, OM_EXCEPTION, e);
        }
    }

    public void firePause() {
        MediaEvents mediaEvents;
        try {
            if (this.viewabilityManager.isViewabilityMeasurementEnabled() && (mediaEvents = this.mMediaEvents) != null) {
                mediaEvents.pause();
            }
        } catch (Exception e) {
            Logger.e(TAG, OM_EXCEPTION, e);
        }
    }

    public void fireResume() {
        MediaEvents mediaEvents;
        try {
            if (this.viewabilityManager.isViewabilityMeasurementEnabled() && (mediaEvents = this.mMediaEvents) != null) {
                mediaEvents.resume();
            }
        } catch (Exception e) {
            Logger.e(TAG, OM_EXCEPTION, e);
        }
    }

    public void fireBufferStart() {
        MediaEvents mediaEvents;
        try {
            if (this.viewabilityManager.isViewabilityMeasurementEnabled() && (mediaEvents = this.mMediaEvents) != null) {
                mediaEvents.bufferStart();
            }
        } catch (Exception e) {
            Logger.e(TAG, OM_EXCEPTION, e);
        }
    }

    public void fireBufferFinish() {
        MediaEvents mediaEvents;
        try {
            if (this.viewabilityManager.isViewabilityMeasurementEnabled() && (mediaEvents = this.mMediaEvents) != null) {
                mediaEvents.bufferFinish();
            }
        } catch (Exception e) {
            Logger.e(TAG, OM_EXCEPTION, e);
        }
    }

    public void fireVolumeChange(boolean z) {
        try {
            if (this.viewabilityManager.isViewabilityMeasurementEnabled() && z != this.muted) {
                this.muted = z;
                MediaEvents mediaEvents = this.mMediaEvents;
                if (mediaEvents == null || this.completeFired) {
                    return;
                }
                mediaEvents.volumeChange(z ? 0.0f : 1.0f);
            }
        } catch (Exception e) {
            Logger.e(TAG, OM_EXCEPTION, e);
        }
    }

    public void fireSkipped() {
        MediaEvents mediaEvents;
        try {
            if (this.viewabilityManager.isViewabilityMeasurementEnabled() && (mediaEvents = this.mMediaEvents) != null) {
                mediaEvents.skipped();
            }
        } catch (Exception e) {
            Logger.e(TAG, OM_EXCEPTION, e);
        }
    }

    public void fireClick() {
        MediaEvents mediaEvents;
        try {
            if (this.viewabilityManager.isViewabilityMeasurementEnabled() && (mediaEvents = this.mMediaEvents) != null) {
                mediaEvents.adUserInteraction(InteractionType.CLICK);
            }
        } catch (Exception e) {
            Logger.e(TAG, OM_EXCEPTION, e);
        }
    }
}
