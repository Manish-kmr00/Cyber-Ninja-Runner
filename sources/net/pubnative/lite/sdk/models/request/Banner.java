package net.pubnative.lite.sdk.models.request;

import java.util.List;
import net.pubnative.lite.sdk.utils.json.BindField;
import net.pubnative.lite.sdk.utils.json.JsonModel;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public class Banner extends JsonModel {

    @BindField
    private List<Integer> api;

    @BindField
    private List<Integer> battr;

    @BindField
    private List<Integer> btype;

    @BindField
    private List<Integer> expdir;

    @BindField
    private List<Format> format;

    @BindField
    private Integer h;

    @BindField
    private Integer hmax;

    @BindField
    private Integer hmin;

    @BindField
    private String id;

    @BindField
    private List<String> mimes;

    @BindField
    private Integer pos;

    @BindField
    private Integer topframe;

    @BindField
    private Integer vcm;

    @BindField
    private Integer w;

    @BindField
    private Integer wmax;

    @BindField
    private Integer wmin;

    public Banner() {
    }

    public Banner(JSONObject jSONObject) throws Exception {
        fromJson(jSONObject);
    }

    public List<Format> getFormat() {
        return this.format;
    }

    public void setFormat(List<Format> list) {
        this.format = list;
    }

    public Integer getW() {
        return this.w;
    }

    public void setW(Integer num) {
        this.w = num;
    }

    public Integer getH() {
        return this.h;
    }

    public void setH(Integer num) {
        this.h = num;
    }

    public Integer getWmax() {
        return this.wmax;
    }

    public void setWmax(Integer num) {
        this.wmax = num;
    }

    public Integer getHmax() {
        return this.hmax;
    }

    public void setHmax(Integer num) {
        this.hmax = num;
    }

    public Integer getWmin() {
        return this.wmin;
    }

    public void setWmin(Integer num) {
        this.wmin = num;
    }

    public Integer getHmin() {
        return this.hmin;
    }

    public void setHmin(Integer num) {
        this.hmin = num;
    }

    public List<Integer> getBtype() {
        return this.btype;
    }

    public void setBtype(List<Integer> list) {
        this.btype = list;
    }

    public List<Integer> getBattr() {
        return this.battr;
    }

    public void setBattr(List<Integer> list) {
        this.battr = list;
    }

    public Integer getPos() {
        return this.pos;
    }

    public void setPos(Integer num) {
        this.pos = num;
    }

    public List<String> getMimes() {
        return this.mimes;
    }

    public void setMimes(List<String> list) {
        this.mimes = list;
    }

    public Integer getTopframe() {
        return this.topframe;
    }

    public void setTopframe(Integer num) {
        this.topframe = num;
    }

    public List<Integer> getExpdir() {
        return this.expdir;
    }

    public void setExpdir(List<Integer> list) {
        this.expdir = list;
    }

    public List<Integer> getApi() {
        return this.api;
    }

    public void setApi(List<Integer> list) {
        this.api = list;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public Integer getVcm() {
        return this.vcm;
    }

    public void setVcm(Integer num) {
        this.vcm = num;
    }
}
