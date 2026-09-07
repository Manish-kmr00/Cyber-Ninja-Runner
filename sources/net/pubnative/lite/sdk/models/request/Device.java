package net.pubnative.lite.sdk.models.request;

import net.pubnative.lite.sdk.models.bidstream.DeviceExtension;
import net.pubnative.lite.sdk.utils.json.BindField;
import net.pubnative.lite.sdk.utils.json.JsonModel;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public class Device extends JsonModel {

    @BindField
    private String carrier;

    @BindField
    private Integer connectiontype;

    @BindField
    private Integer devicetype;

    @BindField
    private String didmd5;

    @BindField
    private String didsha1;

    @BindField
    private Integer dnt;

    @BindField
    private String dpidmd5;

    @BindField
    private String dpidsha1;

    @BindField
    private DeviceExtension ext;

    @BindField
    private String flashver;

    @BindField
    private Geo geo;

    @BindField
    private Integer geofetch;

    @BindField
    private Integer h;

    @BindField
    private String hmw;

    @BindField
    private String ifa;

    @BindField
    private String ip;

    @BindField
    private String ipv6;

    @BindField
    private Integer js;

    @BindField
    private String language;

    @BindField
    private Integer lmt;

    @BindField
    private String macmd5;

    @BindField
    private String macsha1;

    @BindField
    private String make;

    @BindField
    private String mccmnc;

    @BindField
    private String mccmncsim;

    @BindField
    private String model;

    @BindField
    private String os;

    @BindField
    private String osv;

    @BindField
    private Integer ppi;

    @BindField
    private Float pxratio;

    @BindField
    private UserAgent sua;

    @BindField
    private String ua;

    @BindField
    private Integer w;

    public Device() {
    }

    public Device(JSONObject jSONObject) throws Exception {
        fromJson(jSONObject);
    }

    public String getUserAgent() {
        return this.ua;
    }

    public void setUserAgent(String str) {
        this.ua = str;
    }

    public Geo getGeo() {
        return this.geo;
    }

    public void setGeo(Geo geo) {
        this.geo = geo;
    }

    public Integer getDnt() {
        return this.dnt;
    }

    public void setDnt(Integer num) {
        this.dnt = num;
    }

    public Integer getLmt() {
        return this.lmt;
    }

    public void setLmt(Integer num) {
        this.lmt = num;
    }

    public String getIp() {
        return this.ip;
    }

    public void setIp(String str) {
        this.ip = str;
    }

    public String getIpv6() {
        return this.ipv6;
    }

    public void setIpv6(String str) {
        this.ipv6 = str;
    }

    public Integer getDeviceType() {
        return this.devicetype;
    }

    public void setDeviceType(Integer num) {
        this.devicetype = num;
    }

    public String getMake() {
        return this.make;
    }

    public void setMake(String str) {
        this.make = str;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String str) {
        this.model = str;
    }

    public String getOs() {
        return this.os;
    }

    public void setOs(String str) {
        this.os = str;
    }

    public String getOsVersion() {
        return this.osv;
    }

    public void setOsVersion(String str) {
        this.osv = str;
    }

    public String getHmw() {
        return this.hmw;
    }

    public void setHmw(String str) {
        this.hmw = str;
    }

    public Integer getH() {
        return this.h;
    }

    public void setH(Integer num) {
        this.h = num;
    }

    public Integer getW() {
        return this.w;
    }

    public void setW(Integer num) {
        this.w = num;
    }

    public Integer getPpi() {
        return this.ppi;
    }

    public void setPpi(Integer num) {
        this.ppi = num;
    }

    public Float getPxratio() {
        return this.pxratio;
    }

    public void setPxratio(Float f) {
        this.pxratio = f;
    }

    public Integer getJs() {
        return this.js;
    }

    public void setJs(Integer num) {
        this.js = num;
    }

    public Integer getGeofetch() {
        return this.geofetch;
    }

    public void setGeofetch(Integer num) {
        this.geofetch = num;
    }

    public String getFlashver() {
        return this.flashver;
    }

    public void setFlashver(String str) {
        this.flashver = str;
    }

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String str) {
        this.language = str;
    }

    public String getCarrier() {
        return this.carrier;
    }

    public void setCarrier(String str) {
        this.carrier = str;
    }

    public String getMccmnc() {
        return this.mccmnc;
    }

    public void setMccmnc(String str) {
        this.mccmnc = str;
    }

    public String getMccmncsim() {
        return this.mccmncsim;
    }

    public void setMccmncsim(String str) {
        this.mccmncsim = str;
    }

    public Integer getConnectiontype() {
        return this.connectiontype;
    }

    public void setConnectiontype(Integer num) {
        this.connectiontype = num;
    }

    public String getIfa() {
        return this.ifa;
    }

    public void setIfa(String str) {
        this.ifa = str;
    }

    public String getDidsha1() {
        return this.didsha1;
    }

    public void setDidsha1(String str) {
        this.didsha1 = str;
    }

    public String getDidmd5() {
        return this.didmd5;
    }

    public void setDidmd5(String str) {
        this.didmd5 = str;
    }

    public String getDpidsha1() {
        return this.dpidsha1;
    }

    public void setDpidsha1(String str) {
        this.dpidsha1 = str;
    }

    public String getDpidmd5() {
        return this.dpidmd5;
    }

    public void setDpidmd5(String str) {
        this.dpidmd5 = str;
    }

    public String getMacsha1() {
        return this.macsha1;
    }

    public void setMacsha1(String str) {
        this.macsha1 = str;
    }

    public String getMacmd5() {
        return this.macmd5;
    }

    public void setMacmd5(String str) {
        this.macmd5 = str;
    }

    public DeviceExtension getExt() {
        return this.ext;
    }

    public void setExt(DeviceExtension deviceExtension) {
        this.ext = deviceExtension;
    }

    public UserAgent getSua() {
        return this.sua;
    }

    public void setSua(UserAgent userAgent) {
        this.sua = userAgent;
    }
}
