package com.smaato.sdk.video.vast.model;

/* JADX INFO: loaded from: classes10.dex */
public final class VastScenarioCreativeData {
    public final String adId;
    public final String apiFramework;
    public final String id;
    public final Integer sequence;
    public final UniversalAdId universalAdId;

    private VastScenarioCreativeData(UniversalAdId universalAdId, String str, String str2, Integer num, String str3) {
        this.universalAdId = universalAdId;
        this.id = str;
        this.adId = str2;
        this.sequence = num;
        this.apiFramework = str3;
    }

    public static class Builder {
        private String adId;
        private String apiFramework;
        private String id;
        private Integer sequence;
        private UniversalAdId universalAdId;

        public Builder setUniversalAdId(UniversalAdId universalAdId) {
            this.universalAdId = universalAdId;
            return this;
        }

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

        public VastScenarioCreativeData build() {
            if (this.universalAdId == null) {
                this.universalAdId = UniversalAdId.DEFAULT;
            }
            return new VastScenarioCreativeData(this.universalAdId, this.id, this.adId, this.sequence, this.apiFramework);
        }
    }
}
