package net.pubnative.lite.sdk.models.request;

import java.util.List;
import net.pubnative.lite.sdk.utils.json.BindField;
import net.pubnative.lite.sdk.utils.json.JsonModel;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class App extends JsonModel {

    @BindField
    private String bundle;

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
    private String name;

    @BindField
    private List<String> pagecat;

    @BindField
    private Integer paid;

    @BindField
    private Integer privacypolicy;

    @BindField
    private Publisher publisher;

    @BindField
    private List<String> sectioncat;

    @BindField
    private String storeurl;

    @BindField
    private String ver;

    public App() {
    }

    public App(JSONObject jSONObject) throws Exception {
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

    public String getBundle() {
        return this.bundle;
    }

    public void setBundle(String str) {
        this.bundle = str;
    }

    public String getDomain() {
        return this.domain;
    }

    public void setDomain(String str) {
        this.domain = str;
    }

    public String getStoreUrl() {
        return this.storeurl;
    }

    public void setStoreUrl(String str) {
        this.storeurl = str;
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

    public String getVersion() {
        return this.ver;
    }

    public void setVersion(String str) {
        this.ver = str;
    }

    public Integer getPrivacyPolicy() {
        return this.privacypolicy;
    }

    public void setPrivacyPolicy(Integer num) {
        this.privacypolicy = num;
    }

    public Integer getPaid() {
        return this.paid;
    }

    public void setPaid(Integer num) {
        this.paid = num;
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
