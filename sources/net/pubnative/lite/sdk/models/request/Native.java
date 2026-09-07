package net.pubnative.lite.sdk.models.request;

import java.util.List;
import net.pubnative.lite.sdk.utils.json.BindField;
import net.pubnative.lite.sdk.utils.json.JsonModel;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class Native extends JsonModel {

    @BindField
    private List<Integer> api;

    @BindField
    private List<Integer> battr;

    @BindField
    private String request;

    @BindField
    private String ver;

    public Native() {
    }

    public Native(JSONObject jSONObject) throws Exception {
        fromJson(jSONObject);
    }

    public String getRequest() {
        return this.request;
    }

    public void setRequest(String str) {
        this.request = str;
    }

    public String getVer() {
        return this.ver;
    }

    public void setVer(String str) {
        this.ver = str;
    }

    public List<Integer> getApi() {
        return this.api;
    }

    public void setApi(List<Integer> list) {
        this.api = list;
    }

    public List<Integer> getBlockedAttr() {
        return this.battr;
    }

    public void setBlockedAttr(List<Integer> list) {
        this.battr = list;
    }
}
