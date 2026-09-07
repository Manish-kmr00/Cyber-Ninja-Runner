package com.yandex.mobile.ads.impl;

import java.io.IOException;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes5.dex */
public final class sa2 implements vk2<oa2> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final wk2 f10191a;
    private final lq0 b;
    private final ra2 c;
    private final g62 d;

    public /* synthetic */ sa2() {
        this(new wk2(), new lq0(), new ra2(), new g62());
    }

    @Override // com.yandex.mobile.ads.impl.vk2
    public final oa2 a(XmlPullParser parser, wj base64EncodingParameters) throws XmlPullParserException, IOException {
        Intrinsics.checkNotNullParameter(parser, "parser");
        Intrinsics.checkNotNullParameter(base64EncodingParameters, "base64EncodingParameters");
        this.f10191a.getClass();
        Intrinsics.checkNotNullParameter(parser, "parser");
        parser.require(2, null, "Verification");
        xu.a(this.f10191a, parser, "parser", "vendor", "attributeName");
        String attributeValue = parser.getAttributeValue(null, "vendor");
        HashMap map = new HashMap();
        kq0 kq0VarA = null;
        String strA = null;
        while (true) {
            this.f10191a.getClass();
            if (!wk2.a(parser)) {
                break;
            }
            this.f10191a.getClass();
            if (wk2.b(parser)) {
                String name = parser.getName();
                if (Intrinsics.areEqual("JavaScriptResource", name)) {
                    kq0VarA = this.b.a(parser);
                } else if (Intrinsics.areEqual("VerificationParameters", name)) {
                    strA = this.c.a(parser);
                } else if (Intrinsics.areEqual("TrackingEvents", name)) {
                    map = this.d.a(parser, base64EncodingParameters);
                } else {
                    this.f10191a.getClass();
                    wk2.d(parser);
                }
            }
        }
        if (attributeValue == null || attributeValue.length() == 0) {
            return null;
        }
        return new oa2(attributeValue, kq0VarA, strA, map);
    }

    public sa2(wk2 xmlHelper, lq0 javaScriptResourceParser, ra2 verificationParametersParser, g62 trackingEventsParser) {
        Intrinsics.checkNotNullParameter(xmlHelper, "xmlHelper");
        Intrinsics.checkNotNullParameter(javaScriptResourceParser, "javaScriptResourceParser");
        Intrinsics.checkNotNullParameter(verificationParametersParser, "verificationParametersParser");
        Intrinsics.checkNotNullParameter(trackingEventsParser, "trackingEventsParser");
        this.f10191a = xmlHelper;
        this.b = javaScriptResourceParser;
        this.c = verificationParametersParser;
        this.d = trackingEventsParser;
    }
}
