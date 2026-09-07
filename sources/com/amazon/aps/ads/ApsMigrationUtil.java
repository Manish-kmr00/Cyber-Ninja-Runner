package com.amazon.aps.ads;

import com.amazon.aps.ads.model.ApsAdNetwork;
import com.amazon.aps.ads.model.ApsAdRequestErrorCode;
import com.amazon.aps.ads.model.ApsAdType;
import com.amazon.aps.ads.model.ApsLogLevel;
import com.amazon.aps.ads.model.ApsMraidPolicy;
import com.amazon.device.ads.AdError;
import com.amazon.device.ads.AdType;
import com.amazon.device.ads.DTBAdNetwork;
import com.amazon.device.ads.DTBLogLevel;
import com.amazon.device.ads.MRAIDPolicy;

/* JADX INFO: loaded from: classes9.dex */
public class ApsMigrationUtil {
    private static boolean isApsInitCalled;
    private static boolean isApsInitInProgress;
    private static boolean isApsRemoteConfigInProgress;

    static synchronized void setApsInitInProgress(boolean z) {
        isApsInitInProgress = z;
    }

    public static synchronized boolean isApsInitInProgress() {
        return isApsInitInProgress;
    }

    static synchronized void setIsApsInitCalled(boolean z) {
        isApsInitCalled = z;
    }

    public static synchronized boolean getIsApsInitCalled() {
        return isApsInitCalled;
    }

    public static synchronized void setApsRemoteConfigInProgress(boolean z) {
        isApsRemoteConfigInProgress = z;
    }

    public static synchronized boolean isApsRemoteConfigInProgress() {
        return isApsRemoteConfigInProgress;
    }

    static AdError.ErrorCode getErrorCode(ApsAdRequestErrorCode apsAdRequestErrorCode) {
        int i = AnonymousClass1.$SwitchMap$com$amazon$aps$ads$model$ApsAdRequestErrorCode[apsAdRequestErrorCode.ordinal()];
        if (i == 1) {
            return AdError.ErrorCode.NO_ERROR;
        }
        if (i == 2) {
            return AdError.ErrorCode.NETWORK_ERROR;
        }
        if (i == 3) {
            return AdError.ErrorCode.NETWORK_TIMEOUT;
        }
        if (i == 4) {
            return AdError.ErrorCode.NO_FILL;
        }
        if (i == 5) {
            return AdError.ErrorCode.REQUEST_ERROR;
        }
        return AdError.ErrorCode.INTERNAL_ERROR;
    }

    static ApsAdRequestErrorCode getApsAdRequestErrorCode(AdError.ErrorCode errorCode) {
        int i = AnonymousClass1.$SwitchMap$com$amazon$device$ads$AdError$ErrorCode[errorCode.ordinal()];
        if (i == 1) {
            return ApsAdRequestErrorCode.NO_ERROR;
        }
        if (i == 2) {
            return ApsAdRequestErrorCode.NETWORK_ERROR;
        }
        if (i == 3) {
            return ApsAdRequestErrorCode.NETWORK_TIMEOUT;
        }
        if (i == 4) {
            return ApsAdRequestErrorCode.NO_FILL;
        }
        if (i == 5) {
            return ApsAdRequestErrorCode.REQUEST_ERROR;
        }
        return ApsAdRequestErrorCode.INTERNAL_ERROR;
    }

    public static AdType getAdType(ApsAdType apsAdType) {
        int i = AnonymousClass1.$SwitchMap$com$amazon$aps$ads$model$ApsAdType[apsAdType.ordinal()];
        if (i == 1) {
            return AdType.VIDEO;
        }
        if (i == 2) {
            return AdType.INTERSTITIAL;
        }
        return AdType.DISPLAY;
    }

    static DTBLogLevel getDTBLogLevel(ApsLogLevel apsLogLevel) {
        switch (AnonymousClass1.$SwitchMap$com$amazon$aps$ads$model$ApsLogLevel[apsLogLevel.ordinal()]) {
            case 1:
                return DTBLogLevel.All;
            case 2:
                return DTBLogLevel.Off;
            case 3:
                return DTBLogLevel.Info;
            case 4:
                return DTBLogLevel.Warn;
            case 5:
                return DTBLogLevel.Debug;
            case 6:
                return DTBLogLevel.Trace;
            case 7:
                return DTBLogLevel.Fatal;
            default:
                return DTBLogLevel.Error;
        }
    }

    static MRAIDPolicy getMRAIDPolicy(ApsMraidPolicy apsMraidPolicy) {
        int i = AnonymousClass1.$SwitchMap$com$amazon$aps$ads$model$ApsMraidPolicy[apsMraidPolicy.ordinal()];
        if (i == 1) {
            return MRAIDPolicy.DFP;
        }
        if (i == 2) {
            return MRAIDPolicy.CUSTOM;
        }
        if (i == 3) {
            return MRAIDPolicy.NONE;
        }
        return MRAIDPolicy.AUTO_DETECT;
    }

    static ApsMraidPolicy getApsMraidPolicy(MRAIDPolicy mRAIDPolicy) {
        int i = AnonymousClass1.$SwitchMap$com$amazon$device$ads$MRAIDPolicy[mRAIDPolicy.ordinal()];
        if (i == 1) {
            return ApsMraidPolicy.DFP;
        }
        if (i == 2) {
            return ApsMraidPolicy.CUSTOM;
        }
        if (i == 3) {
            return ApsMraidPolicy.NONE;
        }
        return ApsMraidPolicy.AUTO_DETECT;
    }

    /* JADX INFO: renamed from: com.amazon.aps.ads.ApsMigrationUtil$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$amazon$aps$ads$model$ApsAdNetwork;
        static final /* synthetic */ int[] $SwitchMap$com$amazon$aps$ads$model$ApsAdRequestErrorCode;
        static final /* synthetic */ int[] $SwitchMap$com$amazon$aps$ads$model$ApsAdType;
        static final /* synthetic */ int[] $SwitchMap$com$amazon$aps$ads$model$ApsLogLevel;
        static final /* synthetic */ int[] $SwitchMap$com$amazon$aps$ads$model$ApsMraidPolicy;
        static final /* synthetic */ int[] $SwitchMap$com$amazon$device$ads$AdError$ErrorCode;
        static final /* synthetic */ int[] $SwitchMap$com$amazon$device$ads$MRAIDPolicy;

        static {
            int[] iArr = new int[ApsAdNetwork.values().length];
            $SwitchMap$com$amazon$aps$ads$model$ApsAdNetwork = iArr;
            try {
                iArr[ApsAdNetwork.AD_GENERATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$amazon$aps$ads$model$ApsAdNetwork[ApsAdNetwork.ADMOB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$amazon$aps$ads$model$ApsAdNetwork[ApsAdNetwork.UNITY_LEVELPLAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$amazon$aps$ads$model$ApsAdNetwork[ApsAdNetwork.MAX.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$amazon$aps$ads$model$ApsAdNetwork[ApsAdNetwork.NIMBUS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$amazon$aps$ads$model$ApsAdNetwork[ApsAdNetwork.OTHER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$amazon$aps$ads$model$ApsAdNetwork[ApsAdNetwork.CUSTOM_MEDIATION.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr2 = new int[MRAIDPolicy.values().length];
            $SwitchMap$com$amazon$device$ads$MRAIDPolicy = iArr2;
            try {
                iArr2[MRAIDPolicy.DFP.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$amazon$device$ads$MRAIDPolicy[MRAIDPolicy.CUSTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$amazon$device$ads$MRAIDPolicy[MRAIDPolicy.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$amazon$device$ads$MRAIDPolicy[MRAIDPolicy.AUTO_DETECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
            int[] iArr3 = new int[ApsMraidPolicy.values().length];
            $SwitchMap$com$amazon$aps$ads$model$ApsMraidPolicy = iArr3;
            try {
                iArr3[ApsMraidPolicy.DFP.ordinal()] = 1;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$amazon$aps$ads$model$ApsMraidPolicy[ApsMraidPolicy.CUSTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$amazon$aps$ads$model$ApsMraidPolicy[ApsMraidPolicy.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$amazon$aps$ads$model$ApsMraidPolicy[ApsMraidPolicy.AUTO_DETECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused15) {
            }
            int[] iArr4 = new int[ApsLogLevel.values().length];
            $SwitchMap$com$amazon$aps$ads$model$ApsLogLevel = iArr4;
            try {
                iArr4[ApsLogLevel.All.ordinal()] = 1;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$amazon$aps$ads$model$ApsLogLevel[ApsLogLevel.Off.ordinal()] = 2;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$amazon$aps$ads$model$ApsLogLevel[ApsLogLevel.Info.ordinal()] = 3;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$com$amazon$aps$ads$model$ApsLogLevel[ApsLogLevel.Warn.ordinal()] = 4;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$com$amazon$aps$ads$model$ApsLogLevel[ApsLogLevel.Debug.ordinal()] = 5;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$com$amazon$aps$ads$model$ApsLogLevel[ApsLogLevel.Trace.ordinal()] = 6;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$com$amazon$aps$ads$model$ApsLogLevel[ApsLogLevel.Fatal.ordinal()] = 7;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$com$amazon$aps$ads$model$ApsLogLevel[ApsLogLevel.Error.ordinal()] = 8;
            } catch (NoSuchFieldError unused23) {
            }
            int[] iArr5 = new int[ApsAdType.values().length];
            $SwitchMap$com$amazon$aps$ads$model$ApsAdType = iArr5;
            try {
                iArr5[ApsAdType.VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                $SwitchMap$com$amazon$aps$ads$model$ApsAdType[ApsAdType.INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                $SwitchMap$com$amazon$aps$ads$model$ApsAdType[ApsAdType.DISPLAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused26) {
            }
            int[] iArr6 = new int[AdError.ErrorCode.values().length];
            $SwitchMap$com$amazon$device$ads$AdError$ErrorCode = iArr6;
            try {
                iArr6[AdError.ErrorCode.NO_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                $SwitchMap$com$amazon$device$ads$AdError$ErrorCode[AdError.ErrorCode.NETWORK_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                $SwitchMap$com$amazon$device$ads$AdError$ErrorCode[AdError.ErrorCode.NETWORK_TIMEOUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                $SwitchMap$com$amazon$device$ads$AdError$ErrorCode[AdError.ErrorCode.NO_FILL.ordinal()] = 4;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                $SwitchMap$com$amazon$device$ads$AdError$ErrorCode[AdError.ErrorCode.REQUEST_ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                $SwitchMap$com$amazon$device$ads$AdError$ErrorCode[AdError.ErrorCode.INTERNAL_ERROR.ordinal()] = 6;
            } catch (NoSuchFieldError unused32) {
            }
            int[] iArr7 = new int[ApsAdRequestErrorCode.values().length];
            $SwitchMap$com$amazon$aps$ads$model$ApsAdRequestErrorCode = iArr7;
            try {
                iArr7[ApsAdRequestErrorCode.NO_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                $SwitchMap$com$amazon$aps$ads$model$ApsAdRequestErrorCode[ApsAdRequestErrorCode.NETWORK_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                $SwitchMap$com$amazon$aps$ads$model$ApsAdRequestErrorCode[ApsAdRequestErrorCode.NETWORK_TIMEOUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                $SwitchMap$com$amazon$aps$ads$model$ApsAdRequestErrorCode[ApsAdRequestErrorCode.NO_FILL.ordinal()] = 4;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                $SwitchMap$com$amazon$aps$ads$model$ApsAdRequestErrorCode[ApsAdRequestErrorCode.REQUEST_ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                $SwitchMap$com$amazon$aps$ads$model$ApsAdRequestErrorCode[ApsAdRequestErrorCode.INTERNAL_ERROR.ordinal()] = 6;
            } catch (NoSuchFieldError unused38) {
            }
        }
    }

    static DTBAdNetwork getDTBAdNetworkInfo(ApsAdNetwork apsAdNetwork) {
        int i = AnonymousClass1.$SwitchMap$com$amazon$aps$ads$model$ApsAdNetwork[apsAdNetwork.ordinal()];
        if (i == 1) {
            return DTBAdNetwork.AD_GENERATION;
        }
        if (i == 2) {
            return DTBAdNetwork.ADMOB;
        }
        if (i == 3) {
            return DTBAdNetwork.IRON_SOURCE;
        }
        if (i == 4) {
            return DTBAdNetwork.MAX;
        }
        if (i == 5) {
            return DTBAdNetwork.NIMBUS;
        }
        return DTBAdNetwork.OTHER;
    }
}
