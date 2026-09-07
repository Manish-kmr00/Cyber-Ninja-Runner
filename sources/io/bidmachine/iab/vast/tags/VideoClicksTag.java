package io.bidmachine.iab.vast.tags;

import android.text.TextUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes13.dex */
public class VideoClicksTag extends VastXmlTag {
    private String c;
    private List d;
    private List e;

    VideoClicksTag(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        super(xmlPullParser);
        xmlPullParser.require(2, null, "VideoClicks");
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                if (VastXmlTag.a(name, "ClickThrough")) {
                    n(VastXmlTag.c(xmlPullParser));
                } else if (VastXmlTag.a(name, "ClickTracking")) {
                    l(VastXmlTag.c(xmlPullParser));
                } else if (VastXmlTag.a(name, "CustomClick")) {
                    m(VastXmlTag.c(xmlPullParser));
                } else {
                    VastXmlTag.d(xmlPullParser);
                }
            }
        }
        xmlPullParser.require(3, null, "VideoClicks");
    }

    private void l(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.d == null) {
            this.d = new ArrayList();
        }
        this.d.add(str);
    }

    private void m(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.e == null) {
            this.e = new ArrayList();
        }
        this.e.add(str);
    }

    private void n(String str) {
        this.c = str;
    }

    public String getClickThroughUrl() {
        return this.c;
    }

    public List<String> getClickTrackingUrlList() {
        return this.d;
    }
}
