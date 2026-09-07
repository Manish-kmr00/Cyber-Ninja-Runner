package com.smaato.sdk.video.vast.model;

/* JADX INFO: loaded from: classes8.dex */
final class AutoValue_VideoAdViewProperties extends VideoAdViewProperties {
    private final int closeButtonSize;
    private final boolean hasCompanionAd;
    private final boolean isClickable;
    private final boolean isSkippable;
    private final boolean isSoundOn;
    private final long skipInterval;

    private AutoValue_VideoAdViewProperties(long j, int i, boolean z, boolean z2, boolean z3, boolean z4) {
        this.skipInterval = j;
        this.closeButtonSize = i;
        this.isSkippable = z;
        this.isClickable = z2;
        this.isSoundOn = z3;
        this.hasCompanionAd = z4;
    }

    @Override // com.smaato.sdk.video.vast.model.VideoAdViewProperties
    public long skipInterval() {
        return this.skipInterval;
    }

    @Override // com.smaato.sdk.video.vast.model.VideoAdViewProperties
    public int closeButtonSize() {
        return this.closeButtonSize;
    }

    @Override // com.smaato.sdk.video.vast.model.VideoAdViewProperties
    public boolean isSkippable() {
        return this.isSkippable;
    }

    @Override // com.smaato.sdk.video.vast.model.VideoAdViewProperties
    public boolean isClickable() {
        return this.isClickable;
    }

    @Override // com.smaato.sdk.video.vast.model.VideoAdViewProperties
    public boolean isSoundOn() {
        return this.isSoundOn;
    }

    @Override // com.smaato.sdk.video.vast.model.VideoAdViewProperties
    public boolean hasCompanionAd() {
        return this.hasCompanionAd;
    }

    public String toString() {
        return "VideoAdViewProperties{skipInterval=" + this.skipInterval + ", closeButtonSize=" + this.closeButtonSize + ", isSkippable=" + this.isSkippable + ", isClickable=" + this.isClickable + ", isSoundOn=" + this.isSoundOn + ", hasCompanionAd=" + this.hasCompanionAd + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof VideoAdViewProperties)) {
            return false;
        }
        VideoAdViewProperties videoAdViewProperties = (VideoAdViewProperties) obj;
        return this.skipInterval == videoAdViewProperties.skipInterval() && this.closeButtonSize == videoAdViewProperties.closeButtonSize() && this.isSkippable == videoAdViewProperties.isSkippable() && this.isClickable == videoAdViewProperties.isClickable() && this.isSoundOn == videoAdViewProperties.isSoundOn() && this.hasCompanionAd == videoAdViewProperties.hasCompanionAd();
    }

    public int hashCode() {
        long j = this.skipInterval;
        return ((((((((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.closeButtonSize) * 1000003) ^ (this.isSkippable ? 1231 : 1237)) * 1000003) ^ (this.isClickable ? 1231 : 1237)) * 1000003) ^ (this.isSoundOn ? 1231 : 1237)) * 1000003) ^ (this.hasCompanionAd ? 1231 : 1237);
    }

    static final class Builder extends VideoAdViewProperties.Builder {
        private Integer closeButtonSize;
        private Boolean hasCompanionAd;
        private Boolean isClickable;
        private Boolean isSkippable;
        private Boolean isSoundOn;
        private Long skipInterval;

        Builder() {
        }

        @Override // com.smaato.sdk.video.vast.model.VideoAdViewProperties.Builder
        public VideoAdViewProperties.Builder skipInterval(long j) {
            this.skipInterval = Long.valueOf(j);
            return this;
        }

        @Override // com.smaato.sdk.video.vast.model.VideoAdViewProperties.Builder
        public VideoAdViewProperties.Builder closeButtonSize(int i) {
            this.closeButtonSize = Integer.valueOf(i);
            return this;
        }

        @Override // com.smaato.sdk.video.vast.model.VideoAdViewProperties.Builder
        public VideoAdViewProperties.Builder isSkippable(boolean z) {
            this.isSkippable = Boolean.valueOf(z);
            return this;
        }

        @Override // com.smaato.sdk.video.vast.model.VideoAdViewProperties.Builder
        public VideoAdViewProperties.Builder isClickable(boolean z) {
            this.isClickable = Boolean.valueOf(z);
            return this;
        }

        @Override // com.smaato.sdk.video.vast.model.VideoAdViewProperties.Builder
        public VideoAdViewProperties.Builder isSoundOn(boolean z) {
            this.isSoundOn = Boolean.valueOf(z);
            return this;
        }

        @Override // com.smaato.sdk.video.vast.model.VideoAdViewProperties.Builder
        public VideoAdViewProperties.Builder hasCompanionAd(boolean z) {
            this.hasCompanionAd = Boolean.valueOf(z);
            return this;
        }

        @Override // com.smaato.sdk.video.vast.model.VideoAdViewProperties.Builder
        public VideoAdViewProperties build() {
            String str;
            if (this.skipInterval != null) {
                str = "";
            } else {
                str = " skipInterval";
            }
            if (this.closeButtonSize == null) {
                str = str + " closeButtonSize";
            }
            if (this.isSkippable == null) {
                str = str + " isSkippable";
            }
            if (this.isClickable == null) {
                str = str + " isClickable";
            }
            if (this.isSoundOn == null) {
                str = str + " isSoundOn";
            }
            if (this.hasCompanionAd == null) {
                str = str + " hasCompanionAd";
            }
            if (!str.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + str);
            }
            return new AutoValue_VideoAdViewProperties(this.skipInterval.longValue(), this.closeButtonSize.intValue(), this.isSkippable.booleanValue(), this.isClickable.booleanValue(), this.isSoundOn.booleanValue(), this.hasCompanionAd.booleanValue());
        }
    }
}
