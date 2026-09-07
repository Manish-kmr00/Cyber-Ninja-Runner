package net.pubnative.lite.sdk.models.request;

import java.util.List;
import net.pubnative.lite.sdk.utils.json.BindField;
import net.pubnative.lite.sdk.utils.json.JsonModel;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class Deal extends JsonModel {

    @BindField
    private Integer at;

    @BindField
    private Float bidfloor = Float.valueOf(0.0f);

    @BindField
    private String bidfloorcur = "USD";

    @BindField
    private String id;

    @BindField
    private List<String> wadomain;

    @BindField
    private List<String> wseat;

    public Deal() {
    }

    public Deal(JSONObject jSONObject) throws Exception {
        fromJson(jSONObject);
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public Float getBidFloor() {
        return this.bidfloor;
    }

    public void setBidFloor(Float f) {
        this.bidfloor = f;
    }

    public String getBidFloorCurrency() {
        return this.bidfloorcur;
    }

    public void setBidFloorCurrency(String str) {
        this.bidfloorcur = str;
    }

    public Integer getAuctionType() {
        return this.at;
    }

    public void setAuctionType(Integer num) {
        this.at = num;
    }

    public List<String> getWSeat() {
        return this.wseat;
    }

    public void setWSeat(List<String> list) {
        this.wseat = list;
    }

    public List<String> getWAdomain() {
        return this.wadomain;
    }

    public void setWAdomain(List<String> list) {
        this.wadomain = list;
    }
}
