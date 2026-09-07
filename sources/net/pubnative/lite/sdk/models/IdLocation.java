package net.pubnative.lite.sdk.models;

import net.pubnative.lite.sdk.utils.json.BindField;
import net.pubnative.lite.sdk.utils.json.JsonModel;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class IdLocation extends JsonModel {

    @BindField
    public String accuracy;

    @BindField
    public String category;

    @BindField
    public String lat;

    @BindField
    public String lon;

    @BindField
    public String ts;

    @BindField
    public String type;

    public IdLocation() {
    }

    public IdLocation(JSONObject jSONObject) throws Exception {
        fromJson(jSONObject);
    }
}
