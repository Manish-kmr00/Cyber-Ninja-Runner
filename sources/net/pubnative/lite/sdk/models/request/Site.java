package net.pubnative.lite.sdk.models.request;

import java.util.List;
import net.pubnative.lite.sdk.utils.json.BindField;
import net.pubnative.lite.sdk.utils.json.JsonModel;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class Site extends JsonModel {

    @BindField
    private List<String> cat;

    @BindField
    private Content content;

    @BindField
    private String domain;

    @BindField
    private String id;

    @BindField
    private String keywords;

    @BindField
    private Integer mobile;

    @BindField
    private String name;

    @BindField
    private String page;

    @BindField
    private List<String> pagecat;

    @BindField
    private Integer privacypolicy;

    @BindField
    private Publisher publisher;

    @BindField
    private String ref;

    @BindField
    private String search;

    @BindField
    private List<String> sectioncat;

    public Site() {
    }

    public Site(JSONObject jSONObject) throws Exception {
        fromJson(jSONObject);
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getDomain() {
        return this.domain;
    }

    public void setDomain(String str) {
        this.domain = str;
    }

    public List<String> getCategories() {
        return this.cat;
    }

    public void setCategories(List<String> list) {
        this.cat = list;
    }

    public List<String> getSectionCategories() {
        return this.sectioncat;
    }

    public void setSectionCategories(List<String> list) {
        this.sectioncat = list;
    }

    public List<String> getPageCategories() {
        return this.pagecat;
    }

    public void setPageCategories(List<String> list) {
        this.pagecat = list;
    }

    public String getPage() {
        return this.page;
    }

    public void setPage(String str) {
        this.page = str;
    }

    public String getRef() {
        return this.ref;
    }

    public void setRef(String str) {
        this.ref = str;
    }

    public String getSearch() {
        return this.search;
    }

    public void setSearch(String str) {
        this.search = str;
    }

    public Integer getMobile() {
        return this.mobile;
    }

    public void setMobile(Integer num) {
        this.mobile = num;
    }

    public Integer getPrivacyPolicy() {
        return this.privacypolicy;
    }

    public void setPrivacyPolicy(Integer num) {
        this.privacypolicy = num;
    }

    public Publisher getPublisher() {
        return this.publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Content getContent() {
        return this.content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public String getKeywords() {
        return this.keywords;
    }

    public void setKeywords(String str) {
        this.keywords = str;
    }
}
