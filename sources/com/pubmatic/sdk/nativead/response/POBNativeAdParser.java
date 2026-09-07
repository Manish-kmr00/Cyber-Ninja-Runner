package com.pubmatic.sdk.nativead.response;

import com.pubmatic.sdk.common.log.POBLog;
import com.pubmatic.sdk.common.utility.POBUtils;
import com.pubmatic.sdk.nativead.POBNativeConstants;
import com.pubmatic.sdk.nativead.POBNativeLogConstants;
import com.pubmatic.sdk.openwrap.core.nativead.POBNativeDataAssetType;
import com.pubmatic.sdk.openwrap.core.nativead.POBNativeEventTrackingMethod;
import com.pubmatic.sdk.openwrap.core.nativead.POBNativeEventType;
import com.pubmatic.sdk.openwrap.core.nativead.POBNativeImageAssetType;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class POBNativeAdParser {
    /* JADX WARN: Code duplicated, block: B:38:0x00de  */
    private List a(JSONArray jSONArray) {
        JSONObject jSONObjectOptJSONObject;
        POBNativeAdResponseAsset pOBNativeAdDataResponseAsset;
        ArrayList arrayList = new ArrayList();
        if (POBUtils.isJsonArrayNullOrEmpty(jSONArray)) {
            return arrayList;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject2 = jSONArray.optJSONObject(i);
            if (!POBUtils.isJsonObjectNullOrEmpty(jSONObjectOptJSONObject2) && jSONObjectOptJSONObject2.has("id")) {
                int iOptInt = jSONObjectOptJSONObject2.optInt("id");
                boolean z = jSONObjectOptJSONObject2.optInt("required") == 1;
                POBNativeAdLinkResponse pOBNativeAdLinkResponseA = a(jSONObjectOptJSONObject2.optJSONObject("link"));
                boolean zHas = jSONObjectOptJSONObject2.has("title");
                boolean zHas2 = jSONObjectOptJSONObject2.has("img");
                boolean zHas3 = jSONObjectOptJSONObject2.has("data");
                if (zHas) {
                    JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("title");
                    if (jSONObjectOptJSONObject3 != null) {
                        String strOptString = jSONObjectOptJSONObject3.optString("text");
                        if (POBUtils.isNullOrEmpty(strOptString)) {
                            pOBNativeAdDataResponseAsset = null;
                        } else {
                            pOBNativeAdDataResponseAsset = new POBNativeAdTitleResponseAsset(iOptInt, z, pOBNativeAdLinkResponseA, strOptString, jSONObjectOptJSONObject3.optInt(POBNativeConstants.NATIVE_LENGTH, strOptString.length()));
                        }
                    } else {
                        pOBNativeAdDataResponseAsset = null;
                    }
                } else if (zHas2) {
                    JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject2.optJSONObject("img");
                    if (jSONObjectOptJSONObject4 != null) {
                        String strOptString2 = jSONObjectOptJSONObject4.optString("url");
                        if (POBUtils.isNullOrEmpty(strOptString2)) {
                            pOBNativeAdDataResponseAsset = null;
                        } else {
                            pOBNativeAdDataResponseAsset = new POBNativeAdImageResponseAsset(iOptInt, z, pOBNativeAdLinkResponseA, strOptString2, jSONObjectOptJSONObject4.optInt("w"), jSONObjectOptJSONObject4.optInt("h"), POBNativeImageAssetType.getImageAssetType(jSONObjectOptJSONObject4.optInt("type")));
                        }
                    } else {
                        pOBNativeAdDataResponseAsset = null;
                    }
                } else if (!zHas3 || (jSONObjectOptJSONObject = jSONObjectOptJSONObject2.optJSONObject("data")) == null || POBUtils.isNullOrEmpty(jSONObjectOptJSONObject.optString("value"))) {
                    pOBNativeAdDataResponseAsset = null;
                } else {
                    POBNativeDataAssetType dataAssetType = POBNativeDataAssetType.getDataAssetType(jSONObjectOptJSONObject.optInt("type"));
                    String strOptString3 = jSONObjectOptJSONObject.optString("value");
                    pOBNativeAdDataResponseAsset = new POBNativeAdDataResponseAsset(iOptInt, z, pOBNativeAdLinkResponseA, strOptString3, jSONObjectOptJSONObject.optInt(POBNativeConstants.NATIVE_LENGTH, strOptString3.length()), dataAssetType);
                }
                if (pOBNativeAdDataResponseAsset != null) {
                    arrayList.add(pOBNativeAdDataResponseAsset);
                }
            }
        }
        return arrayList;
    }

    private List b(JSONArray jSONArray) {
        POBNativeEventType eventType;
        POBNativeEventTrackingMethod eventTrackingMethod;
        ArrayList arrayList = new ArrayList();
        if (POBUtils.isJsonArrayNullOrEmpty(jSONArray)) {
            return arrayList;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (!POBUtils.isJsonObjectNullOrEmpty(jSONObjectOptJSONObject)) {
                String strOptString = jSONObjectOptJSONObject.optString("url");
                if (!POBUtils.isNullOrEmpty(strOptString) && (eventType = POBNativeEventType.getEventType(jSONObjectOptJSONObject.optInt("event"))) != null && (eventTrackingMethod = POBNativeEventTrackingMethod.getEventTrackingMethod(jSONObjectOptJSONObject.optInt("method"))) != null) {
                    POBNativeAdResponseEventTracker pOBNativeAdResponseEventTracker = new POBNativeAdResponseEventTracker(strOptString, eventType, eventTrackingMethod);
                    JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("ext");
                    if (!POBUtils.isJsonObjectNullOrEmpty(jSONObjectOptJSONObject2)) {
                        pOBNativeAdResponseEventTracker.setExt(jSONObjectOptJSONObject2);
                    }
                    arrayList.add(pOBNativeAdResponseEventTracker);
                }
            }
        }
        return arrayList;
    }

    public POBNativeAdResponse parseNativeAdResponse(String str) throws Exception {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("ver");
            List listA = a(jSONObject.optJSONArray(POBNativeConstants.NATIVE_ASSETS));
            if (listA.isEmpty()) {
                throw new Exception(POBNativeLogConstants.NATIVE_EMPTY_ASSETS);
            }
            POBNativeAdResponse pOBNativeAdResponse = new POBNativeAdResponse(strOptString, listA, a(jSONObject.optJSONObject("link")), POBUtils.convertStringJsonArrayToList(jSONObject.optJSONArray(POBNativeConstants.NATIVE_IMPRESSION_TRACKER)), jSONObject.optString(POBNativeConstants.NATIVE_TRACKER_JAVASCRIPT), b(jSONObject.optJSONArray(POBNativeConstants.NATIVE_EVENT_TRACKERS)), jSONObject.has("privacy") ? jSONObject.optString("privacy") : null);
            POBLog.debug("POBNativeAdParser", "Native Ad response: " + pOBNativeAdResponse, new Object[0]);
            return pOBNativeAdResponse;
        } catch (JSONException e) {
            throw new Exception(e.getMessage());
        }
    }

    private POBNativeAdLinkResponse a(JSONObject jSONObject) {
        if (POBUtils.isJsonObjectNullOrEmpty(jSONObject)) {
            return null;
        }
        return new POBNativeAdLinkResponse(jSONObject.optString("url"), POBUtils.convertStringJsonArrayToList(jSONObject.optJSONArray(POBNativeConstants.NATIVE_CLICK_TRACKER)), jSONObject.optString(POBNativeConstants.NATIVE_FALLBACK_URL));
    }
}
