package net.pubnative.lite.sdk.models;

import net.pubnative.lite.sdk.utils.json.BindField;
import net.pubnative.lite.sdk.utils.json.JsonModel;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class IdOs extends JsonModel {

    @BindField
    public String build_signature;

    @BindField
    public String name;

    @BindField
    public String version;

    public IdOs() {
    }

    public IdOs(JSONObject jSONObject) throws Exception {
        fromJson(jSONObject);
    }
}
