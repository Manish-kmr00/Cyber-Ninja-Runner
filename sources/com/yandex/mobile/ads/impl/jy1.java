package com.yandex.mobile.ads.impl;

import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes7.dex */
public final class jy1 implements vk2<r70> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final wk2 f9364a;

    public jy1(wk2 xmlHelper) {
        Intrinsics.checkNotNullParameter(xmlHelper, "xmlHelper");
        this.f9364a = xmlHelper;
    }

    @Override // com.yandex.mobile.ads.impl.vk2
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final r70 a(XmlPullParser parser, wj base64EncodingParameters) throws XmlPullParserException, IOException {
        Intrinsics.checkNotNullParameter(parser, "parser");
        Intrinsics.checkNotNullParameter(base64EncodingParameters, "base64EncodingParameters");
        this.f9364a.getClass();
        Intrinsics.checkNotNullParameter(parser, "parser");
        parser.require(2, null, "Extension");
        String type = parser.getAttributeValue(null, "type");
        this.f9364a.getClass();
        String value = wk2.c(parser);
        if (type == null || type.length() == 0 || value.length() <= 0) {
            return null;
        }
        Intrinsics.checkNotNull(type);
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(value, "value");
        return new r70(type, value);
    }
}
