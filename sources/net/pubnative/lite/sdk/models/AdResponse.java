package net.pubnative.lite.sdk.models;

import java.util.List;
import net.pubnative.lite.sdk.utils.json.BindField;
import net.pubnative.lite.sdk.utils.json.JsonModel;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class AdResponse extends JsonModel {

    @BindField
    public List<Ad> ads;

    @BindField
    public String error_message;

    @BindField
    public List<AdExt> ext;

    @BindField
    public String status;

    public interface Status {
        public static final String ERROR = "error";
        public static final String OK = "ok";
    }

    public AdResponse() {
    }

    public AdResponse(JSONObject jSONObject) throws Exception {
        fromJson(jSONObject);
    }
}
