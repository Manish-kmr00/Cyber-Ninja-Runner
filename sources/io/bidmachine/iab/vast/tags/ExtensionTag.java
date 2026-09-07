package io.bidmachine.iab.vast.tags;

import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes11.dex */
public class ExtensionTag extends VastXmlTag {
    private static final String[] c = {"type"};

    ExtensionTag(XmlPullParser xmlPullParser) {
        super(xmlPullParser);
    }

    @Override // io.bidmachine.iab.vast.tags.VastXmlTag
    public String[] getSupportedAttributes() {
        return c;
    }
}
