package com.yandex.mobile.ads.impl;

import java.io.IOException;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes3.dex */
public final class ae2 implements vk2<zd2> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final wk2 f8399a;

    @Override // com.yandex.mobile.ads.impl.vk2
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final zd2 a(XmlPullParser parser, wj base64EncodingParameters) throws XmlPullParserException, IOException {
        Intrinsics.checkNotNullParameter(parser, "parser");
        Intrinsics.checkNotNullParameter(base64EncodingParameters, "base64EncodingParameters");
        this.f8399a.getClass();
        Intrinsics.checkNotNullParameter(parser, "parser");
        String str = null;
        parser.require(2, null, "VideoClicks");
        ArrayList arrayList = new ArrayList();
        while (true) {
            this.f8399a.getClass();
            if (!wk2.a(parser)) {
                return new zd2(str, arrayList);
            }
            this.f8399a.getClass();
            if (wk2.b(parser)) {
                String name = parser.getName();
                if (Intrinsics.areEqual("ClickThrough", name)) {
                    this.f8399a.getClass();
                    String strC = wk2.c(parser);
                    if (strC.length() > 0) {
                        str = strC;
                    }
                } else if (Intrinsics.areEqual("ClickTracking", name)) {
                    this.f8399a.getClass();
                    String strC2 = wk2.c(parser);
                    if (strC2.length() > 0) {
                        arrayList.add(strC2);
                    }
                } else {
                    this.f8399a.getClass();
                    wk2.d(parser);
                }
            }
        }
    }

    public /* synthetic */ ae2() {
        this(new wk2());
    }

    public ae2(wk2 xmlHelper) {
        Intrinsics.checkNotNullParameter(xmlHelper, "xmlHelper");
        this.f8399a = xmlHelper;
    }
}
