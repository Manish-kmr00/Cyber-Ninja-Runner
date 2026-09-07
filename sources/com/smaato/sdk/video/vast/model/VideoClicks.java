package com.smaato.sdk.video.vast.model;

import com.smaato.sdk.video.vast.utils.VastModels;
import java.util.List;

/* JADX INFO: loaded from: classes12.dex */
public class VideoClicks {
    public static final String CLICK_THROUGH = "ClickThrough";
    public static final String CLICK_TRACKING = "ClickTracking";
    public static final String CUSTOM_CLICK = "CustomClick";
    public static final String NAME = "VideoClicks";
    public final VastBeacon clickThrough;
    public final List<VastBeacon> clickTrackings;
    public final List<VastBeacon> customClicks;

    VideoClicks(List<VastBeacon> list, List<VastBeacon> list2, VastBeacon vastBeacon) {
        this.clickThrough = vastBeacon;
        this.clickTrackings = list;
        this.customClicks = list2;
    }

    public static class Builder {
        private VastBeacon clickThrough;
        private List clickTrackings;
        private List customClicks;

        public Builder setClickThrough(VastBeacon vastBeacon) {
            this.clickThrough = vastBeacon;
            return this;
        }

        public Builder setClickTrackings(List<VastBeacon> list) {
            this.clickTrackings = list;
            return this;
        }

        public Builder setCustomClicks(List<VastBeacon> list) {
            this.customClicks = list;
            return this;
        }

        public VideoClicks build() {
            this.clickTrackings = VastModels.toImmutableList(this.clickTrackings);
            List immutableList = VastModels.toImmutableList(this.customClicks);
            this.customClicks = immutableList;
            return new VideoClicks(this.clickTrackings, immutableList, this.clickThrough);
        }
    }
}
