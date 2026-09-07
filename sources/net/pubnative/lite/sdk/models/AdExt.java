package net.pubnative.lite.sdk.models;

import java.util.Map;
import net.pubnative.lite.sdk.utils.json.BindField;
import net.pubnative.lite.sdk.utils.json.JsonModel;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public class AdExt extends JsonModel {

    @BindField
    protected Map meta;

    public AdExt(JSONObject jSONObject) throws Exception {
        fromJson(jSONObject);
    }
}
