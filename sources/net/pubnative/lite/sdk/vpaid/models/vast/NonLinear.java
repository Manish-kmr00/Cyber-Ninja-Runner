package net.pubnative.lite.sdk.vpaid.models.vast;

import java.util.List;
import net.pubnative.lite.sdk.vpaid.xml.Attribute;
import net.pubnative.lite.sdk.vpaid.xml.Tag;

/* JADX INFO: loaded from: classes11.dex */
public class NonLinear {

    @Tag
    private AdParameters adParameters;

    @Attribute
    private String apiFramework;

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
    private String maintainAspectRatio;

    @Attribute
    private String minSuggestedDuration;

    @Tag
    private NonLinearClickThrough nonLinearClickThrough;

    @Tag("NonLinearClickTracking")
    private List<NonLinearClickTracking> nonLinearClickTrackingList;

    @Attribute
    private String scalable;

    @Tag("StaticResource")
    private List<StaticResource> staticResources;

    @Attribute
    private String width;

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

    public NonLinearClickThrough getNonLinearClickThrough() {
        return this.nonLinearClickThrough;
    }

    public List<NonLinearClickTracking> getNonLinearClickTrackingList() {
        return this.nonLinearClickTrackingList;
    }

    public String getId() {
        return this.id;
    }

    public String getWidth() {
        return this.width;
    }

    public String getHeight() {
        return this.height;
    }

    public String getExpandedWidth() {
        return this.expandedWidth;
    }

    public String getExpandedHeight() {
        return this.expandedHeight;
    }

    public String isScalable() {
        return this.scalable;
    }

    public String isMaintainAspectRatio() {
        return this.maintainAspectRatio;
    }

    public String getApiFramework() {
        return this.apiFramework;
    }

    public String getMinSuggestedDuration() {
        return this.minSuggestedDuration;
    }
}
