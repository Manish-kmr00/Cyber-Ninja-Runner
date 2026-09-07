package net.pubnative.lite.sdk.models.request;

import java.util.List;
import net.pubnative.lite.sdk.utils.json.BindField;
import net.pubnative.lite.sdk.utils.json.JsonModel;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public class Imp extends JsonModel {

    @BindField
    private Native aNative;

    @BindField
    private Audio audio;

    @BindField
    private Banner banner;

    @BindField
    private Integer clickbrowser;

    @BindField
    private String displaymanager;

    @BindField
    private String displaymanagerver;

    @BindField
    private Integer exp;

    @BindField
    private String id;

    @BindField
    private List<String> iframebuster;

    @BindField
    private List<Metric> metric;

    @BindField
    private Pmp pmp;

    @BindField
    private Integer secure;

    @BindField
    private String tagid;

    @BindField
    private Video video;

    @BindField
    private Integer instl = 0;

    @BindField
    private Float bidfloor = Float.valueOf(0.0f);

    @BindField
    private String bidfloorcur = "USD";

    public Imp() {
    }

    public Imp(JSONObject jSONObject) throws Exception {
        fromJson(jSONObject);
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public List<Metric> getMetric() {
        return this.metric;
    }

    public void setMetric(List<Metric> list) {
        this.metric = list;
    }

    public Banner getBanner() {
        return this.banner;
    }

    public void setBanner(Banner banner) {
        this.banner = banner;
    }

    public Video getVideo() {
        return this.video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public Audio getAudio() {
        return this.audio;
    }

    public void setAudio(Audio audio) {
        this.audio = audio;
    }

    public Native getNative() {
        return this.aNative;
    }

    public void setNative(Native r1) {
        this.aNative = r1;
    }

    public Pmp getPmp() {
        return this.pmp;
    }

    public void setPmp(Pmp pmp) {
        this.pmp = pmp;
    }

    public String getDisplaymanager() {
        return this.displaymanager;
    }

    public void setDisplaymanager(String str) {
        this.displaymanager = str;
    }

    public String getDisplaymanagerver() {
        return this.displaymanagerver;
    }

    public void setDisplaymanagerver(String str) {
        this.displaymanagerver = str;
    }

    public Integer getInstl() {
        return this.instl;
    }

    public void setInstl(Integer num) {
        this.instl = num;
    }

    public String getTagid() {
        return this.tagid;
    }

    public void setTagid(String str) {
        this.tagid = str;
    }

    public Float getBidfloor() {
        return this.bidfloor;
    }

    public void setBidfloor(Float f) {
        this.bidfloor = f;
    }

    public String getBidfloorcur() {
        return this.bidfloorcur;
    }

    public void setBidfloorcur(String str) {
        this.bidfloorcur = str;
    }

    public Integer getClickbrowser() {
        return this.clickbrowser;
    }

    public void setClickbrowser(Integer num) {
        this.clickbrowser = num;
    }

    public Integer getSecure() {
        return this.secure;
    }

    public void setSecure(Integer num) {
        this.secure = num;
    }

    public List<String> getIframebuster() {
        return this.iframebuster;
    }

    public void setIframebuster(List<String> list) {
        this.iframebuster = list;
    }

    public Integer getExp() {
        return this.exp;
    }

    public void setExp(Integer num) {
        this.exp = num;
    }
}
