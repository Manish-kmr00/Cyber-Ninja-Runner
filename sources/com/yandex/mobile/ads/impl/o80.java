package com.yandex.mobile.ads.impl;

import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes9.dex */
public final class o80 implements vk2<j80> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final wk2 f9791a;

    public o80(wk2 xmlHelper) {
        Intrinsics.checkNotNullParameter(xmlHelper, "xmlHelper");
        this.f9791a = xmlHelper;
    }

    @Override // com.yandex.mobile.ads.impl.vk2
    public final j80 a(XmlPullParser parser, wj base64EncodingParameters) throws XmlPullParserException, IOException {
        Intrinsics.checkNotNullParameter(parser, "parser");
        Intrinsics.checkNotNullParameter(base64EncodingParameters, "base64EncodingParameters");
        this.f9791a.getClass();
        Intrinsics.checkNotNullParameter(parser, "parser");
        parser.require(2, null, "FalseClick");
        xu.a(this.f9791a, parser, "parser", "interval", "attributeName");
        String attributeValue = parser.getAttributeValue(null, "interval");
        Long longOrNull = attributeValue != null ? StringsKt.toLongOrNull(attributeValue) : null;
        this.f9791a.getClass();
        String strC = wk2.c(parser);
        if (strC.length() <= 0 || longOrNull == null) {
            return null;
        }
        return new j80(strC, longOrNull.longValue());
    }
}
