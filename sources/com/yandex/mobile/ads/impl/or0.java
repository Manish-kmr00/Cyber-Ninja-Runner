package com.yandex.mobile.ads.impl;

import java.io.IOException;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes13.dex */
public final class or0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final wk2 f9853a;
    private final ae2 b;
    private final q40 c;
    private final mz1 d;
    private final uk2<aw0> e;
    private final uk2<ji0> f;
    private final uk2<e62> g;

    public final void a(XmlPullParser parser, ru.a creativeBuilder, wj base64EncodingParameters) throws XmlPullParserException, JSONException, IOException {
        Intrinsics.checkNotNullParameter(parser, "parser");
        Intrinsics.checkNotNullParameter(creativeBuilder, "creativeBuilder");
        Intrinsics.checkNotNullParameter(base64EncodingParameters, "base64EncodingParameters");
        this.f9853a.getClass();
        Intrinsics.checkNotNullParameter(parser, "parser");
        parser.require(2, null, "Linear");
        this.d.getClass();
        Intrinsics.checkNotNullParameter(parser, "parser");
        String attributeValue = parser.getAttributeValue(null, "skipoffset");
        if (attributeValue == null) {
            attributeValue = "";
        }
        creativeBuilder.a(attributeValue.length() > 0 ? new lz1(attributeValue) : null);
        while (true) {
            this.f9853a.getClass();
            if (!wk2.a(parser)) {
                return;
            }
            this.f9853a.getClass();
            if (wk2.b(parser)) {
                String name = parser.getName();
                if (Intrinsics.areEqual("Duration", name)) {
                    creativeBuilder.a(this.c.a(parser));
                } else if (Intrinsics.areEqual("TrackingEvents", name)) {
                    Iterator it = this.g.a(parser, base64EncodingParameters).iterator();
                    while (it.hasNext()) {
                        creativeBuilder.a((e62) it.next());
                    }
                } else if (Intrinsics.areEqual("MediaFiles", name)) {
                    creativeBuilder.b(this.e.a(parser, base64EncodingParameters));
                } else if (Intrinsics.areEqual("VideoClicks", name)) {
                    zd2 zd2VarA = this.b.a(parser, base64EncodingParameters);
                    creativeBuilder.a(zd2VarA.a());
                    Iterator<String> it2 = zd2VarA.b().iterator();
                    while (it2.hasNext()) {
                        creativeBuilder.a(new e62("clickTracking", it2.next(), null));
                    }
                } else if (Intrinsics.areEqual("Icons", name)) {
                    creativeBuilder.a(this.f.a(parser, base64EncodingParameters));
                } else {
                    this.f9853a.getClass();
                    wk2.d(parser);
                }
            }
        }
    }

    public /* synthetic */ or0() {
        this(new wk2(), new ae2(), new q40(), new mz1(), new uk2(new cw0(), "MediaFiles", "MediaFile"), new uk2(new ki0(), "Icons", "Icon"), new uk2(new f62(), "TrackingEvents", "Tracking"));
    }

    public or0(wk2 xmlHelper, ae2 videoClicksParser, q40 durationParser, mz1 skipOffsetParser, uk2<aw0> mediaFileArrayParser, uk2<ji0> iconArrayParser, uk2<e62> trackingEventsArrayParser) {
        Intrinsics.checkNotNullParameter(xmlHelper, "xmlHelper");
        Intrinsics.checkNotNullParameter(videoClicksParser, "videoClicksParser");
        Intrinsics.checkNotNullParameter(durationParser, "durationParser");
        Intrinsics.checkNotNullParameter(skipOffsetParser, "skipOffsetParser");
        Intrinsics.checkNotNullParameter(mediaFileArrayParser, "mediaFileArrayParser");
        Intrinsics.checkNotNullParameter(iconArrayParser, "iconArrayParser");
        Intrinsics.checkNotNullParameter(trackingEventsArrayParser, "trackingEventsArrayParser");
        this.f9853a = xmlHelper;
        this.b = videoClicksParser;
        this.c = durationParser;
        this.d = skipOffsetParser;
        this.e = mediaFileArrayParser;
        this.f = iconArrayParser;
        this.g = trackingEventsArrayParser;
    }
}
