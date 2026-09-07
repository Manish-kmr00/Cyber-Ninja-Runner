package com.smaato.sdk.video.vast.model;

import com.smaato.sdk.video.vast.utils.VastModels;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class IconClicks {
    public static final String ICON_CLICK_THROUGH = "IconClickThrough";
    public static final String ICON_CLICK_TRACKING = "IconClickTracking";
    public static final String NAME = "IconClicks";
    public final String iconClickThrough;
    public final List<VastBeacon> iconClickTrackings;

    IconClicks(List<VastBeacon> list, String str) {
        this.iconClickTrackings = list;
        this.iconClickThrough = str;
    }

    public static class Builder {
        private String iconClickThrough;
        private List iconClickTrackings;

        public Builder setIconClickTrackings(List<VastBeacon> list) {
            this.iconClickTrackings = list;
            return this;
        }

        public Builder setIconClickThrough(String str) {
            this.iconClickThrough = str;
            return this;
        }

        public IconClicks build() {
            return new IconClicks(VastModels.toImmutableList(this.iconClickTrackings), this.iconClickThrough);
        }
    }
}
