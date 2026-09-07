package com.yandex.mobile.ads.impl;

import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public final class l9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final wk2 f9491a;
    private final u9 b;

    public final k9 a(XmlPullParser parser) throws XmlPullParserException, IOException {
        Intrinsics.checkNotNullParameter(parser, "parser");
        this.f9491a.getClass();
        Intrinsics.checkNotNullParameter(parser, "parser");
        k9 k9Var = null;
        parser.require(2, null, "AdSource");
        xu.a(this.f9491a, parser, "parser", "allowMultipleAds", "attributeName");
        String attributeValue = parser.getAttributeValue(null, "allowMultipleAds");
        if (attributeValue != null) {
            Boolean.parseBoolean(attributeValue);
        }
        xu.a(this.f9491a, parser, "parser", "followRedirects", "attributeName");
        String attributeValue2 = parser.getAttributeValue(null, "followRedirects");
        if (attributeValue2 != null) {
            Boolean.parseBoolean(attributeValue2);
        }
        String attributeValue3 = parser.getAttributeValue(null, "id");
        while (true) {
            this.f9491a.getClass();
            if (!wk2.a(parser)) {
                return k9Var;
            }
            this.f9491a.getClass();
            if (wk2.b(parser)) {
                if (Intrinsics.areEqual("AdTagURI", parser.getName())) {
                    t9 adTagUri = this.b.a(parser);
                    if (adTagUri != null) {
                        Intrinsics.checkNotNullParameter(adTagUri, "adTagUri");
                        k9Var = new k9(adTagUri, attributeValue3);
                    }
                } else {
                    this.f9491a.getClass();
                    wk2.d(parser);
                }
            }
        }
    }

    public /* synthetic */ l9(wk2 wk2Var) {
        this(wk2Var, new u9(wk2Var));
    }

    public l9(wk2 xmlHelper, u9 adTagUriParser) {
        Intrinsics.checkNotNullParameter(xmlHelper, "xmlHelper");
        Intrinsics.checkNotNullParameter(adTagUriParser, "adTagUriParser");
        this.f9491a = xmlHelper;
        this.b = adTagUriParser;
    }
}
