package net.pubnative.lite.sdk.models;

import net.pubnative.lite.sdk.utils.json.BindField;
import net.pubnative.lite.sdk.utils.json.JsonModel;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public class SignalData extends JsonModel {

    @BindField
    public AdResponse adm;

    @BindField
    public String admurl;

    @BindField
    public String status;

    @BindField
    public String tagid;

    public SignalData() {
    }

    public SignalData(JSONObject jSONObject) throws Exception {
        fromJson(jSONObject);
    }
}
