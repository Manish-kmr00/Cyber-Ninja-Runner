package net.pubnative.lite.sdk.models;

import java.util.List;
import net.pubnative.lite.sdk.utils.json.BindField;
import net.pubnative.lite.sdk.utils.json.JsonModel;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class RemoteConfigAppInfo extends JsonModel {

    @BindField
    public String app_store_id;

    @BindField
    public List<String> iab_categories;

    @BindField
    public Double pf;

    @BindField
    public Double pm;

    public RemoteConfigAppInfo() {
    }

    public RemoteConfigAppInfo(JSONObject jSONObject) throws Exception {
        fromJson(jSONObject);
    }
}
