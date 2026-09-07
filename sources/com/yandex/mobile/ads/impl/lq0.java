package com.yandex.mobile.ads.impl;

import com.smaato.sdk.video.vast.model.JavaScriptResource;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes12.dex */
public final class lq0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final wk2 f9558a;

    public final kq0 a(XmlPullParser parser) throws XmlPullParserException, IOException {
        Intrinsics.checkNotNullParameter(parser, "parser");
        this.f9558a.getClass();
        Intrinsics.checkNotNullParameter(parser, "parser");
        parser.require(2, null, "JavaScriptResource");
        xu.a(this.f9558a, parser, "parser", "apiFramework", "attributeName");
        String attributeValue = parser.getAttributeValue(null, "apiFramework");
        xu.a(this.f9558a, parser, "parser", JavaScriptResource.BROWSER_OPTIONAL, "attributeName");
        String attributeValue2 = parser.getAttributeValue(null, JavaScriptResource.BROWSER_OPTIONAL);
        Boolean boolValueOf = attributeValue2 != null ? Boolean.valueOf(Boolean.parseBoolean(attributeValue2)) : null;
        this.f9558a.getClass();
        String strC = wk2.c(parser);
        if (attributeValue == null || attributeValue.length() == 0 || boolValueOf == null || strC.length() <= 0) {
            return null;
        }
        return new kq0(attributeValue, strC, boolValueOf.booleanValue());
    }

    public /* synthetic */ lq0() {
        this(new wk2());
    }

    public lq0(wk2 xmlHelper) {
        Intrinsics.checkNotNullParameter(xmlHelper, "xmlHelper");
        this.f9558a = xmlHelper;
    }
}
