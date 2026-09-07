package com.smaato.sdk.video.vast.parser;

import com.smaato.sdk.core.di.ClassFactory;
import com.smaato.sdk.core.di.DiConstructor;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.video.framework.VideoDiNames;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes6.dex */
public final class RegistryXmlParserFactory implements ClassFactory<RegistryXmlParser> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.smaato.sdk.core.di.ClassFactory
    /* JADX INFO: renamed from: get */
    public RegistryXmlParser get2(DiConstructor diConstructor) {
        XmlPullParser xmlPullParser = (XmlPullParser) diConstructor.get(VideoDiNames.MODULE_DI_NAME, XmlPullParser.class);
        Objects.requireNonNull(xmlPullParser, "XML pull parser shouldn't be null");
        RegistryXmlParser registryXmlParser = new RegistryXmlParser(xmlPullParser, new HashMap());
        registryXmlParser.registerParser("VAST", new VastTreeParser());
        registryXmlParser.registerParser("AdParameters", new AdParametersParser());
        registryXmlParser.registerParser("Ad", new AdParser());
        registryXmlParser.registerParser("AdSystem", new AdSystemParser());
        registryXmlParser.registerParser("Category", new CategoryParser());
        registryXmlParser.registerParser("Advertiser", new AdvertiserParser());
        registryXmlParser.registerParser("CompanionAds", new CompanionAdsParser());
        registryXmlParser.registerParser("Companion", new CompanionParser());
        registryXmlParser.registerParser("Creative", new CreativeParser());
        registryXmlParser.registerParser("IconClicks", new IconClicksParser());
        registryXmlParser.registerParser("Icon", new IconParser());
        registryXmlParser.registerParser("InLine", new InLineParser());
        registryXmlParser.registerParser("JavaScriptResource", new JavaScriptResourceParser());
        registryXmlParser.registerParser("Linear", new LinearParser());
        registryXmlParser.registerParser("MediaFile", new MediaFileParser());
        registryXmlParser.registerParser("StaticResource", new StaticResourceParser());
        registryXmlParser.registerParser("Tracking", new TrackingParser());
        registryXmlParser.registerParser("UniversalAdId", new UniversalAdIdParser());
        registryXmlParser.registerParser("Verification", new VerificationParser());
        registryXmlParser.registerParser("Extension", new ExtensionParser());
        registryXmlParser.registerParser("VideoClicks", new VideoClicksParser());
        registryXmlParser.registerParser("ViewableImpression", new ViewableImpressionParser());
        registryXmlParser.registerParser("Wrapper", new WrapperParser());
        registryXmlParser.registerParser("Impression", new VastBeaconParser("Impression"));
        registryXmlParser.registerParser("ClickThrough", new VastBeaconParser("ClickThrough"));
        registryXmlParser.registerParser("ClickTracking", new VastBeaconParser("ClickTracking"));
        registryXmlParser.registerParser("CustomClick", new VastBeaconParser("CustomClick"));
        registryXmlParser.registerParser("IconClickTracking", new VastBeaconParser("IconClickTracking"));
        registryXmlParser.registerParser("CompanionClickTracking", new VastBeaconParser("CompanionClickTracking"));
        registryXmlParser.registerParser("AdVerifications", new ArrayXmlClassParser("AdVerifications", "Verification"));
        registryXmlParser.registerParser("Extensions", new ArrayXmlClassParser("Extensions", "Extension"));
        registryXmlParser.registerParser("Creatives", new ArrayXmlClassParser("Creatives", "Creative"));
        registryXmlParser.registerParser("MediaFiles", new ArrayXmlClassParser("MediaFiles", "MediaFile"));
        registryXmlParser.registerParser("Icons", new ArrayXmlClassParser("Icons", "Icon"));
        registryXmlParser.registerParser("TrackingEvents", new ArrayXmlClassParser("TrackingEvents", "Tracking"));
        return registryXmlParser;
    }
}
