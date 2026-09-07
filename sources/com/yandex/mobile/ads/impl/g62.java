package com.yandex.mobile.ads.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes4.dex */
public final class g62 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final wk2 f8970a;
    private final f62 b;

    public final HashMap a(XmlPullParser parser, wj base64EncodingHeaderParameters) throws XmlPullParserException, IOException {
        Intrinsics.checkNotNullParameter(parser, "parser");
        Intrinsics.checkNotNullParameter(base64EncodingHeaderParameters, "base64EncodingHeaderParameters");
        this.f8970a.getClass();
        Intrinsics.checkNotNullParameter(parser, "parser");
        parser.require(2, null, "TrackingEvents");
        HashMap map = new HashMap();
        while (true) {
            this.f8970a.getClass();
            if (!wk2.a(parser)) {
                return map;
            }
            this.f8970a.getClass();
            if (wk2.b(parser)) {
                if (Intrinsics.areEqual("Tracking", parser.getName())) {
                    e62 e62VarA = this.b.a(parser, base64EncodingHeaderParameters);
                    if (e62VarA != null) {
                        String strA = e62VarA.a();
                        String strC = e62VarA.c();
                        if (!map.containsKey(strA)) {
                            map.put(strA, new ArrayList());
                        }
                        List list = (List) map.get(strA);
                        if (list != null) {
                            list.add(strC);
                        }
                    }
                } else {
                    this.f8970a.getClass();
                    wk2.d(parser);
                }
            }
        }
    }

    public /* synthetic */ g62() {
        this(new wk2(), new f62());
    }

    public g62(wk2 xmlHelper, f62 trackingEventParser) {
        Intrinsics.checkNotNullParameter(xmlHelper, "xmlHelper");
        Intrinsics.checkNotNullParameter(trackingEventParser, "trackingEventParser");
        this.f8970a = xmlHelper;
        this.b = trackingEventParser;
    }
}
