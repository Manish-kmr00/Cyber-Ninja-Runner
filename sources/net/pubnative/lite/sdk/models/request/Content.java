package net.pubnative.lite.sdk.models.request;

import java.util.List;
import net.pubnative.lite.sdk.utils.json.BindField;
import net.pubnative.lite.sdk.utils.json.JsonModel;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class Content extends JsonModel {

    @BindField
    private String album;

    @BindField
    private String artist;

    @BindField
    private List<String> cat;

    @BindField
    private String contentrating;

    @BindField
    private Integer context;

    @BindField
    private List<Data> data;

    @BindField
    private Integer embeddable;

    @BindField
    private Integer episode;

    @BindField
    private String genre;

    @BindField
    private String id;

    @BindField
    private String isrc;

    @BindField
    private String keywords;

    @BindField
    private String language;

    @BindField
    private Integer len;

    @BindField
    private Integer livestream;

    @BindField
    private Integer prodq;

    @BindField
    private Producer producer;

    @BindField
    private Integer qagmediarating;

    @BindField
    private String season;

    @BindField
    private String series;

    @BindField
    private Integer sourcerelationship;

    @BindField
    private String title;

    @BindField
    private String url;

    @BindField
    private String userrating;

    @BindField
    private Integer videoquality;

    public Content() {
    }

    public Content(JSONObject jSONObject) throws Exception {
        fromJson(jSONObject);
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public Integer getEpisode() {
        return this.episode;
    }

    public void setEpisode(Integer num) {
        this.episode = num;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getSeries() {
        return this.series;
    }

    public void setSeries(String str) {
        this.series = str;
    }

    public String getSeason() {
        return this.season;
    }

    public void setSeason(String str) {
        this.season = str;
    }

    public String getArtist() {
        return this.artist;
    }

    public void setArtist(String str) {
        this.artist = str;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String str) {
        this.genre = str;
    }

    public String getAlbum() {
        return this.album;
    }

    public void setAlbum(String str) {
        this.album = str;
    }

    public String getIsrc() {
        return this.isrc;
    }

    public void setIsrc(String str) {
        this.isrc = str;
    }

    public Producer getProducer() {
        return this.producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public List<String> getCategories() {
        return this.cat;
    }

    public void setCategories(List<String> list) {
        this.cat = list;
    }

    public Integer getProductionQuality() {
        return this.prodq;
    }

    public void setProductionQuality(Integer num) {
        this.prodq = num;
    }

    public Integer getVideoQuality() {
        return this.videoquality;
    }

    public void setVideoQuality(Integer num) {
        this.videoquality = num;
    }

    public Integer getContext() {
        return this.context;
    }

    public void setContext(Integer num) {
        this.context = num;
    }

    public String getContentRating() {
        return this.contentrating;
    }

    public void setContentRating(String str) {
        this.contentrating = str;
    }

    public String getUserRating() {
        return this.userrating;
    }

    public void setUserRating(String str) {
        this.userrating = str;
    }

    public Integer getQagMediaRating() {
        return this.qagmediarating;
    }

    public void setQagMediaRating(Integer num) {
        this.qagmediarating = num;
    }

    public String getKeywords() {
        return this.keywords;
    }

    public void setKeywords(String str) {
        this.keywords = str;
    }

    public Integer getLivestream() {
        return this.livestream;
    }

    public void setLivestream(Integer num) {
        this.livestream = num;
    }

    public Integer getSourceRelationship() {
        return this.sourcerelationship;
    }

    public void setSourceRelationship(Integer num) {
        this.sourcerelationship = num;
    }

    public Integer getLen() {
        return this.len;
    }

    public void setLen(Integer num) {
        this.len = num;
    }

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String str) {
        this.language = str;
    }

    public Integer getEmbeddable() {
        return this.embeddable;
    }

    public void setEmbeddable(Integer num) {
        this.embeddable = num;
    }

    public List<Data> getData() {
        return this.data;
    }

    public void setData(List<Data> list) {
        this.data = list;
    }
}
