package com.yandex.mobile.ads.impl;

import java.io.IOException;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes14.dex */
public final class v70 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final wk2 f10455a;
    private final jy1 b;

    public final ArrayList a(XmlPullParser parser, vj base64EncodingParameters) throws XmlPullParserException, IOException {
        Intrinsics.checkNotNullParameter(parser, "parser");
        Intrinsics.checkNotNullParameter(base64EncodingParameters, "base64EncodingParameters");
        this.f10455a.getClass();
        Intrinsics.checkNotNullParameter(parser, "parser");
        parser.require(2, null, "Extensions");
        ArrayList arrayList = new ArrayList();
        while (true) {
            this.f10455a.getClass();
            if (!wk2.a(parser)) {
                return arrayList;
            }
            this.f10455a.getClass();
            if (wk2.b(parser)) {
                if (Intrinsics.areEqual("Extension", parser.getName())) {
                    r70 r70VarA = this.b.a(parser, base64EncodingParameters);
                    if (r70VarA != null) {
                        arrayList.add(r70VarA);
                    }
                } else {
                    this.f10455a.getClass();
                    wk2.d(parser);
                }
            }
        }
    }

    public /* synthetic */ v70(wk2 wk2Var) {
        this(wk2Var, new jy1(wk2Var));
    }

    public v70(wk2 xmlHelper, jy1 simpleExtensionParser) {
        Intrinsics.checkNotNullParameter(xmlHelper, "xmlHelper");
        Intrinsics.checkNotNullParameter(simpleExtensionParser, "simpleExtensionParser");
        this.f10455a = xmlHelper;
        this.b = simpleExtensionParser;
    }
}
