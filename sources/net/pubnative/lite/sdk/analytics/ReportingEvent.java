package net.pubnative.lite.sdk.analytics;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.Iterator;
import net.pubnative.lite.sdk.utils.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class ReportingEvent {
    private static final String TAG = "ReportingEvent";
    private final JSONObject eventObject = new JSONObject();

    public synchronized void setCategoryId(String str) {
        setCustomString(Reporting.Key.CATEGORY_ID, str);
    }

    public String getCategoryId() {
        return getCustomString(Reporting.Key.CATEGORY_ID);
    }

    public synchronized void setCampaignId(String str) {
        setCustomString("campaign_id", str);
    }

    public String getCampaignId() {
        return getCustomString("campaign_id");
    }

    public synchronized void setCreativeId(String str) {
        setCustomString("creative_id", str);
    }

    public String getCreativeId() {
        return getCustomString("creative_id");
    }

    public synchronized void setCreativeType(String str) {
        setCustomString(Reporting.Key.CREATIVE_TYPE, str);
    }

    public String getCreativeType() {
        return getCustomString(Reporting.Key.CREATIVE_TYPE);
    }

    public synchronized void setCreative(String str) {
        setCustomString(Reporting.Key.CREATIVE, str);
    }

    public String getCreative() {
        return getCustomString(Reporting.Key.CREATIVE);
    }

    public synchronized void setTimestamp(long j) {
        setCustomString("timestamp", String.valueOf(j));
    }

    public synchronized void setTimestamp(String str) {
        setCustomString("timestamp", str);
    }

    public String getTimestamp() {
        return getCustomString("timestamp");
    }

    public synchronized void setEventType(String str) {
        setCustomString("event_type", str);
    }

    public String getEventType() {
        return getCustomString("event_type");
    }

    public synchronized void setErrorCode(int i) {
        setCustomInteger("error_code", i);
    }

    public long getErrorCode() {
        return getCustomInteger("error_code").longValue();
    }

    public synchronized void setErrorMessage(String str) {
        setCustomString("error_message", str);
    }

    public String getErrorMessage() {
        return getCustomString("error_message");
    }

    public synchronized void setAdFormat(String str) {
        setCustomString("ad_format", str);
    }

    public String getAdFormat() {
        return getCustomString("ad_format");
    }

    public synchronized void setAdSize(String str) {
        setCustomString(Reporting.Key.AD_SIZE, str);
    }

    public String getAdSize() {
        return getCustomString(Reporting.Key.AD_SIZE);
    }

    public synchronized void setHasEndCard(boolean z) {
        setCustomBoolean(Reporting.Key.HAS_END_CARD, z);
    }

    public boolean getHasEndCard() {
        return getCustomBoolean(Reporting.Key.HAS_END_CARD).booleanValue();
    }

    public synchronized void setZoneId(String str) {
        setCustomString("zone_id", str);
    }

    public String getZoneId() {
        return getCustomString("zone_id");
    }

    public synchronized void setAdType(String str) {
        setCustomString("ad_type", str);
    }

    public String getAdType() {
        return getCustomString("ad_type");
    }

    public synchronized void setPlatform(String str) {
        setCustomString("platform", str);
    }

    public String getPlatform() {
        return getCustomString("platform");
    }

    public synchronized void setSdkVersion(String str) {
        setCustomString(Reporting.Key.HYBID_VERSION, str);
    }

    public String getSdkVersion() {
        return getCustomString(Reporting.Key.HYBID_VERSION);
    }

    public synchronized void setAppToken(String str) {
        setCustomString(Reporting.Key.APP_TOKEN, str);
    }

    public String getAppToken() {
        return getCustomString(Reporting.Key.APP_TOKEN);
    }

    public synchronized void setPlacementId(String str) {
        setCustomString(Reporting.Key.PLACEMENT_ID, str);
    }

    public String getPlacementId() {
        return getCustomString(Reporting.Key.PLACEMENT_ID);
    }

    public synchronized void setIntegrationType(String str) {
        setCustomString("integration_type", str);
    }

    public String getIntegrationType() {
        return getCustomString("integration_type");
    }

    public synchronized void setVast(String str) {
        setCustomString("vast", str);
    }

    public String getVast() {
        return getCustomString("vast");
    }

    public synchronized void setSessionDuration(String str) {
        setCustomString("session_duration", str);
    }

    public synchronized void setRequestType(String str) {
        setCustomString(Reporting.Key.REQUEST_TYPE, str);
    }

    public synchronized String getRequestType() {
        return getCustomString(Reporting.Key.REQUEST_TYPE);
    }

    public String getSessionDuration() {
        return getCustomString("session_duration");
    }

    public synchronized void setImpDepth(String str) {
        setCustomString(Reporting.Key.IMP_DEPTH, str);
    }

    public String getImpDepth() {
        return getCustomString(Reporting.Key.IMP_DEPTH);
    }

    public synchronized void setImpId(String str) {
        setCustomString("impression_id", str);
    }

    public String getImpId() {
        return getCustomString("impression_id");
    }

    public synchronized void setConfigId(String str) {
        setCustomString(Reporting.Key.REMOTE_CONFIG_ID, str);
    }

    public String getConfigId() {
        return getCustomString(Reporting.Key.REMOTE_CONFIG_ID);
    }

    public synchronized void setAgeOfApp(String str) {
        setCustomString("age_of_app", str);
    }

    public String getAgeOfApp() {
        return getCustomString("age_of_app");
    }

    public synchronized void setCustomString(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str2)) {
                this.eventObject.put(str, str2);
            }
        } catch (JSONException e) {
            Logger.e(TAG, e.getMessage());
        }
    }

    public String getCustomString(String str) {
        try {
            return this.eventObject.getString(str);
        } catch (JSONException e) {
            Logger.e(TAG, e.getMessage());
            return null;
        }
    }

    public void setCustomInteger(String str, long j) {
        try {
            this.eventObject.put(str, j);
        } catch (JSONException e) {
            Logger.e(TAG, e.getMessage());
        }
    }

    public Long getCustomInteger(String str) {
        try {
            return Long.valueOf(this.eventObject.getLong(str));
        } catch (JSONException e) {
            Logger.e(TAG, e.getMessage());
            return null;
        }
    }

    public synchronized void setCustomDecimal(String str, double d) {
        try {
            this.eventObject.put(str, d);
        } catch (JSONException e) {
            Logger.e(TAG, e.getMessage());
        }
    }

    public Double getCustomDecimal(String str) {
        try {
            return Double.valueOf(this.eventObject.getDouble(str));
        } catch (JSONException e) {
            Logger.e(TAG, e.getMessage());
            return null;
        }
    }

    public synchronized void setCustomBoolean(String str, boolean z) {
        try {
            this.eventObject.put(str, z);
        } catch (JSONException e) {
            Logger.e(TAG, e.getMessage());
        }
    }

    public Boolean getCustomBoolean(String str) {
        try {
            return Boolean.valueOf(this.eventObject.getBoolean(str));
        } catch (JSONException e) {
            Logger.e(TAG, e.getMessage());
            return null;
        }
    }

    public synchronized void setCustomJSONObject(String str, JSONObject jSONObject) {
        try {
            this.eventObject.put(str, jSONObject);
        } catch (JSONException e) {
            Logger.e(TAG, e.getMessage());
        }
    }

    public JSONObject getCustomJSONObject(String str) {
        try {
            return this.eventObject.getJSONObject(str);
        } catch (JSONException e) {
            Logger.e(TAG, e.getMessage());
            return null;
        }
    }

    public synchronized void mergeJSONObject(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (jSONObject.length() != 0) {
                JSONArray jSONArrayNames = jSONObject.names();
                if (jSONArrayNames != null) {
                    for (int i = 0; i < jSONArrayNames.length(); i++) {
                        try {
                            String string = jSONArrayNames.getString(i);
                            this.eventObject.put(string, jSONObject.get(string));
                        } catch (JSONException unused) {
                        }
                    }
                }
            }
        }
    }

    public synchronized void setCustomJSONArray(String str, JSONArray jSONArray) {
        try {
            this.eventObject.put(str, jSONArray);
        } catch (JSONException e) {
            Logger.e(TAG, e.getMessage());
        }
    }

    public JSONArray getCustomJSONArray(String str) {
        try {
            return this.eventObject.getJSONArray(str);
        } catch (JSONException e) {
            Logger.e(TAG, e.getMessage());
            return null;
        }
    }

    public Bundle getEventData() {
        Bundle bundle = new Bundle();
        Iterator<String> itKeys = this.eventObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            try {
                bundle.putString(next, this.eventObject.getString(next));
            } catch (JSONException unused) {
            }
        }
        return bundle;
    }

    public JSONObject getEventObject() {
        return this.eventObject;
    }
}
