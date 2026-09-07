package net.pubnative.lite.sdk.vpaid.models.vast;

import java.util.List;
import net.pubnative.lite.sdk.vpaid.xml.Attribute;
import net.pubnative.lite.sdk.vpaid.xml.Tag;

/* JADX INFO: loaded from: classes5.dex */
public class IconClickFallbackImage {

    @Tag
    private AltText altText;

    @Attribute
    private String height;

    @Tag("StaticResource")
    private List<StaticResource> staticResources;

    @Attribute
    private String width;

    public String getWidth() {
        return this.width;
    }

    public String getHeight() {
        return this.height;
    }

    public AltText getAltText() {
        return this.altText;
    }

    public List<StaticResource> getStaticResources() {
        return this.staticResources;
    }
}
