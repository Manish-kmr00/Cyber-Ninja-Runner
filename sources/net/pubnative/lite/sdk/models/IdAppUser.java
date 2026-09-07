package net.pubnative.lite.sdk.models;

import net.pubnative.lite.sdk.utils.json.BindField;
import net.pubnative.lite.sdk.utils.json.JsonModel;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class IdAppUser extends JsonModel {

    @BindField
    public String AUID;

    @BindField
    public String SUID;

    @BindField
    public IdAppVendor vendors;

    public IdAppUser() {
    }

    public IdAppUser(JSONObject jSONObject) throws Exception {
        fromJson(jSONObject);
    }
}
