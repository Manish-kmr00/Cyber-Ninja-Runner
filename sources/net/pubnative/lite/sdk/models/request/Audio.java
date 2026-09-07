package net.pubnative.lite.sdk.models.request;

import java.util.List;
import net.pubnative.lite.sdk.utils.json.BindField;
import net.pubnative.lite.sdk.utils.json.JsonModel;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public class Audio extends JsonModel {

    @BindField
    private List<Integer> api;

    @BindField
    private List<Integer> battr;

    @BindField
    private List<Banner> companionad;

    @BindField
    private List<Integer> companiontype;

    @BindField
    private List<Integer> delivery;

    @BindField
    private Integer feed;

    @BindField
    private Integer maxbitrate;

    @BindField
    private Integer maxduration;

    @BindField
    private Integer maxextended;

    @BindField
    private Integer maxseq;

    @BindField
    private List<String> mimes;

    @BindField
    private Integer minbitrate;

    @BindField
    private Integer minduration;

    @BindField
    private Integer nvol;

    @BindField
    private Integer protocol;

    @BindField
    private List<Integer> protocols;

    @BindField
    private Integer startdelay;

    @BindField
    private Integer stitched;

    public Audio() {
    }

    public Audio(JSONObject jSONObject) throws Exception {
        fromJson(jSONObject);
    }

    public List<String> getMimes() {
        return this.mimes;
    }

    public void setMimes(List<String> list) {
        this.mimes = list;
    }

    public Integer getMinDuration() {
        return this.minduration;
    }

    public void setMinDuration(Integer num) {
        this.minduration = num;
    }

    public Integer getMaxDuration() {
        return this.maxduration;
    }

    public void setMaxDuration(Integer num) {
        this.maxduration = num;
    }

    public List<Integer> getProtocols() {
        return this.protocols;
    }

    public void setProtocols(List<Integer> list) {
        this.protocols = list;
    }

    public Integer getProtocol() {
        return this.protocol;
    }

    public void setProtocol(Integer num) {
        this.protocol = num;
    }

    public Integer getStartDelay() {
        return this.startdelay;
    }

    public void setStartDelay(Integer num) {
        this.startdelay = num;
    }

    public List<Integer> getBlockedAttr() {
        return this.battr;
    }

    public void setBlockedAttr(List<Integer> list) {
        this.battr = list;
    }

    public Integer getMaxExtended() {
        return this.maxextended;
    }

    public void setMaxExtended(Integer num) {
        this.maxextended = num;
    }

    public Integer getMinBitRate() {
        return this.minbitrate;
    }

    public void setMinBitRate(Integer num) {
        this.minbitrate = num;
    }

    public Integer getMaxBitRate() {
        return this.maxbitrate;
    }

    public void setMaxBitRate(Integer num) {
        this.maxbitrate = num;
    }

    public List<Integer> getDelivery() {
        return this.delivery;
    }

    public void setDelivery(List<Integer> list) {
        this.delivery = list;
    }

    public List<Banner> getCompanionAds() {
        return this.companionad;
    }

    public void setCompanionAds(List<Banner> list) {
        this.companionad = list;
    }

    public List<Integer> getApi() {
        return this.api;
    }

    public void setApi(List<Integer> list) {
        this.api = list;
    }

    public List<Integer> getCompanionTypes() {
        return this.companiontype;
    }

    public void setCompanionTypes(List<Integer> list) {
        this.companiontype = list;
    }

    public Integer getMaxSeq() {
        return this.maxseq;
    }

    public void setMaxSeq(Integer num) {
        this.maxseq = num;
    }

    public Integer getFeed() {
        return this.feed;
    }

    public void setFeed(Integer num) {
        this.feed = num;
    }

    public Integer getStitched() {
        return this.stitched;
    }

    public void setStitched(Integer num) {
        this.stitched = num;
    }

    public Integer getVolumeNormalizationMode() {
        return this.nvol;
    }

    public void setVolumeNormalizationMode(Integer num) {
        this.nvol = num;
    }
}
