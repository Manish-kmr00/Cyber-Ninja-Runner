package net.pubnative.lite.sdk.models.request;

import java.util.List;
import net.pubnative.lite.sdk.utils.json.BindField;
import net.pubnative.lite.sdk.utils.json.JsonModel;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class BrandVersion extends JsonModel {

    @BindField
    private String brand;

    @BindField
    private List<String> version;

    public BrandVersion() {
    }

    public BrandVersion(JSONObject jSONObject) throws Exception {
        fromJson(jSONObject);
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String str) {
        this.brand = str;
    }

    public List<String> getVersion() {
        return this.version;
    }

    public void setVersion(List<String> list) {
        this.version = list;
    }
}
