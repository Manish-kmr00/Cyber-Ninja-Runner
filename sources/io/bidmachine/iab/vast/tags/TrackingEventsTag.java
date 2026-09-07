package io.bidmachine.iab.vast.tags;

import io.bidmachine.iab.vast.TrackingEvent;
import io.bidmachine.iab.vast.VastLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes9.dex */
class TrackingEventsTag extends VastXmlTag {
    private final EnumMap c;

    TrackingEventsTag(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        TrackingEvent trackingEventValueOf;
        super(xmlPullParser);
        this.c = new EnumMap(TrackingEvent.class);
        xmlPullParser.require(2, null, "TrackingEvents");
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (VastXmlTag.a(xmlPullParser.getName(), "Tracking")) {
                    String strA = new TrackingTag(xmlPullParser).a("event");
                    try {
                        trackingEventValueOf = TrackingEvent.valueOf(strA);
                    } catch (Exception unused) {
                        VastLog.d("VastXmlTag", "Event: %s is not valid. Skipping it.", strA);
                        trackingEventValueOf = null;
                    }
                    if (trackingEventValueOf != null) {
                        String strC = VastXmlTag.c(xmlPullParser);
                        List list = (List) this.c.get(trackingEventValueOf);
                        if (list != null) {
                            list.add(strC);
                        } else {
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(strC);
                            this.c.put(trackingEventValueOf, arrayList);
                        }
                    }
                }
                VastXmlTag.d(xmlPullParser);
            }
        }
        xmlPullParser.require(3, null, "TrackingEvents");
    }

    EnumMap a() {
        return this.c;
    }
}
