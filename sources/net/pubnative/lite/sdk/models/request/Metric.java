package net.pubnative.lite.sdk.models.request;

import net.pubnative.lite.sdk.utils.json.BindField;
import net.pubnative.lite.sdk.utils.json.JsonModel;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public class Metric extends JsonModel {

    @BindField
    private String type;

    @BindField
    private Float value;

    @BindField
    private String vendor;

    public Metric() {
    }

    public Metric(JSONObject jSONObject) throws Exception {
        fromJson(jSONObject);
    }

    public String getType() {
        return this.type;
    }

    public Float getValue() {
        return this.value;
    }

    public String getVendor() {
        return this.vendor;
    }
}
