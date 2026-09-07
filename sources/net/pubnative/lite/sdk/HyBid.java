package net.pubnative.lite.sdk;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import net.pubnative.lite.sdk.analytics.CrashController;
import net.pubnative.lite.sdk.analytics.ReportingController;
import net.pubnative.lite.sdk.analytics.ReportingEvent;
import net.pubnative.lite.sdk.analytics.ReportingEventCallback;
import net.pubnative.lite.sdk.api.PNApiClient;
import net.pubnative.lite.sdk.api.SDKConfigAPiClient;
import net.pubnative.lite.sdk.browser.BrowserManager;
import net.pubnative.lite.sdk.db.OnDatabaseResetListener;
import net.pubnative.lite.sdk.location.HyBidLocationManager;
import net.pubnative.lite.sdk.models.AdSize;
import net.pubnative.lite.sdk.models.IntegrationType;
import net.pubnative.lite.sdk.models.PNAdRequest;
import net.pubnative.lite.sdk.models.PNAdRequestFactory;
import net.pubnative.lite.sdk.prefs.HyBidPreferences;
import net.pubnative.lite.sdk.prefs.SessionImpressionPrefs;
import net.pubnative.lite.sdk.utils.AdTopicsAPIManager;
import net.pubnative.lite.sdk.utils.AtomManager;
import net.pubnative.lite.sdk.utils.Logger;
import net.pubnative.lite.sdk.utils.PNApiUrlComposer;
import net.pubnative.lite.sdk.viewability.ViewabilityManager;
import net.pubnative.lite.sdk.vpaid.VideoAdCache;
import net.pubnative.lite.sdk.vpaid.enums.AudioState;
import net.pubnative.lite.sdk.vpaid.utils.FileUtils;

/* JADX INFO: loaded from: classes5.dex */
public class HyBid {
    public static final String HYBID_VERSION = "3.3.0";
    public static final String OMSDK_VERSION = "1.5.1";
    public static final String OM_PARTNER_NAME = "pubnativenet";
    private static final String TAG = "HyBid";
    private static boolean isDiagnosticsEnabled = false;
    private static AdCache sAdCache = null;
    private static String sAge = null;
    private static PNApiClient sApiClient = null;
    private static String sAppToken = null;
    private static String sAppVersion = null;
    private static boolean sAtomEnabled = false;
    private static BrowserManager sBrowserManager = null;
    private static String sBundleId = null;
    private static String sContentAgeRating = null;
    private static boolean sCoppaEnabled = false;
    private static CrashController sCrashController = null;
    private static String sDeveloperDomain = null;
    private static DeviceInfo sDeviceInfo = null;
    private static DiagnosticsManager sDiagnosticsManager = null;
    private static final boolean sEventLoggingEndpointEnabled = false;
    private static String sGender = null;
    private static String sIabCategory = null;
    private static String sIabSubcategory = null;
    private static boolean sInitialized = false;
    private static String sKeywords = null;
    private static HyBidLocationManager sLocationManager = null;
    private static boolean sLocationTrackingEnabled = true;
    private static boolean sLocationUpdatesEnabled = true;
    private static ReportingController sReportingController;
    private static boolean sReportingEnabled;
    private static SDKConfigAPiClient sSDKConfigAPiClient;
    private static boolean sTestMode;
    private static TopicManager sTopicManager;
    private static boolean sTopicsApiEnabled;
    private static UserDataManager sUserDataManager;
    private static VgiIdManager sVgiIdManager;
    private static VideoAdCache sVideoAdCache;
    private static ViewabilityManager sViewabilityManager;
    private static Integer skipXmlResource = Integer.valueOf(net.pubnative.lite.sdk.core.R.mipmap.skip);
    private static Integer normalCloseXmlResource = -1;
    private static Integer pressedCloseXmlResource = -1;
    private static AudioState sVideoAudioState = AudioState.ON;
    private static Boolean mIsSDKConfigFetched = false;

    public interface InitialisationListener {
        void onInitialisationFinished(boolean z);
    }

    public static void initialize(String str, Application application) {
        initialize(str, application, null);
    }

    public static void initialize(final String str, final Application application, final InitialisationListener initialisationListener) {
        long jCurrentTimeMillis;
        Boolean boolIsTopicsAPIEnabled;
        sAppToken = str;
        try {
            jCurrentTimeMillis = application.getApplicationContext().getPackageManager().getPackageInfo(application.getApplicationContext().getPackageName(), 0).firstInstallTime;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            jCurrentTimeMillis = System.currentTimeMillis();
        }
        HyBidPreferences hyBidPreferences = new HyBidPreferences(application.getApplicationContext());
        hyBidPreferences.setAppFirstInstalledTime(String.valueOf(jCurrentTimeMillis));
        hyBidPreferences.setSessionTimeStamp(System.currentTimeMillis(), new OnDatabaseResetListener() { // from class: net.pubnative.lite.sdk.HyBid$$ExternalSyntheticLambda0
            @Override // net.pubnative.lite.sdk.db.OnDatabaseResetListener
            public final void onDatabaseReset() {
                new SessionImpressionPrefs(application.getApplicationContext()).nukePrefs();
            }
        }, HyBidPreferences.TIMESTAMP.NORMAL);
        sBundleId = application.getPackageName();
        sApiClient = new PNApiClient(application);
        FileUtils.initParentDirAsync(application.getApplicationContext());
        if (application.getSystemService("location") != null) {
            sLocationManager = new HyBidLocationManager(application);
            if (isLocationTrackingEnabled() && areLocationUpdatesEnabled()) {
                sLocationManager.startLocationUpdates();
            }
        }
        sUserDataManager = new UserDataManager(application.getApplicationContext());
        sAdCache = new AdCache();
        sVideoAdCache = new VideoAdCache();
        sBrowserManager = new BrowserManager();
        sVgiIdManager = new VgiIdManager(application.getApplicationContext());
        sDiagnosticsManager = new DiagnosticsManager(application.getApplicationContext(), getReportingController());
        sViewabilityManager = new ViewabilityManager(application);
        if (Build.VERSION.SDK_INT >= 33 && (boolIsTopicsAPIEnabled = AdTopicsAPIManager.isTopicsAPIEnabled(application.getApplicationContext())) != null && boolIsTopicsAPIEnabled.booleanValue()) {
            setTopicsApiEnabled(true);
            sTopicManager = new TopicManager(application.getApplicationContext());
        }
        if (sCrashController == null) {
            sCrashController = new CrashController();
        }
        if (sDeviceInfo == null) {
            DeviceInfo deviceInfo = new DeviceInfo(application.getApplicationContext());
            sDeviceInfo = deviceInfo;
            deviceInfo.initialize(new DeviceInfo.Listener() { // from class: net.pubnative.lite.sdk.HyBid$$ExternalSyntheticLambda1
                @Override // net.pubnative.lite.sdk.DeviceInfo.Listener
                public final void onInfoLoaded() {
                    HyBid.lambda$initialize$1(str, initialisationListener);
                }
            });
        } else if (initialisationListener != null) {
            initialisationListener.onInitialisationFinished(true);
        }
        sInitialized = true;
    }

    static /* synthetic */ void lambda$initialize$1(String str, InitialisationListener initialisationListener) {
        if (getReportingController() != null && isReportingEnabled().booleanValue()) {
            ReportingEvent reportingEvent = new ReportingEvent();
            reportingEvent.setEventType("init");
            reportingEvent.setAppToken(str);
            getReportingController().reportEvent(reportingEvent);
        }
        if (initialisationListener != null) {
            initialisationListener.onInitialisationFinished(true);
        }
    }

    private static void fetchSDKConfig() {
        if (mIsSDKConfigFetched.booleanValue()) {
            return;
        }
        sSDKConfigAPiClient.fetchConfig(new SDKConfigAPiClient.AtomConfigListener() { // from class: net.pubnative.lite.sdk.HyBid$$ExternalSyntheticLambda2
            @Override // net.pubnative.lite.sdk.api.SDKConfigAPiClient.AtomConfigListener
            public final void onAtomValueFetched(Boolean bool) {
                HyBid.lambda$fetchSDKConfig$2(bool);
            }
        });
    }

    static /* synthetic */ void lambda$fetchSDKConfig$2(Boolean bool) {
        mIsSDKConfigFetched = true;
        AtomManager.setAtomSDKConfig(bool);
    }

    public static String getHyBidVersion() {
        return "3.3.0";
    }

    public static synchronized String getAppToken() {
        if (!isInitialized()) {
            Log.v(TAG, "HyBid SDK is not initiated yet. Please initiate it before using getAppToken()");
        }
        return sAppToken;
    }

    public static synchronized void setAppToken(String str) {
        sAppToken = str;
    }

    public static String getBundleId() {
        return sBundleId;
    }

    public static PNApiClient getApiClient() {
        if (!isInitialized()) {
            Log.v(TAG, "HyBid SDK is not initiated yet. Please initiate it before using getApiClient()");
        }
        return sApiClient;
    }

    public static DeviceInfo getDeviceInfo() {
        if (!isInitialized()) {
            Log.v(TAG, "HyBid SDK is not initiated yet. Please initiate it before using getDeviceInfo()");
        }
        return sDeviceInfo;
    }

    public static UserDataManager getUserDataManager() {
        if (!isInitialized()) {
            Log.v(TAG, "HyBid SDK is not initiated yet. Please initiate it before using getUserDataManager()");
        }
        return sUserDataManager;
    }

    public static ViewabilityManager getViewabilityManager() {
        if (!isInitialized()) {
            Log.v(TAG, "HyBid SDK is not initiated yet. Please initiate it before using getViewabilityManager()");
        }
        return sViewabilityManager;
    }

    public static VgiIdManager getVgiIdManager() {
        if (!isInitialized()) {
            Log.v(TAG, "HyBid SDK is not initiated yet. Please initiate it before using getVgiIdManager()");
        }
        return sVgiIdManager;
    }

    public static HyBidLocationManager getLocationManager() {
        if (!isInitialized()) {
            Log.v(TAG, "HyBid SDK is not initiated yet. Please initiate it before using getLocationManager()");
        }
        return sLocationManager;
    }

    public static AdCache getAdCache() {
        if (!isInitialized()) {
            Log.v(TAG, "HyBid SDK is not initiated yet. Please initiate it before using getAdCache()");
        }
        return sAdCache;
    }

    public static synchronized VideoAdCache getVideoAdCache() {
        if (!isInitialized()) {
            Log.v(TAG, "HyBid SDK is not initiated yet. Please initiate it before using getVideoAdCache()");
        }
        return sVideoAdCache;
    }

    public static BrowserManager getBrowserManager() {
        if (!isInitialized()) {
            Log.v(TAG, "HyBid SDK is not initiated yet. Please initiate it before using getBrowserManager()");
        }
        return sBrowserManager;
    }

    public static TopicManager getTopicManager() {
        if (!isInitialized()) {
            Log.v(TAG, "HyBid SDK is not initiated yet. Please initiate it before using getTopicManager()");
        }
        return sTopicManager;
    }

    public static boolean isInitialized() {
        return sInitialized;
    }

    public static boolean isViewabilityMeasurementActivated() {
        ViewabilityManager viewabilityManager = sViewabilityManager;
        return viewabilityManager != null && viewabilityManager.isViewabilityMeasurementActivated();
    }

    public static void setCoppaEnabled(boolean z) {
        sCoppaEnabled = z;
    }

    public static boolean isCoppaEnabled() {
        return sCoppaEnabled;
    }

    public static void setTestMode(boolean z) {
        sTestMode = z;
    }

    public static boolean isTestMode() {
        return sTestMode;
    }

    public static void setLocationUpdatesEnabled(boolean z) {
        sLocationUpdatesEnabled = z;
    }

    public static boolean areLocationUpdatesEnabled() {
        return sLocationUpdatesEnabled;
    }

    public static void setLocationTrackingEnabled(boolean z) {
        sLocationTrackingEnabled = z;
    }

    public static boolean isLocationTrackingEnabled() {
        return sLocationTrackingEnabled;
    }

    public static void setAge(String str) {
        sAge = str;
    }

    public static String getAge() {
        return sAge;
    }

    public static void setGender(String str) {
        sGender = str;
    }

    public static String getGender() {
        return sGender;
    }

    public static void setKeywords(String str) {
        sKeywords = str;
    }

    public static String getKeywords() {
        return sKeywords;
    }

    public static void setLogLevel(Logger.Level level) {
        Logger.setLogLevel(level);
    }

    public static ReportingController getReportingController() {
        if (sReportingController == null) {
            sReportingController = new ReportingController();
        }
        return sReportingController;
    }

    public static DiagnosticsManager getDiagnosticsManager() {
        return sDiagnosticsManager;
    }

    public static void addReportingCallback(ReportingEventCallback reportingEventCallback) {
        getReportingController().addCallback(reportingEventCallback);
    }

    public static boolean removeReportingCallback(ReportingEventCallback reportingEventCallback) {
        return getReportingController().removeCallback(reportingEventCallback);
    }

    public static void setDiagnosticsEnabled(Boolean bool) {
        isDiagnosticsEnabled = bool.booleanValue();
    }

    public static Boolean isDiagnosticsEnabled() {
        return Boolean.valueOf(isDiagnosticsEnabled);
    }

    public static void setReportingEnabled(Boolean bool) {
        sReportingEnabled = bool.booleanValue();
    }

    public static Boolean isReportingEnabled() {
        return Boolean.valueOf(sReportingEnabled);
    }

    public static void setTopicsApiEnabled(Boolean bool) {
        sTopicsApiEnabled = bool.booleanValue();
    }

    public static Boolean isTopicsApiEnabled() {
        return Boolean.valueOf(sTopicsApiEnabled);
    }

    public static void setAtomEnabled(Boolean bool) {
        sAtomEnabled = bool.booleanValue();
    }

    public static Boolean isAtomEnabled() {
        return Boolean.valueOf(sAtomEnabled);
    }

    public static void reportException(Exception exc) {
        if (sCrashController == null || getReportingController() == null || !isReportingEnabled().booleanValue()) {
            return;
        }
        getReportingController().reportEvent(sCrashController.formatException(exc));
    }

    public static void reportException(Throwable th) {
        if (sCrashController == null || getReportingController() == null || !isReportingEnabled().booleanValue()) {
            return;
        }
        getReportingController().reportEvent(sCrashController.formatException(th));
    }

    public static void setIabCategory(String str) {
        sIabCategory = str;
    }

    public static String getIabCategory() {
        return sIabCategory;
    }

    public static void setIabSubcategory(String str) {
        sIabSubcategory = str;
    }

    public static String getsIabSubcategory() {
        return sIabSubcategory;
    }

    public static void setAppVersion(String str) {
        sAppVersion = str;
    }

    public static String getAppVersion() {
        return sAppVersion;
    }

    public static void setDeveloperDomain(String str) {
        sDeveloperDomain = str;
    }

    public static String getDeveloperDomain() {
        return sDeveloperDomain;
    }

    public static void setContentAgeRating(String str) {
        sContentAgeRating = str;
    }

    public static String getContentAgeRating() {
        return sContentAgeRating;
    }

    @Deprecated
    public static void setVideoAudioStatus(AudioState audioState) {
        sVideoAudioState = audioState;
    }

    @Deprecated
    public static AudioState getVideoAudioStatus() {
        return sVideoAudioState;
    }

    public static String getCustomRequestSignalData() {
        return getCustomRequestSignalData(null);
    }

    public static String getCustomRequestSignalData(String str) {
        return getCustomRequestSignalData(null, str);
    }

    public static String getCustomRequestSignalData(Context context, String str) {
        PNAdRequestFactory pNAdRequestFactory = new PNAdRequestFactory();
        if (isInitialized()) {
            return PNApiUrlComposer.getUrlQuery(getApiClient().getApiUrl(), (PNAdRequest) pNAdRequestFactory.buildRequest("", "", AdSize.SIZE_INTERSTITIAL, "", true, IntegrationType.IN_APP_BIDDING, str, 0, false));
        }
        if (context == null) {
            return "";
        }
        return PNApiUrlComposer.getUrlQuery("https://api.pubnative.net/", (PNAdRequest) pNAdRequestFactory.buildRequest(context, "", "", AdSize.SIZE_INTERSTITIAL, "", true, IntegrationType.IN_APP_BIDDING, str, 0, false));
    }

    public static String getSDKVersionInfo() {
        return new DisplayManager().getDisplayManagerVersion(IntegrationType.IN_APP_BIDDING);
    }

    public static String getSDKVersionInfo(IntegrationType integrationType) {
        if (integrationType == null) {
            integrationType = IntegrationType.IN_APP_BIDDING;
        }
        return new DisplayManager().getDisplayManagerVersion(integrationType);
    }

    public static void setSkipXmlResource(Integer num) {
        skipXmlResource = num;
    }

    public static Integer getSkipXmlResource() {
        return skipXmlResource;
    }

    public static void setCloseXmlResource(Integer num, Integer num2) {
        normalCloseXmlResource = num;
        pressedCloseXmlResource = num2;
    }

    public static Integer getNormalCloseXmlResource() {
        return normalCloseXmlResource;
    }

    public static Integer getPressedCloseXmlResource() {
        return pressedCloseXmlResource;
    }
}
