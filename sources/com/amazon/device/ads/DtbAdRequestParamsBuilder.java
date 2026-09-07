package com.amazon.device.ads;

import android.content.Context;
import android.os.Build;
import androidx.browser.customtabs.CustomTabsClient;
import com.amazon.aps.shared.APSAnalytics;
import com.amazon.aps.shared.analytics.APSEventSeverity;
import com.amazon.aps.shared.analytics.APSEventType;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
class DtbAdRequestParamsBuilder {
    private final String LOG_TAG = "DtbAdRequestParamsBuilder";

    DtbAdRequestParamsBuilder() {
    }

    public HashMap<String, Object> getParams(Context context, List<DTBAdSize> list, Map<String, String> map, boolean z) {
        HashMap<String, Object> map2 = new HashMap<>();
        map2.putAll(getCommonParams(context));
        map2.putAll(getSlotParams(list));
        map2.putAll(getCustomParams(map));
        map2.putAll(getCustomAttributeParams(z, context));
        return map2;
    }

    HashMap<String, Object> getCommonParams(Context context) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("isDTBMobile", "true");
        map.put(RemoteConfigConstants.RequestFieldKey.APP_ID, AdRegistration.getAppKey());
        map.put("adsdk", DtbCommonUtils.getSDKVersion());
        String idfa = DtbSharedPreferences.getInstance().getIdfa();
        if (!DtbCommonUtils.isNullOrEmpty(idfa)) {
            map.put("idfa", idfa);
        }
        Boolean optOut = DtbSharedPreferences.getInstance().getOptOut();
        if (optOut != null) {
            map.put("oo", Boolean.toString(optOut.booleanValue()));
        }
        JSONObject paramsJson = DtbDeviceData.getDeviceDataInstance().getParamsJson();
        if (paramsJson != null) {
            map.put("dinfo", paramsJson);
        }
        String userAgentString = DtbDeviceData.getDeviceDataInstance().getUserAgentString();
        if (userAgentString != null) {
            map.put("ua", userAgentString);
        }
        map.put("pkg", DtbPackageNativeData.getPackageNativeDataInstance(context).getParamsJson());
        String adId = DtbSharedPreferences.getInstance().getAdId();
        if (adId != null) {
            map.put("ad-id", adId);
        }
        if (AdRegistration.isTestMode()) {
            map.put("isTest", "true");
        }
        if (AdRegistration.isLocationEnabled()) {
            String locationParam = new DtbGeoLocation().getLocationParam();
            if (!DtbCommonUtils.isNullOrEmpty(locationParam)) {
                map.put("geoloc", locationParam);
            }
        }
        return map;
    }

    private HashMap<String, Object> getSlotParams(List<DTBAdSize> list) {
        HashMap<String, Object> map = new HashMap<>();
        JSONArray jSONArray = new JSONArray();
        try {
            int i = 1;
            for (DTBAdSize dTBAdSize : list) {
                JSONObject jSONObject = new JSONObject();
                if (dTBAdSize.isInterstitialAd()) {
                    jSONObject.put("sz", "interstitial");
                } else {
                    jSONObject.put("sz", dTBAdSize.getWidth() + VastAttributes.HORIZONTAL_POSITION + dTBAdSize.getHeight());
                }
                jSONObject.put("slot", dTBAdSize.getSlotUUID());
                int i2 = i + 1;
                jSONObject.put("slotId", i);
                JSONArray jSONArray2 = new JSONArray();
                if (AnonymousClass1.$SwitchMap$com$amazon$device$ads$AdType[dTBAdSize.getDTBAdType().ordinal()] == 1) {
                    jSONArray2.put(AdType.VIDEO.toString());
                } else {
                    jSONArray2.put(AdType.DISPLAY.toString());
                }
                jSONObject.put("supportedMediaTypes", jSONArray2);
                if (dTBAdSize.getPubSettings() != null) {
                    jSONObject.put("ps", dTBAdSize.getPubSettings());
                }
                jSONArray.put(jSONObject);
                i = i2;
            }
            map.put("slots", jSONArray);
        } catch (JSONException unused) {
            DtbLog.warn(this.LOG_TAG, "Error constructing slot parameters");
        }
        return map;
    }

    /* JADX INFO: renamed from: com.amazon.device.ads.DtbAdRequestParamsBuilder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$amazon$device$ads$AdType;

        static {
            int[] iArr = new int[AdType.values().length];
            $SwitchMap$com$amazon$device$ads$AdType = iArr;
            try {
                iArr[AdType.VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private HashMap<String, Object> getCustomParams(Map<String, String> map) {
        HashMap<String, Object> map2 = new HashMap<>();
        if (map != null) {
            for (String str : map.keySet()) {
                map2.put(str, map.get(str));
            }
        }
        return map2;
    }

    void addOmidPartnerNameAndPartnerVersionToBidRequest() {
        if (AdRegistration.getCustomDictionary() != null) {
            try {
                if (AdRegistration.getCustomDictionary().containsKey(DtbConstants.MEDIATION_NAME) && DTBAdNetwork.valueOf(AdRegistration.getCustomDictionary().get(DtbConstants.MEDIATION_NAME)).isMediation()) {
                    AdRegistration.addCustomAttribute("omidPartnerName", DTBMetricsConfiguration.getClientConfigVal("partner_name", "Amazon1", "om_sdk_feature"));
                    AdRegistration.addCustomAttribute("omidPartnerVersion", DtbCommonUtils.getSDKVersion());
                    return;
                }
                return;
            } catch (RuntimeException e) {
                APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Failed to set OM SDK Partner Name and Version in Bid Request", e);
                return;
            }
        }
        DtbLog.info(this.LOG_TAG, "Custom Dictionary Not found");
    }

    HashMap<String, Object> getCustomAttributeParams(boolean z, Context context) {
        HashMap<String, Object> map = new HashMap<>();
        JSONObject pJTemplate = DtbSharedPreferences.getInstance().getPJTemplate();
        JSONObject jSONObject = new JSONObject();
        addOmidPartnerNameAndPartnerVersionToBidRequest();
        addCurrentEnvironmentToCustomAtt();
        AdRegistration.addCustomAttribute("autoRefresh", String.valueOf(z));
        addInAppNativeBrowserToCustomAtt(context);
        Iterator<String> itKeys = pJTemplate.keys();
        while (itKeys.hasNext()) {
            try {
                String next = itKeys.next();
                if (pJTemplate.get(next) instanceof String) {
                    String str = AdRegistration.getCustomDictionary().get(pJTemplate.getString(next));
                    if (!DtbCommonUtils.isNullOrEmpty(str)) {
                        jSONObject.put(next, str);
                    }
                } else if (pJTemplate.get(next) instanceof JSONObject) {
                    JSONObject jSONObject2 = pJTemplate.getJSONObject(next);
                    JSONObject jSONObject3 = new JSONObject();
                    Iterator<String> itKeys2 = jSONObject2.keys();
                    while (itKeys2.hasNext()) {
                        String next2 = itKeys2.next();
                        if (jSONObject2.get(next2) instanceof String) {
                            String str2 = AdRegistration.getCustomDictionary().get(jSONObject2.getString(next2));
                            if (!DtbCommonUtils.isNullOrEmpty(str2)) {
                                jSONObject3.put(next2, str2);
                            }
                        }
                    }
                    if (jSONObject3.length() > 0) {
                        jSONObject.put(next, jSONObject3);
                    }
                }
            } catch (Exception unused) {
                DtbLog.warn(this.LOG_TAG, "Error when constructing custom attribute parameters");
            }
        }
        if (jSONObject.length() > 0) {
            map.put("pj", jSONObject);
        }
        return map;
    }

    void addCurrentEnvironmentToCustomAtt() {
        Map map = new HashMap();
        if (AdRegistration.getCustomDictionary() != null) {
            map = AdRegistration.getCustomDictionary();
        }
        if (map.containsKey("framework")) {
            return;
        }
        AdRegistration.addCustomAttribute("framework", DtbCommonUtils.getSDKFramework());
    }

    void addInAppNativeBrowserToCustomAtt(Context context) {
        if (DTBMetricsConfiguration.getInstance().isFeatureEnabled(DTBMetricsConfiguration.CUSTOM_TAB_FEATURE_ENABLED_FLAG, true)) {
            try {
                if (Build.VERSION.SDK_INT < 31 || !DtbCommonUtils.isClassAvailable("androidx.browser.customtabs.CustomTabsClient") || CustomTabsClient.getPackageName(context, Collections.emptyList()) == null) {
                    return;
                }
                AdRegistration.addCustomAttribute("inAppNativeBrowser", Boolean.TRUE.toString());
            } catch (Exception e) {
                APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Failed to set inAppNativeBrowser in Bid Request", e);
            }
        }
    }
}
