package net.pubnative.lite.sdk.models;

import net.pubnative.lite.sdk.utils.json.BindField;
import net.pubnative.lite.sdk.utils.json.JsonModel;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class AtomConfigResponse extends JsonModel {

    @BindField
    public AtomConfig configs;

    @BindField
    public String error_message;

    @BindField
    public String status;

    public interface Status {
        public static final String ERROR = "error";
        public static final String OK = "ok";
    }

    public AtomConfigResponse() {
    }

    public AtomConfigResponse(JSONObject jSONObject) throws Exception {
        fromJson(jSONObject);
    }
}
