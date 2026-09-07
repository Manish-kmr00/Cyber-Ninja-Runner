package net.pubnative.lite.sdk.models;

import net.pubnative.lite.sdk.utils.json.BindField;
import net.pubnative.lite.sdk.utils.json.JsonModel;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class RemoteConfigMetadata extends JsonModel {

    @BindField
    public RemoteConfigLastVersion last_version;

    @BindField
    public String name;

    public RemoteConfigMetadata() {
    }

    public RemoteConfigMetadata(JSONObject jSONObject) throws Exception {
        fromJson(jSONObject);
    }
}
