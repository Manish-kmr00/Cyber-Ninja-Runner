package com.applovin.mediation.unity;

import android.text.TextUtils;
import android.util.Log;
import com.applovin.impl.sdk.AppLovinSdkInitializationConfigurationImpl;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.mediation.MaxMediatedNetworkInfo;
import com.applovin.mediation.MaxSegment;
import com.applovin.mediation.MaxSegmentCollection;
import com.applovin.sdk.AppLovinPrivacySettings;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.applovin.sdk.AppLovinSdkInitializationConfiguration;
import com.applovin.sdk.AppLovinSdkUtils;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.json.bu;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class MaxUnityPlugin {
    private static final String KEY_SDK_KEY = "sdk_key";
    protected static final String SDK_TAG = "AppLovinSdk";
    private static final String TAG = "MaxUnityPlugin";
    private static final String VERSION = "8.0.1";
    private static boolean disableAllLogs;
    private static boolean initializeSdkCalled;
    private static boolean isSdkInitialized;
    private static final AtomicReference<Object> initConfigurationBuilder = new AtomicReference<>();
    private static final AtomicReference<Object> sdk = new AtomicReference<>();
    private static final AtomicReference<Object> adManager = new AtomicReference<>();

    public static AppLovinSdkInitializationConfiguration.Builder getInitConfigurationBuilder() {
        AtomicReference<Object> atomicReference = initConfigurationBuilder;
        Object objCreateInitConfigurationBuilder = atomicReference.get();
        if (objCreateInitConfigurationBuilder == null) {
            synchronized (atomicReference) {
                objCreateInitConfigurationBuilder = atomicReference.get();
                if (objCreateInitConfigurationBuilder == null) {
                    objCreateInitConfigurationBuilder = createInitConfigurationBuilder();
                    if (objCreateInitConfigurationBuilder == null) {
                        objCreateInitConfigurationBuilder = atomicReference;
                    }
                    atomicReference.set(objCreateInitConfigurationBuilder);
                }
            }
        }
        if (objCreateInitConfigurationBuilder == atomicReference) {
            objCreateInitConfigurationBuilder = null;
        }
        return (AppLovinSdkInitializationConfiguration.Builder) objCreateInitConfigurationBuilder;
    }

    public static AppLovinSdk getSdk() {
        AtomicReference<Object> atomicReference = sdk;
        Object appLovinSdk = atomicReference.get();
        if (appLovinSdk == null) {
            synchronized (atomicReference) {
                appLovinSdk = atomicReference.get();
                if (appLovinSdk == null) {
                    appLovinSdk = AppLovinSdk.getInstance(Utils.getCurrentActivity());
                    if (appLovinSdk == null) {
                        appLovinSdk = atomicReference;
                    }
                    atomicReference.set(appLovinSdk);
                }
            }
        }
        if (appLovinSdk == atomicReference) {
            appLovinSdk = null;
        }
        return (AppLovinSdk) appLovinSdk;
    }

    public static MaxUnityAdManager getAdManager() {
        AtomicReference<Object> atomicReference = adManager;
        Object maxUnityAdManager = atomicReference.get();
        if (maxUnityAdManager == null) {
            synchronized (atomicReference) {
                maxUnityAdManager = atomicReference.get();
                if (maxUnityAdManager == null) {
                    maxUnityAdManager = new MaxUnityAdManager();
                    atomicReference.set(maxUnityAdManager);
                }
            }
        }
        if (maxUnityAdManager == atomicReference) {
            maxUnityAdManager = null;
        }
        return (MaxUnityAdManager) maxUnityAdManager;
    }

    public static boolean isDisableAllLogs() {
        return disableAllLogs;
    }

    public static void setBackgroundCallback(MaxUnityAdManager.BackgroundCallback backgroundCallback) {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putString(jSONObject, "name", "OnInitialCallbackEvent");
        backgroundCallback.onEvent(jSONObject.toString());
        MaxUnityAdManager.setBackgroundCallback(backgroundCallback);
    }

    public static void setSdkKey(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ((AppLovinSdkInitializationConfigurationImpl.BuilderImpl) getInitConfigurationBuilder()).setSdkKey(str);
    }

    public static void initializeSdk(String str, String str2) {
        AppLovinSdkInitializationConfiguration.Builder initConfigurationBuilder2 = getInitConfigurationBuilder();
        initConfigurationBuilder2.setPluginVersion("Max-Unity-8.0.1");
        initConfigurationBuilder2.setMediationProvider("max");
        initConfigurationBuilder2.setAdUnitIds(Arrays.asList(str.split(StringUtils.COMMA)));
        getSdk().getSettings().setExtraParameter("applovin_unity_metadata", str2);
        getAdManager().initializeSdkWithCompletionHandler(getInitConfigurationBuilder().build(), new MaxUnityAdManager.Listener() { // from class: com.applovin.mediation.unity.MaxUnityPlugin$$ExternalSyntheticLambda0
            @Override // com.applovin.mediation.unity.MaxUnityAdManager.Listener
            public final void onSdkInitializationComplete(AppLovinSdkConfiguration appLovinSdkConfiguration) {
                MaxUnityPlugin.isSdkInitialized = true;
            }
        });
        initializeSdkCalled = true;
    }

    public static boolean isInitialized() {
        return isSdkInitialized;
    }

    public static void setUserId(String str) {
        getSdk().getSettings().setUserIdentifier(str);
    }

    public static void setSegmentCollection(String str) {
        if (initializeSdkCalled) {
            e("Segment collection must be set before MAX SDK is initialized");
        } else {
            getInitConfigurationBuilder().setSegmentCollection(getMaxSegmentCollection(str));
        }
    }

    public static String getAvailableMediatedNetworks() {
        List<MaxMediatedNetworkInfo> availableMediatedNetworks = getSdk().getAvailableMediatedNetworks();
        JSONArray jSONArray = new JSONArray();
        for (MaxMediatedNetworkInfo maxMediatedNetworkInfo : availableMediatedNetworks) {
            JSONObject jSONObject = new JSONObject();
            JsonUtils.putString(jSONObject, "name", maxMediatedNetworkInfo.getName());
            JsonUtils.putString(jSONObject, "adapterClassName", maxMediatedNetworkInfo.getAdapterClassName());
            JsonUtils.putString(jSONObject, bu.b, maxMediatedNetworkInfo.getAdapterVersion());
            JsonUtils.putString(jSONObject, "sdkVersion", maxMediatedNetworkInfo.getSdkVersion());
            jSONArray.put(jSONObject);
        }
        return jSONArray.toString();
    }

    public static void showMediationDebugger() {
        if (!initializeSdkCalled) {
            d("Failed to show mediation debugger - please ensure the AppLovin MAX Unity Plugin has been initialized by calling 'MaxSdk.InitializeSdk();'!");
        } else {
            getSdk().showMediationDebugger();
        }
    }

    public static void showCreativeDebugger() {
        if (!initializeSdkCalled) {
            d("Failed to show creative debugger - please ensure the AppLovin MAX Unity Plugin has been initialized by calling 'MaxSdk.InitializeSdk();'!");
        } else {
            getSdk().showCreativeDebugger();
        }
    }

    public static int getConsentDialogState() {
        return !isSdkInitialized ? AppLovinSdkConfiguration.ConsentDialogState.UNKNOWN.ordinal() : getSdk().getConfiguration().getConsentDialogState().ordinal();
    }

    public static String getSdkConfiguration() {
        if (!initializeSdkCalled) {
            e("Failed to get SDK configuration - please ensure the AppLovin MAX Unity Plugin has been initialized by calling 'MaxSdk.InitializeSdk();'!");
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        AppLovinSdkConfiguration configuration = getSdk().getConfiguration();
        JsonUtils.putString(jSONObject, "consentFlowUserGeography", Integer.toString(configuration.getConsentFlowUserGeography().ordinal()));
        JsonUtils.putString(jSONObject, "consentDialogState", Integer.toString(configuration.getConsentDialogState().ordinal()));
        JsonUtils.putString(jSONObject, RemoteConfigConstants.RequestFieldKey.COUNTRY_CODE, configuration.getCountryCode());
        JsonUtils.putString(jSONObject, "isSuccessfullyInitialized", String.valueOf(getSdk().isInitialized()));
        JsonUtils.putBoolean(jSONObject, "isTestModeEnabled", configuration.isTestModeEnabled());
        return jSONObject.toString();
    }

    public static void setHasUserConsent(boolean z) {
        AppLovinPrivacySettings.setHasUserConsent(z, Utils.getCurrentActivity());
    }

    public static boolean hasUserConsent() {
        return AppLovinPrivacySettings.hasUserConsent(Utils.getCurrentActivity());
    }

    public static boolean isUserConsentSet() {
        return AppLovinPrivacySettings.isUserConsentSet(Utils.getCurrentActivity());
    }

    public static void setDoNotSell(boolean z) {
        AppLovinPrivacySettings.setDoNotSell(z, Utils.getCurrentActivity());
    }

    public static boolean isDoNotSell() {
        return AppLovinPrivacySettings.isDoNotSell(Utils.getCurrentActivity());
    }

    public static boolean isDoNotSellSet() {
        return AppLovinPrivacySettings.isDoNotSellSet(Utils.getCurrentActivity());
    }

    public static void createBanner(String str, String str2) {
        if (!initializeSdkCalled) {
            logUninitializedAccessError("CreateBanner");
        } else {
            getAdManager().createBanner(str.trim(), str2);
        }
    }

    public static void createBanner(String str, float f, float f2) {
        if (!initializeSdkCalled) {
            logUninitializedAccessError("CreateBannerXY");
        } else {
            getAdManager().createBanner(str.trim(), f, f2);
        }
    }

    public static void loadBanner(String str) {
        if (!initializeSdkCalled) {
            logUninitializedAccessError("LoadBanner");
        } else {
            getAdManager().loadBanner(str.trim());
        }
    }

    public static void setBannerExtraParameter(String str, String str2, String str3) {
        if (!initializeSdkCalled) {
            logUninitializedAccessError("SetBannerExtraParameter");
        } else {
            getAdManager().setBannerExtraParameter(str.trim(), str2, str3);
        }
    }

    public static void setBannerLocalExtraParameter(String str, String str2, Object obj) {
        if (!initializeSdkCalled) {
            logUninitializedAccessError("SetBannerLocalExtraParameter");
        } else {
            getAdManager().setBannerLocalExtraParameter(str.trim(), str2, obj);
        }
    }

    public static void setBannerLocalExtraParameterJson(String str, String str2, String str3) {
        if (!initializeSdkCalled) {
            logUninitializedAccessError("SetBannerLocalExtraParameter");
        } else {
            getAdManager().setBannerLocalExtraParameter(str.trim(), str2, getLocalExtraParameterValue(JsonUtils.deserialize(str3)));
        }
    }

    public static void setBannerCustomData(String str, String str2) {
        if (!initializeSdkCalled) {
            logUninitializedAccessError("setBannerCustomData");
        } else {
            getAdManager().setBannerCustomData(str.trim(), str2);
        }
    }

    public static void setBannerPlacement(String str, String str2) {
        if (!initializeSdkCalled) {
            logUninitializedAccessError("SetBannerPlacement");
        } else {
            getAdManager().setBannerPlacement(str.trim(), str2);
        }
    }

    public static void startBannerAutoRefresh(String str) {
        if (!initializeSdkCalled) {
            logUninitializedAccessError("StartBannerAutoRefresh");
        } else {
            getAdManager().startBannerAutoRefresh(str.trim());
        }
    }

    public static void stopBannerAutoRefresh(String str) {
        if (!initializeSdkCalled) {
            logUninitializedAccessError("StopBannerAutoRefresh");
        } else {
            getAdManager().stopBannerAutoRefresh(str.trim());
        }
    }

    public static void setBannerWidth(String str, float f) {
        if (!initializeSdkCalled) {
            logUninitializedAccessError("SetBannerWidth");
        } else {
            getAdManager().setBannerWidth(str.trim(), (int) f);
        }
    }

    public static void updateBannerPosition(String str, String str2) {
        if (!initializeSdkCalled) {
            logUninitializedAccessError("UpdateBannerPosition");
        } else {
            getAdManager().updateBannerPosition(str.trim(), str2);
        }
    }

    public static void updateBannerPosition(String str, float f, float f2) {
        if (!initializeSdkCalled) {
            logUninitializedAccessError("UpdateBannerPositionXY");
        } else {
            getAdManager().updateBannerPosition(str.trim(), f, f2);
        }
    }

    public static void showBanner(String str) {
        if (!initializeSdkCalled) {
            logUninitializedAccessError("ShowBanner");
        } else {
            getAdManager().showBanner(str.trim());
        }
    }

    public static void destroyBanner(String str) {
        if (!initializeSdkCalled) {
            logUninitializedAccessError("DestroyBanner");
        } else {
            getAdManager().destroyBanner(str.trim());
        }
    }

    public static void hideBanner(String str) {
        if (!initializeSdkCalled) {
            logUninitializedAccessError("HideBanner");
        } else {
            getAdManager().hideBanner(str.trim());
        }
    }

    public static String getBannerLayout(String str) {
        if (!initializeSdkCalled) {
            logUninitializedAccessError("GetBannerLayout");
            return "";
        }
        return getAdManager().getBannerLayout(str.trim());
    }

    public static void setBannerBackgroundColor(String str, String str2) {
        if (!initializeSdkCalled) {
            logUninitializedAccessError("SetBannerBackgroundColor");
        } else {
            getAdManager().setBannerBackgroundColor(str.trim(), str2);
        }
    }

    public static void createMRec(String str, String str2) {
        if (!initializeSdkCalled) {
            logUninitializedAccessError("CreateMRec");
        } else {
            getAdManager().createMRec(str.trim(), str2);
        }
    }

    public static void createMRec(String str, float f, float f2) {
        if (!initializeSdkCalled) {
            logUninitializedAccessError("CreateMRecXY");
        } else {
            getAdManager().createMRec(str.trim(), f, f2);
        }
    }

    public static void loadMRec(String str) {
        if (!initializeSdkCalled) {
            logUninitializedAccessError("LoadMRec");
        } else {
            getAdManager().loadMRec(str.trim());
        }
    }

    public static void setMRecPlacement(String str, String str2) {
        if (!initializeSdkCalled) {
            logUninitializedAccessError("SetMRecPlacement");
        } else {
            getAdManager().setMRecPlacement(str.trim(), str2);
        }
    }

    public static void startMRecAutoRefresh(String str) {
        if (!initializeSdkCalled) {
            logUninitializedAccessError("StartMRecAutoRefresh");
        } else {
            getAdManager().startMRecAutoRefresh(str.trim());
        }
    }

    public static void stopMRecAutoRefresh(String str) {
        if (!initializeSdkCalled) {
            logUninitializedAccessError("StopMRecAutoRefresh");
        } else {
            getAdManager().stopMRecAutoRefresh(str.trim());
        }
    }

    public static void updateMRecPosition(String str, String str2) {
        if (!initializeSdkCalled) {
            logUninitializedAccessError("UpdateMRecPosition");
        } else {
            getAdManager().updateMRecPosition(str.trim(), str2);
        }
    }

    public static void updateMRecPosition(String str, float f, float f2) {
        if (!initializeSdkCalled) {
            logUninitializedAccessError("UpdateMRecPositionXY");
        } else {
            getAdManager().updateMRecPosition(str.trim(), f, f2);
        }
    }

    public static void showMRec(String str) {
        if (!initializeSdkCalled) {
            logUninitializedAccessError("ShowMRec");
        } else {
            getAdManager().showMRec(str.trim());
        }
    }

    public static void destroyMRec(String str) {
        if (!initializeSdkCalled) {
            logUninitializedAccessError("DestroyMRec");
        } else {
            getAdManager().destroyMRec(str.trim());
        }
    }

    public static void hideMRec(String str) {
        if (!initializeSdkCalled) {
            logUninitializedAccessError("HideMRec");
        } else {
            getAdManager().hideMRec(str.trim());
        }
    }

    public static void setMRecExtraParameter(String str, String str2, String str3) {
        if (!initializeSdkCalled) {
            logUninitializedAccessError("SetMRecExtraParameter");
        } else {
            getAdManager().setMRecExtraParameter(str.trim(), str2, str3);
        }
    }

    public static void setMRecLocalExtraParameter(String str, String str2, Object obj) {
        if (!initializeSdkCalled) {
            logUninitializedAccessError("SetMRecLocalExtraParameter");
        } else {
            getAdManager().setMRecLocalExtraParameter(str.trim(), str2, obj);
        }
    }

    public static void setMRecLocalExtraParameterJson(String str, String str2, String str3) {
        if (!initializeSdkCalled) {
            logUninitializedAccessError("SetMRecLocalExtraParameter");
        } else {
            getAdManager().setMRecLocalExtraParameter(str.trim(), str2, getLocalExtraParameterValue(JsonUtils.deserialize(str3)));
        }
    }

    public static void setMRecCustomData(String str, String str2) {
        if (!initializeSdkCalled) {
            logUninitializedAccessError("setMRecCustomData");
        } else {
            getAdManager().setMRecCustomData(str.trim(), str2);
        }
    }

    public static String getMRecLayout(String str) {
        if (!initializeSdkCalled) {
            logUninitializedAccessError("GetMRecLayout");
            return "";
        }
        return getAdManager().getMRecLayout(str.trim());
    }

    public static void loadInterstitial(String str) {
        if (!initializeSdkCalled) {
            logUninitializedAccessError("LoadInterstitial");
        } else {
            getAdManager().loadInterstitial(str.trim());
        }
    }

    public static boolean isInterstitialReady(String str) {
        if (!initializeSdkCalled) {
            logUninitializedAccessError("IsInterstitialReady");
            return false;
        }
        return getAdManager().isInterstitialReady(str.trim());
    }

    public static void showInterstitial(String str, String str2, String str3) {
        if (!initializeSdkCalled) {
            logUninitializedAccessError("ShowInterstitial");
        } else {
            getAdManager().showInterstitial(str.trim(), str2, str3);
        }
    }

    public static void setInterstitialExtraParameter(String str, String str2, String str3) {
        if (!initializeSdkCalled) {
            logUninitializedAccessError("SetInterstitialExtraParameter");
        } else {
            getAdManager().setInterstitialExtraParameter(str.trim(), str2, str3);
        }
    }

    public static void setInterstitialLocalExtraParameter(String str, String str2, Object obj) {
        if (!initializeSdkCalled) {
            logUninitializedAccessError("SetInterstitialLocalExtraParameter");
        } else {
            getAdManager().setInterstitialLocalExtraParameter(str.trim(), str2, obj);
        }
    }

    public static void setInterstitialLocalExtraParameterJson(String str, String str2, String str3) {
        if (!initializeSdkCalled) {
            logUninitializedAccessError("SetInterstitialLocalExtraParameter");
        } else {
            getAdManager().setInterstitialLocalExtraParameter(str.trim(), str2, getLocalExtraParameterValue(JsonUtils.deserialize(str3)));
        }
    }

    public static void loadAppOpenAd(String str) {
        if (!initializeSdkCalled) {
            logUninitializedAccessError("LoadAppOpenAd");
        } else {
            getAdManager().loadAppOpenAd(str.trim());
        }
    }

    public static boolean isAppOpenAdReady(String str) {
        if (!initializeSdkCalled) {
            logUninitializedAccessError("IsAppOpenAdReady");
            return false;
        }
        return getAdManager().isAppOpenAdReady(str.trim());
    }

    public static void showAppOpenAd(String str, String str2, String str3) {
        if (!initializeSdkCalled) {
            logUninitializedAccessError("ShowAppOpenAd");
        } else {
            getAdManager().showAppOpenAd(str.trim(), str2, str3);
        }
    }

    public static void setAppOpenAdExtraParameter(String str, String str2, String str3) {
        if (!initializeSdkCalled) {
            logUninitializedAccessError("SetAppOpenAdExtraParameter");
        } else {
            getAdManager().setAppOpenAdExtraParameter(str.trim(), str2, str3);
        }
    }

    public static void setAppOpenAdLocalExtraParameter(String str, String str2, Object obj) {
        if (!initializeSdkCalled) {
            logUninitializedAccessError("SetAppOpenAdLocalExtraParameter");
        } else {
            getAdManager().setAppOpenAdLocalExtraParameter(str.trim(), str2, obj);
        }
    }

    public static void setAppOpenAdLocalExtraParameterJson(String str, String str2, String str3) {
        if (!initializeSdkCalled) {
            logUninitializedAccessError("SetAppOpenAdLocalExtraParameter");
        } else {
            getAdManager().setAppOpenAdLocalExtraParameter(str.trim(), str2, getLocalExtraParameterValue(JsonUtils.deserialize(str3)));
        }
    }

    public static void loadRewardedAd(String str) {
        if (!initializeSdkCalled) {
            logUninitializedAccessError("LoadRewardedAd");
        } else {
            getAdManager().loadRewardedAd(str.trim());
        }
    }

    public static boolean isRewardedAdReady(String str) {
        if (!initializeSdkCalled) {
            logUninitializedAccessError("IsRewardedAdReady");
            return false;
        }
        return getAdManager().isRewardedAdReady(str.trim());
    }

    public static void showRewardedAd(String str, String str2, String str3) {
        if (!initializeSdkCalled) {
            logUninitializedAccessError("ShowRewardedAd");
        } else {
            getAdManager().showRewardedAd(str.trim(), str2, str3);
        }
    }

    public static void setRewardedAdExtraParameter(String str, String str2, String str3) {
        if (!initializeSdkCalled) {
            logUninitializedAccessError("SetRewardedAdExtraParameter");
        } else {
            getAdManager().setRewardedAdExtraParameter(str.trim(), str2, str3);
        }
    }

    public static void setRewardedAdLocalExtraParameter(String str, String str2, Object obj) {
        if (!initializeSdkCalled) {
            logUninitializedAccessError("SetRewardedAdLocalExtraParameter");
        } else {
            getAdManager().setRewardedAdLocalExtraParameter(str.trim(), str2, obj);
        }
    }

    public static void setRewardedAdLocalExtraParameterJson(String str, String str2, String str3) {
        if (!initializeSdkCalled) {
            logUninitializedAccessError("SetRewardedAdLocalExtraParameter");
        } else {
            getAdManager().setRewardedAdLocalExtraParameter(str.trim(), str2, getLocalExtraParameterValue(JsonUtils.deserialize(str3)));
        }
    }

    public static void loadRewardedInterstitialAd(String str) {
        if (!initializeSdkCalled) {
            logUninitializedAccessError("LoadRewardedInterstitialAd");
        } else {
            getAdManager().loadRewardedInterstitialAd(str.trim());
        }
    }

    public static boolean isRewardedInterstitialAdReady(String str) {
        if (!initializeSdkCalled) {
            logUninitializedAccessError("IsRewardedInterstitialAdReady");
            return false;
        }
        return getAdManager().isRewardedInterstitialAdReady(str.trim());
    }

    public static void showRewardedInterstitialAd(String str, String str2, String str3) {
        if (!initializeSdkCalled) {
            logUninitializedAccessError("ShowRewardedInterstitialAd");
        } else {
            getAdManager().showRewardedInterstitialAd(str.trim(), str2, str3);
        }
    }

    public static void setRewardedInterstitialAdExtraParameter(String str, String str2, String str3) {
        if (!initializeSdkCalled) {
            logUninitializedAccessError("SetRewardedInterstitialAdExtraParameter");
        } else {
            getAdManager().setRewardedInterstitialAdExtraParameter(str.trim(), str2, str3);
        }
    }

    public static void setRewardedInterstitialAdLocalExtraParameter(String str, String str2, Object obj) {
        if (!initializeSdkCalled) {
            logUninitializedAccessError("SetRewardedInterstitialAdLocalExtraParameter");
        } else {
            getAdManager().setRewardedInterstitialAdLocalExtraParameter(str.trim(), str2, obj);
        }
    }

    public static void setRewardedInterstitialAdLocalExtraParameterJson(String str, String str2, String str3) {
        if (!initializeSdkCalled) {
            logUninitializedAccessError("SetRewardedInterstitialAdLocalExtraParameter");
        } else {
            getAdManager().setRewardedInterstitialAdLocalExtraParameter(str.trim(), str2, getLocalExtraParameterValue(JsonUtils.deserialize(str3)));
        }
    }

    public static void trackEvent(String str, String str2) {
        if (!initializeSdkCalled) {
            logUninitializedAccessError("TrackEvent");
        } else {
            getAdManager().trackEvent(str, str2);
        }
    }

    public static boolean isTablet() {
        return AppLovinSdkUtils.isTablet(Utils.getCurrentActivity());
    }

    public static boolean isPhysicalDevice() {
        return !AppLovinSdkUtils.isEmulator();
    }

    public static int getTcfVendorConsentStatus(int i) {
        return getConsentStatusValue(AppLovinPrivacySettings.getTcfVendorConsentStatus(i));
    }

    public static int getAdditionalConsentStatus(int i) {
        return getConsentStatusValue(AppLovinPrivacySettings.getAdditionalConsentStatus(i));
    }

    public static int getPurposeConsentStatus(int i) {
        return getConsentStatusValue(AppLovinPrivacySettings.getPurposeConsentStatus(i));
    }

    public static int getSpecialFeatureOptInStatus(int i) {
        return getConsentStatusValue(AppLovinPrivacySettings.getSpecialFeatureOptInStatus(i));
    }

    public static boolean isMuted() {
        return getSdk().getSettings().isMuted();
    }

    public static void setMuted(boolean z) {
        getSdk().getSettings().setMuted(z);
    }

    public static float getScreenDensity() {
        return Utils.getCurrentActivity().getResources().getDisplayMetrics().density;
    }

    public static String getAdInfo(String str) {
        return getAdManager().getAdInfo(str.trim());
    }

    public static String getAdValue(String str, String str2) {
        return getAdManager().getAdValue(str.trim(), str2);
    }

    public static void setVerboseLogging(boolean z) {
        getSdk().getSettings().setVerboseLogging(z);
    }

    public static boolean isVerboseLoggingEnabled() {
        return getSdk().getSettings().isVerboseLoggingEnabled();
    }

    public static void setCreativeDebuggerEnabled(boolean z) {
        getSdk().getSettings().setCreativeDebuggerEnabled(z);
    }

    public static void setExceptionHandlerEnabled(boolean z) {
        if (initializeSdkCalled) {
            e("Exception handler must be enabled/disabled before MAX SDK is initialized");
        } else {
            getInitConfigurationBuilder().setExceptionHandlerEnabled(z);
        }
    }

    public static void setExtraParameter(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            e("ERROR: Failed to set extra parameter for null or empty key: \" + key");
            return;
        }
        if ("disable_all_logs".equals(str)) {
            disableAllLogs = Boolean.parseBoolean(str2);
        }
        getSdk().getSettings().setExtraParameter(str, str2);
    }

    public static int[] getSafeAreaInsets() {
        MaxUnityAdManager.Insets safeInsets = getAdManager().getSafeInsets();
        return new int[]{safeInsets.left, safeInsets.top, safeInsets.right, safeInsets.bottom};
    }

    public static void showCmpForExistingUser() {
        if (!initializeSdkCalled) {
            logUninitializedAccessError("showCmpForExistingUser");
        } else {
            getAdManager().showCmpForExistingUser();
        }
    }

    public static boolean hasSupportedCmp() {
        if (!initializeSdkCalled) {
            logUninitializedAccessError("hasSupportedCmp");
            return false;
        }
        return getSdk().getCmpService().hasSupportedCmp();
    }

    public static void setTestDeviceAdvertisingIds(String[] strArr) {
        if (initializeSdkCalled) {
            e("Test device advertising IDs must be set before MAX SDK is initialized");
        } else {
            getInitConfigurationBuilder().setTestDeviceAdvertisingIds(Arrays.asList(strArr));
        }
    }

    public static float getAdaptiveBannerHeight(float f) {
        return MaxUnityAdManager.getAdaptiveBannerHeight(f);
    }

    private static Object getLocalExtraParameterValue(JSONObject jSONObject) {
        Object object = JsonUtils.getObject(jSONObject, "value", null);
        if (object instanceof JSONArray) {
            return JsonUtils.optList((JSONArray) object, null);
        }
        if (!(object instanceof JSONObject)) {
            return object;
        }
        try {
            return JsonUtils.toStringObjectMap((JSONObject) object);
        } catch (JSONException e) {
            e("Failed to create map from local extra parameter data: " + jSONObject + "Exception: " + e);
            return null;
        }
    }

    private static int getConsentStatusValue(Boolean bool) {
        if (bool != null) {
            return bool.booleanValue() ? 1 : 0;
        }
        return -1;
    }

    private static MaxSegmentCollection getMaxSegmentCollection(String str) {
        MaxSegmentCollection.Builder builder = MaxSegmentCollection.builder();
        JSONArray jSONArray = JsonUtils.getJSONArray(JsonUtils.deserialize(str), "segments", null);
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = JsonUtils.getJSONObject(jSONArray, i, (JSONObject) null);
            builder.addSegment(new MaxSegment(JsonUtils.getInt(jSONObject, "key", -1), JsonUtils.toIntegerList(JsonUtils.getJSONArray(jSONObject, "values", null))));
        }
        return builder.build();
    }

    private static AppLovinSdkInitializationConfiguration.Builder createInitConfigurationBuilder() {
        return AppLovinSdkInitializationConfiguration.builder(getSdk().getSettings().getExtraParameters().get("sdk_key"), Utils.getCurrentActivity());
    }

    private static void logUninitializedAccessError(String str) {
        e("[MaxUnityPlugin] ERROR: Failed to execute " + str + "() - please ensure the AppLovin MAX Unity Plugin has been initialized by calling 'MaxSdk.InitializeSdk();'!");
    }

    private static void d(String str) {
        if (isDisableAllLogs()) {
            return;
        }
        Log.d(SDK_TAG, "[MaxUnityPlugin] " + str);
    }

    private static void e(String str) {
        if (isDisableAllLogs()) {
            return;
        }
        Log.e(SDK_TAG, "[MaxUnityPlugin] " + str);
    }
}
