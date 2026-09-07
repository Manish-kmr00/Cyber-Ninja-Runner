package io.bidmachine.iab.vast.tags;

import io.bidmachine.iab.vast.TrackingEvent;
import io.bidmachine.iab.vast.VastLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes6.dex */
public class LinearCreativeTag extends CreativeContentTag {
    private static final String[] i = {"skipoffset"};
    private Float c;
    private List d;
    private VideoClicksTag e;
    private String f;
    private EnumMap g;
    private int h;

    LinearCreativeTag(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        super(xmlPullParser);
        this.h = -1;
        xmlPullParser.require(2, null, "Linear");
        int iE = VastXmlTag.e(a("skipoffset"));
        if (iE > -1) {
            a(iE);
        }
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                if (VastXmlTag.a(name, "Duration")) {
                    float fE = VastXmlTag.e(VastXmlTag.c(xmlPullParser));
                    if (fE > -1.0f) {
                        setDurationSec(Float.valueOf(fE));
                    }
                } else if (VastXmlTag.a(name, "MediaFiles")) {
                    a(e(xmlPullParser));
                } else if (VastXmlTag.a(name, "VideoClicks")) {
                    a(new VideoClicksTag(xmlPullParser));
                } else if (VastXmlTag.a(name, "AdParameters")) {
                    setAdParameters(VastXmlTag.c(xmlPullParser));
                } else if (VastXmlTag.a(name, "TrackingEvents")) {
                    a(new TrackingEventsTag(xmlPullParser).a());
                } else {
                    VastXmlTag.d(xmlPullParser);
                }
            }
        }
        xmlPullParser.require(3, null, "Linear");
    }

    private void a(List list) {
        this.d = list;
    }

    private static List e(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, "MediaFiles");
        ArrayList arrayList = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (VastXmlTag.a(xmlPullParser.getName(), "MediaFile")) {
                    MediaFileTag mediaFileTag = new MediaFileTag(xmlPullParser);
                    if (mediaFileTag.isValidTag()) {
                        arrayList.add(mediaFileTag);
                    } else {
                        VastLog.d("VastXmlTag", "MediaFile: is not valid. Skipping it.", new Object[0]);
                    }
                }
                VastXmlTag.d(xmlPullParser);
            }
        }
        xmlPullParser.require(3, null, "MediaFiles");
        return arrayList;
    }

    public String getAdParameters() {
        return this.f;
    }

    public Float getDurationSec() {
        return this.c;
    }

    public List<MediaFileTag> getMediaFileTagList() {
        return this.d;
    }

    public int getSkipOffsetSec() {
        return this.h;
    }

    @Override // io.bidmachine.iab.vast.tags.VastXmlTag
    public String[] getSupportedAttributes() {
        return i;
    }

    public Map<TrackingEvent, List<String>> getTrackingEventListMap() {
        return this.g;
    }

    public VideoClicksTag getVideoClicksTag() {
        return this.e;
    }

    public void setAdParameters(String adParameters) {
        this.f = adParameters;
    }

    public void setDurationSec(Float durationSec) {
        this.c = durationSec;
    }

    private void a(int i2) {
        this.h = i2;
    }

    private void a(EnumMap enumMap) {
        this.g = enumMap;
    }

    private void a(VideoClicksTag videoClicksTag) {
        this.e = videoClicksTag;
    }
}
