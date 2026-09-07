package com.smaato.sdk.video.vast.model;

/* JADX INFO: loaded from: classes3.dex */
public class Ad {
    public static final String AD_TYPE = "adType";
    public static final String CONDITIONAL_AD = "conditionalAd";
    public static final String ID = "id";
    public static final String INLINE = "InLine";
    public static final String NAME = "Ad";
    public static final String SEQUENCE = "sequence";
    public static final String WRAPPER = "Wrapper";
    public final VideoAdType adType;
    public final Boolean conditionalAd;
    public final String id;
    public final InLine inLine;
    public final Integer sequence;
    public final Wrapper wrapper;

    Ad(String str, InLine inLine, Wrapper wrapper, Integer num, Boolean bool, VideoAdType videoAdType) {
        this.inLine = inLine;
        this.wrapper = wrapper;
        this.id = str;
        this.sequence = num;
        this.conditionalAd = bool;
        this.adType = videoAdType;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    public static class Builder {
        private VideoAdType adType;
        private Boolean conditionalAd;
        private String id;
        private InLine inLine;
        private Integer sequence;
        private Wrapper wrapper;

        public Builder() {
            this.adType = VideoAdType.VIDEO;
        }

        public Builder(Ad ad) {
            this.adType = VideoAdType.VIDEO;
            this.inLine = ad.inLine;
            this.wrapper = ad.wrapper;
            this.id = ad.id;
            this.sequence = ad.sequence;
            this.conditionalAd = ad.conditionalAd;
            this.adType = ad.adType;
        }

        public Builder setId(String str) {
            this.id = str;
            return this;
        }

        public Builder setInLine(InLine inLine) {
            this.inLine = inLine;
            return this;
        }

        public Builder setWrapper(Wrapper wrapper) {
            this.wrapper = wrapper;
            return this;
        }

        public Builder setSequence(Integer num) {
            this.sequence = num;
            return this;
        }

        public Builder setConditionalAd(Boolean bool) {
            this.conditionalAd = bool;
            return this;
        }

        public Builder setAdType(String str) {
            VideoAdType videoAdType = VideoAdType.parse(str);
            if (videoAdType == null) {
                videoAdType = this.adType;
            }
            this.adType = videoAdType;
            return this;
        }

        public Ad build() {
            return new Ad(this.id, this.inLine, this.wrapper, this.sequence, this.conditionalAd, this.adType);
        }
    }
}
