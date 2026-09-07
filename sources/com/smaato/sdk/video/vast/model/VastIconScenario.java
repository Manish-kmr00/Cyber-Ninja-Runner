package com.smaato.sdk.video.vast.model;

import com.smaato.sdk.video.vast.exceptions.VastElementMissingException;
import com.smaato.sdk.video.vast.utils.VastModels;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class VastIconScenario {
    public final String apiFramework;
    public final long duration;
    public final Float height;
    public final IconClicks iconClicks;
    public final List<String> iconViewTrackings;
    public final long offset;
    public final String program;
    public final Float pxRatio;
    public final VastScenarioResourceData resourceData;
    public final Float width;
    public final String xPosition;
    public final String yPosition;

    private VastIconScenario(VastScenarioResourceData vastScenarioResourceData, List list, Float f, Float f2, String str, String str2, String str3, long j, long j2, Float f3, IconClicks iconClicks, String str4) {
        this.iconViewTrackings = list;
        this.resourceData = vastScenarioResourceData;
        this.program = str;
        this.width = f;
        this.height = f2;
        this.xPosition = str2;
        this.yPosition = str3;
        this.offset = j;
        this.duration = j2;
        this.pxRatio = f3;
        this.iconClicks = iconClicks;
        this.apiFramework = str4;
    }

    public static class Builder {
        private String apiFramework;
        private long duration;
        private Float height;
        private IconClicks iconClicks;
        private List iconViewTrackings;
        private long offset;
        private String program;
        private Float pxRatio;
        private VastScenarioResourceData resourceData;
        private Float width;
        private String xPosition;
        private String yPosition;

        public Builder setVastScenarioResourceData(VastScenarioResourceData vastScenarioResourceData) {
            this.resourceData = vastScenarioResourceData;
            return this;
        }

        public Builder setIconViewTrackings(List<String> list) {
            this.iconViewTrackings = list;
            return this;
        }

        public Builder setWidth(Float f) {
            this.width = f;
            return this;
        }

        public Builder setHeight(Float f) {
            this.height = f;
            return this;
        }

        public Builder setProgram(String str) {
            this.program = str;
            return this;
        }

        public Builder setXPosition(String str) {
            this.xPosition = str;
            return this;
        }

        public Builder setYPosition(String str) {
            this.yPosition = str;
            return this;
        }

        public Builder setOffset(long j) {
            this.offset = j;
            return this;
        }

        public Builder setPxRatio(Float f) {
            this.pxRatio = f;
            return this;
        }

        public Builder setIconClicks(IconClicks iconClicks) {
            this.iconClicks = iconClicks;
            return this;
        }

        public Builder setApiFramework(String str) {
            this.apiFramework = str;
            return this;
        }

        public Builder setDuration(long j) {
            this.duration = j;
            return this;
        }

        public VastIconScenario build() throws VastElementMissingException {
            VastModels.requireNonNull(this.resourceData, "Cannot build VastIconScenario: resourceData is missing");
            return new VastIconScenario(this.resourceData, VastModels.toImmutableList(this.iconViewTrackings), this.width, this.height, this.program, this.xPosition, this.yPosition, this.offset, this.duration, this.pxRatio, this.iconClicks, this.apiFramework);
        }
    }
}
