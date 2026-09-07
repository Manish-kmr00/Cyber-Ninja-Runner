package io.bidmachine.iab.vast.tags;

import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes12.dex */
public class CreativeTag extends VastXmlTag {
    private static final String[] d = {"id", VastAttributes.AD_ID};
    private CreativeContentTag c;

    CreativeTag(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        CreativeContentTag linearCreativeTag;
        super(xmlPullParser);
        xmlPullParser.require(2, null, "Creative");
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                if (VastXmlTag.a(name, "Linear")) {
                    linearCreativeTag = new LinearCreativeTag(xmlPullParser);
                } else if (VastXmlTag.a(name, "CompanionAds")) {
                    linearCreativeTag = new CompanionAdsCreativeTag(xmlPullParser);
                } else {
                    VastXmlTag.d(xmlPullParser);
                }
                this.c = linearCreativeTag;
            }
        }
        xmlPullParser.require(3, null, "Creative");
    }

    public CreativeContentTag getCreativeContentTag() {
        return this.c;
    }

    @Override // io.bidmachine.iab.vast.tags.VastXmlTag
    public String[] getSupportedAttributes() {
        return d;
    }
}
