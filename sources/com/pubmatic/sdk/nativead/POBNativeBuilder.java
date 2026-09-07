package com.pubmatic.sdk.nativead;

import com.pubmatic.sdk.common.log.POBLog;
import com.pubmatic.sdk.nativead.request.POBBaseNativeRequestAsset;
import com.pubmatic.sdk.nativead.request.POBNativeRequestEventTracker;
import com.pubmatic.sdk.openwrap.core.POBNative;
import com.pubmatic.sdk.openwrap.core.nativead.POBNativeContextSubType;
import com.pubmatic.sdk.openwrap.core.nativead.POBNativeContextType;
import com.pubmatic.sdk.openwrap.core.nativead.POBNativePlacementType;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class POBNativeBuilder implements POBNative {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f7692a;
    private final List b;
    private final Set c;
    private POBNativeAdLoaderConfig d;

    public POBNativeBuilder(List<POBBaseNativeRequestAsset> list, List<POBNativeRequestEventTracker> list2, Set<Integer> set) {
        this.f7692a = list;
        this.b = list2;
        this.c = set;
    }

    private String a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("ver", POBNativeConstants.NATIVE_DEFAULT_VERSION);
        POBNativeAdLoaderConfig pOBNativeAdLoaderConfig = this.d;
        if (pOBNativeAdLoaderConfig != null) {
            POBNativeContextType contextType = pOBNativeAdLoaderConfig.getContextType();
            if (contextType != null) {
                jSONObject.put("context", contextType.getValue());
            }
            POBNativeContextSubType contextSubType = this.d.getContextSubType();
            if (contextSubType != null) {
                jSONObject.put(POBNativeConstants.NATIVE_CONTEXT_SUBTYPE, contextSubType.getValue());
            }
            POBNativePlacementType placementType = this.d.getPlacementType();
            if (placementType != null) {
                jSONObject.put(POBNativeConstants.NATIVE_PLACEMENT_TYPE, placementType.getValue());
            }
        }
        JSONArray jSONArray = new JSONArray();
        Iterator it = this.f7692a.iterator();
        while (it.hasNext()) {
            jSONArray.put(((POBBaseNativeRequestAsset) it.next()).getRTBJSON());
        }
        jSONObject.put(POBNativeConstants.NATIVE_ASSETS, jSONArray);
        if (!this.b.isEmpty()) {
            JSONArray jSONArray2 = new JSONArray();
            Iterator it2 = this.b.iterator();
            while (it2.hasNext()) {
                jSONArray2.put(((POBNativeRequestEventTracker) it2.next()).getRTBJSON());
            }
            jSONObject.put(POBNativeConstants.NATIVE_EVENT_TRACKERS, jSONArray2);
        }
        jSONObject.put("privacy", 1);
        return jSONObject.toString();
    }

    public List<POBBaseNativeRequestAsset> getAssets() {
        return this.f7692a;
    }

    public POBNativeAdLoaderConfig getConfig() {
        return this.d;
    }

    public List<POBNativeRequestEventTracker> getEventTrackers() {
        return this.b;
    }

    @Override // com.pubmatic.sdk.openwrap.core.POBNative
    public JSONObject getRTBJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("request", a());
            jSONObject.put("ver", POBNativeConstants.NATIVE_DEFAULT_VERSION);
            jSONObject.put("api", new JSONArray((Collection) this.c));
        } catch (JSONException e) {
            POBLog.error("POBNativeBuilder", String.format(POBNativeLogConstants.NATIVE_JSON_EXCEPTION, "POBNativeBuilder") + e.getMessage(), new Object[0]);
        }
        return jSONObject;
    }

    public Set<Integer> getSupportedAPIs() {
        return this.c;
    }

    public void setConfig(POBNativeAdLoaderConfig pOBNativeAdLoaderConfig) {
        this.d = pOBNativeAdLoaderConfig;
    }
}
