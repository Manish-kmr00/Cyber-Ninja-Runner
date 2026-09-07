package com.amazon.aps.ads;

import android.content.Context;
import com.amazon.aps.ads.listeners.ApsInitializationListener;
import com.amazon.aps.ads.model.ApsAdNetwork;
import com.amazon.aps.ads.model.ApsInitConfig;
import com.amazon.aps.ads.model.ApsInitializationStatus;
import com.amazon.aps.ads.model.ApsLogLevel;
import com.amazon.aps.ads.model.ApsMraidPolicy;
import com.amazon.aps.ads.model.ApsMraidVersion;
import com.amazon.aps.ads.model.ApsPrivacyType;
import com.amazon.aps.shared.APSAnalytics;
import com.amazon.aps.shared.analytics.APSEventSeverity;
import com.amazon.aps.shared.analytics.APSEventType;
import com.amazon.aps.shared.util.ApsAsyncUtil;
import com.amazon.aps.shared.util.ApsResult;
import com.amazon.device.ads.AdRegistration;
import com.amazon.device.ads.DTBAdNetworkInfo;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public class Aps implements ApsConstants {
    private static String appKey;
    private static ApsInitializationListener apsInitializationListener;
    private static Context context;
    private static final HashMap<String, String> privacyHashmap = new HashMap<>();

    public static void initialize(final Context context2, final String str, ApsAdNetwork apsAdNetwork, final ApsInitializationListener apsInitializationListener2) {
        ApsAdUtils.checkNullAndLogInvalidArg(context2, apsAdNetwork, str);
        ApsMigrationUtil.setIsApsInitCalled(true);
        ApsMigrationUtil.setApsInitInProgress(true);
        try {
            context = context2;
            appKey = str;
            apsInitializationListener = apsInitializationListener2;
            setAdNetworkInfo(apsAdNetwork);
            ApsAsyncUtil.getInstance().runAsyncAndCallback(new ApsAsyncUtil.ApsReturnRunnable() { // from class: com.amazon.aps.ads.Aps$$ExternalSyntheticLambda0
                @Override // com.amazon.aps.shared.util.ApsAsyncUtil.ApsReturnRunnable
                public final Object run() {
                    return Aps.lambda$initialize$0(str, context2);
                }
            }, new ApsAsyncUtil.ApsExecutionListener() { // from class: com.amazon.aps.ads.Aps$$ExternalSyntheticLambda1
                @Override // com.amazon.aps.shared.util.ApsAsyncUtil.ApsExecutionListener
                public final void onExecutionCompleted(ApsResult apsResult, Object obj) {
                    Aps.lambda$initialize$1(apsInitializationListener2, apsResult, (AdRegistration) obj);
                }
            });
        } catch (RuntimeException e) {
            ApsMigrationUtil.setApsInitInProgress(false);
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "API failure:initialize", e);
        }
    }

    static /* synthetic */ AdRegistration lambda$initialize$0(String str, Context context2) {
        AdRegistration adRegistration = AdRegistration.getInstance(str, context2);
        ApsMigrationUtil.setApsInitInProgress(false);
        return adRegistration;
    }

    static /* synthetic */ void lambda$initialize$1(ApsInitializationListener apsInitializationListener2, ApsResult apsResult, AdRegistration adRegistration) {
        if (apsInitializationListener2 != null) {
            apsInitializationListener2.onInitializationCompleted(new ApsInitializationStatus(apsResult));
        }
    }

    public static void initialize(Context context2, String str, ApsAdNetwork apsAdNetwork, final ApsInitConfig apsInitConfig, final ApsInitializationListener apsInitializationListener2) {
        ApsAdUtils.checkNullAndLogInvalidArg(apsInitConfig);
        boolean z = true;
        ApsMigrationUtil.setIsApsInitCalled(true);
        try {
            if (apsInitConfig.apsLogLevel == null || apsInitConfig.apsLogLevel == ApsLogLevel.Off) {
                z = false;
            }
            enableLogging(z, apsInitConfig.apsLogLevel != null ? apsInitConfig.apsLogLevel : ApsLogLevel.Error);
            setLocationEnabled(apsInitConfig.isLocationEnabled);
            initialize(context2, str, apsAdNetwork, new ApsInitializationListener() { // from class: com.amazon.aps.ads.Aps$$ExternalSyntheticLambda2
                @Override // com.amazon.aps.ads.listeners.ApsInitializationListener
                public final void onInitializationCompleted(ApsInitializationStatus apsInitializationStatus) {
                    Aps.lambda$initialize$2(apsInitConfig, apsInitializationListener2, apsInitializationStatus);
                }
            });
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "API failure:initialize", e);
        }
    }

    static /* synthetic */ void lambda$initialize$2(ApsInitConfig apsInitConfig, ApsInitializationListener apsInitializationListener2, ApsInitializationStatus apsInitializationStatus) {
        setTestingMode(apsInitConfig.isTestingMode);
        apsInitializationListener2.onInitializationCompleted(apsInitializationStatus);
    }

    public static boolean isInitialized() {
        return AdRegistration.isInitialized();
    }

    public static void setAdNetworkInfo(ApsAdNetwork apsAdNetwork) {
        ApsAdUtils.checkNullAndLogInvalidArg(apsAdNetwork);
        try {
            AdRegistration.setAdNetworkInfo(new DTBAdNetworkInfo(ApsMigrationUtil.getDTBAdNetworkInfo(apsAdNetwork)));
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "API failure:setAdNetworkInfo", e);
        }
    }

    public static void setMraidSupportedVersions(ApsMraidVersion... apsMraidVersionArr) {
        ApsAdUtils.checkNullAndLogInvalidArg(apsMraidVersionArr);
        try {
            String[] strArr = new String[apsMraidVersionArr.length];
            for (int i = 0; i < apsMraidVersionArr.length; i++) {
                strArr[i] = apsMraidVersionArr[i].getString();
            }
            AdRegistration.setMRAIDSupportedVersions(strArr);
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "API failure:setMraidSupportedVersions", e);
        }
    }

    public static void setMraidPolicy(ApsMraidPolicy apsMraidPolicy) {
        ApsAdUtils.checkNullAndLogInvalidArg(apsMraidPolicy);
        try {
            AdRegistration.setMRAIDPolicy(ApsMigrationUtil.getMRAIDPolicy(apsMraidPolicy));
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "API failure:setMraidPolicy", e);
        }
    }

    public static ApsMraidPolicy getMraidPolicy() {
        try {
            return ApsMigrationUtil.getApsMraidPolicy(AdRegistration.getMRAIDPolicy());
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "API failure:getMraidPolicy", e);
            return ApsMraidPolicy.NONE;
        }
    }

    public static void setLocationEnabled(boolean z) {
        AdRegistration.useGeoLocation(z);
    }

    public static boolean isLocationEnabled() {
        return AdRegistration.isLocationEnabled();
    }

    public static String getSdkVersion() {
        return AdRegistration.getVersion();
    }

    public static void enableLogging(boolean z) {
        AdRegistration.enableLogging(z);
    }

    public static void enableLogging(boolean z, ApsLogLevel apsLogLevel) {
        ApsAdUtils.checkNullAndLogInvalidArg(apsLogLevel);
        try {
            AdRegistration.enableLogging(z, ApsMigrationUtil.getDTBLogLevel(apsLogLevel));
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "API failure:enableLogging", e);
        }
    }

    public static void setTestingMode(boolean z) {
        AdRegistration.enableTesting(z);
    }

    public static boolean isTestingMode() {
        return AdRegistration.isTestMode();
    }

    public static void setCustomAttribute(String str, String str2) {
        ApsAdUtils.checkNullAndLogInvalidArg(str, str2);
        try {
            AdRegistration.addCustomAttribute(str, str2);
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "API failure:setCustomAttribute", e);
        }
    }

    public static void removeCustomAttribute(String str) {
        ApsAdUtils.checkNullAndLogInvalidArg(str);
        try {
            AdRegistration.removeCustomAttribute(str);
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "API failure:removeCustomAttribute", e);
        }
    }

    public static void setOmIdPartnerName(String str) {
        ApsAdUtils.checkNullAndLogInvalidArg(str);
        try {
            AdRegistration.addCustomAttribute("omidPartnerName", str);
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "API failure:setOmIdPartnerName", e);
        }
    }

    public static void setOmIdPartnerVersion(String str) {
        ApsAdUtils.checkNullAndLogInvalidArg(str);
        try {
            AdRegistration.addCustomAttribute("omidPartnerVersion", str);
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "API failure:setOmIdPartnerVersion", e);
        }
    }

    public static void setPrivacyString(ApsPrivacyType apsPrivacyType, String str) {
        ApsAdUtils.checkNullAndLogInvalidArg(apsPrivacyType, str);
        try {
            privacyHashmap.put(apsPrivacyType.toString(), str);
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "API failure:setPrivacyString", e);
        }
    }

    public static void setPrivacyValue(ApsPrivacyType apsPrivacyType, Object obj) {
        ApsAdUtils.checkNullAndLogInvalidArg(apsPrivacyType, obj);
        if (apsPrivacyType == ApsPrivacyType.DSA_PRIVACY && (obj instanceof JSONObject)) {
            AdRegistration.setDsaTransparency((JSONObject) obj);
        } else {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Unsupported value type for " + apsPrivacyType.toString());
        }
    }

    public static void removePrivacyString(ApsPrivacyType apsPrivacyType) {
        ApsAdUtils.checkNullAndLogInvalidArg(apsPrivacyType);
        try {
            privacyHashmap.remove(apsPrivacyType.toString());
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "API failure:setPrivacyString", e);
        }
    }

    static HashMap<String, String> getPrivacyHashmap() {
        return privacyHashmap;
    }
}
