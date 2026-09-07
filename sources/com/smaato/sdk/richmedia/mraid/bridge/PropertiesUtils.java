package com.smaato.sdk.richmedia.mraid.bridge;

import com.pubmatic.sdk.common.POBCommonConstants;
import com.smaato.sdk.core.util.TextUtils;
import com.smaato.sdk.richmedia.mraid.dataprovider.MraidStateMachineFactory;
import com.smaato.sdk.richmedia.mraid.dataprovider.PlacementType;
import com.smaato.sdk.richmedia.util.DeviceUtils;

/* JADX INFO: loaded from: classes5.dex */
abstract class PropertiesUtils {
    static String placementTypeToString(PlacementType placementType) {
        int i = AnonymousClass1.$SwitchMap$com$smaato$sdk$richmedia$mraid$dataprovider$PlacementType[placementType.ordinal()];
        if (i == 1) {
            return "interstitial";
        }
        if (i == 2) {
            return POBCommonConstants.BANNER_PLACEMENT_TYPE;
        }
        throw new IllegalArgumentException("Unknown placement type: " + placementType);
    }

    static String screenOrientationToString(DeviceUtils.ScreenOrientation screenOrientation) {
        int i = AnonymousClass1.$SwitchMap$com$smaato$sdk$richmedia$util$DeviceUtils$ScreenOrientation[screenOrientation.ordinal()];
        if (i == 1) {
            return "portrait";
        }
        if (i == 2) {
            return "landscape";
        }
        return "none";
    }

    static DeviceUtils.ScreenOrientation stringToScreenOrientation(String str) {
        if (TextUtils.isEmpty(str)) {
            return DeviceUtils.ScreenOrientation.UNKNOWN;
        }
        str.hashCode();
        if (str.equals("portrait")) {
            return DeviceUtils.ScreenOrientation.PORTRAIT;
        }
        if (str.equals("landscape")) {
            return DeviceUtils.ScreenOrientation.LANDSCAPE;
        }
        return DeviceUtils.ScreenOrientation.UNKNOWN;
    }

    /* JADX INFO: renamed from: com.smaato.sdk.richmedia.mraid.bridge.PropertiesUtils$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$smaato$sdk$richmedia$mraid$dataprovider$MraidStateMachineFactory$State;
        static final /* synthetic */ int[] $SwitchMap$com$smaato$sdk$richmedia$mraid$dataprovider$PlacementType;
        static final /* synthetic */ int[] $SwitchMap$com$smaato$sdk$richmedia$util$DeviceUtils$ScreenOrientation;

        static {
            int[] iArr = new int[MraidStateMachineFactory.State.values().length];
            $SwitchMap$com$smaato$sdk$richmedia$mraid$dataprovider$MraidStateMachineFactory$State = iArr;
            try {
                iArr[MraidStateMachineFactory.State.HIDDEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$smaato$sdk$richmedia$mraid$dataprovider$MraidStateMachineFactory$State[MraidStateMachineFactory.State.EXPANDED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$smaato$sdk$richmedia$mraid$dataprovider$MraidStateMachineFactory$State[MraidStateMachineFactory.State.RESIZED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$smaato$sdk$richmedia$mraid$dataprovider$MraidStateMachineFactory$State[MraidStateMachineFactory.State.DEFAULT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$smaato$sdk$richmedia$mraid$dataprovider$MraidStateMachineFactory$State[MraidStateMachineFactory.State.LOADING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[DeviceUtils.ScreenOrientation.values().length];
            $SwitchMap$com$smaato$sdk$richmedia$util$DeviceUtils$ScreenOrientation = iArr2;
            try {
                iArr2[DeviceUtils.ScreenOrientation.PORTRAIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$smaato$sdk$richmedia$util$DeviceUtils$ScreenOrientation[DeviceUtils.ScreenOrientation.LANDSCAPE.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$smaato$sdk$richmedia$util$DeviceUtils$ScreenOrientation[DeviceUtils.ScreenOrientation.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr3 = new int[PlacementType.values().length];
            $SwitchMap$com$smaato$sdk$richmedia$mraid$dataprovider$PlacementType = iArr3;
            try {
                iArr3[PlacementType.INTERSTITIAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$smaato$sdk$richmedia$mraid$dataprovider$PlacementType[PlacementType.INLINE.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    static String stateToString(MraidStateMachineFactory.State state) {
        int i = AnonymousClass1.$SwitchMap$com$smaato$sdk$richmedia$mraid$dataprovider$MraidStateMachineFactory$State[state.ordinal()];
        if (i == 1) {
            return "hidden";
        }
        if (i == 2) {
            return "expanded";
        }
        if (i == 3) {
            return "resized";
        }
        if (i == 4) {
            return "default";
        }
        if (i == 5) {
            return "loading";
        }
        throw new IllegalArgumentException("Unknown state: " + state);
    }
}
