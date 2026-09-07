package net.pubnative.lite.sdk.vpaid.models.vast;

import java.util.List;
import net.pubnative.lite.sdk.vpaid.xml.Attribute;
import net.pubnative.lite.sdk.vpaid.xml.Tag;

/* JADX INFO: loaded from: classes12.dex */
public class Icon {

    @Attribute
    private String altText;

    @Attribute
    private String apiFramework;

    @Attribute
    private String duration;

    @Attribute
    private String height;

    @Attribute
    private String hoverText;

    @Tag("HTMLResource")
    private List<HTMLResource> htmlResources;

    @Tag("IFrameResource")
    private List<IFrameResource> iFrameResources;

    @Tag
    private IconClicks iconClicks;

    @Tag("IconViewTracking")
    private List<IconViewTracking> iconViewTrackingList;

    @Attribute
    private String offset;

    @Attribute
    private String program;

    @Attribute
    private String pxratio;

    @Tag("StaticResource")
    private List<StaticResource> staticResources;

    @Attribute
    private String width;

    @Attribute
    private String xPosition;

    @Attribute
    private String yPosition;

    public String getProgram() {
        return this.program;
    }

    public String getWidth() {
        return this.width;
    }

    public String getHeight() {
        return this.height;
    }

    public String getXPosition() {
        return this.xPosition;
    }

    public String getYPosition() {
        return this.yPosition;
    }

    public String getDuration() {
        return this.duration;
    }

    public String getOffset() {
        return this.offset;
    }

    public String getApiFramework() {
        return this.apiFramework;
    }

    public String getPxratio() {
        return this.pxratio;
    }

    public String getAltText() {
        return this.altText;
    }

    public String getHoverText() {
        return this.hoverText;
    }

    public List<StaticResource> getStaticResources() {
        return this.staticResources;
    }

    public List<IFrameResource> getIFrameResources() {
        return this.iFrameResources;
    }

    public List<HTMLResource> getHtmlResources() {
        return this.htmlResources;
    }

    public IconClicks getIconClicks() {
        return this.iconClicks;
    }

    public List<IconViewTracking> getIconViewTrackingList() {
        return this.iconViewTrackingList;
    }
}
