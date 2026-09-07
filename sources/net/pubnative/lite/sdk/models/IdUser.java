package net.pubnative.lite.sdk.models;

import java.util.List;
import net.pubnative.lite.sdk.utils.json.BindField;
import net.pubnative.lite.sdk.utils.json.JsonModel;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class IdUser extends JsonModel {

    @BindField
    public String SUID;

    @BindField
    public List<IdAudience> audiences;

    @BindField
    public List<IdEmail> emails;

    @BindField
    public List<IdLocation> locations;

    @BindField
    public IdUserVendor vendors;

    public IdUser() {
    }

    public IdUser(JSONObject jSONObject) throws Exception {
        fromJson(jSONObject);
    }
}
