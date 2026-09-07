package net.pubnative.lite.sdk.models.request;

import net.pubnative.lite.sdk.utils.json.BindField;
import net.pubnative.lite.sdk.utils.json.JsonModel;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class Segment extends JsonModel {

    @BindField
    private String id;

    @BindField
    private String name;

    @BindField
    private String signal;

    @BindField
    private String value;

    public Segment() {
    }

    public Segment(JSONObject jSONObject) throws Exception {
        fromJson(jSONObject);
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public String getSignal() {
        return this.signal;
    }

    public void setSignal(String str) {
        this.signal = str;
    }
}
