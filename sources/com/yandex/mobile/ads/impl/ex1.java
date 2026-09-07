package com.yandex.mobile.ads.impl;

import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes5.dex */
public final class ex1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final wk2 f8840a;

    public final Integer a(XmlPullParser parser) throws XmlPullParserException, IOException {
        Intrinsics.checkNotNullParameter(parser, "parser");
        this.f8840a.getClass();
        Intrinsics.checkNotNullParameter(parser, "parser");
        parser.require(2, null, "Ad");
        Integer numB = ud2.b(parser.getAttributeValue(null, "sequence"));
        if (numB == null || numB.intValue() >= 0) {
            return numB;
        }
        return null;
    }

    public /* synthetic */ ex1() {
        this(new wk2());
    }

    public ex1(wk2 xmlHelper) {
        Intrinsics.checkNotNullParameter(xmlHelper, "xmlHelper");
        this.f8840a = xmlHelper;
    }
}
