package net.pubnative.lite.sdk.models;

import java.util.List;
import net.pubnative.lite.sdk.utils.json.BindField;
import net.pubnative.lite.sdk.utils.json.JsonModel;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public class RemoteConfigAppConfig extends JsonModel {

    @BindField
    public String api;

    @BindField
    public String app_token;

    @BindField
    public List<String> enabled_apis;

    @BindField
    public List<String> enabled_protocols;

    @BindField
    public RemoteConfigAppFeatures features;

    public RemoteConfigAppConfig() {
    }

    public RemoteConfigAppConfig(JSONObject jSONObject) throws Exception {
        fromJson(jSONObject);
    }
}
