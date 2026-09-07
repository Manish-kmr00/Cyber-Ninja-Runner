package com.yandex.mobile.ads.impl;

import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes4.dex */
public final class u9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final wk2 f10365a;

    public u9(wk2 xmlHelper) {
        Intrinsics.checkNotNullParameter(xmlHelper, "xmlHelper");
        this.f10365a = xmlHelper;
    }

    public final t9 a(XmlPullParser parser) throws XmlPullParserException, IOException {
        Intrinsics.checkNotNullParameter(parser, "parser");
        this.f10365a.getClass();
        Intrinsics.checkNotNullParameter(parser, "parser");
        parser.require(2, null, "AdTagURI");
        parser.getAttributeValue(null, "templateType");
        this.f10365a.getClass();
        String uri = wk2.c(parser);
        if (uri.length() <= 0) {
            return null;
        }
        Intrinsics.checkNotNullParameter(uri, "uri");
        return new t9(uri);
    }
}
