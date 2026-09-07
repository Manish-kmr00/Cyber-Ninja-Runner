package com.amazon.aps.ads;

import com.amazon.aps.ads.model.ApsAdFormat;
import com.amazon.aps.shared.APSAnalytics;
import com.amazon.aps.shared.analytics.APSEventSeverity;
import com.amazon.aps.shared.analytics.APSEventType;
import com.amazon.device.ads.AdType;
import com.amazon.device.ads.DtbDeviceDataRetriever;

/* JADX INFO: loaded from: classes4.dex */
public class ApsAdFormatUtils {
    static final int BANNER_HEIGHT = 50;
    static final int BANNER_WIDTH = 320;
    static final int DEFAULT_VIDEO_REQ_HEIGHT = 480;
    static final int DEFAULT_VIDEO_REQ_WIDTH = 320;
    static final int INTERSTITIAL_HEIGHT_BY_AAX = 9999;
    static final int INTERSTITIAL_WIDTH_BY_AAX = 9999;
    static final int MREC_HEIGHT = 250;
    static final int MREC_WIDTH = 300;
    static final int TABLET_BANNER_HEIGHT = 90;
    static final int TABLET_BANNER_WIDTH = 728;

    private ApsAdFormatUtils() {
    }

    public static int getHeight(ApsAdFormat apsAdFormat) {
        try {
            int i = AnonymousClass1.$SwitchMap$com$amazon$aps$ads$model$ApsAdFormat[apsAdFormat.ordinal()];
            if (i == 1) {
                return DtbDeviceDataRetriever.isTablet() ? 90 : 50;
            }
            if (i == 2) {
                return 50;
            }
            if (i == 3) {
                return 250;
            }
            if (i != 4) {
                return i != 5 ? 9999 : 480;
            }
            return 90;
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Error on getting height from ApsAdFormat", e);
            return 9999;
        }
    }

    /* JADX INFO: renamed from: com.amazon.aps.ads.ApsAdFormatUtils$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$amazon$aps$ads$model$ApsAdFormat;
        static final /* synthetic */ int[] $SwitchMap$com$amazon$device$ads$AdType;

        static {
            int[] iArr = new int[AdType.values().length];
            $SwitchMap$com$amazon$device$ads$AdType = iArr;
            try {
                iArr[AdType.DISPLAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$amazon$device$ads$AdType[AdType.INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$amazon$device$ads$AdType[AdType.VIDEO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[ApsAdFormat.values().length];
            $SwitchMap$com$amazon$aps$ads$model$ApsAdFormat = iArr2;
            try {
                iArr2[ApsAdFormat.BANNER_SMART.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$amazon$aps$ads$model$ApsAdFormat[ApsAdFormat.BANNER.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$amazon$aps$ads$model$ApsAdFormat[ApsAdFormat.MREC.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$amazon$aps$ads$model$ApsAdFormat[ApsAdFormat.LEADERBOARD.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$amazon$aps$ads$model$ApsAdFormat[ApsAdFormat.REWARDED_VIDEO.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public static ApsAdFormat getAdFormat(AdType adType, int i, int i2) {
        if (adType == null) {
            return null;
        }
        try {
            int i3 = AnonymousClass1.$SwitchMap$com$amazon$device$ads$AdType[adType.ordinal()];
            if (i3 != 1) {
                if (i3 == 2 || i3 == 3) {
                    return ApsAdFormat.INTERSTITIAL;
                }
                return null;
            }
            if (i == 50 && i2 == 320) {
                return ApsAdFormat.BANNER;
            }
            if (i == 250 && i2 == 300) {
                return ApsAdFormat.MREC;
            }
            if (i == 90 && i2 == TABLET_BANNER_WIDTH) {
                return ApsAdFormat.LEADERBOARD;
            }
            return null;
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Error on getting AdFormat", e);
            return null;
        }
    }

    public static int getWidth(ApsAdFormat apsAdFormat) {
        try {
            int i = AnonymousClass1.$SwitchMap$com$amazon$aps$ads$model$ApsAdFormat[apsAdFormat.ordinal()];
            if (i == 1) {
                if (DtbDeviceDataRetriever.isTablet()) {
                    return TABLET_BANNER_WIDTH;
                }
                return 320;
            }
            if (i == 2) {
                return 320;
            }
            if (i == 3) {
                return 300;
            }
            if (i != 4) {
                return i != 5 ? 9999 : 320;
            }
            return TABLET_BANNER_WIDTH;
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Error on getting width dimension from ApsAdFormat", e);
            return 9999;
        }
    }
}
