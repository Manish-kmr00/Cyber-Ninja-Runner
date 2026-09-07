package io.bidmachine.iab.vast.tags;

import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes8.dex */
public class VerificationTag extends VastXmlTag {
    private static final String[] e = {"vendor"};
    private JavaScriptResourceTag c;
    private String d;

    VerificationTag(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        super(xmlPullParser);
        xmlPullParser.require(2, null, "Verification");
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                if (VastXmlTag.a(name, "JavaScriptResource")) {
                    this.c = new JavaScriptResourceTag(xmlPullParser);
                } else if (VastXmlTag.a(name, "VerificationParameters")) {
                    this.d = VastXmlTag.c(xmlPullParser);
                } else {
                    VastXmlTag.d(xmlPullParser);
                }
            }
        }
        xmlPullParser.require(3, null, "Verification");
    }

    public JavaScriptResourceTag getJavaScriptResourceTag() {
        return this.c;
    }

    @Override // io.bidmachine.iab.vast.tags.VastXmlTag
    public String[] getSupportedAttributes() {
        return e;
    }

    public String getVendor() {
        return a("vendor");
    }

    public String getVerificationParameters() {
        return this.d;
    }
}
