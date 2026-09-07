package net.pubnative.lite.sdk.models;

import net.pubnative.lite.sdk.utils.json.BindField;
import net.pubnative.lite.sdk.utils.json.JsonModel;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public class IdBattery extends JsonModel {

    @BindField
    public String capacity;

    @BindField
    public Boolean charging;

    public IdBattery() {
    }

    public IdBattery(JSONObject jSONObject) throws Exception {
        fromJson(jSONObject);
    }
}
