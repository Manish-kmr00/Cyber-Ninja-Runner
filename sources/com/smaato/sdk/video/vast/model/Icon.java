package com.smaato.sdk.video.vast.model;

import com.smaato.sdk.video.vast.utils.VastModels;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public class Icon {
    public static final String API_FRAMEWORK = "apiFramework";
    public static final String DURATION = "duration";
    public static final String HEIGHT = "height";
    public static final String HTML_RESOURCE = "HTMLResource";
    public static final String ICON_CLICKS = "IconClicks";
    public static final String ICON_VIEW_TRACKING = "IconViewTracking";
    public static final String I_FRAME_RESOURCE = "IFrameResource";
    public static final String NAME = "Icon";
    public static final String OFFSET = "offset";
    public static final String PROGRAM = "program";
    public static final String PX_RATIO = "pxratio";
    public static final String STATIC_RESOURCE = "StaticResource";
    public static final String WIDTH = "width";
    public static final String X_POSITION = "xPosition";
    public static final String Y_POSITION = "yPosition";
    public final String apiFramework;
    public final String duration;
    public final Float height;
    public final List<String> htmlResources;
    public final List<String> iFrameResources;
    public final IconClicks iconClicks;
    public final List<String> iconViewTrackings;
    public final String offset;
    public final String program;
    public final Float pxRatio;
    public final List<StaticResource> staticResources;
    public final Float width;
    public final String xPosition;
    public final String yPosition;

    Icon(List<String> list, List<StaticResource> list2, List<String> list3, List<String> list4, String str, Float f, Float f2, String str2, String str3, String str4, String str5, Float f3, IconClicks iconClicks, String str6) {
        this.program = str;
        this.width = f;
        this.height = f2;
        this.xPosition = str2;
        this.yPosition = str3;
        this.offset = str4;
        this.duration = str5;
        this.pxRatio = f3;
        this.iconViewTrackings = list;
        this.iconClicks = iconClicks;
        this.staticResources = list2;
        this.iFrameResources = list3;
        this.htmlResources = list4;
        this.apiFramework = str6;
    }

    public static class Builder {
        private String apiFramework;
        private String duration;
        private Float height;
        private List htmlResources;
        private List iFrameResources;
        private IconClicks iconClicks;
        private List iconViewTrackings;
        private String offset;
        private String program;
        private Float pxRatio;
        private List staticResources;
        private Float width;
        private String xPosition;
        private String yPosition;

        public Builder setProgram(String str) {
            this.program = str;
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

        public Builder setXPosition(String str) {
            this.xPosition = str;
            return this;
        }

        public Builder setYPosition(String str) {
            this.yPosition = str;
            return this;
        }

        public Builder setOffset(String str) {
            this.offset = str;
            return this;
        }

        public Builder setDuration(String str) {
            this.duration = str;
            return this;
        }

        public Builder setPxRatio(Float f) {
            this.pxRatio = f;
            return this;
        }

        public Builder setIconViewTrackings(List<String> list) {
            this.iconViewTrackings = list;
            return this;
        }

        public Builder setIconClicks(IconClicks iconClicks) {
            this.iconClicks = iconClicks;
            return this;
        }

        public Builder setStaticResources(List<StaticResource> list) {
            this.staticResources = list;
            return this;
        }

        public Builder setIFrameResources(List<String> list) {
            this.iFrameResources = list;
            return this;
        }

        public Builder setHtmlResources(List<String> list) {
            this.htmlResources = list;
            return this;
        }

        public Builder setApiFramework(String str) {
            this.apiFramework = str;
            return this;
        }

        public Icon build() {
            this.iconViewTrackings = VastModels.toImmutableList(this.iconViewTrackings);
            this.staticResources = VastModels.toImmutableList(this.staticResources);
            this.iFrameResources = VastModels.toImmutableList(this.iFrameResources);
            List immutableList = VastModels.toImmutableList(this.htmlResources);
            this.htmlResources = immutableList;
            return new Icon(this.iconViewTrackings, this.staticResources, this.iFrameResources, immutableList, this.program, this.width, this.height, this.xPosition, this.yPosition, this.offset, this.duration, this.pxRatio, this.iconClicks, this.apiFramework);
        }
    }
}
