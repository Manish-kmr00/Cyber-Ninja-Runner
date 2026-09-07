package net.pubnative.lite.sdk.utils;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.pubnative.lite.sdk.DeviceInfo;
import net.pubnative.lite.sdk.HyBid;
import net.pubnative.lite.sdk.analytics.Reporting;
import net.pubnative.lite.sdk.analytics.tracker.ReportingTracker;
import net.pubnative.lite.sdk.api.ApiClient;
import net.pubnative.lite.sdk.api.PNApiClient;
import net.pubnative.lite.sdk.models.Ad;
import net.pubnative.lite.sdk.models.AdData;
import net.pubnative.lite.sdk.utils.json.JsonOperations;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class AdTracker {
    private static final String MACRO_ERROR_CODE = "[ERRORCODE]";
    private static final String MACRO_EVENT_TYPE = "[EVENTTYPE]";
    private static final String TAG = "AdTracker";
    private final PNApiClient mApiClient;
    private boolean mClickTracked;
    private final List<AdData> mClickUrls;
    private final List<AdData> mCompanionAdUrls;
    private final List<AdData> mCustomEndcardUrls;
    private final DeviceInfo mDeviceInfo;
    private boolean mImpressionTracked;
    private final List<AdData> mImpressionUrls;
    private final JSONObject mPlacementParams;
    private final List<AdData> mSdkEventUrls;
    private final ApiClient.TrackJSListener mTrackJSListener;
    private ApiClient.TrackUrlListener mTrackUrlListener;
    private final Set<Integer> trackedCompanionAdEvents;
    private final Set<Integer> trackedCustomEndcardEvents;
    private final Set<Integer> trackedSdkEvents;

    private enum Type {
        IMPRESSION("impression"),
        CLICK("click"),
        SDK_EVENT(Ad.Beacon.SDK_EVENT),
        COMPANION_AD_EVENT(Ad.Beacon.COMPANION_AD_EVENT),
        CUSTOM_ENDCARD_EVENT(Ad.Beacon.CUSTOM_ENDCARD_EVENT);

        private final String mType;

        Type(String str) {
            this.mType = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.mType;
        }
    }

    public AdTracker(List<AdData> list, List<AdData> list2) {
        this(HyBid.getApiClient(), HyBid.getDeviceInfo(), list, list2, null, null, null);
    }

    public AdTracker(List<AdData> list, List<AdData> list2, boolean z) {
        this(HyBid.getApiClient(), HyBid.getDeviceInfo(), list, list2, null, null, null);
        this.mClickTracked = z;
    }

    public AdTracker(List<AdData> list, List<AdData> list2, List<AdData> list3, List<AdData> list4, List<AdData> list5) {
        this(HyBid.getApiClient(), HyBid.getDeviceInfo(), list, list2, list3, list4, list5);
    }

    AdTracker(PNApiClient pNApiClient, DeviceInfo deviceInfo, List<AdData> list, List<AdData> list2, List<AdData> list3, List<AdData> list4, List<AdData> list5) {
        this.trackedSdkEvents = new HashSet();
        this.trackedCompanionAdEvents = new HashSet();
        this.trackedCustomEndcardEvents = new HashSet();
        this.mApiClient = pNApiClient;
        this.mDeviceInfo = deviceInfo;
        this.mImpressionUrls = list;
        this.mClickUrls = list2;
        this.mSdkEventUrls = list3;
        this.mCompanionAdUrls = list4;
        this.mCustomEndcardUrls = list5;
        this.mPlacementParams = new JSONObject();
        this.mTrackUrlListener = new ApiClient.TrackUrlListener() { // from class: net.pubnative.lite.sdk.utils.AdTracker.1
            @Override // net.pubnative.lite.sdk.api.ApiClient.TrackUrlListener
            public void onFailure(Throwable th) {
            }

            @Override // net.pubnative.lite.sdk.api.ApiClient.TrackUrlListener
            public void onSuccess() {
            }

            @Override // net.pubnative.lite.sdk.api.ApiClient.TrackUrlListener
            public void onFinally(String str, String str2, int i) {
                if (HyBid.getReportingController() != null) {
                    HyBid.getReportingController().reportFiredTracker(new ReportingTracker(str2, str, i));
                }
            }
        };
        this.mTrackJSListener = new ApiClient.TrackJSListener() { // from class: net.pubnative.lite.sdk.utils.AdTracker.2
            @Override // net.pubnative.lite.sdk.api.ApiClient.TrackJSListener
            public void onFailure(Throwable th) {
            }

            @Override // net.pubnative.lite.sdk.api.ApiClient.TrackJSListener
            public void onSuccess(String str) {
                if (HyBid.getReportingController() != null) {
                    HyBid.getReportingController().reportFiredTracker(new ReportingTracker("JavaScript", str));
                }
            }
        };
    }

    public void setTrackUrlListener(ApiClient.TrackUrlListener trackUrlListener) {
        this.mTrackUrlListener = trackUrlListener;
    }

    public void trackImpression() {
        if (this.mImpressionTracked) {
            return;
        }
        trackUrls(this.mImpressionUrls, Type.IMPRESSION);
        this.mImpressionTracked = true;
    }

    public void trackClick() {
        if (this.mClickTracked) {
            return;
        }
        trackUrls(this.mClickUrls, Type.CLICK);
        this.mClickTracked = true;
    }

    public void trackSdkEvent(Integer num, Integer num2) {
        if (this.trackedSdkEvents.add(num)) {
            trackUrls(this.mSdkEventUrls, Type.SDK_EVENT, num, num2);
        }
    }

    public void trackCompanionAdEvent(Integer num, Integer num2) {
        if (this.trackedCompanionAdEvents.add(num)) {
            trackUrls(this.mCompanionAdUrls, Type.COMPANION_AD_EVENT, num, num2);
        }
    }

    public void trackCustomEndcardEvent(Integer num, Integer num2) {
        if (this.trackedCustomEndcardEvents.add(num)) {
            trackUrls(this.mCustomEndcardUrls, Type.CUSTOM_ENDCARD_EVENT, num, num2);
        }
    }

    private void trackUrls(List<AdData> list, Type type) {
        trackUrls(list, type, null, null);
    }

    private void trackUrls(List<AdData> list, Type type, Integer num, Integer num2) {
        if (list != null) {
            JSONArray jSONArray = new JSONArray();
            for (AdData adData : list) {
                if (!TextUtils.isEmpty(adData.getURL()) && URLValidator.isValidURL(adData.getURL())) {
                    Logger.d(TAG, "Tracking " + type.toString() + " url: " + adData.getURL());
                    JsonOperations.putJsonString(jSONArray, adData.getURL());
                    String url = adData.getURL();
                    if (num != null) {
                        url = url.replace(MACRO_EVENT_TYPE, num.toString());
                    }
                    if (num2 != null) {
                        url = url.replace(MACRO_ERROR_CODE, num2.toString());
                    }
                    this.mApiClient.trackUrl(url, this.mDeviceInfo.getUserAgent(), type.name(), this.mTrackUrlListener);
                }
                if (!TextUtils.isEmpty(adData.getJS())) {
                    Logger.d(TAG, "Tracking " + type.toString() + " js: " + adData.getJS());
                    JsonOperations.putJsonString(jSONArray, adData.getJS());
                    this.mApiClient.trackJS(adData.getJS(), this.mTrackJSListener);
                }
            }
            if (type == Type.CLICK) {
                JsonOperations.putJsonArray(this.mPlacementParams, Reporting.Key.FIRED_CLICK_BEACONS, jSONArray);
            } else if (type == Type.IMPRESSION) {
                JsonOperations.putJsonArray(this.mPlacementParams, Reporting.Key.FIRED_IMPRESSION_BEACONS, jSONArray);
            }
        }
    }

    public JSONObject getPlacementParams() {
        return this.mPlacementParams;
    }
}
