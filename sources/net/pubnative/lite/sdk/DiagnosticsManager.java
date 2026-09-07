package net.pubnative.lite.sdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import net.pubnative.lite.sdk.analytics.ReportingController;
import net.pubnative.lite.sdk.analytics.ReportingEvent;
import net.pubnative.lite.sdk.analytics.ReportingEventCallback;
import net.pubnative.lite.sdk.utils.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class DiagnosticsManager implements ReportingEventCallback {
    private static final String ADMOB_MEDIATION_BANNER_ADAPTER_CLASS = "net.pubnative.hybid.adapters.admob.mediation.HyBidMediationBannerCustomEvent";
    private static final String ADMOB_MEDIATION_INTERSTITIAL_ADAPTER_CLASS = "net.pubnative.hybid.adapters.admob.mediation.HyBidMediationInterstitialCustomEvent";
    private static final String ADMOB_MEDIATION_LEADERBOARD_ADAPTER_CLASS = "net.pubnative.hybid.adapters.admob.mediation.HyBidMediationLeaderboardCustomEvent";
    private static final String ADMOB_MEDIATION_MRECT_ADAPTER_CLASS = "net.pubnative.hybid.adapters.admob.mediation.HyBidMediationMRectCustomEvent";
    private static final String ADMOB_MEDIATION_NATIVE_ADAPTER_CLASS = "net.pubnative.hybid.adapters.admob.mediation.HyBidMediationNativeCustomEvent";
    private static final String ADMOB_MEDIATION_REWARDED_ADAPTER_CLASS = "net.pubnative.hybid.adapters.admob.mediation.HyBidMediationRewardedVideoCustomEvent";
    private static final String FORMAT_BANNER_CLASS = "net.pubnative.lite.sdk.views.HyBidAdView";
    private static final String FORMAT_INTERSTITIAL_CLASS = "net.pubnative.lite.sdk.interstitial.HyBidInterstitialAd";
    private static final String FORMAT_NATIVE_CLASS = "net.pubnative.lite.sdk.request.HyBidNativeAdRequest";
    private static final String FORMAT_REWARDED_CLASS = "net.pubnative.lite.sdk.rewarded.HyBidRewardedAd";
    private static final String GAM_HEADER_BIDDING_BANNER_ADAPTER_CLASS = "net.pubnative.lite.adapters.dfp.HyBidDFPBannerCustomEvent";
    private static final String GAM_HEADER_BIDDING_INTERSTITIAL_ADAPTER_CLASS = "net.pubnative.lite.adapters.dfp.HyBidDFPInterstitialCustomEvent";
    private static final String GAM_HEADER_BIDDING_LEADERBOARD_ADAPTER_CLASS = "net.pubnative.lite.adapters.dfp.HyBidDFPLeaderboardCustomEvent";
    private static final String GAM_HEADER_BIDDING_MRECT_ADAPTER_CLASS = "net.pubnative.lite.adapters.dfp.HyBidDFPMRectCustomEvent";
    private static final String TAG = "DiagnosticsManager";
    private final String googleAdsPackageId;

    public DiagnosticsManager(Context context, ReportingController reportingController) {
        if (context != null) {
            this.googleAdsPackageId = getGoogleAdsAppId(context);
        } else {
            this.googleAdsPackageId = "";
        }
        if (reportingController != null) {
            reportingController.addCallback(this);
        }
    }

    @Override // net.pubnative.lite.sdk.analytics.ReportingEventCallback
    public void onEvent(ReportingEvent reportingEvent) {
        if (reportingEvent == null || TextUtils.isEmpty(reportingEvent.getEventType()) || !reportingEvent.getEventType().equals("init") || !isDiagnosticsEnabled().booleanValue()) {
            return;
        }
        reportInitialisation(reportingEvent);
    }

    private Boolean isDiagnosticsEnabled() {
        return HyBid.isDiagnosticsEnabled();
    }

    private void reportInitialisation(ReportingEvent reportingEvent) {
        printDiagnosticsLog(reportingEvent);
    }

    public void printDiagnosticsLog() {
        Logger.d(TAG, getDiagnosticsLog(null));
    }

    public void printDiagnosticsLog(ReportingEvent reportingEvent) {
        Logger.d(TAG, getDiagnosticsLog(reportingEvent));
    }

    private synchronized String getDiagnosticsLog(ReportingEvent reportingEvent) {
        StringBuilder sb;
        sb = new StringBuilder("\nHyBid Diagnostics Log:\n\n");
        if (HyBid.isInitialized()) {
            sb.append("Event: ").append(reportingEvent.getEventType()).append("\nVersion: ");
            sb.append(HyBid.getHyBidVersion()).append("\nBundle Id: ");
            sb.append(HyBid.getBundleId()).append("\nApp Token: ");
            sb.append(HyBid.getAppToken()).append("\nTest Mode: ");
            sb.append(HyBid.isTestMode() ? "true" : "false").append("\nCOPPA: ");
            sb.append(HyBid.isCoppaEnabled() ? "true" : "false").append("\nVideo Audio State: ");
            sb.append(HyBid.getVideoAudioStatus().getStateName()).append("\nLocation tracking (if permission): ");
            sb.append(HyBid.isLocationTrackingEnabled() ? "true" : "false").append("\nLocation updates (if permission): ");
            sb.append(HyBid.areLocationUpdatesEnabled() ? "true" : "false").append("\nTime: ");
            sb.append(System.currentTimeMillis()).append("\nDevice OS: Android\nDevice OS Version: ");
            sb.append(Build.VERSION.SDK_INT).append("\nDevice Model: ");
            sb.append(Build.MODEL).append("\nDevice Manufacturer: ");
            sb.append(Build.MANUFACTURER).append("\n");
            if (!TextUtils.isEmpty(this.googleAdsPackageId)) {
                sb.append("Google Ads Application Id: ").append(this.googleAdsPackageId).append("\n");
            }
            sb.append("Available formats:\n").append(getAvailableFormats());
            sb.append("Available adapters:\n").append(getAvailableAdapters());
        } else {
            sb.append("HyBid SDK has not been initialised\n");
        }
        sb.append("\n-----------------------------------------------------------------");
        return sb.toString();
    }

    public static synchronized String generatePlacementDiagnosticsLog(Context context, JSONObject jSONObject) {
        StringBuilder sb;
        sb = new StringBuilder("\nHyBid Placement Diagnostics Log:\n\n");
        if (jSONObject != null && jSONObject.length() != 0) {
            try {
                sb.append(jSONObject.toString(2));
                sb.append("\n-----------------------------------------------------------------");
            } catch (JSONException e) {
                Logger.e(TAG, "Error parsing placement params: ", e);
                sb.append("Placement data could not be loaded\n-----------------------------------------------------------------");
            }
        }
        return sb.toString();
    }

    public void printPlacementDiagnosticsLog(Context context, JSONObject jSONObject) {
        if (HyBid.isDiagnosticsEnabled().booleanValue()) {
            Logger.d(TAG, generatePlacementDiagnosticsLog(context, jSONObject));
        }
    }

    private String getAvailableFormats() {
        StringBuilder sb = new StringBuilder();
        if (checkAvailableClass(FORMAT_BANNER_CLASS)) {
            sb.append("\tBanner\n");
        }
        if (checkAvailableClass(FORMAT_INTERSTITIAL_CLASS)) {
            sb.append("\tInterstitial\n");
        }
        if (checkAvailableClass(FORMAT_REWARDED_CLASS)) {
            sb.append("\tRewarded\n");
        }
        if (checkAvailableClass(FORMAT_NATIVE_CLASS)) {
            sb.append("\tNative\n");
        }
        if (sb.length() == 0) {
            sb.append("\t").append("No formats available").append("\n");
        }
        return sb.toString();
    }

    private String getAvailableAdapters() {
        StringBuilder sb = new StringBuilder();
        if (checkAvailableClass(ADMOB_MEDIATION_BANNER_ADAPTER_CLASS)) {
            sb.append("\tnet.pubnative.hybid.adapters.admob.mediation.HyBidMediationBannerCustomEvent\n");
        }
        if (checkAvailableClass(ADMOB_MEDIATION_MRECT_ADAPTER_CLASS)) {
            sb.append("\tnet.pubnative.hybid.adapters.admob.mediation.HyBidMediationMRectCustomEvent\n");
        }
        if (checkAvailableClass(ADMOB_MEDIATION_LEADERBOARD_ADAPTER_CLASS)) {
            sb.append("\tnet.pubnative.hybid.adapters.admob.mediation.HyBidMediationLeaderboardCustomEvent\n");
        }
        if (checkAvailableClass(ADMOB_MEDIATION_INTERSTITIAL_ADAPTER_CLASS)) {
            sb.append("\tnet.pubnative.hybid.adapters.admob.mediation.HyBidMediationInterstitialCustomEvent\n");
        }
        if (checkAvailableClass(ADMOB_MEDIATION_REWARDED_ADAPTER_CLASS)) {
            sb.append("\tnet.pubnative.hybid.adapters.admob.mediation.HyBidMediationRewardedVideoCustomEvent\n");
        }
        if (checkAvailableClass(ADMOB_MEDIATION_NATIVE_ADAPTER_CLASS)) {
            sb.append("\tnet.pubnative.hybid.adapters.admob.mediation.HyBidMediationNativeCustomEvent\n");
        }
        if (checkAvailableClass(GAM_HEADER_BIDDING_BANNER_ADAPTER_CLASS)) {
            sb.append("\tnet.pubnative.lite.adapters.dfp.HyBidDFPBannerCustomEvent\n");
        }
        if (checkAvailableClass(GAM_HEADER_BIDDING_MRECT_ADAPTER_CLASS)) {
            sb.append("\tnet.pubnative.lite.adapters.dfp.HyBidDFPMRectCustomEvent\n");
        }
        if (checkAvailableClass(GAM_HEADER_BIDDING_LEADERBOARD_ADAPTER_CLASS)) {
            sb.append("\tnet.pubnative.lite.adapters.dfp.HyBidDFPLeaderboardCustomEvent\n");
        }
        if (checkAvailableClass(GAM_HEADER_BIDDING_INTERSTITIAL_ADAPTER_CLASS)) {
            sb.append("\tnet.pubnative.lite.adapters.dfp.HyBidDFPInterstitialCustomEvent\n");
        }
        if (sb.length() == 0) {
            sb.append("\t").append("No adapters available").append("\n");
        }
        return sb.toString();
    }

    private boolean checkAvailableClass(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private String getGoogleAdsAppId(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null && applicationInfo.metaData != null) {
                return applicationInfo.metaData.getString("com.google.android.gms.ads.APPLICATION_ID");
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return "";
    }
}
