package net.pubnative.lite.sdk.models.request;

import java.util.List;
import net.pubnative.lite.sdk.utils.json.BindField;
import net.pubnative.lite.sdk.utils.json.JsonModel;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public class Pmp extends JsonModel {

    @BindField
    private List<Deal> deals;

    @BindField
    private Integer private_auction = 0;

    public Pmp() {
    }

    public Pmp(JSONObject jSONObject) throws Exception {
        fromJson(jSONObject);
    }

    public Integer getPrivateAuction() {
        return this.private_auction;
    }

    public void setPrivateAuction(Integer num) {
        this.private_auction = num;
    }

    public List<Deal> getDeals() {
        return this.deals;
    }

    public void setDeals(List<Deal> list) {
        this.deals = list;
    }
}
