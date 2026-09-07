package net.pubnative.lite.sdk.db;

import net.pubnative.lite.sdk.utils.json.BindField;
import net.pubnative.lite.sdk.utils.json.JsonModel;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public class SessionImpression extends JsonModel {

    @BindField
    private Long age_of_app;

    @BindField
    private Integer count;

    @BindField
    private Long session_duration;

    @BindField
    private Long timestamp;

    @BindField
    private String zone_id;

    public SessionImpression() {
    }

    public SessionImpression(JSONObject jSONObject) {
        try {
            fromJson(jSONObject);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(Long l) {
        this.timestamp = l;
    }

    public Long getAgeOfApp() {
        return this.age_of_app;
    }

    public void setAgeOfApp(Long l) {
        this.age_of_app = l;
    }

    public String getZoneId() {
        return this.zone_id;
    }

    public void setZoneId(String str) {
        this.zone_id = str;
    }

    public Long getSessionDuration() {
        return this.session_duration;
    }

    public void setSessionDuration(Long l) {
        this.session_duration = l;
    }

    public Integer getCount() {
        Integer num = this.count;
        if (num == null) {
            return 0;
        }
        return num;
    }

    public void setCount(Integer num) {
        this.count = num;
    }
}
