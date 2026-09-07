package com.amazon.aps.ads;

import android.os.Bundle;
import com.amazon.aps.ads.model.ApsAdFormat;
import com.amazon.aps.shared.APSAnalytics;
import com.amazon.aps.shared.analytics.APSEventSeverity;
import com.amazon.aps.shared.analytics.APSEventType;
import com.amazon.aps.shared.util.APSSharedUtil;
import com.amazon.device.ads.DTBAdUtil;
import com.amazon.device.ads.SDKUtilities;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class ApsAdUtils {
    private static final String BID_INFO = "bidInfo";
    private static final String HEIGHT = "height";
    private static final String PRICEPOINT_ENCODED = "pricePointEncoded";
    private static final String UUID = "uuid";
    private static final String WIDTH = "width";
    private static boolean isDebugBuild;

    static {
        new ApsAdUtils();
    }

    private ApsAdUtils() {
        isDebugBuild = false;
    }

    public static boolean checkNullAndLogInvalidArg(Object... objArr) {
        try {
            APSSharedUtil.checkNullAndThrowException(objArr);
            return false;
        } catch (IllegalArgumentException e) {
            if (isDebugBuild) {
                throw e;
            }
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Invalid argument for calling the method", e);
            return true;
        }
    }

    public static String getBidIdFromCreative(String str) {
        String[] strArrSplit;
        if (str == null) {
            return null;
        }
        try {
            String[] strArrSplit2 = str.split("amzn.dtb.loadAd");
            if (strArrSplit2 == null || strArrSplit2.length < 2 || (strArrSplit = strArrSplit2[1].split(StringUtils.COMMA)) == null || strArrSplit.length < 2) {
                return null;
            }
            return strArrSplit[1].replace("\"", "").trim();
        } catch (Exception e) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Error getting bid id from creative", e);
            return null;
        }
    }

    public static JSONObject getUnityLevelPlayDataForBanner(String str, ApsAd apsAd) {
        checkNullAndLogInvalidArg(str, apsAd);
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(BID_INFO, apsAd.getBidInfo());
            jSONObject2.put(PRICEPOINT_ENCODED, apsAd.getPricePoint());
            jSONObject2.put("uuid", apsAd.getSlotUuid());
            jSONObject2.put("width", apsAd.getWidthFromAax());
            jSONObject2.put("height", apsAd.getHeightFromAax());
            jSONObject.put(str, jSONObject2);
        } catch (RuntimeException | JSONException e) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Error constructing the iron source banner object", e);
        }
        return jSONObject;
    }

    public static JSONObject getUnityLevelPlayDataForInterstitial(String str, ApsAd apsAd) {
        checkNullAndLogInvalidArg(str, apsAd);
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(BID_INFO, apsAd.getBidInfo());
            jSONObject2.put(PRICEPOINT_ENCODED, apsAd.getPricePoint());
            jSONObject2.put("uuid", apsAd.getSlotUuid());
            jSONObject.put(str, jSONObject2);
        } catch (RuntimeException | JSONException e) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Error constructing the iron source interstitial object", e);
        }
        return jSONObject;
    }

    public static AdManagerAdRequest.Builder createAdManagerAdRequestBuilder(ApsAd apsAd) {
        checkNullAndLogInvalidArg(apsAd);
        try {
            return DTBAdUtil.INSTANCE.createAdManagerAdRequestBuilder(apsAd);
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Error constructing the AdManagerAdRequest.Builder object in createAdManagerAdRequestBuilder", e);
            return null;
        }
    }

    public static void addApsAdInAdManagerAdRequest(AdManagerAdRequest adManagerAdRequest, ApsAd apsAd) {
        checkNullAndLogInvalidArg(adManagerAdRequest, apsAd);
        try {
            DTBAdUtil.INSTANCE.loadDTBParams(adManagerAdRequest, apsAd);
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Error loading the Aps params in the AdManagerAdRequest.Builder object in loadApsParamsInAdManagerAdRequest", e);
        }
    }

    public static void addApsAdInAdManagerAdRequestBuilder(AdManagerAdRequest.Builder builder, ApsAd apsAd) {
        checkNullAndLogInvalidArg(builder, apsAd);
        try {
            DTBAdUtil.INSTANCE.loadDTBParams(builder, apsAd);
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Error loading the Aps params in the AdManagerAdRequest.Builder object in loadApsParamsInAdManagerAdRequest", e);
        }
    }

    public static Bundle createAdMobInterstitialRequestBundle(String str) {
        checkNullAndLogInvalidArg(str);
        return DTBAdUtil.createAdMobInterstitialRequestBundle(str);
    }

    public static boolean isDebugBuild() {
        return isDebugBuild;
    }

    public static Bundle createAdMobInterstitialVideoRequestBundle(String str) {
        checkNullAndLogInvalidArg(str);
        return DTBAdUtil.createAdMobInterstitialVideoRequestBundle(str);
    }

    public static Bundle createAdMobBannerRequestBundle(String str, ApsAdFormat apsAdFormat) {
        checkNullAndLogInvalidArg(str, apsAdFormat);
        return DTBAdUtil.createAdMobBannerRequestBundle(str, ApsAdFormatUtils.getWidth(apsAdFormat), ApsAdFormatUtils.getHeight(apsAdFormat));
    }

    public static boolean isTelSupported() {
        return SDKUtilities.isTelSupported();
    }

    static void throwExceptionOrRemoteLog(String str) {
        if (isDebugBuild()) {
            throw new IllegalStateException(str);
        }
        APSAnalytics.logEvent(APSEventSeverity.ERROR, APSEventType.EXCEPTION, str);
    }
}
