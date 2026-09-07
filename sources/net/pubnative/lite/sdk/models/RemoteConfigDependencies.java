package net.pubnative.lite.sdk.models;

import java.util.List;
import net.pubnative.lite.sdk.utils.json.BindField;
import net.pubnative.lite.sdk.utils.json.JsonModel;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class RemoteConfigDependencies extends JsonModel {

    @BindField
    public List<String> metadata;

    @BindField
    public List<String> models;

    public RemoteConfigDependencies() {
    }

    public RemoteConfigDependencies(JSONObject jSONObject) throws Exception {
        fromJson(jSONObject);
    }
}
