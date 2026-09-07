package com.yandex.mobile.ads.impl;

import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes4.dex */
public final class tu<T> implements vk2<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final vk2<T> f10332a;
    private final wk2 b;

    public tu(o80 xmlElementParser, wk2 xmlHelper) {
        Intrinsics.checkNotNullParameter(xmlElementParser, "xmlElementParser");
        Intrinsics.checkNotNullParameter(xmlHelper, "xmlHelper");
        this.f10332a = xmlElementParser;
        this.b = xmlHelper;
    }

    @Override // com.yandex.mobile.ads.impl.vk2
    public final T a(XmlPullParser parser, wj base64EncodingParameters) throws XmlPullParserException, JSONException, IOException {
        Intrinsics.checkNotNullParameter(parser, "parser");
        Intrinsics.checkNotNullParameter(base64EncodingParameters, "base64EncodingParameters");
        this.b.getClass();
        Intrinsics.checkNotNullParameter(parser, "parser");
        T tA = null;
        parser.require(2, null, "CreativeExtension");
        while (true) {
            this.b.getClass();
            if (!wk2.a(parser)) {
                return tA;
            }
            this.b.getClass();
            if (wk2.b(parser)) {
                tA = this.f10332a.a(parser, base64EncodingParameters);
            }
        }
    }
}
