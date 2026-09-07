package net.pubnative.lite.sdk.models.response;

import java.util.List;
import net.pubnative.lite.sdk.utils.json.BindField;
import net.pubnative.lite.sdk.utils.json.JsonModel;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public class SeatBid extends JsonModel {

    @BindField
    private List<Bid> bid;

    @BindField
    private Integer group = 0;

    @BindField
    private String seat;

    public SeatBid() {
    }

    public SeatBid(JSONObject jSONObject) throws Exception {
        fromJson(jSONObject);
    }

    public List<Bid> getBids() {
        return this.bid;
    }

    public String getSeat() {
        return this.seat;
    }

    public Integer getGroup() {
        return this.group;
    }
}
