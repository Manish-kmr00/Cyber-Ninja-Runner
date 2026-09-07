package com.yandex.mobile.ads.impl;

import com.smaato.sdk.video.vast.model.Icon;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes13.dex */
public final class ki0 implements vk2<ji0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final wk2 f9422a;

    public /* synthetic */ ki0() {
        this(new wk2());
    }

    @Override // com.yandex.mobile.ads.impl.vk2
    public final ji0 a(XmlPullParser parser, wj base64EncodingParameters) throws XmlPullParserException, IOException {
        Intrinsics.checkNotNullParameter(parser, "parser");
        Intrinsics.checkNotNullParameter(base64EncodingParameters, "base64EncodingParameters");
        this.f9422a.getClass();
        Intrinsics.checkNotNullParameter(parser, "parser");
        parser.require(2, null, "Icon");
        ji0.a aVar = new ji0.a();
        xu.a(this.f9422a, parser, "parser", Icon.PROGRAM, "attributeName");
        String attributeValue = parser.getAttributeValue(null, Icon.PROGRAM);
        xu.a(this.f9422a, parser, "parser", "height", "attributeName");
        String attributeValue2 = parser.getAttributeValue(null, "height");
        xu.a(this.f9422a, parser, "parser", "width", "attributeName");
        String attributeValue3 = parser.getAttributeValue(null, "width");
        xu.a(this.f9422a, parser, "parser", Icon.X_POSITION, "attributeName");
        String attributeValue4 = parser.getAttributeValue(null, Icon.X_POSITION);
        xu.a(this.f9422a, parser, "parser", Icon.Y_POSITION, "attributeName");
        String attributeValue5 = parser.getAttributeValue(null, Icon.Y_POSITION);
        xu.a(this.f9422a, parser, "parser", "apiFramework", "attributeName");
        String attributeValue6 = parser.getAttributeValue(null, "apiFramework");
        xu.a(this.f9422a, parser, "parser", "offset", "attributeName");
        String attributeValue7 = parser.getAttributeValue(null, "offset");
        xu.a(this.f9422a, parser, "parser", "duration", "attributeName");
        String attributeValue8 = parser.getAttributeValue(null, "duration");
        while (true) {
            this.f9422a.getClass();
            if (!wk2.a(parser)) {
                return aVar.f(attributeValue).c(attributeValue2).j(attributeValue3).d(attributeValue4).i(attributeValue5).a(attributeValue6).e(attributeValue7).b(attributeValue8).a();
            }
            this.f9422a.getClass();
            if (wk2.b(parser)) {
                String name = parser.getName();
                ji0.c.c.getClass();
                ji0.c[] cVarArrValues = ji0.c.values();
                int length = cVarArrValues.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        this.f9422a.getClass();
                        wk2.d(parser);
                        break;
                    }
                    if (Intrinsics.areEqual(cVarArrValues[i].a(), name)) {
                        this.f9422a.getClass();
                        aVar.g(name).h(wk2.c(parser));
                        break;
                    }
                    i++;
                }
            }
        }
    }

    public ki0(wk2 xmlHelper) {
        Intrinsics.checkNotNullParameter(xmlHelper, "xmlHelper");
        this.f9422a = xmlHelper;
    }
}
