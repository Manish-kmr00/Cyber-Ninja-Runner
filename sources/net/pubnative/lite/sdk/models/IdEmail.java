package net.pubnative.lite.sdk.models;

import net.pubnative.lite.sdk.utils.json.BindField;
import net.pubnative.lite.sdk.utils.json.JsonModel;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class IdEmail extends JsonModel {

    @BindField
    public String email;

    public IdEmail() {
    }

    public IdEmail(JSONObject jSONObject) throws Exception {
        fromJson(jSONObject);
    }
}
