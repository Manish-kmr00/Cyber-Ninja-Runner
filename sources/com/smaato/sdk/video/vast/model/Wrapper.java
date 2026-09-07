package com.smaato.sdk.video.vast.model;

import com.smaato.sdk.video.vast.utils.VastModels;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class Wrapper {
    public static final String AD_SYSTEM = "AdSystem";
    public static final String AD_VERIFICATIONS = "AdVerifications";
    public static final String ALLOW_MULTIPLE_ADS = "allowMultipleAds";
    public static final String BLOCKED_AD_CATEGORIES = "BlockedAdCategories";
    public static final String CREATIVES = "Creatives";
    public static final String ERROR = "Error";
    public static final String EXTENSIONS = "Extensions";
    public static final String FALLBACK_ON_NO_AD = "fallbackOnNoAd";
    public static final String FOLLOW_ADDITIONAL_WRAPPERS = "followAdditionalWrappers";
    public static final String IMPRESSION = "Impression";
    public static final String NAME = "Wrapper";
    public static final String VAST_AD_TAG_URI = "VastAdTagURI";
    public static final String VIEWABLE_IMPRESSION = "ViewableImpression";
    public final AdSystem adSystem;
    public final List<Verification> adVerifications;
    public final Boolean allowMultipleAds;
    public final String blockedAdCategories;
    public final List<Creative> creatives;
    public final List<String> errors;
    public final List<Extension> extensions;
    public final Boolean fallbackOnNoAd;
    public final boolean followAdditionalWrappers;
    public final List<VastBeacon> impressions;
    public final String vastAdTagUri;
    public final VastTree vastTree;
    public final ViewableImpression viewableImpression;

    Wrapper(boolean z, List<VastBeacon> list, List<Verification> list2, List<Creative> list3, List<String> list4, AdSystem adSystem, ViewableImpression viewableImpression, Boolean bool, Boolean bool2, String str, String str2, VastTree vastTree, List<Extension> list5) {
        this.followAdditionalWrappers = z;
        this.adSystem = adSystem;
        this.impressions = list;
        this.errors = list4;
        this.viewableImpression = viewableImpression;
        this.allowMultipleAds = bool;
        this.fallbackOnNoAd = bool2;
        this.vastAdTagUri = str;
        this.adVerifications = list2;
        this.creatives = list3;
        this.blockedAdCategories = str2;
        this.vastTree = vastTree;
        this.extensions = list5;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    public static class Builder {
        private AdSystem adSystem;
        private List adVerifications;
        private Boolean allowMultipleAds;
        private String blockedAdCategories;
        private List creatives;
        private List errors;
        private List extensions;
        private Boolean fallbackOnNoAd;
        private Boolean followAdditionalWrappers;
        private List impressions;
        private String vastAdTagUri;
        private VastTree vastTree;
        private ViewableImpression viewableImpression;

        public Builder() {
        }

        public Builder(Wrapper wrapper) {
            this.followAdditionalWrappers = Boolean.valueOf(wrapper.followAdditionalWrappers);
            this.adSystem = wrapper.adSystem;
            this.impressions = wrapper.impressions;
            this.errors = wrapper.errors;
            this.viewableImpression = wrapper.viewableImpression;
            this.allowMultipleAds = wrapper.allowMultipleAds;
            this.fallbackOnNoAd = wrapper.fallbackOnNoAd;
            this.vastAdTagUri = wrapper.vastAdTagUri;
            this.adVerifications = wrapper.adVerifications;
            this.blockedAdCategories = wrapper.blockedAdCategories;
            this.creatives = wrapper.creatives;
            this.vastTree = wrapper.vastTree;
            this.extensions = wrapper.extensions;
        }

        public Builder setAdSystem(AdSystem adSystem) {
            this.adSystem = adSystem;
            return this;
        }

        public Builder setImpressions(List<VastBeacon> list) {
            this.impressions = list;
            return this;
        }

        public Builder setErrors(List<String> list) {
            this.errors = list;
            return this;
        }

        public Builder setViewableImpression(ViewableImpression viewableImpression) {
            this.viewableImpression = viewableImpression;
            return this;
        }

        public Builder setFollowAdditionalWrappers(Boolean bool) {
            this.followAdditionalWrappers = bool;
            return this;
        }

        public Builder setAllowMultipleAds(Boolean bool) {
            this.allowMultipleAds = bool;
            return this;
        }

        public Builder setFallbackOnNoAd(Boolean bool) {
            this.fallbackOnNoAd = bool;
            return this;
        }

        public Builder setVastAdTagUri(String str) {
            this.vastAdTagUri = str;
            return this;
        }

        public Builder setAdVerifications(List<Verification> list) {
            this.adVerifications = list;
            return this;
        }

        public Builder setCreatives(List<Creative> list) {
            this.creatives = list;
            return this;
        }

        public Builder setBlockedAdCategories(String str) {
            this.blockedAdCategories = str;
            return this;
        }

        public Builder setVastTree(VastTree vastTree) {
            this.vastTree = vastTree;
            return this;
        }

        public Builder setExtensions(List<Extension> list) {
            this.extensions = list;
            return this;
        }

        public Wrapper build() {
            Boolean bool = this.followAdditionalWrappers;
            this.followAdditionalWrappers = Boolean.valueOf(bool == null || bool.booleanValue());
            this.impressions = VastModels.toImmutableList(this.impressions);
            this.adVerifications = VastModels.toImmutableList(this.adVerifications);
            this.creatives = VastModels.toImmutableList(this.creatives);
            this.errors = VastModels.toImmutableList(this.errors);
            this.extensions = VastModels.toImmutableList(this.extensions);
            return new Wrapper(this.followAdditionalWrappers.booleanValue(), this.impressions, this.adVerifications, this.creatives, this.errors, this.adSystem, this.viewableImpression, this.allowMultipleAds, this.fallbackOnNoAd, this.vastAdTagUri, this.blockedAdCategories, this.vastTree, this.extensions);
        }
    }
}
