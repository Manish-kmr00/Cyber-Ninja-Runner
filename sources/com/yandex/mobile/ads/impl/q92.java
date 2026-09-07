package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.io.IOException;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes13.dex */
public final class q92 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final wk2 f10001a;
    private final ec2 b;

    public final m92 a(XmlPullParser parser, wj base64EncodingParameters) throws XmlPullParserException, JSONException, IOException {
        Intrinsics.checkNotNullParameter(parser, "parser");
        Intrinsics.checkNotNullParameter(base64EncodingParameters, "base64EncodingParameters");
        xu.a(this.f10001a, parser, "parser", "version", "attributeName");
        String attributeValue = parser.getAttributeValue(null, "version");
        ArrayList arrayList = new ArrayList();
        while (true) {
            this.f10001a.getClass();
            if (!wk2.a(parser)) {
                break;
            }
            this.f10001a.getClass();
            if (wk2.b(parser)) {
                if (Intrinsics.areEqual("Ad", parser.getName())) {
                    eb2 eb2VarA = this.b.a(parser, base64EncodingParameters);
                    if (eb2VarA != null) {
                        arrayList.add(eb2VarA);
                    }
                } else {
                    this.f10001a.getClass();
                    wk2.d(parser);
                }
            }
        }
        if (attributeValue == null || attributeValue.length() == 0) {
            return null;
        }
        return new m92(attributeValue, arrayList);
    }

    public /* synthetic */ q92(Context context, lp1 lp1Var) {
        this(context, lp1Var, new wk2(), new ec2(context, lp1Var));
    }

    public q92(Context context, lp1 reporter, wk2 xmlHelper, ec2 videoAdParser) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(xmlHelper, "xmlHelper");
        Intrinsics.checkNotNullParameter(videoAdParser, "videoAdParser");
        this.f10001a = xmlHelper;
        this.b = videoAdParser;
    }
}
