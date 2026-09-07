package com.yandex.mobile.ads.impl;

import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes12.dex */
public final class a32 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final wk2 f8361a;

    public a32() {
        Intrinsics.checkNotNullParameter("id", "attribute");
        Intrinsics.checkNotNullParameter("Ad", "parentTag");
        this.f8361a = new wk2();
    }

    public final String a(XmlPullParser parser) throws XmlPullParserException, IOException {
        Intrinsics.checkNotNullParameter(parser, "parser");
        this.f8361a.getClass();
        Intrinsics.checkNotNullParameter(parser, "parser");
        parser.require(2, null, "Ad");
        String attributeValue = parser.getAttributeValue(null, "id");
        if (attributeValue == null || attributeValue.length() == 0) {
            return null;
        }
        return attributeValue;
    }
}
