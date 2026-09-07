package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes10.dex */
public final class ec2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final wk2 f8785a;
    private final vk0 b;
    private final pk2 c;
    private final ex1 d;
    private final a32 e;
    private final Context f;

    public final eb2 a(XmlPullParser parser, wj base64EncodingParameters) throws XmlPullParserException, JSONException, IOException {
        Intrinsics.checkNotNullParameter(parser, "parser");
        Intrinsics.checkNotNullParameter(base64EncodingParameters, "base64EncodingParameters");
        String strA = this.e.a(parser);
        Integer numA = this.d.a(parser);
        this.f8785a.getClass();
        Intrinsics.checkNotNullParameter(parser, "parser");
        eb2 eb2VarA = null;
        parser.require(2, null, "Ad");
        while (true) {
            this.f8785a.getClass();
            if (!wk2.a(parser)) {
                return eb2VarA;
            }
            this.f8785a.getClass();
            if (wk2.b(parser)) {
                String name = parser.getName();
                if (Intrinsics.areEqual("InLine", name)) {
                    eb2.a aVar = new eb2.a(this.f, false);
                    aVar.f(strA);
                    aVar.a(numA);
                    eb2VarA = this.b.a(parser, aVar, base64EncodingParameters);
                } else if (Intrinsics.areEqual("Wrapper", name)) {
                    eb2.a aVar2 = new eb2.a(this.f, true);
                    aVar2.f(strA);
                    aVar2.a(numA);
                    eb2VarA = this.c.a(parser, aVar2, base64EncodingParameters);
                } else {
                    this.f8785a.getClass();
                    wk2.d(parser);
                }
            }
        }
    }

    public /* synthetic */ ec2(Context context, lp1 lp1Var) {
        this(context, lp1Var, new wk2(), new vk0(new jb2(context, lp1Var)), new pk2(context, lp1Var), new ex1(), new a32());
    }

    public ec2(Context context, lp1 reporter, wk2 xmlHelper, vk0 inlineParser, pk2 wrapperParser, ex1 sequenceParser, a32 idXmlAttributeParser) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(xmlHelper, "xmlHelper");
        Intrinsics.checkNotNullParameter(inlineParser, "inlineParser");
        Intrinsics.checkNotNullParameter(wrapperParser, "wrapperParser");
        Intrinsics.checkNotNullParameter(sequenceParser, "sequenceParser");
        Intrinsics.checkNotNullParameter(idXmlAttributeParser, "idXmlAttributeParser");
        this.f8785a = xmlHelper;
        this.b = inlineParser;
        this.c = wrapperParser;
        this.d = sequenceParser;
        this.e = idXmlAttributeParser;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this.f = applicationContext;
    }
}
