package com.pubmatic.sdk.openwrap.core;

import android.content.Context;
import com.pubmatic.sdk.common.POBCommonConstants;
import com.pubmatic.sdk.common.POBInstanceProvider;
import com.pubmatic.sdk.common.base.POBRequestBuilding;
import com.pubmatic.sdk.common.log.POBLog;
import com.pubmatic.sdk.common.models.POBAppInfo;
import com.pubmatic.sdk.common.models.POBApplicationInfo;
import com.pubmatic.sdk.common.models.POBDeviceInfo;
import com.pubmatic.sdk.common.models.POBLocation;
import com.pubmatic.sdk.common.models.POBUserInfo;
import com.pubmatic.sdk.common.network.POBHttpRequest;
import com.pubmatic.sdk.common.utility.POBLocationDetector;
import com.pubmatic.sdk.common.utility.POBUtils;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.HashMap;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class POBRequestBuilder implements POBRequestBuilding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f7736a;
    private final POBRequest b;
    private final Context c;
    private final Boolean d;
    private POBLocationDetector e;
    private POBDeviceInfo f;
    private POBAppInfo g;

    public POBRequestBuilder(POBRequest pOBRequest, String str, Context context) {
        this.c = context.getApplicationContext();
        this.f7736a = str;
        this.b = pOBRequest;
        this.d = Boolean.valueOf(POBUtils.isDebugBuild(context));
    }

    private JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("profileid", this.b.getProfileId());
            if (this.d.booleanValue() && this.b.getVersionId() != null) {
                jSONObject2.put("versionid", this.b.getVersionId());
            }
            jSONObject2.put(POBConstants.KEY_CLIENT_CONFIG, 1);
            jSONObject.put(POBConstants.KEY_WRAPPER, jSONObject2);
            if (this.b.a()) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("returnallbidstatus", true);
                jSONObject.put(POBConstants.KEY_PREBID, jSONObject3);
            }
        } catch (JSONException e) {
            POBLog.error("POBRequestBuilder", "Exception occurred in getExtObject() : " + e.getMessage(), new Object[0]);
        }
        return jSONObject;
    }

    private JSONObject b() {
        int accuracy;
        JSONObject jSONObject = new JSONObject();
        try {
            POBUserInfo userInfo = POBInstanceProvider.getSdkConfig().getUserInfo();
            if (userInfo != null) {
                POBCommonOrtbJsonHelper pOBCommonOrtbJsonHelper = POBCommonOrtbJsonHelper.INSTANCE;
                POBCommonOrtbJsonHelper.addParamToJson(jSONObject, "region", userInfo.getRegion());
                POBCommonOrtbJsonHelper.addParamToJson(jSONObject, POBConstants.KEY_CITY, userInfo.getCity());
                POBCommonOrtbJsonHelper.addParamToJson(jSONObject, "metro", userInfo.getMetro());
                POBCommonOrtbJsonHelper.addParamToJson(jSONObject, POBCommonConstants.ZIP_PARAM, userInfo.getZip());
            }
            POBDeviceInfo pOBDeviceInfo = this.f;
            if (pOBDeviceInfo != null) {
                POBCommonOrtbJsonHelper pOBCommonOrtbJsonHelper2 = POBCommonOrtbJsonHelper.INSTANCE;
                POBCommonOrtbJsonHelper.addParamToJson(jSONObject, "country", pOBDeviceInfo.getISOAlpha3CountryCode());
                jSONObject.put(POBConstants.KEY_UTC_OFFSET, this.f.getTimeZoneOffsetInMinutes());
            }
            POBLocation location = POBUtils.getLocation(this.e);
            if (location != null) {
                POBLocation.Source source = location.getSource();
                if (source != null) {
                    jSONObject.put("type", source.getValue());
                }
                jSONObject.put("lat", location.getLatitude());
                jSONObject.put(POBConstants.KEY_LONGITUDE, location.getLongitude());
                if (location.getSource() == POBLocation.Source.GPS && (accuracy = (int) location.getAccuracy()) > 0) {
                    jSONObject.put(POBConstants.KEY_ACCURACY, accuracy);
                }
                long lastFixInMillis = location.getLastFixInMillis();
                if (lastFixInMillis > 0) {
                    jSONObject.put(POBConstants.KEY_LAST_FIX, lastFixInMillis / 1000);
                }
            }
        } catch (Exception e) {
            POBLog.error("POBRequestBuilder", "Exception occurred in getGeoObject() : " + e.getMessage(), new Object[0]);
        }
        return jSONObject;
    }

    private String c() {
        String adServerUrl = this.b.getAdServerUrl();
        if (adServerUrl == null) {
            adServerUrl = this.f7736a;
        }
        return this.b.isDebugStateEnabled() ? POBUtils.buildUrlWithQueryParam(adServerUrl, "debug", "1") : adServerUrl;
    }

    private void d() {
        POBDeviceInfo pOBDeviceInfo = this.f;
        if (pOBDeviceInfo != null) {
            pOBDeviceInfo.updateAdvertisingIdInfo();
        }
    }

    @Override // com.pubmatic.sdk.common.base.POBRequestBuilding
    public POBHttpRequest build() {
        return prepareHttpRequest(c(), getBody().toString(), POBConstants.ORTB_VERSION);
    }

    public JSONObject getAppJson(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            POBAppInfo pOBAppInfo = this.g;
            if (pOBAppInfo != null) {
                POBCommonOrtbJsonHelper pOBCommonOrtbJsonHelper = POBCommonOrtbJsonHelper.INSTANCE;
                POBCommonOrtbJsonHelper.addParamToJson(jSONObject, "name", pOBAppInfo.getAppName());
                POBCommonOrtbJsonHelper.addParamToJson(jSONObject, POBConstants.KEY_BUNDLE, this.g.getPackageName());
            }
            POBApplicationInfo applicationInfo = POBInstanceProvider.getSdkConfig().getApplicationInfo();
            if (applicationInfo != null) {
                POBCommonOrtbJsonHelper pOBCommonOrtbJsonHelper2 = POBCommonOrtbJsonHelper.INSTANCE;
                POBCommonOrtbJsonHelper.addParamToJson(jSONObject, "domain", applicationInfo.getDomain());
                if (applicationInfo.getStoreURL() != null) {
                    POBCommonOrtbJsonHelper.addParamToJson(jSONObject, POBConstants.KEY_STORE_URL, applicationInfo.getStoreURL().toString());
                } else {
                    POBLog.warn("POBRequestBuilder", "Missing \"storeURL\" in the request. It is required for platform identification", new Object[0]);
                }
                Boolean boolIsPaid = applicationInfo.isPaid();
                if (boolIsPaid != null) {
                    jSONObject.put(POBConstants.KEY_PAID, boolIsPaid.booleanValue() ? 1 : 0);
                }
                if (applicationInfo.getCategories() != null) {
                    jSONObject.put("cat", new JSONArray(applicationInfo.getCategories().split(StringUtils.COMMA)));
                }
                if (!POBUtils.isNullOrEmpty(applicationInfo.getKeywords())) {
                    jSONObject.put("keywords", applicationInfo.getKeywords());
                }
            }
            POBAppInfo pOBAppInfo2 = this.g;
            if (pOBAppInfo2 != null) {
                jSONObject.put("ver", pOBAppInfo2.getAppVersion());
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", str);
            jSONObject.put("publisher", jSONObject2);
        } catch (JSONException e) {
            POBLog.error("POBRequestBuilder", "Exception occurred in getAppJson() : " + e.getMessage(), new Object[0]);
        }
        return jSONObject;
    }

    public JSONObject getBody() {
        d();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", UUID.randomUUID().toString());
            jSONObject.put(POBConstants.KEY_AT, 1);
            jSONObject.put("cur", POBCommonOrtbJsonHelper.getCurrencyJson());
            jSONObject.put(POBConstants.KEY_IMPRESSION, POBCommonOrtbJsonHelper.getImpressionJsonArray(this.b));
            jSONObject.put("app", getAppJson(this.b.getPubId()));
            jSONObject.put("device", getDeviceObject());
            if (POBInstanceProvider.getSdkConfig().getMeasurementProvider(POBCommonConstants.HTML_MEASUREMENT_PROVIDER_CLASS) != null) {
                jSONObject.put("source", POBCommonOrtbJsonHelper.getMeasurementJson());
            }
            JSONObject userJson = POBCommonOrtbJsonHelper.getUserJson(this.c, this.b.getPlacementType());
            if (userJson.length() > 0) {
                jSONObject.put(POBConstants.KEY_USER, userJson);
            }
            if (this.b.getTestMode() != null && this.b.getTestMode().booleanValue()) {
                jSONObject.put(POBConstants.TEST_MODE, 1);
            }
            JSONObject regsJson = POBCommonOrtbJsonHelper.getRegsJson(this.c);
            if (regsJson != null && regsJson.length() > 0) {
                jSONObject.put(POBConstants.KEY_REGS, regsJson);
            }
            jSONObject.put("ext", a());
        } catch (JSONException e) {
            POBLog.error("POBRequestBuilder", "Exception occurred in getBody() : " + e.getMessage(), new Object[0]);
        }
        return jSONObject;
    }

    public JSONObject getDeviceObject() {
        JSONObject jSONObject = new JSONObject();
        if (this.f != null) {
            try {
                jSONObject.put("geo", b());
                jSONObject.put("pxratio", this.f.getPxratio());
                jSONObject.put(POBConstants.KEY_MCCMNC, this.f.getMccmnc());
                if (this.f.getLmtEnabled() != null) {
                    jSONObject.put("lmt", this.f.getLmtEnabled().booleanValue() ? 1 : 0);
                }
                String advertisingID = this.f.getAdvertisingID();
                if (POBInstanceProvider.getSdkConfig().isAllowAdvertisingId() && advertisingID != null) {
                    jSONObject.put(POBConstants.KEY_IFA, advertisingID);
                }
                jSONObject.put("connectiontype", POBInstanceProvider.getNetworkMonitor(this.c).getConnectionType().getValue());
                POBCommonOrtbJsonHelper pOBCommonOrtbJsonHelper = POBCommonOrtbJsonHelper.INSTANCE;
                POBCommonOrtbJsonHelper.addParamToJson(jSONObject, "carrier", this.f.getCarrierName());
                jSONObject.put(POBConstants.KEY_JS, 1);
                jSONObject.put("ua", POBInstanceProvider.getCacheManager(this.c).getUserAgent());
                jSONObject.put("make", this.f.getMake());
                jSONObject.put("model", this.f.getModel());
                jSONObject.put(POBConstants.KEY_HWV, this.f.getHardwareVersion());
                jSONObject.put("os", this.f.getOsName());
                jSONObject.put("osv", this.f.getOsVersion());
                jSONObject.put("h", this.f.getScreenHeight());
                jSONObject.put("w", this.f.getScreenWidth());
                jSONObject.put(POBConstants.KEY_LANGUAGE, this.f.getAcceptLanguage());
                if (POBUtils.isTablet(this.c)) {
                    jSONObject.put(POBConstants.KEY_DEVICE_TYPE, 5);
                } else {
                    jSONObject.put(POBConstants.KEY_DEVICE_TYPE, 4);
                }
            } catch (Exception e) {
                POBLog.error("POBRequestBuilder", "Exception occurred in getDeviceObject() : " + e.getMessage(), new Object[0]);
            }
        }
        return jSONObject;
    }

    public POBHttpRequest prepareHttpRequest(String str, String str2, String str3) {
        HashMap map = new HashMap();
        map.put("Content-Type", "application/json");
        if (str3 != null) {
            map.put(POBConstants.ORTB_VERSION_PARAM, str3);
        }
        POBHttpRequest pOBHttpRequest = new POBHttpRequest();
        pOBHttpRequest.setRequestMethod(POBHttpRequest.HTTP_METHOD.POST);
        pOBHttpRequest.setPostData(str2);
        pOBHttpRequest.setUrl(str);
        pOBHttpRequest.setTimeout(this.b.getNetworkTimeout() * 1000);
        pOBHttpRequest.setRequestTag(String.valueOf(hashCode()));
        pOBHttpRequest.setHeaders(map);
        return pOBHttpRequest;
    }

    @Override // com.pubmatic.sdk.common.base.POBRequestBuilding
    public void setAppInfo(POBAppInfo pOBAppInfo) {
        this.g = pOBAppInfo;
    }

    @Override // com.pubmatic.sdk.common.base.POBRequestBuilding
    public void setDeviceInfo(POBDeviceInfo pOBDeviceInfo) {
        this.f = pOBDeviceInfo;
    }

    @Override // com.pubmatic.sdk.common.base.POBRequestBuilding
    public void setLocationDetector(POBLocationDetector pOBLocationDetector) {
        this.e = pOBLocationDetector;
    }
}
