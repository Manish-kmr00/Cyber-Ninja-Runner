package com.smaato.sdk.video.vast.model;

import com.smaato.sdk.video.vast.utils.VastModels;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public class Linear {
    public static final String AD_PARAMETERS = "AdParameters";
    public static final String DURATION = "Duration";
    public static final String ICONS = "Icons";
    public static final String MEDIA_FILES = "MediaFiles";
    public static final String NAME = "Linear";
    public static final String SKIPOFFSET = "skipoffset";
    public static final String TRACKING_EVENTS = "TrackingEvents";
    public static final String VIDEO_CLICKS = "VideoClicks";
    public final AdParameters adParameters;
    public final String duration;
    public final List<Icon> icons;
    public final List<MediaFile> mediaFiles;
    public final String skipOffset;
    public final List<Tracking> trackingEvents;
    public final VideoClicks videoClicks;

    Linear(List<MediaFile> list, List<Tracking> list2, List<Icon> list3, AdParameters adParameters, String str, String str2, VideoClicks videoClicks) {
        this.adParameters = adParameters;
        this.duration = str;
        this.skipOffset = str2;
        this.mediaFiles = list;
        this.videoClicks = videoClicks;
        this.trackingEvents = list2;
        this.icons = list3;
    }

    public static class Builder {
        private AdParameters adParameters;
        private String duration;
        private List icons;
        private List mediaFiles;
        private String skipOffset;
        private List trackingEvents;
        private VideoClicks videoClicks;

        public Builder setSkipOffset(String str) {
            this.skipOffset = str;
            return this;
        }

        public Builder setDuration(String str) {
            this.duration = str;
            return this;
        }

        public Builder setAdParameters(AdParameters adParameters) {
            this.adParameters = adParameters;
            return this;
        }

        public Builder setMediaFiles(List<MediaFile> list) {
            List list2 = this.mediaFiles;
            if (list2 == null || list2.isEmpty()) {
                this.mediaFiles = list;
            }
            return this;
        }

        public Builder setVideoClicks(VideoClicks videoClicks) {
            this.videoClicks = videoClicks;
            return this;
        }

        public Builder setTrackingEvents(List<Tracking> list) {
            this.trackingEvents = list;
            return this;
        }

        public Builder setIcons(List<Icon> list) {
            this.icons = list;
            return this;
        }

        public Linear build() {
            return new Linear(VastModels.toImmutableList(this.mediaFiles), VastModels.toImmutableList(this.trackingEvents), VastModels.toImmutableList(this.icons), this.adParameters, this.duration, this.skipOffset, this.videoClicks);
        }
    }
}
