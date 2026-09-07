package net.pubnative.lite.sdk.models;

import net.pubnative.lite.sdk.utils.json.BindField;
import net.pubnative.lite.sdk.utils.json.JsonModel;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class IdAppVendor extends JsonModel {

    @BindField
    public IdApl APL;

    @BindField
    public IdLr LR;

    @BindField
    public IdTtd TTD;

    public IdAppVendor() {
    }

    public IdAppVendor(JSONObject jSONObject) throws Exception {
        fromJson(jSONObject);
    }
}
