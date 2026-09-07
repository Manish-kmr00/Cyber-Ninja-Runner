package com.pubmatic.sdk.omsdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.iab.omid.library.pubmatic.Omid;
import com.iab.omid.library.pubmatic.adsession.AdEvents;
import com.iab.omid.library.pubmatic.adsession.AdSession;
import com.iab.omid.library.pubmatic.adsession.AdSessionConfiguration;
import com.iab.omid.library.pubmatic.adsession.AdSessionContext;
import com.iab.omid.library.pubmatic.adsession.CreativeType;
import com.iab.omid.library.pubmatic.adsession.ErrorType;
import com.iab.omid.library.pubmatic.adsession.ImpressionType;
import com.iab.omid.library.pubmatic.adsession.Owner;
import com.iab.omid.library.pubmatic.adsession.Partner;
import com.iab.omid.library.pubmatic.adsession.VerificationScriptResource;
import com.iab.omid.library.pubmatic.adsession.media.InteractionType;
import com.iab.omid.library.pubmatic.adsession.media.MediaEvents;
import com.iab.omid.library.pubmatic.adsession.media.PlayerState;
import com.iab.omid.library.pubmatic.adsession.media.Position;
import com.iab.omid.library.pubmatic.adsession.media.VastProperties;
import com.pubmatic.sdk.common.POBCommonConstants;
import com.pubmatic.sdk.common.POBDataType;
import com.pubmatic.sdk.common.log.POBLog;
import com.pubmatic.sdk.common.log.POBLogConstants;
import com.pubmatic.sdk.common.viewability.POBMeasurementProvider;
import com.pubmatic.sdk.common.viewability.POBVerificationScriptResource;
import com.pubmatic.sdk.common.viewability.POBVideoMeasurementProvider;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class POBVideoMeasurement extends POBMeasurement implements POBVideoMeasurementProvider {
    private Handler handler = new Handler(Looper.getMainLooper());
    private MediaEvents mediaEvents;

    class a implements POBMeasurementProvider.POBScriptListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f7711a;
        final /* synthetic */ View b;
        final /* synthetic */ POBVideoMeasurementProvider.POBOmidSessionListener c;

        a(List list, View view, POBVideoMeasurementProvider.POBOmidSessionListener pOBOmidSessionListener) {
            this.f7711a = list;
            this.b = view;
            this.c = pOBOmidSessionListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(POBVideoMeasurementProvider.POBOmidSessionListener pOBOmidSessionListener) {
            AdSession adSession = POBVideoMeasurement.this.adSession;
            if (adSession != null) {
                adSession.start();
                pOBOmidSessionListener.onOmidSessionInitialized();
                POBLog.debug(POBOMSDKUtil.TAG, POBOMSDKLogConstants.MSG_OMSDK_START_SESSION, POBVideoMeasurement.this.adSession.getAdSessionId());
            }
        }

        @Override // com.pubmatic.sdk.common.viewability.POBMeasurementProvider.POBScriptListener
        public void onFailedToReceiveMeasurementScript(int i) {
            POBLog.error(POBOMSDKUtil.TAG, POBLogConstants.OMID_JS_SCRIPT_FAILURE, new Object[0]);
        }

        @Override // com.pubmatic.sdk.common.viewability.POBMeasurementProvider.POBScriptListener
        public void onMeasurementScriptReceived(String str) {
            AdSessionContext adSessionContextCreateNativeAdSessionContext = AdSessionContext.createNativeAdSessionContext(Partner.createPartner(POBCommonConstants.PARTNER_NAME, "4.5.1"), str, this.f7711a, null, "");
            Owner owner = Owner.NATIVE;
            AdSessionConfiguration adSessionConfigurationCreateAdSessionConfiguration = AdSessionConfiguration.createAdSessionConfiguration(CreativeType.VIDEO, ImpressionType.ONE_PIXEL, owner, owner, false);
            POBVideoMeasurement.this.adSession = AdSession.createAdSession(adSessionConfigurationCreateAdSessionConfiguration, adSessionContextCreateNativeAdSessionContext);
            POBVideoMeasurement pOBVideoMeasurement = POBVideoMeasurement.this;
            pOBVideoMeasurement.adEvents = AdEvents.createAdEvents(pOBVideoMeasurement.adSession);
            POBVideoMeasurement pOBVideoMeasurement2 = POBVideoMeasurement.this;
            pOBVideoMeasurement2.mediaEvents = MediaEvents.createMediaEvents(pOBVideoMeasurement2.adSession);
            POBVideoMeasurement.this.setTrackView(this.b);
            Handler handler = POBVideoMeasurement.this.handler;
            final POBVideoMeasurementProvider.POBOmidSessionListener pOBOmidSessionListener = this.c;
            handler.post(new Runnable() { // from class: com.pubmatic.sdk.omsdk.POBVideoMeasurement$a$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(pOBOmidSessionListener);
                }
            });
        }
    }

    static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f7712a;
        static final /* synthetic */ int[] b;
        static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[POBVideoMeasurementProvider.POBVideoAdErrorType.values().length];
            c = iArr;
            try {
                iArr[POBVideoMeasurementProvider.POBVideoAdErrorType.GENERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                c[POBVideoMeasurementProvider.POBVideoAdErrorType.VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[POBVideoMeasurementProvider.POBVideoPlayerState.values().length];
            b = iArr2;
            try {
                iArr2[POBVideoMeasurementProvider.POBVideoPlayerState.FULLSCREEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[POBVideoMeasurementProvider.POBVideoPlayerState.COLLAPSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[POBVideoMeasurementProvider.POBVideoPlayerState.EXPANDED.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[POBVideoMeasurementProvider.POBVideoPlayerState.MINIMIZED.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                b[POBVideoMeasurementProvider.POBVideoPlayerState.NORMAL.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[POBDataType.POBVideoAdEventType.values().length];
            f7712a = iArr3;
            try {
                iArr3[POBDataType.POBVideoAdEventType.FIRST_QUARTILE.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f7712a[POBDataType.POBVideoAdEventType.MID_POINT.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f7712a[POBDataType.POBVideoAdEventType.THIRD_QUARTILE.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f7712a[POBDataType.POBVideoAdEventType.COMPLETE.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f7712a[POBDataType.POBVideoAdEventType.SKIPPED.ordinal()] = 5;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f7712a[POBDataType.POBVideoAdEventType.MUTE.ordinal()] = 6;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f7712a[POBDataType.POBVideoAdEventType.UNMUTE.ordinal()] = 7;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f7712a[POBDataType.POBVideoAdEventType.CLICKED.ordinal()] = 8;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f7712a[POBDataType.POBVideoAdEventType.PAUSE.ordinal()] = 9;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f7712a[POBDataType.POBVideoAdEventType.RESUME.ordinal()] = 10;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f7712a[POBDataType.POBVideoAdEventType.ICON_CLICKED.ordinal()] = 11;
            } catch (NoSuchFieldError unused18) {
            }
        }
    }

    @Override // com.pubmatic.sdk.omsdk.POBMeasurement, com.pubmatic.sdk.common.viewability.POBMeasurementProvider
    public void finishAdSession() {
        super.finishAdSession();
        this.adEvents = null;
        this.mediaEvents = null;
    }

    @Override // com.pubmatic.sdk.common.viewability.POBVideoMeasurementProvider
    public void impressionOccurred() {
        if (this.adEvents == null) {
            POBLog.error(POBOMSDKUtil.TAG, POBOMSDKLogConstants.MSG_OMSDK_UNABLE_SIGNALING_EVENT, POBOMSDKLogConstants.MSG_OMSDK_IMPRESSION_EVENT);
            return;
        }
        try {
            POBLog.info(POBOMSDKUtil.TAG, POBOMSDKLogConstants.MSG_OMSDK_SIGNALING_EVENT, POBOMSDKLogConstants.MSG_OMSDK_IMPRESSION_EVENT);
            this.adEvents.impressionOccurred();
        } catch (Exception e) {
            POBLog.error(POBOMSDKUtil.TAG, "Unable to signal event : %s Exception : %s", POBOMSDKLogConstants.MSG_OMSDK_IMPRESSION_EVENT, e.getMessage());
        }
    }

    @Override // com.pubmatic.sdk.common.viewability.POBVideoMeasurementProvider
    public void loaded(boolean z, float f) {
        if (this.adEvents == null) {
            POBLog.error(POBOMSDKUtil.TAG, POBOMSDKLogConstants.MSG_OMSDK_UNABLE_SIGNALING_EVENT, POBOMSDKLogConstants.MSG_OMSDK_LOADED_EVENT);
            return;
        }
        try {
            POBLog.info(POBOMSDKUtil.TAG, POBOMSDKLogConstants.MSG_OMSDK_SIGNALING_EVENT, POBOMSDKLogConstants.MSG_OMSDK_LOADED_EVENT);
            this.adEvents.loaded(z ? VastProperties.createVastPropertiesForSkippableMedia(f, true, Position.STANDALONE) : VastProperties.createVastPropertiesForNonSkippableMedia(true, Position.STANDALONE));
        } catch (Exception e) {
            POBLog.error(POBOMSDKUtil.TAG, "Unable to signal event : %s Exception : %s", POBOMSDKLogConstants.MSG_OMSDK_LOADED_EVENT, e.getMessage());
        }
    }

    @Override // com.pubmatic.sdk.common.viewability.POBVideoMeasurementProvider
    public void signalAdEvent(POBDataType.POBVideoAdEventType pOBVideoAdEventType) {
        if (this.mediaEvents == null) {
            POBLog.error(POBOMSDKUtil.TAG, POBOMSDKLogConstants.MSG_OMSDK_UNABLE_SIGNALING_EVENT, pOBVideoAdEventType.name());
            return;
        }
        try {
            POBLog.info(POBOMSDKUtil.TAG, POBOMSDKLogConstants.MSG_OMSDK_SIGNALING_EVENT, pOBVideoAdEventType.name());
            switch (b.f7712a[pOBVideoAdEventType.ordinal()]) {
                case 1:
                    this.mediaEvents.firstQuartile();
                    break;
                case 2:
                    this.mediaEvents.midpoint();
                    break;
                case 3:
                    this.mediaEvents.thirdQuartile();
                    break;
                case 4:
                    this.mediaEvents.complete();
                    break;
                case 5:
                    this.mediaEvents.skipped();
                    break;
                case 6:
                    this.mediaEvents.volumeChange(0.0f);
                    break;
                case 7:
                    this.mediaEvents.volumeChange(1.0f);
                    break;
                case 8:
                    this.mediaEvents.adUserInteraction(InteractionType.CLICK);
                    break;
                case 9:
                    this.mediaEvents.pause();
                    break;
                case 10:
                    this.mediaEvents.resume();
                    break;
                case 11:
                    this.mediaEvents.adUserInteraction(InteractionType.INVITATION_ACCEPTED);
                    break;
            }
        } catch (Exception e) {
            POBLog.error(POBOMSDKUtil.TAG, "Unable to signal event : %s Exception : %s", pOBVideoAdEventType.name(), e.getMessage());
        }
    }

    @Override // com.pubmatic.sdk.common.viewability.POBVideoMeasurementProvider
    public void signalError(POBVideoMeasurementProvider.POBVideoAdErrorType pOBVideoAdErrorType, String str) {
        if (this.adSession == null) {
            POBLog.error(POBOMSDKUtil.TAG, POBOMSDKLogConstants.MSG_OMSDK_UNABLE_SIGNALING_ERROR, pOBVideoAdErrorType.name());
            return;
        }
        int i = b.c[pOBVideoAdErrorType.ordinal()];
        if (i == 1) {
            this.adSession.error(ErrorType.GENERIC, str);
        } else {
            if (i != 2) {
                return;
            }
            this.adSession.error(ErrorType.VIDEO, str);
        }
    }

    @Override // com.pubmatic.sdk.common.viewability.POBVideoMeasurementProvider
    public void signalPlayerStateChange(POBVideoMeasurementProvider.POBVideoPlayerState pOBVideoPlayerState) {
        if (this.mediaEvents == null) {
            POBLog.error(POBOMSDKUtil.TAG, POBOMSDKLogConstants.MSG_OMSDK_UNABLE_SIGNALING_PLAYERSTATE_EVENT, pOBVideoPlayerState.name());
            return;
        }
        try {
            POBLog.info(POBOMSDKUtil.TAG, POBOMSDKLogConstants.MSG_OMSDK_SIGNALING_EVENT, pOBVideoPlayerState.name());
            int i = b.b[pOBVideoPlayerState.ordinal()];
            if (i == 1) {
                this.mediaEvents.playerStateChange(PlayerState.FULLSCREEN);
            } else if (i == 2) {
                this.mediaEvents.playerStateChange(PlayerState.COLLAPSED);
            } else if (i == 3) {
                this.mediaEvents.playerStateChange(PlayerState.EXPANDED);
            } else if (i == 4) {
                this.mediaEvents.playerStateChange(PlayerState.MINIMIZED);
            } else if (i == 5) {
                this.mediaEvents.playerStateChange(PlayerState.NORMAL);
            }
        } catch (Exception e) {
            POBLog.error(POBOMSDKUtil.TAG, "Unable to signal player state event : %s Exception : %s", pOBVideoPlayerState.name(), e.getMessage());
        }
    }

    @Override // com.pubmatic.sdk.common.viewability.POBVideoMeasurementProvider
    public void start(float f, float f2) {
        if (this.mediaEvents == null) {
            POBLog.error(POBOMSDKUtil.TAG, POBOMSDKLogConstants.MSG_OMSDK_UNABLE_SIGNALING_EVENT, POBOMSDKLogConstants.MSG_OMSDK_START_EVENT);
            return;
        }
        try {
            POBLog.info(POBOMSDKUtil.TAG, POBOMSDKLogConstants.MSG_OMSDK_SIGNALING_EVENT, POBOMSDKLogConstants.MSG_OMSDK_START_EVENT);
            this.mediaEvents.start(f, f2);
        } catch (Exception e) {
            POBLog.error(POBOMSDKUtil.TAG, "Unable to signal event : %s Exception : %s", POBOMSDKLogConstants.MSG_OMSDK_START_EVENT, e.getMessage());
        }
    }

    @Override // com.pubmatic.sdk.common.viewability.POBVideoMeasurementProvider
    public void startAdSession(View view, List<POBVerificationScriptResource> list, POBVideoMeasurementProvider.POBOmidSessionListener pOBOmidSessionListener) {
        try {
            List<VerificationScriptResource> verificationScriptResourceList = POBOMSDKUtil.getVerificationScriptResourceList(list);
            if (verificationScriptResourceList.isEmpty()) {
                POBLog.error(POBOMSDKUtil.TAG, POBOMSDKLogConstants.MSG_OMSDK_UNABLE_START_SESSION, "Verification list is empty");
                return;
            }
            Context applicationContext = view.getContext().getApplicationContext();
            if (!Omid.isActive()) {
                Omid.activate(applicationContext);
            }
            omidJsServiceScript(applicationContext, new a(verificationScriptResourceList, view, pOBOmidSessionListener));
        } catch (Exception e) {
            POBLog.error(POBOMSDKUtil.TAG, POBOMSDKLogConstants.MSG_OMSDK_UNABLE_START_SESSION, e.getMessage());
        }
    }
}
