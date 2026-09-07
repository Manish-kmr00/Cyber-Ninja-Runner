package net.pubnative.lite.sdk.models.response;

import java.util.List;
import net.pubnative.lite.sdk.utils.json.BindField;
import net.pubnative.lite.sdk.utils.json.JsonModel;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class OpenRTBResponse extends JsonModel {

    @BindField
    private String bidid;

    @BindField
    private String cur = "USD";

    @BindField
    private String customData;

    @BindField
    private String id;

    @BindField
    private Integer nbr;

    @BindField
    private List<SeatBid> seatbid;

    public OpenRTBResponse() {
    }

    public OpenRTBResponse(JSONObject jSONObject) throws Exception {
        fromJson(jSONObject);
    }

    public String getId() {
        return this.id;
    }

    public List<SeatBid> getSeatBids() {
        return this.seatbid;
    }

    public String getCurrency() {
        return this.cur;
    }

    public String getBidId() {
        return this.bidid;
    }

    public String getCustomData() {
        return this.customData;
    }

    public Integer getNoBidReason() {
        return this.nbr;
    }
}
