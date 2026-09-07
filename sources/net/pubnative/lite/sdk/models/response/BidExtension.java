package net.pubnative.lite.sdk.models.response;

import java.util.List;
import net.pubnative.lite.sdk.utils.json.BindField;
import net.pubnative.lite.sdk.utils.json.JsonModel;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class BidExtension extends JsonModel {

    @BindField
    private String crtype;

    @BindField
    private List<String> imptrackers;

    @BindField
    private String signaldata;

    public BidExtension(JSONObject jSONObject) throws Exception {
        fromJson(jSONObject);
    }

    public String getCrtype() {
        return this.crtype;
    }

    public void setCrtype(String str) {
        this.crtype = str;
    }

    public List<String> getImptrackers() {
        return this.imptrackers;
    }

    public void setImptrackers(List<String> list) {
        this.imptrackers = list;
    }

    public String getSignaldata() {
        return this.signaldata;
    }

    public void setSignaldata(String str) {
        this.signaldata = str;
    }
}
