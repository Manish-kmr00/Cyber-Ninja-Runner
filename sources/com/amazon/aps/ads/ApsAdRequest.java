package com.amazon.aps.ads;

import com.amazon.aps.ads.listeners.ApsAdRequestListener;
import com.amazon.aps.ads.model.ApsAdFormat;
import com.amazon.aps.shared.APSAnalytics;
import com.amazon.aps.shared.analytics.APSEventSeverity;
import com.amazon.aps.shared.analytics.APSEventType;
import com.amazon.device.ads.AdError;
import com.amazon.device.ads.DTBAdCallback;
import com.amazon.device.ads.DTBAdRequest;
import com.amazon.device.ads.DTBAdResponse;
import com.amazon.device.ads.DTBAdSize;
import com.amazon.device.ads.DTBLoadException;
import com.amazon.device.ads.DtbConstants;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public class ApsAdRequest extends DTBAdRequest {
    private ApsAdFormat apsAdFormat;
    private ApsAdFormatProperties apsAdFormatProperties;
    private ApsAdRequestListener apsAdRequestListener;
    private final DTBAdCallback dtbAdCallback;
    private String slotUuid;

    public ApsAdRequest(String str) {
        this.dtbAdCallback = new DTBAdCallback() { // from class: com.amazon.aps.ads.ApsAdRequest.1
            @Override // com.amazon.device.ads.DTBAdCallback
            public void onFailure(AdError adError) {
                if (ApsAdRequest.this.apsAdRequestListener != null) {
                    ApsAdRequest.this.apsAdRequestListener.onFailure(new ApsAdError(adError, ApsAdRequest.this.slotUuid, ApsAdRequest.this.apsAdFormat));
                }
            }

            @Override // com.amazon.device.ads.DTBAdCallback
            public void onSuccess(DTBAdResponse dTBAdResponse) {
                if (ApsAdRequest.this.apsAdRequestListener != null) {
                    ApsAd apsAd = new ApsAd(dTBAdResponse, ApsAdRequest.this.apsAdFormat);
                    apsAd.setSlotUuid(ApsAdRequest.this.slotUuid);
                    ApsAdRequest.this.apsAdRequestListener.onSuccess(apsAd);
                }
            }
        };
        ApsAdUtils.checkNullAndLogInvalidArg(str);
        this.slotUuid = str;
    }

    public ApsAdRequest(String str, ApsAdFormat apsAdFormat) {
        this(str);
        ApsAdUtils.checkNullAndLogInvalidArg(apsAdFormat);
        setApsAdFormat(apsAdFormat);
    }

    public ApsAdRequest(String str, ApsAdFormat apsAdFormat, ApsAdFormatProperties apsAdFormatProperties) {
        this(str);
        ApsAdUtils.checkNullAndLogInvalidArg(apsAdFormat);
        setApsAdFormat(apsAdFormat, apsAdFormatProperties);
    }

    public ApsAdRequest(DTBAdRequest dTBAdRequest, String str, ApsAdFormat apsAdFormat) {
        super(dTBAdRequest, str);
        this.dtbAdCallback = new DTBAdCallback() { // from class: com.amazon.aps.ads.ApsAdRequest.1
            @Override // com.amazon.device.ads.DTBAdCallback
            public void onFailure(AdError adError) {
                if (ApsAdRequest.this.apsAdRequestListener != null) {
                    ApsAdRequest.this.apsAdRequestListener.onFailure(new ApsAdError(adError, ApsAdRequest.this.slotUuid, ApsAdRequest.this.apsAdFormat));
                }
            }

            @Override // com.amazon.device.ads.DTBAdCallback
            public void onSuccess(DTBAdResponse dTBAdResponse) {
                if (ApsAdRequest.this.apsAdRequestListener != null) {
                    ApsAd apsAd = new ApsAd(dTBAdResponse, ApsAdRequest.this.apsAdFormat);
                    apsAd.setSlotUuid(ApsAdRequest.this.slotUuid);
                    ApsAdRequest.this.apsAdRequestListener.onSuccess(apsAd);
                }
            }
        };
        this.slotUuid = str;
        setApsAdFormat(apsAdFormat);
    }

    public ApsAdRequest(DTBAdRequest dTBAdRequest) {
        DTBAdSize dTBAdSize;
        super(dTBAdRequest);
        this.dtbAdCallback = new DTBAdCallback() { // from class: com.amazon.aps.ads.ApsAdRequest.1
            @Override // com.amazon.device.ads.DTBAdCallback
            public void onFailure(AdError adError) {
                if (ApsAdRequest.this.apsAdRequestListener != null) {
                    ApsAdRequest.this.apsAdRequestListener.onFailure(new ApsAdError(adError, ApsAdRequest.this.slotUuid, ApsAdRequest.this.apsAdFormat));
                }
            }

            @Override // com.amazon.device.ads.DTBAdCallback
            public void onSuccess(DTBAdResponse dTBAdResponse) {
                if (ApsAdRequest.this.apsAdRequestListener != null) {
                    ApsAd apsAd = new ApsAd(dTBAdResponse, ApsAdRequest.this.apsAdFormat);
                    apsAd.setSlotUuid(ApsAdRequest.this.slotUuid);
                    ApsAdRequest.this.apsAdRequestListener.onSuccess(apsAd);
                }
            }
        };
        if (dTBAdRequest == null || dTBAdRequest.getAdSizes() == null || dTBAdRequest.getAdSizes().size() <= 0 || (dTBAdSize = dTBAdRequest.getAdSizes().get(0)) == null) {
            return;
        }
        String slotUUID = dTBAdSize.getSlotUUID();
        ApsAdFormat adFormat = ApsAdFormatUtils.getAdFormat(dTBAdSize.getDTBAdType(), dTBAdSize.getHeight(), dTBAdSize.getWidth());
        this.slotUuid = slotUUID;
        setApsAdFormat(adFormat);
    }

    public void setApsAdFormat(ApsAdFormat apsAdFormat) {
        ApsAdUtils.checkNullAndLogInvalidArg(apsAdFormat);
        try {
            this.apsAdFormat = apsAdFormat;
            this.apsAdFormatProperties = null;
            setAdSize();
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "API failure:ApsAdRequest - setApsAdFormat", e);
        }
    }

    public void setApsAdFormat(ApsAdFormat apsAdFormat, ApsAdFormatProperties apsAdFormatProperties) {
        ApsAdUtils.checkNullAndLogInvalidArg(apsAdFormat);
        try {
            this.apsAdFormat = apsAdFormat;
            this.apsAdFormatProperties = apsAdFormatProperties;
            setAdSize();
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "API failure:ApsAdRequest - setApsAdFormat", e);
        }
    }

    public void loadAd(ApsAdRequestListener apsAdRequestListener) {
        ApsAdUtils.checkNullAndLogInvalidArg(apsAdRequestListener);
        try {
            loadPrivacyStrings();
            this.apsAdRequestListener = apsAdRequestListener;
            super.loadAd(this.dtbAdCallback);
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "API failure:ApsAdRequest - loadAd", e);
        }
    }

    public void loadSmartBanner(ApsAdRequestListener apsAdRequestListener) {
        ApsAdUtils.checkNullAndLogInvalidArg(apsAdRequestListener);
        this.apsAdRequestListener = apsAdRequestListener;
        try {
            loadPrivacyStrings();
            super.loadSmartBanner(this.dtbAdCallback);
        } catch (DTBLoadException | RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "API failure:ApsAdRequest - loadSmartBanner", e);
        }
    }

    public String getSlotUuid() {
        return this.slotUuid;
    }

    private void setAdSize() {
        int width = ApsAdFormatUtils.getWidth(this.apsAdFormat);
        int height = ApsAdFormatUtils.getHeight(this.apsAdFormat);
        switch (AnonymousClass2.$SwitchMap$com$amazon$aps$ads$model$ApsAdFormat[this.apsAdFormat.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                setSizes(new DTBAdSize(width, height, this.slotUuid));
                break;
            case 5:
            case 6:
                setSizes(new DTBAdSize.DTBInterstitialAdSize(this.slotUuid));
                break;
            case 7:
                ApsAdFormatProperties apsAdFormatProperties = this.apsAdFormatProperties;
                int playerWidth = apsAdFormatProperties != null ? apsAdFormatProperties.getPlayerWidth() : 320;
                ApsAdFormatProperties apsAdFormatProperties2 = this.apsAdFormatProperties;
                setSizes(new DTBAdSize.DTBVideo(playerWidth, apsAdFormatProperties2 != null ? apsAdFormatProperties2.getPlayerHeight() : DtbConstants.DEFAULT_PLAYER_HEIGHT, this.slotUuid));
                break;
        }
    }

    /* JADX INFO: renamed from: com.amazon.aps.ads.ApsAdRequest$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$amazon$aps$ads$model$ApsAdFormat;

        static {
            int[] iArr = new int[ApsAdFormat.values().length];
            $SwitchMap$com$amazon$aps$ads$model$ApsAdFormat = iArr;
            try {
                iArr[ApsAdFormat.BANNER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$amazon$aps$ads$model$ApsAdFormat[ApsAdFormat.LEADERBOARD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$amazon$aps$ads$model$ApsAdFormat[ApsAdFormat.MREC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$amazon$aps$ads$model$ApsAdFormat[ApsAdFormat.BANNER_SMART.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$amazon$aps$ads$model$ApsAdFormat[ApsAdFormat.INTERSTITIAL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$amazon$aps$ads$model$ApsAdFormat[ApsAdFormat.REWARDED_VIDEO.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$amazon$aps$ads$model$ApsAdFormat[ApsAdFormat.INSTREAM_VIDEO.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    private void loadPrivacyStrings() {
        try {
            HashMap<String, String> privacyHashmap = Aps.getPrivacyHashmap();
            if (privacyHashmap.size() > 0) {
                for (Map.Entry<String, String> entry : privacyHashmap.entrySet()) {
                    putCustomTarget(entry.getKey(), entry.getValue());
                }
            }
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Error in ApsAdRequest - loadPrivacySettings", e);
        }
    }
}
