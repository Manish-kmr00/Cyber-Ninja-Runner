package io.bidmachine.iab.vast.tags;

import android.text.TextUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes7.dex */
public class AdContentTag extends VastXmlTag {
    private AdSystemTag c;
    private List d;
    private List e;
    private List f;
    private List g;

    AdContentTag(XmlPullParser xmlPullParser) {
        super(xmlPullParser);
    }

    private ExtensionTag f(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        ExtensionTag appodealExtensionTag;
        xmlPullParser.require(2, null, "Extension");
        String strA = new ExtensionTag(xmlPullParser).a("type");
        if (VastXmlTag.a(strA, "appodeal")) {
            appodealExtensionTag = new AppodealExtensionTag(xmlPullParser);
        } else if (VastXmlTag.a(strA, "AdVerifications")) {
            AdVerificationsExtensionTag adVerificationsExtensionTag = null;
            while (xmlPullParser.next() != 3) {
                if (xmlPullParser.getEventType() == 2) {
                    if (VastXmlTag.a(xmlPullParser.getName(), "AdVerifications")) {
                        adVerificationsExtensionTag = new AdVerificationsExtensionTag(xmlPullParser);
                    } else {
                        VastXmlTag.d(xmlPullParser);
                    }
                }
            }
            appodealExtensionTag = adVerificationsExtensionTag;
        } else {
            VastXmlTag.d(xmlPullParser);
            appodealExtensionTag = null;
        }
        xmlPullParser.require(3, null, "Extension");
        return appodealExtensionTag;
    }

    void a(AdSystemTag adSystemTag) {
        this.c = adSystemTag;
    }

    void b(List list) {
        this.e = list;
    }

    List e(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, "Creatives");
        ArrayList arrayList = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (VastXmlTag.a(xmlPullParser.getName(), "Creative")) {
                    arrayList.add(new CreativeTag(xmlPullParser));
                } else {
                    VastXmlTag.d(xmlPullParser);
                }
            }
        }
        xmlPullParser.require(3, null, "Creatives");
        return arrayList;
    }

    List g(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, "Extensions");
        ArrayList arrayList = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (VastXmlTag.a(xmlPullParser.getName(), "Extension")) {
                    ExtensionTag extensionTagF = f(xmlPullParser);
                    if (extensionTagF != null) {
                        arrayList.add(extensionTagF);
                    }
                } else {
                    VastXmlTag.d(xmlPullParser);
                }
            }
        }
        xmlPullParser.require(3, null, "Extensions");
        return arrayList;
    }

    public List<CreativeTag> getCreativeTagList() {
        return this.d;
    }

    public List<String> getErrorUrlList() {
        return this.g;
    }

    public List<ExtensionTag> getExtensionTagList() {
        return this.e;
    }

    public List<String> getImpressionUrlList() {
        return this.f;
    }

    void l(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.g == null) {
            this.g = new ArrayList();
        }
        this.g.add(str);
    }

    void m(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.f == null) {
            this.f = new ArrayList();
        }
        this.f.add(str);
    }

    void a(List list) {
        this.d = list;
    }
}
