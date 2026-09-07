package com.smaato.sdk.video.vast.model;

/* JADX INFO: loaded from: classes12.dex */
public class Creative {
    public static final String AD_ID = "adId";
    public static final String API_FRAMEWORK = "apiFramework";
    public static final String COMPANION_ADS = "CompanionAds";
    public static final String CREATIVE_EXTENSIONS = "CreativeExtensions";
    public static final String ID = "id";
    public static final String LINEAR = "Linear";
    public static final String NAME = "Creative";
    public static final String SEQUENCE = "sequence";
    public static final String UNIVERSAL_AD_ID = "UniversalAdId";
    public final String adId;
    public final String apiFramework;
    public final CompanionAds companionAds;
    public final String id;
    public final Linear linear;
    public final Integer sequence;
    public final UniversalAdId universalAdId;

    Creative(UniversalAdId universalAdId, String str, String str2, Integer num, String str3, Linear linear, CompanionAds companionAds) {
        this.id = str;
        this.adId = str2;
        this.sequence = num;
        this.apiFramework = str3;
        this.universalAdId = universalAdId;
        this.linear = linear;
        this.companionAds = companionAds;
    }

    public boolean hasCompanions() {
        CompanionAds companionAds = this.companionAds;
        return (companionAds == null || companionAds.companions.isEmpty()) ? false : true;
    }

    public static class Builder {
        private String adId;
        private String apiFramework;
        private CompanionAds companionAds;
        private String id;
        private Linear linear;
        private Integer sequence;
        private UniversalAdId universalAdId;

        public Builder setId(String str) {
            this.id = str;
            return this;
        }

        public Builder setAdId(String str) {
            this.adId = str;
            return this;
        }

        public Builder setSequence(Integer num) {
            this.sequence = num;
            return this;
        }

        public Builder setApiFramework(String str) {
            this.apiFramework = str;
            return this;
        }

        public Builder setLinear(Linear linear) {
            this.linear = linear;
            return this;
        }

        public Builder setCompanionAds(CompanionAds companionAds) {
            this.companionAds = companionAds;
            return this;
        }

        public Builder setUniversalAdId(UniversalAdId universalAdId) {
            this.universalAdId = universalAdId;
            return this;
        }

        public Creative build() {
            if (this.universalAdId == null) {
                this.universalAdId = UniversalAdId.DEFAULT;
            }
            return new Creative(this.universalAdId, this.id, this.adId, this.sequence, this.apiFramework, this.linear, this.companionAds);
        }
    }
}
