package net.pubnative.lite.sdk.models.response;

import java.util.List;
import net.pubnative.lite.sdk.utils.json.BindField;
import net.pubnative.lite.sdk.utils.json.JsonModel;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public class Bid extends JsonModel {

    @BindField
    private String adid;

    @BindField
    private String adm;

    @BindField
    private List<String> adomain;

    @BindField
    private Integer api;

    @BindField
    private List<Integer> attr;

    @BindField
    private String bundle;

    @BindField
    private String burl;

    @BindField
    private List<String> cat;

    @BindField
    private String cid;

    @BindField
    private String crid;

    @BindField
    private String dealid;

    @BindField
    private Integer exp;

    @BindField
    private BidExtension ext;

    @BindField
    private Integer h;

    @BindField
    private Integer hratio;

    @BindField
    private String id;

    @BindField
    private String impid;

    @BindField
    private String iurl;

    @BindField
    private String language;

    @BindField
    private String lurl;

    @BindField
    private String nurl;

    @BindField
    private Float price;

    @BindField
    private Integer protocol;

    @BindField
    private Integer qagmediarating;

    @BindField
    private String tactic;

    @BindField
    private Integer w;

    @BindField
    private Integer wratio;

    public Bid() {
    }

    public Bid(JSONObject jSONObject) throws Exception {
        fromJson(jSONObject);
    }

    public String getId() {
        return this.id;
    }

    public String getImpressionid() {
        return this.impid;
    }

    public Float getPrice() {
        return this.price;
    }

    public String getNoticeUrl() {
        return this.nurl;
    }

    public String getBillingUrl() {
        return this.burl;
    }

    public String getLossNoticeUrl() {
        return this.lurl;
    }

    public String getAdMarkup() {
        return this.adm;
    }

    public String getAdId() {
        return this.adid;
    }

    public List<String> getAdvertiserDomains() {
        return this.adomain;
    }

    public String getBundle() {
        return this.bundle;
    }

    public String getIurl() {
        return this.iurl;
    }

    public String getCampaignId() {
        return this.cid;
    }

    public String getCreativeId() {
        return this.crid;
    }

    public String getTactic() {
        return this.tactic;
    }

    public List<String> getCategories() {
        return this.cat;
    }

    public List<Integer> getAttributes() {
        return this.attr;
    }

    public Integer getApi() {
        return this.api;
    }

    public Integer getProtocol() {
        return this.protocol;
    }

    public Integer getQagMediaRating() {
        return this.qagmediarating;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getDealId() {
        return this.dealid;
    }

    public Integer getWidth() {
        return this.w;
    }

    public Integer getHeight() {
        return this.h;
    }

    public Integer getWidthRatio() {
        return this.wratio;
    }

    public Integer getHeightRatio() {
        return this.hratio;
    }

    public Integer getExpiration() {
        return this.exp;
    }

    public BidExtension getExt() {
        return this.ext;
    }
}
