package com.amazon.device.ads;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.amazon.aps.shared.APSAnalytics;
import com.amazon.aps.shared.analytics.APSEventSeverity;
import com.amazon.aps.shared.analytics.APSEventType;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public class DTBAdResponse {
    private static final String AMAZON_AD_INFO = "{bidID:'%s',aaxHost:'%s',type:'%s',width:%d,height:%d,pricePoint:'%s'}";
    private static final String LOG_TAG = "DTBAdResponse";
    private String bidId;
    private String crid;
    protected String extrasAsString;
    private String hostName;
    private String impressionUrl;
    private boolean isVideo;
    private Map<String, List<String>> kvpDictionary;
    private Map<DTBAdSize, List<DtbPricePoint>> pricepoints;
    protected DTBAdRequest refreshLoader;
    protected Bundle renderingBundle;
    protected String videoInventoryType;
    private int videoSkipAfterDurationInSeconds;

    public DTBAdResponse() {
        this.kvpDictionary = new HashMap();
        this.pricepoints = new HashMap();
    }

    public DTBAdResponse(DTBAdResponse dTBAdResponse) {
        this.kvpDictionary = new HashMap();
        this.pricepoints = new HashMap();
        this.bidId = dTBAdResponse.bidId;
        this.isVideo = dTBAdResponse.isVideo;
        this.hostName = dTBAdResponse.hostName;
        this.kvpDictionary = dTBAdResponse.kvpDictionary;
        this.pricepoints = dTBAdResponse.pricepoints;
        this.impressionUrl = dTBAdResponse.impressionUrl;
        this.crid = dTBAdResponse.crid;
        this.refreshLoader = dTBAdResponse.refreshLoader;
        this.videoSkipAfterDurationInSeconds = dTBAdResponse.videoSkipAfterDurationInSeconds;
        this.videoInventoryType = dTBAdResponse.videoInventoryType;
        this.renderingBundle = dTBAdResponse.renderingBundle;
        this.extrasAsString = dTBAdResponse.extrasAsString;
    }

    public DTBAdResponse(Bundle bundle) {
        this.kvpDictionary = new HashMap();
        this.pricepoints = new HashMap();
        this.renderingBundle = bundle;
    }

    public DTBAdResponse(String str) {
        this.kvpDictionary = new HashMap();
        this.pricepoints = new HashMap();
        this.extrasAsString = str;
    }

    public String getImpressionUrl() {
        return this.impressionUrl;
    }

    void setImpressionUrl(String str) {
        this.impressionUrl = str;
    }

    public String getCrid() {
        return this.crid;
    }

    void setCrid(String str) {
        this.crid = str;
    }

    void setBidId(String str) {
        this.bidId = str;
    }

    void setKvpDictionary(JSONObject jSONObject) throws JSONException {
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            JSONArray jSONArray = jSONObject.getJSONArray(next);
            if (jSONArray != null) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    if (this.kvpDictionary.get(next) == null) {
                        this.kvpDictionary.put(next, new ArrayList());
                    }
                    this.kvpDictionary.get(next).add(jSONArray.getString(i));
                }
            }
        }
    }

    void putPricePoint(DtbPricePoint dtbPricePoint) {
        if (this.pricepoints.get(dtbPricePoint.getAdSize()) == null) {
            this.pricepoints.put(dtbPricePoint.getAdSize(), new ArrayList());
        }
        this.pricepoints.get(dtbPricePoint.getAdSize()).add(dtbPricePoint);
    }

    void setVideoSkipAfterDurationInSeconds(int i) {
        this.videoSkipAfterDurationInSeconds = i;
    }

    public Integer getVideoSkipAfterDurationInSeconds() {
        return Integer.valueOf(this.videoSkipAfterDurationInSeconds);
    }

    void setVideoInventoryType(String str) {
        this.videoInventoryType = str;
    }

    String getVideoInventoryType() {
        return this.videoInventoryType;
    }

    public String getBidId() {
        return this.bidId;
    }

    private String getBidKey() {
        if (!this.isVideo) {
            return DTBAdLoader.A9_BID_ID_KEY;
        }
        return DTBAdLoader.A9_VID_KEY;
    }

    public Map<String, List<String>> getDefaultDisplayAdsRequestCustomParams() {
        HashMap map = new HashMap();
        try {
            if (!this.isVideo) {
                if (this.pricepoints.size() > 0) {
                    map.put(DTBAdLoader.A9_BID_ID_KEY, Collections.singletonList(this.bidId));
                    map.put(getBidKey(), Collections.singletonList(this.bidId));
                    map.put(DTBAdLoader.A9_HOST_KEY, Collections.singletonList(DtbSharedPreferences.getInstance().getAaxHostname()));
                    Iterator<DtbPricePoint> it = this.pricepoints.get(getDTBAds().get(0)).iterator();
                    while (it.hasNext()) {
                        map.put(DTBAdLoader.A9_PRICE_POINTS_KEY, Collections.singletonList(it.next().getPricePoint()));
                    }
                }
                map.put(DTBAdLoader.APS_VIDEO_FLAG, Collections.singletonList(String.valueOf(this.isVideo)));
                map.putAll(getKvpDictionary());
                if (!DtbCommonUtils.isNullOrEmpty(AdRegistration.getAppKey())) {
                    map.put(DTBAdLoader.APS_VIDEO_APP_KEY, Collections.singletonList(AdRegistration.getAppKey()));
                }
            }
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.ERROR, APSEventType.EXCEPTION, "Fail to execute getDefaultDisplayAdsRequestCustomParams method", e);
        }
        return map;
    }

    Map<String, List<String>> getKvpDictionary() {
        return this.kvpDictionary;
    }

    public Map<String, String> getDefaultVideoAdsRequestCustomParams() {
        HashMap map = new HashMap();
        try {
            if (this.isVideo) {
                map.put(DTBAdLoader.A9_VID_KEY, this.bidId);
                map.put(DTBAdLoader.A9_HOST_KEY, this.hostName);
                Iterator<DtbPricePoint> it = this.pricepoints.get(getDTBAds().get(0)).iterator();
                while (it.hasNext()) {
                    map.put(DTBAdLoader.A9_PRICE_POINTS_KEY, it.next().getPricePoint());
                }
                for (Map.Entry<String, List<String>> entry : this.kvpDictionary.entrySet()) {
                    map.put(entry.getKey(), TextUtils.join(", ", entry.getValue()));
                }
                map.put(DTBAdLoader.APS_VIDEO_FLAG, String.valueOf(this.isVideo));
                map.put(DTBAdLoader.APS_VIDEO_SKIP_AFTER, String.valueOf(getVideoSkipAfterDurationInSeconds()));
                map.put(DTBAdLoader.APS_VIDEO_TYPE, getVideoInventoryType());
                if (!DtbCommonUtils.isNullOrEmpty(AdRegistration.getAppKey())) {
                    map.put(DTBAdLoader.APS_VIDEO_APP_KEY, AdRegistration.getAppKey());
                }
            }
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.ERROR, APSEventType.EXCEPTION, "Fail to execute getDefaultVideoAdsRequestCustomParams method", e);
        }
        return map;
    }

    Map<String, List<String>> getVideoAdsRequestCustomParamsAsList() {
        HashMap map = new HashMap();
        if (this.isVideo) {
            map.put(DTBAdLoader.A9_VID_KEY, Collections.singletonList(this.bidId));
            map.put(DTBAdLoader.A9_HOST_KEY, Collections.singletonList(this.hostName));
            Iterator<DtbPricePoint> it = this.pricepoints.get(getDTBAds().get(0)).iterator();
            while (it.hasNext()) {
                map.put(DTBAdLoader.A9_PRICE_POINTS_KEY, Collections.singletonList(it.next().getPricePoint()));
            }
            map.put(DTBAdLoader.APS_VIDEO_FLAG, Collections.singletonList(String.valueOf(this.isVideo)));
            map.put(DTBAdLoader.APS_VIDEO_SKIP_AFTER, Collections.singletonList(String.valueOf(getVideoSkipAfterDurationInSeconds())));
            map.put(DTBAdLoader.APS_VIDEO_TYPE, Collections.singletonList(getVideoInventoryType()));
            if (!DtbCommonUtils.isNullOrEmpty(AdRegistration.getAppKey())) {
                map.put(DTBAdLoader.APS_VIDEO_APP_KEY, Collections.singletonList(AdRegistration.getAppKey()));
            }
            map.putAll(getKvpDictionary());
        }
        return map;
    }

    public int getAdCount() {
        return this.pricepoints.size();
    }

    public List<DTBAdSize> getDTBAds() {
        return new ArrayList(this.pricepoints.keySet());
    }

    public String getPricePoints(DTBAdSize dTBAdSize) {
        try {
            List<DtbPricePoint> list = this.pricepoints.get(dTBAdSize);
            if (list == null || list.isEmpty()) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i).getPricePoint());
                if (i != list.size() - 1) {
                    sb.append(StringUtils.COMMA);
                }
            }
            return sb.toString();
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.ERROR, APSEventType.EXCEPTION, "Fail to execute getPricePoints method", e);
            return null;
        }
    }

    @Deprecated
    public String getHost() {
        try {
            return DtbSharedPreferences.getInstance().getAaxHostname();
        } catch (IllegalArgumentException e) {
            APSAnalytics.logEvent(APSEventSeverity.ERROR, APSEventType.EXCEPTION, "Fail to execute getPricePoints method", e);
            return null;
        }
    }

    public String getDefaultPricePoints() {
        try {
            if (getAdCount() == 0) {
                return null;
            }
            return getPricePoints(getDTBAds().get(0));
        } catch (IllegalArgumentException e) {
            APSAnalytics.logEvent(APSEventSeverity.ERROR, APSEventType.EXCEPTION, "Fail to execute getDefaultPricePoints method", e);
            return null;
        }
    }

    protected boolean isVideo() {
        return this.isVideo;
    }

    protected void setVideo(boolean z) {
        this.isVideo = z;
    }

    @Deprecated
    public String getMoPubKeywords() {
        Map<String, List<String>> videoAdsRequestCustomParamsAsList;
        try {
            DtbLog.debug(LOG_TAG, "API 'getMoPubKeywords' supports banner & video Ads.");
            StringBuilder sb = new StringBuilder();
            if (!this.isVideo) {
                videoAdsRequestCustomParamsAsList = getDefaultDisplayAdsRequestCustomParams();
            } else {
                videoAdsRequestCustomParamsAsList = getVideoAdsRequestCustomParamsAsList();
            }
            if (this.pricepoints.size() > 0) {
                boolean z = true;
                for (Map.Entry<String, List<String>> entry : videoAdsRequestCustomParamsAsList.entrySet()) {
                    for (String str : entry.getValue()) {
                        if (z) {
                            z = false;
                        } else {
                            sb.append(StringUtils.COMMA);
                        }
                        sb.append(entry.getKey()).append(":").append(str);
                    }
                }
            }
            return sb.toString();
        } catch (IllegalArgumentException e) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Fail to execute getMoPubKeywords method", e);
            return "";
        }
    }

    @Deprecated
    public String getMoPubServerlessKeywords() {
        try {
            StringBuilder sb = new StringBuilder();
            Map<String, List<String>> defaultDisplayAdsRequestCustomParams = getDefaultDisplayAdsRequestCustomParams();
            if (this.pricepoints.size() > 0 && defaultDisplayAdsRequestCustomParams.containsKey(DTBAdLoader.A9_PRICE_POINTS_KEY)) {
                List<String> list = defaultDisplayAdsRequestCustomParams.get(DTBAdLoader.A9_PRICE_POINTS_KEY);
                if (list.size() > 0) {
                    sb.append("amznslots:").append(list.get(0));
                }
            }
            return sb.toString();
        } catch (IllegalArgumentException e) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Fail to execute getMoPubServerlessKeywords method", e);
            return "";
        }
    }

    private String getAmazonInfo() {
        String str = "";
        if (getDTBAds().size() == 0) {
            return "";
        }
        DTBAdSize dTBAdSize = getDTBAds().get(0);
        int width = dTBAdSize.getWidth();
        int height = dTBAdSize.getHeight();
        int i = AnonymousClass1.$SwitchMap$com$amazon$device$ads$AdType[dTBAdSize.getDTBAdType().ordinal()];
        if (i == 1) {
            str = "video";
        } else if (i == 2) {
            str = "banner";
        } else if (i == 3) {
            Activity currentActivity = AdRegistration.getCurrentActivity();
            str = "interstitial";
            if (currentActivity != null) {
                Display defaultDisplay = ((WindowManager) currentActivity.getSystemService("window")).getDefaultDisplay();
                DisplayMetrics displayMetrics = new DisplayMetrics();
                defaultDisplay.getMetrics(displayMetrics);
                int iPixelsToDeviceIndependenPixels = DTBAdUtil.pixelsToDeviceIndependenPixels(displayMetrics.widthPixels);
                height = DTBAdUtil.pixelsToDeviceIndependenPixels(displayMetrics.heightPixels);
                width = iPixelsToDeviceIndependenPixels;
            }
        }
        String str2 = str;
        String aaxHostName = this.hostName;
        if (aaxHostName == null) {
            aaxHostName = DtbDebugProperties.getAaxHostName(DtbSharedPreferences.getInstance().getAaxHostname());
        }
        String pricePoint = SDKUtilities.getPricePoint(this);
        return String.format(AMAZON_AD_INFO, this.bidId, aaxHostName, str2, Integer.valueOf(width), Integer.valueOf(height), pricePoint);
    }

    /* JADX INFO: renamed from: com.amazon.device.ads.DTBAdResponse$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$amazon$device$ads$AdType;

        static {
            int[] iArr = new int[AdType.values().length];
            $SwitchMap$com$amazon$device$ads$AdType = iArr;
            try {
                iArr[AdType.VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$amazon$device$ads$AdType[AdType.DISPLAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$amazon$device$ads$AdType[AdType.INTERSTITIAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    void setHostName(String str) {
        this.hostName = str;
    }

    public HashMap<String, Object> getRenderingMap() {
        HashMap<String, Object> map = new HashMap<>();
        try {
            map.put("bid_html_template", SDKUtilities.getBidInfo(this));
            map.put("event_server_parameter", SDKUtilities.getPricePoint(this));
            map.put("amazon_ad_info", getAmazonInfo());
            map.put("bid_identifier", this.bidId);
            map.put("hostname_identifier", this.hostName);
            map.put("start_load_time", Long.valueOf(new Date().getTime()));
        } catch (IllegalArgumentException e) {
            DtbLog.debug(LOG_TAG, "Fail to execute getRenderingMap method");
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Fail to execute getRenderingMap method", e);
        }
        return map;
    }

    public Bundle getRenderingBundle() {
        Bundle bundle = this.renderingBundle;
        return bundle != null ? bundle : getRenderingBundle(false);
    }

    public Bundle getRenderingBundle(String str) {
        return getRenderingBundle(false, str);
    }

    public Bundle getRenderingBundle(boolean z) {
        return getRenderingBundle(z, null);
    }

    public Bundle getRenderingBundle(boolean z, String str) {
        Bundle bundleInitializeEmptyBundle = DtbCommonUtils.initializeEmptyBundle();
        try {
            bundleInitializeEmptyBundle.putString("bid_html_template", SDKUtilities.getBidInfo(this));
            bundleInitializeEmptyBundle.putString("bid_identifier", this.bidId);
            bundleInitializeEmptyBundle.putString("hostname_identifier", this.hostName);
            bundleInitializeEmptyBundle.putBoolean("video_flag", this.isVideo);
            bundleInitializeEmptyBundle.putString("event_server_parameter", SDKUtilities.getPricePoint(this));
            bundleInitializeEmptyBundle.putString("amazon_ad_info", getAmazonInfo());
            bundleInitializeEmptyBundle.putLong("start_load_time", new Date().getTime());
            if (z) {
                bundleInitializeEmptyBundle.putInt("expected_width", SDKUtilities.getWidth(this));
                bundleInitializeEmptyBundle.putInt("expected_height", SDKUtilities.getHeight(this));
            }
            if (!DtbCommonUtils.isNullOrEmpty(str)) {
                bundleInitializeEmptyBundle.putString("amazon_request_queue", str);
            }
        } catch (IllegalArgumentException e) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Fail to execute getRenderingBundle method", e);
        }
        return bundleInitializeEmptyBundle;
    }

    public DTBAdRequest getAdLoader() {
        return this.refreshLoader;
    }

    void setAdLoader(DTBAdRequest dTBAdRequest) {
        this.refreshLoader = dTBAdRequest;
    }
}
