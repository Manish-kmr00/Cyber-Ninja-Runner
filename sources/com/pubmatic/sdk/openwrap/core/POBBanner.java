package com.pubmatic.sdk.openwrap.core;

import com.pubmatic.sdk.common.POBAdSize;
import com.pubmatic.sdk.common.POBCommonConstants;
import com.pubmatic.sdk.common.POBInstanceProvider;
import com.pubmatic.sdk.common.log.POBLog;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class POBBanner {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private POBAdSize[] f7723a;
    private POBRequest.AdPosition b;

    public POBBanner(POBAdSize... pOBAdSizeArr) {
        this.f7723a = pOBAdSizeArr;
        this.b = POBRequest.AdPosition.UNKNOWN;
    }

    public JSONObject getRTBJson(Set<Integer> set, boolean z) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        POBRequest.AdPosition adPosition = this.b;
        if (adPosition != null) {
            jSONObject.put(POBConstants.KEY_POSITION, adPosition.getValue());
        }
        POBAdSize[] pOBAdSizeArr = this.f7723a;
        if (pOBAdSizeArr != null) {
            jSONObject.put("format", getSizeArray(pOBAdSizeArr));
        }
        if (!set.isEmpty()) {
            jSONObject.put("api", new JSONArray((Collection) set));
        }
        if (z) {
            jSONObject.put(POBConstants.KEY_VCM, 1);
            if (POBRequest.AdPosition.FULL_SCREEN.equals(this.b)) {
                jSONObject.put("api", new JSONArray((Collection) getSupportedAPIs(true)));
            }
        }
        return jSONObject;
    }

    public JSONArray getSizeArray(POBAdSize... pOBAdSizeArr) {
        JSONArray jSONArray = new JSONArray();
        for (POBAdSize pOBAdSize : pOBAdSizeArr) {
            if (pOBAdSize != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("w", pOBAdSize.getAdWidth());
                    jSONObject.put("h", pOBAdSize.getAdHeight());
                    jSONArray.put(jSONObject);
                } catch (JSONException unused) {
                    POBLog.error("POBBanner", "Error on formatting width/height in ad request.", new Object[0]);
                }
            }
        }
        return jSONArray;
    }

    public Set<Integer> getSupportedAPIs(boolean z) {
        HashSet hashSet = new HashSet();
        hashSet.add(Integer.valueOf(POBRequest.API.MRAID2.getValue()));
        hashSet.add(Integer.valueOf(POBRequest.API.MRAID3.getValue()));
        if (!z && POBInstanceProvider.getSdkConfig().getMeasurementProvider(POBCommonConstants.HTML_MEASUREMENT_PROVIDER_CLASS) != null) {
            hashSet.add(Integer.valueOf(POBRequest.API.OMSDK.getValue()));
        }
        return hashSet;
    }

    public void setAdPosition(POBRequest.AdPosition adPosition) {
        this.b = adPosition;
    }

    public void setAdSizes(POBAdSize... pOBAdSizeArr) {
        this.f7723a = pOBAdSizeArr;
    }

    public POBBanner() {
    }
}
