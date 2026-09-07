package com.smaato.sdk.video.vast.model;

/* JADX INFO: loaded from: classes4.dex */
public abstract class VideoAdViewProperties {

    public static abstract class Builder {
        public abstract VideoAdViewProperties build();

        public abstract Builder closeButtonSize(int i);

        public abstract Builder hasCompanionAd(boolean z);

        public abstract Builder isClickable(boolean z);

        public abstract Builder isSkippable(boolean z);

        public abstract Builder isSoundOn(boolean z);

        public abstract Builder skipInterval(long j);
    }

    public abstract int closeButtonSize();

    public abstract boolean hasCompanionAd();

    public abstract boolean isClickable();

    public abstract boolean isSkippable();

    public abstract boolean isSoundOn();

    public abstract long skipInterval();

    public static Builder builder() {
        return new AutoValue_VideoAdViewProperties.Builder();
    }
}
