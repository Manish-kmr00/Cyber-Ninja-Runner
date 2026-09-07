package com.smaato.sdk.video.vast.model;

import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.video.vast.utils.VastModels;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public final class VastRawMediaFileScenario {
    public final AdParameters adParameters;
    public final long duration;
    public final MediaFile mediaFile;
    public final long skipOffset;
    public final List<Tracking> trackingEvents;
    public final VastIconScenario vastIconScenario;
    public final VastScenarioCreativeData vastScenarioCreativeData;
    public final VideoClicks videoClicks;

    private VastRawMediaFileScenario(List list, VastScenarioCreativeData vastScenarioCreativeData, MediaFile mediaFile, long j, long j2, AdParameters adParameters, VideoClicks videoClicks, VastIconScenario vastIconScenario) {
        this.mediaFile = mediaFile;
        this.vastScenarioCreativeData = vastScenarioCreativeData;
        this.duration = j;
        this.skipOffset = j2;
        this.trackingEvents = list;
        this.adParameters = adParameters;
        this.videoClicks = videoClicks;
        this.vastIconScenario = vastIconScenario;
    }

    public Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        private AdParameters adParameters;
        private long duration;
        private MediaFile mediaFile;
        private long skipOffset;
        private List trackingEvents;
        private VastIconScenario vastIconScenario;
        private VastScenarioCreativeData vastScenarioCreativeData;
        private VideoClicks videoClicks;

        public Builder() {
        }

        private Builder(VastRawMediaFileScenario vastRawMediaFileScenario) {
            this.trackingEvents = vastRawMediaFileScenario.trackingEvents;
            this.vastScenarioCreativeData = vastRawMediaFileScenario.vastScenarioCreativeData;
            this.mediaFile = vastRawMediaFileScenario.mediaFile;
            this.duration = vastRawMediaFileScenario.duration;
            this.skipOffset = vastRawMediaFileScenario.skipOffset;
            this.adParameters = vastRawMediaFileScenario.adParameters;
            this.videoClicks = vastRawMediaFileScenario.videoClicks;
            this.vastIconScenario = vastRawMediaFileScenario.vastIconScenario;
        }

        public Builder setTrackingEvents(List<Tracking> list) {
            this.trackingEvents = list;
            return this;
        }

        public Builder setMediaFile(MediaFile mediaFile) {
            this.mediaFile = mediaFile;
            return this;
        }

        public Builder setDuration(long j) {
            this.duration = j;
            return this;
        }

        public Builder setAdParameters(AdParameters adParameters) {
            this.adParameters = adParameters;
            return this;
        }

        public Builder setSkipOffset(long j) {
            this.skipOffset = j;
            return this;
        }

        public Builder setVideoClicks(VideoClicks videoClicks) {
            this.videoClicks = videoClicks;
            return this;
        }

        public Builder setVastIconScenario(VastIconScenario vastIconScenario) {
            this.vastIconScenario = vastIconScenario;
            return this;
        }

        public Builder setVastScenarioCreativeData(VastScenarioCreativeData vastScenarioCreativeData) {
            this.vastScenarioCreativeData = vastScenarioCreativeData;
            return this;
        }

        public VastRawMediaFileScenario build() {
            Objects.requireNonNull(this.vastScenarioCreativeData, "Cannot build VastMediaFileScenario: vastScenarioCreativeData is missing");
            return new VastRawMediaFileScenario(VastModels.toImmutableList(this.trackingEvents), this.vastScenarioCreativeData, this.mediaFile, this.duration, this.skipOffset, this.adParameters, this.videoClicks, this.vastIconScenario);
        }
    }
}
