package com.yandex.mobile.ads.impl;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes9.dex */
public final class f62 implements vk2<e62> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final wk2 f8870a;
    private final w42 b;

    @Override // com.yandex.mobile.ads.impl.vk2
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final e62 a(XmlPullParser parser, wj base64EncodingParameters) throws XmlPullParserException, IOException {
        Intrinsics.checkNotNullParameter(parser, "parser");
        Intrinsics.checkNotNullParameter(base64EncodingParameters, "base64EncodingParameters");
        this.f8870a.getClass();
        Intrinsics.checkNotNullParameter(parser, "parser");
        parser.require(2, null, "Tracking");
        String attributeValue = parser.getAttributeValue(null, "event");
        String attributeValue2 = parser.getAttributeValue(null, "offset");
        this.f8870a.getClass();
        String strC = wk2.c(parser);
        if (attributeValue == null || attributeValue.length() == 0 || strC.length() <= 0) {
            return null;
        }
        fa2 fa2VarA = attributeValue2 != null ? this.b.a(attributeValue2) : null;
        Intrinsics.checkNotNull(attributeValue);
        return new e62(attributeValue, strC, fa2VarA);
    }

    public /* synthetic */ f62() {
        wk2 wk2Var = new wk2();
        u42[] u42VarArrValues = u42.values();
        this(wk2Var, new w42(new HashSet(CollectionsKt.listOf(Arrays.copyOf(u42VarArrValues, u42VarArrValues.length)))));
    }

    public f62(wk2 xmlHelper, w42 timeOffsetParser) {
        Intrinsics.checkNotNullParameter(xmlHelper, "xmlHelper");
        Intrinsics.checkNotNullParameter(timeOffsetParser, "timeOffsetParser");
        this.f8870a = xmlHelper;
        this.b = timeOffsetParser;
    }
}
