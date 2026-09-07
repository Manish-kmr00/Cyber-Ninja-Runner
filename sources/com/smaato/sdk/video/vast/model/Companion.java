package com.smaato.sdk.video.vast.model;

import com.safedk.android.internal.SafeDKWebAppInterface;
import com.smaato.sdk.video.vast.utils.VastModels;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public class Companion implements Sized {
    public static final String AD_PARAMETERS = "AdParameters";
    public static final String AD_SLOT_ID = "adSlotID";
    public static final String ALT_TEXT = "AltText";
    public static final String API_FRAMEWORK = "apiFramework";
    public static final String ASSET_HEIGHT = "assetHeight";
    public static final String ASSET_WIDTH = "assetWidth";
    public static final String COMPANION_CLICK_THROUGH = "CompanionClickThrough";
    public static final String COMPANION_CLICK_TRACKING = "CompanionClickTracking";
    public static final String EXPANDED_HEIGHT = "expandedHeight";
    public static final String EXPANDED_WIDTH = "expandedWidth";
    public static final String HEIGHT = "height";
    public static final String HTML_RESOURCE = "HTMLResource";
    public static final String ID = "id";
    public static final String IFRAME_RESOURCE = "IFrameResource";
    public static final String NAME = "Companion";
    public static final String PX_RATIO = "pxratio";
    public static final String RENDERING_MODE = "renderingMode";
    public static final String STATIC_RESOURCE = "StaticResource";
    public static final String TRACKING_EVENTS = "TrackingEvents";
    public static final String WIDTH = "width";
    public final AdParameters adParameters;
    public final String adSlotID;
    public final String altText;
    public final String apiFramework;
    public final Float assetHeight;
    public final Float assetWidth;
    public final String companionClickThrough;
    public final List<VastBeacon> companionClickTrackings;
    public final Float expandedHeight;
    public final Float expandedWidth;
    public final Float height;
    public final List<String> htmlResources;
    public final List<String> iFrameResources;
    public final String id;
    public final Float pxRatio;
    public final String renderingMode;
    public final List<StaticResource> staticResources;
    public final List<Tracking> trackingEvents;
    public final Float width;

    Companion(List<VastBeacon> list, List<Tracking> list2, List<StaticResource> list3, List<String> list4, List<String> list5, String str, Float f, Float f2, Float f3, Float f4, Float f5, Float f6, String str2, String str3, Float f7, String str4, String str5, AdParameters adParameters, String str6) {
        this.id = str;
        this.width = f;
        this.height = f2;
        this.assetWidth = f3;
        this.assetHeight = f4;
        this.expandedWidth = f5;
        this.expandedHeight = f6;
        this.apiFramework = str2;
        this.adSlotID = str3;
        this.pxRatio = f7;
        this.altText = str4;
        this.companionClickThrough = str5;
        this.adParameters = adParameters;
        this.staticResources = list3;
        this.iFrameResources = list4;
        this.htmlResources = list5;
        this.companionClickTrackings = list;
        this.trackingEvents = list2;
        this.renderingMode = str6;
    }

    @Override // com.smaato.sdk.video.vast.model.Sized
    public Float getHeight() {
        Float f = this.height;
        return Float.valueOf(f == null ? 480.0f : f.floatValue());
    }

    @Override // com.smaato.sdk.video.vast.model.Sized
    public Float getWidth() {
        Float f = this.width;
        return Float.valueOf(f == null ? 320.0f : f.floatValue());
    }

    public static class Builder {
        private AdParameters adParameters;
        private String adSlotID;
        private String altText;
        private String apiFramework;
        private Float assetHeight;
        private Float assetWidth;
        private String companionClickThrough;
        private List companionClickTrackings;
        private Float expandedHeight;
        private Float expandedWidth;
        private Float height;
        private List htmlResources;
        private List iFrameResources;
        private String id;
        private Float pxRatio;
        private String renderingMode = SafeDKWebAppInterface.e;
        private List staticResources;
        private List trackingEvents;
        private Float width;

        public Builder setId(String str) {
            this.id = str;
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

        public Builder setAssetWidth(Float f) {
            this.assetWidth = f;
            return this;
        }

        public Builder setAssetHeight(Float f) {
            this.assetHeight = f;
            return this;
        }

        public Builder setExpandedWidth(Float f) {
            this.expandedWidth = f;
            return this;
        }

        public Builder setExpandedHeight(Float f) {
            this.expandedHeight = f;
            return this;
        }

        public Builder setApiFramework(String str) {
            this.apiFramework = str;
            return this;
        }

        public Builder setAdSlotID(String str) {
            this.adSlotID = str;
            return this;
        }

        public Builder setPxRatio(Float f) {
            this.pxRatio = f;
            return this;
        }

        public Builder setAltText(String str) {
            this.altText = str;
            return this;
        }

        public Builder setCompanionClickThrough(String str) {
            this.companionClickThrough = str;
            return this;
        }

        public Builder setAdParameters(AdParameters adParameters) {
            this.adParameters = adParameters;
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

        public Builder setCompanionClickTrackings(List<VastBeacon> list) {
            this.companionClickTrackings = list;
            return this;
        }

        public Builder setTrackingEvents(List<Tracking> list) {
            this.trackingEvents = list;
            return this;
        }

        public Builder setRenderingMode(String str) {
            this.renderingMode = str;
            return this;
        }

        public Companion build() {
            this.companionClickTrackings = VastModels.toImmutableList(this.companionClickTrackings);
            this.trackingEvents = VastModels.toImmutableList(this.trackingEvents);
            this.staticResources = VastModels.toImmutableList(this.staticResources);
            this.iFrameResources = VastModels.toImmutableList(this.iFrameResources);
            List immutableList = VastModels.toImmutableList(this.htmlResources);
            this.htmlResources = immutableList;
            return new Companion(this.companionClickTrackings, this.trackingEvents, this.staticResources, this.iFrameResources, immutableList, this.id, this.width, this.height, this.assetWidth, this.assetHeight, this.expandedWidth, this.expandedHeight, this.apiFramework, this.adSlotID, this.pxRatio, this.altText, this.companionClickThrough, this.adParameters, this.renderingMode);
        }
    }

    public boolean isResourcesEmpty() {
        return this.staticResources.isEmpty() && this.iFrameResources.isEmpty() && this.htmlResources.isEmpty();
    }
}
