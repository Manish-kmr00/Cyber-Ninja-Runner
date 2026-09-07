package com.pubmatic.sdk.nativead.request;

import com.pubmatic.sdk.common.log.POBLog;
import com.pubmatic.sdk.nativead.POBNativeConstants;
import com.pubmatic.sdk.nativead.POBNativeLogConstants;
import com.pubmatic.sdk.openwrap.core.nativead.POBNativeEventTrackingMethod;
import com.pubmatic.sdk.openwrap.core.nativead.POBNativeEventType;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class POBNativeRequestEventTracker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final POBNativeEventType f7702a;
    private final List b;

    public POBNativeRequestEventTracker(POBNativeEventType pOBNativeEventType, List<POBNativeEventTrackingMethod> list) {
        this.f7702a = pOBNativeEventType;
        this.b = list;
    }

    public List<POBNativeEventTrackingMethod> getMethods() {
        return this.b;
    }

    public JSONObject getRTBJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("event", this.f7702a.getEventTypeValue());
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < this.b.size(); i++) {
                jSONArray.put(((POBNativeEventTrackingMethod) this.b.get(i)).getEventEventTrackingMethodValue());
            }
            jSONObject.put(POBNativeConstants.NATIVE_METHODS, jSONArray);
        } catch (JSONException e) {
            POBLog.error("POBNativeReqEventTrackr", String.format(POBNativeLogConstants.NATIVE_JSON_EXCEPTION, "POBNativeReqEventTrackr") + e.getMessage(), new Object[0]);
        }
        return jSONObject;
    }

    public POBNativeEventType getType() {
        return this.f7702a;
    }
}
