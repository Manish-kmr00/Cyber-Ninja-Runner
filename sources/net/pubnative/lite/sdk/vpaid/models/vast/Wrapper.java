package net.pubnative.lite.sdk.vpaid.models.vast;

import java.util.Collections;
import java.util.List;
import net.pubnative.lite.sdk.vpaid.xml.Attribute;
import net.pubnative.lite.sdk.vpaid.xml.Tag;

/* JADX INFO: loaded from: classes13.dex */
public class Wrapper implements VastAdSource {

    @Tag
    private AdSystem adSystem;

    @Tag
    private AdVerifications adVerifications;

    @Attribute
    private String allowMultipleAds;

    @Tag(com.smaato.sdk.video.vast.model.Wrapper.BLOCKED_AD_CATEGORIES)
    private List<BlockedAdCategories> blockedAdCategories;

    @Tag
    private Creatives creatives;

    @Tag("Error")
    private List<Error> errors;

    @Tag
    private Extensions extensions;

    @Attribute
    private String fallbackOnNoAd;

    @Attribute
    private String followAdditionalWrappers;

    @Tag("Impression")
    private List<Impression> impressions;

    @Tag
    private Pricing pricing;

    @Tag
    private VASTAdTagURI vastAdTagURI;

    @Tag
    private ViewableImpression viewableImpression;

    @Override // net.pubnative.lite.sdk.vpaid.models.vast.VastAdSource
    public AdServingId getAdServingId() {
        return null;
    }

    public String isFollowAdditionalWrappers() {
        return this.followAdditionalWrappers;
    }

    public String isAllowMultipleAds() {
        return this.allowMultipleAds;
    }

    public String isFallbackOnNoAd() {
        return this.fallbackOnNoAd;
    }

    @Override // net.pubnative.lite.sdk.vpaid.models.vast.VastAdSource
    public List<Impression> getImpressions() {
        return this.impressions;
    }

    public VASTAdTagURI getVastAdTagURI() {
        return this.vastAdTagURI;
    }

    @Override // net.pubnative.lite.sdk.vpaid.models.vast.VastAdSource
    public AdSystem getAdSystem() {
        return this.adSystem;
    }

    @Override // net.pubnative.lite.sdk.vpaid.models.vast.VastAdSource
    public Pricing getPricing() {
        return this.pricing;
    }

    @Override // net.pubnative.lite.sdk.vpaid.models.vast.VastAdSource
    public List<Error> getErrors() {
        return this.errors;
    }

    @Override // net.pubnative.lite.sdk.vpaid.models.vast.VastAdSource
    public ViewableImpression getViewableImpression() {
        return this.viewableImpression;
    }

    @Override // net.pubnative.lite.sdk.vpaid.models.vast.VastAdSource
    public AdVerifications getAdVerifications() {
        return this.adVerifications;
    }

    @Override // net.pubnative.lite.sdk.vpaid.models.vast.VastAdSource
    public Extensions getExtensions() {
        return this.extensions;
    }

    @Override // net.pubnative.lite.sdk.vpaid.models.vast.VastAdSource
    public Creatives getCreatives() {
        return this.creatives;
    }

    public List<BlockedAdCategories> getBlockedAdCategories() {
        return this.blockedAdCategories;
    }

    @Override // net.pubnative.lite.sdk.vpaid.models.vast.VastAdSource
    public List<Category> getCategories() {
        return Collections.emptyList();
    }
}
