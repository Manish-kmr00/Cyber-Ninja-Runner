package io.bidmachine.iab.vast.tags;

import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes12.dex */
public class AdTag extends VastXmlTag {
    private static final String[] d = {"id"};
    private AdContentTag c;

    AdTag(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        AdContentTag inLineAdTag;
        super(xmlPullParser);
        xmlPullParser.require(2, null, "Ad");
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                if (VastXmlTag.a(name, "InLine")) {
                    inLineAdTag = new InLineAdTag(xmlPullParser);
                } else if (VastXmlTag.a(name, "Wrapper")) {
                    inLineAdTag = new WrapperAdTag(xmlPullParser);
                } else {
                    VastXmlTag.d(xmlPullParser);
                }
                this.c = inLineAdTag;
            }
        }
        xmlPullParser.require(3, null, "Ad");
    }

    public AdContentTag getAdContentTag() {
        return this.c;
    }

    @Override // io.bidmachine.iab.vast.tags.VastXmlTag
    public String[] getSupportedAttributes() {
        return d;
    }
}
