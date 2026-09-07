package net.pubnative.lite.sdk.vpaid.models.vast;

import java.util.List;
import net.pubnative.lite.sdk.vpaid.xml.Attribute;
import net.pubnative.lite.sdk.vpaid.xml.Tag;

/* JADX INFO: loaded from: classes12.dex */
public class Companion {

    @Tag
    private AdParameters adParameters;

    @Attribute
    private String adSlotId;

    @Tag
    private AltText altText;

    @Attribute
    private String apiFramework;

    @Attribute
    private String assetHeight;

    @Attribute
    private String assetWidth;

    @Tag
    private CompanionClickThrough companionClickThrough;

    @Tag("CompanionClickTracking")
    private List<CompanionClickTracking> companionClickTrackingList;

    @Attribute
    private String expandedHeight;

    @Attribute
    private String expandedWidth;

    @Attribute
    private String height;

    @Tag("HTMLResource")
    private List<HTMLResource> htmlResources;

    @Tag("IFrameResource")
    private List<IFrameResource> iFrameResources;

    @Attribute
    private String id;

    @Attribute
    private String pxratio;

    @Attribute
    private String renderingMode;

    @Tag("StaticResource")
    private List<StaticResource> staticResources;

    @Tag
    private TrackingEvents trackingEvents;

    @Attribute
    private String width;

    public String getWidth() {
        return this.width;
    }

    public String getHeight() {
        return this.height;
    }

    public String getId() {
        return this.id;
    }

    public String getAssetWidth() {
        return this.assetWidth;
    }

    public String getAssetHeight() {
        return this.assetHeight;
    }

    public String getExpandedWidth() {
        return this.expandedWidth;
    }

    public String getExpandedHeight() {
        return this.expandedHeight;
    }

    public String getApiFramework() {
        return this.apiFramework;
    }

    public String getAdSlotId() {
        return this.adSlotId;
    }

    public String getPxratio() {
        return this.pxratio;
    }

    public String getRenderingMode() {
        return this.renderingMode;
    }

    public List<StaticResource> getStaticResources() {
        return this.staticResources;
    }

    public List<IFrameResource> getiFrameResources() {
        return this.iFrameResources;
    }

    public List<HTMLResource> getHtmlResources() {
        return this.htmlResources;
    }

    public AdParameters getAdParameters() {
        return this.adParameters;
    }

    public AltText getAltText() {
        return this.altText;
    }

    public CompanionClickThrough getCompanionClickThrough() {
        return this.companionClickThrough;
    }

    public List<CompanionClickTracking> getCompanionClickTrackingList() {
        return this.companionClickTrackingList;
    }

    public TrackingEvents getTrackingEvents() {
        return this.trackingEvents;
    }
}
