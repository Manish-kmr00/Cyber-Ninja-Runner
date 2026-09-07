package net.pubnative.lite.sdk.models.request;

import java.util.List;
import net.pubnative.lite.sdk.utils.json.BindField;
import net.pubnative.lite.sdk.utils.json.JsonModel;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class User extends JsonModel {

    @BindField
    private String buyeruid;

    @BindField
    private String customdata;

    @BindField
    private List<Data> data;

    @BindField
    private String gender;

    @BindField
    private Geo geo;

    @BindField
    private String id;

    @BindField
    private String keywords;

    @BindField
    private Integer yob;

    public User() {
    }

    public User(JSONObject jSONObject) throws Exception {
        fromJson(jSONObject);
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getBuyeruid() {
        return this.buyeruid;
    }

    public void setBuyeruid(String str) {
        this.buyeruid = str;
    }

    public Integer getYearOfBirth() {
        return this.yob;
    }

    public void setYearOfBirth(Integer num) {
        this.yob = num;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String str) {
        this.gender = str;
    }

    public String getKeywords() {
        return this.keywords;
    }

    public void setKeywords(String str) {
        this.keywords = str;
    }

    public String getCustomData() {
        return this.customdata;
    }

    public void setCustomData(String str) {
        this.customdata = str;
    }

    public Geo getGeo() {
        return this.geo;
    }

    public void setGeo(Geo geo) {
        this.geo = geo;
    }

    public List<Data> getData() {
        return this.data;
    }

    public void setData(List<Data> list) {
        this.data = list;
    }
}
