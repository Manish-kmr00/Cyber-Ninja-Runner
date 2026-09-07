package net.pubnative.lite.sdk.models.request;

import java.util.List;
import net.pubnative.lite.sdk.utils.json.BindField;
import net.pubnative.lite.sdk.utils.json.JsonModel;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class Video extends JsonModel {

    @BindField
    private List<Integer> api;

    @BindField
    private List<Integer> battr;

    @BindField
    private Integer clktype;

    @BindField
    private List<Banner> companionad;

    @BindField
    private List<Integer> companiontype;

    @BindField
    private List<Integer> delivery;

    @BindField
    private Integer h;

    @BindField
    private Integer linearity;

    @BindField
    private Integer maxbitrate;

    @BindField
    private Integer maxduration;

    @BindField
    private Integer maxextended;

    @BindField
    private List<String> mimes;

    @BindField
    private Integer minbitrate;

    @BindField
    private Integer minduration;

    @BindField
    private Boolean mraidendcard;

    @BindField
    private Integer placement;

    @BindField
    private Integer playbackend;

    @BindField
    private List<Integer> playbackmethod;

    @BindField
    private Integer plcmt;

    @BindField
    private Integer pos;

    @BindField
    private Integer protocol;

    @BindField
    private List<Integer> protocols;

    @BindField
    private Integer sequence;

    @BindField
    private Integer skip;

    @BindField
    private Integer startdelay;

    @BindField
    private Integer w;

    @BindField
    private Integer skipmin = 0;

    @BindField
    private Integer skipafter = 0;

    @BindField
    private Integer boxingallowed = 1;

    public Video() {
    }

    public Video(JSONObject jSONObject) throws Exception {
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

    public Integer getWidth() {
        return this.w;
    }

    public void setWidth(Integer num) {
        this.w = num;
    }

    public Integer getHeight() {
        return this.h;
    }

    public void setHeight(Integer num) {
        this.h = num;
    }

    public Integer getStartDelay() {
        return this.startdelay;
    }

    public void setStartDelay(Integer num) {
        this.startdelay = num;
    }

    public Integer getPlacement() {
        return this.placement;
    }

    public void setPlacement(Integer num) {
        this.placement = num;
    }

    public Integer getLinearity() {
        return this.linearity;
    }

    public void setLinearity(Integer num) {
        this.linearity = num;
    }

    public Integer getSkip() {
        return this.skip;
    }

    public void setSkip(Integer num) {
        this.skip = num;
    }

    public Integer getSkipMin() {
        return this.skipmin;
    }

    public void setSkipMin(Integer num) {
        this.skipmin = num;
    }

    public Integer getSkipAfter() {
        return this.skipafter;
    }

    public void setSkipAfter(Integer num) {
        this.skipafter = num;
    }

    public Integer getSequence() {
        return this.sequence;
    }

    public void setSequence(Integer num) {
        this.sequence = num;
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

    public Integer getBoxingAllowed() {
        return this.boxingallowed;
    }

    public void setBoxingAllowed(Integer num) {
        this.boxingallowed = num;
    }

    public List<Integer> getPlaybackMethod() {
        return this.playbackmethod;
    }

    public void setPlaybackMethod(List<Integer> list) {
        this.playbackmethod = list;
    }

    public Integer getPlaybackEnd() {
        return this.playbackend;
    }

    public void setPlaybackEnd(Integer num) {
        this.playbackend = num;
    }

    public List<Integer> getDelivery() {
        return this.delivery;
    }

    public void setDelivery(List<Integer> list) {
        this.delivery = list;
    }

    public Integer getPos() {
        return this.pos;
    }

    public void setPos(Integer num) {
        this.pos = num;
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

    public List<Integer> getCompanionType() {
        return this.companiontype;
    }

    public void setCompanionTypes(List<Integer> list) {
        this.companiontype = list;
    }

    public Integer getPlacementSubtype() {
        return this.plcmt;
    }

    public void setPlacementSubtype(Integer num) {
        this.plcmt = num;
    }

    public Boolean getMraidEndcard() {
        return this.mraidendcard;
    }

    public void setMraidEndcard(Boolean bool) {
        this.mraidendcard = bool;
    }

    public Integer getClickType() {
        return this.clktype;
    }

    public void setClickType(Integer num) {
        this.clktype = num;
    }
}
