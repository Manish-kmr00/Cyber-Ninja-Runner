package net.pubnative.lite.sdk.models.request;

import java.util.List;
import net.pubnative.lite.sdk.models.AdRequest;
import net.pubnative.lite.sdk.utils.json.BindField;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class OpenRTBAdRequest extends AdRequest {

    @BindField
    private App app;

    @BindField
    private List<String> badv;

    @BindField
    private List<String> bapp;

    @BindField
    private List<String> bcat;

    @BindField
    private List<String> bseat;

    @BindField
    private List<String> cur;

    @BindField
    private Device device;

    @BindField
    private String id;

    @BindField
    private List<Imp> imp;

    @BindField
    private Regs regs;

    @BindField
    private Site site;

    @BindField
    private Source source;

    @BindField
    private Integer tmax;

    @BindField
    private User user;

    @BindField
    private List<String> wlang;

    @BindField
    private List<String> wseat;

    @BindField
    private Integer test = 0;

    @BindField
    private Integer at = 2;

    @BindField
    private Integer allimps = 0;

    public OpenRTBAdRequest(String str, String str2) {
        this.appToken = str;
        this.zoneId = str2;
    }

    public OpenRTBAdRequest(JSONObject jSONObject) throws Exception {
        fromJson(jSONObject);
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public List<Imp> getImp() {
        return this.imp;
    }

    public void setImp(List<Imp> list) {
        this.imp = list;
    }

    public Site getSite() {
        return this.site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public App getApp() {
        return this.app;
    }

    public void setApp(App app) {
        this.app = app;
    }

    public Device getDevice() {
        return this.device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getTest() {
        return this.test;
    }

    public void setTest(Integer num) {
        this.test = num;
    }

    public Integer getAt() {
        return this.at;
    }

    public void setAt(Integer num) {
        this.at = num;
    }

    public Integer getTmax() {
        return this.tmax;
    }

    public void setTmax(Integer num) {
        this.tmax = num;
    }

    public List<String> getWseat() {
        return this.wseat;
    }

    public void setWseat(List<String> list) {
        this.wseat = list;
    }

    public List<String> getBseat() {
        return this.bseat;
    }

    public void setBseat(List<String> list) {
        this.bseat = list;
    }

    public Integer getAllimps() {
        return this.allimps;
    }

    public void setAllimps(Integer num) {
        this.allimps = num;
    }

    public List<String> getCur() {
        return this.cur;
    }

    public void setCur(List<String> list) {
        this.cur = list;
    }

    public List<String> getWlang() {
        return this.wlang;
    }

    public void setWlang(List<String> list) {
        this.wlang = list;
    }

    public List<String> getBcat() {
        return this.bcat;
    }

    public void setBcat(List<String> list) {
        this.bcat = list;
    }

    public List<String> getBadv() {
        return this.badv;
    }

    public void setBadv(List<String> list) {
        this.badv = list;
    }

    public List<String> getBapp() {
        return this.bapp;
    }

    public void setBapp(List<String> list) {
        this.bapp = list;
    }

    public Source getSource() {
        return this.source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public Regs getRegs() {
        return this.regs;
    }

    public void setRegs(Regs regs) {
        this.regs = regs;
    }
}
