package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.util.Xml;
import java.io.IOException;
import java.io.StringReader;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes12.dex */
public final class ma2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final wk2 f9618a;
    private final q92 b;

    public final m92 a(String data, wj base64EncodingParameters) throws XmlPullParserException, JSONException, IOException {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(base64EncodingParameters, "base64EncodingParameters");
        XmlPullParser parser = Xml.newPullParser();
        parser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", false);
        parser.setInput(new StringReader(data));
        Intrinsics.checkNotNull(parser);
        parser.nextTag();
        this.f9618a.getClass();
        Intrinsics.checkNotNullParameter(parser, "parser");
        parser.require(2, null, "VAST");
        return this.b.a(parser, base64EncodingParameters);
    }

    public /* synthetic */ ma2(Context context, lp1 lp1Var) {
        this(context, lp1Var, new wk2(), new q92(context, lp1Var));
    }

    public ma2(Context context, lp1 reporter, wk2 xmlHelper, q92 vastAdsParser) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(xmlHelper, "xmlHelper");
        Intrinsics.checkNotNullParameter(vastAdsParser, "vastAdsParser");
        this.f9618a = xmlHelper;
        this.b = vastAdsParser;
    }
}
