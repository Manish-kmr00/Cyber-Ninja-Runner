package net.pubnative.lite.sdk.models.request;

import net.pubnative.lite.sdk.utils.json.BindField;
import net.pubnative.lite.sdk.utils.json.JsonModel;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class Geo extends JsonModel {

    @BindField
    private Integer accuracy;

    @BindField
    private String city;

    @BindField
    private String country;

    @BindField
    private Integer ipservice;

    @BindField
    private Integer lastfix;

    @BindField
    private Float lat;

    @BindField
    private Float lon;

    @BindField
    private String metro;

    @BindField
    private String region;

    @BindField
    private String regionfips104;

    @BindField
    private Integer type;

    @BindField
    private Integer utcoffset;

    @BindField
    private String zip;

    public Geo() {
    }

    public Geo(JSONObject jSONObject) throws Exception {
        fromJson(jSONObject);
    }

    public Float getLat() {
        return this.lat;
    }

    public void setLat(Float f) {
        this.lat = f;
    }

    public Float getLon() {
        return this.lon;
    }

    public void setLon(Float f) {
        this.lon = f;
    }

    public Integer getType() {
        return this.type;
    }

    public void setType(Integer num) {
        this.type = num;
    }

    public Integer getAccuracy() {
        return this.accuracy;
    }

    public void setAccuracy(Integer num) {
        this.accuracy = num;
    }

    public Integer getLastfix() {
        return this.lastfix;
    }

    public void setLastfix(Integer num) {
        this.lastfix = num;
    }

    public Integer getIpservice() {
        return this.ipservice;
    }

    public void setIpservice(Integer num) {
        this.ipservice = num;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public String getRegion() {
        return this.region;
    }

    public void setRegion(String str) {
        this.region = str;
    }

    public String getRegionfips104() {
        return this.regionfips104;
    }

    public void setRegionfips104(String str) {
        this.regionfips104 = str;
    }

    public String getMetro() {
        return this.metro;
    }

    public void setMetro(String str) {
        this.metro = str;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public String getZip() {
        return this.zip;
    }

    public void setZip(String str) {
        this.zip = str;
    }

    public Integer getUtcoffset() {
        return this.utcoffset;
    }

    public void setUtcoffset(Integer num) {
        this.utcoffset = num;
    }
}
