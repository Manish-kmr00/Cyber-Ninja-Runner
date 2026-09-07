package com.yandex.mobile.ads.impl;

import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes12.dex */
public final class cw0 implements vk2<aw0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final wk2 f8646a;

    public /* synthetic */ cw0() {
        this(new wk2());
    }

    @Override // com.yandex.mobile.ads.impl.vk2
    public final aw0 a(XmlPullParser parser, wj base64EncodingParameters) throws XmlPullParserException, IOException {
        Intrinsics.checkNotNullParameter(parser, "parser");
        Intrinsics.checkNotNullParameter(base64EncodingParameters, "base64EncodingParameters");
        this.f8646a.getClass();
        Intrinsics.checkNotNullParameter(parser, "parser");
        parser.require(2, null, "MediaFile");
        xu.a(this.f8646a, parser, "parser", "delivery", "attributeName");
        String attributeValue = parser.getAttributeValue(null, "delivery");
        xu.a(this.f8646a, parser, "parser", "type", "attributeName");
        String attributeValue2 = parser.getAttributeValue(null, "type");
        xu.a(this.f8646a, parser, "parser", "height", "attributeName");
        String attributeValue3 = parser.getAttributeValue(null, "height");
        xu.a(this.f8646a, parser, "parser", "width", "attributeName");
        String attributeValue4 = parser.getAttributeValue(null, "width");
        xu.a(this.f8646a, parser, "parser", "bitrate", "attributeName");
        String attributeValue5 = parser.getAttributeValue(null, "bitrate");
        xu.a(this.f8646a, parser, "parser", "apiFramework", "attributeName");
        String attributeValue6 = parser.getAttributeValue(null, "apiFramework");
        xu.a(this.f8646a, parser, "parser", "id", "attributeName");
        String attributeValue7 = parser.getAttributeValue(null, "id");
        xu.a(this.f8646a, parser, "parser", "codec", "attributeName");
        String attributeValue8 = parser.getAttributeValue(null, "codec");
        xu.a(this.f8646a, parser, "parser", "vmaf", "attributeName");
        String attributeValue9 = parser.getAttributeValue(null, "vmaf");
        this.f8646a.getClass();
        return new aw0.a(wk2.c(parser)).f(attributeValue7).d(attributeValue).e(attributeValue3).i(attributeValue4).b(attributeValue5).a(attributeValue6).g(attributeValue2).c(attributeValue8).h(attributeValue9).a();
    }

    public cw0(wk2 xmlHelper) {
        Intrinsics.checkNotNullParameter(xmlHelper, "xmlHelper");
        this.f8646a = xmlHelper;
    }
}
